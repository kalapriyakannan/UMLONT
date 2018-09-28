/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.asset.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IRuntimeLifecycleListener;
import org.eclipse.wst.server.core.ServerCore;

import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.extension.DeployIdeMessages;

public class DiscoveredAssetManager {

	public class JobChangeListener implements IJobChangeListener {
		IRuntime runtime = null;

		public JobChangeListener(IRuntime aRuntime) {
			runtime = aRuntime;
		}

		public void aboutToRun(IJobChangeEvent event) {

		}

		public void awake(IJobChangeEvent event) {
		}

		public void done(IJobChangeEvent event) {
			DiscoveryJob job = (DiscoveryJob) event.getJob();
			jobMap.remove(runtime);
			Object configuration = job.getConfigurations();
			assetMap.put(runtime, configuration);
			notifyProviders(runtime);

		}

		public void running(IJobChangeEvent event) {

		}

		public void scheduled(IJobChangeEvent event) {

		}

		public void sleeping(IJobChangeEvent event) {

		}
	}

	private class RuntimeLifecycleListener implements IRuntimeLifecycleListener {

		public void runtimeAdded(final IRuntime runtime) {
		}

		public void runtimeChanged(final IRuntime runtime) {
		}

		public void runtimeRemoved(final IRuntime runtime) {
			Job job = (Job) jobMap.get(runtime);
			if (job.cancel()) {
				jobMap.remove(runtime);
				assetMap.remove(runtime);
			}

		}
	}

	private static final DiscoveredAssetManager instance = new DiscoveredAssetManager();

	private HashMap assetMap = new HashMap();

	private HashMap jobMap = new HashMap();

	private ArrayList providers = new ArrayList();

	public static DiscoveredAssetManager getInstance() {
		return instance;
	}

	public void notifyProviders(IRuntime runtime) {
		if (!providers.isEmpty()) {
			for (Iterator iter = providers.iterator(); iter.hasNext();) {
				IContentProvider provider = (IContentProvider) iter.next();
				provider.inputChanged(null, null, runtime);
			}
		}

	}

	public void addProvider(IContentProvider provider) {
		if (!providers.contains(provider))
			providers.add(provider);

	}

	public void removeProvider(IContentProvider provider) {
		providers.remove(provider);

	}

	public Object getAssets(IRuntime runtime) {
		if (jobMap.containsKey(runtime))
			return new Status(IStatus.WARNING, IDEPlugin.PLUGIN_ID, 0,
					DeployIdeMessages.DiscoveredAssetManager_Discovery_is_in_progres_, null);
		return assetMap.get(runtime);
	}

	public void addJob(IRuntime runtime, DiscoveryJob job) {
		ServerCore.addRuntimeLifecycleListener(new RuntimeLifecycleListener());
		job.addJobChangeListener(new JobChangeListener(runtime));
	}

	public boolean hasConfigurations(IRuntime runtime) {
		return assetMap.containsKey(runtime);
	}

	public void addAssetEntry(IRuntime runtime, Object configuration) {
		assetMap.put(runtime, configuration);
	}
}
