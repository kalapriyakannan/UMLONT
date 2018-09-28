package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.savables.ArtifactListener;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.xtools.emf.index.search.IIndexSearchManager;
import com.ibm.xtools.emf.index.search.IndexContext;

/**
 * Decorator for Child nodes of topologies. Highlights each node as follows Blue if not in any
 * diagram Yellow if not in the current diagram Black if in the diagram
 * 
 * @since 7.0
 * 
 */
public class TopologyNodeColorDecorator extends LabelProvider implements ILightweightLabelDecorator {
	private final Job fetchColorJob;
	private final HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
	private final Object lock = new Object();
	private static boolean enabled = false;
	private boolean logged = false;

	private static class Manager {
		public static final Manager INSTANCE = new Manager();

		private final ListenerList listeners = new ListenerList();

		public void addListener(TopologyNodeColorDecorator decorator) {
			listeners.add(decorator);
		}

		public void removeListener(TopologyNodeColorDecorator decorator) {
			listeners.remove(decorator);
		}

		protected void notifyDecorators(IFile model) {
			Object[] decorators = listeners.getListeners();
			for (int i = 0; i < decorators.length; i++) {
				((TopologyNodeColorDecorator) decorators[i]).updateHighlighting(model);
			}
		}
	}

	private final ArtifactListener listener = new ArtifactListener() {

		public void onDiagramChanged(IFile diagram, IFile model) {
			updateHighlighting(model);

		}

		public void onDiagramClosed(IFile diagram, IFile model) {

		}

		public void onDiagramOpened(IFile diagram, IFile model) {

		}

		public void onDiagramRemoved(IFile diagram, IFile model) {
			updateHighlighting(model);

		}

		public void onDiagramSaved(IFile diagram, IFile model) {
			updateHighlighting(model);

		}

		public void onModelChanged(IFile model) {
			updateHighlighting(model);

		}

		public void onModelClosed(IFile model) {

		}

		public void onModelOpened(IFile model) {
			updateHighlighting(model);

		}

		public void onModelRemoved(IFile model) {
			updateHighlighting(model);

		}

		public void onModelSaved(IFile model) {

		}

		public void onModelsAboutToBeRemoved(List<IFile> models) {

		}

	};

	/**
	 * Constructor grabs the System font in a UIJob and sets up the conceptual and nonConceptual Font
	 * instances.
	 * 
	 */
	public TopologyNodeColorDecorator() {
		fetchColorJob = new UIJob(Messages.ConceptualNodeDecorator_) {
			public IStatus runInUIThread(IProgressMonitor monitor) {
				synchronized (lock) {
					setHighlightedColor(SWT.COLOR_BLUE, Display.getCurrent().getSystemColor(
							SWT.COLOR_BLUE));
					setHighlightedColor(SWT.COLOR_BLACK, Display.getCurrent().getSystemColor(
							SWT.COLOR_BLACK));
					setHighlightedColor(SWT.COLOR_YELLOW, Display.getCurrent().getSystemColor(
							SWT.COLOR_YELLOW));
					lock.notifyAll();
				}
				return Status.OK_STATUS;
			}
		};
		fetchColorJob.schedule();
		TopologyArtifactsMonitor.INSTANCE.addListener(listener);
		Manager.INSTANCE.addListener(this);
	}

	protected void updateHighlighting(IFile model) {
		if (model != null) {
			fireLabelProviderChanged(new LabelProviderChangedEvent(this, model));
		} else {
			fireLabelProviderChanged(new LabelProviderChangedEvent(this));
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		TopologyArtifactsMonitor.INSTANCE.removeListener(listener);
		Manager.INSTANCE.removeListener(this);
	}

	//TODO need to add workspace refresh support
	public void decorate(Object element, IDecoration decoration) {
		if (enabled) {
			if (element instanceof DeployModelObject) {
				try {
					DeployModelObject dmo = (DeployModelObject) element;

					IEMFWorkbenchContext emfContext = IEMFWorkbenchContextFactory.eINSTANCE
							.getContext(WorkbenchResourceHelper.getFile(dmo).getProject());
					IndexContext context = IndexContext.createWorkspaceContext(emfContext
							.getResourceSet());
					Collection c = IIndexSearchManager.INSTANCE.findReferencingResources(context, dmo,
							new NullProgressMonitor());
					if (c.size() <= 1) {
						decoration.setForegroundColor(getHighlightedColor(SWT.COLOR_BLUE));
					} else {
						decoration.setForegroundColor(getHighlightedColor(SWT.COLOR_BLACK));
					}
				} catch (Exception e) {
					if (!logged) {
						DeployCorePlugin.logError(0, e.getMessage(), e);
						logged = !logged;
					}
				}
			}
		} else {
			//TODO need to keep record of things not in diagrams so we dont have to do this
			decoration.setForegroundColor(getHighlightedColor(SWT.COLOR_BLACK));
		}
	}

	protected final Color getHighlightedColor(int color) {
		synchronized (lock) {
			// make sure the Job isn't Running/Waiting/Sleeping  
			try {
				while (colors.get(color) == null) {
					lock.wait();
				}
			} catch (Exception e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
			return colors.get(color);
		}
	}

	protected final void setHighlightedColor(int c, Color color) {
		synchronized (lock) {
			colors.put(c, color);
		}
	}

	public static void setEnabled(boolean toggle) {
		enabled = toggle;

		// update all decorators on all files
		Manager.INSTANCE.notifyDecorators(null);
	}

}
