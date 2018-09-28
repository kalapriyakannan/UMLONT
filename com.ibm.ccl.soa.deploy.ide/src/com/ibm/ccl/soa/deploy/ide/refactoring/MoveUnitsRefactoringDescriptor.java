/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.MoveRefactoring;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager.Listener;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.IMoveUnitsModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.MoveUnitsModelProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.operation.MoveUnitsOperation;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * 
 * This data model is used to refactor units from one topology model to another. It allows for the
 * use of an existing topology file as the destination as well as the ability to create a new
 * topology model by nesting the CreatTopologyDataModel.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>units</b>: The set of units to be moved. </li>
 * <li><b>useExistingTopology</b>: Indicates if the destination topology model of the move
 * refactoring is an existing topology. </li>
 * <li><b>preserveLinks</b>: Indicates how links to the units that will be moved in this
 * refactoring will be preserved, if any links to the units exist. </li>
 * <li><b>existingTopologyFile</b>: Path of the existing topology file. </li>
 * <li><b>preserveLinksRestricted</b>: The purpose of this property is to restrict the
 * preserveLinks property to a specific value and prevent it from changing. The preserveLinks
 * property will remain set to the value it was set to when this property is set to true. </li>
 * </ul>
 * 
 * <p>
 * The following <b>nested models</b> are used by this datamodel. Nested datamodels are used to
 * supplement the information collected by an enclosing datamodel or to execute nested operations
 * directly. The type-safe facade provides generates type-safe facades for each of the nested
 * datamodels, and provides the appropriate accessors and mutators.
 * </p>
 * <p>
 * Accessors (methods that begin with "get") will first check the facaded datamodel for an instance
 * of the nested datamodel, and if found, wrap it in a type-safe facade. Otherwise, the appropriate
 * datamodel will be created, wrapped, and returned.
 * </p>
 * <p>
 * Clients are not required to supply their own instances of nested models (as they are created when
 * accessors ("get") methods are called, but may access the
 * {@link #getUnderlyingDataModel() underlying datamodel} directly if they require advanced
 * customization.
 * </p>
 * <ul>
 * <li><b>topologyCreationDataModel</b> (Type:
 * {@link com.ibm.ccl.soa.deploy.ide.datamodels.CreateTopologyDataModel} ) : Used when the
 * destination of this move refactoring is a new topology model. </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class MoveUnitsRefactoringDescriptor extends RefactoringDescriptor {

	/**
	 * Refactoring id of the 'Move Units' refactoring (value:
	 * <code>com.ibm.ccl.soa.deploy.ide.refactoring.move.units</code>).
	 * <p>
	 * Clients may safely cast the obtained refactoring descriptor to
	 * {@link MoveUnitsRefactoringDescriptor}.
	 * </p>
	 */
	public static final String ID = "com.ibm.ccl.soa.deploy.ide.refactoring.move.units"; //$NON-NLS-1$

	private final IDataModel model;
	private CreateTopologyDataModel topologyCreationDataModel;
	private ROTopologyModelManager modelManager = null;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static MoveUnitsRefactoringDescriptor createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new MoveUnitsRefactoringDescriptor(model);
	}

	/**
	 * Creates and returns an instance of the underlying provider for this facade.
	 * 
	 * <p>
	 * A provider implements the actual logic of a data model. All validation logic, calculation of
	 * default values, and management of property dependencies is handled by the provider.
	 * </p>
	 * 
	 * @return An instance of the underlying provider for this facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public static IDataModelProvider createDatamodelProvider() {
		return new MoveUnitsModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveUnitsRefactoringDescriptor(IDataModel mdl) {
		super(
				ID,
				null,
				"N/A", null, RefactoringDescriptor.STRUCTURAL_CHANGE | RefactoringDescriptor.MULTI_CHANGE); //$NON-NLS-1$
		model = mdl;
	}

	@Override
	public Refactoring createRefactoring(RefactoringStatus status) throws CoreException {
		MoveUnitsProcessor processor = new MoveUnitsProcessor(this);
		return new MoveRefactoring(processor);
	}

	/**
	 * Indicates if the destination topology model of the move refactoring is an existing topology.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newUseExistingTopology
	 *           The new value of the UseExistingTopology property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setUseExistingTopology(Boolean newUseExistingTopology) {
		model.setProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY, newUseExistingTopology);
	}

	/**
	 * Indicates if the destination topology model of the move refactoring is an existing topology.
	 * 
	 * @return The value of the UseExistingTopology property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getUseExistingTopology() {
		return (Boolean) model.getProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY);
	}

	/**
	 * Determine if the UseExistingTopology property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         UseExistingTopology property is valid.
	 * @see #getUseExistingTopology()
	 * @see #setUseExistingTopology(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateUseExistingTopology() {
		return model.validateProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY);
	}

	/**
	 * Determine the default value of the UseExistingTopology property.
	 * 
	 * @return The default value of the UseExistingTopology property.
	 * @see #getUseExistingTopology()
	 * @see #setUseExistingTopology(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultUseExistingTopology() {
		return (Boolean) model.getDefaultProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY);
	}

	/**
	 * Indicates how links to the units that will be moved in this refactoring will be preserved, if
	 * any links to the units exist.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newPreserveLinks
	 *           The new value of the PreserveLinks property.
	 * 
	 */
	public void setPreserveLinks(String newPreserveLinks) {
		if (!model.getBooleanProperty(IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED)) {
			model.setProperty(IMoveUnitsModelProperties.PRESERVE_LINKS, newPreserveLinks);
		}
	}

	/**
	 * Indicates how links to the units that will be moved in this refactoring will be preserved, if
	 * any links to the units exist.
	 * 
	 * @return The value of the PreserveLinks property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getPreserveLinks() {
		return (String) model.getProperty(IMoveUnitsModelProperties.PRESERVE_LINKS);
	}

	/**
	 * Determine if the PreserveLinks property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         PreserveLinks property is valid.
	 * @see #getPreserveLinks()
	 * @see #setPreserveLinks(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validatePreserveLinks() {
		return model.validateProperty(IMoveUnitsModelProperties.PRESERVE_LINKS);
	}

	/**
	 * Determine the default value of the PreserveLinks property.
	 * 
	 * @return The default value of the PreserveLinks property.
	 * @see #getPreserveLinks()
	 * @see #setPreserveLinks(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultPreserveLinks() {
		return (String) model.getDefaultProperty(IMoveUnitsModelProperties.PRESERVE_LINKS);
	}

	/**
	 * Path of the existing topology file.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newExistingTopologyFile
	 *           The new value of the ExistingTopologyFile property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setExistingTopologyFile(String newExistingTopologyFile) {
		model.setProperty(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE, newExistingTopologyFile);
	}

	/**
	 * Path of the existing topology file.
	 * 
	 * @return The value of the ExistingTopologyFile property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getExistingTopologyFile() {
		return (String) model.getProperty(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE);
	}

	/**
	 * Determine if the ExistingTopologyFile property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ExistingTopologyFile property is valid.
	 * @see #getExistingTopologyFile()
	 * @see #setExistingTopologyFile(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateExistingTopologyFile() {
		return model.validateProperty(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE);
	}

	/**
	 * Determine the default value of the ExistingTopologyFile property.
	 * 
	 * @return The default value of the ExistingTopologyFile property.
	 * @see #getExistingTopologyFile()
	 * @see #setExistingTopologyFile(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultExistingTopologyFile() {
		return (String) model.getDefaultProperty(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE);
	}

	/**
	 * The purpose of this property is to restrict the preserveLinks property to a specific value and
	 * prevent it from changing. The preserveLinks property will remain set to the value it was set
	 * to when this property is set to true.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newPreserveLinksRestricted
	 *           The new value of the PreserveLinksRestricted property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setPreserveLinksRestricted(Boolean newPreserveLinksRestricted) {
		model.setProperty(IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED,
				newPreserveLinksRestricted);
	}

	/**
	 * The purpose of this property is to restrict the preserveLinks property to a specific value and
	 * prevent it from changing. The preserveLinks property will remain set to the value it was set
	 * to when this property is set to true.
	 * 
	 * @return The value of the PreserveLinksRestricted property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getPreserveLinksRestricted() {
		return (Boolean) model.getProperty(IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED);
	}

	/**
	 * Determine if the PreserveLinksRestricted property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         PreserveLinksRestricted property is valid.
	 * @see #getPreserveLinksRestricted()
	 * @see #setPreserveLinksRestricted(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validatePreserveLinksRestricted() {
		return model.validateProperty(IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED);
	}

	/**
	 * Determine the default value of the PreserveLinksRestricted property.
	 * 
	 * @return The default value of the PreserveLinksRestricted property.
	 * @see #getPreserveLinksRestricted()
	 * @see #setPreserveLinksRestricted(Boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getDefaultPreserveLinksRestricted() {
		return (Boolean) model
				.getDefaultProperty(IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED);
	}

	/**
	 * Used when the destination of this move refactoring is a new topology model.
	 * 
	 * <p>
	 * Return the type-safe model for the nested TopologyCreationDataModel data model.
	 * </p>
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @return The type-safe model for the nested TopologyCreationDataModel data model.
	 * @generated (mde.utilities.datamodels)
	 */
	public CreateTopologyDataModel getTopologyCreationDataModel() {
		if (topologyCreationDataModel == null) {
			if (model.isNestedModel(IMoveUnitsModelProperties.TOPOLOGY_CREATION_DATA_MODEL)) {
				IDataModel nestedModel = model
						.getNestedModel(IMoveUnitsModelProperties.TOPOLOGY_CREATION_DATA_MODEL);
				topologyCreationDataModel = new CreateTopologyDataModel(nestedModel);
			} else {
				topologyCreationDataModel = CreateTopologyDataModel.createModel();
				model.addNestedModel(IMoveUnitsModelProperties.TOPOLOGY_CREATION_DATA_MODEL,
						topologyCreationDataModel.getUnderlyingDataModel());
			}
		}
		return topologyCreationDataModel;

	}

	/**
	 * Determine if the TopologyCreationDataModel property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         TopologyCreationDataModel property is valid.
	 * @see #getTopologyCreationDataModel()
	 * 
	 */
	public IStatus validateTopologyCreationDataModel() {
		if (!getUseExistingTopology()) {
			return getTopologyCreationDataModel().validate();
		}

		return Status.OK_STATUS;

	}

	/**
	 * Determine the default value of the TopologyCreationDataModel property.
	 * 
	 * @return The default value of the TopologyCreationDataModel property.
	 * @see #getTopologyCreationDataModel()
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	protected CreateTopologyDataModel getDefaultTopologyCreationDataModel() {
		return (CreateTopologyDataModel) model
				.getDefaultProperty(IMoveUnitsModelProperties.TOPOLOGY_CREATION_DATA_MODEL);
	}

	/**
	 * Return the value of Units field.
	 * 
	 * @return The value of Units field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Unit[] getUnits() {
		return (Unit[]) model.getProperty(IMoveUnitsModelProperties.UNITS);
	}

	/**
	 * The set of units to be moved.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newUnits
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setUnits(Unit[] newUnits) {
		model.setProperty(IMoveUnitsModelProperties.UNITS, newUnits);
	}

	/**
	 * Determine if the Units property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Units
	 *         property is valid.
	 * @see #getUnits()
	 * @see #setUnits(Unit[])
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateUnits() {
		return model.validateProperty(IMoveUnitsModelProperties.UNITS);

	}

	/**
	 * Determine the default value of the Units property.
	 * 
	 * @return The default value of the Units property.
	 * @see #getUnits()
	 * @see #setUnits(Unit[])
	 * @generated (mde.utilities.datamodels)
	 */
	protected Unit[] getDefaultUnits() {
		return (Unit[]) model.getDefaultProperty(IMoveUnitsModelProperties.UNITS);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		MoveUnitsOperation operation = new MoveUnitsOperation(this);
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

	private ROTopologyModelManager getModelManager() {
		if (modelManager == null) {
			modelManager = ROTopologyModelManager.create();
		}

		return modelManager;
	}

	public Topology getTopology(IPath path) {
		return getTopology(ResourcesPlugin.getWorkspace().getRoot().getFile(path));
	}

	public Topology getTopology(IFile file) {
		return getModelManager().openModel(file, new Listener() {

			public void onUnload(IFile unloadedResource) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void dispose() {
		if (modelManager != null) {
			modelManager.dispose();
			modelManager = null;
		}
	}

	public String getDestinationNamespace() {
		if (model.getBooleanProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY)) {
			return getDestinationTopology().getNamespace();
		}

		return getTopologyCreationDataModel().getNamespacePath();
	}

	public String getDestinationName() {
		if (model.getBooleanProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY)) {
			return getDestinationTopology().getName();
		}

		return getTopologyCreationDataModel().getTopologyName();
	}

	public Topology getDestinationTopology() {
		if (!model.getBooleanProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY)) {
			return null;
		}
		return getModelManager().openModel(getDestinationTopologyFile(), new Listener() {
			public void onUnload(IFile unloadedResource) {
				// TODO Auto-generated method stub
			}
		});
	}

	public IFile getDestinationTopologyFile() {
		if (model.getBooleanProperty(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY)) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path((String) model
							.getProperty(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE)));
		}

		return getTopologyCreationDataModel().getTopologyFile();
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
		return ((Unit[]) model.getProperty(IMoveUnitsModelProperties.UNITS))[0].getTopology();
	}

	public IFile getSourceTopologyFile() {
		return WorkbenchResourceHelper.getFile(((Unit[]) model
				.getProperty(IMoveUnitsModelProperties.UNITS))[0]);
	}

	public String getQualifiedDestinationName() {
		String namespace = getDestinationNamespace() == null ? new String()
				: getDestinationNamespace().trim();
		String name = getDestinationName();

		return (namespace.length() != 0 ? namespace + IConstants.DOT_SEPARATOR : namespace) + name;
	}

	public String getQualifiedSourceName() {
		String namespace = getSourceNamespace() == null ? new String() : getSourceNamespace().trim();
		String name = getSourceName();

		return (namespace.length() != 0 ? namespace + IConstants.DOT_SEPARATOR : namespace) + name;
	}

	public Unit findParentUnit(DeployModelObject dmo) {
		if (CorePackage.eINSTANCE.getUnit().isSuperTypeOf(dmo.eClass())) {
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
}
