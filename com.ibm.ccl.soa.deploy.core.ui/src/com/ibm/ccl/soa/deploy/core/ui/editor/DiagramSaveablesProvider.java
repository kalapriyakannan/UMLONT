/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.editor;

import java.lang.ref.WeakReference;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.savables.ArtifactListener;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveable;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;

class DiagramSaveablesProvider extends ArtifactListener {

	private final WeakReference<DeployCoreEditor> reference;
	private final Object lock = new Object();

	public DiagramSaveablesProvider(DeployCoreEditor editor) {
		reference = new WeakReference(editor);
	}

	@Override
	public void onDiagramChanged(IFile diagram) {
		final DeployCoreEditor editor = getEditor();
		if (editor == null) {
			return;
		}

		synchronized (lock) {
			TopologySaveable saveable = editor.getSaveable();
			if (saveable != null && saveable.getArtifacts().contains(diagram)) {
				if (Display.getDefault() != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (null != editor && !editor.isDisposed()) {
								editor.firePropertyChange(IEditorPart.PROP_DIRTY);
							}
						}
					});
				}
			}
		}
	}

	@Override
	public void onDiagramMoved(final IFile oldDiagramLocation, final IFile newDiagramLocation) {
		final DeployCoreEditor editor = getEditor();
		if (editor == null) {
			return;
		}

		synchronized (lock) {

			final TopologySaveable saveable = editor.getSaveable();
			if (saveable != null && saveable.getArtifacts().contains(oldDiagramLocation)) {
				SafeRunner.run(new DeployCoreSafeRunnable() {

					@Override
					public void run() throws Exception {
						saveable.close(true, new NullProgressMonitor());
					}

				});

//				saveable.removeArtifact(oldDiagramLocation);
//				saveable.addArtifact(newDiagramLocation);

				if (Display.getDefault() != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (null != editor && !editor.isDisposed()) {
								// close current editor
								SafeRunner.run(new DeployCoreSafeRunnable() {
									public void run() throws Exception {
										editor.getEditorSite().getPage().closeEditor(editor, false);
									}
								});
							}
						}
					});
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							// open a new editor
							SafeRunner.run(new DeployCoreSafeRunnable() {

								public void run() throws Exception {
									IWorkbenchPage page = PlatformUI.getWorkbench()
											.getActiveWorkbenchWindow().getActivePage();
									page.openEditor(new FileEditorInput(newDiagramLocation),
											DeployCoreUIPlugin.EDITOR_ID);
								}
							});
						}
					});
				}
			}
		}
	}

	@Override
	public void onDiagramSaved(IFile diagram) {
		final DeployCoreEditor editor = getEditor();
		if (editor == null) {
			return;
		}

		synchronized (lock) {

			TopologySaveable saveable = editor.getSaveable();
			if (saveable != null && saveable.getArtifacts().contains(diagram)) {
				if (Display.getDefault() != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (null != editor && !editor.isDisposed()) {
								editor.firePropertyChange(IEditorPart.PROP_DIRTY);
							}
						}
					});
				}
			}
		}
	}

	@Override
	public void onDiagramClosed(IFile diagram) {
		final DeployCoreEditor editor = getEditor();
		if (editor == null) {
			return;
		}

		synchronized (lock) {
			IFile diagramInput = editor.getDiagramFile(editor.getEditorInput());
			TopologySaveable saveable = editor.getSaveable();
			if (saveable != null && saveable.getArtifacts().contains(diagram)
					&& diagramInput.equals(diagram)) {

				if (Display.getDefault() != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (null != editor && !editor.isDisposed()) {

								// close current editor
								SafeRunner.run(new DeployCoreSafeRunnable() {

									public void run() throws Exception {
										editor.getEditorSite().getPage().closeEditor(editor, false);
									}
								});
							}
						}
					});
				}
			}
		}
	}

	@Override
	public void onModelChanged(IFile model) {
		final DeployCoreEditor editor = getEditor();
		if (editor == null) {
			return;
		}

		synchronized (lock) {
			TopologySaveable saveable = editor.getSaveable();
			if (saveable != null && saveable.getArtifacts().contains(model)) {
				if (Display.getDefault() != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (null != editor && !editor.isDisposed()) {
								editor.firePropertyChange(IEditorPart.PROP_DIRTY);
							}
						}
					});
				}
			}
		}
	}

	@Override
	public void onModelClosed(final IFile model) {
		final DeployCoreEditor editor = getEditor();
		if (editor == null) {
			return;
		}

		synchronized (lock) {
			TopologySaveable saveable = editor.getSaveable();
			if (saveable != null && saveable.getArtifacts().contains(model)) {

				if (Display.getDefault() != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (null != editor && !editor.isDisposed()) {

								// close saveable in current editor
								SafeRunner.run(new DeployCoreSafeRunnable() {

									public void run() throws Exception {
										editor.getSaveable().close(true, new NullProgressMonitor());
									}
								});

								// close current editor
								SafeRunner.run(new DeployCoreSafeRunnable() {

									public void run() throws Exception {
										editor.getEditorSite().getPage().closeEditor(editor, false);
									}

								});
							}
						}
					});
				}
			}
		}
	}

	@Override
	public void onModelRemoved(IFile model) {
		final DeployCoreEditor editor = getEditor();
		if (editor == null) {
			return;
		}

		synchronized (lock) {
			TopologySaveable saveable = editor.getSaveable();
			if (saveable != null && saveable.getArtifacts().contains(model)) {

				if (Display.getDefault() != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (null != editor && !editor.isDisposed()) {

								// close saveable in current editor
								SafeRunner.run(new DeployCoreSafeRunnable() {

									public void run() throws Exception {
										editor.getSaveable().close(true, new NullProgressMonitor());
									}
								});

								// close current editor
								SafeRunner.run(new DeployCoreSafeRunnable() {

									public void run() throws Exception {
										editor.getEditorSite().getPage().closeEditor(editor, false);
									}
								});
							}
						}
					});
				}
			}
		}
	}

	@Override
	public void onModelMoved(IFile oldModelLocation, final IFile newModelLocation) {
		final DeployCoreEditor editor = getEditor();
		if (editor == null) {
			return;
		}
		if (oldModelLocation != null && newModelLocation != null
				&& oldModelLocation.equals(newModelLocation)) {
			return;
		}

		synchronized (lock) {
			final TopologySaveable saveable = editor.getSaveable();
			if (saveable != null && saveable.getArtifacts().contains(oldModelLocation)) {

				SafeRunner.run(new DeployCoreSafeRunnable() {

					@Override
					public void run() throws Exception {
						saveable.close(true, new NullProgressMonitor());
					}

				});
//				saveable.removeArtifact(oldModelLocation);
//				saveable.addArtifact(newModelLocation);
//
//				if (saveable.getOpenedOn().equals(oldModelLocation)) {
//					saveable.setOpenedOn(newModelLocation);
//				}

				if (Display.getDefault() != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (null != editor && !editor.isDisposed()) {
								// close current editor
								SafeRunner.run(new DeployCoreSafeRunnable() {

									public void run() throws Exception {
										editor.getEditorSite().getPage().closeEditor(editor, false);
									}
								});
							}
						}
					});
				}
			}
		}
	}

	@Override
	public void onModelSaved(IFile model) {
		final DeployCoreEditor editor = getEditor();
		if (editor == null) {
			return;
		}

		synchronized (lock) {

			TopologySaveable saveable = editor.getSaveable();
			if (saveable != null && saveable.getArtifacts().contains(model)) {
				if (Display.getDefault() != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (null != editor && !editor.isDisposed()) {
								editor.firePropertyChange(IEditorPart.PROP_DIRTY);
							}
						}
					});
				}
			}
		}
	}


	private DeployCoreEditor getEditor() {
		return reference.get();
	}

}
