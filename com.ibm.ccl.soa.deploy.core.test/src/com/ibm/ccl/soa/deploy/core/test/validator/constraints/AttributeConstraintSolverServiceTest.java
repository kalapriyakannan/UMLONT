package com.ibm.ccl.soa.deploy.core.test.validator.constraints;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.AssertionFailedError;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AndConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;
import com.ibm.ccl.soa.deploy.core.constraint.XorConstraint;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.constraints.AttributeConstraintSolverService;
import com.ibm.ccl.soa.deploy.core.validator.constraints.AttributeValues;
import com.ibm.ccl.soa.deploy.core.validator.constraints.AttributeValuesRange;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Tests {@link AttributeConstraintSolverService}
 */
public class AttributeConstraintSolverServiceTest extends TopologyTestCase {

	public AttributeConstraintSolverServiceTest() {
		super(AttributeConstraintSolverServiceTest.class.getSimpleName());
	}

	/**
	 * Tests {@link AttributeValuesRange}
	 */
	public void testAttributeValueRanges() {
		AttributeValuesRange r11to20 = new AttributeValuesRange(10, false, 20,
				true);
		// Test accessors
		assertEquals(10, r11to20.getMin());
		assertFalse(r11to20.isMinInclusive());
		assertEquals(20, r11to20.getMax());
		assertTrue(r11to20.isMaxInclusive());
		// Test range operations
		assertFalse(r11to20.isValueInRange(null));
		assertFalse(r11to20.isValueInRange(9));
		assertFalse(r11to20.isValueInRange(10));
		assertTrue(r11to20.isValueInRange(11));
		assertTrue(r11to20.isValueInRange(15));
		assertTrue(r11to20.isValueInRange(20));
		assertFalse(r11to20.isValueInRange(21));

		assertEquals(r11to20, r11to20);
		assertEquals(0, r11to20.compareTo(r11to20));
		assertEquals(r11to20, new AttributeValuesRange(10, false, 20, true));
		assertEquals(r11to20, new AttributeValuesRange(11, true, 20, true));
		assertEquals(r11to20, new AttributeValuesRange(11, true, 21, false));
		assertEquals(r11to20, new AttributeValuesRange(10, false, 21, false));
		assertFalse(r11to20
				.equals(new AttributeValuesRange(10, true, 20, true)));
		assertFalse(r11to20.equals(new AttributeValuesRange(10, false, 20,
				false)));

		//
		// Range comparisons
		//
		AttributeValuesRange rMinToMax = new AttributeValuesRange(null, true,
				null, true);
		AttributeValuesRange rMinTo5 = new AttributeValuesRange(null, true, 5,
				true);
		AttributeValuesRange r0to5 = new AttributeValuesRange(0, true, 5, true);
		AttributeValuesRange r5to15 = new AttributeValuesRange(5, true, 15,
				true);
		AttributeValuesRange r15to25 = new AttributeValuesRange(15, true, 25,
				true);
		AttributeValuesRange r25to35 = new AttributeValuesRange(25, true, 35,
				true);
		AttributeValuesRange r30toMax = new AttributeValuesRange(30, true,
				null, true);

		List<AttributeValuesRange> list = new ArrayList<AttributeValuesRange>();
		list.add(rMinToMax);
		list.add(rMinTo5);
		list.add(r0to5);
		list.add(r5to15);
		list.add(r11to20);
		list.add(r15to25);
		list.add(r25to35);
		list.add(r30toMax);
		Collections.sort(list);

		assertListEquals(list.iterator(), new Object[] { rMinTo5, rMinToMax,
				r0to5, r5to15, r11to20, r15to25, r25to35, r30toMax });

		//
		// Overlap
		//
		assertTrue(rMinToMax.overlaps(rMinTo5));
		assertTrue(rMinToMax.overlaps(r0to5));
		assertTrue(rMinToMax.overlaps(r30toMax));
		assertTrue(rMinToMax.overlaps(rMinToMax));

		assertTrue(rMinTo5.overlaps(r0to5));
		assertTrue(rMinTo5.overlaps(r5to15));
		assertFalse(rMinTo5.overlaps(r11to20));
		assertFalse(r11to20.overlaps(rMinTo5));
		assertFalse(r11to20.overlaps(r30toMax));
		assertFalse(r11to20.overlaps(new AttributeValuesRange(10, true, 10,
				true)));

		//
		// Empty
		//
		assertFalse(rMinToMax.isEmpty());
		assertFalse(rMinTo5.isEmpty());
		assertFalse(r5to15.isEmpty());
		assertFalse(r30toMax.isEmpty());
		assertTrue(new AttributeValuesRange(20, true, 10, true).isEmpty());
		assertTrue(new AttributeValuesRange(10, false, 10, false).isEmpty());
		assertTrue(new AttributeValuesRange(10, false, 11, false).isEmpty());

		//
		// Add
		//
		AttributeValuesRange r5to25 = new AttributeValuesRange(5, true, 15,
				true);
		r5to25.add(r15to25);
		assertEquals(5, r5to25.getMin());
		assertTrue(r5to25.isMinInclusive());
		assertEquals(25, r5to25.getMax());
		assertTrue(r5to25.isMaxInclusive());

		//
		// Subtract
		//
		AttributeValuesRange r0to5b = new AttributeValuesRange(null, true, 100,
				false);
		r0to5b.subtract(r0to5);
		assertEquals(r0to5b, r0to5);

		AttributeValuesRange r0to3 = new AttributeValuesRange(-100, false, 3,
				true);
		r0to3.subtract(r0to5);
		assertEquals(r0to3, new AttributeValuesRange(0, true, 3, true));

		AttributeValuesRange r3to5 = new AttributeValuesRange(2, false, null,
				true);
		r3to5.subtract(r0to5);
		assertEquals(r3to5, new AttributeValuesRange(3, true, 5, true));
	}

