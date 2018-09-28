/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

/**
 * @since 1.0
 * 
 */
public interface ICommonDeployExtensionConstants {

	/** The string {@value #ATT_NAME }. */
	String ATT_NAME = "name"; //$NON-NLS-1$

	/** The string {@value #ATT_DESCRIPTION } . */
	String ATT_DESCRIPTION = "description"; //$NON-NLS-1$

	/** The string {@value #ATT_CLASS }. */
	final String ATT_CLASS = "class"; //$NON-NLS-1$ 

	/** The string {@value #ATT_ID }. */
	final String ATT_ID = "id"; //$NON-NLS-1$

	/** The string {@value #ATT_TEMPLATE_URI }. */
	final String ATT_TEMPLATE_URI = "templateURI"; //$NON-NLS-1$

	/** The string {@value #ATT_TEMPLATE_URI }. */
	final String ATT_TEMPLATEV_URI = "diagramPath"; //$NON-NLS-1$

	/** The string {@value #ATT_ECLASS }. */
	final String ATT_ECLASS = "eclass"; //$NON-NLS-1$

	/** The string {@value #ATT_TARGET_NAMESPACE }. */
	final String ATT_TARGET_NAMESPACE = "targetNamespace"; //$NON-NLS-1$

	/** The string {@value #ATT_ICON }. */
	final String ATT_ICON = "icon"; //$NON-NLS-1$

	/** The string {@value #ATT_RESOURCE_TYPE_ID }. */
	final String ATT_RESOURCE_TYPE_ID = "resourceTypeId"; //$NON-NLS-1$

	/** The string {@value #ATT_PATH }. */
	final String ATT_PATH = "path"; //$NON-NLS-1$

	/** The string {@value #ATT_LABEL }. */
	final String ATT_LABEL = "label"; //$NON-NLS-1$

	/** The string {@value #ATT_SMALL_ICON }. */
	final String ATT_SMALL_ICON = "smallIcon"; //$NON-NLS-1$

	/** The string {@value #ATT_LARGE_ICON }. */
	final String ATT_LARGE_ICON = "largeIcon"; //$NON-NLS-1$

	/** The string {@value #ENABLE_PALETTE }. */
	final String ENABLE_PALETTE = "enablePalette"; //$NON-NLS-1$

	/** The string {@value #ATT_CONTEXT }. */
	final String ATT_CONTEXT = "context"; //$NON-NLS-1$

	/** The string {@value #TAG_ENABLEMENT }. */
	String TAG_ENABLEMENT = "enablement"; //$NON-NLS-1$

	/** The string {@value #TAG_INPUT_ENABLEMENT }. */
	String TAG_INPUT_ENABLEMENT = "inputEnablement"; //$NON-NLS-1$

	/** The string {@value #TAG_OUTPUT_ENABLEMENT }. */
	String TAG_OUTPUT_ENABLEMENT = "outputEnablement"; //$NON-NLS-1$

	/** The string {@vaule #TAG_HOST_ENABLEMENT }. */
	String TAG_HOST_ENABLEMENT = "hostEnablement"; //$NON-NLS-1$

	/** The string {@value #TAG_DOMAINS }. */
	String TAG_DOMAINS = "domains"; //$NON-NLS-1$

	/** The string {@value #TAG_DOMAIN }. */
	String TAG_DOMAIN = "domain"; //$NON-NLS-1$

	/** The string {@value #TAG_TOPOLOGY }. */
	String TAG_TOPOLOGY = "topology"; //$NON-NLS-1$

	/** The string {@value #TAG_EXPORTER }. */
	String TAG_EXPORTER = "exporter"; //$NON-NLS-1$

	/** The string {@value #TAG_DISCOVERER }. */
	String TAG_DISCOVERER = "discoverer"; //$NON-NLS-1$

	/** The string {@value #TAG_UNIT_DISCOVERER }. */
	String TAG_UNIT_DISCOVERER = "unitDiscoverer"; //$NON-NLS-1$

	/** The string {@value #TAG_DECORATOR_SEMANTIC }. */
	String TAG_DECORATOR_SEMANTIC = "decoratorSemantic"; //$NON-NLS-1$

