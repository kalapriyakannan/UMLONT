package com.ibm.ccl.soa.deploy.core.internal.update;

import com.ibm.ccl.soa.deploy.core.Unit;

public class CoreUnitRefresherFactory extends UnitRefresherFactory {

	public CoreUnitRefresherFactory(Unit unit) {
		super(unit);
	}

	@Override
	public CoreUnitRefresher createRefresher(Unit unit) {
		CoreUnitRefresher unitRefresher = new CoreUnitRefresher(unit);
		return unitRefresher;
	}
}
