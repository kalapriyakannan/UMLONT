/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.editor.EditorService;
import org.eclipse.gmf.runtime.common.ui.util.OverlayImageDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.TreeDiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.TreeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.properties.views.PropertiesBrowserPage;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.palette.PaletteContent;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteViewerEx;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISaveablesSource;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.DeployActionIds;
import com.ibm.ccl.soa.deploy.core.ui.actions.DeployDeleteAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.EditDynamicPaletteEntryAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.FilterPreferenceMenuManager;
import com.ibm.ccl.soa.deploy.core.ui.actions.RemoveDynamicPaletteEntryAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.RenameDynamicPaletteEntryAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.ShowRelatedAction;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromNotationalCommand;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromSemanticCommand;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CapabilitiesPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.DiagramUpdateData;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.DiagramUpdateDialog;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployConnectionLayerEx;
import com.ibm.ccl.soa.deploy.core.ui.internal.DeployPalettePopulator;
import com.ibm.ccl.soa.deploy.core.ui.internal.UIDeployOperationExecutor;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.DeployDropTargetListener;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.DeployViewerDropAdapter;
import com.ibm.ccl.soa.deploy.core.ui.perspective.DeployCorePerspectiveFactory;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveable;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ConsolidationLinkUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;
import com.ibm.ccl.soa.deploy.internal.core.extension.DecoratorSemanticListener;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidatorJob;
import com.ibm.ccl.soa.deploy.internal.core.validator.TopologyValidationMonitor;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.xtools.common.ui.reduction.viewpoints.IViewpointListener;
import com.ibm.xtools.common.ui.reduction.viewpoints.IViewpointManager;
import com.ibm.xtools.common.ui.reduction.viewpoints.ViewpointEvent;

/**
 * @author jswanke
 * 
 * Topology Editor.s
 */
/**
 * @since 1.0
 * 
 */
