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

import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.util.FilterList;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAwareList;
import com.ibm.ccl.soa.deploy.internal.core.InternalDeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;
import com.ibm.ccl.soa.deploy.internal.core.validator.TopologyMarkerFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Model Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#getAnnotations <em>Annotations</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#getDescription <em>Description</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#getDisplayName <em>Display Name</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#isFrozen <em>Frozen</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#getManufacturer <em>Manufacturer</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#getName <em>Name</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @extends InternalDeployModelObject
 */
public class DeployModelObjectImpl extends EObjectImpl implements DeployModelObject,
		InternalDeployModelObject {
	protected static final int INVALID_CONTAINMENT_INDEX = -999;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList annotations;

	/**
	 * The cached value of the '{@link #getAttributeMetaData() <em>Attribute Meta Data</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributeMetaData()
	 * @generated
	 * @ordered
	 */
	protected EList attributeMetaData;

	/**
	 * The cached value of the '{@link #getExtendedAttributes() <em>Extended Attributes</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExtendedAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList extendedAttributes;

	/**
	 * The cached value of the '{@link #getArtifactGroup() <em>Artifact Group</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getArtifactGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap artifactGroup;

	/**
	 * The cached value of the '{@link #getConstraintGroup() <em>Constraint Group</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstraintGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap constraintGroup;

	/*
	 * <doc-ku> a slight of hand with the featuremap makes for some delectable code </doc-ku>
	 */
	private List artifacts;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isMutable() <em>Mutable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MUTABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMutable() <em>Mutable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMutable()
	 * @generated
	 * @ordered
	 */
	protected boolean mutable = MUTABLE_EDEFAULT;

	/**
	 * This is true if the Mutable attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean mutableESet;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * A field used to capture the current status of this model object.
	 */
	private IStatus status;

	/**
	 * FeatureAwareList containing constraints.
	 */
	private FeatureAwareList constraints;

	/**
	 * Transient unmodifiable list filtering DeployModelObjects in {@link #eContents()}
	 */
	protected List containedModelObjectList;

	private String resolvedPath;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DeployModelObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.DEPLOY_MODEL_OBJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList(Annotation.class, this,
					CorePackage.DEPLOY_MODEL_OBJECT__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getAttributeMetaData() {
		if (attributeMetaData == null) {
			attributeMetaData = new EObjectContainmentEList(AttributeMetaData.class, this,
					CorePackage.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA);
		}
		return attributeMetaData;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getConstraint(java.lang.String)
	 */
	public Constraint getConstraint(String name) {

		for (java.util.Iterator iter = getConstraints().iterator(); iter.hasNext();) {
			Constraint c = (Constraint) iter.next();
			if (name == null) {
				if (c.getName() == null) {
					return c;
				}
			} else {
				if (name.equals(c.getName())) {
					return c;
				}
			}
		}
		return null;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getAttributeMetaData(java.lang.String)
	 */
	public AttributeMetaData getAttributeMetaData(String name) {
		if (attributeMetaData == null || name == null) {
			return null;
		}
		for (Iterator iter = attributeMetaData.iterator(); iter.hasNext();) {
			AttributeMetaData data = (AttributeMetaData) iter.next();
			if (data != null && name.equals(data.getAttributeName())) {
				return data;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getExtendedAttributes() {
		if (extendedAttributes == null) {
			extendedAttributes = new EObjectContainmentEList(ExtendedAttribute.class, this,
					CorePackage.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES);
		}
		return extendedAttributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getArtifactGroup() {
		if (artifactGroup == null) {
			artifactGroup = new BasicFeatureMap(this, CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP);
		}
		return artifactGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getArtifactsGen() {
		return getArtifactGroup().list(CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.application.Module#getArtifacts()
	 */
	public List getArtifacts() {
		if (artifacts == null) {
			artifacts = new FeatureAwareList(CorePackage.eINSTANCE.getDeployModelObject_Artifacts(),
					(FeatureMap.Internal) getArtifactGroup());
		}
		return artifacts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getConstraintGroup() {
		if (constraintGroup == null) {
			constraintGroup = new BasicFeatureMap(this,
					CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP);
		}
		return constraintGroup;
	}

	/**
	 * <!-- begin-user-doc --> Returns the list of constraints defined on this DMO. <!-- end-user-doc
	 * -->
	 * 
	 * @generated NOT
	 */
	public List getConstraints() {
		return getConstraintsGen();

	}

	/**
	 * <!-- begin-user-doc --> Returns the list of constraints defined on this DMO. <!-- end-user-doc
	 * -->
	 * 
	 * @generated NOT
	 */
	public List getConstraintsGen() {
		if (constraints == null) {
			constraints = new FeatureAwareList(CorePackage.eINSTANCE
					.getDeployModelObject_Constraints(), (FeatureMap.Internal) getConstraintGroup());
		}
		return constraints;

	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getExtendedAttribute(java.lang.String)
	 */
	public ExtendedAttribute getExtendedAttribute(String name) {
		if (extendedAttributes == null || extendedAttributes.size() == 0) {
			return null;
		}
		for (Iterator iter = getExtendedAttributes().iterator(); iter.hasNext();) {
			ExtendedAttribute attr = (ExtendedAttribute) iter.next();
			if (name == null) {
				if (attr.getName() == null) {
					return attr;
				}
			} else if (name.equals(attr.getName())) {
				return attr;
			}
		}
		return null;
	}

	public Annotation findAnnotation(String context) {
		Annotation foundAnnotation = null;
		if (context == null || !getAnnotations().isEmpty()) {
			for (Iterator it = getAnnotations().iterator(); it.hasNext();) {
				Annotation annotation = (Annotation) it.next();
				if (context.equals(annotation.getContext())) {
					foundAnnotation = annotation;
					break;
				}
			}
		}
		return foundAnnotation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.DEPLOY_MODEL_OBJECT__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.DEPLOY_MODEL_OBJECT__DISPLAY_NAME, oldDisplayName, displayName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isMutable() {
		return mutable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMutable(boolean newMutable) {
		boolean oldMutable = mutable;
		mutable = newMutable;
		boolean oldMutableESet = mutableESet;
		mutableESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.DEPLOY_MODEL_OBJECT__MUTABLE, oldMutable, mutable, !oldMutableESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetMutable() {
		boolean oldMutable = mutable;
		boolean oldMutableESet = mutableESet;
		mutable = MUTABLE_EDEFAULT;
		mutableESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					CorePackage.DEPLOY_MODEL_OBJECT__MUTABLE, oldMutable, MUTABLE_EDEFAULT,
					oldMutableESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetMutable() {
		return mutableESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	public void setName(String newName) {
		releaseResolvedPath();
//		resolvedPath = null;
		EObject parent = eContainer();
		if (parent != null && parent instanceof InternalDeployModelObject) {
			((InternalDeployModelObject) parent).releaseResolvedPath();
		}

		setNameGen(newName);
	}

	@Override
	public NotificationChain eBasicSetContainer(InternalEObject newContainer,
			int newContainerFeatureID, NotificationChain msgs) {
		resolvedPath = null;
		return super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNameGen(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.DEPLOY_MODEL_OBJECT__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case CorePackage.DEPLOY_MODEL_OBJECT__ANNOTATIONS:
			return ((InternalEList) getAnnotations()).basicRemove(otherEnd, msgs);
		case CorePackage.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA:
			return ((InternalEList) getAttributeMetaData()).basicRemove(otherEnd, msgs);
		case CorePackage.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES:
			return ((InternalEList) getExtendedAttributes()).basicRemove(otherEnd, msgs);
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP:
			return ((InternalEList) getArtifactGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACTS:
			return ((InternalEList) getArtifacts()).basicRemove(otherEnd, msgs);
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP:
			return ((InternalEList) getConstraintGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINTS:
			return ((InternalEList) getConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case CorePackage.DEPLOY_MODEL_OBJECT__ANNOTATIONS:
			return getAnnotations();
		case CorePackage.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA:
			return getAttributeMetaData();
		case CorePackage.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES:
			return getExtendedAttributes();
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP:
			if (coreType) {
				return getArtifactGroup();
			}
			return ((FeatureMap.Internal) getArtifactGroup()).getWrapper();
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACTS:
			return getArtifacts();
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP:
			if (coreType) {
				return getConstraintGroup();
			}
			return ((FeatureMap.Internal) getConstraintGroup()).getWrapper();
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINTS:
			return getConstraints();
		case CorePackage.DEPLOY_MODEL_OBJECT__DESCRIPTION:
			return getDescription();
		case CorePackage.DEPLOY_MODEL_OBJECT__DISPLAY_NAME:
			return getDisplayName();
		case CorePackage.DEPLOY_MODEL_OBJECT__MUTABLE:
			return isMutable() ? Boolean.TRUE : Boolean.FALSE;
		case CorePackage.DEPLOY_MODEL_OBJECT__NAME:
			return getName();
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
		case CorePackage.DEPLOY_MODEL_OBJECT__ANNOTATIONS:
			getAnnotations().clear();
			getAnnotations().addAll((Collection) newValue);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA:
			getAttributeMetaData().clear();
			getAttributeMetaData().addAll((Collection) newValue);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES:
			getExtendedAttributes().clear();
			getExtendedAttributes().addAll((Collection) newValue);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP:
			((FeatureMap.Internal) getArtifactGroup()).set(newValue);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACTS:
			getArtifacts().clear();
			getArtifacts().addAll((Collection) newValue);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP:
			((FeatureMap.Internal) getConstraintGroup()).set(newValue);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINTS:
			getConstraints().clear();
			getConstraints().addAll((Collection) newValue);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__DISPLAY_NAME:
			setDisplayName((String) newValue);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__MUTABLE:
			setMutable(((Boolean) newValue).booleanValue());
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__NAME:
			setName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eOpenSet(EStructuralFeature feature, Object newValue) {

		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS == feature) {
			clearStatus(false);
			addStatus((IStatus) newValue);
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == feature) {
			return;
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES == feature) {
			return;
		}
		/*
		 * Check extended attributes first.
		 */
		if (feature instanceof ExtendedAttribute) {
			((ExtendedAttribute) feature).setValue(newValue);
		} else {
			super.eOpenSet(feature, newValue);
		}
	}

	@Override
	public Object eOpenGet(EStructuralFeature feature, boolean resolve) {
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS == feature) {
			return getStatus();
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == feature) {
			return null;
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES == feature) {
			return null;
		}
		/*
		 * Check extended attributes first.
		 */
		if (feature instanceof ExtendedAttribute) {
			return ((ExtendedAttribute) feature).getValue();
		} else {
			return super.eOpenGet(feature, resolve);
		}
	}

	@Override
	public void eOpenUnset(EStructuralFeature feature) {
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS == feature) {
			clearStatus();
			return;
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == feature) {
			return;
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES == feature) {
			return;
		}
		/*
		 * Check extended attributes first.
		 */
		if (feature instanceof ExtendedAttribute) {
			((ExtendedAttribute) feature).setValue(null);
		} else {
			super.eOpenUnset(feature);
		}
	}

	@Override
	public boolean eOpenIsSet(EStructuralFeature feature) {
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS == feature) {
			return getStatus().getChildren().length > 0;
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == feature) {
			return true;
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES == feature) {
			return true;
		}
		/*
		 * Check extended attributes first.
		 */
		if (feature instanceof ExtendedAttribute) {
			return ((ExtendedAttribute) feature).getValue() != null;
		} else {
			return super.eOpenIsSet(feature);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case CorePackage.DEPLOY_MODEL_OBJECT__ANNOTATIONS:
			getAnnotations().clear();
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA:
			getAttributeMetaData().clear();
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES:
			getExtendedAttributes().clear();
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP:
			getArtifactGroup().clear();
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACTS:
			getArtifacts().clear();
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP:
			getConstraintGroup().clear();
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINTS:
			getConstraints().clear();
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__DISPLAY_NAME:
			setDisplayName(DISPLAY_NAME_EDEFAULT);
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__MUTABLE:
			unsetMutable();
			return;
		case CorePackage.DEPLOY_MODEL_OBJECT__NAME:
			setName(NAME_EDEFAULT);
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
		case CorePackage.DEPLOY_MODEL_OBJECT__ANNOTATIONS:
			return annotations != null && !annotations.isEmpty();
		case CorePackage.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA:
			return attributeMetaData != null && !attributeMetaData.isEmpty();
		case CorePackage.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES:
			return extendedAttributes != null && !extendedAttributes.isEmpty();
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP:
			return artifactGroup != null && !artifactGroup.isEmpty();
		case CorePackage.DEPLOY_MODEL_OBJECT__ARTIFACTS:
			return !getArtifacts().isEmpty();
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP:
			return constraintGroup != null && !constraintGroup.isEmpty();
		case CorePackage.DEPLOY_MODEL_OBJECT__CONSTRAINTS:
			return !getConstraints().isEmpty();
		case CorePackage.DEPLOY_MODEL_OBJECT__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT
					.equals(description);
		case CorePackage.DEPLOY_MODEL_OBJECT__DISPLAY_NAME:
			return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT
					.equals(displayName);
		case CorePackage.DEPLOY_MODEL_OBJECT__MUTABLE:
			return isSetMutable();
		case CorePackage.DEPLOY_MODEL_OBJECT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer('\n');
		result.append(super.toString());
		result.append(" (" + getFullPath() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		result.append(" (artifactGroup: "); //$NON-NLS-1$
		result.append(artifactGroup);
		result.append(", constraintGroup: "); //$NON-NLS-1$
		result.append(constraintGroup);
		result.append(", description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", displayName: "); //$NON-NLS-1$
		result.append(displayName);
		result.append(", mutable: "); //$NON-NLS-1$
		if (mutableESet) {
			result.append(mutable);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

	public EObject getEObject() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getParent()
	 */
	public DeployModelObject getParent() {
		EObject container = eContainer();
		if (container != null) {
			if (container instanceof Augmentation) {
				EObject intercepted = ((Augmentation) container).eContainer();
				if (intercepted instanceof Instantiation) {
					return ((Instantiation) intercepted).getReferencedObject();
				}
			} else if (container instanceof Instantiation) {
				return ((Instantiation) container).getReferencedObject();
			} else if (container instanceof DeployModelObject) {
				return (DeployModelObject) container;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getParent()
	 */
	public InternalDeployModelObject getContaintmentParent() {
		EObject container = eContainer();
		return container != null && eContainer() instanceof InternalDeployModelObject ? (InternalDeployModelObject) container
				: null;
	}

	/**
	 * Generates {@link Notification#SET} events when {@link Status#OK_STATUS} event (null) is
	 * added-to, or a new {@link MultiStatus} is created, and {@link Notification#ADD} events when
	 * adding to existing MultiStatus.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#addStatus(org.eclipse.core.runtime.IStatus)
	 */
	public IStatus addStatus(IStatus aNewStatus) {
		if (aNewStatus != null) {
			if (status == null) {
				status = aNewStatus;
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.SET,
							CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS, Status.OK_STATUS, status));
				}
			} else {
				IStatus oldStatus = status;
				if (!status.isMultiStatus()) {
					status = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new IStatus[] { oldStatus,
							aNewStatus }, DeployCoreMessages.Model_consistency_status_message, null);
					if (eNotificationRequired()) {
						eNotify(new ENotificationImpl(this, Notification.ADD,
								CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS, oldStatus, status, 1));
					}
				} else {
					MultiStatus multiStatus = (MultiStatus) status;
					int index = multiStatus.getChildren().length;
					multiStatus.add(aNewStatus);
					if (eNotificationRequired()) {
						eNotify(new ENotificationImpl(this, Notification.ADD,
								CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS, oldStatus, status, index));
					}
				}
			}
		}
		return getStatus();
	}

	public void clearStatus() {
		clearStatus(true);
	}

	private void clearStatus(boolean withNotification) {
		IStatus oldStatus = status;
		status = null;
		if (withNotification && eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS, oldStatus, getStatus()));
		}
	}

	public IStatus getStatus() {
		return status == null ? Status.OK_STATUS : status;
	}

	/**
	 * Accepts only instances of {@link DeployModelObject}
	 */
	public static final IObjectFilter DEPLOY_MODEL_OBJECT_FILTER = new IObjectFilter() {
		public boolean accept(Object value) {
			if (value instanceof DeployModelObject) {
				return true;
			}
			return false;
		}
	};

	/*
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getContainedModelObjects()
	 */
	public List getContainedModelObjects() {
		if (containedModelObjectList == null) {
			containedModelObjectList = Collections.unmodifiableList(new FilterList(eContents(),
					DEPLOY_MODEL_OBJECT_FILTER));
		}
		return containedModelObjectList;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getTopology()
	 */
	public Topology getTopology() {
		InternalDeployModelObject object = this;
		while (object != null && !CorePackage.Literals.TOPOLOGY.isInstance(object)) {
			object = object.getContaintmentParent();
		}
		return (Topology) object;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getEditTopology()
	 */
	public Topology getEditTopology() {
		// Proxies can intercept this method and return the edit topology
		// In the case where the object is contained by a proxy, we can
		// get a proxy topology; so we call getEditTopology() on it for safety.
		Topology topology = getTopology();
		if (topology != null && Proxy.isProxyClass(topology.getClass())) {
			return topology.getEditTopology();
		}
		return topology;
	}

	public String getQualifiedName() {
		Topology container = getTopology();
		if (container != null) {
			return container.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR
					+ (name != null ? name : IConstants.EMPTY_STRING);
		}

		return getFullPath();

	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getFullPath()
	 */
	public String getFullPath() {

		EObject ancestor = this;
		while ((ancestor = ancestor.eContainer()) != null && !ancestor.eIsProxy()
				&& resolvedPath != null) {
			if (ancestor instanceof InternalDeployModelObject) {
				InternalDeployModelObject dmoancestor = (InternalDeployModelObject) ancestor;
				if (dmoancestor.getResolvedPath() == null) {
					resolvedPath = null;
				}
			}
		}

		if (resolvedPath == null) {
			resolvedPath = getRelativePath(null);
		}

		return resolvedPath;
	}

	/**
	 * Returns the <em>unique</em> name for the object for use in a path expression.
	 * <p>
	 * If {@link DeployModelObject#getName()} is not valid, or unique in the container, returns an
	 * escaped index name.
	 * 
	 * @param object
	 *           a deploy model object.
	 * @return the name of the object if valid and unique in container, or the escaped index.
	 */
	protected static String computeLocalPathName(InternalDeployModelObject object) {
		boolean useIndex = false;
		if (!TopologyMarkerFactory.isValidDeployModelObjectName(object.getName())) {
			useIndex = true;
		} else if (object.getContaintmentParent() == null) {
			useIndex = false;
		} else {
			for (Iterator iter = object.getContaintmentParent().getContainedModelObjects().iterator(); iter
					.hasNext();) {
				DeployModelObject cur = (DeployModelObject) iter.next();
				if (object != cur && object.getName().equals(cur.getName())) {
					useIndex = true;
					break;
				}
			}
		}
		if (useIndex) {
			int index = -1;
			if (object.getContaintmentParent() != null) {
				index = object.getContaintmentParent().getContainedModelObjects().indexOf(object);
			}
			return IConstants.INDEX_SEPARATOR + Integer.toString(index);
		}
		return object.getName();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#getRelativePath(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public final String getRelativePath(DeployModelObject relativeObject) {
		InternalDeployModelObject current = this;
		LinkedList list = new LinkedList();
		while (current != null && current != relativeObject && !(current instanceof Topology)) {
			list.addFirst(computeLocalPathName(current));
			current = (InternalDeployModelObject) current.getParent();
		}

		StringBuffer buffer = new StringBuffer();
		if (current != null && current instanceof Topology) {
			if (current != getEditTopology()) {
				buffer.append(((Topology) current).getQualifiedName()).append(
						IConstants.TOPOLOGY_SEPARATOR);
			}
		}

		if (relativeObject == null) {
			buffer.append(IConstants.PATH_SEPARATOR);
		}
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			buffer.append(name);
			if (iter.hasNext()) {
				buffer.append(IConstants.PATH_SEPARATOR);
			}
		}
		return buffer.toString();
	}

	public final DeployModelObject resolve(String path) {
		return resolve(path, (InternalScopeService) IScopeService.Locator.findScopeService(this));
	}

	public final DeployModelObject resolve(String path, InternalScopeService service) {
		if (path == null) {
			return null;
		}
		if (path.length() == 0) {
			return this;
		}

		int referencedTopologyIndx = path.indexOf(IConstants.TOPOLOGY_SEPARATOR);
		if (referencedTopologyIndx > -1) {
			// check for an instantiation
			DeployModelObject instantiation = resolveInstantiation(path);
			if (instantiation != null) {
				return instantiation;
			}
			String qualifiedTopology = path.substring(0, referencedTopologyIndx);
			if (isRemoteReference(qualifiedTopology)) {
				if (service != null) {
					return service.resolve(path);
				}
				// Cannot resolve namespace without scope service
				return null;
			}
			// invalid path
			if (referencedTopologyIndx < path.length()) {
				path = path.substring(referencedTopologyIndx + 1, path.length());
			} else {
				return null;
			}
		}

		// Examples: no quotes
		// - "/"
		// - "/foo"
		// - "/foo/bar"
		// - "//foo//bar" (redundant path separators)
		// - "/@2/bar"
		boolean isAbsolute = path.charAt(0) == IConstants.PATH_SEPARATOR;
		DeployModelObject context;
		if (isAbsolute) {
			context = getTopology();
		} else {
			context = this;
		}
		int index = isAbsolute ? 1 : 0;
		while (context != null && index < path.length()) {
			int nextIndex = path.indexOf(IConstants.PATH_SEPARATOR, index);
			if (nextIndex == -1) {
				nextIndex = path.length();
			}
			String localPath = path.substring(index, nextIndex);
			if (localPath.length() > 0) {
				boolean isIndex = localPath.charAt(0) == IConstants.INDEX_SEPARATOR;
				if (isIndex) {
					if (localPath.length() == 1) {
						context = null;
					} else {
						try {
							int containmentIndex = Integer.parseInt(localPath.substring(1));
							if (containmentIndex < 0
									|| containmentIndex >= context.getContainedModelObjects().size()) {
								context = null;
							} else {
								context = (DeployModelObject) context.getContainedModelObjects().get(
										containmentIndex);
							}
						} catch (NumberFormatException e) {
							context = null;
						}
					}
				} else {
					boolean found = false;
					for (Iterator iter = context.getContainedModelObjects().iterator(); iter.hasNext();) {
						DeployModelObject cur = (DeployModelObject) iter.next();
						if (localPath.equals(cur.getName())) {
							context = cur;
							found = true;
							break;
						}
					}
					if (!found) {
						context = null;
					}
				}
				if (context == null) {
					//if (resolveWhenErrorsExist) {
					// TODO don't know what type
					//return null;
					//}
					return null;
				}
			}
			index = nextIndex + 1;
		}
		return context;
	}

	private boolean isRemoteReference(String qualifiedTopology) {
		return getTopology() == null || !qualifiedTopology.equals(getTopology().getQualifiedName());
	}

	private DeployModelObject resolveInstantiation(String path) {
		int referencedTopologyIndx = path.indexOf(IConstants.TOPOLOGY_SEPARATOR);
		if (referencedTopologyIndx > -1) {
			String namespace = null;
			String pattern = null;
			String qualified = path.substring(0, referencedTopologyIndx);
			String referenced = path.substring(referencedTopologyIndx + 1, path.length());
//			String attribute = null;
			int attrIndx = referenced.indexOf(IConstants.ATTRIBUTE_SEPARATOR);
			if (attrIndx > -1) {
//				attribute = referenced.substring(attrIndx + 1, referenced.length());
				referenced = referenced.substring(0, attrIndx);
			}
			int namespaceIndx = qualified.lastIndexOf(IConstants.DOT_SEPARATOR);
			if (namespaceIndx > -1) {
				namespace = qualified.substring(0, namespaceIndx);
			} else {
				namespace = INamespaceElement.DEFAULT_NAMESPACE;
			}
			pattern = qualified.substring(namespaceIndx + 1, qualified.length());
			Import imported = getEditTopology().getImport(namespace, pattern);

			if (imported != null && imported.getInstanceConfiguration() != null) {
				IPath parsed = new Path(referenced);
				Instantiation instantiation = null;
				if (parsed.segmentCount() == 1) {
					instantiation = imported.getInstanceConfiguration().getInstantiation(
							parsed.toString());
					if (instantiation != null) {
						return instantiation.getReferencedObject();
					}
				} else {
					instantiation = imported.getInstanceConfiguration().getInstantiation(
							parsed.toString());
					while (instantiation == null && parsed.segmentCount() > 0) {
						parsed = parsed.removeLastSegments(1);
						instantiation = imported.getInstanceConfiguration().getInstantiation(
								parsed.toString());
					}
					if (instantiation != null) {
						IPath subparsed = new Path(referenced).removeFirstSegments(parsed.segmentCount());
						return instantiation.resolveReferenced(subparsed.toString());
					}
				}
			}
		}
		return null;
	}

	public boolean isVisible() {
		return true;
	}

	public boolean isPublic() {
		return true;
	}

	public boolean isPublicEditable() {
		return true;
	}

	public boolean isPublicEditable(String propertyName) {
		return true;
	}

	public String getResolvedPath() {
		return resolvedPath;
	}

	public void releaseResolvedPath() {
		if (resolvedPath != null) {
			resolvedPath = null;
		}
		for (Iterator<DeployModelObject> iter = getContainedModelObjects().iterator(); iter.hasNext();) {
			DeployModelObject dmo = iter.next();
			if (dmo instanceof InternalDeployModelObject) {
				((InternalDeployModelObject) dmo).releaseResolvedPath();
			}
		}
	}

} //DeployModelObjectImpl
