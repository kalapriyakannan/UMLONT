package com.ibm.ccl.soa.deploy.core.test.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;

/**
 * Memory leak test case. 
 * 
 * @author barnold
 * 
 */
public class DeployNLSTest extends TopologyTestCase {

	static final int TRY_COUNT = 1024 * 1024;

	/**
	 * @param name
	 */
	public DeployNLSTest(String name) {
		super(name);
		this.setDeleteProjectOnTearDown(false);
	}

	/**
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void testGetName() {
//		long start = System.currentTimeMillis();
		for (int i = 0; i < TRY_COUNT; ++i) {
			if (i % 100 == 0) {
				System.out.println(".");
			}
			Topology top = createTopology("testGetName");
			Unit u = addUnit(top, "testUnit");

			for (Iterator attrIter = u.eClass().getEAllAttributes().iterator(); attrIter.hasNext();) {
				EAttribute ea = (EAttribute) attrIter.next();

				// Excludes all core EAttributes that are FeatureMaps
				if (FeatureMapUtil.isFeatureMap(ea)) {
					continue;
				}
				@SuppressWarnings("unused")
				String translatedAttribName = DeployNLS.getName(u, ea);
			}
			
			unloadTopologyInEditingDomain(top);
		}
//		System.out.println("Took " + (System.currentTimeMillis() - start)/1000 + " sec to run " + TRY_COUNT + " iterations");
	}
}
