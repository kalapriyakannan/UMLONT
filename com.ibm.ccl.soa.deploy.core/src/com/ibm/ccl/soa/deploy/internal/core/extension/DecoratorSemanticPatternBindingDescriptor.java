/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a layer around an IConfigurationElement from
 * <b>com.ibm.ccl.soa.deploy.core.topology/decoratorSemanticPatternBinding</b>
 * 
 * @since 1.0
 * 
 */
public class DecoratorSemanticPatternBindingDescriptor extends CommonDescriptor {

	private String decoratorSemanticId;

	private DecoratorSemanticPatternDescriptor[] includeTypePatternDesciptors;
	private DecoratorSemanticPatternDescriptor[] excludeTypePatternDesciptors;

	private DecoratorSemanticPatternDescriptor[] includeMenuPatternDescriptors;
	private DecoratorSemanticPatternDescriptor[] excludeMenuPatternDescriptors;

	private DecoratorSemanticPatternDescriptor[] includeValidatorPatternDescriptors;
	private DecoratorSemanticPatternDescriptor[] excludeValidatorPatternDescriptors;

	private DecoratorSemanticPatternDescriptor[] includeViewPatternDescriptors;
	private DecoratorSemanticPatternDescriptor[] excludeViewPatternDescriptors;

	private DecoratorSemanticPatternDescriptor[] includePropertySheetPatternDescriptors;
	private DecoratorSemanticPatternDescriptor[] excludePropertySheetPatternDescriptors;

	private DecoratorSemanticPatternDescriptor[] includePaletteEntryPatternDescriptors;
	private DecoratorSemanticPatternDescriptor[] excludePaletteEntryPatternDescriptors;

	private DecoratorSemanticPatternDescriptor[] includeUnitProviderPatternDescriptors;
	private DecoratorSemanticPatternDescriptor[] excludeUnitProviderPatternDescriptors;

	private DecoratorSemanticPatternDescriptor[] includeContentProviderPatternDescriptors;
	private DecoratorSemanticPatternDescriptor[] excludeContentProviderPatternDescriptors;

	private Map includeUserDefinedPatternDescriptors;
	private Map excludeUserDefinedPatternDescriptors;

