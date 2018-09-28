package com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.part.FileEditorInput;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.index.search.Query;
import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.EclipseResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;

public class RefactoringUtils {

	/**
	 * <p>
	 * Retrieve list of IEditorPart's who are open on any file contained in the namespace and any
	 * sub-namespaces if searchSubNamespaces is true.
	 * </p>
	 * 
	 * @param namespace
	 *           the namespace that should be searched for open files in the editor
	 * @param searchSubNamespaces
	 *           boolean indicating if subnamespaces should also be searched
	 * @return a List of IEditorParts that are opened on files contained in the namespace or
	 *         subnamespaces if searchSubNamespaces is true and are currently dirty.
	 * @throws CoreException
	 */
	public static List<IEditorPart> findDirtyEditors(INamespaceFragment namespace,
			boolean searchSubNamespaces) throws CoreException {
		List<IEditorPart> dirty = new ArrayList<IEditorPart>();
		List<IEditorPart> editors = findEditors(namespace, searchSubNamespaces);
		for (Iterator<IEditorPart> iter = editors.iterator(); iter.hasNext();) {
			IEditorPart editor = iter.next();
			if (editor.isDirty() && !dirty.contains(editor)) {
				dirty.add(editor);
			}
		}

		return dirty;
	}

	/**
	 * <p>
	 * Retrieve IEditorPart's for any editors that are currently open in any workbench window whose
	 * input matches a file contained in the namespace.
	 * </p>
	 * 
	 * @param namespace
	 *           the namespace that should be searched for open files in the editor
	 * @param searchSubNamespaces
	 *           boolean indicating if subnamespaces should also be searched
	 * @return a List of IEditorParts that are opened on topologies contained in the namespace or
	 *         subnamespaces if searchSubNamespaces == true.
	 * @throws CoreException
	 */
	public static List<IEditorPart> findEditors(INamespaceFragment namespace,
			boolean searchSubNamespaces) throws CoreException {
		List<IEditorPart> editors = new ArrayList<IEditorPart>();
		IResource[] resources = namespace.getCorrespondingResource().members(false);
		for (int i = 0; i < resources.length; i++) {
			IResource resource = resources[i];
			if (resource.getType() == IResource.FILE) {
				List<IEditorPart> theEditors = findEditors((IFile) resource);
				for (Iterator<IEditorPart> iter = theEditors.iterator(); iter.hasNext();) {
					IEditorPart editor = iter.next();
					if (!editors.contains(editor)) {
						editors.add(editor);
					}
				}
			}
		}

		if (searchSubNamespaces) {
			INamespaceFragment[] subnamespaces = namespace.subNamespaces();
			for (int i = 0; i < subnamespaces.length; i++) {
				List<IEditorPart> theEditors = findEditors(subnamespaces[i], searchSubNamespaces);
				for (Iterator<IEditorPart> iter = theEditors.iterator(); iter.hasNext();) {
					IEditorPart editor = iter.next();
					if (!editors.contains(editor)) {
						editors.add(editor);
					}
				}
			}
		}

		return editors;
	}

	/**
	 * <p>
	 * Retrieve a list of IEditorPart's for any existing editors in any workbench window who where
	 * opened on the file and who are currently "dirty".
	 * </p>
	 * 
	 * @param file
	 *           The IFile to search for an open editor on.
	 * @return a List of IEditorParts that are opened on the file and are currently dirty
	 */
	public static List<IEditorPart> findDirtyEditors(IFile file) {
		List<IEditorPart> dirty = new ArrayList<IEditorPart>();
		List<IEditorPart> editors = findEditors(file);
		for (Iterator<IEditorPart> iter = editors.iterator(); iter.hasNext();) {
			IEditorPart editor = iter.next();
			if (editor.isDirty() && !dirty.contains(editor)) {
				dirty.add(editor);
			}
		}

		return dirty;
	}

