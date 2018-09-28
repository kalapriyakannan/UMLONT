/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint.provider;

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

import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot;

/**
 * This is the item provider adapter for a
 * {@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConstraintRootItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintRootItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
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
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED);
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__XMLNS_PREFIX_MAP);
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL);
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE);
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EQUALS);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION);
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PALETTE);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER);
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION);
			childrenFeatures
					.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY);
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TYPE);
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_UPDATE);
			childrenFeatures.add(ConstraintPackage.Literals.CONSTRAINT_ROOT__VALUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ConstraintRoot.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConstraintRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_ConstraintRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ConstraintRoot.class))
		{
		case ConstraintPackage.CONSTRAINT_ROOT__MIXED:
		case ConstraintPackage.CONSTRAINT_ROOT__XMLNS_PREFIX_MAP:
		case ConstraintPackage.CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EQUALS:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PALETTE:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TYPE:
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_UPDATE:
		case ConstraintPackage.CONSTRAINT_ROOT__VALUE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true,
					false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
	 * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT, ""))); //$NON-NLS-1$

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, ""))); //$NON-NLS-1$

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
						XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_AND,
						ConstraintFactory.eINSTANCE.createAndConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION,
						ConstraintFactory.eINSTANCE.createApplicationCommunicationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL,
						ConstraintFactory.eINSTANCE.createApplicationCommunicationProtocolConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF,
						ConstraintFactory.eINSTANCE.createAttributeDefinedConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION,
						ConstraintFactory.eINSTANCE.createAttributePropagationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION,
						ConstraintFactory.eINSTANCE.createBaseCommunicationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION,
						ConstraintFactory.eINSTANCE.createApplicationCommunicationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION,
						ConstraintFactory.eINSTANCE.createNetworkCommunicationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION,
						ConstraintFactory.eINSTANCE.createCollocationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH,
						ConstraintFactory.eINSTANCE.createCommunicationBandwidthConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST,
						ConstraintFactory.eINSTANCE.createCommunicationCostConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT,
						ConstraintFactory.eINSTANCE.createCommunicationPortConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY,
						ConstraintFactory.eINSTANCE.createCommunicationRedundancyConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE,
						ConstraintFactory.eINSTANCE.createCommunicationTypeConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING,
						ConstraintFactory.eINSTANCE.createDeferredHostingConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION,
						ConstraintFactory.eINSTANCE.createEnumerationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EQUALS,
						ConstraintFactory.eINSTANCE.createEqualsConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION,
						ConstraintFactory.eINSTANCE.createExclusionConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY,
						ConstraintFactory.eINSTANCE.createGroupCardinalityConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY,
						ConstraintFactory.eINSTANCE.createMemberCardinalityConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION,
						ConstraintFactory.eINSTANCE.createNetworkCommunicationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NOT,
						ConstraintFactory.eINSTANCE.createNotConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_OR,
						ConstraintFactory.eINSTANCE.createOrConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PALETTE,
						ConstraintFactory.eINSTANCE.createPaletteConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER,
						ConstraintFactory.eINSTANCE.createProductIdentifierConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_RANGE,
						ConstraintFactory.eINSTANCE.createRangeConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION,
						ConstraintFactory.eINSTANCE.createRealizationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION,
						ConstraintFactory.eINSTANCE.createSynchronousCommunicationConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY,
						ConstraintFactory.eINSTANCE.createTransmissionDelayConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TYPE,
						ConstraintFactory.eINSTANCE.createTypeConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_XOR,
						ConstraintFactory.eINSTANCE.createXorConstraint())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__MIXED, FeatureMapUtil.createEntry(
						ConstraintPackage.Literals.CONSTRAINT_ROOT__VALUE, ConstraintFactory.eINSTANCE
								.createSingleValue())));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION,
				ConstraintFactory.eINSTANCE.createApplicationCommunicationConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL,
				ConstraintFactory.eINSTANCE.createApplicationCommunicationProtocolConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF,
				ConstraintFactory.eINSTANCE.createAttributeDefinedConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION,
				ConstraintFactory.eINSTANCE.createAttributePropagationConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION,
				ConstraintFactory.eINSTANCE.createBaseCommunicationConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION,
				ConstraintFactory.eINSTANCE.createApplicationCommunicationConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION,
				ConstraintFactory.eINSTANCE.createNetworkCommunicationConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH,
				ConstraintFactory.eINSTANCE.createCommunicationBandwidthConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST,
				ConstraintFactory.eINSTANCE.createCommunicationCostConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT,
				ConstraintFactory.eINSTANCE.createCommunicationPortConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY,
				ConstraintFactory.eINSTANCE.createCommunicationRedundancyConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE,
				ConstraintFactory.eINSTANCE.createCommunicationTypeConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EQUALS,
				ConstraintFactory.eINSTANCE.createEqualsConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION,
				ConstraintFactory.eINSTANCE.createNetworkCommunicationConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PALETTE,
				ConstraintFactory.eINSTANCE.createPaletteConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER,
				ConstraintFactory.eINSTANCE.createProductIdentifierConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION,
				ConstraintFactory.eINSTANCE.createRealizationConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION,
				ConstraintFactory.eINSTANCE.createSynchronousCommunicationConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY,
				ConstraintFactory.eINSTANCE.createTransmissionDelayConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TYPE,
				ConstraintFactory.eINSTANCE.createTypeConstraint()));

		newChildDescriptors.add(createChildParameter(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__VALUE, ConstraintFactory.eINSTANCE
						.createSingleValue()));
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

		boolean qualify = childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EQUALS
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PALETTE
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TYPE
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_UPDATE
				|| childFeature == ConstraintPackage.Literals.CONSTRAINT_ROOT__VALUE;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
					new Object[] { getTypeText(childObject), getFeatureText(childFeature),
							getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return ConstraintEditPlugin.INSTANCE;
	}

}