	/**
	 * Tests {@link AttributeValuesRange#prevValue(Comparable)} and
	 * {@link AttributeValuesRange#nextValue(Comparable)}
	 * 
	 */
	public void testAttributeValueRangesPrevNext() {
		assertEquals(Integer.MIN_VALUE, AttributeValuesRange
				.prevValue(Integer.MIN_VALUE));
		assertEquals(-1, AttributeValuesRange.prevValue(0));
		assertEquals(Integer.MAX_VALUE - 1, AttributeValuesRange
				.prevValue(Integer.MAX_VALUE));

		assertEquals(Integer.MIN_VALUE + 1, AttributeValuesRange
				.nextValue(Integer.MIN_VALUE));
		assertEquals(1, AttributeValuesRange.nextValue(0));
		assertEquals(Integer.MAX_VALUE, AttributeValuesRange
				.nextValue(Integer.MAX_VALUE));

		String min = Character.toString(Character.MIN_VALUE);
		String max = Character.toString(Character.MAX_VALUE);

		assertEquals("", AttributeValuesRange.prevValue(""));
		assertEquals("", AttributeValuesRange.prevValue(min));
		assertEquals("a", AttributeValuesRange.prevValue("b"));

		assertEquals(min, AttributeValuesRange.nextValue(""));
		assertEquals("c", AttributeValuesRange.nextValue("b"));
		assertEquals(max + min, AttributeValuesRange.nextValue(max));

		assertEquals("a" + max, AttributeValuesRange.prevValue("b" + min));
		assertEquals("b" + min, AttributeValuesRange.nextValue("a" + max));
	}

