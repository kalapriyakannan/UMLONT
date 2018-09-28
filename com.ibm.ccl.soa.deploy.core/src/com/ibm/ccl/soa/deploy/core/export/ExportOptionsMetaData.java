/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.export;

/**
 * These options are passed to the export through the DeployTopologyExportService when the exporter
 * is invoked.
 */
public class ExportOptionsMetaData {
	private int outputAs;
	private Object output;
	private boolean exportWithErrors;
	private DeployExportLogger exportLog;
	private String exportProjectName;
	private boolean createExportProject;
	private boolean exportDiagramResourceIfPresent;
	private boolean createLocationBinding = false;
	private boolean exportModules = true;

	/**
	 * @return Returns the outputAs.
	 */
	public int getOutputAs() {
		return outputAs;
	}

	/**
	 * @param outputAs
	 *           The outputAs to set.
	 */
	public void setOutputAs(int outputAs) {
		this.outputAs = outputAs;
	}

	/**
	 * @return Returns the output.
	 */
	public Object getOutput() {
		return output;
	}

	/**
	 * @param output
	 *           The output to set.
	 */
	public void setOutput(Object output) {
		this.output = output;
	}

	/**
	 * @param exportWithErrors
	 *           The exportWithErrors to set.
	 */
	public void setExportWithErrors(boolean exportWithErrors) {
		this.exportWithErrors = exportWithErrors;
	}

	/**
	 * @return Returns the exportWithErrors.
	 */
	public boolean isExportWithErrors() {
		return exportWithErrors;
	}

	/**
	 * @param exportLog
	 *           The exportLog to set.
	 */
	public void setExportLog(DeployExportLogger exportLog) {
		this.exportLog = exportLog;
	}

	/**
	 * @return Returns the exportLog.
	 */
	public DeployExportLogger getExportLog() {
		if (exportLog == null) {
			exportLog = new DeployExportLogger();
		}
		return exportLog;
	}

	/**
	 * the option to create the location binding
	 * 
	 * @param createLocationBinding
	 *           the option to create the location binding
	 */
	public void setCreateLocationBinding(boolean createLocationBinding) {
		this.createLocationBinding = createLocationBinding;
	}

	/**
	 * 
	 * @return the option to create the location binding
	 */
	public boolean isCreateLocationBinding() {
		return createLocationBinding;
	}

	/**
	 * the project name to be used for export
	 * 
	 * @param exportProjectName
	 *           the project name to be used for export
	 */
	public void setExportProjectName(String exportProjectName) {
		this.exportProjectName = exportProjectName;
	}

	/**
	 * 
	 * @return the project name to be used for export
	 */
	public String getExportProjectName() {
		return exportProjectName;
	}

	/**
	 * the option to create the project is set
	 * 
	 * @param createExportProject
	 *           the option to create the project
	 */
	public void setCreateExportProject(boolean createExportProject) {
		this.createExportProject = createExportProject;
	}

	/**
	 * the option to create the project
	 * 
	 * @return the option to create the project
	 */
	public boolean isCreateExportProject() {
		return createExportProject;
	}

	/**
	 * the option to export the diagram resource if present
	 * 
	 * @param exportDiagramResourceIfPresent
	 *           the option to export the diagram resource if present
	 */
	public void setExportDiagramResourceIfPresent(boolean exportDiagramResourceIfPresent) {
		this.exportDiagramResourceIfPresent = exportDiagramResourceIfPresent;
	}

	/**
	 * the option to export the diagram resource if present
	 * 
	 * @return the option to export the diagram resource if present
	 */
	public boolean isExportDiagramResourceIfPresent() {
		return exportDiagramResourceIfPresent;
	}

	/**
	 * set to export the modules present in the topology through the export service if this option is
	 * set to false, the only the resources that are returned by the exporter will be packaged such
	 * that the deploy topology service will not traverse the topology and package the archive for
	 * the unit(s) in to the output archive.
	 * 
	 * @param exportModules
	 *           set to export the modules present in the topology through the export service
	 */
	public void setExportModules(boolean exportModules) {
		this.exportModules = exportModules;
	}

	/**
	 * option to export the modules present in the topology through the export service
	 * 
	 * @return option to export the modules present in the topology through the export service
	 */
	public boolean isExportModules() {
		return exportModules;
	}
}
