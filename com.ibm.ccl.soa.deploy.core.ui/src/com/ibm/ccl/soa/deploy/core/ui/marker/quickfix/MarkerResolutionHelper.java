/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.marker.quickfix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.ide.IDE;

/**
 * Helper class that caches the IMarkerResolutions produced by
 * IDE.getMarkerHelpRegistry().getResolutions().
 * 
 * @since 1.0
 */
public class MarkerResolutionHelper {
	/** An empty array of marker resolutions. */
	public static final IMarkerResolution[] EMPTY_MARKER_RESOLUTIONS = new IMarkerResolution[0];

	/** Map of IMarker to IMarkerResolution[] */
	private final Map markerResolutionArrayMap = new HashMap();

	/** The markers for which resolutions are found. */
	private final IMarker[] markers;

	/** All resolutions found for the markers. */
	private IMarkerResolution[] resolutions;

	/**
	 * Create a resolution marker helper for the specified markers.
	 * 
	 * @param markers
	 *           the markers for which resolutions should be created.
	 */
	public MarkerResolutionHelper(IMarker[] markers) {
		this.markers = markers;
		init();
	}

	/**
	 * Initialize the resolutions for the markers.
	 */
	private void init() {
		if (markers != null) {
			List resolutionList = new ArrayList();
			for (int x = 0; x < markers.length; ++x) {
				if (IDE.getMarkerHelpRegistry().hasResolutions(markers[x])) {
					IMarkerResolution[] resolutions = IDE.getMarkerHelpRegistry().getResolutions(
							markers[x]);
					if (resolutions != null) {
						//TODO switch back to Collection.addAll(...) when build supports jre 1.5
						// Collection.addAll is a faster implementation
						resolutionList.addAll(Arrays.asList(resolutions));
					}
					markerResolutionArrayMap.put(markers[x], resolutions);
				}
			}
			resolutions = (IMarkerResolution[]) resolutionList
					.toArray(new IMarkerResolution[resolutionList.size()]);
		} else {
			resolutions = EMPTY_MARKER_RESOLUTIONS;
		}
	}

	/**
	 * Returns the resolutions for the specified marker.
	 * 
	 * @param marker
	 *           the marker
	 * @return the resolutions for the given marker (never null).
	 */
	public IMarkerResolution[] getResolutions(IMarker marker) {
		IMarkerResolution[] result = (IMarkerResolution[]) markerResolutionArrayMap.get(marker);
		if (result == null) {
			return EMPTY_MARKER_RESOLUTIONS;
		}
		return result;
	}

	/**
	 * @return all the resolutions found for them markers (never null).
	 */
	public IMarkerResolution[] getResolutions() {
		return resolutions;
	}

	/**
	 * Resolves a resolution to the marker for which it was created.
	 * 
	 * @param resolution
	 *           a resolution returned by {@link #getResolutions()}.
	 * @return the marker for the given resolution, null if not found.
	 */
	public IMarker getMarker(IMarkerResolution resolution) {
		for (Iterator iter = markerResolutionArrayMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			IMarker marker = (IMarker) entry.getKey();
			IMarkerResolution[] resolutions = (IMarkerResolution[]) entry.getValue();
			if (resolutions != null) {
				for (int x = 0; x < resolutions.length; ++x) {
					if (resolutions[x] == resolution) {
						return marker;
					}
				}
			}
		}
		return null;
	}
}
