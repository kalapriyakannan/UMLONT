/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Point;

/**
 * @deprecated
 */
public class FigureUtils extends FigureUtilities {

	/**
	 * @deprecated
	 */
	public static final char LATIN1_FIRST = 0x00;
	/**
	 * @deprecated
	 */
	public static final char LATIN1_LAST = 0xFF;
	/**
	 * @deprecated
	 */
	public static final char EURO_SIGN = 0x20AC;
	/**
	 * @deprecated
	 */
	public static final char SP = 0x20; // space
	/**
	 * @deprecated
	 */
	public static final char HT = 0x09; // horizontal tab
	/**
	 * @deprecated
	 */
	public static final char LF = 0x0a; // line feed
	/**
	 * @deprecated
	 */
	public static final char FF = 0x0c; // form feed
	/**
	 * @deprecated
	 */
	public static final char CR = 0x0d; // cariage return
	/**
	 * @deprecated
	 */
	public static final char PERIOD = 0x2e; // period

	private static final boolean allowDBCS = true;
	private static final String ONE_SPACE = " ";//$NON-NLS-1$

	/**
	 * @deprecated
	 */
	public static final int DEPLOYABLE_LANE = 0;
	/**
	 * @deprecated
	 */
	public static final int SERVER_LANE = 1;
	/**
	 * @deprecated
	 */
	public static final int HOST_LANE = 2;

	/**
	 * @param viewer
	 * @param location
	 * @return unknown
	 * @deprecated
	 */
	public static int getSwimLane(EditPartViewer viewer, org.eclipse.draw2d.geometry.Point location) {
		return getSwimLane(viewer, new Point(location.x, location.y));
	}

	/**
	 * @param viewer
	 * @param location
	 * @return unknown
	 * @deprecated
	 */
	public static int getSwimLane(EditPartViewer viewer, Point location) {
		org.eclipse.swt.graphics.Rectangle rect = viewer.getControl().getBounds();
		if (location.y < rect.height / 2) {
			return DEPLOYABLE_LANE;
		} else if (location.y < rect.height * 3 / 4) {
			return SERVER_LANE;
		}
		return HOST_LANE;
	}

	/**
	 * draw a string wrapped into a box
	 * 
	 * @param g
	 * @param left
	 * @param top
	 * @param text
	 * @param width
	 * @param font
	 * @param bkdColor
	 */
	public static void drawTextWrapped(Graphics g, int left, int top, String text, int width,
			Font font, Color bkdColor) {
		FontMetrics fm = g.getFontMetrics();
		int w = (font == null) ? 0 : FigureUtils.getStringWidth(text, font);
		int wd = MapModeUtil.getMapMode().LPtoDP(width);
		if (w > wd)
			w = wd;
		int h = (fm == null) ? 0 : fm.getHeight();
		if (h > 14)
			h = 14;
		float avg = (w != 0 && text.length() != 0) ? w / (float) text.length() : 0.0f;

		// split up string to fit on image (working in device units)
		List list = new ArrayList();
		int rows = 0;
		while (text.length() > 0) {
			int l = FigureUtils.getTextForSpace(text, font, w, 0, avg, false);
			// make room for decorations added below
			if (l < text.length()) {
				l--;
				if (rows > 0)
					l -= 2;
			}
			list.add(text.substring(0, l));
			text = text.substring(l);
			rows++;
		}

		// now draw each line (working in logical units)
		h = MapModeUtil.getMapMode().DPtoLP(h);
		w = MapModeUtil.getMapMode().DPtoLP(w);
		if (rows > 0) {
			int x = left;
			int y = top + MapModeUtil.getMapMode().DPtoLP(1);
			Rectangle rBkd = new Rectangle(x, y, w, h);
			if (bkdColor != null)
				g.setBackgroundColor(bkdColor);
			for (int i = 0; i < rows; i++) {
				String s = (String) list.get(i);
				// add decorations to string to make it look like one long string
				if (i + 1 < rows && !s.endsWith(" "))s += "-";//$NON-NLS-1$ //$NON-NLS-2$
				if (i > 0)
					s = "  " + s;//$NON-NLS-1$
				// draw with or with a background
				if (bkdColor != null) {
					g.fillRectangle(rBkd);
					rBkd.translate(0, h);
				}
				g.drawText(s, x, y);
				y += h;
			}
		}

	}