	/**
	 * <p>
	 * Returns a list of IEditorParts who where opened on the file in any workbench window.
	 * </p>
	 * 
	 * @param file
	 *           The IFile to search for an open editor on.
	 * @return a List of IEditorParts that are opened on the file
	 */
	public static List<IEditorPart> findEditors(IFile file) {
		List<IEditorPart> editors = new ArrayList<IEditorPart>();
		Workbench workbench = Workbench.getInstance();
		if (null != workbench) {
			IWorkbenchWindow[] windows = workbench.getWorkbenchWindows();
			for (int w = 0; w < windows.length; w++) {
				IWorkbenchWindow window = windows[w];
				IWorkbenchPage[] pages = window.getPages();
				for (int p = 0; p < pages.length; p++) {
					IWorkbenchPage page = pages[p];
					IEditorPart editor = page.findEditor(new FileEditorInput(file));
					if (null != editor && !editors.contains(editor)) {
						editors.add(editor);
					}
				}
			}
		}

		return editors;
	}

	/**
	 * <p>
	 * If the file is an instance of a Diagram then this method will return the model file associated
	 * with this diagram. If this is a model file then this method will simply return the same file.
	 * If there is not a model associated with the diagram then this method will return null. If the
	 * diagram has not been previously loaded and the force parameter equals true then this method
	 * will force the load of the diagram's resource.
	 * </p>
	 * 
	 * @param file
	 *           A diagram or model file
	 * @param force
	 *           boolean indicating if the diagram file should be forcibly loaded if it has not yet
	 *           been loaded.
	 * @return an IFile handle to the model file associated with the diagram file passed in or null
	 *         if the diagram file passed in has not been previously loaded and the force parameter
	 *         was false, or the diagram file is not associated with a model file.
	 */
	public static IFile getAssociatedModelFile(final IFile diagram) {

		if (null == diagram) {
			return null;
		}

		if (!diagram.getProject().isAccessible() || !diagram.isAccessible()) {
			return null;
		}

		if (!IConstants.TOPOLOGYV_EXTENSION.equals(diagram.getFileExtension())) {
			return null;
		}

		IEditModelScribbler scribbler = null;

		try {

			scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(diagram.getProject(),
					new DefaultScribblerDomain() {

						public String getEditModelLabel() {
							return diagram.getName()
									+ ".readonly." + RefactoringUtils.class.getSimpleName() + ".getAssociatedModelFile"; //$NON-NLS-1$ //$NON-NLS-2$
						}

						public IResourceDescriptor[] getResourceDescriptors() {
							return new IResourceDescriptor[] { new EclipseResourceDescriptor(diagram
									.getProjectRelativePath(), diagram.getFullPath()) };
						}

					});

			Resource resource = scribbler.getResource(diagram,
					IEditModelScribbler.OPTION_LOAD_AS_READ_ONLY);
			if (resource != null && ((Resource.Internal) resource).isLoaded()
					&& !((Resource.Internal) resource).isLoading() && resource.getContents().size() > 0) {
				Diagram aDiagram = (Diagram) resource.getContents().get(0);

				// we use eGet(.., don't resolve) to avoid loading the model just to find out who it is
				EObject element = (EObject) aDiagram
						.eGet(NotationPackage.Literals.VIEW__ELEMENT, false /* resolve */);
				if (element instanceof Topology) {
					Topology topology = (Topology) element;
					if (topology.eIsProxy()) {
						URI uri = EcoreUtil.getURI(topology);
						return ResourcesPlugin.getWorkspace().getRoot().getFile(
								new Path(uri.toPlatformString(true)));
					}
					return getFile(topology.eResource());
				}
			}
		} catch (EditModelException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		} finally {
			try {
				if (null != scribbler) {
					scribbler.close(null);
				}
			} catch (EditModelException ex) {
				IDEPlugin.logError(0, ex.getMessage(), ex);
			}
		}
		return null;
	}

