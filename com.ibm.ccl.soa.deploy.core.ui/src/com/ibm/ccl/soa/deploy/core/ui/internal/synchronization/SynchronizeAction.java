/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.synchronization;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;
import com.ibm.ccl.soa.deploy.core.internal.synchronization.ImplementationRefactoringProcessor;
import com.ibm.ccl.soa.deploy.core.internal.synchronization.ReflectionRefactoringProcessor;
import com.ibm.ccl.soa.deploy.core.internal.synchronization.SynchronizationRefactoring;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * An action which opens the RefactorWizard to allow a user to choose units to synchronize.
 */
public class SynchronizeAction extends Action implements IAction {

	/**
	 * Typesafe Enumeration to indicates the direction the action should follow.
	 * 
	 */
	public static class Direction {

		/**
		 * Indicate that the Synchronization should occur from the world to the model.
		 */
		public static final int FROM_WORLD_TO_MODEL = -1;

		/**
		 * Indicate that the Synchronization should occur from the model to the world.
		 */
		public static final int FROM_MODEL_TO_WORLD = 1;

		/**
		 * Indicate that the Synchronization should occur from the world to the model.
		 */
		public static final Direction WorldToModel = new Direction(FROM_WORLD_TO_MODEL);

		/**
		 * Indicate that the Synchronization should occur from the model to the world.
		 */
		public static final Direction ModelToWorld = new Direction(FROM_MODEL_TO_WORLD);

		private int value;

		private Direction(int which) {
			value = which;
		}

		/**
		 * @return One of {@link #FROM_MODEL_TO_WORLD} or {@link #FROM_WORLD_TO_MODEL}
		 */
		public int getValue() {
			return value;
		}
	}

	private Shell shell;
	private ISelectionProvider selectionProvider;
	private Direction direction;

	/**
	 * Create a synchronize action with the given shell and selection provider.
	 * 
	 * @param shell
	 *           The shell to use as the parent of any dialogs opened by this action.
	 * @param selProvider
	 *           A selection provider to use to seed any widgets in the opened dialogs.
	 * @param which
	 *           Indicate the direction the action should follow when executed.
	 */
	public SynchronizeAction(Shell shell, ISelectionProvider selProvider, Direction which) {
		Assert.isNotNull(shell);
		Assert.isNotNull(selProvider);

		this.shell = shell;
		this.selectionProvider = selProvider;
		this.direction = which;

		ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();

		switch (direction.getValue())
		{
		case Direction.FROM_MODEL_TO_WORLD:
			setAccelerator(SWT.SHIFT | SWT.F5);
			setText(Messages.SynchronizeAction_From_Model_to_Workspac_);
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_ACTN_SYNCHRONIZE_TO_WORLD));
			break;
		case Direction.FROM_WORLD_TO_MODEL:
			setAccelerator(SWT.CONTROL | SWT.F5);
			setText(Messages.SynchronizeAction_From_Workspace_to_Mode_);

			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_ACTN_SYNCHRONIZE_TO_MODEL));
			break;
		}

		direction = which;
	}

	public void run() {

		ISelection selection = selectionProvider.getSelection();
		if (selection instanceof IStructuredSelection) {

			IStructuredSelection sSel = (IStructuredSelection) selection;
			Topology topology = null;
			List<Unit> collection = new ArrayList<Unit>();
			Object[] selectedEditParts = sSel.toArray();
			for (int i = 0; i < selectedEditParts.length; i++) {
				if (selectedEditParts[i] instanceof EditPart) {
					EObject modelElement = ViewUtil
							.resolveSemanticElement((View) ((EditPart) selectedEditParts[i]).getModel());
					if (modelElement instanceof Unit) {
						collection.add((Unit) modelElement);
					} else if (modelElement instanceof Topology) {
						topology = (Topology) modelElement;
					}
				}
			}
			if (collection.size() > 0 && topology == null) {
				topology = collection.get(0).getEditTopology();
			}

			SynchronizationDatamodel datamodel = SynchronizationDatamodel.createModel();
			datamodel.setTopology(topology);
			datamodel.setComponents(collection.toArray(new Unit[collection.size()]));

			RefactoringProcessor processor = null;
			switch (direction.getValue())
			{
			case Direction.FROM_MODEL_TO_WORLD:
				processor = new ImplementationRefactoringProcessor(datamodel);
				break;
			case Direction.FROM_WORLD_TO_MODEL:
				processor = new ReflectionRefactoringProcessor(datamodel);
				break;
			}

			SynchronizationRefactoring refactoring = new SynchronizationRefactoring(processor);
			SynchronizationRefactoringWizard wizard = new SynchronizationRefactoringWizard(
					refactoring, datamodel);
			RefactoringWizardOpenOperation open = new RefactoringWizardOpenOperation(wizard);

			try {
				open.run(shell, Messages.SynchronizeAction_Implement_Component_);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
