/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: AttributePropagationConstraint.java,v 1.6 2008/06/18 22:19:10 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attribute Propagation Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			A constraint that propagates an attribute value from one Topology Model object to another.
 * 			<p>
 * 			The constraint context determines the base source and the base target objects for the attribute propagation,
 * 			as described in the following table.
 * 			</p>
 * 			<p>
 * 			<table>
 * 			<tr>
 * 			<th>Context</th>
 *         <th>Base Source</th>
 *         <th>Base Target</th>
 * 			</tr>
 * 			<tr>
 * 			<td>Dependency link</td>
 *         <td>Link source's (i.e., requirement's) unit</td>
 *         <td>Link target (capability)</td>
 * 			</tr>
 * 			<tr>
 * 			<td>Other deploy link</td>
 *         <td>Link source</td>
 *         <td>Link target</td>
 * 			</tr>
 * 			<tr>
 * 			<td>Requirement</td>
 *         <td>Requirement unit</td>
 *         <td>Requirement-associated link peer.
 * 			   <p>The link peer is defined per {@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes} type:
 * 			   <ul>
 * 			   <li>{@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes#DEPENDENCY}: dependency link target capability.</li>
 * 			   <li>{@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes#HOSTING}: hosting link source (host) units.</li>
 * 			   <li>{@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes#MEMBER}: member links are from group to member.
 * 			   If {@link com.ibm.ccl.soa.deploy.core.Unit#isGroup()} then the peers are the member link targets, otherwise it
 * 			   is the member link sources.</li>
 * 			   <li>{@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes#ANY}: undefined (validation indicates as an error).</li>.
 * 			   </ul>
 * 			   </p>
 *         </td>
 * 			</tr>
 * 			<tr>
 * 			<td>Other object</td>
 *         <td>Context object</td>
 *         <td>Context object</td>
 * 			</tr>
 * 			</table>
 * 			</p>
 * 			<p>
 * 			The {@link #isRespectLinkDirection()} is false, then the computed source and target objects are
 * 			swapped.
 * 			</p>
 * 			<p>
 * 			The constraint further supports navigation from the computed base source and base target objects
 * 			using the attributes {@link #getSourceObjectURI()} and {@link #getTargetObjectURI()}.  Their value is used
 * 			compute the source and target objects by using {@link com.ibm.ccl.soa.deploy.core.DeployModelObject#resolve(String)}.
 * 			The navigation can be relative path ({@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getRelativePath(com.ibm.ccl.soa.deploy.core.DeployModelObject)}),
 * 			or an absolute path ({@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getFullPath()}).
 * 			</p>
 * 			<p>
 * 			Once the source and target objects have been computed, the attributes which are propagated from/to are
 * 			identified using {@link #getSourceAttributeName()}, and {@link #getTargetAttributeName()}. 
 * 			</p>
 * 			<p>
 * 			Certain placement of the constraint (e.g., on a MEMBER Requirement) makes possible several DMOs 
 * 			as source or target objects. In this case, the validation logic enforces pair-wise propagation 
 * 			between every source and every target. If there is more than one source, and the values of 
 * 			the attributes are different, there will be a conflict.
 * 			</p>
 * 			<p>
 * 			The attribute propagation logic implements a flexible equality comparison.  {@link Object#equals(Object} is relaxed
 * 			as follows:
 * 			<ul>
 * 			<li> Null is treated as equal to an empty string </li>
 * 			<li> If the two endpoints are not assignable, then their string representations are also compared.  This allows one
 * 			     to propagate an {@link Integer} value	into a {@link String} value by invoking {@link Integer#toString()} to convert.</li>
 * 			</ul>
 * 			</p>
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getSourceAttributeName <em>Source Attribute Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getSourceObjectURI <em>Source Object URI</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getTargetAttributeName <em>Target Attribute Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getTargetObjectURI <em>Target Object URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributePropagationConstraint()
 * @model extendedMetaData="name='AttributePropagationConstraint' kind='elementOnly'"
 * @generated
 */
public interface AttributePropagationConstraint extends Constraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Respect Link Direction</b></em>' attribute. The default
	 * value is <code>"true"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc -->
	 * 
	 * True if the link direction should specify the propagation direction, false otherwise.
	 * <p>
	 * Applicable if the constraint is defined over a {@link com.ibm.ccl.soa.deploy.core.Requirement}
	 * or an {@link com.ibm.ccl.soa.deploy.core.DeployLink}. If the value is set to true, then the
	 * context or implied context link's direction specifies the propagation direction. Otherwise the
	 * reverse direction is used.
	 * </p>
	 * <p>
	 * For example, dependency links typically are used to express a propagation from the target
	 * capability to a capability of the requirement's unit. In such cases, the link direction is
	 * reverse to the propagation direction, and the value of this attribute will be false.
	 * </p>
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Respect Link Direction</em>' attribute.
	 * @see #isSetRespectLinkDirection()
	 * @see #unsetRespectLinkDirection()
	 * @see #setRespectLinkDirection(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributePropagationConstraint_RespectLinkDirection()
	 * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='respectLinkDirection'"
	 * @generated
	 */
	boolean isRespectLinkDirection();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Respect Link Direction</em>' attribute.
	 * @see #isSetRespectLinkDirection()
	 * @see #unsetRespectLinkDirection()
	 * @see #isRespectLinkDirection()
	 * @generated
	 */
	void setRespectLinkDirection(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetRespectLinkDirection()
	 * @see #isRespectLinkDirection()
	 * @see #setRespectLinkDirection(boolean)
	 * @generated
	 */
	void unsetRespectLinkDirection();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Respect Link Direction</em>' attribute is set.
	 * @see #unsetRespectLinkDirection()
	 * @see #isRespectLinkDirection()
	 * @see #setRespectLinkDirection(boolean)
	 * @generated
	 */
	boolean isSetRespectLinkDirection();

	/**
	 * Returns the value of the '<em><b>Source Attribute Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Name of the source
	 * attribute.
	 * <p>
	 * The name may refer to a static XSD/EMF attribute, or an
	 * {@link com.ibm.ccl.soa.deploy.core.ExtendedAttribute}.
	 * </p>
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Source Attribute Name</em>' attribute.
	 * @see #setSourceAttributeName(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributePropagationConstraint_SourceAttributeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='sourceAttributeName'"
	 * @generated
	 */
	String getSourceAttributeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getSourceAttributeName <em>Source Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Attribute Name</em>' attribute.
	 * @see #getSourceAttributeName()
	 * @generated
	 */
	void setSourceAttributeName(String value);

	/**
	 * Returns the value of the '<em><b>Source Object URI</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Optional relative or
	 * absolute path from the computed base source of the propagation constraint.
	 * <p>
	 * If this attribute is not set, then the base rules for evaluating the attribute propagation
	 * source, as described in the class documentation ({@link AttributePropagationConstraint}).
	 * </p>
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Source Object URI</em>' attribute.
	 * @see #setSourceObjectURI(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributePropagationConstraint_SourceObjectURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" extendedMetaData="kind='attribute'
	 *        name='sourceObjectURI'"
	 * @generated
	 */
	String getSourceObjectURI();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getSourceObjectURI <em>Source Object URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Object URI</em>' attribute.
	 * @see #getSourceObjectURI()
	 * @generated
	 */
	void setSourceObjectURI(String value);

	/**
	 * Returns the value of the '<em><b>Target Attribute Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Name of the target
	 * attribute.
	 * <p>
	 * The name may refer to a static XSD/EMF attribute, or an
	 * {@link com.ibm.ccl.soa.deploy.core.ExtendedAttribute}.
	 * </p>
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Target Attribute Name</em>' attribute.
	 * @see #setTargetAttributeName(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributePropagationConstraint_TargetAttributeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='targetAttributeName'"
	 * @generated
	 */
	String getTargetAttributeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getTargetAttributeName <em>Target Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute Name</em>' attribute.
	 * @see #getTargetAttributeName()
	 * @generated
	 */
	void setTargetAttributeName(String value);

	/**
	 * Returns the value of the '<em><b>Target Object URI</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Optional relative or
	 * absolute path from the computed base target of the propagation constraint.
	 * <p>
	 * If this attribute is not set, then the base rules for evaluating the attribute propagation
	 * target, as described in the class documentation ({@link AttributePropagationConstraint}).
	 * </p>
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Target Object URI</em>' attribute.
	 * @see #setTargetObjectURI(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributePropagationConstraint_TargetObjectURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" extendedMetaData="kind='attribute'
	 *        name='targetObjectURI'"
	 * @generated
	 */
	String getTargetObjectURI();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getTargetObjectURI <em>Target Object URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Object URI</em>' attribute.
	 * @see #getTargetObjectURI()
	 * @generated
	 */
	void setTargetObjectURI(String value);

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
	public List<DeployModelObject> getSourceObjects();

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
	public List<DeployModelObject> getTargetObjects();

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
	public List<DeployModelObject> getBaseSourceObjects();

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
	public List<DeployModelObject> getBaseTargetObjects();

} // AttributePropagationConstraint
