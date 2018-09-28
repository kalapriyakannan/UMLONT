/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.BasicFeatureMapEntry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ltk.core.refactoring.CreateChangeOperation;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;
import com.ibm.ccl.soa.deploy.core.internal.synchronization.ImportRefactoringProcessor;
import com.ibm.ccl.soa.deploy.core.internal.synchronization.SynchronizationRefactoring;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromSemanticCommand;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.ReportStatusDialog;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.SelectChangeQuickDialog;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.TopologyUnitStubLabelProvider;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployDiagramDragDropEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Creates views for <code>dropRequest</code>'s {@link DropObjectsRequest#getObjects()}, as well
 * as adding those objects to a {@link Topology}.
 * 
 * @since 1.0
 * @see DeployDiagramDragDropEditPolicy
 */
public class AddToTopologyCommand extends DeployTransactionalCommand {

	private final List<DeployModelObject> canExecuteCreateViewList = new ArrayList<DeployModelObject>();
	private final List<EditPart> canExecuteRevealEditpartList = new ArrayList<EditPart>();
	private final List<Diagram> canExecuteCreateDiagramList = new ArrayList<Diagram>();
	private final Map<Object, Boolean> canExecuteEvaluationCache = new HashMap<Object, Boolean>();
	static private final Map<Object, IFile> _substituteImportFile = new HashMap<Object, IFile>();

	private final DropObjectsRequest dropRequest;
	private final IGraphicalEditPart editPart;
	private IUndoableOperation lastOperation = null;
	private final List<View> lastCreatedViews = new ArrayList<View>();

	private final org.eclipse.swt.graphics.Point reference;

	public static final String TARGETEP = "TARGETEP"; //$NON-NLS-1$

	private boolean _canExecute = true;
	private boolean _processed = false;

