/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.impl.ExtendedAttributeImpl;

public class AttributeMetadataTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "AttributeMetadataTest";

	public AttributeMetadataTest() {
		super(PROJECT_NAME);
	}

	public AttributeMetadataTest(String name) {
		super(name);
	}

	public void testAttributeMetaData() throws IOException {
		Topology top = createTopology("attributeMetadata");

		// Create a Unit
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		top.getUnits().add(unit1);

		AttributeMetaData manufacturerData = CoreFactory.eINSTANCE
				.createAttributeMetaData();
		manufacturerData.setAttributeName("manufacturer");
		assert !manufacturerData.isEncryptionRequired();
		assert !manufacturerData.isSetEncrypted();
		assert !manufacturerData.isSetMutable();
		assert !manufacturerData.isSetOptional();

		// Manufacturer: mutable
		manufacturerData.setMutable(true);
		assert !manufacturerData.isEncryptionRequired();
		assert !manufacturerData.isSetEncrypted();
		assert manufacturerData.isSetMutable();
		assert !manufacturerData.isSetOptional();

		// Version: encrypted, encrypt, mutable, optional
		AttributeMetaData versionData = CoreFactory.eINSTANCE
				.createAttributeMetaData();
		versionData.setAttributeName("version");
		versionData.setEncrypted(true);
		versionData.setEncryptionRequired(true);
		versionData.setMutable(true);
		versionData.setOptional(true);

		// Version = 1.2
		/*
		 * AT 5/4/2007: Requirement Expressions removed from Attribute Metadata
		 * RequirementExpression versionExpression = CoreFactory.eINSTANCE
		 * .createRequirementExpression();
		 * versionExpression.setInterpreter(Equals.INTERPRETER_ID);
		 * versionExpression.setName("version");
		 * versionExpression.setValue("1.2");
		 * 
		 * assert versionData.getExpressions().size() == 0;
		 * versionData.getExpressions().add(versionExpression);
		 * assertSetEquals(versionData.getExpressions(), new Object[] {
		 * versionExpression });
		 */

		// Add attribute meta-datas to unit.
		assert unit1.getAttributeMetaData().size() == 0;
		assert unit1.getAttributeMetaData(null) == null;
		assert unit1.getAttributeMetaData(manufacturerData.getAttributeName()) == null;
		assert unit1.getAttributeMetaData(versionData.getAttributeName()) == null;
		unit1.getAttributeMetaData().add(manufacturerData);
		unit1.getAttributeMetaData().add(versionData);
		assertSetEquals(unit1.getAttributeMetaData(), new Object[] {
				manufacturerData, versionData });
		assert unit1.getAttributeMetaData(manufacturerData.getAttributeName()) == manufacturerData;
		assert unit1.getAttributeMetaData(versionData.getAttributeName()) == versionData;

		//
		// Test serialization
		//
		top = super.reload(top, true);
		unit1 = (Unit) top.resolve(unit1.getName());
		assert unit1 != null;
		List attrMeta = unit1.getAttributeMetaData();
		assert attrMeta != null;
		assert attrMeta.size() == 2;
		if ("version".equals(((AttributeMetaData) attrMeta.get(0))
				.getAttributeName())) {
			versionData = (AttributeMetaData) attrMeta.get(0);
			manufacturerData = (AttributeMetaData) attrMeta.get(1);
		} else {
			versionData = (AttributeMetaData) attrMeta.get(1);
			manufacturerData = (AttributeMetaData) attrMeta.get(0);
		}
		assert versionData != null;
		assert manufacturerData != null;

		//
		assert manufacturerData.getAttributeName().equals("manufacturer");
		assert !manufacturerData.isEncryptionRequired();
		assert !manufacturerData.isSetEncrypted();
		assert manufacturerData.isSetMutable();
		assert !manufacturerData.isSetOptional();

		//
		assert versionData.getAttributeName().equals("version");

		assert versionData.isEncryptionRequired();
		assert versionData.isEncrypted();
		assert versionData.isMutable();
		assert versionData.isOptional();

		/*
		 * AT 5/4/2007: Requirement Expressions removed from Attribute Metadata
		 * versionExpression = (RequirementExpression) versionData
		 * .getExpressions().get(0); assert
		 * versionExpression.getName().equals("version"); assert
		 * versionExpression.getValue().equals("1.2"); assert
		 * versionExpression.getInterpreter().equals(Equals.INTERPRETER_ID);
		 */
	}

	/** Test the various types allowed in extended attributes 
	 * @throws IOException */
	public void testExtendedAttributes4() throws IOException {
		Topology top = createTopology("testExtendedAttributes4");
		
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("unit1");
		Capability cap1 = CoreFactory.eINSTANCE.createCapability();
		cap1.setName("cap1");
		unit1.getCapabilities().add(cap1);
		top.getUnits().add(unit1);
		
		ExtendedAttribute ea1 = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea1.setValue("String");
		ea1.setName("ea1");
		cap1.getExtendedAttributes().add(ea1);
		
		ExtendedAttribute ea2 = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea2.setValue(Boolean.TRUE);
		ea2.setName("ea2");
		cap1.getExtendedAttributes().add(ea2);
		
		ExtendedAttribute ea3 = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea3.setValue((byte) 3);
		ea3.setName("ea3");
		cap1.getExtendedAttributes().add(ea3);
		
		ExtendedAttribute ea4 = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea4.setValue((short) 4);
		ea4.setName("ea4");
		cap1.getExtendedAttributes().add(ea4);
		
		ExtendedAttribute ea5 = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea5.setValue((int) 5);
		ea5.setName("ea5");
		cap1.getExtendedAttributes().add(ea5);
		
		ExtendedAttribute ea6 = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea6.setValue((long) 6);
		ea6.setName("ea6");
		cap1.getExtendedAttributes().add(ea6);
		
		ExtendedAttribute ea7 = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea7.setValue(BigInteger.valueOf(7));
		ea7.setName("ea7");
		cap1.getExtendedAttributes().add(ea7);
		
		ExtendedAttribute ea8 = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea8.setValue((float) 8.0);
		ea8.setName("ea8");
		cap1.getExtendedAttributes().add(ea8);
		
		ExtendedAttribute ea9 = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea9.setValue((double) 9.0);
		ea9.setName("ea8");
		cap1.getExtendedAttributes().add(ea9);
		
		Resource res = top.getEObject().eResource();
		res.save(null);
		
		assert cap1.getExtendedAttributes().size() == 9;
	}
	
	/** Test setting the type and getting <code>null</code> for the value in response */
	public void testExtendedAttributes3() {
		ExtendedAttribute ea = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea.setInstanceType(XMLTypePackage.eINSTANCE.getString());
		assert ea.getValue() == null;
		ea.setInstanceType(XMLTypePackage.eINSTANCE.getInteger());
		assert ea.getValue() == null;
		ea.setInstanceType(XMLTypePackage.eINSTANCE.getBooleanObject());
		assert ea.getValue() == null;
		ea = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea.setInstanceType(XMLTypePackage.eINSTANCE.getInteger());
		assert ea.getValue() == null;
		ea = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea.setInstanceType(XMLTypePackage.eINSTANCE.getBooleanObject());
		assert ea.getValue() == null;
	}

	/** Test setting the value, then setting it to <code>null</code>, then 
	 * verifying that it is truly <code>null</code>. 
	 */
	public void testExtendedAttributes2() {
		// Test setting the value, then setting it to null, then verifying that it is truly null.
		ExtendedAttribute ea = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea.setValue(Boolean.FALSE);
		ea.setValue(null);
		assert ea.getValue() == null;
		
		ea = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea.setValue(BigInteger.valueOf(0));
		ea.setValue(null);
		assert ea.getValue() == null;
		
		ea = (ExtendedAttribute) CoreFactory.eINSTANCE
		.createExtendedAttribute();
		ea.setValue("");
		assert ((String) ea.getValue()).length() == 0;
		ea.setValue(null);
		assert ea.getValue() == null;
	}
	
	public void testExtendedAttributes() throws IOException {
		Topology top = createTopology("extendedAttributes");

		// Create a Unit
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		//
		// Extended attribute
		//
		final String attrName = "myNewObjectProperty";
		final Integer attrValue = new Integer(4);
		final EDataType attrType = XMLTypePackage.Literals.INT;

		assert unit.getExtendedAttribute(attrName) == null;
		ExtendedAttribute extAttr = (ExtendedAttribute) CoreFactory.eINSTANCE
				.createExtendedAttribute();
		extAttr.setName(attrName);
		extAttr.setInstanceType(attrType);
		// Check if it causes runtime error
		extAttr.getValue();
		extAttr.setValue(attrValue);
		unit.getExtendedAttributes().add(extAttr);

		// Test accessors
		assert extAttr.getName().equals(attrName);
		assert extAttr.getInstanceType().equals(attrType);
		assert extAttr.getValue().equals(attrValue);
		assert extAttr.getContainer().equals(unit);

		assert unit.getExtendedAttributes().size() == 1;
		assert unit.getExtendedAttributes().get(0) == extAttr;
		assert unit.getExtendedAttribute(extAttr.getName()) == extAttr;

		//
		// Test serialization
		//
		top = reload(top, true);

		unit = (Unit) top.resolve("unit");
		assert unit != null;
		assert unit.getExtendedAttributes().size() == 1;
		extAttr = (ExtendedAttributeImpl) unit.getExtendedAttributes().get(0);
		assert extAttr.getName().equals(attrName);
		assert extAttr.getInstanceType().equals(attrType);
		assert extAttr.getValue().equals(attrValue);
		assert extAttr.getContainer().equals(unit);

		//
		// Test non-primitive value (date) serialization
		//
		final Object attrValue2 = XMLTypeFactory.eINSTANCE
				.createDate("2006-05-02Z");
		final EDataType attrType2 = XMLTypePackage.eINSTANCE.getDate();
		try {
			extAttr.setValue(attrValue2);
			assert false;
		} catch (IllegalArgumentException e) {
			// OK -- caught type incompatibility
		}
		assert extAttr.getInstanceType().equals(attrType);
		extAttr.setInstanceType(attrType2);
		assert extAttr.getInstanceType().equals(attrType2) : extAttr
				.getInstanceType();
		extAttr.setValue(attrValue2);
		assert extAttr.getValue().equals(attrValue2) : extAttr.getValue()
				+ " != " + attrValue2;

		top = reload(top, true);

		unit = (Unit) top.resolve("unit");
		assert unit != null;
		assert unit.getExtendedAttributes().size() == 1;
		extAttr = (ExtendedAttributeImpl) unit.getExtendedAttributes().get(0);
		assert extAttr.getName().equals(attrName);
		assert extAttr.getInstanceType().equals(attrType2);
		assert extAttr.getValue().equals(attrValue2);
		assert extAttr.getContainer().equals(unit);
	}
	
	public void testExtendedAttributesAsEAttribute() throws IOException {
		Topology top = createTopology("testExtendedAttributesAsEAttribute");

		// Create a Unit
		Unit unit = CoreFactory.eINSTANCE.createUnit();
		unit.setName("unit");
		top.getUnits().add(unit);

		//
		// Extended attribute
		//
		final String attrName = "myNewObjectProperty";
		final Integer attrValue = new Integer(4);
		final EDataType attrType = XMLTypePackage.Literals.INT_OBJECT;

		assertNull(unit.getExtendedAttribute(attrName));
		ExtendedAttribute extAttr = (ExtendedAttribute) CoreFactory.eINSTANCE
				.createExtendedAttribute();
		extAttr.setName(attrName);
		extAttr.setInstanceType(attrType);
		unit.getExtendedAttributes().add(extAttr);
		
		//Set value
		unit.eSet(extAttr, attrValue);
		assertTrue(unit.eIsSet(extAttr));

		// Test accessors
		assertEquals(attrName, extAttr.getName());
		assertEquals(attrType, extAttr.getInstanceType());
		assertEquals(attrValue, unit.eGet(extAttr));
		assertEquals(unit, extAttr.getContainer());
		
		//Unset
		unit.eUnset(extAttr);
		assertFalse(unit.eIsSet(extAttr));
		unit.eSet(extAttr, attrValue);
		

		assertEquals(1, unit.getExtendedAttributes().size());
		assertEquals(extAttr, unit.getExtendedAttributes().get(0));
		assertEquals(extAttr, unit.getExtendedAttribute(extAttr.getName()));

		//
		// Test serialization
		//
		top = reload(top, true);

		unit = (Unit) top.resolve("unit");
		assertNotNull(unit);
		assertEquals(1, unit.getExtendedAttributes().size());
		extAttr = (ExtendedAttributeImpl) unit.getExtendedAttributes().get(0);
		assertEquals(extAttr, unit.getExtendedAttributes().get(0));
		
		assertEquals(attrName, extAttr.getName());
		assertEquals(attrType, extAttr.getInstanceType());
		assertEquals(attrValue, unit.eGet(extAttr));
		assertEquals(unit, extAttr.getContainer());

		//
		// Test non-primitive value (date) serialization
		//
		final Object attrValue2 = XMLTypeFactory.eINSTANCE
				.createDate("2006-05-02Z");
		final EDataType attrType2 = XMLTypePackage.eINSTANCE.getDate();
		try {
			unit.eSet(extAttr, attrValue2);
			assert false;
		} catch (IllegalArgumentException e) {
			// OK -- caught type incompatibility
		}
		assert extAttr.getInstanceType().equals(attrType);
		extAttr.setInstanceType(attrType2);
		assert extAttr.getInstanceType().equals(attrType2) : extAttr
				.getInstanceType();
		unit.eSet(extAttr, attrValue2);
		assertEquals(attrValue2, unit.eGet(extAttr));

		top = reload(top, true);

		unit = (Unit) top.resolve("unit");		
		assertNotNull(unit);
		assertEquals(1, unit.getExtendedAttributes().size());
		extAttr = (ExtendedAttributeImpl) unit.getExtendedAttributes().get(0);
		assertEquals(extAttr, unit.getExtendedAttributes().get(0));
		
		assertEquals(attrName, extAttr.getName());
		assertEquals(attrType2, extAttr.getInstanceType());
		assertEquals(attrValue2, unit.eGet(extAttr));
		assertEquals(unit, extAttr.getContainer());
	}
}