public class DeployCoreEditor extends DiagramEditorWithFlyOutPalette implements
		ISetSelectionTarget, IGotoMarker, DecoratorSemanticListener, ISaveablesSource,
		IEditingDomainProvider {

	private static final Class<IEditingDomainProvider> IEDITING_DOMAIN_PROVIDER_CLASS = IEditingDomainProvider.class;

	private static final Class<IPropertySheetPage> IPROPERTY_SHEET_PAGE_CLASS = IPropertySheetPage.class;

	protected final static String XML_SOURCE_EDITOR_ID = "org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart"; //$NON-NLS-1$

	protected final static String TEXT_EDITOR_ID = "org.eclipse.ui.DefaultTextEditor";//$NON-NLS-1$

	private final IViewpointManager manager = IViewpointManager.INSTANCE;

	private final IViewpointListener viewPointListener = new IViewpointListener() {

		public void viewpointChanged(ViewpointEvent event) {
			if (event.getEventType() == ViewpointEvent.VIEWPOINT_CHANGED
					|| event.getEventType() == ViewpointEvent.ENABLE_VIEWPOINT_CHANGED) {
				PaletteRoot root = getEditDomain().getPaletteViewer().getPaletteRoot();
				createPaletteRoot(root);
			}

		}
	};

	protected static class DeleteExtendedToolMenuItemMenuListener implements IMenuListener {

		private PaletteViewer owner;

		public void install(PaletteViewer newOwner) {

			if (owner != newOwner) {
				if (owner != null && owner.getContextMenu() != null) {
					owner.getContextMenu().removeMenuListener(this);
				}
				owner = newOwner;

				if (owner != null && owner.getContextMenu() != null) {
					owner.getContextMenu().addMenuListener(this);
				}
			}
		}

		public void uninstall() {
			install(null);
		}

		public void menuAboutToShow(IMenuManager manager) {

			if (owner != null) {
				// We don't want to merely use pv.getActiveTool(), because the user
				// may right click over a different unit than was previously left-clicked.
				ToolEntry pte = null; // pv.getActiveTool();

				// It isn't sufficient to pick the first selected palette entry edit part.
				// We need the first *visible* one. 
				for (EditPart ep : (List<EditPart>) owner.getSelectedEditParts()) {
					if (ep instanceof AbstractGraphicalEditPart) {
						AbstractGraphicalEditPart agep = (AbstractGraphicalEditPart) ep;
						if (agep.getFigure().isVisible()) {
							if (agep.getModel() instanceof ToolEntry) {
								pte = (ToolEntry) agep.getModel();
								break;
							}
						}
					}
				}

				if (pte != null && isDynamicPaletteEntry(pte.getId())) {
					manager.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS,
							new RemoveDynamicPaletteEntryAction(pte.getId()));
					manager.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS,
							new EditDynamicPaletteEntryAction(pte.getId()));
					manager.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS,
							new RenameDynamicPaletteEntryAction(pte.getId(), pte.getLabel()));
				}
			}
		}

		private boolean isDynamicPaletteEntry(String id) {
			//			System.out.println("palette entry id = " + id); //$NON-NLS-1$
			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			return rts.isDynamicPaletteEntry(id);
		}

	} // end static inner class DeleteExtendedToolMenuItemMenuListener

	/**
	 * @deprecated use {@link DeployValidatorService#getDefaultValidatorService()}.
	 */
	public static final String VALIDATOR_SERVICE = "DeployCoreEditor.ValidatorService"; //$NON-NLS-1$

	private static final String[] DEFAULT_EXTS = new String[] { IConstants.TOPOLOGYV_EXTENSION,
			IConstants.TOPOLOGY_EXTENSION };

	/**
	 * Returns the default validator service shared by editor instances.
	 * 
	 * @return the shared editor validator service.
	 */
	public synchronized static DeployValidatorService getDefaultDeployValidatorService() {
		return DeployValidatorService.getDefaultValidatorService();
	}

	/**
	 * 
	 * @param deployModelObjects
	 * @param sourceDiagram --
	 *           diagram from which unit arrangement will come
	 */
	public static void visualize(List<DeployModelObject> deployModelObjects) {
		Object part = ResourceUtils.getActiveEditorPart();
		if (part instanceof DeployCoreEditor) {
			DeployCoreEditor dce = (DeployCoreEditor) part;
			final DiagramCommandStack cmdStack = dce.getDiagramEditPart().getDiagramEditDomain()
					.getDiagramCommandStack();
			final VisualizeFromSemanticCommand visualizeCmd = new VisualizeFromSemanticCommand(dce
					.getEditingDomain(), dce.getDiagramEditPart(), deployModelObjects, null, null);
			if (visualizeCmd.canExecute()) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						cmdStack.execute(new ICommandProxy(visualizeCmd));
					}
				});
			}
		}
	}

	// Based on jswanke's NubEditPopUpCommand.estimate()
	private static Point estimate(IGraphicalEditPart editPart /* , int which */) {
		IFigure figure = editPart.getFigure();

		org.eclipse.draw2d.geometry.Point pt = figure.getBounds().getTopLeft().getCopy();
		figure.translateToAbsolute(pt);
		org.eclipse.swt.graphics.Point p = new org.eclipse.swt.graphics.Point(0, 0);
		p = editPart.getViewer().getControl().toDisplay(p);
		pt.x += p.x;
		pt.y += p.y;
		return new Point(pt.x, pt.y);
	}

	protected final TopologyArtifactsMonitor monitor;

	private DeployValidatorService deployValidatorService = null;

	private DeployConnectionLayerEx connectionLayer = null;

	private final List<DiagramUpdateData> _initialViewChanges = new ArrayList<DiagramUpdateData>();

	private final DiagramSaveablesProvider saveablesProvider;

	private final Object lock = new Object();

	private TopologySaveable saveable;

	private IJobChangeListener validationListener;

	private boolean isNewTopology = false; // if new topology

	private IDecoratorSemanticService dsService;

	private VisualizeFileEditorInput _visualizeInput = null;

	private boolean initialized = false;
	private boolean disposed = false;

	private final Object editorLock = new Object();

	private final DeployPalettePopulator palettePopulator;

	private final DeleteExtendedToolMenuItemMenuListener dynamicEntryMenuManager = new DeleteExtendedToolMenuItemMenuListener();

	/**
	 * 
	 * 
	 */
	public DeployCoreEditor() {
		super();
		monitor = TopologyArtifactsMonitor.INSTANCE;
		saveablesProvider = new DiagramSaveablesProvider(this);
		monitor.addListener(saveablesProvider);
		manager.addViewpointListener(viewPointListener);
		palettePopulator = new DeployPalettePopulator(getEditDomain(), manager);
	}

	public TopologySaveable getSaveable() {
		return saveable;
	}

	public void createPartControl(Composite parent) {
		if (initialized) {
			super.createPartControl(parent);
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
					IDeployHelpContextIds.TOPOLOGY_EDITOR_GENERAL);
		}

	}

	protected Object getDefaultPaletteContent() {
		Diagram diagram = getDiagram();
		PaletteContent defPaletteContent = null;
		if (diagram != null) {
			IResource workspaceRes = WorkbenchResourceHelper.getFile(diagram);
			IProject resourceProject = workspaceRes != null ? workspaceRes.getProject() : null;
			defPaletteContent = new PaletteContent(resourceProject, diagram);
		}
		return defPaletteContent;
	}

	public void decoratorSemanticChanged() {
		DeployCoreUIPlugin.runWithProgress(new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException,
					InterruptedException {
				//NM: need to rebuild the palette again. Ideally, we should not remove the palette entry in decorator semantic filtering
				// but rather we should make invisible. In that case we will not need to rebuild the palette
				PaletteService.getInstance().updatePalette(
						getEditDomain().getPaletteViewer().getPaletteRoot(), getDeployCoreEditor(),
						getDefaultPaletteContent());
				palettePopulator.paletteRegistryChanged();
				setEditorImage();
			}
		}, false);
	}

	/*
	 * @see com.ibm.ccl.soa.infrastructure.ui.SOACommonDiagramEditor#dispose()
	 */
	public void dispose() {

		synchronized (editorLock) {

			if (!disposed) {
				disposed = true;

				palettePopulator.dispose();
				manager.removeViewpointListener(viewPointListener);
				getDsService().removeDecoratorSemanticChangeListener(this);

				Diagram diagram = getDiagram();
				if (diagram != null) {
					EObject eobject = (EObject) getDiagram().eGet(
							NotationPackage.Literals.VIEW__ELEMENT, false);
					if (eobject != null && eobject instanceof Topology) {
						Topology topology = (Topology) eobject;
						DeployValidatorService validator = getDeployValidatorService();
						TopologyValidationMonitor.unmonitor(topology, validator);
					}
					unwatchValidationJobs();
				}

				monitor.removeListener(saveablesProvider);
				if (saveable != null) {
					SafeRunner.run(new DeployCoreSafeRunnable() {

						public void run() throws Exception {
							saveable.close(false, new NullProgressMonitor());
						}
					});
					saveable = null;
				}

				dynamicEntryMenuManager.uninstall();

				if (diagram != null) {
					super.dispose();
				}
			}
		}
	}

	public Saveable[] getActiveSaveables() {
		return getSaveables();
	}

	public Object getAdapter(Class type) {
		if (type == IPROPERTY_SHEET_PAGE_CLASS) {
			return new PropertiesBrowserPage(this);
		}
		if (type == IEDITING_DOMAIN_PROVIDER_CLASS) {
			return this;
		}
		return super.getAdapter(type);
	}

	public DeployConnectionLayerEx getConnectionLayer() {
		return connectionLayer;
	}

	// override RMP/GMF properties
	public String getContributorId() {
		return "com.ibm.ccl.soa.deploy.core.ui.properties"; //$NON-NLS-1$
	}

	/**
	 * @return DeployValidatorService
	 */
	public DeployValidatorService getDeployValidatorService() {
		if (deployValidatorService == null) {
			deployValidatorService = getDefaultDeployValidatorService();
		}
		return deployValidatorService;
	}

	@Override
	public String getPartName() {
		String title = super.getPartName();
		int inx = title.indexOf('.');
		if (inx == -1) {
			inx = title.length();
		}
		return title.substring(0, inx);
	}

	public Saveable[] getSaveables() {
		return new Saveable[] { saveable };
	}

	/*
	 * We have to override this method and set the topology file that is opened because this tooltip
	 * is used as the title for the workbench window and having multiple files in the text causes the
	 * window title to be shown funny.
	 * 
	 * @see com.ibm.ccl.soa.infrastructure.ui.SOACommonDiagramEditor#getTitleToolTip()
	 */
	public String getTitleToolTip() {
		if (!initialized) {
			return IConstants.EMPTY_STRING;
		}

		if (saveable != null) {
			List<IFile> topologyArtifacts = saveable.getModelArtifacts();
			if (topologyArtifacts.size() > 0) {
				IFile topologyFile = topologyArtifacts.get(0);
				if (topologyFile != null) {
					return topologyFile.getFullPath().toString();
				}
			}
		}

		return super.getTitleToolTip();
	}

	/** Method from IGotoMarker */
	public void gotoMarker(IMarker marker) {
		Unit target = getTarget(marker);
		if (target != null) {
			StructuredSelection sel = new StructuredSelection(target);
			selectReveal(sel);

			// UX Item 2188: open flyout
			openFlyout(target, marker);
		}

	} // end method gotoMarker()

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.ISetSelectionTarget#selectReveal(org.eclipse.jface.viewers.ISelection)
	 */
	public void selectReveal(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object[] selectionArray = ((IStructuredSelection) selection).toArray();
			List<EObject> elements = new ArrayList<EObject>();
			Object object = null;
			for (int x = 0; x < selectionArray.length; ++x) {
				object = selectionArray[x];
				// don't select if the editpart doesn't exist
				if (object instanceof EObject
						&& GMFUtils.getEditPartsFor(getDiagramGraphicalViewer(), (EObject) object).size() > 0) {
					elements.add((EObject) object);
				}
			}
			select(elements);
		}

	}

	public void setFocus() {
		super.setFocus();
		DeployCorePerspectiveFactory.filterViewsByDecoratorSemantic(getDecoratorSemantic());
	}

	/**
	 * Validation has just finished.
	 * 
	 * BUG: Doesn't notice when blocking/synchronous validation finishes.
	 */
	public void validationComplete() {
		//		System.out.println("Validation complete!"); //$NON-NLS-1$
		if (!getGraphicalControl().isDisposed()) {
			getGraphicalControl().getDisplay().asyncExec(new Runnable() {
				public void run() {
					// Get all EditParts.  This includes connections, which might not be
					// children of the root.
					//				Map m = getGraphicalViewer().getRootEditPart().getViewer().getEditPartRegistry();
					// Bug https://cs.opensource.ibm.com/bugzilla/show_bug.cgi?id=12536
					// Don't iterate through GMF's map, because validationComplete() might
					// add or remove markers triggering concurrent modifications.  Copy the map first. 
					Map m = new HashMap(getGraphicalViewer().getRootEditPart().getViewer()
							.getEditPartRegistry());
					for (Iterator<EditPart> it = m.values().iterator(); it.hasNext();) {
						EditPart ep = it.next();
						validationComplete(ep);
					}
				}
			});
		}
	}

	protected void configureGraphicalViewer() {
		if (initialized) {
			super.configureGraphicalViewer();

			IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();

			// build context menus
			buildContextMenus(viewer);

			// install additional key handlers for selection tools
			setupKeyHandler(viewer);

			// install link routine
			installDeployConnectionLayer(viewer);
		}

	}

	@Override
	protected PaletteViewer constructPaletteViewer() {
		// there's no really clean way to add the Dynamic Entries menu options
		return new PaletteViewerEx() {
			@Override
			public void setContextMenu(MenuManager contextMenu) {
				super.setContextMenu(contextMenu);
				if (contextMenu != null) {
					dynamicEntryMenuManager.install(this);
				}
			}
		};
	}

	// filter out GMF palette contribution
	protected PaletteRoot createPaletteRoot(PaletteRoot existingRoot) {
		PaletteRoot root = null;

		try {

			root = super.createPaletteRoot(existingRoot);
			getDsService().addDecoratorSemanticChangeListener(this);
			palettePopulator.populatePalette(root);
		} catch (RuntimeException e) {
			String msg = e.getMessage() != null ? e.getMessage() : e.toString();
			DeployCoreUIPlugin.logError(0, msg, e);
		}

		return root;
	}

	protected ScrollingGraphicalViewer createScrollingGraphicalViewer() {
		DeployViewerDropAdapter adapter = new DeployViewerDropAdapter(this);
		DeployGraphicalViewer viewer = new DeployGraphicalViewer(adapter);
		adapter.setViewer(viewer);
		return viewer;
	}

	protected DeployCoreEditor getDeployCoreEditor() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.infrastructure.ui.SOACommonDiagramEditor#getDiagramEditorInput(org.eclipse
	 *      .ui.IEditorInput)
	 */
	protected IDiagramEditorInput getDiagramEditorInput(IEditorInput input) {
		if (input instanceof FileEditorInput) {
			// the input file is the topology file
			// get the corresponding diagram file
			IFile file = getDiagramFile(input);
			setPartName(file.getName());
			return new TopologySaveableInput(file, saveable);

		}
		return null;
	}

	protected IFile getDiagramFile(IEditorInput input) {
		if (input instanceof FileEditorInput) {
			IFile file = ((FileEditorInput) input).getFile();
			// if this is already a topologyv file, just use that
			if (file.getFileExtension().compareToIgnoreCase(IConstants.TOPOLOGYV_EXTENSION) == 0) {
				return file;
				// else if a .topology file, get a .topologyv IFile resource
			} else if (file.getFileExtension().compareToIgnoreCase(IConstants.TOPOLOGY_EXTENSION) == 0) {
				return getDefaultDiagramFile(file);
			}
		}
		return null;
	}

	protected IDecoratorSemanticService getDsService() {
		if (dsService == null) {
			dsService = ExtensionsCore.createDecoratorSemanticService();
		}
		return dsService;
	}

	protected String[] getInterestingExtensions() {
		return DEFAULT_EXTS;
	}

	/*
	 * use our own custom delete handler until gmf fixes bugs
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#getKeyHandler()
	 */
	protected KeyHandler getKeyHandler() {
		KeyHandler keyHandler = super.getKeyHandler();

		// add our "Delete from Model"
		ActionRegistry registry = getActionRegistry();

		if (registry.getAction(DeployActionIds.DEPLOY_DELETE_MODEL) == null) {
			DeployDeleteAction modelAction = new DeployDeleteAction(this.getSite().getPage(),
					DeployDeleteAction.DELETE_FROM_MODEL, DeployDeleteAction.DELKEY_DELETE);
			registry.registerAction(modelAction);
			getSelectionActions().add(modelAction.getId());
			// assign Ctrl+Del to "Delete from Model"
			keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, SWT.CTRL), modelAction);
		}
		// add our "Delete from Diagram"
		if (registry.getAction(DeployActionIds.DEPLOY_DELETE_VIEW) == null) {
			DeployDeleteAction viewAction = new DeployDeleteAction(this.getSite().getPage(),
					DeployDeleteAction.DELETE_FROM_DIAGRAM, DeployDeleteAction.DELKEY_DELETE);
			registry.registerAction(viewAction);
			getSelectionActions().add(viewAction.getId());
			// assign Del, BS keys to our "Delete from Diagram" action
			keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0), viewAction);
			keyHandler.put(KeyStroke.getPressed(SWT.BS, 8, 0), viewAction);
		}

		if (registry.getAction(DeployActionIds.DEPLOY_DELETE_FROM_CONTAINER) == null) {
			// add our "Delete from Container"
			DeployDeleteAction containerAction = new DeployDeleteAction(this.getSite().getPage(),
					DeployDeleteAction.DELETE_FROM_CONTAINER, DeployDeleteAction.DELKEY_DELETE);
			registry.registerAction(containerAction);
			getSelectionActions().add(containerAction.getId());
			// assign Alt+Del to "Delete from Container"
			keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, SWT.ALT), containerAction);
		}

		return keyHandler;
	}

	protected Unit getModelUnit(EditPart editPart) {
		Object model = editPart.getModel();
		if (model instanceof View) {
			View view = (View) model;
			if (view.getElement() instanceof Unit) {
				return (Unit) view.getElement();
			}
		}

		return null;
	}

	@Override
	protected EditPartFactory getOutlineViewEditPartFactory() {
		return new EditPartFactory() {

			public EditPart createEditPart(EditPart context, Object model) {
				if (model instanceof Diagram) {
					return new TreeDiagramEditPart(model);
				} else if (model instanceof Node) {
					return new UnitOutlineEditPart(DeployCoreEditor.this.getDiagramGraphicalViewer(),
							context, (Node) model);
				}

				return new TreeEditPart(model);
			}
		};
	}

	protected void initializeGraphicalViewer() {
		Diagram model = getDiagram();
		Resource resource = null;
		boolean dirtyFlag = false;
		if (model != null) {
			resource = model.eResource();
			if (resource != null) {
				dirtyFlag = resource.isModified();
			}
		}
		try {
			/* Add a drop target listener for Deploy objects */
			getDiagramGraphicalViewer().addDropTargetListener(
					(TransferDropTargetListener) new DeployDropTargetListener(
							getDiagramGraphicalViewer()));
			super.initializeGraphicalViewer();
			doInitializeGraphicalViewer();
		} finally {
			if (resource != null) {
				resource.setModified(dirtyFlag);
			}
		}
	}

	private void doInitializeGraphicalViewer() {

		// start w/o grid snap
		getGraphicalViewer().setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, false);
		// eventually in DeployShapeNodeEditPart