	/**
	 * @param f
	 * @return unknown
	 * @deprecated
	 */
	//	205507
	public static int getOverHang(Font f) {
		if (f != null) {
			FontData[] fds = f.getFontData();
			if ((fds != null) && (fds.length > 0)) {
				FontData fd = fds[0];
				if ((fd != null) && ((fd.getStyle() & SWT.ITALIC) != 0)) {
					//	Returning one white space width because
					//	overhang cannot be retrieved from FontMetrics.
					return getStringWidth(ONE_SPACE, f);
				}
			}
		}
		return 0;
	}

	/**
	 * @param types
	 * @param start
	 * @return unknown
	 * @deprecated
	 */
	public static int scanBidiSegment(byte[] types, int start) {
		if (types == null)
			return -1;

		int len = types.length;
		int offset = start;
		byte bidiType = -1;
		while (offset < len) {
			if (bidiType < 0) {
				bidiType = types[offset];
			} else {
				if (bidiType != types[offset])
					break;
			}
			offset++;
		}

		return offset - start;
	}

	/**
	 * @param s
	 * @param types
	 * @param start
	 * @return unknown
	 * @deprecated
	 */
	public static int scanLocaleSegmentBidi(String s, byte[] types, int start) {
		if (types == null)
			return scanLocaleSegment(s, start);

		if ((s == null) || (start < 0))
			return -1;
		char[] arr = s.toCharArray();
		if (arr == null)
			return -1;
		int len = arr.length;
		int offset = start;
		boolean nonLatin1 = true;
		//	Skip white spaces
		while (offset < len) {
			if (!isWhiteSpace(arr[offset])) {
				nonLatin1 = isNonLatin1(arr[offset++]);
				break;
			}
			offset++;
		}
		byte bidiType = -1;
		len = Math.min(len, types.length);
		offset = start;
		//	Scan
		while (offset < len) {
			if (bidiType < 0) {
				bidiType = types[offset];
			} else {
				if (bidiType != types[offset])
					break;
			}
			//	Need to avoid a segment from beginning with white space
			//	Otherwise, a white space may be the first character of a
			//	line.  Excepting white spaces can be rendered with both
			//	fonts, locale and latin1.
			if ((!isWhiteSpace(arr[offset])) && (isNonLatin1(arr[offset]) != nonLatin1))
				break;
			offset++;
		}
		return offset - start;
	}

	/**
	 * @param s
	 * @param start
	 * @return unknown
	 * @deprecated
	 */
	public static int scanLocaleSegment(String s, int start) {
		if ((s == null) || (start < 0))
			return -1;
		char[] arr = s.toCharArray();
		if (arr == null)
			return -1;
		int len = arr.length;
		int offset = start;
		boolean nonLatin1 = true;
		//	Skip white spaces
		while (offset < len) {
			if (!isWhiteSpace(arr[offset])) {
				nonLatin1 = isNonLatin1(arr[offset++]);
				break;
			}
			offset++;
		}
		//	Scan
		while (offset < len) {
			//	Need to avoid a segment from beginning with white space
			//	Otherwise, a white space may be the first character of a
			//	line.  Excepting white spaces can be rendered with both
			//	fonts, locale and latin1.
			if ((!isWhiteSpace(arr[offset])) && (isNonLatin1(arr[offset]) != nonLatin1))
				break;
			offset++;
		}
		return offset - start;
	}

	/**
	 * @param c
	 * @return unknown
	 * @deprecated
	 */
	public static boolean isNonLatin1(char c) {
		if ((c == EURO_SIGN) || ((LATIN1_FIRST <= c) && (c <= LATIN1_LAST))) {
			return false;
		}
		return true;
	}

