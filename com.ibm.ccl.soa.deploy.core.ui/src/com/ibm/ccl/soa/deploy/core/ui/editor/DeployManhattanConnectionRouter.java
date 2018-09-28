/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.draw2d.AbstractRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Ray;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployConnectorAnchor;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployDiagramFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.DiagramFigure;

/**
 * @since 1.0 same as GEF's Manhattan Router except atry to avoid obsticles
 * 
 */
public class DeployManhattanConnectionRouter extends AbstractRouter {
	private final Map<Integer, Connection> rowsUsed = new HashMap<Integer, Connection>();

	private final Map<Integer, Connection> colsUsed = new HashMap<Integer, Connection>();

	private final Map<Connection, Object> constraints = new HashMap<Connection, Object>();

	private final LayeredPane parent;

	private static Ray UP = new Ray(0, -1);
	private static Ray DOWN = new Ray(0, 1);
	private static Ray LEFT = new Ray(-1, 0);
	private static Ray RIGHT = new Ray(1, 0);

	// saves all row and column info on every connection (link) in the diagram
	// but current not used
	private final Map<Connection, ReservedInfo> reservedInfo = new HashMap<Connection, ReservedInfo>();

	private class ReservedInfo {
		public List<Integer> reservedRows = new ArrayList<Integer>(2);
		public List<Integer> reservedCols = new ArrayList<Integer>(2);
	}

	private static int OFFSET = MapModeUtil.getMapMode().DPtoLP(5);

