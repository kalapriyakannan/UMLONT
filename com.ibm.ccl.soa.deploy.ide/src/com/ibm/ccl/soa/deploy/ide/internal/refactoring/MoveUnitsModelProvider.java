/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager.Listener;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.operation.MoveUnitsOperation;
import com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsRefactoringDescriptor;
import com.ibm.ccl.soa.deploy.index.search.Query;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsRefactoringDescriptor}. The provider is
 * required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsRefactoringDescriptor
 * @generated (mde.utilities.datamodels)
 */
public class MoveUnitsModelProvider extends AbstractDataModelProvider implements
		IMoveUnitsModelProperties {

	private ROTopologyModelManager modelManager = null;

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveUnitsModelProperties#USE_EXISTING_TOPOLOGY
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateUseExistingTopology() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY) instanceof Boolean);
		//Boolean useExistingTopologyProperty = (Boolean)  model.getProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the UseExistingTopology property.
	 * @see IMoveUnitsModelProperties#USE_EXISTING_TOPOLOGY
	 * @see MoveUnitsRefactoringDescriptor#getUseExistingTopology()
	 * 
	 */
	protected Boolean getDefaultUseExistingTopology() {
		return Boolean.TRUE;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveUnitsModelProperties#PRESERVE_LINKS
	 * 
	 */
	public IStatus validatePreserveLinks() {

		Topology source = getSourceTopology();
		Topology destination = getDestinationTopology();

		boolean useExistingTopology = model.getBooleanProperty(USE_EXISTING_TOPOLOGY);
		boolean willNeedToCreateImports = false;

		MultiStatus validationStatus = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, null, null);
		ImportPreservationStatus status = new ImportPreservationStatus(PRESERVE_LINKS_IN_NEITHER,
				null);
		Map<IPath, List<IPath>> importMap = new HashMap<IPath, List<IPath>>();
		List<Unit> units = Arrays.asList((Unit[]) model.getProperty(UNITS));
		for (Iterator<DeployLink> iter = source.findAllDeployLinks(); iter.hasNext();) {
			DeployLink link = iter.next();

			// ignore links proxied in from an import
			if (!link.getEditTopology().equals(link.getTopology())) {
				continue;
			}

			DeployModelObject lnkSource = source.resolve(link.getSourceURI());
			DeployModelObject lnkTarget = source.resolve(link.getTargetURI());

			Unit lnkSourceUnit = findParentUnit(lnkSource);

			if (null == lnkSourceUnit) {
				// Invalid link defined in topology model
				return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, NLS.bind(
						Messages.MoveUnitsModelProvider_The_sourceURI_property_of_the_link_,
						new Object[] { link.getName(), link.getTopology().getQualifiedName(),
								link.getSourceURI() }));
			}

			Unit lnkTargetUnit = findParentUnit(lnkTarget);

			if (null == lnkTargetUnit) {
				// Invalid link defined in topology model
				return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, NLS.bind(
						Messages.MoveUnitsModelProvider_The_targetURI_property_of_the_link_,
						new Object[] { link.getName(), link.getTopology().getQualifiedName(),
								link.getTargetURI() }));
			}

			boolean sourceWillBeMoved = units.contains(lnkSourceUnit);
			boolean sourceIsImported = !link.getSourceURI().startsWith(
					new String() + IConstants.PATH_SEPARATOR);
			boolean targetWillBeMoved = units.contains(lnkTargetUnit);
			boolean targetIsImported = !link.getTargetURI().startsWith(
					new String() + IConstants.PATH_SEPARATOR);

			// determine if this link will require an import to be created
			boolean needImport = false;

			if (sourceWillBeMoved) {
				if (targetIsImported) {
					if (null == destination && !useExistingTopology) {
						if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_DESTINATION)) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
													new Object[] {
															getDestinationNamespace() + IConstants.DOT_SEPARATOR
																	+ getDestinationName(),
															source.eResource().getURI().lastSegment() }));
						}
						needImport = true;
						getToBeCreatedImports(importMap, getSourceTopologyFile().getFullPath()).add(
								getDestinationTopologyFile().getFullPath());
						validationStatus
								.add(status = new ImportPreservationStatus(
										PRESERVE_LINKS_IN_SOURCE,
										Messages.MoveUnitsRefactoringDataModelProvider_Imports_must_be_placed_in_source_to_));
					} else if (null != destination && useExistingTopology
							&& !link.getTargetURI().startsWith(destination.getQualifiedName())) {
						if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_DESTINATION)) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
													new Object[] {
															getDestinationNamespace() + IConstants.DOT_SEPARATOR
																	+ getDestinationName(),
															source.eResource().getURI().lastSegment() }));
						}
						needImport = true;
						getToBeCreatedImports(importMap, getSourceTopologyFile().getFullPath()).add(
								getDestinationTopologyFile().getFullPath());
						validationStatus
								.add(status = new ImportPreservationStatus(
										PRESERVE_LINKS_IN_SOURCE,
										Messages.MoveUnitsRefactoringDataModelProvider_Imports_must_be_placed_in_source_to_));
						if (hasImport(destination, source)) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
													new Object[] { destination.getQualifiedName(),
															source.eResource().getURI().lastSegment() }));
						}
						if (haveCommonImports(destination, source)
								|| haveCommonImports(getToBeCreatedImports(importMap,
										getSourceTopologyFile().getFullPath()), getToBeCreatedImports(
										importMap, getDestinationTopologyFile().getFullPath()))) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on__2,
													new Object[] { destination.getQualifiedName(),
															source.eResource().getURI().lastSegment() }));
						}
					}
				} else if (!targetWillBeMoved) {
					needImport = true;
					if (null != destination && useExistingTopology) {
						if (hasImport(destination, source)) {
							if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_SOURCE)) {
								return new Status(
										IStatus.ERROR,
										DeployCorePlugin.PLUGIN_ID,
										NLS
												.bind(
														Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
														new Object[] {
																source.getQualifiedName(),
																getDestinationTopologyFile().getFullPath()
																		.lastSegment() }));
							}
							needImport = false;
							validationStatus
									.add(status = new ImportPreservationStatus(
											PRESERVE_LINKS_IN_DESTINATION,
											Messages.MoveUnitsRefactoringDataModelProvider_Imports_must_be_placed_in_destinati_));
						}
						if (hasImport(source, destination)) {
							if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_DESTINATION)) {
								return new Status(
										IStatus.ERROR,
										DeployCorePlugin.PLUGIN_ID,
										NLS
												.bind(
														Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
														new Object[] {
																getDestinationNamespace()
																		+ IConstants.DOT_SEPARATOR
																		+ getDestinationName(),
																source.eResource().getURI().lastSegment() }));
							}
							needImport = false;
							validationStatus
									.add(status = new ImportPreservationStatus(
											PRESERVE_LINKS_IN_SOURCE,
											Messages.MoveUnitsRefactoringDataModelProvider_Imports_must_be_placed_in_source_to_));
						}
						if (haveCommonImports(destination, source)
								|| haveCommonImports(getToBeCreatedImports(importMap,
										getSourceTopologyFile().getFullPath()), getToBeCreatedImports(
										importMap, getDestinationTopologyFile().getFullPath()))) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on__2,
													new Object[] { destination.getQualifiedName(),
															source.eResource().getURI().lastSegment() }));
						}
					}
				}
			}

			if (targetWillBeMoved) {
				if (sourceIsImported) {
					if (null == destination && !useExistingTopology) {
						if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_DESTINATION)) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
													new Object[] {
															source.getQualifiedName(),
															getDestinationTopologyFile().getFullPath()
																	.lastSegment() }));
						}
						needImport = true;
						getToBeCreatedImports(importMap, getSourceTopologyFile().getFullPath()).add(
								getDestinationTopologyFile().getFullPath());
						validationStatus
								.add(status = new ImportPreservationStatus(
										PRESERVE_LINKS_IN_SOURCE,
										Messages.MoveUnitsRefactoringDataModelProvider_Imports_must_be_placed_in_source_to_));
					} else if (null != destination && useExistingTopology
							&& !link.getSourceURI().startsWith(destination.getQualifiedName())) {
						if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_DESTINATION)) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
													new Object[] {
															source.getQualifiedName(),
															getDestinationTopologyFile().getFullPath()
																	.lastSegment() }));
						}
						needImport = true;
						getToBeCreatedImports(importMap, getSourceTopologyFile().getFullPath()).add(
								getDestinationTopologyFile().getFullPath());
						validationStatus
								.add(status = new ImportPreservationStatus(
										PRESERVE_LINKS_IN_SOURCE,
										Messages.MoveUnitsRefactoringDataModelProvider_Imports_must_be_placed_in_source_to_));
						if (hasImport(destination, source)) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
													new Object[] { destination.getQualifiedName(),
															source.eResource().getURI().lastSegment() }));
						}
						if (haveCommonImports(destination, source)
								|| haveCommonImports(getToBeCreatedImports(importMap,
										getSourceTopologyFile().getFullPath()), getToBeCreatedImports(
										importMap, getDestinationTopologyFile().getFullPath()))) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on__2,
													new Object[] { destination.getQualifiedName(),
															source.eResource().getURI().lastSegment() }));
						}
					}
				} else if (!sourceWillBeMoved) {
					needImport = true;
					if (null != destination && useExistingTopology) {
						if (hasImport(source, destination)) {
							if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_DESTINATION)) {
								return new Status(
										IStatus.ERROR,
										DeployCorePlugin.PLUGIN_ID,
										NLS
												.bind(
														Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
														new Object[] {
																getDestinationNamespace()
																		+ IConstants.DOT_SEPARATOR
																		+ getDestinationName(),
																source.eResource().getURI().lastSegment() }));
							}
							needImport = false;
							validationStatus
									.add(status = new ImportPreservationStatus(
											PRESERVE_LINKS_IN_SOURCE,
											Messages.MoveUnitsRefactoringDataModelProvider_Imports_must_be_placed_in_source_to_));
						}
						if (hasImport(destination, source)) {
							if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_SOURCE)) {
								return new Status(
										IStatus.ERROR,
										DeployCorePlugin.PLUGIN_ID,
										NLS
												.bind(
														Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on_,
														new Object[] { destination.getQualifiedName(),
																source.eResource().getURI().lastSegment() }));
							}
							needImport = false;
							validationStatus
									.add(status = new ImportPreservationStatus(
											PRESERVE_LINKS_IN_DESTINATION,
											Messages.MoveUnitsRefactoringDataModelProvider_Imports_must_be_placed_in_destinati_));
						}
						if (haveCommonImports(destination, source)
								|| haveCommonImports(getToBeCreatedImports(importMap,
										getSourceTopologyFile().getFullPath()), getToBeCreatedImports(
										importMap, getDestinationTopologyFile().getFullPath()))) {
							return new Status(
									IStatus.ERROR,
									DeployCorePlugin.PLUGIN_ID,
									NLS
											.bind(
													Messages.MoveUnitsRefactoringDataModelProvider_Cannot_perform_move_refactoring_on__2,
													new Object[] { destination.getQualifiedName(),
															source.eResource().getURI().lastSegment() }));
						}
					}
				}
			}

			// if we have not yet had the need to create an import, but this
			// link will require us to create one then mark it as such
			willNeedToCreateImports = needImport ? needImport : willNeedToCreateImports;
		}

		if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_SOURCE)
				&& !model.getStringProperty(PRESERVE_LINKS).equals(PRESERVE_LINKS_IN_SOURCE)) {
			validationStatus
					.add(new Status(
							IStatus.ERROR,
							DeployCorePlugin.PLUGIN_ID,
							Messages.MoveUnitsRefactoringDataModelProvider_Cannot_create_imports_in_destinatio_));
			model.setBooleanProperty(PRESERVE_LINKS_RESTRICTED, Boolean.FALSE);
		} else if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_SOURCE)
				&& model.getStringProperty(PRESERVE_LINKS).equals(PRESERVE_LINKS_IN_SOURCE)) {
			model.setBooleanProperty(PRESERVE_LINKS_RESTRICTED, Boolean.TRUE);
		}

		if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_DESTINATION)
				&& !model.getStringProperty(PRESERVE_LINKS).equals(PRESERVE_LINKS_IN_DESTINATION)) {
			validationStatus
					.add(new Status(
							IStatus.ERROR,
							DeployCorePlugin.PLUGIN_ID,
							Messages.MoveUnitsRefactoringDataModelProvider_Cannot_create_imports_in_source_due_));
			model.setBooleanProperty(PRESERVE_LINKS_RESTRICTED, Boolean.FALSE);
		} else if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_DESTINATION)
				&& model.getStringProperty(PRESERVE_LINKS).equals(PRESERVE_LINKS_IN_DESTINATION)) {
			model.setBooleanProperty(PRESERVE_LINKS_RESTRICTED, Boolean.TRUE);
		}

		if (status.getPreserveConst().equals(PRESERVE_LINKS_IN_NEITHER) && !willNeedToCreateImports
				&& (null != destination && useExistingTopology || !useExistingTopology)) {
			model.setStringProperty(PRESERVE_LINKS, PRESERVE_LINKS_IN_NEITHER);
			model.setBooleanProperty(PRESERVE_LINKS_RESTRICTED, Boolean.TRUE);
			validationStatus
					.add(new Status(
							IStatus.INFO,
							DeployCorePlugin.PLUGIN_ID,
							Messages.MoveUnitsRefactoringDataModelProvider_Imports_will_not_need_to_be_created_));
		}

		return validationStatus;
	}

	/**
	 * 
	 * @return The default value of the PreserveLinks property.
	 * @see IMoveUnitsModelProperties#PRESERVE_LINKS
	 * @see MoveUnitsRefactoringDescriptor#getPreserveLinks()
	 * 
	 */
	protected String getDefaultPreserveLinks() {
		return IMoveUnitsModelProperties.PRESERVE_LINKS_IN_SOURCE;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveUnitsModelProperties#EXISTING_TOPOLOGY_FILE
	 */
	public IStatus validateExistingTopologyFile() {

		try {
			Assert
					.isTrue(model.getProperty(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE) instanceof String);

			if (!model.getBooleanProperty(USE_EXISTING_TOPOLOGY)) {
				return Status.OK_STATUS;
			}

			String path = (String) model.getProperty(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE);

			if (path == null || path.trim().equals(new String())) {
				return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
						Messages.MoveUnitsRefactoringDataModelProvider_is_required_,
						Messages.MoveUnitsRefactoringDataModelProvider_Topolog_));
			}

			if (!path.startsWith(new String() + IConstants.PATH_SEPARATOR)) {
				return new Status(
						IStatus.ERROR,
						DeployCorePlugin.PLUGIN_ID,
						NLS
								.bind(
										Messages.MoveUnitsRefactoringDataModelProvider_Existing_topology_file_path_must_st_,
										IConstants.PATH_SEPARATOR));
			}

			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
			if (!IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
				return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
						Messages.MoveUnitsRefactoringDataModelProvider_0_must_use_the_topology_file_ex_,
						model.getProperty(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE)));
			}

			if (!file.exists()
					&& ((Boolean) model.getProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY))
							.booleanValue()) {
				return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
						Messages.MoveUnitsRefactoringDataModelProvider_0_must_be_an_existing_file_, model
								.getProperty(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE)));
			}

			IFile movedFrom = WorkbenchResourceHelper.getFile(((Unit[]) model
					.getProperty(IMoveUnitsModelProperties.UNITS))[0].eResource());
			if (file.equals(movedFrom)) {
				return new Status(
						IStatus.ERROR,
						DeployCorePlugin.PLUGIN_ID,
						Messages.MoveUnitsRefactoringDataModelProvider_Cannot_move_units_to_the_topology_m_);
			}
		} catch (Exception ex) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex.getMessage(), ex);
		}

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the ExistingTopologyFile property.
	 * @see IMoveUnitsModelProperties#EXISTING_TOPOLOGY_FILE
	 * @see MoveUnitsRefactoringDescriptor#getExistingTopologyFile()
	 * 
	 */
	protected String getDefaultExistingTopologyFile() {
		return new String();
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveUnitsModelProperties#PRESERVE_LINKS_RESTRICTED
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validatePreserveLinksRestricted() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED) instanceof Boolean);
		//Boolean preserveLinksRestrictedProperty = (Boolean)  model.getProperty(IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the PreserveLinksRestricted property.
	 * @see IMoveUnitsModelProperties#PRESERVE_LINKS_RESTRICTED
	 * @see MoveUnitsRefactoringDescriptor#getPreserveLinksRestricted()
	 * 
	 */
	protected Boolean getDefaultPreserveLinksRestricted() {
		return Boolean.FALSE;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveUnitsModelProperties#TOPOLOGY_CREATION_DATA_MODEL
	 * 
	 */
	public IStatus validateTopologyCreationDataModel() {

		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IMoveUnitsModelProperties#TOPOLOGY_CREATION_DATA_MODEL
	 * @generated (mde.utilities.datamodels)
	 */
	protected IDataModel getDefaultTopologyCreationDataModel() {
		// TODO Return the default value of the TopologyCreationDataModel property.
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IMoveUnitsModelProperties#UNITS
	 * 
	 */
	public IStatus validateUnits() {

		Unit[] units = (Unit[]) model.getProperty(UNITS);
		if (units.length == 0) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
					Messages.MoveUnitsRefactoringDataModelProvider_No_units_have_been_selected_to_move_);
		}

		Topology topology = getSourceTopology();
		IFile topologyFile = WorkbenchResourceHelper.getFile(topology);

		if (!topologyFile.getProject().isAccessible()) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
					Messages.MoveUnitsRefactoringDataModelProvider_Source_topology_is_located_in_a_non_);
		}

		if (!topologyFile.isAccessible()) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
					Messages.MoveUnitsRefactoringDataModelProvider_Source_topology_is_not_accessible_);
		}

		if (null != topology) {
			for (int i = 0; i < units.length; i++) {
				Unit unit = units[i];
				Topology aTopology = unit.getTopology();

				// cannot move imported units
				if (!aTopology.getEditTopology().equals(unit.getTopology())) {
					return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
							Messages.MoveUnitsRefactoringDataModelProvider_Cannot_move_imported_units_);
				}

				// cannot move multiple units from different topologies
				if (!topology.eResource().getURI().equals(unit.eResource().getURI())) {
					return new Status(
							IStatus.ERROR,
							DeployCorePlugin.PLUGIN_ID,
							Messages.MoveUnitsRefactoringDataModelProvider_Cannot_move_multiple_units_from_dif_);
				}
			}
		}

		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IMoveUnitsModelProperties#UNITS
	 * 
	 */
	protected Unit[] getDefaultUnits() {
		return new Unit[0];
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IMoveUnitsModelProperties.PRESERVE_LINKS.equals(property)) {
			return validatePreserveLinks();
		} else if (IMoveUnitsModelProperties.UNITS.equals(property)) {
			return validateUnits();
		} else if (IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE.equals(property)) {
			return validateExistingTopologyFile();
		} else if (IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY.equals(property)) {
			return validateUseExistingTopology();
		} else if (IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED.equals(property)) {
			return validatePreserveLinksRestricted();
		} else if (IMoveUnitsModelProperties.TOPOLOGY_CREATION_DATA_MODEL.equals(property)) {
			return validateTopologyCreationDataModel();
		} else {
			return Status.OK_STATUS;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultProperty(String property) {
		if (IMoveUnitsModelProperties.PRESERVE_LINKS.equals(property)) {
			return getDefaultPreserveLinks();
		} else if (IMoveUnitsModelProperties.UNITS.equals(property)) {
			return getDefaultUnits();
		} else if (IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE.equals(property)) {
			return getDefaultExistingTopologyFile();
		} else if (IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY.equals(property)) {
			return getDefaultUseExistingTopology();
		} else if (IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED.equals(property)) {
			return getDefaultPreserveLinksRestricted();
		} else if (IMoveUnitsModelProperties.TOPOLOGY_CREATION_DATA_MODEL.equals(property)) {
			return getDefaultTopologyCreationDataModel();
		} else {
			return null;
		}

	}

	/**
	 * Override this method to handle dependencies between different properties. That is, if changing
	 * a name property updates the default values of other properties, this is where you respond to
	 * these changes.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#propertySet(String,
	 *      Object)
	 * @generated (mde.utilities.datamodels)
	 */
	public boolean propertySet(String propertyName, Object propertyValue) {
		return super.propertySet(propertyName, propertyValue);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IMoveUnitsModelProperties.PRESERVE_LINKS);
		propertyNames.add(IMoveUnitsModelProperties.UNITS);
		propertyNames.add(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE);
		propertyNames.add(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY);
		propertyNames.add(IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED);
		propertyNames.add(IMoveUnitsModelProperties.TOPOLOGY_CREATION_DATA_MODEL);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new MoveUnitsOperation(model);
	}

	private ROTopologyModelManager getModelManager() {
		if (modelManager == null) {
			modelManager = ROTopologyModelManager.create();
		}

		return modelManager;
	}

	@Override
	public void dispose() {
		super.dispose();
		if (modelManager != null) {
			modelManager.dispose();
		}
	}

	public String getDestinationNamespace() {
		if (model.getBooleanProperty(USE_EXISTING_TOPOLOGY)) {
			return getDestinationTopology().getNamespace();
		}

		return model.getNestedModel(TOPOLOGY_CREATION_DATA_MODEL).getStringProperty(
				ICreateTopologyDataModelProperties.NAMESPACE_PATH);
	}

	public String getDestinationName() {
		if (model.getBooleanProperty(USE_EXISTING_TOPOLOGY)) {
			return getDestinationTopology().getName();
		}

		return model.getNestedModel(TOPOLOGY_CREATION_DATA_MODEL).getStringProperty(
				ICreateTopologyDataModelProperties.TOPOLOGY_NAME);
	}

	public Topology getDestinationTopology() {
		if (!model.getBooleanProperty(USE_EXISTING_TOPOLOGY)) {
			return null;
		}
		IFile model = getDestinationTopologyFile();
		if (null == model) {
			return null;
		}
		return getModelManager().openModel(getDestinationTopologyFile(), new Listener() {
			public void onUnload(IFile unloadedResource) {
				// TODO Auto-generated method stub
			}
		});
	}

	public IFile getDestinationTopologyFile() {
		if (model.getBooleanProperty(USE_EXISTING_TOPOLOGY)) {
			IStatus status = validateExistingTopologyFile();
			if (status.isOK()) {
				return ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path((String) model.getProperty(EXISTING_TOPOLOGY_FILE)));
			}

			return null;
		}

		return (IFile) model.getNestedModel(TOPOLOGY_CREATION_DATA_MODEL).getProperty(
				ICreateTopologyDataModelProperties.TOPOLOGY_FILE);
	}

	public String getSourceNamespace() {
		if (getSourceTopology().getNamespace() != null
				&& !getSourceTopology().getNamespace().trim().equals(new String())) {
			return getSourceTopology().getNamespace();
		}

		return null;
	}

	public String getSourceName() {
		return getSourceTopology().getName();
	}

	public Topology getSourceTopology() {
		return ((Unit[]) model.getProperty(UNITS))[0].getTopology();
	}

	public IFile getSourceTopologyFile() {
		return WorkbenchResourceHelper.getFile(((Unit[]) model.getProperty(UNITS))[0]);
	}

	public Collection<URI> findDeployLinksBySourceOrTarget(Unit unit, IProgressMonitor monitor)
			throws CoreException {
		Collection<URI> results = new ArrayList<URI>();
		results.addAll(Query.findDeployLinksByImportedTarget(unit, null, true, false, true, false,
				monitor));
		results.addAll(Query.findDeployLinksByImportedSource(unit, null, true, false, true, false,
				monitor));
		return results;
	}

	private Unit findParentUnit(DeployModelObject dmo) {

		if (null == dmo) {
			return null;
		}

		if (CorePackage.eINSTANCE.getUnit().isSuperTypeOf(dmo.getEObject().eClass())) {
			return (Unit) dmo;
		}

		DeployModelObject parent = dmo.getParent();
		while (!CorePackage.eINSTANCE.getUnit().isSuperTypeOf(parent.eClass())
				&& !CorePackage.eINSTANCE.getTopology().isSuperTypeOf(parent.eClass())) {
			parent = parent.getParent();
		}

		if (CorePackage.eINSTANCE.getUnit().isSuperTypeOf(parent.eClass())) {
			return (Unit) parent;
		}

		return null;
	}

	private boolean hasImport(Topology topology, Topology imported) {
		if (null == imported) {
			return false;
		}
		return hasImport(topology, imported.getQualifiedName());
	}

	private boolean hasImport(Topology topology, String qualifiedTopologyName) {
		if (null == topology || null == qualifiedTopologyName) {
			return false;
		}
		for (Iterator<Import> iter = topology.getImports().iterator(); iter.hasNext();) {
			Import anImport = iter.next();
			if (qualifiedTopologyName.equals(anImport.getQualifiedImport())) {
				return true;
			}
		}

		return false;
	}

	private boolean haveCommonImports(Topology topology1, Topology topology2) {
		if (null == topology1 || null == topology2) {
			return false;
		}

		for (Iterator<Import> iter = topology1.getImports().iterator(); iter.hasNext();) {
			Import anImport = iter.next();
			if (hasImport(topology2, anImport.getQualifiedImport())) {
				return true;
			}
		}

		for (Iterator<Import> iter = topology2.getImports().iterator(); iter.hasNext();) {
			Import anImport = iter.next();
			if (hasImport(topology1, anImport.getQualifiedImport())) {
				return true;
			}
		}

		return false;
	}

	private boolean haveCommonImports(List<IPath> aImports, List<IPath> bImports) {
		if (null == aImports || null == bImports) {
			return false;
		}

		for (Iterator<IPath> iter = aImports.iterator(); iter.hasNext();) {
			IPath aPath = iter.next();
			if (bImports.contains(aPath)) {
				return true;
			}
		}

		for (Iterator<IPath> iter = bImports.iterator(); iter.hasNext();) {
			IPath bPath = iter.next();
			if (aImports.contains(bPath)) {
				return true;
			}
		}

		return false;
	}

	private List<IPath> getToBeCreatedImports(Map<IPath, List<IPath>> importMap, IPath topology) {
		List imports = importMap.get(topology);
		if (imports == null) {
			imports = new ArrayList<IPath>();
			importMap.put(topology, imports);
		}
		return imports;
	}

	private class ImportPreservationStatus extends Status {

		private final String preserveConst;

		public ImportPreservationStatus(String preserveConst, String message) {
			super(IStatus.INFO, DeployCorePlugin.PLUGIN_ID, message);
			this.preserveConst = preserveConst;
		}

		public String getPreserveConst() {
			return preserveConst;
		}

	}
}
