/*******************************************************************************
 * Copyright (c) 2005,2006 IBM Corporation
 * Licensed Material - Property of IBM. All rights reserved. 
 * US Government Users Restricted Rights - Use, duplication or disclosure  v1.0
 * restricted by GSA ADP Schedule Contract with IBM Corp. 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.Guid;
import com.collation.platform.model.ModelObject;
import com.collation.platform.model.domain.CMDBDomain;
import com.collation.platform.model.topology.app.db.db2.Db2Database;
import com.collation.platform.model.topology.app.db.db2.Db2Instance;
import com.collation.platform.model.topology.app.db.db2.Db2System;
import com.collation.platform.model.topology.core.Relationship;
import com.collation.platform.model.topology.meta.Association;
import com.collation.platform.model.topology.meta.ObjectClass;
import com.collation.platform.model.topology.meta.RelationshipType;
import com.collation.platform.model.topology.meta.UserDataMeta;
import com.collation.platform.model.topology.relation.Federates;
import com.collation.platform.model.topology.relation.MemberOf;
import com.collation.platform.model.topology.sys.ComputerSystem;
import com.collation.platform.model.util.GuidResult;
import com.collation.proxy.api.client.ApiException;
import com.collation.proxy.api.client.CMDBApi;
import com.collation.proxy.api.client.ResultMetaData;
import com.collation.proxy.api.common.AttrNameValue;
import com.collation.proxy.api.edm.EDMInterface;
import com.collation.topomgr.TopologyVersion;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQuery;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

/**
 * Grab-bag of tests exercising CMDB apis. 
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class CMDBAPITests extends TopologyTestCase {

	private Topology top;

	private Resource res;

	private String taddmServer = "rf18.watson.ibm.com"; //$NON-NLS-1$
	// private String taddmServer = "9.2.85.93"; //$NON-NLS-1$
	// private String taddmServer = "rfvm08.watson.ibm.com"; //$NON-NLS-1$

	private String taddmUserId = "administrator"; //$NON-NLS-1$

	private String taddmUserPw = "collation"; //$NON-NLS-1$

	/** Test case ctor */
	public CMDBAPITests() {
		super("CMDBAPITests");
	}


	/**
	 * 
	 * @throws Exception
	 */
	public void testCMDBApis() throws Exception {
		try {

			CmdbQuery cmdbQuery = new CmdbQuery(taddmServer, taddmUserId, taddmUserPw);
			CMDBApi api = cmdbQuery.getApi();
			List<ModelObject> moList = cmdbQuery.getModelObjectsOfType("ComputerSystem", 1); //$NON-NLS-1$
			assert (moList.size() > 0);
			ComputerSystem cs = (ComputerSystem) moList.get(0);
			Guid csGuid = cs.getGuid();
			ComputerSystem csFromQuery = (ComputerSystem) cmdbQuery.getModelObject(csGuid);
// assert(cs.equals(csFromQuery));

			String classNames[] = api.getClassNames();
			CMDBDomain domain = api.getDomain(csGuid);

			EDMInterface edmI = api.getEDM();

			UserDataMeta umd[] = api.getExtendedAttributeMeta("ComputerSystem");
			AttrNameValue anv[] = api.getExtendedAttributes(csGuid);

// Guid guidAliases[] = api.getGuidAliases(csGuid);

			ObjectClass oc = api.getMetaData("ComputerSystem");
			ObjectClass ocArray[] = api.getAllMetaData();
			for (int i = 0; i < ocArray.length; ++i) {
				oc = ocArray[i];
				if (oc instanceof RelationshipType) {
					if (oc.getName().equals(MemberOf.class.getName()) || oc.getName().equals(Federates.class.getName())) {
						RelationshipType rt = (RelationshipType) oc;
						Association va[] = rt.getValidAssociations();
//						System.out.println("Valid associations for " + oc.getName());
//						for (int j = 0; j < va.length; ++j) {
//							Association a = va[j];
//							System.out.println("sc=" + a.getSourceClass() + ", tc=" + a.getTargetClass());
//						}
					}
				}
			}
			assert (ocArray.length > 1);

// Set<RelationshipType> rtSet = getValidRelationshipTypes(ocArray,
// VirtualComputerSystem.class.getName(), ComputerSystem.class.getName());
// for (RelationshipType rt : rtSet) {
// System.out.println("RT : " + rt.getName());
// }

			Set keys = cs.getAllAttributes().keySet();
			String keyArray[] = new String[keys.size()];
			int ind = 0;
			for (Object key : keys) {
				keyArray[ind++] = (String) key;
			}
			ResultMetaData rmd = api.getResultMetaData("ComputerSystem", keyArray); //$NON-NLS-1$

			ModelObject csObjs1[] = api.find("SELECT name FROM ComputerSystem WHERE numCPUs > 0", 1, null, null);
			assert (csObjs1.length > 0);
			ModelObject csObjs2[] = api.find("SELECT name FROM ComputerSystem WHERE numCPUs > 1", 1, null, null);
			// rf13, rf19
// assert(csObjs2.length == 0) : csObjs2.length;
			ModelObject csObjs3[] = api.find(
					"SELECT name,guid FROM ComputerSystem WHERE name == 'rf09.watson.ibm.com'", 1, null, null);
			ModelObject csObjs4[] = api
					.find("SELECT name,guid FROM ComputerSystem WHERE name == 'RF09'", 1, null, null);
			assert (csObjs3.length == 1 || csObjs4.length == 1);
			ModelObject rf09CS = null;
			if (csObjs3.length == 1) {
				rf09CS = csObjs3[0];
			} else if (csObjs4.length == 1) {
				rf09CS = csObjs4[0];
			}
			assert rf09CS != null;

			ModelObject dbObjs[] = api.find("SELECT * FROM Db2Database where name == 'TRADEDB'", 1, null, null);
			assert dbObjs.length == 1 : dbObjs.length;
			Db2Database tradeDB = (Db2Database) dbObjs[0];
			
			/*
			Map<String, String> classNamesWithInstancesFound = new HashMap<String, String>();
			
//			for (String className : classNameSet) {
			for (int i=0; i<classNames.length; ++i) {
				String className = classNames[i];
				try {
					if (!className.startsWith("com.")) {
						continue;
					}
					// Cursed classes (api never returns, TADDM at 100 percent. For a long time, days at least). 
					if (className.endsWith("Composite")) {
						System.out.println("Skipping composite classname " + className);
						continue;
					}
					System.out.print("Attempting find of objects of type " + className);
					ModelObject MObjs[] = api.find("SELECT * FROM " + className, 1, null, null);
					System.out.println(" [" + MObjs.length + "]");
					if (MObjs.length > 0) {
						classNamesWithInstancesFound.put(className, Integer.toString(MObjs.length));
					}
				} catch (ApiException apie) {
					System.out.println("\nFailed finding objects of type " + className);
				}
			}
			for (String className : classNamesWithInstancesFound.keySet()) {
				System.out.println("Found in CMDB : " + className + " [" + classNamesWithInstancesFound.get(className) + "]");
			}
			*/
			
			// Cursed GUID?
// Guid g = new Guid("B60E06DCE16D3FDDBAC3A78E921752FD");
// ModelObject moTest1 = api.find(g, 1, null);

			String status = api.getStatus();

			RelationshipType rtArray1[] = api.getValidRelationshipTypes(Db2System.class.getName(), null);
			for (int i = 0; i < rtArray1.length; ++i) {
				System.out.println("Source relationships : " + rtArray1[i].getName());
				displayAssociations(rtArray1[i]);
			}
			RelationshipType rtArray2[] = api.getValidRelationshipTypes(null, Db2Instance.class.getName());
			for (int i = 0; i < rtArray2.length; ++i) {
				System.out.println("Target relationships : " + rtArray2[i].getName());
				displayAssociations(rtArray2[i]);
			}
			RelationshipType rtArray3[] = api.getValidRelationshipTypes(Db2System.class.getName(), Db2Instance.class
					.getName());
			for (int i = 0; i < rtArray3.length; ++i) {
				System.out.println("Source/Target relationships : " + rtArray3[i].getName());
				displayAssociations(rtArray3[i]);
			}

			TopologyVersion tv = api.getVersion();

			boolean isECMDB = api.isECMDB();

			GuidResult gr[] = api.evaluateGuids(cs);

			// "Not yet implemented"
// api.executeQuery("", csGuid, null);

			// TODO try this api
// ModelObject changes[] = findChanges(java.lang.String query,
// int depth,
// long start,
// long end,
// int changeType)
// throws ApiException

			// TODO try this api
// Application[]
// findImpactedBusinessApplications(com.collation.platform.model.Guid[] objects)
// throws ApiException
// System.out.println();

			// This is documented as obsolete though not deprecated
// api.findJDO(arg0, arg1, arg2, arg3, arg4, arg5);

			Guid rf09CSGuid = rf09CS.getGuid();
			for (int i = 0; i < 1; ++i) {
				long prevTime = System.currentTimeMillis();
				Relationship rArray[] = api.findRelationships(rf09CSGuid, CMDBApi.CDB_DIRECTION_FORWARD, null, 1, null);
				long time = System.currentTimeMillis();
				System.out.println(this.getName() + " : Elapsed milliseconds for findRelationshipsF depth 1 (cnt=" +
						rArray.length + ") = " + (time - prevTime) + " per MO=" + (time - prevTime) / rArray.length);
			}
			for (int i = 0; i < 1; ++i) {
				long prevTime = System.currentTimeMillis();
				ModelObject moArray[] = api.find("Select * from Relationship where source == '" + rf09CSGuid + "'", 1,
						null, null);
				Relationship rArray[] = new Relationship[moArray.length];
				for (int j = 0; j < moArray.length; ++j) {
					rArray[j] = (Relationship) moArray[j];
				}
// Relationship rArray[] = api.findRelationships(rf09CSGuid,
// CMDBApi.CDB_DIRECTION_FORWARD, null, 1, null);
				long time = System.currentTimeMillis();
				System.out.println(this.getName() +
						" : Elapsed milliseconds for substitute using Query for findRelationshipsF depth 1 (cnt=" +
						rArray.length + ") = " + (time - prevTime) + " per MO=" + (time - prevTime) / rArray.length);
			}
			for (int i = 0; i < 1; ++i) {
				long prevTime = System.currentTimeMillis();
				Relationship rArray[] = api
						.findRelationships(rf09CSGuid, CMDBApi.CDB_DIRECTION_BACKWARD, null, 1, null);
				long time = System.currentTimeMillis();
				System.out.println(this.getName() + " : Elapsed milliseconds for findRelationshipsB (cnt=" +
						rArray.length + ") = " + (time - prevTime) + " per MO=" + (time - prevTime) / rArray.length);
			}

			Guid tradeDBGuid = tradeDB.getGuid();
			for (int i = 0; i < 1; ++i) {
				long prevTime = System.currentTimeMillis();
				Relationship rArray[] = api
						.findRelationships(tradeDBGuid, CMDBApi.CDB_DIRECTION_FORWARD, null, 1, null);
				long time = System.currentTimeMillis();
				System.out.println(this.getName() + " : Elapsed milliseconds for findRelationshipsF (cnt=" +
						rArray.length + ") = " + (time - prevTime) + " per MO=" + (time - prevTime) / rArray.length);
			}

			for (int i = 0; i < 1; ++i) {
				long prevTime = System.currentTimeMillis();
				Relationship rArray[] = api.findRelationships(tradeDBGuid, CMDBApi.CDB_DIRECTION_BACKWARD, null, 1,
						null);
				long time = System.currentTimeMillis();
				System.out.println(this.getName() + " : Elapsed milliseconds for findRelationshipsB (cnt=" +
						rArray.length + ") = " + (time - prevTime) + " per MO=" + (time - prevTime) / rArray.length);
			}

			for (int i = 0; i < 1; ++i) {
				long prevTime = System.currentTimeMillis();
				Relationship rArray[] = api.findRelationships(tradeDBGuid, CMDBApi.CDB_DIRECTION_BACKWARD, "Contains",
						1, null);
				long time = System.currentTimeMillis();
				System.out.println(this.getName() +
						" : Elapsed milliseconds for findRelationshipsB for 'Contains' (cnt=" + rArray.length + ") = " +
						(time - prevTime) + " per MO=" + (time - prevTime) / rArray.length);
			}

// {
// long prevTime = System.currentTimeMillis();
// ModelObject relObjs[] = api.find("SELECT * FROM Relationship", 1, null,
// null);
// assert relObjs.length > 0 : relObjs.length;
// long time = System.currentTimeMillis();
// System.out.println(this.getName() + " : Elapsed milliseconds for get of all
// relationships depth 1 (cnt=" +
// relObjs.length + ") = " + (time - prevTime) + " per MO=" + (time - prevTime)
// / relObjs.length);
// }

			{
				long prevTime = System.currentTimeMillis();
				ModelObject relObjs[] = api.find("SELECT * FROM MemberOf", 1, null, null);
				assert relObjs.length > 0 : relObjs.length;
				long time = System.currentTimeMillis();
				System.out.println(this.getName() +
						" : Elapsed milliseconds for get of all MemberOf relationships depth 1 (cnt=" + relObjs.length +
						") = " + (time - prevTime) + " per MO=" + (time - prevTime) / relObjs.length);
			}

//			{
//				long prevTime = System.currentTimeMillis();
//				ModelObject relObjs[] = api.find("SELECT * FROM Federates", 1, null, null);
//				assert relObjs.length > 0 : relObjs.length;
//				long time = System.currentTimeMillis();
//				System.out.println(this.getName() +
//						" : Elapsed milliseconds for get of all Federates relationships depth 1 (cnt=" +
//						relObjs.length + ") = " + (time - prevTime) + " per MO=" + (time - prevTime) / relObjs.length);
//			}

			System.out.println();
		} catch (ApiException ae) {
			ae.printStackTrace();
		}

	}

	private void displayAssociations(RelationshipType relationshipType) {
		Association aArray[];
		try {
			aArray = relationshipType.getValidAssociations();
//			for (int i = 0; i < aArray.length; ++i) {
//				System.out.println("RT/st/tt : " + relationshipType.getName() + "/" + aArray[i].getSourceClass() + "/" +
//						aArray[i].getTargetClass());
//			}
		} catch (AttributeNotSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Set<RelationshipType> getValidRelationshipTypes(ObjectClass[] ocArray, String sourceClass,
			String targetClass) {

		Set<RelationshipType> results = new HashSet();
		java.lang.Class<?> srcClass = null;
		if (sourceClass != null)
			try {
				srcClass = com.ibm.cdb.api.server.ApiLookup.lookup(sourceClass);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		java.lang.Class<?> targClass = null;
		if (targetClass != null)
			try {
				targClass = com.ibm.cdb.api.server.ApiLookup.lookup(targetClass);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			for (int i = 0; i < ocArray.length; ++i) {
				if (!(ocArray[i] instanceof com.collation.platform.model.topology.meta.RelationshipType))
					continue;
				RelationshipType rt = (RelationshipType) ocArray[i];

				if (rt.hasValidAssociations()) {
					Association aArray[] = rt.getValidAssociations();
					for (int j = 0; j < aArray.length; ++j) {
						System.out.println("rel " + aArray[j].getClass().getSimpleName() + " s class = " +
								aArray[j].getSourceClass());
						System.out.println("rel " + aArray[j].getClass().getSimpleName() + " t class = " +
								aArray[j].getTargetClass());

						try {
							Class<?> src = Class.forName(aArray[j].getSourceClass());
							Class<?> targ = Class.forName(aArray[j].getTargetClass());
							if (srcClass == null) {
								if (targ.isAssignableFrom(targClass))
									results.add(rt);
							} else if (targClass == null) {
								if (src.isAssignableFrom(srcClass))
									results.add(rt);
							} else if (srcClass != null && targClass != null && targ.isAssignableFrom(targClass) &&
									src.isAssignableFrom(srcClass))
								results.add(rt);
						} catch (ClassNotFoundException cnfe) {
// cnfe.printStackTrace();
						}

					}
				} else {
					System.out.println("rt has no associations" + rt.getClass().getSimpleName());
				}
			}
		} catch (AttributeNotSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

}
