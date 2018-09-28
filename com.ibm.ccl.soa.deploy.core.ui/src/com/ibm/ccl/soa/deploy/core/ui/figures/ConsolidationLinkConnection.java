/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.figures;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.jface.preference.IPreferenceStore;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployManhattanConnectionRouter;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.ui.views.factories.ConsolidationLinkViewFactory;

/**
 * Figure for a consolidated link
 * 
 * @see ConsolidationLinkEditPart
 * @see ConsolidationLinkViewFactory
 */
public class ConsolidationLinkConnection extends DeployLinkConnection {
	private static final int _unconsolidatedThreshold = MapModeUtil.getMapMode().DPtoLP(12);
	private static final int _blipThreshold = MapModeUtil.getMapMode().DPtoLP(9);
	private static final int _fanOffset = MapModeUtil.getMapMode().DPtoLP(28);
	private static final int _captionIntersectionThreshold = MapModeUtil.getMapMode().DPtoLP(1600);
	private List<PointList> _unconsolidatedPtLists = new ArrayList<PointList>();
	private static final int _captionTruncateLength = 3;

	/**
	 * @param connectionEP
	 */
	public ConsolidationLinkConnection(DeployConnectionNodeEditPart connectionEP) {
		super(connectionEP, FULL_JOG_LENGTH);
	}

	/**
	 * This method actually draws the line (but not the arrowheads/anchors at the ends. Those are set
	 * up somewhere in {@link SelectionUtils}, sometimes -- but not always -- using a
	 * {@link DeployCustomDecoration}.
	 */

	protected void outlineShape(Graphics g) {
		PointList ptList = getPoints();

		if (ptList != null) {
			clipParentClientArea(g);
			if (isFaded()) {
				g.setAlpha(DeployCoreConstants.SELECTION_FADE);
			}
			if (isUnconsolidated()) {
				g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(1));
				if (g.getForegroundColor() == DeployColorConstants.consolidationLinkColor) {
					g.setForegroundColor(DeployColorConstants.dependencyLinkColor);
				}
			} else {
				g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(1));
			}
			if (_isBorderLine) {
				setBorderLineProperties(g);
			}
			g.drawPolyline(ptList);

			paintCaptions(ptList, g);

