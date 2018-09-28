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

import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.EObjectTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.FilterList;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementImpl#getDependencyLinkGroup <em>Dependency Link Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementImpl#getLink <em>Link</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementImpl#getDmoType <em>Dmo Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementImpl#getLinkType <em>Link Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.RequirementImpl#getUse <em>Use</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpl extends DeployModelObjectImpl implements Requirement {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getDependencyLinkGroup() <em>Dependency Link Group</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDependencyLinkGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap dependencyLinkGroup;

	/**
	 * The default value of the '{@link #getDmoType() <em>Dmo Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDmoType()
	 * @generated
	 * @ordered
	 */
	protected static final QName DMO_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDmoType() <em>Dmo Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDmoType()
	 * @generated
	 * @ordered
	 */
	protected QName dmoType = DMO_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtends() <em>Extends</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected String extends_ = EXTENDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkType() <em>Link Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected static final RequirementLinkTypes LINK_TYPE_EDEFAULT = RequirementLinkTypes.DEPENDENCY_LITERAL;

	/**
	 * The cached value of the '{@link #getLinkType() <em>Link Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected RequirementLinkTypes linkType = LINK_TYPE_EDEFAULT;

	/**
	 * This is true if the Link Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean linkTypeESet;

	/**
	 * The default value of the '{@link #getUse() <em>Use</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUse()
	 * @generated
	 * @ordered
	 */
	protected static final RequirementUsage USE_EDEFAULT = RequirementUsage.REQUIRED_LITERAL;

	/**
	 * The cached value of the '{@link #getUse() <em>Use</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUse()
	 * @generated
	 * @ordered
	 */
	protected RequirementUsage use = USE_EDEFAULT;

	/**
	 * This is true if the Use attribute has been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean useESet;

	/** Transient cache of converting the {@link QualifiedName} {@link #dmoType} to an {@link EClass}. */
	protected EClass dmoEType = null;

	private List reqExpressions;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> Returns the list of Requirement Expression constraints, defined on
	 * this Requirement. <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List getExpressions() {
		if (reqExpressions == null) {
			reqExpressions = new FilterList((EList) getConstraints(),
					EObjectTypeFilter.REQ_EXPR_FILTER);
		}
		return reqExpressions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isVisible() {
		return super.isVisible();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isPublic() {
		return super.isPublic();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isPublicEditable() {
		return super.isPublicEditable();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getDependencyLinkGroup() {
		if (dependencyLinkGroup == null) {
			dependencyLinkGroup = new BasicFeatureMap(this, CorePackage.REQUIREMENT__DEPENDENCY_LINK_GROUP);
		}
		return dependencyLinkGroup;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Requirement#getExpression(java.lang.String)
	 */
	public RequirementExpression getExpression(String name) {

		for (java.util.Iterator iter = getExpressions().iterator(); iter.hasNext();) {
			RequirementExpression expr = (RequirementExpression) iter.next();
			if (name == null) {
				if (expr.getName() == null) {
					return expr;
				}
			} else {
				if (name.equals(expr.getName())) {
					return expr;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> Returns the link directly contained or contained in the adapted
	 * capability. <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public DependencyLink getLink() {
//		return (DependencyLink) getDependencyLinkGroup().get(CorePackage.Literals.REQUIREMENT__LINK,
//				true);
		if (getDependencyLinkGroup().size() > 0) {
			return (DependencyLink) getDependencyLinkGroup().getValue(0);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLink(DependencyLink newLink, NotificationChain msgs) {
		return ((FeatureMap.Internal)getDependencyLinkGroup()).basicAdd(CorePackage.Literals.REQUIREMENT__LINK, newLink, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(DependencyLink newLink) {
		((FeatureMap.Internal)getDependencyLinkGroup()).set(CorePackage.Literals.REQUIREMENT__LINK, newLink);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementLinkTypes getLinkType() {
		return linkType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkType(RequirementLinkTypes newLinkType) {
		RequirementLinkTypes oldLinkType = linkType;
		linkType = newLinkType == null ? LINK_TYPE_EDEFAULT : newLinkType;
		boolean oldLinkTypeESet = linkTypeESet;
		linkTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT__LINK_TYPE, oldLinkType, linkType, !oldLinkTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinkType() {
		RequirementLinkTypes oldLinkType = linkType;
		boolean oldLinkTypeESet = linkTypeESet;
		linkType = LINK_TYPE_EDEFAULT;
		linkTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.REQUIREMENT__LINK_TYPE, oldLinkType, LINK_TYPE_EDEFAULT, oldLinkTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinkType() {
		return linkTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementUsage getUse() {
		return use;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUse(RequirementUsage newUse) {
		RequirementUsage oldUse = use;
		use = newUse == null ? USE_EDEFAULT : newUse;
		boolean oldUseESet = useESet;
		useESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT__USE, oldUse, use, !oldUseESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUse() {
		RequirementUsage oldUse = use;
		boolean oldUseESet = useESet;
		use = USE_EDEFAULT;
		useESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.REQUIREMENT__USE, oldUse, USE_EDEFAULT, oldUseESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUse() {
		return useESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.REQUIREMENT__DEPENDENCY_LINK_GROUP:
				return ((InternalEList)getDependencyLinkGroup()).basicRemove(otherEnd, msgs);
			case CorePackage.REQUIREMENT__LINK:
				return basicSetLink(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * @return the deploy core root which is the root container, or null if not set
	 */
	protected DeployCoreRoot getDeployCoreRoot() {
		Topology top = getTopology();
		if (top == null) {
			return null;
		}

		if (top.getEObject().eContainer() instanceof DeployCoreRoot) {
			return (DeployCoreRoot) top.getEObject().eContainer();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public QName getDmoType() {
		return dmoType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDmoType(QName newDmoType) {
		QName oldDmoType = dmoType;
		dmoType = newDmoType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT__DMO_TYPE, oldDmoType, dmoType));
	}

	/*
	 * @see Requirement#getDmoEType()
	 */
	public EClass getDmoEType() {
		if (dmoEType != null) {
			return dmoEType;
		}

		if (dmoType == null) {
			return null;
		}

		try {
			dmoEType = deserializeCapabilityType(dmoType);
		} catch (RuntimeException e) {
			// Deserialization error masked.  Validators explicitely check by comparing
			// getDmoType() != null && getDmoEType() == null
			// This is consistent with our behavior when links cannot be dereferenced.
			dmoEType = null;
		}
		return dmoEType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(String newExtends) {
		String oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT__EXTENDS, oldExtends, extends_));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Requirement#setCapabilityEType(org.eclipse.emf.ecore.EClass)
	 *      @generated NOT
	 */
	public void setDmoEType(EClass type) {
		QName oldCapabilityType = dmoType;
		if (type == null) {
			dmoType = null;
			dmoEType = null;
		} else {
			dmoEType = type;
			EPackage epkg = type.getEPackage();
			dmoType = (QName) XMLTypeUtil.createQName(epkg.getNsURI(), ExtendedMetaData.INSTANCE
					.getName(type), epkg.getNsPrefix());
		}

		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.REQUIREMENT__DMO_TYPE,
					oldCapabilityType, dmoType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.REQUIREMENT__DEPENDENCY_LINK_GROUP:
				if (coreType) return getDependencyLinkGroup();
				return ((FeatureMap.Internal)getDependencyLinkGroup()).getWrapper();
			case CorePackage.REQUIREMENT__LINK:
				return getLink();
			case CorePackage.REQUIREMENT__DMO_TYPE:
				return getDmoType();
			case CorePackage.REQUIREMENT__EXTENDS:
				return getExtends();
			case CorePackage.REQUIREMENT__LINK_TYPE:
				return getLinkType();
			case CorePackage.REQUIREMENT__USE:
				return getUse();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.REQUIREMENT__DEPENDENCY_LINK_GROUP:
				((FeatureMap.Internal)getDependencyLinkGroup()).set(newValue);
				return;
			case CorePackage.REQUIREMENT__LINK:
				setLink((DependencyLink)newValue);
				return;
			case CorePackage.REQUIREMENT__DMO_TYPE:
				setDmoType((QName)newValue);
				return;
			case CorePackage.REQUIREMENT__EXTENDS:
				setExtends((String)newValue);
				return;
			case CorePackage.REQUIREMENT__LINK_TYPE:
				setLinkType((RequirementLinkTypes)newValue);
				return;
			case CorePackage.REQUIREMENT__USE:
				setUse((RequirementUsage)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.REQUIREMENT__DEPENDENCY_LINK_GROUP:
				getDependencyLinkGroup().clear();
				return;
			case CorePackage.REQUIREMENT__LINK:
				setLink((DependencyLink)null);
				return;
			case CorePackage.REQUIREMENT__DMO_TYPE:
				setDmoType(DMO_TYPE_EDEFAULT);
				return;
			case CorePackage.REQUIREMENT__EXTENDS:
				setExtends(EXTENDS_EDEFAULT);
				return;
			case CorePackage.REQUIREMENT__LINK_TYPE:
				unsetLinkType();
				return;
			case CorePackage.REQUIREMENT__USE:
				unsetUse();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.REQUIREMENT__DEPENDENCY_LINK_GROUP:
				return dependencyLinkGroup != null && !dependencyLinkGroup.isEmpty();
			case CorePackage.REQUIREMENT__LINK:
				return getLink() != null;
			case CorePackage.REQUIREMENT__DMO_TYPE:
				return DMO_TYPE_EDEFAULT == null ? dmoType != null : !DMO_TYPE_EDEFAULT.equals(dmoType);
			case CorePackage.REQUIREMENT__EXTENDS:
				return EXTENDS_EDEFAULT == null ? extends_ != null : !EXTENDS_EDEFAULT.equals(extends_);
			case CorePackage.REQUIREMENT__LINK_TYPE:
				return isSetLinkType();
			case CorePackage.REQUIREMENT__USE:
				return isSetUse();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dependencyLinkGroup: "); //$NON-NLS-1$
		result.append(dependencyLinkGroup);
		result.append(", dmoType: "); //$NON-NLS-1$
		result.append(dmoType);
		result.append(", extends: "); //$NON-NLS-1$
		result.append(extends_);
		result.append(", linkType: "); //$NON-NLS-1$
		if (linkTypeESet) result.append(linkType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", use: "); //$NON-NLS-1$
		if (useESet) result.append(use); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

	/**
	 * Deserializes the capability type QName.
	 * 
	 * @param obj
	 *           a serialized capability type QName.
	 * @return the deserialized EClass.
	 */
	protected EClass deserializeCapabilityType(Object obj) {
		assert obj != null;

		QName qName = (QName) obj;
		if (qName.getNamespaceURI() != null && qName.getNamespaceURI().length() > 0) {
			String packageURI = qName.getNamespaceURI();
			if (packageURI == null) {
				throw new RuntimeException(NLS.bind(DeployCoreMessages.Cannot_resolve_namespace_0,
						qName.getNamespaceURI()));
			}
			EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(packageURI);
			if (pkg == null) {
				throw new RuntimeException(NLS.bind(DeployCoreMessages.Cannot_resolve_namespace_0,
						packageURI));
			}
			return (EClass) pkg.getEClassifier(qName.getLocalPart());
		}
		return (EClass) CorePackage.eINSTANCE.getEClassifier(qName.getLocalPart());
	}

} //RequirementImpl
