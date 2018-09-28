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

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CreateHostingLinkDialog;
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
public class HostingLinkCreationTool extends DeployLinkCreationTool {

	//[6256 - 06/20/08 DCB: Removed constraint link type to avoid non-hosting type constraints
	//being returned when using the HostingLinkCreationTool.
	static private LinkType[] linkTypes = new LinkType[] { LinkType.HOSTING };
	static private IElementType[] semanticTypes = new IElementType[] { DeploySemanticType.HOSTINGLINK };

	/**
	 * 
	 * @param elementType
	 */
	public HostingLinkCreationTool(IElementType elementType) {
		super(elementType);
	}

	protected List<DeployShapeNodeEditPart> getSourceList(LinkDescriptor link) {
		return GMFUtils.getOrRefreshEditPartsFor(getViewer(),
				link.getType() == LinkType.CONSTRAINT ? link.getSourceUnit() : link.getTargetUnit());
	}

	protected List<DeployShapeNodeEditPart> getTargetList(LinkDescriptor link) {
		return GMFUtils.getOrRefreshEditPartsFor(getViewer(),
				link.getType() == LinkType.CONSTRAINT ? link.getTargetUnit() : link.getSourceUnit());
	}

	protected List<List<DeployShapeNodeEditPart>> getTargetLists(LinkDescriptor[] links) {
		List<List<DeployShapeNodeEditPart>> list = new ArrayList<List<DeployShapeNodeEditPart>>();
		for (int i = 0; i < links.length; i++) {
			Unit tgtUnit = links[i].getType() == LinkType.CONSTRAINT ? links[i].getTargetUnit()
					: links[i].getSourceUnit();
			list.add(GMFUtils.getOrRefreshEditPartsFor(this.getCurrentViewer(), tgtUnit));
		}
		return list;
	}

	//MK 12/21/2007: this isn't called by anyone; commenting it out
//	protected List getUserSelectionsOLD(LinkDescriptor[] links) {
//		Shell shell = getCurrentViewer().getControl().getShell();
//		CreateHostingLinkDialog dialog = new CreateHostingLinkDialog(shell, getCurrentViewer(), links);
//		if (dialog.open() == Window.OK && dialog.getSelections().size() >= 0) {
//			return dialog.getSelections();
//		}
//		return null;
//	}
//
	protected static String[] tableColumnProperties = { Messages.TARGET_LABEL,
			Messages.CreateDependencyLinkDialog_Matc_, Messages.CONSTRAINT_LABEL };

//	protected ColumnLayoutData[] tableColumnLayouts = { new ColumnWeightData(45),
//			new ColumnWeightData(10) };
	protected static int[] tableColumnWidths = { 275, 75, 50 };

	protected List getUserSelections(final Unit srcUnit, final LinkDescriptor[] links) {
		final List<LinkDescriptor> linkSelections = new ArrayList<LinkDescriptor>();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Shell shell = getCurrentViewer().getControl().getShell();
				Point openLocation = Display.getCurrent().getCursorLocation();
				CreateHostingLinkDialog dialog = new CreateHostingLinkDialog(new Shell(shell,
						SWT.RESIZE), getCurrentViewer(), openLocation, srcUnit, Arrays.asList(links));
				dialog.open();
				linkSelections.addAll(dialog.getSelectedOptions());
			}
		});

		return linkSelections;
	}

	protected boolean isModelReversed() {
		return true;
	}

	/**
	 * @return link types
	 */
	public LinkType[] getLinkTypes() {
		return linkTypes;
	}

	/**
	 * @return semeantic types
	 */
	public IElementType[] getSemanticTypes() {
		return semanticTypes;
	}
}
