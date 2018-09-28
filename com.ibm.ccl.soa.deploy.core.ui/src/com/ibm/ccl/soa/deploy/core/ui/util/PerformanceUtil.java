/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author jswanke
 * 
 */

// To time usage taken by each step of a sequence of steps: 
//			PerformanceUtil.activate(true); // programmatically turn on metrics
//			PerformanceUtil.startSeq("sample: loading model");
//				load model -- can be in same method or in different methods
// 		PerformanceUtil.startSeq("sample: display model-- put at end of loading model"); 
//			PerformanceUtil.comment("a comment that doesn't affect performance testing"); 
//			// stop measuring performance
//			PerformanceUtil.stopSeq(); 
//			// turn performance testing on/off only when some condition is met (off by default)
//			PerformanceUtil.activate(condition);
// 		// dump log -- usually called in plugin stop method
// 		// --overwrites the last log
// 		PerformanceUtil.dump("C:\\performance.log");
//
//			// to measure the time taken by individual loops of an iteration:
//			do loop {
//					PerformanceUtil.startLap("what loop is doing", 0, "location of loop (class.method)", reportOnLoops);
//                 reportOnLoops -- use true to get a report on each lap of loop
//					PerformanceUtil.startLapSeq("describe this step of this iteration of the loop");
//						:	:	:
//					// can also be called from within a method called during this iteration 
//					PerformanceUtil.startLapSeq("describe this step of this iteration of the loop");
//						:	:	:
//					PerformanceUtil.stopLapSeq();// does stop lap and stop sequence
//			} 
//
//
//
//
//
public class PerformanceUtil {
	/////////////// ACTIVATE /////////////////////////////////
	// turn on performance logging
	static boolean isOn = false;
	//////////////////////////////////////////////////////////

	static String lastDescription = "start"; //$NON-NLS-1$
	static HashMap seqTimeMap = new HashMap();

	static boolean isTimerOn = false;
	static boolean isLapTiming = false;
	static boolean isLapSeqTiming = false;
	static long lastTime = 0;
	static long lastLapTime = 0;
	static long lastLapSeqTime = 0;
	static long backgroundTime = 0;
	static long lastLapTotalMemory = 0;

	static int lapNumber = 0;
	static int lapNumOverSquelch = 0;
	static long lapTimeOverSquelch = 0;
	static String lastLoopDescription = "lastclass"; //$NON-NLS-1$
	static long lastLapSquelch = 0;
	static String lastLoopLocation = "none"; //$NON-NLS-1$
	static HashMap lapClassMap = new HashMap();
	static HashMap totalLapClassMap = new HashMap();
	static boolean lastReportLoops = false;

	static String lastLapSeqDescription = "none"; //$NON-NLS-1$
	static HashMap totalLapSeqClassMap = new HashMap();

	static ArrayList perfLog = new ArrayList();
	static ArrayList lapLog = new ArrayList();
	static ArrayList lapSeqLog = new ArrayList();
	static ArrayList errorLog = new ArrayList();
	static boolean lapSeqTimedError = false;

	private class PerformanceData {
		public long totalTime = 0;
		public long totalMemory = 0;
		public int totalCalls = 0;
		public long maxTime = 0;
		public long maxMemory = 0;
		public int maxLoopNum = 0;
		public int maxTotalCall = 0;
		public int maxMLoopNum = 0;
		public int maxMTotalCall = 0;
		HashMap lapSeqMap = null;
	}

//////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////// INITIALIZATION ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Used to turn timing on. Off by default.
	 */
	public static void activate(boolean on) {
		isOn = on;
		lastTime = System.currentTimeMillis();
	}

//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// SNAPSHOTS ///////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Used to time a single event. -- insert before openning an editor, saving a file, etc. --
	 * insert stopSeq() at end of the same function so that the background processing between
	 * functions can also be measured
	 */
	static public void startSeq(String description) {
		if (!isOn) {
			return;
		}
		// if another timer hasn't been stopped, stop other timer and start this one
		if (isTimerOn) {
			stopSeq();
		} else {
			stopBackground();
		}
		// turn on timer
		lastDescription = description;
		isTimerOn = true;
		lastTime = System.currentTimeMillis();
	}

