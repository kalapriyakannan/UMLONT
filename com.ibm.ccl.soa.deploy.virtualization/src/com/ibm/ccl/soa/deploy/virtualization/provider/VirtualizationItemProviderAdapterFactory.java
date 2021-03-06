/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationItemProviderAdapterFactory.java,v 1.7 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.provider;

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

import com.ibm.ccl.soa.deploy.virtualization.util.VirtualizationAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualizationItemProviderAdapterFactory extends VirtualizationAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection supportedTypes = new ArrayList();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualizationItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.Hypervisor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HypervisorItemProvider hypervisorItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.Hypervisor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createHypervisorAdapter() {
		if (hypervisorItemProvider == null) {
			hypervisorItemProvider = new HypervisorItemProvider(this);
		}

		return hypervisorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualDiskDefItemProvider virtualDiskDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualDiskDefAdapter() {
		if (virtualDiskDefItemProvider == null) {
			virtualDiskDefItemProvider = new VirtualDiskDefItemProvider(this);
		}

		return virtualDiskDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDefUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualDiskDefUnitItemProvider virtualDiskDefUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDefUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualDiskDefUnitAdapter() {
		if (virtualDiskDefUnitItemProvider == null) {
			virtualDiskDefUnitItemProvider = new VirtualDiskDefUnitItemProvider(this);
		}

		return virtualDiskDefUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualDiskSnapshotItemProvider virtualDiskSnapshotItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualDiskSnapshotAdapter() {
		if (virtualDiskSnapshotItemProvider == null) {
			virtualDiskSnapshotItemProvider = new VirtualDiskSnapshotItemProvider(this);
		}

		return virtualDiskSnapshotItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshotUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualDiskSnapshotUnitItemProvider virtualDiskSnapshotUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshotUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualDiskSnapshotUnitAdapter() {
		if (virtualDiskSnapshotUnitItemProvider == null) {
			virtualDiskSnapshotUnitItemProvider = new VirtualDiskSnapshotUnitItemProvider(this);
		}

		return virtualDiskSnapshotUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualEthernetNICDefItemProvider virtualEthernetNICDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualEthernetNICDefAdapter() {
		if (virtualEthernetNICDefItemProvider == null) {
			virtualEthernetNICDefItemProvider = new VirtualEthernetNICDefItemProvider(this);
		}

		return virtualEthernetNICDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDefUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualEthernetNICDefUnitItemProvider virtualEthernetNICDefUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDefUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualEthernetNICDefUnitAdapter() {
		if (virtualEthernetNICDefUnitItemProvider == null) {
			virtualEthernetNICDefUnitItemProvider = new VirtualEthernetNICDefUnitItemProvider(this);
		}

		return virtualEthernetNICDefUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualImageItemProvider virtualImageItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualImageAdapter() {
		if (virtualImageItemProvider == null) {
			virtualImageItemProvider = new VirtualImageItemProvider(this);
		}

		return virtualImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualImageCollectionItemProvider virtualImageCollectionItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualImageCollectionAdapter() {
		if (virtualImageCollectionItemProvider == null) {
			virtualImageCollectionItemProvider = new VirtualImageCollectionItemProvider(this);
		}

		return virtualImageCollectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollectionUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualImageCollectionUnitItemProvider virtualImageCollectionUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollectionUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualImageCollectionUnitAdapter() {
		if (virtualImageCollectionUnitItemProvider == null) {
			virtualImageCollectionUnitItemProvider = new VirtualImageCollectionUnitItemProvider(this);
		}

		return virtualImageCollectionUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageSnapshotContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualImageSnapshotContainerItemProvider virtualImageSnapshotContainerItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageSnapshotContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualImageSnapshotContainerAdapter() {
		if (virtualImageSnapshotContainerItemProvider == null) {
			virtualImageSnapshotContainerItemProvider = new VirtualImageSnapshotContainerItemProvider(this);
		}

		return virtualImageSnapshotContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualImageUnitItemProvider virtualImageUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualImageUnitAdapter() {
		if (virtualImageUnitItemProvider == null) {
			virtualImageUnitItemProvider = new VirtualImageUnitItemProvider(this);
		}

		return virtualImageUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualizationRootItemProvider virtualizationRootItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualizationRootAdapter() {
		if (virtualizationRootItemProvider == null) {
			virtualizationRootItemProvider = new VirtualizationRootItemProvider(this);
		}

		return virtualizationRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualServerDefItemProvider virtualServerDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualServerDefAdapter() {
		if (virtualServerDefItemProvider == null) {
			virtualServerDefItemProvider = new VirtualServerDefItemProvider(this);
		}

		return virtualServerDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualServerSnapshotItemProvider virtualServerSnapshotItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualServerSnapshotAdapter() {
		if (virtualServerSnapshotItemProvider == null) {
			virtualServerSnapshotItemProvider = new VirtualServerSnapshotItemProvider(this);
		}

		return virtualServerSnapshotItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshotUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualServerSnapshotUnitItemProvider virtualServerSnapshotUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshotUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVirtualServerSnapshotUnitAdapter() {
		if (virtualServerSnapshotUnitItemProvider == null) {
			virtualServerSnapshotUnitItemProvider = new VirtualServerSnapshotUnitItemProvider(this);
		}

		return virtualServerSnapshotUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareESX} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareESXItemProvider vMwareESXItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareESX}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareESXAdapter() {
		if (vMwareESXItemProvider == null) {
			vMwareESXItemProvider = new VMwareESXItemProvider(this);
		}

		return vMwareESXItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareESXUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareESXUnitItemProvider vMwareESXUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareESXUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareESXUnitAdapter() {
		if (vMwareESXUnitItemProvider == null) {
			vMwareESXUnitItemProvider = new VMwareESXUnitItemProvider(this);
		}

		return vMwareESXUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareHypervisorItemProvider vMwareHypervisorItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareHypervisorAdapter() {
		if (vMwareHypervisorItemProvider == null) {
			vMwareHypervisorItemProvider = new VMwareHypervisorItemProvider(this);
		}

		return vMwareHypervisorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualDiskDefItemProvider vMwareVirtualDiskDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualDiskDefAdapter() {
		if (vMwareVirtualDiskDefItemProvider == null) {
			vMwareVirtualDiskDefItemProvider = new VMwareVirtualDiskDefItemProvider(this);
		}

		return vMwareVirtualDiskDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDefUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualDiskDefUnitItemProvider vMwareVirtualDiskDefUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDefUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualDiskDefUnitAdapter() {
		if (vMwareVirtualDiskDefUnitItemProvider == null) {
			vMwareVirtualDiskDefUnitItemProvider = new VMwareVirtualDiskDefUnitItemProvider(this);
		}

		return vMwareVirtualDiskDefUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualDiskSnapshotItemProvider vMwareVirtualDiskSnapshotItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualDiskSnapshotAdapter() {
		if (vMwareVirtualDiskSnapshotItemProvider == null) {
			vMwareVirtualDiskSnapshotItemProvider = new VMwareVirtualDiskSnapshotItemProvider(this);
		}

		return vMwareVirtualDiskSnapshotItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshotUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualDiskSnapshotUnitItemProvider vMwareVirtualDiskSnapshotUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshotUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualDiskSnapshotUnitAdapter() {
		if (vMwareVirtualDiskSnapshotUnitItemProvider == null) {
			vMwareVirtualDiskSnapshotUnitItemProvider = new VMwareVirtualDiskSnapshotUnitItemProvider(this);
		}

		return vMwareVirtualDiskSnapshotUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualEthernetNICDefItemProvider vMwareVirtualEthernetNICDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualEthernetNICDefAdapter() {
		if (vMwareVirtualEthernetNICDefItemProvider == null) {
			vMwareVirtualEthernetNICDefItemProvider = new VMwareVirtualEthernetNICDefItemProvider(this);
		}

		return vMwareVirtualEthernetNICDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDefUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualEthernetNICDefUnitItemProvider vMwareVirtualEthernetNICDefUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDefUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualEthernetNICDefUnitAdapter() {
		if (vMwareVirtualEthernetNICDefUnitItemProvider == null) {
			vMwareVirtualEthernetNICDefUnitItemProvider = new VMwareVirtualEthernetNICDefUnitItemProvider(this);
		}

		return vMwareVirtualEthernetNICDefUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualIDEDiskDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualIDEDiskDefItemProvider vMwareVirtualIDEDiskDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualIDEDiskDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualIDEDiskDefAdapter() {
		if (vMwareVirtualIDEDiskDefItemProvider == null) {
			vMwareVirtualIDEDiskDefItemProvider = new VMwareVirtualIDEDiskDefItemProvider(this);
		}

		return vMwareVirtualIDEDiskDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualImageItemProvider vMwareVirtualImageItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualImageAdapter() {
		if (vMwareVirtualImageItemProvider == null) {
			vMwareVirtualImageItemProvider = new VMwareVirtualImageItemProvider(this);
		}

		return vMwareVirtualImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualImageSnapshotContainerItemProvider vMwareVirtualImageSnapshotContainerItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualImageSnapshotContainerAdapter() {
		if (vMwareVirtualImageSnapshotContainerItemProvider == null) {
			vMwareVirtualImageSnapshotContainerItemProvider = new VMwareVirtualImageSnapshotContainerItemProvider(this);
		}

		return vMwareVirtualImageSnapshotContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualImageUnitItemProvider vMwareVirtualImageUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualImageUnitAdapter() {
		if (vMwareVirtualImageUnitItemProvider == null) {
			vMwareVirtualImageUnitItemProvider = new VMwareVirtualImageUnitItemProvider(this);
		}

		return vMwareVirtualImageUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualSCSIDiskDefItemProvider vMwareVirtualSCSIDiskDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualSCSIDiskDefAdapter() {
		if (vMwareVirtualSCSIDiskDefItemProvider == null) {
			vMwareVirtualSCSIDiskDefItemProvider = new VMwareVirtualSCSIDiskDefItemProvider(this);
		}

		return vMwareVirtualSCSIDiskDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualServerDefItemProvider vMwareVirtualServerDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualServerDefAdapter() {
		if (vMwareVirtualServerDefItemProvider == null) {
			vMwareVirtualServerDefItemProvider = new VMwareVirtualServerDefItemProvider(this);
		}

		return vMwareVirtualServerDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualServerSnapshotItemProvider vMwareVirtualServerSnapshotItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualServerSnapshotAdapter() {
		if (vMwareVirtualServerSnapshotItemProvider == null) {
			vMwareVirtualServerSnapshotItemProvider = new VMwareVirtualServerSnapshotItemProvider(this);
		}

		return vMwareVirtualServerSnapshotItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshotUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualServerSnapshotUnitItemProvider vMwareVirtualServerSnapshotUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshotUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createVMwareVirtualServerSnapshotUnitAdapter() {
		if (vMwareVirtualServerSnapshotUnitItemProvider == null) {
			vMwareVirtualServerSnapshotUnitItemProvider = new VMwareVirtualServerSnapshotUnitItemProvider(this);
		}

		return vMwareVirtualServerSnapshotUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.XenHypervisor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenHypervisorItemProvider xenHypervisorItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.XenHypervisor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createXenHypervisorAdapter() {
		if (xenHypervisorItemProvider == null) {
			xenHypervisorItemProvider = new XenHypervisorItemProvider(this);
		}

		return xenHypervisorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualDiskDefItemProvider xenVirtualDiskDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createXenVirtualDiskDefAdapter() {
		if (xenVirtualDiskDefItemProvider == null) {
			xenVirtualDiskDefItemProvider = new XenVirtualDiskDefItemProvider(this);
		}

		return xenVirtualDiskDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDefUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualDiskDefUnitItemProvider xenVirtualDiskDefUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDefUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createXenVirtualDiskDefUnitAdapter() {
		if (xenVirtualDiskDefUnitItemProvider == null) {
			xenVirtualDiskDefUnitItemProvider = new XenVirtualDiskDefUnitItemProvider(this);
		}

		return xenVirtualDiskDefUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualEthernetNICDefItemProvider xenVirtualEthernetNICDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createXenVirtualEthernetNICDefAdapter() {
		if (xenVirtualEthernetNICDefItemProvider == null) {
			xenVirtualEthernetNICDefItemProvider = new XenVirtualEthernetNICDefItemProvider(this);
		}

		return xenVirtualEthernetNICDefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDefUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualEthernetNICDefUnitItemProvider xenVirtualEthernetNICDefUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDefUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createXenVirtualEthernetNICDefUnitAdapter() {
		if (xenVirtualEthernetNICDefUnitItemProvider == null) {
			xenVirtualEthernetNICDefUnitItemProvider = new XenVirtualEthernetNICDefUnitItemProvider(this);
		}

		return xenVirtualEthernetNICDefUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualImageItemProvider xenVirtualImageItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createXenVirtualImageAdapter() {
		if (xenVirtualImageItemProvider == null) {
			xenVirtualImageItemProvider = new XenVirtualImageItemProvider(this);
		}

		return xenVirtualImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImageUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualImageUnitItemProvider xenVirtualImageUnitItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImageUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createXenVirtualImageUnitAdapter() {
		if (xenVirtualImageUnitItemProvider == null) {
			xenVirtualImageUnitItemProvider = new XenVirtualImageUnitItemProvider(this);
		}

		return xenVirtualImageUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualServerDef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualServerDefItemProvider xenVirtualServerDefItemProvider;

	/**
	 * This creates an adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualServerDef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createXenVirtualServerDefAdapter() {
		if (xenVirtualServerDefItemProvider == null) {
			xenVirtualServerDefItemProvider = new XenVirtualServerDefItemProvider(this);
		}

		return xenVirtualServerDefItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (hypervisorItemProvider != null) hypervisorItemProvider.dispose();
		if (virtualDiskDefItemProvider != null) virtualDiskDefItemProvider.dispose();
		if (virtualDiskDefUnitItemProvider != null) virtualDiskDefUnitItemProvider.dispose();
		if (virtualDiskSnapshotItemProvider != null) virtualDiskSnapshotItemProvider.dispose();
		if (virtualDiskSnapshotUnitItemProvider != null) virtualDiskSnapshotUnitItemProvider.dispose();
		if (virtualEthernetNICDefItemProvider != null) virtualEthernetNICDefItemProvider.dispose();
		if (virtualEthernetNICDefUnitItemProvider != null) virtualEthernetNICDefUnitItemProvider.dispose();
		if (virtualImageItemProvider != null) virtualImageItemProvider.dispose();
		if (virtualImageCollectionItemProvider != null) virtualImageCollectionItemProvider.dispose();
		if (virtualImageCollectionUnitItemProvider != null) virtualImageCollectionUnitItemProvider.dispose();
		if (virtualImageSnapshotContainerItemProvider != null) virtualImageSnapshotContainerItemProvider.dispose();
		if (virtualImageUnitItemProvider != null) virtualImageUnitItemProvider.dispose();
		if (virtualizationRootItemProvider != null) virtualizationRootItemProvider.dispose();
		if (virtualServerDefItemProvider != null) virtualServerDefItemProvider.dispose();
		if (virtualServerSnapshotItemProvider != null) virtualServerSnapshotItemProvider.dispose();
		if (virtualServerSnapshotUnitItemProvider != null) virtualServerSnapshotUnitItemProvider.dispose();
		if (vMwareESXItemProvider != null) vMwareESXItemProvider.dispose();
		if (vMwareESXUnitItemProvider != null) vMwareESXUnitItemProvider.dispose();
		if (vMwareHypervisorItemProvider != null) vMwareHypervisorItemProvider.dispose();
		if (vMwareVirtualDiskDefItemProvider != null) vMwareVirtualDiskDefItemProvider.dispose();
		if (vMwareVirtualDiskDefUnitItemProvider != null) vMwareVirtualDiskDefUnitItemProvider.dispose();
		if (vMwareVirtualDiskSnapshotItemProvider != null) vMwareVirtualDiskSnapshotItemProvider.dispose();
		if (vMwareVirtualDiskSnapshotUnitItemProvider != null) vMwareVirtualDiskSnapshotUnitItemProvider.dispose();
		if (vMwareVirtualEthernetNICDefItemProvider != null) vMwareVirtualEthernetNICDefItemProvider.dispose();
		if (vMwareVirtualEthernetNICDefUnitItemProvider != null) vMwareVirtualEthernetNICDefUnitItemProvider.dispose();
		if (vMwareVirtualIDEDiskDefItemProvider != null) vMwareVirtualIDEDiskDefItemProvider.dispose();
		if (vMwareVirtualImageItemProvider != null) vMwareVirtualImageItemProvider.dispose();
		if (vMwareVirtualImageSnapshotContainerItemProvider != null) vMwareVirtualImageSnapshotContainerItemProvider.dispose();
		if (vMwareVirtualImageUnitItemProvider != null) vMwareVirtualImageUnitItemProvider.dispose();
		if (vMwareVirtualSCSIDiskDefItemProvider != null) vMwareVirtualSCSIDiskDefItemProvider.dispose();
		if (vMwareVirtualServerDefItemProvider != null) vMwareVirtualServerDefItemProvider.dispose();
		if (vMwareVirtualServerSnapshotItemProvider != null) vMwareVirtualServerSnapshotItemProvider.dispose();
		if (vMwareVirtualServerSnapshotUnitItemProvider != null) vMwareVirtualServerSnapshotUnitItemProvider.dispose();
		if (xenHypervisorItemProvider != null) xenHypervisorItemProvider.dispose();
		if (xenVirtualDiskDefItemProvider != null) xenVirtualDiskDefItemProvider.dispose();
		if (xenVirtualDiskDefUnitItemProvider != null) xenVirtualDiskDefUnitItemProvider.dispose();
		if (xenVirtualEthernetNICDefItemProvider != null) xenVirtualEthernetNICDefItemProvider.dispose();
		if (xenVirtualEthernetNICDefUnitItemProvider != null) xenVirtualEthernetNICDefUnitItemProvider.dispose();
		if (xenVirtualImageItemProvider != null) xenVirtualImageItemProvider.dispose();
		if (xenVirtualImageUnitItemProvider != null) xenVirtualImageUnitItemProvider.dispose();
		if (xenVirtualServerDefItemProvider != null) xenVirtualServerDefItemProvider.dispose();
	}

}
