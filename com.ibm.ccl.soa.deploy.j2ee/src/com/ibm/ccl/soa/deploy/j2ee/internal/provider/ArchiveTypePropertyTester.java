/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.provider;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.jst.j2ee.application.Application;
import org.eclipse.jst.j2ee.commonarchivecore.internal.ApplicationClientFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.Archive;
import org.eclipse.jst.j2ee.commonarchivecore.internal.CommonarchiveFactory;
import org.eclipse.jst.j2ee.commonarchivecore.internal.CommonarchivePackage;
import org.eclipse.jst.j2ee.commonarchivecore.internal.EARFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.EJBJarFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.WARFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.exception.OpenFailureException;
import org.eclipse.jst.j2ee.core.internal.plugin.CatalogJ2EEXmlDtDEntityResolver;
import org.eclipse.jst.j2ee.internal.xml.J2EEXmlDtDEntityResolver;
import org.eclipse.wst.common.internal.emf.resource.EMF2SAXRendererFactory;
import org.eclipse.wst.common.internal.emf.resource.RendererFactory;
import org.eclipse.wst.common.internal.emf.utilities.DOMUtilities;

import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployPlugin;

/**
 * A &lt;extension point="org.eclipse.core.expressions.propertyTesters"&gt;
 * 
 * @see J2EEModuleUnitProvider
 */
public class ArchiveTypePropertyTester extends PropertyTester {

	private final String property = "isSupportedArchive"; //$NON-NLS-1$
	private final String JAR_EXT = "jar"; //$NON-NLS-1$
	private final String WAR_EXT = "war"; //$NON-NLS-1$
	private final String EAR_EXT = "ear"; //$NON-NLS-1$
	private final String RAR_EXT = "rar"; //$NON-NLS-1$

	private String extension;

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (this.property.equals(property)) {
			if (receiver instanceof IFile) {
				IFile archive = (IFile) receiver;
				String uri = archive.getRawLocation().toOSString();
				extension = archive.getFileExtension();
				if (isArchive()) {

					//temp until we support version 5 
					CommonarchivePackage pkg = CommonarchivePackage.eINSTANCE;
					CommonarchiveFactory factory = pkg.getCommonarchiveFactory();
					Archive j2eearchive = null;
					String version = null;
					try {

						// Disable SSE renderer
						RendererFactory.setDefaultRendererFactory(EMF2SAXRendererFactory.INSTANCE);

						// Use CatalogJ2EEXmlDtDEntityResolver
						J2EEXmlDtDEntityResolver.INSTANCE = new CatalogJ2EEXmlDtDEntityResolver();
						DOMUtilities.setDefaultEntityResolver(J2EEXmlDtDEntityResolver.INSTANCE);
						j2eearchive = factory.openArchive(uri);
						// investigate post rsa 7.5 using this api for j2ee 5.0 support
						/*
						 * try { IPath path = archive.getLocation(); IArchive arch =
						 * IArchiveFactory.INSTANCE.openArchive(path); arch.getArchiveOptions().setOption(
						 * JavaEEArchiveUtilities.DISCRIMINATE_EJB_ANNOTATIONS, Boolean.TRUE);
						 * arch.setPath(path); JavaEEQuickPeek peek = JavaEEArchiveUtilities.INSTANCE
						 * .getJavaEEQuickPeek(arch);
						 * 
						 * //JavaEEQuickPeek jqp =
						 * JavaEEArchiveUtilities.INSTANCE.getJavaEEQuickPeek(archive); peek.getVersion(); }
						 * catch (ArchiveOpenFailureException e) { // TODO Auto-generated catch block
						 * e.printStackTrace(); }
						 */
						if (extension.equals(EAR_EXT)) {
							if (j2eearchive.isEARFile()) {
								EARFile earFile = (EARFile) j2eearchive;
								Application app = earFile.getDeploymentDescriptor();
								if (app != null) {
									version = earFile.getDeploymentDescriptor().getVersion();
								}
							} else {
								version = J2EEVersionConstants.VERSION_1_5_TEXT;
							}

						} else if (j2eearchive.isEJBJarFile()) {
							EJBJarFile ejbJar = (EJBJarFile) j2eearchive;
							version = ejbJar.getDeploymentDescriptor().getVersion();
						} else if (j2eearchive.isWARFile()) {
							WARFile warFile = (WARFile) j2eearchive;
							version = warFile.getDeploymentDescriptor().getVersion();
						} else if (j2eearchive.isApplicationClientFile()) {
							ApplicationClientFile appClientFile = (ApplicationClientFile) archive;
							version = appClientFile.getDeploymentDescriptor().getVersion();
						}

					} catch (OpenFailureException e) {

						J2EEDeployPlugin.logError(0, e.getMessage(), e);

					} finally {
						if (version != null
								&& (version.equals(J2EEVersionConstants.VERSION_1_5_TEXT) || version
										.equals("5"))) { //$NON-NLS-1$
							return false;
						}
						if (extension.equals(JAR_EXT) || extension.equals(WAR_EXT)
								|| extension.equals(RAR_EXT) || extension.equals(EAR_EXT)) {
							return true;
						}
						if (null != j2eearchive) {
							j2eearchive.close();
						}
					}

				}
			}
		}
		return false;
	}

	private boolean isArchive() {

		if (extension != null
				&& (extension.equals(JAR_EXT) || extension.equals(WAR_EXT) || extension.equals(RAR_EXT) || extension
						.equals(EAR_EXT))) {
			return true;
		}
		return false;
	}
}
