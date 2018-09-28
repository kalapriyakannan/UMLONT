/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateTopologyDataModelOperation;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateTopologyDataModelProvider;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;

/**
 * 	 
 * This data model is used to create a new Topology.  This data model will allow you to 
 * set a project location as well as the source folder and namespace for the new topology. 
 *
 * <p>
 * The following properties are <b>required</b>. If not provided, then 
 * the model is not in a valid state, and the operation will not
 * be able to execute successfully. 
 * </p>
 * <ul>  
 * <li><b>topologyFile</b>: 
 *     This is a READ-ONLY field that will return the computed file for the new topology
 *     based on the project name, source folder, namespace path, and topology name.
 * </li>  
 * <li><b>contractType</b>: 
 *     The contractType determines which kind of 
 *     ConfigurationContract to add to the Topology.
 *     
 *     The string should represent the fully qualified name
 *     of the actual model type (e.g. 
 *     IdentityContract.class.getCanonicalName()).
 * </li>  
 * <li><b>topologyName</b>: 
 *     A name for the new Topology.
 * </li>  
 * <li><b>decoratorSemanticDescription</b>: 
 *     This is a READ-ONLY property used to obtain the description for the selected
 *     decoratorSemantic.
 * </li>  
 * <li><b>sourcePath</b>: 
 *     This is the path to the root folder for the topologies.  The path must be at least
 *     one segment long where the first segment is a valid project name.
 * </li> 
 * </ul> 
 * 
 * <p>
 * The following properties are <b>optional</b>, and can be provided to 
 * configure the operation more exactly. If values are not supplied
 * for these properties, then default values will be used instead. 
 * Refer to the documentation for each of these to determine the 
 * behavior of the operation if the property value is not specified.
 * <p>
 * <ul> 
 * <li><b>topologyDescription</b>: 
 *     An optional description for the topology.  The default is a simple string
 *     indicating the timestamp that the topology was created.
 * </li>  
 * <li><b>decoratorSemantic</b>: 
 *     An optional decoratorSemantic name.  This must be a valid decorator semantic if it is set.  If no
 *     value is set then it defaults to null.  A validation check will be made against the value to ensure that
 *     it is a valid decorator semantic.
 * </li>  
 * <li><b>namespacePath</b>: 
 *     This is the path for the namespace to be used for the new Topology.  This 
 *     property is optional.  If a value is not set then the defaul will be an empty 
 *     namespace.  This means the topology will be created directly in the set
 *     sourceFolder.
 * </li> 
 * </ul> 
 * 
 * @generated (mde.utilities.datamodels)
 */
public class CreateTopologyDataModel {

	private final IDataModel model;

	/**
   * Creates and returns an instance of the type-safe API datamodel.
   * 
   * @return An instance of the type-safe API datamodel. 
   * @generated (mde.utilities.datamodels)
   */
	public static CreateTopologyDataModel createModel() {
    IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
    return new CreateTopologyDataModel(model);
  }

	/**
   * Creates and returns an instance of the underlying provider for this facade.
   *
   * <p>
   * A provider implements the actual logic of a data model. All validation logic, 
   * calculation of default values, and management of property dependencies
   * is handled by the provider.
   * </p>
   * @return An instance of the underlying provider for this facade.
   * @generated (mde.utilities.datamodels)
   */
	public static IDataModelProvider createDatamodelProvider() {
    return new CreateTopologyDataModelProvider();
  }

	/**
   * Create a type-safe facade for the given datamodel.
   * 
   * @param mdl The datamodel to provide a facade for. 
   * @generated (mde.utilities.datamodels)
   */
	public CreateTopologyDataModel(IDataModel mdl) {
    model = mdl;	
  }

	/**
   * The contractType determines which kind of 
   * ConfigurationContract to add to the Topology.
   * 
   * The string should represent the fully qualified name
   * of the actual model type (e.g. 
   * IdentityContract.class.getCanonicalName()).
   *
   * <p><b>[Required]</b></p>
   * 
   * @param newContractType The new value of the ContractType property.
   * @generated (mde.utilities.datamodels)
   */
	public void setContractType(String newContractType) {
    model.setProperty(ICreateTopologyDataModelProperties.CONTRACT_TYPE, newContractType);
  }

