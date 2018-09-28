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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployGraphicalViewer;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployToggleCanonicalModeCommand;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.FilterLinkData;
import com.ibm.ccl.soa.deploy.core.ui.util.FilteringUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;

/**
 * 
 * @since 1.0
 * 
 */
public class ConstraintLinkCreationTool extends ConnectionCreationTool implements DragTracker {

	/**
	 * key to request map that saves the link descriptor for the create link command
	 */
	final static public String DESCRIPTOR = "descriptor"; //$NON-NLS-1$
	final static public String LINKRESULTMAP = "linkresultmap"; //$NON-NLS-1$
	private EditPartViewer _viewer;
	private boolean _delayEraseSourceFeedback = false;

	/**
	 * 
	 * @param elementType
	 */
	public ConstraintLinkCreationTool(IElementType elementType) {
		super(elementType);
		init();
	}

	private void init() {
		setDefaultCursor(DeployCoreImages.CONNECT_CURSOR);
		setDisabledCursor(DeployCoreImages.CONNECT_CURSOR);
	}

	// user is dragging tool
	protected boolean handleDragStarted() {
		// when tool starts to drag unfade other figures so user can see them
		SelectionUtils.unfadeFigures();
		return super.handleDragStarted();
	}

	// user has pressed enter key on the palette, create the links
	protected void createConnection() {
		List selectedEditParts = getCurrentViewer().getSelectedEditParts();
		if (!selectedEditParts.isEmpty()) {
			IGraphicalEditPart srcEP = (IGraphicalEditPart) selectedEditParts.get(0);
			IGraphicalEditPart tgtEP = selectedEditParts.size() == 2 ? (IGraphicalEditPart) selectedEditParts
					.get(1)
					: srcEP;
			createConnection(srcEP, tgtEP);
		}
	}

	// user has released mouse tool, create the link(s)
	protected boolean handleCreateConnection() {
		boolean bRet = false;
		setAvoidDeactivation(true);
		Request req = this.getSourceRequest();
		if (req instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
			EditPart srcEP = request.getSourceEditPart();
			EditPart tgtEP = request.getTargetEditPart();
			bRet = createConnection(srcEP, tgtEP);
		}
		setAvoidDeactivation(false);
		eraseSourceFeedback();
		deactivate();
		return bRet;
	}

	/*
	 * common method to create links from keyboard or mouse
	 */
	private boolean createConnection(EditPart srcEP, EditPart tgtEP) {
		/*
		 * prompt user to ask what links they want to create
		 */
		_viewer = srcEP.getViewer();
		EObject srcObj = ViewUtil.resolveSemanticElement((View) srcEP.getModel());
		EObject tgtObj = tgtEP != null ? ViewUtil.resolveSemanticElement((View) tgtEP.getModel())
				: null;
		if (!(srcObj instanceof Unit) || !(tgtObj instanceof Unit) || srcObj == tgtObj) {
			return false;
		}
		Unit unit1 = (Unit) srcObj;
		Unit unit2 = (Unit) tgtObj;

		org.eclipse.swt.graphics.Point point = new org.eclipse.swt.graphics.Point(getLocation().x,
				getLocation().y);
		point = getCurrentViewer().getControl().toDisplay(point);

		_delayEraseSourceFeedback = true;
		Request req = getSourceRequest();
		((DeployGraphicalViewer) srcEP.getViewer()).closeToolTip();

		Menu menu = new Menu(getCurrentViewer().getControl());
		populateMenu(menu, unit1, unit2);
		menu.setLocation(point);
		menu.setVisible(true);

		// add display loop
		Display display = getCurrentViewer().getControl().getDisplay();
		while (!menu.isDisposed() && menu.isVisible()) {
			display.readAndDispatch();
		}

		if (!menu.isDisposed()) {
			menu.dispose();
		}

		// ensure that link feedback is erased
		_delayEraseSourceFeedback = false;
		Object t = req.getType();
		req.setType(RequestConstants.REQ_CONNECTION_END);
		srcEP.eraseSourceFeedback(req);
		req.setType(t);
		return false;
	}

	public void populateMenu(Menu emptyMenu, Unit unit1, Unit unit2) {
		List<ShortConstraintDescriptor> applicableConstraints = ConstraintService.INSTANCE
				.applicableConstraints(unit1, unit2);

		for (ShortConstraintDescriptor d : applicableConstraints) {
			createMenuItem(new CreateConstraintAction(d, unit1, unit2), emptyMenu);
		}

	}

