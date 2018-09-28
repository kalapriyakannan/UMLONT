/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.saf.extension;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;

import com.ibm.ccl.soa.deploy.saf.handler.IServiceDescriptor;

/**
 * Provides a wrapper around the <tt>service</tt> element of the
 * <b>com.ibm.ccl.soa.deploy.saf.handlers</b> extension point.
 * 
 */
public class ServiceDescriptor extends CommonDescriptor implements ISAFExtensionConstants,
		IServiceDescriptor {

	private String serviceType;
	private String packageNamespace;
	private String eType;

	private EClass eClass;
	private boolean initFailed = false;

	/* package */ServiceDescriptor(IConfigurationElement config) {
		super(config);
		Assert.isTrue(TAG_SERVICE.equals(getElement().getName()));
		init();
	}

	private void init() {

		serviceType = getElement().getAttribute(ATTR_TYPE);
		Assert.isNotNull(serviceType);

		packageNamespace = getElement().getAttribute(ATTR_PACKAGE);
		Assert.isNotNull(packageNamespace);

		eType = getElement().getAttribute(ATTR_ETYPE);
		Assert.isNotNull(eType);
	}

	/**
	 * Return the fully qualified Java class name of this Service.
	 * 
	 * @return The fully qualified Java class name of this Service.
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * Return the EMF Short name of this class (equivalent to
	 * {@link ENamedElement#getName() EClass.getName()}, but does not force other plugins to load.)
	 * 
	 * @return The EMF Short name of this class
	 */
	public String getEType() {
		return eType;
	}

	/**
	 * Forces the resolution o the EClass. <b>WARNING: This method should be used sparingly as it
	 * forces the load of plugins.</b>
	 * 
	 * @return The resolved EClass or <b>null</b> if not available.
	 */
	public synchronized EClass resolveType() {
		if (eClass == null && !initFailed) {
			EPackage epkg = EPackage.Registry.INSTANCE.getEPackage(packageNamespace);
			if (epkg != null) {
				EClassifier classifier = epkg.getEClassifier(eType);
				if (classifier instanceof EClass) {
					eClass = (EClass) classifier;
				}
			}
			initFailed = eClass == null;
		}
		return eClass;
	}
}
