/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisDeployRootItemProvider.java,v 1.5 2007/12/10 21:58:01 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.provider;


import com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot;
import com.ibm.ccl.soa.deploy.analysis.AnalysisFactory;
import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalysisDeployRootItemProvider
	extends ItemProviderAdapter
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
	public AnalysisDeployRootItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION);
			childrenFeatures.add(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_NODE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns AnalysisDeployRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AnalysisDeployRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_AnalysisDeployRoot_type"); //$NON-NLS-1$
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

		switch (notification.getFeatureID(AnalysisDeployRoot.class)) {
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION:
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_NODE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY,
				 AnalysisFactory.eINSTANCE.createAvailabilityConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD,
				 AnalysisFactory.eINSTANCE.createDailyLoadConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE,
				 AnalysisFactory.eINSTANCE.createDataServiceConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE,
				 AnalysisFactory.eINSTANCE.createExecutionServiceConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN,
				 AnalysisFactory.eINSTANCE.createExpectedLifespanConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME,
				 AnalysisFactory.eINSTANCE.createExpectedVolumeConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD,
				 AnalysisFactory.eINSTANCE.createPeakLoadConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME,
				 AnalysisFactory.eINSTANCE.createResponseTimeConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION,
				 AnalysisFactory.eINSTANCE.createSizePerSubmissionConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY,
				 AnalysisFactory.eINSTANCE.createUsageWindowPerDayConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT,
				 AnalysisFactory.eINSTANCE.createDeployment()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE,
				 AnalysisFactory.eINSTANCE.createNode()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createAnalysisConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createAvailabilityConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createDailyLoadConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createDataServiceConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createExecutionServiceConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createExpectedLifespanConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createExpectedVolumeConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createPeakLoadConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createResponseTimeConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createSizePerSubmissionConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT,
				 AnalysisFactory.eINSTANCE.createUsageWindowPerDayConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT,
				 AnalysisFactory.eINSTANCE.createDeploymentUnit()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION,
				 AnalysisFactory.eINSTANCE.createLocationUnit()));

		newChildDescriptors.add
			(createChildParameter
				(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_NODE,
				 AnalysisFactory.eINSTANCE.createNodeUnit()));
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

		boolean qualify =
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION ||
			childFeature == AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY;

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
