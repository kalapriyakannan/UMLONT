/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.extension;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.extension.DecoratorSemanticListener;

/**
 * Provides a management layer for <b>com.ibm.ccl.soa.deploy.core.topology/decoratorSemantic</b>
 * extensions.
 * 
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 * @since 1.0
 * 
 */
public interface IDecoratorSemanticService {

	/**
	 * @return an array of Strings representing all the enabled decorator semantics
	 */
	public String[] getAllDecoratorSemanticNames();

	/**
	 * @param semanticName
	 *           the name of the decorator semantic
	 * @return the description of the specified decorator semantic name
	 */
	public String getDecoratorSemanticDescription(String semanticName);

	/**
	 * @param semanticName
	 *           the name of the decorator semantic
	 * @return the description of the specified decorator semantic name
	 */
	public String getDecoratorSemanticId(String semanticName);

	/**
	 * @param semanticId
	 *           the name of the decorator semantic
	 * @return the name of the specified decorator semantic id
	 */
	public String getDecoratorSemanticName(String semanticId);

	/**
	 * @param semanticId
	 *           the name of the decorator semantic
	 * @return the icon of the specified decorator semantic id
	 */
	public String getDecoratorSemanticIcon(String semanticId);

	/**
	 * @param decoratorSemanticId
	 *           the decorator semantic to query against
	 * @param dmo
	 *           the Deploy Model object to query against
	 * @return true if the specified DeployModelObject is enabled as namespace content for the
	 *         specified decorator semantic
	 */
	public boolean isDmoMemberOf(String decoratorSemanticId, DeployModelObject dmo);

	/**
	 * @param decoratorSemanticId
	 *           the decorator semantic to query against
	 * @param menuId
	 *           the menu ID of the UI artifact to query against
	 * @return true if the menuID is enabled as menu content for the specified decorator semantic
	 */
	public boolean isMenuMemberOf(String decoratorSemanticId, String menuId);

	/**
	 * @param decoratorSemanticId
	 *           the decorator semantic to query against
	 * @param validatorID
	 *           the view ID
	 * @return true if the view ID is enabled as view content for the specified decorator semantic
	 */
	public boolean isViewMemberOf(String decoratorSemanticId, String viewID);

	/**
	 * @param decoratorSemanticId
	 *           the decorator semantic to query against
	 * @param propertyId
	 *           the property sheet ID
	 * @return true if the property sheet ID is enabled as property sheet content for the specified
	 *         decorator semantic
	 */
	public boolean isPropertySheetMemberOf(String decoratorSemanticId, String propertyId);

	/**
	 * @param decoratorSemanticId
	 *           the decorator semantic to query against
	 * @param paletteId
	 *           the palette entry ID
	 * @return true if the palette entry ID is enabled as palette entry content for the specified
	 *         decorator semantic
	 */
	public boolean isPaletteEntryMemberOf(String decoratorSemanticId, String paletteId);

	/**
	 * @param decoratorSemanticId
	 *           the decorator semantic to query against
	 * @param contentProviderId
	 *           the contentProviderId
	 * @return true if the contentProviderId is enabled as content provider content for the specified
	 *         decorator semantic
	 */
	public boolean isContentProviderMemberOf(String decoratorSemanticId, String contentProviderId);

	/**
	 * @param decoratorSemanticId
	 *           the decorator semantic to query against
	 * @param userCategory
	 *           the name of the userDefinedContent category defined for this decorator semantic
	 * @param contentItem
	 *           the item to check for existence in this decorator semantic
	 * @return true if item is enabled as user defined content for the specified decorator semantic
	 */
	public boolean isUserContentMemberOf(String decoratorSemanticId, String userCategory,
			String contentItem);

	/**
	 * Will determine if the specified palette entry is a valid explicit entry content. True if the
	 * palette entry is listed in a decorator semantic binding rule AND if the rule definition exists
	 * in the same plugin as the palette entry definition itself.
	 * 
	 * @param paletteId
	 *           The class of the palette entry
	 * @return true if the specified content is explicit entry content
	 */
	public boolean isPaletteEntryExplicitEntry(String paletteId);

	/**
	 * Will determine if the specified menu is a valid explicit entry content. True if the menu is
	 * listed in a decorator semantic binding rule AND if the rule definition exists in the same
	 * plugin as the menu definition itself.
	 * 
	 * @param menuId
	 *           The class of the menu
	 * @return true if the specified content is explicit entry content
	 */
	public boolean isMenuExplicitEntry(String menuId);

	/**
	 * Will determine if the specified view is a valid explicit entry content. True if the view is
	 * listed in a decorator semantic binding rule AND if the rule definition exists in the same
	 * plugin as the view definition itself.
	 * 
	 * @param viewId
	 *           The class of the view
	 * @return true if the specified content is explicit entry content
	 */
	public boolean isViewExplicitEntry(String viewId);

	/**
	 * Will determine if the specified property sheet is a valid explicit entry content. True if the
	 * property sheet is listed in a decorator semantic binding rule AND if the rule definition
	 * exists in the same plugin as the property sheet definition itself.
	 * 
	 * @param propertySheetId
	 *           The class of the property sheet
	 * @return true if the specified content is explicit entry content
	 */
	public boolean isPropertySheetExplicitEntry(String propertySheetId);

	/**
	 * Will determine if the specified content provider is a valid explicit entry content. True if
	 * the content provider is listed in a decorator semantic binding rule AND if the rule definition
	 * exists in the same plugin as the content provider definition itself.
	 * 
	 * @param contentProviderId
	 *           The class of the content provider
	 * @return true if the specified content is explicit entry content
	 */
	public boolean isContentProviderExplicitEntry(String contentProviderId);

	/**
	 * Will determine if the specified deploy model object is a valid explicit entry content. True if
	 * the dmo is listed in a decorator semantic binding rule AND if the rule definition exists in
	 * the same plugin as the dmo class itself.
	 * 
	 * @param dmo
	 *           The deploy model object
	 * @return true if the specified content is explicit entry content
	 */
	public boolean isDmoExplicitEntry(DeployModelObject dmo);

	/**
	 * Notify all registered listeners of decorator semantic listener for any changes
	 */
	public void fireDecoratorSemanticChanged();

	/**
	 * Add the decorator semantic listener
	 * 
	 * @param listener
	 *           the decorator semantic listerner to add
	 */
	public void addDecoratorSemanticChangeListener(DecoratorSemanticListener listener);

	/**
	 * Remove the decorator semantic listener
	 * 
	 * @param listener
	 *           the decorator semantic listerner to remove
	 */
	public void removeDecoratorSemanticChangeListener(DecoratorSemanticListener listener);

}
