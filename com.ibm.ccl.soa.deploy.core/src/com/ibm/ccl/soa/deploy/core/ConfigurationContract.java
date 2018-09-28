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

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * 
 * A contract <b>exports</b> {@link Unit units}, {@link Capability capabilities}, and
 * {@link Requirement requirements} or some combination of specific features as either <i>private</i>,
 * <i>public</i>, or <i>public-editable</i>.
 * 
 * <p>
 * The <i>contract visibility</i> determines whether a {@link DeployModelObject} may be (1) the
 * source or target of a link, or (2) modified by an importing {@link Topology}. Contracts work
 * with {@link Import Imports} to establish encapsulated, reusable, configurable {@link Topologies}
 * to share amongst different interested parties.
 * </p>
 * 
 * <p>
 * There are a few basic permissions:
 * <ul>
 * <li>A. Change the value of an(a) attribute(s)</li>
 * <li>B. Declare the model element as the source of a link</li>
 * <li>C. Declare the model element as the target of a link</li>
 * <li>D. Add a {@link Capability} to the {@link Unit}</li>
 * <li>E. Add a {@link Requirement} to the {@link Unit}</li>
 * </ul>
 * </p>
 * 
 * <table border="0">
 * <tr>
 * <td width="30%"> <b>Type</b> </td>
 * <td width="30%"> <b>Visibility</b> </td>
 * <td width="40%"> <b>Permissions</b> </td>
 * <!----------- Unit -----------------> </tr>
 * <tr>
 * <td width="30%">Unit</td>
 * <td> <table border="0">
 * <tr>
 * <td width="50%"><i>private</i></td>
 * <td width="50%"><b>{ }</b></td>
 * </tr>
 * <tr>
 * <td width="50%"><i>public</i></td>
 * <td width="50%"><b>{B, C, E}</b></td>
 * </tr>
 * <tr>
 * <td width="50%"><i>public-editable</i></td>
 * <td width="50%"><b>{A, B, C, D, E}</b></td>
 * </tr>
 * </table> </td>
 * </tr>
 * <!----------- Capability / Requirement ----------------->
 * <tr>
 * <td width="30%">Capability or Requirement</td>
 * <td> <table border="0">
 * <tr>
 * <td width="50%"><i>private</i></td>
 * <td width="50%"><b>{ }</b></td>
 * </tr>
 * <tr>
 * <td width="50%"><i>public</i></td>
 * <td width="50%"><b>{B, C}</b></td>
 * </tr>
 * <tr>
 * <td width="50%"><i>public-editable</i></td>
 * <td width="50%"><b>{A, B, C}</b></td>
 * </tr>
 * </table> </td>
 * </tr>
 * </table>
 * 
 * <p>
 * In addition, the following rules apply:
 * <ol>
 * <li>Individual features may be <b>exported</b>,</li>
 * <li>Contained elements inherit the <i>contract visibility</i> of their container, and</li>
 * <li>The most specific <i>contract visibility</i> rule applies. </li>
 * </ol>
 * </p>
 * 
 * <p>
 * For example, if a {@link Unit} is <i>private</i>, and one of its attributes,
 * {@link Capability capabilities}, or {@link Requirement requirements} is <b>exported</b> as
 * <i>public</i> or <i>public-editable</i>, then the {@link Unit} remains <i>private</i>. If the
 * {@link Unit} is <i>public-editable</i>, then any attribute not explicitly marked <i>private</i>
 * is also <i>public-editable</i>.
 * </p>
 * 
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * 
 * A representation of the content that can be exposed by this topology upon import by another
 * topology.
 * 
 * <!-- end-model-doc -->
 * 
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getConfigurationContract()
 * @model extendedMetaData="name='ConfigurationContract' kind='elementOnly'"
 * @extends Agreement
 */
public interface ConfigurationContract extends DeployModelObject, Agreement {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Export the given object in the contract and indicate whether the given object should be
	 * editable when imported. When the source is editable, any feature it contains may be modified
	 * by the importing {@link Topology}, unless more specific contract rules have been applied
	 * (e.g., the feature is explicitly <i>private</i>).
	 * 
	 * <p>
	 * If the source is <i>private</i> with this method is called with <b>true</b>, it will be
	 * <i>public-editable</i> when the method returns.
	 * </p>
	 * <p>
	 * If the source is <i>private</i> with this method is called with <b>false</b>, it will be
	 * <i>public</i> when the method returns.
	 * </p>
	 * <p>
	 * If the source is <i>public</i> with this method is called with <b>true</b>, it will be
	 * <i>public-editable</i> when the method returns.
	 * </p>
	 * <p>
	 * If the source is <i>public-editable</i> with this method is called with <b>false</b>, it
	 * will be <i>public-editable</i> when the method returns.
	 * </p>
	 * 
	 * @param source
	 *           The DeployModelObject to expose in the contract.
	 * @param editable
	 *           True indicates the given source and its features may be modified by
	 *           {@link Topology topologies} that import the {@link Topology} that contains the
	 *           source.
	 */
	public void export(DeployModelObject source, boolean editable);

