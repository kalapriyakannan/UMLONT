package com.ibm.ccl.soa.deploy.cmdb.test;


import junit.framework.TestCase;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.Guid;
import com.collation.platform.model.ModelObject;
import com.collation.platform.model.topology.core.Relationship;
import com.collation.platform.model.topology.sys.ComputerSystem;
import com.collation.proxy.api.client.ApiConnection;
import com.collation.proxy.api.client.ApiException;
import com.collation.proxy.api.client.ApiSession;
import com.collation.proxy.api.client.CMDBApi;
import com.ibm.cdb.api.ApiFactory;

/**
 * CMDB api test case for findRelationships and replacement simple query
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class CMDBAPIFindRelationshipsTestCase extends TestCase {

	private String taddmServer = "rf18.watson.ibm.com"; //$NON-NLS-1$
	// private String taddmServer = "9.2.85.93"; //$NON-NLS-1$
//	 private String taddmServer = "rfvm08.watson.ibm.com"; //$NON-NLS-1$

	private String taddmUserId = "administrator"; //$NON-NLS-1$

	private String taddmUserPw = "collation"; //$NON-NLS-1$

	private String collationHomePropName = "com.collation.home"; //$NON-NLS-1$

	// Default value overwritten IFF running in runtime workbench
	private String collationHomePropValue = "C:/eclipse-constellation.workspace.clean.rsa/com.ibm.ccl.soa.deploy.cmdb/sdk"; //$NON-NLS-1$

	/** Test case ctor */
	public CMDBAPIFindRelationshipsTestCase() {
		super("CMDBAPIFindRelationshipsTestCase");
	}

	/**
	 * Test creating, saving, and validating.
	 * 
	 * @throws Exception
	 */
	public void testPlantsDB2StackDCMProvider() throws Exception {

		try {
			System.setProperty(this.collationHomePropName, this.collationHomePropValue);

			ApiConnection conn = ApiFactory.getInstance().getApiConnection(this.taddmServer, -1, null, false);

			ApiSession sess = ApiFactory.getInstance().getSession(conn, this.taddmUserId, this.taddmUserPw,
					ApiSession.DEFAULT_VERSION);

			CMDBApi api = sess.createCMDBApi();

			ModelObject moArray[];

			// Get a ComputerSystem and its Guid
			String simpleTypeName = "ComputerSystem";
			String query = "select * from " + simpleTypeName; //$NON-NLS-1$
			moArray = api.find(query, 1, null, null);
			assert (moArray.length > 0);
			ComputerSystem cs = (ComputerSystem) moArray[0];
			Guid csGuid = cs.getGuid();

			long prevTime;
			long time;

			// Timings for findRelationships and similar query
			for (int i = 0; i < 2; ++i) {
				prevTime = System.currentTimeMillis();
				Relationship rArray1[] = api.findRelationships(csGuid, CMDBApi.CDB_DIRECTION_FORWARD, null, 1, null);
				time = System.currentTimeMillis();
				System.out.println(this.getName() + " : Elapsed milliseconds for findRelationshipsF depth 1 (cnt=" +
						rArray1.length + ") = " + (time - prevTime) + " per MO=" + (time - prevTime) / rArray1.length);
				assert (rArray1.length > 0);
				relationshipArrayStatistics(rArray1);

				prevTime = System.currentTimeMillis();
				moArray = api.find("Select * from Relationship where source == '" + csGuid + "'", 1,
						null, null);
				assert (moArray.length > 0);
				Relationship rArray2[] = new Relationship[moArray.length];
				for (int j=0; j<moArray.length; ++j) {
					rArray2[j] = (Relationship)moArray[j];
				}
				time = System.currentTimeMillis();
				System.out.println(this.getName() + " : Elapsed milliseconds for query of Relationships depth 1 (cnt=" +
						rArray2.length + ") = " + (time - prevTime) + " per MO=" + (time - prevTime) / rArray2.length);
				relationshipArrayStatistics(rArray2);
			}

		} catch (ApiException ae) {
			ae.printStackTrace();
		}

	}
	
	private void relationshipArrayStatistics(Relationship rArray[]) throws AttributeNotSetException {
		if (rArray.length == 0) {
			return;
		}
		int sourceAttributesSetSum = 0;
		int targetAttributesSetSum = 0;
		for (int i=0; i<rArray.length; ++i) {
			sourceAttributesSetSum += rArray[i].getSource().getAllAttributes().size();
			targetAttributesSetSum += rArray[i].getTarget().getAllAttributes().size();
		}
		System.out.println("Total source attributes set = " + sourceAttributesSetSum + ", mean = " + 
				((double)sourceAttributesSetSum)/((double)rArray.length));
		System.out.println("Total target attributes set = " + targetAttributesSetSum + ", mean = " + 
				((double)targetAttributesSetSum)/((double)rArray.length));
	}
}
