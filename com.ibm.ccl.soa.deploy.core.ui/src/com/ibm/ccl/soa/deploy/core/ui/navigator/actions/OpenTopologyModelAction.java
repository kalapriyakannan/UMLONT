package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveableDomain;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

public class OpenTopologyModelAction extends Action {

	private final Collection<IFile> models;
	private final TopologyArtifactsMonitor modelManager = TopologyArtifactsMonitor.INSTANCE;

	public OpenTopologyModelAction(Collection<IFile> models) {
		super(Messages.OpenTopologyModelAction_Open_Mode_);
		super.setId("openTopologyModelAction"); //$NON-NLS-1$
		this.models = models;
	}

	public OpenTopologyModelAction(IFile model) {
		super(Messages.OpenTopologyModelAction_Open_Mode_);
		super.setId("openTopologyModelAction"); //$NON-NLS-1$
		models = new ArrayList<IFile>();
		models.add(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	public boolean isEnabled() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 * 
	 */
	public void run() {
		if (models.size() > 0) {
			for (Iterator<IFile> iter = models.iterator(); iter.hasNext();) {
				IEditModelScribbler scribbler = null;
				try {
					IFile model = iter.next();
					scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(model.getProject(),
							new TopologySaveableDomain(model));
					Resource resource = scribbler.getResource(model);
					if (resource != null) {
						TopologyArtifactsMonitor.INSTANCE.resourceLoaded(resource);
					}
				} catch (EditModelException ex) {
					DeployCoreUIPlugin.logError(0, ex.toString(), ex);
				} finally {
					if (null != scribbler) {
						final IEditModelScribbler closeme = scribbler;
						SafeRunner.run(new ISafeRunnable() {

							public void run() throws Exception {
								if (null != closeme) {
									closeme.close(new NullProgressMonitor());
								}
							}

							public void handleException(Throwable ex) {
								DeployCoreUIPlugin.logError(0, ex.toString(), ex);
							}

						});
					}
				}
			}
		}
	}
}