	/**
	 * Used to time a looping event. -- insert in a loop that's processing all the widgets in a
	 * display, etc. -- no need to call stopLap(), next startLap() calls it automatically class --
	 * the instance of the class executing this loop's method or some representative class msSquelch --
	 * so that minor loops aren't measured, will not measure loops less then "msSquelch" in duration:
	 * use 0 for all loops or 1 for all loops above zero ms
	 */
	static public void startLap(Object obj, int msSquelch, String loopLocation, boolean reportLoops) {
		if (!isOn) {
			return;
		}
		String classDesc = "null"; //$NON-NLS-1$
		if (obj != null) {
			String classname = obj.getClass().getName();
			classDesc = classname.substring(classname.lastIndexOf(".") + 1); //$NON-NLS-1$
		}
		startLap(classDesc, msSquelch, loopLocation, reportLoops);
	}

	static public void startLap(String loopDescription, int msSquelch, String loopLocation,
			boolean reportLoops) {
		if (!isOn) {
			return;
		}
		if (isLapTiming) {
			stopLap();
		}

		// setup for next loop
		isLapTiming = true;
		lastLapTime = System.currentTimeMillis();
		lastLapTotalMemory = Runtime.getRuntime().totalMemory();
		lapNumber++;
		lastLoopDescription = loopDescription;
		lastLapSquelch = msSquelch;
		lastLoopLocation = loopLocation;
		lastReportLoops = reportLoops;
	}

	/**
	 * Can be used to trigger other events for particular lap numbers.
	 */
	static public int getLapNumber() {
		return lapNumber;
	}

	/**
	 * Used to time a sequential event within a loop cycle. -- call stopLapSeq() at the end of a
	 * function else time measured will be now till end of loop -- can only be called once per loop
	 * msSquelch -- so that all loops aren't measured, will not measure this sequence unless the loop
	 * is longer then this value in milliseconds
	 */
	static public void startLapSeq(String description) {
		if (!isOn) {
			return;
		}
		// if another timer hasn't been stopped, stop other timer and start this one
		if (isLapSeqTiming) {
			stopLapSeq();
		}
		// turn on timer
		isLapSeqTiming = true;
		lastLapSeqDescription = description;
		lastLapSeqTime = System.currentTimeMillis();
	}

//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////// LOGGING RESULTS ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Stop the current lap sequence measurement.
	 */
	static public void stopLapSeq() {
		if (!isOn) {
			return;
		}
		if (!isLapSeqTiming) {
			return;
		}
		isLapSeqTiming = false;
		long lapSeqTime = System.currentTimeMillis() - lastLapSeqTime;
		if (lapSeqTime > 0) {
			lapSeqLog.add("               |--" + lapSeqTime + "  " + lastLapSeqDescription); //$NON-NLS-1$ //$NON-NLS-2$

			// save result in totalLapMap under the current lap description
			String totDesc = lastLoopLocation + "/" + lastLoopDescription; //$NON-NLS-1$
			PerformanceUtil.PerformanceData data = (PerformanceData) totalLapClassMap.get(totDesc);
			if (data == null) {
				PerformanceUtil probe = new PerformanceUtil();
				data = probe.new PerformanceData();
				totalLapClassMap.put(totDesc, data);
			}
			if (data.lapSeqMap == null) {
				data.lapSeqMap = new HashMap();
			}
			PerformanceUtil.PerformanceData lsdata = (PerformanceData) data.lapSeqMap
					.get(lastLapSeqDescription);
			if (lsdata == null) {
				PerformanceUtil probe = new PerformanceUtil();
				lsdata = probe.new PerformanceData();
				data.lapSeqMap.put(lastLapSeqDescription, lsdata);
			}
			if (lapSeqTime > lsdata.maxTime) {
				lsdata.maxTime = lapSeqTime;
				lsdata.maxLoopNum = lapNumber;
			}
			lsdata.totalCalls++;
			lsdata.totalTime += lapSeqTime;

			// also save result in a totLapSeqMap under current lap seq description
			data = (PerformanceData) totalLapSeqClassMap.get(lastLapSeqDescription);
			if (data == null) {
				PerformanceUtil probe = new PerformanceUtil();
				data = probe.new PerformanceData();
				totalLapSeqClassMap.put(lastLapSeqDescription, data);
			}
			if (lapSeqTime > data.maxTime) {
				data.maxTime = lapSeqTime;
				data.maxLoopNum = lapNumber;
			}
			data.totalCalls++;
			data.totalTime += lapSeqTime;
		}
	}

