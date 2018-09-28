/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CreateDependencyLinkDialog;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeploySemanticType;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * 
 * @since 1.0
 * 
 */
public class DependencyLinkCreationTool extends DeployLinkCreationTool {

	static private LinkType[] linkTypes = new LinkType[] { LinkType.DEPENDENCY, LinkType.CONSTRAINT };

	static private IElementType[] semanticTypes = new IElementType[] {
			DeploySemanticType.DEPENDENCYLINK, DeploySemanticType.CONSTRAINTLINK };

	/**
	 * 
	 * @param elementType
	 */
	public DependencyLinkCreationTool(IElementType elementType) {
		super(elementType);
	}

	@Override
	protected List getUserSelections(Unit srcUnit, LinkDescriptor[] links) {
		return null;
	}

	@Override
	protected List getUserSelections(EditPart srcEP, EditPart tgtEP, LinkDescriptor[] links) {
		final List<LinkDescriptor> linkSelections = new ArrayList<LinkDescriptor>();
		Point openLocation = Display.getCurrent().getCursorLocation();
		Shell shell = getCurrentViewer().getControl().getShell();
		final CreateDependencyLinkDialog dialog = new CreateDependencyLinkDialog(new Shell(shell,
				SWT.RESIZE), getCurrentViewer(), openLocation, Arrays.asList(links), srcEP, tgtEP);
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				dialog.open();
				linkSelections.addAll(dialog.getSelectedOptions());
			}
		});
		return linkSelections;
	}

	protected List<DeployShapeNodeEditPart> getSourceList(LinkDescriptor link) {
		return GMFUtils.getOrRefreshEditPartsFor(getViewer(), link.getSourceUnit());
	}

	protected List<DeployShapeNodeEditPart> getTargetList(LinkDescriptor link) {
		return GMFUtils.getOrRefreshEditPartsFor(getViewer(), link.getTargetUnit());
	}

	protected List<List<DeployShapeNodeEditPart>> getTargetLists(LinkDescriptor[] links) {
		List<List<DeployShapeNodeEditPart>> list = new ArrayList<List<DeployShapeNodeEditPart>>();
		for (int i = 0; i < links.length; i++) {
			Unit tgtUnit = links[i].getTargetUnit();
			list.add(GMFUtils.getOrRefreshEditPartsFor(this.getCurrentViewer(), tgtUnit));
		}
		return list;
	}

	/**
	 * @return link types
	 */
	public LinkType[] getLinkTypes() {
		return linkTypes;
	}

	/**
	 * @return semantic types
	 */
	public IElementType[] getSemanticTypes() {
		return semanticTypes;
	}

	//MK: 12/21/2007 CommunicationConstraint --> ApplicationCommunicationConstraint
	// rely on default implementation
//	protected List<LinkDescriptor> promptForConceptualNodeLinks(Unit srcUnit, Unit targetUnit,
//			Point point, LinkDescriptor[] linkDescriptors) {
//		IDataModel dataModel = DataModelFactory
//				.createDataModel(new CommunicationConstraintDataModelProvider());
//		setupScribblerParameters(srcUnit.getTopology(), dataModel);
//		dataModel.setProperty(ICommunicationConstraintDataModelProperties.SOURCE_UNIT, srcUnit);
//		dataModel.setProperty(ICommunicationConstraintDataModelProperties.TARGET_UNIT, targetUnit);
//		CommunicationConstraintWizard wizard = new CommunicationConstraintWizard(dataModel);
//		IWorkbench workbench = PlatformUI.getWorkbench();
//		wizard.init(workbench, null);
//		Shell parent = getCurrentViewer().getControl().getShell();
//		WizardDialog dialog = new WizardDialog(parent, wizard);
//		dialog.create();
//		dialog.getShell().setLocation(point.x, point.y);
//		if (dialog.open() == Window.OK) {
//			LinkDescriptor link = (LinkDescriptor) dataModel
//					.getProperty(ICommunicationConstraintDataModelProperties.LINK_DESCRIPTOR);
//			List<LinkDescriptor> list = new ArrayList<LinkDescriptor>();
//			list.add(link);
//			return list;
//		}
//
//		return new ArrayList<LinkDescriptor>();
//	}
//
	protected boolean canPromptCreateMatches() {
		return true;
	}
}