//	    public Object getAdapter(Class key) {       
//	        if (key == SnapToHelper.class) {
//	            return SnapToHelperUtil.getSnapHelper(this);// provide override of helper
//	        }
//	    }

		final DeployDiagramEditPart ddep = (DeployDiagramEditPart) getDiagramEditPart();
		/* if toplogyv is new, run arrange on it just in case it had views in it */
		if (isNewTopology) {
			// add all views to diagram
			CanonicalUtils.refreshViews(ddep, null, true);
			// Create a pleasant layout.
			ArrangeRequest request = new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL,
					LayoutType.DEFAULT);
			request.setPartsToArrange(getDiagram().getChildren());
			Command command = getDiagramEditPart().getCommand(request);
			if (command != null && command.canExecute()) {
				DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
						.getDiagramCommandStack();
				cmdStack.execute(command);
			}
		} else {
			// existing diagram
			// should views be created in existing diagram? 
			if (_visualizeInput != null) {
				DiagramCommandStack cmdStack = getDiagramEditPart().getDiagramEditDomain()
						.getDiagramCommandStack();
				AbstractTransactionalCommand visualizeCmd = null;
				if (!_visualizeInput.hasNotationModel()) {
					// adding units in navigator to a new diagram
					// result of AddToNewTopologyDiagramAction
					visualizeCmd = new VisualizeFromSemanticCommand(getEditingDomain(),
							getDiagramEditPart(), _visualizeInput.getVisualizeDmos(), null, null);
				} else {
					// adding units from one diagram to a new diagram
					visualizeCmd = new VisualizeFromNotationalCommand(getEditingDomain(),
							getDiagramEditPart(), _visualizeInput.getViewMap(), null);
				}
				if (visualizeCmd.canExecute()) {
					cmdStack.execute(new ICommandProxy(visualizeCmd));
				}
			}
		}

		EObject eobject = getDiagram().getElement();
		if (eobject instanceof Topology) {
			// Monitor topology for changes
			Topology topology = (Topology) eobject;
			DeployValidatorService validator = getDeployValidatorService();
			TopologyValidationMonitor.monitor(topology, validator, new UIDeployOperationExecutor(),
					250);

			watchForValidationJobs();
		}
		connectionLayer.setDiagramEditPart(getDiagramEditPart());

		// init consolidated links
		ConsolidationLinkUtils.refreshConsolidatedLinks(getDiagramEditPart());

		// display any automatic notation model changes (thru canonical policies) due to the semantic model changing 
		if (!isNewTopology && _visualizeInput == null
				&& (_initialViewChanges.size() > 0 || ddep.getInitialCanonicalChanges().size() > 0)) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					_initialViewChanges.addAll(ddep.getInitialCanonicalChanges());
					ddep.setInitialCanonicalChanges(null);
					DiagramUpdateDialog dlg = new DiagramUpdateDialog(_initialViewChanges,
							DeployCoreEditor.this.getDiagramGraphicalViewer(), null);
					dlg.open();
				}
			});
		} else {
			// only need to set to null if not opening dialog-- otherwise dialog sets to null
			ddep.setInitialCanonicalChanges(null);
		}

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {

		try {
			super.init(site, input);
		} catch (RuntimeException re) {
			openRedirectedEditor(input, re.getMessage());
		}
	}

	protected void setInput(IEditorInput input) {
		// check if the input of the file is topology
		// get the topologyv file, if it does not exist create one and
		// input = resolveInput(input);
		initialize(input);

		String problem = getAnyProblem(input);
		if (problem != null) {
			initialized = false;
			throw new IllegalStateException(problem);
		} else {
			setEditorImage();

			// delete any views that have unresolved elements
			Diagram diagram = this.getDiagram();
			if (diagram != null) {
				ViewUtil.refreshProxyViews(diagram, _initialViewChanges);
			}

			//Update the palettePopulator
			palettePopulator.setDecoratorSemantic(getDecoratorSemantic());

			// if this is a visualization open, remember what units to visualize
			if (input instanceof VisualizeFileEditorInput) {
				_visualizeInput = (VisualizeFileEditorInput) input;
			}
			initialized = true;
		}
	}

	private void buildContextMenus(final IDiagramGraphicalViewer viewer) {
		ContextMenuProvider provider = new DiagramContextMenuProvider(this, viewer) {

			public void buildContextMenu(IMenuManager menu) {

//				configureStandardGroups(menu);

				super.buildContextMenu(menu);
				// we override model delete to allow select elements to be deleted 
				menu.remove(ActionIds.ACTION_DELETE_FROM_DIAGRAM);
				menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);
				// RATLC00564916
				//menu.remove(ActionIds.MENU_NAVIGATE);
				menu.remove(GlobalActionId.PROPERTIES);
				menu.remove(ActionIds.ACTION_ADD_NOTELINK);

				// Remove the "Add" menu group
				menu.remove(ActionIds.MENU_DIAGRAM_ADD);

				IWorkbenchPage page = ResourceUtils.getActiveWorkbenchPage();
				// add "Delete from Container" if unit is contained
				if (DeployDeleteAction.isAllContainedEditParts(viewer)) {
					if (menu.find(DeployActionIds.DEPLOY_DELETE_VIEW) != null) {
						menu.insertAfter(DeployActionIds.DEPLOY_DELETE_VIEW, new DeployDeleteAction(page,
								DeployDeleteAction.DELETE_FROM_CONTAINER,
								DeployDeleteAction.MENUACTION_DELETE));
					}
				}

				/** Remove File Menu, and move "Save As Image ..." action */
				IMenuManager fileMenu = menu.findMenuUsingPath(ActionIds.MENU_FILE);
				IContributionItem saveAsImageItem = fileMenu
						.find(org.eclipse.gmf.runtime.diagram.ui.render.actions.ActionIds.ACTION_COPY_TO_IMAGE);
				menu.remove(fileMenu);
				menu.insertBefore(ICommonMenuConstants.GROUP_ADDITIONS, new Separator(
						Messages.DeployCoreEditor_Save_As_Diagra_));
				menu.appendToGroup(Messages.DeployCoreEditor_Save_As_Diagra_, saveAsImageItem);

				/** Build the Filter context menu */
				IMenuManager filterMenu = menu.findMenuUsingPath(ActionIds.MENU_FILTERS);
				filterMenu.removeAll();
				filterMenu.add(new FilterPreferenceMenuManager(page));
				filterMenu.add(new ShowRelatedAction(page));

				// bug https://cs.opensource.ibm.com/bugzilla/show_bug.cgi?id=11393
				// Add "Order" actions to main toolbar
				IMenuManager formatMenu = menu.findMenuUsingPath(ActionIds.MENU_FORMAT);
				if (formatMenu != null) {
					IMenuManager zorderMenu = formatMenu.findMenuUsingPath(ActionIds.MENU_ZORDER);
					if (zorderMenu != null) {
						formatMenu.remove(ActionIds.MENU_ZORDER);
						IContributionItem[] zorderItems = zorderMenu.getItems();
						for (int i = 0; i < zorderItems.length; i++) {
							formatMenu.add(zorderItems[i]);
						}
					}
				}

				menu.add(new Separator("PreferenceGroup")); //$NON-NLS-1$ 

				buildSynchronizeMenu(menu);

				//				buildConstraintLinksMenu(menu);
			}

			/**
			 * hide eight menus contributed by other plugins: Run As, Debug As, Profile As, Validation,
			 * Analysis, Team, Compare With, Replace With
			 */
			protected boolean allowItem(IContributionItem itemToAdd) {
				if (itemToAdd == null) {
					return false;
				}
				String itemId = itemToAdd.getId();

				/*
				 * These eight menu ids are below: org.eclipse.debug.ui.contextualLaunch.run.submenu
				 * org.eclipse.debug.ui.contextualLaunch.debug.submenu
				 * org.eclipse.debug.ui.contextualLaunch.profile.submenu ValidationAction
				 * org.eclipse.tptp
				 * .platform.analysis.core.ui.internal.actions.MultiAnalysisActionDelegate team.main
				 * compareWithMenu replaceWithMenu
				 */
				if ("org.eclipse.debug.ui.contextualLaunch.run.submenu".equals(itemId) || //$NON-NLS-1$
						"org.eclipse.debug.ui.contextualLaunch.debug.submenu".equals(itemId) || //$NON-NLS-1$
						"org.eclipse.debug.ui.contextualLaunch.profile.submenu".equals(itemId) || //$NON-NLS-1$
						"ValidationAction".equals(itemId) || //$NON-NLS-1$
						"org.eclipse.tptp.platform.analysis.core.ui.internal.actions.MultiAnalysisActionDelegate" //$NON-NLS-1$
						.equals(itemId) || "team.main".equals(itemId) || //$NON-NLS-1$
						"compareWithMenu".equals(itemId) || //$NON-NLS-1$
						"replaceWithMenu".equals(itemId)) //$NON-NLS-1$
				{
					itemToAdd.setVisible(false);
				}
				//filter the context menu on topology diagram
				filterEditorContextMenu(itemToAdd);
				return true;
			}

			private void buildSynchronizeMenu(IMenuManager menu) {

				//				menu.add(/*DeployActionIds.MB_SYNCHRONIZE,*/ new ContributionItem() {
				//					@Override
				//					public void fill(Menu menu, int index) {
				//						super.fill(menu, index);
				//						ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
				//						MenuItem synchronizeMenu = new MenuItem(menu, SWT.CASCADE);
				//						synchronizeMenu.setImage(sharedImages.getImage(ISharedImages.IMG_ACTN_SYNCHRONIZE));
				//						synchronizeMenu.setText(Messages.SynchronizeAction_Synchroniz_); 
				//						
				//						MenuItem toWorld = new MenuItem(synchronizeMenu, SWT.CASCADE);
				//						toWorld.
				//						
				//						synchronizeMenu.add(new SynchronizeAction(getShell(), viewer,  Direction.ModelToWorld));
				//						synchronizeMenu.add(new SynchronizeAction(getShell(), viewer,  Direction.WorldToModel));
				//					}
				//				});  

				// Removed as of M5 until Refresh is available
//				IMenuManager synchronizeMenu = new MenuManager(Messages.SynchronizeAction_Synchroniz_);
//				synchronizeMenu.add(new SynchronizeAction(getShell(), viewer, Direction.ModelToWorld));
//				synchronizeMenu.add(new SynchronizeAction(getShell(), viewer, Direction.WorldToModel));
//
//				menu.appendToGroup("restGroup", synchronizeMenu); //$NON-NLS-1$
			}

			private void filterEditorContextMenu(IContributionItem itemToAdd) {
				String semantic = getDecoratorSemantic();
				String itemid = itemToAdd.getId();
				if (itemid != null && !getDsService().isMenuMemberOf(semantic, itemid)) {
					itemToAdd.setVisible(false);
				}
			}
		};

		viewer.setContextMenu(provider);
		getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, viewer);
	}

	private String getDecoratorSemantic() {
		EObject eobject = getDiagram() != null ? getDiagram().getElement() : null;
		if (eobject instanceof Topology) {
			Topology topology = (Topology) eobject;
			return topology.getDecoratorSemantic();
		}
		return null;
	}

	private IFile getDefaultDiagramFile(IFile file) {
		Path diagramPath = (Path) new Path(file.getName()).removeFileExtension();
		// add .topologyv extension, then get file from same parent as .topology file (same folder)
		return file.getParent().getFile(diagramPath.addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
	}

	/**
	 * @param eObject
	 * @return Returns the list of the selectable editparts. Scans thru the editpart registry to find
	 *         the editpart whose model's element is the eObject. If it couldnot find one it tries to
	 *         find the editpart for the parent eObject's match.
	 */
	private List<EditPart> getSelectableEditParts(EObject eObject) {
		Map map = getGraphicalViewer().getEditPartRegistry();
		Set<?> set = map.keySet();
		Iterator<?> nodes = set.iterator();
		Object modelObject = null;
		EObject eResObject = null;
		List<EditPart> list = new ArrayList<EditPart>();
		EditPart ep = null;
		while (nodes.hasNext()) {

			modelObject = nodes.next();
			if (modelObject instanceof View) {
				eResObject = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
						.resolveSemanticElement((View) modelObject);
				if (eResObject == eObject) {
					ep = (EditPart) map.get(modelObject);
					if (ep != null && ep.isSelectable()) {
						list.add(ep);
					}
				}
			}

		}
		// if list is empty, try selecting the parent
		if (list.isEmpty()) {
			if (eObject.eContainer() != null) {
				list = getSelectableEditParts(eObject.eContainer());
			}
		}
		return list;
	}

	private Shell getShell() {
		return getSite().getShell();
	}

	private Unit getTarget(IMarker marker) {
		if (getDiagram().getElement() instanceof Topology) {
			Topology top = (Topology) getDiagram().getElement();
			Object obj = DeployMarker.getObject(marker, top);

			DeployModelObject dmo = (DeployModelObject) obj;

			while (dmo != null) {
				if (dmo instanceof Unit) {
					return (Unit) dmo;
				}

				dmo = dmo.getParent();
			}
		}

		return null;
	}

	private ImageDescriptor getVisibilityOverlay(Topology topology) {
		if (topology != null) {
			ConfigurationContract contract = topology.getConfigurationContract();
			if (contract != null) {
				Visibility vis = contract.getDefaultPolicy();
				switch (vis.getValue())
				{
				case Visibility.PRIVATE:
					if (contract.getDefaultConceptualPolicy().getValue() == Visibility.PUBLIC) {
						return DeployCoreUIPlugin
								.getDefault()
								.getSharedImages()
								.getImageDescriptor(
										com.ibm.ccl.soa.deploy.core.ui.ISharedImages.IMG_DEFAULT_CONTRACT_ALL_CONCEPTUAL_PUBLIC);
					} else {
						return DeployCoreUIPlugin
								.getDefault()
								.getSharedImages()
								.getImageDescriptor(
										com.ibm.ccl.soa.deploy.core.ui.ISharedImages.IMG_DEFAULT_CONTRACT_ALL_PRIVATE);
					}
				case Visibility.PUBLIC:
					return DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
							com.ibm.ccl.soa.deploy.core.ui.ISharedImages.IMG_DEFAULT_CONTRACT_ALL_PUBLIC);
				}
			}
		}
		return null;
	}

	private void initialize(IEditorInput input) {
		//reset the flag
		isNewTopology = false;

		// if otherwise, the finally {..} block will correctly generate an error
		if (input instanceof IFileEditorInput) {
			// check to see if the Diagram file exists, if it does not create one
			IFile modelFile = null;
			IFile diagramFile = null;

			IFile inputFile = ((IFileEditorInput) input).getFile();
			String fileExtension = inputFile.getFullPath().getFileExtension();
			if (IConstants.TOPOLOGY_EXTENSION.compareToIgnoreCase(fileExtension) == 0) {
				modelFile = inputFile;
			} else if (IConstants.TOPOLOGYV_EXTENSION.compareToIgnoreCase(fileExtension) == 0) {
				diagramFile = inputFile;
			} else {
				return; // cannot process other file extensions yet
			}

			Assert.isTrue(diagramFile != null || modelFile != null);

			if (diagramFile == null && modelFile != null) {
				diagramFile = getDefaultDiagramFile(modelFile);
			}

			Assert.isTrue(diagramFile != null);

			synchronized (lock) {
				saveable = new TopologySaveable(new IFile[] { diagramFile });

			}

			if (diagramFile.isAccessible()) {
				// we load the diagram here since getAssociatedModelFile() 
				// will also load it below; if we call this line after that line
				// the diagram resource will be loaded, unloaded, and then 
				// re-loaded by the editor
				saveable.getScribbler().getResource(diagramFile);
			}

			if (modelFile == null) {

				// try to find the model file associated with the diagram file, load the diagram resource if necessary
				modelFile = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(diagramFile, true);

				if (modelFile == null) {

					// if modelFile is still null at this point then that means we could not load the diagram file resource
					// or we could and it just does not contain an element that points to it's associated model file,
					// we will try to find a model with the same name as the diagram file ( in the case that this diagram file
					// is the default diagram for some model )

					modelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
							diagramFile.getFullPath().removeFileExtension().addFileExtension(
									IConstants.TOPOLOGY_EXTENSION));

					if (!modelFile.exists()) {

						// if no model file exists with the same name as the diagram then the diagram file
						// is not the default diagram for a model and we cannot determine which model file
						// should be associated with the diagram
						closeEditor(false);
						throw new IllegalArgumentException(
								"Diagram file \"" + diagramFile.getName() + "\" does not reference a valid Topology model and a model file with the same name does not exist in the same directory as the diagram file."); //$NON-NLS-1$//$NON-NLS-2$
					}
				}

			}

			assert diagramFile != null && diagramFile.getFileExtension() != null
					&& diagramFile.getFileExtension().equals(IConstants.TOPOLOGYV_EXTENSION) : "Diagram file does not exists"; //$NON-NLS-1$

			// we load the resource here to avoid unnecessary re-loads in the API we're about to call
			saveable.getScribbler().getResource(modelFile);
			saveable.addArtifact(modelFile);

			if (!diagramExistsAndNotCorrupt(diagramFile)) {
				TopologyDiagramCreateHelper.createDiagramFile(modelFile, diagramFile, saveable
						.getScribbler());
				Resource modelResource = saveable.getScribbler().getResource(modelFile);
				if (modelResource.getContents().size() > 0) {
					DeployCoreRoot root = (DeployCoreRoot) modelResource.getContents().get(0);
					Topology topology = root.getTopology();
					if (topology == null) {
						throw new IllegalStateException("The model file \"" + modelFile.getName() //$NON-NLS-1$
								+ "\" has been corrupted. Please verify that the file is a valid Topology."); //$NON-NLS-1$
					}

					List<DeployModelObject> visualizees = new ArrayList<DeployModelObject>();
					visualizees.addAll(topology.getUnits());
					visualizees.addAll(topology.getImports());
					_visualizeInput = new VisualizeFileEditorInput(diagramFile, visualizees);

				}
			}

			// need to explicitly invoke loading notification b/c it does not always fire correctly when resource is loaded
			Resource modelResource = saveable.getScribbler().getResource(modelFile);
			monitor.resourceLoaded(modelResource);

			// need to explicitly invoke loading notification b/c it does not always fire correctly when resource is loaded
			Resource diagramResource = saveable.getScribbler().getResource(diagramFile);
			monitor.resourceLoaded(diagramResource);

			super.setInput(getDiagramEditorInput(input));
		}

	}

	private String getAnyProblem(IEditorInput input) {
		String target = input instanceof IFileEditorInput ? ((IFileEditorInput) input).getFile()
				.getName() : Messages.DeployCoreEditor_Unknown_input_sourc_;
		if (saveable == null || saveable.getScribbler().isClosed() || !saveable.isOpen()) {
			return NLS.bind(Messages.DeployCoreEditor_Could_not_successfully_load_the_mod_, target);
		}
		Diagram diagram = getDiagram();
		if (diagram == null || diagram.eIsProxy() || diagram.getElement().eIsProxy()) {
			return NLS.bind(Messages.DeployCoreEditor_The_diagram_object_for_0_was_im_, target);
		}

		return null;
	}

	private boolean diagramExistsAndNotCorrupt(IFile diagramFile) {
		if (!diagramFile.exists()) {
			return false;
		}
		if (saveable != null) {
			Resource resource = saveable.getScribbler().getResource(diagramFile.getFullPath());
			if (resource != null) {
				return resource.getContents().size() > 0;
			}
		}
		return false;
	}

	private void installDeployConnectionLayer(IDiagramGraphicalViewer viewer) {
		// replace the ConnectionLayer
		DiagramRootEditPart rootEditPart = (DiagramRootEditPart) viewer.getRootEditPart();
		IFigure figure = rootEditPart.getLayer(LayerConstants.CONNECTION_LAYER);
		if (figure != null) {
			IFigure parentFigure = figure.getParent();
			parentFigure.remove(figure);
			connectionLayer = new DeployConnectionLayerEx(parentFigure);
			parentFigure.add(connectionLayer, LayerConstants.CONNECTION_LAYER);
		}
	}

	private void openFlyout(Unit target, IMarker marker) {
		if (getDiagram().getElement() instanceof Topology) {
			Topology top = (Topology) getDiagram().getElement();
			Object obj = DeployMarker.getObject(marker, top);

			// If the marker points to a Constraint, look at the container.  The UI for the
			// container displays the constraints.
			while (obj instanceof Constraint) {
				Constraint constraint = (Constraint) obj;
				obj = constraint.getParent();
			}

			if (obj instanceof Capability) {
				Capability cap = (Capability) obj;

				Point initialLocation = new Point(0, 0);
				List sel = getGraphicalViewer().getSelectedEditParts();
				if (sel.size() > 0 && sel.get(0) instanceof DeployShapeNodeEditPart) {
					DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) sel.get(0);
					initialLocation = estimate(ep);
					// Shift it a little bit so a trace of the selected unit is visible
					initialLocation.x += 10;
					initialLocation.y += 10;
				}

				CapabilitiesPopupDialog popup = new CapabilitiesPopupDialog(getShell(), target,
						initialLocation);
				new UnitFlyOutPropertiesToggler(target, getEditDomain(), popup);
				popup.open();
				popup.setSelection(cap);
			}

			// We could attempt to open the Requirements flyout here, or the Artifacts property page,
			// if obj isn't a Capability...
		}
	}

	/**
	 * If this EditPart has decorations, refresh them now
	 * 
	 * @param ep
	 */
	private void refreshMarkers(EditPart ep) {
		DecorationEditPolicy policy = (DecorationEditPolicy) ep
				.getEditPolicy(EditPolicyRoles.DECORATION_ROLE);
		if (policy != null) {
			policy.refresh();
		}
	}

	/**
	 * @param elements
	 *           List of elements to be selected
	 */
	private void select(List<?> elements) {
		List<EditPart> editparts = new ArrayList<EditPart>();
		List<EditPart> list = null;
		for (int i = 0; i < elements.size(); i++) {
			Object element = elements.get(i);
			if (element instanceof EObject) {
				list = getSelectableEditParts((EObject) element);
				editparts.addAll(list);
			}
		}

		if (!editparts.isEmpty()) {
			getGraphicalViewer().setSelection(new StructuredSelection(editparts));
			getGraphicalViewer().reveal(editparts.get(editparts.size() - 1));
		} else {
			getGraphicalViewer().deselectAll();
		}
	}

	/**
	 * Sets the editor image based on the topology decorator semantic and default contract status. If
	 * the semantic is null, or no image can be found, then the default is used.
	 * 
	 */
	private void setEditorImage() {
		Image editorImage = null;

		//Get the correct decorator semantic image
		String imgPath = getDsService().getDecoratorSemanticIcon(getDecoratorSemantic());
		if (imgPath != null && imgPath.trim().length() != 0) {
			editorImage = DeployCoreUIPlugin.getDefault().getSharedImages().getImageFromPath(imgPath);
		}

		//Create the contract overlay in top left corner
		if (getDiagram().getElement() instanceof Topology) {
			Topology top = (Topology) getDiagram().getElement();
			ImageDescriptor desc = getVisibilityOverlay(top);
			//If we have found an overlay, use it
			if (desc != null) {
				if (editorImage == null) {
					editorImage = getTitleImage();
				}
				OverlayImageDescriptor overlay = new OverlayImageDescriptor(editorImage, desc, 16, 16);
				Image newImage = overlay.createImage();

				setTitleImage(newImage);
			} else if (editorImage != null) { //If we don't find an overlay but have a semantic
				setTitleImage(editorImage);
			}
		}
	}

	private void setupKeyHandler(IDiagramGraphicalViewer viewer) {
		KeyHandler viewerKeyHandler = new DeployEditorKeyHandler(this).setParent(viewer
				.getKeyHandler());
		viewer.setKeyHandler(viewerKeyHandler);
	}

	/** Stop monitoring of validation */
	private void unwatchValidationJobs() {
		if (validationListener != null) {
			Job.getJobManager().removeJobChangeListener(validationListener);
		}
	}

	/**
	 * Refresh SOA Deploy markers on this EditPart and its children. NOTE: recursive.
	 */
	private void validationComplete(EditPart ep) {

		if (ep.getModel() instanceof View) {
			View v = (View) ep.getModel();
			if (v instanceof Edge || ep instanceof DeployShapeNodeEditPart) {
				if (v.getElement() instanceof DeployModelObject) {
					refreshMarkers(ep);
				}
			}
		}

		for (Iterator<EditPart> it = ep.getChildren().iterator(); it.hasNext();) {
			validationComplete(it.next());
		}
	}

	/** Monitor for the end of validation */
	private void watchForValidationJobs() {
		validationListener = new JobChangeAdapter() {
			public void done(IJobChangeEvent event) {
				if (event.getJob() instanceof DeployValidatorJob) {
					validationComplete();
				}
			}
		};

		Job.getJobManager().addJobChangeListener(validationListener);
	}

	/** ***********implements******************** */
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * @see org.eclipse.ui.IEditorPart#doSave(IProgressMonitor)
	 */
	public void doSave(IProgressMonitor progressMonitor) {

		if (saveable != null) {
			try {
				saveable.doSave(progressMonitor, new IShellProvider() {
					public Shell getShell() {
						return getSite().getShell();
					}
				});
			} catch (CoreException e) {
				DeployCoreUIPlugin.logError(0, e.getMessage(), e);
			}

		}
	}

	public void doSaveAs() {
		performSaveAs(new NullProgressMonitor(), false);
	}

	protected boolean performSaveAs(IProgressMonitor progressMonitor, boolean originalDeleted) {
		SaveAsDialog dialog = new SaveAsDialog(getSite().getWorkbenchWindow().getShell());
		// Only set the original file if it is file based.
		if (getEditorInput() instanceof IFileEditorInput) {
			dialog.setOriginalFile(getDiagramFile(getEditorInput()));
		}

		dialog.open();
		IPath path = dialog.getResult();

		if (path == null) {
			return false;
		}

		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);

		boolean sameFile = false;
		if (!originalDeleted) {
			if (getEditorInput() instanceof IFileEditorInput) {
				sameFile = ((IFile) ((IAdaptable) getEditorInput()).getAdapter(IFile.class))
						.getLocation().equals(file.getLocation());

				if (!sameFile) {
					// check if the file is open in the editor
					List editors = EditorService.getInstance().getRegisteredEditorParts();
					for (Iterator it = editors.iterator(); it.hasNext();) {
						IEditorPart editor = (IEditorPart) it.next();
						IFile f = (IFile) ((IAdaptable) editor.getEditorInput()).getAdapter(IFile.class);
						if (f.getLocation() != null && f.getLocation().equals(file.getLocation())) {
							MessageBox mb = new MessageBox(getSite().getWorkbenchWindow().getShell(),
									SWT.OK | SWT.ICON_ERROR | SWT.APPLICATION_MODAL);
							mb.setMessage(NLS.bind(Messages.DeployCoreEditor_Save_as_0_, path));
							mb.open();

							return false;
						}
					}
				}
			}
		}

