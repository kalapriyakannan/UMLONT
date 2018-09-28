/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.validator.pattern.action;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.SignatureInstanceIterator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.UnitSignature;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

public class SignatureIteratorTest extends TestCase {

	public static final String PROJECT_NAME = SignatureIteratorTest.class
			.getName();

	public void testIterator() {

		WasCellUnit cell1 = WasFactory.eINSTANCE.createWasCellUnit();
		cell1.setName("cell1");
		WasCellUnit cell2 = WasFactory.eINSTANCE.createWasCellUnit();
		cell2.setName("cell2");
		WebsphereAppServerUnit server1 = WasFactory.eINSTANCE
				.createWebsphereAppServerUnit();
		server1.setName("server1");

		// Topology1
		Topology top1 = CoreFactory.eINSTANCE.createTopology();
		top1.setName("top1");
		top1.getUnits().add(cell1);
		top1.getUnits().add(cell2);
		top1.getUnits().add(server1);

		UnitSignature signature11 = new UnitSignature(
				new EClass[] { CorePackage.Literals.UNIT });
		UnitSignature signature21 = new UnitSignature(
				new EClass[] { WasPackage.Literals.WAS_CLUSTER_UNIT });

		UnitSignature signature12 = new UnitSignature(new EClass[] {
				WasPackage.Literals.WAS_CELL_UNIT,
				WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT });
		UnitSignature signature22 = new UnitSignature(new EClass[] {
				WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT,
				WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT });

		UnitSignature signature13 = new UnitSignature(new EClass[] {
				WasPackage.Literals.WAS_CELL_UNIT,
				WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT,
				WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT });
		UnitSignature signature23 = new UnitSignature(new EClass[] {
				WasPackage.Literals.WAS_CELL_UNIT,
				WasPackage.Literals.WAS_CELL_UNIT,
				WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT });

		SignatureInstanceIterator iter1 = new SignatureInstanceIterator(
				signature11, top1);
		assertEquals(3, getNumberOfCombinations(iter1));
		SignatureInstanceIterator iter2 = new SignatureInstanceIterator(
				signature21, top1);
		assertEquals(0, getNumberOfCombinations(iter2));
		SignatureInstanceIterator iter3 = new SignatureInstanceIterator(
				signature12, top1);
		assertEquals(2, getNumberOfCombinations(iter3));
		SignatureInstanceIterator iter4 = new SignatureInstanceIterator(
				signature22, top1);
		assertEquals(0, getNumberOfCombinations(iter4));
		SignatureInstanceIterator iter5 = new SignatureInstanceIterator(
				signature13, top1);
		assertEquals(0, getNumberOfCombinations(iter5));
		SignatureInstanceIterator iter6 = new SignatureInstanceIterator(
				signature23, top1);
		assertEquals(2, getNumberOfCombinations(iter6));
	}

	private int getNumberOfCombinations(SignatureInstanceIterator iter) {
		int number = 0;
		while (iter.hasNext()) {
			List<DeployModelObject> inst = iter.next();
			if (!inst.contains(null) && inst.size() > 0) {
				// System.out.println("next instance: " + dumpInstances (inst));
				// //$NON-NLS-1$
				number++;
			}
		}
		return number;
	}

	// for debugging
	public String dumpInstances(List<DeployModelObject> instances) {
		if (null == instances)
			return "[]";//$NON-NLS-1$
		String output = "["; //$NON-NLS-1$
		for (int i = 0; i < instances.size(); i++) {
			if (i > 0)
				output += ","; //$NON-NLS-1$
			DeployModelObject o = instances.get(i);
			if (null == o) {
				output += "null"; //$NON-NLS-1$
			} else {
				output += (o instanceof Unit) ? ((Unit) o).getCaptionProvider().title((Unit) o) : o
						.getName();
			}
		}
		output += "]"; //$NON-NLS-1$
		return output;
	}

}
