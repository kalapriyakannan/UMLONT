/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.comparator.DeployModelObjectStatusComparator;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusUtil;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * This class will group statuses based on there problem type.
 * 
 * Short term solution to handle missing status group function. Group types will be extensible for
 * now using constants.
 */
public class DeployStatusGrouper implements IDeployStatusGroupType, ICoreProblemType {

	private final Topology topology;
	private int error_count = 0;
	private int warning_count = 0;
	private int info_count = 0;
	private final boolean filterWarning;
	private final boolean filterError;
	private final boolean filterInfo;
	private final DeployModelObjectStatusComparator comparator = new DeployModelObjectStatusComparator();

	private Map<String, List<IStatus>> statusMap;

	public DeployStatusGrouper(Topology topology, boolean filterError, boolean filterWarning,
			boolean filterInfo) {
		this.topology = topology;
		this.filterError = filterError;
		this.filterWarning = filterWarning;
		this.filterInfo = filterInfo;
		initStatusMap();
		getStatus(topology);

	}

	private void initStatusMap() {
		statusMap = new HashMap<String, List<IStatus>>();
	}

	List<IStatus> statuses = new ArrayList<IStatus>();

	private List<?> gatherDeployModelObject(DeployModelObject dmo) {
		List<?> dmos = null;
		if (dmo instanceof Topology) {
			dmos = dmo.getContainedModelObjects();
		}
		if (dmo instanceof Import) {
			dmos = getImportUnits(dmo);
		}
		if (dmos == null || dmos.iterator() == null) {
			return Collections.emptyList();
		}
		List<Object> dmoCollection = new ArrayList<Object>();
		for (Iterator<?> iterator = dmos.iterator(); iterator.hasNext();) {
			DeployModelObject childDmo = (DeployModelObject) iterator.next();
			if (childDmo instanceof Import) {
				List importUnits = getImportUnits(childDmo);
				for (Iterator importIterator = importUnits.iterator(); importIterator.hasNext();) {
					Object importChild = importIterator.next();
					if (importChild instanceof Unit) {
						addLinks(dmoCollection, (Unit) importChild);
					}
				}
				dmoCollection.addAll(importUnits);
			} else {
				dmoCollection.add(childDmo);
			}
			if (childDmo instanceof Unit) {
				addLinks(dmoCollection, (Unit) childDmo);
			}
		}
		return dmoCollection;
	}

	private void addLinks(List<Object> dmoCollection, Unit unit) {
		dmoCollection.addAll(TopologyUtil.getImmediateHostingLinksIn(unit));
		dmoCollection.addAll(unit.getConstraintLinks());
	}

	public void getStatus(DeployModelObject dmo) {
		List<?> dmos = gatherDeployModelObject(dmo);
		for (Iterator iterator = dmos.iterator(); iterator.hasNext();) {
			DeployModelObject dmoChild = (DeployModelObject) iterator.next();
			IStatus status = StatusUtil.collectStatus(dmoChild, true);
			statuses.addAll(gatherStatus(status, null));

		}
		assortStatus(statuses);

	}

	private List<?> getImportUnits(DeployModelObject dmo) {
		List<?> dmos = null;
		Import imprt = (Import) dmo;
		InstanceConfiguration instanceConfig = imprt.getInstanceConfiguration();
		if (instanceConfig != null) {
			dmos = instanceConfig.getVisibleUnits();
		}
		return dmos;
	}

	private void assortStatus(List<IStatus> statusesList) {
		for (Iterator<IStatus> iterator = statusesList.iterator(); iterator.hasNext();) {
			IStatus statusObj = iterator.next();
			assortStatusType(statusObj);
		}

	}