	/**
	 * Creates a menu item for the parent menu based on the action.
	 * 
	 * @param action
	 * 
	 * @param parent
	 * @return a menu item
	 */
	public MenuItem createMenuItem(final IAction action, Menu parent) {
		final MenuItem item = new MenuItem(parent, SWT.NONE);
		if (action.getImageDescriptor() != null) {
			item.setImage(action.getImageDescriptor().createImage());
		}
		item.setText(action.getText());

		item.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				//Do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				action.run();
			}
		});
		return item;
	}

	class CreateConstraintAction extends Action {

		private ShortConstraintDescriptor descriptor = null;
		private final Unit unitOne;
		private final Unit unitTwo;

		protected CreateConstraintAction(ShortConstraintDescriptor d, Unit unit1, Unit unit2) {
			super(d.getTitle(), DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_CONSTRAINT));
			descriptor = d;
			unitOne = unit1;
			unitTwo = unit2;
		}

		@Override
		public void run() {
			createLinks(unitOne, unitTwo, descriptor);
		}
	}

	@Override
	protected void eraseSourceFeedback() {
		if (!_delayEraseSourceFeedback) {
			setAvoidDeactivation(false);
			super.eraseSourceFeedback();
		}
	}

	/*
	 * creates every link to every duplicate view
	 */
	protected void createLinks(Unit unit1, Unit unit2, ShortConstraintDescriptor descriptor) {
		List<DeployShapeNodeEditPart> toggleList = new ArrayList<DeployShapeNodeEditPart>();

		// get all sources and targets for this link
		List<DeployShapeNodeEditPart> srcList = GMFUtils.getOrRefreshEditPartsFor(_viewer, unit1);
		List<DeployShapeNodeEditPart> tgtList = GMFUtils.getOrRefreshEditPartsFor(_viewer, unit2);

		// collect all the possible duplicate links
		List<FilterLinkData> potentialList = new ArrayList<FilterLinkData>();
		for (Iterator<DeployShapeNodeEditPart> srcIt = srcList.iterator(); srcIt.hasNext();) {
			DeployShapeNodeEditPart srcEP = srcIt.next();
			for (Iterator<DeployShapeNodeEditPart> tgtIt = tgtList.iterator(); tgtIt.hasNext();) {
				DeployShapeNodeEditPart tgtEP = tgtIt.next();
				potentialList.add(new FilterLinkData(srcEP, tgtEP, null));
			}
		}

		// add the canonical toggle commands to prevent view refresh until all link views are created
		toggleList.addAll(srcList);
		toggleList.addAll(tgtList);
		Command command = DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(toggleList,
				true, false, false);

		// if there are duplicate links, optionally filter out the secondary duplicate links
		if (potentialList.size() > 1) {
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			if (store.getBoolean(IDeployPreferences.DEPLOY_FILTER_SECONDARY_DUP_LINKS)) {
				FilteringUtils.filterDupLinks(potentialList, null);
			}
		}

		// now create the filtered links commands		
		Map<LinkDescriptor, DeployModelObject> linkResultMap = new HashMap<LinkDescriptor, DeployModelObject>();
		for (Iterator<FilterLinkData> itFiltered = potentialList.iterator(); itFiltered.hasNext();) {
			FilterLinkData filterData = itFiltered.next();

			Command cmd = getCreateConnection(filterData.getSource(), filterData.getTarget(),
					descriptor, linkResultMap);
			if (cmd != null && cmd.canExecute()) {
				if (command != null) {
					command = command.chain(cmd);
				} else {
					command = cmd;
				}
				command.setLabel(cmd.getLabel());
			}
		}

		// now execute the command and select the new objects
		if (command != null) {
			// re-enable the the canonical policies
			command = command.chain(DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(
					toggleList, true, true, false));
			setCurrentCommand(command);
			executeCurrentCommand();
			selectAddedObject(_viewer, DiagramCommandStack.getReturnValues(command));
		}

		setAvoidDeactivation(false);
		eraseSourceFeedback();
		deactivate();
	}

	protected Command getCreateConnection(IGraphicalEditPart sourceEditPart,
			IGraphicalEditPart targetEditPart, ShortConstraintDescriptor shortConstraintDescriptor,
			Map<LinkDescriptor, DeployModelObject> linkResultMap) {

		CreateConnectionRequest connectionRequest = (CreateConnectionRequest) createTargetRequest();

		connectionRequest.setTargetEditPart(sourceEditPart);
		connectionRequest.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_START);
		connectionRequest.setLocation(new Point(0, 0));

		// only if the connection is supported will we get a non null
		// command from the sourceEditPart
		if (sourceEditPart.getCommand(connectionRequest) != null) {

			connectionRequest.setSourceEditPart(sourceEditPart);
			connectionRequest.setTargetEditPart(targetEditPart);
			connectionRequest.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_END);
			connectionRequest.setLocation(new Point(0, 0));
			connectionRequest.getExtendedData().put(DESCRIPTOR, shortConstraintDescriptor);
			connectionRequest.getExtendedData().put(LINKRESULTMAP, linkResultMap);

			return targetEditPart.getCommand(connectionRequest);
		}
		return null;

	}
}
