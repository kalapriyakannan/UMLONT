/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

/**
 * @author jswanke
 * 
 */
public class GeometryUtils {
	private static Rectangle LINEBOUNDS = Rectangle.SINGLETON;
	private static int TOLERANCE = 3;

	public static final int TOP = 0;
	public static final int RIGHT = 1;
	public static final int BOTTOM = 2;
	public static final int LEFT = 3;

	/**
	 * detewrmine if point is on a link
	 * 
	 * @param fig
	 * @param lineWidth
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param px
	 * @param py
	 * @return true
	 */
	public static boolean lineContainsPoint(IFigure fig, int lineWidth, int x1, int y1, int x2,
			int y2, int px, int py) {
		LINEBOUNDS.setSize(0, 0);
		LINEBOUNDS.setLocation(x1, y1);
		LINEBOUNDS.union(x2, y2);
		Dimension absTol = new Dimension(TOLERANCE + lineWidth / 2, 0);
		MapModeUtil.getMapMode(fig).DPtoLP(absTol);
		LINEBOUNDS.expand(absTol.width, absTol.width);
		if (!LINEBOUNDS.contains(px, py)) {
			return false;
		}

		double v1x, v1y, v2x, v2y;
		double numerator, denominator;
		double result = 0;

		if (x1 != x2 && y1 != y2) {
			v1x = (double) x2 - x1;
			v1y = (double) y2 - y1;
			v2x = (double) px - x1;
			v2y = (double) py - y1;

			numerator = v2x * v1y - v1x * v2y;

			denominator = v1x * v1x + v1y * v1y;

			result = numerator * numerator / denominator;
		}

		// if it is the same point, and it passes the bounding box test,
		// the result is always true.
		return result <= absTol.width * absTol.width;

	}

	/**
	 * determine the intersection of a point list and a rectangle, if any
	 * 
	 * @param ptList
	 * @param rect
	 * @return the point or null
	 */
	public static Point getIntersection(PointList ptList, Rectangle rect) {
		Point pt = null;
		for (int i = 0; i < ptList.size() - 1; i++) {
			// for each ptList line, check if it intersects with a rectangle side
			pt = getIntersection(ptList.getPoint(i), ptList.getPoint(i + 1), rect.getTopLeft(), rect
					.getTopRight());
			if (pt != null) {
				break;
			}
			pt = getIntersection(ptList.getPoint(i), ptList.getPoint(i + 1), rect.getTopRight(), rect
					.getBottomRight());
			if (pt != null) {
				break;
			}
			pt = getIntersection(ptList.getPoint(i), ptList.getPoint(i + 1), rect.getBottomLeft(),
					rect.getBottomRight());
			if (pt != null) {
				break;
			}
			pt = getIntersection(ptList.getPoint(i), ptList.getPoint(i + 1), rect.getTopLeft(), rect
					.getBottomLeft());
			if (pt != null) {
				break;
			}
		}
		return pt;
	}

	/**
	 * Return the list of intersection points between a point list and a rectangle
	 * 
	 * @param ptList
	 * @param rect
	 * @return the points or null
	 */
	public static PointList getIntersectionPoints(PointList ptList, Rectangle rect) {
		PointList intersectionPts = new PointList();
		Point pt = null;
		for (int i = 0; i < ptList.size() - 1; i++) {
			// for each ptList line, check if it intersects with a rectangle side
			pt = getIntersection(ptList.getPoint(i), ptList.getPoint(i + 1), rect.getTopLeft(), rect
					.getTopRight());
			if (pt != null) {
				intersectionPts.addPoint(pt);
			}
			pt = getIntersection(ptList.getPoint(i), ptList.getPoint(i + 1), rect.getTopRight(), rect
					.getBottomRight());
			if (pt != null) {
				intersectionPts.addPoint(pt);
			}
			pt = getIntersection(ptList.getPoint(i), ptList.getPoint(i + 1), rect.getBottomLeft(),
					rect.getBottomRight());
			if (pt != null) {
				intersectionPts.addPoint(pt);
			}
			pt = getIntersection(ptList.getPoint(i), ptList.getPoint(i + 1), rect.getTopLeft(), rect
					.getBottomLeft());
			if (pt != null) {
				intersectionPts.addPoint(pt);
			}
		}
		return intersectionPts;
	}

