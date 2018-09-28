/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

/**
 * @since 7.0
 * 
 */
public class AutoRealizationControl {
	private boolean followStructuralConstraintLinks = true;
	private boolean allowUnmatchedConfigUnits = false;
	private boolean allowManyToOneRealizations = true;
	private boolean findAllSolutions = false;
	private boolean strictAttributeValueMatchMode = false;
	private boolean fullyValidateConstraintsInMatchMode = false;

	/**
	 * Copy-constructor.
	 * 
	 * @param arc
	 */
	public AutoRealizationControl(AutoRealizationControl arc) {
		followStructuralConstraintLinks = arc.followStructuralConstraintLinks;
		allowUnmatchedConfigUnits = arc.allowUnmatchedConfigUnits;
		allowManyToOneRealizations = arc.allowManyToOneRealizations;
		findAllSolutions = arc.findAllSolutions;
		strictAttributeValueMatchMode = arc.strictAttributeValueMatchMode;
		fullyValidateConstraintsInMatchMode = arc.fullyValidateConstraintsInMatchMode;
	}

	/**
	 * Non-copy-constructor
	 */
	public AutoRealizationControl() {

	}

	/**
	 * @return Returns the followStructuralConstraintLinks.
	 */
	public boolean isFollowStructuralConstraintLinks() {
		return followStructuralConstraintLinks;
	}

	/**
	 * @param followStructuralConstraintLinks
	 *           The followStructuralConstraintLinks to set.
	 */
//	public void setFollowConstraintLinks(boolean followStructuralConstraintLinks) {
//		this.followStructuralConstraintLinks = followStructuralConstraintLinks;
//	}
	/**
	 * @return Returns the allowUnmatchedConfigUnits.
	 */
	public boolean isAllowUnmatchedConfigUnits() {
		return allowUnmatchedConfigUnits;
	}

	/**
	 * @param allowUnmatchedConfigUnits
	 *           The allowUnmatchedConfigUnits to set.
	 */
	public void setAllowUnmatchedConfigUnits(boolean allowUnmatchedConfigUnits) {
		this.allowUnmatchedConfigUnits = allowUnmatchedConfigUnits;
	}

	/**
	 * @return Returns the allowManyToOneRealizations.
	 */
	public boolean isAllowManyToOneRealizations() {
		return allowManyToOneRealizations;
	}

	/**
	 * @param allowManyToOneRealizations
	 *           The allowManyToOneRealizations to set.
	 */
	public void setAllowManyToOneRealizations(boolean allowManyToOneRealizations) {
		this.allowManyToOneRealizations = allowManyToOneRealizations;
	}

	/**
	 * @return Returns the findAllSolutions.
	 */
	public boolean isFindAllSolutions() {
		return findAllSolutions;
	}

	/**
	 * @param findAllSolutions
	 *           The findAllSolutions to set.
	 */
	public void setFindAllSolutions(boolean findAllSolutions) {
		this.findAllSolutions = findAllSolutions;
	}

	/**
	 * @param followStructuralConstraintLinks
	 *           The followStructuralConstraintLinks to set.
	 */
	public void setFollowStructuralConstraintLinks(boolean followStructuralConstraintLinks) {
		this.followStructuralConstraintLinks = followStructuralConstraintLinks;
	}

	/**
	 * @return Returns the strictAttributeValueMatchMode.
	 */
	public boolean isStrictAttributeValueMatchMode() {
		return strictAttributeValueMatchMode;
	}

	/**
	 * @param strictAttributeValueMatchMode
	 *           The strictAttributeValueMatchMode to set.
	 */
	public void setStrictAttributeValueMatchMode(boolean strictAttributeValueMatchMode) {
		this.strictAttributeValueMatchMode = strictAttributeValueMatchMode;
	}

	/**
	 * @return Returns the fullyValidateConstraintsWhenMatching.
	 */
	public boolean isFullyValidateConstraintsInMatchMode() {
		return fullyValidateConstraintsInMatchMode;
	}

	/**
	 * @param fullyValidateConstraintsWhenMatching
	 *           The fullyValidateConstraintsWhenMatching to set.
	 */
	public void setFullyValidateConstraintsInMatchMode(boolean fullyValidateConstraintsInMatchMode) {
		this.fullyValidateConstraintsInMatchMode = fullyValidateConstraintsInMatchMode;
	}
}
