/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel}. The provider is required
 * by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel
 * @generated (mde.utilities.datamodels)
 */
public class AddToPaletteDataModelProvider extends AbstractDataModelProvider

implements IAddToPaletteDataModelProperties {

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#LABEL
	 */
	public IStatus validateLabel() {
		String labelProperty = (String) model.getProperty(IAddToPaletteDataModelProperties.LABEL);
		if (labelProperty == null || labelProperty.length() < 1) {
			return DeployCorePlugin
					.createErrorStatus(
							0,
							DeployCoreMessages.AddToPaletteDataModelProvider_The_template_name_can_not_be_empty_,
							null);
		}
		// Ensure the name does not contain invalid characters.
		if (!isValidName(labelProperty)) {
			return DeployCorePlugin
					.createErrorStatus(
							0,
							DeployCoreMessages.AddToPaletteDataModelProvider_The_template_name_contains_an_inval_,
							null);
		}

		if (labelProperty == null || labelProperty == getDefaultLabel()) {
			return DeployCorePlugin.createErrorStatus(0,
					DeployCoreMessages.AddToPaletteDataModelProvider_Please_enter_a_Palette_entry_name_,
					null);
		}
		return checkForDuplicate(labelProperty);

	}

	public IStatus checkForDuplicate(String labelProperty) {
		LinkedList idsInUse = new LinkedList<String>();
		DynamicPaletteEntry adpe[] = getDynamicPaletteEntries();
		for (int i = 0; i < adpe.length; i++) {
			idsInUse.add(adpe[i].getId());
		}
		if (idsInUse.contains(labelProperty)) {
			return DeployCorePlugin
					.createErrorStatus(
							0,
							DeployCoreMessages.AddToPaletteDataModelProvider_Palette_entry_name_is_already_in_us_,
							null);
		}

		return Status.OK_STATUS;
	}

	/**
	 * @return palette entries known to Resource Type Service
	 */
	private DynamicPaletteEntry[] getDynamicPaletteEntries() {
		return ExtensionsCore.createResourceTypeService().getDynamicPaletteEntries();
	}

	/**
	 * 
	 * @return The default value of the Label property.
	 * @see IAddToPaletteDataModelProperties#LABEL
	 * @see AddToPaletteDataModel#getLabel()
	 */
	protected String getDefaultLabel() {
		Topology topology = (Topology) getProperty(TOPOLOGY);
		if (topology != null) {
			return createUniqueName(topology);
		}
		return ""; //$NON-NLS-1$ 
	}

	public String createUniqueName(Topology topology) {
		String topologyName = topology.getName();
		if (topologyName.indexOf(PALATTE_ENTRY) == -1) {
			topologyName = topologyName + UNDERSCORE + PALATTE_ENTRY;
		} else {
			if (topologyName.indexOf(PALATTE_ENTRY + UNDERSCORE) > -1) {
				topologyName = topologyName.substring(0, (topologyName.length() - 2));
			}
		}
		int x = 1;
		while (checkForDuplicate(topologyName).getSeverity() != IStatus.OK) {
			topologyName = topologyName + UNDERSCORE + x++;
		}
		return topologyName;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#DESCRIPTIONi
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDescription() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IAddToPaletteDataModelProperties.DESCRIPTION) instanceof String);
		//String descriptionProperty = (String)  model.getProperty(IAddToPaletteDataModelProperties.DESCRIPTION);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Description property.
	 * @see IAddToPaletteDataModelProperties#DESCRIPTION
	 * @see AddToPaletteDataModel#getDescription()
	 */
	protected String getDefaultDescription() {
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
		Calendar now = Calendar.getInstance();
		return NLS.bind(DeployCoreMessages.AddToPaletteDataModelProvider_Template_created_on_0_,
				formatter.format(now.getTime()));
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#STACK
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateStack() {
		// TODO Remove the @generated tag above and validate the property.

		Assert.isTrue(model.getProperty(IAddToPaletteDataModelProperties.STACK) instanceof String);
		//String stackProperty = (String)  model.getProperty(IAddToPaletteDataModelProperties.STACK);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Stack property.
	 * @see IAddToPaletteDataModelProperties#STACK
	 * @see AddToPaletteDataModel#getStack()
	 * @generated (mde.utilities.datamodels) NOT
	 */
	protected String getDefaultStack() {
		return "newStack"; //$NON-NLS-1$ 
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#DRAWER
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDrawer() {
		// TODO Remove the @generated tag above and validate the property.

		Assert.isTrue(model.getProperty(IAddToPaletteDataModelProperties.DRAWER) instanceof String);
		//String drawerProperty = (String)  model.getProperty(IAddToPaletteDataModelProperties.DRAWER);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Drawer property.
	 * @see IAddToPaletteDataModelProperties#DRAWER
	 * @see AddToPaletteDataModel#getDrawer()
	 */
	protected String getDefaultDrawer() {
		return getDrawerId();
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#ICON
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateIcon() {
		// TODO Remove the @generated tag above and validate the property.

		Assert.isTrue(model.getProperty(IAddToPaletteDataModelProperties.ICON) instanceof String);
		//String iconProperty = (String)  model.getProperty(IAddToPaletteDataModelProperties.ICON);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the Icon property.
	 * @see IAddToPaletteDataModelProperties#ICON
	 * @see AddToPaletteDataModel#getIcon()
	 */
	protected String getDefaultIcon() {
		return "platform:///plugin/com.ibm.ccl.soa.deploy.generic.ui/icons/pal/unit_24.gif"; //$NON-NLS-1$
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#ADD_TO_PALETTE
	 */
	public IStatus validateAddToPalette() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IAddToPaletteDataModelProperties.ADD_TO_PALETTE) instanceof Boolean);
		//boolean addToPaletteProperty = (boolean)  model.getProperty(IAddToPaletteDataModelProperties.ADD_TO_PALETTE);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the AddToPalette property.
	 * @see IAddToPaletteDataModelProperties#ADD_TO_PALETTE
	 * @see AddToPaletteDataModel#getAddToPalette()
	 */
	protected boolean getDefaultAddToPalette() {
		return false;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#PROJECT_NAME
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateProjectName() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IAddToPaletteDataModelProperties.PROJECT_NAME) instanceof String);
		//String projectNameProperty = (String)  model.getProperty(IAddToPaletteDataModelProperties.PROJECT_NAME);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the ProjectName property.
	 * @see IAddToPaletteDataModelProperties#PROJECT_NAME
	 * @see AddToPaletteDataModel#getProjectName()
	 * @generated (mde.utilities.datamodels)
	 */
	protected String getDefaultProjectName() {
		return "null"; //$NON-NLS-1$ 
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#TOPOLOGY_V_URI
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateTopologyVUri() {
		// TODO Remove the @generated tag above and validate the property.

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the TopologyVUri property.
	 * @see IAddToPaletteDataModelProperties#TOPOLOGY_V_URI
	 * @see AddToPaletteDataModel#getTopologyVUri()
	 */
	protected String getDefaultTopologyVUri() {
		return null;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#CAPTURE_VISUALS
	 * 
	 */
	public IStatus validateCaptureVisuals() {

		Assert
				.isTrue(model.getProperty(IAddToPaletteDataModelProperties.CAPTURE_VISUALS) instanceof Boolean);
		//boolean captureVisualsProperty = (boolean)  model.getProperty(IAddToPaletteDataModelProperties.CAPTURE_VISUALS);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the CaptureVisuals property.
	 * @see IAddToPaletteDataModelProperties#CAPTURE_VISUALS
	 * @see AddToPaletteDataModel#getCaptureVisuals()
	 * 
	 */
	protected Boolean getDefaultCaptureVisuals() {
		return true;
	}

	/**
	 * 
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#ENABLE_CAPTURE_VISUALS
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateEnableCaptureVisuals() {
		// TODO Remove the @generated tag above and validate the property.

		Assert
				.isTrue(model.getProperty(IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS) instanceof Boolean);
		//boolean enableCaptureVisualsProperty = (boolean)  model.getProperty(IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS);		

		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return The default value of the EnableCaptureVisuals property.
	 * @see IAddToPaletteDataModelProperties#ENABLE_CAPTURE_VISUALS
	 * @see AddToPaletteDataModel#getEnableCaptureVisuals()
	 * @generated (mde.utilities.datamodels)
	 */
	protected Boolean getDefaultEnableCaptureVisuals() {
		return false;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#TOPOLOGY
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateTopology() {
		//Topology topologyProperty = (Topology)  model.getProperty(IAddToPaletteDataModelProperties.TOPOLOGY);

		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IAddToPaletteDataModelProperties#TOPOLOGY
	 * @generated (mde.utilities.datamodels)
	 */
	protected Topology getDefaultTopology() {
		// TODO Return the default value of the Topology property.
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IAddToPaletteDataModelProperties#UNITS
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateUnits() {
		// TODO Remove the @generated tag above and validate the property. 
		//Assert.isTrue(model.getProperty(IAddToPaletteDataModelProperties.UNITS) instanceof Unit[]);

		//Unit[] unitsProperty = (Unit[])  model.getProperty(IAddToPaletteDataModelProperties.UNITS);

		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see IAddToPaletteDataModelProperties#UNITS
	 * @generated (mde.utilities.datamodels)
	 */
	protected Unit[] getDefaultUnits() {
		// TODO Return the default value of the Units property.
		return new Unit[0];
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (IAddToPaletteDataModelProperties.PROJECT_NAME.equals(property)) {
			return validateProjectName();
		} else if (IAddToPaletteDataModelProperties.LABEL.equals(property)) {
			return validateLabel();
		} else if (IAddToPaletteDataModelProperties.ICON.equals(property)) {
			return validateIcon();
		} else if (IAddToPaletteDataModelProperties.DRAWER.equals(property)) {
			return validateDrawer();
		} else if (IAddToPaletteDataModelProperties.CAPTURE_VISUALS.equals(property)) {
			return validateCaptureVisuals();
		} else if (IAddToPaletteDataModelProperties.TOPOLOGY_V_URI.equals(property)) {
			return validateTopologyVUri();
		} else if (IAddToPaletteDataModelProperties.ADD_TO_PALETTE.equals(property)) {
			return validateAddToPalette();
		} else if (IAddToPaletteDataModelProperties.STACK.equals(property)) {
			return validateStack();
		} else if (IAddToPaletteDataModelProperties.DESCRIPTION.equals(property)) {
			return validateDescription();
		} else if (IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS.equals(property)) {
			return validateEnableCaptureVisuals();
		} else if (IAddToPaletteDataModelProperties.TOPOLOGY.equals(property)) {
			return validateTopology();
		} else if (IAddToPaletteDataModelProperties.UNITS.equals(property)) {
			return validateUnits();
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
		if (IAddToPaletteDataModelProperties.PROJECT_NAME.equals(property)) {
			return getDefaultProjectName();
		} else if (IAddToPaletteDataModelProperties.LABEL.equals(property)) {
			return getDefaultLabel();
		} else if (IAddToPaletteDataModelProperties.ICON.equals(property)) {
			return getDefaultIcon();
		} else if (IAddToPaletteDataModelProperties.DRAWER.equals(property)) {
			return getDefaultDrawer();
		} else if (IAddToPaletteDataModelProperties.CAPTURE_VISUALS.equals(property)) {
			return getDefaultCaptureVisuals();
		} else if (IAddToPaletteDataModelProperties.TOPOLOGY_V_URI.equals(property)) {
			return getDefaultTopologyVUri();
		} else if (IAddToPaletteDataModelProperties.ADD_TO_PALETTE.equals(property)) {
			return getDefaultAddToPalette();
		} else if (IAddToPaletteDataModelProperties.STACK.equals(property)) {
			return getDefaultStack();
		} else if (IAddToPaletteDataModelProperties.DESCRIPTION.equals(property)) {
			return getDefaultDescription();
		} else if (IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS.equals(property)) {
			return getDefaultEnableCaptureVisuals();
		} else if (IAddToPaletteDataModelProperties.TOPOLOGY.equals(property)) {
			return getDefaultTopology();
		} else if (IAddToPaletteDataModelProperties.UNITS.equals(property)) {
			return getDefaultUnits();
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
	 */
	public boolean propertySet(String propertyName, Object propertyValue) {
		if (STACK.equals(propertyName)) {
			if (propertyValue == NONE) {
				propertyValue = getDrawerId();
			} else {
				propertyValue = getDrawerId() + propertyValue;
			}
		}
		return super.propertySet(propertyName, propertyValue);
	}

	private String getDrawerId() {
		return EXTENSION_DRAWER;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IAddToPaletteDataModelProperties.PROJECT_NAME);
		propertyNames.add(IAddToPaletteDataModelProperties.LABEL);
		propertyNames.add(IAddToPaletteDataModelProperties.ICON);
		propertyNames.add(IAddToPaletteDataModelProperties.DRAWER);
		propertyNames.add(IAddToPaletteDataModelProperties.CAPTURE_VISUALS);
		propertyNames.add(IAddToPaletteDataModelProperties.TOPOLOGY_V_URI);
		propertyNames.add(IAddToPaletteDataModelProperties.ADD_TO_PALETTE);
		propertyNames.add(IAddToPaletteDataModelProperties.STACK);
		propertyNames.add(IAddToPaletteDataModelProperties.DESCRIPTION);
		propertyNames.add(IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS);
		propertyNames.add(IAddToPaletteDataModelProperties.TOPOLOGY);
		propertyNames.add(IAddToPaletteDataModelProperties.UNITS);
		propertyNames.add(IAddToPaletteDataModelProperties.DATAMODEL);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new AddToPaletteDataModelOperation(model);
	}

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

}
