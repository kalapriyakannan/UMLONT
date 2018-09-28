/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.unitprovider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jst.j2ee.application.Application;
import org.eclipse.jst.j2ee.applicationclient.componentcore.util.AppClientArtifactEdit;
import org.eclipse.jst.j2ee.client.ApplicationClient;
import org.eclipse.jst.j2ee.componentcore.util.EARArtifactEdit;
import org.eclipse.jst.j2ee.ejb.EJBJar;
import org.eclipse.jst.j2ee.ejb.componentcore.util.EJBArtifactEdit;
import org.eclipse.jst.j2ee.internal.project.J2EEProjectUtilities;
import org.eclipse.jst.j2ee.web.componentcore.util.WebArtifactEdit;
import org.eclipse.jst.j2ee.webapplication.WebApp;
import org.eclipse.wst.common.componentcore.ComponentCore;
import org.eclipse.wst.common.componentcore.internal.resources.VirtualArchiveComponent;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
import org.eclipse.wst.common.componentcore.resources.IVirtualFolder;
import org.eclipse.wst.common.componentcore.resources.IVirtualReference;
import org.eclipse.wst.common.componentcore.resources.IVirtualResource;
import org.eclipse.wst.common.project.facet.core.runtime.IRuntime;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ICapabilityProviderService;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.j2ee.AppClient;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JCAModule;
import com.ibm.ccl.soa.deploy.j2ee.JarModule;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider.ServerRuntimeUtils;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEDeployUtils;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEModuleUnitProvider;

public class IDEJ2EEModuleUnitProvider extends J2EEModuleUnitProvider {

	private final String KEY_BASE_J2EE = "j2ee."; //$NON-NLS-1$

	private final String KEY_BASE_EJB = "ejb."; //$NON-NLS-1$

	private final String KEY_BASE_SERVLET = "servlet."; //$NON-NLS-1$

	private final String KEY_BASE_JSP = "jsp."; //$NON-NLS-1$

