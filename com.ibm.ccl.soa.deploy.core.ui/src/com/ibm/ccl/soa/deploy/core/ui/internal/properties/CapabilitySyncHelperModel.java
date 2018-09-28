/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import java.util.List;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.operation.UpdateContractOperation;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthCapabilityComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;

/** Get image information for combo setting */
public class CapabilitySyncHelperModel extends DmoSyncHelperModel {
	private static final String CLEAR = ""; //$NON-NLS-1$
	private static final PropertyDescriptor CLEAR_DESCRIPTOR = new PropertyDescriptor(CLEAR, null);
	private boolean isImport = false;

	@Override
	public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature esf) {
		if (esf == SynthCapabilityComposite.fakeAttributeForCapContract) {
			return getContractDescriptors();
		}
		if (EcorePackage.Literals.EENUM.isInstance(esf.getEType())) {
			return getValidPropertyDescriptors((EEnum) esf.getEType());
		}

		return super.getValidPropertyDescriptors(esf);
	}

	private PropertyDescriptor[] getValidPropertyDescriptors(EEnum enum1) {
		boolean isLinkType = CorePackage.Literals.CAPABILITY_LINK_TYPES == enum1;
		List<EEnumLiteral> literals = enum1.getELiterals();
		int size = isLinkType ? literals.size() : literals.size() + 1;
		PropertyDescriptor[] retval = new PropertyDescriptor[size];
		int retValIndex = isLinkType ? 0 : 1;
		if (!isLinkType) {
			retval[0] = CLEAR_DESCRIPTOR;
		}
		for (int i = 0; i < literals.size(); i++) {
			EEnumLiteral temp = literals.get(i);
			retval[i + retValIndex] = createPropertyDescriptor(temp);
		}
		return retval;
	}

	@Override
	public boolean isPropertyEnabled(EStructuralFeature esf) {
		if (isImport) {
			//Do not allow the contract and link type to be changed.
			if (esf == SynthCapabilityComposite.fakeAttributeForCapContract
					|| CorePackage.Literals.CAPABILITY__LINK_TYPE == esf) {
				return false;
			}
			//Only if the property is editable should it be enabled.
			return dmo.isPublicEditable(esf.getName());
		}
//		if (esf == SynthCapabilityComposite.fakeAttributeForCapContract) {
		// We only want to enable setting a unit's "contract" if the topology
		// has an ExplicitContract
//			return !isImport
//					&& dmo.getTopology().getConfigurationContract() instanceof ExplicitContract;
//		}
		return super.isPropertyEnabled(esf);
	}

	//		@Override
	//		public Object getProperty(EStructuralFeature esf) {
	//			if (esf == CatchallCapabilityComposite.fakeAttributeForCapContract) {
	//				System.out.println("getProperty for contract"); //$NON-NLS-1$
	//				return null;
	//			}
	//			
	//			return super.getProperty(esf);
	//		}

	@Override
	public PropertyDescriptor getPropertyDescriptor(EStructuralFeature esf) {
		if (esf == SynthCapabilityComposite.fakeAttributeForCapContract) {
			return getContractPropertyDescriptor();
		}

		return super.getPropertyDescriptor(esf);
	}

	@Override
	public Object getProperty(EStructuralFeature feature) {
		if (feature.isMany() || dmo.eIsSet(feature)) {
			return dmo.eGet(feature);
		}
		return null;
	}

	@Override
	protected void doSetProperty(EStructuralFeature esf, Object value) {
		if (esf == SynthCapabilityComposite.fakeAttributeForCapContract && value instanceof Integer) {
			updateContract(((Integer) value).intValue());
			return;
		}

		super.doSetProperty(esf, value);
	}

	public Image getPropertyImage(EStructuralFeature esf) {
		if (esf == CorePackage.Literals.CAPABILITY__LINK_TYPE) {
			CapabilityLinkTypes type = ((Capability) dmo).getLinkType();
			return getImage(type);
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY.equals(esf)) {
			if (isImport) {
				if (dmo.isPublicEditable()) {
					//Return public editable image.
					return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
							ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE);
				} else if (dmo.isPublic()) {
					//Return public image.
					return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
							ISharedImages.IMG_CONTRACT_PUBLIC);
				} else {
					//Return private image.
					return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
							ISharedImages.IMG_CONTRACT_PRIVATE);
				}
			} else {
				//Image for contract state
				Topology top = dmo.getEditTopology();
				if (top != null) {
					ConfigurationContract contract = top.getConfigurationContract();
					if (contract != null) {
						if (contract.isPublicEditable(dmo)) {
							//Return public editable image.
							return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
									ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE);
						}
						if (contract.isPublic(dmo)) {
							//Return public image.
							return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
									ISharedImages.IMG_CONTRACT_PUBLIC);
						}
						//Return private image.
						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_CONTRACT_PRIVATE);
					}
				}
			}
		}

		return super.getPropertyImage(esf);
	}

	private Image getImage(CapabilityLinkTypes type) {
		String imageKey = null;

		if (type == CapabilityLinkTypes.DEPENDENCY_LITERAL) {
			imageKey = ISharedImages.IMG_DEPENDENCY_LINK_TYPE;
		} else if (type == CapabilityLinkTypes.HOSTING_LITERAL) {
			imageKey = ISharedImages.IMG_HOSTING_LINK_TYPE;
		}

		// TODO We need an 'any' link type icon

		if (imageKey != null) {
			return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(imageKey);
		}

		return null;
	}

	private PropertyDescriptor getContractPropertyDescriptor() {
		if (isImport) {
			if (dmo.isPublicEditable()) {
				return getContractDescriptors()[UpdateContractOperation.PUBLIC_EDITABLE_FLAG];
			} else if (dmo.isPublic()) {
				return getContractDescriptors()[UpdateContractOperation.PUBLIC_FLAG];
			} else {
				return getContractDescriptors()[UpdateContractOperation.PRIVATE_FLAG];
			}
		} else {
			ConfigurationContract contract = dmo.getTopology().getConfigurationContract();
			if (contract == null) {
				return getContractDescriptors()[UpdateContractOperation.PRIVATE_FLAG];
			} else if (contract.isPublicEditable(dmo)) {
				return getContractDescriptors()[UpdateContractOperation.PUBLIC_EDITABLE_FLAG];
			} else if (contract.isPublic(dmo)) {
				return getContractDescriptors()[UpdateContractOperation.PUBLIC_FLAG];
			} else {
				return getContractDescriptors()[UpdateContractOperation.PRIVATE_FLAG];
			}
		}
	}

	@Override
	public void setInput(DeployModelObject newDMO) {
		if (newDMO != null && newDMO != dmo) {
			calculateImportedFlag(newDMO);
		}
		super.setInput(newDMO);
	}

	private void calculateImportedFlag(DeployModelObject newDMO) {
		Topology top = newDMO.getTopology();
		Topology editTop = newDMO.getEditTopology();
		isImport = editTop != top;
	}

} // end static inner class CapabilitySynchHelperModel
