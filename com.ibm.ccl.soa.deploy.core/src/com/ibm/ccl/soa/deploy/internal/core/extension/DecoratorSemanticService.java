/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * APIs for accessing Decorator Semantic content
 * 
 * @since 1.0
 * 
 * Supported categories: - content provider - object type (DMO) - menu - palette entry - property
 * sheet - unit provider - validator - view - user-defined content
 */
public class DecoratorSemanticService implements IDecoratorSemanticService,
		ICommonDeployExtensionConstants {
	/**
	 * Create a new instance of decorator semantic
	 * 
	 * @return the instance of the decorator semantic
	 */
	private static DecoratorSemanticService service;

	/**
	 * get the decorator semantic
	 * 
	 * @return the decorator semantic
	 */
	public static final DecoratorSemanticService getDecoratorSemantic() {
		if (service == null) {
			service = new DecoratorSemanticService();
		}
		return service;
	}

	protected DecoratorSemanticService() {

	}

	private static final String EMPTY_STRING = ""; //$NON-NLS-1$
	private final List<DecoratorSemanticListener> changeListeners = new LinkedList<DecoratorSemanticListener>();

	/**
	 * @param listener
	 */
	public void addDecoratorSemanticChangeListener(DecoratorSemanticListener listener) {
		syncAddDecoratorSemanticChangeListener(listener);
	}

	protected synchronized void syncAddDecoratorSemanticChangeListener(
			DecoratorSemanticListener listener) {
		changeListeners.add(listener);
	}

	/**
	 * @param listener
	 */
	public void removeDecoratorSemanticChangeListener(DecoratorSemanticListener listener) {
		syncRemoveDecoratorSemanticChangeListener(listener);
	}

	protected synchronized void syncRemoveDecoratorSemanticChangeListener(
			DecoratorSemanticListener listener) {
		changeListeners.remove(listener);
	}

	/**
	 * Notifies registered listeners of change of decorator semantic
	 */
	public void fireDecoratorSemanticChanged() {
		syncFireDecoratorSemanticChanged();
	}

	synchronized protected void syncFireDecoratorSemanticChanged() {
		if (changeListeners == null) {
			return;
		}
		for (Iterator it = changeListeners.iterator(); it.hasNext();) {
			DecoratorSemanticListener listener = (DecoratorSemanticListener) it.next();
			listener.decoratorSemanticChanged();
		}
	}

	public String[] getAllDecoratorSemanticNames() {
		DecoratorSemanticDescriptor[] ds = TopologyManager.getInstance()
				.findAvailableDecoratorSemantics();
		String[] names = new String[ds.length];
		for (int i = 0; i < ds.length; i++) {
			names[i] = ds[i].getName();
		}
		return names;
	}

	public String getDecoratorSemanticDescription(String semanticName) {
		DecoratorSemanticDescriptor[] ds = TopologyManager.getInstance()
				.findAvailableDecoratorSemantics();
		for (int i = 0; i < ds.length; i++) {
			if (ds[i].getName().equals(semanticName)) {
				return ds[i].getDescription();
			}
		}
		return EMPTY_STRING;
	}

	public String getDecoratorSemanticId(String semanticName) {
		DecoratorSemanticDescriptor[] ds = TopologyManager.getInstance()
				.findAvailableDecoratorSemantics();
		for (int i = 0; i < ds.length; i++) {
			if (ds[i].getName().equals(semanticName)) {
				return ds[i].getId();
			}
		}
		return EMPTY_STRING;
	}

	public String getDecoratorSemanticName(String semanticId) {
		DecoratorSemanticDescriptor[] ds = TopologyManager.getInstance()
				.findAvailableDecoratorSemantics();
		for (int i = 0; i < ds.length; i++) {
			if (ds[i].getId().equals(semanticId)) {
				return ds[i].getName();
			}
		}
		return EMPTY_STRING;
	}

	public String getDecoratorSemanticIcon(String semanticId) {
		DecoratorSemanticDescriptor[] ds = TopologyManager.getInstance()
				.findAvailableDecoratorSemantics();
		for (int i = 0; i < ds.length; i++) {
			if (ds[i].getId().equals(semanticId)) {
				return ds[i].getIcon();
			}
		}
		return EMPTY_STRING;
	}

	public boolean isDmoMemberOf(String decoratorSemanticId, DeployModelObject dmo) {
		boolean explicitEntry = false;
		if (isDmoExplicitEntry(dmo)) {
			explicitEntry = true;
		}

		// If blank decorator semantic, return true unless item is explicit entry
		if (decoratorSemanticId == null || decoratorSemanticId.equals(EMPTY_STRING)) {
			if (explicitEntry) {
				return false;
			}
			return true;
		}

		DecoratorSemanticPatternBindingDescriptor[] bindings = TopologyManager.getInstance()
				.findDecoratorSemanticPatternBindings(decoratorSemanticId);
		if (bindings == null) {
			return false;
		}
		for (int i = 0; i < bindings.length; i++) {
			// If excluded, return false			
			DecoratorSemanticPatternDescriptor[] excludePatternDescriptors = bindings[i]
					.getExcludeTypePatternDescriptors();
			if (isMatch(excludePatternDescriptors, dmo)) {
				return false;
			}
		}

		for (int i = 0; i < bindings.length; i++) {
			// If included, return true
			DecoratorSemanticPatternDescriptor[] patternDescriptors = bindings[i]
					.getIncludeTypePatternDescriptors();
			if (isMatch(patternDescriptors, dmo)) {
				return true;
			}
		}
		return false;
	}

	public boolean isMenuMemberOf(String decoratorSemanticId, String menuId) {
		boolean explicitEntry = false;
		if (isMenuExplicitEntry(menuId)) {
			explicitEntry = true;
		}

		// If blank decorator semantic, return true unless item is explicit entry
		if (decoratorSemanticId == null || decoratorSemanticId.equals(EMPTY_STRING)) {
			if (explicitEntry) {
				return false;
			}
			return true;
		}

		DecoratorSemanticPatternBindingDescriptor[] bindings = TopologyManager.getInstance()
				.findDecoratorSemanticPatternBindings(decoratorSemanticId);
		if (bindings == null) {
			return false;
		}
		for (int i = 0; i < bindings.length; i++) {
			// If excluded, return false			
			DecoratorSemanticPatternDescriptor[] excludePatternDescriptors = bindings[i]
					.getExcludeMenuPatternDescriptors();
			if (isMatch(excludePatternDescriptors, menuId)) {
				return false;
			}
		}

		for (int i = 0; i < bindings.length; i++) {
			// If included, return true
			DecoratorSemanticPatternDescriptor[] patternDescriptors = bindings[i]
					.getIncludeMenuPatternDescriptors();
			if (isMatch(patternDescriptors, menuId, explicitEntry)) {
				return true;
			}

		}
		return false;
	}

	public boolean isViewMemberOf(String decoratorSemanticId, String viewID) {
		boolean explicitEntry = false;
		if (isViewExplicitEntry(viewID)) {
			explicitEntry = true;
		}

		// If blank decorator semantic, return true unless item is explicit entry
		if (decoratorSemanticId == null || decoratorSemanticId.equals(EMPTY_STRING)) {
			if (explicitEntry) {
				return false;
			}
			return true;
		}

		DecoratorSemanticPatternBindingDescriptor[] bindings = TopologyManager.getInstance()
				.findDecoratorSemanticPatternBindings(decoratorSemanticId);
		if (bindings == null) {
			return false;
		}
		for (int i = 0; i < bindings.length; i++) {
			// If excluded, return false			
			DecoratorSemanticPatternDescriptor[] excludePatternDescriptors = bindings[i]
					.getExcludeViewPatternDescriptors();
			if (isMatch(excludePatternDescriptors, viewID)) {
				return false;
			}
		}

		for (int i = 0; i < bindings.length; i++) {
			// If included, return true
			DecoratorSemanticPatternDescriptor[] patternDescriptors = bindings[i]
					.getIncludeViewPatternDescriptors();
			if (isMatch(patternDescriptors, viewID, explicitEntry)) {
				return true;
			}

		}
		return false;
	}

	public boolean isPropertySheetMemberOf(String decoratorSemanticId, String propertyId) {
		boolean explicitEntry = false;
		if (isPropertySheetExplicitEntry(propertyId)) {
			explicitEntry = true;
		}

		// If blank decorator semantic, return true unless item is explicit entry
		if (decoratorSemanticId == null || decoratorSemanticId.equals(EMPTY_STRING)) {
			if (explicitEntry) {
				return false;
			}
			return true;
		}

		DecoratorSemanticPatternBindingDescriptor[] bindings = TopologyManager.getInstance()
				.findDecoratorSemanticPatternBindings(decoratorSemanticId);
		if (bindings == null) {
			return false;
		}
		for (int i = 0; i < bindings.length; i++) {
			// If excluded, return false			
			DecoratorSemanticPatternDescriptor[] excludePatternDescriptors = bindings[i]
					.getExcludePropertySheetPatternDescriptors();
			if (isMatch(excludePatternDescriptors, propertyId)) {
				return false;
			}
		}

		for (int i = 0; i < bindings.length; i++) {
			// If included, return true
			DecoratorSemanticPatternDescriptor[] patternDescriptors = bindings[i]
					.getIncludePropertySheetPatternDescriptors();
			if (isMatch(patternDescriptors, propertyId, explicitEntry)) {
				return true;
			}

		}
		return false;
	}

	public boolean isPaletteEntryMemberOf(String decoratorSemanticId, String paletteId) {
		boolean explicitEntry = false;
		if (isPaletteEntryExplicitEntry(paletteId)) {
			explicitEntry = true;
		}

		// If blank decorator semantic, return true unless item is explicit entry
		if (decoratorSemanticId == null || decoratorSemanticId.equals(EMPTY_STRING)) {
			if (explicitEntry) {
				return false;
			}
			return true;
		}

		DecoratorSemanticPatternBindingDescriptor[] bindings = TopologyManager.getInstance()
				.findDecoratorSemanticPatternBindings(decoratorSemanticId);
		if (bindings == null) {
			return false;
		}
		for (int i = 0; i < bindings.length; i++) {
			// If excluded, return false			
			DecoratorSemanticPatternDescriptor[] excludePatternDescriptors = bindings[i]
					.getExcludePaletteEntryPatternDescriptors();
			if (isMatch(excludePatternDescriptors, paletteId)) {
				return false;
			}
		}

		for (int i = 0; i < bindings.length; i++) {
			// If included, return true
			DecoratorSemanticPatternDescriptor[] patternDescriptors = bindings[i]
					.getIncludePaletteEntryPatternDescriptors();
			if (isMatch(patternDescriptors, paletteId, explicitEntry)) {
				return true;
			}

		}
		return false;
	}

	public boolean isContentProviderMemberOf(String decoratorSemanticId, String contentProviderId) {
		boolean explicitEntry = false;
		if (isContentProviderExplicitEntry(contentProviderId)) {
			explicitEntry = true;
		}

		// If blank decorator semantic, return true unless item is explicit entry
		if (decoratorSemanticId == null || decoratorSemanticId.equals(EMPTY_STRING)) {
			if (explicitEntry) {
				return false;
			}
			return true;
		}

		DecoratorSemanticPatternBindingDescriptor[] bindings = TopologyManager.getInstance()
				.findDecoratorSemanticPatternBindings(decoratorSemanticId);
		if (bindings == null) {
			return false;
		}
		for (int i = 0; i < bindings.length; i++) {
			// If excluded, return false			
			DecoratorSemanticPatternDescriptor[] excludePatternDescriptors = bindings[i]
					.getExcludeContentProviderPatternDescriptors();
			if (isMatch(excludePatternDescriptors, contentProviderId)) {
				return false;
			}
		}

		for (int i = 0; i < bindings.length; i++) {
			// If included, return true
			DecoratorSemanticPatternDescriptor[] patternDescriptors = bindings[i]
					.getIncludeContentProviderPatternDescriptors();
			if (isMatch(patternDescriptors, contentProviderId, explicitEntry)) {
				return true;
			}

		}
		return false;
	}

	// TODO make this object based instead of string based?
	public boolean isUserContentMemberOf(String decoratorSemanticId, String userCategory,
			String contentItem) {
		DecoratorSemanticPatternBindingDescriptor[] bindings = TopologyManager.getInstance()
				.findDecoratorSemanticPatternBindings(decoratorSemanticId);
		if (bindings == null) {
			return false;
		}
		for (int i = 0; i < bindings.length; i++) {
			// If excluded, return false			
			DecoratorSemanticPatternDescriptor[] excludePatternDescriptors = bindings[i]
					.getExcludeUserDefinedPatternDescriptors(userCategory);
			if (isMatch(excludePatternDescriptors, contentItem)) {
				return false;
			}

		}

		for (int i = 0; i < bindings.length; i++) {
			// If included, return true
			DecoratorSemanticPatternDescriptor[] patternDescriptors = bindings[i]
					.getIncludeUserDefinedPatternDescriptors(userCategory);
			if (isMatch(patternDescriptors, contentItem)) {
				return true;
			}

		}
		return false;
	}

	private boolean isMatch(DecoratorSemanticPatternDescriptor[] descs, String id,
			boolean explicitEntry) {
		if (descs != null) {
			for (int j = 0; j < descs.length; j++) {
				Pattern pattern = descs[j].getPattern();
				// If explicit entry, must have exact string matching
				if (explicitEntry) {
					if (pattern.pattern().equals(id) && descs[j].isEnabled(id)) {
						return true;
					}
				}
				// If not explicit entry, can use pattern matching
				else {
					if (pattern.matcher(id).matches() && descs[j].isEnabled(id)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isMatch(DecoratorSemanticPatternDescriptor[] descs, String id) {
		return isMatch(descs, id, false);
	}

	private boolean isMatch(DecoratorSemanticPatternDescriptor[] descs, DeployModelObject dmo) {
		String id = dmo.eClass().getInstanceClass().getName();
		if (descs != null) {
			for (int j = 0; j < descs.length; j++) {
				Pattern pattern = descs[j].getPattern();
				if (pattern.matcher(id).matches() && descs[j].isEnabled(dmo)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isPaletteEntryExplicitEntry(String paletteId) {
		// TODO implement
		return false;
	}

	public boolean isMenuExplicitEntry(String menuId) {
		// TODO implement
		return false;
	}

	public boolean isViewExplicitEntry(String viewId) {
		// TODO implement
		return false;
	}

	public boolean isPropertySheetExplicitEntry(String propertySheetId) {
		// TODO implement
		return false;
	}

	public boolean isContentProviderExplicitEntry(String contentProviderId) {
		// TODO implement
		return false;
	}

	public boolean isDmoExplicitEntry(DeployModelObject dmo) {
		// TODO implement
		return false;
	}

	private void checkExplicitEntryError(String id, String contentType, String pluginId) {
		// Did not find ex-entry in local plugin
		String exEntrypluginId = DomainManager.getInstance().findPluginIdForContent(id, contentType);
		if (exEntrypluginId != null) {
			// If content is defined in a different plugin than the attempted explicit-entry declaration, log an error
			DeployCorePlugin.logError(0, NLS.bind(
					DeployCoreMessages.DecoratorSemanticBindingRuleDescriptor_Explicit_entry_not_local,
					new Object[] { id, exEntrypluginId, pluginId }), null);
		}
	}

}
