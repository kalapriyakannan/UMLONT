package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISaveablesSource;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveable;

public class OpenCloseTopologyActionGroup extends ActionGroup {

	private IStructuredSelection selection;
	private final IWorkbenchPartSite viewSite;
	private ISaveablesSource saveablesSource;

	/**
	 * @param viewSite
	 */
	public OpenCloseTopologyActionGroup(IWorkbenchPartSite viewSite) {
		this.viewSite = viewSite;
		if (this.viewSite.getPart() instanceof ISaveablesSource) {
			saveablesSource = (ISaveablesSource) this.viewSite.getPart();
		}
	}

	/**
	 * @param selection
	 */
	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public void fillContextMenu(IMenuManager menu) {
		if (isSingleSelected()) {
			Object object = selection.getFirstElement();
			if (object instanceof IFile) {
				IFile file = (IFile) object;
				if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
					TopologySaveable saveable = getSaveable(file);
					if (saveable != null && saveable.isOpen()) {
						menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, new CloseTopologyModelAction(
								saveable));
					} else {
						menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, new OpenTopologyModelAction(
								file));
					}
				}
			}
		} else if (selection != null) {
			List<TopologySaveable> opened = new ArrayList<TopologySaveable>();
			List<IFile> closed = new ArrayList<IFile>();
			for (Iterator iter = selection.iterator(); iter.hasNext();) {
				Object object = iter.next();
				if (object instanceof IFile) {
					IFile file = (IFile) object;
					if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
						TopologySaveable saveable = getSaveable(file);
						if (saveable != null && saveable.isOpen()) {
							opened.add(saveable);
						} else {
							closed.add(file);
						}
					}
				}
			}

			if (opened.size() == selection.size()) {
				menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN,
						new CloseTopologyModelAction(opened));
			} else if (closed.size() == selection.size()) {
				menu
						.appendToGroup(ICommonMenuConstants.GROUP_OPEN, new OpenTopologyModelAction(
								closed));
			}
		}
	}

	private TopologySaveable getSaveable(IFile file) {
		if (saveablesSource != null) {
			Saveable[] saveables = saveablesSource.getSaveables();
			for (int i = 0; i < saveables.length; i++) {
				Saveable saveable = saveables[i];
				if (saveable instanceof TopologySaveable) {
					TopologySaveable topSaveable = (TopologySaveable) saveable;
					if (topSaveable.getArtifacts().contains(file)) {
						return topSaveable;
					}
				}
			}
		}

		return null;
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
}
