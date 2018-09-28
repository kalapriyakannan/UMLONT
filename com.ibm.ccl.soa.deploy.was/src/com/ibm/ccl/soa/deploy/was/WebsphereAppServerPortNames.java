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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Websphere App Server Port Names</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWebsphereAppServerPortNames()
 * @model extendedMetaData="name='WebsphereAppServerPortNames'"
 * @generated
 */
public final class WebsphereAppServerPortNames extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

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
	public static final int DCS_UNICAST_ADDRESS = 0;

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
	public static final int BOOTSTRAP_ADDRESS = 1;

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
	public static final int SOAP_CONNECTOR_ADDRESS = 2;

	/**
	 * The '<em><b>Sas Ssl Server Auth Listener Address</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sas Ssl Server Auth Listener Address</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL
	 * @model name="sasSslServerAuthListenerAddress" literal="sas_ssl_serverAuth_listener_address"
	 * @generated
	 * @ordered
	 */
	public static final int SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS = 3;

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
	public static final int CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS = 4;

	/**
	 * The '<em><b>Csiv2 Ssl Server Auth Listener Address</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Csiv2 Ssl Server Auth Listener Address</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL
	 * @model name="csiv2SslServerAuthListenerAddress"
	 *        literal="csiv2_ssl_serverAuth_listener_address"
	 * @generated
	 * @ordered
	 */
	public static final int CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS = 5;

	/**
	 * The '<em><b>Wc Adminhost</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wc Adminhost</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WC_ADMINHOST_LITERAL
	 * @model name="wcAdminhost" literal="wc_adminhost"
	 * @generated
	 * @ordered
	 */
	public static final int WC_ADMINHOST = 6;

	/**
	 * The '<em><b>Wc Adminhost Secure</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wc Adminhost Secure</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WC_ADMINHOST_SECURE_LITERAL
	 * @model name="wcAdminhostSecure" literal="wc_adminhost_secure"
	 * @generated
	 * @ordered
	 */
	public static final int WC_ADMINHOST_SECURE = 7;

	/**
	 * The '<em><b>Wc Defaulthost</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WC Defaulthost</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WC_DEFAULTHOST_LITERAL
	 * @model name="wcDefaulthost" literal="wc_defaulthost"
	 * @generated
	 * @ordered
	 */
	public static final int WC_DEFAULTHOST = 8;

	/**
	 * The '<em><b>Wc Defaulthost Secure</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WC Defaulthost Secure</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WC_DEFAULTHOST_SECURE_LITERAL
	 * @model name="wcDefaulthostSecure" literal="wc_defaulthost_secure"
	 * @generated
	 * @ordered
	 */
	public static final int WC_DEFAULTHOST_SECURE = 9;

	/**
	 * The '<em><b>Sib Endpoint Address</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sib Endpoint Address</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIB_ENDPOINT_ADDRESS_LITERAL
	 * @model name="sibEndpointAddress" literal="sib_endpoint_address"
	 * @generated
	 * @ordered
	 */
	public static final int SIB_ENDPOINT_ADDRESS = 10;

	/**
	 * The '<em><b>Sib Endpoint Secure Address</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sib Endpoint Secure Address</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIB_ENDPOINT_SECURE_ADDRESS_LITERAL
	 * @model name="sibEndpointSecureAddress" literal="sib_endpoint_secure_address"
	 * @generated
	 * @ordered
	 */
	public static final int SIB_ENDPOINT_SECURE_ADDRESS = 11;

	/**
	 * The '<em><b>Sib Mq Endpoint Address</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sib Mq Endpoint Address</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIB_MQ_ENDPOINT_ADDRESS_LITERAL
	 * @model name="sibMqEndpointAddress" literal="sib_mq_endpoint_address"
	 * @generated
	 * @ordered
	 */
	public static final int SIB_MQ_ENDPOINT_ADDRESS = 12;

	/**
	 * The '<em><b>Sib Mq Endpoint Secure Address</b></em>' literal value.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Sib Mq Endpoint Secure Address</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIB_MQ_ENDPOINT_SECURE_ADDRESS_LITERAL
	 * @model name="sibMqEndpointSecureAddress" literal="sib_mq_endpoint_secure_address"
	 * @generated
	 * @ordered
	 */
	public static final int SIB_MQ_ENDPOINT_SECURE_ADDRESS = 13;

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
	public static final int ORB_LISTENER_ADDRESS = 14;

	/**
	 * The '<em><b>Dcs Unicast Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #DCS_UNICAST_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames DCS_UNICAST_ADDRESS_LITERAL = new WebsphereAppServerPortNames(DCS_UNICAST_ADDRESS, "dcsUnicastAddress", "dcs_unicast_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Bootstrap Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #BOOTSTRAP_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames BOOTSTRAP_ADDRESS_LITERAL = new WebsphereAppServerPortNames(BOOTSTRAP_ADDRESS, "bootstrapAddress", "bootstrap_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Soap Connector Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SOAP_CONNECTOR_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames SOAP_CONNECTOR_ADDRESS_LITERAL = new WebsphereAppServerPortNames(SOAP_CONNECTOR_ADDRESS, "soapConnectorAddress", "soap_connector_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Sas Ssl Server Auth Listener Address</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL = new WebsphereAppServerPortNames(SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS, "sasSslServerAuthListenerAddress", "sas_ssl_serverAuth_listener_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Csiv2 Ssl Mutualauth Listener Address</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL = new WebsphereAppServerPortNames(CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS, "csiv2SslMutualauthListenerAddress", "csiv2_ssl_mutualauth_listener_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Csiv2 Ssl Server Auth Listener Address</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL = new WebsphereAppServerPortNames(CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS, "csiv2SslServerAuthListenerAddress", "csiv2_ssl_serverAuth_listener_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Wc Adminhost</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #WC_ADMINHOST
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames WC_ADMINHOST_LITERAL = new WebsphereAppServerPortNames(WC_ADMINHOST, "wcAdminhost", "wc_adminhost"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Wc Adminhost Secure</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #WC_ADMINHOST_SECURE
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames WC_ADMINHOST_SECURE_LITERAL = new WebsphereAppServerPortNames(WC_ADMINHOST_SECURE, "wcAdminhostSecure", "wc_adminhost_secure"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Wc Defaulthost</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #WC_DEFAULTHOST
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames WC_DEFAULTHOST_LITERAL = new WebsphereAppServerPortNames(WC_DEFAULTHOST, "wcDefaulthost", "wc_defaulthost"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Wc Defaulthost Secure</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #WC_DEFAULTHOST_SECURE
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames WC_DEFAULTHOST_SECURE_LITERAL = new WebsphereAppServerPortNames(WC_DEFAULTHOST_SECURE, "wcDefaulthostSecure", "wc_defaulthost_secure"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Sib Endpoint Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SIB_ENDPOINT_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames SIB_ENDPOINT_ADDRESS_LITERAL = new WebsphereAppServerPortNames(SIB_ENDPOINT_ADDRESS, "sibEndpointAddress", "sib_endpoint_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Sib Endpoint Secure Address</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIB_ENDPOINT_SECURE_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames SIB_ENDPOINT_SECURE_ADDRESS_LITERAL = new WebsphereAppServerPortNames(SIB_ENDPOINT_SECURE_ADDRESS, "sibEndpointSecureAddress", "sib_endpoint_secure_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Sib Mq Endpoint Address</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIB_MQ_ENDPOINT_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames SIB_MQ_ENDPOINT_ADDRESS_LITERAL = new WebsphereAppServerPortNames(SIB_MQ_ENDPOINT_ADDRESS, "sibMqEndpointAddress", "sib_mq_endpoint_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Sib Mq Endpoint Secure Address</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #SIB_MQ_ENDPOINT_SECURE_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames SIB_MQ_ENDPOINT_SECURE_ADDRESS_LITERAL = new WebsphereAppServerPortNames(SIB_MQ_ENDPOINT_SECURE_ADDRESS, "sibMqEndpointSecureAddress", "sib_mq_endpoint_secure_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Orb Listener Address</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ORB_LISTENER_ADDRESS
	 * @generated
	 * @ordered
	 */
	public static final WebsphereAppServerPortNames ORB_LISTENER_ADDRESS_LITERAL = new WebsphereAppServerPortNames(ORB_LISTENER_ADDRESS, "orbListenerAddress", "orb_listener_address"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Websphere App Server Port Names</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WebsphereAppServerPortNames[] VALUES_ARRAY = new WebsphereAppServerPortNames[] {
			DCS_UNICAST_ADDRESS_LITERAL,
			BOOTSTRAP_ADDRESS_LITERAL,
			SOAP_CONNECTOR_ADDRESS_LITERAL,
			SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL,
			CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL,
			CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL,
			WC_ADMINHOST_LITERAL,
			WC_ADMINHOST_SECURE_LITERAL,
			WC_DEFAULTHOST_LITERAL,
			WC_DEFAULTHOST_SECURE_LITERAL,
			SIB_ENDPOINT_ADDRESS_LITERAL,
			SIB_ENDPOINT_SECURE_ADDRESS_LITERAL,
			SIB_MQ_ENDPOINT_ADDRESS_LITERAL,
			SIB_MQ_ENDPOINT_SECURE_ADDRESS_LITERAL,
			ORB_LISTENER_ADDRESS_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Websphere App Server Port Names</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Websphere App Server Port Names</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WebsphereAppServerPortNames get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WebsphereAppServerPortNames result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Websphere App Server Port Names</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WebsphereAppServerPortNames getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WebsphereAppServerPortNames result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Websphere App Server Port Names</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WebsphereAppServerPortNames get(int value) {
		switch (value) {
			case DCS_UNICAST_ADDRESS: return DCS_UNICAST_ADDRESS_LITERAL;
			case BOOTSTRAP_ADDRESS: return BOOTSTRAP_ADDRESS_LITERAL;
			case SOAP_CONNECTOR_ADDRESS: return SOAP_CONNECTOR_ADDRESS_LITERAL;
			case SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS: return SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL;
			case CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS: return CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL;
			case CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS: return CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL;
			case WC_ADMINHOST: return WC_ADMINHOST_LITERAL;
			case WC_ADMINHOST_SECURE: return WC_ADMINHOST_SECURE_LITERAL;
			case WC_DEFAULTHOST: return WC_DEFAULTHOST_LITERAL;
			case WC_DEFAULTHOST_SECURE: return WC_DEFAULTHOST_SECURE_LITERAL;
			case SIB_ENDPOINT_ADDRESS: return SIB_ENDPOINT_ADDRESS_LITERAL;
			case SIB_ENDPOINT_SECURE_ADDRESS: return SIB_ENDPOINT_SECURE_ADDRESS_LITERAL;
			case SIB_MQ_ENDPOINT_ADDRESS: return SIB_MQ_ENDPOINT_ADDRESS_LITERAL;
			case SIB_MQ_ENDPOINT_SECURE_ADDRESS: return SIB_MQ_ENDPOINT_SECURE_ADDRESS_LITERAL;
			case ORB_LISTENER_ADDRESS: return ORB_LISTENER_ADDRESS_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WebsphereAppServerPortNames(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WebsphereAppServerPortNames
