/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
/**
 * 
 */
package com.ibm.ccl.soa.deploy.internal.core.ui.validator.resolution;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.ui.services.properties.PropertiesServiceAdapterFactory;
import org.eclipse.gmf.runtime.common.ui.services.properties.descriptors.ICompositeSourcePropertyDescriptor;
import org.eclipse.gmf.runtime.emf.ui.properties.descriptors.EMFCompositeSourcePropertyDescriptor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.PasswordDialog;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.DeployResolutionParameterizer;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployParameterizedResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameterizer;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;

/**
 * @author Alexander V. Konstantinou (avk@us.ibm.com)
 */
public class SetAttributeResolutionParameterizer extends DeployResolutionParameterizer implements
		IDeployResolutionParameterizer {

	private IPropertyDescriptor ipd;

	private final static IPropertySourceProvider ipsp = new PropertiesServiceAdapterFactory();

	/*
	 * @seecom.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameterizer#
	 * setParameters
	 * (com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployParameterizedResolution)
	 */
	public IStatus setParameters(IDeployParameterizedResolution resolution) {
		List<IDataModel> params = resolution.getParameters();
		if (params.size() != 1) {
			return Status.CANCEL_STATUS;
		}
		if (!(params.get(0) instanceof IDataModel)) {
			return Status.CANCEL_STATUS;
		}
		final IDataModel param = params.get(0);
		final ResolutionAttributeDataModel resolutionAttributeDataModel = new ResolutionAttributeDataModel(
				param);
		IDeployResolutionContext context = resolution.getDeployResolutionContext();
		DeployModelObject offendingDmo = context.getDeployStatus().getDeployObject();
		IDeployAttributeStatus idas = (IDeployAttributeStatus) context.getDeployStatus();
		EStructuralFeature offendingEsf = idas.getAttributeType();
		ExtendedAttribute ea = null;

		IPropertySource ips = ipsp.getPropertySource(offendingDmo);
		if (ips == null) {
			ips = new GuiPropertySetResolutionGenerator.MyCapSource(offendingDmo);
			// return false;
		}

		IPropertyDescriptor[] aipd = ips.getPropertyDescriptors();
		for (int i = 0; i < aipd.length; i++) {
			if (aipd[i] instanceof EMFCompositeSourcePropertyDescriptor) {
				EMFCompositeSourcePropertyDescriptor emfDescr = (EMFCompositeSourcePropertyDescriptor) aipd[i];
				if (emfDescr.getFeature() == offendingEsf) {
					ipd = emfDescr;
					break;
				}
			} else if (aipd[i] instanceof GuiPropertySetResolutionGenerator.MyPropertyDescriptor) {
				EStructuralFeature feature = ((GuiPropertySetResolutionGenerator.MyPropertyDescriptor) aipd[i])
						.getFeature();
				if (feature == offendingEsf) {
					ipd = aipd[i];
					break;
				}
//			} else if (aipd[i] instanceof ExtendedAttributePropertyDescriptor) {
//				ea = ((ExtendedAttributePropertyDescriptor) aipd[i]).getExtendedAttribute();
//				if (null == ea) {
//					continue;
//				}
//				String attributeName = ea.getName();
//				if (null == attributeName || 0 == attributeName.length()) {
//					continue;
//				}
//				if (idas.getAttributeName().equals(attributeName)) {
//					ipd = aipd[i];
//					break;
//				}
			}
		}

		if (ipd == null) {
			return Status.CANCEL_STATUS;
		}

		if (ipd instanceof ICompositeSourcePropertyDescriptor) {
			ICompositeSourcePropertyDescriptor icspd = (ICompositeSourcePropertyDescriptor) ipd;
			if (icspd.isReadOnly()) {
				return Status.CANCEL_STATUS;
			}
		}

		if (isPassword(offendingDmo, idas.getAttributeName())) {
			PasswordDialog pd = new PasswordDialog(new Shell(), ipd.getDisplayName()/*
																											 * offendingEsf.getName
																											 * ()
																											 */);
			if (pd.open() == Window.OK) {
				resolutionAttributeDataModel.getResolutionDataModel().setValue(pd.getValue());
				return Status.OK_STATUS;
			}
			return Status.CANCEL_STATUS;
		}

		Shell parentShell = Display.getDefault().getActiveShell();
		// Non-password
		Object expectedValue = idas instanceof IDeployAttributeValueStatus ? ((IDeployAttributeValueStatus) idas)
				.getAttributeExpectedValue()
				: null;
		Dialog dlg = new GuiPropertySetResolutionGenerator.GuiPropertySetDialog(parentShell, ipd,
				offendingDmo, offendingEsf, ea, expectedValue) {

			@Override
			protected void doApplyValue(Object newValue) {
				resolutionAttributeDataModel.getResolutionDataModel().setValue(newValue);
			}
		};
		int dlgStatusCode;
		try {
			dlg.create();
			dlgStatusCode = dlg.open();
		} catch (Exception ex) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex.getLocalizedMessage(), ex);
		}
		if (dlgStatusCode == Window.CANCEL) {
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	// MK 7/19/2007: modified isPassword to use attribute name instead of EStructuralFeature 
	// allowing it to work for both {@link EAttriubte} and for {@link ExtextendAttribute}
	// also made it a private method since it is only called locally
	private boolean isPassword(DeployModelObject dmo, String attributeName) {
		if (dmo == null || attributeName == null) {
			return false;
		}

		AttributeMetaData md = dmo.getAttributeMetaData(attributeName);
		if (md != null) {
			return md.isEncrypted();
		}

		return false;
	}
}
