/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Deployment Manager Port Names</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDeploymentManagerPortNames()
 * @model extendedMetaData="name='WasDeploymentManagerPortNames'"
 * @generated
 */
public final class WasDeploymentManagerPortNames extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Bootstrap Address</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bootstrap Address</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOTSTRAP_ADDRESS_LITERAL
	 * @model name="bootstrapAddress" literal="bootstrap_address"
	 * @generated
	 * @ordered
	 */
	public static final int BOOTSTRAP_ADDRESS = 0;

	/**
	 * The '<em><b>Cell Discovery Address</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cell Discovery Address</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CELL_DISCOVERY_ADDRESS_LITERAL
	 * @model name="cellDiscoveryAddress" literal="cell_discovery_address"
	 * @generated
	 * @ordered
	 */
	public static final int CELL_DISCOVERY_ADDRESS = 1;

	/**
	 * The '<em><b>Csiv2 Ssl Mutualauth Listener Address</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Csiv2 Ssl Mutualauth Listener Address</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL
	 * @model name="csiv2SslMutualauthListenerAddress"
	 *        literal="csiv2_ssl_mutualauth_listener_address"
	 * @generated
	 * @ordered
	 */
	public static final int CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS = 2;

	/**
	 * The '<em><b>Csiv2 Ssl Serverauth Listener Address</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Csiv2 Ssl Serverauth Listener Address</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL
	 * @model name="csiv2SslServerauthListenerAddress"
	 *        literal="csiv2_ssl_serverauth_listener_address"
	 * @generated
	 * @ordered
	 */
	public static final int CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS = 3;

	/**
	 * The '<em><b>Dcs Unicast Address</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Dcs Unicast Address</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DCS_UNICAST_ADDRESS_LITERAL
	 * @model name="dcsUnicastAddress" literal="dcs_unicast_address"
	 * @generated
	 * @ordered
	 */
	public static final int DCS_UNICAST_ADDRESS = 4;

	/**
	 * The '<em><b>Orb Listener Address</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Orb Listener Address</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORB_LISTENER_ADDRESS_LITERAL
	 * @model name="orbListenerAddress" literal="orb_listener_address"
	 * @generated
	 * @ordered
	 */
	public static final int ORB_LISTENER_ADDRESS = 5;

	/**
	 * The '<em><b>Sas Ssl Serverauth Listener Address</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sas Ssl Serverauth Listener Address</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SAS_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL
	 * @model name="sasSslServerauthListenerAddress" literal="sas_ssl_serverauth_listener_address"
	 * @generated
	 * @ordered
	 */
	public static final int SAS_SSL_SERVERAUTH_LISTENER_ADDRESS = 6;

	/**
	 * The '<em><b>Soap Connector Address</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Soap Connector Address</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAP_CONNECTOR_ADDRESS_LITERAL
	 * @model name="soapConnectorAddress" literal="soap_connector_address"
	 * @generated
	 * @ordered
	 */
	public static final int SOAP_CONNECTOR_ADDRESS = 7;

	/**
	 * The '<em><b>Wc Adminhost</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WC Adminhost</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WC_ADMINHOST_LITERAL
	 * @model name="wcAdminhost" literal="wc_adminhost"
	 * @generated
	 * @ordered
	 */
	public static final int WC_ADMINHOST = 8;

	/**
	 * The '<em><b>Wc Adminhost Secure</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WC Adminhost Secure</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WC_ADMINHOST_SECURE_LITERAL
	 * @model name="wcAdminhostSecure" literal="wc_adminhost_secure"
	 * @generated
	 * @ordered
	 */
	public static final int WC_ADMINHOST_SECURE = 9;

	/**
	 * The '<em><b>Bootstrap Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #BOOTSTRAP_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames BOOTSTRAP_ADDRESS_LITERAL = new WasDeploymentManagerPortNames(BOOTSTRAP_ADDRESS, "bootstrapAddress", "bootstrap_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Cell Discovery Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #CELL_DISCOVERY_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames CELL_DISCOVERY_ADDRESS_LITERAL = new WasDeploymentManagerPortNames(CELL_DISCOVERY_ADDRESS, "cellDiscoveryAddress", "cell_discovery_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Csiv2 Ssl Mutualauth Listener Address</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL = new WasDeploymentManagerPortNames(CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS, "csiv2SslMutualauthListenerAddress", "csiv2_ssl_mutualauth_listener_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Csiv2 Ssl Serverauth Listener Address</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL = new WasDeploymentManagerPortNames(CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS, "csiv2SslServerauthListenerAddress", "csiv2_ssl_serverauth_listener_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Dcs Unicast Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #DCS_UNICAST_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames DCS_UNICAST_ADDRESS_LITERAL = new WasDeploymentManagerPortNames(DCS_UNICAST_ADDRESS, "dcsUnicastAddress", "dcs_unicast_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Orb Listener Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ORB_LISTENER_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames ORB_LISTENER_ADDRESS_LITERAL = new WasDeploymentManagerPortNames(ORB_LISTENER_ADDRESS, "orbListenerAddress", "orb_listener_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Sas Ssl Serverauth Listener Address</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SAS_SSL_SERVERAUTH_LISTENER_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames SAS_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL = new WasDeploymentManagerPortNames(SAS_SSL_SERVERAUTH_LISTENER_ADDRESS, "sasSslServerauthListenerAddress", "sas_ssl_serverauth_listener_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Soap Connector Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SOAP_CONNECTOR_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames SOAP_CONNECTOR_ADDRESS_LITERAL = new WasDeploymentManagerPortNames(SOAP_CONNECTOR_ADDRESS, "soapConnectorAddress", "soap_connector_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Wc Adminhost</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #WC_ADMINHOST
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames WC_ADMINHOST_LITERAL = new WasDeploymentManagerPortNames(WC_ADMINHOST, "wcAdminhost", "wc_adminhost"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Wc Adminhost Secure</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #WC_ADMINHOST_SECURE
	 * @generated
	 * @ordered
	 */
	public static final WasDeploymentManagerPortNames WC_ADMINHOST_SECURE_LITERAL = new WasDeploymentManagerPortNames(WC_ADMINHOST_SECURE, "wcAdminhostSecure", "wc_adminhost_secure"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Deployment Manager Port Names</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WasDeploymentManagerPortNames[] VALUES_ARRAY = new WasDeploymentManagerPortNames[] {
			BOOTSTRAP_ADDRESS_LITERAL,
			CELL_DISCOVERY_ADDRESS_LITERAL,
			CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL,
			CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL,
			DCS_UNICAST_ADDRESS_LITERAL,
			ORB_LISTENER_ADDRESS_LITERAL,
			SAS_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL,
			SOAP_CONNECTOR_ADDRESS_LITERAL,
			WC_ADMINHOST_LITERAL,
			WC_ADMINHOST_SECURE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Deployment Manager Port Names</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Deployment Manager Port Names</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasDeploymentManagerPortNames get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasDeploymentManagerPortNames result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Deployment Manager Port Names</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasDeploymentManagerPortNames getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasDeploymentManagerPortNames result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Deployment Manager Port Names</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasDeploymentManagerPortNames get(int value) {
		switch (value) {
			case BOOTSTRAP_ADDRESS: return BOOTSTRAP_ADDRESS_LITERAL;
			case CELL_DISCOVERY_ADDRESS: return CELL_DISCOVERY_ADDRESS_LITERAL;
			case CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS: return CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL;
			case CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS: return CSIV2_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL;
			case DCS_UNICAST_ADDRESS: return DCS_UNICAST_ADDRESS_LITERAL;
			case ORB_LISTENER_ADDRESS: return ORB_LISTENER_ADDRESS_LITERAL;
			case SAS_SSL_SERVERAUTH_LISTENER_ADDRESS: return SAS_SSL_SERVERAUTH_LISTENER_ADDRESS_LITERAL;
			case SOAP_CONNECTOR_ADDRESS: return SOAP_CONNECTOR_ADDRESS_LITERAL;
			case WC_ADMINHOST: return WC_ADMINHOST_LITERAL;
			case WC_ADMINHOST_SECURE: return WC_ADMINHOST_SECURE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasDeploymentManagerPortNames(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasDeploymentManagerPortNames
