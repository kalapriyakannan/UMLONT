/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.DataModelPropertyDescriptor;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.IConstants.DecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.ContractProviderDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ContractProviderManager;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel}. The provider is required
 * by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel
 * @generated (mde.utilities.datamodels)
 */
public class CreateTopologyDataModelProvider extends AbstractDataModelProvider implements
		ICreateTopologyDataModelProperties {

	/*
	 * Hold an instance to our type safe data model.
	 */
	private CreateTopologyDataModel topologyDataModel;

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateTopologyDataModelProperties#TOPOLOGY_NAME
	 * 
	 */
	public IStatus validateTopologyName() {
		String topologyName = (String) model
				.getProperty(ICreateTopologyDataModelProperties.TOPOLOGY_NAME);
		// Ensure the name is not empty.
		if (topologyName == null || topologyName.length() < 1) {
			return DeployCorePlugin
					.createErrorStatus(
							0,
							DeployCoreMessages.CreateTopologyDataModelProvider_The_topology_name_cannot_be_empty_,
							null);
		}
		// Ensure the name does not contain invalid characters.
		if (!isValidName(topologyName)) {
			return DeployCorePlugin
					.createErrorStatus(
							0,
							DeployCoreMessages.CreateTopologyDataModelProvider_The_topology_name_contains_invalid_,
							null);
		}
		// Ensure the topology name is unique in the namespace.
		IContainer namespaceContainer = getNamespaceContainer();
		if (namespaceContainer != null) {
			if (namespaceContainer.exists()) {
				IResource existingTopology = namespaceContainer.findMember(new Path(topologyName)
						.addFileExtension(IConstants.TOPOLOGY_EXTENSION));
				if (existingTopology != null) {
					return DeployCorePlugin
							.createErrorStatus(
									0,
									NLS
											.bind(
													DeployCoreMessages.CreateTopologyDataModelProvider_A_topology_named_0_already_exis_,
													topologyName), null);
				}
			}
		}
		return validateUniqueQualifiedName(topologyName);
	}

	/**
	 * 
	 * @return The default value of the TopologyName property.
	 * @see ICreateTopologyDataModelProperties#TOPOLOGY_NAME
	 * @see CreateTopologyDataModel#getTopologyName()
	 * 
	 */
	protected String getDefaultTopologyName() {
		return ""; //$NON-NLS-1$ 
	}

	private IStatus validateUniqueQualifiedName(String topologyName) {
		IContainer sourceContainer = getTopologyDataModel().getSourceContainer();
		if (sourceContainer != null) {
			IProject project = sourceContainer.getProject();
			if (!project.exists()) {
				return Status.OK_STATUS;
			}
			INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(project, null);
			if (roots.length == 0 || roots.length == 1
					&& roots[0].getCorrespondingResource() == project) {
				// Either no roots exist yet or the only root is the project
				// where we have
				// already tested for uniqueness.
				return Status.OK_STATUS;
			}
			// Test that the qualified topology name is unique across all roots.
			String namespace = getTopologyDataModel().getNamespacePath();
			for (int i = 0; i < roots.length; i++) {
				if (sourceContainer != roots[i].getCorrespondingResource()) {
					IFile[] topologyFiles = null;
					//work item 2474 (add length check)
					if (namespace == null || namespace.length() == 0) {
						// Default namespace.
						topologyFiles = roots[i].topologies();
					} else {
						INamespaceFragment existingNamespace = roots[i].resolveNamespace(namespace);
						if (existingNamespace != null && existingNamespace.exists()) {
							topologyFiles = existingNamespace.topologies();
						}
					}
					if (topologyFiles != null) {
						for (int j = 0; j < topologyFiles.length; j++) {
							IPath path = topologyFiles[j].getProjectRelativePath();
							path = path.removeFileExtension();
							if (topologyName.equals(path.lastSegment())) {
								String qualifiedName = namespace + '.' + topologyName;
								// An error since another qualified topology
								// exists.
								return DeployCorePlugin
										.createErrorStatus(
												0,
												NLS
														.bind(
																DeployCoreMessages.CreateTopologyDataModelProvider_A_topology_named_0_already_exis_,
																qualifiedName), null);
							}
						}
					}
				}
			}
		}
		return Status.OK_STATUS;
	}

	/*
	 * Should start with a letter and contain only letters, numbers, or the connecting underscore
	 * character "_".
	 */
	private boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		name.trim();
		char[] tChar = name.toCharArray();
		if (tChar.length == 0) {
			return false;
		}
		if (!Character.isLetter(tChar[0])) {
			return false;
		}
		for (int i = 0; i < tChar.length; i++) {
			char c = tChar[i];
			if (Character.isLetterOrDigit(c)) {
				continue;
			} else if (c == '_') {
				continue;
			} else if (c == ' ') {
				continue;
			}
			return false;
		}
		return true;
	}

	/*
	 * The namespace cannot contain any slashes.
	 */
	private IStatus validateNamespace(String namespace) {
		if (namespace != null) {
			String name = namespace.trim();
			if (name.length() > 0) {
				int length = name.length();
				if (name.charAt(0) == IConstants.DOT_SEPARATOR
						|| name.charAt(length - 1) == IConstants.DOT_SEPARATOR) {
					return DeployCorePlugin
							.createErrorStatus(
									0,
									DeployCoreMessages.CreateTopologyDataModelProvider_The_namespace_must_not_start_or_end_,
									null);
				}
				int dot = 0;
				while (dot != -1 && dot < length - 1) {
					if ((dot = name.indexOf(IConstants.DOT_SEPARATOR, dot + 1)) != -1
							&& dot < length - 1 && name.charAt(dot + 1) == IConstants.DOT_SEPARATOR) {
						return DeployCorePlugin
								.createErrorStatus(
										0,
										DeployCoreMessages.CreateTopologyDataModelProvider_The_namespace_cannot_contain_consec_,
										null);
					}
				}
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				StringTokenizer st = new StringTokenizer(name, String.valueOf(IConstants.DOT_SEPARATOR));
				boolean firstToken = true;
				IStatus warningStatus = null;
				while (st.hasMoreTokens()) {
					String typeName = st.nextToken();
					typeName = typeName.trim(); // grammar allows spaces
					char[] typeNameChars = typeName.toCharArray();
					for (int i = 0; i < typeNameChars.length; i++) {
						char c = typeNameChars[i];
						if (Character.isWhitespace(c)) {
							return DeployCorePlugin
									.createErrorStatus(
											0,
											DeployCoreMessages.CreateTopologyDataModelProvider_Spaces_are_not_valid_characters_in_,
											null);
						}
						if (c == '/' || c == '\\' || !Character.isLetterOrDigit(c)) {
							return DeployCorePlugin
									.createErrorStatus(
											0,
											NLS
													.bind(
															DeployCoreMessages.CreateTopologyDataModelProvider_0_is_an_invalid_character_in_the_,
															new Object[] { new Character(c), typeName }), null);
						}
					}
					IStatus status = workspace.validateName(typeName, IResource.FOLDER);
					if (!status.isOK()) {
						return status;
					}
					if (firstToken && typeNameChars.length > 0
							&& Character.isUpperCase(typeNameChars[0])) {
						if (warningStatus == null) {
							warningStatus = DeployCorePlugin
									.createStatus(
											IStatus.INFO,
											0,
											DeployCoreMessages.CreateTopologyDataModelProvider_By_convention_namespaces_typically_,
											null);
						}
					}
					firstToken = false;
				}
				IContainer container = getTopologyDataModel().getNamespaceContainer();
				if (container == null || !container.exists()) {
					warningStatus = DeployCorePlugin
							.createStatus(
									IStatus.INFO,
									0,
									DeployCoreMessages.CreateTopologyDataModelProvider_The_namespace_doesn_t_exist_and_wil_,
									null);
				}
				if (warningStatus != null) {
					return warningStatus;
				}
			}
		}
		return OK_STATUS;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateTopologyDataModelProperties#TOPOLOGY_DESCRIPTION
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateTopologyDescription() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION) instanceof String);
		//String topologyDescriptionProperty = (String)  model.getProperty(ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the TopologyDescription property.
	 * @see ICreateTopologyDataModelProperties#TOPOLOGY_DESCRIPTION
	 * @see CreateTopologyDataModel#getTopologyDescription()
	 * 
	 */
	protected String getDefaultTopologyDescription() {
		Calendar now = Calendar.getInstance();
		//SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");//$NON-NLS-1$
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd E a hh:mm:ss z");//$NON-NLS-1$
		// Change for RATLC01148960
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);

		return NLS.bind(DeployCoreMessages.CreateTopologyDataModelProvider_Created_on_0_, formatter
				.format(now.getTime()));
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateTopologyDataModelProperties#DECORATOR_SEMANTIC
	 */
	public IStatus validateDecoratorSemantic() {
		if (isPropertySet(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC)) {
			String decoratorSemanticName = getStringProperty(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC);
			if (decoratorSemanticName != null
					&& !decoratorSemanticName.equals(DecoratorSemanticConstants.BLANK_SEMANTIC)) {
				//Validate that this name has a registered ID.
				IDecoratorSemanticService dsService = ExtensionsCore.createDecoratorSemanticService();
				String id = dsService.getDecoratorSemanticId(decoratorSemanticName);
				if (id == null || id.length() == 0) {
					return DeployCorePlugin
							.createErrorStatus(
									0,
									NLS
											.bind(
													DeployCoreMessages.CreateTopologyDataModelProvider_The_decorator_semantic_name_0_i_,
													decoratorSemanticName), null);
				}
			}
		}
		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the DecoratorSemantic property.
	 * @see ICreateTopologyDataModelProperties#DECORATOR_SEMANTIC
	 * @see CreateTopologyDataModel#getDecoratorSemantic()
	 */
	protected String getDefaultDecoratorSemantic() {
		return DecoratorSemanticConstants.BLANK_SEMANTIC;
	}

	/**
	 * 
	 * @return The default value of the DecoratorSemanticDescription property.
	 * @see ICreateTopologyDataModelProperties#DECORATOR_SEMANTIC_DESCRIPTION
	 * @see CreateTopologyDataModel#getDecoratorSemanticDescription()
	 */
	protected String getDefaultDecoratorSemanticDescription() {
		String decoratorSemantic = model
				.getStringProperty(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC);
		String description = null;
		if (decoratorSemantic != null) {
			if (decoratorSemantic.equals(DecoratorSemanticConstants.BLANK_SEMANTIC)) {
				description = DeployCoreMessages.CreateTopologyDataModelProvider_A_topology_type_that_will_not_const_;
			} else {
				IDecoratorSemanticService dsService = ExtensionsCore.createDecoratorSemanticService();
				description = dsService.getDecoratorSemanticDescription(decoratorSemantic);
			}
		}
		return description == null ? "" : description; //$NON-NLS-1$ 
	}

	/**
	 * The source path must have at least one segment. This first segment must match an existing
	 * project. A warning will be presented for any other segments that do not exist. It is expected
	 * that an operation will create a source folder if it doesn't exist.
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateTopologyDataModelProperties#SOURCE_PATH
	 * 
	 */
	public IStatus validateSourcePath() {
		String sourcePathProperty = model
				.getStringProperty(ICreateTopologyDataModelProperties.SOURCE_PATH);
		sourcePathProperty = sourcePathProperty.trim();
		if (sourcePathProperty == null || sourcePathProperty.length() < 1) {
			return DeployCorePlugin.createErrorStatus(0,
					DeployCoreMessages.CreateTopologyDataModelProvider_The_source_folder_is_required_,
					null);
		}
		// Validate that the first segment resolves to a project.
		sourcePathProperty = TextProcessor.deprocess(sourcePathProperty);
		IPath sourcePath = new Path(sourcePathProperty);
		try {
			String projectName = sourcePath.segment(0);
			projectName = TextProcessor.deprocess(projectName);
			IProject project = projectName != null ? ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName) : null;

			if (project == null || !project.exists()) {
				return DeployCorePlugin
						.createErrorStatus(
								0,
								NLS
										.bind(
												DeployCoreMessages.CreateTopologyDataModelProvider_The_selected_souce_folder_project_,
												projectName), null);
			} else if (!project.isAccessible()) {
				return DeployCorePlugin
						.createErrorStatus(
								0,
								NLS
										.bind(
												DeployCoreMessages.CreateTopologyDataModelProvider_The_selected_souce_folder_project__2,
												projectName), null);
			}/*
				 * else if(sourcePath.segmentCount() == 1){//Make it so that project cannot be source
				 * folder return DeployCorePlugin .createErrorStatus( 0, NLS .bind(
				 * DeployCoreMessages.CreateTopologyDataModelProvider_Projects_cannot_be_used_as_source_f_,
				 * projectName), null); }
				 */
			// This is a temporary restriction.
			if (sourcePath.segmentCount() > 2) {
				return DeployCorePlugin
						.createErrorStatus(
								0,
								DeployCoreMessages.CreateTopologyDataModelProvider_The_source_folder_is_limitted_to_a_,
								null);
			}
			if (sourcePath.segmentCount() > 1) {
				IContainer sourceContainer = getSourceContainer();
				// Validate that it exists.
				if (sourceContainer == null || !sourceContainer.exists()) {
					// Validate that the segment doesn't contain invalid
					// characters.
					String segment = sourcePath.segment(1);
					TextProcessor.deprocess(segment);
					IStatus status = ResourcesPlugin.getWorkspace().validateName(segment,
							IResource.FOLDER);
					if (!status.isOK()) {
						return status;
					}
					return DeployCorePlugin
							.createStatus(
									IStatus.WARNING,
									0,
									DeployCoreMessages.CreateTopologyDataModelProvider_The_topology_source_path_0_does_,
									null);
				}
				if (!sourceContainer.isAccessible()) {
					return DeployCorePlugin
							.createErrorStatus(
									0,
									NLS
											.bind(
													DeployCoreMessages.CreateTopologyDataModelProvider_The_container_for_the_path_0_do_,
													sourcePath.toString()), null);
				}
				// Validate that the selected container is not already a
				// namespace.
				INamespaceElement element = NamespaceCore.create(sourceContainer);
				if (element != null && element.getType() == INamespaceElement.TOPOLOGY_NAMESPACE) {
					return DeployCorePlugin
							.createErrorStatus(
									0,
									NLS
											.bind(
													DeployCoreMessages.CreateTopologyDataModelProvider_The_source_path_0_resolves_to_a_,
													sourcePath.toString()), null);
				}
			} else {
				return DeployCorePlugin
						.createStatus(
								IStatus.ERROR,
								0,
								DeployCoreMessages.CreateTopologyDataModelProvider_Projects_cannot_be_used_as_source_f_,
								null);
			}
		} catch (Exception e) {
			// This will happen if we have an invalid format.
			return DeployCorePlugin.createErrorStatus(0, NLS.bind(
					DeployCoreMessages.CreateTopologyDataModelProvider_The_source_path_0_is_not_a_vali_,
					sourcePath.toString()), e);
		}
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICreateTopologyDataModelProperties#SOURCE_PATH
	 */
	protected IPath getDefaultSourcePath() {
		// TODO Return the default value of the SourcePath property.
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateTopologyDataModelProperties#NAMESPACE_PATH
	 * 
	 */
	public IStatus validateNamespacePath() {
		if (model.isPropertySet(ICreateTopologyDataModelProperties.NAMESPACE_PATH)) {
			String namespacePath = model
					.getStringProperty(ICreateTopologyDataModelProperties.NAMESPACE_PATH);
			return validateNamespace(namespacePath);
		}
		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICreateTopologyDataModelProperties#NAMESPACE_PATH
	 */
	protected IPath getDefaultNamespacePath() {
		// Null is the default value.
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICreateTopologyDataModelProperties#TOPOLOGY_FILE
	 */
	protected IFile getDefaultTopologyFile() {
		CreateTopologyDataModel myDataModel = getTopologyDataModel();
		IFile topologyFile = null;
		IContainer namespaceContainer = getNamespaceContainer();
		String topologyName = myDataModel.getTopologyName();
		if (namespaceContainer != null && topologyName != null && topologyName.length() > 0) {
			// Use the container to define the IFile for the topology.
			IPath topologyFilePath = new Path(myDataModel.getTopologyName());
			topologyFilePath = topologyFilePath.addFileExtension(IConstants.TOPOLOGY_EXTENSION);
			topologyFile = namespaceContainer.getFile(topologyFilePath);
		}
		return topologyFile;
	}

	private IContainer getNamespaceContainer() {
		CreateTopologyDataModel myDataModel = getTopologyDataModel();
		return computeContainerFromNamespace(getSourceContainer(), myDataModel.getNamespacePath());
	}

	/**
	 * 
	 * @param root
	 * @param namespace
	 * @return
	 */
	public static IContainer computeContainerFromNamespace(IContainer root, String namespace) {
		IContainer namespaceContainer = root;
		if (namespace != null && root != null && namespace.length() > 0) {
			IPath namespacePath = new Path(namespace.replace('.', '/'));
			namespaceContainer = root.getFolder(namespacePath);
		}
		return namespaceContainer;
	}

	private IContainer getSourceContainer() {
		CreateTopologyDataModel myDataModel = getTopologyDataModel();
		String sourcePath = myDataModel.getSourcePath();
		sourcePath = TextProcessor.deprocess(sourcePath);
		if (sourcePath != null && sourcePath.length() > 0) {
			return getWorkspaceRelativeContainer(new Path(sourcePath));
		}
		return null;
	}

	/**
	 * 
	 * @param workspaceRelativePath -
	 *           An {@link IPath} that is workspace relative (i.e., the first segment is a project
	 *           name.
	 * @return An {@link IContainer} resolved from the workspaceRelativePath.
	 */
	public static IContainer getWorkspaceRelativeContainer(IPath workspaceRelativePath) {
		IContainer container = null;
		if (workspaceRelativePath != null && workspaceRelativePath.segmentCount() > 0) {
			// The project is the first segment in the path.
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
					workspaceRelativePath.segment(0));
			if (workspaceRelativePath.segmentCount() > 1) {
				IPath projectRelativePath = null;
				// Remove the project segment and set the folder within the
				// project.
				if (project != null && project.isAccessible()) {
					projectRelativePath = workspaceRelativePath.removeFirstSegments(1);
					container = project.getFolder(projectRelativePath);
				}
			} else {
				// The project is the source container.
				container = project;
			}
		}
		return container;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels) NOT
	 */
	public IStatus validate(String property) {
		if (ICreateTopologyDataModelProperties.SOURCE_PATH.equals(property)) {
			return validateSourcePath();
		} else if (ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION.equals(property)) {
			return validateTopologyDescription();
		} else if (ICreateTopologyDataModelProperties.NAMESPACE_PATH.equals(property)) {
			return validateNamespacePath();
		} else if (ICreateTopologyDataModelProperties.CONTRACT_TYPE.equals(property)) {
			return validateContractType();
		} else if (ICreateTopologyDataModelProperties.TOPOLOGY_NAME.equals(property)) {
			return validateTopologyName();
		} else if (ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC.equals(property)) {
			return validateDecoratorSemantic();
		} else if (IAddToPaletteDataModelProperties.DATAMODEL.equals(property)
				&& isPropertySet(IAddToPaletteDataModelProperties.DATAMODEL)) {
			return validateAddToPaletteDataModel();
		}

		else {
			return Status.OK_STATUS;
		}

	}

	private IStatus validateAddToPaletteDataModel() {
		AddToPaletteDataModel addtoPaletteDataModel = getAddToPaletteDataModel();
		if (addtoPaletteDataModel.getAddToPalette()) {
			return addtoPaletteDataModel.getUnderlyingDataModel().validate(true);

		} else {
			return Status.OK_STATUS;
		}
	}

	private AddToPaletteDataModel getAddToPaletteDataModel() {
		if (isPropertySet(IAddToPaletteDataModelProperties.DATAMODEL)) {
			IDataModel dataModel = model.getNestedModel(IAddToPaletteDataModelProperties.DATAMODEL);
			if (model == null) {
				return null;
			}
			return new AddToPaletteDataModel(dataModel);
		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultProperty(String property) {
		if (ICreateTopologyDataModelProperties.SOURCE_PATH.equals(property)) {
			return getDefaultSourcePath();
		} else if (ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION.equals(property)) {
			return getDefaultDecoratorSemanticDescription();
		} else if (ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION.equals(property)) {
			return getDefaultTopologyDescription();
		} else if (ICreateTopologyDataModelProperties.NAMESPACE_PATH.equals(property)) {
			return getDefaultNamespacePath();
		} else if (ICreateTopologyDataModelProperties.CONTRACT_TYPE.equals(property)) {
			return getDefaultContractType();
		} else if (ICreateTopologyDataModelProperties.TOPOLOGY_FILE.equals(property)) {
			return getDefaultTopologyFile();
		} else if (ICreateTopologyDataModelProperties.TOPOLOGY_NAME.equals(property)) {
			return getDefaultTopologyName();
		} else if (ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC.equals(property)) {
			return getDefaultDecoratorSemantic();
		} else {
			return null;
		}

	}

	/*
	 * Override this method to handle dependencies between different properties. That is, if changing
	 * a name property updates the default values of other properties, this is where you respond to
	 * these changes.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#propertySet(String,
	 *      Object)
	 * 
	 */
	public boolean propertySet(String propertyName, Object propertyValue) {
		boolean result = super.propertySet(propertyName, propertyValue);
		if (result) {
			if (propertyName.equals(SOURCE_PATH) || propertyName.equals(NAMESPACE_PATH)) {
				getDataModel().notifyPropertyChange(TOPOLOGY_FILE, IDataModel.DEFAULT_CHG);
				getDataModel().notifyPropertyChange(TOPOLOGY_NAME, IDataModel.DEFAULT_CHG);
			}
			if (propertyName.equals(TOPOLOGY_NAME)) {
				getDataModel().notifyPropertyChange(TOPOLOGY_FILE, IDataModel.DEFAULT_CHG);
				if (getAddToPaletteDataModel() != null) {
					getAddToPaletteDataModel().setLabel((String) propertyValue);
				}

			} else if (propertyName.equals(DECORATOR_SEMANTIC)) {
				getDataModel().notifyPropertyChange(DECORATOR_SEMANTIC_DESCRIPTION,
						IDataModel.DEFAULT_CHG);

			}
		}
		return result;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(ICreateTopologyDataModelProperties.SOURCE_PATH);
		propertyNames.add(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION);
		propertyNames.add(ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION);
		propertyNames.add(ICreateTopologyDataModelProperties.NAMESPACE_PATH);
		propertyNames.add(ICreateTopologyDataModelProperties.CONTRACT_TYPE);
		propertyNames.add(ICreateTopologyDataModelProperties.TOPOLOGY_FILE);
		propertyNames.add(ICreateTopologyDataModelProperties.TOPOLOGY_NAME);
		propertyNames.add(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC);
		propertyNames.add(IAddToPaletteDataModelProperties.DATAMODEL);
		return propertyNames;
	}

	/*
	 * Setup nested models here.
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider#init()
	 */
	public void init() {
		super.init();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new CreateTopologyDataModelOperation(model);
	}

	private CreateTopologyDataModel getTopologyDataModel() {
		if (topologyDataModel == null) {
			topologyDataModel = new CreateTopologyDataModel(getDataModel());
		}
		return topologyDataModel;
	}

	public DataModelPropertyDescriptor[] getValidPropertyDescriptors(String propertyName) {
		if (DECORATOR_SEMANTIC.equals(propertyName)) {
			return getValidDecoratorSemantics();
		} else if (CONTRACT_TYPE.equals(propertyName)) {
			return getValidContractTypes();
		}
		return super.getValidPropertyDescriptors(propertyName);
	}

	private DataModelPropertyDescriptor[] getValidDecoratorSemantics() {
		IDecoratorSemanticService dsService = ExtensionsCore.createDecoratorSemanticService();
		String[] names = dsService.getAllDecoratorSemanticNames();
		Arrays.sort(names);
		int descriptorSize = names == null ? 1 : names.length + 1;
		DataModelPropertyDescriptor[] descriptors = new DataModelPropertyDescriptor[descriptorSize];
		descriptors[0] = new DataModelPropertyDescriptor(DecoratorSemanticConstants.BLANK_SEMANTIC);
		if (names != null && names.length > 0) {
			for (int i = 0; i < names.length; i++) {
				descriptors[i + 1] = new DataModelPropertyDescriptor(names[i]);
			}
		}
		return descriptors;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ICreateTopologyDataModelProperties#CONTRACT_TYPE
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateContractType() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(ICreateTopologyDataModelProperties.CONTRACT_TYPE) instanceof String);
		//String contractTypeProperty = (String)  model.getProperty(ICreateTopologyDataModelProperties.CONTRACT_TYPE);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the ContractType property.
	 * @see ICreateTopologyDataModelProperties#CONTRACT_TYPE
	 * @see CreateTopologyDataModel#getContractType()
	 * 
	 */
	protected String getDefaultContractType() {

		ContractProviderDescriptor[] contractDescriptors = ContractProviderManager.getInstance()
				.getDescriptors();
		if (contractDescriptors.length > 0) {
			return contractDescriptors[0].getDisplayName();
		}
		return ""; //$NON-NLS-1$
	}

	private DataModelPropertyDescriptor[] getValidContractTypes() {
		ContractProviderDescriptor[] contractDescriptors = ContractProviderManager.getInstance()
				.getDescriptors();
		DataModelPropertyDescriptor[] descriptors = new DataModelPropertyDescriptor[contractDescriptors.length];
		for (int i = 0; i < descriptors.length; i++) {
			descriptors[i] = new DataModelPropertyDescriptor(contractDescriptors[i].getDisplayName());
		}
		return descriptors;
	}

}
