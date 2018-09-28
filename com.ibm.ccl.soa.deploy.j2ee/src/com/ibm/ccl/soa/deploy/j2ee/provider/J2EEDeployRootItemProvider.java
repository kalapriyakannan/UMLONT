/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.provider;

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

import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class J2EEDeployRootItemProvider extends ItemProviderAdapter implements
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
	public J2EEDeployRootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED);
			childrenFeatures.add(J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE);
			childrenFeatures.add(J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT);
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
	 * This returns J2EEDeployRoot.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/J2EEDeployRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_J2EEDeployRoot_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(J2EEDeployRoot.class))
		{
		case J2eePackage.J2EE_DEPLOY_ROOT__MIXED:
		case J2eePackage.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE:
		case J2eePackage.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT:
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
				.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED, FeatureMapUtil
						.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT, ""))); //$NON-NLS-1$

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, ""))); //$NON-NLS-1$

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
						XMLTypeFactory.eINSTANCE.createProcessingInstruction())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE,
						J2eeFactory.eINSTANCE.createAppClientModule())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE,
						J2eeFactory.eINSTANCE.createEARModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB,
						J2eeFactory.eINSTANCE.createEJB())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER,
						J2eeFactory.eINSTANCE.createEJBContainer())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE,
						J2eeFactory.eINSTANCE.createEJBModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER,
						J2eeFactory.eINSTANCE.createJ2EEContainer())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE,
						J2eeFactory.eINSTANCE.createJ2EEDatasource())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE,
						J2eeFactory.eINSTANCE.createJ2EEModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE,
						J2eeFactory.eINSTANCE.createAppClientModule())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE,
						J2eeFactory.eINSTANCE.createEARModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE,
						J2eeFactory.eINSTANCE.createEJBModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE,
						J2eeFactory.eINSTANCE.createJarModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE,
						J2eeFactory.eINSTANCE.createJCAModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE,
						J2eeFactory.eINSTANCE.createWebModuleCapability())));

		newChildDescriptors
				.add(createChildParameter(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
						FeatureMapUtil
								.createEntry(
										J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT,
										J2eeFactory.eINSTANCE.createJ2EEResourceEnvironmentRequirement())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT,
						J2eeFactory.eINSTANCE.createJ2EEResourceRequirement())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE,
						J2eeFactory.eINSTANCE.createJ2EESecurityRole())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER,
						J2eeFactory.eINSTANCE.createJ2EEServer())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE,
						J2eeFactory.eINSTANCE.createJarModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER,
						J2eeFactory.eINSTANCE.createJCAContainer())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE,
						J2eeFactory.eINSTANCE.createJCAModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER,
						J2eeFactory.eINSTANCE.createJSPContainer())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER,
						J2eeFactory.eINSTANCE.createServletContainer())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE,
						J2eeFactory.eINSTANCE.createWebModuleCapability())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_EAR,
						J2eeFactory.eINSTANCE.createEarModule())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_EJB,
						J2eeFactory.eINSTANCE.createEjbModule())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_JAR,
						J2eeFactory.eINSTANCE.createJarModule())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__COMPONENT_WEB,
						J2eeFactory.eINSTANCE.createWebModule())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_JAVA,
						J2eeFactory.eINSTANCE.createJavaInterface())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_URL,
						J2eeFactory.eINSTANCE.createURLInterface())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__INTERFACE_WSDL,
						J2eeFactory.eINSTANCE.createWSDLInterface())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_ENTITY,
						J2eeFactory.eINSTANCE.createEntityService())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_SERVLET,
						J2eeFactory.eINSTANCE.createURLService())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_SESSION,
						J2eeFactory.eINSTANCE.createSessionService())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__SERVICE_WS,
						J2eeFactory.eINSTANCE.createWebService())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT,
						J2eeFactory.eINSTANCE.createAppClient())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER,
						J2eeFactory.eINSTANCE.createGenericJ2eeServer())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(
						J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT,
						J2eeFactory.eINSTANCE.createJ2EEServerUnit())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE,
						J2eeFactory.eINSTANCE.createJCAModule())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER,
						J2eeFactory.eINSTANCE.createGenericWebServer())));

		newChildDescriptors.add(createChildParameter(J2eePackage.Literals.J2EE_DEPLOY_ROOT__MIXED,
				FeatureMapUtil.createEntry(J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER,
						J2eeFactory.eINSTANCE.createGenericJ2eeServer())));

		newChildDescriptors.add(createChildParameter(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, J2eeFactory.eINSTANCE
						.createJ2EEModuleCapability()));

		newChildDescriptors.add(createChildParameter(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, J2eeFactory.eINSTANCE
						.createAppClientModule()));

		newChildDescriptors.add(createChildParameter(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, J2eeFactory.eINSTANCE
						.createEARModuleCapability()));

		newChildDescriptors.add(createChildParameter(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, J2eeFactory.eINSTANCE
						.createEJBModuleCapability()));

		newChildDescriptors.add(createChildParameter(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, J2eeFactory.eINSTANCE
						.createJarModuleCapability()));

		newChildDescriptors.add(createChildParameter(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, J2eeFactory.eINSTANCE
						.createJCAModuleCapability()));

		newChildDescriptors.add(createChildParameter(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE, J2eeFactory.eINSTANCE
						.createWebModuleCapability()));

		newChildDescriptors.add(createChildParameter(
				J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT, J2eeFactory.eINSTANCE
						.createJ2EEServerUnit()));
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

		boolean qualify = childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE
				|| childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE
				|| childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE
				|| childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE
				|| childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE
				|| childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE
				|| childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE
				|| childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER
				|| childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER
				|| childFeature == J2eePackage.Literals.J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT;

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
				J2eeEditPlugin.INSTANCE.log(e);
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
		return J2eeEditPlugin.INSTANCE;
	}

}
