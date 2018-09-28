/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jst.j2ee.application.Application;
import org.eclipse.jst.j2ee.client.ApplicationClient;
import org.eclipse.jst.j2ee.commonarchivecore.internal.ApplicationClientFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.Archive;
import org.eclipse.jst.j2ee.commonarchivecore.internal.CommonarchiveFactory;
import org.eclipse.jst.j2ee.commonarchivecore.internal.CommonarchivePackage;
import org.eclipse.jst.j2ee.commonarchivecore.internal.EARFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.EJBJarFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.RARFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.WARFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.exception.OpenFailureException;
import org.eclipse.jst.j2ee.core.internal.plugin.CatalogJ2EEXmlDtDEntityResolver;
import org.eclipse.jst.j2ee.ejb.EJBJar;
import org.eclipse.jst.j2ee.internal.xml.J2EEXmlDtDEntityResolver;
import org.eclipse.jst.j2ee.jca.Connector;
import org.eclipse.jst.j2ee.webapplication.WebApp;
import org.eclipse.wst.common.internal.emf.resource.EMF2SAXRendererFactory;
import org.eclipse.wst.common.internal.emf.resource.RendererFactory;
import org.eclipse.wst.common.internal.emf.utilities.DOMUtilities;
import org.xml.sax.EntityResolver;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ICapabilityProviderService;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.j2ee.AppClient;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployPlugin;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JCAModule;
import com.ibm.ccl.soa.deploy.j2ee.JarModule;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.os.OsPackage;

public class J2EEModuleUnitProvider extends UnitProvider {

