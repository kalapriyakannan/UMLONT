/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms.provider;

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

import com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class JMSDeployRootItemProvider extends ItemProviderAdapter implements
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
	public JMSDeployRootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED);
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
	 * This returns JMSDeployRoot.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/JMSDeployRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_JMSDeployRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(JMSDeployRoot.class)) {
			case JmsPackage.JMS_DEPLOY_ROOT__MIXED:
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
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
					 ""))); //$NON-NLS-1$

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
					 XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION,
					 JmsFactory.eINSTANCE.createJMSActivationSpecification())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY,
					 JmsFactory.eINSTANCE.createJMSConnectionFactory())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION,
					 JmsFactory.eINSTANCE.createJMSDestination())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION,
					 JmsFactory.eINSTANCE.createJMSQueueDestination())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION,
					 JmsFactory.eINSTANCE.createJMSTopicDestination())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER,
					 JmsFactory.eINSTANCE.createJMSProvider())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY,
					 JmsFactory.eINSTANCE.createJMSQueueConnectionFactory())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION,
					 JmsFactory.eINSTANCE.createJMSQueueDestination())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY,
					 JmsFactory.eINSTANCE.createJMSTopicConnectionFactory())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION,
					 JmsFactory.eINSTANCE.createJMSTopicDestination())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT,
					 JmsFactory.eINSTANCE.createJMSActivationSpecificationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT,
					 JmsFactory.eINSTANCE.createJMSConnectionFactoryUnit())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT,
					 JmsFactory.eINSTANCE.createJMSProviderUnit())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT,
					 JmsFactory.eINSTANCE.createJMSQueueConnectionFactoryUnit())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT,
					 JmsFactory.eINSTANCE.createJMSQueueDestinationUnit())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT,
					 JmsFactory.eINSTANCE.createJMSTopicConnectionFactoryUnit())));

		newChildDescriptors.add
			(createChildParameter
				(JmsPackage.Literals.JMS_DEPLOY_ROOT__MIXED,
				 FeatureMapUtil.createEntry
					(JmsPackage.Literals.JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT,
					 JmsFactory.eINSTANCE.createJMSTopicDestinationUnit())));
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
			childFeature == JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION ||
			childFeature == JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION ||
			childFeature == JmsPackage.Literals.JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION;

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
				JmsEditPlugin.INSTANCE.log(e);
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
		return JmsEditPlugin.INSTANCE;
	}

}
