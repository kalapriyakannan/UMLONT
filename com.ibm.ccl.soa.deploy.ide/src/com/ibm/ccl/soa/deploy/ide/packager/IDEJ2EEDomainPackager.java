/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.packager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jst.j2ee.applicationclient.componentcore.util.AppClientArtifactEdit;
import org.eclipse.jst.j2ee.commonarchivecore.internal.Archive;
import org.eclipse.jst.j2ee.commonarchivecore.internal.exception.OpenFailureException;
import org.eclipse.jst.j2ee.commonarchivecore.internal.exception.SaveFailureException;
import org.eclipse.jst.j2ee.commonarchivecore.internal.strategy.ZipStreamSaveStrategyImpl;
import org.eclipse.jst.j2ee.componentcore.util.EARArtifactEdit;
import org.eclipse.jst.j2ee.ejb.componentcore.util.EJBArtifactEdit;
import org.eclipse.jst.j2ee.internal.project.J2EEProjectUtilities;
import org.eclipse.jst.j2ee.jca.modulecore.util.ConnectorArtifactEdit;
import org.eclipse.jst.j2ee.web.componentcore.util.WebArtifactEdit;

import com.ibm.ccl.soa.deploy.core.DomainPackager;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEDeployUtils;

public class IDEJ2EEDomainPackager extends DomainPackager {

	protected String getWorkspaceProjectName(Unit unit) {
		List artifacts = unit.getArtifacts();
		for (Iterator iter = artifacts.iterator(); iter.hasNext();) {
			FileArtifact artifact = (FileArtifact) iter.next();
			List fileURIs = artifact.getFileURIs();
			for (Iterator iterator = fileURIs.iterator(); iterator.hasNext();) {
				String fileURI = (String) iterator.next();
				if (fileURI != null) {
					return UnitUtil.getProjectName(fileURI);
				}
			}
		}
		return null;
	}

	public IProject getProject(Unit unit) {
		String projectName = getWorkspaceProjectName(unit);
		return null == projectName ? null : ProjectUtilities.getProject(projectName);
	}

	public InputStream export(Unit unit) {
		IProject project = getProject(unit);

		if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.WEB_FACET_ID)) {
			return getWebInputStream(project);
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EAR_FACET_ID)) {
			return getEarInputStream(project);
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EJB_FACET_ID)) {
			return getEjbInputStream(project);
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.APPCLIENT_FACET_ID)) {
			return getAppClientInputStream(project);
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JCA_FACET_ID)) {
			return getConnectorInputStream(project);
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JAVA_FACET_ID)) {
			return getUtilityInputStream(project);
		}
		assert false;
		return null;
	}

	protected InputStream getEjbInputStream(IProject project) {
		EJBArtifactEdit edit = null;
		try {
			edit = EJBArtifactEdit.getEJBArtifactEditForRead(project);
			Archive archive = edit.asArchive(false);
			return getInputStream(archive);
		} catch (OpenFailureException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		} finally {
			if (null != edit) {
				edit.dispose();
			}
		}
		return null;
	}

	protected InputStream getEarInputStream(IProject project) {
		EARArtifactEdit edit = null;
		try {
			edit = EARArtifactEdit.getEARArtifactEditForRead(project);
			Archive archive = edit.asArchive(false);
			return getInputStream(archive);
		} catch (OpenFailureException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		} finally {
			if (null != edit) {
				edit.dispose();
			}
		}
		return null;
	}

	protected InputStream getWebInputStream(IProject project) {
		WebArtifactEdit edit = null;
		try {
			edit = WebArtifactEdit.getWebArtifactEditForRead(project);
			Archive archive = edit.asArchive(false);
			return getInputStream(archive);
		} catch (OpenFailureException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		} finally {
			if (null != edit) {
				edit.dispose();
			}
		}
		return null;
	}

	protected InputStream getAppClientInputStream(IProject project) {
		AppClientArtifactEdit edit = null;
		try {
			edit = AppClientArtifactEdit.getAppClientArtifactEditForRead(project);
			Archive archive = edit.asArchive(false);
			return getInputStream(archive);
		} catch (OpenFailureException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		} finally {
			if (null != edit) {
				edit.dispose();
			}
		}
		return null;
	}

	protected InputStream getConnectorInputStream(IProject project) {
		ConnectorArtifactEdit edit = null;
		try {
			edit = ConnectorArtifactEdit.getConnectorArtifactEditForRead(project);
			Archive archive = edit.asArchive(false);
			return getInputStream(archive);
		} catch (OpenFailureException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		} finally {
			if (null != edit) {
				edit.dispose();
			}
		}
		return null;
	}

	protected InputStream getUtilityInputStream(IProject project) {
		try {
			Archive archive = J2EEProjectUtilities.asArchive(project.getLocationURI().toString(),
					project, false);
			return getInputStream(archive);
		} catch (OpenFailureException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		}
		return null;
	}

	protected InputStream getInputStream(Archive archive) {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		BufferedOutputStream buffOut = new BufferedOutputStream(byteOut);
		ZipStreamSaveStrategyImpl zipSaveStrategy = new ZipStreamSaveStrategyImpl(buffOut);
		try {
			archive.save(zipSaveStrategy);
			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			return new BufferedInputStream(byteIn);
		} catch (SaveFailureException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		}
		return null;
	}

	public String getExtension(Unit unit) {
		IProject project = getProject(unit);

		if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.WEB_FACET_ID)) {
			return "war"; //$NON-NLS-1$
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EAR_FACET_ID)) {
			return "ear"; //$NON-NLS-1$
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EJB_FACET_ID)) {
			return "jar"; //$NON-NLS-1$
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.APPCLIENT_FACET_ID)) {
			return "jar"; //$NON-NLS-1$
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JCA_FACET_ID)) {
			return "rar"; //$NON-NLS-1$
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JAVA_FACET_ID)) {
			return "jar"; //$NON-NLS-1$
		}
		assert false;
		return null;

	}

}
