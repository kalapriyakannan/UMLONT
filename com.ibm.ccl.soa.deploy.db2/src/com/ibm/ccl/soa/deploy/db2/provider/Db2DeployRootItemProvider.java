/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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

import com.ibm.ccl.soa.deploy.db2.Db2DeployRoot;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class Db2DeployRootItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public Db2DeployRootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED);
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
	 * This returns Db2DeployRoot.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Db2DeployRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_Db2DeployRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Db2DeployRoot.class)) {
			case Db2Package.DB2_DEPLOY_ROOT__MIXED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT,
					 Db2Factory.eINSTANCE.createDB2AdminClient())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER,
					 Db2Factory.eINSTANCE.createDB2AdminServer())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER,
					 Db2Factory.eINSTANCE.createUnixDB2AdminServer())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER,
					 Db2Factory.eINSTANCE.createWindowsDB2AdminServer())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT,
					 Db2Factory.eINSTANCE.createDB2AppDevelClient())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE,
					 Db2Factory.eINSTANCE.createDB2BaseInstance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE,
					 Db2Factory.eINSTANCE.createDB2ClientInstance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE,
					 Db2Factory.eINSTANCE.createDB2Instance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE,
					 Db2Factory.eINSTANCE.createUnixDB2ClientInstance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE,
					 Db2Factory.eINSTANCE.createUnixDB2Instance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE,
					 Db2Factory.eINSTANCE.createWindowsDB2ClientInstance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE,
					 Db2Factory.eINSTANCE.createWindowsDB2Instance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE,
					 Db2Factory.eINSTANCE.createDB2CatalogedNode())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT,
					 Db2Factory.eINSTANCE.createDB2Client())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT,
					 Db2Factory.eINSTANCE.createDB2AdminClient())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT,
					 Db2Factory.eINSTANCE.createDB2AppDevelClient())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE,
					 Db2Factory.eINSTANCE.createDB2ClientInstance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE,
					 Db2Factory.eINSTANCE.createUnixDB2ClientInstance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE,
					 Db2Factory.eINSTANCE.createWindowsDB2ClientInstance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE,
					 Db2Factory.eINSTANCE.createDB2Database())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE,
					 Db2Factory.eINSTANCE.createDB2Instance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE,
					 Db2Factory.eINSTANCE.createUnixDB2Instance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE,
					 Db2Factory.eINSTANCE.createWindowsDB2Instance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER,
					 Db2Factory.eINSTANCE.createDB2JdbcDriver())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM,
					 Db2Factory.eINSTANCE.createDB2System())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM,
					 Db2Factory.eINSTANCE.createUnixDB2System())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM,
					 Db2Factory.eINSTANCE.createWindowsDB2System())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER,
					 Db2Factory.eINSTANCE.createUnixDB2AdminServer())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE,
					 Db2Factory.eINSTANCE.createUnixDB2ClientInstance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE,
					 Db2Factory.eINSTANCE.createUnixDB2Instance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM,
					 Db2Factory.eINSTANCE.createUnixDB2System())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER,
					 Db2Factory.eINSTANCE.createWindowsDB2AdminServer())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE,
					 Db2Factory.eINSTANCE.createWindowsDB2ClientInstance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE,
					 Db2Factory.eINSTANCE.createWindowsDB2Instance())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM,
					 Db2Factory.eINSTANCE.createWindowsDB2System())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT,
					 Db2Factory.eINSTANCE.createDB2AdminClientUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT,
					 Db2Factory.eINSTANCE.createDB2AdminServerUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT,
					 Db2Factory.eINSTANCE.createDB2AppDevelClientUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT,
					 Db2Factory.eINSTANCE.createDB2BaseClientUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT,
					 Db2Factory.eINSTANCE.createDB2AdminClientUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT,
					 Db2Factory.eINSTANCE.createDB2AppDevelClientUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT,
					 Db2Factory.eINSTANCE.createDB2RuntimeClientUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT,
					 Db2Factory.eINSTANCE.createDB2CatalogUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT,
					 Db2Factory.eINSTANCE.createDB2ClientInstanceUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT,
					 Db2Factory.eINSTANCE.createDB2DatabaseUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2DDL,
					 Db2Factory.eINSTANCE.createDB2DDLArtifact())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT,
					 Db2Factory.eINSTANCE.createDB2InstanceUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT,
					 Db2Factory.eINSTANCE.createDB2NodeCatalogUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT,
					 Db2Factory.eINSTANCE.createDB2RuntimeClientUnit())));

		newChildDescriptors.add
			(createChildParameter
				(Db2Package.Literals.DB2_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT,
					 Db2Factory.eINSTANCE.createDB2SystemUnit())));
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

		if (childFeature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify =
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT ||
			childFeature == Db2Package.Literals.DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return Db2DomainEditPlugin.INSTANCE;
	}

}
