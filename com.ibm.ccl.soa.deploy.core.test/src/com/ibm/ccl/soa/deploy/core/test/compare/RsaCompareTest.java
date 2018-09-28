package com.ibm.ccl.soa.deploy.core.test.compare;

import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

public class RsaCompareTest extends TopologyTestCase {

	public RsaCompareTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/*public RsaCompareTest(String name) {
		super("testCompareUnits");
		// TODO Auto-generated constructor stub
	}

	public void testCompareUnits() {
		Topology top = createTopology("compareTopology");

		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("test Unit");
		top.getUnits().add(unit);
		try {
			top.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		Resource resource = unit.eResource();
		try {
			resource.unload();
			resource.load(Collections.EMPTY_MAP);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
		Topology topology2 = root.getTopology();
		Unit unit2 = (Unit) topology2.getUnits().get(0);
		Capability capability = CoreFactory.eINSTANCE.createCapability();
		capability.setName("test Cap");
		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
		annotation.setContext("test");
		unit2.getAnnotations().add(annotation);
		AttributeMetaData data = CoreFactory.eINSTANCE.createAttributeMetaData();
		data.setAttributeName("test attribute");
		capability.getAttributeMetaData().add(data);
		unit2.getCapabilities().add(capability);

		Resource resource2 = null;
		try {
			resource2 = ResourceUtil.getResourceSet().createResource(
					resource.getURI());
			resource2.load(Collections.EMPTY_MAP);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DeployCoreRoot root2 = (DeployCoreRoot) resource2.getContents().get(0);
		Topology topology = root2.getTopology();
		Unit unit3 = (Unit) topology.getUnits().get(0);

		String label;
		Resource baseResource = unit2.eResource();
		Resource contributorResource = unit3.eResource();

		label = baseResource.getURI().path();
		IInputOutputDescriptor baseDesc = new DefaultInputOutputDescriptor(
				IInputOutputDescriptor.TYPE_INPUT_DATA_IN_MEMORY, baseResource,
				label, label);

		label = contributorResource.getURI().path();
		IInputOutputDescriptor contDesc = new DefaultInputOutputDescriptor(
				IInputOutputDescriptor.TYPE_INPUT_DATA_IN_MEMORY, contributorResource,
				label, label);

		String fileType = baseResource.getURI().lastSegment();
		IMergeStatusCallback callback = new DefaultMergeStatusCallback();
		MergeSessionInfo sessionInfo = new MergeSessionInfo(fileType, null,
				baseDesc, contDesc, baseDesc, MergeModeType.MERGE_BY_ID,
				callback, false, true);
		
		EmfMergeManager mgr = new EmfMergeManager();
		mgr.init(sessionInfo);
		mgr.run(new NullProgressMonitor());
		DeltaContainer deltaContainer = mgr.getDeltaContainer(contributorResource);
		List deltas = deltaContainer.getDeltas();

	}
*/
}
