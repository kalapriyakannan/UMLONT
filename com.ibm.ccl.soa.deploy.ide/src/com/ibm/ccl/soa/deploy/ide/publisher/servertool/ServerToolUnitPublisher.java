/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.publisher.servertool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.componentcore.UnresolveableURIException;
import org.eclipse.wst.common.componentcore.internal.impl.ModuleURIUtil;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerType;
import org.eclipse.wst.server.core.IServerWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;
import org.eclipse.wst.server.core.ServerUtil;
import org.eclipse.wst.server.core.internal.IClient;
import org.eclipse.wst.server.core.internal.ILaunchableAdapter;
import org.eclipse.wst.server.core.internal.PublishServerJob;
import org.eclipse.wst.server.core.internal.RestartServerJob;
import org.eclipse.wst.server.core.internal.ServerPlugin;
import org.eclipse.wst.server.core.internal.ServerType;
import org.eclipse.wst.server.core.internal.ServerWorkingCopy;
import org.eclipse.wst.server.core.internal.StartServerJob;
import org.eclipse.wst.server.core.util.SocketUtil;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.ide.extension.DeployIdeMessages;
import com.ibm.ccl.soa.deploy.ide.publisher.IPublisherConstants;
import com.ibm.ccl.soa.deploy.ide.publisher.IdeUnitPublisher;
import com.ibm.ccl.soa.deploy.ide.publisher.PublishFamilyManager;
import com.ibm.ccl.soa.deploy.ide.publisher.PublishFamilyMember;

// CLASS under implementation and subject to be abstracted further.

/**
 * This class is intended to be overriden by clients.
 * 
 * Function provided includes module converting, server creatation, server configuring, server
 * launching, and client launching.
 * 
 * Model converting - deployment modules, ie host units and configuration units are translated into
 * j2ee deployables which yeild server tool modules.
 * 
 * Server creation - introspects deployment modules (host) to find environment specific server tool
 * ids. These ids are used to create server instances.
 * 
 * Server configuration- tapping into server tooling api, modules are modified for the client server
 * resources.
 * 
 * Server launching - uses debug framework to launch vm in different modes: debug, run or profile
 * mode.
 * 
 * Client launching - if default clients are defined launches client. An example of a client is a
 * browser with a url.
 * 
 */