	/**
	 * Stop the current lap measurement.
	 */
	static private void stopLap() {
		stopLapSeq();
		if (!isOn) {
			return;
		}
		if (!isLapTiming) {
			return;
		}

		// get current lap time
		long newTime = System.currentTimeMillis();
		long lapTime = newTime - lastLapTime;
		long newMemory = Runtime.getRuntime().totalMemory();
		long lapMemory = newMemory - lastLapTotalMemory;
		if (lapTime >= lastLapSquelch) {
			// log lap measurement
			if (lastReportLoops) {
				lapLog
						.add("          " + lapTime + "ms\t" + lapMemory + "bytes\t<lap #" + lapNumber + ">\t" + lastLoopDescription); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$
			}

			// add any lap seq log
			if (lapSeqLog.size() > 0) {
				//lapLog.addAll(lapSeqLog);
				lapSeqLog.clear();
			}

			// save for final report
			lapNumOverSquelch++;
			lapTimeOverSquelch += lapTime;

			// save per class data
			PerformanceUtil.PerformanceData data = (PerformanceData) lapClassMap
					.get(lastLoopDescription);
			if (data == null) {
				PerformanceUtil probe = new PerformanceUtil();
				data = probe.new PerformanceData();
				lapClassMap.put(lastLoopDescription, data);
			}
			if (lapTime > data.maxTime) {
				data.maxTime = lapTime;
				data.maxLoopNum = lapNumber;
				data.maxTotalCall = data.totalCalls;
			}
			if (lapMemory > data.maxMemory) {
				data.maxMemory = lapMemory;
				data.maxMLoopNum = lapNumber;
				data.maxMTotalCall = data.totalCalls;
			}
			data.totalCalls++;
			data.totalTime += lapTime;
			data.totalMemory += lapMemory;
			// save in total class data
			String totDesc = lastLoopLocation + "/" + lastLoopDescription; //$NON-NLS-1$
			data = (PerformanceData) totalLapClassMap.get(totDesc);
			if (data == null) {
				PerformanceUtil probe = new PerformanceUtil();
				data = probe.new PerformanceData();
				totalLapClassMap.put(totDesc, data);
			}
			if (lapTime > data.maxTime) {
				data.maxTime = lapTime;
				data.maxLoopNum = lapNumber;
				data.maxTotalCall = data.totalCalls;
			}
			if (lapMemory > data.maxMemory) {
				data.maxMemory = lapMemory;
				data.maxMLoopNum = lapNumber;
				data.maxMTotalCall = data.totalCalls;
			}
			data.totalCalls++;
			data.totalTime += lapTime;
			data.totalMemory += lapMemory;
		}
	}

	/**
	 * Stop all measurements.
	 */
	static public void stopSeq() {
		isLapTiming = false; //don't count last lap time --might be way off stopLap();
		if (!isOn) {
			return;
		}
		if (!isTimerOn) {
			return;
		}

		// log sequence measurement
		long seqTime = System.currentTimeMillis() - lastTime;
		perfLog.add(seqTime + "\t" + lastDescription); //$NON-NLS-1$

		// if id already called once, log accumulated time for that description
		PerformanceUtil.PerformanceData data = (PerformanceData) seqTimeMap.get(lastDescription);
		if (data == null) {
			PerformanceUtil probe = new PerformanceUtil();
			data = probe.new PerformanceData();
			seqTimeMap.put(lastDescription, data);
		}
		if (seqTime > data.maxTime) {
			data.maxTime = seqTime;
		}
		data.totalCalls++;
		data.totalTime += seqTime;

		// log any lap measurements
		if (lapClassMap.size() > 0) {
			perfLog.add(" "); //$NON-NLS-1$
			perfLog.add("          --------------------------------------------------------"); //$NON-NLS-1$
			perfLog.add("          processed loop in " + lastLoopLocation + ":"); //$NON-NLS-1$ //$NON-NLS-2$
			perfLog.add("          --------------------------------------------------------"); //$NON-NLS-1$
			if (lastReportLoops) {
				perfLog.addAll(lapLog);
				perfLog.add("          --------------------------------------------------------"); //$NON-NLS-1$
			}
			lapLog.clear();

			perfLog.add("          Calls\t\ttot(ms)\t\tmax(ms)\ttot(by)\t\tmax(by)\t\tclass"); //$NON-NLS-1$
			perfLog.add("          ------\t------\t\t------\t\t--------\t\t------\t\t--------"); //$NON-NLS-1$
			Iterator iter = lapClassMap.entrySet().iterator();
			for (int i = 0; i < lapClassMap.size(); i++) {
				Map.Entry entry = (Map.Entry) iter.next();
				String className = (String) entry.getKey();
				data = (PerformanceData) entry.getValue();
				perfLog.add("            " + data.totalCalls + "\t\t" + //$NON-NLS-1$//$NON-NLS-2$
						data.totalTime + "\t\t" + //$NON-NLS-1$
						data.maxTime + "(" + data.maxTotalCall + "/" + data.maxLoopNum + ")\t\t" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						data.totalMemory + "\t\t" + //$NON-NLS-1$
						data.maxMemory + "(" + data.maxMTotalCall + "/" + data.maxMLoopNum + ")\t\t"//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
						+ className);
			}
			perfLog.add("  ");//$NON-NLS-1$
			perfLog.add("          total loops=" + lapNumber + " with total loops over "//$NON-NLS-1$ //$NON-NLS-2$
					+ lastLapSquelch + "ms =" + lapNumOverSquelch + " for total time="//$NON-NLS-1$ //$NON-NLS-2$
					+ lapTimeOverSquelch);
			perfLog.add("          --------------------------------------------------------");//$NON-NLS-1$
			perfLog.add(" ");//$NON-NLS-1$
			lapClassMap.clear();
			lapNumber = 0;
			lapNumOverSquelch = 0;
			lapTimeOverSquelch = 0;
		}

		// reset everything
		lastTime = System.currentTimeMillis();
		isTimerOn = false;
		isLapTiming = false;
	}

