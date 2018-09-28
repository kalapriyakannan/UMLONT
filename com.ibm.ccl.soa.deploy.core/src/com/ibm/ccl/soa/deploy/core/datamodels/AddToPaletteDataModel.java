/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.AddToPaletteDataModelOperation;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.AddToPaletteDataModelProvider;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IAddToPaletteDataModelProperties;

/**
 * 
 * AddToPalette datamodel is used to capture dynamicType.xml information. The datamodel will be used
 * in dialog and creation wizard.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>topology</b>: Topology for topology constraint </li>
 * <li><b>units</b>: Units to be added to the palette </li>
 * <li><b>label</b>: name of palette entry </li>
 * <li><b>description</b>: Description of palette entry </li>
 * <li><b>stack</b>: The Stack property. </li>
 * <li><b>drawer</b>: Position of entry </li>
 * <li><b>icon</b>: Icon for palette entry </li>
 * <li><b>addToPalette</b>: Indication to create a template </li>
 * <li><b>projectName</b>: The ProjectName property. </li>
 * <li><b>topologyVUri</b>: Associated Topologyv file used to copy notational metadata </li>
 * <li><b>captureVisuals</b>: Should capture notational values in topologyV </li>
 * <li><b>enableCaptureVisuals</b>: Should capture notational values in topologyV </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class AddToPaletteDataModel {

	private final IDataModel model;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static AddToPaletteDataModel createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new AddToPaletteDataModel(model);
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
		return new AddToPaletteDataModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public AddToPaletteDataModel(IDataModel mdl) {
		model = mdl;
	}

	/**
	 * name of palette entry
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newLabel
	 *           The new value of the Label property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setLabel(String newLabel) {
		model.setProperty(IAddToPaletteDataModelProperties.LABEL, newLabel);
	}

	/**
	 * name of palette entry
	 * 
	 * @return The value of the Label property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getLabel() {
		return (String) model.getProperty(IAddToPaletteDataModelProperties.LABEL);
	}

	/**
	 * Determine if the Label property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Label
	 *         property is valid.
	 * @see #getLabel()
	 * @see #setLabel(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateLabel() {
		return model.validateProperty(IAddToPaletteDataModelProperties.LABEL);
	}

	/**
	 * Determine the default value of the Label property.
	 * 
	 * @return The default value of the Label property.
	 * @see #getLabel()
	 * @see #setLabel(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultLabel() {
		return (String) model.getDefaultProperty(IAddToPaletteDataModelProperties.LABEL);
	}

	/**
	 * Description of palette entry
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDescription
	 *           The new value of the Description property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDescription(String newDescription) {
		model.setProperty(IAddToPaletteDataModelProperties.DESCRIPTION, newDescription);
	}

	/**
	 * Description of palette entry
	 * 
	 * @return The value of the Description property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDescription() {
		return (String) model.getProperty(IAddToPaletteDataModelProperties.DESCRIPTION);
	}

	/**
	 * Determine if the Description property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Description
	 *         property is valid.
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDescription() {
		return model.validateProperty(IAddToPaletteDataModelProperties.DESCRIPTION);
	}

	/**
	 * Determine the default value of the Description property.
	 * 
	 * @return The default value of the Description property.
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultDescription() {
		return (String) model.getDefaultProperty(IAddToPaletteDataModelProperties.DESCRIPTION);
	}

	/**
	 * The Stack property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newStack
	 *           The new value of the Stack property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setStack(String newStack) {
		model.setProperty(IAddToPaletteDataModelProperties.STACK, newStack);
	}

	/**
	 * The Stack property.
	 * 
	 * @return The value of the Stack property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getStack() {
		return (String) model.getProperty(IAddToPaletteDataModelProperties.STACK);
	}

	/**
	 * Determine if the Stack property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Stack
	 *         property is valid.
	 * @see #getStack()
	 * @see #setStack(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateStack() {
		return model.validateProperty(IAddToPaletteDataModelProperties.STACK);
	}

	/**
	 * Determine the default value of the Stack property.
	 * 
	 * @return The default value of the Stack property.
	 * @see #getStack()
	 * @see #setStack(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultStack() {
		return (String) model.getDefaultProperty(IAddToPaletteDataModelProperties.STACK);
	}

	/**
	 * Position of entry
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDrawer
	 *           The new value of the Drawer property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDrawer(String newDrawer) {
		model.setProperty(IAddToPaletteDataModelProperties.DRAWER, newDrawer);
	}

	/**
	 * Position of entry
	 * 
	 * @return The value of the Drawer property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDrawer() {
		return (String) model.getProperty(IAddToPaletteDataModelProperties.DRAWER);
	}

	/**
	 * Determine if the Drawer property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Drawer
	 *         property is valid.
	 * @see #getDrawer()
	 * @see #setDrawer(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDrawer() {
		return model.validateProperty(IAddToPaletteDataModelProperties.DRAWER);
	}

	/**
	 * Determine the default value of the Drawer property.
	 * 
	 * @return The default value of the Drawer property.
	 * @see #getDrawer()
	 * @see #setDrawer(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultDrawer() {
		return (String) model.getDefaultProperty(IAddToPaletteDataModelProperties.DRAWER);
	}

	/**
	 * Icon for palette entry
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newIcon
	 *           The new value of the Icon property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setIcon(String newIcon) {
		model.setProperty(IAddToPaletteDataModelProperties.ICON, newIcon);
	}

	/**
	 * Icon for palette entry
	 * 
	 * @return The value of the Icon property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getIcon() {
		return (String) model.getProperty(IAddToPaletteDataModelProperties.ICON);
	}

	/**
	 * Determine if the Icon property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Icon
	 *         property is valid.
	 * @see #getIcon()
	 * @see #setIcon(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateIcon() {
		return model.validateProperty(IAddToPaletteDataModelProperties.ICON);
	}

	/**
	 * Determine the default value of the Icon property.
	 * 
	 * @return The default value of the Icon property.
	 * @see #getIcon()
	 * @see #setIcon(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultIcon() {
		return (String) model.getDefaultProperty(IAddToPaletteDataModelProperties.ICON);
	}

	/**
	 * port number is applicable
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newAddToPalette
	 *           The new value of the AddToPalette property.
	 */
	public void setAddToPalette(boolean newAddToPalette) {
		model.setProperty(IAddToPaletteDataModelProperties.ADD_TO_PALETTE, newAddToPalette);
	}

	/**
	 * port number is applicable
	 * 
	 * @return The value of the AddToPalette property.
	 */
	public boolean getAddToPalette() {
		return (Boolean) model.getProperty(IAddToPaletteDataModelProperties.ADD_TO_PALETTE);
	}

	/**
	 * Determine if the AddToPalette property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         AddToPalette property is valid.
	 * @see #getAddToPalette()
	 * @see #setAddToPalette(boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateAddToPalette() {
		return model.validateProperty(IAddToPaletteDataModelProperties.ADD_TO_PALETTE);
	}

	/**
	 * Determine the default value of the AddToPalette property.
	 * 
	 * @return The default value of the AddToPalette property.
	 * @see #getAddToPalette()
	 * @see #setAddToPalette(boolean)
	 */
	public boolean getDefaultAddToPalette() {
		return (Boolean) model.getDefaultProperty(IAddToPaletteDataModelProperties.ADD_TO_PALETTE);
	}

	/**
	 * The ProjectName property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newProjectName
	 *           The new value of the ProjectName property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setProjectName(String newProjectName) {
		model.setProperty(IAddToPaletteDataModelProperties.PROJECT_NAME, newProjectName);
	}

	/**
	 * The ProjectName property.
	 * 
	 * @return The value of the ProjectName property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getProjectName() {
		return (String) model.getProperty(IAddToPaletteDataModelProperties.PROJECT_NAME);
	}

	/**
	 * Determine if the ProjectName property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the ProjectName
	 *         property is valid.
	 * @see #getProjectName()
	 * @see #setProjectName(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateProjectName() {
		return model.validateProperty(IAddToPaletteDataModelProperties.PROJECT_NAME);
	}

	/**
	 * Determine the default value of the ProjectName property.
	 * 
	 * @return The default value of the ProjectName property.
	 * @see #getProjectName()
	 * @see #setProjectName(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultProjectName() {
		return (String) model.getDefaultProperty(IAddToPaletteDataModelProperties.PROJECT_NAME);
	}

	/**
	 * Associated Topologyv file used to copy notational metadata
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newTopologyVUri
	 *           The new value of the TopologyVUri property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setTopologyVUri(String newTopologyVUri) {
		model.setProperty(IAddToPaletteDataModelProperties.TOPOLOGY_V_URI, newTopologyVUri);
	}

	/**
	 * Associated Topologyv file used to copy notational metadata
	 * 
	 * @return The value of the TopologyVUri property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getTopologyVUri() {
		return (String) model.getProperty(IAddToPaletteDataModelProperties.TOPOLOGY_V_URI);
	}

	/**
	 * Determine if the TopologyVUri property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         TopologyVUri property is valid.
	 * @see #getTopologyVUri()
	 * @see #setTopologyVUri(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateTopologyVUri() {
		return model.validateProperty(IAddToPaletteDataModelProperties.TOPOLOGY_V_URI);
	}

	/**
	 * Determine the default value of the TopologyVUri property.
	 * 
	 * @return The default value of the TopologyVUri property.
	 * @see #getTopologyVUri()
	 * @see #setTopologyVUri(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultTopologyVUri() {
		return (String) model.getDefaultProperty(IAddToPaletteDataModelProperties.TOPOLOGY_V_URI);
	}

	/**
	 * Should capture notational values in topologyV
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newCaptureVisuals
	 *           The new value of the CaptureVisuals property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setCaptureVisuals(boolean newCaptureVisuals) {
		model.setProperty(IAddToPaletteDataModelProperties.CAPTURE_VISUALS, newCaptureVisuals);
	}

	/**
	 * Should capture notational values in topologyV
	 * 
	 * @return The value of the CaptureVisuals property.
	 * 
	 */
	public boolean getCaptureVisuals() {
		return (Boolean) model.getProperty(IAddToPaletteDataModelProperties.CAPTURE_VISUALS);
	}

	/**
	 * Determine if the CaptureVisuals property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         CaptureVisuals property is valid.
	 * @see #getCaptureVisuals()
	 * @see #setCaptureVisuals(boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateCaptureVisuals() {
		return model.validateProperty(IAddToPaletteDataModelProperties.CAPTURE_VISUALS);
	}

	/**
	 * Determine the default value of the CaptureVisuals property.
	 * 
	 * @return The default value of the CaptureVisuals property.
	 * @see #getCaptureVisuals()
	 * @see #setCaptureVisuals(boolean)
	 */
	public Boolean getDefaultCaptureVisuals() {
		return (Boolean) model.getDefaultProperty(IAddToPaletteDataModelProperties.CAPTURE_VISUALS);
	}

	/**
	 * Should capture notational values in topologyV
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newEnableCaptureVisuals
	 *           The new value of the EnableCaptureVisuals property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setEnableCaptureVisuals(boolean newEnableCaptureVisuals) {
		model.setProperty(IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS,
				newEnableCaptureVisuals);
	}

	/**
	 * Should capture notational values in topologyV
	 * 
	 * @return The value of the EnableCaptureVisuals property.
	 */
	public Boolean getEnableCaptureVisuals() {
		return (Boolean) model.getProperty(IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS);
	}

	/**
	 * Determine if the EnableCaptureVisuals property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         EnableCaptureVisuals property is valid.
	 * @see #getEnableCaptureVisuals()
	 * @see #setEnableCaptureVisuals(boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateEnableCaptureVisuals() {
		return model.validateProperty(IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS);
	}

	/**
	 * Determine the default value of the EnableCaptureVisuals property.
	 * 
	 * @return The default value of the EnableCaptureVisuals property.
	 * @see #getEnableCaptureVisuals()
	 * @see #setEnableCaptureVisuals(boolean)
	 */
	public Boolean getDefaultEnableCaptureVisuals() {
		return (Boolean) model
				.getDefaultProperty(IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS);
	}

	/**
	 * Return the value of Topology field.
	 * 
	 * @return The value of Topology field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Topology getTopology() {
		return (Topology) model.getProperty(IAddToPaletteDataModelProperties.TOPOLOGY);
	}

	/**
	 * Topology for topology constraint
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newTopology
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setTopology(Topology newTopology) {
		model.setProperty(IAddToPaletteDataModelProperties.TOPOLOGY, newTopology);
	}

	/**
	 * Determine if the Topology property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Topology
	 *         property is valid.
	 * @see #getTopology()
	 * @see #setTopology(Topology)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateTopology() {
		return model.validateProperty(IAddToPaletteDataModelProperties.TOPOLOGY);

	}

	/**
	 * Determine the default value of the Topology property.
	 * 
	 * @return The default value of the Topology property.
	 * @see #getTopology()
	 * @see #setTopology(Topology)
	 * @generated (mde.utilities.datamodels)
	 */
	protected Topology getDefaultTopology() {
		return (Topology) model.getDefaultProperty(IAddToPaletteDataModelProperties.TOPOLOGY);
	}

	/**
	 * Return the value of Units field.
	 * 
	 * @return The value of Units field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Unit[] getUnits() {
		return (Unit[]) model.getProperty(IAddToPaletteDataModelProperties.UNITS);
	}

	/**
	 * Units to be added to the palette
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
		model.setProperty(IAddToPaletteDataModelProperties.UNITS, newUnits);
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
		return model.validateProperty(IAddToPaletteDataModelProperties.UNITS);

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
		return (Unit[]) model.getDefaultProperty(IAddToPaletteDataModelProperties.UNITS);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		AddToPaletteDataModelOperation operation = new AddToPaletteDataModelOperation(this);
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
	 * 
	 * @return a String that combines the drawer and stack into a single path string.
	 */
	public String getPath() {
		String drawer = getDrawer();
		String stack = null;
		if (model.isPropertySet(IAddToPaletteDataModelProperties.STACK)) {
			stack = getStack();
		}
		if (stack != null && stack.length() > 0) {
			return drawer + stack;
		}
		return drawer;
	}

}