	/**
	 * @param s
	 * @param start
	 * @param len
	 * @return unknown
	 * @deprecated
	 */
	public static boolean hasNonLatin1(String s, int start, int len) {
		if (s == null)
			return false;
		char[] arr = s.toCharArray();
		if (arr != null) {
			int min = Math.max(0, start);
			int idx = Math.min(start + len, arr.length);
			while (--idx >= min) {
				if (isNonLatin1(arr[idx])) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param s
	 * @return unknown
	 * @deprecated
	 */
	public static boolean hasNonLatin1(String s) {
		if (s == null)
			return false;
		return hasNonLatin1(s, 0, s.length());
	}

	/**
	 * @param c
	 * @return unknown
	 * @deprecated
	 */
	public static boolean isWhiteSpace(char c) {
		switch (c)
		{
		case SP:
		case HT:
		case LF:
		case FF:
		case CR:
			return true;
		default:
			break;
		}
		return false;
	}

	private static int indexOfFirstWhiteSpace(String s, int start, int end) {
		if (s != null) {
			if ((-1 <= start) && (end <= s.length())) {
				while (++start < end) {
					if (isWhiteSpace(s.charAt(start))) {
						return start;
					}
				}
			}
		}
		return -1;
	}

	private static int indexOfLastWhiteSpace(String s, int start, int end) {
		if (s != null) {
			if ((-1 <= start) && (end <= s.length())) {
				while (--end > start) {
					if (isWhiteSpace(s.charAt(end))) {
						return end;
					}
				}
			}
		}
		return -1;
	}

	/**
	 * @param s
	 * @return unknown
	 * @deprecated
	 */
	public static int getLeadingSpaces(String s) {
		int len = s.length();
		int index = 0;
		for (; index < len; ++index) {
			if (s.charAt(index) != SP)
				break;
		}
		return index;
	}

	/**
	 * @param s
	 * @param offset
	 * @return unknown
	 * @deprecated
	 */
	public static int getNextBreakpoint(String s, int offset) {
		int strlen = s.length();
		if (strlen == 0 || strlen <= offset) {
			return strlen;
		}
		if (allowDBCS) {
			int index;
			try {
				BreakIterator bounds = BreakIterator.getLineInstance();
				bounds.setText(s);
				int index_sp;
				int start = Math.max(0, offset - 1); //	left boundary of the previous character
				while (true) {
					index = bounds.following(start);
					if (index == BreakIterator.DONE) {
						index = s.length();
						//	For HTML, break at white space even if it is between two nbsp's
						index_sp = indexOfFirstWhiteSpace(s, start, index);
						if (index_sp >= 0) {
							index = index_sp + 1; //	right boundary of this white space
						}
						break;
					}
					//	For HTML, break at white space even if it is between two nbsp's
					index_sp = indexOfFirstWhiteSpace(s, start, index);
					if (index_sp >= 0) {
						index = index_sp + 1; //	right boundary of this white space
						break;
					}
					//	For HTML, never break at period
					if ((index < 0) || (s.charAt(index - 1) != PERIOD)) {
						break;
					}
					start = index;
				}
			} catch (IllegalArgumentException iae) {
				if (offset < 0) {
					index = 0;
				} else {
					index = s.length();
				}
			}
			return index;
		} //else {
		int index = s.indexOf(SP, offset);
		if (index == -1)
			return s.length();
		return index;
//		}
	}

	/**
	 * @param s
	 * @param offset
	 * @return unknown
	 * @deprecated
	 */
	public static int getPreviousBreakpoint(String s, int offset) {
		int strlen = s.length();
		if ((strlen == 0) || (offset <= 0)) {
			return 0;
		}
		if (strlen <= offset) {
			return strlen;
		}
		if (allowDBCS) {
			int index;
			try {
				BreakIterator bounds = BreakIterator.getLineInstance();
				bounds.setText(s);
				if (isWhiteSpace(s.charAt(offset - 1)) ||
				//	For HTML, never break at period
						(bounds.isBoundary(offset) && (s.charAt(offset - 1) != PERIOD))) {
					index = offset; //	left boundary of this character
				} else {
					int index_sp;
					int last = offset;
					while (true) {
						index = bounds.preceding(last);
						if (index == BreakIterator.DONE) {
							index = 0;
							//	For HTML, break at white space even if it is between two nbsp's
							index_sp = indexOfLastWhiteSpace(s, index, last);
							if (index_sp >= 0) {
								index = index_sp + 1; //	right boundary of this white space
							}
							break;
						}
						//	For HTML, break at white space even if it is between two nbsp's
						index_sp = indexOfLastWhiteSpace(s, index, last);
						if (index_sp >= 0) {
							index = index_sp + 1; //	right boundary of this white space
							break;
						}
						//	For HTML, never break at period
						if ((index <= 0) || (s.charAt(index - 1) != PERIOD)) {
							break;
						}
						last = index;
					}
				}
			} catch (IllegalArgumentException iae) {
				if (offset < 0) {
					index = 0;
				} else {
					index = offset; //	left boundary of this character
				}
			}
			return index;
		} //else {
		if (offset == s.length())
			return offset;
		int index = s.lastIndexOf(SP, offset - 1);
		return Math.max(0, index + 1);
//		}
	}

	public static Dimension getStringExtents(String s, Font f) {
		return new Dimension(getStringDimension(s, f));
	}

	/**
	 * @param s
	 * @param f
	 * @return unknown
	 * @deprecated
	 */
	public static int getStringWidth(String s, Font f) {
		return getStringDimension(s, f).x;
	}

	/**
	 * @param s
	 * @param f
	 * @param letter_spacing
	 * @return unknown
	 * @deprecated
	 */
	public static int getStringWidth(String s, Font f, int letter_spacing) {
		return getStringWidth(s, f) + letter_spacing * s.length();
	}

	/**
	 * @param s
	 * @param f
	 * @param availableWidth
	 * @param letter_spacing
	 * @param avg
	 * @return unknown
	 * @deprecated
	 */
	public static int getTextForSpace(String s, Font f, int availableWidth, int letter_spacing,
			float avg) {
		return getTextForSpace(s, f, availableWidth, letter_spacing, avg, true);
	}

	/**
	 * @param s
	 * @param f
	 * @param availableWidth
	 * @param letter_spacing
	 * @param avg
	 * @param wordWrap
	 * @return unknown
	 * @deprecated
	 */
	public static int getTextForSpace(String s, Font f, int availableWidth, int letter_spacing,
			float avg, boolean wordWrap) {
		FontMetrics metrics = getFontMetrics(f);
		int MIN, min, max;
		if (avg == 0.0)
			avg = metrics.getAverageCharWidth();
		//At least one space character should be returned when wordWrap is true
		//even if the first character is space character.
		MIN = min = wordWrap ? getNextBreakpoint(s, 1) : 0;
		max = s.length() + 1;

		//The size of the current guess
		int guess = 0, guessSize = 0;

		while ((max - min) > 1) {
			//Pick a new guess size
			//	New guess is the last guess plus the missing width in pixels
			//	divided by the average character size in pixels
			guess = guess + (int) ((availableWidth - guessSize) / avg);

			if (guess >= max)
				guess = max - 1;
			if (guess <= min)
				guess = min + 1;

			//Measure the current guess
			guessSize = getStringWidth(s.substring(0, guess), f, letter_spacing) - letter_spacing;

			if (guessSize <= availableWidth)
				//We did not use the available width
				min = guess;
			else
				//We exceeded the available width
				max = guess;
		}
		return Math.max(MIN, wordWrap ? getPreviousBreakpoint(s, min) : min);
	}

	/**
	 * @param s
	 * @return unknown
	 * @deprecated
	 */
	public static int getWordLength(String s) {
		// returns word length + one for a SPACE
		int index = 0;
		if (s != null) {
			int len = s.length();
			for (; index < len; ++index) {
				if (s.charAt(index) == SP) {
					index++;
					break;
				}
			}
		}
		return index;
	}

	/**
	 * @param s
	 * @param capitalizeFirstChar
	 * @return unknown
	 * @deprecated
	 */
	public static String capitalizeString(String s, boolean capitalizeFirstChar) {
		if (s != null) {
			int len = s.length();
			if (len > 0) {
				StringBuffer buf = new StringBuffer(len);
				if (buf != null) {
					char c;
					int index = 0;
					boolean capital = capitalizeFirstChar;
					while (index < len) {
						c = s.charAt(index);
						if (isNonLatin1(c) || isWhiteSpace(c)) {
							//	never transform
							buf.append(c);
							//	next latin 1 char should be capitalized
							capital = true;
						} else {
							//	transform
							if (capital) {
								buf.append(s.substring(index, index + 1).toUpperCase());
							} else {
//								buf.append(s.substring(index, index + 1).toLowerCase());
								buf.append(c);
							}
							//	next latin 1 char should not be capitalized
							capital = false;
						}
						index++;
					}
					return buf.toString();
				}
			}
		}
		return s;
	}

	/**
	 * @param s
	 * @return unknown
	 * @deprecated
	 */
	public static boolean startsWithLineFeed(String s) {
		if (s != null) {
			if (s.length() > 0) {
				if (s.charAt(0) == LF) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param s
	 * @deprecated
	 */
	public static void trace(String s) {
		System.err.println(s);
	}

	/**
	 * @param font
	 * @return unknown
	 * @deprecated
	 */
	public static int getDiacriticWidth(Font font) {
		FontMetrics metrics = getFontMetrics(font);
		return metrics == null ? 0 : metrics.getAverageCharWidth();
	}
}
