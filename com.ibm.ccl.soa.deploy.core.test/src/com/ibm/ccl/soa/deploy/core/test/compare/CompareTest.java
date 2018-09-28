package com.ibm.ccl.soa.deploy.core.test.compare;

import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;

public class CompareTest extends TopologyTestCase {

	public CompareTest(String name) {
		super("testCompareUnits");
		// TODO Auto-generated constructor stub
	}

	public void testCompareUnits() {
//		Topology top = createTopology("compareTopology");
//
//		Unit unit = CoreFactory.eINSTANCE.createUnit();
//		unit.setName("test Unit");
//		top.getUnits().add(unit);
//		try {
//			top.eResource().save(Collections.EMPTY_MAP);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//
//		Resource resource = unit.eResource();
//		try {
//			resource.unload();
//			resource.load(Collections.EMPTY_MAP);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
//		Topology topology2 = root.getTopology();
//		Unit unit2 = (Unit) topology2.getUnits().get(0);
//		Capability capability = CoreFactory.eINSTANCE.createCapability();
//		capability.setName("test Cap");
//		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
//		annotation.setContext("test");
//		unit2.getAnnotations().add(annotation);
//		AttributeMetaData data = CoreFactory.eINSTANCE.createAttributeMetaData();
//		data.setAttributeName("test attribute");
//		capability.getAttributeMetaData().add(data);
//		unit2.getCapabilities().add(capability);
//
//		Resource resource2 = null;
//		try {
//			resource2 = ResourceUtil.getResourceSet().createResource(
//					resource.getURI());
//			resource2.load(Collections.EMPTY_MAP);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		DeployCoreRoot root2 = (DeployCoreRoot) resource2.getContents().get(0);
//		Topology topology = root2.getTopology();
//		Unit unit3 = (Unit) topology.getUnits().get(0);
//
//		// Matching model elements
//		MatchModel match = null;
//		try {
//			match = MatchService.doContentMatch(unit2, unit3, Collections
//					.<String, Object> emptyMap());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// Computing differences
//		final DiffModel diff = DiffService.doDiff(match, false);
//
//		DiffGroup group = (DiffGroup) diff.getOwnedElements().get(0);
//		group.getSubDiffElements();
//		/*
//		 * EStructuralFeature updatedFeature = myUpdateDiff.getAttribute();
//		 * Object oldValue= myUpdateDiff.getLeftElement().eGet(updatedFeature);
//		 * Object newValue= myUpdateDiff.getRightElement().eGet(updatedFeature);
//		 */
//		// Merges all differences from model1 to model2
//		TransactionalEditingDomain ed = TransactionUtil.getEditingDomain(resource2);
//
//		AbstractEMFOperation update = new AbstractEMFOperation(	ed,	"To initialize COMFORT Constraint") {
//
//			@Override
//			protected IStatus doExecute(IProgressMonitor monitor,
//					IAdaptable info) throws ExecutionException {
//				List<DiffElement> differences = new ArrayList<DiffElement>(diff
//						.getOwnedElements());
//				MergeService.merge(differences, true);
//				return org.eclipse.core.runtime.Status.OK_STATUS;
//			}};
//			
//			try {
//				update.execute(new NullProgressMonitor(), null);
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		unit2.getCapabilities();

	}

}
