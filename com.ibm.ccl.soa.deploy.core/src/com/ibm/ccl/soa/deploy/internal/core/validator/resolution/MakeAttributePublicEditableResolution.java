/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.Agreement;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;

/**
 * Resolution to make a unit public
 */
public class MakeAttributePublicEditableResolution extends DeployResolution {

	private final DeployModelObject _object;
	private final String _attributeName;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator that created the resolution
	 * @param description
	 *           a description of the resolution
	 * @param object
	 *           the object to be made public
	 * @param attributeName
	 *           the (short) name of the attribute to be made public-editable
	 */
	public MakeAttributePublicEditableResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, DeployModelObject object,
			String attributeName) {
		super(context, generator, description);
		_object = object;
		_attributeName = attributeName;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		_object.getTopology().getConfigurationContract().export(_object, _attributeName);
//		printContract(_object.getTopology());
		return Status.OK_STATUS;
	}

	private void printContract(Topology t) {
//		Agreement a = t.getConfigurationContract();
		for (Iterator<Unit> units = t.findAllUnits(); units.hasNext();) {
			Unit unit = units.next();
			System.out
					.println("Unit: " + unit.getCaptionProvider().title(unit) + " - " + getVisibility(unit)); //$NON-NLS-1$ //$NON-NLS-2$
			List<Capability> capabilities = unit.getCapabilities();
			for (int i = 0; i < capabilities.size(); i++) {
				Capability c = capabilities.get(i);
				System.out
						.println("   Capability: " + c.getCaptionProvider().title(c) + " - " + getVisibility(c)); //$NON-NLS-1$ //$NON-NLS-2$
				EList<EStructuralFeature> attributes = unit.eClass().getEAllStructuralFeatures();
				for (int j = 0; j < attributes.size(); j++) {
					EStructuralFeature esf = attributes.get(j);
					System.out
							.println("      Attribute: " + esf.getName() + " - " + getVisibility(c, esf)); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
	}

	private String getVisibility(DeployModelObject o) {
		if (null == o) {
			return null;
		}
		Topology t = o.getTopology();
		if (null == t) {
			return null;
		}
		Agreement a = t.getConfigurationContract();
		if (null == a) {
			return null;
		}
		String visibility = "private"; //$NON-NLS-1$
		if (a.isPublicEditable(o)) {
			visibility = "public-editable"; //$NON-NLS-1$
		}
		if (a.isPublic(o)) {
			visibility = "public"; //$NON-NLS-1$
		}
		return visibility;
	}

	private String getVisibility(DeployModelObject o, EStructuralFeature esf) {
		if (null == o) {
			return null;
		}
		Topology t = o.getTopology();
		if (null == t) {
			return null;
		}
		Agreement a = t.getConfigurationContract();
		if (null == a) {
			return null;
		}
		if (null == esf) {
			return null;
		}
		String visibility = ""; //$NON-NLS-1$
		if (a.isPublicEditable(o, esf.getName())) {
			visibility = "public-editable"; //$NON-NLS-1$
		}
		return visibility;
	}

}