	/**
	 * @param parent
	 */
	public DeployManhattanConnectionRouter(LayeredPane parent) {
		super();
		this.parent = parent;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////// ROUTE  /////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @see ConnectionRouter#route(Connection)
	 */
	public void route(Connection conn) {
		// if this link doesn't have both anchors, don't bother to route
		if (conn.getSourceAnchor() == null || conn.getTargetAnchor() == null) {
			return;
		}

		// are we going into compartments?
		IFigure srcFg = conn.getSourceAnchor().getOwner();
		IFigure tgtFg = conn.getTargetAnchor().getOwner();
		boolean ignoreInterFigures = srcFg != null
				&& tgtFg != null
				&& (!(srcFg.getParent() instanceof DiagramFigure) || !(tgtFg.getParent() instanceof DiagramFigure));

		// get start and end points
		Point startPoint = getStartPoint(conn);
		conn.translateToRelative(startPoint);
		Point endPoint = getEndPoint(conn);
		conn.translateToRelative(endPoint);

		// if this link is between units in a snapped group, make it a direct connection
		if (DeployConnectionNodeEditPart.isInnerSnapLink(conn)) {
			PointList points = new PointList();
			points.addPoint(startPoint);
			points.addPoint(startPoint.getCopy().translate(0, OFFSET));
			points.addPoint(endPoint.getCopy().translate(0, -OFFSET));
			points.addPoint(endPoint);
			conn.setPoints(points);
			return;
		}

		// get start, end and midway Rays
		Ray start = new Ray(startPoint);
		Ray end = new Ray(endPoint);
		Ray average = start.getAveraged(end);

		// get the direction this link is headed from start to end (UP/DOWN/LEFT/RIGHT or combination)
		// and which way start/end are headed when they come out of their anchors
		Ray linkDirection = new Ray(start, end);
		Ray startDirection = getStartDirection(conn);
		Ray endDirection = getEndDirection(conn);

		// offset
		int five = MapModeUtil.getMapMode(conn).DPtoLP(3);
		int ten = MapModeUtil.getMapMode(conn).DPtoLP(10);

		// initialize the bendpoints in this link to up to five;
		List positions = new ArrayList(5);
		int i;

		/*--------------------------------------------------------------------------
		 * SET START OF LINK TO START POINT
		 *-------------------------------------------------------------------------- */
		boolean horizontal = startDirection.isHorizontal();
		if (horizontal) {
			positions.add(new Integer(start.y)); // <<<<<<<<<<<<< position(1)
		} else {
			positions.add(new Integer(start.x)); // <<<<<<<<<<<<< position(1)
		}
		horizontal = !horizontal;

		/*--------------------------------------------------------------------------
		 * ADD 0 TO 3 CENTER POINTS
		 *-------------------------------------------------------------------------- */
		/////////////////////////////////////////////////////////////
		/////// START AND END HEADED BOTH IN SAME DIRECTION /////////
		/////////////////////////////////////////////////////////////
		if (startDirection.dotProduct(endDirection) == 0) {
			if (startDirection.dotProduct(linkDirection) >= 0
					&& endDirection.dotProduct(linkDirection) <= 0) {
				// >>>>>>>>>>>>occurs if one hosting link anchor is rotating around a group and the other is fixed
				// 3 point line
				// 1 is start point (pos1 = y of start point)
				// 2 is pos2, last y
				// 3 is end point
				//
				// position(1) set at start to starting point's y
				// position(2) set at end to ending point's x
				//
				// NOTHING IS SET HERE
			} else {
				// >>>>>>>>>>>>>>occurs if one hosting link anchor is rotating around a group and the other is fixed
				//	  +--------+
				//   |		  |
				//	  V		  +-----+
				//
				// 5 point line
				// 1 is start point (pos1 = y of start point)
				// 2 is pos2, last y
				// 3 is last x, pos3
				// 4 is pos4, last y
				// 5 is end point
				//
				// position(1) set at start to starting point's y
				// position(2) & (3) are set here 
				// position(4) set at end to ending point's y

				// get position(2)-- a new x value either 10 pixels away from figure or 
				//   an average x value between start figure and end figure  
				if (startDirection.dotProduct(linkDirection) < 0) {
					i = startDirection.similarity(start.getAdded(startDirection.getScaled(ten)));
				} else {
					if (horizontal) {
						i = average.y;
					} else {
						i = average.x;
					}
				}
				positions.add(new Integer(i)); //<<<<<<<<<<<<<<<<<<< position(2)
				horizontal = !horizontal;

				// get position(3)-- a new y value either 10 pixels away from figure or 
				//   an average y value between start figure and end figure  
				if (endDirection.dotProduct(linkDirection) > 0) {
					i = endDirection.similarity(end.getAdded(endDirection.getScaled(ten)));
				} else {
					if (horizontal) {
						i = average.y;
					} else {
						i = average.x;
					}
				}
				positions.add(new Integer(i)); //<<<<<<<<<<<<<<< position(3)
				horizontal = !horizontal;

				// now just add end point below and we're done!
			}
			/////////////////////////////////////////////////////////////
			/////// START AND END HEADED IN DIFFRENT DIRECTIONS /////////
			/////////////////////////////////////////////////////////////
		} else {
			if (startDirection.dotProduct(endDirection) > 0) {
				// >>>>>>>>>>>>>>>>>>>>>>> occurs if one hosting link anchor is rotating around a group and the other is fixed
				// creating 4 point line:
				// 1 is start point (positions(1) = x of start point)
				// 2 is last x, positions(2)
				// 3 is positions(3), last y
				// 4 is end point
				//
				// position(1) set at start to starting point's x
				// position(2) is set here 
				// position(3) set at end to ending point's x

				// get position(2), the new y after start point-- it's just 10 pixels out from starting figure
				if (startDirection.dotProduct(linkDirection) >= 0) {
					i = startDirection.similarity(start.getAdded(startDirection.getScaled(ten)));
				} else {
					i = endDirection.similarity(end.getAdded(endDirection.getScaled(ten)));
				}
				positions.add(new Integer(i)); //<<<<<<<<<<<<<<< position(2)
				horizontal = !horizontal;
				// now just add end point below and we're done!

			} else {
				// >>>>>>>>occurs when hosting anchors are fixed on top and bottom of figure
				// >>>>>>>> also occurs when both anchors are floating-- but only 4 point line
				// can create 4 or 6 point line
				//				+(pos1==x)
				//                  |
				//       (pos2==y)  +--------+ (pos3=x)
				//                           |
				//                           V
				//   --------OR ----------
				//          (pos4=y)+----+ (pos5=x)
				//                  |    |
				//  (pos1=x) +      |    V
				//           |      |
				//  (pos2=y) +------+ (pos3=x)
				//	
				// 4/6 point line:
				// 1 is start point (pos1 = x of start point)
				// 2 is last x, pos2
				// 3 is pos3, last y
				// -/4 is last x, pos 4
				// -/5 is pos5, last y
				// 4/6 is end point
				//
				// position(1) set at start to starting point's x
				// position(2)(3)(4)(5) are set here 
				// position(4/6) set at end to ending point's x

				// get position(2) for 6 point line only: a new y, is puts the line 10 pixels above/below the starting figure
				if (startDirection.dotProduct(linkDirection) < 0) {
					i = startDirection.similarity(start.getAdded(startDirection.getScaled(ten)));
					positions.add(new Integer(i)); //<<<<<<<<<<<<<<< position(2) for 6 point line
					horizontal = !horizontal;
				}

				// get position(2) for 4 point line or (3) for 6 point line:
				//   for 4 point line, a new y that's horizontally between the start figure and end figure
				//   for 6 point line, a new x that's vertically between the start and end figure
				//   for a loopback((a 4 point line that just goes down 10 pixels/ left 10 pixels and back),
				//     put the x 10 pixels out from starting x
				if (isCycle(conn)) {
					if (horizontal) {
						i = ((DeployConnectorAnchor) conn.getSourceAnchor()).getNodeOwner().getBounds()
								.getTop().y
								- ten;
					} else {
						i = ((DeployConnectorAnchor) conn.getSourceAnchor()).getNodeOwner().getBounds()
								.getRight().x
								+ ten;
					}

				} else {

					//   for 4 point line, get position(2), a new y that's in the middle between start and end figure
					//				+(pos1==x)
					//                  |
					//       (pos2==y)  +--------+ (pos3=x)
					//                  ---------|   <-----------------below we determine the y of this line
					//                           |
					//                           V

					//   unless it will intersect a figure in which case change y to pass 5 pixels above intersecting figure 
					//  (the last x position puts the line in the horizontal middle of the end figure)

					if (horizontal) {
						// determine the area the line will be passing through
						Rectangle targetArea = new Rectangle(start.x < end.x ? start.x : end.x, start.y
								+ five, Math.abs(start.x - end.x), end.y - start.y - ten);

						// build up a rectangle that is the union of all the figures in this area
						Rectangle r = buildIntersectingRect(targetArea);

						// default to center
						i = average.y;
						if (!ignoreInterFigures && r != null) {
							boolean isBelowStart = r.x < start.x && r.getRight().x > start.x;
							boolean isAboveEnd = r.x < end.x && r.getRight().x > end.x;
							// if intersecting figures are below start point, line will pass above to avoid them 
							if (isBelowStart && !isAboveEnd) {
								if (r.y < i) {
									i = r.y - five;
									int minY = start.y + five;
									if (i < minY) {
										i = minY;
									}
								}
								// else if over end figure, pass above
							} else if (!isBelowStart && isAboveEnd) {
								int bottom = r.getBottom().y;
								if (bottom > i) {
									i = bottom + ten;
									int maxY = end.y - five;
									if (i > maxY) {
										i = maxY;
									}
								}
								// else try one or the other
							} else {
								int iAbove = r.y - five;
								int minY = start.y + five;
								if (iAbove < minY) {
									iAbove = minY;
								}
								int bottom = r.getBottom().y;
								int iBelow = bottom + ten;
								int maxY = end.y - five;
								if (iBelow > maxY) {
									iBelow = maxY;
								}
								if (iAbove - minY > maxY - iBelow) {
									i = iAbove;
								} else {
									i = iBelow;
								}
							}
							// else we just take the average and hope for the best
						}

					} else {
						//   for 6 point line, get position(3), a new x in the middle between the start and end figure, 
						//          (pos4=y)+----+ (pos5=x)
						//                  ||    |
						//  (pos1=x) +      ||    V
						//           |      ||<-----------------------below we determine the x of this line
						//  (pos2=y) +------+ (pos3=x)

						// determine the area the line will be passing through

						// default to center
						i = average.x;
						IFigure srcFig = conn.getSourceAnchor().getOwner();
						IFigure tgtFig = conn.getTargetAnchor().getOwner();
						if (srcFig != null && tgtFig != null) {

							// create a target area based on area between the start figure and end figure
							Rectangle src = srcFig.getBounds();
							Rectangle tgt = tgtFig.getBounds();
							int minX = 0;
							int maxX = 0;
							if (start.x < end.x) {
								minX = start.x + src.width / 2;
								maxX = end.x - tgt.width / 2;
							} else {
								minX = end.x + tgt.width / 2;
								maxX = start.x - src.width / 2;
							}
							// if figures aren't on top of each other
							if (minX < maxX) {
								minX += five;
								maxX -= five;
								int minY = Math.min(start.y + five, end.y - five);
								int maxY = Math.max(start.y + five, end.y - five);
								Rectangle targetArea = new Rectangle(minX, minY, maxX - minX, maxY - minY);

								// now build up a rectangle that is the union of all the figures in this area
								Rectangle r = buildIntersectingRect(targetArea);
								if (!ignoreInterFigures && r != null) {
									// create a spacer between line and figures
									r.expand(five, five);
									// if average X would put the line through these figures
									if (r.getRight().x >= i && r.x <= i) {
										// try passing line to left of it
										if (r.x > minX) {
											i = r.x;
											// else try passing to the right
										} else if (r.getRight().x < maxX) {
											i = r.getRight().x;
										}
										// else we just take the average and hope for the best
									}
								}
							}
						}
					}
				}
				positions.add(new Integer(i)); //<<<<<<<<<<<<<<< position(2 for 4 point line or 3 for 6 point line)
				horizontal = !horizontal;

				// for 6 point line, get position(4), a new y that positions the line 10 pixels above the top of the end figure
				//  (the last x position below positions the line centered over the end figure) 
				if (startDirection.dotProduct(linkDirection) < 0) {
					i = endDirection.similarity(end.getAdded(endDirection.getScaled(ten)));
					positions.add(new Integer(i)); //<<<<<<<<<<<<<<< position(4)
					horizontal = !horizontal;
				}
			}
		}

		/*--------------------------------------------------------------------------
		 * SET END OF LINK TO END POINT
		 *-------------------------------------------------------------------------- */
		if (horizontal) {
			positions.add(new Integer(end.y)); //<<<<<<<<<<<<<<< position(?)
		} else {
			positions.add(new Integer(end.x)); //<<<<<<<<<<<<<<< position(?)
		}

		/*--------------------------------------------------------------------------
		 * CONVERT POSITIONS INTO POINTS
		 *-------------------------------------------------------------------------- */
		processPositions(start, end, positions, startDirection.isHorizontal(), conn);
	}

	/*
	 * convert positions into points and set into link
	 */
	protected void processPositions(Ray start, Ray end, List positions, boolean horizontal,
			Connection conn) {
		removeReservedLines(conn);

		int pos[] = new int[positions.size() + 2];
		if (horizontal) {
			pos[0] = start.x;
		} else {
			pos[0] = start.y;
		}
		int i;
		for (i = 0; i < positions.size(); i++) {
			pos[i + 1] = ((Integer) positions.get(i)).intValue();
		}
		if (horizontal == (positions.size() % 2 == 1)) {
			pos[++i] = end.x;
		} else {
			pos[++i] = end.y;
		}

		PointList points = new PointList();
		points.addPoint(new Point(start.x, start.y));
		Point p;
		int current, prev, min, max;
		boolean adjust;
		for (i = 2; i < pos.length - 1; i++) {
			horizontal = !horizontal;
			prev = pos[i - 1];
			current = pos[i];

			adjust = i != pos.length - 2;
			if (horizontal) {
				if (adjust) {
					min = pos[i - 2];
					max = pos[i + 2];
					pos[i] = current = getRowNear(conn, current, min, max);
				}
				p = new Point(prev, current);
			} else {
				if (adjust) {
					min = pos[i - 2];
					max = pos[i + 2];
					pos[i] = current = getColumnNear(conn, current, min, max);
				}
				p = new Point(current, prev);
			}
			points.addPoint(p);
		}
		points.addPoint(new Point(end.x, end.y));
		conn.setPoints(points);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////OTHER REQUIRED OVERRIDES /////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Object getConstraint(Connection connection) {
		return constraints.get(connection);
	}

	public void setConstraint(Connection connection, Object constraint) {
		constraints.put(connection, constraint);
	}

	/**
	 * @see ConnectionRouter#invalidate(Connection)
	 */
	public void invalidate(Connection connection) {
		removeReservedLines(connection);
	}

	/**
	 * @see ConnectionRouter#remove(Connection)
	 */
	public void remove(Connection connection) {
		removeReservedLines(connection);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////// HELPERS //////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/*
	 * return the direction with which a link comes out of a anchor at the start only direction is
	 * indicated, not magnitutude (1,0), (-1,0), etc
	 */
	private Ray getStartDirection(Connection conn) {
		ConnectionAnchor anchor = conn.getSourceAnchor();
		Point p = getStartPoint(conn);
		Rectangle rect;
		int Q = MapModeUtil.getMapMode(conn).DPtoLP(1);
		if (anchor.getOwner() == null) {
			rect = new Rectangle(p.x - Q, p.y - Q, Q * 2, Q * 2);
		} else {
			rect = conn.getSourceAnchor().getOwner().getBounds().getCopy();
			conn.getSourceAnchor().getOwner().translateToAbsolute(rect);
		}
		return getDirection(rect, p);
	}

	/*
	 * return the direction with which a link comes out of a anchor at the end; only direction is
	 * indicated, not magnitutude (1,0), (-1,0), etc
	 */
	private Ray getEndDirection(Connection conn) {
		ConnectionAnchor anchor = conn.getTargetAnchor();
		Point p = getEndPoint(conn);
		Rectangle rect;
		int Q = MapModeUtil.getMapMode(conn).DPtoLP(1);
		if (anchor.getOwner() == null) {
			rect = new Rectangle(p.x, p.y - Q, Q * 2, Q * 2); // my workaround starts
		} else {
			rect = conn.getTargetAnchor().getOwner().getBounds().getCopy();
			conn.getTargetAnchor().getOwner().translateToAbsolute(rect);
		}
		return getDirection(rect, p);
	}

	/**
	 * Returns the direction the point <i>p</i> is in relation to the given rectangle. Possible
	 * values are LEFT (-1,0), RIGHT (1,0), UP (0,-1) and DOWN (0,1).
	 * 
	 * @param r
	 *           the rectangle
	 * @param p
	 *           the point
	 * @return the direction from <i>r</i> to <i>p</i>
	 */
	protected Ray getDirection(Rectangle r, Point p) {
		int i, distance = Math.abs(r.x - p.x);
		Ray direction;

		direction = LEFT;

		i = Math.abs(r.y - p.y);
		if (i <= distance) {
			distance = i;
			direction = UP;
		}

		i = Math.abs(r.bottom() - p.y);
		if (i <= distance) {
			distance = i;
			direction = DOWN;
		}

		i = Math.abs(r.right() - p.x);
		if (i < distance) {
			distance = i;
			direction = RIGHT;
		}

		return direction;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * prevent two links from overlapping each other-- keep an OFFSET between them
	 */
	// r = current point; n = potential min;  x = potential max
	private int getColumnNear(Connection connection, int r, int n, int x) {
		int min = Math.min(n, x), max = Math.max(n, x);
		if (min > r) {
			max = min;
			min = r - (min - r);
		}
		if (max < r) {
			min = max;
			max = r + r - max;
		}
		int proximity = 0;
		int direction = -1;
		if (r % OFFSET != 0) {
			r = r - r % OFFSET;
		}

		// see if there's any link in the area we can use
		for (Iterator<Entry<Integer, Connection>> it = colsUsed.entrySet().iterator(); it.hasNext();) {
			Entry<Integer, Connection> entry = it.next();
			if (entry.getKey().intValue() >= min && entry.getKey().intValue() <= max) {
				if (entry.getValue().getSourceAnchor().getOwner() == connection.getSourceAnchor()
						.getOwner()
						|| entry.getValue().getTargetAnchor().getOwner() == connection.getTargetAnchor()
								.getOwner()) {
					return entry.getKey().intValue();
				}
			}
		}

		Integer i;
		while (proximity < r) {
			i = new Integer(r + proximity * direction);
			// this column hasn't been selected yet, just use it
			if (!colsUsed.containsKey(i)) {
				colsUsed.put(i, connection);
				reserveColumn(connection, i);
				return i.intValue();
			}
//			// this column has been used, but if used by a connection with same src/tgt, let them overlap
//			Connection conn = colsUsed.get(i);
//			if (conn.getSourceAnchor().getOwner() == connection.getSourceAnchor().getOwner()
//					|| conn.getTargetAnchor().getOwner() == connection.getTargetAnchor().getOwner()) {
//				return i.intValue();
//			}
			int j = i.intValue();
			if (j <= min) {
				return j + OFFSET;
			}
			if (j >= max) {
				return j - OFFSET;
			}
			if (direction == 1) {
				direction = -1;
			} else {
				direction = 1;
				proximity += OFFSET;
			}
		}
		return r;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * prevent two links from overlapping each other-- keep an OFFSET between them
	 */
	// r = current point; n = potential min;  x = potential max
	private int getRowNear(Connection connection, int r, int n, int x) {
		int min = Math.min(n, x), max = Math.max(n, x);
		if (min > r) {
			max = min;
			min = r - (min - r);
		}
		if (max < r) {
			min = max;
			max = r + r - max;
		}

		int proximity = 0;
		int direction = -1;
		if (r % OFFSET != 0) {
			r = r - r % OFFSET;
		}

		// see if there's any link in the area we can use
		for (Iterator<Entry<Integer, Connection>> it = rowsUsed.entrySet().iterator(); it.hasNext();) {
			Entry<Integer, Connection> entry = it.next();
			if (entry.getKey().intValue() >= min && entry.getKey().intValue() <= max) {
				if (entry.getValue().getSourceAnchor().getOwner() == connection.getSourceAnchor()
						.getOwner()
						|| entry.getValue().getTargetAnchor().getOwner() == connection.getTargetAnchor()
								.getOwner()) {
					return entry.getKey().intValue();
				}
			}
		}

		Integer i;
		while (proximity < r) {
			i = new Integer(r + proximity * direction);
			if (!rowsUsed.containsKey(i)) {
				rowsUsed.put(i, connection);
				reserveRow(connection, i);
				return i.intValue();
			}
//			// this row has been used, but if used by a connection with same src/tgt, let them overlap
//			Connection conn = rowsUsed.get(i);
//			if (conn.getSourceAnchor().getOwner() == connection.getSourceAnchor().getOwner()
//					|| conn.getTargetAnchor().getOwner() == connection.getTargetAnchor().getOwner()) {
//				return i.intValue();
//			}
			int j = i.intValue();
			if (j <= min) {
				return j + OFFSET;
			}
			if (j >= max) {
				return j - OFFSET;
			}
			if (direction == 1) {
				direction = -1;
			} else {
				direction = 1;
				proximity += OFFSET;
			}
		}
		return r;
	}

	// saves row and column info on every link (connection)
	// used to clear rowsUsed/colsUsed Sets when a line is removed
	//  ReservedInfo info = (ReservedInfo) reservedInfo.get(connection);
	//  info.reservedRows(), info.reservedColumns()
	// however not currently used
	protected void reserveColumn(Connection connection, Integer column) {
		ReservedInfo info = reservedInfo.get(connection);
		if (info == null) {
			info = new ReservedInfo();
			reservedInfo.put(connection, info);
		}
		info.reservedCols.add(column);
	}

	private void reserveRow(Connection connection, Integer row) {
		ReservedInfo info = reservedInfo.get(connection);
		if (info == null) {
			info = new ReservedInfo();
			reservedInfo.put(connection, info);
		}
		info.reservedRows.add(row);
	}

	private void removeReservedLines(Connection connection) {
		ReservedInfo rInfo = reservedInfo.get(connection);
		if (rInfo == null) {
			return;
		}

		for (int i = 0; i < rInfo.reservedRows.size(); i++) {
			rowsUsed.remove(rInfo.reservedRows.get(i));
		}
		for (int i = 0; i < rInfo.reservedCols.size(); i++) {
			colsUsed.remove(rInfo.reservedCols.get(i));
		}
		reservedInfo.remove(connection);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
	protected boolean isCycle(Connection conn) {
		if (conn.getSourceAnchor() instanceof DeployConnectorAnchor
				&& conn.getTargetAnchor() instanceof DeployConnectorAnchor) {

			IFigure source = ((DeployConnectorAnchor) conn.getSourceAnchor()).getNodeOwner();
			IFigure target = ((DeployConnectorAnchor) conn.getTargetAnchor()).getNodeOwner();

			return source != null && source.equals(target);
		}
		return false;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	private Rectangle buildIntersectingRect(Rectangle targetArea) {
		Rectangle r = null;
		Set<Rectangle> figureSet = getDeployDiagramFigures();
		for (Iterator<Rectangle> it = figureSet.iterator(); it.hasNext();) {
			Rectangle rect = it.next();
			if (targetArea.intersects(rect)) {
				if (r == null) {
					r = rect.getCopy();
				} else {
					r = r.union(rect);
				}
			}
		}
		return r;
	}

	private Set<Rectangle> getDeployDiagramFigures() {
		DeployDiagramFigure d = getDeployDiagramFigureHelper(parent
				.getLayer(LayerConstants.PRIMARY_LAYER));
		if (d != null && d.getDiagramFigureMap() != null) {
			return d.getDiagramFigureMap().keySet();
		}
		return Collections.EMPTY_SET;
	}

	private DeployDiagramFigure getDeployDiagramFigureHelper(IFigure f) {
		if (f instanceof DeployDiagramFigure) {
			return (DeployDiagramFigure) f;
		}
		for (Iterator<IFigure> it = f.getChildren().iterator(); it.hasNext();) {
			DeployDiagramFigure d = getDeployDiagramFigureHelper(it.next());
			if (d != null) {
				return d;
			}
		}
		return null;
	}

}
