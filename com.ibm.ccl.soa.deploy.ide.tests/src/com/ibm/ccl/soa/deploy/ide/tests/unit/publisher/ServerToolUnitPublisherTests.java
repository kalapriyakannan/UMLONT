/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.unit.publisher;

import junit.framework.TestCase;

import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.util.SocketUtil;

import com.ibm.ccl.soa.deploy.tests.workspaces.TomcatTestWorkspace;

public class ServerToolUnitPublisherTests extends TestCase {
	protected static int NUMBER_OF_PINGS = 5;

	private Thread readerThread;

	private boolean done = false;

	private IServer server;

/*
 * private class ServerStatusTester extends Job {
 * 
 * public ServerStatusTester(String name, IServer aServer) { super(name); server =
 * aServer; }
 * 
 * IServer server = null;
 * 
 * long failSafeTimer = 0;
 * 
 * int x = 0;
 * 
 * protected IStatus run(IProgressMonitor monitor) { while (failSafeTimer <
 * 900000000) { ServerPort[] ports = server.getServerPorts(new
 * NullProgressMonitor()); System.out.println(server.getName()); for (int i = 0;
 * i < ports.length; i++) { ServerPort port = ports[i]; System.out.print("port
 * name: " + port.getName() + " "); boolean result =
 * checkPortInUse(port.getPort()); System.out.println(" passed: " + result + "
 * "); // assertTrue(result); } if (failSafeTimer == 0) { failSafeTimer += 1; if
 * (failSafeTimer == 900000000) { if (x < 3) {
 * System.out.println(failSafeTimer); failSafeTimer = 1; x += 1; } } if (done)
 * return null; } } return null; }
 *  }
 */
	private TestServerToolUnitPublisher unitPublihser = new TestServerToolUnitPublisher();

	protected void setUp() throws Exception {
		TomcatTestWorkspace.init();
	}

	/**
	 * Performs end to end publish of a tomcat 5.0 server Adding a web module ->
	 * bank module configure a datasource --- in progress need models ping port
	 * to see if server has started.
	 */

	// ServerStatusTester tester;
	public void testEndtoEndPublish() throws Exception {
		unitPublihser.publish(null, null);

/*
 * Platform.getJobManager().addJobChangeListener(new IJobChangeListener() {
 * public synchronized void aboutToRun(IJobChangeEvent event) {
 * System.out.println(event.getJob()); if (event.getJob() instanceof
 * StartServerJob) { System.out.println("jobstarted"); StartServerJob serverJob =
 * (StartServerJob) event.getJob(); IServer server = serverJob.getServer();
 *  }
 *  }
 * 
 * public void awake(IJobChangeEvent event) { }
 * 
 * public synchronized void done(IJobChangeEvent event) { if (event.getJob()
 * instanceof StartServerJob) { System.out.println("jobDone");
 * System.out.println();
 * 
 * done = true; }
 *  }
 * 
 * public void running(IJobChangeEvent event) { }
 * 
 * public void scheduled(IJobChangeEvent event) {
 *  }
 * 
 * public void sleeping(IJobChangeEvent event) {
 *  } });
 * 
 * ThreadGroup group = Thread.currentThread().getThreadGroup(); int groupCount =
 * group.activeCount(); Thread[] tgArray = new Thread[groupCount];
 * group.enumerate(tgArray, true); for (int i = 0; i < tgArray.length; i++) {
 * Thread thread = tgArray[i]; if (thread.getName().equals("ReaderThread")) {
 * readerThread = thread; break; } } synchronized (readerThread) { try {
 * Thread.yield(); } catch (Exception e) { e.printStackTrace(); } }
 * 
 * 
 * try { Platform.getJobManager().join("org.eclipse.wst.server.ui.family",
 * null); } catch (OperationCanceledException e) { // TODO Auto-generated catch
 * block e.printStackTrace(); } catch (InterruptedException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 */

		// Job job = unitPublihser.getPublishJob();
		// server = unitPublihser.gets
		// tester = new ServerStatusTester("server tester", server);
		// tester.setPriority(60);
		// tester.schedule();
		// serverJob.setNextJob(tester);
	}

	/**
	 * Checks server state - should be started Checks test modules have been
	 * deployed to the server Checks module state - should be published
	 * 
	 */

	public void checkServerModules() throws Exception {

	}

	/**
	 * pings port to ensure the server has started.
	 * 
	 * @param portNum
	 */

	private boolean checkPortInUse(int portNum) {
		System.out.print("checking port " + portNum);
		return SocketUtil.isPortInUse(portNum, NUMBER_OF_PINGS);
	}

}
