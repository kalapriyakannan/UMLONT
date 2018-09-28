/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.locationbinding.LocationBindingService;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>File Artifact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.FileArtifactImpl#getFileURIs <em>File UR Is</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FileArtifactImpl extends ArtifactImpl implements FileArtifact {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$
	protected List resolvedFileURIs = null;
	protected boolean isFileURIListResolved = true;
	private ArtifactKey key;

	public class ArtifactKey {

		public String getArtifactName() {
			return getName();
		}

		public List getArtifactFileURis() {
			return getFileURIs();
		}

		public String getArtifactFullPath() {
			return getFullPath();
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || obj.getClass() != this.getClass()) {
				return false;
			}

			ArtifactKey fileArtifact = (ArtifactKey) obj;
			if (!fileArtifact.getArtifactName().equals(name)) {
				return false;
			}

			List list = fileArtifact.getArtifactFileURis();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				String uri = (String) iterator.next();
				if (getFileURIs().contains(uri)) {
					return true;
				}
			}
			return super.equals(obj);
		}

		@Override
		public int hashCode() {
			int hash = 7;
			int hashCode = 31 * hash + (null == getFileURIs() ? 0 : getFileURIs().size());
			return hashCode;
		}

	}

	/**
	 * The cached value of the '{@link #getFileURIs() <em>File UR Is</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFileURIs()
	 * @generated
	 * @ordered
	 */
	protected EList fileURIs;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FileArtifactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.FILE_ARTIFACT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getFileURIsGen() {
		if (fileURIs == null) {
			fileURIs = new EDataTypeEList(String.class, this, CorePackage.FILE_ARTIFACT__FILE_UR_IS);
		}
		return fileURIs;
	}

	/**
	 * The list of file URI's for this file artifact. If there is a location binding usage, then the
	 * file URI location is resolved from the location binding resource, otherwise, the fileURI's are
	 * inlined.
	 * 
	 * @return the location binding aware list of file URI's
	 */
	public List getFileURIs() {
		if (!LocationBindingService.INSTANCE.isLocationBindingUsage(eResource())) {
//			System.out.println(getDisplayName() + " doesn't think the location binding service is enabled."); //$NON-NLS-1$
			isFileURIListResolved = false;
			return getFileURIsGen();
		} else if (resolvedFileURIs == null) {
			Resource.Internal res = (Resource.Internal) eResource();
			if (res == null || res.isLoading()) {
				return getFileURIsGen();
			}

			boolean deliver = eDeliver();
			try {
				// this isn't a true modification
				eSetDeliver(false);
				if (resolvedFileURIs == null) {
					Collection collection = getFileURIsGen();
					resolvedFileURIs = new EDataTypeEList(String.class, this,
							CorePackage.FILE_ARTIFACT__FILE_UR_IS);
					if (!isFileURIListResolved) {
						for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
							resolvedFileURIs.add(iterator.next());
						}
						isFileURIListResolved = true;
						return resolvedFileURIs;
					}
				}
				LocationBindingService.INSTANCE.resolvedBindingEntries(resolvedFileURIs, this);
			} finally {
				eSetDeliver(deliver);
			}
		}
//		else {
//			System.out.println(getDisplayName() + " didn't try to resolve the bindings from the service."); //$NON-NLS-1$
//		}
		return resolvedFileURIs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case CorePackage.FILE_ARTIFACT__FILE_UR_IS:
			return getFileURIs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case CorePackage.FILE_ARTIFACT__FILE_UR_IS:
			getFileURIs().clear();
			getFileURIs().addAll((Collection) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case CorePackage.FILE_ARTIFACT__FILE_UR_IS:
			getFileURIs().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case CorePackage.FILE_ARTIFACT__FILE_UR_IS:
			return fileURIs != null && !fileURIs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileURIs: "); //$NON-NLS-1$
		result.append(fileURIs);
		result.append(')');
		return result.toString();
	}

	@Override
	public Object getKey() {
		if (null == key) {
			key = new ArtifactKey();
		}
		return key;
	}

} //FileArtifactImpl
