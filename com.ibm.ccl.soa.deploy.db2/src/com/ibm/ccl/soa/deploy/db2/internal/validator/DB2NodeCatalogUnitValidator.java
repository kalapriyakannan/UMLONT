/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.db2.DB2BaseInstance;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.Db2DomainMessages;

/**
 * Validates a {link DB2NodeCatalogUnit}.
 */
public class DB2NodeCatalogUnitValidator extends ConfigurationUnitValidator {

	/**
	 * 
	 */
	public DB2NodeCatalogUnitValidator() {
		this(Db2Package.eINSTANCE.getDB2NodeCatalogUnit());
	}

	protected DB2NodeCatalogUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2Package.eINSTANCE.getDB2NodeCatalogUnit().isSuperTypeOf(unitType);

		addCapabilityTypeConstraint(Db2Package.eINSTANCE.getDB2CatalogedNode(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		addRequirementTypeConstraint(Db2Package.eINSTANCE.getDB2BaseInstance(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		addRequirementTypeConstraint(Db2Package.eINSTANCE.getDB2Instance(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);
		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IDB2ValidatorID.DB2_NODE_CATALOG_UNIT_HOSTNAME_001, Db2Package.eINSTANCE
						.getDB2CatalogedNode_Hostname(), Db2Package.eINSTANCE.getDB2Instance_Hostname()));
		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IDB2ValidatorID.DB2_NODE_CATALOG_UNIT_PORT_001, Db2Package.eINSTANCE
						.getDB2CatalogedNode_Port(), Db2Package.eINSTANCE.getDB2Instance_Port()));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDB2ValidatorID.DB2_NODE_CATALOG_UNIT_NODENAME_EMPTY_001, Db2Package.eINSTANCE
						.getDB2CatalogedNode_NodeName(), IStatus.ERROR));

		addAttributeValidator(new CapabilityInstanceNameToNodeNamePropagationValidator(
				IDB2ValidatorID.DB2_NODE_CATALOG_UNIT_NODENAME_EMPTY_001, Db2Package.eINSTANCE
						.getDB2CatalogedNode(), Db2Package.eINSTANCE.getDB2CatalogedNode_NodeName(),
				Db2Package.eINSTANCE.getDB2Instance(), Db2Package.eINSTANCE
						.getDB2BaseInstance_Db2InstanceName()));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IDB2ValidatorID.DB2_NODE_CATALOG_UNIT_NODE_NAME_UNIQUE_IN_HOST_001,
				Db2Package.eINSTANCE.getDB2CatalogedNode_NodeName()));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// Core Unit validation
		super.validateUnit(unit, context, reporter);

		DB2CatalogedNode providedDb2CatalogedNode = (DB2CatalogedNode) getFirstCapability(unit
				.getCapabilities(), Db2Package.eINSTANCE.getDB2CatalogedNode());
		if (providedDb2CatalogedNode == null) {
			return;
		}

		// Use generic DB2 name check on nodeName. 
		// Pattern validator already checks nodeName == null case
		String nodeName = providedDb2CatalogedNode.getNodeName();
		if (nodeName != null) {
			DB2ValidatorUtils.validateDB2GenericName(nodeName, providedDb2CatalogedNode,
					Db2Package.eINSTANCE.getDB2CatalogedNode_NodeName(), reporter);

			// nodeName should be different than client instance name
			Unit hostOfNodeCatalogUnit = ValidatorUtils.discoverHost(unit, context
					.getProgressMonitor());
			if (hostOfNodeCatalogUnit != null) {
				DB2BaseInstance baseInstance = (DB2BaseInstance) ValidatorUtils.getFirstCapability(
						hostOfNodeCatalogUnit, Db2Package.eINSTANCE.getDB2BaseInstance());
				if (baseInstance != null) {
					String instanceName = baseInstance.getDb2InstanceName();
					if (instanceName != null) {
						if (instanceName.equalsIgnoreCase(nodeName)) {
							IDeployAttributeStatus status = DeployCoreStatusUtil
									.createAttributeInvalidStatus(
											IStatus.ERROR,
											IDB2ValidatorID.DB2_NODE_CATALOG_UNIT_NODENAME_CONFLICTS_WITH_CLIENT_INSTANCE_NAME_001,
											providedDb2CatalogedNode, Db2Package.eINSTANCE
													.getDB2CatalogedNode_NodeName());
							status
									.setUnboundMessage(Db2DomainMessages.Validator_DB2_nodeName_0_conflicts_with_local_instance_name);
							status.setBindings(new String[] { nodeName });
							reporter.addStatus(status);
						}
					}
				}

			}
		}

		// TODO implement
		// DB2CatalogedNode.dasLevel
		// DB2CatalogedNode.nodeType valid
		// Node types are "APPC", "APPN", "LOCAL", "NPIPE", "NETBIOS", "TCPIP" i.e. protocol
		// Or... "DB2 V8". Unclear. 
	}

	/**
	 * Limit propagation to where target is null or empty.
	 * 
	 * @since 7.0
	 * 
	 */
	private class CapabilityInstanceNameToNodeNamePropagationValidator extends
			CapabilityAttributeToAttributePropagationValidator {

		public CapabilityInstanceNameToNodeNamePropagationValidator(String validatorID,
				EClass targetEClass, EAttribute targetEAttribute, EClass sourceEClass,
				EAttribute sourceEAttribute) {
			super(validatorID, targetEClass, targetEAttribute, sourceEClass, sourceEAttribute);
		}

		// Only propagate if target is not null or empty, i.e. suggest a value
		@Override
		public void validate(Unit unit, Capability targetCap, IDeployValidationContext context,
				IDeployReporter reporter) {
			Object o = targetCap.eGet(targetEAttribute);
			if (o == null || o instanceof String && ((String) o).length() == 0) {
				super.validate(unit, targetCap, context, reporter);
			}
		}

	}

}
