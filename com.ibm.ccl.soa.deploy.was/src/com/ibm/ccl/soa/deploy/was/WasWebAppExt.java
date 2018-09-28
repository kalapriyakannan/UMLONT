/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Web App Ext</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#getAdditionalClassPath <em>Additional Class Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoLoadFilters <em>Auto Load Filters</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoRequestEncoding <em>Auto Request Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoResponseEncoding <em>Auto Response Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#getDefaultErrorPage <em>Default Error Page</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isDirectoryBrowsingEnabled <em>Directory Browsing Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isFileServingEnabled <em>File Serving Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isPreCompileJSPs <em>Pre Compile JS Ps</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isReloadingEnabled <em>Reloading Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#getReloadInterval <em>Reload Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isServeServletsByClassnameEnabled <em>Serve Servlets By Classname Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt()
 * @model extendedMetaData="name='WasWebAppExt' kind='elementOnly'"
 * @generated
 */
public interface WasWebAppExt extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Additional Class Path</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Class Path</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Additional Class Path</em>' attribute.
	 * @see #setAdditionalClassPath(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_AdditionalClassPath()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='additionalClassPath'"
	 * @generated
	 */
	String getAdditionalClassPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#getAdditionalClassPath <em>Additional Class Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Additional Class Path</em>' attribute.
	 * @see #getAdditionalClassPath()
	 * @generated
	 */
	void setAdditionalClassPath(String value);

	/**
	 * Returns the value of the '<em><b>Auto Load Filters</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Load Filters</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Auto Load Filters</em>' attribute.
	 * @see #isSetAutoLoadFilters()
	 * @see #unsetAutoLoadFilters()
	 * @see #setAutoLoadFilters(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_AutoLoadFilters()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='autoLoadFilters'"
	 * @generated
	 */
	boolean isAutoLoadFilters();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoLoadFilters <em>Auto Load Filters</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Load Filters</em>' attribute.
	 * @see #isSetAutoLoadFilters()
	 * @see #unsetAutoLoadFilters()
	 * @see #isAutoLoadFilters()
	 * @generated
	 */
	void setAutoLoadFilters(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoLoadFilters <em>Auto Load Filters</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAutoLoadFilters()
	 * @see #isAutoLoadFilters()
	 * @see #setAutoLoadFilters(boolean)
	 * @generated
	 */
	void unsetAutoLoadFilters();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoLoadFilters <em>Auto Load Filters</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Auto Load Filters</em>' attribute is set.
	 * @see #unsetAutoLoadFilters()
	 * @see #isAutoLoadFilters()
	 * @see #setAutoLoadFilters(boolean)
	 * @generated
	 */
	boolean isSetAutoLoadFilters();

	/**
	 * Returns the value of the '<em><b>Auto Request Encoding</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Request Encoding</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Auto Request Encoding</em>' attribute.
	 * @see #isSetAutoRequestEncoding()
	 * @see #unsetAutoRequestEncoding()
	 * @see #setAutoRequestEncoding(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_AutoRequestEncoding()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='autoRequestEncoding'"
	 * @generated
	 */
	boolean isAutoRequestEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoRequestEncoding <em>Auto Request Encoding</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Request Encoding</em>' attribute.
	 * @see #isSetAutoRequestEncoding()
	 * @see #unsetAutoRequestEncoding()
	 * @see #isAutoRequestEncoding()
	 * @generated
	 */
	void setAutoRequestEncoding(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoRequestEncoding <em>Auto Request Encoding</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAutoRequestEncoding()
	 * @see #isAutoRequestEncoding()
	 * @see #setAutoRequestEncoding(boolean)
	 * @generated
	 */
	void unsetAutoRequestEncoding();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoRequestEncoding <em>Auto Request Encoding</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Auto Request Encoding</em>' attribute is set.
	 * @see #unsetAutoRequestEncoding()
	 * @see #isAutoRequestEncoding()
	 * @see #setAutoRequestEncoding(boolean)
	 * @generated
	 */
	boolean isSetAutoRequestEncoding();

	/**
	 * Returns the value of the '<em><b>Auto Response Encoding</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Response Encoding</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Auto Response Encoding</em>' attribute.
	 * @see #isSetAutoResponseEncoding()
	 * @see #unsetAutoResponseEncoding()
	 * @see #setAutoResponseEncoding(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_AutoResponseEncoding()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='autoResponseEncoding'"
	 * @generated
	 */
	boolean isAutoResponseEncoding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoResponseEncoding <em>Auto Response Encoding</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Response Encoding</em>' attribute.
	 * @see #isSetAutoResponseEncoding()
	 * @see #unsetAutoResponseEncoding()
	 * @see #isAutoResponseEncoding()
	 * @generated
	 */
	void setAutoResponseEncoding(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoResponseEncoding <em>Auto Response Encoding</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAutoResponseEncoding()
	 * @see #isAutoResponseEncoding()
	 * @see #setAutoResponseEncoding(boolean)
	 * @generated
	 */
	void unsetAutoResponseEncoding();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isAutoResponseEncoding <em>Auto Response Encoding</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Auto Response Encoding</em>' attribute is set.
	 * @see #unsetAutoResponseEncoding()
	 * @see #isAutoResponseEncoding()
	 * @see #setAutoResponseEncoding(boolean)
	 * @generated
	 */
	boolean isSetAutoResponseEncoding();

	/**
	 * Returns the value of the '<em><b>Default Error Page</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Error Page</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default Error Page</em>' attribute.
	 * @see #setDefaultErrorPage(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_DefaultErrorPage()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='defaultErrorPage'"
	 * @generated
	 */
	String getDefaultErrorPage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#getDefaultErrorPage <em>Default Error Page</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Error Page</em>' attribute.
	 * @see #getDefaultErrorPage()
	 * @generated
	 */
	void setDefaultErrorPage(String value);

	/**
	 * Returns the value of the '<em><b>Directory Browsing Enabled</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directory Browsing Enabled</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Directory Browsing Enabled</em>' attribute.
	 * @see #isSetDirectoryBrowsingEnabled()
	 * @see #unsetDirectoryBrowsingEnabled()
	 * @see #setDirectoryBrowsingEnabled(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_DirectoryBrowsingEnabled()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='directoryBrowsingEnabled'"
	 * @generated
	 */
	boolean isDirectoryBrowsingEnabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isDirectoryBrowsingEnabled <em>Directory Browsing Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directory Browsing Enabled</em>' attribute.
	 * @see #isSetDirectoryBrowsingEnabled()
	 * @see #unsetDirectoryBrowsingEnabled()
	 * @see #isDirectoryBrowsingEnabled()
	 * @generated
	 */
	void setDirectoryBrowsingEnabled(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isDirectoryBrowsingEnabled <em>Directory Browsing Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDirectoryBrowsingEnabled()
	 * @see #isDirectoryBrowsingEnabled()
	 * @see #setDirectoryBrowsingEnabled(boolean)
	 * @generated
	 */
	void unsetDirectoryBrowsingEnabled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isDirectoryBrowsingEnabled <em>Directory Browsing Enabled</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Directory Browsing Enabled</em>' attribute is set.
	 * @see #unsetDirectoryBrowsingEnabled()
	 * @see #isDirectoryBrowsingEnabled()
	 * @see #setDirectoryBrowsingEnabled(boolean)
	 * @generated
	 */
	boolean isSetDirectoryBrowsingEnabled();

	/**
	 * Returns the value of the '<em><b>File Serving Enabled</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Serving Enabled</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>File Serving Enabled</em>' attribute.
	 * @see #isSetFileServingEnabled()
	 * @see #unsetFileServingEnabled()
	 * @see #setFileServingEnabled(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_FileServingEnabled()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='fileServingEnabled'"
	 * @generated
	 */
	boolean isFileServingEnabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isFileServingEnabled <em>File Serving Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Serving Enabled</em>' attribute.
	 * @see #isSetFileServingEnabled()
	 * @see #unsetFileServingEnabled()
	 * @see #isFileServingEnabled()
	 * @generated
	 */
	void setFileServingEnabled(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isFileServingEnabled <em>File Serving Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetFileServingEnabled()
	 * @see #isFileServingEnabled()
	 * @see #setFileServingEnabled(boolean)
	 * @generated
	 */
	void unsetFileServingEnabled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isFileServingEnabled <em>File Serving Enabled</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>File Serving Enabled</em>' attribute is set.
	 * @see #unsetFileServingEnabled()
	 * @see #isFileServingEnabled()
	 * @see #setFileServingEnabled(boolean)
	 * @generated
	 */
	boolean isSetFileServingEnabled();

	/**
	 * Returns the value of the '<em><b>Pre Compile JS Ps</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Compile JS Ps</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pre Compile JS Ps</em>' attribute.
	 * @see #isSetPreCompileJSPs()
	 * @see #unsetPreCompileJSPs()
	 * @see #setPreCompileJSPs(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_PreCompileJSPs()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='preCompileJSPs'"
	 * @generated
	 */
	boolean isPreCompileJSPs();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isPreCompileJSPs <em>Pre Compile JS Ps</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Compile JS Ps</em>' attribute.
	 * @see #isSetPreCompileJSPs()
	 * @see #unsetPreCompileJSPs()
	 * @see #isPreCompileJSPs()
	 * @generated
	 */
	void setPreCompileJSPs(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isPreCompileJSPs <em>Pre Compile JS Ps</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPreCompileJSPs()
	 * @see #isPreCompileJSPs()
	 * @see #setPreCompileJSPs(boolean)
	 * @generated
	 */
	void unsetPreCompileJSPs();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isPreCompileJSPs <em>Pre Compile JS Ps</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pre Compile JS Ps</em>' attribute is set.
	 * @see #unsetPreCompileJSPs()
	 * @see #isPreCompileJSPs()
	 * @see #setPreCompileJSPs(boolean)
	 * @generated
	 */
	boolean isSetPreCompileJSPs();

	/**
	 * Returns the value of the '<em><b>Reloading Enabled</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reloading Enabled</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reloading Enabled</em>' attribute.
	 * @see #isSetReloadingEnabled()
	 * @see #unsetReloadingEnabled()
	 * @see #setReloadingEnabled(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_ReloadingEnabled()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='reloadingEnabled'"
	 * @generated
	 */
	boolean isReloadingEnabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isReloadingEnabled <em>Reloading Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reloading Enabled</em>' attribute.
	 * @see #isSetReloadingEnabled()
	 * @see #unsetReloadingEnabled()
	 * @see #isReloadingEnabled()
	 * @generated
	 */
	void setReloadingEnabled(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isReloadingEnabled <em>Reloading Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetReloadingEnabled()
	 * @see #isReloadingEnabled()
	 * @see #setReloadingEnabled(boolean)
	 * @generated
	 */
	void unsetReloadingEnabled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isReloadingEnabled <em>Reloading Enabled</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reloading Enabled</em>' attribute is set.
	 * @see #unsetReloadingEnabled()
	 * @see #isReloadingEnabled()
	 * @see #setReloadingEnabled(boolean)
	 * @generated
	 */
	boolean isSetReloadingEnabled();

	/**
	 * Returns the value of the '<em><b>Reload Interval</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Reload Interval</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reload Interval</em>' attribute.
	 * @see #isSetReloadInterval()
	 * @see #unsetReloadInterval()
	 * @see #setReloadInterval(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_ReloadInterval()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='reloadInterval'"
	 * @generated
	 */
	int getReloadInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#getReloadInterval <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reload Interval</em>' attribute.
	 * @see #isSetReloadInterval()
	 * @see #unsetReloadInterval()
	 * @see #getReloadInterval()
	 * @generated
	 */
	void setReloadInterval(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#getReloadInterval <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetReloadInterval()
	 * @see #getReloadInterval()
	 * @see #setReloadInterval(int)
	 * @generated
	 */
	void unsetReloadInterval();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#getReloadInterval <em>Reload Interval</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reload Interval</em>' attribute is set.
	 * @see #unsetReloadInterval()
	 * @see #getReloadInterval()
	 * @see #setReloadInterval(int)
	 * @generated
	 */
	boolean isSetReloadInterval();

	/**
	 * Returns the value of the '<em><b>Serve Servlets By Classname Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serve Servlets By Classname Enabled</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serve Servlets By Classname Enabled</em>' attribute.
	 * @see #isSetServeServletsByClassnameEnabled()
	 * @see #unsetServeServletsByClassnameEnabled()
	 * @see #setServeServletsByClassnameEnabled(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebAppExt_ServeServletsByClassnameEnabled()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='serveServletsByClassnameEnabled'"
	 * @generated
	 */
	boolean isServeServletsByClassnameEnabled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isServeServletsByClassnameEnabled <em>Serve Servlets By Classname Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serve Servlets By Classname Enabled</em>' attribute.
	 * @see #isSetServeServletsByClassnameEnabled()
	 * @see #unsetServeServletsByClassnameEnabled()
	 * @see #isServeServletsByClassnameEnabled()
	 * @generated
	 */
	void setServeServletsByClassnameEnabled(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isServeServletsByClassnameEnabled <em>Serve Servlets By Classname Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetServeServletsByClassnameEnabled()
	 * @see #isServeServletsByClassnameEnabled()
	 * @see #setServeServletsByClassnameEnabled(boolean)
	 * @generated
	 */
	void unsetServeServletsByClassnameEnabled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasWebAppExt#isServeServletsByClassnameEnabled <em>Serve Servlets By Classname Enabled</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Serve Servlets By Classname Enabled</em>' attribute is set.
	 * @see #unsetServeServletsByClassnameEnabled()
	 * @see #isServeServletsByClassnameEnabled()
	 * @see #setServeServletsByClassnameEnabled(boolean)
	 * @generated
	 */
	boolean isSetServeServletsByClassnameEnabled();

} // WasWebAppExt
