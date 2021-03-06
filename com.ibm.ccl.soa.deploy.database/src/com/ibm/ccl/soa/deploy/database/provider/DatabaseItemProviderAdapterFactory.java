/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import com.ibm.ccl.soa.deploy.database.util.DatabaseAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class DatabaseItemProviderAdapterFactory extends DatabaseAdapterFactory implements
		ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection supportedTypes = new ArrayList();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.Database} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected DatabaseItemProvider databaseItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.Database}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createDatabaseAdapter() {
		if (databaseItemProvider == null) {
			databaseItemProvider = new DatabaseItemProvider(this);
		}

		return databaseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.DatabaseComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseComponentItemProvider databaseComponentItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.DatabaseComponent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createDatabaseComponentAdapter() {
		if (databaseComponentItemProvider == null) {
			databaseComponentItemProvider = new DatabaseComponentItemProvider(this);
		}

		return databaseComponentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.DatabaseDefinition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseDefinitionItemProvider databaseDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.DatabaseDefinition}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createDatabaseDefinitionAdapter() {
		if (databaseDefinitionItemProvider == null) {
			databaseDefinitionItemProvider = new DatabaseDefinitionItemProvider(this);
		}

		return databaseDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseDeployRootItemProvider databaseDeployRootItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createDatabaseDeployRootAdapter() {
		if (databaseDeployRootItemProvider == null) {
			databaseDeployRootItemProvider = new DatabaseDeployRootItemProvider(this);
		}

		return databaseDeployRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.DatabaseInstance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseInstanceItemProvider databaseInstanceItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.DatabaseInstance}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createDatabaseInstanceAdapter() {
		if (databaseInstanceItemProvider == null) {
			databaseInstanceItemProvider = new DatabaseInstanceItemProvider(this);
		}

		return databaseInstanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseInstanceUnitItemProvider databaseInstanceUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createDatabaseInstanceUnitAdapter() {
		if (databaseInstanceUnitItemProvider == null) {
			databaseInstanceUnitItemProvider = new DatabaseInstanceUnitItemProvider(this);
		}

		return databaseInstanceUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.DatabaseUnit} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected DatabaseUnitItemProvider databaseUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.DatabaseUnit}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createDatabaseUnitAdapter() {
		if (databaseUnitItemProvider == null) {
			databaseUnitItemProvider = new DatabaseUnitItemProvider(this);
		}

		return databaseUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.DDLArtifact} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected DDLArtifactItemProvider ddlArtifactItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.DDLArtifact}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createDDLArtifactAdapter() {
		if (ddlArtifactItemProvider == null) {
			ddlArtifactItemProvider = new DDLArtifactItemProvider(this);
		}

		return ddlArtifactItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.DDLInterface} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected DDLInterfaceItemProvider ddlInterfaceItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.DDLInterface}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createDDLInterfaceAdapter() {
		if (ddlInterfaceItemProvider == null) {
			ddlInterfaceItemProvider = new DDLInterfaceItemProvider(this);
		}

		return ddlInterfaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.DMLArtifact} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected DMLArtifactItemProvider dmlArtifactItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.DMLArtifact}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createDMLArtifactAdapter() {
		if (dmlArtifactItemProvider == null) {
			dmlArtifactItemProvider = new DMLArtifactItemProvider(this);
		}

		return dmlArtifactItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.SQLModule} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected SQLModuleItemProvider sqlModuleItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.SQLModule}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createSQLModuleAdapter() {
		if (sqlModuleItemProvider == null) {
			sqlModuleItemProvider = new SQLModuleItemProvider(this);
		}

		return sqlModuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.database.SQLUser} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected SQLUserItemProvider sqlUserItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.database.SQLUser}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createSQLUserAdapter() {
		if (sqlUserItemProvider == null) {
			sqlUserItemProvider = new SQLUserItemProvider(this);
		}

		return sqlUserItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (databaseItemProvider != null) databaseItemProvider.dispose();
		if (databaseComponentItemProvider != null) databaseComponentItemProvider.dispose();
		if (databaseDefinitionItemProvider != null) databaseDefinitionItemProvider.dispose();
		if (databaseDeployRootItemProvider != null) databaseDeployRootItemProvider.dispose();
		if (databaseInstanceItemProvider != null) databaseInstanceItemProvider.dispose();
		if (databaseInstanceUnitItemProvider != null) databaseInstanceUnitItemProvider.dispose();
		if (databaseUnitItemProvider != null) databaseUnitItemProvider.dispose();
		if (ddlArtifactItemProvider != null) ddlArtifactItemProvider.dispose();
		if (ddlInterfaceItemProvider != null) ddlInterfaceItemProvider.dispose();
		if (dmlArtifactItemProvider != null) dmlArtifactItemProvider.dispose();
		if (sqlModuleItemProvider != null) sqlModuleItemProvider.dispose();
		if (sqlUserItemProvider != null) sqlUserItemProvider.dispose();
	}

}
