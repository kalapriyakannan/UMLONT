package com.ibm.ccl.soa.deploy.core.internal.update;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public abstract class UnitRefresher {
	protected Unit unit;
	protected List<Object> environmentUnits;
	protected UnitProvider unitProvider;
	private IProgressMonitor monitor;

	public UnitRefresher(Unit aUnit) {
		unit = aUnit;
	}

	public IStatus init() {
		if (unit != null) {
			unitProvider = getUnitProvider();
			if (unitProvider == null) {
				IStatus status = createStatus(DeployCoreMessages.DeployModelObjectRefresherFactory_Unit_provider_not_foun_);
				logError(status);
				return status;
			}
			Object obj = unitProvider.resolveUnderlyingResource(unit, getMonitor());
			if (obj == null) {
				IStatus status = createStatus(DeployCoreMessages.DeployModelObjectRefresher_Could_not_find_underlying_objec_);
				logError(status);
				return status;
			}

			TopologyUnitStub[] stubs = getTopologyStubs(obj);
			if (stubs == null || stubs.length == 0) {
				IStatus status = createStatus(DeployCoreMessages.DeployModelObjectRefresher_Could_not_create_stubs_from_input_o_);
				return status;
			}

			resolveUnits(stubs, unitProvider);
		}
		return Status.OK_STATUS;
	}

	protected abstract TopologyUnitStub[] getTopologyStubs(Object obj);

	protected void resolveUnits(TopologyUnitStub[] stubs, UnitProvider unitProvider) {
		for (int i = 0; i < stubs.length; i++) {
			TopologyUnitStub topologyUnitStub = stubs[i];
			Object[] objects = unitProvider.resolveUnit(topologyUnitStub, true, getMonitor());
			if (objects != null) {
				unitProvider.resolveLinks(Arrays.asList(objects), getMonitor());
				getEnvironmentUnits().addAll(Arrays.asList(objects));
			}
		}
	}

	protected IStatus createStatus(String message) {
		Status status = new Status(0, DeployCorePlugin.PLUGIN_ID, message);
		return status;
	}

	private void logError(IStatus status) {
		DeployCorePlugin.log(status);

	}

	public abstract UnitProvider getUnitProvider();

	protected IProgressMonitor getMonitor() {
		return new NullProgressMonitor();
	}

	public List<Object> getEnvironmentUnits() {
		if (environmentUnits == null) {
			environmentUnits = new ArrayList();
		}
		return environmentUnits;
	}

	public boolean resolveLinks(List objects) {
		return unitProvider.resolveLinks(objects, getMonitor());

	}

}
