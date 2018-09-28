/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.geoshapes.internal.providers.GeoshapeConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.SnapViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * @since 1.0
 * 
 * This canonical edit policy is installed on the DiagramEditPart ensuring that all the Unit
 * contained by the Topology is visualized on the Diagram.
 * 
 * Note: Once we move to multiple diagram paradigm, we will have to remove else all diagrams will be
 * identical in terms of their contents.
 */
public class DeployDiagramCanonicalEditPolicy extends DeployCanonicalEditPolicy {

	private boolean _ignoreRestrictions = false;
	private List<DeployModelObject> _creationList = null;

	/**
	 * 
	 */
	public DeployDiagramCanonicalEditPolicy() {
		super();
	}

	/**
	 * refresh the views in the diagram, but only create views for the units in the list
	 * 
	 * @param creationList
	 */
	public void refreshWithRestrictions(List<DeployModelObject> creationList) {
		// setup for restricted view creation/unlimited view deletion
		_creationList = creationList;
		_ignoreRestrictions = _creationList == null;

		// do an immediate refresh, no deferring
		refreshSemantic();

		// reset
		_ignoreRestrictions = false;
		if (_creationList != null) {
			_creationList.clear();
			_creationList = null;
		}
	}

	/**
	 * only allow views for the units in the creation restriction list to be created
	 */
	protected CreateViewRequest getCreateViewRequest(List descriptors) {
		if (!_ignoreRestrictions) {
			List removeDescriptorList = new ArrayList();
			for (Iterator<ViewDescriptor> it = descriptors.iterator(); it.hasNext();) {
				ViewDescriptor desc = it.next();
				if (_creationList == null
						|| !_creationList.contains(desc.getElementAdapter().getAdapter(EObject.class))) {
					removeDescriptorList.add(desc);
				}
			}
			descriptors.removeAll(removeDescriptorList);
		}
		return new CreateViewRequest(descriptors);
	}

	/*
	 * this method gets all the units in the diagram 1) Config Units views are filtered here and
	 * readded to HostingListCompartmentFigure by HostingListCompartmentUnitCanonicalEditPolicy 1)
	 * Units in groups are filtered here and readded to UnitCollectionCompartmentFigure by
	 * UnitCompartmentCanonicalEditPolicy
	 * 
	 */
	protected List getSemanticChildrenList() {
		EObject eObject = resolveSemanticElement();
		if (eObject instanceof Topology) {
			Topology topology = (Topology) eObject;
			DeployDiagramEditPart ddep = (DeployDiagramEditPart) getHost();

			//  for link cycle algorithm-- if a config unit in the current topology is hosted on 
			//  a proxy in an imported topology, it has a path to the canvas thru that proxy and there
			// does not have a cycle problem
			List importUnits = new ArrayList();
			for (Iterator<Import> it = topology.getImports().iterator(); it.hasNext();) {
				InstanceConfiguration instanceConfig = it.next().getInstanceConfiguration();
				if (instanceConfig != null) {
					importUnits.addAll(instanceConfig.getPublicUnits());
				}
			}

			// for link cycle algorithm-- create a list of units that are in the diagram
			//  if a top unit isn't in this list, it isn't in this diagram and therefore is not visible
			List<DeployModelObject> diagramUnits = new ArrayList<DeployModelObject>();
			Diagram diagram = (Diagram) ddep.getNotationView();
			for (Iterator<View> it = DiagramUtils.getAllChildViewsIncludingGroup(diagram).iterator(); it
					.hasNext();) {
				View view = it.next();
				EObject eo = view.getElement();
				if (eo instanceof Unit) {
					diagramUnits.add((Unit) eo);
				}
			}
			// also add any views we are authorized to create this time
			if (_creationList != null) {
				diagramUnits.addAll(_creationList);
			}

			// filter out any that are contained in lists, groups or nodes
			List filteredUnits = CanonicalUtils.filterOutContainedUnits(ddep, topology.getUnits(),
					importUnits, diagramUnits, false, null, _creationList);

			// add any imported topologies too
			filteredUnits.addAll(topology.getImports());
			return filteredUnits;
		}

		return Collections.EMPTY_LIST;
	}

	protected boolean shouldDeleteView(View view) {
		// don't delete Notes and Text views 
		String type = view.getType();
		if (type != null) {
			if (type.equals("Note") || type.equals("Text")) { //$NON-NLS-1$ //$NON-NLS-2$
				return false;
			}

			// don't delete snap groups
			if (type.equals(DeployCoreConstants.SNAPGROUP_SEMANTICHINT)) {
				if (SnapViewCommand.getMemberSize(view) > 1) {
					return false;
				}
			}

			// don't delete geoshapes
			for (Iterator<String> it = GeoshapeConstants.getSupportedShapes().iterator(); it.hasNext();) {
				if (type.equals(it.next())) {
					return false;
				}
			}

			// don't delete diagram nodes
			if (type.equals(DeployCoreConstants.DIAGRAMNODEVIEW_SEMANTICHINT)) {
				return false;
			}
		}

		// definately gone if the view's semantic element is null or container is null
		EObject eo = ViewUtil.resolveSemanticElement(view);
		if (eo == null || eo.eContainer() == null) {
			return true;
		}

		// Note: this is needed in addition to getDuplicateCanvasViewMap() logic above so that proxy
		// units of an import topology aren't deleted (proxy units aren't included in the 
		// semantic list that is being created above)
		DeployStyle deployStyle = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (deployStyle != null && deployStyle.isIsDuplicateCanvasView()) {
			return false;
		}

		// we allow duplicate Import views since they may be Import Diagrams
		if (eo instanceof Import) {
			return false;
		}

		return true;
	}

	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return null;
	}
}
