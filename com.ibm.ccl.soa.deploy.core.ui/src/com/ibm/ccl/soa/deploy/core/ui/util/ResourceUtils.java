/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.Messages;

public class ResourceUtils {
	protected String getPluginInstallPath(URL url) {
		String file = url.getFile();
		if (file != null && file.endsWith("/")) {//$NON-NLS-1$
			try {
				url = new URL(url.getProtocol(), url.getHost(), url.getPort(), file.substring(0, file
						.length() - 1));
			} catch (MalformedURLException e) {
				return null;
			}
		}
		String installLocation = null;
		try {
			installLocation = Platform.asLocalURL(url).getFile();
		} catch (java.io.IOException e) {
		}
		if (installLocation == null) {
			return null;
		}
		if (installLocation.startsWith("/")) {//$NON-NLS-1$
			return installLocation.substring(1);
		}
		return installLocation;
	}

	/**
	 * Get active workbench page
	 * 
	 * @return org.eclipse.ui.IWorkbenchPage
	 */
	public static void addWorkbenchWindowListener(IWindowListener listener) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null) {
			return;
		}
		workbench.addWindowListener(listener);
	}

	/**
	 * Get active workbench page
	 * 
	 * @return org.eclipse.ui.IWorkbenchPage
	 */
	public static void addWorkbenchPartListener(IPartListener listener) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null) {
			return;
		}
		int n = workbench.getWorkbenchWindowCount();
		IWorkbenchWindow[] windows = workbench.getWorkbenchWindows();
		for (int i = 0; i < n; i++) {
			IWorkbenchWindow w = windows[i];
			w.getPartService().addPartListener(listener);
		}
	}

	public static void removeWorkbenchPartListener(IPartListener listener) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null) {
			return;
		}
		int n = workbench.getWorkbenchWindowCount();
		IWorkbenchWindow[] windows = workbench.getWorkbenchWindows();
		for (int i = 0; i < n; i++) {
			IWorkbenchWindow w = windows[i];
			w.getPartService().removePartListener(listener);
		}
	}

	/**
	 * Get active workbench page
	 * 
	 * @return org.eclipse.ui.IWorkbenchPage
	 */
	public static IWorkbenchPage getActiveWorkbenchPage() {
		IWorkbenchWindow workbenchWindow = getActiveWorkbenchWindow();
		if (workbenchWindow == null) {
			logError(Messages.ResourceUtils_The_active_workbench_window_could_n_);
			return null;
		}
		return workbenchWindow.getActivePage();
	}

	/**
	 * @return IWorkbenchWindow
	 */
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		final IWorkbenchWindow workbenchWindow[] = new IWorkbenchWindow[1];
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench != null) {
			Display display = Display.getCurrent() != null ? Display.getCurrent() : Display
					.getDefault();
			display.syncExec(new Runnable() {
				public void run() {
					workbenchWindow[0] = workbench.getActiveWorkbenchWindow();
				}
			});
		}
		return workbenchWindow[0];
	}

	private static void logError(String string) {
		IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, string, null);
		DeployCorePlugin.log(status);

	}

	/**
	 * Get active editor
	 * 
	 * @return org.eclipse.ui.IEditorPart
	 */
	public static IEditorPart getActiveEditorPart() {
		IEditorPart ret = null;

		IWorkbenchPage page = getActiveWorkbenchPage();
		if (page != null) {
			ret = page.getActiveEditor();
			if (ret != null) {
				IEditorPart innerEditor = (IEditorPart) ret.getAdapter(IEditorPart.class);
				if (innerEditor != null) {
					ret = innerEditor;
				}
			}
		}

		return ret;
	}

	/**
	 * Get active DeployToolEditor
	 * 
	 * @return com.ibm.etools.sketcher.editor.HTMLEditDomain
	 */
	public static DeployCoreEditor getActiveDeployEditDomain() {
		IEditorPart editor = getActiveEditorPart();
		if (editor == null) {
			return null;
		}
		return (DeployCoreEditor) editor.getAdapter(DeployCoreEditor.class);
	}

	/**
	 * Returns the validator service used by the active deploy editor.
	 * <p>
	 * Creates a new validator service if the current active editor cannot be identified, or has not
	 * been initialized.
	 * 
	 * @return the validator service (never null).
	 * 
	 * @see #getActiveDeployEditDomain()
	 * @see DeployValidatorService#getDefaultValidatorService()
	 */
	public static DeployValidatorService getActiveDeployEditorValidatorService() {
		DeployCoreEditor editor = getActiveDeployEditDomain();
		DeployValidatorService validatorService = null;
		if (editor != null) {
			validatorService = editor.getDeployValidatorService();
		}
		if (validatorService == null) {
			validatorService = DeployValidatorService.getDefaultValidatorService();
		}
		return validatorService;
	}

	/**
	 * Get project for a path
	 * 
	 * @return com.ibm.etools.sketcher.editor.HTMLEditDomain
	 */
	public static IProject getProjectForIPath(IPath fullLocalIPath) {
		final IContainer container = getContainerOfPath(fullLocalIPath);
		if (container != null) {
			// fullLocalIPath exists in workspace
			final IProject project = container.getProject();
			if (project != null) {
				return project;
			}
		}

		// IWorkspaceRoot.getContainerForLocation() seems to return the correct
		// IContariner even if fullIPath doesn't exist, but make sure.

		// Search IProject which fileURL belongs to
		final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		if (workspace == null) {
			return null;
		}
		IProject[] projects = workspace.getProjects();
		if (projects == null) {
			return null;
		}
		IProject project = null;
		for (int i = 0; i < projects.length; ++i) {
			project = projects[i];
			// project.getFile() is more appropriate to see if fullIPath is in
			// project ??
			if (project.getLocation().isPrefixOf(fullLocalIPath) == true) {
				// fullLocalIPath seem to belong to project
				return project;
			}
		}

		return null;
	}

	/**
	 * Gets IContainer of the given absolute local path(E:/foo/bar/...)
	 */
	private static IContainer getContainerOfPath(IPath fullLocalIPath) {
		final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		final IContainer container = workspace.getContainerForLocation(fullLocalIPath);
		return container;
	}

	public static IFolder getFolderOfPath(IPath fullLocalIPath) {
		final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		final IFolder folder = workspace.getFolder(fullLocalIPath);
		return folder;
	}

	// Should start with a letter and contain only letters, numbers,
	// or the connecting underscore character "_".
	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		name.trim();
		char[] tChar = name.toCharArray();
		if (tChar.length == 0) {
			return false;
		}
		if (!Character.isLetter(tChar[0])) {
			return false;
		}
		for (int i = 0; i < tChar.length; i++) {
			char c = tChar[i];
			if (Character.isLetterOrDigit(c)) {
				continue;
			} else if (c == '_') {
				continue;
			} else if (c == '-') {
				continue;
			} else if (c == ' ') {
				continue;
			}
			return false;
		}
		return true;
	}

	static public boolean isProjectExist(String projectName) {
		boolean isExist = false;
		IProject[] projects = ProjectUtilities.getAllProjects();
		for (int i = 0; i < projects.length && !isExist; i++) {
			isExist = projects[i].getName().equals(projectName);
		}
		return isExist;
	}

	/**
	 * List of all topology files in the project.
	 * <p>
	 */
	public static List getTopologyProjectFiles(IProject project) {
		List result = new ArrayList();
		if (project == null) {
			return result;
		}
		try {
			result = collectFiles(project.members(), result, IConstants.TOPOLOGY_EXTENSION);
		} catch (CoreException e) {
		}
		return result;
	}

	public static List getTopologyFolderFiles(IFolder folder) {
		List result = new ArrayList();
		if (folder == null) {
			return result;
		}
		try {
			result = collectFiles(folder.members(), result, IConstants.TOPOLOGY_EXTENSION);
		} catch (CoreException e) {
		}
		return result;
	}

	private static List collectFiles(IResource[] members, List result, String extension)
			throws CoreException {
		// recursively collect files for the given members
		if (extension == null) {
			return result;
		}
		for (int i = 0; i < members.length; i++) {
			IResource res = members[i];
			if (res instanceof IFolder) {
				collectFiles(((IFolder) res).members(), result, extension);
			} else if (res instanceof IFile) {
				String fileExtensionToCheck = ((IFile) res).getFileExtension();
				if (fileExtensionToCheck != null && fileExtensionToCheck.equalsIgnoreCase(extension)) {
					result.add(res);
				}
			}
		}
		return result;
	}

	/**
	 * @param ext
	 * @return list of path names
	 */
	public static List<String> findFilesWithExtension(String ext) {
		return findFilesWithExtension(new String[] { ext });
	}

	/**
	 * @param exts
	 * @return list of path names
	 */
	@SuppressWarnings("unchecked")
	public static List<String> findFilesWithExtension(String[] exts) {
		if (exts == null || exts.length == 0) {
			return Collections.EMPTY_LIST;
		}
		List<String> list = new ArrayList<String>();
		IProject[] projects = ProjectUtilities.getAllProjects();
		for (int i = 0; i < projects.length; i++) {
			IProject project = projects[i];
			findFilesWithExtensionHelper(project, exts, list);
		}
		return list;
	}

	private static void findFilesWithExtensionHelper(IContainer container, String[] exts,
			List<String> list) {

		try {
			IResource[] members = container.members();
			for (int i = 0; i < members.length; i++) {
				IResource resource = members[i];
				switch (resource.getType())
				{
				case IResource.FILE:
					if (resource.getFileExtension() != null) {
						for (String ext : exts) {
							if (resource.getFileExtension().equalsIgnoreCase(ext)) {
								list.add(resource.getFullPath().toPortableString());
								break;
							}
						}
					}
					break;
				case IResource.FOLDER:
					findFilesWithExtensionHelper((IContainer) resource, exts, list);
					break;
				}
			}
		} catch (CoreException e) {
		}
	}

}