			if (!isBackfillMode()) {
				updateConnectionLabel(ptList);
				updateConnectionLayer(ptList);
			}
		}
	}

	private PointList getUnconsolidatedPoints() {
		PointList pts = new PointList();
		if (_unconsolidatedPtLists != null && !_unconsolidatedPtLists.isEmpty()) {
			boolean reverse = false;
			PointList last = null;
			for (PointList ptList : _unconsolidatedPtLists) {
				if (reverse) {
					last = ptList;
					ptList = ptList.getCopy();
					ptList.reverse();
				}
				pts.addAll(ptList);
				reverse = !reverse;
			}
			// If the last link was reversed, the target point is now the same as the source point.
			// To set the target correctly, repeat the last pointList going forward
			if (!reverse && last != null) {
				pts.addAll(last);
			}
		}
		return pts;
	}

	protected String getToolTipMessage(DeployModelObject xlinkDmo, DeployModelObject xsrcDmo,
			String xsrcDup, DeployModelObject xtgtDmo, String xtgtDup) {
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		ConsolidationLinkEditPart consolidationLinkEP = (ConsolidationLinkEditPart) getConnectionEP();
		for (Iterator<DeployConnectionNodeEditPart> it = consolidationLinkEP
				.getConsolidatedLinkList().iterator(); it.hasNext(); count++) {
			DeployConnectionNodeEditPart linkEP = it.next();
			DeployLinkConnection linkFig = (DeployLinkConnection) linkEP.getFigure();
			GraphicalEditPart srcEP = (GraphicalEditPart) linkEP.getSource();
			GraphicalEditPart tgtEP = (GraphicalEditPart) linkEP.getTarget();
			if (linkEP != null && srcEP != null && tgtEP != null) {
				DeployModelObject linkDmo = (DeployModelObject) linkEP.resolveSemanticElement();
				DeployModelObject srcDmo = (DeployModelObject) srcEP.resolveSemanticElement();
				DeployModelObject tgtDmo = (DeployModelObject) tgtEP.resolveSemanticElement();
				if (count != 0) {
					buffer.append("\n"); //$NON-NLS-1$
				}
				buffer.append(linkFig.getToolTipMessage(linkDmo, srcDmo, getDupIndex(srcEP), tgtDmo,
						getDupIndex(tgtEP)));
			}
		}
		return buffer.toString();
	}

	private boolean isUnconsolidated() {
		if (!isConsolidatedPreference() && _unconsolidatedPtLists != null
				&& !_unconsolidatedPtLists.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public PointList getPoints() {
		_isBorderLine = false;
		PointList ptList = super.getPoints();
		if (doBorderLineLink()) {
			PointList ptList2 = getBorderLinePointList();
			if (ptList2 != null) {
				_isBorderLine = true;
				return ptList2;
			}
		}
		if (isUnconsolidated()) {
			ptList = getUnconsolidatedPoints();
		}
		return ptList;
	}

	@Override
	public void layout() {
		_unconsolidatedPtLists.clear();
		if (!isConsolidatedPreference()) {
			// route points here so the fanned out links will be based on the current routing
			if (getSourceAnchor() != null && getTargetAnchor() != null) {
				getConnectionRouter().route(this);
			}
			PointList ptList = super.getPoints();
			if (ptList != null && ptList.size() > 1) {
				double distance = ptList.getLastPoint().getDistance(ptList.getFirstPoint());
				if (distance > _unconsolidatedThreshold) {
					_unconsolidatedPtLists = getUnconsolidatedPointLists(ptList);
				}
			}
		}

		super.layout();
	}

	private List<PointList> getUnconsolidatedPointLists(PointList originalPointList) {
		PointList ptList = originalPointList.getCopy();
		adjustMidpointBlip(ptList);
		List<PointList> ptLists = new ArrayList<PointList>();
		boolean translate = ptList.size() <= 4 ? false : true;
		if (getConnectionRouter() instanceof DeployManhattanConnectionRouter) {
			translate = false;
		}

		ConsolidationLinkEditPart consolidationLinkEP = (ConsolidationLinkEditPart) getConnectionEP();
		if (consolidationLinkEP == null) {
			return ptLists;
		}
		int numLinks = consolidationLinkEP.getConsolidatedLinkList().size();
		boolean isEvenNumLinks = numLinks % 2 == 0;

		int offset = _fanOffset;
		int currentOffset = -(offset * (numLinks / 2));

		for (int i = 0; i < numLinks; i++) {
			PointList points = ptList.getCopy();
			if (!translate) {
				offsetMidpoint(points, currentOffset);
				ptLists.add(points);
			}

			else {

				Point firstPoint = points.getFirstPoint().getCopy();
				Point lastPoint = points.getLastPoint().getCopy();
				translatePoints(points, currentOffset);
				// if (points.size() > 4 && currentOffset != 0) {
				if (points.size() > 4) {
					points.removePoint(0);
					points.removePoint(0);
					points.removePoint(points.size() - 1);
					points.removePoint(points.size() - 1);
					points.insertPoint(firstPoint, 0);
					points.addPoint(lastPoint);
				}

				ptLists.add(points);
			}

			currentOffset += offset;
			// if there are an even number of links, offset the middle twice
			if (!translate && isEvenNumLinks && i == numLinks / 2 - 1) {
				currentOffset += offset;
			}
		}

		return ptLists;
	}

	private void adjustMidpointBlip(PointList points) {
		if (points.size() < 4) {
			return;
		}
		LineSeg seg = getMidLineSeg(points);

		if (seg.length() < _blipThreshold) {
			deleteMidLineSeg(points);
		}
	}

	private void deleteMidLineSeg(PointList points) {
		if (points.size() < 4) {
		}
		int startIndex;
		int endIndex;
		int midIndex = points.size() / 2;
		if (points.size() % 2 == 0) {
			startIndex = midIndex - 1;
			endIndex = midIndex;
		} else {
			startIndex = midIndex - 1;
			endIndex = midIndex + 1;
		}
		if (startIndex > 0 && endIndex < points.size() && endIndex > startIndex) {
			points.removePoint(endIndex);
			points.removePoint(startIndex);
		}
	}

	private void translatePoints(PointList points, int offset) {
		if (offset == 0) {
			return;
		}
		Point midPoint = getMidpoint(points, true);
		Point offsetPoint = getOffsetMidpoint(points, offset);
		if (midPoint != null && offsetPoint != null) {
			points.performTranslate(midPoint.x - offsetPoint.x, midPoint.y - offsetPoint.y);
		}
	}

	private Point getOffsetMidpoint(PointList ptList, int offset) {
		PointList points = ptList.getCopy();
		Point midPoint = getMidpoint(points, true);
		LineSeg midLineSeg = getMidLineSeg(points);
		if (midPoint != null && midLineSeg != null) {
			float perpSlope = midLineSeg.perpSlope();
			LineSeg lineseg = new LineSeg(LineSeg.KeyPoint.ORIGIN, midPoint.x, midPoint.y, perpSlope,
					offset < 0 ? -offset : offset, offset < 0 ? -1 : 1);
			return lineseg.getTerminus();
		}
		return null;
	}

	private LineSeg getMidLineSeg(PointList points) {
		if (points.size() < 2) {
			return null;
		}
		int startIndex;
		int endIndex;
		int midIndex = points.size() / 2;
		if (points.size() % 2 == 0) {
			startIndex = midIndex - 1;
			endIndex = midIndex;
		} else {
			startIndex = midIndex - 1;
			endIndex = midIndex + 1;
		}
		if (startIndex >= 0 && endIndex < points.size() && endIndex > startIndex) {
			return new LineSeg(points.getPoint(startIndex), points.getPoint(endIndex));
		}
		return null;
	}

	/**
	 * @param points
	 * @param insert
	 *           set to true if the midPoint should be inserted when the pointList contains an even
	 *           number of points
	 * @return
	 */
	private Point getMidpoint(PointList points, boolean insert) {
		if (points.size() < 2) {
			return null;
		}
		Point midPoint = null;
		int midptIndex = points.size() / 2;
		if (points.size() % 2 == 0) {
			// add a midpoint and offset it
			midPoint = points.getMidpoint();
			points.insertPoint(midPoint, points.size() / 2);
		} else {
			midPoint = points.getPoint(midptIndex);
		}
		return midPoint;
	}

	private void offsetMidpoint(PointList ptList, int offset) {
		if (ptList.size() < 2) {
			return;
		}
		if (offset == 0) {
			return;
		}

		Point midPoint = getMidpoint(ptList, true);
		int midptIndex = ptList.size() / 2;
		Point offsetPoint = getOffsetMidpoint(ptList, offset);

		if (midPoint != null && offsetPoint != null && midptIndex > 0
				&& midptIndex + 1 < ptList.size()) {
			ptList.setPoint(offsetPoint, midptIndex);
		}

	}

	private String getConcatenatedCaptions(List<String> captions) {
		String caption = ""; //$NON-NLS-1$
		for (Iterator<String> it = captions.iterator(); it.hasNext();) {
			caption += it.next();
			if (it.hasNext()) {
				caption += ", "; //$NON-NLS-1$
			}
		}
		return caption;
	}

	/**
	 * Return true if one of the captions has been explicitly specified, false otherwise
	 * 
	 * @return
	 */
	private boolean doPaintCaptions() {
		ConsolidationLinkEditPart consolidationLinkEP = (ConsolidationLinkEditPart) getConnectionEP();
		if (consolidationLinkEP != null) {
			for (Iterator<DeployConnectionNodeEditPart> it = consolidationLinkEP
					.getConsolidatedLinkList().iterator(); it.hasNext();) {
				DeployConnectionNodeEditPart linkEP = it.next();
				if (linkEP != null) {
					DeployModelObject linkDmo = (DeployModelObject) linkEP.resolveSemanticElement();
					if (linkDmo != null && !(linkDmo instanceof Unit)) {
						if (linkDmo.getDisplayName() != null && linkDmo.getDisplayName().length() > 0) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Returns a list of Strings for captions, one for each link in the consolidation. Entries in the
	 * list can be null or empty.
	 * 
	 * @param displayNameOnly
	 *           if true, only return display names; If false return display name or dmo name
	 * @return
	 */
	private List<String> getCaptionNames(boolean displayNameOnly) {
		ArrayList<String> captions = new ArrayList<String>();
		//ArrayList<Integer> duplicates = new ArrayList<Integer>();
		ConsolidationLinkEditPart consolidationLinkEP = (ConsolidationLinkEditPart) getConnectionEP();
		if (consolidationLinkEP != null) {
			for (Iterator<DeployConnectionNodeEditPart> it = consolidationLinkEP
					.getConsolidatedLinkList().iterator(); it.hasNext();) {
				String caption = null;
				DeployConnectionNodeEditPart linkEP = it.next();
				if (linkEP != null) {
					DeployModelObject linkDmo = (DeployModelObject) linkEP.resolveSemanticElement();
					if (linkDmo != null && !(linkDmo instanceof Unit)) {
						caption = linkDmo.getDisplayName();
						if ((caption == null || caption.length() == 0) && !displayNameOnly) {
							caption = PropertyUtils.getDmoName(linkDmo);
						}
					}
				}
				boolean dupeFound = false;
				for (String str : captions) {
					if (str != null && str.equals(caption)) {
						dupeFound = true;
						break;
					}
				}
				if (caption != null && !dupeFound) {
					captions.add(caption);
				}
				//duplicates.add(new Integer(dups + 1));
			}
		}
		// TODO: duplicate counter should only be appended if the Deploy Editor preference for "Filter duplicate view counters" is not turned on
		// Note: In the current implementation, layoutCaptions() populates a Hashtable of  <String captionName, Rectangle bounds>, which
		// is used to paint the captions. The Hashtable won't include more than 1 caption with the same name. 
		// (If that behavior is desired, either change the Hashtable implementation, or append some characters
		// to a duplicate name that will be truncated at display time, so that each key is unique).

//		for (int i = 0; i < captions.size(); i++) {
//			int dup = duplicates.get(i);
//			if (dup > 1) {
//				String caption = captions.get(i);
//				captions.set(i, caption + " (" + dup + ")"); //$NON-NLS-1$//$NON-NLS-2$
//			}
//		}
		return captions;
	}

	static private boolean isConsolidatedPreference() {
		boolean isConsolidated = true;
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		String pref = store.getString(IDeployPreferences.PREF_MULTIPLE_LINKS_STYLE);
		if (pref != null && !pref.equals(Messages.DeployCoreMainPreferencePage_Consolidated_)) {
			isConsolidated = false;
		}
		return isConsolidated;
	}

	@Override
	protected void layoutCaptions() {
		ConsolidationLinkEditPart consolidationLinkEP = (ConsolidationLinkEditPart) getConnectionEP();
		if (consolidationLinkEP == null) {
			return;
		}
		if (!doPaintCaptions()) {
			return;
		}

		Hashtable<String, Rectangle> captions = new Hashtable<String, Rectangle>(); // caption Strings + proposed bounds after layout 
		if (!isUnconsolidated() || _isBorderLine) {
			List<String> captionNames = getCaptionNames(true);
			String caption = getConcatenatedCaptions(captionNames);
			if (caption != null && caption.length() > 0) {
				Rectangle bnds = getMidpointBounds(caption, getPoints());
				if (bnds != null) {
					captions.put(caption, bnds);
				}
			}
		} else {
			List<String> captionNames = getCaptionNames(true);
			if (isUnconsolidated() && _unconsolidatedPtLists.size() <= captionNames.size()) {
				// first try to put each caption at a ptList's midpoint
				setCaptionsAtMidpoints(captions, captionNames);
				int intersectionArea = getIntersectionArea(captions.values().toArray(new Rectangle[0]),
						_captionIntersectionThreshold);
				if (intersectionArea > 0) {
					// Midpoint captions intersect; try incremental positioning along each pointList
					Hashtable<String, Rectangle> incrementalCaptions = new Hashtable<String, Rectangle>();
					setCaptionsAtEvenIncrements(incrementalCaptions, captionNames);
					int incrementalIntersectionArea = getIntersectionArea(incrementalCaptions.values()
							.toArray(new Rectangle[0]), _captionIntersectionThreshold);
					if (incrementalIntersectionArea < intersectionArea) {
						captions.clear();
						captions = incrementalCaptions;
						intersectionArea = incrementalIntersectionArea;
					}

				}
				// with either midpoint positioning or incremental positioning, there still are intersections
				if (intersectionArea > 0) {
					// justify the largest two captions to the right and left and truncate middle captions
					setCaptionsJustifiedAndTruncated(captions);
				}
			}

		}
		if (captions != null && captions.size() > 0) {
			getCaptions().putAll(captions);
		}
	}

	/**
	 * Find the two widest captions; Justify one to the left and one to the right If the center
	 * captions still intersect, truncate the intersecting center captions
	 * 
	 * @param captions
	 */
	private void setCaptionsJustifiedAndTruncated(Hashtable<String, Rectangle> captions) {
		if (captions.size() < 2) {
			return;
		}
		ArrayList<String> captionNames = new ArrayList<String>();
		ArrayList<Dimension> dimensions = new ArrayList<Dimension>();
		ArrayList<Point> midpoints = new ArrayList<Point>();
		Set<Entry<String, Rectangle>> captionSet = captions.entrySet();
		for (Entry<String, Rectangle> entry : captionSet) {
			Rectangle rect = entry.getValue();
			if (rect != null) {
				captionNames.add(entry.getKey());
				dimensions.add(rect.getSize());
				midpoints.add(rect.getCenter());
			}
		}
		captions.clear();

		// find widest caption
		int widest = 0;
		int widestIndex = 0;
		for (int i = 0; i < dimensions.size(); i++) {
			int width = dimensions.get(i).width;
			if (width > widest) {
				widest = width;
				widestIndex = i;
			}
		}
		// find leftmost midpoint
		int leftMost = Integer.MAX_VALUE;
		int leftIndex = 0;
		for (int i = 0; i < midpoints.size(); i++) {
			if (midpoints.get(i).x < leftMost) {
				leftMost = midpoints.get(i).x;
				leftIndex = i;
			}
		}

		// justify largest caption to the left of the leftmost point
		Point left = midpoints.get(leftIndex);
		String caption = captionNames.get(widestIndex);
		Dimension dim = dimensions.get(widestIndex);
		left.x -= dim.width / 2;
		Rectangle bnds = getBoundsAtPoint(caption, left, null);
		captions.put(caption, bnds);
		captionNames.remove(widestIndex);
		dimensions.remove(widestIndex);
		midpoints.remove(leftIndex);

		// find second widest caption
		widest = 0;
		widestIndex = 0;
		for (int i = 0; i < dimensions.size(); i++) {
			int width = dimensions.get(i).width;
			if (width > widest) {
				widest = width;
				widestIndex = i;
			}
		}
		// find rightmost midpoint
		int rightMost = Integer.MIN_VALUE;
		int rightIndex = 0;
		for (int i = 0; i < midpoints.size(); i++) {
			if (midpoints.get(i).x >= rightMost) {
				rightMost = midpoints.get(i).x;
				rightIndex = i;
			}
		}

		// justify second largest caption to the right of the rightmost point
		Point right = midpoints.get(rightIndex);
		caption = captionNames.get(widestIndex);
		dim = dimensions.get(widestIndex);
		right.x += dim.width / 2;
		bnds = getBoundsAtPoint(caption, right, null); // adjust above the line if it's on a flat sloped part of the pointList
		if (bnds != null) {
			captions.put(caption, bnds);
		}
		captionNames.remove(widestIndex);
		dimensions.remove(widestIndex);
		midpoints.remove(rightIndex);

		// use the former midpoints for the rest of the captions
		if (!captionNames.isEmpty()) {
			ArrayList<String> middleCaptions = new ArrayList<String>();
			PointList allPoints = getUnconsolidatedPoints();
			for (int i = 0; i < captionNames.size(); i++) {
				caption = captionNames.get(i);
				bnds = getBoundsAtPoint(caption, midpoints.get(i), allPoints);
				if (bnds != null) {
					captions.put(caption, bnds);
					middleCaptions.add(caption);
				}
			}

			for (String middleCaption : middleCaptions) {
				truncateIntersectingCaption(middleCaption, captions, _captionIntersectionThreshold);
			}
		}

	}

	/**
	 * If this captions intersects with any others, truncate it
	 * 
	 * @param caption
	 * @param captions
	 */
	private void truncateIntersectingCaption(String caption, Hashtable<String, Rectangle> captions,
			int thresholdArea) {
		if (caption.length() <= _captionTruncateLength + 1) { // (add 1 because of "..")
			return;
		}
		Rectangle captionRect = captions.get(caption);

		int intersectionArea = 0;
		for (String key : captions.keySet()) {
			if (!key.equals(caption)) {
				Rectangle rect = captions.get(key);
				Rectangle intersection = captionRect.getIntersection(rect);
				if (!intersection.isEmpty()) {
					int area = intersection.height * intersection.width;
					if (area > thresholdArea) {
						intersectionArea += area;
					}
				}
			}
		}
		if (intersectionArea > 0) {
			boolean truncate = false;
			String truncatedCaption = null;
			for (int i = _captionTruncateLength; i < caption.length() - 1 && !truncate; i++) {
				truncatedCaption = caption.substring(0, i);
				truncatedCaption += ".."; //$NON-NLS-1$
				if (captions.get(truncatedCaption) == null) {
					truncate = true;
				}
			}

			if (truncate && truncatedCaption != null) {
				captions.remove(caption);
				Rectangle bnds = getBoundsAtPoint(truncatedCaption, captionRect.getCenter(), null);
				captions.put(truncatedCaption, bnds);
			}
		}
	}

	private void setCaptionsAtMidpoints(Hashtable<String, Rectangle> captions,
			List<String> captionNames) {
		int count = 0;
		for (PointList points : _unconsolidatedPtLists) {
			String caption = captionNames.get(count);
			if (caption != null && caption.length() > 0) {
				Rectangle bnds = getMidpointBounds(caption, points);
				if (bnds != null) {
					captions.put(caption, bnds);
				}
			}
			count++;
		}
	}

	/**
	 * Incrementally place captions in even increments along each pointList
	 * 
	 * @param captions
	 * @param captionNames
	 */
	private void setCaptionsAtEvenIncrements(Hashtable<String, Rectangle> captions,
			List<String> captionNames) {
		int numCaptions = 0;
		for (String caption : captionNames) {
			if (caption != null && caption.length() > 0) {
				numCaptions++;
			}
		}
		int increment = 100 / (numCaptions + 1);
		int count = 0;
		numCaptions = 0;
		for (PointList points : _unconsolidatedPtLists) {
			String caption = captionNames.get(count);
			if (caption != null && caption.length() > 0) {
				int percentage = increment * (numCaptions + 1);
				if (percentage > 100) {
					percentage = 100;
				}
				Point pt = getPercentageLocation(points, percentage);
				if (pt != null) {
					Rectangle bnds = getBoundsAtPoint(caption, pt, points);
					if (bnds != null) {
						captions.put(caption, bnds);
						numCaptions++;
					}
				}
			}
			count++;
		}
	}

	/**
	 * Returns the total area of the intersections between the rectangles, only including those
	 * intersections that exceed the thresholdArea
	 * 
	 * @param captions
	 * @param thresholdArea
	 * @return
	 */
	private int getIntersectionArea(Rectangle[] rectangles, int thresholdArea) {
		int intersectionArea = 0;
		for (int i = 0; i < rectangles.length - 1; i++) {
			for (int j = i + 1; j < rectangles.length; j++) {
				Rectangle intersection = rectangles[i].getIntersection(rectangles[j]);
				if (!intersection.isEmpty()) {
					int area = intersection.height * intersection.width;
					if (area > thresholdArea) {
						intersectionArea += area;
					}
				}
			}
		}
		return intersectionArea;
	}

	protected Point getPercentageLocation(PointList points, int percentage) {
		Point p = PointListUtilities.calculatePointRelativeToLine(PointListUtilities
				.copyPoints(points), 0, percentage, true);
		return p;
	}
}