	String moduleType = null;

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		TopologyUnitStub[] stubs = NO_STUBS;
		if (anInputObject instanceof IAdaptable) {
			IProject project = J2EEDeployUtils.getProject((IAdaptable) anInputObject);
			stubs = new TopologyUnitStub[1];
			Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
			annotation.getDetails().put(IAnnotationConstants.PROJECT_NAME, project.getName());
			annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
			stubs[0] = new TopologyUnitStub(project.getName(), null, annotation, project);
		} else {
			stubs = super.resolveStubs(anInputObject);
		}
		return stubs;
	}

	public Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor) {
		List modules = new ArrayList();

		Annotation stubAnnotation = aStub.getAnnotation();
		String projectName = (String) stubAnnotation.getDetails().get(
				IAnnotationConstants.PROJECT_NAME);

		if (null != projectName) {
			IProject project = ProjectUtilities.getProject(projectName);

			modules.addAll(Arrays.asList(resolveUnit(project, aStub,
					new ArrayList<IVirtualComponent>())));
		}

		return modules.toArray(new DeployModelObject[modules.size()]);
	}

	protected Unit[] resolveUnit(IProject project, TopologyUnitStub aStub,
			List<IVirtualComponent> alreadyVisited) {
		List units = new ArrayList();
		Unit module = resolveModule(project, aStub);
		if (module != null) {
			units.add(module);
			List<Unit> contained = resolveContainedUnits(project, alreadyVisited);
			if (contained.size() > 0) {
				for (Iterator iter = contained.iterator(); iter.hasNext();) {
					Unit bUnit = (Unit) iter.next();

					Annotation annotation = bUnit.findAnnotation(ENVIRONMENT_J2EE_JARMODULE);
					if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(module.getEObject().eClass())
							&& J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(bUnit.getEObject().eClass())
							&& annotation != null) {
						// skip
					} else {
						LinkFactory.createMemberLink(module, bUnit);
					}

					if (annotation != null
							&& J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(module.getEObject().eClass())) {
						bUnit.getAnnotations().remove(annotation);
					}

					units.add(bUnit);
				}
				resolveLinks(units);
			}
		}
		return (Unit[]) units.toArray(new Unit[units.size()]);
	}

	protected List<Unit> resolveContainedUnits(IProject project,
			List<IVirtualComponent> alreadyVisited) {

		List<Unit> units = new ArrayList<Unit>();
		if (alreadyVisited == null) {
			alreadyVisited = new ArrayList<IVirtualComponent>();
		}

		IVirtualComponent component = null;

		try {
			component = ComponentCore.createComponent(project);
		} catch (RuntimeException re) {
			return Collections.emptyList();
		}

		if (alreadyVisited.contains(component)) {
			return Collections.emptyList();
		}

		alreadyVisited.add(component);

		if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EAR_FACET_ID)) {

			IVirtualReference[] newReferences = component.getReferences();
			if (newReferences.length > 0) {
				List<IVirtualReference> newReferencesList = Arrays.asList(newReferences);
				newReferencesList.removeAll(alreadyVisited);

				units.addAll(findVirtualReferences(newReferencesList, alreadyVisited));

			}
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.WEB_FACET_ID)) {

			IVirtualFolder root = component.getRootFolder();
			IVirtualFolder webinf = root.getFolder(WebArtifactEdit.WEBLIB);

			IVirtualResource[] resources = new IVirtualResource[0];
			try {
				resources = webinf.members();
			} catch (CoreException ex) {
				IDEPlugin.logError(0, ex.getMessage(), ex);
			}
			List<IVirtualResource> libsToIntrospect = new ArrayList<IVirtualResource>(Arrays
					.asList(resources));

			IVirtualReference[] newReferences = component.getReferences();

			if (newReferences.length > 0) {
				//Process references 
				List<IVirtualReference> newReferencesList = new ArrayList<IVirtualReference>();
				newReferencesList.addAll(Arrays.asList(newReferences));
				newReferencesList.removeAll(alreadyVisited);

				int webLibLength = -1;
				for (Iterator<IVirtualReference> it = newReferencesList.iterator(); it.hasNext();) {
					IVirtualReference reference = it.next();
					if (!WebArtifactEdit.WEBLIB.equals(reference.getRuntimePath())) {
						//The reference is not a web lib reference.
						it.remove();
						continue;
					}
					if (reference.getArchiveName() == null) {
						//We don't have an archive file...we have a project reference.
						continue;
					}
					if (webLibLength == -1) {
						webLibLength = WebArtifactEdit.WEBLIB.toString().length();
					}
					String refArchiveName = reference.getArchiveName().substring(webLibLength,
							reference.getArchiveName().length());
					for (int k = 0; k < resources.length; k++) {
						IVirtualResource resource = resources[k];
						String resArchiveName = resource.getName();
						if (resArchiveName.equals(refArchiveName)) {
							libsToIntrospect.remove(resource);
							break;
						}
					}
				}
				units.addAll(findVirtualReferences(newReferencesList, alreadyVisited));

			}
			units.addAll(findVirtualResources(libsToIntrospect));
			for (Iterator<Unit> iter = units.iterator(); iter.hasNext();) {
				Unit unit = iter.next();
				Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
				annotation.setContext(ENVIRONMENT_J2EE_JARMODULE);
				annotation.getDetails().put(IS_UTILITY_JAR_FROM_WAR_FILE, Boolean.TRUE.toString());
				unit.getAnnotations().add(annotation);
			}
		}

		return units;
	}

	private List<Unit> findVirtualResources(List<IVirtualResource> references) {
		if (references.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		List<Unit> units = new ArrayList<Unit>();
		for (Iterator<IVirtualResource> iter = references.iterator(); iter.hasNext();) {
			IVirtualResource resource = iter.next();
			if (resource.getFileExtension().equalsIgnoreCase("jar")) { //$NON-NLS-1$
				TopologyUnitStub[] stubs = super.resolveStubs(resource.getUnderlyingResource());
				if (stubs.length > 0) {
					Object[] modules = super.resolveUnit(stubs[0], false, new NullProgressMonitor());
					if (modules != null) {
						for (int i = 0; i < modules.length; i++) {
							if (modules[i] instanceof Unit) {
								Unit aModule = (Unit) modules[i];
								if (J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(aModule.getEObject()
										.eClass())) {
									removeOSRequirement(aModule);
								}
								units.add(aModule);
							}
						}
					}
				}
			}
		}

		return units;
	}

	private List<Unit> findVirtualReferences(List<IVirtualReference> references,
			List<IVirtualComponent> alreadyVisited) {
		if (references.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		List<Unit> units = new ArrayList<Unit>();
		for (Iterator<IVirtualReference> iter = references.iterator(); iter.hasNext();) {
			IVirtualReference reference = iter.next();
			collectReferencedUnits(reference, units, alreadyVisited);
		}

		return units;
	}

	private void collectReferencedUnits(IVirtualReference reference, List<Unit> units,
			List<IVirtualComponent> alreadyVisited) {
		IVirtualComponent component = reference.getReferencedComponent();
		if (component != null) {
			if (!component.isBinary()) {
				IProject componentProj = component.getProject();
				if (componentProj != null) {
					TopologyUnitStub[] stubs = resolveStubs(componentProj);
					if (stubs.length > 0) {
						Unit[] modules = resolveUnit(componentProj, stubs[0], alreadyVisited);
						if (modules != null) {
							for (int i = 0; i < modules.length; i++) {
								Unit aModule = modules[i];
								if (J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(aModule.getEObject()
										.eClass())) {
									removeOSRequirement(aModule);
								}
								units.add(aModule);
							}
						}
					}
				}
			} else {
				if (component instanceof VirtualArchiveComponent) {
					VirtualArchiveComponent archiveComponent = (VirtualArchiveComponent) component;
					TopologyUnitStub[] stubs = super.resolveStubs(archiveComponent
							.getUnderlyingWorkbenchFile());
					if (stubs.length > 0) {
						Object[] modules = super.resolveUnit(stubs[0], false, new NullProgressMonitor());
						if (modules != null) {
							for (int i = 0; i < modules.length; i++) {
								if (modules[i] instanceof Unit) {
									Unit aModule = (Unit) modules[i];
									if (J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(aModule.getEObject()
											.eClass())) {
										removeOSRequirement(aModule);
									}
									units.add(aModule);
								}
							}
						}
					}
				}
			}
		}
	}

	protected Unit resolveModule(IProject project, TopologyUnitStub aStub) {
		Unit module = null;
		Annotation stubAnnotation = aStub.getAnnotation();

		if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.WEB_FACET_ID)) {
			module = resolveWebModule(project);
			moduleType = J2EEDeployUtils.WEB_FACET_ID;
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EAR_FACET_ID)) {
			moduleType = J2EEDeployUtils.EAR_FACET_ID;
			module = resolveEarModule(project);
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EJB_FACET_ID)) {
			module = resolveEjbModule(project);
			moduleType = J2EEDeployUtils.EJB_FACET_ID;
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JCA_FACET_ID)) {
			module = resolveJCAModule(project);
			moduleType = J2EEDeployUtils.JCA_FACET_ID;
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.APPCLIENT_FACET_ID)) {
			module = resolveAppClient(project);
			moduleType = J2EEDeployUtils.APPCLIENT_FACET_ID;
		} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JAVA_FACET_ID)) {
			module = resolveUtilityModule(project);
			moduleType = J2EEDeployUtils.JAVA_FACET_ID;
		}

		if (module != null) {
			//NM: this annotation is needed to indicate export of how this unit was created
			Annotation annotation = module.findAnnotation(stubAnnotation.getContext());
			if (annotation == null) {
				annotation = CoreFactory.eINSTANCE.createAnnotation();
				annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
				module.getAnnotations().add(annotation);
			}
			annotation.getDetails().put(IAnnotationConstants.PROJECT_NAME, project.getName());
			annotation.getDetails().put(IAnnotationConstants.MODULE_TYPE, moduleType);
			addFileArtifact(module, URI.createPlatformResourceURI(
					project.getFullPath().toPortableString()).toString());
		}

		return module;
	}

	protected WebModule resolveWebModule(IProject webProject) {
		WebModule webModule = J2eeFactory.eINSTANCE.createWebModule();
		String s = webProject.getName();
		webModule.setName(UnitUtil.fixNameForID(s));
		webModule.setDisplayName(s);
		addServerRuntimeRequirement(webProject, webModule);

		WebArtifactEdit edit = null;
		try {
			edit = WebArtifactEdit.getWebArtifactEditForRead(webProject);
			setRequirementsAndCapabilities(webModule, edit.getWebApp());
			setRequirementsAndCapabilities(webModule, webProject);
			ensureUniqueRequirementAndCapabilityNames(webModule);
			// Set context root on existing web module capability
			WebModuleCapability cap = (WebModuleCapability) CapabilityUtil.findCapabilityOfType(
					webModule, J2eePackage.eINSTANCE.getWebModuleCapability());
			if (cap != null) {
				cap.setContextRoot(edit.getServerContextRoot());
			}
		} finally {
			if (edit != null) {
				edit.dispose();
			}
		}
		webModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		return webModule;
	}

	protected EjbModule resolveEjbModule(IProject ejbProject) {
		EjbModule ejbModule = J2eeFactory.eINSTANCE.createEjbModule();
		String s = ejbProject.getName();
		ejbModule.setName(UnitUtil.fixNameForID(s));
		ejbModule.setDisplayName(s);
		addServerRuntimeRequirement(ejbProject, ejbModule);

		EJBArtifactEdit edit = null;
		try {
			edit = EJBArtifactEdit.getEJBArtifactEditForRead(ejbProject);
			setRequirementsAndCapabilities(ejbModule, edit.getEJBJar());
			setRequirementsAndCapabilities(ejbModule, ejbProject);
			ensureUniqueRequirementAndCapabilityNames(ejbModule);
		} finally {
			if (edit != null) {
				edit.dispose();
			}
		}
		ejbModule.setMutable(true);
		ejbModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		return ejbModule;
	}

	protected AppClient resolveAppClient(IProject appClientProject) {
		AppClient appClientModule = J2eeFactory.eINSTANCE.createAppClient();
		String s = appClientProject.getName();
		appClientModule.setName(UnitUtil.fixNameForID(s));
		appClientModule.setDisplayName(s);
		addServerRuntimeRequirement(appClientProject, appClientModule);
		// TODO need to add java req based on project facet

		AppClientArtifactEdit edit = null;
		try {
			edit = AppClientArtifactEdit.getAppClientArtifactEditForRead(appClientProject);
			ApplicationClient applicationClient = edit.getApplicationClient();
			setRequirementsAndCapabilities(appClientModule, applicationClient);
			setRequirementsAndCapabilities(appClientModule, appClientProject);
			ensureUniqueRequirementAndCapabilityNames(appClientModule);
		} finally {
			if (edit != null) {
				edit.dispose();
			}
		}
		appClientModule.setMutable(true);
		appClientModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		return appClientModule;
	}

	protected JCAModule resolveJCAModule(IProject jcaProject) {
		JCAModule jcaModule = J2eeFactory.eINSTANCE.createJCAModule();
		String s = jcaProject.getName();
		jcaModule.setName(UnitUtil.fixNameForID(s));
		jcaModule.setDisplayName(s);
		addServerRuntimeRequirement(jcaProject, jcaModule);
		setRequirementsAndCapabilities(jcaModule, jcaProject);
		ensureUniqueRequirementAndCapabilityNames(jcaModule);

		// TODO - need ConnectorArtifactEdit dependency from somewhere
		/*
		 * ConnectorArtifactEdit edit = null; try { edit =
		 * ConnectorArtifactEdit.getConnectorArtifactEditForRead(jcaProject); Connector connector =
		 * edit.getConnector(); setRequirementsAndCapabilities( jcaModule, connector ); } finally { if
		 * (edit != null) { edit.dispose(); } }
		 */
		jcaModule.setMutable(true);
		jcaModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		return jcaModule;
	}

	protected JarModule resolveUtilityModule(IProject project) {
		JarModule jarModule = J2eeFactory.eINSTANCE.createJarModule();
		String s = project.getName();
		jarModule.setName(UnitUtil.fixNameForID(s));
		jarModule.setDisplayName(s);
		setRequirementsAndCapabilities(jarModule, project);
		ensureUniqueRequirementAndCapabilityNames(jarModule);
		jarModule.setMutable(true);
		jarModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		return jarModule;
	}

	protected EarModule resolveEarModule(IProject earProject) {
		EarModule earModule = J2eeFactory.eINSTANCE.createEarModule();
		earModule.setConceptual(false);
		String s = earProject.getName();
		earModule.setName(UnitUtil.fixNameForID(s));
		earModule.setDisplayName(s);
		addServerRuntimeRequirement(earProject, earModule);
		EARArtifactEdit edit = null;
		try {
			edit = EARArtifactEdit.getEARArtifactEditForRead(earProject);
			setRequirementsAndCapabilities(earModule, edit.getApplication());
			setRequirementsAndCapabilities(earModule, earProject);
			ensureUniqueRequirementAndCapabilityNames(earModule);
		} finally {
			if (edit != null) {
				edit.dispose();
			}
		}
		earModule.setMutable(true);
		earModule.setPublishIntent(PublishIntent.PUBLISH_LITERAL);
		earModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		return earModule;
	}

	protected void addServerRuntimeRequirement(IProject project, Unit module) {
		IRuntime runtime = ServerRuntimeUtils.getPrimaryRuntime(project);

		if (runtime != null) {
			ICapabilityProviderService capabilityProviderService = ExtensionsCore
					.createCapabilityProviderService();

			CapabilityProvider[] providers = capabilityProviderService
					.findEnabledCapabilityProvidersByInputOnly(runtime);
			for (int i = 0; i < providers.length; i++) {
				CapabilityProvider provider = providers[i];
				Object[] requirements = provider.resolveRequirements(runtime);
				Set<Requirement> requiredHostingReqs = new HashSet<Requirement>();
				for (int j = 0; j < requirements.length; j++) {
					requiredHostingReqs.add((Requirement) requirements[j]);
				}

				Requirement accRequiredHostingReqs = combineRequiredHostingRequirements(requiredHostingReqs);
				if (accRequiredHostingReqs != null) {
					boolean foundHostingReq = false;
					for (Iterator iter = module.getRequirements().iterator(); iter.hasNext()
							&& !foundHostingReq;) {
						Requirement req = (Requirement) iter.next();
						if (req.getLinkType().equals(RequirementLinkTypes.HOSTING_LITERAL)) {
							foundHostingReq = true;
							req.getConstraints().addAll(accRequiredHostingReqs.getConstraints());
						}
					}

					if (!foundHostingReq) {
						module.getRequirements().add(accRequiredHostingReqs);
					}
				}

				Annotation annotation = module.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
				if (annotation == null) {
					annotation = CoreFactory.eINSTANCE.createAnnotation();
					annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
				}

				annotation.getDetails().put(IAnnotationConstants.RUNTIME_ID, runtime.getName());
				annotation.getDetails().put(IAnnotationConstants.RUNTIME_TYPE,
						ServerRuntimeUtils.getRuntimeId(runtime));
				module.getAnnotations().add(annotation);

			}
		}
	}

	public Object resolveUnderlyingResource(Unit unit, IProgressMonitor aMonitor) {

		IProject project = null;
		List resources = new ArrayList(2);
		String uri = null;

		List artifacts = unit.getArtifacts();
		if (artifacts != null && artifacts.size() > 0) {
			FileArtifact file = (FileArtifact) artifacts.get(0);
			if (file != null && file.getFileURIs() != null && file.getFileURIs().size() > 0) {
				URI projectUri = URI.createURI((String) file.getFileURIs().get(0));
				int lastSegment = projectUri.segmentCount();
				uri = projectUri.segment(lastSegment - 1);
			}

		}

		if (uri == null) {
			return null;
		}

		project = ResourcesPlugin.getWorkspace().getRoot().getProject(uri);

		if (project.exists()) {
			resources.add(project);
			if (J2EEProjectUtilities.isDynamicWebProject(project)) {
				WebArtifactEdit edit = null;
				try {
					edit = WebArtifactEdit.getWebArtifactEditForRead(project);
					WebApp webApp = edit.getWebApp();
					resources.add(webApp.eResource());
				} catch (WrappedException exception) {
					exception.printStackTrace();
				} finally {
					if (null != edit) {
						edit.dispose();
					}
				}
			} else if (J2EEProjectUtilities.isEJBProject(project)) {
				EJBArtifactEdit edit = null;
				try {
					edit = EJBArtifactEdit.getEJBArtifactEditForRead(project);
					EJBJar ejbJar = edit.getEJBJar();
					resources.add(ejbJar.eResource());
				} catch (WrappedException exception) {
					exception.printStackTrace();
				} finally {
					if (null != edit) {
						edit.dispose();
					}
				}
			} else if (J2EEProjectUtilities.isEARProject(project)) {
				EARArtifactEdit edit = null;
				try {
					edit = EARArtifactEdit.getEARArtifactEditForRead(project);
					Application app = edit.getApplication();
					resources.add(app.eResource());
				} catch (WrappedException exception) {
					exception.printStackTrace();
				} finally {
					if (null != edit) {
						edit.dispose();
					}
				}
			} else if (J2EEProjectUtilities.isApplicationClientProject(project)) {
				AppClientArtifactEdit edit = null;
				try {
					edit = AppClientArtifactEdit.getAppClientArtifactEditForRead(project);
					ApplicationClient applicationClient = edit.getApplicationClient();
					resources.add(applicationClient.eResource());
				} catch (WrappedException exception) {
					exception.printStackTrace();
				} finally {
					if (null != edit) {
						edit.dispose();
					}
				}
			}
		} else {
			resources = (List) super.resolveUnderlyingResource(unit, aMonitor);
		}

		return resources;
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
