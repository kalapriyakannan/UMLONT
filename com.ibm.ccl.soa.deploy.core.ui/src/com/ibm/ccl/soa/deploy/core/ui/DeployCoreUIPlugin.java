/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.progress.IProgressService;
import org.osgi.framework.BundleContext;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ICapabilityProviderService;
import com.ibm.ccl.soa.deploy.core.extension.IUnitDiscovererService;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndex;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndexer;
import com.ibm.ccl.soa.deploy.core.ui.handlers.CompositeFactoryService;
import com.ibm.ccl.soa.deploy.core.ui.handlers.ICompositeFactoryService;
import com.ibm.ccl.soa.deploy.core.ui.internal.SharedColors;
import com.ibm.ccl.soa.deploy.core.ui.internal.SharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.internal.SharedImages;
import com.ibm.ccl.soa.deploy.core.ui.savables.ArtifactListener;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;
import com.ibm.ccl.soa.deploy.core.ui.util.ColorUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.internal.core.DeployFileModificationApprover.DeployValidateEditHelper;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.extension.SAFServiceFactory;
import com.ibm.ccl.soa.deploy.saf.ui.extension.IUIHandlerService;
import com.ibm.ccl.soa.deploy.saf.ui.extension.SAFUIServiceFactory;

/**
 * The main plugin cla ss to be used in the desktop.
 */
public class DeployCoreUIPlugin extends AbstractUIPlugin {
	/**
	 * The unique identifier for the DeployCoreUI plugin.
	 */
	public static String PLUGIN_ID = "com.ibm.ccl.soa.deploy.core.ui"; //$NON-NLS-1$

	/**
	 * The unique ID of editor used in preference store
	 */
	public static final String EDITOR_ID = "DeployCoreEditor"; //$NON-NLS-1$

	// The shared instance.
	private static DeployCoreUIPlugin instance;

	private ColorRegistry colorRegistry;

	/**
	 * Instance of the UnitProviderService
	 */
	private IUnitProviderService unitProviderService = null;

	/**
	 * Instance of the UnitDiscovererService
	 */
	private IUnitDiscovererService unitDiscovererService = null;

	/**
	 * Instance of the CapabilityProviderService
	 */
	private ICapabilityProviderService capabilityProviderService = null;

	/**
	 * Instance of the InterfaceHandlerService
	 */
	private static IInterfaceHandlerService interfaceHandlerService;

	/**
	 * Instance of the InterfaceUIHandlerService
	 */
	private static IUIHandlerService interfaceUIHandlerService;

	/**
	 * Instance of the InterfaceUIHandlerService
	 */
	private static IUIHandlerService artifactUIHandlerService;

	/**
	 * Instance of the DiagramFilesManager
	 */
//	private DiagramFilesManager diagramFilesManager;
	/**
	 * Instance of the ICompositeFactoryService
	 */
	private static ICompositeFactoryService compositeFactoryService;

	private static TopologyArtifactsMonitor artifactMonitor;

	private final Object lock = new Object();

	private ISharedImages sharedImages;

	private ISharedFonts sharedFonts;

	private ISharedColors sharedColors;

	/**
	 * A listener that will watch for model and diagram files to be changed on disk and will invoke
	 * the {@link ReloadTopologyJob}.
	 */
	private static final class TopologyReloadListener extends ArtifactListener {
		@Override
		public void onModelFileChanged(IFile model) {
			//Refresh
			ReloadTopologyJob.INSTANCE.enqueue(model);
		}

		@Override
		public void onDiagramFileChanged(IFile diagram) {
			//Refresh
			ReloadTopologyJob.INSTANCE.enqueue(diagram);
		}
	}

	private static final class DeployUIValidateEditHelper implements DeployValidateEditHelper {

		public List<IFile> getAffectedUIFiles() {
			//Check for active diagram as well.
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (window != null) {
				IEditorPart editor = window.getActivePage().getActiveEditor();
				if (editor != null) {
					if (editor.getEditorInput() instanceof FileEditorInput) {
						IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
						if (file != null) {
							return Collections.singletonList(file);
						}
					}
				}
			}
			return null;
		}

