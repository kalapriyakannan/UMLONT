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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.ui.navigator.INavigatorSaveablesService;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveable;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

public class NamespaceElementLabelProvider extends LabelProvider implements ICommonLabelProvider {

	private static final String TOPOLOGY_NAMESPACE_EMPTY_ICO = "icons/full/obj16/TopologyNamespace_empty.gif"; //$NON-NLS-1$

	private static final String TOPOLOGY_NAMESPACE_FULL_ICO = "icons/full/obj16/TopologyNamespace.gif"; //$NON-NLS-1$

	private static final String TOPOLOGY_NAMESPACE_ROOT_ICO = "icons/full/obj16/TopologyNamespaceRoot.gif"; //$NON-NLS-1$

	private static final String TOPOLOGY_CLOSED_ICO = "icons/full/obj16/closed_topology_obj.gif"; //$NON-NLS-1$

	private ILabelProvider decoratingLabelProvider = null;

	private INavigatorSaveablesService service = null;

	private final ROTopologyModelManager.Listener modelListener = new ROTopologyModelManager.Listener() {
		public void onUnload(IFile unloadedResource) {
			if (unloadedResource.getProject().isAccessible()) {
				//Do something here
			}
//				refreshJob.enqueue(unloadedResource);
		}
	};

	public NamespaceElementLabelProvider() {
		super();
	}

	public Image getImage(Object element) {
		if (element instanceof INamespaceElement) {
			INamespaceElement tElement = (INamespaceElement) element;
			switch (tElement.getType())
			{
			case INamespaceElement.TOPOLOGY_NAMESPACE:
				INamespaceFragment ns = (INamespaceFragment) tElement;
				if (ns.getRoot().getCorrespondingResource(ns).getProject().isAccessible()) {
					if (ns.containsTopologies()) {
						return getImage(TOPOLOGY_NAMESPACE_FULL_ICO);
					}
					return getImage(TOPOLOGY_NAMESPACE_EMPTY_ICO);
				}
				break;
			case INamespaceElement.TOPOLOGY_NAMESPACE_ROOT:
				return getImage(TOPOLOGY_NAMESPACE_ROOT_ICO);
			}
		}
		if (element instanceof IFile) {
			IFile topFile = (IFile) element;
			if (topFile.getProject().isAccessible()) {
				if (IConstants.TOPOLOGY_EXTENSION.equals(topFile.getFileExtension())) {

					// if topology is not open for write access
					if (!isOpen(topFile)) {
						return getImage(TOPOLOGY_CLOSED_ICO);
					}

					Topology top = getTopology(topFile);
					// if the topology can't be opened it has no icon
					if (top == null) {
						return null;
					}

					//Return image based on semantic 
					IDecoratorSemanticService dsService = ExtensionsCore
							.createDecoratorSemanticService();
					String imgPath = dsService.getDecoratorSemanticIcon(top.getDecoratorSemantic());
					if (imgPath != null && imgPath.trim().length() != 0) {
						return getImage(imgPath);
					}
				}

				if (IConstants.TOPOLOGYV_EXTENSION.equals(topFile.getFileExtension())) {
					if (!isOpen(topFile)) {
						return getImage(TOPOLOGY_CLOSED_ICO);
					}
				}
			}
		}

		return getDecoratingLabelProvider().getImage(element);
	}

	public String getText(Object element) {
		if (element instanceof INamespaceFragmentRoot) {
			return ((INamespaceFragmentRoot) element).getName();
		}
		if (element instanceof INamespaceElement) {
			return ((INamespaceElement) element).getQualifiedName();
		}

		if (element instanceof IFile) {
			IFile file = (IFile) element;
			if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())
					|| IConstants.TOPOLOGYV_EXTENSION.equals(file.getFileExtension())) {
				if (isDirty(file)) {
					return getDecoratingLabelProvider().getText(element) + "*"; //$NON-NLS-1$
				}
			}
		}

		return getDecoratingLabelProvider().getText(element);
	}

	public Image getImage(String name) {
		return DeployCoreUIPlugin.getDefault().getSharedImages().getImageFromPath(name);
	}

	public void restoreState(IMemento aMemento) {
	}

	public void saveState(IMemento aMemento) {
	}

	public String getDescription(Object anElement) {
		return getText(anElement);
	}

	public void init(ICommonContentExtensionSite aConfig) {
		service = aConfig.getService().getSaveablesService();
	}

	private ILabelProvider getDecoratingLabelProvider() {
		if (decoratingLabelProvider == null) {
			decoratingLabelProvider = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
		}
		return decoratingLabelProvider;
	}

	public void dispose() {
		super.dispose();
		if (decoratingLabelProvider != null) {
			decoratingLabelProvider.dispose();
		}
		decoratingLabelProvider = null;
	}

	private boolean isOpen(IFile file) {
		if (service != null) {
			Saveable[] saveables = service.getSaveables();
			for (int s = 0; s < saveables.length; s++) {
				if (saveables[s] instanceof TopologySaveable) {
					TopologySaveable saveable = (TopologySaveable) saveables[s];
					if (saveable.isManaged(file)) {
						return saveable.isOpen();
					}
				}
			}
		}

		return false;
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

	private boolean isOpenInEditor(IFile file) {
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for (int w = 0; w < windows.length; w++) {
			IWorkbenchWindow window = windows[w];
			IWorkbenchPage[] pages = window.getPages();
			for (int p = 0; p < pages.length; p++) {
				IWorkbenchPage page = pages[p];
				IEditorReference[] references = page.findEditors(null,
						"DeployCoreEditor", IWorkbenchPage.MATCH_ID); //$NON-NLS-1$
				for (int r = 0; r < references.length; r++) {
					IEditorReference reference = references[r];
					if (reference.getEditor(false) instanceof DeployCoreEditor) {
						DeployCoreEditor editor = (DeployCoreEditor) reference.getEditor(false);
						Saveable[] saveables = editor.getSaveables();
						for (int s = 0; s < saveables.length; s++) {
							if (saveables[s] instanceof TopologySaveable) {
								TopologySaveable saveable = (TopologySaveable) saveables[s];
								if (saveable.isManaged(file)) {
									return true;
								}
							}
						}
					}
				}
			}
		}

		return false;
	}

	private Topology getTopology(IFile file) {
		Topology topology = null;
		if (service != null) {
			Saveable[] saveables = service.getSaveables();
			for (int s = 0; s < saveables.length; s++) {
				if (saveables[s] instanceof TopologySaveable) {
					TopologySaveable saveable = (TopologySaveable) saveables[s];
					if (saveable.isManaged(file)) {
						if (saveable.isOpen()) {
							IEditModelScribbler scribbler = saveable.getScribbler();
							if (null != scribbler && !scribbler.isClosed()) {
								Resource resource = scribbler.getResource(file);
								if (null != resource) {
									if (null != resource.getContents() && resource.getContents().size() > 0) {
										DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
										if (null != root) {
											topology = root.getTopology();
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return topology;
	}
}
