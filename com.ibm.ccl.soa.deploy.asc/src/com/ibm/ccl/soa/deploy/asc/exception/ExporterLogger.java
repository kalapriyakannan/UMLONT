/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.exception;

import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.asc.ASCActivator;
import com.ibm.ccl.soa.deploy.core.export.DeployExportStatus;

/**
 * The log of the exporter.
 * 
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-8-25
 */
public class ExporterLogger {

	private StringBuffer logContent = new StringBuffer();

	boolean exception = false;

	int taskNumber = 0;

	int unitNumber = 0;

	int propNumber = 0;

	int dirtyNumber = 0;

	private Vector exportStatus = new Vector();

	private ExporterLogger() {
		appendLine("***********************ASC Log Begin**********************************************"); //$NON-NLS-1$
	}

	private void addInfoStatus(String statusInfo) {
		exportStatus.add(new DeployExportStatus(IStatus.INFO, ASCActivator.PLUGIN_ID, 0, statusInfo,
				null));
	}

	private void addErrorStatus(String statusInfo) {
		exportStatus.add(new DeployExportStatus(IStatus.ERROR, ASCActivator.PLUGIN_ID, 0, statusInfo,
				null));
	}

	private void addErrorStatus(String statusInfo, Exception e) {
		exportStatus.add(new DeployExportStatus(IStatus.ERROR, ASCActivator.PLUGIN_ID, 0, statusInfo,
				e));
	}

	/**
	 * clean all the caches for one exporting procedure
	 */
	public void clean() {
		INSTANCE = new ExporterLogger();
	}

	public static ExporterLogger INSTANCE = new ExporterLogger();

	/**
	 * log a null property value
	 * 
	 * @param propName,
	 *           the name of property which's value is null, eg,"wasHome"
	 */
	public void logNullPorp(String propName) {
		propNumber++;
		String msg = NLS.bind(ASCExceptionMsg.LOG_NULL_PROP, propName);
		appendLine(msg);
		this.addErrorStatus(msg);
	}

	/**
	 * log a dirty unit, this unit should not be exported for some reason, eg no related task
	 * 
	 * @param unitName
	 *           the name of Unit.
	 */
	public void logDirtyUnit(String unitName) {
		dirtyNumber++;
		String msg = NLS.bind(ASCExceptionMsg.LOG_MARK_DIRTY, unitName);
		appendLine(msg);
		this.addErrorStatus(msg);
	}

	/**
	 * log an exception occured
	 * 
	 * @param e,
	 *           exception instance
	 */
	public void logException(Exception e) {
		exception = true;
		String msg = NLS.bind(ASCExceptionMsg.LOG_Exception, e.getMessage());
		appendLine(msg);
		this.addErrorStatus(msg, e);
	}

	/**
	 * log a successful exporting of a unit
	 * 
	 * @param unitName,
	 *           the name of unit that task is created successfully.
	 */
	public void logUnitSuccess(String unitName) {
		unitNumber++;
		String msg = NLS.bind(ASCExceptionMsg.LOG_UNIT_SUCCESS, unitName);
		appendLine(msg);
		this.addInfoStatus(msg);
	}

	/**
	 * log an error exporting of a unit
	 * 
	 * @param unitName
	 *           the name of unit that task is created failed.
	 */

	public void logUnitError(String unitName) {
		String msg = NLS.bind(ASCExceptionMsg.LOG_UNIT_ERROR, unitName);
		appendLine(msg);
		this.addErrorStatus(msg);
	}

	/**
	 * log an error when create a task
	 * 
	 * @param taskName
	 *           the name of task
	 */
	public void logTaskError(String taskName) {

		String msg = NLS.bind(ASCExceptionMsg.LOG_TASK_ERROR, taskName);
		appendLine(msg);
		this.addErrorStatus(msg);
	}

	/**
	 * log a successful creation of a task
	 * 
	 * @param taskName
	 *           the name of task
	 */
	public void logTaskSuccess(String taskName) {
		taskNumber++;
		String msg = NLS.bind(ASCExceptionMsg.LOG_TASK_SUCCESS, taskName);
		appendLine(msg);
		this.addInfoStatus(msg);
	}

	private void appendLine(String msg) {
		logContent.append("\n" + msg); //$NON-NLS-1$
	}

	/**
	 * get all log content
	 * 
	 * @return the log content
	 */
	public StringBuffer getLogContent() {
		StringBuffer result = logContent;
		result
				.append("\n==============================================================================="); //$NON-NLS-1$
		result
				.append("\n " + NLS.bind(ASCExceptionMsg.LOG_TOTAL_PROPERTY, Integer.toString(propNumber))); //$NON-NLS-1$ 
		result
				.append("\n " + NLS.bind(ASCExceptionMsg.LOG_TOTAL_DIRTY, Integer.toString(dirtyNumber))); //$NON-NLS-1$ 
		result.append("\n " + NLS.bind(ASCExceptionMsg.LOG_TOTAL_TASK, Integer.toString(taskNumber))); //$NON-NLS-1$ 

		if (exception) {
			result.append("\n ** " + ASCExceptionMsg.LOG_END_ERROR); //$NON-NLS-1$
		} else if (taskNumber > 0)
			result.append("\n ** " + ASCExceptionMsg.LOG_END_SUCCESS); //$NON-NLS-1$
		result
				.append("\n==============================================================================="); //$NON-NLS-1$
		result
				.append("\n***********************ASC Log Ended**********************************************\n"); //$NON-NLS-1$
		return result;
	}

	/**
	 * get all log status
	 * 
	 * @return list of the log status
	 */
	public List getStatusList() {
		return exportStatus;
	}

	/**
	 * log info when create a task
	 * 
	 * @param info
	 */
	public void logInfo(String info) {
		appendLine(info);
//		addInfoStatus(info);
	}

	public void entryUnit(String name) {
		logInfo(NLS.bind(ASCExceptionMsg.LOG_ENTRY_UNIT, name));
	}

	/**
	 * log an conditionFailed when create a task
	 * 
	 * @param unitName
	 *           the name of Unit
	 */
	public void conditionFailed(String unitName) {
		String msg = NLS.bind(ASCExceptionMsg.LOG_COND_FAILED, unitName);
		logInfo(msg);
		addInfoStatus(msg);
	}

	/**
	 * log an Ignore when create a task
	 * 
	 * @param unitName
	 */
	public void logIgnore(String unitName) {
		String msg = NLS.bind(ASCExceptionMsg.LOG_UNIT_IGNOERED, unitName);
		logInfo(msg);
		addInfoStatus(msg);
	}

	public void logIntalled(String unitName) {
		String msg = NLS.bind(ASCExceptionMsg.LOG_UNIT_INSTALLED, unitName);
		logInfo(msg);
		addInfoStatus(msg);
	}
}
