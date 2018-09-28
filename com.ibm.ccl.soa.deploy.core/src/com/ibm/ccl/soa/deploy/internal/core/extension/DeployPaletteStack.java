/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

/**
 * 
 * @since 2.0
 * 
 */
public class DeployPaletteStack {

	private final String id;
	private final String path;
	private final String label;
	private final String description;
	private final String icon;
	private final String kind;

	public static final String STACK_KIND = "stack"; //$NON-NLS-1$

	/**
	 * 
	 * @param id
	 * @param path
	 * @param label
	 * @param description
	 * @param smallIcon
	 * @param largeIcon
	 * @param kind
	 * @param templateUri
	 */
	public DeployPaletteStack(String id, String path, String label, String description, String icon,
			String kind) {
		super();
		this.id = id;
		this.path = path;
		this.label = label;
		this.description = description;
		this.icon = icon;
		this.kind = kind;
	}

	public String getId() {
		return id;
	}

	public String getPath() {
		return path;
	}

	public String getLabel() {
		return label;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	public String getKind() {
		return kind;
	}

	@Override
	public String toString() {
		return super.toString() + "[label=" + label + ", id=" + id + ", path=" + path + ']'; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}