	/**
   * The contractType determines which kind of 
   * ConfigurationContract to add to the Topology.
   * 
   * The string should represent the fully qualified name
   * of the actual model type (e.g. 
   * IdentityContract.class.getCanonicalName()).
   * 
   * @return The value of the ContractType property. 
   * @generated (mde.utilities.datamodels)
   */
	public String getContractType() {
    return (String) model.getProperty(ICreateTopologyDataModelProperties.CONTRACT_TYPE);
  }

	/**
   * Determine if the ContractType property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the ContractType property is valid. 
   * @see #getContractType()
   * @see #setContractType(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateContractType() {
    return model.validateProperty(ICreateTopologyDataModelProperties.CONTRACT_TYPE);
  }

	/**
   * Determine the default value of the ContractType property.
   * 
   * @return The default value of the ContractType property. 
   * @see #getContractType()
   * @see #setContractType(String) 
   * @generated (mde.utilities.datamodels)
   */
	public String getDefaultContractType() {
    return(String) model.getDefaultProperty(ICreateTopologyDataModelProperties.CONTRACT_TYPE);
  }

	/**
   * A name for the new Topology.
   *
   * <p><b>[Required]</b></p>
   * 
   * @param newTopologyName The new value of the TopologyName property.
   * @generated (mde.utilities.datamodels)
   */
	public void setTopologyName(String newTopologyName) {
    model.setProperty(ICreateTopologyDataModelProperties.TOPOLOGY_NAME, newTopologyName);
  }

	/**
	 * A name for the new Topology.
	 * 
	 * @return The value of the TopologyName property.
	 * 
	 */
	public String getTopologyName() {
		String name = getTopologyNameGen();
		return name != null ? name.trim() : name;
	}

	/**
   * A name for the new Topology.
   * 
   * @return The value of the TopologyName property. 
   * @generated (mde.utilities.datamodels)
   */
	public String getTopologyNameGen() {
    return (String) model.getProperty(ICreateTopologyDataModelProperties.TOPOLOGY_NAME);
  }

	/**
   * Determine if the TopologyName property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the TopologyName property is valid. 
   * @see #getTopologyName()
   * @see #setTopologyName(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateTopologyName() {
    return model.validateProperty(ICreateTopologyDataModelProperties.TOPOLOGY_NAME);
  }

	/**
   * Determine the default value of the TopologyName property.
   * 
   * @return The default value of the TopologyName property. 
   * @see #getTopologyName()
   * @see #setTopologyName(String) 
   * @generated (mde.utilities.datamodels)
   */
	public String getDefaultTopologyName() {
    return(String) model.getDefaultProperty(ICreateTopologyDataModelProperties.TOPOLOGY_NAME);
  }

	/**
   * An optional description for the topology.  The default is a simple string
   * indicating the timestamp that the topology was created.
   *
   * <p><b>[Optional]</b></p>
   * 
   * @param newTopologyDescription The new value of the TopologyDescription property.
   * @generated (mde.utilities.datamodels)
   */
	public void setTopologyDescription(String newTopologyDescription) {
    model.setProperty(ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION, newTopologyDescription);
  }

	/**
   * An optional description for the topology.  The default is a simple string
   * indicating the timestamp that the topology was created.
   * 
   * @return The value of the TopologyDescription property. 
   * @generated (mde.utilities.datamodels)
   */
	public String getTopologyDescription() {
    return (String) model.getProperty(ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION);
  }

	/**
   * Determine if the TopologyDescription property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the TopologyDescription property is valid. 
   * @see #getTopologyDescription()
   * @see #setTopologyDescription(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateTopologyDescription() {
    return model.validateProperty(ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION);
  }

	/**
   * Determine the default value of the TopologyDescription property.
   * 
   * @return The default value of the TopologyDescription property. 
   * @see #getTopologyDescription()
   * @see #setTopologyDescription(String) 
   * @generated (mde.utilities.datamodels)
   */
	public String getDefaultTopologyDescription() {
    return(String) model.getDefaultProperty(ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION);
  }

	/**
   * An optional decoratorSemantic name.  This must be a valid decorator semantic if it is set.  If no
   * value is set then it defaults to null.  A validation check will be made against the value to ensure that
   * it is a valid decorator semantic.
   *
   * <p><b>[Optional]</b></p>
   * 
   * @param newDecoratorSemantic The new value of the DecoratorSemantic property.
   * @generated (mde.utilities.datamodels)
   */
	public void setDecoratorSemantic(String newDecoratorSemantic) {
    model.setProperty(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC, newDecoratorSemantic);
  }

