/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.scenarios;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.IActivity;
import org.eclipse.ui.activities.IActivityPatternBinding;
import org.eclipse.ui.activities.IWorkbenchActivitySupport;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.internal.core.extension.DomainManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeDescriptor;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;

/**
 * JUnit test case for templates.
 * 
 * This consolidates a number of tests for template functionality and some heuristic tests for template consistency and correctness.
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class TemplatesTest extends TopologyTestCase {

	private boolean verbose = false;

	private boolean allResourceTypes = true;

	/** Test case ctor */
	public TemplatesTest() {
		super("TemplatesTest");
	}

	/**
	 * @throws Exception
	 *             Note 2007/04/04 main test case won't run without this dummy test run first.
	 */
	public void testDummy() throws Exception {
		createTopology("dummy");
	}

	/**
	 * Test all available templates, loading and looking for basic errors
	 * 
	 * @throws Exception
	 */
	public void testTemplates() throws Exception {
		Topology top = createTopology("TemplatesLoadTest");
		top.setDescription("Load registered templates and check for errors");
		Resource res;
		res = top.getEObject().eResource();

		ResourceSet resSet = new ResourceSetImpl();
		res = resSet.createResource(res.getURI());
		DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
		root.setTopology(top);
		res.getContents().add(root);

		DeployValidatorService deployValidatorService = new DeployValidatorService();

		// Hack to get GMF palette entries
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(
				"org.eclipse.gmf.runtime.emf.type.core", "elementTypes");
		assert (point != null);
		IConfigurationElement[] elements = point.getConfigurationElements();
		assert (elements.length > 0);
		TreeSet<String> templateIds = new TreeSet<String>();
		Map<String, String> typeIDToTemplateURIMap = new HashMap<String, String>();
		for (int i = 0; i < elements.length; i++) {
			IConfigurationElement element = elements[i];
			if (ignoreElement(element)) {
				continue;
			}
			// IExtension ie = element.getDeclaringExtension();
			if (element.getName().equals("specializationType")) {
				IConfigurationElement[] paramElements = element.getChildren("param");
				for (int x = 0; x < paramElements.length; x++) {
					IConfigurationElement paramElement = paramElements[x];
					if (paramElement.getAttribute("name").equals("templateURI")) {
						String id = element.getAttribute("id");
						// System.out.println("Template ID = " + id + " - From plugin: " +
						// element.getContributor().getName());
						templateIds.add(id);
						typeIDToTemplateURIMap.put(id, paramElement.getAttribute("value"));
					}
				}
			}
			if (element.getName().equals("metamodel")) {
				IConfigurationElement[] stElements = element.getChildren("specializationType");
				for (int j = 0; j < stElements.length; j++) {
					IConfigurationElement stElement = stElements[j];
					IConfigurationElement[] paramElements = stElement.getChildren("param");
					for (int x = 0; x < paramElements.length; x++) {
						IConfigurationElement paramElement = paramElements[x];
						if (paramElement.getAttribute("name").equals("templateURI")) {
							String id = stElement.getAttribute("id");
							// System.out.println("Template ID = " + id + " - From plugin: " +
							// element.getContributor().getName());
							templateIds.add(id);
							typeIDToTemplateURIMap.put(id, paramElement.getAttribute("value"));
						}
					}
				}
			}
		}

		// assert (templateIds.size() > 0);

		// Get types ids and uris, either all resource types or palette entry types
		Map<String, String> rtIDToTemplateURIMap = new HashMap<String, String>();
		if (allResourceTypes) {
			// Get all resource types
			ResourceTypeDescriptor rtdArray[] = DomainManager.INSTANCE.getAllResourceTypes();
			assert (rtdArray.length > 0);
			for (int i = 0; i < rtdArray.length; i++) {
				rtIDToTemplateURIMap.put(rtdArray[i].getId(), rtdArray[i].getTemplateUri());
			}
		} else {
			// Get just palette types
			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			DynamicPaletteEntry[] dpeArray = rts.getAllPaletteEntries();
			assert (dpeArray.length > 0);
			for (int i = 0; i < dpeArray.length; ++i) {
				rtIDToTemplateURIMap.put(dpeArray[i].getId(), dpeArray[i].getTemplateURI());
			}
		}

		int typeEntriesAdded = 0;
		// Add types to master list, with bookkeeping
		for (String id : rtIDToTemplateURIMap.keySet()) {
			String templateURI = rtIDToTemplateURIMap.get(id);
			if (templateURI == null) {
				System.out.println("Resource type with no template URI: " + id);
				continue;
			}
			if (!(ignoreType(id, templateURI))) {
				if (!templateIds.contains(id)) {
					++typeEntriesAdded;
				}
				// System.out.println("RTS id = " + id);
				templateIds.add(id);
				typeIDToTemplateURIMap.put(id, templateURI);
			}
		}
		assert (typeEntriesAdded > 0);

		HashSet<String> badProblemTypesSet = new HashSet<String>();
		addBadProblemTypesToSet(badProblemTypesSet);
		HashSet<String> badValidatorIdsSet = new HashSet<String>();
		addBadValidatorIdsToSet(badValidatorIdsSet);
		StringBuffer errorLog = new StringBuffer();
		StringBuffer localLog = new StringBuffer();
		int errorCount = 0;
		for (Iterator iter = templateIds.iterator(); iter.hasNext();) {
			String templateId = (String) iter.next();
			int errorLogLength = errorLog.length();
			if (verbose)
				System.out.println("Loading template with id = " + templateId + " ("
						+ typeIDToTemplateURIMap.get(templateId) + ")");
			//checkRootAnnotationPresence(typeIDToTemplateURIMap.get(templateId));
			top.getUnits().clear();
			top.getImports().clear();
			top.getRealizationLinks().clear();
			top.setDecoratorSemantic(null);
			this.addExplicitContractDefaultPublicEditable(top);
			DeployModelObject u = null;
			try {
				top.setDescription(templateId);
				u = ResolutionUtils.addFromTemplate(templateId, top); //$NON-NLS-1$
			} catch (Exception e) {
				System.out.println("Failed loading template with id = " + templateId + " ("
						+ typeIDToTemplateURIMap.get(templateId) + ")");
				throw e;
			}
			if (u == null) {
				// Handle unitless constraint link templates
				assert (top.getConstraints() != null);
			}

//			checkIdAndConceptualFlagConsistency(u, templateId, errorLog);

			checkDmoTypeOrTypeConstraintPresenceOnRequirements(top);

			long prevTime = System.currentTimeMillis();
			deployValidatorService.validate(top);
			long time = System.currentTimeMillis();
			if (verbose) {
				System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
				System.out.println("Error count = " + ValidatorTestUtils.getTopologyErrorCount(top));
				System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
				System.out.println("Warning count = "
						+ ValidatorTestUtils.getTopologyStatusOfSeverityCount(top, IStatus.WARNING));
				System.out.println(ValidatorTestUtils.getTopologyWarningDescription(top));
			}

			// Besides well known errors, no other WARNING or ERROR statuses
			if (!ValidatorTestUtils.topologyNoProblemTypesInSet(top, badProblemTypesSet,
					(IStatus.WARNING | IStatus.ERROR), localLog)) {
				errorLog.append("Found unexpected problem types in template with type id " + templateId + "\n");
				errorLog.append("URI of failing template = " + typeIDToTemplateURIMap.get(templateId) + "\n");
				errorLog.append(localLog);
				localLog.setLength(0);
			}
			if (!ValidatorTestUtils.topologyNoValidatorIdsInSet(top, badValidatorIdsSet,
					(IStatus.WARNING | IStatus.ERROR), localLog)) {
				errorLog.append("Found unexpected validator ID(s) template with type id " + templateId + "\n");
				errorLog.append("URI of failing template = " + typeIDToTemplateURIMap.get(templateId) + "\n");
				errorLog.append(localLog);
				localLog.setLength(0);
			}

			// Conceptual units get OK or INFO only

			// Bill Arnold 2007/04/08 Should this severity override for
			// conceptual units be done with a contract?
			top.setDecoratorSemantic(IDecoratorSemanticConstants.TemplateDesignDS_ID);
			if (hasConceptualUnits(top)) {
				for (Iterator iter2 = top.getUnits().iterator(); iter2.hasNext();) {
					Unit unit = (Unit) iter2.next();
					if (!unit.isConceptual()) {
						errorLog.append("Template " + templateId + " mixes conceptual and concrete units\n");
						continue;
					}
					if ((!unit.getStatus().isOK()) && (unit.getStatus().getSeverity() != IStatus.INFO)) {
						// TODO remove this special case
						if ((unit instanceof EarModule || unit instanceof WebModule || unit instanceof EjbModule)) {
							if (unit.getStatus().getSeverity() == IStatus.WARNING) {
								continue;
							}
						}
						errorLog.append("Non OK/INFO status found on conceptual unit " + unit.getName()
								+ " of template " + templateId + ":\n"
								+ getString(unit.getStatus(), IStatus.WARNING | IStatus.ERROR) + "\n");
						errorLog.append("URI of failing template = " + typeIDToTemplateURIMap.get(templateId) + "\n");
					}
					for (Iterator iter3 = unit.eAllContents(); iter3.hasNext();) {
						Object obj = iter3.next();
						if (obj instanceof DeployModelObject) {
							DeployModelObject dmo = (DeployModelObject) obj;
							if ((!dmo.getStatus().isOK()) && (dmo.getStatus().getSeverity() != IStatus.INFO)) {
								errorLog.append("Non OK/INFO status found on conceptual unit " + unit.getName()
										+ " object " + dmo.getName() + " of template " + templateId + ":\n"
										+ getString(dmo.getStatus(), IStatus.WARNING | IStatus.ERROR) + "\n");
								errorLog.append("URI of failing template = " + typeIDToTemplateURIMap.get(templateId)
										+ "\n");
							}
						}
					}
				}
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// Save to baos doesn't work unless save to file first?
			res.save(null);
			res.save(baos, null);
			String s = baos.toString();
			assert (s != null) : templateId;
			assert (s.length() != 0) : templateId;
			// Test retired 2008/04/15, because extended attributes have a legitimate use for xsi:type
			// assert (s.indexOf("xsi:type=") == -1) : templateId;
			if (errorLogLength != errorLog.length()) {
				errorLog.append("-----------------------------------------------------------------\n");
				errorCount++;
			}
		}
		if (errorCount > 0) {
			throw new IllegalArgumentException("Found " + errorCount + " templates with errors:\n\n"
					+ errorLog.toString());
		}
	}

	/*
	 * Ignore the UML and Anlysis domains since they do not follow the same pattern
	 * for ids.
	 */
	private boolean ignoreElement(IConfigurationElement element) {
		IContributor cont = element.getContributor();
		String contributorName = cont.getName();
		return contributorName.startsWith("com.ibm.ccl.soa.deploy.analysis") ||
				contributorName.startsWith("com.ibm.ccl.soa.deploy.uml");
	}

	private void checkIdAndConceptualFlagConsistency(DeployModelObject o, String templateId, StringBuffer errorLog) {
		if (!(o instanceof Unit)) {
			return;
		}
		Unit u = (Unit) o;
//		boolean templateIdConceptual = templateId.endsWith(".conceptual");
		boolean templateIdConceptual = templateId.indexOf("conceptual") >= 0;
		if (!u.isConceptual() && templateIdConceptual) {
			errorLog.append("Template ID [" + templateId + "] conceptual, root unit ["
					+ u.getCaptionProvider().titleWithContext(u) + "] in template non-conceptual");
		}
		if (u.isConceptual() && !templateIdConceptual) {
			errorLog.append("Template ID [" + templateId + "] non-conceptual, root unit ["
					+ u.getCaptionProvider().titleWithContext((Unit) o) + "] in template conceptual");
		}		
	}

	private boolean ignoreType(String id, String templateURI) {
		boolean basic = "test.resource.type".equals(id) || "platform:/some.uri".equals(templateURI);
		if (basic) {
			return true;
		}
		//Check activities.
		//Ignore the analysis and uml activities.
		try {
			if (isPatternBound(id, "com.ibm.rational.deployment.activity.logical.analysis")) {
				return true;
			}
		} catch (IllegalStateException e) {
			//The workbench has not been started. Do a basic test.
			return id.startsWith("analysis");
		}
		try {
			if (isPatternBound(id, "com.ibm.rational.deployment.activity.logical.uml")) {
				return true;
			}
		} catch (IllegalStateException e) {
			//The workbench has not been started. Do a basic test.
			return id.startsWith("uml");
		}
		return false;
	}
	
	private boolean isPatternBound(String id, String activityId) {
		return isPatternBound(id, getActivity(activityId));
	}
	
	@SuppressWarnings("unchecked")
	private boolean isPatternBound(String id, IActivity activity) {
		Set<IActivityPatternBinding> bindingSet = activity.getActivityPatternBindings();
		for (Iterator<IActivityPatternBinding> it = bindingSet.iterator(); it.hasNext();) {
			IActivityPatternBinding patternBinding = it.next();
			Matcher matcher = patternBinding.getPattern().matcher(id);
			if (matcher.find()) {
				return true;
			}
		}
		return false;
	}
	
	private IActivity getActivity(String id) {
		IWorkbenchActivitySupport activitySupport = PlatformUI.getWorkbench().getActivitySupport();
		return activitySupport.getActivityManager().getActivity(id);
	}

	protected boolean hasConceptualUnits(Topology top) {
		for (Iterator iter2 = top.getUnits().iterator(); iter2.hasNext();) {
			Unit unit = (Unit) iter2.next();
			if (unit.isConceptual()) {
				return true;
			}
		}
		return false;
	}

	protected HashSet addBadValidatorIdsToSet(HashSet<String> badValidatorIdsSet) {
		badValidatorIdsSet.add(IDeployCoreValidators.OBJECT_NAME_001);
		badValidatorIdsSet.add(IDeployCoreValidators.OBJECT_NAME_002);
		badValidatorIdsSet.add(IDeployCoreValidators.OBJECT_NAME_003);
		badValidatorIdsSet.add(IDeployCoreValidators.PUBLISH_STATE_001);
		badValidatorIdsSet.add(IDeployCoreValidators.MEMBER_REQUIREMENT_001);
		badValidatorIdsSet.add(IDeployCoreValidators.CAPABILITY_001);
		badValidatorIdsSet.add(IDeployCoreValidators.DEPENDENCY_LINK_005);
		return badValidatorIdsSet;
	}

	protected HashSet addBadProblemTypesToSet(HashSet<String> badProblemTypesSet) {
		badProblemTypesSet.add(ICoreProblemType.DEPENDENCY_LINK_ENDPOINT_ATTRIBUTE_MISMATCH);
		badProblemTypesSet.add(ICoreProblemType.DEPENDENCY_LINK_ENDPOINT_TYPE_MISMATCH);
		badProblemTypesSet.add(ICoreProblemType.DEPENDENCY_LINK_SOURCE_INVALID);
		badProblemTypesSet.add(ICoreProblemType.DEPENDENCY_LINK_TARGET_HOSTING_INVALID);
		badProblemTypesSet.add(ICoreProblemType.DEPENDENCY_LINK_TARGET_INVALID);
		// badProblemTypesSet.add(ICoreProblemType.DEPENDENCY_LINK_TARGET_UNDEFINED);
		// badProblemTypesSet.add(ICoreProblemType.GROUP_IN_CARDINALITY_INVALID);
		// badProblemTypesSet.add(ICoreProblemType.GROUP_OUT_CARDINALITY_INVALID);
		badProblemTypesSet.add(ICoreProblemType.HOSTING_LINK_SOURCE_IS_NOT_CONTAINER);
		badProblemTypesSet.add(ICoreProblemType.HOSTING_LINK_SOURCE_PROVIDES_NO_HOSTING_CAPABILITIES);
		badProblemTypesSet.add(ICoreProblemType.HOSTING_LINK_TARGET_HAS_NO_HOSTING_REQUIREMENTS);
		badProblemTypesSet.add(ICoreProblemType.HOSTING_LINK_TARGET_INVALID);
		badProblemTypesSet.add(ICoreProblemType.HOSTING_LINK_TARGET_UNDEFINED);
		badProblemTypesSet.add(ICoreProblemType.LINK_SOURCE_UNDEFINED);
		badProblemTypesSet.add(ICoreProblemType.LINK_SOURCE_UNRESOLVABLE);
		badProblemTypesSet.add(ICoreProblemType.LINK_TARGET_UNDEFINED);
		badProblemTypesSet.add(ICoreProblemType.LINK_TARGET_UNRESOLVABLE);
		badProblemTypesSet.add(ICoreProblemType.MEMBER_LINK_TARGET_INVALID);
		badProblemTypesSet.add(ICoreProblemType.MEMBER_LINK_TARGET_UNDEFINED);
		badProblemTypesSet.add(ICoreProblemType.MULTIPLE_MEMBER_LINKS_BETWEEN_UNITS);
		badProblemTypesSet.add(ICoreProblemType.OBJECT_CONTAINER_UNDEFINED);
		badProblemTypesSet.add(ICoreProblemType.REQUIREMENT_EXPRESSION_INVALID_ATTRIBUTE);
		badProblemTypesSet.add(ICoreProblemType.REQUIREMENT_EXPRESSION_MISSING);
		badProblemTypesSet.add(ICoreProblemType.REQUIREMENT_EXPRESSION_VALUE_MISMATCH);
		badProblemTypesSet.add(ICoreProblemType.REQUIREMENT_LINK_TYPE_MISMATCH);
		badProblemTypesSet.add(ICoreProblemType.REQUIREMENT_TYPE_MISMATCH);
		// badProblemTypesSet.add(ICoreProblemType.UNIT_ARTIFACT_UNDEFINED);
		badProblemTypesSet.add(ICoreProblemType.UNIT_CAPABILITY_CARDINALITY_INVALID);
		badProblemTypesSet.add(ICoreProblemType.UNIT_CAPABILITY_TYPE_CARDINALITY_INVALID);
		badProblemTypesSet.add(ICoreProblemType.UNIT_CAPABILITY_INVALID_TYPE);
		badProblemTypesSet.add(ICoreProblemType.UNIT_HAS_NO_REQUIREMENTS_OR_CAPABILITIES);
		badProblemTypesSet.add(ICoreProblemType.UNIT_MISSING_CAPABILITY);
		badProblemTypesSet.add(ICoreProblemType.UNIT_MISSING_REQUIREMENT);
		badProblemTypesSet.add(ICoreProblemType.UNIT_MULTIPLE_HOSTS);
		badProblemTypesSet.add(ICoreProblemType.UNIT_REQUIREMENT_CARDINALITY_INVALID);
		badProblemTypesSet.add(ICoreProblemType.UNIT_REQUIREMENT_TYPE_INVALID);
		return badProblemTypesSet;
	}



	void checkDmoTypeOrTypeConstraintPresenceOnRequirements(Topology top) {
		boolean requirementsHaveValidDMOTypeOrTypeConstraint = true;
		StringBuffer errors = new StringBuffer();
		for (Iterator unitIter = top.getUnits().iterator(); unitIter.hasNext();) {
			Unit u = (Unit) unitIter.next();
			for (Iterator reqIter = u.getRequirements().iterator(); reqIter.hasNext();) {
				Requirement r = (Requirement) reqIter.next();
				boolean foundTypeConstraint = false;
				// assert r.getDmoType() != null;
				// TODO recursive analyzer of type constraints that are children
				// of logical constraints
				for (Constraint c : (List<Constraint>) r.getConstraints()) {
					if (c instanceof TypeConstraint) {
						foundTypeConstraint = true;
					}
					if (c instanceof OrConstraint) {
						for (Constraint c2 : (List<Constraint>) c.getConstraints()) {
							if (c2 instanceof TypeConstraint) {
								foundTypeConstraint = true;
								break;
							}
						}
					}
					if (foundTypeConstraint) {
						break;
					}
				}
				if (r.getDmoEType() == null && !foundTypeConstraint) {
					requirementsHaveValidDMOTypeOrTypeConstraint = false;
					if (errors.length() > 0) {
						errors.append("\n");
					}
					if (top.getDescription() != null) {
						errors.append(top.getDescription());
					} else {
						errors.append(top.eResource().getURI());
					}
					errors.append(": ");
					errors.append("Unit  ");
					errors.append(DeployNLS.getName(u));
					errors.append(" has requirement ");
					errors.append(DeployNLS.getName(r));
					errors.append(" without valid dmoType or top level or ORed type constraint");
				}
			}
		}
		assertTrue(errors.toString(), requirementsHaveValidDMOTypeOrTypeConstraint);
	}
}
