/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.comparator.DeployModelObjectStatusComparator;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ErrorMarkerDecorator;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.QuickFixStatusComposite.DmoListHolder;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.QuickFixStatusComposite.GroupHolder;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusUtil;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * Provides the content for the Quick Fix dialog. Roughly, the content resembles the hosting trees
 * in the diagram, and also includes nodes for links, with error statuses as the leaves.
 * 
 * @see QuickFixStatusComposite
 */
public class QuickFixStausContentProvider implements ITreeContentProvider {

	private final static Object[] NONE = new Object[0];
	private final ErrorMarkerDecorator decorator;
	Comparator<Object> comparator = new DeployModelObjectStatusComparator();
	private final Map<EObject, IGraphicalEditPart> editPartMap = new HashMap<EObject, IGraphicalEditPart>();
	// Cache used to prevent recursion; Defect 2786
	private final Map<Object, Object[]> cache = new HashMap<Object, Object[]>();

	/**
	 * Constructor
	 * 
	 * @param aDecorator
	 *           The {@link ErrorMarkerDecorator} for the {@link EditPart} that we are obtaining
	 *           status information for.
	 */
	public QuickFixStausContentProvider(ErrorMarkerDecorator aDecorator) {
		decorator = aDecorator;
	}

	public void clearCache() {
		cache.clear();
	}

	public Object[] getChildren(Object parentElement) {
		// We cache everything, and use the cache to prevent recursive trees that
		// crash when their viewer gets an expandAll().
		Object[] retVal = cache.get(parentElement);
		if (retVal == null) {
			retVal = internalGetChildren(parentElement);
			retVal = filterCachedValues(retVal);
			cache.put(parentElement, retVal);
		}
		return retVal;
	}

	private Object[] filterCachedValues(Object[] rawChildren) {
		List<Object> retVal = new LinkedList<Object>();

		for (int i = 0; i < rawChildren.length; i++) {
			if (cache.get(rawChildren[i]) == null) {
				retVal.add(rawChildren[i]);
			}
		}

		return retVal.toArray();
	}

	public Object[] internalGetChildren(Object parentElement) {
		if (decorator != null) {
			return getChildrenFromEditParts(parentElement);
		}
		return internalGetModelChildren(parentElement);
	}

	private Object[] getChildrenFromEditParts(Object parentElement) {
		if (parentElement == null || parentElement instanceof EObject) {
			List<Object> result = getDecoratorChildren((EObject) parentElement, 1);
			//Sort
			Object[] resultArray = result.toArray();
			Arrays.sort(resultArray, comparator);
			return resultArray;
		}
		return NONE;
	}

	/*
	 * Use the ErrorMarkerDecorator to get the children. This ensures that we have the same content
	 * as displayed in the EditParts.
	 */
	private List<Object> getDecoratorChildren(EObject parentElement, int depth) {
		List<Object> result = new ArrayList<Object>();
		//Get immediate statuses
		IStatus status = decorator.collectImmediateStatuses(parentElement, false);

		if (status != null) {
			collectStatuses(status, result);
		}
		//Get immediate children
		IGraphicalEditPart editPart = editPartMap.get(parentElement);
		Collection<Unit> children = decorator.getCompartmentlizedUnits(parentElement, editPart,
				editPartMap, 1);
		if (!children.isEmpty()) {
			result.addAll(children);
		}
		return result;
	}

	private void collectStatuses(IStatus status, List<Object> collection) {
		if (status.isMultiStatus()) {
			IStatus[] children = ((MultiStatus) status).getChildren();
			for (int i = 0; i < children.length; i++) {
				collectStatuses(children[i], collection);
			}
		} else if (!status.isOK()) {
			collection.add(status);
		}
	}

