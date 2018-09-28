package com.ibm.ccl.soa.deploy.core.internal.update;

import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;

public class CoreUnitRefresher extends UnitRefresher {

	public CoreUnitRefresher(Unit unit) {
		super(unit);
	}

	@Override
	public UnitProvider getUnitProvider() {
		if (unit == null) {
			return null;
		}
		IUnitProviderService service = ExtensionsCore.createProviderService();
		String originId = unit.getOrigin();
		if (originId == null) {
			return useFirstFoundProvider(service);
		}
		return UnitLifeCycleManager.INSTANCE.getUnitProviderByName(originId);

	}

	private UnitProvider useFirstFoundProvider(IUnitProviderService service) {
		UnitProvider[] providers = service.findEnabledProvidersByInputOnly(unit);
		return providers[0];

	}

	@Override
	protected TopologyUnitStub[] getTopologyStubs(Object inputObject) {
		if (unitProvider == null) {
			return null;
		}
		if (inputObject instanceof List) {
			return findTopologyStubs(inputObject);
		}

		return unitProvider.resolveStubs(inputObject);
	}

	private TopologyUnitStub[] findTopologyStubs(Object obj) {
		List<Object> list = (List) obj;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object inputObject = iterator.next();
			TopologyUnitStub[] stubs = unitProvider.resolveStubs(inputObject);
			if (stubs != null && stubs.length > 0) {
				return stubs;
			}
		}
		return null;
	}

}
