/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * A lightweight object to represent data from the underlying domain model.
 * 
 * @since 1.0
 * 
 */
public final class TopologyUnitStub {

	private String name;

	private String type;

	private Annotation annotation;

	private Object input;

	private Topology topology;

	private DeployModelObject dropTarget;

	private UnitProvider source;

	/**
	 * Creaet a stub to delay heavyweight resolution of the input object.
	 * 
	 * @param aName
	 *           A string based name that can be displayed to the user.
	 * @param aType
	 *           Type information to be used by the Core deploy layer when working with this
	 *           representation.
	 * @param anAnnotation
	 *           A hint about what this underlying domain model is or how it is persisted.
	 * @param anInput
	 *           The original input object that was adapted.
	 */
	public TopologyUnitStub(String aName, String aType, Annotation anAnnotation, Object anInput) {
		name = aName;
		type = aType;
		annotation = anAnnotation;
		input = anInput;
	}

	/**
	 * 
	 * @return A hint about what the underlying domain model is or how it is persisted.
	 */
	public Annotation getAnnotation() {
		return annotation;
	}

	/**
	 * 
	 * @return The original object that was adapted.
	 */
	public Object getInput() {
		return input;
	}

	/**
	 * 
	 * @return A string that can be displayed to a user to represent this object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return The type used by the core deploy layer to identify how this representation should be
	 *         displayed in the diagram.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param topology
	 *           The topology to set.
	 */
	public void setTopology(Topology topology) {
		this.topology = topology;
	}

	/**
	 * @return Returns the topology.
	 */
	public Topology getTopology() {
		return topology;
	}

	/**
	 * @param target
	 *           The target object
	 */
	public void setDropTarget(DeployModelObject target) {
		this.dropTarget = target;
	}

	/**
	 * @return Returns the target object
	 */
	public DeployModelObject getDropTarget() {
		return dropTarget;
	}

	public void setSource(UnitProvider unitProvider) {
		this.source = unitProvider;
	}

	public UnitProvider getSource() {
		return source;
	}
}
