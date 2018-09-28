package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveable;

public class CloseTopologyModelAction extends Action {

	private final Collection<TopologySaveable> saveables;
	private final TopologyArtifactsMonitor modelManager = TopologyArtifactsMonitor.INSTANCE;

	public CloseTopologyModelAction(Collection<TopologySaveable> saveables) {
		super(Messages.CloseTopologyModelAction_Close_Mode_);
		super.setId("closeTopologyModelAction"); //$NON-NLS-1$
		this.saveables = saveables;
	}

	public CloseTopologyModelAction(TopologySaveable saveable) {
		super(Messages.CloseTopologyModelAction_Close_Mode_);
		super.setId("closeTopologyModelAction"); //$NON-NLS-1$
		saveables = new ArrayList<TopologySaveable>();
		saveables.add(saveable);
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

		IProgressService service = PlatformUI.getWorkbench().getProgressService();

		try {
			service.runInUI(service, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException {
					for (Iterator<TopologySaveable> iter = saveables.iterator(); iter.hasNext();) {
						TopologySaveable saveable = iter.next();
						try {
							saveable.close(true, true, monitor);
						} catch (CoreException ex) {
							throw new InvocationTargetException(ex);
						}
					}
				}
			}, null);
		} catch (InvocationTargetException ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
		} catch (InterruptedException ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
		}
	}
}
