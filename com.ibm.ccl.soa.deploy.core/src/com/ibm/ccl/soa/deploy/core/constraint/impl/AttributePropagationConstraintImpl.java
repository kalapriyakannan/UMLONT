/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: AttributePropagationConstraintImpl.java,v 1.8 2008/04/23 19:19:59 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.constraints.AttributePropagationConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.constraints.StatusInOutParameter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Propagation Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributePropagationConstraintImpl#isRespectLinkDirection <em>Respect Link Direction</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributePropagationConstraintImpl#getSourceAttributeName <em>Source Attribute Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributePropagationConstraintImpl#getSourceObjectURI <em>Source Object URI</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributePropagationConstraintImpl#getTargetAttributeName <em>Target Attribute Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributePropagationConstraintImpl#getTargetObjectURI <em>Target Object URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributePropagationConstraintImpl extends ConstraintImpl implements
		AttributePropagationConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isRespectLinkDirection() <em>Respect Link Direction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isRespectLinkDirection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESPECT_LINK_DIRECTION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRespectLinkDirection() <em>Respect Link Direction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isRespectLinkDirection()
	 * @generated
	 * @ordered
	 */
	protected boolean respectLinkDirection = RESPECT_LINK_DIRECTION_EDEFAULT;

	/**
	 * This is true if the Respect Link Direction attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean respectLinkDirectionESet;

	/**
	 * The default value of the '{@link #getSourceAttributeName() <em>Source Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceAttributeName() <em>Source Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String sourceAttributeName = SOURCE_ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceObjectURI() <em>Source Object URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceObjectURI()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_OBJECT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceObjectURI() <em>Source Object URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceObjectURI()
	 * @generated
	 * @ordered
	 */
	protected String sourceObjectURI = SOURCE_OBJECT_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetAttributeName() <em>Target Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetAttributeName() <em>Target Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String targetAttributeName = TARGET_ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetObjectURI() <em>Target Object URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetObjectURI()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_OBJECT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetObjectURI() <em>Target Object URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetObjectURI()
	 * @generated
	 * @ordered
	 */
	protected String targetObjectURI = TARGET_OBJECT_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributePropagationConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.ATTRIBUTE_PROPAGATION_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRespectLinkDirection() {
		return respectLinkDirection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRespectLinkDirection(boolean newRespectLinkDirection) {
		boolean oldRespectLinkDirection = respectLinkDirection;
		respectLinkDirection = newRespectLinkDirection;
		boolean oldRespectLinkDirectionESet = respectLinkDirectionESet;
		respectLinkDirectionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__RESPECT_LINK_DIRECTION, oldRespectLinkDirection, respectLinkDirection, !oldRespectLinkDirectionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRespectLinkDirection() {
		boolean oldRespectLinkDirection = respectLinkDirection;
		boolean oldRespectLinkDirectionESet = respectLinkDirectionESet;
		respectLinkDirection = RESPECT_LINK_DIRECTION_EDEFAULT;
		respectLinkDirectionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__RESPECT_LINK_DIRECTION, oldRespectLinkDirection, RESPECT_LINK_DIRECTION_EDEFAULT, oldRespectLinkDirectionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRespectLinkDirection() {
		return respectLinkDirectionESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceAttributeName() {
		return sourceAttributeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceAttributeName(String newSourceAttributeName) {
		String oldSourceAttributeName = sourceAttributeName;
		sourceAttributeName = newSourceAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_ATTRIBUTE_NAME, oldSourceAttributeName, sourceAttributeName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceObjectURI() {
		return sourceObjectURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceObjectURI(String newSourceObjectURI) {
		String oldSourceObjectURI = sourceObjectURI;
		sourceObjectURI = newSourceObjectURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_OBJECT_URI, oldSourceObjectURI, sourceObjectURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetAttributeName() {
		return targetAttributeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetAttributeName(String newTargetAttributeName) {
		String oldTargetAttributeName = targetAttributeName;
		targetAttributeName = newTargetAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_ATTRIBUTE_NAME, oldTargetAttributeName, targetAttributeName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetObjectURI() {
		return targetObjectURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetObjectURI(String newTargetObjectURI) {
		String oldTargetObjectURI = targetObjectURI;
		targetObjectURI = newTargetObjectURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_OBJECT_URI, oldTargetObjectURI, targetObjectURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__RESPECT_LINK_DIRECTION:
				return isRespectLinkDirection() ? Boolean.TRUE : Boolean.FALSE;
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_ATTRIBUTE_NAME:
				return getSourceAttributeName();
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_OBJECT_URI:
				return getSourceObjectURI();
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_ATTRIBUTE_NAME:
				return getTargetAttributeName();
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_OBJECT_URI:
				return getTargetObjectURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__RESPECT_LINK_DIRECTION:
				setRespectLinkDirection(((Boolean)newValue).booleanValue());
				return;
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_ATTRIBUTE_NAME:
				setSourceAttributeName((String)newValue);
				return;
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_OBJECT_URI:
				setSourceObjectURI((String)newValue);
				return;
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_ATTRIBUTE_NAME:
				setTargetAttributeName((String)newValue);
				return;
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_OBJECT_URI:
				setTargetObjectURI((String)newValue);
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
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__RESPECT_LINK_DIRECTION:
				unsetRespectLinkDirection();
				return;
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_ATTRIBUTE_NAME:
				setSourceAttributeName(SOURCE_ATTRIBUTE_NAME_EDEFAULT);
				return;
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_OBJECT_URI:
				setSourceObjectURI(SOURCE_OBJECT_URI_EDEFAULT);
				return;
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_ATTRIBUTE_NAME:
				setTargetAttributeName(TARGET_ATTRIBUTE_NAME_EDEFAULT);
				return;
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_OBJECT_URI:
				setTargetObjectURI(TARGET_OBJECT_URI_EDEFAULT);
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
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__RESPECT_LINK_DIRECTION:
				return isSetRespectLinkDirection();
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_ATTRIBUTE_NAME:
				return SOURCE_ATTRIBUTE_NAME_EDEFAULT == null ? sourceAttributeName != null : !SOURCE_ATTRIBUTE_NAME_EDEFAULT.equals(sourceAttributeName);
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_OBJECT_URI:
				return SOURCE_OBJECT_URI_EDEFAULT == null ? sourceObjectURI != null : !SOURCE_OBJECT_URI_EDEFAULT.equals(sourceObjectURI);
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_ATTRIBUTE_NAME:
				return TARGET_ATTRIBUTE_NAME_EDEFAULT == null ? targetAttributeName != null : !TARGET_ATTRIBUTE_NAME_EDEFAULT.equals(targetAttributeName);
			case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_OBJECT_URI:
				return TARGET_OBJECT_URI_EDEFAULT == null ? targetObjectURI != null : !TARGET_OBJECT_URI_EDEFAULT.equals(targetObjectURI);
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
		result.append(" (respectLinkDirection: "); //$NON-NLS-1$
		if (respectLinkDirectionESet) result.append(respectLinkDirection); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", sourceAttributeName: "); //$NON-NLS-1$
		result.append(sourceAttributeName);
		result.append(", sourceObjectURI: "); //$NON-NLS-1$
		result.append(sourceObjectURI);
		result.append(", targetAttributeName: "); //$NON-NLS-1$
		result.append(targetAttributeName);
		result.append(", targetObjectURI: "); //$NON-NLS-1$
		result.append(targetObjectURI);
		result.append(')');
		return result.toString();
	}

	/**
	 * Returns the List of source DMOs, taking into account the 'respectLinkDirection' attribute of
	 * the constraint.
	 * 
	 * The List is never NULL. The list may be empty, if the source object is not known yet, or if an
	 * error occured while trying to compute the source object. In most cases there will be no more
	 * than one object in the list, however in some cases (for example when the constraint is defined
	 * on a MEMBER Requirement), the list may contain more that one DMO.
	 * 
	 * @return the List of source DMOs
	 * 
	 * @generated NOT
	 */
	public List<DeployModelObject> getSourceObjects() {
		DeployModelObject context = ConstraintUtil.getExpectedContext(this);
		if (context == null) {
			return Collections.emptyList();
		}
		StatusInOutParameter outStatus = new StatusInOutParameter();
		return AttributePropagationConstraintValidator.getSourceObjects(this, context, outStatus);
	}

	/**
	 * Returns the List of target DMOs, taking into account the 'respectLinkDirection' attribute of
	 * the constraint.
	 * 
	 * The List is never NULL. The list may be empty, if the target object is not known yet, or if an
	 * error occured while trying to compute the target object. In most cases there will be no more
	 * than one object in the list, however in some cases (for example when the constraint is defined
	 * on a MEMBER Requirement), the list may contain more that one DMO.
	 * 
	 * @return the List of target DMOs
	 * 
	 * @generated NOT
	 */
	public List<DeployModelObject> getTargetObjects() {
		DeployModelObject context = ConstraintUtil.getExpectedContext(this);
		if (context == null) {
			return Collections.emptyList();
		}
		StatusInOutParameter outStatus = new StatusInOutParameter();
		return AttributePropagationConstraintValidator.getTargetObjects(this, context, outStatus);
	}

	/**
	 * Returns the List of BASE source DMOs (as defined in the documentation to the constraint, see
	 * above), taking into account the 'respectLinkDirection' attribute of the constraint.
	 * 
	 * The List is never NULL. The list may be empty, if the source object is not known yet, or if an
	 * error occured while trying to compute the source object. In most cases there will be no more
	 * than one object in the list, however in some cases (for example when the constraint is defined
	 * on a MEMBER Requirement), the list may contain more that one DMO.
	 * 
	 * @return the list of base source DMOs
	 * 
	 * @generated NOT
	 */
	public List<DeployModelObject> getBaseSourceObjects() {
		DeployModelObject context = ConstraintUtil.getExpectedContext(this);
		if (context == null) {
			return Collections.emptyList();
		}
		StatusInOutParameter outStatus = new StatusInOutParameter();
		if (respectLinkDirection) {
			return AttributePropagationConstraintValidator.getBaseSourceObjects(this, context,
					outStatus);
		} else {
			return AttributePropagationConstraintValidator.getBaseTargetObjects(this, context,
					outStatus);
		}
	}

	/**
	 * Returns the List of BASE target DMOs (as defined in the documentation to the constraint, see
	 * above), taking into account the 'respectLinkDirection' attribute of the constraint.
	 * 
	 * The List is never NULL. The list may be empty, if the target object is not known yet, or if an
	 * error occured while trying to compute the target object. In most cases there will be no more
	 * than one object in the list, however in some cases (for example when the constraint is defined
	 * on a MEMBER Requirement), the list may contain more that one DMO.
	 * 
	 * @return the list of base target DMOs
	 * 
	 * @generated NOT
	 */
	public List<DeployModelObject> getBaseTargetObjects() {
		DeployModelObject context = ConstraintUtil.getExpectedContext(this);
		if (context == null) {
			return Collections.emptyList();
		}
		StatusInOutParameter outStatus = new StatusInOutParameter();
		if (respectLinkDirection) {
			return AttributePropagationConstraintValidator.getBaseTargetObjects(this, context,
					outStatus);
		} else {
			return AttributePropagationConstraintValidator.getBaseSourceObjects(this, context,
					outStatus);
		}
	}

} //AttributePropagationConstraintImpl
