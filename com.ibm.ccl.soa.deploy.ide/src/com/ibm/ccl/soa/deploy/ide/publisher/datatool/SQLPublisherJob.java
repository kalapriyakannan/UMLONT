/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.publisher.datatool;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.IdeMessages;
import com.ibm.ccl.soa.deploy.ide.publisher.IPublisherConstants;
import com.ibm.ccl.soa.deploy.ide.publisher.PublishFamilyMember;

public class SQLPublisherJob extends PublishFamilyMember {

	private static final String SEMICOLON = ";"; //$NON-NLS-1$

	private static final String SQL_CALL_CMD = "CALL"; //$NON-NLS-1$

	private final BufferedReader in;

	private final Connection connection;

	private int lineNumbers = 0;

	private final HashMap statusMap = new HashMap();

	public SQLPublisherJob(String name, BufferedReader in, Connection connection) {
		super(name, IPublisherConstants.DEPLOY_TOOLS_PUBLISH_FAMILY_NAME);
		setFamilyPriority(1);
		this.in = in;
		this.connection = connection;
		/* LineNumberReader lineReader = new LineNumberReader(in); */
		lineNumbers = 8000;

	}

	private void fireSqlStatement(String statementSource, Connection jdbcConnection) {
		Statement stmt = null;
		// Temporary ui dependency will be removed when runtime view ready
		try {
			if (isCallStatement(statementSource)) {
				stmt = jdbcConnection.prepareCall(statementSource);
				((CallableStatement) stmt).execute();
			} else {
				stmt = jdbcConnection.createStatement();
				stmt.execute(statementSource);
				statusMap.put(statementSource, statementSource);
			}
		} catch (Exception exception) {
			statusMap.put(exception, statementSource);
		}

	}

	private boolean isCallStatement(String sql) {
		int len = sql.length();
		for (int i = 0; i < len; i++) {
			if (sql.charAt(i) != ' ') {
				int end = Math.min(i + 4, len);
				String sub = sql.substring(i, end);
				if (sub.toUpperCase().equals(SQL_CALL_CMD)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	protected IStatus run(IProgressMonitor monitor) {
		String str = null;
		String contents = ""; //$NON-NLS-1$;
		int executedLines = 0;
		monitor.beginTask(IdeMessages.DatabasePublisherJob_Executing_Sql_statements_, lineNumbers);
		monitor.worked(executedLines);
		try {
			while ((str = in.readLine()) != null) {
				if (str != null || str != "") { //$NON-NLS-1$
					contents = contents.concat(str);
					contents = contents.concat("\n"); //$NON-NLS-1$
				}
				if (str.endsWith(SEMICOLON) && contents.length() > 0) {
					int terminatorInt = contents.lastIndexOf(SEMICOLON);
					contents = contents.substring(0, terminatorInt);
					fireSqlStatement(contents, connection);
					monitor.setTaskName(NLS.bind(
							IdeMessages.DatabasePublisherJob_Executing_sql_statemet_0_, contents));
					monitor.worked(++executedLines);
					contents = ""; //$NON-NLS-1$
				}
			}
			if (contents.length() <= 0) {
				return Status.OK_STATUS; // TODO error
			}

		} catch (IOException e) {
			IDEPlugin.logError(0, e.getMessage(), e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					IDEPlugin.logError(0, e.getMessage(), e);
				}
			}
			monitor.done();
		}

		return Status.OK_STATUS;
	}

	public synchronized HashMap getStatusMap() {
		return statusMap;
	}

}