	private void assortStatusType(IStatus statusObj) {
		if (statusObj instanceof DeployWrapperStatus) {
			statusObj = ((DeployWrapperStatus) statusObj).getWrappedStatus();
		}
		if (statusObj instanceof DeployActionStatus) {
			if (!statusMap.containsKey(PERFORM_CUSTOM_ACTIONS)) {
				statusMap.put(PERFORM_CUSTOM_ACTIONS, new ArrayList<IStatus>());
			}
			List<IStatus> list = statusMap.get(PERFORM_CUSTOM_ACTIONS);
			list.add(statusObj);
			return;
		}

		if (statusObj instanceof DeployMatcherStatus
				|| statusObj instanceof DeployAttributeValueSourceStatus) {
			if (!statusMap.containsKey(FIX_MISMATCHED_ATTRIBUTES)) {
				statusMap.put(FIX_MISMATCHED_ATTRIBUTES, new ArrayList<IStatus>());
			}
			List<IStatus> list = statusMap.get(FIX_MISMATCHED_ATTRIBUTES);
			list.add(statusObj);
			return;
		}

		if (statusObj instanceof DeployAttributeStatus) {
			if (!statusMap.containsKey(SET_MISSING_ATTRIBUTES)) {
				statusMap.put(SET_MISSING_ATTRIBUTES, new ArrayList<IStatus>());
			}
			List<IStatus> list = statusMap.get(SET_MISSING_ATTRIBUTES);
			list.add(statusObj);
			return;
		}

		if (statusObj instanceof DeployStatus) {
			assortStatusTypeMessage((DeployStatus) statusObj);

		}

	}

	private void assortStatusTypeMessage(DeployStatus statusObj) {
		if (statusObj.getProblemType() != null) {
			if (statusObj.getProblemType().equals(UNIT_NOT_HOSTED)) {
				if (!statusMap.containsKey(HOST_UNITS)) {
					statusMap.put(HOST_UNITS, new ArrayList<IStatus>());
				}
				List<IStatus> list = statusMap.get(HOST_UNITS);
				list.add(statusObj);
				return;
			} else if (statusObj.getProblemType().equals(CONCEPTUAL_UNIT_NOT_REALIZED)) {
				if (!statusMap.containsKey(REALIZE_CONCEPTUAL_UNITS)) {
					statusMap.put(REALIZE_CONCEPTUAL_UNITS, new ArrayList<IStatus>());
				}
				List<IStatus> list = statusMap.get(REALIZE_CONCEPTUAL_UNITS);
				list.add(statusObj);
				return;
			} else if (statusObj.getProblemType().equals(UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED)) {
				if (!statusMap.containsKey(RESOLVE_MISSING_DEPENDENCIES)) {
					statusMap.put(RESOLVE_MISSING_DEPENDENCIES, new ArrayList<IStatus>());
				}
				List<IStatus> list = statusMap.get(RESOLVE_MISSING_DEPENDENCIES);
				list.add(statusObj);
				return;
			} else if (statusObj.getMessage().contains(
					DeployCoreMessages.DeployStatusGrouper_not_matche_)) {
				if (!statusMap.containsKey(FIX_MISMATCHED_ATTRIBUTES)) {
					statusMap.put(FIX_MISMATCHED_ATTRIBUTES, new ArrayList<IStatus>());
				}
				List<IStatus> list = statusMap.get(FIX_MISMATCHED_ATTRIBUTES);
				list.add(statusObj);
				return;
			}
			//work with mk and ak to find a generic solution. Custom actions should subclass deployActionStatus
			if (statusObj.getProblemType().contains(".wasWebServerToIhsConstraintFails") || statusObj.getProblemType().contains("..earToDbLogicalLinkNotImplementedButCan")) //$NON-NLS-1$ //$NON-NLS-2$
			{
				if (!statusMap.containsKey(PERFORM_CUSTOM_ACTIONS)) {
					statusMap.put(PERFORM_CUSTOM_ACTIONS, new ArrayList<IStatus>());
				}
				List<IStatus> list = statusMap.get(PERFORM_CUSTOM_ACTIONS);
				list.add(statusObj);
				return;

			}
		}
		if (!statusMap.containsKey(OTHER)) {
			statusMap.put(OTHER, new ArrayList<IStatus>());
		}
		List<IStatus> list = statusMap.get(OTHER);
		list.add(statusObj);

	}

