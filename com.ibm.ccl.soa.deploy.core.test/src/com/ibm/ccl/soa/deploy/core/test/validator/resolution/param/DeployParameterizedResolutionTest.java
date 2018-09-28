/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.validator.resolution.param;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel;
import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.DeployResolutionParameterValueDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployParameterizedResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameterValueDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.SetAttributeResolution;

/**
 * Tests the parameterization of resolutions.
 * 
 * @see IDeployParameterizedResolution
 * @see IDeployResolutionParameter
 * @see IDeployResolutionEnumParameter
 */
public class DeployParameterizedResolutionTest extends TopologyTestCase {

	public DeployParameterizedResolutionTest() {
		super("DeployParameterizedResolutionTest");
	}

	/**
	 * Tests {@link ResolutionDataModel} and {@link ResolutionAttributeDataModel}.
	 * 
	 * @throws Exception
	 * @see TestSetAttributeResolution
	 */
	public void testResolutionAttributeDataModel() throws Exception {
		Topology top = createTopology("testResolutionAttributeDataModel");
		Unit unit = addUnit(top, "unit");
		
		ResolutionAttributeDataModel aModel = ResolutionAttributeDataModel.createModel();
		ResolutionDataModel model = aModel.getResolutionDataModel();

		//
		assertTrue(model.validateDescription().isOK());
		model.setDescription("Test parameter");
		assertEquals("Test parameter", model.getDescription());
		assertTrue(model.validateDescription().isOK());

		//
		assertTrue(!model.validateName().isOK());
		model.setName("myparam");
		assertEquals("myparam", model.getName());
		assertTrue(model.validateName().isOK());

		//
		assertTrue(!model.validateResolution().isOK());
		EAttribute attribute = CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION;
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.ERROR, "fake validator", "fake problem", "not really a problem", null, unit, attribute);
		IDeployResolutionContext context = new DeployResolutionContext(status, null, null);
		SetAttributeResolution resolution = new SetAttributeResolution(context, null);
		model.setResolution(resolution);
		assertEquals(resolution, model.getResolution());
		assertTrue(model.validateResolution().isOK());
		
		//
		assertTrue(!model.validateType().isOK());
		model.setType(String.class);
		assertEquals(String.class, model.getType());
		assertTrue(model.validateType().isOK());

		//
		assertTrue(model.validateValue().isOK());
		model.setValue(new Integer(1));
		assertEquals(new Integer(1), model.getValue());
		assertTrue(!model.validateValue().isOK());
		model.setValue("value");
		assertEquals("value", model.getValue());
		assertTrue(model.validateValue().isOK());
		
		//
		assertTrue(model.validateValueSet().isOK());
		model.setValueSet(false);
		assertTrue(!model.getValueSet());
		assertTrue(model.validateValueSet().isOK());

		model.setValueSet(true);
		assertTrue(model.getValueSet());
		assertTrue(model.validateValueSet().isOK());

		//
		assertTrue(model.validateValidValues().isOK());
		DeployResolutionParameterValueDescriptor descrOK = new DeployResolutionParameterValueDescriptor("value1", "value 1 description");
		List<IDeployResolutionParameterValueDescriptor> list = new ArrayList<IDeployResolutionParameterValueDescriptor>();
		list.add(descrOK);
		model.setValidValues(list);
		assertTrue(model.validateValidValues().isOK());
		
		//
		assertTrue(model.validateValidValueListExclusive().isOK());
		model.setValidValueListExclusive(true);
		assertTrue(!model.validateValue().isOK());
		model.setValue(descrOK.getValue());
		assertTrue(model.validateValue().isOK());
		model.setValue("value");
		
		assertTrue(model.validateValidValueListExclusive().isOK());
		model.setValidValueListExclusive(false);
		assertTrue(model.validateValue().isOK());
		assertTrue(model.validateValidValueListExclusive().isOK());

		//
		assertTrue(!aModel.validateDeployModelObject().isOK());
		aModel.setDeployModelObject(unit);
		assertTrue(aModel.validateDeployModelObject().isOK());

