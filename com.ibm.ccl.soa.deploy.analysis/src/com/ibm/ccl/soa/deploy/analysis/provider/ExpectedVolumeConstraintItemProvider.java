/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExpectedVolumeConstraintItemProvider.java,v 1.1 2007/12/03 20:16:14 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.provider;


import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint;

import com.ibm.ccl.soa.deploy.core.CorePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpectedVolumeConstraintItemProvider
	extends AnalysisConstraintItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpectedVolumeConstraintItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addGrowthRatePercentagePropertyDescriptor(object);
			addInitialSizePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Growth Rate Percentage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGrowthRatePercentagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExpectedVolumeConstraint_growthRatePercentage_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ExpectedVolumeConstraint_growthRatePercentage_feature", "_UI_ExpectedVolumeConstraint_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 AnalysisPackage.Literals.EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExpectedVolumeConstraint_initialSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ExpectedVolumeConstraint_initialSize_feature", "_UI_ExpectedVolumeConstraint_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 AnalysisPackage.Literals.EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns ExpectedVolumeConstraint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ExpectedVolumeConstraint")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((ExpectedVolumeConstraint)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ExpectedVolumeConstraint_type") : //$NON-NLS-1$
			getString("_UI_ExpectedVolumeConstraint_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ExpectedVolumeConstraint.class)) {
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE:
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
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
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE ||
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return AnalysisDomainEditPlugin.INSTANCE;
	}

}
