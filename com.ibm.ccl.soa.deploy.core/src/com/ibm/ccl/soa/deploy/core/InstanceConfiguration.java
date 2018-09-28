package com.ibm.ccl.soa.deploy.core;

import java.util.List;

/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
public interface InstanceConfiguration extends DeployModelObject, Agreement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Instantiations</b></em>' containment reference list. The
	 * list contents are of type {@link com.ibm.ccl.soa.deploy.core.Instantiation}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instantiations</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getInstanceConfiguration_Instantiations()
	 * @model type="com.ibm.ccl.soa.deploy.core.Instantiation" containment="true"
	 *        extendedMetaData="kind='element' name='instantiation' namespace='##targetNamespace'"
	 * @generated
	 */
	List getInstantiations();

	/**
	 * The {@link #getURI} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
	 */
	int INSTANCECONFIGURATION__UNITS = 1;

	/**
	 * Returns the value of the '<em><b>Imported</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.ibm.ccl.soa.deploy.core.Import#getInstanceConfiguration <em>Instance Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported</em>' container reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported</em>' container reference.
	 * @see #setImported(Import)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getInstanceConfiguration_Imported()
	 * @see com.ibm.ccl.soa.deploy.core.Import#getInstanceConfiguration
	 * @model opposite="instanceConfiguration"
	 * @generated
	 */
	Import getImported();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.InstanceConfiguration#getImported <em>Imported</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported</em>' container reference.
	 * @see #getImported()
	 * @generated
	 */
	void setImported(Import value);

	/**
	 * Configure the given <i>source</i>'s <i>field</i> with the given <i>value</i>.
	 * 
	 * @param source
	 * @param field
	 * @param value
	 */
	void configure(DeployModelObject source, String field, Object value);

	/**
	 * Remove the configured value for the given <i>source</i>'s <i>field</i>.
	 * 
	 * @param source
	 * @param field
	 */
	void deconfigure(DeployModelObject source, String field);

	/**
	 * Return the configured value for the given <i>source</i>'s <i>field</i>.
	 * 
	 * @param source
	 *           The source from a read-only Topology
	 * @param field
	 *           The name of a field on the source that may have a configured value.
	 * 
	 * @return A configured vaue or <b>null</b> if one does not exist.
	 */
	Object getConfiguredValue(DeployModelObject source, String field);

	/**
	 * An {@link Instantiation} manages customized state for an imported {@link Unit}.
	 * 
	 * @param referenced
	 *           The simple name ({@link DeployModelObject#getName()} of the DeployModelObject in
	 *           the imported Topology (not the full path).
	 * @return The Instantiation associated with the referenced Unit, or null if none exists.
	 */
	Instantiation getInstantiation(String referenced);

	/**
	 * Instantiate a state management object for the given referenced name. In particular,
	 * modifications that result from this method do *not* generate EMF events.
	 * 
	 * @param referenced
	 *           The simple name ({@link DeployModelObject#getName()} of the Unit in the imported
	 *           Topology (not the full path).
	 * @return The new Instantiation associated with the referenced Unit, or an existing one if it
	 *         has already been created.
	 */
	Instantiation instantiate(String referenced);

}
