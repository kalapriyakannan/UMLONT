/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.osgi.util.NLS;

import com.ibm.asc.orchestrator.dynamic.ITask;
import com.ibm.asc.orchestrator.dynamic.OrchestratorFactory;
import com.ibm.asc.orchestrator.dynamic.TaskFactory;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.asc.exception.ASCExceptionMsg;
import com.ibm.ccl.soa.deploy.asc.exception.ExporterLogger;
import com.ibm.ccl.soa.deploy.asc.exporter.ASCBuilder;
import com.ibm.ccl.soa.deploy.asc.exporter.AscScriptDescriptor;
import com.ibm.ccl.soa.deploy.asc.exporter.ZipUtil;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;

/**
 * ASC Builder can generate the ASC Tasks from {@link AscScriptDescriptor} and build asc script from
 * Unit into zip.
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class UnitASCBuilder implements ASCBuilder {
	private static final String FILE_SEPARATOR = "/";//$NON-NLS-1$

	private static final String RESOURCE_ROOT = "/resources";//$NON-NLS-1$

	private static final String RUN_ALL_BAT = "runAll.bat";//$NON-NLS-1$

	private static final String ASC_JAR = "asc.jar";//$NON-NLS-1$

	private static final String ASC_LIBRARIES_ZIP = "ascLibraries.zip";//$NON-NLS-1$

	private static final String ASC_AGENT_ZIP = "asc-agent.zip";//$NON-NLS-1$

	private static final String LIB_FOLDER = "lib/";//$NON-NLS-1$

	private static final String SOLUTION_PROPERTIES = "solution.properties";//$NON-NLS-1$

	private static final String BUILD_XML = "build.xml";//$NON-NLS-1$

	private static final IUnitProviderService providerService = ExtensionsCore
			.createProviderService();

	private OrchestratorFactory ascFactory = new OrchestratorFactory();

	// some time some unit's property is missed, so should not be exported
	private HashSet dirtyUnitSet = new HashSet();

	private HashSet addedUnitSet = new HashSet();

	private int taskNum = 0;

	private ITask createTask(AscScriptDescriptor ascd, int taskNum) throws ASCException {
		ITask task = null;
		String taskNumStr = new Integer(taskNum).toString();
		try {
			task = TaskFactory.getTask(ascd.getAscPackageName(), ascd.getAscTaskName(), ascd
					.getAscProperties(), taskNumStr);
		} catch (Exception e) {
			ExporterLogger.INSTANCE.logTaskError(ascd.getAscTaskName());
			throw new ASCException(
					NLS.bind(ASCExceptionMsg.TASK_CREATE_FAILED, ascd.getAscTaskName()), e);
		}
		if (task != null)
			ExporterLogger.INSTANCE.logTaskSuccess(ascd.getAscTaskName());
		return task;
	}

	/**
	 * Add a unit into the builder to be exported
	 * 
	 * @param unit
	 *           the Unit which you want to build in asc script.
	 */
	private void addUnit(Unit unit) throws ASCException {
		ExporterLogger.INSTANCE.entryUnit(unit.getName());
		// to avoid duplicated unit from the map
		if (addedUnitSet.contains(unit) == true
				|| true == InstallState.INSTALLED_LITERAL.equals(unit.getInitInstallState()))
			return;
		addedUnitSet.add(unit);
		// can do noting to the OperatingSystemUnit and cell
		if (isIgnored(unit) == true) {
			ExporterLogger.INSTANCE.logIgnore(unit.getName());
			return;
		}

		UnitASCProvider provider = getUnitProviders(unit);

		if (provider == null) {
			ExporterLogger.INSTANCE.logInfo(NLS
					.bind(ASCExceptionMsg.NO_PROVIDER_FOUND, unit.getName()));
			this.markDirty(unit);
			return;
		}

		TopologyUnitStub[] stubs = provider.resolveStubs(unit);

		// some unit need special condition
		if (provider.isConditionSatisfied() == false) {
			ExporterLogger.INSTANCE.conditionFailed(unit.getName());
			markDirtyWithHostee(unit);
			return;
		}

		AscScriptDescriptor[] ascSDs = new AscScriptDescriptor[0];
		if (stubs.length > 0)
			ascSDs = (AscScriptDescriptor[]) provider.resolveUnit(stubs[0], true,
					new NullProgressMonitor());

		this.addDescriptors(ascSDs);
	}

	/**
	 * some unit have no provider and no ASC tasks, so should be ignored.
	 * 
	 * @param unit
	 * @return
	 */

	private boolean isIgnored(Unit unit) {
		return unit instanceof OperatingSystemUnit || unit instanceof WasDeploymentManagerUnit
				|| unit instanceof PortConfigUnit || unit instanceof DB2CatalogUnit
				|| unit instanceof DB2RuntimeClientUnit || unit instanceof UserGroupUnit
				|| unit instanceof UserUnit;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.exporter.ASCBuilder#getBuildStr()
	 */
	public StringBuffer getBuildStr() throws ASCException {
		try {
			return ascFactory.publish();
		} catch (IOException e) {
			ExporterLogger.INSTANCE.logException(e);
			throw new ASCException(ASCExceptionMsg.BUILDFILE_CREATE_FAILED, e);
		}
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.exporter.ASCBuilder#getTasks()
	 */
	public Vector getTasks() {
		return ascFactory.getTasks();
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.exporter.ASCBuilder#getSolutionStr()
	 */
	public StringBuffer getSolutionStr() throws ASCException {
		try {
			return ascFactory.propertyPublish();
		} catch (IOException e) {
			ExporterLogger.INSTANCE.logException(e);
			throw new ASCException(ASCExceptionMsg.SOLUTIONFILE_CREATE_FAILED, e);
		}
	}

	private void addDescriptors(AscScriptDescriptor[] arrDes) {
		for (int i = 0; i < arrDes.length; i++) {
			ITask task = null;
			try {
				task = createTask(arrDes[i], taskNum++);
			} catch (ASCException e) {
				e.printStackTrace();
				System.out.println(arrDes[i].toString());
				ExporterLogger.INSTANCE.logException(e);
			} finally {
				if (task != null)
					ascFactory.addTask(task);
			}
		}

	}

	private UnitASCProvider getUnitProviders(Unit unit) {

		UnitProvider[] unitProviders = providerService.findEnabledProvidersByInputAndOutput(unit,
				new AscScriptDescriptor());
		UnitProvider unitProvider = null;
		if (unitProviders.length > 0)
			unitProvider = unitProviders[0];
		return (UnitASCProvider) unitProvider;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.exporter.ASCBuilder#buildZip(java.util.zip.ZipOutputStream)
	 */
	public void buildZip(ZipOutputStream zipOut) throws ASCException {

		if (taskNum == 0) {
			return;

		}
		// Dump the script library, runAll.bat, asc.jar into the archive

		try {
			// ASC_AGENT_ZIP

			InputStream agentStream = ASCActivator.class.getResourceAsStream(RESOURCE_ROOT
					+ FILE_SEPARATOR + ASC_AGENT_ZIP);
			ZipUtil.compressByCopy(ASC_AGENT_ZIP, agentStream, zipOut);

			InputStream libStream = ASCActivator.class.getResourceAsStream(RESOURCE_ROOT
					+ FILE_SEPARATOR + ASC_LIBRARIES_ZIP);
			ZipUtil.compressByCopy(ASC_LIBRARIES_ZIP, libStream, zipOut);

			InputStream runAllStream = ASCActivator.class.getResourceAsStream(RESOURCE_ROOT
					+ FILE_SEPARATOR + RUN_ALL_BAT);
			ZipUtil.compressByCopy(RUN_ALL_BAT, runAllStream, zipOut);

			InputStream ascJarInputStream = ASCActivator.class.getResourceAsStream(RESOURCE_ROOT
					+ FILE_SEPARATOR + ASC_JAR);
			ZipUtil.compressFile2Dir(LIB_FOLDER, ASC_JAR, ascJarInputStream, zipOut);

			// Generate orchestration file and property file
			StringBuffer buildStr = ascFactory.publish();
			StringBuffer propertyStr = ascFactory.propertyPublish();

			ZipUtil.compressStringAsFile(buildStr, zipOut, BUILD_XML);
			ZipUtil.compressStringAsFile(propertyStr, zipOut, SOLUTION_PROPERTIES);

		} catch (Exception e) {
			e.printStackTrace();
			ExporterLogger.INSTANCE.logException(e);
			throw new ASCException(ASCExceptionMsg.ZIP_FILE_FAILED, e);
		}

	}

	/**
	 * only mark it self dirty, means this unit will never be exported as ASC scripts
	 * 
	 * @param unit
	 *           The unit to be marked dirty.
	 */

	private void markDirty(Unit unit) {
		dirtyUnitSet.add(unit);
		ExporterLogger.INSTANCE.logDirtyUnit(unit.getName());
	}

	/**
	 * mark itself and all the children dirty, means this unit and it children will never be exported
	 * as ASC scripts
	 * 
	 * @param unit
	 *           The unit to be marked dirty.
	 */
	private void markDirtyWithHostee(Unit unit) {

		this.markDirty(unit);
		// should get all children unit here
		List udlist = unit.getHostingLinks();
		if (udlist == null)
			return;
		Iterator iterator = udlist.iterator();
		while (iterator.hasNext())
			markDirtyWithHostee(((HostingLink) iterator.next()).getHosted());
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.exporter.ASCBuilder#addUnitArray(com.ibm.ccl.soa.deploy.core.Unit[])
	 */
	public void addUnitArray(Unit[] units) throws ASCException {
		for (int i = 0; i < units.length; i++) {
			Unit unit = units[i];
			if (ASCUtil.isInstalledUnit(unit)) {
				ExporterLogger.INSTANCE.logIntalled(unit.getName());
				continue;
			}
			try {
				if (unit instanceof WasSystemUnit && ASCUtil.isWASBase6(unit)) {
					WasNodeUnit nodeUnit = ASCUtil.getFirstWasNodeUnitofWasBase((WasSystemUnit) unit);

					// make this node dirty, for the base v6
					// so this node don't be used create "createProfile" task
					markDirty(nodeUnit);
				}
				if (dirtyUnitSet.contains(unit) == false)
					addUnit(unit);
			} catch (Exception e) {
				e.printStackTrace();
				markDirty(unit);
				ExporterLogger.INSTANCE.logException(e);
			}
		}
	}
}
