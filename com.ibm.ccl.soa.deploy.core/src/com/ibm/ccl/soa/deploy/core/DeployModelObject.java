/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deploy Model Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    Abstract parent type of all deployment types.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getAttributeMetaData <em>Attribute Meta Data</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getExtendedAttributes <em>Extended Attributes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getDescription <em>Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#isMutable <em>Mutable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObject()
 * @model abstract="true"
 *        features="artifactGroup artifacts constraintGroup constraints" 
 *        artifactGroupUnique="false" artifactGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" artifactGroupMany="true" artifactGroupSuppressedGetVisibility="true" artifactGroupSuppressedSetVisibility="true"
 *        artifactGroupExtendedMetaData="kind='group' name='artifact:group' namespace='##targetNamespace'"
 *        artifactsType="com.ibm.ccl.soa.deploy.core.Artifact" artifactsContainment="true" artifactsMany="true" artifactsTransient="true" artifactsVolatile="true" artifactsDerived="true" artifactsSuppressedGetVisibility="true" artifactsSuppressedSetVisibility="true"
 *        artifactsExtendedMetaData="kind='element' name='artifact' namespace='##targetNamespace' group='artifact:group'"
 *        constraintGroupUnique="false" constraintGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" constraintGroupMany="true" constraintGroupSuppressedGetVisibility="true" constraintGroupSuppressedSetVisibility="true"
 *        constraintGroupExtendedMetaData="kind='group' name='constraint:group' namespace='##targetNamespace'"
 *        constraintsType="com.ibm.ccl.soa.deploy.core.Constraint" constraintsContainment="true" constraintsMany="true" constraintsTransient="true" constraintsVolatile="true" constraintsDerived="true" constraintsSuppressedGetVisibility="true" constraintsSuppressedSetVisibility="true"
 *        constraintsExtendedMetaData="kind='element' name='constraint' namespace='##targetNamespace' group='constraint:group'"
 *        extendedMetaData="name='DeployModelObject' kind='elementOnly'"
 * @generated
 */
