/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;

/**
 * Provide suggestions for {@link Unit}s that may be hosted by, or a member of, this Unit.
 * 
 * <p>
 * The returned Lists can contain simple Strings, {@link UnitFilter.UnitFilterTemplate}s,
 * {@link UnitFilter.UnitFilterAction}s, and Lists of the above. Simple Strings are interpreted by
 * the {@link ResourceTypeService}.
 * 
 * <p>
 * Any element is potentially deployable. Clients must describe to the SOA Topology Modeler
 * framework which elements may be deployed using the
 * <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitFilter</b> extension point. That extension
 * point requires clients to supply a subclass of <code>UnitFilter</code>. The client
 * implementation will only be invoked when an element matching the expression defined by the
 * client's extension is encountered.
 * 
 * <p>
 * Please refer to the extension point documentation for
 * <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitFilter</b> for more information.
 * 
 * 
 * @since 1.0
 * @see DeployableUnitElementUIService
 */
public abstract class UnitFilter {

	/**
	 * a hosting unit type
	 */
	public static final int HOSTEE = 0;

	/**
	 * a member unit type
	 */
	public static final int MEMBER = 1;

	/**
	 * a capability/service nub type
	 */
	public static final int NUB = 2;

	/**
	 * Get the allowable unit type Id's that can be hosted in this unit
	 * 
	 * @param anInputUnit
	 *           pass the input unit
	 * @return List of allowable hosting unit type ID's
	 * 
	 * (formerly deprecated) Use {@link #getAllowableConfigurationUnitTypes(Unit)}
	 */
	public List getAllowableHostingUnitTypes(Unit anInputUnit) {
		return getAllowableConfigurationUnitTypes(anInputUnit);
	}

	/**
	 * Get the allowable unit type Id's that can be hosted in this unit
	 * 
	 * @param anInputUnit
	 *           pass the input unit
	 * @return List of allowable hosting unit type ID's
	 * 
	 */
	public List getAllowableConfigurationUnitTypes(Unit anInputUnit) {
		return null;
	}

	/**
	 * Get the allowable unit type eClass objects that can be hosted on this unit.
	 * 
	 * @param anInputUnit
	 *           pass the input unit
	 * @return List of EClass objects for the unit types that the passed in unit allows to be hosted
	 *         on it.
	 */
	public List getAllowableUnitHostingTypes(Unit anInputUnit) {
		return null;
	}

	/**
	 * Get the allowable unit type Id's that can be member of this unit
	 * 
	 * @param anInputUnit
	 *           anInputUnit pass the input unit
	 * @return List of allowable member unit type ID's
	 */
	public List getAllowableMemberUnitTypes(Unit anInputUnit) {
		return null;
	}

	/**
	 * Get the allowable deploy model object type Id's that can be a nub on a unit (ex: Service,
	 * Reference)
	 * 
	 * @param anInputUnit
	 *           anInputUnit pass the input unit
	 * @return List of allowable member unit type ID's
	 */
	public List getAllowableNubDmoTypes(Unit anInputUnit) {
		return null;
	}

	/**
	 * @return <code>true</code> if the get-methods may return different values in the future for
	 *         this object. Volatile serves as a hint to not cache the results.
	 */
	public boolean isVolatile() {
		return false;
	}

	/**
	 * UnitFilterAction represents an arbitrary action that can be returned by a UnitFilter.
	 */
	public static abstract class UnitFilterAction {
		protected String name;
		protected String path;

		/**
		 * @param nameForMenu
		 * @param iconPath
		 */
		public UnitFilterAction(String nameForMenu, String iconPath) {
			name = nameForMenu;
			path = iconPath;
		}

		/**
		 * @return a human-readable name, for menus etc.
		 */
		public String getText() {
			return name;
		}

		/**
		 * @return an icon for menus, etc.
		 */
		public String getImagePath() {
			return path;
		}

		/**
		 * Execute this 'action'. The caller will have set up a transaction if one is needed.
		 * 
		 * @param context
		 *           the Unit which is being filtered
		 * @param outDmosToReveal
		 *           run() should add DMOs it creates, so that the UI may select them
		 * @return <code>Status.OK</code> if successful
		 */
		public abstract IStatus run(Unit context, List<DeployModelObject> outDmosToReveal);
	} // end inner class UnitFilterAction

	/**
	 * UnitFilterTemplate represents a topology .template that can be returned by a UnitFilter.
	 */
	public static class UnitFilterTemplate {
		protected String name;
		protected String path;
		protected String templateURI;

		/**
		 * @param nameForMenu
		 * @param iconPath
		 * @param uri
		 */
		public UnitFilterTemplate(String nameForMenu, String iconPath, String uri) {
			name = nameForMenu;
			path = iconPath;
			templateURI = uri;
		}

		/**
		 * @return a human-readable name, for menus etc.
		 */
		public String getText() {
			return name;
		}

		/**
		 * @return an icon for menus, etc.
		 */
		public String getImagePath() {
			return path;
		}

		/**
		 * A template to be added to the current topology
		 * 
		 * @return the URI as a String
		 */
		public String getTemplateURI() {
			return templateURI;
		}
	} // end inner class UnitFilterTemplate

} // end class UnitFilter
