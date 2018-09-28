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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;

/**
 * JUnit test case for Plants-by.
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class LinkNavigationMethodTimings extends TopologyTestCase {

	// Use instance variables for now
	/** Topology used for the middleware units. */
	private Topology top;

	private Import importTop1;

	private Topology editTop1;

	private Topology resolvedTop1;

	boolean verbose = true;

	private Topology editTop2;

	private Import importTop2;

	private Topology resolvedTop2;

	private int callCnt = 200;

	private double reportingThreshold = 0.0001;

	private boolean useImportedTopologies = true;

	/** Test case ctor */
	public LinkNavigationMethodTimings() {
		super("LinkNavigationMethodTimings");
	}

	/**
	 * @throws Exception
	 *             Note 2007/04/04 main test case won't run without this dummy
	 *             test run first.
	 */
	public void testDummy() throws Exception {
		createTopology("dummy");
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * Time link navigation methods
	 * 
	 * @throws Exception
	 */
	public void testLinkNavigationMethodTimings() throws Exception {

		top = createTopology("LinkNavigationTimings", true);

		if (useImportedTopologies) {
			editTop1 = createTopology("editTop1", true);
			ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE_CONCEPTUAL, editTop1);
			save(editTop1);
			assert (editTop1.getUnits().size() >= 1);

			editTop2 = createTopology("editTop2", true);
			ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE, editTop2);
			save(editTop2);
			assert (editTop2.getUnits().size() >= 1);

			importTop1 = TopologyUtil.importTopology(editTop1, top);
			resolvedTop1 = TopologyUtil.resolve(importTop1);
			importTop2 = TopologyUtil.importTopology(editTop2, top);
			resolvedTop2 = TopologyUtil.resolve(importTop2);
		} else {
			ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE_CONCEPTUAL, top);
			ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_STANDALONE_BUNDLE, top);
			assert (top.getUnitLinks().size() >= 2);
		}
		save(top);

		createRealizationLinks(top);
		save(top);

		ArrayList allUnitsList = new ArrayList();
		for (Iterator unitIter = top.findAllUnits(); unitIter.hasNext();) {
			Unit u = (Unit) unitIter.next();
			Method m = top.getClass().getMethod("findHosts", new Class[] { Unit.class });
			Object o = m.invoke(top, new Object[] { u });

			allUnitsList.add(u);
		}
		System.out.println("Timings for all units in edit topology " + top.getName());
		timeMethodsWithSingleParameter(Topology.class, top, allUnitsList);
		timeMethodsWithSingleParameter(ValidatorUtils.class, new ValidatorUtils(), allUnitsList);
		timeMethodsWithSingleParameter(RealizationLinkUtil.class, new RealizationLinkUtil(), allUnitsList);
		timeMethodsWithSingleParameter(TopologyUtil.class, null, allUnitsList);
		timeMethodsWithSingleParameter(UnitUtil.class, null, allUnitsList);
	}

	/**
	 * @param c
	 * @param cInst
	 * @param parameterObjList
	 *            List of parameters to pass to method (one per call to method)
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private void timeMethodsWithSingleParameter(Class c, Object cInst, List parameterObjList)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		if (cInst != null)
			assert (c.isInstance(cInst));
		List<Method> methods = new LinkedList<Method>(Arrays.asList(c.getMethods()));
		assert(methods.size() > 0);
		for (int mNum = 0; mNum < methods.size(); ++mNum) {
			Method m = methods.get(mNum);
			if (m.getName().equals("equals")) {
				continue;
			}
			
			if (m.getParameterTypes().length == 1 && parameterObjList.size() > 0
					&& m.getParameterTypes()[0].isInstance(parameterObjList.get(0))) {
				// prime code path before timings
//				System.out.println("invoking " + c.getName() + "#" + m.getName());				
				Object o = m.invoke(cInst, new Object[] { parameterObjList.get(0) });
			}

			long prevTime = System.currentTimeMillis();

			int parametersUsedCnt = 0;
			for (Iterator pListIter = parameterObjList.iterator(); pListIter.hasNext();) {
				Object parameterObj = pListIter.next();
				if (m.getParameterTypes().length == 1 && m.getParameterTypes()[0].isInstance(parameterObj)
						&& !m.getParameterTypes()[0].equals(Object.class)) {
//					System.out.println("invoking " + c.getName() + "#" + m.getName());
					for (int i = 0; i < callCnt; ++i) {
						Object o = m.invoke(cInst, new Object[] { parameterObj });
					}
					++parametersUsedCnt;
				}
			}
			long time = System.currentTimeMillis();
			double average = (double) (time - prevTime) / (callCnt * parametersUsedCnt);
			NumberFormat nf = NumberFormat.getInstance();

			nf.setMaximumFractionDigits(3);
			nf.setMaximumIntegerDigits(2);
			if (average > reportingThreshold) {
				System.out.println(this.getName() + " : " + nf.format(average) + " ms/call for " + callCnt
						* parametersUsedCnt + " " + c.getName() + "#" + m.getName() + " calls"); //$NON-NLS-1$
			}
		}
	}

	private void createRealizationLinks(Topology top) {
		DeployValidatorService dvs = new DeployValidatorService();
		for (Iterator unitIter = top.findAllUnits(); unitIter.hasNext();) {
			Unit u = (Unit) unitIter.next();
			if (u.isConceptual()) {
				for (Iterator unitIter2 = top.findAllUnits(); unitIter2.hasNext();) {
					Unit testU = (Unit) unitIter2.next();
					if (dvs.canCreateLink(u, testU, new LinkType[] { LinkType.REALIZATION }).isOK()) {
						RealizationLink rl = LinkFactory.createRealizationLink(u, testU);
						assert (rl != null);
						System.out.println("RealizationLink from " + u.getCaptionProvider().titleWithContext(u)
								+ " to " + testU.getCaptionProvider().titleWithContext(testU));
					}
				}
			}
		}
	}

}
