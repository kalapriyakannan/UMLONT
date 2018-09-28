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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementsPropertiesContentProvider.RequirementGroup;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;

/**
 * This {@link ILabelProvider} is used to display the icons and labels for Requirements and their
 * children. It can be used with one or four column {@link TreeViewer}s. If four columns are used
 * this label provider will show the linked target with a delete action.
 * 
 * @author daberg
 * 
 */
public class RequirementsPropertiesLabelProvider implements ITableLabelProvider,
		ITableColorProvider, ITableFontProvider, ILabelProvider {

	private static final String FIND_HOST_TXT = Messages.RequirementsPropertiesLabelProvider_No_host_;//"[Find Host]";
	private static final String FIND_TARGET_TXT = Messages.RequirementsPropertiesLabelProvider_No_target_;//"[Find Target]";
	private Map<EClass, EObjectAdapter> requirementEObjectAdapterMap = new HashMap<EClass, EObjectAdapter>();
	private Color blueColor;
	private boolean isUnitImported = false;

	/**
	 * Default constructor.
	 * 
	 * @param isUnitImported
	 */
	public RequirementsPropertiesLabelProvider(boolean isUnitImported) {
		this.isUnitImported = isUnitImported;
	}

	/**
	 * Set the imported unit flag.
	 * 
	 * @param isUnitImported
	 */
	public void setIsUnitImported(boolean isUnitImported) {
		this.isUnitImported = isUnitImported;
	}

	protected static IStatus getHostingStatus(Unit unit) {
		// Is there a Unit error?
		if (unit != null) {
			if (!unit.getStatus().isOK()) {
				// Is it a hosting error?
				for (Iterator it = new StatusIterator(unit.getStatus()); it.hasNext();) {
					Object obj = it.next();
					if (obj instanceof DeployStatus) {
						DeployStatus das = (DeployStatus) obj;
						if (ICoreProblemType.UNIT_NOT_HOSTED.equals(das.getProblemType())) {
							// Yes, hosting error
							return das;
						}
					}
				}
			}
		}
		return null;
	}

	/*
	 * TODO Adjust the images when we have something.
	 * 
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		if (element != null) {
			switch (columnIndex)
			{
			case RequirementsListComposite.REQ_COLUMN:
				if (element instanceof Requirement) {
					return getRequirementIcon((Requirement) element);
				}
				if (element instanceof Interface) {
					return getInterfaceIcon((Interface) element);
				}

				if (element instanceof RequirementGroup) {
//					if (((RequirementGroup) element).isHosting()) {
//						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
//								ISharedImages.IMG_HOSTING);
//					} else 
					if (((RequirementGroup) element).isMember()) {
						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_MEMBERSHIP_LINK_TYPE);
					}
				}
				if (element instanceof Interface) {
					return getInterfaceIcon((Interface) element);
				}
				break;
			case RequirementsListComposite.VISIBILITY_COLUMN:
				if (element instanceof Requirement) {
					return getVisibilityImage((Requirement) element);
				}
				break;
			case RequirementsListComposite.TARGET_COLUMN:
				if (element instanceof Requirement) {
					RequirementLinkTypes linkType = ((Requirement) element).getLinkType();
					if (/*
							 * linkType != RequirementLinkTypes.HOSTING_LITERAL &&
							 */linkType != RequirementLinkTypes.MEMBER_LITERAL) {
						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_LINK_ARROW);
					}
				} /*
					 * else if (element instanceof RequirementGroup && ((RequirementGroup)
					 * element).isHosting()) { return
					 * DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					 * ISharedImages.IMG_LINK_ARROW); }
					 */
				break;
			}
		}
		return null;
	}

	protected Image getVisibilityImage(Requirement requirement) {
		if (isUnitImported) {
			//There are only two options if the parent Unit is imported.
			if (requirement.isPublicEditable()) {
				//Return public editable image.
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE);
			} else if (requirement.isPublic()) {
				//Return public image.
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PUBLIC);
			} else {
				//Return private image.
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PRIVATE);
			}
		} else {
			Topology top = requirement.getEditTopology();
			if (top != null) {
				ConfigurationContract contract = top.getConfigurationContract();
				if (contract != null) {
					if (contract.isPublicEditable(requirement)) {
						//Return public editable image.
						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE);
					}
					if (contract.isPublic(requirement)) {
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
		return null;
	}

	private Image getInterfaceIcon(Interface element) {
		/*
		 * The handler should be able to return an image.
		 */
//		IInterfaceHandlerService interfaceService = DeployCoreUIPlugin.getDefault().getInterfaceHandlerService();
//		AbstractInterfaceHandler handler = interfaceService.findInterfaceHandlerForInterface(element);
//		if (handler != null) {
//			return handler.getInterfacePropertyImage(element);
//		}
		return null;
	}

	private Image getRequirementIcon(Requirement element) {
		//First report any status icons.
		if (element.getStatus().getSeverity() != IStatus.OK) {
			return PropertyUtils.getStatusTableImage(element.getStatus());
		}
		if (element.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL) {
			IStatus status = getHostingStatus((Unit) element.getParent());
			if (status != null && !status.isOK()) {
				return PropertyUtils.getStatusTableImage(status);
			}
			return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_HOSTING);
		}
		return getTypeImage(element);
	}

	/**
	 * @param requirement
	 *           A {@link Requirement}.
	 * @return An {@link Image} for the type of the {@link Requirement}.
	 */
	public Image getTypeImage(Requirement requirement) {
		Image image = null;
		EClass dmoType = requirement.getDmoEType();
		if (dmoType != null) {
			EObjectAdapter adapter = getEObjectAdapter(dmoType);
			if (adapter != null) {
				image = IconService.getInstance().getIcon(adapter,
						IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
			}
		} else {
			return null;
		}
		if (image == null) {
			image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_DEPENDENT_REQ);
		}
		return image;
	}

	/*
	 * This is a hack but due to limitations in GMF there is nothing else we can do.
	 */
	private EObjectAdapter getEObjectAdapter(EClass requirementDmoType) {
		if (requirementDmoType.isAbstract()) {
			return null;
		}
		EObjectAdapter adapter = requirementEObjectAdapterMap.get(requirementDmoType);
		if (adapter == null) {
			adapter = new EObjectAdapter(requirementDmoType.getEPackage().getEFactoryInstance()
					.create(requirementDmoType));
			requirementEObjectAdapterMap.put(requirementDmoType, adapter);
		}
		return adapter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		if (element != null) {
			switch (columnIndex)
			{
			case RequirementsListComposite.REQ_COLUMN:
				if (element instanceof Requirement) {
					return getRequirementLabel((Requirement) element);
				}
				if (element instanceof RequirementGroup) {
//					if (((RequirementGroup) element).isHosting()) {
//						return com.ibm.ccl.soa.deploy.core.ui.properties.Messages.ConfigurationsPropertySection2_Hostin_;
//					} else if (((RequirementGroup) element).isMember()) {
					return Messages.NewRequirementDialog_Membe_;
//					}
				}
				if (element instanceof Interface) {
					return getInterfaceLabel((Interface) element);
				}
				if (element instanceof UnsetInterface) {
					return Messages.RequirementsPropertiesLabelProvider_Set_Interface_;
				}
				break;
			case RequirementsListComposite.TARGET_COLUMN:
				if (element instanceof Requirement
				//&& ((Requirement) element).getLinkType() != RequirementLinkTypes.HOSTING_LITERAL
						&& ((Requirement) element).getLinkType() != RequirementLinkTypes.MEMBER_LITERAL) {
					return getLinkTargetString((Requirement) element);
				}
//				if (element instanceof RequirementGroup && ((RequirementGroup) element).isHosting()) {
//					return getLinkTargetLabel((RequirementGroup) element);
//				}
				return ""; //$NON-NLS-1$
			}
		}
		return null;
	}

	private String getInterfaceLabel(Interface element) {
		IInterfaceHandlerService interfaceService = DeployCoreUIPlugin.getDefault()
				.getInterfaceHandlerService();
		AbstractInterfaceHandler handler = interfaceService.findInterfaceHandlerForInterface(element);
		if (handler != null) {
			return handler.getInterfacePropertyLabel(element);
		}
		return null;
	}

	/**
	 * Compute the link target string.
	 * 
	 * @param aRequirement
	 *           A {@link Requirement} used to get it's linked target.
	 * @return A {@link String} for the link target.
	 */
	public static String getLinkTargetString(Requirement aRequirement) {
		if (aRequirement.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL) {
			//TODO DCB - This is not safe but what else should we use?
			Unit owningUnit = (Unit) aRequirement.getParent();
			Unit host = ValidatorUtils.getHost(owningUnit);
			return host != null ? DeployModelObjectUtil.getTitle(host) : FIND_HOST_TXT;
		}
		DependencyLink link = aRequirement.getLink();
		DeployModelObject target = null;
		if (link != null) {
			target = link.getTarget();
			if (target != null) {
				return calculateReadablePath(target);
			}
			//What do we return if the Capability is null??
			return link.getTargetURI();
		}
		return FIND_TARGET_TXT;
	}

	private static String calculateReadablePath(DeployModelObject dmo) {
		if (dmo instanceof Capability) {
			return ((Capability) dmo).getCaptionProvider().titleWithContext(((Capability) dmo));
		}
		return DeployModelObjectUtil.getTitle(dmo);
	}

	private String getRequirementLabel(Requirement element) {
		return DeployModelObjectUtil.getTitle(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		//Do nothing at this time.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		requirementEObjectAdapterMap.clear();
		requirementEObjectAdapterMap = null;
		blueColor = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
	 *      java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		//Do nothing at this time.
	}

	public Color getBackground(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getForeground(Object element, int columnIndex) {
//		switch (columnIndex) {
//		case RequirementsListComposite.REQ_COLUMN:
//			if (element instanceof UnsetInterface || element instanceof Interface) {
//				return getBlueColor();
//			}
//			break;
//		case RequirementsListComposite.TARGET_COLUMN:
//			if ((element instanceof Requirement && ((Requirement)element).getLinkType() != RequirementLinkTypes.HOSTING_LITERAL) ||
//					(element instanceof RequirementGroup && ((RequirementGroup) element).isHosting())) {
//				return getBlueColor();
//			}
//		}
		return null;
	}

	private Color getBlueColor() {
		if (blueColor == null) {
			blueColor = PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_BLUE);
		}
		return blueColor;
	}

	public Font getFont(Object element, int columnIndex) {
//		switch (columnIndex) {
//		case 0:
//			if (element instanceof UnsetInterface) {
//				return JFaceResources.getFontRegistry().getBold(
//						JFaceResources.DIALOG_FONT);
//			}
//			break;
//		case 2:
//			if ((element instanceof Requirement && ((Requirement)element).getLinkType() != RequirementLinkTypes.HOSTING_LITERAL) ||
//					element instanceof HostingGroup) {
//				return JFaceResources.getFontRegistry().getBold(
//						JFaceResources.DIALOG_FONT);
//			}
//		}
		return null;
	}

	public Image getImage(Object element) {
		return getColumnImage(element, 0);
	}

	public String getText(Object element) {
		return getColumnText(element, 0);
	}
}
