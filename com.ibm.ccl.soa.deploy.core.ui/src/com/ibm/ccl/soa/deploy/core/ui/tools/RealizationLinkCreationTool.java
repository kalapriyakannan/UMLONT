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
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CreateRealizationLinkDialog;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeploySemanticType;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Tool for creating realization links by dragging.
 * 
 * @author Ed Snible (based on jswanke original)
 */
public class RealizationLinkCreationTool extends DeployLinkCreationTool {

	//	static private LinkType[] linkTypes = new LinkType[] { LinkType.REALIZATION };

	static private IElementType[] semanticTypes = new IElementType[] { DeploySemanticType.REALIZATIONLINK };

	/**
	 * 
	 * @param elementType
	 */
	public RealizationLinkCreationTool(IElementType elementType) {
		super(elementType);
	}

	protected List getUserSelections(final Unit srcUnit, final LinkDescriptor[] links) {
		final List<LinkDescriptor> linkSelections = new ArrayList<LinkDescriptor>();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Shell shell = getCurrentViewer().getControl().getShell();
				Point openLocation = Display.getCurrent().getCursorLocation();
				CreateRealizationLinkDialog dialog = new CreateRealizationLinkDialog(new Shell(shell,
						SWT.RESIZE), getCurrentViewer(), openLocation, srcUnit, Arrays.asList(links));
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
			list.add(GMFUtils.getOrRefreshEditPartsFor(this.getCurrentViewer(), links[i]
					.getTargetUnit()));
		}
		return list;
	}

	/**
	 * @return link types
	 */
	public LinkType[] getLinkTypes() {
		return LinkType.REALIZATION_SET;
	}

	/**
	 * @return semeantic types
	 */
	public IElementType[] getSemanticTypes() {
		return semanticTypes;
	}
}