public abstract class ServerToolUnitPublisher extends IdeUnitPublisher implements
		IAnnotationConstants {

	private boolean republish = false;

	private final Random rand = new Random();

	/**
	 * Variable stores an open working copy. Open working copy enusres data written to the server
	 * configuraitons are not overriden. After configurations are completed the working copy is saved
	 * and a server instance is produced.
	 * 
	 * @since 1.0
	 */

	private IServerWorkingCopy serverWC = null;

	/**
	 * Constant used to assign jobs in context relative to the job manager. helps prevent blocking on
	 * common scheduling rules.
	 * 
	 * @since 1.0
	 */
	private final String jobContext = "org.eclipse.wst.server.ui.family"; //$NON-NLS-1$

	// TODO hook into job manager progressMonitor
	/**
	 * Variable used to show progress of server jobs. The server view includes an animated progress
	 * already. Currently use of progress monitor not essential, but noted.
	 * 
	 * @since 1.0
	 */
	private final IProgressMonitor pub_monitor = new NullProgressMonitor();

	/**
	 * Returns true if this publisher can publish the specified host unit
	 * 
	 * @since 1.0
	 */

	List<IModule> uninstallModules = new ArrayList<IModule>();

	public boolean canPublish(Unit hostUnit) {
		if (super.canPublish(hostUnit)) {
			// Check that the runtime instance id exists in the workspace
			String runtimeInstanceId = getRuntimeInstanceId(hostUnit);

			IRuntime[] runtimes = ServerCore.getRuntimes();
			for (int i = 0; i < runtimes.length; i++) {
				IRuntime runtime = runtimes[i];
				if (runtime.getName().equals(runtimeInstanceId)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Gathers server specific ids from host annotations.
	 * 
	 * @see getRuntimeId(host)
	 * @see getRuntimeType(host)
	 * 
	 * @since 1.0
	 */

	protected IStatus publish(Unit host, List modules, List configurationModules) {
		String runtimeId = getRuntimeInstanceId(host);
		String runtimeType = getRuntimeTypeId(host);
		administer(runtimeId, runtimeType, toModuleArray(modules),
				toConfigurationArray(configurationModules), host);
		// TODO gather status
		return Status.OK_STATUS;
	}

	/**
	 * Delegates discovery of deployables, server creation, server configuration, and server launch.
	 * Collects status for each stage of module publishing.
	 * 
	 * @since 1.0
	 * @return IStatus could contain many IStatus collected during the publish process
	 */

	private IStatus administer(String runtimeId, String runtimeType, Unit[] modules,
			Unit[] configurationModules, Unit host) {
		List deployableModules = null;
		if (modules != null) {
			deployableModules = getServerModules(modules);
		}
		IServer server = getServer(runtimeId, runtimeType);
		if (deployableModules != null) {
			configureServer(server, deployableModules, host);
			// if (!isRepublish())
		}

		// run it wide open - need concept of published models
		configureServer(server, configurationModules, host);
		launchServer(server, ILaunchManager.DEBUG_MODE); // TODO get from
		// service
		return null;
	}

	/**
	 * Provides function for converting deployment modules into server tooling IModules. Required
	 * annotations must be defined by the deployment module. Status will be gathered and reported if
	 * a module fails to resolve.
	 * 
	 * @since 1.0
	 * @return IModule[] for resolved deployment modules
	 */

	protected List getServerModules(Unit[] deploymentModules) {
		List serverModules = new ArrayList(deploymentModules.length);

		for (int i = 0; i < deploymentModules.length; i++) {
			Unit module = deploymentModules[i];
			List annotations = module.getAnnotations();
			String moduleURI = getModuleURI(annotations);
			if (moduleURI == null) {
				moduleURI = getFileArtifactModuleURI(module);
				if (moduleURI == null) {
					String errMsg = NLS.bind(
							DeployIdeMessages.ServerToolUnitPublisher_Module_URI_not_set,
							new Object[] { module.getName() });
					reportErrorStatus(module, errMsg, null);
				}
			}

			String moduleType = getModuleType(annotations);
			if (moduleType == null) {
				String errMsg = NLS.bind(DeployIdeMessages.ServerToolUnitPublisher_Module_type_not_set,
						new Object[] { module.getName() });
				reportErrorStatus(module, errMsg, null);
			}
			IModule serverModule = findServerModule(moduleType, moduleURI);
			if (serverModule == null) {
				String errMsg = NLS.bind(
						DeployIdeMessages.ServerToolUnitPublisher_Server_module_could_not_be_found,
						new Object[] { moduleURI });
				reportErrorStatus(module, errMsg, null);
			} else {
				if (deploymentModules[i].getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
					uninstallModules.add(serverModule);
				} else {
					serverModules.add(serverModule);
				}
			}
		}
		return serverModules;
	}

	private String getFileArtifactModuleURI(Unit module) {
		List artifacts = module.getArtifacts();
		for (Iterator iter = artifacts.iterator(); iter.hasNext();) {
			FileArtifact artifact = (FileArtifact) iter.next();
			List uris = artifact.getFileURIs();
			if (uris == null) {
				return null;
			}
			String moduleUri = (String) uris.get(0);
			return UnitUtil.getProjectName(moduleUri);
		}
		return null;

	}

	private String getProjectUri(String moduleUri) {
		Path path = new Path(moduleUri);
		String resource = path.lastSegment();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(resource);
		if (project.exists()) {
			return resource;
		}
		return null;
	}

	/**
	 * Resolves a module name from a module uri
	 * 
	 * @since 1.0
	 * @return String project or module name in the workspace
	 */

	private String getDeployModuleName(String moduleURI) {
		URI uri = URI.createURI(moduleURI);
		String deployedName = null;
		try {
			deployedName = ModuleURIUtil.getDeployedName(uri);
		} catch (UnresolveableURIException e) {
			deployedName = moduleURI;
		}
		return deployedName;
	}

	/**
	 * Function uses sever tooling api to find an IModule for a given project
	 * 
	 * @see ServerUtil.getModules()
	 * @since 1.0
	 * @return IModule for a resolved deployment module
	 */

	private IModule findServerModule(String moduleType, String moduleURI) {
		if (moduleType == null || moduleURI == null) {
			return null;
		}
		IModule[] modules = ServerUtil.getModules(moduleType);
		String deployedName = getDeployModuleName(moduleURI);
		for (int i = 0; i < modules.length; i++) {
			IModule module = modules[i];
			if (module.getName().equals(deployedName)) {
				return module;
			}

		}
		return null;
	}

	// ***Server creation

	/**
	 * Queries environment for user defined server configuration. This id provides a bridge between
	 * deployment models and the server tooling environment
	 * 
	 * @since 1.0
	 * @return IRuntime, runtime instance used for configurations
	 */

	private IRuntime getRuntime(String runtimeId) {
		IRuntime[] runtimes = ServerCore.getRuntimes();
		for (int i = 0; i < runtimes.length; i++) {
			IRuntime runtime = runtimes[i];
			String name = runtime.getId();
			if (name.equals(runtimeId)) {
				return runtime;
			}

		}
		return null;
	}

	/**
	 * Queries environment for client defined server types. The serverType relating to the runtime
	 * type will be used to create a server instance.
	 * 
	 * @since 1.0
	 * @return IServerType
	 */

	private IServerType getServerType(String runtimeType) {
		IServerType[] serverTypes = ServerCore.getServerTypes();
		for (int i = 0; i < serverTypes.length; i++) {
			IServerType type = serverTypes[i];
			String id = type.getRuntimeType().getId();
			if (id.equals(runtimeType)) {
				return type;
			}

		}
		return null;
	}

	/**
	 * Checks for an existing server instance. If instance is found creates a working copy for
	 * configuration modificaiton.
	 * 
	 * @since 1.0
	 * @return IServer, if not found return null to signal creation of server.
	 */

	private IServer getExistingServer(IRuntime currentRuntime) {
		IServer[] servers = ServerCore.getServers();
		for (int i = 0; i < servers.length; i++) {
			IServer server = servers[i];
			IRuntime runtime = server.getRuntime();
			if (runtime == currentRuntime) {
				setServerWC(server.createWorkingCopy());
				return server;
			}
		}
		return null;
	}

	/**
	 * Determines if runtime id has an existing server defined. If does not exist then create.
	 * 
	 * @since 1.0
	 * @return IServer
	 */

	protected IServer getServer(String runtimeId, String serverTypeId) {
		IServerType serverType = getServerType(serverTypeId);
		IRuntime runtime = getRuntime(runtimeId);
		IServer serverInst = getExistingServer(runtime);
		try {
			Platform.getJobManager().join(jobContext, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (serverInst == null) {
			serverInst = createServer(serverType, runtime);
		} else {
			setRepublish(true);
		}

		return serverInst;

	}

	/**
	 * Saves cached working copy creating a server instance. Configurations are peristed out to
	 * server files.
	 * 
	 * @since 1.0
	 * @return IServer
	 */

	private IServer createServer(IServerType serverType, IRuntime runtime) {
		IServer server = null;
		try {
			createServerWorkingCopy(serverType, runtime);
			getServerWC().setRuntime(runtime);
			server = getServerWC().save(false, new NullProgressMonitor());

		} catch (CoreException e) {
			e.printStackTrace();
			// Throw error
			// reportErrorStatus("");
		}

		return server;
	}

	/**
	 * Creates a reference to a server file in memory for configuration updates. Cached working copy
	 * used throughout publish process.
	 * 
	 * @since 1.0
	 */
	private void createServerWorkingCopy(IServerType serverType, IRuntime runtime)
			throws CoreException {
		if (getServerWC() == null) {
			try {
				setServerWC(serverType.createServer(null, null, runtime, pub_monitor));
				ServerUtil.setServerDefaultName(serverWC);
				((ServerWorkingCopy) getServerWC()).importConfiguration(runtime, pub_monitor);

			} catch (CoreException e) {
				// reportErrorStatus(e.getMessage());
				throw e;
			}
		}

	}

	/**
	 * Retrieve sever working copy used throughout publish process. Clients should override for
	 * configuration:
	 * 
	 * @see configureServer
	 * @see variable serverWC defination
	 * @since 1.0
	 * @return IServerWorkingCopy
	 */

	protected IServerWorkingCopy getServerWC() {
		return serverWC;
	}

	/**
	 * Setter used for caching working copy
	 * 
	 * @see variable serverWC defination
	 * @since 1.0
	 */

	private void setServerWC(IServerWorkingCopy serverWC) {
		this.serverWC = serverWC;
	}

	// server configuration

	/**
	 * Intended for clients to override. Each client will be passed a server instance, and deployment
	 * configuration models.
	 * 
	 * @since 1.0
	 * @return IStatus, error status will be reported and gathered
	 */

	abstract protected IStatus configureServer(IServer server, Unit[] units, Unit host);

	/**
	 * Provides function updating or removing server modules for a server configuration.
	 * 
	 * @since 1.0
	 */

	protected void configureServer(IServer server, List moduleList, Unit host) {

		if (uninstallModules != null && uninstallModules.size() > 0) {
			moduleList = trimDeployedModules(server, uninstallModules);
		}
		if (moduleList.size() > 0) {
			IModule[] deployModules = toIModuleArray(moduleList);
			loadModules(server, serverWC, deployModules, host);
		}

	}

	/**
	 * Using the cached server working copy, modules are modified and persisted to the server
	 * resource cached in memory.
	 * 
	 * @since 1.0
	 */

	private void loadModules(IServer server, IServerWorkingCopy copy, IModule[] modules, Unit host) {
		try {
			serverWC = server.createWorkingCopy();
			if (isUnPublish()) {
				ServerUtil.modifyModules(serverWC, new IModule[0], modules, null);
			} else {
				ServerUtil.modifyModules(serverWC, modules, new IModule[0], null);
			}
			serverWC.setRuntime(server.getRuntime());
			serverWC.save(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			String errMsg = NLS.bind(e.getMessage(), new Object[] { server.getName() });
			reportErrorStatus(host, errMsg, null);
		}
	}

	/**
	 * For performance list are converted to []
	 * 
	 * @since 1.0
	 * @return IModule[]
	 */

	private IModule[] toIModuleArray(List moduleList) {
		if (moduleList == null) {
			return null;
		}
		return (IModule[]) moduleList.toArray(new IModule[moduleList.size()]);

	}

	/**
	 * For performance list are converted to []
	 * 
	 * @since 1.0
	 * @return IModule[]
	 */

	private Unit[] toConfigurationArray(List moduleList) {
		if (moduleList == null) {
			return null;
		}
		return (Unit[]) moduleList.toArray(new Unit[moduleList.size()]);

	}

	/**
	 * Function provides merging new modules and with existing. Occurs when modifing an existing
	 * server instance.
	 * 
	 * @since 1.0
	 * @return List
	 */

	private List trimDeployedModules(IServer server, List moduleList) {
		IModule[] currentDeployedModules = server.getModules();
		for (int i = 0; i < currentDeployedModules.length; i++) {
			IModule module = currentDeployedModules[i];
			if (moduleList.contains(module)) {
				moduleList.remove(module);
			}
		}
		return moduleList;

	}

	/**
	 * Sets publisher in unpublish mode
	 */

	private boolean isUnPublish() {
		return false;
	}

	// ****Launch servers

	/**
	 * Delegates server starting, stopping and launching of clients.
	 * 
	 * @since 1.0
	 */

	protected void launchServer(IServer server, String launchMode) {

		// get the launchable adapter and module object
		processLaunchClientAdapters(server, launchMode);
		int state = server.getServerState();
		switch (state)
		{
		case IServer.STATE_STARTED: {
			Job job = updateStartedServer(server, launchMode);

			scheduleJob(job);
			break;
		}
		case IServer.STATE_STOPPED: {
			Job job = updateStoppedServer(server, launchMode);
			scheduleJob(job);
			break;
		}
		default:
			break;
		}

	}

	protected void scheduleJob(Job job) {
		PublishFamilyMember member = new PublishFamilyMember(job, job.getName(),
				IPublisherConstants.DEPLOY_TOOLS_PUBLISH_FAMILY_NAME);
		member.setFamilyPriority(3);
		PublishFamilyManager.instance().addMember(member);
	}

	/**
	 * Launchables define a work of unit to be perfomed after the server is running. For instance a
	 * browser opening with a url.
	 * 
	 * @since 1.0
	 */

	private void processLaunchClientAdapters(IServer server, String launchMode) {
		// need default module
		// IModule[] modules = new IModule[] { module }; // TODO: get parent
		// ILaunchableAdapter launchableAdapter = null;
		Object launchable = null;
		ILaunchableAdapter[] adapters = ServerPlugin.getLaunchableAdapters();
		if (adapters != null) {
			int size2 = adapters.length;
			for (int j = 0; j < size2; j++) {
				ILaunchableAdapter adapter = adapters[j];
				try {
					Object launchable2 = adapter.getLaunchable(server, null);
					if (launchable2 != null) {
						// launchableAdapter = adapter;
						launchable = launchable2;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		IClient[] clients = new IClient[0];
		if (launchable != null) {
			clients = getClients(server, launchable, launchMode);
		}
		// IClient client = null;
		if (clients == null || clients.length == 0) {
			// System.out.println("no clients");
		} else if (clients.length == 1) {
			// client = clients[0];
		} else {
			return;
		}

	}

	/**
	 * Starts a server that has been stopped for configuration.
	 */

	private Job updateStoppedServer(IServer server, String launchMode) {
		PublishServerJob publishJob = new PublishServerJob(server);
		publishJob.setRule(PublishFamilyManager.instance().getMutex());
		publishJob.setProgressGroup(pub_monitor, 60);
		pub_monitor.setTaskName(publishJob.getName());
		StartServerJob startServerJob = new StartServerJob(server, launchMode);
		startServerJob.setProgressGroup(pub_monitor, 70);
		if (((ServerType) server.getServerType()).startBeforePublish()) {
			startServerJob.setNextJob(publishJob);
			// publishJob.setNextJob(clientJob);
			return startServerJob;
		} else {
			publishJob.setNextJob(startServerJob);
			// startServerJob.setNextJob(clientJob);
			return publishJob;
		}

	}

	/**
	 * Either stops a server for configuration updates and restarts or provides running
	 * configuration.
	 */

	private Job updateStartedServer(IServer server, String launchMode) {
		boolean restart = false;
		String mode = server.getMode();
		if (!ILaunchManager.DEBUG_MODE.equals(mode) && ILaunchManager.DEBUG_MODE.equals(launchMode)) {
			int result = 1;
			if (result == 1) {
				launchMode = mode;
			} else if (result == 0) {
				restart = true;
			} else {
				return null;
			}
		} else if (!ILaunchManager.PROFILE_MODE.equals(mode)
				&& ILaunchManager.PROFILE_MODE.equals(launchMode)) {
			int result = 1;
			if (result == 1) {
				launchMode = mode;
			} else if (result == 0) {
				restart = true;
			} else {
				return null;
			}
		}
		// restart = true;
		PublishServerJob publishJob = new PublishServerJob(server);
		publishJob.setProgressGroup(pub_monitor, 60);
		pub_monitor.setTaskName(publishJob.getName());
		if (restart) {
			RestartServerJob restartJob = new RestartServerJob(server, launchMode);
			restartJob.setProgressGroup(pub_monitor, 60);
			restartJob.schedule();
			publishJob.setNextJob(restartJob);
		}

		return publishJob;
	}

	/**
	 * Retrieves clients from server api applicable to the server and launch mode.
	 */

	protected IClient[] getClients(IServer server, Object launchable, String launchMode) {
		ArrayList list = new ArrayList();
		IClient[] clients = ServerPlugin.getClients();
		if (clients != null) {
			int size = clients.length;
			for (int i = 0; i < size; i++) {
				if (clients[i].supports(server, launchable, launchMode)) {
					list.add(clients[i]);
				}
			}
		}
		IClient[] clients2 = new IClient[list.size()];
		list.toArray(clients2);
		return clients2;
	}

	public boolean isRepublish() {
		return republish;
	}

	public void setRepublish(boolean republish) {
		this.republish = republish;
	}

	protected String getUniquePort() {
		int n = 10000;
		int i = rand.nextInt(n + 1);
		while (SocketUtil.isPortInUse(i, 5)) {
			i = rand.nextInt(n + 1);
		}
		return Integer.toString(i);
	}

	/**
	 * Annotations interated through to find a module type. A module type, is a common string like
	 * jst.web or jst.ejb used to narrow the search for IModules.
	 * 
	 * @see getServerModules(Modules[])
	 * @since 1.0
	 * @return String, a module type
	 */

	protected String getModuleType(List annotations) {
		for (Iterator iter = annotations.iterator(); iter.hasNext();) {
			Annotation element = (Annotation) iter.next();
			Object obj = element.getDetails().get(IAnnotationConstants.MODULE_TYPE);
			if (obj != null && obj instanceof String) {
				return (String) obj;
			}
		}
		return null;
	}

	protected String getModuleURI(List annotations) {
		for (Iterator iter = annotations.iterator(); iter.hasNext();) {
			Annotation element = (Annotation) iter.next();
			Object obj = element.getDetails().get(IAnnotationConstants.PROJECT_NAME);
			if (obj != null && obj instanceof String) {
				return (String) obj;
			}
		}
		return null;

	}
}