	/**
	 * <p>
	 * Returns a List of IFiles that are instances of GMF diagrams who are associated with the model
	 * file.
	 * </p>
	 * 
	 * @param model
	 *           the topology model file to find all diagram associations for
	 * @return a List of IFile diagrams who are associated with the model file or an empty list if no
	 *         associated diagrams could be located or the model is null or not a topology model file
	 */
	public static List<IFile> getAssociatedDiagramFiles(final IFile model) {

		List<IFile> diagrams = new ArrayList<IFile>();

		if (null == model) {
			return diagrams;
		}

		if (!model.getProject().isAccessible() || !model.isAccessible()) {
			return diagrams;
		}

		if (!IConstants.TOPOLOGY_EXTENSION.equals(model.getFileExtension())) {
			return diagrams;
		}

		IEditModelScribbler scribbler = null;

		try {

			scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(model.getProject(),
					new DefaultScribblerDomain() {

						public String getEditModelLabel() {
							return model.getName()
									+ ".readonly." + RefactoringUtils.class.getSimpleName() + ".getAssociatedDiagramFiles"; //$NON-NLS-1$ //$NON-NLS-2$
						}

						public IResourceDescriptor[] getResourceDescriptors() {
							return new IResourceDescriptor[] { new EclipseResourceDescriptor(model
									.getProjectRelativePath(), model.getFullPath()) };
						}

					});

			Resource resource = scribbler.getResource(model,
					IEditModelScribbler.OPTION_LOAD_AS_READ_ONLY
							| IEditModelScribbler.OPTION_LOAD_RESOURCE);
			if (resource != null && ((Resource.Internal) resource).isLoaded()
					&& !((Resource.Internal) resource).isLoading() && resource.getContents().size() > 0) {
				Topology topology = ((DeployCoreRoot) resource.getContents().get(0)).getTopology();
				Collection<IFile> associations = Query.findReferencingDiagramResources(topology, Arrays
						.asList(new IResource[] { model.getProject() }), true, false, true, false, null);
				diagrams.addAll(associations);
			}

		} catch (CoreException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		} catch (EditModelException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		} finally {
			try {
				if (null != scribbler) {
					scribbler.close(null);
				}
			} catch (EditModelException ex) {
				IDEPlugin.logError(0, ex.getMessage(), ex);
			}
		}

		return diagrams;
	}

	/**
	 * <p>
	 * Determines the "modified" state of the file. Attempts to "load" the file as an EMF Resource.
	 * If not already loaded in an edit model, will return false, otherwise the resulting value of
	 * the Resource's isModified() method will be returned.
	 * </p>
	 * 
	 * @param file
	 *           a file to test for modification
	 * @return true if the file is an emf resource whose isModified() return value is true otherwise
	 *         false.
	 */
	public static boolean isDirty(final IFile file) {

		if (null == file) {
			return false;
		}

		if (!file.getProject().isAccessible() || !file.isAccessible()) {
			return false;
		}

		if (file.isReadOnly()) {
			return false;
		}

		IEditModelScribbler scribbler = null;

		try {

			scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(file.getProject(),
					new DefaultScribblerDomain() {

						public String getEditModelLabel() {
							return file.getName()
									+ ".readonly." + RefactoringUtils.class.getSimpleName() + ".isDirty"; //$NON-NLS-1$ //$NON-NLS-2$
						}

						public IResourceDescriptor[] getResourceDescriptors() {
							return new IResourceDescriptor[] { new EclipseResourceDescriptor(file
									.getProjectRelativePath(), file.getFullPath()) };
						}

					});

			Resource resource = scribbler.getResource(file, IEditModelScribbler.OPTION_NONE
					| IEditModelScribbler.OPTION_LOAD_AS_READ_ONLY);
			if (resource != null && ((Resource.Internal) resource).isLoaded()
					&& !((Resource.Internal) resource).isLoading() && resource.getContents().size() > 0) {
				if (resource.isModified()) {
					return true;
				}
			}
		} catch (EditModelException ex) {
			IDEPlugin.logError(0, ex.getMessage(), ex);
		} finally {
			try {
				if (null != scribbler) {
					scribbler.close(null);
				}
			} catch (EditModelException ex) {
				IDEPlugin.logError(0, ex.getMessage(), ex);
			}
		}
		return false;
	}

	private static IFile getFile(Resource resource) {
		URI uri = resource.getURI();
		IPath path = new Path(uri.toPlatformString(true));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		return file;
	}
}