	/**
   * An optional decoratorSemantic name.  This must be a valid decorator semantic if it is set.  If no
   * value is set then it defaults to null.  A validation check will be made against the value to ensure that
   * it is a valid decorator semantic.
   * 
   * @return The value of the DecoratorSemantic property. 
   * @generated (mde.utilities.datamodels)
   */
	public String getDecoratorSemantic() {
    return (String) model.getProperty(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC);
  }

	/**
   * Determine if the DecoratorSemantic property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the DecoratorSemantic property is valid. 
   * @see #getDecoratorSemantic()
   * @see #setDecoratorSemantic(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateDecoratorSemantic() {
    return model.validateProperty(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC);
  }

	/**
   * Determine the default value of the DecoratorSemantic property.
   * 
   * @return The default value of the DecoratorSemantic property. 
   * @see #getDecoratorSemantic()
   * @see #setDecoratorSemantic(String) 
   * @generated (mde.utilities.datamodels)
   */
	public String getDefaultDecoratorSemantic() {
    return(String) model.getDefaultProperty(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC);
  }

	/**
   * This is a READ-ONLY property used to obtain the description for the selected
   * decoratorSemantic.
   * 
   * @return The value of the DecoratorSemanticDescription property. 
   * @generated (mde.utilities.datamodels)
   */
	public String getDecoratorSemanticDescription() {
    return (String) model.getProperty(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION);
  }

	/**
   * Determine if the DecoratorSemanticDescription property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the DecoratorSemanticDescription property is valid. 
   * @see #getDecoratorSemanticDescription()
   * @see #setDecoratorSemanticDescription(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateDecoratorSemanticDescription() {
    return model.validateProperty(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION);
  }

	/**
   * Determine the default value of the DecoratorSemanticDescription property.
   * 
   * @return The default value of the DecoratorSemanticDescription property. 
   * @see #getDecoratorSemanticDescription()
   * @see #setDecoratorSemanticDescription(String) 
   * @generated (mde.utilities.datamodels)
   */
	public String getDefaultDecoratorSemanticDescription() {
    return(String) model.getDefaultProperty(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION);
  }

	/**
	 * This is the path to the root folder for the topologies. The path must be at least one segment
	 * long where the first segment is a valid project name.
	 */
	public void setSourcePath(String newSourcePath) {
		newSourcePath = TextProcessor.process(newSourcePath, "/"); //$NON-NLS-1$
		model.setProperty(ICreateTopologyDataModelProperties.SOURCE_PATH, newSourcePath);
	}

	/**
	 * This is the path to the root folder for the topologies. The path must be at least one segment
	 * long where the first segment is a valid project name.
	 * 
	 * @return The value of the SourcePath property.
	 * 
	 */
	public String getSourcePath() {
		String path = getSourcePathGen();
		return path != null ? path.trim() : path;
	}

	/**
   * This is the path to the root folder for the topologies.  The path must be at least
   * one segment long where the first segment is a valid project name.
   * 
   * @return The value of the SourcePath property. 
   * @generated (mde.utilities.datamodels)
   */
	public String getSourcePathGen() {
    return (String) model.getProperty(ICreateTopologyDataModelProperties.SOURCE_PATH);
  }

	/**
   * Determine if the SourcePath property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the SourcePath property is valid. 
   * @see #getSourcePath()
   * @see #setSourcePath(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateSourcePath() {
    return model.validateProperty(ICreateTopologyDataModelProperties.SOURCE_PATH);
  }

	/**
   * Determine the default value of the SourcePath property.
   * 
   * @return The default value of the SourcePath property. 
   * @see #getSourcePath()
   * @see #setSourcePath(String) 
   * @generated (mde.utilities.datamodels)
   */
	public String getDefaultSourcePath() {
    return(String) model.getDefaultProperty(ICreateTopologyDataModelProperties.SOURCE_PATH);
  }

	/**
   * This is the path for the namespace to be used for the new Topology.  This 
   * property is optional.  If a value is not set then the defaul will be an empty 
   * namespace.  This means the topology will be created directly in the set
   * sourceFolder.
   *
   * <p><b>[Optional]</b></p>
   * 
   * @param newNamespacePath The new value of the NamespacePath property.
   * @generated (mde.utilities.datamodels)
   */
	public void setNamespacePath(String newNamespacePath) {
    model.setProperty(ICreateTopologyDataModelProperties.NAMESPACE_PATH, newNamespacePath);
  }

