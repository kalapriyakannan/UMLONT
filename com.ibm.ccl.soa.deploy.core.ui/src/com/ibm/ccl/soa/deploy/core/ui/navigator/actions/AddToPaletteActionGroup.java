/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * @since 1.0
 * 
 */
public class AddToPaletteActionGroup extends ActionGroup {
	private IStructuredSelection selection;
	private final IWorkbenchPartSite viewSite;
	private final String TOPOLOGY_FILE_EXTENSION = "topology"; //$NON-NLS-1$
	private final String TOPOLOGYV_FILE_EXTENSION = "topologyv"; //$NON-NLS-1$
	AddToPaletteDataModel dataModel = AddToPaletteDataModel.createModel();
	private IFile file;

	public AddToPaletteActionGroup(IWorkbenchPartSite viewSite) {
		this.viewSite = viewSite;
	}

	public void dispose() {
		super.dispose();
	}

	/**
	 * @param selection
	 */
	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public void fillContextMenu(IMenuManager menu) {
		Object object = selection.getFirstElement();
		boolean isTopologyFile = false;
		Topology topology = null;
		IProject project = null;
		if (object instanceof IFile) {
			file = (IFile) object;
			project = ProjectUtilities.getProject(object);
			isTopologyFile = isToplogyFile((IFile) object);
			if (!isTopologyFile) {
				return;

			}
		} else if (object instanceof Topology) {
			topology = (Topology) object;
			List<Constraint> constraints = ValidatorUtils.getConstraints(topology,
					ConstraintPackage.eINSTANCE.getPaletteConstraint());
			if (!constraints.isEmpty()) {
				return;
			}
			dataModel.setTopology(topology);
		}

		if (project != null && project.exists()) {
			if (isTopologyFile) {
				dataModel.setTopologyVUri(getDefaultDiagramFile((IFile) object).getFullPath()
						.toString());

			}
			String projectName = project.getName();
			dataModel.setProjectName(projectName);
			menu
					.insertAfter(ICommonMenuConstants.GROUP_NEW, new Separator(
							"deploy.palette.seperator")); //$NON-NLS-1$
			menu.appendToGroup("deploy.palette.seperator", new AddToPaletteAction(dataModel, file)); //$NON-NLS-1$
		}
	}

	/**
	 * @return Returns true if only one object is selected in the navigator otherwise returns false
	 */
	private boolean isSingleSelected() {
		if (selection == null) {
			return false;
		}
		if (selection.size() > 1) {
			return false;
		}
		return true;
	}

	private IFile getDefaultDiagramFile(IFile file) {
		Path diagramPath = (Path) new Path(file.getName()).removeFileExtension();
		// add .topologyv extenion, then get file from same parent as .topology file (same folder)
		return file.getParent().getFile(diagramPath.addFileExtension(IConstants.TOPOLOGYV_EXTENSION));
	}

	private boolean isToplogyFile(IFile file) {
		return file.getFileExtension().equals(TOPOLOGY_FILE_EXTENSION);
	}

}
