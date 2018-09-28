package com.ibm.ccl.soa.deploy.cmdb.ui.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

import sun.management.counter.Units;

import com.collation.platform.model.Guid;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbToTdmConversionUtils;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;

/**
 * Static UI utility methods for the CMDB domain.
 */
public final class CmdbUiUtil {

	private CmdbUiUtil() {
		// do not instantiate
	}

	/**
	 * Returns a list of {@link Units}s for the parts selected.
	 * 
	 * @param selectedParts
	 *            a UI selection
	 * @return a list of Units (never null}.
	 */
	public static List<Unit> getSelectedPartUnits(List selectedParts) {
		if (selectedParts == null) {
			return Collections.emptyList();
		}
		List<Unit> result = null;
		for (Object obj : selectedParts) {
			Unit unit = getSelectedPartUnit(obj);
			if (unit != null) {
				if (result == null) {
					result = new ArrayList<Unit>();
				}
				result.add(unit);
			}
		}
		if (result == null) {
			return Collections.emptyList();
		}
		return result;
	}

	/**
	 * Returns a list of {@link Guid}s for the units selected.
	 * 
	 * @param selection
	 *            a UI selection
	 * @return a list of GUIDs (never null}.
	 */
	public static List<Guid> getSelectedPartGuids(IStructuredSelection selection) {
		if (selection == null) {
			return Collections.emptyList();
		}
		return getSelectedPartGuids(selection.iterator());
	}

	/**
	 * Returns a list of {@link Guid}s for the units selected.
	 * 
	 * @param selectedParts
	 *            alist of selected parts.
	 * @return a list of GUIDs (never null}.
	 */
	public static List<Guid> getSelectedPartGuids(List selectedParts) {
		if (selectedParts == null) {
			return Collections.emptyList();
		}
		return getSelectedPartGuids(selectedParts.iterator());
	}

	/**
	 * Returns a list of {@link Guid}s for the units selected.
	 * 
	 * @param iter
	 *            an iterator over selected parts.
	 * @return a list of GUIDs (never null}.
	 */
	public static List<Guid> getSelectedPartGuids(Iterator iter) {
		if (iter == null) {
			return Collections.emptyList();
		}
		List<Guid> result = null;
		while (iter.hasNext()) {
			Object element = iter.next();
			Unit unit = getSelectedPartUnit(element);
			if (unit != null) {
				Guid guid = CmdbToTdmConversionUtils.getCmdbGuid(unit);
				if (guid != null) {
					if (result == null) {
						result = new ArrayList<Guid>();
					}
					result.add(guid);
				}
			}
		}
		if (result == null) {
			return Collections.emptyList();
		}
		return result;
	}

	/**
	 * Returns the unit represented by the selected element.
	 * 
	 * @param selectedElement
	 *            a selected element.
	 * @return the unit of the element, or null if not applicable.
	 * @see IStructuredSelection#iterator()
	 */
	public static Unit getSelectedPartUnit(Object selectedElement) {
		if (selectedElement instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) selectedElement;
			EObject eo = ep.getNotationView().getElement();
			if (eo instanceof Unit) {
				return (Unit) eo;
			}
		}
		if (selectedElement instanceof Unit) {
			return (Unit) selectedElement;
		}
		return null;
	}
}
