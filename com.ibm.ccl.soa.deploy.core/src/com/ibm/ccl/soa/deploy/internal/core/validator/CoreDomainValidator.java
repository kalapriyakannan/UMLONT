/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployWrapperStatus;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Validates the {@link Topology} object and instances of {@link Unit}.
 * <p>
 * Only direct instances of {@link Unit} are validated (subtypes are delegated to extension
 * domains).
 */
public class CoreDomainValidator extends DomainValidator implements InternalDomainValidator {

	protected UnitValidator unitValidator;

	protected ArrayList conceptualNodes = null;

	/**
	 * Construct a new core domain validator.
	 */
	public CoreDomainValidator() {
		unitValidator = new UnitValidator(CorePackage.eINSTANCE.getUnit());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		IProgressMonitor monitor = context.getProgressMonitor();
		Topology topology = context.getTopology();

		//
		// Validate object name validity and uniqueness.
		//
		validateDeployObjectNames(context, reporter);
		if (monitor.isCanceled()) {
			return;
		}

		//
		// Validate the topology object
		//
		validateTopology(topology, context, reporter);
		if (monitor.isCanceled()) {
			return;
		}

		//
		// Special universal validations on all topology units
		//
		validateExtendedAttributes(topology, context, reporter);
		for (Iterator<DeployModelObject> iter = topology.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = iter.next();
			// Generic extended attributes validation
			validateExtendedAttributes(obj, context, reporter);

			// Validation of "generic" units
			if (obj != null && CorePackage.eINSTANCE.getUnit().equals(obj.getEObject().eClass())) {
				unitValidator.validate((Unit) obj, context, reporter);
			}
		}
		if (monitor.isCanceled()) {
			return;
		}
	}