	private static final String REQUIREMENT = "Requirement"; //$NON-NLS-1$
	private static final String CAPABILITY = "Capability"; //$NON-NLS-1$
	protected static final String ENVIRONMENT_J2EE_JARMODULE = "environment_j2ee_jarmodule"; //$NON-NLS-1$
	protected static final String IS_UTILITY_JAR_FROM_WAR_FILE = "isUtilityJarFromWarFile"; //$NON-NLS-1$

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		TopologyUnitStub[] stubs = NO_STUBS;
		if (anInputObject instanceof IFile) {
			IFile file = (IFile) anInputObject;
			stubs = new TopologyUnitStub[1];
			Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
			String uri = file.getRawLocation().toOSString();
			annotation.getDetails().put(IAnnotationConstants.ARCHIVE_URI, uri);
			annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
			stubs[0] = new TopologyUnitStub(uri, null, annotation, file);
		} else if (anInputObject instanceof Archive) {
			Archive archive = (Archive) anInputObject;
			stubs = new TopologyUnitStub[1];
			Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
			annotation.getDetails().put(IAnnotationConstants.ARCHIVE_URI, archive.getURI());
			annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
			stubs[0] = new TopologyUnitStub(archive.getURI(), null, annotation, archive);
		}
		return stubs;
	}

	public Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor) {
		List modules = new ArrayList();

		// Disable SSE renderer
		RendererFactory originalRendererFactory;
		originalRendererFactory = RendererFactory.getDefaultRendererFactory();

		// Use CatalogJ2EEXmlDtDEntityResolver
		EntityResolver originalEntityResolver = DOMUtilities.getDefaultEntityResolver();

		try {

			// Disable SSE renderer
			RendererFactory.setDefaultRendererFactory(EMF2SAXRendererFactory.INSTANCE);

			// Use CatalogJ2EEXmlDtDEntityResolver
			J2EEXmlDtDEntityResolver.INSTANCE = new CatalogJ2EEXmlDtDEntityResolver();
			DOMUtilities.setDefaultEntityResolver(J2EEXmlDtDEntityResolver.INSTANCE);

			Annotation stubAnnotation = aStub.getAnnotation();
			String archiveURI = (String) stubAnnotation.getDetails().get(
					IAnnotationConstants.ARCHIVE_URI);

			if (null != archiveURI) {
				Archive archive = null;
				CommonarchivePackage pkg = CommonarchivePackage.eINSTANCE;
				CommonarchiveFactory factory = pkg.getCommonarchiveFactory();
				try {
					archive = factory.openArchive(archiveURI);
					modules.addAll(Arrays.asList(resolveUnit(archive, aStub)));
				} catch (OpenFailureException e) {
					J2EEDeployPlugin.logError(0, e.getMessage(), e);
				} finally {
					if (null != archive) {
						archive.close();
					}
				}
			}

		} finally {

			// Restore original entity resolver
			DOMUtilities.setDefaultEntityResolver(originalEntityResolver);

			// Restore original renderer
			RendererFactory.setDefaultRendererFactory(originalRendererFactory);
		}

		return modules.toArray(new DeployModelObject[modules.size()]);
	}

	protected Unit[] resolveUnit(Archive archive, TopologyUnitStub aStub) {
		List units = new ArrayList();
		Unit aModule = resolveModule(archive, aStub);
		if (aModule != null) {
			units.add(aModule);
			List contained = Arrays.asList(resolveContainedUnits(archive));
			if (contained.size() > 0) {
				for (Iterator iter = contained.iterator(); iter.hasNext();) {
					Unit bUnit = (Unit) iter.next();

					List<FileArtifact> artifacts = aModule.getArtifacts();
					if (artifacts.size() > 0) {
						FileArtifact artifact = (FileArtifact) aModule.getArtifacts().get(0);
						if (artifact != null) {
							bUnit.getArtifacts().clear();
							addFileArtifact(bUnit, (String) artifact.getFileURIs().get(0));
						}
					}

					Annotation annotation = bUnit.findAnnotation(ENVIRONMENT_J2EE_JARMODULE);
					if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(aModule.getEObject().eClass())
							&& J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(bUnit.getEObject().eClass())
							&& annotation != null) {
						// skip
					} else {
						LinkFactory.createMemberLink(aModule, bUnit);
					}

					if (annotation != null
							&& J2eePackage.Literals.EAR_MODULE
									.isSuperTypeOf(aModule.getEObject().eClass())) {
						bUnit.getAnnotations().remove(annotation);
					}
					units.add(bUnit);
				}
				resolveLinks(units);
			}
		}
		return (Unit[]) units.toArray(new Unit[units.size()]);
	}

	protected Unit[] resolveContainedUnits(Archive archive) {
		List units = new ArrayList();
		if (archive.isEARFile()) {
			EARFile earFile = (EARFile) archive;
			List<Unit> references = findReferences(earFile.getArchiveFiles());
			units.addAll(references);
		} else if (archive.isWARFile()) {
			WARFile warFile = (WARFile) archive;
			List<Unit> references = findReferences(warFile.getLibArchives());
			for (Iterator<Unit> iter = references.iterator(); iter.hasNext();) {
				Unit unit = iter.next();
				Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
				annotation.setContext(ENVIRONMENT_J2EE_JARMODULE);
				annotation.getDetails().put(IS_UTILITY_JAR_FROM_WAR_FILE, "true"); //$NON-NLS-1$
				unit.getAnnotations().add(annotation);
			}
			units.addAll(references);
		}
		return (Unit[]) units.toArray(new Unit[units.size()]);
	}

	protected List<Unit> findReferences(List files) {
		List<Unit> units = new ArrayList<Unit>();
		for (Iterator iter = files.iterator(); iter.hasNext();) {
			Object file = iter.next();
			if (file instanceof Archive) {
				Archive arch = (Archive) file;
				TopologyUnitStub[] stubs = resolveStubs(arch);
				if (stubs.length > 0) {
					Unit[] modules = resolveUnit(arch, stubs[0]);
					if (modules != null) {
						for (int i = 0; i < modules.length; i++) {
							Unit module = modules[i];
							if (module instanceof JarModule) {
								removeOSRequirement(module);
							}
							Annotation annotation = module
									.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
							if (annotation == null) {
								annotation = CoreFactory.eINSTANCE.createAnnotation();
								annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
								module.getAnnotations().add(annotation);
							}
							annotation.getDetails().put(IAnnotationConstants.CONTAINED_ARCHIVE_URI,
									arch.getName());
							units.add(module);
						}
					}
				}
			}
		}

		return units;
	}

	protected Unit resolveModule(Archive archive, TopologyUnitStub aStub) {
		Unit module = null;
		String moduleType = null;
		Object inputObject = aStub.getInput();
		if (archive.isWARFile()) {
			module = resolveWebModule((WARFile) archive);
			moduleType = J2EEDeployUtils.WEB_FACET_ID;
		} else if (archive.isEARFile()) {
			module = resolveEarModule((EARFile) archive);
			moduleType = J2EEDeployUtils.EAR_FACET_ID;
		} else if (archive.isEJBJarFile()) {
			module = resolveEjbModule((EJBJarFile) archive);
			moduleType = J2EEDeployUtils.EJB_FACET_ID;
		} else if (archive.isRARFile()) {
			module = resolveJCAModule((RARFile) archive);
			moduleType = J2EEDeployUtils.JCA_FACET_ID;
		} else if (archive.isApplicationClientFile()) {
			module = resolveAppClient((ApplicationClientFile) archive);
			moduleType = J2EEDeployUtils.APPCLIENT_FACET_ID;
		} else {
			module = resolveUtilityModule(archive);
			moduleType = J2EEDeployUtils.JAVA_FACET_ID;
		}

		if (module != null) {
			Annotation stubAnnotation = aStub.getAnnotation();
			Annotation annotation = module.findAnnotation(stubAnnotation.getContext());
			if (annotation == null) {
				annotation = CoreFactory.eINSTANCE.createAnnotation();
				annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
				module.getAnnotations().add(annotation);
			}
			annotation.getDetails().put(IAnnotationConstants.MODULE_TYPE, moduleType);

			if (inputObject instanceof IFile) {
				IFile file = (IFile) inputObject;
				addFileArtifact(module, URI.createPlatformResourceURI(
						file.getFullPath().toPortableString()).toString());
			}
		}

		return module;
	}

	protected FileArtifact addFileArtifact(Unit unit, String archiveURI) {
		FileArtifact fileArtifact = CoreFactory.eINSTANCE.createFileArtifact();
		fileArtifact.setDisplayName(unit.getDisplayName());
		fileArtifact.setName(unit.getName());
		fileArtifact.getFileURIs().add(archiveURI);
		unit.getArtifacts().add(fileArtifact);
		return fileArtifact;
	}

	protected EarModule resolveEarModule(EARFile earFile) {
		EarModule earModule = J2eeFactory.eINSTANCE.createEarModule();
		earModule.setConceptual(false);
		Application app = earFile.getDeploymentDescriptor();
		String s = removeFileNameExtension(earFile.getName());
		earModule.setName(UnitUtil.fixNameForID(s));
		earModule.setDisplayName(s);
		setRequirementsAndCapabilities(earModule, app);
		setRequirementsAndCapabilities(earModule, earFile);
		ensureUniqueRequirementAndCapabilityNames(earModule);
		earModule.setPublishIntent(PublishIntent.PUBLISH_LITERAL);
		earModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		earModule.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		return earModule;
	}

	protected EjbModule resolveEjbModule(EJBJarFile anEjbJarFile) {
		EjbModule ejbModule = J2eeFactory.eINSTANCE.createEjbModule();
		EJBJar ejbJar = anEjbJarFile.getDeploymentDescriptor();
		String s = removeFileNameExtension(anEjbJarFile.getName());
		ejbModule.setName(UnitUtil.fixNameForID(s));
		ejbModule.setDisplayName(s);
		setRequirementsAndCapabilities(ejbModule, ejbJar);
		setRequirementsAndCapabilities(ejbModule, anEjbJarFile);
		ensureUniqueRequirementAndCapabilityNames(ejbModule);
		ejbModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		ejbModule.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		return ejbModule;
	}

	protected JarModule resolveUtilityModule(Archive archive) {
		JarModule jarModule = J2eeFactory.eINSTANCE.createJarModule();
		String s = removeFileNameExtension(archive.getName());
		jarModule.setName(UnitUtil.fixNameForID(s));
		jarModule.setDisplayName(s);
		setRequirementsAndCapabilities(jarModule, archive);
		ensureUniqueRequirementAndCapabilityNames(jarModule);
		jarModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		jarModule.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		return jarModule;
	}

	protected WebModule resolveWebModule(WARFile warFile) {
		WebModule webModule = J2eeFactory.eINSTANCE.createWebModule();
		WebApp webApp = warFile.getDeploymentDescriptor();
		String s = removeFileNameExtension(warFile.getName());
		webModule.setName(UnitUtil.fixNameForID(s));
		webModule.setDisplayName(s);
		setRequirementsAndCapabilities(webModule, webApp);
		setRequirementsAndCapabilities(webModule, warFile);
		ensureUniqueRequirementAndCapabilityNames(webModule);
		webModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		webModule.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		return webModule;
	}

	protected JCAModule resolveJCAModule(RARFile rarFile) {
		JCAModule jcaModule = J2eeFactory.eINSTANCE.createJCAModule();
		Connector connector = rarFile.getDeploymentDescriptor();
		String s = removeFileNameExtension(rarFile.getName());
		jcaModule.setName(UnitUtil.fixNameForID(s));
		jcaModule.setDisplayName(s);
		setRequirementsAndCapabilities(jcaModule, connector);
		setRequirementsAndCapabilities(jcaModule, rarFile);
		ensureUniqueRequirementAndCapabilityNames(jcaModule);
		jcaModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		jcaModule.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		return jcaModule;
	}

	protected AppClient resolveAppClient(ApplicationClientFile appClientFile) {
		AppClient appClientModule = J2eeFactory.eINSTANCE.createAppClient();
		ApplicationClient appClient = appClientFile.getDeploymentDescriptor();
		String s = removeFileNameExtension(appClientFile.getName());
		appClientModule.setName(UnitUtil.fixNameForID(s));
		appClientModule.setDisplayName(s);
		setRequirementsAndCapabilities(appClientModule, appClient);
		setRequirementsAndCapabilities(appClientModule, appClientFile);
		ensureUniqueRequirementAndCapabilityNames(appClientModule);
		appClientModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		appClientModule.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		return appClientModule;
	}

	public boolean resolveLinks(List units, IProgressMonitor monitor) {
		return true;
	}

	/*
	 * Resolve all possible dependencyLinks.
	 */
	protected void resolveLinks(List units) {
		DeployValidatorService validator = DeployValidatorService.getDefaultValidatorService();
		for (Iterator iter = units.iterator(); iter.hasNext();) {
			Unit sourceUnit = (Unit) iter.next();
			for (int k = 0; k < units.size(); k++) {
				Unit targetUnit = (Unit) units.get(k);
				LinkDescriptor[] possibleLinks = validator.getPossibleLinks(sourceUnit, targetUnit,
						LinkType.DEPENDENCY_SET);
				createDefaultLinks(possibleLinks);
			}
		}
	}

	protected void createDefaultLinks(LinkDescriptor[] possibleLinks) {
		for (int i = 0; i < possibleLinks.length; i++) {
			// Perfect matches only
			if (possibleLinks[i].getLinkWeight() >= LinkDescriptor.MAX_LINK_WEIGHT) {
				possibleLinks[i].create();
			}
		}
	}

	protected void removeOSRequirement(Unit unit) {
		for (Iterator iter = unit.getRequirements().iterator(); iter.hasNext();) {
			Requirement requirement = (Requirement) iter.next();
			if (OsPackage.Literals.DIRECTORY == requirement.getDmoEType()) {
				iter.remove();
			}
		}
	}

	protected void setRequirementsAndCapabilities(Unit unit, Object inputObj) {

		// Look up capability manager service
		ICapabilityProviderService capabilityProviderService = ExtensionsCore
				.createCapabilityProviderService();

		CapabilityProvider[] providers = capabilityProviderService
				.findEnabledCapabilityProvidersByInputOnly(inputObj);
		Set<Requirement> requiredHostingReqs = new HashSet<Requirement>();
		for (int i = 0; i < providers.length; i++) {
			CapabilityProvider provider = providers[i];
			Object[] requirements = provider.resolveRequirements(inputObj, unit);
			Object[] capabilities = provider.resolveCapabilities(inputObj, unit);
			for (int j = 0; j < requirements.length; j++) {
				// Ensure uniqueness of requirement and unit names
				boolean isRequiredHostingReq = false;
				if (requirements[j] instanceof Requirement) {
					Requirement req = (Requirement) requirements[j];
					String typeName = req.eClass().getInstanceTypeName();
					typeName.length();
					String reqName = req.getName();
					if (reqName == null) {
						reqName = REQUIREMENT;
						req.setName(reqName);
					}
					if (reqName.equals(unit.getName())) {
						req.setName(req.getName() + " " + REQUIREMENT); //$NON-NLS-1$
					}
					if (req.getLinkType().equals(RequirementLinkTypes.HOSTING_LITERAL)) {
						if (req.getUse().equals(RequirementUsage.REQUIRED_LITERAL)) {
							isRequiredHostingReq = true;
						} else {
							assert true;
						}
					}
				}
				if (isRequiredHostingReq) {
					requiredHostingReqs.add((Requirement) requirements[j]);
				} else {
					unit.getRequirements().add(requirements[j]);
				}
			}
			for (int j = 0; j < capabilities.length; j++) {
				// Ensure uniqueness of capability and unit names
				if (capabilities[j] instanceof Capability) {
					Capability cap = (Capability) capabilities[j];
					String capName = cap.getName();
					if (capName == null) {
						capName = CAPABILITY;
						cap.setName(capName);
					}
					if (capName.equals(unit.getName())) {
						cap.setName(capName + " " + CAPABILITY); //$NON-NLS-1$
					}
				}
				unit.getCapabilities().add(capabilities[j]);
			}
		}
		// For all required hosting requirements, convert to a type constraint with same constraint children
		// as hosting requirement, and add to single accumulated requirement.
		Requirement accRequiredHostingReqs = combineRequiredHostingRequirements(requiredHostingReqs);
		if (accRequiredHostingReqs != null) {
			// Use existing hosting requirement if already present
			boolean foundHostingReq = false;
			for (Iterator iter = unit.getRequirements().iterator(); iter.hasNext() && !foundHostingReq;) {
				Requirement req = (Requirement) iter.next();
				if (req.getLinkType().equals(RequirementLinkTypes.HOSTING_LITERAL)) {
					foundHostingReq = true;
					req.getConstraints().addAll(accRequiredHostingReqs.getConstraints());
				}
			}

			// if no pre-existing hosting requirement is present add this new one
			if (!foundHostingReq) {
				unit.getRequirements().add(accRequiredHostingReqs);
			}
		}
	}

	/**
	 * Build a single hosting requirement that combines all the constraints including dmoTypes of the
	 * passed collection of hosting requirements. Each hosting requirement is converted to a
	 * TypeConstraint child of the single hosting requirement. The Constraint children (that are not
	 * TypeConstraints) of the requirement are converted to children of the type constraint.
	 * TypeConstraint children of the requirement are made peers of the converted type constraints.
	 * 
	 * @param hostingReqs
	 *           Collection of required hosting requirements to combine
	 * @return Hosting requirement that combines the hosting requirements in the passed list. Returns
	 *         null if input list is empty.
	 */
	protected Requirement combineRequiredHostingRequirements(Collection<Requirement> hostingReqs) {
		Requirement accRequiredHostingReqs = null;
		for (Requirement hostingReq : hostingReqs) {
			assert hostingReq.getLinkType().equals(RequirementLinkTypes.HOSTING_LITERAL)
					|| hostingReq.getLinkType().equals(RequirementLinkTypes.ANY_LITERAL);
			assert hostingReq.getUse().equals(RequirementUsage.REQUIRED_LITERAL);
			if (accRequiredHostingReqs == null) {
				accRequiredHostingReqs = CoreFactory.eINSTANCE.createRequirement();
				accRequiredHostingReqs.setName(REQUIREMENT);
				accRequiredHostingReqs.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
				accRequiredHostingReqs.setUse(RequirementUsage.REQUIRED_LITERAL);
				accRequiredHostingReqs.setName("Hosting " + REQUIREMENT); //$NON-NLS-1$
			}
			// Type constraint with null dmoType is promiscuous
			TypeConstraint tc = ConstraintFactory.eINSTANCE.createTypeConstraint();
			tc.setDmoEType(hostingReq.getDmoEType());
			tc.setDescription(hostingReq.getDescription());
			tc.setDisplayName(hostingReq.getDisplayName());
			tc.setName(hostingReq.getName());
			for (Constraint c : (List<Constraint>) hostingReq.getConstraints()) {
				// make converted req#dmoType type constraints 
				// and child type constraints peers.
				if (c instanceof TypeConstraint) {
					accRequiredHostingReqs.getConstraints().add(EcoreUtil.copy(c));
				} else {
					tc.getConstraints().add(EcoreUtil.copy(c));
				}
			}
			if (hostingReq.getConstraints().size() == 0) {
				// If hosting requirement is simple with no children, add
				accRequiredHostingReqs.getConstraints().add(tc);
			} else if (tc.getConstraints().size() > 0) {
				// If hosting requirement had any non-TypeConstraint children, add 
				accRequiredHostingReqs.getConstraints().add(tc);
			}
		}
		return accRequiredHostingReqs;
	}

	@Override
	public Object resolveUnderlyingResource(Unit unit, IProgressMonitor aMonitor) {

		Archive archive = null;
		List resources = new ArrayList(2);
		String uri = null;

		List artifacts = unit.getArtifacts();
		if (artifacts != null && artifacts.size() > 0) {
			FileArtifact file = (FileArtifact) artifacts.get(0);
			if (file != null && file.getFileURIs() != null && file.getFileURIs().size() > 0) {
				URI platformURI = URI.createURI((String) file.getFileURIs().get(0));
				String workspaceURI = ResourcesPlugin.getWorkspace().getRoot().getLocation()
						.toPortableString();
				uri = workspaceURI + platformURI.toPlatformString(true);
			}

		}

		if (uri == null) {
			return null;
		}

		// Disable SSE renderer
		RendererFactory originalRendererFactory;
		originalRendererFactory = RendererFactory.getDefaultRendererFactory();

		// Use CatalogJ2EEXmlDtDEntityResolver
		EntityResolver originalEntityResolver = DOMUtilities.getDefaultEntityResolver();

		try {

			// Disable SSE renderer
			RendererFactory.setDefaultRendererFactory(EMF2SAXRendererFactory.INSTANCE);

			// Use CatalogJ2EEXmlDtDEntityResolver
			J2EEXmlDtDEntityResolver.INSTANCE = new CatalogJ2EEXmlDtDEntityResolver();
			DOMUtilities.setDefaultEntityResolver(J2EEXmlDtDEntityResolver.INSTANCE);

			CommonarchivePackage pkg = CommonarchivePackage.eINSTANCE;
			CommonarchiveFactory factory = pkg.getCommonarchiveFactory();
			try {
				archive = factory.openArchive(uri);
				Resource resource = null;
				if (archive.isEARFile()
						&& !J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(unit.getEObject().eClass())) {
					// if unit is not an ear module but the file artifact points to an ear archive 
					// then the unit must be contained in the ear archive.  We will need to locate
					// the archive_file_name annotation to retrieve the correct file from the 
					// archive in order to introspect it and get a handle on the deployment descriptor
					// from the contained file
					String containedArchiveUri = null;
					Annotation annotation = unit.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
					if (annotation != null) {
						containedArchiveUri = (String) annotation.getDetails().get(
								IAnnotationConstants.CONTAINED_ARCHIVE_URI);
					}

					if (containedArchiveUri != null) {
						Archive arch = archive.openNestedArchive(containedArchiveUri);
						resource = resolveUnderlyingResource(arch);
					}
				} else {
					resource = resolveUnderlyingResource(archive);
				}

				if (resource != null) {
					resources.add(resource);
				}

			} catch (OpenFailureException e) {
				J2EEDeployPlugin.logError(0, e.getMessage(), e);
			} finally {
				if (null != archive) {
					// TODO find a better way to handle the closure of this archive
					// related to Defect #2431
					//				archive.close();
				}
			}

		} finally {

			// Restore original entity resolver
			DOMUtilities.setDefaultEntityResolver(originalEntityResolver);

			// Restore original renderer
			RendererFactory.setDefaultRendererFactory(originalRendererFactory);
		}

		return resources;
	}

	protected Resource resolveUnderlyingResource(Archive archive) {
		if (archive != null) {
			if (archive.isEARFile()) {
				EARFile earFile = (EARFile) archive;
				return earFile.getDeploymentDescriptor().eResource();
			} else if (archive.isEJBJarFile()) {
				EJBJarFile ejbJar = (EJBJarFile) archive;
				return ejbJar.getDeploymentDescriptor().eResource();
			} else if (archive.isWARFile()) {
				WARFile warFile = (WARFile) archive;
				return warFile.getDeploymentDescriptor().eResource();
			} else if (archive.isApplicationClientFile()) {
				ApplicationClientFile appClientFile = (ApplicationClientFile) archive;
				return appClientFile.getDeploymentDescriptor().eResource();
			}
		}

		return null;
	}

	protected void ensureUniqueRequirementAndCapabilityNames(Unit unit) {

		List names = new ArrayList();
		names.add(unit.getName());
		List requirements = unit.getRequirements();
		List capabilities = unit.getCapabilities();

		for (int j = 0; j < requirements.size(); j++) {
			Requirement requirement = (Requirement) requirements.get(j);
			ensureUniqueRequirementName(unit, requirement);
			names.add(requirement.getName());
		}

		for (int j = 0; j < capabilities.size(); j++) {
			Capability capability = (Capability) capabilities.get(j);
			ensureUniqueCapabilityName(unit, capability);
			int idx = 0;
			while (names.contains(capability.getName())) {
				capability.setName(capability.getName() + idx);
				ensureUniqueCapabilityName(unit, capability);
				idx++;
			}
			names.add(capability.getName());
		}
	}

	protected Requirement ensureUniqueRequirementName(Unit unit, Requirement requirement) {
		// Ensure name uniqueness among requirements in this unit
		int idx = 0;
		for (Iterator iter = unit.getRequirements().iterator(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			assert req != null;
			assert req.getName() != null;
			assert requirement != null;
			assert requirement.getName() != null;
			if (req.getName().equals(requirement.getName()) && !req.equals(requirement)
					|| req.getName().equals(unit.getName())) {
				req.setName(req.getName() + idx);
				idx++;
			}
		}

		return requirement;
	}

	protected Capability ensureUniqueCapabilityName(Unit unit, Capability capability) {
		// Ensure name uniqueness among capabilities in this unit
		int idx = 0;
		for (Iterator iter = unit.getCapabilities().iterator(); iter.hasNext();) {
			Capability cap = (Capability) iter.next();
			if (cap.getName().equals(capability.getName()) && !cap.equals(capability)
					|| cap.getName().equals(unit.getName())) {
				cap.setName(cap.getName() + idx);
				idx++;
			}
		}

		return capability;
	}

	protected String removeFileNameExtension(String name) {
		if (name == null) {
			return null;
		}

		int index = name.lastIndexOf('.');
		if (index > 0) {
			return name.substring(0, index);
		}
		return name;
	}

}
