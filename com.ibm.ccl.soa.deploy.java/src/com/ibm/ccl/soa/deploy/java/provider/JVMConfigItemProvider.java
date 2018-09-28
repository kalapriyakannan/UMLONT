/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.java.provider;

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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.provider.CapabilityItemProvider;
import com.ibm.ccl.soa.deploy.java.JVMConfig;
import com.ibm.ccl.soa.deploy.java.JavaPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.java.JVMConfig} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class JVMConfigItemProvider extends CapabilityItemProvider implements
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
	public JVMConfigItemProvider(AdapterFactory adapterFactory) {
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

			addBootClasspathPropertyDescriptor(object);
			addClasspathPropertyDescriptor(object);
			addDebugArgsPropertyDescriptor(object);
			addDisableJITPropertyDescriptor(object);
			addExecutableJarfileNamePropertyDescriptor(object);
			addGenericJvmArgumentsPropertyDescriptor(object);
			addInitialHeapSizePropertyDescriptor(object);
			addInternalClassAccessModePropertyDescriptor(object);
			addMaximumHeapSizePropertyDescriptor(object);
			addRunHProfPropertyDescriptor(object);
			addVerboseModeClassPropertyDescriptor(object);
			addVerboseModeGarbageCollectionPropertyDescriptor(object);
			addVerboseModeJNIPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Boot Classpath feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBootClasspathPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_bootClasspath_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_bootClasspath_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__BOOT_CLASSPATH, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Classpath feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addClasspathPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_classpath_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_classpath_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__CLASSPATH, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Debug Args feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDebugArgsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_debugArgs_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_debugArgs_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__DEBUG_ARGS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Disable JIT feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDisableJITPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_disableJIT_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_disableJIT_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__DISABLE_JIT, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Executable Jarfile Name feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExecutableJarfileNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_executableJarfileName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_executableJarfileName_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__EXECUTABLE_JARFILE_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Generic Jvm Arguments feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addGenericJvmArgumentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_genericJvmArguments_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_genericJvmArguments_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__GENERIC_JVM_ARGUMENTS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Initial Heap Size feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addInitialHeapSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_initialHeapSize_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_initialHeapSize_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__INITIAL_HEAP_SIZE, true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Internal Class Access Mode feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addInternalClassAccessModePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_internalClassAccessMode_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_internalClassAccessMode_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Maximum Heap Size feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMaximumHeapSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_maximumHeapSize_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_maximumHeapSize_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__MAXIMUM_HEAP_SIZE, true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Run HProf feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRunHProfPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_runHProf_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_runHProf_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__RUN_HPROF, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Verbose Mode Class feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addVerboseModeClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_verboseModeClass_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_verboseModeClass_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__VERBOSE_MODE_CLASS, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Verbose Mode Garbage Collection feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addVerboseModeGarbageCollectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_verboseModeGarbageCollection_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_verboseModeGarbageCollection_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Verbose Mode JNI feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addVerboseModeJNIPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_JVMConfig_verboseModeJNI_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_JVMConfig_verboseModeJNI_feature", "_UI_JVMConfig_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						JavaPackage.Literals.JVM_CONFIG__VERBOSE_MODE_JNI, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns JVMConfig.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/JVMConfig")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((JVMConfig) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_JVMConfig_type") : //$NON-NLS-1$
				getString("_UI_JVMConfig_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(JVMConfig.class))
		{
		case JavaPackage.JVM_CONFIG__BOOT_CLASSPATH:
		case JavaPackage.JVM_CONFIG__CLASSPATH:
		case JavaPackage.JVM_CONFIG__DEBUG_ARGS:
		case JavaPackage.JVM_CONFIG__DISABLE_JIT:
		case JavaPackage.JVM_CONFIG__EXECUTABLE_JARFILE_NAME:
		case JavaPackage.JVM_CONFIG__GENERIC_JVM_ARGUMENTS:
		case JavaPackage.JVM_CONFIG__INITIAL_HEAP_SIZE:
		case JavaPackage.JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE:
		case JavaPackage.JVM_CONFIG__MAXIMUM_HEAP_SIZE:
		case JavaPackage.JVM_CONFIG__RUN_HPROF:
		case JavaPackage.JVM_CONFIG__VERBOSE_MODE_CLASS:
		case JavaPackage.JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION:
		case JavaPackage.JVM_CONFIG__VERBOSE_MODE_JNI:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
					true));
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

		boolean qualify = childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE
				|| childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR;

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
				JavaEditPlugin.INSTANCE.log(e);
			}
		}

		return super.getCreateChildImage(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return JavaEditPlugin.INSTANCE;
	}

}