	/** The string {@value #TAG_DECORATOR_SEMANTIC_PATTERN_BINDING }. */
	String TAG_DECORATOR_SEMANTIC_PATTERN_BINDING = "decoratorSemanticPatternBinding"; //$NON-NLS-1$

	/** The string {@value #ATT_DECORATOR_SEMANTIC_ID }. */
	final String ATT_DECORATOR_SEMANTIC_ID = "decoratorSemanticId"; //$NON-NLS-1$

	/** The string {@value #TAG_TYPE_CONTENT }. */
	String TAG_TYPE_CONTENT = "typeContent"; //$NON-NLS-1$

	/** The string {@value #TAG_ID_CONTENT }. */
	String TAG_ID_CONTENT = "idContent"; //$NON-NLS-1$

	/** The string {@value #TAG_MENU_CONTENT }. */
	String TAG_MENU_CONTENT = "menuContent"; //$NON-NLS-1$

	/** The string {@value #TAG_VALIDATOR_CONTENT }. */
	String TAG_VALIDATOR_CONTENT = "validatorContent"; //$NON-NLS-1$

	/** The string {@value #TAG_VIEW_CONTENT }. */
	String TAG_VIEW_CONTENT = "viewContent"; //$NON-NLS-1$

	/** The string {@value #TAG_PALETTE_ENTRY_CONTENT }. */
	String TAG_PALETTE_ENTRY_CONTENT = "paletteEntryContent"; //$NON-NLS-1$

	/** The string {@value #TAG_PROPERTY_SHEET_CONTENT }. */
	String TAG_PROPERTY_SHEET_CONTENT = "propertySheetContent"; //$NON-NLS-1$

	/** The string {@value #TAG_UNIT_PROVIDER_CONTENT }. */
	String TAG_UNIT_PROVIDER_CONTENT = "unitProviderContent"; //$NON-NLS-1$

	/** The string {@value #TAG_LOGICAL_LINK_CONTENT }. */
	String TAG_LOGICAL_LINK_CONTENT = "logicalLinkContent"; //$NON-NLS-1$

	/** The string {@value #TAG_CONTENT_PROVIDER_CONTENT }. */
	String TAG_CONTENT_PROVIDER_CONTENT = "contentProviderContent"; //$NON-NLS-1$

	/** The string {@value #TAG_USER_DEFINED_CONTENT }. */
	String TAG_USER_DEFINED_CONTENT = "userDefinedContent"; //$NON-NLS-1$

	/** The string {@value #TAG_INCLUDE }. */
	String TAG_INCLUDE = "include"; //$NON-NLS-1$

	/** The string {@value #TAG_EXCLUDE }. */
	String TAG_EXCLUDE = "exclude"; //$NON-NLS-1$

	/** The string {@value #ATT_PATTERN }. */
	final String ATT_PATTERN = "pattern"; //$NON-NLS-1$

	/** The string {@value #ATT_CONTENT }. */
	final String ATT_CONTENT = "content"; //$NON-NLS-1$

	/** The string {@value #TAG_EXPLICIT_ENTRY }. */
	final String TAG_EXPLICIT_ENTRY = "explicit-entry"; //$NON-NLS-1$

	/** The string {@value #TAG_PUBLISHER }. */
	String TAG_PUBLISHER = "publisher"; //$NON-NLS-1$

	/** The string {@value #TAG_VALIDATOR }. */
	String TAG_VALIDATOR = "validator"; //$NON-NLS-1$

	/** The string {@value #TAG_PACKAGER }. */
	String TAG_PACKAGER = "packager"; //$NON-NLS-1$

	/** The string {@value #TAG_UNIT_PROVIDER }. */
	String TAG_UNIT_PROVIDER = "unitProvider"; //$NON-NLS-1$

	/** The string {@value #TAG_UNIT_AMPLIFIER }. */
	String TAG_UNIT_AMPLIFIER = "unitAmplifier"; //$NON-NLS-1$

	/** The string {@value #TAG_CAPABILITY_PROVIDER }. */
	String TAG_CAPABILITY_PROVIDER = "capabilityProvider"; //$NON-NLS-1$

	/** The string {@value #TAG_RESOURCE_TYPE }. */
	String TAG_RESOURCE_TYPE = "resourceType"; //$NON-NLS-1$