	/**
	 * Tests {@link EqualsConstraint}.
	 */
	public void testEqualsValidValues() throws IOException {
		Topology top = createTopology("testEqualsValidValues");
		Unit u1 = addUnit(top, "u1");
		EAttribute attr = CorePackage.eINSTANCE
				.getDeployModelObject_Description();

		EqualsConstraint equalsC1 = ConstraintFactory.eINSTANCE
				.createEqualsConstraint();
		equalsC1.setName("equals1");
		equalsC1.setAttributeName(attr.getName());
		equalsC1.setValue("a");
		save(top);

		AttributeConstraintSolverService s = AttributeConstraintSolverService
				.getInstance();

		//
		// Equals(a)
		//
		u1.getConstraints().add(equalsC1);

		assertValidValues(s.getValidValues(u1, CorePackage.eINSTANCE
				.getDeployModelObject_Description()), new Object[] { "a" },
				true);
		validate(top);
		IDeployAttributeStatus status = getAttributeStatus(u1, attr);
		assertValidValues(s.getValidValues(status), new Object[] { "a" }, true);

		// Cleanup constraint containment
		u1.getConstraints().remove(equalsC1);

		//
		// Equals(a), Equals(a)
		// 
		EqualsConstraint equalsC2 = ConstraintFactory.eINSTANCE
				.createEqualsConstraint();
		equalsC2.setName("equals2");
		equalsC2.setAttributeName(attr.getName());
		equalsC2.setValue("a");

		u1.getConstraints().add(equalsC1);
		u1.getConstraints().add(equalsC2);
		save(top);

		assertValidValues(s.getValidValues(u1, CorePackage.eINSTANCE
				.getDeployModelObject_Description()), new Object[] { "a" },
				true);
		assertSetEquals(u1.getConstraints(),
				new Object[] { equalsC1, equalsC2 });
		validate(top);
		status = getAttributeStatus(u1, attr);
		assertValidValues(s.getValidValues(status), new Object[] { "a" }, true);

		// Cleanup constraint containment
		u1.getConstraints().remove(equalsC1);
		u1.getConstraints().remove(equalsC2);

		//
		// Or (And (Equals(a), Equals(a)))
		// 
		OrConstraint orCforAnd = ConstraintFactory.eINSTANCE
				.createOrConstraint();
		orCforAnd.setName("orForAnd");
		u1.getConstraints().add(orCforAnd);

		AndConstraint andC = ConstraintFactory.eINSTANCE.createAndConstraint();
		andC.setName("and");
		orCforAnd.getConstraints().add(andC);

		andC.getConstraints().add(equalsC1);
		andC.getConstraints().add(equalsC2);
		save(top);

		assertValidValues(s.getValidValues(u1, CorePackage.eINSTANCE
				.getDeployModelObject_Description()), new Object[] { "a" },
				true);
		validate(top);
		status = getAttributeStatus(u1, attr);
		assertValidValues(s.getValidValues(status), new Object[] { "a" }, true);

		// And (Equals(a), Equals(b))
		equalsC2.setValue("b");
		save(top);
		assertValidValues(s.getValidValues(u1, CorePackage.eINSTANCE
				.getDeployModelObject_Description()), new Object[] {}, true);
		validate(top);
		status = getAttributeStatus(u1, attr);
		assertValidValues(s.getValidValues(status), new Object[] {}, true);

		// Cleanup constraint containment
		u1.getConstraints().remove(orCforAnd);
		orCforAnd.getConstraints().remove(andC);
		andC.getConstraints().remove(equalsC1);
		andC.getConstraints().remove(equalsC2);

		//
		// OR (Equals(a), Equals(b))
		// 
		OrConstraint orC = ConstraintFactory.eINSTANCE.createOrConstraint();
		orC.setName("or");
		u1.getConstraints().add(orC);

		equalsC1.setValue("a");
		equalsC2.setValue("b");

		orC.getConstraints().add(equalsC1);
		orC.getConstraints().add(equalsC2);
		save(top);

		assertValidValues(s.getValidValues(u1, CorePackage.eINSTANCE
				.getDeployModelObject_Description()),
				new Object[] { "a", "b" }, true);
		validate(top);
		status = getAttributeStatus(u1, attr);
		assertValidValues(s.getValidValues(status), new Object[] { "a", "b" },
				true);

		// Cleanup constraint containment
		u1.getConstraints().remove(orC);
		orC.getConstraints().remove(equalsC1);
		orC.getConstraints().remove(equalsC2);

		//
		// XOR (Equals(a), Equals(b))
		// 
		XorConstraint xorC = ConstraintFactory.eINSTANCE.createXorConstraint();
		xorC.setName("xor");
		u1.getConstraints().add(xorC);

		equalsC1.setValue("a");
		equalsC2.setValue("b");

		xorC.getConstraints().add(equalsC1);
		xorC.getConstraints().add(equalsC2);

		assertValidValues(s.getValidValues(u1, CorePackage.eINSTANCE
				.getDeployModelObject_Description()),
				new Object[] { "a", "b" }, true);
		validate(top);
		status = getAttributeStatus(u1, attr);
		assertValidValues(s.getValidValues(status), new Object[] { "a", "b" },
				true);

		// Cleanup constraint containment
		u1.getConstraints().remove(xorC);
		xorC.getConstraints().remove(equalsC1);
		xorC.getConstraints().remove(equalsC2);
	}

