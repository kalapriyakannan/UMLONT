/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.handlers;

import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthDmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.validator.constraints.communication.ApplicationCommunicationProtocolConstraintMappingService;

/**
 * UI for {@link Service}.
 * 
 * The purpose is to override the SynthCapabilityComposite to use a Combo box for
 * {@link ApplicationCommunicationProtocolConstraint#getApplicationLayerProtocol()} and to override
 * the CapabilitySyncHelperModel to populate that combo.
 */
public class ApplicationCommunicationProtocolConstraintUIHandler extends AbstractCompositeFactory {

	@Override
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return ConstraintPackage.Literals.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT
				.isSuperTypeOf(dmo.getEObject().eClass());
//		return dmo instanceof ApplicationCommunicationProtocolConstraint;
	}

	@Override
	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) {
		ApplicationCommunicationProtocolConstraint acpc = (ApplicationCommunicationProtocolConstraint) editDmo;

		DmoComposite composite = new ApplicationCommunicationProtocolConstraintComposite(parent,
				acpc, formToolkit);
		formToolkit.adapt(composite);
		return composite;
	}

	private static class ApplicationCommunicationProtocolConstraintComposite extends
			SynthDmoComposite {

		private ApplicationCommunicationProtocolConstraintComposite(Composite parent,
				ApplicationCommunicationProtocolConstraint acpc, FormToolkit formToolkit) {
			super(parent, acpc, formToolkit);
		}

		protected DmoSyncHelperModel createDmoSyncHelperModel() {
			return new ApplicationCommunicationProtocolConstraintSyncHelperModel();
		}

		@Override
		protected DecoratedField createDataEntryField(Composite parent, EAttribute attribute,
				AttributeMetaData amd, Label label) {
			if (attribute == ConstraintPackage.Literals.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL) {
				DecoratedField retVal = createComboEntry(parent, attribute, label, SWT.NONE);
				return retVal;
			}

			return super.createDataEntryField(parent, attribute, amd, label);
		}

		private static class ApplicationCommunicationProtocolConstraintSyncHelperModel extends
				DmoSyncHelperModel {

			private PropertyDescriptor[] understoodProtocols;
			private ApplicationCommunicationProtocolConstraint acpc;

			@Override
			public void setInput(DeployModelObject constraint) {
				super.setInput(constraint);
				acpc = (ApplicationCommunicationProtocolConstraint) constraint;
			}

			@Override
			public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature esf) {
				if (esf == ConstraintPackage.Literals.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL) {
					return getProtocolDescriptors();
				}

				return super.getValidPropertyDescriptors(esf);
			}

			@Override
			public PropertyDescriptor getPropertyDescriptor(EStructuralFeature esf) {
				if (esf == ConstraintPackage.Literals.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL) {
					return getProtocolPropertyDescriptor();
				}

				return super.getPropertyDescriptor(esf);
			}

			@Override
			protected void doSetProperty(EStructuralFeature esf, Object value) {
				if (esf == ConstraintPackage.Literals.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL
						&& value instanceof Integer) {
					setProtocolProperty(value);
					return;
				}

				super.doSetProperty(esf, value);
			}

			private void setProtocolProperty(Object value) {
				Integer integer = (Integer) value;
				PropertyDescriptor pd = getProtocolDescriptors()[integer.intValue()];
				acpc.setApplicationLayerProtocol(pd.getPropertyText());
			}

			private PropertyDescriptor getProtocolPropertyDescriptor() {
				String protocol = acpc.getApplicationLayerProtocol();
				if (protocol == null) {
					// We don't return null; return a catchall instead
					PropertyDescriptor[] pd = getProtocolDescriptors();
					return pd[pd.length - 1];
				}
				for (PropertyDescriptor pd : getProtocolDescriptors()) {
					if (pd.getPropertyText().equals(acpc.getApplicationLayerProtocol())) {
						return pd;
					}
				}
				return super
						.getPropertyDescriptor(ConstraintPackage.Literals.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL);
			}

			/**
			 * This is where we hard-code known protocols
			 * 
			 * @return
			 */
			private PropertyDescriptor[] getProtocolDescriptors() {
				//Populate and cache descriptors
				if (understoodProtocols == null) {
					Set<String> registeredProtocols = ApplicationCommunicationProtocolConstraintMappingService.INSTANCE
							.getKnownProtocols();
					understoodProtocols = new PropertyDescriptor[registeredProtocols.size() + 1];
//					String [] items = new String[registeredProtocols.size()+1];
					int idx = 0;
					for (String protocol : registeredProtocols) {
						understoodProtocols[idx] = new PropertyDescriptor(protocol, idx++);
//						items[idx++] = protocol;
					}
					// TODO I don't know if 'other' should be translated.  The real
					// protocols, e.g. http, shouldn't be.  I don't know if we should make
					// this list dynamic and extend it when we notice models with different
					// values created outside the tool.
					understoodProtocols[idx] = new PropertyDescriptor("other", idx); //$NON-NLS-1$
//					items[idx] = "other"; //$NON-NLS-1$					

//					understoodProtocols = new PropertyDescriptor[items.length];
//					for (int i = 0; i < items.length; i++) {
//						understoodProtocols[i] = new PropertyDescriptor(items[i], i);
//					}
				}
				return understoodProtocols;
			}
		} // end private static class ApplicationCommunicationProtocolConstraintSyncHelperModel

	} // end private static class ApplicationCommunicationProtocolConstraintComposite

} // end class ApplicationCommunicationProtocolConstraintUIHandler