		public Object getUIContext() {
			Display display = Display.getCurrent();
			if (display != null) {
				return display.getActiveShell();
			} else {
				final Shell[] shell = new Shell[1];
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						shell[0] = Display.getCurrent().getActiveShell();
					}
				});
				return shell[0];
			}
		}
	}

	/**
	 * The constructor.
	 */
	public DeployCoreUIPlugin() {
		instance = this;
	}

	/**
	 * @return Returns the singleton instance of the UnitProviderService
	 */
	public IUnitProviderService getUnitProviderService() {
		return unitProviderService;
	}

	/**
	 * @return Returns the singleton instance of the UnitDiscovererService
	 */
	public IUnitDiscovererService getUnitDiscovererService() {
		return unitDiscovererService;
	}

	/**
	 * @return Returns the singleton instance of the CapabilityProviderService
	 */
	public ICapabilityProviderService getCapabilityProviderService() {
		return capabilityProviderService;
	}

	/**
	 * @return Returns the singleton instance of the IInterfaceHandlerService
	 */
	public IInterfaceHandlerService getInterfaceHandlerService() {
		return interfaceHandlerService;
	}

	/**
	 * @return Returns the singleton instance of the IInterfaceHandlerService
	 */
	public IUIHandlerService getInterfaceUIHandlerService() {
		return interfaceUIHandlerService;
	}

	/**
	 * @return Returns the singleton instance of the IInterfaceHandlerService
	 */
	public IUIHandlerService getArtifactUIHandlerService() {
		return artifactUIHandlerService;
	}

	/**
	 * @return Returns the singleton instance of the ICompositeFactoryService
	 */
	public ICompositeFactoryService getCompositeFactoryService() {
		return compositeFactoryService;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);

		// load IResourceFactory Assistant
		// DeployResourceAssistantFactory draf = new
		// DeployResourceAssistantFactory();
		// IEMFWorkbenchContextFactory.eINSTANCE.installResourceAssistantFactory(draf);
		IPreferenceStore prefStore = getPreferenceStore();
		PreferencesHint.registerPreferenceStore(new PreferencesHint(EDITOR_ID), prefStore);

		unitProviderService = ExtensionsCore.createProviderService();
		unitDiscovererService = ExtensionsCore.createDiscovererService();
		capabilityProviderService = ExtensionsCore.createCapabilityProviderService();

		// Update from preferences
		updateSettingsFromPreferences(prefStore);

