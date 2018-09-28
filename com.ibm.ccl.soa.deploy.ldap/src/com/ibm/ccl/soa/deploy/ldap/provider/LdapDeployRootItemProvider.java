/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.provider;

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

import com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot;
import com.ibm.ccl.soa.deploy.ldap.LdapFactory;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class LdapDeployRootItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public LdapDeployRootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_EPERSON);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT);
			childrenFeatures.add(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT);
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
	 * This returns LdapDeployRoot.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LdapDeployRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_LdapDeployRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(LdapDeployRoot.class)) {
			case LdapPackage.LDAP_DEPLOY_ROOT__MIXED:
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY:
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER:
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_EPERSON:
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON:
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION:
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON:
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_PERSON:
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT:
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT:
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT:
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
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT,
					 LdapFactory.eINSTANCE.createLdapClient())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY,
					 LdapFactory.eINSTANCE.createLdapEntry())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF,
					 LdapFactory.eINSTANCE.createLdapLdif())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA,
					 LdapFactory.eINSTANCE.createLdapSchema())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER,
					 LdapFactory.eINSTANCE.createLdapServer())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX,
					 LdapFactory.eINSTANCE.createLdapSuffix())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_EPERSON,
					 LdapFactory.eINSTANCE.createEPerson())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON,
					 LdapFactory.eINSTANCE.createInetOrgPerson())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION,
					 LdapFactory.eINSTANCE.createOrganization())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON,
					 LdapFactory.eINSTANCE.createOrganizationalPerson())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON,
					 LdapFactory.eINSTANCE.createInetOrgPerson())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON,
					 LdapFactory.eINSTANCE.createPerson())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON,
					 LdapFactory.eINSTANCE.createOrganizationalPerson())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON,
					 LdapFactory.eINSTANCE.createInetOrgPerson())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT,
					 LdapFactory.eINSTANCE.createLdapEntryUnit())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT,
					 LdapFactory.eINSTANCE.createLdapServerUnit())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT,
					 LdapFactory.eINSTANCE.createLdapSuffixUnit())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT,
					 LdapFactory.eINSTANCE.createLdapClientUnit())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT,
					 LdapFactory.eINSTANCE.createLdapLdifUnit())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE,
					 LdapFactory.eINSTANCE.createSecurityRoleReferenceUnit())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT,
					 LdapFactory.eINSTANCE.createLdapSchemaUnit())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT,
					 LdapFactory.eINSTANCE.createLdifArtifact())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT,
					 LdapFactory.eINSTANCE.createSchemaArtifact())));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY,
				 LdapFactory.eINSTANCE.createLdapEntry()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER,
				 LdapFactory.eINSTANCE.createLdapServer()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_EPERSON,
				 LdapFactory.eINSTANCE.createEPerson()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON,
				 LdapFactory.eINSTANCE.createInetOrgPerson()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION,
				 LdapFactory.eINSTANCE.createOrganization()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON,
				 LdapFactory.eINSTANCE.createOrganizationalPerson()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON,
				 LdapFactory.eINSTANCE.createInetOrgPerson()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON,
				 LdapFactory.eINSTANCE.createPerson()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON,
				 LdapFactory.eINSTANCE.createOrganizationalPerson()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON,
				 LdapFactory.eINSTANCE.createInetOrgPerson()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT,
				 LdapFactory.eINSTANCE.createLdapEntryUnit()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT,
				 LdapFactory.eINSTANCE.createLdapServerUnit()));

		newChildDescriptors.add
			(createChildParameter
				(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT,
				 LdapFactory.eINSTANCE.createLdapSuffixUnit()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY ||
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER ||
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_EPERSON ||
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON ||
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON ||
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON ||
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION ||
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT ||
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT ||
			childFeature == LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
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
		if (feature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)feature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)child;
			feature = entry.getEStructuralFeature();
			child = entry.getValue();        
		}

		if (feature instanceof EReference && child instanceof EObject) {
			String name = "full/obj16/" + ((EObject)child).eClass().getName(); //$NON-NLS-1$

			try {
				return getResourceLocator().getImage(name);
			}
			catch (Exception e) {
				LdapDomainEditPlugin.INSTANCE.log(e);
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
		return LdapDomainEditPlugin.INSTANCE;
	}

}
