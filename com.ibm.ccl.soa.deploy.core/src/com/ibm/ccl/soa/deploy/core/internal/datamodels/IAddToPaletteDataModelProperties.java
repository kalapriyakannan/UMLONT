  
/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * Clients should not use the Properties interface directly, but instead should refer 
 * to the type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel}.
 * The properties interface is required by the Smart Datamodels Framework (SDF). 
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel
 * @generated (mde.utilities.datamodels)
 */
public interface IAddToPaletteDataModelProperties

{

	/** 
   * 
   * name of palette entry
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String LABEL = "IAddToPaletteDataModelProperties.LABEL"; //$NON-NLS-1$

	/** 
   * 
   * Description of palette entry
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String DESCRIPTION = "IAddToPaletteDataModelProperties.DESCRIPTION"; //$NON-NLS-1$

	/** 
   * 
   * The Stack property.
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String STACK = "IAddToPaletteDataModelProperties.STACK"; //$NON-NLS-1$

	/** 
   * 
   * Position of entry
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String DRAWER = "IAddToPaletteDataModelProperties.DRAWER"; //$NON-NLS-1$

	/** 
   * 
   * Icon for palette entry
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String ICON = "IAddToPaletteDataModelProperties.ICON"; //$NON-NLS-1$

	/** 
   * 
   * Indication to create a template
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link boolean}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String ADD_TO_PALETTE = "IAddToPaletteDataModelProperties.ADD_TO_PALETTE"; //$NON-NLS-1$

	/** 
   * 
   * The ProjectName property.
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String PROJECT_NAME = "IAddToPaletteDataModelProperties.PROJECT_NAME"; //$NON-NLS-1$

	/** 
   * 
   * Associated Topologyv file used to copy notational metadata
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
  String TOPOLOGY_V_URI = "IAddToPaletteDataModelProperties.TOPOLOGY_V_URI"; //$NON-NLS-1$

  /** 
   * 
   * Should capture notational values in topologyV
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link boolean}. </p>
   * @generated (mde.utilities.datamodels)
   */
  String CAPTURE_VISUALS = "IAddToPaletteDataModelProperties.CAPTURE_VISUALS"; //$NON-NLS-1$

  /** 
   * 
   * Should capture notational values in topologyV
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link boolean}. </p>
   * @generated (mde.utilities.datamodels)
   */
  String ENABLE_CAPTURE_VISUALS = "IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS"; //$NON-NLS-1$

  /** 
   * 
   * Topology for topology constraint
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link Topology}. </p>
   * 
   * @generated (mde.utilities.datamodels)
   */
	String TOPOLOGY = "IAddToPaletteDataModelProperties.TOPOLOGY"; //$NON-NLS-1$	

	/** 
   * 
   * Units to be added to the palette
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link Unit[]}. </p>
   * 
   * @generated (mde.utilities.datamodels)
   */
	String UNITS = "IAddToPaletteDataModelProperties.UNITS"; //$NON-NLS-1$	

	/**
	 * 
	 * port number is applicable
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link boolean}.
	 * </p>
	 * 
	 */
	String DATAMODEL = "IAddToPaletteDataModelProperties.DATAMODEL";//$NON-NLS-1$

	final static String LOCAL_EXTENSIONS = "Local Extensions"; //$NON-NLS-1$
	final static String EXTENSION_DRAWER = "/extensionDrawer/";//$NON-NLS-1$
	final static String NONE = "NONE";//$NON-NLS-1$
	final static String PALATTE_ENTRY = "Palette_Entry"; //$NON-NLS-1$
	final static char UNDERSCORE = '_';
}
