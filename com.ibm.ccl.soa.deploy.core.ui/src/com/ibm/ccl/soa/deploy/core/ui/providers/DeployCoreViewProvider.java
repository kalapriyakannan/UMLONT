/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.ConsolidationLinkViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.ConstraintLinkViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.DependencyLinkViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.DiagramListContainerViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.DiagramShapesContainerViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.DiagramViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.HostingLinkViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.HybridListCompartmentViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.HybridShapesCompartmentViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.ImportListContainerViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.ImportShapesContainerViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.ListContainerViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.RealizationLinkViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.ShapesContainerViewFactory;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.SnapViewFactory;

/**
 * Notation Provider that registers all the specific Deploy tool figures
 */
public class DeployCoreViewProvider extends AbstractViewProvider {

	static public final int FORCE_TREE = 1;
	static public final int FORCE_SHAPES = 2;
	static private int _overridePreference = 0;
	static private Map<DeployModelObject, Integer> _overridePreferenceMap = null;

	/**
	 * @param overridePreference --
	 *           allow toggle command to override the user preference
	 */
	public static void setOverridePreference(int overridePreference) {
		DeployCoreViewProvider._overridePreference = overridePreference;
	}

	/**
	 * allow a map of container types to be applied when creating multiple views
	 * 
	 * @param overridePreferenceMap
	 */
	public static void setOverridePreferenceMap(Map<DeployModelObject, Integer> overridePreferenceMap) {
		DeployCoreViewProvider._overridePreferenceMap = overridePreferenceMap;
	}

	// Map to hold the Shape Views
	private final Map<String, Class> nodeHintMap = new HashMap<String, Class>();
	{
		nodeHintMap.put(DeployCoreConstants.DEPLOY_NAME, BasicNodeViewFactory.class);

		nodeHintMap.put(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT,
				HybridListCompartmentViewFactory.class);
		nodeHintMap.put(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT,
				HybridListCompartmentViewFactory.class);
		nodeHintMap.put(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT,
				HybridShapesCompartmentViewFactory.class);

		nodeHintMap.put(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT,
				HybridShapesCompartmentViewFactory.class);
		nodeHintMap.put(DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT,
				HybridShapesCompartmentViewFactory.class);
		nodeHintMap.put(DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT,
				HybridShapesCompartmentViewFactory.class);

		nodeHintMap.put(DeployCoreConstants.SNAPROW_SEMANTICHINT, SnapViewFactory.class);
		nodeHintMap.put(DeployCoreConstants.SNAPGROUP_SEMANTICHINT, SnapViewFactory.class);
	}

	//	 Map to hold the Edge Views
	private final Map<String, Class> edgeHintMap = new HashMap<String, Class>();
	{
		edgeHintMap.put(DeployCoreConstants.DEPENDENCYLINK_SEMANTICHINT,
				DependencyLinkViewFactory.class);
		edgeHintMap.put(DeployCoreConstants.HOSTINGLINK_SEMANTICHINT, HostingLinkViewFactory.class);
		edgeHintMap.put(DeployCoreConstants.REALIZATIONLINK_SEMANTICHINT,
				RealizationLinkViewFactory.class);
		edgeHintMap.put(DeployCoreConstants.CONSTRAINTLINK_SEMANTICHINT,
				ConstraintLinkViewFactory.class);
		edgeHintMap.put(DeployCoreConstants.CONSOLIDATIONLINK_SEMANTICHINT,
				ConsolidationLinkViewFactory.class);
	}

	//	 Map to hold the Edge Views
	private final Map<EClass, Class> edgeMap = new HashMap<EClass, Class>();
	{
		edgeMap.put(CorePackage.eINSTANCE.getDependencyLink(), DependencyLinkViewFactory.class);
		edgeMap.put(CorePackage.eINSTANCE.getHostingLink(), HostingLinkViewFactory.class);
		edgeMap.put(CorePackage.eINSTANCE.getRealizationLink(), RealizationLinkViewFactory.class);
		edgeMap.put(CorePackage.eINSTANCE.getConstraintLink(), ConstraintLinkViewFactory.class);
	}

	protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView,
			String semanticHint) {
		// now check semantic hint for extended plugin views
		// treat a missing domain (for domains that don't have a ui plugin) view request as is if were a regular unit view
		if (semanticHint != null && semanticHint.length() > 0
				&& !semanticHint.equals(DeployCoreConstants.MISSINGDOMAINUI_SEMANTICHINT)) {

			// if creating diagram node, create shapes or list container?
			if (semanticHint.equals(DeployCoreConstants.DIAGRAMNODEVIEW_SEMANTICHINT)) {
				return isCreateShapeCompartment(null) ? DiagramShapesContainerViewFactory.class
						: DiagramListContainerViewFactory.class;
			}
			return nodeHintMap.get(semanticHint);
		}

		// now check object for core plugin views
		EObject eObject = getSemanticElement(semanticAdapter);
		boolean isCreateShapeCompartment = isCreateShapeCompartment(eObject);
		if (eObject instanceof Import) {
			// if creating import topology, create shapes or list container?
			return isCreateShapeCompartment ? ImportShapesContainerViewFactory.class
					: ImportListContainerViewFactory.class;
		} else if (eObject instanceof Unit) {
			// if appearing in a list, always use the list view factory 
			if (containerView.getType().equals(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT)
					|| containerView.getType().equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT)
					|| containerView.getType().equals(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT)) {
				return ListContainerViewFactory.class;
			}

			return isCreateShapeCompartment ? ShapesContainerViewFactory.class
					: ListContainerViewFactory.class;
		}

		return null;
	}

	private boolean isCreateShapeCompartment(EObject eObject) {
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		String pref = store.getString(IDeployPreferences.PREF_GROUP_STYLE);
		boolean isShapeCompartment = pref != null
				&& !pref.equals(Messages.DeployCoreMainPreferencePage_Tree_);
		if (!isShapeCompartment) {
			// always make a generic group a shape container initially
			isShapeCompartment = eObject instanceof Unit && ((Unit) eObject).isGroup()
					&& eObject.getClass().getName().endsWith(".UnitImpl"); //$NON-NLS-1$
		}

		// override if necessary by ConvertShapesOrTreeCommand
		if (_overridePreference == FORCE_TREE) {
			isShapeCompartment = false;
		} else if (_overridePreference == FORCE_SHAPES) {
			isShapeCompartment = true;
		}

		// override if necessary by VisualizeStateData (visualizing from another diagram)
		if (_overridePreferenceMap != null && _overridePreferenceMap.containsKey(eObject)) {
			isShapeCompartment = _overridePreferenceMap.get(eObject).intValue() == FORCE_SHAPES;
		}

		return isShapeCompartment;
	}

	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView,
			String semanticHint) {
		Class clazz = null;

		if (semanticHint != null && semanticHint.length() > 0) {
			clazz = edgeHintMap.get(semanticHint);
		}

		if (clazz == null) {
			clazz = edgeMap.get(getSemanticEClass(semanticAdapter));
		}

		return clazz;
	}

	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		if (diagramKind.equals(DeployCoreConstants.DEPLOY_CORE)) {
			return DiagramViewFactory.class;
		}
		return null;
	}
}