	/**
	 * @param dropRequest
	 * @param editPart
	 * @param point
	 */
	public AddToTopologyCommand(DropObjectsRequest dropRequest, IGraphicalEditPart editPart,
			org.eclipse.swt.graphics.Point point) {
		super(editPart, Messages.ADD_TO_TOPOLOGY, false);
		this.dropRequest = dropRequest;
		this.editPart = editPart;
		//setLabel(Messages.ADD_TO_TOPOLOGY);
		reference = point;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		if (_processed) {
			return _canExecute;
		}

		if (dropRequest.getObjects().size() == 0) {
			_canExecute = false;
			return false;
		}

		EObject eObject = editPart.resolveSemanticElement();
		if (!(eObject instanceof Topology)) {
			_canExecute = false;
			return false;
		}
		Topology topology = (Topology) eObject;
		canExecuteCreateViewList.clear();
		canExecuteRevealEditpartList.clear();

		// support DnD diagrams
		canExecuteCreateDiagramList.clear();
		Object part = ResourceUtils.getActiveEditorPart();
		DeployCoreEditor editor = null;
		if (part instanceof DeployCoreEditor) {
			editor = (DeployCoreEditor) part;
		}
		Diagram thisDiagram = (Diagram) getHost().getNotationView();

		List objects = dropRequest.getObjects();
		Object object = null;
		for (int x = 0; x < objects.size(); ++x) {
			object = objects.get(x);

			//////////////////////////////////////////////////////////////////////////////////////
			/////////////////// VISUALIZE UNITS //////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////
			// if topology already contains this unit but there's no view for it in this diagram
			// we will allow it
			if (object instanceof Unit && topology.getUnits().contains(object)) {
				IGraphicalEditPart targetEP = getTargetEditPart(dropRequest);
				EditPart ep = getChildEditPart(targetEP.getChildren(), object);
				if (ep == null) {
					canExecuteCreateViewList.add((Unit) object);
				} else {
					canExecuteRevealEditpartList.add(ep);
				}
				continue;
			}

			//////////////////////////////////////////////////////////////////////////////////////
			/////////////////// VISUALIZE DIAGRAM & IMPORT DIAGRAM //////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////
			// if a file, see if it's a topologyv file that has a diagram that has the same topology as this diagram's
			// we will allow it
			IFile file = null;
			if (object instanceof IFile) {
				file = (IFile) object;
			} else if (object instanceof IAdaptable) {
				file = (IFile) ((IAdaptable) object).getAdapter(IFile.class);
			}
			if (file != null && file.getFileExtension() != null
					&& file.getFileExtension().compareToIgnoreCase(IConstants.TOPOLOGYV_EXTENSION) == 0) {
				if (editor != null) {
					Resource resource = editor.getSaveable().getScribbler().getResource(
							file.getFullPath());
					if (resource != null && resource.getContents().size() > 0) {
						List contents = resource.getContents();
						Diagram diagram = (Diagram) contents.get(0);
						// don't add diagram on top of itself, make sure it's from same topology,
						//  and make sure it isn't already in the diagram
						if (diagram != thisDiagram) {
							boolean isProcessed = true;
							EditPart ep = getChildEditPart(getHost().getChildren(), object);
							if (ep == null) {
								canExecuteCreateDiagramList.add(diagram);

								// do we need to import a topology?
								if (diagram.getElement() != topology) {
									// if this diagram's topology hasn't been imported, substitute import file for diagram file
									Topology importTopology = (Topology) diagram.getElement();
									if (topology.getImport(importTopology.getNamespace(), importTopology
											.getName()) == null) {
										isProcessed = false;
										IFile importFile = _substituteImportFile.get(object);
										if (importFile == null) {
											importFile = WorkbenchResourceHelper.getFile(importTopology);
											_substituteImportFile.put(object, importFile);
										}
										object = importFile;
									}
								}
							} else {
								canExecuteRevealEditpartList.add(ep);
							}
							if (isProcessed) {
								continue;
							}
						}
					}
				}
			}

			//////////////////////////////////////////////////////////////////////////////////////
			/////////////////// VISUALIZE IMPORT //////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////
			// visualizing import object from this topology
			if (object instanceof Import && ((Import) object).getTopology() == topology) {
				EditPart ep = getChildEditPart(getHost().getChildren(), object);
				if (ep == null) {
					canExecuteCreateViewList.add((DeployModelObject) object);
				} else {
					canExecuteRevealEditpartList.add(ep);
				}
				continue;
			}

			// visualizing import topology file
			if (object instanceof IFile
					&& ((IFile) object).getFileExtension().compareToIgnoreCase(
							IConstants.TOPOLOGY_EXTENSION) == 0) {
				file = (IFile) object;
				if (editor != null) {
					Resource resource = editor.getSaveable().getScribbler().getResource(
							file.getFullPath());
					if (resource != null && resource.getContents().size() > 0) {
						EObject rootModelObject = resource.getContents().get(0);
						if (rootModelObject instanceof DeployCoreRoot) {
							Topology importTopology = ((DeployCoreRoot) rootModelObject).getTopology();
							Import imprt = topology.getImport(importTopology.getNamespace(),
									importTopology.getName());
							if (imprt != null) {
								EditPart ep = getChildEditPart(getHost().getChildren(), object);
								if (ep == null) {
									canExecuteCreateViewList.add(imprt);
								} else {
									canExecuteRevealEditpartList.add(ep);
								}
								continue;
							}
						}
					}
				}
			}

			//////////////////////////////////////////////////////////////////////////////////////
			/////////////////// IMPORT TOPOLOGY//////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////

			// else it might be a unit for creation or a topology file for import
			//To avoid the continuous checking against the same object the 
			// DeployDropListener should only access the addToTopology.canExecute()
			// once and cache the boolean.
			if (canExecuteEvaluationCache.containsKey(object)) {
				_canExecute = canExecuteEvaluationCache.get(object).booleanValue();
				return _canExecute;
			}
			String decoratorSemantic = topology.getDecoratorSemantic();
			if (decoratorSemantic == null) {
				if (UnitLifeCycleManager.INSTANCE.findEnabledTopologyUnitProvidersByInputOnly(object).length == 0) {
					canExecuteEvaluationCache.put(object, Boolean.FALSE);
					_canExecute = false;
					return false;
				}
			} else if (UnitLifeCycleManager.INSTANCE.findEnabledTopologyUnitProvidersByInputOnly(
					object, decoratorSemantic).length == 0) {
				canExecuteEvaluationCache.put(object, Boolean.FALSE);
				_canExecute = false;
				return false;
			}
			canExecuteEvaluationCache.put(object, Boolean.TRUE);

		}
		_canExecute = true;
		_processed = true;
		return true;

	}