	/**
	 * This is the path for the namespace to be used for the new Topology. This property is optional.
	 * If a value is not set then the defaul will be an empty namespace. This means the topology will
	 * be created directly in the set sourceFolder.
	 * 
	 * @return The value of the NamespacePath property.
	 * 
	 */
	public String getNamespacePath() {
		String path = getNamespacePathGen();
		return path != null ? path.trim() : path;
	}

	/**
   * This is the path for the namespace to be used for the new Topology.  This 
   * property is optional.  If a value is not set then the defaul will be an empty 
   * namespace.  This means the topology will be created directly in the set
   * sourceFolder.
   * 
   * @return The value of the NamespacePath property. 
   * @generated (mde.utilities.datamodels)
   */
	public String getNamespacePathGen() {
    return (String) model.getProperty(ICreateTopologyDataModelProperties.NAMESPACE_PATH);
  }

	/**
   * Determine if the NamespacePath property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the NamespacePath property is valid. 
   * @see #getNamespacePath()
   * @see #setNamespacePath(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateNamespacePath() {
    return model.validateProperty(ICreateTopologyDataModelProperties.NAMESPACE_PATH);
  }

	/**
   * Determine the default value of the NamespacePath property.
   * 
   * @return The default value of the NamespacePath property. 
   * @see #getNamespacePath()
   * @see #setNamespacePath(String) 
   * @generated (mde.utilities.datamodels)
   */
	public String getDefaultNamespacePath() {
    return(String) model.getDefaultProperty(ICreateTopologyDataModelProperties.NAMESPACE_PATH);
  }

	/**
   * Return the value of TopologyFile field.
   * 
   * @return The value of TopologyFile field.
   * @generated (mde.utilities.datamodels)
   */
	public IFile getTopologyFile() { 
    return (IFile) model.getProperty(ICreateTopologyDataModelProperties.TOPOLOGY_FILE); 
  }

	/**
   * Determine if the TopologyFile property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the TopologyFile property is valid. 
   * @see #getTopologyFile()
   * @see #setTopologyFile(IFile) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateTopologyFile() { 
    return model.validateProperty(ICreateTopologyDataModelProperties.TOPOLOGY_FILE);
    
  }

	/**
   * Determine the default value of the TopologyFile property.
   * 
   * @return The default value of the TopologyFile property. 
   * @see #getTopologyFile()
   * @see #setTopologyFile(IFile) 
   * @generated (mde.utilities.datamodels)
   */
	protected IFile getDefaultTopologyFile() {
    return (IFile) model.getDefaultProperty(ICreateTopologyDataModelProperties.TOPOLOGY_FILE);
  }

	/**
   * Create and return an operation that is configured with the values from this datamodel.
   * 
   * @return A ready-to-run operation prepared with this model to carry out the operation. 
   * @generated (mde.utilities.datamodels)
   */
	public IDataModelOperation createConfiguredOperation() {
    CreateTopologyDataModelOperation operation = new CreateTopologyDataModelOperation(this); 
    return operation;		
  }

	/**
	 * The underlying datamodel that backs this facade.
	 * 
	 * @return The underlying datamodel that backs this facade.
	 */
	public final IDataModel getUnderlyingDataModel() {
		return model;
	}

	/**
   * Validates all properties associated with this type-safe data model. 
   *
   * @return The collective status of all properties associated with the underlying datamodel. 
   * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validate() {	
    return model.validate(false);
  }

	/**
	 * @return An {@link IContainer} defined for the
	 *         {@link ICreateTopologyDataModelProperties#SOURCE_PATH} property.
	 */
	public IContainer getSourceContainer() {
		String sourcePath = getSourcePath();
		if (sourcePath != null) {
			return CreateTopologyDataModelProvider.getWorkspaceRelativeContainer(new Path(sourcePath));
		}
		return null;
	}

	public IContainer getNamespaceContainer() {
		String namepsacePath = model
				.getStringProperty(ICreateTopologyDataModelProperties.NAMESPACE_PATH);
		return CreateTopologyDataModelProvider.computeContainerFromNamespace(getSourceContainer(),
				namepsacePath);
	}

	/**
	 * Set the source path based on the given root.
	 * 
	 * @param root
	 *           An {@link INamespaceFragmentRoot}.
	 */
	public void setSourcePath(INamespaceFragmentRoot root) {
		if (root != null) {
			IContainer container = root.getCorrespondingResource();
			if (container != null) {
				setSourcePath(container.getFullPath().makeRelative().toString());
			}
		}
	}
}