	public Object[] internalGetModelChildren(Object parentElement) {
		List<DeployModelObject> hosteeList = new ArrayList<DeployModelObject>();

		if (parentElement instanceof DmoListHolder) {
			DmoListHolder linksHolder = (DmoListHolder) parentElement;
			return linksHolder.getList().toArray();
		}

		if (parentElement instanceof GroupHolder) {
			GroupHolder groupHolder = (GroupHolder) parentElement;
			DeployModelObject dmo = groupHolder.getObj();
			List<? extends DeployModelObject> units = dmo.getContainedModelObjects();
			List<Object> filteredList = new ArrayList<Object>(units.size());
			gatherMemberUnit(dmo, units, filteredList, false, hosteeList);
			Object[] array = filteredList.toArray();
			Arrays.sort(array, comparator);
			return array;
		}

		if (parentElement instanceof Import) {
			Import imprt = (Import) parentElement;
			InstanceConfiguration instanceConfig = imprt.getInstanceConfiguration();
			if (instanceConfig != null) {
				List<Unit> units = instanceConfig.getVisibleUnits();
				return getSortedUnitArray(units, hosteeList);
			}
		}

		if (parentElement instanceof Topology) {
			List<Unit> units = ((Topology) parentElement).getUnits();
			return getSortedUnitArray(units, hosteeList);
		}

		if (parentElement instanceof DeployModelObject) {
			DeployModelObject dmo = (DeployModelObject) parentElement;
			IStatus status = StatusUtil.collectStatus(dmo, true);
			List<Object> list = new ArrayList<Object>();

			if (dmo instanceof Unit) {
				Unit unit = (Unit) dmo;
				if (hasMembers(dmo)) {
					gatherMemberUnit(dmo, null, list, false, hosteeList);
				}
				addFilteredContent(ValidatorUtils.getHosted(unit), list, false, hosteeList);
				addFilteredContent(TopologyUtil.getImmediateHostingLinksIn((Unit) dmo), list, true,
						hosteeList);
				addFilteredContent(((Unit) dmo).getConstraintLinks(), list, false, hosteeList);
				return gatherStatus(status, list);
			}

			addFilteredContent(TopologyUtil.getImmediateConstraintLinksOut(dmo), list, false,
					hosteeList);
			return gatherStatus(status, list);
		}

		return NONE;
	}

	private Object[] getSortedUnitArray(List<Unit> units, List<DeployModelObject> hosteeList) {
		if (units.isEmpty()) {
			return units.toArray();
		}
		List<Object> filteredList = new ArrayList<Object>(units.size());
		addFilteredContent(units, filteredList, true, hosteeList);
		Object[] array = filteredList.toArray();
		Arrays.sort(array, comparator);
		return array;
	}

	/**
	 * Add status (in the case of a MultiStatus, all the direct children) to 'list', then return
	 * 'list' as a sorted array.
	 * 
	 * @param status
	 * @param list
	 * @return
	 */
	private Object[] gatherStatus(IStatus status, List<Object> list) {
		for (StatusIterator iter = new StatusIterator(status); iter.hasNext();) {
			IStatus statusHolder = null;
			try {
				statusHolder = iter.next();
			} catch (NoSuchElementException exception) {
				DeployCoreUIPlugin.logError(0, exception.getMessage(), exception);
			}
			if (statusHolder instanceof MultiStatus) {
				MultiStatus multi = (MultiStatus) statusHolder;
				for (int i = 0; i < multi.getChildren().length; i++) {
					IStatus array_element = multi.getChildren()[i];
					if (array_element instanceof DeployStatus) {

						list.add(array_element);
					}
				}

			} else {
				if (statusHolder instanceof DeployStatus && !((DeployStatus) statusHolder).isOK()) {
					if (!list.contains(statusHolder)) {
						list.add(statusHolder);
					}
				}
			}
			Object[] array = list.toArray();
			Arrays.sort(array, comparator);
			return array;
		}
		return null;
	}