	/**
	 * Create a descriptor for elements with the name "decoratorSemanticPatternBinding" that are
	 * defined as part of a <b>com.ibm.ccl.soa.deploy.core.topology</b> extension point.
	 * 
	 * @param anElement
	 *           An element with the name "decoratorSemanticPatternBinding" that conforms to the
	 *           schema of <b>com.ibm.ccl.soa.deploy.core.topology/decoratorSemanticPatternBinding</b>.
	 */
	public DecoratorSemanticPatternBindingDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_DECORATOR_SEMANTIC_PATTERN_BINDING.equals(anElement.getName());
		init();
	}

	private void init() {
		decoratorSemanticId = getElement().getAttribute(ATT_DECORATOR_SEMANTIC_ID) == null ? EMPTY_STRING
				: getElement().getAttribute(ATT_DECORATOR_SEMANTIC_ID);

		includeTypePatternDesciptors = loadPatternDescriptors(TAG_TYPE_CONTENT, true);
		excludeTypePatternDesciptors = loadPatternDescriptors(TAG_TYPE_CONTENT, false);
		includeMenuPatternDescriptors = loadPatternDescriptors(TAG_MENU_CONTENT, true);
		excludeMenuPatternDescriptors = loadPatternDescriptors(TAG_MENU_CONTENT, false);
		includeValidatorPatternDescriptors = loadPatternDescriptors(TAG_VALIDATOR_CONTENT, true);
		excludeValidatorPatternDescriptors = loadPatternDescriptors(TAG_VALIDATOR_CONTENT, false);
		includeViewPatternDescriptors = loadPatternDescriptors(TAG_VIEW_CONTENT, true);
		excludeViewPatternDescriptors = loadPatternDescriptors(TAG_VIEW_CONTENT, false);
		includeUnitProviderPatternDescriptors = loadPatternDescriptors(TAG_UNIT_PROVIDER_CONTENT,
				true);
		excludeUnitProviderPatternDescriptors = loadPatternDescriptors(TAG_UNIT_PROVIDER_CONTENT,
				false);
		includePaletteEntryPatternDescriptors = loadPatternDescriptors(TAG_PALETTE_ENTRY_CONTENT,
				true);
		excludePaletteEntryPatternDescriptors = loadPatternDescriptors(TAG_PALETTE_ENTRY_CONTENT,
				false);
		includePropertySheetPatternDescriptors = loadPatternDescriptors(TAG_PROPERTY_SHEET_CONTENT,
				true);
		excludePropertySheetPatternDescriptors = loadPatternDescriptors(TAG_PROPERTY_SHEET_CONTENT,
				false);
		includeContentProviderPatternDescriptors = loadPatternDescriptors(
				TAG_CONTENT_PROVIDER_CONTENT, true);
		excludeContentProviderPatternDescriptors = loadPatternDescriptors(
				TAG_CONTENT_PROVIDER_CONTENT, false);
		loadUserDefinedPatternDescriptors(TAG_USER_DEFINED_CONTENT, true);
		loadUserDefinedPatternDescriptors(TAG_USER_DEFINED_CONTENT, false);

	}

	private DecoratorSemanticPatternDescriptor[] loadPatternDescriptors(String elementType,
			boolean include) {
		DecoratorSemanticPatternDescriptor[] descriptors = null;
		IConfigurationElement[] contents = getElement().getChildren(elementType);
		String contentType = include ? TAG_INCLUDE : TAG_EXCLUDE;

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
				IConfigurationElement[] values = contentElement.getChildren(contentType);
				if (values != null) {
					descriptors = new DecoratorSemanticPatternDescriptor[values.length];
					for (int i = 0; i < values.length; i++) {
						descriptors[i] = new DecoratorSemanticPatternDescriptor(values[i]);
					}
				}
			}
		}
		return descriptors;
	}

	private void loadUserDefinedPatternDescriptors(String elementType, boolean include) {
		DecoratorSemanticPatternDescriptor[] descriptors = null;
		IConfigurationElement[] contents = getElement().getChildren(elementType);
		String contentType = include ? TAG_INCLUDE : TAG_EXCLUDE;

		if (contents != null) {
			for (int j = 0; j < contents.length; j++) {
				IConfigurationElement contentElement = contents[j];
				String name = contentElement.getAttribute(ATT_NAME);
				IConfigurationElement[] values = contentElement.getChildren(contentType);
				if (values != null) {
					descriptors = new DecoratorSemanticPatternDescriptor[values.length];
					for (int i = 0; i < values.length; i++) {
						descriptors[i] = new DecoratorSemanticPatternDescriptor(values[i]);
					}
				}
				// TODO if descriptos.get(name) returns something, this is an error.  They used the same name twice in the same binding.
				if (descriptors.length > 0) {
					if (include) {
						if (includeUserDefinedPatternDescriptors == null) {
							includeUserDefinedPatternDescriptors = new HashMap();
						}
						includeUserDefinedPatternDescriptors.put(name, descriptors);
					} else {
						if (excludeUserDefinedPatternDescriptors == null) {
							excludeUserDefinedPatternDescriptors = new HashMap();
						}
						excludeUserDefinedPatternDescriptors.put(name, descriptors);
					}
				}
			}
		}
	}

	/**
	 * @return The value of the decoratorSemanticId attribute from the extension. (Already
	 *         externalized and ready for display).
	 */
	public String getDecoratorSemanticId() {
		return decoratorSemanticId;
	}

	/**
	 * 
	 * @return the included type pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getIncludeTypePatternDescriptors() {
		return includeTypePatternDesciptors;
	}

	/**
	 * @return the excluded type pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getExcludeTypePatternDescriptors() {
		return excludeTypePatternDesciptors;
	}

	/**
	 * @return the excluded menu pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getExcludeMenuPatternDescriptors() {
		return excludeMenuPatternDescriptors;
	}

	/**
	 * @return the excluded validator pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getExcludeValidatorPatternDescriptors() {
		return excludeValidatorPatternDescriptors;
	}

	/**
	 * @return the included menu pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getIncludeMenuPatternDescriptors() {
		return includeMenuPatternDescriptors;
	}

	/**
	 * @return the included validator pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getIncludeValidatorPatternDescriptors() {
		return includeValidatorPatternDescriptors;
	}

	/**
	 * @return the excluded palette entry pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getExcludePaletteEntryPatternDescriptors() {
		return excludePaletteEntryPatternDescriptors;
	}

	/**
	 * @return the excluded property sheet pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getExcludePropertySheetPatternDescriptors() {
		return excludePropertySheetPatternDescriptors;
	}

	/**
	 * @return the excluded unit provider pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getExcludeUnitProviderPatternDescriptors() {
		return excludeUnitProviderPatternDescriptors;
	}

	/**
	 * @return the excluded view pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getExcludeViewPatternDescriptors() {
		return excludeViewPatternDescriptors;
	}

	/**
	 * @return the excluded content provider pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getExcludeContentProviderPatternDescriptors() {
		return excludeContentProviderPatternDescriptors;
	}

	/**
	 * @return the included palette entry pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getIncludePaletteEntryPatternDescriptors() {
		return includePaletteEntryPatternDescriptors;
	}

	/**
	 * @return the included property sheet pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getIncludePropertySheetPatternDescriptors() {
		return includePropertySheetPatternDescriptors;
	}

	/**
	 * @return the included unit provider pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getIncludeUnitProviderPatternDescriptors() {
		return includeUnitProviderPatternDescriptors;
	}

	/**
	 * @return the included view pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getIncludeViewPatternDescriptors() {
		return includeViewPatternDescriptors;
	}

	/**
	 * @return the included content provider pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getIncludeContentProviderPatternDescriptors() {
		return includeContentProviderPatternDescriptors;
	}

	/**
	 * @param name
	 *           the name attribute for the user defined decorator semantic
	 * @return the included user defined pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getIncludeUserDefinedPatternDescriptors(String name) {
		if (includeUserDefinedPatternDescriptors == null) {
			return null;
		}
		return (DecoratorSemanticPatternDescriptor[]) includeUserDefinedPatternDescriptors.get(name);
	}

	/**
	 * @param name
	 *           the name attribute for the user defined decorator semantic
	 * @return the excluded user defined pattern descriptors for this semantic binding
	 */
	public DecoratorSemanticPatternDescriptor[] getExcludeUserDefinedPatternDescriptors(String name) {
		if (excludeUserDefinedPatternDescriptors == null) {
			return null;
		}
		return (DecoratorSemanticPatternDescriptor[]) excludeUserDefinedPatternDescriptors.get(name);
	}
}