	static private void stopBackground() {
		long backTime = System.currentTimeMillis() - lastTime;
		perfLog.add(backTime + "\t(???)");//$NON-NLS-1$
		backgroundTime += backTime;
		lastTime = System.currentTimeMillis();
	}

	static public void comment(String cmt) {
		if (!isOn) {
			return;
		}
		perfLog.add(cmt);
	}

//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////// DUMPING LOG /////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////

	static public void dump(String filename) {
		if (!isOn) {
			return;
		}
		if (perfLog.size() == 0) {
			return;
		}
		stopBackground();
		perfLog.add(" ");//$NON-NLS-1$
		perfLog.add("         ////////////////////////////////////////////////");//$NON-NLS-1$
		perfLog.add("         //////////    TOTALS     ///////////////////////");//$NON-NLS-1$
		perfLog.add("         ////////////////////////////////////////////////");//$NON-NLS-1$
		/////////////////////////
		perfLog.add(" ");//$NON-NLS-1$
		perfLog.add("----------- totals for sequences ---------------------");//$NON-NLS-1$
		perfLog.add("          Calls\t\ttot(ms)\t\tmax(ms)\ttot(by)\t\tmax(by)\t\tdescription");//$NON-NLS-1$
		perfLog.add("          ------\t------\t\t------\t\t--------\t\t------\t\t--------");//$NON-NLS-1$

		// sort the list first
		long totSeqTime = 0;
		Iterator iter = seqTimeMap.entrySet().iterator();
		Map.Entry arrSeqMap[] = new Map.Entry[seqTimeMap.size()];
		for (int i = 0; i < seqTimeMap.size(); i++) {
			Map.Entry entry = (Map.Entry) iter.next();
			arrSeqMap[i] = entry;
		}
		sortClassArray(arrSeqMap);
		for (int i = 0; i < arrSeqMap.length; i++) {
			Map.Entry entry = arrSeqMap[i];
			String description = (String) entry.getKey();
			PerformanceData data = (PerformanceData) entry.getValue();
			perfLog.add("            " + data.totalCalls + "\t\t" + data.totalTime + "\t\t"//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
					+ data.maxTime + "(" + data.maxTotalCall + "/" + data.maxLoopNum + ")\t\t"//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
					+ data.totalMemory + "\t\t" + data.maxMemory + "(" + data.maxMTotalCall + "/"//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
					+ data.maxMLoopNum + ")\t\t" + description);//$NON-NLS-1$
			totSeqTime += data.totalTime;
		}

		/////////////////////////
		/////////////////////////
		perfLog.add(" ");//$NON-NLS-1$
		perfLog.add("----------- totals for loops ---------------------");//$NON-NLS-1$
		perfLog.add("          Calls\t\ttot(ms)\t\tmax(ms)\ttot(by)\t\tmax(by)\t\tclassname");//$NON-NLS-1$
		perfLog.add("          ------\t------\t\t------\t\t--------\t\t------\t\t--------");//$NON-NLS-1$

		// sort the list first
		long totLapTime = 0;
		iter = totalLapClassMap.entrySet().iterator();
		Map.Entry arrMap[] = new Map.Entry[totalLapClassMap.size()];
		for (int i = 0; i < totalLapClassMap.size(); i++) {
			Map.Entry entry = (Map.Entry) iter.next();
			arrMap[i] = entry;
		}
		sortClassArray(arrMap);
		ArrayList lapSeqPercent = new ArrayList();
		for (int i = 0; i < arrMap.length; i++) {
			Map.Entry entry = arrMap[i];
			String className = (String) entry.getKey();
			PerformanceData data = (PerformanceData) entry.getValue();
			perfLog.add("            " + data.totalCalls + "\t\t" + data.totalTime + "\t\t"//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
					+ data.maxTime + "(" + data.maxTotalCall + "/" + data.maxLoopNum + ")\t\t"//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
					+ data.totalMemory + "\t\t" + data.maxMemory + "(" + data.maxMTotalCall + "/"//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
					+ data.maxMLoopNum + ")\t\t" + className);//$NON-NLS-1$
			// report seq's for this loop
			if (data.lapSeqMap != null && data.totalTime >= 100) {
				iter = data.lapSeqMap.entrySet().iterator();
				for (int j = 0; j < data.lapSeqMap.size(); j++) {
					entry = (Map.Entry) iter.next();
					className = (String) entry.getKey();
					PerformanceData lsdata = (PerformanceData) entry.getValue();
					long perc = lsdata.totalTime * 100 / data.totalTime;
					if (perc >= 20) {
						lapSeqPercent.add("				  " + perc + "% == " + className + " (maximum=="//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
								+ lsdata.maxTime + "ms on lap#==" + lsdata.maxLoopNum + ")");//$NON-NLS-1$ //$NON-NLS-2$
					}
				}
				if (lapSeqPercent.size() > 0) {
					perfLog.add("				  ~~~~~~~~~~~~~~~~~inner lap sequences ~~~~~~~~~~~~~~~~~");//$NON-NLS-1$
					perfLog.addAll(lapSeqPercent);
					lapSeqPercent.clear();
					perfLog.add("				  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");//$NON-NLS-1$
				}
			}
			totLapTime += data.totalTime;
		}
		perfLog.add(" ");//$NON-NLS-1$
		perfLog.add("  total measured sequence time=" + totSeqTime);//$NON-NLS-1$
		perfLog.add("  total measured loop time=" + totLapTime);//$NON-NLS-1$
		perfLog.add("  total unmeasured (???) time=" + backgroundTime);//$NON-NLS-1$
		perfLog.add("////////////////////////////////////////////////");//$NON-NLS-1$
		/////////////////////////
		/////////////////////////
		perfLog.add(" ");//$NON-NLS-1$
		perfLog.add("----------- totals for loop sequences ---------------------");//$NON-NLS-1$
		perfLog.add("          Calls\t\ttot(ms)\t\tmax(ms)\t\tclass");//$NON-NLS-1$
		perfLog.add("          ------\t------\t\t------\t\t--------");//$NON-NLS-1$
		iter = totalLapSeqClassMap.entrySet().iterator();
		Map.Entry arrLapSeqMap[] = new Map.Entry[totalLapSeqClassMap.size()];
		for (int i = 0; i < totalLapSeqClassMap.size(); i++) {
			Map.Entry entry = (Map.Entry) iter.next();
			arrLapSeqMap[i] = entry;
		}
		sortClassArray(arrLapSeqMap);
		for (int i = 0; i < arrLapSeqMap.length; i++) {
			Map.Entry entry = arrLapSeqMap[i];
			String className = (String) entry.getKey();
			PerformanceData data = (PerformanceData) entry.getValue();
			perfLog.add("            " + data.totalCalls + "\t\t" + data.totalTime + "\t\t"//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
					+ data.maxTime + "(" + data.maxTotalCall + "/" + data.maxLoopNum + ")\t\t"//$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
					+ className);
		}
		perfLog.add("          --------------------------------------------------------");//$NON-NLS-1$

		/////////////////////////
		try {
			PrintWriter dump = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			dump.println("///////////////////// LOG START ///////////////////////////////");//$NON-NLS-1$
			for (int i = 0; i < perfLog.size(); i++) {
				dump.println((String) perfLog.get(i));
			}
			dump.flush();
			if (errorLog.size() > 0) {
				dump.println("****************************");//$NON-NLS-1$
				for (int i = 0; i < errorLog.size(); i++) {
					dump.println((String) perfLog.get(i));
				}
				dump.flush();
			}
		} catch (IOException e) {
		}
		perfLog.clear();
		errorLog.clear();
	}

	static void sortClassArray(Map.Entry[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				Map.Entry entryi = a[i];
				Map.Entry entryj = a[j];
				PerformanceData datai = (PerformanceData) entryi.getValue();
				PerformanceData dataj = (PerformanceData) entryj.getValue();
				if (datai.totalTime < dataj.totalTime) {
					Map.Entry temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

}
