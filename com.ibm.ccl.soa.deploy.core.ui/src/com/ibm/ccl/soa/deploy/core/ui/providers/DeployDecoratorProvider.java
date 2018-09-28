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

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.decorators.AttributesDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ContractDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.DiagramListCollapseButtonDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.DiagramShapesCollapseButtonDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ErrorMarkerDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.HybridListCollapseButtonDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.HybridShapesCollapseButtonDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ImportListCollapseButtonDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ImportShapesCollapseButtonDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.NubInCounterDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.NubOutCounterDecorator;
import com.ibm.ccl.soa.deploy.core.ui.decorators.UnresolvedReferenceDecorator;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConstraintLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DependencyLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HostingLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.RealizationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.TopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnresolvedProxyConnectionEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnresolvedProxyEditPart;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;

/**
 * @since 1.0
 * 
 */
public class DeployDecoratorProvider extends AbstractProvider implements IDecoratorProvider {
	private static final String DEPLOY_CORE_ERROR_MARKER = "deployCoreErrorMarker"; //$NON-NLS-1$
	private static final String DEPLOY_CORE_UNREFERROR_MARKER = "deployCoreUnrefErrorMarker"; //$NON-NLS-1$
	private static final String DEPLOY_CORE_HYBRID_SHAPES_COLLAPSE_BTN = "deployCoreHybridShapesCollapseBtn"; //$NON-NLS-1$
	private static final String DEPLOY_CORE_HYBRID_LIST_COLLAPSE_BTN = "deployCoreHybridListCollapseBtn"; //$NON-NLS-1$
	private static final String DEPLOY_CORE_IMPORT_LIST_COLLAPSE_BTN = "deployCoreImportListCollapseBtn"; //$NON-NLS-1$
	private static final String DEPLOY_CORE_IMPORT_SHAPES_COLLAPSE_BTN = "deployCoreImportShapesCollapseBtn"; //$NON-NLS-1$
	private static final String DEPLOY_CORE_DIAGRAM_LIST_COLLAPSE_BTN = "deployCoreDiagramListCollapseBtn"; //$NON-NLS-1$
	private static final String DEPLOY_CORE_DIAGRAM_SHAPES_COLLAPSE_BTN = "deployCoreDiagramShapesCollapseBtn"; //$NON-NLS-1$
	private static final String DEPLOY_CORE_INNUB_EDIT_BTN = "deployCoreINNUBEDITBtn"; //$NON-NLS-1$
	private static final String DEPLOY_CORE_OUTNUB_EDIT_BTN = "deployCoreOUTNUBEDITBtn"; //$NON-NLS-1$
	private static final String DEPLOY_ATTRIBUTES = "deployAttributes"; //$NON-NLS-1$
	private static final String DEPLOY_CONTRACT = "deployContract"; //$NON-NLS-1$

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editpart = (EditPart) decoratorTarget.getAdapter(EditPart.class);

		/* add error markers to units, unit groups, dependencylinks and hostinglinks */
		if (editpart != null
				&& (editpart instanceof TopologyEditPart || editpart instanceof DependencyLinkEditPart
						|| editpart instanceof HostingLinkEditPart
						|| editpart instanceof ConstraintLinkEditPart
						|| editpart instanceof ConsolidationLinkEditPart
						|| editpart instanceof RealizationLinkEditPart
						|| editpart instanceof ImportTopologyEditPart || editpart instanceof DiagramNodeEditPart)) {
			decoratorTarget.installDecorator(DEPLOY_CORE_ERROR_MARKER, new ErrorMarkerDecorator(
					decoratorTarget));
		}

		/* add special error marker to unresolved proxies */
		if (editpart != null
				&& (editpart instanceof UnresolvedProxyEditPart || editpart instanceof UnresolvedProxyConnectionEditPart)) {
			decoratorTarget.installDecorator(DEPLOY_CORE_UNREFERROR_MARKER,
					new UnresolvedReferenceDecorator(decoratorTarget));
		}

		/* add collapse buttons to units and unitgroups */
		if (editpart != null && editpart instanceof TopologyEditPart) {
			if (DeployShapeNodeEditPart.isTreeMode(editpart)) {
				decoratorTarget.installDecorator(DEPLOY_CORE_HYBRID_LIST_COLLAPSE_BTN,
						new HybridListCollapseButtonDecorator(decoratorTarget));
			} else {
				decoratorTarget.installDecorator(DEPLOY_CORE_HYBRID_SHAPES_COLLAPSE_BTN,
						new HybridShapesCollapseButtonDecorator(decoratorTarget));
			}
		}

		/* add collapse buttons to imports */
		if (editpart != null && editpart instanceof ImportTopologyEditPart) {
			if (DeployShapeNodeEditPart.isTreeMode(editpart)) {
				decoratorTarget.installDecorator(DEPLOY_CORE_IMPORT_LIST_COLLAPSE_BTN,
						new ImportListCollapseButtonDecorator(decoratorTarget));
			} else {
				decoratorTarget.installDecorator(DEPLOY_CORE_IMPORT_SHAPES_COLLAPSE_BTN,
						new ImportShapesCollapseButtonDecorator(decoratorTarget));
			}
		}

		/* add collapse buttons to diagram nodes */
		if (editpart != null && editpart instanceof DiagramNodeEditPart) {
			if (DeployShapeNodeEditPart.isTreeMode(editpart)) {
				decoratorTarget.installDecorator(DEPLOY_CORE_DIAGRAM_LIST_COLLAPSE_BTN,
						new DiagramListCollapseButtonDecorator(decoratorTarget));
			} else {
				decoratorTarget.installDecorator(DEPLOY_CORE_DIAGRAM_SHAPES_COLLAPSE_BTN,
						new DiagramShapesCollapseButtonDecorator(decoratorTarget));
			}
		}

		/* add Installed Resource Decoration to units */
		if (editpart != null && editpart instanceof TopologyEditPart) {
			decoratorTarget.installDecorator(DEPLOY_ATTRIBUTES, new AttributesDecorator(
					decoratorTarget));

		}
		/* add Installed Resource Decoration to units */
		if (editpart != null && editpart instanceof TopologyEditPart
				|| editpart instanceof ImportTopologyEditPart) {
			decoratorTarget.installDecorator(DEPLOY_CONTRACT, new ContractDecorator(decoratorTarget));
		}

		/* add Nub Counter/edit button Decoration to nubs on components */
		if (editpart != null && editpart instanceof TopologyEditPart) {
			decoratorTarget.installDecorator(DEPLOY_CORE_INNUB_EDIT_BTN, new NubInCounterDecorator(
					decoratorTarget));
			decoratorTarget.installDecorator(DEPLOY_CORE_OUTNUB_EDIT_BTN, new NubOutCounterDecorator(
					decoratorTarget));
		}

	}

	public boolean provides(IOperation operation) {
		Assert.isNotNull(operation);
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation)
				.getDecoratorTarget();
		return decoratorTarget.getAdapter(View.class) != null;
	}

}
