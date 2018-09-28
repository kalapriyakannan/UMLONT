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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.ISurfaceEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.l10n.DiagramUIPluginImages;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.PopupBarTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.UnitFilter.UnitFilterAction;
import com.ibm.ccl.soa.deploy.core.UnitFilter.UnitFilterTemplate;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.AddUnitMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.internal.DeployableUnitElementUIService;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployCreateElementAndViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * Popup for displaying a modeling assistant balloon containing icons for Units that may be added.
 * 
 * <p>
 * GMF's ModelingAssistantService is no longer used to determine the contents of the balloon.
 * Instead, the DeployableUnitElementUIService is called directly.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @author Ed Snible
 * 
 * @see AddUnitMenuManager for a completely different way to get the same function
 */
public class DeployPopupBarEditPolicy extends DiagramAssistantEditPolicy {

	/* ************************** nested classes *********************** */

	/**
	 * 
	 * Class to hold pertinent information about the tool placed on the popup bar
	 * 
	 */
	private class PopupBarDescriptor {

		/** The action button tooltip */
		private String _tooltip = new String();

		/** The image for the button */
		private Image _icon = null;

		/** The typeinfo used to create the Request for the command */
		private final IElementType _elementType;

		/** The DracgTracker / Tool associatd with the popup bar button */
		private DragTracker _dragTracker = null;

		/**
		 * constructor
		 * 
		 * @param s
		 * @param i
		 * @param elementType
		 * @param theTracker
		 */
		public PopupBarDescriptor(String s, Image i, IElementType elementType, DragTracker theTracker) {
			_tooltip = s;
			_icon = i;
			_dragTracker = theTracker;
			_elementType = elementType;

		}

		/**
		 * gets the element type associated with this Descriptor
		 * 
		 * @return element type
		 */
		public final IElementType getElementtype() {
			return _elementType;
		}

		/**
		 * gets the icon associated with this Descriptor
		 * 
		 * @return Image
		 */
		public final Image getIcon() {
			return _icon;
		}

		/**
		 * gets the drag tracker associated with this Descriptor
		 * 
		 * @return drag tracker
		 */
		public final DragTracker getDragTracker() {
			return _dragTracker;
		}

		/**
		 * gets the tool tip associated with this Descriptor
		 * 
		 * @return string
		 */
		public final String getToolTip() {
			return _tooltip;
		}

	} // end PopupBarDescriptor

	/**
	 * Horizontal chevron Label
	 */
	private class ChevronLabel extends Label {

		/**
		 * flag to drawFocus rect around the handle when the mouse rolls over it
		 */
		private boolean myMouseOver = false;

		/**
		 * Constructor
		 */
		public ChevronLabel() {
			setIcon(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_ARROW_DOWN));
			setToolTip(new Label(Messages.DeployPopupBarEditPolicy_Click_to_show_mor_));

			this.setOpaque(true);
			this.setBackgroundColor(ColorConstants.buttonLightest);
		}

		/**
		 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics) paint a focus
		 *      rectangle for the label if the mouse is inside the label
		 */
		protected void paintBorder(Graphics graphics) {
			super.paintBorder(graphics);

			if (myMouseOver) {
				Rectangle area = getClientArea();
				graphics.setForegroundColor(ColorConstants.black);
				graphics.setBackgroundColor(ColorConstants.white);

				graphics.drawFocus(area.x, area.y, area.width - 1, area.height - 1);
			}
		}

		/**
		 * @see org.eclipse.draw2d.IFigure#handleMouseEntered(org.eclipse.draw2d.MouseEvent) flip
		 *      myMouseOver bit and repaint
		 */
		public void handleMouseEntered(MouseEvent event) {
			super.handleMouseEntered(event);
			myMouseOver = true;
			repaint();
		}

		/**
		 * @see org.eclipse.draw2d.IFigure#handleMouseExited(org.eclipse.draw2d.MouseEvent) flip
		 *      myMouseOver bit and repaint
		 */
		public void handleMouseExited(MouseEvent event) {

			super.handleMouseExited(event);
			myMouseOver = false;
			repaint();
		}

