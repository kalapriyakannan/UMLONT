/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.os.OperatingSystemRoot;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class OperatingSystemRootItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public OperatingSystemRootItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
	 * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT);
			childrenFeatures.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT);
			childrenFeatures
					.add(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns OperatingSystemRoot.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OperatingSystemRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_OperatingSystemRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(OperatingSystemRoot.class))
		{
		case OsPackage.OPERATING_SYSTEM_ROOT__MIXED:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM:
		case OsPackage.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT:
		case OsPackage.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true,
					false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
						FeatureMapUtil.createEntry(
								XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT, ""))); //$NON-NLS-1$

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, ""))); //$NON-NLS-1$

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
						XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP,
						OsFactory.eINSTANCE.createAIXLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE,
						OsFactory.eINSTANCE.createAIXLocalService())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER,
						OsFactory.eINSTANCE.createAIXLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createAIXOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE,
						OsFactory.eINSTANCE.createDataFile())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY,
						OsFactory.eINSTANCE.createDirectory())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY,
						OsFactory.eINSTANCE.createUnixDirectory())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY,
						OsFactory.eINSTANCE.createWindowsDirectory())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
						OsFactory.eINSTANCE.createFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
						OsFactory.eINSTANCE.createLocalFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
						OsFactory.eINSTANCE.createRemoteFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
						OsFactory.eINSTANCE.createNFSFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
						OsFactory.eINSTANCE.createOpenVmsFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
						OsFactory.eINSTANCE.createSMBFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
						OsFactory.eINSTANCE.createUnixFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
						OsFactory.eINSTANCE.createSolarisFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM,
						OsFactory.eINSTANCE.createWindowsFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
						OsFactory.eINSTANCE.createFileSystemContent())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
						OsFactory.eINSTANCE.createDataFile())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
						OsFactory.eINSTANCE.createDirectory())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
						OsFactory.eINSTANCE.createUnixDirectory())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
						OsFactory.eINSTANCE.createWindowsDirectory())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP,
						OsFactory.eINSTANCE.createLinuxLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP,
						OsFactory.eINSTANCE.createRedhatLinuxLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP,
						OsFactory.eINSTANCE.createSUSELinuxLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE,
						OsFactory.eINSTANCE.createLinuxLocalService())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE,
						OsFactory.eINSTANCE.createRedhatLinuxLocalService())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE,
						OsFactory.eINSTANCE.createSUSELinuxLocalService())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER,
						OsFactory.eINSTANCE.createLinuxLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER,
						OsFactory.eINSTANCE.createRedhatLinuxLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER,
						OsFactory.eINSTANCE.createSUSELinuxLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createLinuxOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createRedhatLinuxOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createSUSELinuxOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
						OsFactory.eINSTANCE.createLocalFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
						OsFactory.eINSTANCE.createOpenVmsFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
						OsFactory.eINSTANCE.createUnixFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
						OsFactory.eINSTANCE.createSolarisFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
						OsFactory.eINSTANCE.createWindowsFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM,
						OsFactory.eINSTANCE.createNFSFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM,
						OsFactory.eINSTANCE.createOpenVmsFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createAIXOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createLinuxOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createRedhatLinuxOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createSUSELinuxOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createWindowsOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT,
						OsFactory.eINSTANCE.createPort())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER,
						OsFactory.eINSTANCE.createPortConsumer())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP,
						OsFactory.eINSTANCE.createRedhatLinuxLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE,
						OsFactory.eINSTANCE.createRedhatLinuxLocalService())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER,
						OsFactory.eINSTANCE.createRedhatLinuxLocalUser())));

		newChildDescriptors
				.add(createChildParameter(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
						FeatureMapUtil
								.createEntry(
										OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM,
										OsFactory.eINSTANCE.createRedhatLinuxOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM,
						OsFactory.eINSTANCE.createRemoteFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM,
						OsFactory.eINSTANCE.createNFSFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM,
						OsFactory.eINSTANCE.createSMBFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM,
						OsFactory.eINSTANCE.createSMBFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM,
						OsFactory.eINSTANCE.createSolarisFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP,
						OsFactory.eINSTANCE.createSUSELinuxLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE,
						OsFactory.eINSTANCE.createSUSELinuxLocalService())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER,
						OsFactory.eINSTANCE.createSUSELinuxLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createSUSELinuxOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY,
						OsFactory.eINSTANCE.createUnixDirectory())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM,
						OsFactory.eINSTANCE.createUnixFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM,
						OsFactory.eINSTANCE.createSolarisFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER,
						OsFactory.eINSTANCE.createUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER,
						OsFactory.eINSTANCE.createAIXLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER,
						OsFactory.eINSTANCE.createLinuxLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER,
						OsFactory.eINSTANCE.createRedhatLinuxLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER,
						OsFactory.eINSTANCE.createSUSELinuxLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER,
						OsFactory.eINSTANCE.createWindowsLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP,
						OsFactory.eINSTANCE.createUserGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP,
						OsFactory.eINSTANCE.createAIXLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP,
						OsFactory.eINSTANCE.createLinuxLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP,
						OsFactory.eINSTANCE.createRedhatLinuxLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP,
						OsFactory.eINSTANCE.createSUSELinuxLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP,
						OsFactory.eINSTANCE.createWindowsLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY,
						OsFactory.eINSTANCE.createWindowsDirectory())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM,
						OsFactory.eINSTANCE.createWindowsFileSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP,
						OsFactory.eINSTANCE.createWindowsLocalGroup())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE,
						OsFactory.eINSTANCE.createWindowsLocalService())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER,
						OsFactory.eINSTANCE.createWindowsLocalUser())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM,
						OsFactory.eINSTANCE.createWindowsOperatingSystem())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP,
						OsFactory.eINSTANCE.createAIXLocalGroupUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT,
						OsFactory.eINSTANCE.createAIXLocalServiceUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER,
						OsFactory.eINSTANCE.createAIXLocalUserUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createAIXOperatingSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT,
						OsFactory.eINSTANCE.createDataFileUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT,
						OsFactory.eINSTANCE.createDirectoryUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT,
						OsFactory.eINSTANCE.createFileSystemContentUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT,
						OsFactory.eINSTANCE.createDataFileUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT,
						OsFactory.eINSTANCE.createDirectoryUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createLocalFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createRemoteFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createNFSFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createOpenVmsFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createSMBFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createUnixFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createSolarisFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createWindowsFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP,
						OsFactory.eINSTANCE.createLinuxLocalGroupUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT,
						OsFactory.eINSTANCE.createLinuxLocalServiceUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER,
						OsFactory.eINSTANCE.createLinuxLocalUserUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createLinuxOperatingSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createLocalFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createOpenVmsFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createUnixFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createSolarisFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createWindowsFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createNFSFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createOpenVmsFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createOperatingSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createAIXOperatingSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createLinuxOperatingSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createWindowsOperatingSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT,
						OsFactory.eINSTANCE.createPortConfigUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createRemoteFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createNFSFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createSMBFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createSMBFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createSolarisFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createUnixFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createSolarisFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER,
						OsFactory.eINSTANCE.createUserUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER,
						OsFactory.eINSTANCE.createAIXLocalUserUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER,
						OsFactory.eINSTANCE.createLinuxLocalUserUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER,
						OsFactory.eINSTANCE.createWindowsLocalUserUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP,
						OsFactory.eINSTANCE.createUserGroupUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP,
						OsFactory.eINSTANCE.createAIXLocalGroupUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP,
						OsFactory.eINSTANCE.createLinuxLocalGroupUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP,
						OsFactory.eINSTANCE.createWindowsLocalGroupUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createWindowsFileSystemUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP,
						OsFactory.eINSTANCE.createWindowsLocalGroupUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT,
						OsFactory.eINSTANCE.createWindowsLocalServiceUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER,
						OsFactory.eINSTANCE.createWindowsLocalUserUnit())));

		newChildDescriptors.add(createChildParameter(OsPackage.Literals.OPERATING_SYSTEM_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT,
						OsFactory.eINSTANCE.createWindowsOperatingSystemUnit())));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE, OsFactory.eINSTANCE
						.createDataFile()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, OsFactory.eINSTANCE
						.createFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, OsFactory.eINSTANCE
						.createLocalFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, OsFactory.eINSTANCE
						.createRemoteFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, OsFactory.eINSTANCE
						.createNFSFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, OsFactory.eINSTANCE
						.createOpenVmsFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, OsFactory.eINSTANCE
						.createSMBFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, OsFactory.eINSTANCE
						.createUnixFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, OsFactory.eINSTANCE
						.createSolarisFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM, OsFactory.eINSTANCE
						.createWindowsFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
				OsFactory.eINSTANCE.createFileSystemContent()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
				OsFactory.eINSTANCE.createDataFile()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
				OsFactory.eINSTANCE.createDirectory()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
				OsFactory.eINSTANCE.createUnixDirectory()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT,
				OsFactory.eINSTANCE.createWindowsDirectory()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
				OsFactory.eINSTANCE.createLocalFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
				OsFactory.eINSTANCE.createOpenVmsFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
				OsFactory.eINSTANCE.createUnixFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
				OsFactory.eINSTANCE.createSolarisFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM,
				OsFactory.eINSTANCE.createWindowsFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM,
				OsFactory.eINSTANCE.createNFSFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM,
				OsFactory.eINSTANCE.createOpenVmsFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM,
				OsFactory.eINSTANCE.createRemoteFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM,
				OsFactory.eINSTANCE.createNFSFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM,
				OsFactory.eINSTANCE.createSMBFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM,
				OsFactory.eINSTANCE.createSMBFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM,
				OsFactory.eINSTANCE.createSolarisFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM,
				OsFactory.eINSTANCE.createUnixFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM,
				OsFactory.eINSTANCE.createSolarisFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM,
				OsFactory.eINSTANCE.createWindowsFileSystem()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT, OsFactory.eINSTANCE
						.createDataFileUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT, OsFactory.eINSTANCE
						.createDirectoryUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT,
				OsFactory.eINSTANCE.createFileSystemContentUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT,
				OsFactory.eINSTANCE.createDataFileUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT,
				OsFactory.eINSTANCE.createDirectoryUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, OsFactory.eINSTANCE
						.createFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, OsFactory.eINSTANCE
						.createLocalFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, OsFactory.eINSTANCE
						.createRemoteFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, OsFactory.eINSTANCE
						.createNFSFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, OsFactory.eINSTANCE
						.createOpenVmsFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, OsFactory.eINSTANCE
						.createSMBFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, OsFactory.eINSTANCE
						.createUnixFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, OsFactory.eINSTANCE
						.createSolarisFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT, OsFactory.eINSTANCE
						.createWindowsFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createLocalFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createOpenVmsFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createUnixFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createSolarisFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createWindowsFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createNFSFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createOpenVmsFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createRemoteFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createNFSFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createSMBFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createSMBFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createSolarisFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createUnixFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createSolarisFileSystemUnit()));

		newChildDescriptors.add(createChildParameter(
				OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT,
				OsFactory.eINSTANCE.createWindowsFileSystemUnit()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		if (childFeature instanceof EStructuralFeature
				&& FeatureMapUtil.isFeatureMap((EStructuralFeature) childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify = childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER
				|| childFeature == OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
					new Object[] { getTypeText(childObject), getFeatureText(childFeature),
							getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * This returns the icon image for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getCreateChildImage(Object owner, Object feature, Object child,
			Collection selection) {
		if (feature instanceof EStructuralFeature
				&& FeatureMapUtil.isFeatureMap((EStructuralFeature) feature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) child;
			feature = entry.getEStructuralFeature();
			child = entry.getValue();
		}

		if (feature instanceof EReference && child instanceof EObject) {
			String name = "full/obj16/" + ((EObject) child).eClass().getName(); //$NON-NLS-1$

			try {
				return getResourceLocator().getImage(name);
			} catch (Exception e) {
				OsEditPlugin.INSTANCE.log(e);
			}
		}

		return super.getCreateChildImage(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return OsEditPlugin.INSTANCE;
	}

}
