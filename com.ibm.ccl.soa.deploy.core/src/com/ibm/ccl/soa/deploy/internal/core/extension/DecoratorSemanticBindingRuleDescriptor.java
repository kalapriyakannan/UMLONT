/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a wrapper around <b>&lt;decoratorSemanticBindingRUle /&gt;</b> configuration elements
 * parsed from the <b>com.ibm.ccl.soa.deploy.core.domains</b> extension point.
 * 
 * @since 1.0
 * 
 */
public class DecoratorSemanticBindingRuleDescriptor extends CommonDescriptor {

	private final Map explicitEntryContentByType = new HashMap();
	private final String contributingPluginId;

	/**
	 * Only allow classes local to the package or subclasses to instantiate this element.
	 * 
	 * @param anElement
	 *           The "decoratorSemanticBindingRule" IConfigurationElement from the registry reader.
	 */
	protected DecoratorSemanticBindingRuleDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_DECORATOR_SEMANTIC_BINDING_RULE.equals(anElement.getName());
		contributingPluginId = anElement.getContributor().getName();
		init();
	}

	private void init() {
		//TODO
		explicitEntryContentByType.put(TAG_UNIT_PROVIDER_CONTENT,
				loadExplicitEntries(TAG_UNIT_PROVIDER_CONTENT));
		explicitEntryContentByType.put(TAG_VALIDATOR_CONTENT,
				loadExplicitEntries(TAG_VALIDATOR_CONTENT));
		explicitEntryContentByType.put(TAG_PALETTE_ENTRY_CONTENT,
				loadExplicitEntries(TAG_PALETTE_ENTRY_CONTENT));
	}

	private List loadExplicitEntries(String elementType) {
		List contentList = new ArrayList();
		IConfigurationElement[] contents = getElement().getChildren(elementType);

		if (contents != null) {
			if (contents.length > 1) {
				DeployCorePlugin
						.logError(
								0,
								NLS
										.bind(
												DeployCoreMessages.DecoratorSemanticPatternBindingDescriptor_Invalid_number_of_content_eleme_,
												new Object[] {
														elementType,
														getElement().getDeclaringExtension()
																.getExtensionPointUniqueIdentifier() }), null);

			} else if (contents.length == 1) {
				IConfigurationElement contentElement = contents[0];
				IConfigurationElement[] values = contentElement.getChildren(TAG_EXPLICIT_ENTRY);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						String content = values[i].getAttribute(ATT_CONTENT);
						if (content != null && content != EMPTY_STRING) {
							contentList.add(content);
						}
					}
				}
			}
		}
		return contentList;
	}

	/**
	 * 
	 * @return unit provider explicit entry contents
	 */
	public List getUnitProviderExplicitEntryContents() {
		return (List) explicitEntryContentByType.get(TAG_UNIT_PROVIDER_CONTENT);
	}

	/**
	 * 
	 * @return validator explicit entry contents
	 */
	public List getValidatorExplicitEntryContents() {
		return (List) explicitEntryContentByType.get(TAG_VALIDATOR_CONTENT);
	}

	/**
	 * 
	 * @return palette entry explicit entry contents
	 */
	public List getPaletteEntryExplicitEntryContents() {
		return (List) explicitEntryContentByType.get(TAG_PALETTE_ENTRY_CONTENT);
	}

	/**
	 * 
	 * @param contentType
	 *           the type of explicit entry content to retrieve
	 * @return the list of explicit entires for the content type
	 */
	public List getExplicitEntryContents(String contentType) {
		return (List) explicitEntryContentByType.get(contentType);
	}

	/**
	 * 
	 * @return the contributing plugin in
	 */
	public String getContributingPluginId() {
		return contributingPluginId;
	}
}
