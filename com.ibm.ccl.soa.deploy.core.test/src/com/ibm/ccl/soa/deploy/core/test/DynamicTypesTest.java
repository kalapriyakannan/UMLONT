/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test;

import java.io.IOException;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAdapter;

/**
 * @author daberg
 *
 */
public class DynamicTypesTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "DynamicTypeTestCase"; //$NON-NLS-1$
	
	public DynamicTypesTest() {
		super(PROJECT_NAME);
	}
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	public void testSimpleDynamicTypes() throws IOException {
		EPackage pack = createPackage("Test1", "http://com.acme.types/test1/1.0.0", "tst1");
		assertNotNull(pack);
		EClass docRoot = getOrCreateDocRoot(pack);
		assertNotNull(docRoot);
		//Create Foo unit extinging Unit
		EClass fooClass = createDynamicType(pack, docRoot, "Foo", CorePackage.Literals.UNIT, "unit.foo"); 		
		
		//Add a new capability type
		EClass fooCapClass = createDynamicType(pack, docRoot, "FooCapability", CorePackage.Literals.CAPABILITY, "capability.foo"); 
		//Add attributes
		EAttribute att1 = EcoreFactory.eINSTANCE.createEAttribute();
		att1.setName("attribute1");
		att1.setEType(EcorePackage.Literals.ESTRING);
		fooCapClass.getEStructuralFeatures().add(att1);
		
		EAttribute att2 = EcoreFactory.eINSTANCE.createEAttribute();
		att2.setName("attribute2");
		att2.setEType(EcorePackage.Literals.ESTRING);
		fooCapClass.getEStructuralFeatures().add(att2);
		
		//save resource
		pack.eResource().save(null);
		
		//Create topology
		Topology topology = createTopology("TestTopology");
		
		//Create instance of FooUnit
		Unit fooUnit = (Unit) pack.getEFactoryInstance().create(fooClass);
		fooUnit.setName("unit0");
		fooUnit.setDisplayName("FooTest1");
		topology.getUnits().add(fooUnit);
		//Add fooCapability
		Capability fooCap = (Capability) pack.getEFactoryInstance().create(fooCapClass);
		fooCap.setName("c0");
		fooCap.setDisplayName("BarCapability");
		fooCap.eSet(att1, "bar");
		fooUnit.getCapabilities().add(fooCap);
		
		//Add simple Unit
		Unit unitA = CoreFactory.eINSTANCE.createUnit();
		unitA.setName("unit1");
		unitA.setDisplayName("UnitA");
		topology.getUnits().add(unitA);
		//Add req
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("r0");
		req.setDisplayName("fooReq");
		req.setDmoEType(fooCapClass);
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		RequirementExpression exp = CoreFactory.eINSTANCE.createRequirementExpression();
		exp.setName("Constraint1");
		exp.setInterpreter("Equals");
		exp.setAttributeName("attribute1");
		exp.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		exp.setValue("foo");
		req.getConstraints().add(exp);
		unitA.getRequirements().add(req);
		
		//Create link
		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName("dl0");
		link.setTarget(fooCap);
		req.setLink(link);
		
		save(topology);
		
		DeployValidatorService.getDefaultValidatorService().validate(topology);
		
		//An error should exist on the fooCap for bad attribute value match.
		assertFalse(fooCap.getStatus().isOK());
		
		Resource res = topology.eResource();
		
		res.unload();
		
		res.load(null);
		
		topology = getTopology(res);
		
		assertNotNull(topology);
		
		assertEquals(2, topology.getUnits().size());
		
		unitA = (Unit) topology.resolve("unit1");
		
		assertNotNull(unitA);
		
		assertEquals(1, unitA.getRequirements().size());
		
		req = (Requirement) unitA.getRequirements().get(0);
		
		link = req.getLink();
		
		assertNotNull(link);
		
		fooCap = link.getTarget();
		
		assertNotNull(fooCap);
		
		String capValue = (String) fooCap.eGet(att1);
		
		assertEquals("bar", capValue);
		
		//Fix value
		fooCap.eSet(att1, "foo");
		
		
		DeployValidatorService.getDefaultValidatorService().validate(topology);
		
		//An error should exist on the fooCap for bad attribute value match.
		assertTrue(fooCap.getStatus().isOK());				
	}
	
	public void testSimpleDynamicTypeLoadWithRemovedAttribute() throws IOException {
		EPackage pack = createPackage("Test2", "http://com.acme.types/test2/1.0.0", "tst2");
		assertNotNull(pack);
		EClass docRoot = getOrCreateDocRoot(pack);
		assertNotNull(docRoot);
		//Create Foo unit extinging Unit
		EClass fooClass = createDynamicType(pack, docRoot, "Foo", CorePackage.Literals.UNIT, "unit.foo"); 		
		
		//Add a new capability type
		EClass fooCapClass = createDynamicType(pack, docRoot, "FooCapability", CorePackage.Literals.CAPABILITY, "capability.foo"); 
		//Add attributes
		EAttribute att1 = EcoreFactory.eINSTANCE.createEAttribute();
		att1.setName("attribute1");
		att1.setEType(EcorePackage.Literals.ESTRING);
		fooCapClass.getEStructuralFeatures().add(att1);
		
		EAttribute att2 = EcoreFactory.eINSTANCE.createEAttribute();
		att2.setName("attribute2");
		att2.setEType(EcorePackage.Literals.ESTRING);
		fooCapClass.getEStructuralFeatures().add(att2);
		
		//save resource
		pack.eResource().save(null);
		
		//Create topology
		Topology topology = createTopology("TestTopology");
		
		//Create instance of FooUnit
		Unit fooUnit = (Unit) pack.getEFactoryInstance().create(fooClass);
		fooUnit.setName("unit0");
		fooUnit.setDisplayName("FooTest1");
		topology.getUnits().add(fooUnit);
		//Add fooCapability
		Capability fooCap = (Capability) pack.getEFactoryInstance().create(fooCapClass);
		fooCap.setName("c0");
		fooCap.setDisplayName("BarCapability");
		fooCap.eSet(att1, "bar");
		fooUnit.getCapabilities().add(fooCap);
		
		//Add simple Unit
		Unit unitA = CoreFactory.eINSTANCE.createUnit();
		unitA.setName("unit1");
		unitA.setDisplayName("UnitA");
		topology.getUnits().add(unitA);
		//Add req
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("r0");
		req.setDisplayName("fooReq");
		req.setDmoEType(fooCapClass);
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		RequirementExpression exp = CoreFactory.eINSTANCE.createRequirementExpression();
		exp.setName("Constraint1");
		exp.setInterpreter("Equals");
		exp.setAttributeName("attribute1");
		exp.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
		exp.setValue("bar");
		req.getConstraints().add(exp);
		unitA.getRequirements().add(req);
		
		//Create link
		DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
		link.setName("dl0");
		link.setTarget(fooCap);
		req.setLink(link);
		
		save(topology);
		
		DeployValidatorService.getDefaultValidatorService().validate(topology);
		
		assertTrue(fooCap.getStatus().isOK());
		
		Resource res = topology.eResource();
		
		res.unload();
		
		res.load(null);
		
		topology = getTopology(res);
		
		assertNotNull(topology);
		
		assertEquals(2, topology.getUnits().size());
		
		unitA = (Unit) topology.resolve("unit1");
		
		assertNotNull(unitA);
		
		assertEquals(1, unitA.getRequirements().size());
		
		req = (Requirement) unitA.getRequirements().get(0);
		
		link = req.getLink();
		
		assertNotNull(link);
		
		fooCap = link.getTarget();
		
		assertNotNull(fooCap);
		
		String capValue = (String) fooCap.eGet(att1);
		
		assertEquals("bar", capValue);
		
		res.unload();
		
		//Remove attribute from package.
		fooCapClass.getEStructuralFeatures().remove(att1);
		//save package
		pack.eResource().save(null);
		
		//It should not fail to load.
		res.load(null);
				
	}
	
	private EPackage createPackage(String name, String uri, String prefix) throws IOException {
		EPackage pack = EcoreFactory.eINSTANCE.createEPackage();
		pack.setName(name);
		pack.setNsURI(uri);
		pack.setNsPrefix(prefix);
		
		//Create resource
		Resource resource = new EcoreResourceFactoryImpl().createResource(URI.createPlatformResourceURI("/" + getProject().getName() + "/" + name + ".ecore", false));
		resource.getContents().add(pack);
		
		assertTrue(getProject().exists());
		assertTrue(getProject().isAccessible());
		
	//	System.out.println(getProject().getName());
		
		resource.save(null);
		
		//Register the new package
		registerPackage(pack);
		
		return pack;
	}
	
	private EClass getOrCreateDocRoot(EPackage pack) {
		EClass docRoot = FeatureAdapter.getDocumentRootForPackage(pack);
		if (docRoot == null) {
			//create docroot
			docRoot = EcoreFactory.eINSTANCE.createEClass();
			docRoot.setName("GlobalElementDocRoot");
			EAnnotation annotation = createEcoreAnnotation();
			docRoot.getEAnnotations().add(annotation);
			annotation.getDetails().put("name", "");
			annotation.getDetails().put("kind", "mixed");
			pack.getEClassifiers().add(docRoot);
		}
		return docRoot;
	}
	
	private EAnnotation createEcoreAnnotation() {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("http:///org/eclipse/emf/ecore/util/ExtendedMetaData");
		return annotation;
	}
	
	private EClass createDynamicType(EPackage pack, EClass docRoot, String name, EClass superType, String elementName) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		eClass.getESuperTypes().add(superType);
		pack.getEClassifiers().add(eClass);
		//Setup docRoot
		EReference eClassRef = EcoreFactory.eINSTANCE.createEReference();
		eClassRef.setName(name + "Ref");
		eClassRef.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		eClassRef.setEType(eClass);
		eClassRef.setChangeable(true);
		eClassRef.setVolatile(true);
		eClassRef.setTransient(true);
		eClassRef.setDerived(true);
		eClassRef.setContainment(true);
		eClassRef.setResolveProxies(false);
		docRoot.getEReferences().add(eClassRef);
		//Add annotation for substitution
		EAnnotation annotation = createEcoreAnnotation();
		eClassRef.getEAnnotations().add(annotation);
		EMap<String, String> details = annotation.getDetails();
		details.put("kind", "element");
		details.put("name", elementName);
		details.put("namespace", "##targetNamespace");
		if (superType.isSuperTypeOf(CorePackage.Literals.UNIT)) {
			details.put("affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit");
		} else if (superType.isSuperTypeOf(CorePackage.Literals.CAPABILITY)) {
			details.put("affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability");
		}
		return eClass;
	}
	
	private void registerPackage(EPackage pack) {
		Registry.INSTANCE.put(pack.getNsURI(), pack);
	}

}
