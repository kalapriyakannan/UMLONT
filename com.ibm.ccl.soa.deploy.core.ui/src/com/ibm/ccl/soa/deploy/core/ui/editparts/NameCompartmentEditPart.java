/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.UnitCaptionDialog2;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployWrapLabel;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.GeneralPropertyFlyoutDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @canBeSeenBy %partners
 */
public class NameCompartmentEditPart extends TextCompartmentEditPart implements
		IPropertyChangeListener {
	private static final int MIN_X = MapModeUtil.getMapMode().DPtoLP(22);

	// when name label is on a plain unit figure
	private static final int UNIT_LABEL = 0;
	// when name is an entry in a hosting list
	private static final int HOSTING_LIST_LABEL = 2;
	// when name is an entry in a hosting list
	private static final int IMPORT_TOPOLOGY_LABEL = 3;
	// when name is an entry in a business component
	private static final int BUSINESS_COMPONENT_LABEL = 4;
	// when name is an entry in a diagram node
	private static final int DIAGRAM_NODE_LABEL = 5;

	private static final String INITCHAR = "directedit_extendeddata_initial_char"; //$NON-NLS-1$

	private static GeneralPropertyFlyoutDialog _pfd;

	protected EObject _contentObject = null;
	protected EContentAdapter _contentAdapter = null;
	private static final int SHIFT = 8;
	private Image overlayImage = null;
	private final Unit _missingUnit = null;

	private UnitCaptionDialog2 _ucd = null;

	private class OverlayImageDescriptor extends CompositeImageDescriptor {
		private Image _srcImage = null;
		private ImageDescriptor _overlayDesc = null;

		public OverlayImageDescriptor(Image srcImage, ImageDescriptor overlayDesc) {
			_srcImage = srcImage;
			_overlayDesc = overlayDesc;
		}

		protected void drawCompositeImage(int width, int height) {
			if (_srcImage != null) {
				ImageData backgroundData = _srcImage.getImageData();
				if (backgroundData != null) {
					drawImage(backgroundData, SHIFT, 0);
				}
			}
			if (_overlayDesc != null) {
				ImageData overlayData = _overlayDesc.getImageData();
				if (overlayData != null) {
					drawImage(overlayData, 0, 0);
				}
			}
		}

		protected org.eclipse.swt.graphics.Point getSize() {
			return new org.eclipse.swt.graphics.Point(16 + SHIFT, 16);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (_overlayDesc == null ? 0 : _overlayDesc.hashCode());
			result = prime * result + (_srcImage == null ? 0 : _srcImage.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final OverlayImageDescriptor other = (OverlayImageDescriptor) obj;
			if (_overlayDesc == null) {
				if (other._overlayDesc != null) {
					return false;
				}
			} else if (!_overlayDesc.equals(other._overlayDesc)) {
				return false;
			}
			if (_srcImage == null) {
				if (other._srcImage != null) {
					return false;
				}
			} else if (!_srcImage.equals(other._srcImage)) {
				return false;
			}
			return true;
		}
	}

	/**
	 * 
	 * @param view
	 */
	public NameCompartmentEditPart(View view) {
		super(view);

		_contentObject = ViewUtil.resolveSemanticElement(view);

		// It's no longer sufficient to merely adapt the Unit, because
		// an imported Unit's label might change when it's InstanceConfiguration
		// changes, not just when the Unit changes.  Bug 1275.
		if (_contentObject instanceof DeployModelObject) {
			DeployModelObject dmo = (DeployModelObject) _contentObject;
			if (PropertyUtils.isProxy(dmo)) {
				_contentObject = dmo.getEditTopology();
			}
		}

		if (_contentObject != null) {
			_contentAdapter = new EContentAdapter() {
				public void notifyChanged(Notification aNotification) {
					if (aNotification.getEventType() == Notification.SET) {
						refreshLabel();
					}
				}
			};
			_contentObject.eAdapters().add(_contentAdapter);
		}
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	public void deactivate() {
		if (_contentObject != null) {
			_contentObject.eAdapters().remove(_contentAdapter);
		}
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);

		// overlayImage managed by ISharedImages, which will dispose it

		super.deactivate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		DeployWrapLabel label = (DeployWrapLabel) super.createFigure();
		label.setTextWrap(false);
		return label;
	}

	protected WrapLabel createWrapLabel() {
		DeployWrapLabel label = new DeployWrapLabel(""); //$NON-NLS-1$
		label.setLabelAlignment(PositionConstants.TOP);
		label.setTextAlignment(PositionConstants.TOP);
		return label;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart#getLabelText()
	 */
	protected String getLabelText() {
		String labelText = null;
		EObject eObject = resolveSemanticElement();

		// if diagram, just use diagram name
		if (eObject instanceof Diagram && getParent() instanceof DiagramNodeEditPart) {
			labelText = ((DiagramNodeEditPart) getParent()).getDiagramName();
		} else if (eObject instanceof Import && getParent() instanceof ImportTopologyEditPart) {
			labelText = ((ImportTopologyEditPart) getParent()).getImportDiagramName();
		} else if (getParser() != null && eObject != null) {
			labelText = getParser().getPrintString(new EObjectAdapter(eObject),
					getParserOptions().intValue());
		}

		// get emf name
		if (labelText == null) {
			EObject eo = getNotationView().getElement();
			if (eo != null) {
				labelText = EMFCoreUtil.getName(eo);
			}
		}

		// get deploystyle name
		if (labelText == null || labelText.length() == 0) {
			if (getParent() instanceof TopologyEditPart) {
				TopologyEditPart ep = (TopologyEditPart) getParent();
				View view = ep.getNotationView();
				DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
						.getDeployStyle());
				if (style != null) {
					labelText = style.getElementName();
				}
			}
		}

		// no name-- put up "Delete-No Model"
		if (labelText == null) {
			labelText = Messages.DETACHED_MESSAGE;
		} else {
			labelText += " "; //$NON-NLS-1$
		}

		return labelText;
	}

	/**
	 * listen for changes in preference store
	 */
	public void propertyChange(PropertyChangeEvent event) {
		if (isActive()) {
			refreshFont();
		}
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFont();
		refreshBounds();
	}

	/*
	 * draw group and group members names in hosting lists in bold and italic
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart#refreshFont()
	 */
	protected void refreshFont() {
		boolean isConceptual = false;
		GraphicalEditPart unitEP = (GraphicalEditPart) this.getParent();
		// if this unit is conceptual, make it italic
		isConceptual = unitEP.resolveSemanticElement() instanceof Unit
				&& ((Unit) unitEP.resolveSemanticElement()).isConceptual();

		// start out with a static name/size
		String fontName = "Microsoft Sans Serif"; //$NON-NLS-1$
		int fontHeight = 8;

		// then try to use font in preference store
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		if (store != null) {
			FontData fontData = PreferenceConverter.getFontData(DeployCoreUIPlugin.getDefault()
					.getPreferenceStore(), IPreferenceConstants.PREF_DEFAULT_FONT);
			fontName = fontData.getName();
			fontHeight = fontData.getHeight();
		}

		// then if they've override the font on just this name
		int sty = isConceptual ? SWT.ITALIC : SWT.NORMAL;
		FontStyle style = (FontStyle) getPrimaryView().getStyle(NotationPackage.Literals.SHAPE_STYLE);
		if (style != null) {
			if (style.eIsSet(NotationPackage.Literals.FONT_STYLE__FONT_NAME)) {
				fontName = style.getFontName();
			}
			if (style.eIsSet(NotationPackage.Literals.FONT_STYLE__FONT_HEIGHT)) {
				fontHeight = style.getFontHeight();
			}
			if (style.eIsSet(NotationPackage.Literals.FONT_STYLE__BOLD) && style.isBold()) {
				sty |= SWT.BOLD;
			}
		}
		FontData fontData = new FontData(fontName, fontHeight, sty);
		setFont(fontData);
	}

	private void refreshBounds() {
		getFigure().getParent().setConstraint(getFigure(), new Locator() {
			public void relocate(IFigure target) {
				// get parents bounding rect
				IFigure parent = target.getParent().getParent();
				Rectangle r = parent.getBounds().getCopy();
				parent.translateToAbsolute(r);
				target.translateToRelative(r);
				Dimension size = target.getPreferredSize();

				// determine starting x,y
				int dX = MapModeUtil.getMapMode().DPtoLP(18);
				int dY = MapModeUtil.getMapMode().DPtoLP(20);
				int type = getLabelType(target);
				switch (type)
				{
				// when name is an entry in a hosting list
				case HOSTING_LIST_LABEL:
					dX = MapModeUtil.getMapMode().DPtoLP(21);
					dY = MapModeUtil.getMapMode().DPtoLP(2);
					break;
				// when name label is on a plain unit figure
				// when name label is on a group figure title
				// when name label is on a component figure
				case UNIT_LABEL:
				case BUSINESS_COMPONENT_LABEL:
				case IMPORT_TOPOLOGY_LABEL:
				case DIAGRAM_NODE_LABEL:
					dX = (r.width - size.width) / 2;
					if (dX < MIN_X) {
						dX = MIN_X;
					}
					// if filtering type name, move name up
					if (parent instanceof CompositeShapeFigure) {
						if (((DeployCoreFigure) ((CompositeShapeFigure) parent).getInnerFigure())
								.isTypeNameFiltered()) {
							dY -= MapModeUtil.getMapMode().DPtoLP(6);
						}
					}
					break;
				}
				if (type == IMPORT_TOPOLOGY_LABEL || type == DIAGRAM_NODE_LABEL) {
					// when expanded, the category is on the right
					if (type == IMPORT_TOPOLOGY_LABEL ? GMFUtils.isImportExpanded(parent) : GMFUtils
							.isDiagramExpanded(parent)) {
						dX = MapModeUtil.getMapMode().DPtoLP(30);
					}
				}
				Point pt = r.getTopLeft().translate(dX, dY);
				target.setBounds(new Rectangle(pt, size));
			}

		});
	}

	private int getLabelType(IFigure target) {
		if (target.getParent() instanceof DeployListItemFigure) {
			return HOSTING_LIST_LABEL;
		}
		EditPart ep = this.getParent();
		if (ep instanceof ImportTopologyEditPart) {
			return IMPORT_TOPOLOGY_LABEL;
		} else if (ep instanceof DiagramNodeEditPart) {
			return DIAGRAM_NODE_LABEL;
		} else if (ep instanceof BusinessComponentEditPart) {
			return BUSINESS_COMPONENT_LABEL;
		}
		return UNIT_LABEL;
	}

	protected void refreshLabel() {
		super.refreshLabel();
		WrapLabel label = this.getLabel();
		if (label == null) {
			return;
		}
		label.setIcon(getImage());
		label.setText(getLabelText());
		if (this.getRoot() != null) {
			refreshFont();
		}
	}

	protected Image getImage() {
		// if it doesn't have an element or element is a proxy, no image!
		EObject semanticObject = getNotationView().getElement();
		// allow proxy-- it finds the right icon even though it couldn't find the topology file
		// used by compare/merge when the topology file is missing
		if (semanticObject == null) {// || semanticObject.eIsProxy()) {
			return null;
		}

		//Get the image for the shape.   If stereotypes exist, the image
		//will be the first stereotype image.  Otherwise, the kind image will
		//be returned.
		Image image = IconService.getInstance().getIcon(new EObjectAdapter(semanticObject),
				IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());

		// if this is a member, add a point to image
		//Create the contract overlay in top left corner
		if (getParent() instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) getParent();
			int relationship = ep.getRelationshipToContainer();
			if (relationship != DeployShapeNodeEditPart.NOCONTAINER) {
				if (overlayImage == null) {
					String overlayID = ISharedImages.IMG_MEMBER_ICON_OVERLAY;
					switch (relationship)
					{
					case DeployShapeNodeEditPart.HOSTEE:
						overlayID = ISharedImages.IMG_HOSTEE_ICON_OVERLAY;
						break;
					case DeployShapeNodeEditPart.DEFERREDHOSTEE:
						overlayID = ISharedImages.IMG_DEFERREDHOSTEE_ICON_OVERLAY;
						break;
					}
					ImageDescriptor desc = DeployCoreUIPlugin.getDefault().getSharedImages()
							.getImageDescriptor(overlayID);
					if (desc != null) {
						OverlayImageDescriptor overlay = new OverlayImageDescriptor(image, desc);
						DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(this);
						if (ddep != null) {
							overlayImage = ddep.getSharedImages().getImage(overlay);
						}
					}
				}
				return overlayImage;
				// no longer a member
			}
		}

		return image;
	}

	/**
	 * Suppress usual GMF in-place editor for Unit names
	 */
	protected DirectEditManager getManager() {
		return null;
	}

	/**
	 * performs direct edit
	 */
	protected void performDirectEdit() {
		//		EObject semanticObject = getNotationView().getElement();

	}

	protected void performDirectEdit(Point eventLocation) {
		//		performDirectEdit();
	}

	protected void performDirectEditRequest(Request request) {
		View view = (View) getModel();
		EObject semanticObject = view.getElement();

		// Get coordinate of mouse click
		Rectangle rect = getFigure().getBounds().getCopy();
		if (semanticObject instanceof Unit) {
			Unit unit = (Unit) semanticObject;
			Character c = (Character) request.getExtendedData().get(INITCHAR);
			popupCaptionDialog(rect.getTopLeft(), unit, c);
		}
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new EditCaptionEditPolicy());
	}

	/**
	 * @param fig
	 * @param viewer
	 * @param pt
	 * @param unit
	 */
	public static void popupGeneralPropertyFlyout(IFigure fig, final EditPartViewer viewer,
			Point pt, final Unit unit) {
		Point location = new Point(pt);
		fig.translateToAbsolute(location);
		org.eclipse.swt.graphics.Point loc = location.getSWTPoint();
		Control canvas = viewer.getControl();
		final org.eclipse.swt.graphics.Point loc2 = Display.getCurrent().map(canvas, null, loc);

		final GeneralPropertyFlyoutDialog oldPfd = _pfd;
		_pfd = new GeneralPropertyFlyoutDialog(Display.getCurrent().getShells()[0], unit, loc2,
				viewer.getEditDomain());
		new UnitFlyOutPropertiesToggler(unit, viewer.getEditDomain(), _pfd);
		_pfd.open();
		if (oldPfd != null) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (!oldPfd.isClosed()) {
						oldPfd.close();
					}
				}
			});
		}
	}

	/**
	 * @param pt
	 * @param unit
	 * @param initialChar
	 */
	public void popupCaptionDialog(Point pt, Unit unit, Character initialChar) {
		// if this unit is readonly because it's in an import topology, don't edit it
		if (GMFUtils.isNonMutableImport(unit)) {
			return;
		}

		Point location = new Point(pt);
		getFigure().translateToAbsolute(location);
		org.eclipse.swt.graphics.Point loc = location.getSWTPoint();
		Control canvas = getViewer().getControl();
		loc = Display.getCurrent().map(canvas, null, loc);
		loc.x += 18;
		loc.y -= 2;

		if (_ucd == null) {
			_ucd = new UnitCaptionDialog2(Display.getCurrent().getShells()[0], unit, loc, initialChar,
					this, true);
			_ucd.open();
		} else {
			_ucd.addCharacter(initialChar);
		}
	}

	/**
	 * start new dialog
	 */
	public void closeCaptionDlg() {
		_ucd = null;
	}

	class EditCaptionEditPolicy extends OpenEditPolicy {

		protected Command getOpenCommand(Request request) {
			View view = (View) getHost().getModel();
			EObject semanticObject = view.getElement();

			// We can't actually create this command, because
			// we'd need the results of the dialog to get the command,
			// and the dialog doesn't block.  So we'll always return
			// null.  However, before returning null, we'll fake an
			// in-place edit.

			if (semanticObject instanceof Unit) {
				Unit unit = (Unit) semanticObject;
				//Open up the Property flyout on double click
				if (request instanceof SelectionRequest) {
					Rectangle rect = getFigure().getParent().getBounds();
					popupGeneralPropertyFlyout(getFigure(), getViewer(), rect.getTopRight(), unit);
				}
			}
			return null;
		}

	} // end inner class EditCaptionEditPolicy

} // end NameCompartmentEditPart