	/**
	 * Export the given feature of the source in the contract. When the feature is editable, it may
	 * be modified by the importing {@link Topology}. The source will retain its initial contract
	 * visibility; if the source is <i>private</i> when this method is called, it will be <i>private</i>
	 * when this method returns, but it will be returned from {@link Agreement#getPublicUnits()} as
	 * it has a <i>public-editable</i> feature.
	 * 
	 * <p>
	 * The source will retain its contract visibility. If it is <i>private</i> when this method is
	 * called, it will be <i>private</i> when the method returns.
	 * </p>
	 * 
	 * @param source
	 *           The DeployModelObject of the property to expose in the contract.
	 * @param feature
	 *           The feature of a specific property to export. (e.g.
	 *           {@link CorePackage#getCommunicationCapability_ApplicationLayerProtocol()}).
	 */
	public void export(DeployModelObject source, EStructuralFeature feature);

	/**
	 * Export the given feature of the source in the contract. When the feature is editable, it may
	 * be modified by the importing {@link Topology}. The source will retain its initial contract
	 * visibility; if the source is <i>private</i> when this method is called, it will be <i>private</i>
	 * when this method returns, but it will be returned from {@link Agreement#getPublicUnits()} as
	 * it has a <i>public-editable</i> feature.
	 * 
	 * @param source
	 *           The DeployModelObject to expose in the contract.
	 * @param propertyName
	 *           The feature of a specific property to export.
	 */
	public void export(DeployModelObject source, String propertyName);

	/**
	 * Declare a property with the given name in the contract. Clients may refer to the variable
	 * using "$propertyname" in their attribute values.
	 * 
	 * @param propertyName
	 *           The designation of the property.
	 * @return The property that was created or found with the given name.
	 * @see Agreement#getProperty(String)
	 */
	public Property exportProperty(String propertyName);

	/**
	 * Remove the export of the given object in the contract. Any more specific contract rules will
	 * remain. If a specific attribute of the source is marked as <i>public-editable</i>, it will
	 * remain so after this method returns.
	 * <p>
	 * Depending on the implementation of the contract, this may or may not formally remove all
	 * metadata associated with the source. See {@link #clear(DeployModelObject)} to ensure all
	 * metadata is removed.
	 * </p>
	 * 
	 * @param source
	 *           The DeployModelObject to remove from the contract.
	 */
	public void unexport(DeployModelObject source);

	/**
	 * Remove the export of the given feature of the source object from the contract. If source has
	 * other <i>contract visibility</i> rules, those will remain in tact.
	 * 
	 * @param source
	 *           The DeployModelObject of the property to remove from the contract.
	 * @param feature
	 *           The feature of a specific property to export. (e.g.
	 *           {@link CorePackage#getCommunicationCapability_ApplicationLayerProtocol()}).
	 */
	public void unexport(DeployModelObject source, EStructuralFeature feature);

	/**
	 * Remove the export of the given feature of the source object from the contract. If source has
	 * other <i>contract visibility</i> rules, those will remain in tact.
	 * 
	 * @param source
	 *           The DeployModelObject of the property to remove from the contract.
	 * @param propertyName
	 *           The feature of a specific property to remove from the export.
	 */
	public void unexport(DeployModelObject source, String propertyName);

	/**
	 * Remove the declaration of a property with the given name in the contract.
	 * 
	 * @param propertyName
	 *           The name of a global property (variable) in the Topology.
	 */
	public void unexportProperty(String propertyName);

	/**
	 * Remove all metadata stored in the contract related to the given source. The result will resent
	 * the given source to the default behavior of the contract implementation.
	 * 
	 * @param source
	 *           The DeployModelObject to remove from the contract.
	 */
	public void clear(DeployModelObject source);

	/**
	 * Returns the value of the '<em><b>Default Conceptual Policy</b></em>' attribute. The
	 * default value is <code>"private"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.core.Visibility}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Conceptual Policy</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default Conceptual Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 */
	Visibility getDefaultConceptualPolicy();

	/**
	 * Returns the value of the '<em><b>Default Policy</b></em>' attribute. The default value is
	 * <code>"private"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.core.Visibility}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Policy</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 */
	Visibility getDefaultPolicy();

} // ConfigurationContract