	private List<IStatus> gatherStatus(IStatus status, List<IStatus> list) {
		if (list == null) {
			list = new ArrayList<IStatus>();
		}
		for (StatusIterator iter = new StatusIterator(status); iter.hasNext();) {
			IStatus statusHolder = null;
			try {
				statusHolder = iter.next();
			} catch (NoSuchElementException exception) {
				DeployCorePlugin.logError(0, exception.getMessage(), exception);
			}
			if (statusHolder instanceof MultiStatus) {
				MultiStatus multi = (MultiStatus) statusHolder;
				for (int i = 0; i < multi.getChildren().length; i++) {
					IStatus statusChild = multi.getChildren()[i];
					if (statusChild instanceof DeployStatus) {
						if (!list.contains(statusChild)) {
							countStatusType(statusChild);
							list.add(statusChild);
						}
					}
				}
			} else {
				if (statusHolder instanceof DeployStatus && !((DeployStatus) statusHolder).isOK()) {
					if (!list.contains(statusHolder)) {
						countStatusType(statusHolder);
						list.add(statusHolder);
					}
				}
			}
		}
		return list;
	}

	private void countStatusType(IStatus status) {

		switch (status.getSeverity())
		{
		case IStatus.ERROR: {
			++error_count;
			break;
		}
		case IStatus.WARNING: {
			++warning_count;
			break;

		}
		case IStatus.INFO: {
			++info_count;
			break;
		}

		}

	}

	public Map<String, List<IStatus>> getStatusMap() {
		return statusMap;
	}

	public Object[] getStatus(String type) {
		List<IStatus> types = getStatusMap().get(type);
		if (types == null || types.isEmpty()) {
			return new Object[0];
		}

		Object[] result = types.toArray();
		Arrays.sort(result, comparator);
		return result;
	}

	public Map<DeployModelObject, List<IStatus>> getUnitMap(List<IStatus> statusList) {
		Map<DeployModelObject, List<IStatus>> deployModelMap = new HashMap<DeployModelObject, List<IStatus>>();
		for (Iterator<IStatus> iterator = statusList.iterator(); iterator.hasNext();) {
			IStatus status = iterator.next();
			if (status instanceof DeployStatus) {
				DeployStatus deployStatus = (DeployStatus) status;
				DeployModelObject dmo = deployStatus.getDeployObject();
				if (deployModelMap.containsKey(dmo)) {
					List<IStatus> dmoStatusList = deployModelMap.get(dmo);
					dmoStatusList.add(deployStatus);
				} else {
					List<IStatus> newStatusList = new ArrayList<IStatus>();
					newStatusList.add(status);
					deployModelMap.put(dmo, newStatusList);
				}
			}
		}
		return deployModelMap;
	}

	public int getCount(String type, int serverityType) {
		if (type.equals(GLOBAL)) {
			if (serverityType == IStatus.ERROR) {
				return error_count;
			}
			if (serverityType == IStatus.WARNING) {
				return warning_count;
			}
			if (serverityType == IStatus.INFO) {
				return info_count;
			}
		}
		List<IStatus> statuses = getStatusMap().get(type);
		if (statuses == null || statuses.size() == 0) {
			return 0;
		}
		return getCount(statuses, serverityType);

	}

	private int getCount(List<IStatus> statuses, int severityType) {
		int counter = 0;
		for (Iterator iterator = statuses.iterator(); iterator.hasNext();) {
			IStatus status = (IStatus) iterator.next();
			if (status.getSeverity() == severityType) {
				counter++;
			}
		}
		return counter;

	}

	public Object[] getDeployModelObjects(String type) {
		List<IStatus> statusList = getStatusMap().get(type);
		if (statusList == null) {
			return new Object[0];
		}
		Map<DeployModelObject, List<IStatus>> deployModelMap = getUnitMap(statusList);
		return deployModelMap.keySet().toArray();
	}

	public Object[] getStatuses(DeployModelObject dmo, String type) {
		List<IStatus> statuses = getStatusMap().get(type);
		Map<DeployModelObject, List<IStatus>> deployModelMap = getUnitMap(statuses);
		List<IStatus> statusList = deployModelMap.get(dmo);
		Object[] result = statusList.toArray();
		Arrays.sort(result, comparator);
		return result;
	}

	public Topology getTopology() {
		return topology;
	}

}
