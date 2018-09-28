/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc;

import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.asc.exception.ExporterLogger;
import com.ibm.ccl.soa.deploy.asc.exporter.AscScriptDescriptor;
import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;

/**
 * UnitProvider Contribution: UnitASCProvider.This is the parent of all the ASC unit providers to
 * craete the ASC tasks for the unit.
 * 
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> 2006-8-17
 */

public abstract class UnitASCProvider extends UnitProvider {

	private static final String LOCALHOST = "localhost";//$NON-NLS-1$

	private static final String AGENT = "agent";//$NON-NLS-1$

	/**
	 * The asc package name: see {@link ASCConstants#PACKAGE_NAME_WAS_6} and
	 * {@link ASCConstants#PACKAGE_NAME_WASND_6}
	 */
	protected String ascPackageName = null;

	/**
	 * An array of task names about this unit provider.
	 */
	protected String[] ascTaskName = null;

	/**
	 * An array of properties of the tasks, it should have the same sequance of the task name array.
	 */
	protected Properties[] ascProps = null;

	/**
	 * each provider owns a unit to be exproted .
	 */
	protected Unit unit = null;

	private static final String LOCAL_AGENT = "com.ibm.asc.ca.ChangeAgent:${basedir}/tmp/agent::logVerbosity=debug:consoleVerbosity=debug"; //$NON-NLS-1$

	private static final String REMOTE_AGENT_POSTFIX = ":8123:consoleVerbosity=debug:logVerbosity=debug";//$NON-NLS-1$ 

	private static final String REMOTE_AGENT_PREFIX = "com.ibm.asc.ca.http.HttpAgentProxy:";//$NON-NLS-1$ 

	/**
	 * Whether the pre-request is satisfied. Subclass maybe need special condition to triger the
	 * export. Otherwise the unit will alwasys be exported with ASC tasks.
	 * 
	 * @return true if the unit can be exported as ASC tasks
	 */
	public boolean isConditionSatisfied() {
		return true;
	}

	/**
	 * All the providers must implemataion the method to init the asc task.
	 */
	protected abstract void initTasks() throws ASCException;

	/**
	 * Set a name-value pare into a properties.The provider will use the properties to build ASC
	 * tasks. instead.
	 * 
	 * @param props :
	 *           the Properties to which the name and value will be put
	 * @param name :
	 *           property name
	 * @param value :
	 *           property value
	 */
	protected void setAscProperty(Properties props, String name, String value) throws ASCException {
		// asc optional attribute can be ""
		if (value == null)
			value = ""; //$NON-NLS-1$
		props.put(name, value);
	}

	/**
	 * Given an input object (from a view or otherwise indicated by the user), quickly determine what
	 * underlying domain model elements the input object may correspond to. Avoid any heavy
	 * operations or more document loading than is absolutely necessary.
	 * 
	 * @param anInputObject
	 *           An element that matches the input enablement specified by the extension
	 *           corresponding to this provider.
	 * @return An array of stub elements that can be used to represent the potential underlying
	 *         domain model elements.
	 */
	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		TopologyUnitStub[] stubs = NO_STUBS;

		unit = (Unit) anInputObject;

		String unitName = unit.getName();

		stubs = new TopologyUnitStub[1];

		Annotation annotation = createAnnotaion(unitName);

		stubs[0] = new TopologyUnitStub(unitName, null, annotation, unit);
		return stubs;
	}

	protected Annotation createAnnotaion(String unitName) {
		Annotation annotation = (Annotation) CoreFactory.eINSTANCE.createAnnotation();
		annotation.getDetails().put(IAnnotationConstants.ARCHIVE_URI, unitName);
		annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
		return annotation;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.core.UnitProvider#resolveUnit(com.ibm.ccl.soa.deploy.core.TopologyUnitStub,
	 *      boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor) {

		unit = (Unit) aStub.getInput();

		try {
			this.initTasks();
		} catch (ASCException e) {
			e.printStackTrace();
			ExporterLogger.INSTANCE.logException(e);
			return new AscScriptDescriptor[0];
		}

		AscScriptDescriptor[] ascScriptDescriptors = new AscScriptDescriptor[ascTaskName.length];
		for (int i = 0; i < ascTaskName.length; i++) {
			AscScriptDescriptor ascScriptDescriptor = new AscScriptDescriptor();
			ascScriptDescriptor.setAscPackageName(this.ascPackageName);
			ascScriptDescriptor.setAscTaskName(this.ascTaskName[i]);

			ascScriptDescriptor.setAscProperties(this.ascProps[i]);

			ascScriptDescriptors[i] = ascScriptDescriptor;
		}
		return ascScriptDescriptors;

	}

	/**
	 * @see com.ibm.ccl.soa.deploy.core.UnitProvider#resolveLinks(java.util.List,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public boolean resolveLinks(List aDeployModelObjects, IProgressMonitor aMonitor) {
		return false;
	}

	/**
	 * Set the asgent property of the asc tasks related of this unit provider.
	 * 
	 * @param props :
	 *           The Properties to which the agnet property will be put
	 * @return
	 */
	protected void setASCAgentProp(Properties props) throws ASCException {
		String host = ASCUtil.getOSHostName(unit);
		setASCAgentProp(props, host);
	}

	protected void setASCAgentProp(Properties props, String host) throws ASCException {
		String anget = LOCAL_AGENT;
		if (host != null && host.equalsIgnoreCase(LOCALHOST) == false)
			anget = REMOTE_AGENT_PREFIX + host + REMOTE_AGENT_POSTFIX;
		setAscProperty(props, AGENT, anget);
	}

}