//		final boolean clone = originalDeleted ? originalDeleted : !sameFile;

		IRunnableWithProgress op = new IRunnableWithProgress() {

			public void run(final IProgressMonitor monitor) {
				try {
					doSave(/* file, clone, */monitor);
				} catch (Exception e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		};

		try {
			IProgressService service = PlatformUI.getWorkbench().getProgressService();
			service.run(false, true, op);
		} catch (InvocationTargetException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		} catch (InterruptedException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		}

		return true;
	}

	protected boolean isValidInput(IEditorInput newInput) {
		if (newInput instanceof IFileEditorInput) {
			IFileEditorInput input = (IFileEditorInput) getEditorInput();
			IFile file = input.getFile();
			if (IConstants.TOPOLOGY_EXTENSION.compareToIgnoreCase(file.getFileExtension()) == 0
					|| IConstants.TOPOLOGYV_EXTENSION.compareToIgnoreCase(file.getFileExtension()) == 0) {
				return true;
			}
		}
		return false;
	}

	protected String getRedirectedEditorID() {
		return XML_SOURCE_EDITOR_ID;
	}

	protected String getRedirectedEditorMessage() {
		if (getEditorInput() instanceof IFileEditorInput) {
			return Messages.Redirecting_Editor_3_ERROR;
		}

		return Messages.REDIRECT_TEXT_EDITOR_BINARY_PROJECT_UI;
	}

	/**
	 * Close this editor and open another system editor that can handle the input.
	 */
	protected void openRedirectedEditor(final IEditorInput input, final String errorMessage) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getEditorSite().getPage().closeEditor(DeployCoreEditor.this, false);
				MessageDialog.openError(null, Messages.Redirecting_Editor_1, errorMessage);
				IWorkbenchPage page = null;
				try {
					page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					page.openEditor(input, getRedirectedEditorID());
				} catch (Exception e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
					if (page != null) {
						try {
							page.openEditor(input, TEXT_EDITOR_ID);
						} catch (PartInitException e1) {
							DeployCoreUIPlugin.logError(0, e1.getMessage(), e1);
						}
					}
				}
			}
		});
	}

