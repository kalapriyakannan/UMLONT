/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeploymentImpl.java,v 1.2 2007/10/10 20:13:27 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.Deployment;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet;
import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.DeploymentImpl#getFacet <em>Facet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeploymentImpl extends CapabilityImpl implements Deployment {
	/**
	 * The default value of the '{@link #getFacet() <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacet()
	 * @generated
	 * @ordered
	 */
	protected static final DeploymentUnitFacet FACET_EDEFAULT = DeploymentUnitFacet.UNDEFINED_LITERAL;

	/**
	 * The cached value of the '{@link #getFacet() <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacet()
	 * @generated
	 * @ordered
	 */
	protected DeploymentUnitFacet facet = FACET_EDEFAULT;

	/**
	 * This is true if the Facet attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean facetESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.DEPLOYMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentUnitFacet getFacet() {
		return facet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacet(DeploymentUnitFacet newFacet) {
		DeploymentUnitFacet oldFacet = facet;
		facet = newFacet == null ? FACET_EDEFAULT : newFacet;
		boolean oldFacetESet = facetESet;
		facetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.DEPLOYMENT__FACET, oldFacet, facet, !oldFacetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFacet() {
		DeploymentUnitFacet oldFacet = facet;
		boolean oldFacetESet = facetESet;
		facet = FACET_EDEFAULT;
		facetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AnalysisPackage.DEPLOYMENT__FACET, oldFacet, FACET_EDEFAULT, oldFacetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFacet() {
		return facetESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.DEPLOYMENT__FACET:
				return getFacet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnalysisPackage.DEPLOYMENT__FACET:
				setFacet((DeploymentUnitFacet)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case AnalysisPackage.DEPLOYMENT__FACET:
				unsetFacet();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AnalysisPackage.DEPLOYMENT__FACET:
				return isSetFacet();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (facet: "); //$NON-NLS-1$
		if (facetESet) result.append(facet); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //DeploymentImpl
