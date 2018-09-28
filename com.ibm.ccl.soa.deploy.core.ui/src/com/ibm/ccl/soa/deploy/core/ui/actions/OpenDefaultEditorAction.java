/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.wst.server.ui.internal.editor.IServerEditorInput;
import org.eclipse.wst.server.ui.internal.editor.ServerEditorInput;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Opens the default editor for a Unit or an Import.
 * 
 * @since 7.0
 * 
 */
public class OpenDefaultEditorAction extends Action {
	private final IWorkbenchPage wbPage;

	/**
	 * @param wbPage
	 */
	public OpenDefaultEditorAction(IWorkbenchPage wbPage) {
		setId(DeployActionIds.ACTION_OPEN_DEFAULT_EDITOR);
		setText(Messages.OpenDefaultEditorAction_Open_Default_Edito_);
		setToolTipText(Messages.OpenDefaultEditorAction_Open_the_system_editor_for_a_units_);
		this.wbPage = wbPage;
	}

	@Override
	public boolean isEnabled() {
		EObject dmo = getSelection();
		if (dmo instanceof Unit) {
			IUnitProviderService unitProviderService = ExtensionsCore.createProviderService();
			return unitProviderService.findEnabledProvidersByInputOnly(dmo).length > 0;
		}

		return true;
	}

	public void run() {
		open(getSelection());
	}

	/**
	 * @param dmo
	 */
	public static void open(EObject dmo) {
		if (dmo != null) {
			if (dmo instanceof Unit) {
				openUnit((Unit) dmo);
			} else if (dmo instanceof Import) {
				openImport((Import) dmo);
			} else if (dmo instanceof Diagram) {
				openDiagram((Diagram) dmo);
			}
		}
	}

	static private void openUnit(Unit unit) {
		IUnitProviderService unitProviderService = ExtensionsCore.createProviderService();
		UnitProvider[] providers = unitProviderService.findEnabledProvidersByInputOnly(unit);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		for (int i = 0; i < providers.length; i++) {
			UnitProvider provider = providers[i];
			Object objects = provider.resolveUnderlyingResource(unit, null);
			if (objects instanceof List) {
				List resources = (List) objects;
				for (Iterator iter = resources.iterator(); iter.hasNext();) {
					Object obj = iter.next();
					Resource resource = null;
					if (obj instanceof Resource) {
						resource = (Resource) iter.next();
					} else if (obj instanceof IAdaptable) {
						EObject eobj = (EObject) ((IAdaptable) obj).getAdapter(EObject.class);
						resource = eobj.eResource();
					}

					if (resource != null) {
						IFile file = WorkbenchResourceHelper.getFile(resource);
						openEditor(page, file);
					}
				}
			} else if (objects instanceof String) {
				// defect will be open to remove IServerEditorInput out of the ui plugins.
				IServerEditorInput input = new ServerEditorInput((String) objects);
				try {
					page.openEditor(input, IServerEditorInput.EDITOR_ID);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//Opens the import in a separate editor instance
	static private void openImport(Import theImport) {
		IProject project = WorkbenchResourceHelper.getFile(theImport).getProject();
		IFile file = NamespaceCore.resolveTopology(project, theImport.getNamespace(), theImport
				.getDisplayName());
		openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
	}

	//Opens the diagram in a separate editor instance
	static private void openDiagram(Diagram diagram) {
		IFile file = WorkbenchResourceHelper.getFile(diagram.eResource());
		openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
	}

	static private void openEditor(IWorkbenchPage page, IFile file) {
		try {
			IDE.openEditor(page, file);
		} catch (PartInitException e) {
			// don't open the editor
		}
	}

	private EObject getSelection() {
		EObject retVal = null;
		IStructuredSelection selection = (IStructuredSelection) wbPage.getSelection();
		if (selection instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) selection;
			if (ss.size() == 1) {
				Object element = ss.getFirstElement();
				if (element instanceof DeployShapeNodeEditPart) {
					DeployShapeNodeEditPart editPart = (DeployShapeNodeEditPart) element;
					// if they selected an Import Diagram, open the diagram, not the topology
					if (editPart instanceof ImportTopologyEditPart
							&& ((ImportTopologyEditPart) editPart).isImportDiagram()) {
						retVal = ((ImportTopologyEditPart) editPart).getImportDiagram();
					} else {
						retVal = editPart.resolveSemanticElement();
					}
				}
			}
		}
		return retVal;
	}

}