	/**
	 * Given a list of points, return the list of points that are within the rectangle; If a line
	 * segment of the list intersects the rectangle, include the intersection point(s).
	 * 
	 * @param ptList
	 * @param rect
	 * @return the points or null
	 */
	public static PointList getPointsWithinRectangle(PointList ptList, Rectangle rect) {
		PointList points = new PointList();
		for (int i = 0; i < ptList.size() - 1; i++) {
			Point pt1 = ptList.getPoint(i);
			Point pt2 = ptList.getPoint(i + 1);
			if (rect.contains(pt1)) { // pt1 is within the rect
				points.addPoint(pt1);
				if (rect.contains(pt2)) { // pt2 is also within the rect
					points.addPoint(pt2);
				} else { // pt1 is outside the rect
					int[] pts = { pt1.x, pt1.y, pt2.x, pt2.y };
					Point intersection = getIntersection(new PointList(pts), rect);
					if (intersection != null) {
						points.addPoint(intersection);
					}
				}
			} else { // pt1 is outside the rectangle
				int[] pts = { pt1.x, pt1.y, pt2.x, pt2.y };
				PointList twoPoints = new PointList(pts);
				if (rect.contains(pt2)) { // pt2 is within the rect
					Point intersection = getIntersection(twoPoints, rect);
					if (intersection != null) {
						points.addPoint(intersection);
					}
				} else { // pt2 is also outside the rect
					// find 0 or 2 intersection points
					PointList intersections = getIntersectionPoints(twoPoints, rect);
					for (int j = 0; j < intersections.size(); j++) {
						points.addPoint(intersections.getPoint(j));
					}
				}
			}
		}

		return points;
	}

	/**
	 * get intersection of two lines where line1 == p1 to p2 and line2 == p3 to p4
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @return point or null if they don't intersect
	 */
	public static Point getIntersection(Point p1, Point p2, Point p3, Point p4) {
		double p1x = p1.x;
		double p1y = p1.y;
		double p2x = p2.x;
		double p2y = p2.y;
		double p3x = p3.x;
		double p3y = p3.y;
		double p4x = p4.x;
		double p4y = p4.y;
		double dist, cos, sin, newX, factor;
		p2x -= p1x;
		p2y -= p1y;
		p3x -= p1x;
		p3y -= p1y;
		p4x -= p1x;
		p4y -= p1y;
		dist = Math.sqrt(p2x * p2x + p2y * p2y);
		cos = p2x / dist;
		sin = p2y / dist;
		newX = p3x * cos + p3y * sin;
		p3y = p3y * cos - p3x * sin;
		p3x = newX;
		newX = p4x * cos + p4y * sin;
		p4y = p4y * cos - p4x * sin;
		p4x = newX;
		if (p3y < 0. && p4y < 0. || p3y >= 0. && p4y >= 0.) {
			return null;
		}
		factor = p4x + (p3x - p4x) * p4y / (p4y - p3y);
		if (factor < 0. || factor > dist) {
			return null;
		}
		Point pt = new Point(p1x + factor * cos, p1y + factor * sin);
		if (pt.x > 0 || pt.y > 0) {
			return pt;
		}
		return null;
	}

	/**
	 * @param p1
	 * @param p2
	 * @return distance*distance
	 */
	public static int distanceSquared(Point p1, Point p2) {
		int term1 = p1.x - p2.x;
		int term2 = p1.y - p2.y;
		return term1 * term1 + term2 * term2;
	}

	/**
	 * @param boundary
	 * @param toTest
	 * @return
	 */
	public static int getClosestSide(Rectangle boundary, Point toTest) {
		int[] sides = new int[] { LEFT, RIGHT, TOP, BOTTOM };

		int closestSide = LEFT;
		int closestDistance = Integer.MAX_VALUE;

		for (int idx = 0; idx < sides.length; idx++) {
			int side = sides[idx];

			int distance = getDistanceFromEdge(boundary, toTest, side);

			if (distance < closestDistance) {
				closestDistance = distance;
				closestSide = side;
			}
		}

		return closestSide;
	}

	private static int getDistanceFromEdge(Rectangle rectangle, Point testPoint, int edgeOfInterest) {
		switch (edgeOfInterest)
		{
		case TOP:
			return testPoint.y - rectangle.y;
		case BOTTOM:
			return rectangle.y + rectangle.height - testPoint.y;
		case LEFT:
			return testPoint.x - rectangle.x;
		case RIGHT:
			return rectangle.x + rectangle.width - testPoint.x;
		}

		return 0;
	}

}