	/**
	 * Filter 'units' to 'filteredList' using {@link #addFilteredContent(List, List, boolean)}, then
	 * add members with problems to the list as well.
	 * 
	 * @param dmo
	 * @param units
	 * @param filteredList
	 * @param addRoot
	 */
	private void gatherMemberUnit(final DeployModelObject dmo,
			List<? extends DeployModelObject> units, List<Object> filteredList, boolean addRoot,
			List<DeployModelObject> hosteeList) {
		if (units != null) {
			addFilteredContent(units, filteredList, true, hosteeList);
		}
		if (dmo instanceof Unit) {
			List<Unit> list = ValidatorUtils.getMembers((Unit) dmo);
			for (Iterator<Unit> iterator = list.iterator(); iterator.hasNext();) {
				Unit unit = iterator.next();
				if (hasAnyProblems(unit, false, hosteeList)) {
					filteredList.add(unit);
				}
			}
			if (hasAnyProblems(dmo, false, hosteeList)) {
				if (!addRoot) {
					IStatus status = StatusUtil.collectStatus(dmo, true);
					filteredList.addAll(Arrays.asList(gatherStatus(status, new ArrayList())));
				} else {
					if (!ValidatorUtils.isHosted((Unit) dmo)) {
						filteredList.add(dmo);
					}
				}
			}

		}
		if (dmo instanceof DeployLink && hasAnyProblems(dmo, false, hosteeList)) {
			filteredList.add(dmo);
		}
	}

	/**
	 * Build 'filteredList' from 'list' members with errors. It isn't a simple filter; sometimes
	 * 'list' members are added twice.
	 * 
	 * Note: sets member variable {@link #hosteeList} as a side effect.
	 * 
	 * @param list
	 *           candidate DMOs
	 * @param filteredList
	 *           DMOs from 'candidate' are (mostly) added to the list if they have errors
	 * @param hostOnly
	 */
	private void addFilteredContent(List<? extends DeployModelObject> list,
			List<Object> filteredList, boolean hostOnly, List<DeployModelObject> hosteeList) {

		for (DeployModelObject dmo : list) {
			if (hosteeList.contains(dmo)) {
				continue;
			}

			if (dmo instanceof Unit) {
				if (hasAnyProblems(dmo, true, hosteeList)) {
					Unit unit = (Unit) dmo;
					if (hostOnly) {
						if (hasMembers(dmo)) {
							filteredList.add(dmo);
						}
						if (unit.getEditTopology().getRelationships().getHostedLinks(unit) != null
								&& unit.getEditTopology().getRelationships().getHostedLinks(unit).size() > 0
								|| ValidatorUtils.getHost(unit) == null) {
							filteredList.add(unit);
							hosteeList.addAll(ValidatorUtils.getHosted(unit));
						}
					} else {
						filteredList.add(unit);
					}
				}
			}

			if (dmo instanceof DeployLink && hasAnyProblems(dmo, true, hosteeList)) {
				filteredList.add(dmo);
			}
		}
		filteredList.removeAll(hosteeList);
	}

	private boolean hasAnyProblems(DeployModelObject dmo, boolean checkForMembers,
			List<DeployModelObject> hosteeList) {
		if (checkForMembers && hasMembers(dmo)) {
			List dmos = new ArrayList();
			gatherMemberUnit(dmo, null, dmos, false, hosteeList);
			return dmos.size() > 0;
		}
		return !StatusUtil.collectStatus(dmo, false).isOK();

	}

	public Object getParent(Object element) {
//		if (element instanceof DeployStatus) {
//			return null;
//		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return element instanceof DeployModelObject;

	}

	public Object[] getElements(Object inputElement) {
		if (decorator != null && decorator == inputElement) {
			return getChildren(decorator.getDeployObject(true));
		}
		return getChildren(inputElement);
	}

	public void dispose() {
		editPartMap.clear();
		cache.clear();
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// do nothing
	}

	private boolean hasMembers(DeployModelObject dmo) {
		if (dmo instanceof Unit) {
			return ValidatorUtils.getMembers((Unit) dmo).size() > 0;
		}
		return false;
	}
}