public interface DeployModelObject extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list. The
	 * list contents are of type {@link com.ibm.ccl.soa.deploy.core.Annotation}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * (Use SOA Deploy {@link Annotation}s instead of EMF EAnnotation for adding annotations).
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObject_Annotations()
	 * @model type="com.ibm.ccl.soa.deploy.core.Annotation" containment="true"
	 *        extendedMetaData="kind='element' name='annotation' namespace='##targetNamespace'"
	 * @generated
	 */
	List getAnnotations();

	/**
	 * Returns the value of the '<em><b>Attribute Meta Data</b></em>' containment reference
	 * list. The list contents are of type {@link com.ibm.ccl.soa.deploy.core.AttributeMetaData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Meta Data</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Used to add metadata, such as 'mutable=false' or password nature, to individual attributes of
	 * instances. The metadata applies to the attribute with the same EStructuralFeature.name as the
	 * AttributeMetaData.attributeName, or the same ExtendedAttribute.name.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Attribute Meta Data</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObject_AttributeMetaData()
	 * @model type="com.ibm.ccl.soa.deploy.core.AttributeMetaData" containment="true"
	 *        extendedMetaData="kind='element' name='attributeMetaData'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	List getAttributeMetaData();

	/**
	 * Returns the first attribute meta-data associated with the named attribute.
	 * 
	 * @param name
	 *           the EMF or extended attribute name.
	 * @return the attribute metadata, or null if not defined.
	 * 
	 * @see AttributeMetaData#getAttributeName()
	 */
	AttributeMetaData getAttributeMetaData(String name);

	/**
	 * Returns the value of the '<em><b>Extended Attributes</b></em>' containment reference
	 * list. The list contents are of type {@link com.ibm.ccl.soa.deploy.core.ExtendedAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Attributes</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Used to add attributes to instances that aren't in the schema. SOA Deploy treats the
	 * ExtendedAttributes as the equal of ordinary typed attributes in the GUI and validation logic.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Extended Attributes</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObject_ExtendedAttributes()
	 * @model type="com.ibm.ccl.soa.deploy.core.ExtendedAttribute" containment="true"
	 *        extendedMetaData="kind='element' name='extendedAttribute'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	List getExtendedAttributes();

	/**
	 * Returns the first extended attribute with the specified name.
	 * 
	 * @param name
	 *           the name that the extended attribute {@link ExtendedAttribute#getName()} must match.
	 * @return the first extended attribute with the specified name, or null if not found.
	 * @generated NOT
	 */
	ExtendedAttribute getExtendedAttribute(String name);

	/**
	 * Returns the <em>first</em> constraint whose name equals the argument, or null if none
	 * exists.
	 * 
	 * @param name
	 *           the name of a contained constraint.
	 * @return the <em>first</em> constraint of the specified name, or null.
	 * 
	 * @generated NOT
	 */
	Constraint getConstraint(String name);

	/**
	 * Return the {@link Annotation} element for the given DeployModelObject.
	 * 
	 * <p>
	 * The first {@link Annotation} element will be returned which matches the
	 * {@link Annotation#getContext()}.
	 * </p>
	 * 
	 * @param context -
	 *           The key used to obtain the correct {@link Annotation} element.
	 * @return The Annotation element matching the passed <code>context</code>.
	 * 
	 * @generated NOT
	 */
	Annotation findAnnotation(String context);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObject_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Display Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Name used on GUI labels and messages <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObject_DisplayName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='displayName'"
	 * @generated
	 */
	String getDisplayName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(String value);

	/**
	 * Returns the value of the '<em><b>Mutable</b></em>' attribute. The default value is
	 * <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutable</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> if false, object is considered to be read-only.
	 * if true, DeployModelObject is mutable iff all its parents have mutable=true <!-- end-model-doc
	 * -->
	 * 
	 * @return the value of the '<em>Mutable</em>' attribute.
	 * @see #isSetMutable()
	 * @see #unsetMutable()
	 * @see #setMutable(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObject_Mutable()
	 * @model default="true" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.Boolean" extendedMetaData="kind='attribute'
	 *        name='mutable'"
	 * @generated
	 */
	boolean isMutable();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#isMutable <em>Mutable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutable</em>' attribute.
	 * @see #isSetMutable()
	 * @see #unsetMutable()
	 * @see #isMutable()
	 * @generated
	 */
	void setMutable(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#isMutable <em>Mutable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMutable()
	 * @see #isMutable()
	 * @see #setMutable(boolean)
	 * @generated
	 */
	void unsetMutable();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#isMutable <em>Mutable</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mutable</em>' attribute is set.
	 * @see #unsetMutable()
	 * @see #isMutable()
	 * @see #setMutable(boolean)
	 * @generated
	 */
	boolean isSetMutable();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Internal 'anchor' for XML references. See
	 * {@link #displayName} for the name exposed in the UI. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObject_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.Constraint"
	 * @generated
	 */
	List getConstraints();

	/**
	 * Return the {@link EObject} representing this model object.
	 * 
	 * @return EObject
	 * @generated NOT
	 */
	EObject getEObject();

	/**
	 * @return the conceptual owning parent {@link DeployModelObject} of this
	 *         {@link DeployModelObject}.
	 * @generated NOT
	 */
	DeployModelObject getParent();

	/**
	 * Return an {@link IStatus} object that represents any error conditions that were detected with
	 * the model object.
	 * 
	 * @return an {@link IStatus} object.
	 * @generated NOT
	 */
	IStatus getStatus();

	/**
	 * A modeled object will not overwrite any existing status unless a client calls
	 * {@link #clearStatus()}. Whenever a client calls addStatus(), either the given aNewStatus is
	 * set as the status or the given aNewStatus is added to the existing MultiStatus. If there is an
	 * existing IStatus an it is not a MultiStatus then a new MultiStatus is created with the
	 * existing and the given aNewStatus as child elements. The resultant IStatus is returned.
	 * 
	 * @param aNewStatus
	 *           A status for this model object (could be warning, error, info, or OK)
	 * @return IStatus - The combined status after adding the given aNewStatus.
	 * @generated NOT
	 */
	IStatus addStatus(IStatus aNewStatus);

	/**
	 * Reset the status to just IStatus.OK
	 * 
	 * @generated NOT
	 */
	void clearStatus();

	/**
	 * This API is used to get the contained {@link DeployModelObject} objects.
	 * 
	 * @return an unmodifiable list of {@link DeployModelObject} elements.
	 * @generated NOT
	 */
	List getContainedModelObjects();

	/**
	 * Returns the topology object which directly or indirectly contains this deploy model object.
	 * 
	 * @return the topology that contains the object (directly or indirectly).
	 * @generated NOT
	 */
	public Topology getTopology();

	/**
	 * Returns the topology object which imports the topology of this unit.
	 * <p>
	 * The edit topology can used to add new units and links.
	 * 
	 * @return the topology object that imports this object (may be the same as the
	 *         {@link #getTopology()}.
	 */
	public Topology getEditTopology();

	/**
	 * Returns the full path of the deploy model object relative to its topology.
	 * <p>
	 * Paths are used when serializing link targets and error statuses. Examples include
	 * {@link DependencyLink#getTargetURI()}, {@link UnitLink#getTargetURI()},
	 * {@link ConstraintLink#getTargetURI()}.
	 * <p>
	 * The absolute path is composed listing the {@link DeployModelObject#getName()} of the object's
	 * containment path, separated by the '/' character. If a name is not valid or unique in its
	 * container, the index escape character '@' is used followed by the containment index. Examples:
	 * <ul>
	 * <li> "/unit1/req1/expr1" : an absolute path rooted in the topology, refers to requirement
	 * expression "expr1" contained in requirement "req1" which is contained in the topology-level
	 * unit "unit1".
	 * <li> "/unit1/@3/expr1": as in the previous example, but using the containment index of the
	 * requirement because its name is not unique.
	 * </ul>
	 * character to the
	 * <p>
	 * Equivalent to invoking {@link #getRelativePath(DeployModelObject)} on {@link #getTopology()}.
	 * 
	 * @return the path relative to the topology, or null if the object is not directly or indirectly
	 *         contained in a topology.
	 * @see #getRelativePath(DeployModelObject)
	 * @see #resolve(String)
	 * @generated NOT
	 */
	public String getFullPath();

	/**
	 * Returns the fully qualified name of the DeployModelObject including the name and namespace of
	 * the containing {@link Topology}.
	 * 
	 * @return
	 */
	public String getQualifiedName();

	/**
	 * Returns the path of the deploy model object relative to the specified object.
	 * 
	 * @param relativeObject
	 *           an object in the containment path of this object.
	 * 
	 * @return the path relative to the object, or null if the object is not directly or indirectly
	 *         contained the <Code>relativeObject</code>.
	 * @see #getFullPath()
	 * @see #resolve(String)
	 * @generated NOT
	 */
	public String getRelativePath(DeployModelObject relativeObject);

	/**
	 * Resolve the passed path to a {@link DeployModelObject}.
	 * <p>
	 * If the path is absolute then the resolution will take place from the {@link Topology}.
	 * Otherwise all resolutions will be relative to the object receiving the call.
	 * </p>
	 * 
	 * @param path -
	 *           The path to the {@link DeployModelObject}.
	 * @return a {@link DeployModelObject} or null if the resolution fails.
	 * 
	 * @see #getFullPath()
	 * @see #getRelativePath(DeployModelObject)
	 * @generated NOT
	 */
	public DeployModelObject resolve(String path);

	/**
	 * Returns the value of the '<em><b>Artifacts</b></em>' containment reference list. The list
	 * contents are of type {@link com.ibm.ccl.soa.deploy.core.Artifact}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifacts</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Artifacts</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit_Artifacts()
	 * @model type="com.ibm.ccl.soa.deploy.core.Artifact" containment="true" transient="true"
	 *        volatile="true" derived="true" extendedMetaData="kind='element' name='artifact'
	 *        namespace='##targetNamespace' group='artifact:group'"
	 * @generated NOT
	 */
	List getArtifacts();

	/**
	 * If the DeployModelObject is from an import, the result reflects the immutable exposure from
	 * the Imported {@link Topology}'s contract. If the DeployModelObject is local (contained by the
	 * current {@link Topology}, then this method always returns true.
	 * 
	 * 
	 * @return True if the DeployModelObject is itself <i>public</i> or contains one or more
	 *         <i>public-editable</i> attributes.
	 */
	public boolean isVisible();

	/**
	 * If the DeployModelObject is from an import, the result reflects the immutable exposure from
	 * the Imported {@link Topology}'s contract. If the DeployModelObject is local (contained by the
	 * current {@link Topology}, then this method always returns true.
	 * 
	 * <p>
	 * To determine of the DeployModelObject is <i>public</i> in the current {@link Topology}'s
	 * contract, use {@link Topology#getConfigurationContract()} and
	 * {@link Agreement#isPublic(DeployModelObject)}.
	 * </p>
	 * 
	 * @return True if the DeployModelObject is <i>public</i> (can be the source of links).
	 */
	public boolean isPublic();

	/**
	 * If the DeployModelObject is from an import, the result reflects the immutable exposure from
	 * the Imported {@link Topology}'s contract. If the DeployModelObject is local (contained by the
	 * current {@link Topology}, then this method always returns true.
	 * 
	 * <p>
	 * To determine of the DeployModelObject is <i>public-editable</i> in the current
	 * {@link Topology}'s contract, use {@link Topology#getConfigurationContract()} and
	 * {@link Agreement#isPublicEditable(DeployModelObject)}.
	 * </p>
	 * 
	 * @return True if the DeployModelObject is <i>public-editable</i> (can have augmented state
	 *         associated with it).
	 */
	public boolean isPublicEditable();

	/**
	 * If the DeployModelObject is from an import, the result reflects the immutable exposure from
	 * the Imported {@link Topology}'s contract. If the DeployModelObject is local (contained by the
	 * current {@link Topology}, then this method always returns true.
	 * 
	 * <p>
	 * To determine of the given property of this DeployModelObject is <i>public-editable</i> in the
	 * current {@link Topology}'s contract, use {@link Topology#getConfigurationContract()} and
	 * {@link Agreement#isPublicEditable(DeployModelObject, String)}.
	 * </p>
	 * 
	 * @param propertyName
	 *           The name of a property associated with this DeployModelObject.
	 * @return True if the given property of this DeployModelObject is <i>public-editable</i> (can
	 *         have augmented state associated with it).
	 */
	public boolean isPublicEditable(String propertyName);

} // DeployModelObject