	/**
	 * Validates the {@link Topology} object itself.
	 * 
	 * @param topology
	 *           the topology to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	protected void validateTopology(Topology topology, IDeployValidationContext context,
			IDeployReporter reporter) {
		IProgressMonitor monitor = context.getProgressMonitor();
		validateTopologyFile(topology, context, reporter);

		if (topology.getConfigurationContract() != null) {
			validateConfigurationContract(topology.getConfigurationContract(), context, reporter);
		}

		// Look for import cycles
		Map markMap = new HashMap();
		if (hasImportCycles(topology, markMap)) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.TOPOLOGY_IMPORT_002, ICoreProblemType.TOPOLOGY_IMPORT_CYCLE,
					DeployCoreMessages.Validator_topology_has_import_cycle, new Object[] { topology },
					topology);
			reporter.addStatus(status);
		}

		// Validate individual imports
		for (Iterator iter = topology.getImports().iterator(); iter.hasNext();) {
			Import i = (Import) iter.next();
			if (context.getProgressMonitor().isCanceled()) {
				return;
			}
			validateImport(i, context, reporter);
		}

		// Validate that topology-contained links don't have sources in
		// the same topology
		validateTopologyLinkSources(topology, context, reporter);

		//
		// Validate constraints on the topology and topology-contained links: dependency, unit, and constraint.
		//
		for (Iterator iter = topology.getUnitLinks().iterator(); iter.hasNext();) {
			UnitLink link = (UnitLink) iter.next();
			ConstraintUtil.validateChildConstraintsInParentContext(link, context, reporter);
		}
		if (monitor.isCanceled()) {
			return;
		}
		for (Iterator iter = topology.getConstraintLinks().iterator(); iter.hasNext();) {
			ConstraintLink link = (ConstraintLink) iter.next();
			ConstraintUtil.validateChildConstraintsInParentContext(link, context, reporter);
		}
		if (monitor.isCanceled()) {
			return;
		}
		for (Iterator iter = topology.getDependencyLinks().iterator(); iter.hasNext();) {
			DependencyLink link = (DependencyLink) iter.next();
			ConstraintUtil.validateChildConstraintsInParentContext(link, context, reporter);
		}
		if (monitor.isCanceled()) {
			return;
		}
		if (!topology.getConstraints().isEmpty()) {
			ConstraintUtil.validateChildConstraintsInParentContext(topology, context, reporter);
		}
	}

	/**
	 * Validates the extended attributes of the deploy object.
	 * 
	 * @param object
	 *           a deploy object.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the status reporter.
	 */
	protected final void validateExtendedAttributes(DeployModelObject object,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (object == null) {
			return;
		}
		int attrIndex = 0;
		Set<String> nameSet = new HashSet<String>();
		for (ExtendedAttribute attr : (List<ExtendedAttribute>) object.getExtendedAttributes()) {
			if (attr == null) {
				continue;
			}
			if (attr.getName() == null || attr.getName().trim().length() == 0) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE
						.createDeployStatus(
								IStatus.ERROR,
								IDeployCoreValidators.EXTENDED_ATTRIBUTE_001,
								ICoreProblemType.OBJECT_EXTENDED_ATTRIBUTE_NAME_UNDEFINED,
								DeployCoreMessages.Validator_deploy_model_object_0_extended_attribute_at_index_1_has_no_name,
								new Object[] { object, attrIndex }, object);
				reporter.addStatus(status);
			} else if (object.getEObject().eClass().getEStructuralFeature(attr.getName()) != null) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE
						.createAttributeStatus(
								IStatus.ERROR,
								IDeployCoreValidators.EXTENDED_ATTRIBUTE_004,
								ICoreProblemType.OBJECT_EXTENDED_ATTRIBUTE_NAME_INVALID,
								DeployCoreMessages.Validator_deploy_model_object_0_extended_attribute_1_conflicts_with_static_attribute_name,
								new Object[] { object, attr.getName() }, object, attr);
				reporter.addStatus(status);
			} else {
				if (nameSet.contains(attr.getName())) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE
							.createAttributeStatus(
									IStatus.ERROR,
									IDeployCoreValidators.EXTENDED_ATTRIBUTE_005,
									ICoreProblemType.OBJECT_EXTENDED_ATTRIBUTE_NAME_INVALID,
									DeployCoreMessages.Validator_deploy_model_object_0_extended_attribute_name_1_not_unique,
									new Object[] { object, attr.getName() }, object, attr);
					reporter.addStatus(status);
				} else {
					nameSet.add(attr.getName());
				}
			}
			if (attr.getEAttributeType() == null) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
						IStatus.ERROR, IDeployCoreValidators.EXTENDED_ATTRIBUTE_002,
						ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
						DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_undefined,
						new Object[] { object, attr }, object, attr);
				reporter.addStatus(status);
			} else if (attr.getValue() != null && attr.getInstanceType() != null
					&& !attr.getInstanceType().isInstance(attr.getValue())) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
						IStatus.ERROR, IDeployCoreValidators.EXTENDED_ATTRIBUTE_003,
						ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
						DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_undefined,
						new Object[] { object, attr }, object, attr);
				reporter.addStatus(status);
			}
			attrIndex++;
		}

	}

	/**
	 * Validates all of the names of objects contained in the topology.
	 * <p>
	 * Tests for (1) character validity, and (2) uniqueness in container.
	 * 
	 * @param context
	 *           the domain validation context (used to extract the topology).
	 * @param reporter
	 *           used to create deploy markers.
	 */
	protected void validateDeployObjectNames(IDeployValidationContext context,
			IDeployReporter reporter) {
		assert context != null;
		LinkedList<DeployModelObject> stack = new LinkedList<DeployModelObject>();
		stack.add(context.getTopology());

		Map<String, DeployModelObject> nameObjectMap = new HashMap<String, DeployModelObject>();
		while (stack.size() > 0) {
			DeployModelObject parent = stack.removeFirst();
			String name = parent.getName();
			if (name == null || name.length() == 0) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
						IStatus.ERROR, IDeployCoreValidators.OBJECT_NAME_001,
						ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
						DeployCoreMessages.Validator_deploy_model_object_0_type_1_name_undefined,
						new Object[] { parent, parent.eClass().getName() }, parent, CorePackage.eINSTANCE
								.getDeployModelObject_Name());

				reporter.addStatus(status);
			} else if (!TopologyMarkerFactory.isValidDeployModelObjectName(name)) {
				IDeployStatus status = DeployCoreStatusUtil.createAttributeInvalidStatus(IStatus.ERROR,
						IDeployCoreValidators.OBJECT_NAME_002, parent, CorePackage.eINSTANCE
								.getDeployModelObject_Name());
				reporter.addStatus(status);
			}

			// Validate uniqueness of child names
			nameObjectMap.clear();
			for (Iterator<DeployModelObject> iter = parent.getContainedModelObjects().iterator(); iter
					.hasNext();) {
				DeployModelObject child = iter.next();
				stack.add(child);

				String childName = child.getName();
				if (childName == null || childName.length() == 0) {
					continue;
				}

				if (nameObjectMap.containsKey(childName)) {
					IDeployStatus status = DeployCoreStatusUtil
							.createDeployModelObjectNameNotUniqueStatus(IStatus.ERROR,
									IDeployCoreValidators.OBJECT_NAME_003, child, parent);
					reporter.addStatus(status);

					DeployModelObject first = nameObjectMap.get(childName);
					if (first != null) {
						status = DeployCoreStatusUtil.createDeployModelObjectNameNotUniqueStatus(
								IStatus.ERROR, IDeployCoreValidators.OBJECT_NAME_003, first, parent);
						reporter.addStatus(status);

						nameObjectMap.put(childName, null);
					}
				} else {
					nameObjectMap.put(childName, child);
				}
			}
		}
	}

	/**
	 * Validates the import of a topology.
	 * 
	 * @param importDcl
	 *           the topology import declaration.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	protected void validateImport(Import importDcl, IDeployValidationContext context,
			IDeployReporter reporter) {
		if (importDcl.getPattern() == null || importDcl.getPattern().trim().length() == 0) {
			IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.ERROR, IDeployCoreValidators.TOPOLOGY_IMPORT_PATTERN_001,
					ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
					DeployCoreMessages.Validator_topology_import_0_has_empty_pattern,
					new Object[] { importDcl }, importDcl, CorePackage.Literals.IMPORT__PATTERN);
			reporter.addStatus(status);
		} else {
			IScopeService scope = IScopeService.Locator.findScopeService(importDcl);
			if (scope instanceof InternalScopeService) {
				Topology importTop = ((InternalScopeService) scope).resolve(importDcl);
				if (importTop == null) {
					String fullName;
					if (importDcl.getNamespace() == null || importDcl.getNamespace().length() == 0) {
						fullName = importDcl.getPattern();
					} else {
						fullName = importDcl.getNamespace() + IConstants.DOT_SEPARATOR
								+ importDcl.getPattern();
					}
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
							IStatus.ERROR, IDeployCoreValidators.TOPOLOGY_IMPORT_001,
							ICoreProblemType.TOPOLOGY_IMPORT_NOT_FOUND,
							DeployCoreMessages.Validator_topology_import_0_not_found_in_1, new Object[] {
									fullName, importDcl }, importDcl);
					reporter.addStatus(status);
				} else {
					InstanceConfiguration instanceConfig = importDcl.getInstanceConfiguration();
					if (instanceConfig != null) {
						validateInstanceConfiguration(instanceConfig, importTop, importDcl, context,
								reporter);
					}
				}
			}
			// TODO lookup topoology (check != null)
		}

	}

	/**
	 * Validates the configuration contract.
	 * 
	 * @param contract
	 *           the configuration contract.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	protected void validateConfigurationContract(ConfigurationContract contract,
			IDeployValidationContext context, IDeployReporter reporter) {
		// Note: ExplicitContract only returns units resolvable against contracts topology.
		// No error check that units in contract are in its topology is necessary, nor is such a 
		// check testable.
	}

	/**
	 * Validates the instance configuration for the import. Validate that DMOs referenced by
	 * instantiations are resolvable TODO arrange for display of error marker on import
	 * 
	 * @param instanceConfig
	 *           the instance configuration for the import (non-null).
	 * @param importTop
	 *           the topology which the import references (non-null).
	 * @param importDcl
	 *           the import declaration (non-null).
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	protected void validateInstanceConfiguration(InstanceConfiguration instanceConfig,
			Topology importTop, Import importDcl, IDeployValidationContext context,
			IDeployReporter reporter) {

		for (Instantiation instantiation : (List<Instantiation>) instanceConfig.getInstantiations()) {
			if (instantiation == null) {
				continue;
			}
			// TODO check Augmentations

			// TODO use getReferencedObject() instead?
			String referenced = instantiation.getReferenced();
			if (referenced == null) {
				continue;
			}
			String namespace = importDcl.getNamespace();
			String fullName = importDcl.getPattern();
			if (fullName == null) {
				continue;
			}
			if (namespace != null) {
				fullName = namespace + IConstants.DOT_SEPARATOR + fullName;
			}
			String path = fullName + IConstants.TOPOLOGY_SEPARATOR + IConstants.PATH_SEPARATOR
					+ referenced;
			DeployModelObject referencedDMO = importDcl.getEditTopology().resolve(path);
			if (referencedDMO == null) {
				// Report unresolvable
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.TOPOLOGY_IMPORT_003,
						ICoreProblemType.IMPORT_INSTANTIATION_NOT_RESOLVABLE,
						DeployCoreMessages.Validator_instantiation_reference_0_not_resolvable,
						new Object[] { path }, instantiation);
				reporter.addStatus(status);
			} else if (referencedDMO.getTopology().getConfigurationContract() != null) {
				//ConfigurationContract contract = referencedDMO.getTopology().getConfigurationContract();
				// Validate instantiation against contract
				if (!referencedDMO.isPublic()) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
							IStatus.ERROR, IDeployCoreValidators.TOPOLOGY_IMPORT_004,
							ICoreProblemType.IMPORT_INSTANTIATION_OBJECT_NOT_PUBLIC,
							DeployCoreMessages.Validator_instantiation_object_0_not_public,
							new Object[] { referencedDMO }, referencedDMO);
					reporter.addStatus(status);
				} else {
					// Check instantiated object attributes to verify that they are editable
					for (Property p : (List<Property>) instantiation.getConfiguredProperties()) {
						if (!referencedDMO.isPublicEditable(p.getSelect())) {
							IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE
									.createAttributeStatus(
											IStatus.ERROR,
											IDeployCoreValidators.TOPOLOGY_IMPORT_005,
											ICoreProblemType.IMPORT_INSTANTIATION_OBJECT_ATTRIBUTE_NOT_EDITABLE,
											DeployCoreMessages.Validator_instantiation_object_0_attribute_1_not_editable,
											new Object[] { referencedDMO, p.getSelect() }, referencedDMO, p
													.getSelect());
							reporter.addStatus(status);
						}
					}
				}
			}
		}
	}

	/**
	 * Validates the location and name of the file containing te topology.
	 * 
	 * @param topology
	 *           the topology whose file is to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	protected void validateTopologyFile(Topology topology, IDeployValidationContext context,
			IDeployReporter reporter) {
		if (topology != null) {
			IFile file = WorkbenchResourceHelper.getFile(topology.getEObject());
			if (file != null && file.exists()) {
				// Validate that the namespace in the topology matches the
				// actual namespace.
				INamespaceFragmentRoot root = NamespaceCore.getRoot(file.getParent());
				if (null == root) {
					// Topology exists outside of a namespace or namespace src folder
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(
							IStatus.ERROR, IDeployCoreValidators.TOPOLOGY_NAMESPACE_003,
							ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
							DeployCoreMessages.CoreDomainValidator_The_topology_file_0_does_not_exis_,
							new Object[] { file.getFullPath() }, topology,
							CorePackage.Literals.TOPOLOGY__NAMESPACE, null);
					reporter.addStatus(status);
				} else {
					INamespaceFragment namespaceElement = NamespaceCore.findNamespace(file.getProject(),
							file.getParent());
//					INamespaceElement namespaceElement = NamespaceCore.create(file.getParent());
					if (namespaceElement != null) {
						String namespace = topology.getNamespace();
						switch (namespaceElement.getType())
						{
						case INamespaceElement.TOPOLOGY_NAMESPACE:
							// Ensure the namespaces match.
							String physicalNamespace = namespaceElement.getQualifiedName();
							if (!physicalNamespace.equals(namespace)) {
								// Error detected.
								IDeployStatus status = DeployCoreStatusFactory.INSTANCE
										.createAttributeValueStatus(
												IStatus.ERROR,
												IDeployCoreValidators.TOPOLOGY_NAMESPACE_001,
												ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
												DeployCoreMessages.CoreDomainValidator_0_does_not_match_the_expected_na_,
												new Object[] { namespace, physicalNamespace }, topology,
												CorePackage.Literals.TOPOLOGY__NAMESPACE, physicalNamespace);
								reporter.addStatus(status);
							}
							break;
						case INamespaceElement.TOPOLOGY_NAMESPACE_ROOT:
							// Ensure the namespace is null.
							if (namespace != null && namespace.length() > 0) {
								// Error detected.
								IDeployStatus status = DeployCoreStatusFactory.INSTANCE
										.createAttributeValueStatus(
												IStatus.ERROR,
												IDeployCoreValidators.TOPOLOGY_NAMESPACE_002,
												ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
												DeployCoreMessages.CoreDomainValidator_0_does_not_match_the_expected_na_,
												new Object[] { namespace, "" }, topology, CorePackage.Literals.TOPOLOGY__NAMESPACE, null); //$NON-NLS-1$
								reporter.addStatus(status);
							}
							break;
						}
					}
				}
				// Validate file name.
				IPath path = file.getFullPath().removeFileExtension();
				if (!path.lastSegment().equals(topology.getName())) {
					// The name of the topology and its file name should match.
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(
							IStatus.ERROR, IDeployCoreValidators.TOPOLOGY_NAME_001,
							ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
							DeployCoreMessages.CoreDomainValidator_The_topology_file_name_should_match_,
							new Object[] { topology.getName() }, topology,
							CorePackage.Literals.DEPLOY_MODEL_OBJECT__NAME, path.lastSegment());
					reporter.addStatus(status);
				}
			}
		}
	}

	protected DomainMatcher createDomainMatcher() {
		return new CoreDomainMatcher();
	}

	/**
	 * Returns true if the topology has an import cycle.
	 * 
	 * @param top
	 *           the edit topology.
	 * @param markMap
	 *           a map (initially empty) used to track visits.
	 * @return true if the topology has an import cycle.
	 */
	protected boolean hasImportCycles(Topology top, Map markMap) {
		markMap.put(top, Boolean.FALSE);
		for (Iterator iter = top.getImports().iterator(); iter.hasNext();) {
			Topology cur = TopologyUtil.resolve((Import) iter.next());
			if (cur != null) {
				if (markMap.get(cur) == Boolean.FALSE) {
					return true;
				} else if (!markMap.containsKey(cur)) {
					if (hasImportCycles(cur, markMap)) {
						return true;
					}
				}
			}
		}
		markMap.put(top, Boolean.TRUE);
		return false;
	}

	/**
	 * Validates that the links contained {@link Topology} have a source that is not in the topology
	 * itself.
	 * 
	 * @param topology
	 *           the topology to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	protected void validateTopologyLinkSources(Topology topology, IDeployValidationContext context,
			IDeployReporter reporter) {
		if (topology.getEditTopology() == topology) {
			// Rule only applies for the edit topology
			return;
		}
		for (Iterator iter = topology.getUnitLinks().iterator(); iter.hasNext();) {
			UnitLink link = (UnitLink) iter.next();
			checkLinkSourceNotFromTopology(link.getSource(), topology, link, context, reporter);
		}
		for (Iterator iter = topology.getConstraintLinks().iterator(); iter.hasNext();) {
			ConstraintLink link = (ConstraintLink) iter.next();
			checkLinkSourceNotFromTopology(link.getSource(), topology, link, context, reporter);
		}

		for (Iterator iter = topology.getDependencyLinks().iterator(); iter.hasNext();) {
			DependencyLink link = (DependencyLink) iter.next();
			checkLinkSourceNotFromTopology(link.getSource(), topology, link, context, reporter);
		}
		for (Iterator iter = topology.getRealizationLinks().iterator(); iter.hasNext();) {
			RealizationLink link = (RealizationLink) iter.next();
			checkLinkSourceNotFromTopology(link.getSource(), topology, link, context, reporter);
		}
	}

	/**
	 * Validates that the link source object that is not in the topology.
	 * 
	 * @param source
	 *           the link source.
	 * @param topology
	 *           the topology to which the object should not belong.
	 * @param link
	 *           the link whose source is being checked.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation reporter.
	 */
	protected void checkLinkSourceNotFromTopology(DeployModelObject source, Topology topology,
			DeployLink link, IDeployValidationContext context, IDeployReporter reporter) {
		if (source == null) {
			return;
		}
		if (source.getTopology() == topology) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(
					IStatus.ERROR, IDeployCoreValidators.TOPOLOGY_LINK_001,
					ICoreProblemType.OBJECT_CONTAINER_INVALID,
					DeployCoreMessages.Validator_link_0_must_be_contained_at_source_1, new Object[] {
							link, source }, link, CorePackage.Literals.DEPLOY_LINK__SOURCE_URI, source);
			reporter.addStatus(status);
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.InternalDomainValidator#filterStatusList(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      java.util.List)
	 */
	public void filterStatusList(IDeployValidationContext context, List list) {
		String ds = context.getTopology().getEditTopology().getDecoratorSemantic();
		//
		// Template and business decorator semantic parameters not required.
		//

		// TODO define in plugin.xml
		// Template design decorator semantic removed as obsolete 2007/04/08: Defect #833		
		if (IDecoratorSemanticConstants.TemplateDesignDS_ID.equals(ds)
				|| IDecoratorSemanticConstants.BusinessApplicationDS_ID.equals(ds)) {
			removeObjectAttributeUndefinedForParameters(context, list);
		}

		//
		// Conceptual unit attributes do not have to be defined
		//
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
			DeployModelObject object = status.getDeployObject();
			Unit unit = ValidatorUtils.getUnit(object);
			if (unit == null || !unit.isConceptual()) {
				continue;
			}

			while (status instanceof DeployWrapperStatus) {
				status = ((DeployWrapperStatus) status).getWrappedStatus();
			}

			if (ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED.equals(status.getProblemType())) {
				status.setSeverity(IStatus.INFO);
				if (status instanceof IDeployAttributeStatus
						&& removeObjectAttributeUndefinedBecauseDefined((IDeployAttributeStatus) status)) {
					iter.remove();
				}
			} else if (ICoreProblemType.OBJECT_ATTRIBUTE_INVALID.equals(status.getProblemType())
					&& status instanceof IDeployAttributeStatus) {
				IDeployAttributeStatus aStatus = (IDeployAttributeStatus) status;
				if (aStatus.getAttributeType() != null
						&& !status.getDeployObject().eIsSet(aStatus.getAttributeType())) {
					// The value is unset, so this is really an undefined error.
					status.setSeverity(IStatus.INFO);
					if (removeObjectAttributeUndefinedBecauseDefined((IDeployAttributeStatus) status)) {
						iter.remove();
					}
				}
			}
		}
		//
		// Do any other severity overrides
		// 
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
			DeployStatusSeverityOverrideService.INSTANCE.severityOverride(status);
		}
	}

	/**
	 * Filter out {@link AttributeMetaData#isParameter()}
	 * {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}.
	 * 
	 * @param context
	 *           the validation context.
	 * @param list
	 *           the mutable status list.
	 */
	private void removeObjectAttributeUndefinedForParameters(IDeployValidationContext context,
			List list) {

		// TODO: propagate over multiple paths (transitive closure).
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
			if (status instanceof IDeployAttributeStatus
					&& ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED.equals(status.getProblemType())) {
				IDeployAttributeStatus aStatus = (IDeployAttributeStatus) status;
				if (ValidatorUtils.isParameter(aStatus.getDeployObject(), aStatus.getAttributeName())) {
					iter.remove();
				} else if (aStatus instanceof IDeployAttributeValueSourceStatus) {
					IDeployAttributeValueSourceStatus sStatus = (IDeployAttributeValueSourceStatus) aStatus;
					if (ValidatorUtils.isParameter(context.getTopology().resolve(
							sStatus.getAttributeExpectedValueSourceObjectID()), sStatus
							.getAttributeExpectedValueSourceAttributeName())) {
						iter.remove();
					}

				}
			}
		}
	}

	/**
	 * Determine whether or not to remove a {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED} or
	 * {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID} because it is defined elsewhere as a result
	 * of a realization.
	 * 
	 * @param context
	 *           the validation context.
	 * @param list
	 *           the mutable status list.
	 */
	private boolean removeObjectAttributeUndefinedBecauseDefined(IDeployAttributeStatus s) {
		DeployModelObject object = s.getDeployObject();
		EAttribute attribute = s.getAttributeType();
		String attributeName = s.getAttributeShortName();
		if (null == attributeName && null != attribute) {
			attributeName = attribute.getName();
		}

		Collection<DeployModelObject> peerColl = RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(object);
		for (DeployModelObject peer : peerColl) {
			// get attribute value
			// MK DeployModelObjectUtil#getAttributeValue does not check if attribute isSet
			// we should check this for unset enumerations
			// Object value = DeployModelObjectUtil.getAttributeValue(peer, attributeName);
			Object value = null;
			EStructuralFeature feature = peer.eClass().getEStructuralFeature(attributeName);
			if (feature instanceof EAttribute) {
				if (peer.eIsSet(feature)) {
					value = peer.eGet(feature);
				}
			} else {
				ExtendedAttribute ext = peer.getExtendedAttribute(attributeName);
				if (ext != null) {
					value = ext.getValue();
				}
			}

			if (value == null) {
				// null attribute: still undefined; keep looking
				continue;
			}
			if (!(value instanceof String)) {
				// not-null non-String: we have a definition; remove the status
				return true;
			}
			if (((String) value).trim().length() != 0) {
				// non-null String w/ non-zero length: we have a definition; remove the status
				return true;
			}
			// non-null String w/ zero length: attribute still undefined; keep looking
		}

		return false;
	}
}
