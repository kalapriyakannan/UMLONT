  
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

import org.eclipse.core.resources.IFile;

/**
 * Clients should not use the Properties interface directly, but instead should refer 
 * to the type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel}.
 * The properties interface is required by the Smart Datamodels Framework (SDF). 
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel
 * @generated (mde.utilities.datamodels)
 */
public interface ICreateTopologyDataModelProperties {

	/** 
   * 
   * The contractType determines which kind of 
   * ConfigurationContract to add to the Topology.
   * 
   * The string should represent the fully qualified name
   * of the actual model type (e.g. 
   * IdentityContract.class.getCanonicalName()).
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String CONTRACT_TYPE = "ICreateTopologyDataModelProperties.CONTRACT_TYPE"; //$NON-NLS-1$

	/** 
   * 
   * A name for the new Topology.
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String TOPOLOGY_NAME = "ICreateTopologyDataModelProperties.TOPOLOGY_NAME"; //$NON-NLS-1$

	/** 
   * 
   * An optional description for the topology.  The default is a simple string
   * indicating the timestamp that the topology was created.
   *
   * <p><b>[Optional]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String TOPOLOGY_DESCRIPTION = "ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION"; //$NON-NLS-1$

	/** 
   * 
   * An optional decoratorSemantic name.  This must be a valid decorator semantic if it is set.  If no
   * value is set then it defaults to null.  A validation check will be made against the value to ensure that
   * it is a valid decorator semantic.
   *
   * <p><b>[Optional]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String DECORATOR_SEMANTIC = "ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC"; //$NON-NLS-1$

	/** 
   * 
   * This is a READ-ONLY property used to obtain the description for the selected
   * decoratorSemantic.
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String DECORATOR_SEMANTIC_DESCRIPTION = "ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION"; //$NON-NLS-1$

	/** 
   * 
   * This is the path to the root folder for the topologies.  The path must be at least
   * one segment long where the first segment is a valid project name.
   *
   * <p><b>[Required]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String SOURCE_PATH = "ICreateTopologyDataModelProperties.SOURCE_PATH"; //$NON-NLS-1$	

	/** 
   * 
   * This is the path for the namespace to be used for the new Topology.  This 
   * property is optional.  If a value is not set then the defaul will be an empty 
   * namespace.  This means the topology will be created directly in the set
   * sourceFolder.
   *
   * <p><b>[Optional]</b></p>
   *
   * <p>Type = {@link String}. </p>
   * @generated (mde.utilities.datamodels)
   */
	String NAMESPACE_PATH = "ICreateTopologyDataModelProperties.NAMESPACE_PATH"; //$NON-NLS-1$	

	/** 
   * 
   * This is a READ-ONLY field that will return the computed file for the new topology
   * based on the project name, source folder, namespace path, and topology name.
   *
   * <p><b>[Required]</b></p>
   * 
   * <p>Type = {@link IFile}. </p>
   * 
   * @generated (mde.utilities.datamodels)
   */
	String TOPOLOGY_FILE = "ICreateTopologyDataModelProperties.TOPOLOGY_FILE"; //$NON-NLS-1$	

}