//
//	/**
//	 * 
//	 * @param newFile
//	 *           The file to save
//	 * @param clone
//	 *           Not used by this method
//	 * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
//	 */
//	public void doSave(final IFile newFile, boolean clone, final IProgressMonitor progressMonitor)
//			throws Exception {
//		/* perform validate save on the file */
//		if (!FileChangeManager.getInstance().okToSave(newFile)) {
//			String title = Messages.DiagramEditor_save_readonly_dialog_title;
//			String message = Messages.DiagramEditor_save_readonly_dialog_message;
//			MessageDialog.openError(getSite().getShell(), title, MessageFormat.format(message,
//					new Object[] { newFile.getName() }));
//			return;
//		}
//
//		try {
//
//			ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
//
//				public void run(IProgressMonitor monitor) throws CoreException {
//					IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE
//							.getContext(getFileEditorInput().getFile().getProject());
//					IUndoableOperation commitOp = new AbstractEMFOperation(context.getEditingDomain(),
//							Messages.SOACommonDiagramEditor_Saving_the_contents_of_the_editor_) {
//
//						protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
//							try {
//								progressMonitor
//										.setTaskName(Messages.SOACommonDiagramEditor_Saving_the_contents_of_the_editor_);
//								Assert.isNotNull(editModelScribbler);
//								IFileEditorInput input = getFileEditorInput();
//								if (input != null) {
//									IFile originalFile = input.getFile();
//									if (!originalFile.equals(newFile)) {
//
//										Resource diagramResource = editModelScribbler
//												.getResource(originalFile.getFullPath());
//										diagramResource.setURI(URI.createPlatformResourceURI(newFile
//												.getFullPath().toString(), true));
//										diagramResource.setModified(true);
//
//										updateFileInput(newFile);
//									}
//								}
//
//								editModelScribbler.save(true, progressMonitor);
//							} catch (EditModelException e) {
//								DeployCoreUIPlugin.logError(0, e.getMessage(), e);
//								return Status.CANCEL_STATUS;
//							}
//							return Status.OK_STATUS;
//						}
//					};
//					// we do not use the command stack because we do not want this operation to appear in the Undo menu
//					try {
//						commitOp.execute(progressMonitor, null);
//					} catch (ExecutionException e) {
//						throw new CoreException(DeployCoreUIPlugin
//								.createErrorStatus(0, e.getMessage(), e));
//					}
//				}
//			}, progressMonitor);
//
//			setPartName(newFile.getName());
//		} catch (Exception e) {
//			DeployCoreUIPlugin.logError(0, e.getLocalizedMessage(), e);
//		} finally {
//			if (progressMonitor != null) {
//				progressMonitor.done();
//			}
//		}
//	}

	/**
	 * Re-exposed for visibility into the current package.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#firePropertyChange(int)
	 */
	protected void firePropertyChange(int property) {
		super.firePropertyChange(property);
	}

	/**
	 * Re-exposed for visibility into the current package.
	 * 
	 * @see DiagramEditor#closeEditor(boolean)
	 */
	protected void closeEditor(final boolean save) {
		super.closeEditor(save);
	}

	public boolean isDisposed() {
		// ensure memory consistency for disposed field
		synchronized (editorLock) {
			return disposed;
		}
	}

	public boolean isDirty() {

		if (saveable != null && saveable.isDirty()) {
			return true;
		}
		return false;
	}
} // end class DeployCoreEditor