		/**
		 * Iterates through the data structure left behind by {@link #populatePopupBars()}. For each
		 * one it creates a handle, a draw2d {@link Label}, with {@link PopupBarTool} as the drag
		 * tracker. The PopupBarTool only knows the EditPart of the host/container and the
		 * IElementType of the hostee/member to be created. The default getTargetRequest() for the
		 * tool calls GMF's CreateViewRequestFactory.getCreateShapeRequest(). The Request is passed to
		 * the EditPart's policies which make a Command. In this case the Request is always a
		 * {@link CreateViewAndElementRequest} and the Command is always
		 * {@link DeployCreateElementAndViewCommand}.
		 * 
		 * @see org.eclipse.draw2d.IFigure#handleMousePressed(org.eclipse.draw2d.MouseEvent) set
		 *      PopupBarEditPolicy.myActionMoveFigure bit so the popup bar is not dismissed after
		 *      creating an item in the editpart
		 * 
		 */
		public void handleMousePressed(MouseEvent me) {

			if (1 == me.button) {
				// this is the flag in PopupBarEditPolicy that
				// prevents the popup bar from dismissing after a new item
				// is added to a shape, which causes the editpart to be
				// resized.
				setFlag(POPUPBAR_MOVE_FIGURE, true);
				// future: when other tools besides PopupBarTool are
				// used
				// we will need a way in which to call
			}
			super.handleMousePressed(me);

			if (getDropDownListFigure() != null) {
				return;
			}

			List<List<?>> eleTypeGroups = getPopupBarElementTypeGroups();

			IFigure dropdownFigure = createDropDownListFigure();
			dropdownFigure.setSize(ACTION_WIDTH_HGT + 2 * ACTION_BUTTON_START_Y, ACTION_WIDTH_HGT
					* (eleTypeGroups.size() - ENTRY_NUMBER_THRESHOLD));

			int xLoc = ACTION_BUTTON_START_X;
			int yLoc = ACTION_BUTTON_START_Y;

			// Add extra entries into the drop-down list
			for (int i = ENTRY_NUMBER_THRESHOLD; i < eleTypeGroups.size(); i++) {
				List<?> eleTypeGroup = eleTypeGroups.get(i);

				Label item = null;
				if (eleTypeGroup.size() > 1) {
					item = new BarItemWithArrowLabel(eleTypeGroup);
				} else {
					Object eleType = eleTypeGroup.get(0);
					item = new PopupBarLabelHandle(getToolForSelection(eleType),
							DeployableUnitElementUIService.getIconForSelection(eleType));
					// set tooltip
					item.setToolTip(new Label(DeployableUnitElementUIService
							.getNameForSelection(eleType)));
				}

				Rectangle r1 = new Rectangle();
				r1.setLocation(xLoc, yLoc);
				yLoc += ACTION_WIDTH_HGT;
				r1.setSize(ACTION_WIDTH_HGT, ACTION_WIDTH_HGT - ACTION_MARGIN_RIGHT);

				item.setPreferredSize(ACTION_WIDTH_HGT, ACTION_WIDTH_HGT);
				item.setBounds(r1);

				dropdownFigure.add(item);

				item.addMouseMotionListener(DeployPopupBarEditPolicy.this);
//				item.addMouseListener(myMouseKeyListener);
			}

			dropdownFigure.addMouseMotionListener(DeployPopupBarEditPolicy.this);
//			dropdownFigure.addMouseListener(myMouseKeyListener);

			// the feedback layer figures do not recieve mouse events so do not use
			// it for popup bars
			IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
			layer.add(dropdownFigure);

			// Locate the position of the drop-down list
			//Point mouseLocation = me.getLocation();
			dropdownFigure.setLocation(getBounds().getBottomRight());
		} // end method handleMousePressed

	} // end inner class ChevronLabel

	/**
	 * Default tool placed on the popup bar
	 * 
	 * @author affrantz@us.ibm.com
	 */
	private class PopupBarLabelHandle extends Label implements Handle {
		/**
		 * flag to drawFocus rect around the handle when the mouse rolls over it
		 */
		private boolean myMouseOver = false;

		private Image myDisabledImage = null;

		/** The dragTracker CreationTool associated with the handle * */
		private DragTracker myDragTracker = null;

		private Image getDisabledImage() {
			if (myDisabledImage != null) {
				return myDisabledImage;
			}

			Image theImage = this.getIcon();
			if (theImage == null) {
				return null;
			}

			myDisabledImage = new Image(Display.getCurrent(), theImage, SWT.IMAGE_DISABLE);
			imagesToBeDisposed.add(myDisabledImage);
			return myDisabledImage;
		}

		/**
		 * cnostructor
		 * 
		 * @param tracker
		 * @param theImage
		 */
		public PopupBarLabelHandle(DragTracker tracker, Image theImage) {
			super(theImage);
			myDragTracker = tracker;
			this.setOpaque(true);
			this.setBackgroundColor(ColorConstants.buttonLightest);
			calculateEnabled();
		}

		/**
		 * @see org.eclipse.gef.Handle#getAccessibleLocation()
		 */
		public Point getAccessibleLocation() {
			return null;
		}

		/**
		 * @see org.eclipse.gef.Handle#getDragTracker()
		 */
		public DragTracker getDragTracker() {
			return myDragTracker;
		}

		/**
		 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics) paint a focus
		 *      rectangle for the label if the mouse is inside the label
		 */
		protected void paintBorder(Graphics graphics) {
			super.paintBorder(graphics);

			if (myMouseOver) {

				Rectangle area = getClientArea();
				graphics.setForegroundColor(ColorConstants.black);
				graphics.setBackgroundColor(ColorConstants.white);

				graphics.drawFocus(area.x, area.y, area.width - 1, area.height - 1);

			}

		}

		/**
		 * @see org.eclipse.draw2d.IFigure#handleMouseEntered(org.eclipse.draw2d.MouseEvent) flip
		 *      myMouseOver bit and repaint
		 */
		public void handleMouseEntered(MouseEvent event) {

			calculateEnabled();

			super.handleMouseEntered(event);
			myMouseOver = true;
			repaint();
		}

		/**
		 * @see org.eclipse.draw2d.IFigure#handleMouseExited(org.eclipse.draw2d.MouseEvent) flip
		 *      myMouseOver bit and repaint
		 */
		public void handleMouseExited(MouseEvent event) {

			super.handleMouseExited(event);
			myMouseOver = false;
			repaint();
		}

		/**
		 * @see org.eclipse.draw2d.IFigure#handleMousePressed(org.eclipse.draw2d.MouseEvent) set
		 *      PopupBarEditPolicy.myActionMoveFigure bit so the popup bar is not dismissed after
		 *      creating an item in the editpart
		 * 
		 */
		public void handleMousePressed(MouseEvent event) {

			if (1 == event.button) {
				// this is the flag in PopupBarEditPolicy that
				// prevents the popup bar from dismissing after a new item
				// is added to a shape, which causes the editpart to be
				// resized.
				setFlag(POPUPBAR_MOVE_FIGURE, true);
				// future: when other tools besides PopupBarTool are
				// used
				// we will need a way in which to call

			}

			super.handleMousePressed(event);
		}

		private void calculateEnabled() {
			if (myDragTracker != null && myDragTracker instanceof AbstractPopupBarTool) {
				AbstractPopupBarTool abarTool = (AbstractPopupBarTool) myDragTracker;
				setEnabled(abarTool.isCommandEnabled());
			} else {
				setEnabled(true);
			}
		}

		/**
		 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		protected void paintFigure(Graphics graphics) {
			if (!isEnabled()) {
				Image theImage = getDisabledImage();
				if (theImage != null) {
					graphics.translate(bounds.x, bounds.y);
					graphics.drawImage(theImage, getIconLocation());
					graphics.translate(-bounds.x, -bounds.y);
					return;
				}

			}
			super.paintFigure(graphics);

		}
	}

	/**
	 * the label for the popup bar item with a down arrow.
	 */
	private class BarItemWithArrowLabel extends Label {
		private final Image arrowImg;
		private final List<?> eleTypeGroup;

		/**
		 * flag to drawFocus rect around the handle when the mouse rolls over it
		 */
		private boolean myMouseOver = false;

		/**
		 * constructor
		 * 
		 * @param newEleTypeGroup
		 */
		private BarItemWithArrowLabel(List<?> newEleTypeGroup) {
			Object type = newEleTypeGroup.get(0);
			//			setIcon(IconService.getInstance().getIcon(type));
			setIcon(DeployableUnitElementUIService.getIconForSelection(type));

			this.setOpaque(true);
			this.setBackgroundColor(ColorConstants.buttonLightest);

			arrowImg = DeployCoreUIPlugin
					.getImageDescriptor("/icons/misc/ArrowDown.gif").createImage(); //$NON-NLS-1$

			eleTypeGroup = newEleTypeGroup;
		}

		/**
		 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics) paint a focus
		 *      rectangle for the label if the mouse is inside the label
		 */
		protected void paintBorder(Graphics graphics) {
			super.paintBorder(graphics);

			if (myMouseOver) {

				Rectangle area = getClientArea();
				graphics.setForegroundColor(ColorConstants.black);
				graphics.setBackgroundColor(ColorConstants.white);

				graphics.drawFocus(area.x, area.y, area.width - 1, area.height - 1);
			}
		}

		/**
		 * @see org.eclipse.draw2d.IFigure#handleMouseEntered(org.eclipse.draw2d.MouseEvent) flip
		 *      myMouseOver bit and repaint
		 */
		public void handleMouseEntered(MouseEvent event) {
			super.handleMouseEntered(event);
			myMouseOver = true;
			repaint();
		}

		/**
		 * @see org.eclipse.draw2d.IFigure#handleMouseExited(org.eclipse.draw2d.MouseEvent) flip
		 *      myMouseOver bit and repaint
		 */
		public void handleMouseExited(MouseEvent event) {
			super.handleMouseExited(event);
			myMouseOver = false;
			repaint();
		}

		/**
		 * @see org.eclipse.draw2d.IFigure#handleMousePressed(org.eclipse.draw2d.MouseEvent) set
		 *      PopupBarEditPolicy.myActionMoveFigure bit so the popup bar is not dismissed after
		 *      creating an item in the editpart
		 * 
		 */
		public void handleMousePressed(MouseEvent me) {

			if (1 == me.button) {
				// this is the flag in PopupBarEditPolicy that
				// prevents the popup bar from dismissing after a new item
				// is added to a shape, which causes the editpart to be
				// resized.
				setFlag(POPUPBAR_MOVE_FIGURE, true);
				// future: when other tools besides PopupBarTool are
				// used
				// we will need a way in which to call
			}

			super.handleMousePressed(me);

			// prompt the dropdown list
			// 1. Get all specification element types from the meta type
			// 2. Build the drop down list
			//ItemDropDownFigure figure 

			Menu menu = new Menu(Display.getCurrent().getActiveShell());
			for (int i = 0; i < eleTypeGroup.size(); i++) {
				final Object eleType = eleTypeGroup.get(i);
				MenuItem item = new MenuItem(menu, SWT.CASCADE);
				item.setImage(DeployableUnitElementUIService.getIconForSelection(eleType));
				item.setText(DeployableUnitElementUIService.getNameForSelection(eleType));
				item.addSelectionListener(new SelectionListener() {
					public void widgetDefaultSelected(SelectionEvent e) {
					}

					public void widgetSelected(SelectionEvent e) {
						execute(eleType);
					}
				});
			}
			menu.setVisible(true);

		}

		private void execute(Object eleType) {
			Command cmd = DeployableUnitElementUIService.getGefCommandForSelection(getUnit(getHost()),
					eleType, getActionType(eleType), (IGraphicalEditPart) getHost());

			DiagramCommandStack cmdStack = ((IGraphicalEditPart) getHost()).getDiagramEditDomain()
					.getDiagramCommandStack();
			cmdStack.execute(cmd);
		}

		/**
		 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		protected void paintFigure(Graphics graphics) {
			super.paintFigure(graphics);
			graphics.translate(bounds.x, bounds.y);
			arrowImg.getBounds();
			graphics.drawImage(arrowImg, getBounds().width - arrowImg.getBounds().width,
					getBounds().height - arrowImg.getBounds().height);
			graphics.translate(-bounds.x, -bounds.y);
		}
	}

	private static Image IMAGE_POPUPBAR_PLUS = DiagramUIPluginImages
			.get(DiagramUIPluginImages.IMG_POPUPBAR_PLUS);

	private static Image IMAGE_POPUPBAR = DiagramUIPluginImages
			.get(DiagramUIPluginImages.IMG_POPUPBAR);

	/**
	 * This is the figure which represents the drop-down popup list.
	 * 
	 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
	 */
	private class DropDownListFigure extends RectangleFigure {
		private DropDownListFigure() {
			this.setFill(true);
			this.setBackgroundColor(ColorConstants.buttonLightest);
			this.setForegroundColor(ColorConstants.lightGray);
			this.setVisible(true);
			this.setEnabled(true);
			this.setOpaque(true);
		}
	}

	/**
	 * 
	 * This is the figure that represents the ballon portion of the popup bar
	 * 
	 * @author affrantz@us.ibm.com
	 */
	private class RoundedRectangleWithTail extends RoundedRectangle {

		private Image myTailImage = null;

		private boolean bIsInit = false;

		private final int myCornerDimension = 6;

		/**
		 * constructor
		 */
		public RoundedRectangleWithTail() {
			// we do not make the myActionTailFigue opaque because it
			// doesn't look good when magnification is set.
			this.setFill(true);
			this.setBackgroundColor(ColorConstants.buttonLightest);
			this.setForegroundColor(ColorConstants.lightGray);
			this.setVisible(true);
			this.setEnabled(true);
			this.setOpaque(true);

		}

		/**
		 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		public void paintFigure(Graphics graphics) {
			int shiftWidth = 3;
			Image theTail = getTail();
			Rectangle theBounds = this.getBounds().getCopy();
			theBounds.height -= theTail.getBounds().height;
			theBounds.height -= shiftWidth;// shift slight above cursor
			theBounds.x += shiftWidth; // shift slight to right of cursor
			theBounds.width -= shiftWidth + 1; // otherwise rhs is clipped

			// fill the round rectangle first since it is opaque
			graphics.fillRoundRectangle(theBounds, myCornerDimension, myCornerDimension);
			graphics.drawRoundRectangle(theBounds, myCornerDimension, myCornerDimension);

			graphics.drawImage(theTail, theBounds.x + 6, theBounds.y + theBounds.height - 1);

		}

		private Image getTail() {
			if (!bIsInit) {
				if (getIsDisplayAtMouseHoverLocation() && !isHostConnection()) {
					if (myTailImage == null) {
						myTailImage = IMAGE_POPUPBAR_PLUS;
						bIsInit = true;
					}
				} else {
					if (myTailImage == null) {
						if (usePlusTail) {
							myTailImage = IMAGE_POPUPBAR_PLUS;
						} else {
							myTailImage = IMAGE_POPUPBAR;
						}
						bIsInit = true;
					}
				}

			}
			return myTailImage;

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#isDiagramAssistant(java.lang.Object)
	 */
	protected boolean isDiagramAssistant(Object object) {
		return object instanceof RoundedRectangleWithTail || object instanceof PopupBarLabelHandle
				|| object instanceof ChevronLabel || object instanceof BarItemWithArrowLabel;
	}

	/**
	 * Adds the popup bar after a delay
	 */
	public void mouseHover(MouseEvent me) {
		// If event source is ChevronLabel, then show popup bar
		if (me.getSource() instanceof ChevronLabel) {
			setAvoidHidingDiagramAssistant(true);
			setMouseLocation(me.getLocation());
			showDiagramAssistant(getMouseLocation()); // no delay

			return;
		}

		// if the cursor is inside the popup bar
		// or the keyboar triggred activation
		// then we do not want to deactivate
		if (!isDiagramAssistant(me.getSource())) {
			setAvoidHidingDiagramAssistant(false);
		}

		setMouseLocation(me.getLocation());

		if (getIsDisplayAtMouseHoverLocation()) {
			showDiagramAssistantAfterDelay(getAppearanceDelayLocationSpecific()); // no
			// delay
		} else if (shouldShowDiagramAssistant()) {
			showDiagramAssistant(getMouseLocation()); // no delay
		}
	}

	/**
	 * @see org.eclipse.draw2d.MouseMotionListener#mouseMoved(org.eclipse.draw2d.MouseEvent)
	 */
	public void mouseMoved(MouseEvent me) {

		if (getIsDisplayAtMouseHoverLocation()) {
			Object srcObj = me.getSource();
			if (srcObj != null && srcObj.equals(getHostFigure())) {
				hideDiagramAssistant();
			}
		}
		setAvoidHidingDiagramAssistant(true);
		setMouseLocation(me.getLocation());

		if (!getIsDisplayAtMouseHoverLocation()) {
			// if the cursor is inside the popup bar
			// or the keyboar triggred activation
			// then we do not want to deactivate
			if (!isDiagramAssistant(me.getSource())) {
				setAvoidHidingDiagramAssistant(false);
			}

			showDiagramAssistantAfterDelay(getAppearanceDelay());
		}
	}

	/**
	 * Listens to the owner figure being moved so the handles can be removed when this occurs.
	 * 
	 * @author affrantz@us.ibm.com
	 * 
	 */
	private class OwnerMovedListener implements FigureListener {

		private final Point myPopupBarLastPosition = new Point(0, 0);

		boolean hasPositionChanged(Rectangle theBounds) {
			if (theBounds.x != myPopupBarLastPosition.x) {
				return true;
			}
			if (theBounds.y != myPopupBarLastPosition.y) {
				return true;
			}
			return false;
		}

		/**
		 * @see org.eclipse.draw2d.FigureListener#figureMoved(org.eclipse.draw2d.IFigure)
		 */
		public void figureMoved(IFigure source) {
			// for some reason we get more than one
			// figure moved call after compartment items are added
			// myActionMoveFigure handles the first one which we expect
			// hasPositionChanged handles the others caused by the selection of
			// the compartment
			// item.
			if (getFlag(POPUPBAR_MOVE_FIGURE) && hasPositionChanged(source.getBounds())) {
				hideDiagramAssistant(); // without delay
			} else {
				setFlag(POPUPBAR_MOVE_FIGURE, false); // toggle flag back
				Rectangle theBounds = source.getBounds();
				myPopupBarLastPosition.setLocation(theBounds.x, theBounds.y);

			}

		}
	}

	/**
	 * Listens for mouse key presses so the popup bar can be dismissed if the context menu is
	 * displayed
	 * 
	 * @author affrantz@us.ibm.com
	 */
	private class PopupBarMouseListener extends MouseListener.Stub {

		/**
		 * @see org.eclipse.draw2d.MouseListener#mousePressed(org.eclipse.draw2d.MouseEvent)
		 */
		public void mousePressed(MouseEvent me) {
			hideDiagramAssistant();
			setPopupBarOnDiagramActivated(true);
		}
	}

	/* ************************* End nested classes ******************** */

	/** the maximum number of entries which show in the horizontal popup bar */
	static private int ENTRY_NUMBER_THRESHOLD = 7;

	/** Y postion offset from shape where the balloon top begin. */
	static private int BALLOON_Y_OFFSET = 10;

	/** Y postion offset from shape where the balloon top begin. */
	static private double BALLOON_X_OFFSET_RHS = 0.90;

	static private double BALLOON_X_OFFSET_LHS = 0.25;

	/** Y postion offset from shape where the balloon top begin. */
	static private int ACTION_WIDTH_HGT = 30;

	static private int ACTION_BUTTON_START_X = 5;

	static private int ACTION_BUTTON_START_Y = 5;

	static private int ACTION_MARGIN_RIGHT = 10;

	/** popup bar bits */
	static private int POPUPBAR_ACTIVATEONHOVER = 0x01; /* Display the action when hovering */
	static private int POPUPBAR_MOVE_FIGURE = 0x02; /*
	 * Ignore the first figureMoved event when
	 * creating elements inside a shape via a popup
	 * bar
	 */
	static private int POPUPBAR_DISPLAYATMOUSEHOVERLOCATION = 0x04; /*
	 * Display the popup bar at the
	 * mouse location used by
	 * diagrams and machine edit
	 * parts
	 */
	static private int POPUPBAR_ONDIAGRAMACTIVATED = 0x10; /*
	 * For popup bars on diagram and machine
	 * edit parts, where we
	 * POPUPBAR_DISPLAYATMOUSEHOVERLOCATION,
	 * don't display popup bar until user
	 * clicks on surface
	 */
	static private int POPUPBAR_HOST_IS_CONNECTION = 0x20; /*
	 * For popup bars on connection edit
	 * parts
	 */

	/** Bit field for the actrionbar associated bits */
	private int myPopupBarFlags = POPUPBAR_ACTIVATEONHOVER;

	private double myBallonOffsetPercent = BALLOON_X_OFFSET_RHS;

	/** the figure used to surround the action buttons */
	private IFigure myBalloon = null;

	private IFigure dropDownListFigure = null;

	private boolean usePlusTail = false;

	/** The popup bar descriptors for the popup bar buttons */
	private final List<PopupBarDescriptor> myPopupBarDescriptors = new ArrayList<PopupBarDescriptor>();

	//	private final List<List<IElementType>> barElementTypeGroups = new ArrayList<List<IElementType>>();
	private final List<List<?>> barElementTypeGroups = new ArrayList<List<? extends Object>>();

	/** Images created that must be deleted when popup bar is removed */
	protected List<Image> imagesToBeDisposed = new ArrayList<Image>();

	/** mouse keys listener for the owner shape */
	private final PopupBarMouseListener myMouseKeyListener = new PopupBarMouseListener();

	/** listener for owner shape movement */
	private final OwnerMovedListener myOwnerMovedListener = new OwnerMovedListener();

	private List<?> nubTypes;

	private List<?> memberTypes;

	private Dimension _ballonSize;

	//	private List<?> hosteeTypes;

	/**
	 * 
	 */
	public DeployPopupBarEditPolicy() {
		// do nothing
	}

	/** flag for whether mouse cursor within shape */

	private void setFlag(int bit, boolean b) {
		if (b) {
			myPopupBarFlags |= bit;
		} else if (getFlag(bit)) {
			myPopupBarFlags ^= bit;
		}

	}

	private boolean getFlag(int bit) {
		return (myPopupBarFlags & bit) > 0;
	}

	private void setPopupBarOnDiagramActivated(boolean bVal) {
		setFlag(POPUPBAR_ONDIAGRAMACTIVATED, bVal);
	}

	private boolean getPopupBarOnDiagramActivated() {
		return getFlag(POPUPBAR_ONDIAGRAMACTIVATED);
	}

	/**
	 * set the host is connection flag
	 * 
	 * @param bVal
	 *           the new value
	 */
	protected void setHostConnection(boolean bVal) {
		setFlag(POPUPBAR_HOST_IS_CONNECTION, bVal);
	}

	/**
	 * get the host is connection flag
	 * 
	 * @return true or false
	 */
	protected boolean isHostConnection() {
		return getFlag(POPUPBAR_HOST_IS_CONNECTION);
	}

	/**
	 * Populates the popup bar with popup bar descriptors added by suclassing this editpolicy (i.e.
	 * <code>fillPopupBarDescriptors</code> and by querying the modeling assistant service for all
	 * types supported on the popup bar of this host. For those types added by the modeling assistant
	 * service the icons are retrieved using the Icon Service.
	 */
	protected void populatePopupBars() {
		fillPopupBarDescriptors();

		// Create a data structure for {@link #initPopupBars()} or 
		// {@link ChevronLabel#handleMousePressed(MouseEvent me)} to use.

		//		List types = ModelingAssistantService.getInstance().getTypesForPopupBar(getHost());

		// Hack to go directly to DeployableUnitElementUIService, avoiding GMF.  This lets us see
		// the original categories.
		IGraphicalEditPart editPart = (IGraphicalEditPart) getHost().getAdapter(
				IGraphicalEditPart.class);
		Unit unit = (Unit) editPart.getNotationView().getElement();

		List<Object> types = new ArrayList<Object>();
		List<?> nubTypes2 = DeployableUnitElementUIService.getInstance().getAllowableNubUnitElements(
				unit);
		List<?> memberTypes2 = DeployableUnitElementUIService.getInstance()
				.getAllowableMemberUnitElements(unit);
		List<?> hosteeTypes2 = DeployableUnitElementUIService.getInstance()
				.getAllowableHostingUnitElements(unit);
		types.addAll(nubTypes2);
		types.addAll(memberTypes2);
		types.addAll(hosteeTypes2);
		nubTypes = flatten(nubTypes2);
		memberTypes = flatten(memberTypes2);
		//		hosteeTypes = flatten(hosteeTypes2);

		// change popup to have a plus sign if components
		if (nubTypes2.size() > 0) {
			usePlusTail = true;
		}

		// group element types

		// Wrap each returned IElementType in a list (unless it already is one).
		for (int i = 0; i < types.size(); i++) {
			Object obj = types.get(i);
			if (obj instanceof List) {
				List<?> group = (List<?>) obj;
				//				List<IElementType> group = new ArrayList<IElementType>();
				getPopupBarElementTypeGroups().add(group);
			} else {

				//			IElementType eleType = (IElementType) obj;
				// Wrap the value in a list, the list will contain one element and thus not drop-down
				List<Object> group = new ArrayList<Object>();
				group.add(obj);
				getPopupBarElementTypeGroups().add(group);

				//			IElementType eleType = types.get(i);
				//			List<IElementType> group = new ArrayList<IElementType>();
				//			group.add(eleType);
				//			getPopupBarElementTypeGroups().add(group);
			}
		}

	}

	private List<Object> flatten(List<?> listOfLists) {
		List<Object> retVal = new ArrayList<Object>();
		flatten(listOfLists, retVal);
		return retVal;
	}

	private List<?> flatten(List<?> listOfLists, List<Object> retVal) {
		for (Iterator<?> it = listOfLists.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj instanceof IElementType || obj instanceof UnitFilterAction
					|| obj instanceof UnitFilterTemplate) {
				retVal.add(obj);
			} else if (obj instanceof List) {
				List<?> l = (List<?>) obj;
				flatten(l, retVal);
			} else {
				DeployCoreUIPlugin.log(IStatus.WARNING, 0, "Unknown UnitFilter tool type " + obj, null); //$NON-NLS-1$
			}
		}

		return retVal;
	}

	/**
	 * This is the entry point that subclasses can override to fill the popup bar descriptors if they
	 * have customized tools that cannot be done using the type along with the modeling assistant
	 * service.
	 */
	protected void fillPopupBarDescriptors() {
		// subclasses can override.
	}

	private boolean isSelectionToolActive() {
		// getViewer calls getParent so check for null
		if (getHost().getParent() != null && getHost().isActive()) {
			Tool theTool = getHost().getViewer().getEditDomain().getActiveTool();
			if (theTool != null && theTool instanceof SelectionTool) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#shouldShowDiagramAssistant()
	 */
	protected boolean shouldShowDiagramAssistant() {
		if (!super.shouldShowDiagramAssistant()) {
			return false;
		}

		if (this.getIsDisplayAtMouseHoverLocation()) {
			if (isHostConnection()) {
				return isSelectionToolActive();
			}
			if (getPopupBarOnDiagramActivated()) {
				return isSelectionToolActive();
			}
			return false;
		}
		//		else
		return isSelectionToolActive();
	}

	/**
	 * allows plugins to add their own popup bar tools and tips
	 * 
	 * @param elementType
	 * @param theImage
	 * @param theTracker
	 * @param theTip
	 */
	protected void addPopupBarDescriptor(IElementType elementType, Image theImage,
			DragTracker theTracker, String theTip) {

		PopupBarDescriptor desc = new PopupBarDescriptor(theTip, theImage, elementType, theTracker);
		myPopupBarDescriptors.add(desc);

	}

	/**
	 * adds popup bar descriptor
	 * 
	 * @param elementType
	 * @param theImage
	 * @param theTracker
	 */
	protected void addPopupBarDescriptor(IElementType elementType, Image theImage,
			DragTracker theTracker) {

		String theInputStr = DiagramUIMessages.PopupBar_AddNew;

		String theTip = NLS.bind(theInputStr, elementType.getDisplayName());

		addPopupBarDescriptor(elementType, theImage, theTracker, theTip);
	}

	/**
	 * default method for plugins which passes along the PopupBarTool as the tool to be used.
	 * 
	 * @param elementType
	 * @param theImage
	 */
	protected void addPopupBarDescriptor(IElementType elementType, Image theImage) {

		//		this.addPopupBarDescriptor(elementType, theImage, new PopupBarTool(getHost(), elementType));
		this.addPopupBarDescriptor(elementType, theImage, getToolForSelection(elementType));

	}

	/**
	 * @param elementType
	 * @param theImage
	 * @param theTip
	 */
	protected void addPopupBarDescriptor(IElementType elementType, Image theImage, String theTip) {

		//		PopupBarTool theTracker = new PopupBarTool(getHost(), elementType);
		DragTracker theTracker = getToolForSelection(elementType);
		PopupBarDescriptor desc = new PopupBarDescriptor(theTip, theImage, elementType, theTracker);
		myPopupBarDescriptors.add(desc);

	}

	//	/**
	//	 * method used primarily to add UnspecifiedTypeCreationTool
	//	 * 
	//	 * @param elementType
	//	 * @param theImage
	//	 * @param theRequest
	//	 *           the create request to be used
	//	 */
	//	protected void addPopupBarDescriptor(IElementType elementType, Image theImage,
	//			CreateRequest theRequest) {
	//		//		PopupBarTool theTracker = new PopupBarTool(getHost(), theRequest);
	//		DragTracker theTracker = getToolForSelection(theRequest);
	//
	//		this.addPopupBarDescriptor(elementType, theImage, theTracker);
	//
	//	}

	//	/**
	//	 * gets the popup bar descriptors
	//	 * 
	//	 * @return list
	//	 */
	//	private List<PopupBarDescriptor> getPopupBarDescriptors() {
	//		return myPopupBarDescriptors;
	//	}

	private List<List<?>> getPopupBarElementTypeGroups() {
		return barElementTypeGroups;
	}

	/**
	 * initialize the popup bars from the list of action descriptors.
	 */
	private void initPopupBars() {

		//List theList = getPopupBarDescriptors();
		List<List<?>> theList = getPopupBarElementTypeGroups();

		if (theList.isEmpty()) {
			return;
		}
		myBalloon = createPopupBarFigure();

		int iTotal = 0;
		if (theList.size() > ENTRY_NUMBER_THRESHOLD) {
			iTotal = ACTION_WIDTH_HGT * (ENTRY_NUMBER_THRESHOLD + 1) + ACTION_MARGIN_RIGHT;
		} else {
			iTotal = ACTION_WIDTH_HGT * theList.size() + ACTION_MARGIN_RIGHT;
		}

		setBallonSize(iTotal, ACTION_WIDTH_HGT + 2 * ACTION_BUTTON_START_Y);

		int xLoc = ACTION_BUTTON_START_X;
		int yLoc = ACTION_BUTTON_START_Y;

		for (int i = 0; i < theList.size() && i < ENTRY_NUMBER_THRESHOLD; i++) {
			List<?> eleTypeGroup = theList.get(i);

			Label item = null;
			if (eleTypeGroup.size() > 1) {
				item = new BarItemWithArrowLabel(eleTypeGroup);
			} else {
				//				IElementType eleType = eleTypeGroup.get(0);
				Object eleType = eleTypeGroup.get(0);
				item = new PopupBarLabelHandle(getToolForSelection(eleType),
						DeployableUnitElementUIService.getIconForSelection(eleType));

				// set tooltip
				item.setToolTip(new Label(DeployableUnitElementUIService.getNameForSelection(eleType)));
			}

			Rectangle bound = new Rectangle();
			bound.setLocation(xLoc, yLoc);
			xLoc += ACTION_WIDTH_HGT;
			bound.setSize(ACTION_WIDTH_HGT, ACTION_WIDTH_HGT - ACTION_MARGIN_RIGHT);

			/*
			 * Label tip = new Label(); tip.setText(theDesc.getToolTip()); item.setToolTip(tip);
			 */

			item.setPreferredSize(ACTION_WIDTH_HGT, ACTION_WIDTH_HGT);
			item.setBounds(bound);

			getBalloon().add(item);

			item.addMouseMotionListener(this);
//			item.addMouseListener(myMouseKeyListener);

		}

		/** Draw chevron */
		if (theList.size() > ENTRY_NUMBER_THRESHOLD) {
			ChevronLabel chevronLabel = new ChevronLabel();

			Rectangle r = new Rectangle();
			r.setLocation(xLoc, yLoc);
			r.setSize(ACTION_WIDTH_HGT, ACTION_WIDTH_HGT - ACTION_MARGIN_RIGHT);
			chevronLabel.setPreferredSize(ACTION_WIDTH_HGT, ACTION_WIDTH_HGT);
			chevronLabel.setBounds(r);

			chevronLabel.addMouseMotionListener(this);
//			chevronLabel.addMouseListener(myMouseKeyListener);

			getBalloon().add(chevronLabel);
		}
	}

	private AbstractPopupBarTool getToolForSelection(Object obj) {
		if (obj instanceof IElementType) {
			return getToolForSelection((IElementType) obj);
		} else if (obj instanceof UnitFilterAction) {
			return new PopupActionWrapperTool((IGraphicalEditPart) getHost(), (UnitFilterAction) obj,
					getActionType(obj));
		} else if (obj instanceof UnitFilterTemplate) {
			UnitFilterTemplate uft = (UnitFilterTemplate) obj;
			return new SoaDeployPopupBarTool((IGraphicalEditPart) getHost(), uft, getActionType(uft));
		}

		return null;
	}

	private AbstractPopupBarTool getToolForSelection(IElementType eleType) {
		return new SoaDeployPopupBarTool((IGraphicalEditPart) getHost(), eleType,
				getActionType(eleType));
		//		return new PopupBarTool(getHost(), eleType);
	}

	private int getActionType(Object unitFilterThing) {
		// Assume hostee
		int actionType = UnitFilter.HOSTEE;
		if (memberTypes.contains(unitFilterThing)) {
			actionType = UnitFilter.MEMBER;
		} else if (nubTypes.contains(unitFilterThing)) {
			actionType = UnitFilter.NUB;
		}

		return actionType;
	}

	//	private AbstractPopupBarTool getToolForSelection(CreateRequest createRequest) {
	//	return new PopupBarTool(getHost(), createRequest);
	//}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#getPreferenceName()
	 */
	/*
	 * String getPreferenceName() { return IPreferenceConstants.PREF_SHOW_POPUP_BARS; }
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#isDiagramAssistantShowing()
	 */
	protected boolean isDiagramAssistantShowing() {
		return getBalloon() != null;
	}

	private IFigure getBalloon() {
		return myBalloon;
	}

	private void setBallonSize(int width, int height) {
		_ballonSize = new Dimension(width, height);
	}

	private Dimension getBallonSize() {
		return _ballonSize;
	}

	protected IFigure createPopupBarFigure() {
		return new RoundedRectangleWithTail();
	}

	protected void showDiagramAssistant(Point referencePoint) {
		// if user is dragging/selecting mouse, no popup
		if (GMFUtils.getDeployDiagramEditPart(getHost()).isMousePressed()) {
			return;
		}

		// if host is a non mutable imported unit, nothing can be added to it
		if (GMFUtils.isImportThatCannotHost(getHost())) {
			return;
		}

		// already have a one
		if (getBalloon() != null && getBalloon().getParent() != null) {
			return;
		}

		if (getPopupBarElementTypeGroups().isEmpty()) {
			populatePopupBars();
			initPopupBars();

			if (getPopupBarElementTypeGroups().isEmpty()) {
				return; // nothing to show
			}
		}
		getBalloon().addMouseMotionListener(this);
		//getBalloon().addMouseListener(myMouseKeyListenerr);

		// the feedback layer figures do not recieve mouse events so do not use
		// it for popup bars
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		layer.add(getBalloon());

		if (referencePoint == null) {
			referencePoint = getHostFigure().getBounds().getCenter();
		}

		Point thePoint = getBalloonPosition(referencePoint);

		getBalloon().setBounds(new Rectangle(thePoint, getBallonSize()));

		// dismiss the popup bar after a delay
		if (!shouldAvoidHidingDiagramAssistant()) {
			hideDiagramAssistantAfterDelay(getDisappearanceDelay());
		}
	}

	/**
	 * getter for the IsDisplayAtMouseHoverLocation flag
	 * 
	 * @return true or false
	 */
	protected boolean getIsDisplayAtMouseHoverLocation() {
		return getFlag(POPUPBAR_DISPLAYATMOUSEHOVERLOCATION);
	}

	/**
	 * setter for the IsDisplayAtMouseHoverLocation
	 * 
	 * @param bVal
	 */
	protected void setIsDisplayAtMouseHoverLocation(boolean bVal) {
		setFlag(POPUPBAR_DISPLAYATMOUSEHOVERLOCATION, bVal);
	}

	/**
	 * For editparts that consume the entire viewport, statechart, structure, communication, we want
	 * to display the popup bar at the mouse location.
	 * 
	 * @param referencePoint
	 *           The reference point which may be used to determine where the diagram assistant
	 *           should be located. This is most likely the current mouse location.
	 * @return Point
	 */
	private Point getBalloonPosition(Point referencePoint) {
		Point thePoint = new Point();
		Dimension theoffset = new Dimension();
		Rectangle rcBounds = getHostFigure().getBounds().getCopy();

		getHostFigure().translateToAbsolute(rcBounds);
		getBalloon().translateToRelative(rcBounds);

		theoffset.height = -(BALLOON_Y_OFFSET + ACTION_WIDTH_HGT);
		theoffset.width = (int) (rcBounds.width * myBallonOffsetPercent);

		thePoint.x = rcBounds.x + theoffset.width * 3 / 4;
		thePoint.y = rcBounds.y + theoffset.height;

		// Don't display the balloon outside of the screen
		if (getHost().getViewer().getControl() instanceof FigureCanvas) {
			FigureCanvas figureCanvas = (FigureCanvas) getHost().getViewer().getControl();
			Viewport vp = figureCanvas.getViewport();
			Rectangle vpRect = vp.getClientArea();
			if (thePoint.y < vpRect.y) {
				thePoint.y = vpRect.y + 15;
			}
			Dimension dim = getBallonSize();
			if (thePoint.x + dim.width + 30 >= vpRect.x + vpRect.width) {
				thePoint.x = vpRect.x + vpRect.width - dim.width - 15;
			}
		}

		return thePoint;
	}

	// This only checks the X direction!
	private boolean willBalloonBeClipped(Point pnt) {
		Control ctrl1 = getHost().getViewer().getControl();
		if (ctrl1 instanceof FigureCanvas) {
			FigureCanvas figureCanvas = (FigureCanvas) ctrl1;
			Viewport vp = figureCanvas.getViewport();
			Rectangle vpRect = vp.getClientArea();
			Dimension dim = getBalloon().getSize();
			if (pnt.x + dim.width >= vpRect.x + vpRect.width) {
				return true;
			}
		}
		return false;
	}

	private IFigure getDropDownListFigure() {
		return dropDownListFigure;
	}

	private void clearDropDownListFigure() {
		dropDownListFigure = null;
	}

	private IFigure createDropDownListFigure() {
		dropDownListFigure = new DropDownListFigure();

		return dropDownListFigure;
	}

	private void teardownPopupBar() {
		/** Destroy the balloon */
		getBalloon().removeMouseMotionListener(this);
		//getBalloon().removeMouseListener(myMouseKeyListenerr);
		// the feedback layer figures do not recieve mouse events
		IFigure handleLayer = getLayer(LayerConstants.HANDLE_LAYER);
		if (myBalloon.getParent() != null) {
			handleLayer.remove(myBalloon);
		}
		myBalloon = null;

		//this.myPopupBarDescriptors.clear();
		getPopupBarElementTypeGroups().clear();

		IFigure dropDownFigure = getDropDownListFigure();
		if (dropDownFigure != null && dropDownFigure.getParent() != null) {
			handleLayer.remove(dropDownFigure);
			clearDropDownListFigure();
		}

		setRightHandDisplay(); // set back to default

		for (Iterator<Image> iter = imagesToBeDisposed.iterator(); iter.hasNext();) {
			iter.next().dispose();
		}
		imagesToBeDisposed.clear();
	}

	protected void hideDiagramAssistant() {
		if (getBalloon() != null) {
			teardownPopupBar();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#showDiagramAssistantAfterDelay(int)
	 */
	protected void showDiagramAssistantAfterDelay(int theDelay) {
		// only show the popup bar if it isn't already showing
		if (!isDiagramAssistantShowing()) {
			super.showDiagramAssistantAfterDelay(theDelay);
		}
	}

	public void activate() {
		//super.activate();  
		// To cancel the FocusListener which is registered by DiagramAssisantEditPolicy
		// to hide diagram assistant when host editpart loses focus
		((IGraphicalEditPart) getHost()).getFigure().addMouseMotionListener(this);

		getHostFigure().addMouseListener(myMouseKeyListener);
		getHostFigure().addFigureListener(myOwnerMovedListener);

		if (getHost() instanceof ISurfaceEditPart) {
			setIsDisplayAtMouseHoverLocation(true);
		}
	}

	public void deactivate() {
		getHostFigure().removeMouseListener(myMouseKeyListener);
		getHostFigure().removeFigureListener(myOwnerMovedListener);

		//super.deactivate();
		// To cancel the FocusListener which is registered by DiagramAssisantEditPolicy
		// to hide diagram assistant when host editpart loses focus
		((IGraphicalEditPart) getHost()).getFigure().removeMouseMotionListener(this);
		hideDiagramAssistant();
	}

	/**
	 * This is the default which places the popup bar to favor the right side of the shape
	 * 
	 */
	protected void setRightHandDisplay() {
		myBallonOffsetPercent = BALLOON_X_OFFSET_RHS;
	}

	/**
	 * Place the popup bar to favor the left had side of the shape
	 * 
	 */
	protected void setLeftHandDisplay() {
		myBallonOffsetPercent = BALLOON_X_OFFSET_LHS;
	}

	/**
	 * check thee right display status
	 * 
	 * @return true or false
	 */
	protected boolean isRightDisplay() {
		return BALLOON_X_OFFSET_RHS == myBallonOffsetPercent;
	}

	/**
	 * Gets the amount of time to wait before showing the popup bar if the popup bar is to be shown
	 * at the mouse location {@link #getIsDisplayAtMouseHoverLocation()}.
	 * 
	 * @return the time to wait in milliseconds
	 */
	protected int getAppearanceDelayLocationSpecific() {
		return getAppearanceDelay();
	}

	private static Unit getUnit(EditPart host) {
		Object obj = host.getModel();
		if (obj instanceof View) {
			View view = (View) obj;
			if (view.getElement() instanceof Unit) {
				return (Unit) view.getElement();
			}
		}

		return null;
	}

	private static class PopupActionWrapperTool extends AbstractPopupBarTool {

		private Request dummyRequest;
		private final UnitFilterAction ufa;
		private final int type;

		private PopupActionWrapperTool(IGraphicalEditPart epHost, UnitFilterAction action,
				int actionType) {
			super(epHost, (IElementType) null);
			ufa = action;
			type = actionType;
		}

		@Override
		protected Request createTargetRequest() {
			if (dummyRequest == null) {
				dummyRequest = new Request();
			}
			return dummyRequest;
		}

		@Override
		protected Command getCommand() {
			return DeployableUnitElementUIService.getGefCommandForSelection(getUnit(getHost()), ufa,
					type, (IGraphicalEditPart) getHost());
		}

	} // end static inner class PopupOperationWrapperTool

	/**
	 * A popup bar tool explicitly designed to handle UnitFilterTemplate and IElementType.
	 */
	private static class SoaDeployPopupBarTool extends AbstractPopupBarTool {

		//		private final boolean isHostee;
		//		private final boolean isMember;
		//		private final boolean isNub;
		private Request dummyRequest;
		private final int type;
		private final UnitFilterTemplate item;

		private SoaDeployPopupBarTool(IGraphicalEditPart epHost, IElementType anEleType,
				int actionType) {
			super(epHost, anEleType);

			type = actionType;
			item = null;
		}

		private SoaDeployPopupBarTool(IGraphicalEditPart epHost, UnitFilterTemplate uft,
				int actionType) {
			super(epHost, (IElementType) null);

			type = actionType;
			item = uft;
		}

		protected Request createTargetRequest() {
			if (dummyRequest == null) {
				dummyRequest = new Request();
			}
			return dummyRequest;
		}

		@Override
		protected Command getCommand() {
			return DeployableUnitElementUIService.getGefCommandForSelection(getUnit(getHost()),
					getItem(), type, (IGraphicalEditPart) getHost());
		}

		private Object getItem() {
			if (getElementType() != null) {
				return getElementType();
			}

			return item;
		}

		//		protected abstract Collection<?> insertNewUnits();
		//
		//		protected Topology getTopology() {
		//			Unit unit = getUnit();
		//			return unit == null ? null : unit.getTopology();
		//		}
		//
		//		private Unit getUnit() {
		//			Object obj = getHost().getModel();
		//			if (obj instanceof View) {
		//				View view = (View) obj;
		//				if (view.getElement() instanceof Unit) {
		//					return (Unit) view.getElement();
		//				}
		//			}
		//
		//			return null;
		//		}

	} // end static inner class SoaDeployPopupBarTool

	//	/** Tool that works with .template files containing {@link Topology}s */
	//	private static class TemplatePopupBarTool extends SoaDeployPopupBarTool {
	//
	//		private final UnitFilterTemplate uft;
	//
	//		protected TemplatePopupBarTool(IGraphicalEditPart epHost,
	//				UnitFilterTemplate unitFilterTemplate, int actionType) {
	//			super(epHost, null, actionType);
	//			uft = unitFilterTemplate;
	//		}
	//
	//		@Override
	//		protected Collection<?> insertNewUnits() {
	//			return ResolutionUtils.doRealElementCreation(uft.getTemplateURI(), getTopology());
	//		}
	//	}
	//
	//	/** Tool that works with GMF element types */
	//	private static class ElementTypePopupBarTool extends SoaDeployPopupBarTool {
	//
	//		protected ElementTypePopupBarTool(IGraphicalEditPart epHost, IElementType iet, int actionType) {
	//			super(epHost, iet, actionType);
	//		}
	//
	//		@Override
	//		protected Collection<?> insertNewUnits() {
	//			return ResolutionUIUtils.doRealElementCreation(getElementType(), getTopology());
	//		}
	//	}

} // end class DeployPopupBarEditPolicy