//		diagramFilesManager = new DiagramFilesManager();
//		diagramFilesManager.init();

		ResourceTypeService.getInstance().init();

		interfaceHandlerService = SAFServiceFactory.createInterfaceHandlerService();
		interfaceUIHandlerService = SAFUIServiceFactory.createInterfaceUIHandlerService();
		artifactUIHandlerService = SAFUIServiceFactory.createArtifactUIHandlerService();
		compositeFactoryService = CompositeFactoryService.createCompositeFactoryService();

		artifactMonitor = TopologyArtifactsMonitor.INSTANCE;

		artifactMonitor.addListener(new TopologyReloadListener());

		DeployCorePlugin.getDefault().setDeployValidateEditHelper(new DeployUIValidateEditHelper());

	}

	/**
	 * reread the settings from preference store
	 */
	protected void updateSettingsFromPreferences(IPreferenceStore prefStore) {
		/*
		 * LocationBindingService.INSTANCE.setLocationBindingUsage(prefStore
		 * .getBoolean(IDeployPreferences.LOCATION_BINDING_USAGE));
		 */
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {

		super.stop(context);
		instance = null;

		ResourceTypeService.getInstance().depose();

		unitProviderService = null;
		unitDiscovererService = null;
		capabilityProviderService = null;

//		diagramFilesManager.dispose();
//		diagramFilesManager = null;

		artifactMonitor.dispose();
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return The shared instance.
	 */
	public static DeployCoreUIPlugin getDefault() {
		return instance;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @param path
	 *           the path
	 * @return the image descriptor
	 * @see ISharedImages#getImageDescriptor(String)
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Log an error using the plugin id of the DeployCorePlugin.
	 * 
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 */
	public static void logError(int aCode, String aMessage, Throwable anException) {
		getDefault().getLog().log(createErrorStatus(aCode, aMessage, anException));
	}

	/**
	 * Log an error using the plugin id of the DeployCorePlugin.
	 * 
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 */
	public static void logError(int aCode, String aMessage, ExecutionException anException) {
		if (anException != null) {
			if (anException.getCause() != null) {
				getDefault().getLog().log(
						createErrorStatus(aCode, anException.getCause().getMessage(), anException
								.getCause()));
			}
		} else {
			getDefault().getLog().log(createErrorStatus(aCode, aMessage, anException));
		}
	}

	/**
	 * Log an error using the plugin id of the DeployCorePlugin
	 * 
	 * @param severity
	 *           The severity of message (see {@link IStatus}).
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 */
	public static void log(int severity, int aCode, String aMessage, Throwable anException) {
		log(createStatus(severity, aCode, aMessage, anException));
	}

	/**
	 * Publish the status to the log.
	 * 
	 * @param aStatus
	 *           The status to publish to the log.
	 */
	public static void log(IStatus aStatus) {
		getDefault().getLog().log(aStatus);
	}

	/**
	 * Create a status using the DeployCorePlugin's id.
	 * 
	 * @param severity
	 *           The severity of message (see {@link IStatus}).
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createStatus(int severity, int aCode, String aMessage,
			Throwable anException) {
		if (aMessage == null) {
			aMessage = Messages.DeployCoreUIPlugin_No_Message_;
		}
		return new Status(severity, PLUGIN_ID, aCode, aMessage, anException);
	}

	/**
	 * Create a status with the severity set to {@link IStatus#ERROR}.
	 * 
	 * @param aCode
	 *           A message code for the created status
	 * @param aMessage
	 *           A message describing the error
	 * @param anException
	 *           An exception that was thrown, if any.
	 * @return The created status
	 */
	public static IStatus createErrorStatus(int aCode, String aMessage, Throwable anException) {
		return createStatus(IStatus.ERROR, aCode, aMessage, anException);
	}

	public ColorRegistry getColorRegistry() {
		if (colorRegistry == null) {
			colorRegistry = createColorRegistry();
			initializeColorRegistry(colorRegistry);
		}
		return colorRegistry;
	}

	/**
	 * Return the indexer which manages knowledge about the location of the model files throughout
	 * the workspace.
	 * 
	 * <b>A convenience method to fetch an index and show a progress dialog to prevent UI lockup.
	 * Must be called from a UI thread.</b>
	 * 
	 * @param project
	 *           The project to fetch the interface for.
	 * 
	 * @return The indexer singleton which tracks available model files in the workspace.
	 * 
	 * @see DeployCorePlugin#getIndexer()
	 * @see IModelFileIndexer#getModelIndex(IProject, IProgressMonitor)
	 * 
	 */
	public IModelFileIndex getIndex(final IProject project) {

		final IModelFileIndex[] index = new IModelFileIndex[1];
		synchronized (lock) {
			IProgressService progress = PlatformUI.getWorkbench().getProgressService();
			try {
				progress.busyCursorWhile(new IRunnableWithProgress() {
					public void run(IProgressMonitor monitor) {
						monitor.beginTask(NLS.bind(
								Messages.DeployCoreUIPlugin_Fetching_the_model_index_for_0_, project
										.getName()), 10);
						index[0] = DeployCorePlugin.getDefault().getIndexer().getModelIndex(project,
								new SubProgressMonitor(monitor, 10));
						monitor.done();
					}
				});
			} catch (InvocationTargetException e) {
				logError(0, e.getMessage(), e);
			} catch (InterruptedException e) {
				logError(0, e.getMessage(), e);
			}

		}
		return index[0];
	}

	public ISharedImages getSharedImages() {
		synchronized (lock) {
			if (sharedImages == null) {
				sharedImages = new SharedImages(PLUGIN_ID, getImageRegistry());
			}
		}
		return sharedImages;
	}

	/**
	 * @return The {@link ISharedFonts} which manages the {@link org.eclipse.swt.graphics.Font}s
	 *         shared by the Deploy Core UI Plug-in.
	 */
	public ISharedFonts getSharedFonts() {
		if (sharedFonts == null) {
			sharedFonts = new SharedFonts(new FontRegistry());
		}
		return sharedFonts;
	}

	public ISharedColors getSharedColors() {
		if (sharedColors == null) {
			sharedColors = new SharedColors(PLUGIN_ID, getColorRegistry());
		}
		return sharedColors;
	}

	public static void executeFromNestedContextWithProgress(final IUndoableOperation operation,
			final IAdaptable info, boolean fork, final ISchedulingRule rule) {

		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				try {
					ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {

						public void run(IProgressMonitor monitor) throws CoreException {
							try {
								operation.execute(monitor, info);
							} catch (ExecutionException e) {
								throw new CoreException(DeployCoreUIPlugin.createErrorStatus(0, e
										.getMessage(), e));
							}
						}
					}, rule, 0, monitor);
				} catch (CoreException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		};
		runWithProgress(runnable, fork);

	}

	/**
	 * Execute the given operation with the correct {@link IUndoContext} relative to the given
	 * context.
	 * 
	 * @param scope
	 *           An existing ChangeScope to use as the undo context.
	 * @param operation
	 *           The operation to execute.
	 */
	public static void executeInContextWithProgress(final ChangeScope<?, ?> scope,
			final IUndoableOperation operation) {
		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException,
					InterruptedException {
				scope.execute(operation, monitor);
			}
		};

		runWithProgress(runnable);
	}

	/**
	 * Execute the given operation with the correct {@link IUndoContext} relative to the given
	 * context.
	 * 
	 * @param context
	 *           The context to supply to the operation before executing
	 * @param operation
	 *           The operation to execute.
	 */
	public static IStatus executeInContextWithProgress(IUndoContext context,
			final IUndoableOperation operation, final IAdaptable info) {
		final IStatus[] result = new IStatus[1];
		if (context != null) {
			operation.addContext(context);
		}
		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException,
					InterruptedException {

				IOperationHistory history = PlatformUI.getWorkbench().getOperationSupport()
						.getOperationHistory();
				try {
					result[0] = history.execute(operation, monitor, info);
				} catch (ExecutionException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		};

		runWithProgress(runnable, false);
		return result[0];
	}

	public static void undoWithProgress(final IUndoableOperation operation, final IAdaptable info) {

		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				try {
					operation.undo(monitor, info);
				} catch (ExecutionException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		};
		runWithProgress(runnable, false);

	}

	public static void redoWithProgress(final IUndoableOperation operation, final IAdaptable info) {

		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				try {
					operation.redo(monitor, info);
				} catch (ExecutionException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		};
		runWithProgress(runnable, false);

	}

	/**
	 * Executes the runnable using the progress monitor of the Workbench Window or presents a
	 * progress dialog if the window cannot be found.
	 * 
	 * @param runnable
	 *           A runnable which will be supplied a fresh progress monitor to provide feedback to
	 *           the user.
	 */
	public static void runWithProgress(IRunnableWithProgress runnable) {
		runWithProgress(runnable, true);
	}

	/**
	 * Executes the runnable using the progress monitor of the Workbench Window or presents a
	 * progress dialog if the window cannot be found.
	 * 
	 * @param runnable
	 *           A runnable which will be supplied a fresh progress monitor to provide feedback to
	 *           the user.
	 */
	public static void runWithProgress(IRunnableWithProgress runnable, boolean fork) {

		IWorkbench workbench = PlatformUI.getWorkbench();
		try {
			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			if (window != null) {
				window.run(fork, true, runnable);
			} else {
				IWorkbenchWindow[] workbenchWindows = workbench.getWorkbenchWindows();
				if (workbenchWindows.length > 0) {
					workbenchWindows[0].run(true, true, runnable);
				} else {
					workbench.getProgressService().run(true, true, runnable);
				}
			}
		} catch (InvocationTargetException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		} catch (InterruptedException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		}
	}

	/**
	 * Return a subprogress monitor properly configured to show labels on the main monitor.
	 * 
	 * @param monitor
	 *           The parent monitor for which this child monitor will measure a subportion of the
	 *           overall task.
	 * @param ticks
	 *           The number of ticks from the parent monitor to be counted off by the returned child
	 *           monitor.
	 * @return a subprogress monitor properly configured to show labels on the main monitor.
	 */
	public static IProgressMonitor subprogress(IProgressMonitor monitor, int ticks) {
		return new SubProgressMonitor(monitor, ticks,
				SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
	}

	protected ColorRegistry createColorRegistry() {
		return new ColorRegistry();
	}

	protected void initializeColorRegistry(ColorRegistry reg) {

		reg.put(DeployColorConstants.RGB_BLUE, new RGB(49, 106, 197)); // hard-coded
		// color
		// can
		// be
		// used for hover and
		// selection color

		reg.put(DeployColorConstants.RGB_LIGHT_BLUE, ColorUtils.getLightShade(reg
				.getRGB(DeployColorConstants.RGB_BLUE), 2, 3));

		reg.put(DeployColorConstants.RGB_BLUE_FOR_STROKE, getRBG(reg
				.getRGB(DeployColorConstants.RGB_BLUE), 65));

		reg.put(DeployColorConstants.RGB_BLUE_FOR_FILL, getRBG(reg
				.getRGB(DeployColorConstants.RGB_BLUE), 95));

	}

	protected static RGB getRBG(RGB rgb, float percentage) {
		RGB opacity = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND).getRGB();

		float p = percentage / 100;

		int r = Math.round(Math.min((1 - p) * rgb.red + p * opacity.red, 255));
		int g = Math.round(Math.min((1 - p) * rgb.green + p * opacity.green, 255));
		int b = Math.round(Math.min((1 - p) * rgb.blue + p * opacity.blue, 255));

		return new RGB(r, g, b);
	}

	protected static RGB getRBG(int symbol, float percentage) {
		return getRBG(Display.getCurrent().getSystemColor(symbol).getRGB(), percentage);
	}
}
