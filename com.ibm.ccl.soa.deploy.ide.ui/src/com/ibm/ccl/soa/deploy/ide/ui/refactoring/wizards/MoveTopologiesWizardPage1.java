package com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePathViewerSorter;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.NewNamespaceDialog;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.NamespaceElementContentProvider;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.NamespaceElementLabelProvider;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.MoveTopologyParticipant;
import com.ibm.ccl.soa.deploy.ide.ui.refactoring.Messages;

public class MoveTopologiesWizardPage1 extends UserInputWizardPage {

	public static final String PAGE_NAME = "MoveTopologiesWizardPage1";//$NON-NLS-1$

//	private Label namespaceLabel = null;
//	private Text namespaceText = null;
//	private Button namespaceButton = null;

	private Tree sourceFolderTree;
	private TreeViewer sourceFolderTreeViewer = null;

	public MoveTopologiesWizardPage1(String pageName) {
		super(pageName);
	}

	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;

		composite.setLayout(gridLayout);

		GridData messageGridData = new GridData();
		messageGridData.horizontalSpan = 2;
		messageGridData.grabExcessHorizontalSpace = true;
		messageGridData.horizontalAlignment = GridData.FILL;
		messageGridData.verticalAlignment = GridData.END;

		Label messageLabel = new Label(composite, SWT.NONE);
		messageLabel.setFont(JFaceResources.getDialogFont());
		messageLabel.setText(Messages.MoveTopologiesWizardPage1_Choose_destination_for_move_);
		messageLabel.setLayoutData(messageGridData);

		GridData btnGridData = new GridData();
		btnGridData.horizontalAlignment = GridData.END;

		Button newNamespaceButton = new Button(composite, SWT.PUSH);
		newNamespaceButton.setText(Messages.NamespaceSelectionDialog_Create_Namespace_);
		newNamespaceButton.setLayoutData(btnGridData);
		newNamespaceButton.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				NewNamespaceDialog dialog = new NewNamespaceDialog(getShell());
				dialog.create();
				if (Window.OK == dialog.open()) {
					sourceFolderTreeViewer.setSelection(new StructuredSelection(dialog.getNamespace()));
				}
			}

		});

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		gridData.heightHint = 250;
		gridData.widthHint = 325;

		sourceFolderTree = new Tree(composite, SWT.BORDER);
		sourceFolderTree.setLayoutData(gridData);
		sourceFolderTreeViewer = new TreeViewer(sourceFolderTree);
		sourceFolderTreeViewer.setSorter(new TreePathViewerSorter());

		//Listen for changes to the selection so that we can enable the ok button
		sourceFolderTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof INamespaceFragment) {
						INamespaceFragment element = (INamespaceFragment) obj;
						getProcessor().getDataModel().setContainer(
								element.getRoot().getCorrespondingResource(element).getFullPath()
										.toString());
						handleInputChanged();
					}
				}
			}
		});
		setTreeProviders();
//		setInput(((IFile) getProcessor().getElements()[0]).getProject());
		setControl(composite);
		setPageComplete(false);

		/*
		 * PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
		 * IDeployHelpContextIds.TOPOLOGY_REFACTOR_MOVE_TOPOLOGY);
		 */
	}

	private void setTreeProviders() {
		sourceFolderTreeViewer.setContentProvider(new NamespaceContentProvider());
		sourceFolderTreeViewer.setLabelProvider(new NamespaceElementLabelProvider());
	}

	public void setInput(Object input) {
		sourceFolderTreeViewer.setInput(input);
	}

	protected MoveTopologyParticipant getProcessor() {
		return null;
//		return (MoveTopologyParticipant) ((MoveRefactoring) getRefactoring()).getProcessor();
	}

	protected void handleInputChanged() {

		setPageComplete(RefactoringStatus.create(getProcessor().getDataModel().validateContainer()));
	}

	public class NamespaceContentProvider extends NamespaceElementContentProvider {

		public Object[] getChildren(Object aParent) {

			// we want to support providing the roots of a project. 
			if (aParent instanceof IProject) {
				INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(((IProject) aParent),
						new NullProgressMonitor());
				List<INamespaceFragmentRoot> existing = new ArrayList<INamespaceFragmentRoot>();
				for (int i = 0; i < roots.length; i++) {
					if (roots[i].getCorrespondingResource().isAccessible()) {
						existing.add(roots[i]);
					}
				}
				return existing.toArray();
				// when the individual roots are sent in as children, the if statement above will handle their children.
			}

			if (aParent instanceof INamespaceElement) {

				HashSet children = new HashSet();

				if (aParent instanceof INamespaceFragmentRoot) {
					children.addAll(Arrays.asList(((INamespaceFragmentRoot) aParent).namespaces()));
				}

				return children.toArray(new Object[children.size()]);
			}

			return new Object[0];
		}
	}
}
