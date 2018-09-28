/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * JUnit test case for Plants-by.
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class DmoGetMethodTimings extends TopologyTestCase {

	// Use instance variables for now
	/** Topology used for the middleware units. */
	private Topology top;

	private Import importTop1;

	private Topology editTop1;

	private Topology resolvedTop1;

	boolean verbose = true;

	private int callCnt = 1000000;
	
	private double reportingThreshold = 0.00001;

	private boolean useImportedTopologies = true;

	/** Test case ctor */
	public DmoGetMethodTimings() {
		super("LinkNavigationMethodTimings");
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}
	

	/**
	 * @throws Exception
	 *             Note 2007/04/04 main test case won't run without this dummy
	 *             test run first.
	 */
	public void testDummy() throws Exception {
		createTopology("dummy");
	}

	/**
	 * Time link navigation methods
	 * 
	 * @throws Exception
	 */
	public void testDmoGetMethodTimings() throws Exception {

		top = createTopology("DmoGetMethodTimings", true);
		WebsphereAppServerUnit wasServerUnit = null;
		if (useImportedTopologies) {
			editTop1 = createTopology("editTop1", true);
			ResolutionUtils.addFromTemplate(
					IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE_CONCEPTUAL,
					editTop1);
			save(editTop1);
			assert (editTop1.getUnits().size() >= 1);
			addIdentityContract(editTop1);

			importTop1 = TopologyUtil.importTopology(editTop1, top);
			resolvedTop1 = TopologyUtil.resolve(importTop1);
		} else {
			ResolutionUtils.addFromTemplate(
					IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE_CONCEPTUAL,
					top);
			assert (top.getUnits().size() >= 2);
		}
		save(top);
		
		for (Iterator<Unit> unitsIter = top.findAllUnits(); unitsIter.hasNext();) {
			Unit u = unitsIter.next();
			if (u instanceof WebsphereAppServerUnit) {
				wasServerUnit = (WebsphereAppServerUnit) u;
			}
		}
		assert(wasServerUnit != null);
		WasServer wasServer = (WasServer)ValidatorUtils.getFirstCapability(wasServerUnit, WasPackage.eINSTANCE.getWasServer());
		assert(wasServer != null);

		System.out.println("Timings for all units in edit topology "
				+ top.getName());
		timeMethodsWithNoParameters(WasServer.class, wasServer);
		timeMethodsWithNoParameters(WebsphereAppServerUnit.class, wasServerUnit);		
	}
	
	private void addIdentityContract(Topology top) {
		ExplicitContract ic = CoreFactory.eINSTANCE.createExplicitContract();
		ic.setName("Identity0");
		ic.setDisplayName("Identity contract");
		top.setConfigurationContract(ic);
	}	

	/**
	 * @param c
	 * @param dmo
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private void timeMethodsWithNoParameters(Class c, DeployModelObject dmo) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		Method mArray[] = c.getMethods();
		for (int mNum = 0; mNum < mArray.length; ++mNum) {
			Method m = mArray[mNum];

			if (m.getParameterTypes().length == 0 && !(m.getName().startsWith("unset"))/*&& m.getName().startsWith("get")*/) {
				long prevTime = System.currentTimeMillis();

				for (int i = 0; i < callCnt; ++i) {
					m.invoke(dmo);
				}

				long time = System.currentTimeMillis();
				double average = (double) (time - prevTime) / (callCnt);
				NumberFormat nf = NumberFormat.getInstance();

				nf.setMaximumFractionDigits(3);
				nf.setMaximumIntegerDigits(2);
				if (average > reportingThreshold) {
					System.out.println(this.getName() + " : " + nf.format(average) + " ms/call for " + callCnt + " "
							+ c.getName() + "#" + m.getName() + " calls"); //$NON-NLS-1$
					System.out.println(this.getName() + " : " + nf.format((time-prevTime)/1000.0) + " total seconds for " + callCnt + " "
							+ c.getName() + "#" + m.getName() + " calls");
				}
			}
		}
	}
}
