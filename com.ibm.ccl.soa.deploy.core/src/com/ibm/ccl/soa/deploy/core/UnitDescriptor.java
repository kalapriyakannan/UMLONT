/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core;

/**
 * This class is used to act as a descriptor to get the value of the unit itself. Provide an
 * implementation of this class to create the unit and it's name.
 * 
 * @see TopologyDiscoverer
 */
public abstract class UnitDescriptor {

	protected Unit unit;
	private String descriptorName;
	private String displayName;
	/** @deprecated */
	protected boolean existingUnit = false;
	/** @deprecated */
	private boolean addedToTopology = false;

	/**
	 * Constructor for the unit descriptor
	 */
	public UnitDescriptor() {

	}

	/**
	 * override this method to get or create the instance of the unit
	 * 
	 * @return the instance of the unit
	 */
	protected abstract Unit getUnit();

	/**
	 * override this method to get or create the instance of the unit, discover the links and add to
	 * topology
	 * 
	 * @param topology
	 *           topology to add the unit to
	 * @return the instance of the unit
	 */
	protected abstract Unit getUnitAndAddToTopology(Topology topology);

	/**
	 * Override this method to create the descriptor name that can be used for uniqueness.
	 * 
	 * @return the descriptor name
	 */
	protected abstract String createDescriptorName();

	/**
	 * Override this method to create the display name that can be used for display.
	 * 
	 * @return the descriptor name
	 */
	protected abstract String createDisplayName();

	/**
	 * 
	 * @return the value of the unit that is encapsulated
	 */
	public Unit getUnitValue() {
		if (unit == null) {
			unit = getUnit();
		}
		return unit;
	}

	/**
	 * get or create the instance of the unit, discover the links and add to topology
	 * 
	 * @param topology
	 *           topology to add the unit to
	 * 
	 * @return the value of the unit that is encapsulated
	 */
	public final Unit getUnitValueAndAddToTopology(Topology topology) {
		if (addedToTopology) {
			return unit;
		}
//		if(unit == null){
		unit = getUnitAndAddToTopology(topology);
		addedToTopology = true;
//		}
		return unit;
	}

	/**
	 * Set the value of the unit
	 * 
	 * @param unit
	 */
	public void setUnitValue(Unit unit) {
		this.unit = unit;
	}

	/**
	 * @return the descriptor name as set
	 */
	public String getDescriporName() {
		if (descriptorName == null) {
			descriptorName = createDescriptorName();
		}
		return descriptorName;
	}

	/**
	 * Set the name of the descriptor.
	 * 
	 * @param descriptorName
	 */
	public void setDescriptorName(String descriptorName) {
		this.descriptorName = descriptorName;
	}

	/**
	 * 
	 * @return the display name set for the unit descriptor
	 */
	public String getDisplayName() {
		if (displayName == null) {
			displayName = createDisplayName();
		}
		return displayName;
	}

	/**
	 * 
	 * @param displayName
	 *           the name for the unit to display
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "UnitDescriptor[" + getDescriporName() + ']';//$NON-NLS-1$
	}

	/**
	 * 
	 * @return flag indicating if unit has been added to current topology
	 * @deprecated use {@link #isInTopology(Topology)}
	 */
	public boolean isAddedToTopology() {
		return addedToTopology;
	}

	/**
	 * 
	 * @param added
	 *           flag indicating if unit has been added to current topology
	 * @deprecated
	 */
	protected void setAddedToTopology(boolean added) {
		addedToTopology = added;
	}

	/**
	 * Set to true if already present in Topology
	 * 
	 * @param existingUnit
	 *           the existingUnit to set
	 * @deprecated
	 */
	public void setExistingUnit(boolean existingUnit) {
		this.existingUnit = existingUnit;
	}

	/**
	 * Check if unit in use was already existing in topology
	 * 
	 * @return the existingUnit
	 * @deprecated use {@link #isInTopology(Topology)}
	 */
	public boolean isExistingUnit() {
		return existingUnit;
	}

	/**
	 * Determine if a unit is in a given topology.
	 * 
	 * @param topology
	 *           the topology to check
	 * @return true if the unit is in the topology
	 */
	public boolean isInTopology(Topology topology) {
		Unit u = getUnitValue();
		if (null == u) {
			return false;
		}
		return u.getEditTopology() == topology;
	}

	/**
	 * Determines if a descriptor identifies the same {@link Unit} as a given {@link Unit}. Two
	 * units are the same if they would be represented by the same {@link Unit} in the same
	 * {@link Topology}.
	 * 
	 * @param unit
	 *           the unit to be compared to that described by the descriptor
	 * @return true if the units are the same unit; false if not or if not determinable
	 */
	public abstract boolean referencesUnit(Unit unit);

	/**
	 * Determines if a descriptor identifies the same {@link Unit} as that described by a second
	 * {@UnitDescriptor}. Two units are the same if they would be represented by the same
	 * {@link Unit} in the same {@link Topology}.
	 * 
	 * @param unit
	 *           the unit to be compared to that described by the descriptor
	 * @return true if the units are the same unit; false if not or if not
	 */
	public abstract boolean referencesUnit(UnitDescriptor descriptor);
}
