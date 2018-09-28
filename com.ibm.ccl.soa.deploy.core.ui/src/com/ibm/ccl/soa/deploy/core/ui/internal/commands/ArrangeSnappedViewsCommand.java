/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.SnapUtils;

/**
 * @since 1.0
 * 
 */
public class ArrangeSnappedViewsCommand extends AbstractTransactionalCommand {
	final private View _view;
	final private EditPartViewer _viewer;
	private int _flag = 0;
	final private Rectangle _oldBounds;
	protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);
	private static final int MIN_HEIGHT = DeployCoreConstants.SERVER_UNIT_MIN_HEIGHT;
	private static final int MIN_WIDTH = DeployCoreConstants.SERVER_UNIT_MIN_WIDTH;

	/**
	 * @param editingDomain
	 * @param view
	 * @param viewer
	 * @param flag
	 * @param oldBounds
	 *           TODO
	 */
	public ArrangeSnappedViewsCommand(TransactionalEditingDomain editingDomain, View view,
			EditPartViewer viewer, int flag, Rectangle oldBounds) {
		super(editingDomain,
				"Align Attached Views Command", //$NON-NLS-1$
				Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE),
				getWorkspaceFiles(view));
		_view = view;
		_viewer = viewer;
		_flag = flag;
		_oldBounds = oldBounds;
		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		arrangeSnappedViews(_view, _viewer, _flag, _oldBounds);
		return CommandResult.newOKCommandResult();
	}

	/**
	 * @param editingDomain
	 * @param view
	 * @param viewer
	 * @param flag
	 * @param oldBounds
	 *           TODO
	 */
	public static void arrangeSnappedViews(TransactionalEditingDomain editingDomain, View view,
			EditPartViewer viewer, int flag, Rectangle oldBounds) {
		ArrangeSnappedViewsCommand cmd = new ArrangeSnappedViewsCommand(editingDomain, view, viewer,
				flag, oldBounds);
		if (cmd.canExecute()) {
			try {
				cmd.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				DeployCoreUIPlugin.logError(0, e.getMessage(), e);
			}
		}
	}

	/**
	 * align attachments around this center view
	 * 
	 * @param alignView
	 * @param viewer
	 * @param flag
	 * @param oldBounds
	 *           TODO
	 */
	public static void arrangeSnappedViews(View alignView, EditPartViewer viewer, int flag,
			Rectangle oldBounds) {
		Map<?, ?> v2eMap = viewer.getEditPartRegistry();

		boolean compartmentChange = flag == SnapUtils.COMPARTMENT_CHANGE ? true : false;

		// get the snap group's view
		View snapGroupView = alignView;
		if (flag != SnapUtils.ANCHOR_GROUP) {
			DeployStyle style = (DeployStyle) alignView.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style == null || style.getSnapParent() == null
					|| style.getSnapParent().eContainer() == null) {
				return;
			}
			snapGroupView = (View) style.getSnapParent().eContainer();
		}

		// get data on snap group views and rows
		int rowInx = 0;
		int maxRowWidth = 0;
		int anchorRowInx = 0;
		int anchorXOffset = 0;
		View anchorRow = null;
		// View anchorView = !isAnchorSnapGroup ? alignView : null;
		View anchorView = flag != SnapUtils.ANCHOR_GROUP ? alignView : null;
		Map<View, Rectangle> viewToBoundsMap = new HashMap<View, Rectangle>();
		List<Dimension> rowSizeList = new ArrayList<Dimension>();
		for (Iterator<?> itRow = snapGroupView.getChildren().iterator(); itRow.hasNext();) {
			View snapRow = (View) itRow.next();
			DeployStyle snapRowStyle = (DeployStyle) snapRow.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			int xOff = 0;
			int colInx = 0;
			int maxRowHeight = 0;
			int totalRowWidth = 0;
			for (Iterator<?> it = snapRowStyle.getSnapChildren().iterator(); it.hasNext();) {
				View view = (View) it.next();
				if (anchorView == null) {
					anchorView = view;
					anchorRowInx = 0;
					anchorXOffset = 0;
					// } else if (!isAnchorSnapGroup && view == anchorView) {
				} else if (flag != SnapUtils.ANCHOR_GROUP && view == anchorView) {
					anchorRowInx = rowInx;
					anchorXOffset = xOff;
					anchorRow = snapRow;
				}
				Rectangle rect = SnapUtils.getViewBounds(view, v2eMap);
				viewToBoundsMap.put(view, rect);
				totalRowWidth += rect.width;
				if (maxRowHeight < rect.height) {
					maxRowHeight = rect.height;
				}
				xOff += rect.width;
				colInx++;
			}
			rowSizeList.add(new Dimension(totalRowWidth, maxRowHeight));
			if (maxRowWidth < totalRowWidth) {
				maxRowWidth = totalRowWidth;
			}
			rowInx++;
		}
		if (anchorView == null) {
			return;
		}

		// now just arrange each row within the snap group
		DeployStyle snapGroupStyle = (DeployStyle) snapGroupView
				.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
		int snapStyle = snapGroupStyle != null ? snapGroupStyle.getSnapStyle() : 0;
		// if the snapStyle was never set, set it to the current preference.
		// Then set the style of the snapGroup, so if the preference will be changed subsequently,
		// it will only affect new snapGroups, not snapGroups that have already been created
		if (snapStyle == 0) {
			snapStyle = getSnapPreference();
			if (snapGroupStyle != null) {
				snapGroupStyle.setSnapStyle(snapStyle);
			}
		}
		if (snapStyle == DeployCoreConstants.SNAP_CENTERED) {
			Point anchorPt = getAnchorPoint(anchorView, anchorRowInx, anchorXOffset, maxRowWidth,
					viewToBoundsMap, rowSizeList);
			arrangeCentered(v2eMap, snapGroupView, maxRowWidth, rowSizeList, anchorPt);
		} else { // SNAP_CENTERED
			int rowWidth = maxRowWidth;
			// if alignView was resized, reset the bounds of other shapes to accommodate
			if (oldBounds != null) {
				Rectangle bounds = SnapUtils.getViewBounds(alignView, v2eMap);
				if (bounds.height != oldBounds.height) {
					adjustRowHeights(snapGroupView, alignView, oldBounds, bounds, rowSizeList,
							compartmentChange);
				}
				if (bounds.width != oldBounds.width) {
					// FIXME: handle the case where the width of anchorRow < minimum permissible for any row (numViews in row * MIN_HEIGHT_OR_WIDTH)
					rowWidth = adjustRowWidth(viewToBoundsMap, alignView, oldBounds, bounds, anchorRow);
					rowSizeList.get(anchorRowInx).width = rowWidth;
					if (anchorXOffset != 0) {
						anchorXOffset += bounds.x - oldBounds.x;
					}
				}
			}
			Point anchorPt = getAnchorPoint(anchorView, anchorRowInx, anchorXOffset, rowWidth,
					viewToBoundsMap, rowSizeList);
			int maxWidth = arrangeRectangular(viewToBoundsMap, snapGroupView, rowWidth, rowSizeList,
					anchorView, anchorPt, compartmentChange);
			if (maxWidth != rowWidth) {
				// TODO: do this more efficiently by determining a viable rowWidth before calling arrangeRectangular(). 
				// In the current implementation, arrangeRectangular() returns the maxWidth. 
				// If a row couldn't minimize itself to the requested rowWidth, the maxWidth will be greater
				// than 'rowWidth'. In that case, reset all rowWidths
				arrangeRectangular(viewToBoundsMap, snapGroupView, maxWidth, rowSizeList, anchorView,
						anchorPt, compartmentChange);
			}
		}
	}

	private static Point getAnchorPoint(View anchorView, int anchorRowInx, int anchorXOffset,
			int maxRowWidth, Map<View, Rectangle> viewToBoundsMap, List<Dimension> rowSizeList) {
		// the anchor view's top/left position must stay the same therefore
		// determine top/left point of snap group based on anchor view's position in the group
		Point anchorPt = viewToBoundsMap.get(anchorView).getTopLeft();
		int rowMargin = (maxRowWidth - rowSizeList.get(anchorRowInx).width) / 2;
		anchorPt.x -= rowMargin + anchorXOffset;
		for (int inx = anchorRowInx - 1; inx >= 0; inx--) {
			anchorPt.y -= rowSizeList.get(inx).height;
		}
		return anchorPt;
	}

	/**
	 * Adjust all row heights to accommodate a resize of resizedView
	 * 
	 * @param snapGroupView
	 * @param resizedView
	 * @param rowSizeList
	 * @param map
	 */
	private static void adjustRowHeights(View snapGroupView, View resizedView, Rectangle oldBounds,
			Rectangle newBounds, List<Dimension> rowSizeList, boolean compartmentChange) {
		if (newBounds.height < MIN_HEIGHT) {
			newBounds.height = MIN_HEIGHT;
		}
		int rowInx = 0;
		for (Iterator<?> itRow = snapGroupView.getChildren().iterator(); itRow.hasNext();) {
			View snapRow = (View) itRow.next();
			DeployStyle snapRowStyle = (DeployStyle) snapRow.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());

			for (Iterator<?> it = snapRowStyle.getSnapChildren().iterator(); it.hasNext();) {
				View view = (View) it.next();
				// this row contains the resized view; Adjust the rows before and/or after
				if (view == resizedView) {
					rowSizeList.get(rowInx).height = newBounds.height;
					// if the resize was not due to a compartment change, adjust the rows before and/or after
					if (!compartmentChange) {
						// if the top edge was moved, adjust the row above
						if (oldBounds.y != newBounds.y) {
							if (rowInx != 0) {
								int height = rowSizeList.get(rowInx - 1).height;
								height += newBounds.y - oldBounds.y;
								if (height < MIN_HEIGHT) {
									height = MIN_HEIGHT;
								}
								rowSizeList.get(rowInx - 1).height = height;
							}
						}
						// if the bottom edge was moved, adjust the row below
						if (oldBounds.bottom() != newBounds.bottom()) {
							if (rowInx < rowSizeList.size() - 1) {
								int height = rowSizeList.get(rowInx + 1).height;
								height -= newBounds.bottom() - oldBounds.bottom();
								if (height < MIN_HEIGHT) {
									height = MIN_HEIGHT;
								}
								rowSizeList.get(rowInx + 1).height = height;
							}
						}
					}

				}
			}
			rowInx++;
		}

	}

	private static int adjustRowWidth(Map<View, Rectangle> viewToBoundsMap, View anchorView,
			Rectangle oldBounds, Rectangle newBounds, View anchorRow) {
		int rowWidth = 0;
		if (newBounds.width < MIN_WIDTH) {
			newBounds.width = MIN_WIDTH;
		}

		DeployStyle snapRowStyle = (DeployStyle) anchorRow.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		int colInx = 0;
		for (int i = 0; i < snapRowStyle.getSnapChildren().size(); i++) {
			View view = snapRowStyle.getSnapChildren().get(i);
			if (view == anchorView) {
				// if the left edge was moved, adjust the view to the left of the anchorView
				if (oldBounds.x != newBounds.x) {
					if (colInx != 0) {
						View viewToTheLeft = snapRowStyle.getSnapChildren().get(colInx - 1);
						Rectangle leftBounds = viewToBoundsMap.get(viewToTheLeft);
						int width = leftBounds.width;
						rowWidth -= width;
						width += newBounds.x - oldBounds.x;
						if (width < MIN_WIDTH) {
							width = MIN_WIDTH;
						}
						viewToBoundsMap.get(viewToTheLeft).width = width;
						rowWidth += width;
					}
				}
				// if the right edge was moved, adjust the view to the right of the anchorView
				if (oldBounds.right() != newBounds.right()) {
					if (colInx < snapRowStyle.getSnapChildren().size() - 1) {
						View viewToTheRight = snapRowStyle.getSnapChildren().get(colInx + 1);
						Rectangle rightBounds = viewToBoundsMap.get(viewToTheRight);
						int width = rightBounds.width;
						width -= newBounds.right() - oldBounds.right();
						if (width < MIN_WIDTH) {
							width = MIN_WIDTH;
						}
						viewToBoundsMap.get(viewToTheRight).width = width;
					}
				}
			}
			rowWidth += viewToBoundsMap.get(view).width;
			colInx++;
		}

		return rowWidth;
	}

	private static void arrangeCentered(Map<?, ?> v2eMap, View snapGroupView, int maxRowWidth,
			List<Dimension> rowSizeList, Point anchorPt) {
		int rowInx;
		rowInx = 0;
		int y = anchorPt.y;
		for (Iterator<?> itRow = snapGroupView.getChildren().iterator(); itRow.hasNext();) {
			View snapRow = (View) itRow.next();
			DeployStyle snapRowStyle = (DeployStyle) snapRow.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			int x = anchorPt.x + (maxRowWidth - rowSizeList.get(rowInx).width) / 2;
			for (Iterator<?> it = snapRowStyle.getSnapChildren().iterator(); it.hasNext();) {
				View view = (View) it.next();
				setViewLocation(view, new Point(x, y));
				x += SnapUtils.getViewBounds(view, v2eMap).width;
			}
			y += rowSizeList.get(rowInx++).height;
		}
	}

	private static int arrangeRectangular(Map<View, Rectangle> viewToBoundsMap, View snapGroupView,
			int newRowWidth, List<Dimension> rowSizeList, View anchorView, Point anchorPt,
			boolean compartmentChanged) {
		int rowInx;
		rowInx = 0;
		int y = anchorPt.y;
		int maxRowWidth = 0;
		for (Iterator<?> itRow = snapGroupView.getChildren().iterator(); itRow.hasNext();) {
			View snapRow = (View) itRow.next();
			DeployStyle snapRowStyle = (DeployStyle) snapRow.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			// if this row is < newRowWidth, distribute the missing width evenly amongst all of the views
			int widthAdjustment = 0;
			int rowWidth = rowSizeList.get(rowInx).width;
			int pixelDiff = 0;
			if (rowWidth != newRowWidth) {
				widthAdjustment = (newRowWidth - rowWidth) / snapRowStyle.getSnapChildren().size();
				// adjust for loss of precision from float to integer
				int actualAdjustment = widthAdjustment * snapRowStyle.getSnapChildren().size();
				pixelDiff = newRowWidth - (rowWidth + actualAdjustment);
			}
			int x = anchorPt.x;
			int viewCount = 0;
			int thisRowWidth = 0;
			for (Iterator<?> it = snapRowStyle.getSnapChildren().iterator(); it.hasNext();) {
				View view = (View) it.next();
				viewCount++;
				// Rectangle bounds = getViewBounds(view, v2eMap);
				int width = viewToBoundsMap.get(view).width + widthAdjustment;
				if (viewCount == 1) {
					width += pixelDiff;
				}
				if (width < MIN_WIDTH) {
					int extraWidth = width - MIN_WIDTH;
					int numInRow = snapRowStyle.getSnapChildren().size();
					if (viewCount < numInRow) {
						widthAdjustment -= (float) extraWidth / (numInRow - viewCount);
					}
					width = MIN_WIDTH;
				}
				thisRowWidth += width;
				setViewLocation(view, new Point(x, y));
				Dimension d = new Dimension(width, rowSizeList.get(rowInx).height);
				// note: if the size expands beyond a threshold (and this arrangement is not due to a compartmentChange),
				// then expand the compartments. Note that if the size decreases, the compartments
				// are not collapsed. The reason: collapsing a compartment causes its size to
				// be set to -1, -1 (see DeployCoreCompartmentEditPart.setCollapse and
				// DeployListCompartmentEditpart.setCollapse)
				boolean expandCompartments = compartmentChanged && view == anchorView ? false : true;
				SnapUtils.setViewDimension(view, d, expandCompartments);
				Rectangle newBounds = new Rectangle(x, y, d.width, d.height);
				viewToBoundsMap.put(view, newBounds);
				x += d.width;
			}
			if (thisRowWidth > maxRowWidth) {
				maxRowWidth = thisRowWidth;
			}
			rowSizeList.get(rowInx).width = thisRowWidth;
			y += rowSizeList.get(rowInx++).height;
		}

		return maxRowWidth;
	}

	static private void setViewLocation(View view, Point loc) {
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X(), loc.x);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y(), loc.y);
	}

	public boolean canExecute() {
		return true;
	}

	static private int getSnapPreference() {
		int snapPref = DeployCoreConstants.SNAP_CENTERED;
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		String pref = store.getString(IDeployPreferences.PREF_SNAP_STYLE);
		if (pref != null && !pref.equals(Messages.DeployCoreMainPreferencePage_Centered_)) {
			snapPref = DeployCoreConstants.SNAP_RECTANGULAR;
		}
		return snapPref;
	}

	/**
	 * @param domain
	 * @param view
	 * @param bounds
	 * @param flag
	 * @param viewer
	 */
	public static void arrangeSnappedViewsDelayed(final TransactionalEditingDomain domain,
			final View view, final Rectangle bounds, final int flag, final EditPartViewer viewer) {
		GraphicalEditPart ep = (GraphicalEditPart) viewer.getEditPartRegistry().get(view);
		ep.refresh();
		final FigureCanvas fc = (FigureCanvas) viewer.getControl();
		fc.setRedraw(false);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				try {
					ArrangeSnappedViewsCommand.arrangeSnappedViews(domain, view, viewer, flag, bounds);
				} finally {
					fc.setRedraw(true);
				}
			}
		});
	}

}
