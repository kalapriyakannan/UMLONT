/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ui.handlers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthCapabilityComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.CapabilitySyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;

/**
 * UI for {@link Service}.
 * 
 * The purpose is to override the SynthCapabilityComposite to use a Combo box for
 * {@link Service#getProtocol()} and to override the CapabilitySyncHelperModel to populate that
 * combo.
 */
public class ServiceUIHandler extends AbstractCompositeFactory {

	@Override
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return dmo instanceof Service;
	}

	@Override
	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) {
		Capability cap = (Capability) editDmo;

		DmoComposite composite = new ServiceCapabilityComposite(parent, cap, formToolkit);
		formToolkit.adapt(composite);
		return composite;
	}

	private static class ServiceCapabilityComposite extends SynthCapabilityComposite {

		private ServiceCapabilityComposite(Composite parent, Capability cap, FormToolkit formToolkit) {
			super(parent, cap, formToolkit);
		}

		protected DmoSyncHelperModel createDmoSyncHelperModel() {
			return new ServiceSyncHelperModel();
		}

		@Override
		protected DecoratedField createDataEntryField(Composite parent, EAttribute attribute,
				AttributeMetaData amd, Label label) {
			if (attribute == CorePackage.Literals.SERVICE__PROTOCOL) {
				DecoratedField retVal = createComboEntry(parent, attribute, label, SWT.NONE);
				return retVal;
			}

			return super.createDataEntryField(parent, attribute, amd, label);
		}

		private static class ServiceSyncHelperModel extends CapabilitySyncHelperModel {

			private PropertyDescriptor[] understoodProtocols;
			private Service service;

			@Override
			public void setInput(DeployModelObject newService) {
				super.setInput(newService);
				service = (Service) newService;
			}

			@Override
			public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature esf) {
				if (esf == CorePackage.Literals.SERVICE__PROTOCOL) {
					return getProtocolDescriptors();
				}

				return super.getValidPropertyDescriptors(esf);
			}

			@Override
			public PropertyDescriptor getPropertyDescriptor(EStructuralFeature esf) {
				if (esf == CorePackage.Literals.SERVICE__PROTOCOL) {
					return getProtocolPropertyDescriptor();
				}

				return super.getPropertyDescriptor(esf);
			}

			@Override
			protected void doSetProperty(EStructuralFeature esf, Object value) {
				if (esf == CorePackage.Literals.SERVICE__PROTOCOL && value instanceof Integer) {
					setProtocolProperty(value);
					return;
				}

				super.doSetProperty(esf, value);
			}

			private void setProtocolProperty(Object value) {
				Integer integer = (Integer) value;
				PropertyDescriptor pd = getProtocolDescriptors()[integer.intValue()];
				service.setProtocol(pd.getPropertyText());
			}

			private PropertyDescriptor getProtocolPropertyDescriptor() {
				String protocol = service.getProtocol();
				if (protocol == null) {
					// We don't return null; return a catchall instead
					PropertyDescriptor[] pd = getProtocolDescriptors();
					return pd[pd.length - 1];
				}
				for (PropertyDescriptor pd : getProtocolDescriptors()) {
					if (pd.getPropertyText().equals(service.getProtocol())) {
						return pd;
					}
				}
				return super.getPropertyDescriptor(CorePackage.Literals.SERVICE__PROTOCOL);
			}

			/**
			 * This is where we hard-code known protocols
			 * 
			 * @return
			 */
			private PropertyDescriptor[] getProtocolDescriptors() {
				//Populate and cache descriptors
				if (understoodProtocols == null) {
					String[] items = { "http", //$NON-NLS-1$
							"https", //$NON-NLS-1$

							// TODO I don't know if 'other' should be translated.  The real
							// protocols, e.g. http, shouldn't be.  I don't know if we should make
							// this list dynamic and extend it when we notice models with different
							// values created outside the tool.
							"other" //$NON-NLS-1$
					};
					understoodProtocols = new PropertyDescriptor[items.length];
					for (int i = 0; i < items.length; i++) {
						understoodProtocols[i] = new PropertyDescriptor(items[i], i);
					}
				}
				return understoodProtocols;
			}
		} // end private static class ServiceSyncHelperModel

	} // end private static class ServiceCapabilityComposite

} // end class ServiceUIHandler
