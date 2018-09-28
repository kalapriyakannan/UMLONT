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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.Guid;
import com.collation.platform.model.ModelObject;
import com.collation.platform.model.topology.core.Relationship;
import com.collation.platform.model.topology.meta.ObjectClass;
import com.collation.platform.model.topology.meta.RelationshipType;
import com.collation.platform.model.topology.sys.ComputerSystem;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQuery;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;

/**
 * <p>
 * Exercise public methods in CmdbQueryService.
 * 
 * @author Bill Arnold
 */
public class CMDBQueryServiceTests extends TestCase {

	private String taddmServer = "rf18.watson.ibm.com"; //$NON-NLS-1$

	// private String taddmServer = "9.2.85.93"; //$NON-NLS-1$
	// private String taddmServer = "rfvm08.watson.ibm.com"; //$NON-NLS-1$

	private String taddmUserId = "administrator"; //$NON-NLS-1$

	private String taddmUserPw = "collation"; //$NON-NLS-1$

	/** Test case ctor */
	public CMDBQueryServiceTests() {
		super("CMDBQueryServiceTests");
	}

	/**
	 * 
	 * @throws AttributeNotSetException
	 */
	public void testCMDBQueries() throws AttributeNotSetException {
		CmdbQuery cmdbQuery = new CmdbQuery(taddmServer, taddmUserId, taddmUserPw);
		CmdbQueryService.INSTANCE.setTaddmServer(taddmServer);
		CmdbQueryService.INSTANCE.setTaddmUserId(taddmUserId);
		CmdbQueryService.INSTANCE.setTaddmUserPw(taddmUserPw);

		List<ModelObject> moListRaw = cmdbQuery.getModelObjectsOfType("ComputerSystem");
		{
			List<ModelObject> moListSvc = CmdbQueryService.INSTANCE.getModelObjectsOfType("ComputerSystem");
			assert moListRaw.size() > 0;
			assertCollectionsSimilar((Collection)moListRaw, (Collection)moListSvc);
		}
		ModelObject firstMO = moListRaw.get(0);
		Guid firstMOGuid = firstMO.getGuid();

		{
			List<Relationship> relsInRaw = cmdbQuery.getCmdbRelationshipsIn(firstMOGuid);
			List<Relationship> relsInSvc = CmdbQueryService.INSTANCE.getCmdbRelationshipsIn(firstMOGuid);
			assert relsInRaw.size() > 0;
			assertCollectionsSimilar((Collection)relsInRaw, (Collection)relsInSvc);
		}

		{
			List<Relationship> relsOutRaw = cmdbQuery.getCmdbRelationshipsOut(firstMOGuid);
			List<Relationship> relsOutSvc = CmdbQueryService.INSTANCE.getCmdbRelationshipsOut(firstMOGuid);
			assert relsOutRaw.size() > 0;
			assertCollectionsSimilar((Collection)relsOutRaw, (Collection)relsOutSvc);
		}

		{
			ObjectClass allMDRaw[] = cmdbQuery.getAllMetaData();
			ObjectClass allMDSvc[] = CmdbQueryService.INSTANCE.getAllMetaData();
			List<ObjectClass> allMDRawList = Arrays.asList(allMDRaw);
			List<ObjectClass> allMDSvcList = Arrays.asList(allMDSvc);
			assert allMDRawList.size() > 0;
			assertCollectionsSimilar((Collection)allMDRawList, (Collection)allMDSvcList);
		}

		{
			ObjectClass md1 = cmdbQuery.getMetaData("ComputerSystem");
			ObjectClass md2 = cmdbQuery.getMetaData("com.collation.platform.model.topology.sys.ComputerSystem");
			assert md1.getName().equals(md2.getName());
			ObjectClass mdSvc1 = CmdbQueryService.INSTANCE.getMetaData("ComputerSystem");
			ObjectClass mdSvc2 = CmdbQueryService.INSTANCE.getMetaData("com.collation.platform.model.topology.sys.ComputerSystem");
			assert mdSvc1.getName().equals(mdSvc2.getName());
			assert mdSvc1.getName().equals(md1.getName());
		}
		
		{
			List<RelationshipType> relTypesSourceRaw = cmdbQuery.getValidRelationshipsSource(ComputerSystem.class);
			List<RelationshipType> relTypesSourceSvc = CmdbQueryService.INSTANCE.getValidRelationshipsSource(ComputerSystem.class);
			assert relTypesSourceRaw.size() > 0;
			assertCollectionsSimilar((Collection)relTypesSourceRaw, (Collection)relTypesSourceSvc);
		}
		
		{
			List<RelationshipType> relTypesTargetRaw = cmdbQuery.getValidRelationshipsTarget(ComputerSystem.class);
			List<RelationshipType> relTypesTargetSvc = CmdbQueryService.INSTANCE.getValidRelationshipsTarget(ComputerSystem.class);
			assert relTypesTargetRaw.size() > 0;
			assertCollectionsSimilar((Collection)relTypesTargetRaw, (Collection)relTypesTargetSvc);
		}

	}
	
	private void assertCollectionsSimilar(Collection<Object> c1, Collection<Object> c2) {
		// sizes same
		assert (c1.size() == c2.size());

		// classes of objects in collections
		Set<Object> s1 = new HashSet<Object>();
		for (Object o : c1) {
			s1.add(o.getClass().getName());
		}
		Set<Object> s2 = new HashSet<Object>();
		for (Object o : c2) {
			s2.add(o.getClass().getName());
		}
	    assert s2.containsAll(s1);
		assert s1.containsAll(s2);
		
		// GUIDs if model objects
		s1.clear();
		for (Object o : c1) {
			if (o instanceof ModelObject) {
				try {
					s1.add(((ModelObject)o).getGuid());
				} catch (AttributeNotSetException e) {
				}
			}
		}
		s2.clear();
		for (Object o : c2) {
			try {
				s2.add(((ModelObject)o).getGuid());
			} catch (AttributeNotSetException e) {
			}
		}
	    assert s2.containsAll(s1);
		assert s1.containsAll(s2);
	}

}
