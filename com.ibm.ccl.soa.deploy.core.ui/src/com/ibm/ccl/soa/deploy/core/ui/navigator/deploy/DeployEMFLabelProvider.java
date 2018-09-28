/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.ui.navigator.INavigatorSaveablesService;
import org.eclipse.wst.common.internal.emfworkbench.integration.DynamicAdapterFactory;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnsetInterface;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveable;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;

/**
 * LabelProvider for {@link DeployModelObject}s, {@link TopologyDiagramNode}s, and
 * {@link LoadingModelNode}s.
 */
public class DeployEMFLabelProvider implements ICommonLabelProvider {

	private AdapterFactoryLabelProvider delegateLabelProvider;
	private INavigatorSaveablesService service = null;

	/**
	 * 
	 */
	public DeployEMFLabelProvider() {
		// default the delegate
//		delegateLabelProvider = new AdapterFactoryLabelProvider(new DynamicAdapterFactory(null));
		delegateLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry()));
	}

	public void init(ICommonContentExtensionSite aConfig) {
		initialize(aConfig.getExtensionStateModel().getViewerId());
		service = aConfig.getService().getSaveablesService();
	}

	public Image getImage(Object element) {
		if (element instanceof Unit) {
			Image icon = IconService.getInstance().getIcon(new EObjectAdapter((Unit) element));
			if (icon == null) {
				return delegateLabelProvider.getImage(element);
			}
		}

		if (element instanceof DeployModelObject) {
			Image icon = IconService.getInstance().getIcon(
					new EObjectAdapter((DeployModelObject) element));
			if (icon != null) {
				return icon;
			}
		}

		if (element instanceof TopologyDiagramNode) {
			return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_TOPOLOGY_DIAGRAM_NODE);
		}
		if (element instanceof IProject) {
			return null;
		}
		if (element instanceof IFile) {
			return null;
		}

		// LOADING_EXAMPLE The LoadingModelNode must be consulted for its image 
		if (element instanceof LoadingModelNode) {
			return ((LoadingModelNode) element).getImage();
		}

		if (delegateLabelProvider != null) {
			return delegateLabelProvider.getImage(element);
		}

		return null;
	}

	/**
	 * @param element
	 * @return
	 */
	public String getText(Object element) {

		if (element instanceof Unit) {
//			return ((Unit) element).getCaptionProvider().title((Unit) element);
			return DeployModelObjectUtil.getTitle((DeployModelObject) element);
			// NOTE: Before 5/27 Units on property pages used getCaptionProvider().titleWithContext(unit);
		}

		if (element instanceof Constraint) {
			Constraint constraint = (Constraint) element;
			return ConstraintService.INSTANCE.title(constraint);
		}

		if (element instanceof DeployModelObject) {
//			return ((DeployModelObject) element).getDisplayName();
			return DeployModelObjectUtil.getTitle((DeployModelObject) element);
		}

		if (element instanceof TopologyDiagramNode) {
			String label = ((TopologyDiagramNode) element).getText();
			if (isDirty(((TopologyDiagramNode) element).getDiagramFile())) {
				label += "*"; //$NON-NLS-1$
			}
			return label;
		}

		if (element instanceof IProject) {
			return null;
		}
		if (element instanceof IFile) {
			return null;
		}
		//	LOADING_EXAMPLE The LoadingModelNode must be consulted for its text 
		if (element instanceof LoadingModelNode) {
			return ((LoadingModelNode) element).getText();
		}

		if (element instanceof Interface) {
			Interface interfaze = (Interface) element;
			AbstractInterfaceHandler handler = DeployCoreUIPlugin.getDefault()
					.getInterfaceHandlerService().findInterfaceHandlerForInterface(interfaze);
			String iname = DeployNLS.bind(Messages.NubEditDialog_Interface_0_, handler
					.getInterfacePropertyLabel(interfaze));
			return iname;
		}

		if (element instanceof ShortConstraintDescriptor) {
			ShortConstraintDescriptor descr = (ShortConstraintDescriptor) element;
			return descr.getTitle();
		}

		if (element instanceof UnsetInterface) {
			return com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPropertiesLabelProvider_Set_Interface_;
		}

		if (delegateLabelProvider != null) {
			return delegateLabelProvider.getText(element);
		}

		return null;
	}

	/**
	 * @param listener
	 */
	public void addListener(ILabelProviderListener listener) {
		if (delegateLabelProvider != null) {
			delegateLabelProvider.addListener(listener);
		}
	}

	/**
	 * 
	 */
	public void dispose() {
		if (delegateLabelProvider != null) {
			delegateLabelProvider.dispose();
		}
	}

	/**
	 * @param object
	 * @param id
	 * @return
	 */
	public boolean isLabelProperty(Object object, String id) {
		if (delegateLabelProvider != null) {
			return delegateLabelProvider.isLabelProperty(object, id);
		}
		return false;
	}

	/**
	 * @param listener
	 */
	public void removeListener(ILabelProviderListener listener) {
		if (delegateLabelProvider != null) {
			delegateLabelProvider.removeListener(listener);
		}
	}

	public void restoreState(IMemento aMemento) {
		// TODO Auto-generated method stub

	}

	public void saveState(IMemento aMemento) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.wst.common.navigator.internal.views.extensions.ICommonLabelProvider#getDescription
	 * (java.lang.Object)
	 */
	public String getDescription(Object anElement) {
		return getText(anElement);
	}

	/**
	 * 
	 */
	public void fireLabelProviderChanged() {
		if (delegateLabelProvider != null) {
			delegateLabelProvider.fireLabelProviderChanged();
		}
	}

	/**
	 * @return
	 */
	public AdapterFactory getAdapterFactory() {
		if (delegateLabelProvider != null) {
			return delegateLabelProvider.getAdapterFactory();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (delegateLabelProvider != null) {
			return delegateLabelProvider.hashCode();
		}
		return super.hashCode();
	}

	/**
	 * @param notification
	 */
	public void notifyChanged(Notification notification) {
		if (delegateLabelProvider != null) {
			delegateLabelProvider.notifyChanged(notification);
		}
	}

	/**
	 * @param adapterFactory
	 */
	public void setAdapterFactory(AdapterFactory adapterFactory) {
		if (delegateLabelProvider != null) {
			delegateLabelProvider.setAdapterFactory(adapterFactory);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (delegateLabelProvider != null) {
			return delegateLabelProvider.toString();
		}
		return super.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (delegateLabelProvider != null) {
			return delegateLabelProvider.equals(obj);
		}
		return false;
	}

	private void initialize(String aViewerId) {
		// use the viewid to customize the delegate
		delegateLabelProvider = new AdapterFactoryLabelProvider(new DynamicAdapterFactory(aViewerId));
	}

	private boolean isDirty(IFile file) {
		if (service != null) {
			Saveable[] saveables = service.getSaveables();
			for (int s = 0; s < saveables.length; s++) {
				if (saveables[s] instanceof TopologySaveable) {
					TopologySaveable saveable = (TopologySaveable) saveables[s];
					if (saveable.isManaged(file)) {
						////file - NM: 5064
						//If just the diagram is changed the notification is only on the Topology File and the savable
						//needs to determine the model and the diagrams being dirty
						return saveable.isDirty();
					}
				}
			}
		}

		return false;
	}
}
