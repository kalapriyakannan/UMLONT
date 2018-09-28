/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>AIX Operating System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getDesktop <em>Desktop</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getKernel <em>Kernel</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getLastBootUpTime <em>Last Boot Up Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#isTCB <em>TCB</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXOperatingSystem()
 * @model extendedMetaData="name='AIXOperatingSystem' kind='elementOnly'"
 * @generated
 */
public interface AIXOperatingSystem extends OperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Desktop</b></em>' attribute.
	 * The default value is <code>"CDE"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.AIXDesktopType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desktop</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desktop</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.AIXDesktopType
	 * @see #isSetDesktop()
	 * @see #unsetDesktop()
	 * @see #setDesktop(AIXDesktopType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXOperatingSystem_Desktop()
	 * @model default="CDE" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Desktop'"
	 * @generated
	 */
	AIXDesktopType getDesktop();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getDesktop <em>Desktop</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desktop</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.AIXDesktopType
	 * @see #isSetDesktop()
	 * @see #unsetDesktop()
	 * @see #getDesktop()
	 * @generated
	 */
	void setDesktop(AIXDesktopType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getDesktop <em>Desktop</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDesktop()
	 * @see #getDesktop()
	 * @see #setDesktop(AIXDesktopType)
	 * @generated
	 */
	void unsetDesktop();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getDesktop <em>Desktop</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Desktop</em>' attribute is set.
	 * @see #unsetDesktop()
	 * @see #getDesktop()
	 * @see #setDesktop(AIXDesktopType)
	 * @generated
	 */
	boolean isSetDesktop();

	/**
	 * Returns the value of the '<em><b>Install Date</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Install Date</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Install Date</em>' attribute.
	 * @see #setInstallDate(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXOperatingSystem_InstallDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InstallDate'"
	 * @generated
	 */
	String getInstallDate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getInstallDate <em>Install Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Date</em>' attribute.
	 * @see #getInstallDate()
	 * @generated
	 */
	void setInstallDate(String value);

	/**
	 * Returns the value of the '<em><b>Kernel</b></em>' attribute.
	 * The default value is <code>"32-bit"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.KernelWidthType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kernel</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kernel</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
	 * @see #isSetKernel()
	 * @see #unsetKernel()
	 * @see #setKernel(KernelWidthType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXOperatingSystem_Kernel()
	 * @model default="32-bit" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Kernel'"
	 * @generated
	 */
	KernelWidthType getKernel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getKernel <em>Kernel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kernel</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
	 * @see #isSetKernel()
	 * @see #unsetKernel()
	 * @see #getKernel()
	 * @generated
	 */
	void setKernel(KernelWidthType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getKernel <em>Kernel</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetKernel()
	 * @see #getKernel()
	 * @see #setKernel(KernelWidthType)
	 * @generated
	 */
	void unsetKernel();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getKernel <em>Kernel</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Kernel</em>' attribute is set.
	 * @see #unsetKernel()
	 * @see #getKernel()
	 * @see #setKernel(KernelWidthType)
	 * @generated
	 */
	boolean isSetKernel();

	/**
	 * Returns the value of the '<em><b>Last Boot Up Time</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Boot Up Time</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Last Boot Up Time</em>' attribute.
	 * @see #setLastBootUpTime(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXOperatingSystem_LastBootUpTime()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='LastBootUpTime'"
	 * @generated
	 */
	String getLastBootUpTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getLastBootUpTime <em>Last Boot Up Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Boot Up Time</em>' attribute.
	 * @see #getLastBootUpTime()
	 * @generated
	 */
	void setLastBootUpTime(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXOperatingSystem_Owner()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Owner'"
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

	/**
	 * Returns the value of the '<em><b>TCB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TCB</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TCB</em>' attribute.
	 * @see #isSetTCB()
	 * @see #unsetTCB()
	 * @see #setTCB(boolean)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXOperatingSystem_TCB()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='TCB'"
	 * @generated
	 */
	boolean isTCB();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#isTCB <em>TCB</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>TCB</em>' attribute.
	 * @see #isSetTCB()
	 * @see #unsetTCB()
	 * @see #isTCB()
	 * @generated
	 */
	void setTCB(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#isTCB <em>TCB</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetTCB()
	 * @see #isTCB()
	 * @see #setTCB(boolean)
	 * @generated
	 */
	void unsetTCB();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#isTCB <em>TCB</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>TCB</em>' attribute is set.
	 * @see #unsetTCB()
	 * @see #isTCB()
	 * @see #setTCB(boolean)
	 * @generated
	 */
	boolean isSetTCB();

} // AIXOperatingSystem
