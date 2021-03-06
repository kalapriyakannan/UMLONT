/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.provider;

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

import com.ibm.ccl.soa.deploy.ihs.util.IhsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class IhsItemProviderAdapterFactory extends IhsAdapterFactory implements
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
	public IhsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected IHSDeployRootItemProvider ihsDeployRootItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIHSDeployRootAdapter() {
		if (ihsDeployRootItemProvider == null) {
			ihsDeployRootItemProvider = new IHSDeployRootItemProvider(this);
		}

		return ihsDeployRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsModule} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsModuleItemProvider ihsModuleItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsModule}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsModuleAdapter() {
		if (ihsModuleItemProvider == null) {
			ihsModuleItemProvider = new IhsModuleItemProvider(this);
		}

		return ihsModuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsServer} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsServerItemProvider ihsServerItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsServer}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsServerAdapter() {
		if (ihsServerItemProvider == null) {
			ihsServerItemProvider = new IhsServerItemProvider(this);
		}

		return ihsServerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsServerUnit} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected IhsServerUnitItemProvider ihsServerUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsServerUnit}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsServerUnitAdapter() {
		if (ihsServerUnitItemProvider == null) {
			ihsServerUnitItemProvider = new IhsServerUnitItemProvider(this);
		}

		return ihsServerUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsSystem} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsSystemItemProvider ihsSystemItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsSystem}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsSystemAdapter() {
		if (ihsSystemItemProvider == null) {
			ihsSystemItemProvider = new IhsSystemItemProvider(this);
		}

		return ihsSystemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected IhsSystemUnitItemProvider ihsSystemUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsSystemUnitAdapter() {
		if (ihsSystemUnitItemProvider == null) {
			ihsSystemUnitItemProvider = new IhsSystemUnitItemProvider(this);
		}

		return ihsSystemUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsUser} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsUserItemProvider ihsUserItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsUser}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createIhsUserAdapter() {
		if (ihsUserItemProvider == null) {
			ihsUserItemProvider = new IhsUserItemProvider(this);
		}

		return ihsUserItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsUserRepository} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected IhsUserRepositoryItemProvider ihsUserRepositoryItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsUserRepository}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsUserRepositoryAdapter() {
		if (ihsUserRepositoryItemProvider == null) {
			ihsUserRepositoryItemProvider = new IhsUserRepositoryItemProvider(this);
		}

		return ihsUserRepositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsUserUnit} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected IhsUserUnitItemProvider ihsUserUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsUserUnit}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsUserUnitAdapter() {
		if (ihsUserUnitItemProvider == null) {
			ihsUserUnitItemProvider = new IhsUserUnitItemProvider(this);
		}

		return ihsUserUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected IhsWasAdminModuleItemProvider ihsWasAdminModuleItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsWasAdminModuleAdapter() {
		if (ihsWasAdminModuleItemProvider == null) {
			ihsWasAdminModuleItemProvider = new IhsWasAdminModuleItemProvider(this);
		}

		return ihsWasAdminModuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsWasAdminModuleUnitItemProvider ihsWasAdminModuleUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsWasAdminModuleUnitAdapter() {
		if (ihsWasAdminModuleUnitItemProvider == null) {
			ihsWasAdminModuleUnitItemProvider = new IhsWasAdminModuleUnitItemProvider(this);
		}

		return ihsWasAdminModuleUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsWasModule} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected IhsWasModuleItemProvider ihsWasModuleItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsWasModule}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsWasModuleAdapter() {
		if (ihsWasModuleItemProvider == null) {
			ihsWasModuleItemProvider = new IhsWasModuleItemProvider(this);
		}

		return ihsWasModuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected IhsWasModuleUnitItemProvider ihsWasModuleUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createIhsWasModuleUnitAdapter() {
		if (ihsWasModuleUnitItemProvider == null) {
			ihsWasModuleUnitItemProvider = new IhsWasModuleUnitItemProvider(this);
		}

		return ihsWasModuleUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.LinuxIhsSystem} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected LinuxIhsSystemItemProvider linuxIhsSystemItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.LinuxIhsSystem}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createLinuxIhsSystemAdapter() {
		if (linuxIhsSystemItemProvider == null) {
			linuxIhsSystemItemProvider = new LinuxIhsSystemItemProvider(this);
		}

		return linuxIhsSystemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.ihs.WindowsIhsSystem} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected WindowsIhsSystemItemProvider windowsIhsSystemItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.ihs.WindowsIhsSystem}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Adapter createWindowsIhsSystemAdapter() {
		if (windowsIhsSystemItemProvider == null) {
			windowsIhsSystemItemProvider = new WindowsIhsSystemItemProvider(this);
		}

		return windowsIhsSystemItemProvider;
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
		if (ihsDeployRootItemProvider != null) ihsDeployRootItemProvider.dispose();
		if (ihsModuleItemProvider != null) ihsModuleItemProvider.dispose();
		if (ihsServerItemProvider != null) ihsServerItemProvider.dispose();
		if (ihsServerUnitItemProvider != null) ihsServerUnitItemProvider.dispose();
		if (ihsSystemItemProvider != null) ihsSystemItemProvider.dispose();
		if (ihsSystemUnitItemProvider != null) ihsSystemUnitItemProvider.dispose();
		if (ihsUserItemProvider != null) ihsUserItemProvider.dispose();
		if (ihsUserRepositoryItemProvider != null) ihsUserRepositoryItemProvider.dispose();
		if (ihsUserUnitItemProvider != null) ihsUserUnitItemProvider.dispose();
		if (ihsWasAdminModuleItemProvider != null) ihsWasAdminModuleItemProvider.dispose();
		if (ihsWasAdminModuleUnitItemProvider != null) ihsWasAdminModuleUnitItemProvider.dispose();
		if (ihsWasModuleItemProvider != null) ihsWasModuleItemProvider.dispose();
		if (ihsWasModuleUnitItemProvider != null) ihsWasModuleUnitItemProvider.dispose();
		if (linuxIhsSystemItemProvider != null) linuxIhsSystemItemProvider.dispose();
		if (windowsIhsSystemItemProvider != null) windowsIhsSystemItemProvider.dispose();
	}

}
