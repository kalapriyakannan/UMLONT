package com.ibm.ccl.deploy.core.test.amplifier;

import junit.framework.TestCase;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitAmplifier;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitAmplifierService;

public class UnitAmplifierTest extends TestCase {

	public void testFindDescriptorsbyInput() {
		IUnitAmplifierService ampedService = ExtensionsCore
				.createAmplifierService();
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		UnitAmplifier[] amplifilers = ampedService
				.findEnabledTopologyUnitAmplifiersByInputOnly(unit);
		assert (amplifilers.length != 0);
	}
	
	public void testFindDescriptorsbyInputAndOutput() {
		IUnitAmplifierService ampedService = ExtensionsCore
				.createAmplifierService();
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		UnitAmplifier[] amplifilers = ampedService
				.findEnabledTopologyUnitAmplifiersByInputAndOutput(unit, null);
		assert (amplifilers.length == 0);
	}
	
	public void testFindDescriptorsbyOutput() {
		IUnitAmplifierService ampedService = ExtensionsCore
				.createAmplifierService();
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		UnitAmplifier[] amplifilers = ampedService
				.findEnabledTopologyUnitAmplifiersByOutputOnly(null);
		assert (amplifilers.length == 0);
	}
}
