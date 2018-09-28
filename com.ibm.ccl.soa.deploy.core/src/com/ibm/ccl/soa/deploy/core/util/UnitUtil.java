/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Static deploy {@link Unit} utility methods.
 */
public final class UnitUtil {

	private UnitUtil() {
		// static methods only.
	}

	/** An array of capabilities of size zero. */
	public static final Capability[] EMPTY_CAPABILITY_ARRAY = new Capability[0];

	/**
	 * Change the input name to be a valid unit name
	 * 
	 * @param name
	 *           the input name
	 * @return the valid unit name
	 */
	public static String fixNameForID(String name) {
		if (name == null) {
			return null;
		}

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (!Character.isLetter(chars[i]) && !Character.isDigit(chars[i])
					&& !Character.isWhitespace(chars[i]) && chars[i] != '_') {
				chars[i] = '_';
			}
		}
		return new String(chars);
	}

	/**
	 * Sets the {@link DeployModelObject#getName()} attribute to a unique value in its container.
	 * 
	 * @param dmo
	 *           a deploy model object whose getParent() != null
	 * @see #generateUniqueName(DeployModelObject, String)
	 */
	public static String assignUniqueName(DeployModelObject dmo) {
		if (dmo instanceof Topology) {
			Topology top = (Topology) dmo;
			if (top.getName() == null || top.getName().length() == 0) {
				top.setName("topology");//$NON-NLS-1$

			}
			return top.getName();
		}
		if (dmo.getParent() == null) {
			throw new IllegalArgumentException(DeployNLS.bind(
					DeployCoreMessages.Validator_deploy_model_object_0_container_undefined, dmo));
		}
		String name = dmo.getName();
		if (!isNameUniqueInContext(dmo.getParent(), dmo)) {
			name = generateUniqueName(dmo.getParent(), dmo.getEObject().eClass().getName());
			dmo.setName(name);
		}
		return name;
	}

	/**
	 * Determine if a given name is unique in the context of a given parent.
	 * 
	 * NOTE - if the name you pass in is from an object that is already a child of the parent then
	 * this method will always return false. Use this method to test if a name would be unique if you
	 * added an object as a child of the parent.
	 * 
	 * @param parent
	 *           the parent {@link DeployModelObject}
	 * @param name
	 *           the name to check for uniqueness
	 * @return true if the name is unique; false otherwise; false if the name is invalid (null or 0
	 *         length)
	 */
	public static boolean isNameUniqueInContext(DeployModelObject parent, String name) {
		if (null == name || name.length() == 0) {
			// name is invalid
			return false;
		}

		synchronized (parent) {
			for (DeployModelObject child : (List<DeployModelObject>) parent.getContainedModelObjects()) {
				if (name.equals(child.getName())) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Determine if the given child dmo's name is unique within the context of the parent dmo.
	 * 
	 * @param parent
	 *           the parent {@link DeployModelObject}
	 * @param child
	 *           the child who name will be checked for uniqueness
	 * @return true if the child's name is unique; false otherwise; false if the child's name is
	 *         invalid ( null or 0 length )
	 */
	public static boolean isNameUniqueInContext(DeployModelObject parent, DeployModelObject child) {
		if (null == child || null == child.getName() || child.getName().length() == 0) {
			// name is invalid
			return false;
		}

		synchronized (parent) {
			for (DeployModelObject aChild : (List<DeployModelObject>) parent
					.getContainedModelObjects()) {
				if (child.getName().equals(aChild.getName())) {
					if (!child.equals(aChild)) {
						return false;
					}
				}
			}
		}

		return true;
	}

	/**
	 * Generates a unique name for a {@link DeployModelObject}. The 'name' field on a
	 * DeployModelObject must be unique among its siblings.
	 * 
	 * <p>
	 * NOTE: Although this method is in UnitUtil it's safe to call for any DeployModelObject.
	 * 
	 * @param parent
	 * @param prefix
	 * @return a String this is unique among the direct children of 'dmo' and can be safely used as
	 *         the 'name' field.
	 */
	public static String generateUniqueName(DeployModelObject parent, String prefix) {

		synchronized (parent) {
			// Collect names of all model objects directly contained by on this dmo
			Set names = new HashSet();
			for (Iterator it = parent.getContainedModelObjects().iterator(); it.hasNext();) {
				DeployModelObject child = (DeployModelObject) it.next();
				names.add(child.getName());
			}

			// Generate a string prefixed by 'prefix' that isn't in 'names'
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				String candidate = prefix + i;
				if (!names.contains(candidate)) {
					return candidate;
				}
			}
		} // end synchronized

		// If we reach here it means that 'dmo' has more than 2^31 children with 'prefix';
		// this is unlikely.
		throw new IllegalArgumentException();

	} // end method generateUniqueName()

	/**
	 * @deprecated this only being used in a test plugin.
	 * 
	 * 
	 * 
	 * /**
	 * @param unit
	 * @return unmodifiable list of Capabilities that are public
	 */
	public static List<Capability> getPublicCapabilities(Unit unit) {
		List<Capability> retVal = new ArrayList<Capability>();
		// if unit is visible, then at least one capability is public
		if (unit.isVisible()) {
			for (Iterator<Capability> it = unit.getCapabilities().iterator(); it.hasNext();) {
				retVal.add(it.next());
			}
		}

		return Collections.unmodifiableList(retVal);
	}

	/**
	 * If there is a project by the input URI name, then return the project URI
	 * 
	 * @param moduleUri
	 *           the input URI to test
	 * @return the project name or null
	 */
	public static String getProjectName(String moduleUri) {
		Path path = new Path(moduleUri);
		String resource = path.lastSegment();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(resource);
		if (project.exists()) {
			return resource;
		}
		return null;
	}
} // end class UnitUtil