		//
		assertTrue(!aModel.validateAttributeName().isOK());
		aModel.setAttributeName("nonexistentattribute");
		assertTrue(!aModel.validateAttributeName().isOK());
		aModel.setAttributeName(attribute.getName());
		assertTrue(aModel.validateAttributeName().isOK());
		
		//
		assertTrue(aModel.validateAttribute().isOK());
		aModel.setAttribute(CorePackage.Literals.CAPABILITY__ORIGIN);
		assertTrue(!aModel.validateAttribute().isOK());
		aModel.setAttribute(attribute);
		assertTrue(aModel.validateAttribute().isOK());
		
		//
		IStatus s = aModel.validate();
		assertTrue(getString(s), s.isOK());
	}

	/**
	 * Test the parameterized resolution.
	 * 
	 * @throws Exception
	 * @see TestSetAttributeResolution
	 */
	public void testSetAttributeResolution() throws Exception {
		IProgressMonitor monitor = new NullProgressMonitor();
		// Create topology
		Topology top = createTopology("testSetAttributeResolution");
		Unit unit = addUnit(top, "u1");
		addCapability(unit, "cap1", CapabilityLinkTypes.HOSTING_LITERAL);
		save(top);
		validate(top);
		assertHasNoErrorStatus(top);

		// Create undefined status on description
		EAttribute attribute = CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION;
		IDeployAttributeStatus descrStatus = DeployCoreStatusFactory.INSTANCE
				.createAttributeStatus(IStatus.ERROR,
						this.getClass().getName(),
						ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED, "unbound",
						null, unit, attribute);
		unit.addStatus(descrStatus);

		// Find parameterized set attribute resolution
		List<IDeployResolution> resolutions = getValidatorService()
				.getResolutions(descrStatus);
		SetAttributeResolution resolution = null;
		for (IDeployResolution cur : resolutions) {
			if (cur instanceof SetAttributeResolution) {
				resolution = (SetAttributeResolution) cur;
			}
		}
		assertNotNull("Could not find DeploySetAttributeResolution resolution",
				resolution);

		// Find resolution parameter
		assertEquals(1, resolution.getParameters().size());
		ResolutionAttributeDataModel attributeDataModel = resolution
				.getAttributeDataModel();
		ResolutionDataModel resolutionDataModel = attributeDataModel
				.getResolutionDataModel();
		assertEquals(String.class, resolutionDataModel.getType());
		assertEquals(attribute.getName(), attributeDataModel.getAttributeName());
		assertEquals(unit, attributeDataModel.getDeployModelObject());
		assertEquals(attribute, attributeDataModel.getAttribute());

		// Set description parameter (wrong type)
		resolutionDataModel.setValue(new Integer(1));
		assertTrue(!attributeDataModel.validate().isOK());

		// Set description parameter (right type)
		String descr = "my description";
		resolutionDataModel.setValue(descr);
		IStatus status = attributeDataModel.validate();
		assertTrue(status.toString(), status.isOK());

		// Resolve and verify that the unit description has changed
		assertEquals(null, unit.getDescription());
		resolution.resolveWithParameters(monitor);
		assertTrue(status.toString(), status.isOK());
		assertEquals(descr, unit.getDescription());

		// Test exclusive valid values.
		String specialDescr = "special description";
		List<IDeployResolutionParameterValueDescriptor> validValuesList = new LinkedList<IDeployResolutionParameterValueDescriptor>();
		validValuesList.add(new DeployResolutionParameterValueDescriptor(specialDescr));
		resolutionDataModel.setValidValues(validValuesList);
		resolutionDataModel.setValidValueListExclusive(true);
		assertTrue(!resolutionDataModel.validate().isOK());
		
		resolutionDataModel.setValidValueListExclusive(false);
		assertTrue(resolutionDataModel.validate().isOK());
		resolutionDataModel.setValidValueListExclusive(true);

		resolutionDataModel.setValue(specialDescr);
		assertTrue(resolutionDataModel.validate().isOK());

		status = resolution.resolveWithParameters(monitor);
		assertTrue(status.toString(), status.isOK());
		assertEquals(specialDescr, unit.getDescription());
	}
}