	/** The string {@value #resourceTypeBinding }. */
	String TAG_RESOURCE_TYPE_BINDING = "resourceTypeBinding"; //$NON-NLS-1$

	/** The string {@value #resourceTypeUIBinding }. */
	String TAG_RESOURCE_TYPE_UI_BINDING = "resourceTypeUIBinding"; //$NON-NLS-1$

	/** The string {@value #TAG_UNIT_FILTER }. */
	String TAG_UNIT_FILTER = "unitFilter"; //$NON-NLS-1$

	/** The string {@value #TAG_UNIT_PROVIDER }. */
	String TAG_UNIT_PUBLISHER = "unitPublisher"; //$NON-NLS-1$

	/** The string {@value #TAG_UNIT_LIFECYCLE }. */
	String TAG_UNIT_LIFECYCLE = "unitLifecycle"; //$NON-NLS-1$

	/** The string {@value #TAG_DECORATOR_SEMANTIC_BINDING_RULE }. */
	String TAG_DECORATOR_SEMANTIC_BINDING_RULE = "decoratorSemanticBindingRule"; //$NON-NLS-1$

	//
	// Resolution tags
	//

	/** The string {@value} */
	String TAG_RESOLUTION_GENERATORS = "resolutionGenerators"; //$NON-NLS-1$

	/** The string {@value} */
	String TAG_RESOLUTION_GENERATOR = "resolutionGenerator"; //$NON-NLS-1$

	/** The string {@value} */
	String TAG_RESOLUTION_PARAMETERIZER = "resolutionParameterizer"; //$NON-NLS-1$

	//
	// Logical Link tags
	//

	/** The string {@value #TAG_LOGICAL_LINKS} */
	String TAG_LOGICAL_LINKS = "logicalLinks"; //$NON-NLS-1$

	/** The string {@value #TAG_LOGICAL_LINK} */
	String TAG_LOGICAL_LINK = "logicalLink"; //$NON-NLS-1$

	/** The string {@value #TAG_MATCHER} */
	String TAG_MATCHER = "matcher"; //$NON-NLS-1$

	/** The string {@value #TAG_TESTER} */
	String TAG_TESTER = "tester"; //$NON-NLS-1$

	/** The string {@value #TAG_IMPLEMENTATIONS} */
	String TAG_IMPLEMENTATIONS = "implementations"; //$NON-NLS-1$

	/** The string {@value #TAG_IMPLEMENTATION} */
	String TAG_IMPLEMENTATION = "implementation"; //$NON-NLS-1$

	/** The string {@value #TAG_SYNCHRONIZATION_PARTICIPANT} */
	String TAG_SYNCHRONIZATION_PARTICIPANT = "synchronizationParticipant"; //$NON-NLS-1$

	//
	// Constraint tags
	//

	/** The string {@value #TAG_CONSTRAINT} */
	String TAG_CONSTRAINT = "constraint"; //$NON-NLS-1$

	/** The string {@value #TAG_CONSTRAINTS} */
	String TAG_CONSTRAINTS = "constraints"; //$NON-NLS-1$

	/** The string {@value #ATT_DISPLAY_NAME} */
	String ATT_DISPLAY_NAME = "displayName"; //$NON-NLS-1$

	/** The string {@value #ATT_NAMESPACE} */
	String ATT_NAMESPACE = "namespace"; //$NON-NLS-1$

	/** The string {@value #ATT_TYPE} */
	String ATT_TYPE = "type"; //$NON-NLS-1$

	/** The string {@value #TAG_FACTORY} */
	String TAG_FACTORY = "factory"; //$NON-NLS-1$

	/** The string {@value #TAG_LINK_MATCHER} */
	String TAG_LINK_MATCHER = "linkMatcher"; //$NON-NLS-1$

	/** The string {@value #TAG_PARENT_ENABLEMENT} */
	String TAG_PARENT_ENABLEMENT = "parentEnablement"; //$NON-NLS-1$

	/** The string {@value #TAG_CONTEXT_ENABLEMENT} */
	String TAG_CONTEXT_ENABLEMENT = "contextEnablement"; //$NON-NLS-1$
}