	public CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		Topology topology = (Topology) editPart.resolveSemanticElement();
		final ChangeScope<Topology, DeploymentTopologyDomain> scope = ChangeScope
				.createChangeScopeForWrite(topology);
		try {

			lastOperation = new AbstractTransactionalCommand(scope.getTransactionalEditingDomain(),
					getLabel(), null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {

					ChangeScope<Topology, DeploymentTopologyDomain> scope = ChangeScope
							.findChangeScope(info);

					// get target editpart
					IGraphicalEditPart targetEP = getTargetEditPart(dropRequest);

					if (canExecuteEvaluationCache.size() > 0) {
						executeImportCommand(scope, targetEP, monitor);
					}
					if (canExecuteCreateViewList.size() > 0) {
						executeVisualizeCommand(scope, targetEP, monitor);
					}
					if (canExecuteCreateDiagramList.size() > 0) {
						executeDiagramCommand(scope, targetEP, monitor);
					}
					if (canExecuteRevealEditpartList.size() > 0) {
						executeRevealCommand(scope, targetEP, monitor);
					}

					return null;
				}

			};

			DeployCoreUIPlugin.executeFromNestedContextWithProgress(lastOperation, scope, false,
					ResourcesPlugin.getWorkspace().getRoot());

		} finally {
			canExecuteEvaluationCache.clear();
			if (scope != null) {
				DeployCoreUIPlugin.runWithProgress(new IRunnableWithProgress() {
					public void run(IProgressMonitor monitor) {
						scope.close(monitor);

					}
				}, false);
			}
		}
		return null;

	}

	private IGraphicalEditPart getTargetEditPart(DropObjectsRequest dropRequest2) {
		IGraphicalEditPart targetEP = (IGraphicalEditPart) dropRequest.getExtendedData()
				.get(TARGETEP);
		if (targetEP == null) {
			targetEP = getHost();
		}
		return targetEP;
	}

	public void undo() {
		if (lastOperation != null) {
			DeployCoreUIPlugin.undoWithProgress(lastOperation, null);
		}
		// delete any views created by the last operation
		if (lastCreatedViews.size() > 0) {
			Map options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
			AbstractEMFOperation operation = new DeployTransactionalCommand(getHost(),
					StringStatics.BLANK, options, true) {

				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
					for (Iterator<View> it = lastCreatedViews.iterator(); it.hasNext();) {
						ViewUtil.destroy(it.next());
					}
					return null;
				}
			};
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
			}
			lastCreatedViews.clear();
		}
	}

	private void executeImportCommand(ChangeScope<Topology, DeploymentTopologyDomain> scope,
			final IGraphicalEditPart targetEP, final IProgressMonitor monitor) {

		boolean isObjectCreateSuccess = false;
		try {
			Topology topology = scope.openTopology();

			checkCancelled(monitor);
			monitor.beginTask(Messages.AddToTopologyCommand_Importing_artifacts_, 20);

			checkCancelled(monitor);
			final Set<TopologyUnitStub> stubs = resolveStubs(targetEP, scope, DeployCoreUIPlugin
					.subprogress(monitor, 5));

			checkCancelled(monitor);
			ChangeDescription changeDescription = null;
			ChangeRecorder recorder = new ChangeRecorder(topology);
			try {
				recorder.beginRecording(Collections.singleton(topology));

				SynchronizationDatamodel datamodel = SynchronizationDatamodel.createModel();
				datamodel.setStubs(stubs.toArray(new TopologyUnitStub[stubs.size()]));
				datamodel.setTopology(topology);
				SynchronizationRefactoring refactor = new SynchronizationRefactoring(
						new ImportRefactoringProcessor(datamodel));

				checkCancelled(monitor);

				RefactoringStatus checkInitialConditions = refactor
						.checkInitialConditions(DeployCoreUIPlugin.subprogress(monitor, 1));
				if (checkInitialConditions.isOK()) {

					checkCancelled(monitor);

					RefactoringStatus checkFinalConditions = refactor
							.checkFinalConditions(DeployCoreUIPlugin.subprogress(monitor, 1));
					if (checkFinalConditions.isOK()) {
						final PerformChangeOperation makeChanges = new PerformChangeOperation(
								new CreateChangeOperation(refactor));

						// stop canonical refreshes on changes to topology
						CanonicalUtils.pauseSemanticCacheRefresh((DeployDiagramEditPart) editPart);

						checkCancelled(monitor);

						// add new objects to topology
						makeChanges.run(DeployCoreUIPlugin.subprogress(monitor, 10));
						changeDescription = recorder.endRecording();

						checkCancelled(monitor);

						//resume canonical refreshes on changes to topology
						CanonicalUtils.resumeSemanticCacheRefresh((DeployDiagramEditPart) editPart);
					} else {
						warnUser(checkFinalConditions);
					}
				} else {
					warnUser(checkInitialConditions); // $NON-NLS-1$
					return;
				}
			} catch (CoreException e) {
				warnUser(DeployCoreUIPlugin.createErrorStatus(0,
						Messages.AddToTopologyCommand_Could_not_safely_execute_changes_, e));
			} finally {
				if (recorder != null) {
					recorder.dispose();
				}
			}

			if (changeDescription == null) {
				warnUser(DeployCoreUIPlugin.createErrorStatus(0,
						Messages.AddToTopologyCommand_No_changes_were_made_to_the_model_, null));
				return;
			}

			checkCancelled(monitor);

			// get any new objects added to the topology
			final List<EObject> newObjects = getNewObjects(changeDescription.getObjectChanges());

			// if creating any diagrams, don't add views for import objects
			if (_substituteImportFile.size() > 0) {
				_substituteImportFile.clear();
				List<EObject> removeImports = new ArrayList<EObject>();
				for (Iterator<EObject> it = newObjects.iterator(); it.hasNext();) {
					EObject eo = it.next();
					if (eo instanceof Import) {
						removeImports.add(eo);
					}
				}
				newObjects.removeAll(removeImports);
				if (newObjects.size() == 0) {
					return;
				}
			}

			// update their names if necessary
			IProgressMonitor assigningNamesProgress = DeployCoreUIPlugin.subprogress(monitor, 1);
			assigningNamesProgress.beginTask(Messages.AddToTopologyCommand_Assigning_unique_names_,
					newObjects.size());
			assigningNamesProgress.subTask(""); //$NON-NLS-1$

			checkCancelled(monitor);

			for (Iterator<EObject> iterator = newObjects.iterator(); iterator.hasNext();) {
				EObject newObject = iterator.next();
				// some changes are object removals, in which case the topology is null
				if (newObject instanceof DeployModelObject) {
					DeployModelObject dmo = (DeployModelObject) newObject;
					if (dmo.getTopology() != null) {
						assigningNamesProgress.subTask(UnitUtil.assignUniqueName(dmo));
					}
				}
				assigningNamesProgress.worked(1);

				checkCancelled(monitor);
			}
			assigningNamesProgress.done();
			isObjectCreateSuccess = true;

			// create views
			createAddViewsCommandDelayed(newObjects, targetEP, monitor);

		} finally {
			if (!isObjectCreateSuccess) {
				monitor.done();
			}
		}
	}

	private void executeVisualizeCommand(ChangeScope<Topology, DeploymentTopologyDomain> scope,
			final IGraphicalEditPart targetEP, final IProgressMonitor monitor) {
		try {
			checkCancelled(monitor);
			monitor.beginTask(Messages.AddToTopologyCommand_Creating_views_for_existing_topolog_, 100);
			checkCancelled(monitor);

			// suppliment unit list with non-config hosted units
			//		addHostedUnits(targetEP, scope.getTarget(), canExecuteCreateViewList);

			// create views
			createAddViewsCommandDelayed(canExecuteCreateViewList, targetEP, monitor);

		} finally {
			monitor.done();
		}
	}

	private void addHostedUnits(IGraphicalEditPart ep, Topology topology,
			List<DeployModelObject> list) {
		List<HostingLink> hostingLinks = new ArrayList<HostingLink>();
		for (Iterator<HostingLink> it = topology.findAllHostingLinks(); it.hasNext();) {
			hostingLinks.add(it.next());
		}

		Set<Unit> hostSet = new HashSet<Unit>();
		for (Iterator<DeployModelObject> it = list.iterator(); it.hasNext();) {
			DeployModelObject dmo = it.next();
			if (dmo instanceof Unit) {
				addHostedUnitsHelper(ep, (Unit) dmo, hostingLinks, hostSet);
			}
		}

		// add only units that aren't already in the diagram
		for (Iterator<Unit> it = hostSet.iterator(); it.hasNext();) {
			Unit unit = it.next();
			if (GMFUtils.getEditPartsFor(ep, unit).size() == 0) {
				list.add(unit);
			}
		}
	}

	private void addHostedUnitsHelper(IGraphicalEditPart ep, Unit unit,
			List<HostingLink> hostingLinks, Set<Unit> hostSet) {
		if (!unit.isConfigurationUnit()) {
			for (Iterator<HostingLink> it = hostingLinks.iterator(); it.hasNext();) {
				HostingLink link = it.next();
				// stop adding stack when we get to a view that is already in the diagram
				if (link.getHost() == unit
						&& GMFUtils.getEditPartsFor(ep, link.getHosted()).size() == 0) {
					hostSet.add(link.getHosted());
					addHostedUnitsHelper(ep, link.getHosted(), hostingLinks, hostSet);
				}
			}
		}
	}

	private void executeRevealCommand(ChangeScope<Topology, DeploymentTopologyDomain> scope,
			final IGraphicalEditPart targetEP, final IProgressMonitor monitor) {
		try {
			checkCancelled(monitor);
			monitor.beginTask(Messages.AddToTopologyCommand_Creating_views_for_existing_topolog_, 100);
			checkCancelled(monitor);

			// now create the views for these new objects and lay them out in a UI thread
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					// select the existing eps
					editPart.getViewer().setSelection(
							new StructuredSelection(canExecuteRevealEditpartList));

					// if just one ep, reveal it
					if (canExecuteRevealEditpartList.size() == 1) {
						editPart.getViewer().reveal(canExecuteRevealEditpartList.get(0));
					}
				}
			});

		} finally {
			monitor.done();
		}
	}

	private void checkCancelled(IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

	}

	/*
	 * asynchronously perform createAddViewsCommand
	 */
	private void createAddViewsCommandDelayed(final List newObjects,
			final IGraphicalEditPart targetEP, final IProgressMonitor monitor) {

		// remove members of new objects
		EObject eObject = editPart.resolveSemanticElement();
		if (eObject instanceof Topology) {
			Topology topology = (Topology) eObject;
			IRelationshipChecker relations = topology.getRelationships();

			List<Unit> allMembers = new ArrayList<Unit>();
			for (Iterator iterator = newObjects.iterator(); iterator.hasNext();) {
				Object object = iterator.next();
				if (object instanceof Unit) {
					Unit unit = (Unit) object;
					Collection<Unit> members = relations.getMembers(unit);
					if (!members.contains(unit)) {
						allMembers.addAll(members);
					}
				}
			}
			newObjects.removeAll(allMembers);

		}

		Runnable runnable = new Runnable() {
			public void run() {
				try {
					Point pt = dropRequest.getLocation().getCopy();
					IFigure container = getHost().getContentPane();
					container.translateToRelative(pt);
					container.translateFromParent(pt);
					pt.translate(container.getClientArea().getLocation().getNegated());
					VisualizeFromSemanticCommand visualizeCmd = new VisualizeFromSemanticCommand(
							getHost().getEditingDomain(), targetEP, newObjects, lastCreatedViews, pt);
					visualizeCmd.execute(monitor, null);
				} catch (ExecutionException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				} finally {
					monitor.done();
				}
			}
		};

		if (Display.getCurrent() == null) {
			// now create the views for these new objects and lay them out in a UI thread
			Display.getDefault().syncExec(runnable);
		} else {
			runnable.run();
		}

	}

	// extract any new objects from chnage description
	private List<EObject> getNewObjects(EMap objectChanges) {
		List<EObject> list = new ArrayList<EObject>();
		for (Iterator iter = objectChanges.iterator(); iter.hasNext();) {
			Map.Entry mapEntry = (Map.Entry) iter.next();
			EObject eObject = (EObject) mapEntry.getKey();
			for (Iterator featureChangeIter = ((List) mapEntry.getValue()).iterator(); featureChangeIter
					.hasNext();) {
				FeatureChange fc = (FeatureChange) featureChangeIter.next();
				if (fc.isSet()) {
					EStructuralFeature feature = fc.getFeature();
					if (feature.isMany()) {
						EList newList = new BasicEList((EList) eObject.eGet(feature));
						EList oldList = (EList) fc.getValue();
						newList.removeAll(oldList);
						for (Iterator it = newList.iterator(); it.hasNext();) {
							Object o = it.next();
							if (o instanceof Import) {
								list.add((EObject) o);
							} else if (o instanceof BasicFeatureMapEntry) {
								BasicFeatureMapEntry entry = (BasicFeatureMapEntry) o;
								list.add((EObject) entry.getValue());
							}
						}
					}
				} else {
					EStructuralFeature feature = fc.getFeature();
					Object o1 = eObject.eGet(feature);
					if (o1 instanceof EList) {
						EList newList = new BasicEList((EList) o1);
						EList oldList = (EList) fc.getValue();
						newList.removeAll(oldList);
						for (Iterator it = newList.iterator(); it.hasNext();) {
							Object o = it.next();
							if (o instanceof Import) {
								list.add((EObject) o);
							} else if (o instanceof BasicFeatureMapEntry) {
								BasicFeatureMapEntry entry = (BasicFeatureMapEntry) o;
								list.add((EObject) entry.getValue());
							}
						}
					} else if (o1 instanceof EObject) {
						list.add((EObject) o1);
					}
				}
			}
		}
		return list;
	}

	private void executeDiagramCommand(ChangeScope<Topology, DeploymentTopologyDomain> scope,
			final IGraphicalEditPart targetEP, final IProgressMonitor monitor) {
		try {
			checkCancelled(monitor);
			monitor.beginTask(Messages.AddToTopologyCommand_Creating_views_for_existing_topolog_, 100);
			checkCancelled(monitor);

			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
						public void run() {
							try {
								createDiagramViewCommand(targetEP, monitor).execute(monitor, null);
							} catch (ExecutionException e) {
								DeployCoreUIPlugin.logError(0, e.getMessage(), e);
							} finally {
								monitor.done();
							}
						}
					});
				}
			});

		} finally {
			monitor.done();
		}
	}

	private ICommand createDiagramViewCommand(final IGraphicalEditPart targetEP,
			final IProgressMonitor monitor) {

		return new AbstractTransactionalCommand(getHost().getEditingDomain(), "", null) { //$NON-NLS-1$
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
					IAdaptable info) {

				// create the diagram views
				monitor.subTask("Creating diagrams"); //$NON-NLS-1$

				// get drop location
				Point pt = dropRequest.getLocation().getCopy();
				pt.x -= 10;
				pt.y -= 5;

				// convert to diagram
				IFigure container = getHost().getContentPane();
				container.translateToRelative(pt);
				container.translateFromParent(pt);
				pt.translate(container.getClientArea().getLocation().getNegated());

				// for each diagram, create a diagramnode view and stuff the Diagram into the DiagramLinkStyle
				Topology topology = (Topology) editPart.resolveSemanticElement();
				List<View> newDiagramNodes = new ArrayList<View>();
				List<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
				for (Iterator<Diagram> it = canExecuteCreateDiagramList.iterator(); it.hasNext();) {
					Diagram diagram = it.next();
					EObject eo = diagram;
					boolean isImportDiagram = false;
					String hint = DeployCoreConstants.DIAGRAMNODEVIEW_SEMANTICHINT;

					// if this diagram's topology is not the same as the edit topology, this is an Import Diagram
					if (!diagram.getElement().equals(topology)) {
						Topology importTopology = (Topology) diagram.getElement();
						eo = topology.getImport(importTopology.getNamespace(), importTopology.getName());
						// if import doesn't exist/wasn't created, don't create a view
						if (eo == null) {
							continue;
						}
						hint = ""; //$NON-NLS-1$
						isImportDiagram = true;
					}

					// create descriptor and then view
					CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(
							new EObjectAdapter(eo), Node.class, hint, getHost()
									.getDiagramPreferencesHint());
					viewDescriptors.add(viewDescriptor);
					View newView = ViewService.getInstance().createView(viewDescriptor.getViewKind(),
							viewDescriptor.getElementAdapter(), targetEP.getNotationView(),
							viewDescriptor.getSemanticHint(), viewDescriptor.getIndex(),
							viewDescriptor.isPersisted(), viewDescriptor.getPreferencesHint());

					// remember for undo
					lastCreatedViews.add(newView);

					// if this is an import diagram, add a link to the diagram
					if (isImportDiagram) {
						DiagramLinkStyle style = (DiagramLinkStyle) newView
								.getStyle(NotationPackage.eINSTANCE.getDiagramLinkStyle());
						style.setDiagramLink(diagram);
					}

					newDiagramNodes.add(newView);
					viewDescriptor.setView(newView);
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(
							newView, NotationPackage.eINSTANCE.getLocation_X(), new Integer(pt.x));
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(
							newView, NotationPackage.eINSTANCE.getLocation_Y(), new Integer(pt.y));
				}

				// add all diagram editparts
				targetEP.refresh();
				for (Iterator<View> it = newDiagramNodes.iterator(); it.hasNext();) {
					View view = it.next();
					CanonicalUtils.refresh((IGraphicalEditPart) getHost().getViewer()
							.getEditPartRegistry().get(view), true);
				}

				// layout the addition
				DeployDeferredLayoutCommand arrangeCommand = new DeployDeferredLayoutCommand(editPart
						.getEditingDomain(), viewDescriptors, editPart, null, null, false, false);
				if (arrangeCommand.canExecute()) {
					try {
						arrangeCommand.execute(new NullProgressMonitor(), null);
					} catch (ExecutionException e) {
						DeployCoreUIPlugin.logError(0, "Could not arrange", null); //$NON-NLS-1$
					}
				}

				monitor.subTask(""); //$NON-NLS-1$
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private void warnUser(final IStatus status) {
		DeployCoreUIPlugin.log(status);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog warning = new ReportStatusDialog(Display.getDefault().getActiveShell(),
						Messages.AddToTopologyCommand_Problem_importing_resource_,
						Messages.AddToTopologyCommand_Problems_were_encountered_while_per_, status);
				warning.open();

			}
		});

	}

	private void warnUser(RefactoringStatus status) {

		RefactoringStatusEntry[] entries = status.getEntries();

		RefactoringStatusEntry highestSeverityEntry = status.getEntryWithHighestSeverity();
		IStatus highestSeverity = highestSeverityEntry.toStatus();
		final MultiStatus warningStatus = new MultiStatus(highestSeverity.getPlugin(),
				highestSeverity.getCode(), highestSeverity.getMessage(), highestSeverity.getException());
		for (int i = 0; i < entries.length; i++) {
			warningStatus.add(entries[i].toStatus());
		}

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog warning = new ReportStatusDialog(Display.getDefault().getActiveShell(),
						Messages.AddToTopologyCommand_Problem_importing_resource_,
						Messages.AddToTopologyCommand_Problems_were_encountered_while_per_, warningStatus);
				warning.open();

			}
		});

		DeployCoreUIPlugin.log(warningStatus);
	}

	private IGraphicalEditPart getHost() {
		return editPart;
	}

	/**
	 * @param droppedObjects
	 * @param dropObject
	 * @param monitor
	 * @return list of units
	 */
	private Set<TopologyUnitStub> resolveStubs(final IGraphicalEditPart targetEP,
			final ChangeScope<Topology, DeploymentTopologyDomain> scope, IProgressMonitor monitor) {

		try {
			monitor.beginTask(Messages.AddToTopologyCommand_Resolving_the_model_elements_, 11);

			final Set<TopologyUnitStub> dropChanges = new HashSet<TopologyUnitStub>();
			Object dropObject = null;
			for (Iterator droppedObjects = dropRequest.getObjects().iterator(); droppedObjects
					.hasNext();) {
				dropObject = droppedObjects.next();

				// if they drag in a topologyv file from another topology we import the topology file instead
				if (_substituteImportFile.containsKey(dropObject)) {
					dropObject = _substituteImportFile.get(dropObject);
				}

				monitor.subTask(Messages.AddToTopologyCommand_Resolving_dropped_object_);
				EObject resolvedSemanticElement = targetEP.resolveSemanticElement();
				DeployModelObject dropTarget = null;
				if (resolvedSemanticElement instanceof DeployModelObject) {
					dropTarget = (DeployModelObject) resolvedSemanticElement;
				} else {
					DeployCoreUIPlugin
							.logError(
									0,
									"The semantic element of the target element (\"" + resolvedSemanticElement.eClass().getName() + //$NON-NLS-1$  
											"\") is not a subtype of DeployModelObject.", null); //$NON-NLS-1$
				}
				monitor.worked(1);

				monitor.subTask(Messages.AddToTopologyCommand_Finding_model_providers_);
				String decoratorSemantic = scope.openTopology().getDecoratorSemantic();
				UnitProvider[] unitProviders = DeployCoreUIPlugin.getDefault().getUnitProviderService()
						.findEnabledProvidersByInputOnly(dropObject, decoratorSemantic);
				monitor.subTask(""); //$NON-NLS-1$ 
				monitor.worked(1);

				final Set<TopologyUnitStub> resolvedStubsForDroppedObject = resolveStubsForDroppedObject(
						scope, dropObject, dropTarget, unitProviders, DeployCoreUIPlugin.subprogress(
								monitor, 3));

				if (resolvedStubsForDroppedObject.size() > 1) {
					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							Shell shell = targetEP.getViewer().getControl().getShell();

							final SelectChangeQuickDialog quickDialog = new SelectChangeQuickDialog<TopologyUnitStub>(
									new Shell(shell, SWT.RESIZE), reference, resolvedStubsForDroppedObject,
									new TopologyUnitStubLabelProvider());
							quickDialog.open();
							dropChanges.addAll(quickDialog.getSelectedOptions());
						}
					});
				} else {
					dropChanges.addAll(resolvedStubsForDroppedObject);
				}
			}

			// Check for existing instances in topology
			List existingUnitsToVisualize = new ArrayList();
			for (Iterator iter = dropChanges.iterator(); iter.hasNext();) {
				boolean reuseExisting = false;
				TopologyUnitStub stub = (TopologyUnitStub) iter.next();
				Topology top = stub.getTopology();
				UnitProvider provider = stub.getSource();
				Unit existingUnit = provider.resolveExistingInstance(top, stub);
				if (existingUnit != null) {
					String message = NLS.bind(
							Messages.AddToTopologyCommand_Existing_Instance_0_Dlg_Text, existingUnit
									.getDisplayName(), null);

					IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
					String pref = store.getString(IDeployPreferences.DEPLOY_REUSE_EXISTING_INSTANCES);
					if (pref != null && pref.equals(Messages.DeployCoreMainPreferencePage_promp_)) {
						MessageDialogWithToggle dlg = MessageDialogWithToggle.openYesNoQuestion(Display
								.getCurrent().getActiveShell(),
								Messages.AddToTopologyCommand_Existing_Instance_Dlg_Title, message, null,
								false, store, IDeployPreferences.DEPLOY_REUSE_EXISTING_INSTANCES);
						if (dlg.getReturnCode() == IDialogConstants.YES_ID) {
							reuseExisting = true;
						}
					} else if (pref != null && pref.equals(MessageDialogWithToggle.ALWAYS)) {
						reuseExisting = true;
					}
					if (reuseExisting) {
						// Drop stub
						iter.remove();
						if (GMFUtils.getEditPartsFor(targetEP, existingUnit).size() == 0) {
							existingUnitsToVisualize.add(existingUnit);
						}
						// Visualize/host as needed if drop target is a unit
						else if (stub.getDropTarget() instanceof Unit) {
							existingUnitsToVisualize.add(existingUnit);
						}
					}
				}
			}
			// visualize existing unit (if necessary)
			if (existingUnitsToVisualize.size() > 0) {
				canExecuteCreateViewList.addAll(existingUnitsToVisualize);
			}

			return dropChanges;

		} finally {
			monitor.done();
		}
	}

	private Set<TopologyUnitStub> resolveStubsForDroppedObject(
			ChangeScope<Topology, DeploymentTopologyDomain> scope, Object dropObject,
			DeployModelObject dropTarget, UnitProvider[] unitProviders, IProgressMonitor monitor) {
		monitor.beginTask(Messages.AddToTopologyCommand_Resolving_stubs_, unitProviders.length);

		Set<TopologyUnitStub> cache = new HashSet<TopologyUnitStub>();
		for (int x = 0; x < unitProviders.length; ++x) {

			TopologyUnitStub[] topologyUnitStubs = unitProviders[x].resolveStubs(dropObject);

			if (topologyUnitStubs != null) {
				for (int y = 0; y < topologyUnitStubs.length; ++y) {
					monitor.subTask(topologyUnitStubs[y].getName());
					topologyUnitStubs[y].setTopology(scope.openTopology());
					topologyUnitStubs[y].setSource(unitProviders[x]);
					topologyUnitStubs[y].setDropTarget(dropTarget);
				}
				cache.addAll(Arrays.asList(topologyUnitStubs));
			}
			monitor.worked(1);
		}
		monitor.done();

		return cache;
	}

	/**
	 * @param targetEP
	 * @param objects
	 * @return do any of these objects already have a view in this container?
	 */
	public static boolean containsAnyUnit(IGraphicalEditPart targetEP, List<?> objects) {
		if (targetEP != null) {
			if (targetEP.getParent() instanceof DeployShapeNodeEditPart) {
				if (objects.contains(((DeployShapeNodeEditPart) targetEP.getParent())
						.resolveSemanticElement())) {
					return true;
				}
			}
			for (Iterator<?> it = objects.iterator(); it.hasNext();) {
				Object o = it.next();
				if (getChildEditPart(targetEP.getChildren(), o) != null) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param targetEP
	 * @param objects
	 * @return are any of these units contained?
	 */
	public static boolean isAnyUnitShowOnHost(IGraphicalEditPart targetEP, List<?> objects) {
		if (targetEP != null) {
			for (Iterator<?> it = objects.iterator(); it.hasNext();) {
				Object o = it.next();
				if (o instanceof Unit && ContainmentStateUtils.isShowOnHost(targetEP, (Unit) o)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param children
	 * @param eo
	 * @return return child that is a view to this object
	 */
	public static EditPart getChildEditPart(List<?> children, Object eo) {
		Iterator<?> it = children.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) o;
				if (eo == ViewUtil.resolveSemanticElement((View) ep.getModel())) {
					return ep;
				}
			} else if (o instanceof DiagramNodeEditPart) {
				DiagramNodeEditPart ep = (DiagramNodeEditPart) o;
				if (eo == ViewUtil.resolveSemanticElement((View) ep.getModel())) {
					return ep;
				}
			} else if (o instanceof ImportTopologyEditPart) {
				ImportTopologyEditPart ep = (ImportTopologyEditPart) o;
				if (eo == ep.getImportDiagram()) {
					return ep;
				}
			}
		}
		return null;
	}

}
