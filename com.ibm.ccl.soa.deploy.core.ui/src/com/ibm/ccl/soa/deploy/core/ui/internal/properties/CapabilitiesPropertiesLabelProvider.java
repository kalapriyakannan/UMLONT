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

import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.dialogs.PatternFilter;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * This {@link ILabelProvider} is used to display the icons and labels for Requirements and their
 * children. It can be used with one or four column {@link TreeViewer}s. If four columns are used
 * this label provider will show the linked target with a delete action.
 * 
 * This class must implement {@link ILabelProvider} for the {@link PatternFilter} to work.
 * 
 * @author Ed Snible (based on daberg RequirementsPropertiesLabelProvider)
 * 
 */
public class CapabilitiesPropertiesLabelProvider implements ITableLabelProvider, ILabelProvider {

//	private final Map<EClass, EObjectAdapter> capEObjectAdapterMap = new HashMap<EClass, EObjectAdapter>();
	private boolean isUnitImported = false;

	private final ILabelProvider capColumnLabelProvider = PropertyUtils.getSoaLabelProvider();

	/**
	 * @param isImported
	 */
	public CapabilitiesPropertiesLabelProvider(boolean isImported) {
		isUnitImported = isImported;
	}

	/**
	 * Set the imported unit flag.
	 * 
	 * @param isImported
	 */
	public void setIsUnitImported(boolean isImported) {
		isUnitImported = isImported;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		if (element != null) {
			switch (columnIndex)
			{
			case CapabilitiesListComposite.CAP_COLUMN:
				return capColumnLabelProvider.getImage(element);

			case CapabilitiesListComposite.VISIBILITY_COLUMN:
				if (element instanceof Capability) {
					return getVisibilityImage((Capability) element);
				}

				break;
			}
		}

		return null;
	}

	protected Image getVisibilityImage(Capability cap) {
		if (isUnitImported) {
			//There are only two options if the parent Unit is imported.
			if (cap.isPublicEditable()) {
				//Return public editable image.
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE);
			} else if (cap.isPublic()) {
				//Return public image.
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PUBLIC);
			} else {
				//Return private image.
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PRIVATE);
			}
		} else {
			Topology top = cap.getEditTopology();
			if (top != null) {
				ConfigurationContract contract = top.getConfigurationContract();
				if (contract != null) {
					if (contract.isPublicEditable(cap)) {
						//Return public editable image.
						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE);
					}
					if (contract.isPublic(cap)) {
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

	public String getColumnText(Object element, int columnIndex) {
		if (element != null) {
			switch (columnIndex)
			{
			case CapabilitiesListComposite.CAP_COLUMN:
				return capColumnLabelProvider.getText(element);

			}
		}
		return null;
	}

	public void addListener(ILabelProviderListener listener) {
		//Do nothing at this time.
	}

	public void dispose() {
		//Do nothing at this time.
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		//Do nothing at this time.
	}

	public Image getImage(Object element) {
		return getColumnImage(element, CapabilitiesListComposite.CAP_COLUMN);
	}

	public String getText(Object element) {
		return getColumnText(element, CapabilitiesListComposite.CAP_COLUMN);
	}

}
