/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.tests.unit.publisher;

import junit.extensions.TestDecorator;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestResult;

/**
 * A TestDecorator that allows the decorated Test to spawn other threads and do
 * assertions in them. The main JUnit thread is suspended until all threads
 * spawned by the Test end, or a configurable timeout is exceeded. Failed
 * assertions from any spawned threads of the Test are added to the TestResult.
 * The main JUnit thread then wakes up and handles the TestResult as usual.
 * <p>
 * Typical usage is to return an instance of ThreadSpawnableTest from a Test's
 * suite method:
 * 
 * <pre>
 * public static Test suite() {
 * 	return new ThreadSpawnableTest(new TestSuite(MyTest.class));
 * }
 * </pre>
 * 
 * Note: if all your test methods in a MyTest class don't need the behavior
 * offered, then you should create your suite differently.
 * <p>
 * 
 * @author Greg Vaughn (gvaughn@delphis.com)
 * @date March 1, 2001
 * @date December 18, 2001
 * @date January 3, 2002
 */
// TO-DO: see if this could be integrated with main JUnit framework
// and replace the need for Protectable
public class ThreadSpawnableTest extends TestDecorator {

	private long fTimeout = 10000; // default to 10 seconds
	private boolean fTestThreadsRunning = false;

	/**
	 * Simple constructor for decorating the test
	 * 
	 * @param test
	 *            to be decorated
	 */
	public ThreadSpawnableTest(Test test) {
		super(test);
	}

	/**
	 * Constructor that also sets the overall timeout
	 * 
	 * @param test
	 *            to be decorated
	 * @param timeout
	 *            timeout
	 */
	public ThreadSpawnableTest(Test test, long timeout) {
		this(test);
		fTimeout = timeout;
	}

	public void basicRun(TestResult result) {
		System.out.println(fTest);
		fTest.run(result);
	}

	/**
	 * This overridden run method will create a ThreadGroup that handles all
	 * uncaught exceptions so the candidate Test can write assertions in threads
	 * that it spawns.
	 * 
	 * @param result
	 *            the collector of exceptions
	 */
	public synchronized void run(TestResult result) {
		result.shouldStop();
		ThreadGroup grp = new AssertionCatchingThreadGroup(result);
		Runnable endWatcher = new EndWatcher(result);
		Thread endWatcherThread = new Thread(grp, endWatcher, "EndWatcher");
		endWatcherThread.start();
		// basicRun() will be called within endWatcherThread

		// Now the main JUnit thread waits to either timeout or be
		// notified. (Spawned threads might call notifyAll and wake the
		// JUnit thread.)
		long endTime = fTimeout + System.currentTimeMillis();
		while (endTime > System.currentTimeMillis() && fTestThreadsRunning) {
			try {
				wait(fTimeout);
				// We own the lock on 'this' because run(TestResult)
				// is synchronized
			} catch (InterruptedException e) {
			}
		}

		if (grp.activeCount() > 1) { // OK if EndWatcher is still running
			fail("Timeout exceeded");
		}
	}

	// The candidate Test will be run within the context of this
	// ThreadGroup
	protected class AssertionCatchingThreadGroup extends ThreadGroup {
		private TestResult fResult;

		public AssertionCatchingThreadGroup(TestResult result) {
			super("AssertionCatchingThreadGroup");
			fResult = result;
		}

		public void uncaughtException(Thread t, Throwable e) {
			// TO-DO make wrapper subclass exceptions that will
			// encapsulate the thread name and include
			// it with the message, and preserve stack trace
			synchronized (fResult) {
				if (e instanceof AssertionFailedError) {
					fResult.addFailure(getTest(), (AssertionFailedError) e);
				} else {
					fResult.addError(getTest(), e);
				}
			}
		}
	}

	protected class EndWatcher implements Runnable {
		private TestResult fResult;

		public EndWatcher(TestResult result) {
			fResult = result;
		}

		// This will run within AssertionCatchingThreadGroup. First
		// it calls basicRun so if the candidate Test spawns threads,
		// they will by default be part of the same ThreadGroup. Then
		// it watches for all threads in the group to finish before
		// notifying the main JUnit thread.
		public void run() {
			ThreadSpawnableTest.this.fTestThreadsRunning = true;
			ThreadGroup grp = Thread.currentThread().getThreadGroup();
			basicRun(fResult);
			while (grp.activeCount() > 1) { // this thread counts as 1
				try {
					synchronized (this) {
						this.wait(200);
					}
				} catch (InterruptedException e) {
				}
			}
			synchronized (ThreadSpawnableTest.this) {
				ThreadSpawnableTest.this.fTestThreadsRunning = false;
				ThreadSpawnableTest.this.notify(); // main JUnit thread
			}
		}
	}
}
