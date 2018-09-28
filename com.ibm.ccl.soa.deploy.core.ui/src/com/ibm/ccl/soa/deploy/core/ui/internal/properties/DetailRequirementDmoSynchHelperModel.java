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

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;

/**
 * @author daberg
 * 
 */
public class DetailRequirementDmoSynchHelperModel extends DmoSyncHelperModel {

	private final String emptyString = ""; //$NON-NLS-1$
	private RequirementsPropertiesLabelProvider labelProvider;
	private PropertyDescriptor[] validLinkTypes;

	@Override
	public String getStringProperty(EStructuralFeature property) {
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME == property) {
			return DeployModelObjectUtil.getTitle(dmo);
		}
		if (CorePackage.Literals.DEPLOY_LINK__TARGET_URI == property) {
			return RequirementsPropertiesLabelProvider.getLinkTargetString((Requirement) dmo);
		}
		if (CorePackage.Literals.REQUIREMENT__DMO_TYPE == property) {
			QName qName = (QName) getProperty(property);
			String qualifiedString = getQualifiedName(qName);
			return qualifiedString == null ? Messages.PropertyUtils_none_ : qualifiedString;
		}
		return super.getStringProperty(property);
	}

	private String getQualifiedName(QName qName) {
		if (qName != null) {
			EPackage pack = EPackage.Registry.INSTANCE.getEPackage(qName.getNamespaceURI());
			if (pack != null) {
				return pack.getName() + "." + qName.getLocalPart(); //$NON-NLS-1$
			}
			return qName.getLocalPart();
		}
		return null;
	}

	@Override
	public PropertyDescriptor getPropertyDescriptor(EStructuralFeature property) {
		if (CorePackage.Literals.REQUIREMENT__DMO_TYPE == property) {
			QName qName = (QName) getProperty(property);
			return new PropertyDescriptor(getQualifiedName(qName), qName);
		}
		return super.getPropertyDescriptor(property);
	}

	@Override
	public boolean isPropertyEnabled(EStructuralFeature property) {
		if (isImportedRequirement()) {
			return CorePackage.Literals.DEPLOY_LINK__TARGET_URI == property
					|| CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME == property;
		}
		return super.isPropertyEnabled(property);
	}

	private boolean isImportedRequirement() {
		return dmo != null && dmo.getEditTopology() != dmo.getTopology();
	}

	@Override
	public void dispose() {
		labelProvider = null;
		super.dispose();
	}

	@Override
	public Image getPropertyImage(EStructuralFeature property) {
		String imageKey = null;
		if (CorePackage.Literals.REQUIREMENT__DMO_TYPE == property && labelProvider != null) {
			return labelProvider.getTypeImage((Requirement) dmo);
		} else if (CorePackage.Literals.REQUIREMENT__LINK_TYPE == property) {
			RequirementLinkTypes types = ((Requirement) dmo).getLinkType();
			switch (types.getValue())
			{
			case RequirementLinkTypes.HOSTING:
				imageKey = ISharedImages.IMG_HOSTING_LINK_TYPE;
				break;
			case RequirementLinkTypes.DEPENDENCY:
				imageKey = ISharedImages.IMG_DEPENDENCY_LINK_TYPE;
				break;
			case RequirementLinkTypes.MEMBER:
				imageKey = ISharedImages.IMG_MEMBERSHIP_LINK_TYPE;
				break;
			}
		} else if (CorePackage.Literals.REQUIREMENT__USE == property) {
			RequirementUsage usage = ((Requirement) dmo).getUse();
			switch (usage.getValue())
			{
			case RequirementUsage.REQUIRED:
				imageKey = ISharedImages.IMG_USE_REQUIRED;
				break;
			case RequirementUsage.OPTIONAL:
				imageKey = ISharedImages.IMG_USE_OPTIONAL;
				break;
			case RequirementUsage.PROHIBITED:
				imageKey = ISharedImages.IMG_USE_PROHIBITED;
				break;
			}
		}
		if (imageKey != null) {
			return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(imageKey);
		}
		return super.getPropertyImage(property);
	}

	public void setTypeImageProvider(RequirementsPropertiesLabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	protected ChangeScope<DeployModelObject, IScribblerDomain> getCurrentChangeScope() {
		return scope;
	}

	@Override
	public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature feature) {
		if (CorePackage.Literals.REQUIREMENT__LINK_TYPE == feature) {
			Requirement req = (Requirement) dmo;
			if (validLinkTypes == null) {
				if (req.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL) {
					//Already Hosting type.
					validLinkTypes = new PropertyDescriptor[] {
							createPropertyDescriptor(RequirementLinkTypes.DEPENDENCY_LITERAL),
							createPropertyDescriptor(RequirementLinkTypes.HOSTING_LITERAL),
							createPropertyDescriptor(RequirementLinkTypes.MEMBER_LITERAL) };
				} else {
					//Check for the existence of another hosting requirement.
					if (req.getParent() != null && hasHostingRequirement((Unit) req.getParent())) {
						//Do not include the Hosting option.
						validLinkTypes = new PropertyDescriptor[] {
								createPropertyDescriptor(RequirementLinkTypes.DEPENDENCY_LITERAL),
								createPropertyDescriptor(RequirementLinkTypes.MEMBER_LITERAL) };
					} else {
						validLinkTypes = new PropertyDescriptor[] {
								createPropertyDescriptor(RequirementLinkTypes.DEPENDENCY_LITERAL),
								createPropertyDescriptor(RequirementLinkTypes.HOSTING_LITERAL),
								createPropertyDescriptor(RequirementLinkTypes.MEMBER_LITERAL) };
					}
				}
			}
			return validLinkTypes;
		}
		return super.getValidPropertyDescriptors(feature);
	}

	@Override
	public boolean validPropertyDescriptorsChanged(EStructuralFeature feature) {
		//We must return true if the validLinkTypes is null for the REQUIREMENT__LINK_TYPE.
		if (CorePackage.Literals.REQUIREMENT__LINK_TYPE == feature) {
			return validLinkTypes == null;
		}
		return super.validPropertyDescriptorsChanged(feature);
	}

	private boolean hasHostingRequirement(Unit unit) {
		if (unit == null) {
			return false;
		}
		List<Requirement> reqs = unit.getRequirements();
		for (int i = 0; i < reqs.size(); i++) {
			if (reqs.get(i).getLinkType() == RequirementLinkTypes.HOSTING_LITERAL) {
				return true;
			}
		}
		return false;
	}

	private PropertyDescriptor createPropertyDescriptor(RequirementLinkTypes dependencyLiteral) {
		return new PropertyDescriptor(dependencyLiteral.getName(), dependencyLiteral);
	}

	@Override
	public void setInput(DeployModelObject dmo) {
		//Reset the validLinkTypes when the input changes.
		validLinkTypes = null;
		super.setInput(dmo);
	}
}
