/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>V5DB2 Datasource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DB2DatasourceImpl#getCliSchema <em>Cli Schema</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DB2DatasourceImpl#getCurrentPackageSet <em>Current Package Set</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DB2DatasourceImpl#getCurrentSchema <em>Current Schema</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DB2DatasourceImpl#isDeferPrepares <em>Defer Prepares</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DB2DatasourceImpl#isFullyMaterializeLobData <em>Fully Materialize Lob Data</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DB2DatasourceImpl#getResultSetHoldability <em>Result Set Holdability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DB2DatasourceImpl#getTraceFile <em>Trace File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DB2DatasourceImpl#getTraceLevel <em>Trace Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DB2DatasourceImpl#isUseTemplate <em>Use Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasV5DB2DatasourceImpl extends WasV5DatasourceImpl implements WasV5DB2Datasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getCliSchema() <em>Cli Schema</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCliSchema()
	 * @generated
	 * @ordered
	 */
	protected static final String CLI_SCHEMA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCliSchema() <em>Cli Schema</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCliSchema()
	 * @generated
	 * @ordered
	 */
	protected String cliSchema = CLI_SCHEMA_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentPackageSet() <em>Current Package Set</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCurrentPackageSet()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_PACKAGE_SET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentPackageSet() <em>Current Package Set</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCurrentPackageSet()
	 * @generated
	 * @ordered
	 */
	protected String currentPackageSet = CURRENT_PACKAGE_SET_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentSchema() <em>Current Schema</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCurrentSchema()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_SCHEMA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentSchema() <em>Current Schema</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCurrentSchema()
	 * @generated
	 * @ordered
	 */
	protected String currentSchema = CURRENT_SCHEMA_EDEFAULT;

	/**
	 * The default value of the '{@link #isDeferPrepares() <em>Defer Prepares</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDeferPrepares()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFER_PREPARES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeferPrepares() <em>Defer Prepares</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDeferPrepares()
	 * @generated
	 * @ordered
	 */
	protected boolean deferPrepares = DEFER_PREPARES_EDEFAULT;

	/**
	 * This is true if the Defer Prepares attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean deferPreparesESet;

	/**
	 * The default value of the '{@link #isFullyMaterializeLobData() <em>Fully Materialize Lob Data</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFullyMaterializeLobData()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FULLY_MATERIALIZE_LOB_DATA_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFullyMaterializeLobData() <em>Fully Materialize Lob Data</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFullyMaterializeLobData()
	 * @generated
	 * @ordered
	 */
	protected boolean fullyMaterializeLobData = FULLY_MATERIALIZE_LOB_DATA_EDEFAULT;

	/**
	 * This is true if the Fully Materialize Lob Data attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fullyMaterializeLobDataESet;

	/**
	 * The default value of the '{@link #getResultSetHoldability() <em>Result Set Holdability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResultSetHoldability()
	 * @generated
	 * @ordered
	 */
	protected static final int RESULT_SET_HOLDABILITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getResultSetHoldability() <em>Result Set Holdability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResultSetHoldability()
	 * @generated
	 * @ordered
	 */
	protected int resultSetHoldability = RESULT_SET_HOLDABILITY_EDEFAULT;

	/**
	 * This is true if the Result Set Holdability attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean resultSetHoldabilityESet;

	/**
	 * The default value of the '{@link #getTraceFile() <em>Trace File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTraceFile()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceFile() <em>Trace File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTraceFile()
	 * @generated
	 * @ordered
	 */
	protected String traceFile = TRACE_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTraceLevel() <em>Trace Level</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTraceLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int TRACE_LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTraceLevel() <em>Trace Level</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTraceLevel()
	 * @generated
	 * @ordered
	 */
	protected int traceLevel = TRACE_LEVEL_EDEFAULT;

	/**
	 * This is true if the Trace Level attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean traceLevelESet;

	/**
	 * The default value of the '{@link #isUseTemplate() <em>Use Template</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isUseTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_TEMPLATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseTemplate() <em>Use Template</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isUseTemplate()
	 * @generated
	 * @ordered
	 */
	protected boolean useTemplate = USE_TEMPLATE_EDEFAULT;

	/**
	 * This is true if the Use Template attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean useTemplateESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasV5DB2DatasourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_V5DB2_DATASOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCliSchema() {
		return cliSchema;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCliSchema(String newCliSchema) {
		String oldCliSchema = cliSchema;
		cliSchema = newCliSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5DB2_DATASOURCE__CLI_SCHEMA, oldCliSchema, cliSchema));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentPackageSet() {
		return currentPackageSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentPackageSet(String newCurrentPackageSet) {
		String oldCurrentPackageSet = currentPackageSet;
		currentPackageSet = newCurrentPackageSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_PACKAGE_SET, oldCurrentPackageSet, currentPackageSet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentSchema() {
		return currentSchema;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentSchema(String newCurrentSchema) {
		String oldCurrentSchema = currentSchema;
		currentSchema = newCurrentSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_SCHEMA, oldCurrentSchema, currentSchema));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeferPrepares() {
		return deferPrepares;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeferPrepares(boolean newDeferPrepares) {
		boolean oldDeferPrepares = deferPrepares;
		deferPrepares = newDeferPrepares;
		boolean oldDeferPreparesESet = deferPreparesESet;
		deferPreparesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5DB2_DATASOURCE__DEFER_PREPARES, oldDeferPrepares, deferPrepares, !oldDeferPreparesESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDeferPrepares() {
		boolean oldDeferPrepares = deferPrepares;
		boolean oldDeferPreparesESet = deferPreparesESet;
		deferPrepares = DEFER_PREPARES_EDEFAULT;
		deferPreparesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_V5DB2_DATASOURCE__DEFER_PREPARES, oldDeferPrepares, DEFER_PREPARES_EDEFAULT, oldDeferPreparesESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDeferPrepares() {
		return deferPreparesESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFullyMaterializeLobData() {
		return fullyMaterializeLobData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullyMaterializeLobData(boolean newFullyMaterializeLobData) {
		boolean oldFullyMaterializeLobData = fullyMaterializeLobData;
		fullyMaterializeLobData = newFullyMaterializeLobData;
		boolean oldFullyMaterializeLobDataESet = fullyMaterializeLobDataESet;
		fullyMaterializeLobDataESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5DB2_DATASOURCE__FULLY_MATERIALIZE_LOB_DATA, oldFullyMaterializeLobData, fullyMaterializeLobData, !oldFullyMaterializeLobDataESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFullyMaterializeLobData() {
		boolean oldFullyMaterializeLobData = fullyMaterializeLobData;
		boolean oldFullyMaterializeLobDataESet = fullyMaterializeLobDataESet;
		fullyMaterializeLobData = FULLY_MATERIALIZE_LOB_DATA_EDEFAULT;
		fullyMaterializeLobDataESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_V5DB2_DATASOURCE__FULLY_MATERIALIZE_LOB_DATA, oldFullyMaterializeLobData, FULLY_MATERIALIZE_LOB_DATA_EDEFAULT, oldFullyMaterializeLobDataESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFullyMaterializeLobData() {
		return fullyMaterializeLobDataESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getResultSetHoldability() {
		return resultSetHoldability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultSetHoldability(int newResultSetHoldability) {
		int oldResultSetHoldability = resultSetHoldability;
		resultSetHoldability = newResultSetHoldability;
		boolean oldResultSetHoldabilityESet = resultSetHoldabilityESet;
		resultSetHoldabilityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5DB2_DATASOURCE__RESULT_SET_HOLDABILITY, oldResultSetHoldability, resultSetHoldability, !oldResultSetHoldabilityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResultSetHoldability() {
		int oldResultSetHoldability = resultSetHoldability;
		boolean oldResultSetHoldabilityESet = resultSetHoldabilityESet;
		resultSetHoldability = RESULT_SET_HOLDABILITY_EDEFAULT;
		resultSetHoldabilityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_V5DB2_DATASOURCE__RESULT_SET_HOLDABILITY, oldResultSetHoldability, RESULT_SET_HOLDABILITY_EDEFAULT, oldResultSetHoldabilityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResultSetHoldability() {
		return resultSetHoldabilityESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTraceFile() {
		return traceFile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceFile(String newTraceFile) {
		String oldTraceFile = traceFile;
		traceFile = newTraceFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5DB2_DATASOURCE__TRACE_FILE, oldTraceFile, traceFile));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getTraceLevel() {
		return traceLevel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceLevel(int newTraceLevel) {
		int oldTraceLevel = traceLevel;
		traceLevel = newTraceLevel;
		boolean oldTraceLevelESet = traceLevelESet;
		traceLevelESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5DB2_DATASOURCE__TRACE_LEVEL, oldTraceLevel, traceLevel, !oldTraceLevelESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTraceLevel() {
		int oldTraceLevel = traceLevel;
		boolean oldTraceLevelESet = traceLevelESet;
		traceLevel = TRACE_LEVEL_EDEFAULT;
		traceLevelESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_V5DB2_DATASOURCE__TRACE_LEVEL, oldTraceLevel, TRACE_LEVEL_EDEFAULT, oldTraceLevelESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTraceLevel() {
		return traceLevelESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseTemplate() {
		return useTemplate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseTemplate(boolean newUseTemplate) {
		boolean oldUseTemplate = useTemplate;
		useTemplate = newUseTemplate;
		boolean oldUseTemplateESet = useTemplateESet;
		useTemplateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5DB2_DATASOURCE__USE_TEMPLATE, oldUseTemplate, useTemplate, !oldUseTemplateESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUseTemplate() {
		boolean oldUseTemplate = useTemplate;
		boolean oldUseTemplateESet = useTemplateESet;
		useTemplate = USE_TEMPLATE_EDEFAULT;
		useTemplateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_V5DB2_DATASOURCE__USE_TEMPLATE, oldUseTemplate, USE_TEMPLATE_EDEFAULT, oldUseTemplateESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUseTemplate() {
		return useTemplateESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_V5DB2_DATASOURCE__CLI_SCHEMA:
				return getCliSchema();
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_PACKAGE_SET:
				return getCurrentPackageSet();
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_SCHEMA:
				return getCurrentSchema();
			case WasPackage.WAS_V5DB2_DATASOURCE__DEFER_PREPARES:
				return isDeferPrepares() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_V5DB2_DATASOURCE__FULLY_MATERIALIZE_LOB_DATA:
				return isFullyMaterializeLobData() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_V5DB2_DATASOURCE__RESULT_SET_HOLDABILITY:
				return new Integer(getResultSetHoldability());
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_FILE:
				return getTraceFile();
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_LEVEL:
				return new Integer(getTraceLevel());
			case WasPackage.WAS_V5DB2_DATASOURCE__USE_TEMPLATE:
				return isUseTemplate() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_V5DB2_DATASOURCE__CLI_SCHEMA:
				setCliSchema((String)newValue);
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_PACKAGE_SET:
				setCurrentPackageSet((String)newValue);
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_SCHEMA:
				setCurrentSchema((String)newValue);
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__DEFER_PREPARES:
				setDeferPrepares(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__FULLY_MATERIALIZE_LOB_DATA:
				setFullyMaterializeLobData(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__RESULT_SET_HOLDABILITY:
				setResultSetHoldability(((Integer)newValue).intValue());
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_FILE:
				setTraceFile((String)newValue);
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_LEVEL:
				setTraceLevel(((Integer)newValue).intValue());
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__USE_TEMPLATE:
				setUseTemplate(((Boolean)newValue).booleanValue());
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
			case WasPackage.WAS_V5DB2_DATASOURCE__CLI_SCHEMA:
				setCliSchema(CLI_SCHEMA_EDEFAULT);
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_PACKAGE_SET:
				setCurrentPackageSet(CURRENT_PACKAGE_SET_EDEFAULT);
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_SCHEMA:
				setCurrentSchema(CURRENT_SCHEMA_EDEFAULT);
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__DEFER_PREPARES:
				unsetDeferPrepares();
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__FULLY_MATERIALIZE_LOB_DATA:
				unsetFullyMaterializeLobData();
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__RESULT_SET_HOLDABILITY:
				unsetResultSetHoldability();
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_FILE:
				setTraceFile(TRACE_FILE_EDEFAULT);
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_LEVEL:
				unsetTraceLevel();
				return;
			case WasPackage.WAS_V5DB2_DATASOURCE__USE_TEMPLATE:
				unsetUseTemplate();
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
			case WasPackage.WAS_V5DB2_DATASOURCE__CLI_SCHEMA:
				return CLI_SCHEMA_EDEFAULT == null ? cliSchema != null : !CLI_SCHEMA_EDEFAULT.equals(cliSchema);
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_PACKAGE_SET:
				return CURRENT_PACKAGE_SET_EDEFAULT == null ? currentPackageSet != null : !CURRENT_PACKAGE_SET_EDEFAULT.equals(currentPackageSet);
			case WasPackage.WAS_V5DB2_DATASOURCE__CURRENT_SCHEMA:
				return CURRENT_SCHEMA_EDEFAULT == null ? currentSchema != null : !CURRENT_SCHEMA_EDEFAULT.equals(currentSchema);
			case WasPackage.WAS_V5DB2_DATASOURCE__DEFER_PREPARES:
				return isSetDeferPrepares();
			case WasPackage.WAS_V5DB2_DATASOURCE__FULLY_MATERIALIZE_LOB_DATA:
				return isSetFullyMaterializeLobData();
			case WasPackage.WAS_V5DB2_DATASOURCE__RESULT_SET_HOLDABILITY:
				return isSetResultSetHoldability();
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_FILE:
				return TRACE_FILE_EDEFAULT == null ? traceFile != null : !TRACE_FILE_EDEFAULT.equals(traceFile);
			case WasPackage.WAS_V5DB2_DATASOURCE__TRACE_LEVEL:
				return isSetTraceLevel();
			case WasPackage.WAS_V5DB2_DATASOURCE__USE_TEMPLATE:
				return isSetUseTemplate();
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
		result.append(" (cliSchema: "); //$NON-NLS-1$
		result.append(cliSchema);
		result.append(", currentPackageSet: "); //$NON-NLS-1$
		result.append(currentPackageSet);
		result.append(", currentSchema: "); //$NON-NLS-1$
		result.append(currentSchema);
		result.append(", deferPrepares: "); //$NON-NLS-1$
		if (deferPreparesESet) result.append(deferPrepares); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", fullyMaterializeLobData: "); //$NON-NLS-1$
		if (fullyMaterializeLobDataESet) result.append(fullyMaterializeLobData); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", resultSetHoldability: "); //$NON-NLS-1$
		if (resultSetHoldabilityESet) result.append(resultSetHoldability); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", traceFile: "); //$NON-NLS-1$
		result.append(traceFile);
		result.append(", traceLevel: "); //$NON-NLS-1$
		if (traceLevelESet) result.append(traceLevel); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", useTemplate: "); //$NON-NLS-1$
		if (useTemplateESet) result.append(useTemplate); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasV5DB2DatasourceImpl
