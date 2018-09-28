/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Resolves attribute undefined errors for
 * {@link AttributePropagationConstraint#getSourceAttributeName()} and
 * {@link AttributePropagationConstraint#getTargetAttributeName()}
 */
public class AttributePropagationResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployAttributeStatus aStatus = (IDeployAttributeStatus) context.getDeployStatus();
		Endpoints pair = getPropagationEndpoints(aStatus);

		List<AttributePropagationEndpointResolution> result = new ArrayList<AttributePropagationEndpointResolution>();
		DeployModelObject object = null;
		boolean isSource;
		if (ConstraintPackage.eINSTANCE.getAttributePropagationConstraint_TargetAttributeName()
				.equals(aStatus.getAttributeType())) {
			object = pair.target;
			isSource = false;
		} else if (ConstraintPackage.eINSTANCE
				.getAttributePropagationConstraint_SourceAttributeName().equals(
						aStatus.getAttributeType())) {
			object = pair.source;
			isSource = true;
		} else {
			return EMPTY_RESOLUTION_ARRAY;
		}

		addResolutions(context, object, isSource, result);

		if (object instanceof Unit) {
			for (Capability cap : (List<Capability>) ((Unit) object).getCapabilities()) {
				addResolutions(context, cap, isSource, result);
			}
			for (Artifact artifact : (List<Artifact>) ((Unit) object).getArtifacts()) {
				addResolutions(context, artifact, isSource, result);
			}
		}

		if (result.size() == 0) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		Collections.sort(result, new Comparator<AttributePropagationEndpointResolution>() {
			public int compare(AttributePropagationEndpointResolution o1,
					AttributePropagationEndpointResolution o2) {
				return o2.getDescription().compareToIgnoreCase(o1.getDescription());
			}
		});
		return result.toArray(new IDeployResolution[result.size()]);
	}

	private void addResolutions(IDeployResolutionContext context, DeployModelObject object,
			boolean isSource, List<AttributePropagationEndpointResolution> resolutions) {
		// EAttributes
		for (EAttribute attr : object.eClass().getEAllAttributes()) {
			if (attr.getEContainingClass().equals(CorePackage.eINSTANCE.getDeployModelObject())) {
				continue;
			}
			if (attr.getEContainingClass().equals(CorePackage.eINSTANCE.getCapability())) {
				continue;
			}
			if (attr.getEContainingClass().equals(CorePackage.eINSTANCE.getUnit())) {
				continue;
			}
			if (attr.getEContainingClass().equals(CorePackage.eINSTANCE.getRequirement())) {
				continue;
			}
			resolutions.add(new AttributePropagationEndpointResolution(context, object,
					attr.getName(), isSource, this));
		}
		// Extended attributes
		for (ExtendedAttribute attr : (List<ExtendedAttribute>) object.getExtendedAttributes()) {
			if (attr.getName() != null) {
				resolutions.add(new AttributePropagationEndpointResolution(context, object, attr
						.getName(), isSource, this));
			}
		}

	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		Endpoints pair = getPropagationEndpoints(context.getDeployStatus());
		if (pair == null) {
			return false;
		}
		return true;
	}

	protected Endpoints getPropagationEndpoints(IDeployStatus status) {
		if (!(status.getDeployObject() instanceof AttributePropagationConstraint)) {
			return null;
		}

		AttributePropagationConstraint c = (AttributePropagationConstraint) status.getDeployObject();

		DeployModelObject cContext = ConstraintUtil.getExpectedContext(c);
		if (cContext == null) {
			return null;
		}
		if (!(cContext instanceof ConstraintLink)) {
			return null;
		}
		ConstraintLink cLink = (ConstraintLink) cContext;
		DeployModelObject pTarget;
		DeployModelObject pSource;
		if (c.isRespectLinkDirection()) {
			pSource = cLink.getSource();
			pTarget = cLink.getTarget();
		} else {
			pSource = cLink.getTarget();
			pTarget = cLink.getSource();
		}
		return new Endpoints(pSource, pTarget);
	}

	private class Endpoints {
		public final DeployModelObject target;
		public final DeployModelObject source;

		public Endpoints(DeployModelObject source, DeployModelObject target) {
			this.target = target;
			this.source = source;
		}
	}
}
