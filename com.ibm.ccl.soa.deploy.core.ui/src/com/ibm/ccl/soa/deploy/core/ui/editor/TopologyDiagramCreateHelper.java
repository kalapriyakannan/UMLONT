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
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.NewDiagramNameDialog;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

/**
 * Given an IFile creating a Topology, creates a Diagram and saves it in a .topologyv file.
 */
public class TopologyDiagramCreateHelper {

	private final IFile modelFile;
	private final IEditModelScribbler scribbler;

	private PreferencesHint preferencesHint;
	private final IFile diagramFile;

	/**
	 * @param file
	 * @param diagramFile
	 * @param scribbler
	 * 
	 */
	public TopologyDiagramCreateHelper(IFile file, IFile diagramFile, IEditModelScribbler scribbler) {
		modelFile = file;
		this.diagramFile = diagramFile != null ? diagramFile : modelFile.getParent().getFile(
				new Path(modelFile.getName() + "v")); //$NON-NLS-1$
		this.scribbler = scribbler;
	}

	protected final IFile getFile() {
		return modelFile;
	}

	/**
	 * @return Returns the status if the diagram is created, otherwise false
	 * @throws ExecutionException
	 */
	public IStatus createDiagram(IProgressMonitor monitor) throws ExecutionException {

		Resource modelResource = null;

		try {
			modelResource = getScribbler().getResource(modelFile.getFullPath());
		} catch (Exception e) {
			handleProblemLoadingModel(e);
			return null;
		}

		if (modelResource == null) {
			handleProblemLoadingModel(null);
			return null;
		}

		EObject rootModelObject = modelResource.getContents().get(0);

		if (rootModelObject == null || !(rootModelObject instanceof DeployCoreRoot)) {
			handleProblemLoadingModel(null);
			return null;
		}
		final Topology diagramModelObject = ((DeployCoreRoot) rootModelObject).getTopology();

		// Invoke create() and save() to make new view
		/* Map options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE); */
		AbstractEMFOperation operation = new AbstractEMFOperation(TransactionUtil
				.getEditingDomain(modelResource), StringStatics.BLANK, Collections.EMPTY_MAP) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				Diagram diagram = create(diagramModelObject);
				if (diagram == null) {
					return DeployCoreUIPlugin.createErrorStatus(0,
							"Failed to create diagram object", null); //$NON-NLS-1$

				}
				//set diagram name to default
				String str = new Path(diagramFile.getName()).removeFileExtension().toString();
				diagram.setName(str);
				try {
					getScribbler().save(true, monitor);
				} catch (EditModelException e) {
					throw new ExecutionException(e.getMessage(), e);
				}
				return Status.OK_STATUS;
			}
			/*
			 * private void setDiagramName(EObject diagram) { if (diagram instanceof Diagram) { IFile
			 * dFile = getDiagramFile(); if (dFile != null) { String fileName = dFile.getName(); int
			 * index = fileName.indexOf('.'); if (index > -1) { fileName = fileName.substring(0,
			 * index); } ((Diagram) diagram).setName(fileName); } } }
			 */
		};

		return operation.execute(monitor, null);

	}

	/**
	 * Given a core model Topology, produce a GMF Diagram visualization of that topology, using
	 * LayoutType.DEFAULT
	 * 
	 * <b>Must be called after modelFile and diagramFile are set.
	 * 
	 * @param filename
	 * 
	 * 
	 * @return a GMF diagram
	 */
	private Diagram create(Topology diagramModel) {

		Assert.isNotNull(modelFile);
		Assert.isNotNull(diagramFile);

		// Create a Diagram based on the Topology instance
		Diagram diagram = ViewService.getInstance().createDiagram(new EObjectAdapter(diagramModel),
				DeployCoreConstants.DEPLOY_CORE, getPreferencesHint());

		// create the topologyv resource so that an editingdomain can be used

		Resource diagramResource = getScribbler().getResource(diagramFile.getFullPath(),
				IEditModelScribbler.OPTION_NONE);
		diagramResource.getContents().add(diagram);

//		// create a diagram editpart
//		DeployDiagramEditPart diagramEP = (DeployDiagramEditPart) OffscreenEditPartFactory.
//				getInstance().createDiagramEditPart(diagram);
//		
//		// use the canonical edit policies to fill in the views for this model (units and links)
//		CanonicalUtils.refreshAll(diagramEP, true);
//		
//		// Create a pleasant layout.  
//		ArrangeRequest request = new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL,LayoutType.DEFAULT); 
//		request.setPartsToArrange(diagram.getChildren());
//		Command command=diagramEP.getCommand(request);
//		if (command != null && command.canExecute()) {
//			DiagramCommandStack cmdStack = diagramEP.getDiagramEditDomain().getDiagramCommandStack();
//			cmdStack.execute(command);
//		}

		return diagram;
	}

	/**
	 * 
	 */
	private void handleProblemLoadingModel(Throwable problem) {
		IStatus error = DeployCoreUIPlugin.createErrorStatus(0, Messages.EMPTY_CORRUPTED_TOPOLOGY,
				problem);
		DeployCoreUIPlugin.logError(0, error.getMessage(), problem);
		MessageDialog.openError(null, Messages.DeployCoreEditor_Problem_loading_mode_, error
				.getMessage());
	}

	private PreferencesHint getPreferencesHint() {
		if (preferencesHint == null) {
			preferencesHint = new PreferencesHint(DeployCoreUIPlugin.PLUGIN_ID);
		}
		return preferencesHint;
	}

	/**
	 * @return The diagram file that was created.
	 */
	public IFile getDiagramFile() {
		return diagramFile;
	}

	protected final IEditModelScribbler getScribbler() {
		return scribbler;
	}

	/**
	 * @param topologyFile
	 * @param diagramName
	 * @return new diagram file
	 */
	static public IFile createTopologyDiagram(IFile topologyFile, String diagramName) {
		// ask the user for the new digram name
		NewDiagramNameDialog dlg = new NewDiagramNameDialog(Display.getCurrent().getShells()[0],
				topologyFile, diagramName);
		if (dlg.open() != Window.OK) {
			return null;
		}
		diagramName = dlg.getDiagramName();

		// get unique diagram name
		Path diagramPath = (Path) new Path(diagramName)
				.addFileExtension(IConstants.TOPOLOGYV_EXTENSION);
		IFile diagramFile = topologyFile.getParent().getFile(diagramPath);

		IEditModelScribbler scribbler = null;
		try {
			scribbler = new DeploymentTopologyDomain(topologyFile, diagramFile)
					.createScribblerForWrite();
			diagramFile = createDiagramFile(topologyFile, diagramFile, scribbler);

		} catch (EditModelException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		} finally {
			if (scribbler != null) {
				try {
					scribbler.close(new NullProgressMonitor());
				} catch (EditModelException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		}
		return diagramFile;
	}

	public static IFile createDiagramFile(final IFile topologyFile, final IFile diagramFile,
			final IEditModelScribbler scribbler) {
		// no scope rule is specified; defaults to workspace
		// the resulting operation can be more broad than the 
		// files we're aware of here

		try {
			ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {

				public void run(IProgressMonitor monitor) throws CoreException {

					IProgressService service = PlatformUI.getWorkbench().getProgressService();

					try {
						service.runInUI(service, new IRunnableWithProgress() {

							public void run(IProgressMonitor monitor) /*
																					 * throws InvocationTargetException,
																					 * InterruptedException
																					 */{

								TopologyDiagramCreateHelper helper = new TopologyDiagramCreateHelper(
										topologyFile, diagramFile, scribbler);
								try {
									helper.createDiagram(monitor);

								} catch (ExecutionException e) {
									DeployCoreUIPlugin.logError(0, e.getMessage(), e);
								}

							}
						}, ResourcesPlugin.getWorkspace().getRoot());
					} catch (InvocationTargetException e) {
						DeployCoreUIPlugin.logError(0, e.getMessage(), e);
					} catch (InterruptedException e) {
						DeployCoreUIPlugin.logError(0, e.getMessage(), e);
					}
				}
			}, null);

			if (diagramFile.exists()) {
				return diagramFile;
			}
		} catch (CoreException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		}
		return null;
	}

}
