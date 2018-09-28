/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

public class CreateDefaultNodeGroupUnitIntoCellUnitResolution extends DeployResolution {
	private final WasCellUnit _cellUnit;

	public CreateDefaultNodeGroupUnitIntoCellUnitResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, WasCellUnit cellUnit) {
		super(context, generator, DeployNLS
				.bind(WasDomainMessages.Resolution_create_Default_Was_NodeGroup_Unit_for_CellUnit_0,
						cellUnit));
		_cellUnit = cellUnit;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		WasNodeGroupUnit defaultNodeGroupUnit = null;
		String templateId = _cellUnit.isConceptual() ? IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT_CONCEPTUAL
				: IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT;
		defaultNodeGroupUnit = (WasNodeGroupUnit) ResolutionUtils.addFromTemplate(templateId,
				_cellUnit.getEditTopology());
		List<Requirement> requireCellUnitL = ValidatorUtils.getRequirements(defaultNodeGroupUnit,
				WasPackage.eINSTANCE.getWasCellUnit());
		if (requireCellUnitL == null || defaultNodeGroupUnit == null) {
			return null;
		}
		defaultNodeGroupUnit
				.setDescription(WasDomainMessages.Resolution_create_default_node_group_description);
		LinkFactory.createMemberLink(_cellUnit, defaultNodeGroupUnit);

		WasNodeGroup ngCap = (WasNodeGroup) ValidatorUtils.getCapability(defaultNodeGroupUnit,
				WasPackage.eINSTANCE.getWasNodeGroup());
		if (ngCap != null) {
			ngCap.setIsDefaultType(true);
			ngCap.setNodeGroupName(WasDomainMessages.Resolution_create_default_node_group_name);
			ngCap.setDescription(WasDomainMessages.Resolution_create_default_node_group_description);
		}
		return Status.OK_STATUS;
	}
}