	/**
	 * Tests {@link EnumerationConstraint} with Integer values.
	 */
	public void testEnumerationIntegerValidValues() throws IOException {
		Topology top = createTopology("testEnumerationIntegerValidValues");
		Unit u1 = addUnit(top, "u1");
		CommunicationCapability c1 = CoreFactory.eINSTANCE
				.createCommunicationCapability();
		c1.setName("c1");
		u1.getCapabilities().add(c1);

		BigInteger one = BigInteger.ONE;
		BigInteger two = BigInteger.valueOf(2);

		EAttribute attr = CorePackage.eINSTANCE
				.getCommunicationCapability_Port();
		EnumerationConstraint enumC1 = ConstraintFactory.eINSTANCE
				.createEnumerationConstraint();
		enumC1.setName("enum1");
		enumC1.setAttributeName(attr.getName());
		enumC1.getValues().add(createSingleValue(one));
		enumC1.getValues().add(createSingleValue(two));
		save(top);

		AttributeConstraintSolverService s = AttributeConstraintSolverService
				.getInstance();
		//
		// Enum(1, 2) : c1.port = null
		//
		c1.getConstraints().add(enumC1);

		assertValidValues(s.getValidValues(c1, attr),
				new Object[] { one, two }, true);
		validate(top);
		IDeployAttributeStatus status = getAttributeStatus(c1, attr);
		assertValidValues(s.getValidValues(status), new Object[] { one, two },
				true);

		// Enum(1, 2) : c1.port = 1
		c1.setPort(BigInteger.ONE);
		validate(top);
		assertEquals(Status.OK_STATUS, c1.getStatus());

		// Enum(1, 2) : c1.port = 3
		c1.setPort(BigInteger.valueOf(3));
		validate(top);
		status = getAttributeStatus(c1, attr);
		assertValidValues(s.getValidValues(status), new Object[] { one, two },
				true);

		// Cleanup constraint containment
		c1.getConstraints().remove(enumC1);
	}

	/**
	 * Tests {@link EnumerationConstraint} with EMF enumeratino values.
	 */
	public void testEnumerationEnumValidValues() throws IOException {
		Topology top = createTopology("testEnumerationEnumValidValues");
		Unit u1 = addUnit(top, "u1");

		EAttribute attr = CorePackage.eINSTANCE.getUnit_InitInstallState();
		EnumerationConstraint enumC1 = ConstraintFactory.eINSTANCE
				.createEnumerationConstraint();
		enumC1.setName("enum1");
		enumC1.setAttributeName(attr.getName());
		InstallState v1 = InstallState.INSTALLED_LITERAL;
		InstallState v2 = InstallState.NOT_INSTALLED_LITERAL;
		enumC1.getValues().add(createSingleValue(v1));
		enumC1.getValues().add(createSingleValue(v2));
		save(top);

		AttributeConstraintSolverService s = AttributeConstraintSolverService
				.getInstance();
		//
		// Enum(INSTALLED, NOT_INSTALLED) : u1.initInstallState = UNKNOWN
		//
		u1.getConstraints().add(enumC1);

		assertValidValues(s.getValidValues(u1, attr), new Object[] { v1, v2 },
				true);
		validate(top);
		IDeployAttributeStatus status = getAttributeStatus(u1, attr);
		assertValidValues(s.getValidValues(status), new Object[] { v1, v2 },
				true);

		// Enum(INSTALLED, NOT_INSTALLED) : u1.initInstallState = INSTALLED
		u1.setInitInstallState(v1);
		validate(top);
		status = null;
		try {
			status = getAttributeStatus(u1, attr);
		} catch (AssertionFailedError e) {
			// OK to ignore
		}
		if (status != null) {
			fail(getString(status));
		}

		// Cleanup constraint containment
		u1.getConstraints().remove(enumC1);
	}

	protected IDeployAttributeStatus getAttributeStatus(DeployModelObject obj,
			EAttribute attr) {

		for (DeployStatusIterator iter = new DeployStatusIterator(obj); iter
				.hasNext();) {
			IDeployStatus status = iter.next();
			if ((status instanceof IDeployAttributeStatus)
					&& attr.equals(((IDeployAttributeStatus) status)
							.getAttributeType())) {
				return (IDeployAttributeStatus) status;
			}
		}

		fail(obj.getName() + "." + attr.getName() + "\n"
				+ dumpStatus(obj.getTopology()));
		return null;
	}

	protected void assertValidValues(AttributeValues values, Object[] expected,
			boolean expectedExhaustive) {
		assertSetEquals(values.getValidValues(), expected);
		assertEquals(expectedExhaustive, values.isValidValuesExclusive());
	}

	protected SingleValue createSingleValue(Object value) {
		SingleValue sv = ConstraintFactory.eINSTANCE.createSingleValue();
		sv.setValueObject(value);
		sv.setDescription(value == null ? "null" : value.toString());
		return sv;
	}
}
