package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jst.j2ee.commonarchivecore.internal.Archive;
import org.eclipse.jst.j2ee.commonarchivecore.internal.CommonarchiveFactory;
import org.eclipse.jst.j2ee.commonarchivecore.internal.CommonarchivePackage;
import org.eclipse.jst.j2ee.commonarchivecore.internal.EARFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.WARFile;
import org.eclipse.jst.j2ee.commonarchivecore.internal.exception.OpenFailureException;
import org.eclipse.jst.j2ee.commonarchivecore.internal.helpers.ArchiveManifest;
import org.eclipse.jst.j2ee.componentcore.util.EARArtifactEdit;
import org.eclipse.jst.j2ee.core.internal.plugin.CatalogJ2EEXmlDtDEntityResolver;
import org.eclipse.jst.j2ee.ejb.componentcore.util.EJBArtifactEdit;
import org.eclipse.jst.j2ee.internal.plugin.J2EEPlugin;
import org.eclipse.jst.j2ee.internal.xml.J2EEXmlDtDEntityResolver;
import org.eclipse.jst.j2ee.web.componentcore.util.WebArtifactEdit;
import org.eclipse.wst.common.componentcore.ComponentCore;
import org.eclipse.wst.common.componentcore.internal.resources.VirtualArchiveComponent;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
import org.eclipse.wst.common.componentcore.resources.IVirtualFolder;
import org.eclipse.wst.common.componentcore.resources.IVirtualReference;
import org.eclipse.wst.common.componentcore.resources.IVirtualResource;
import org.eclipse.wst.common.internal.emf.resource.EMF2SAXRendererFactory;
import org.eclipse.wst.common.internal.emf.resource.RendererFactory;
import org.eclipse.wst.common.internal.emf.utilities.DOMUtilities;
import org.xml.sax.EntityResolver;

import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployPlugin;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEDeployUtils;

public class BundleCapabilityProvider extends J2EEModuleCapabilityProvider {

	@Override
	public Object[] resolveCapabilities(Object anObject) {

		List<Capability> capabilities = new ArrayList<Capability>();
		BundleCapability capability = null;
		String name = null;

		if (anObject instanceof IProject) {

			IProject project = (IProject) anObject;
			name = project.getName();

			if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.WEB_FACET_ID)) {
				capability = J2eeFactory.eINSTANCE.createWebModuleCapability();
			} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EJB_FACET_ID)) {
				capability = J2eeFactory.eINSTANCE.createEJBModuleCapability();
			} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JCA_FACET_ID)) {
				capability = J2eeFactory.eINSTANCE.createJCAModuleCapability();
			} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EAR_FACET_ID)) {
				capability = J2eeFactory.eINSTANCE.createEARModuleCapability();
			} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JAVA_FACET_ID)) {
				capability = J2eeFactory.eINSTANCE.createJarModuleCapability();
			}

		} else if (anObject instanceof Archive) {

			Archive archive = (Archive) anObject;
			name = removeFileNameExtension(archive.getName());

			if (archive.isWARFile()) {
				capability = J2eeFactory.eINSTANCE.createWebModuleCapability();
			} else if (archive.isEJBJarFile()) {
				capability = J2eeFactory.eINSTANCE.createEJBModuleCapability();
			} else if (archive.isRARFile()) {
				capability = J2eeFactory.eINSTANCE.createJCAModuleCapability();
			} else if (archive.isEARFile()) {
				capability = J2eeFactory.eINSTANCE.createEARModuleCapability();
			} else {
				capability = J2eeFactory.eINSTANCE.createJarModuleCapability();
			}
		}

		if (capability != null) {
			capability.setName(UnitUtil.fixNameForID(name));
			capability.setDisplayName(name);
			capability.setId(capability.getName());
			capability.setVersion("1.0.0"); //$NON-NLS-1$
			capability.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
			capability.setMutable(true);
			capabilities.add(capability);
			return capabilities.toArray(new Capability[capabilities.size()]);
		}

		return NO_CAPS;
	}

	@Override
	public Object[] resolveRequirements(Object anObject) {

		List<Requirement> requirements = new ArrayList<Requirement>();
		if (anObject instanceof IProject) {

			IProject project = (IProject) anObject;

			if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.WEB_FACET_ID)) {
				WebArtifactEdit edit = null;
				try {
					edit = WebArtifactEdit.getWebArtifactEditForRead(project);
					IVirtualComponent component = ComponentCore.createComponent(project);
					IVirtualFolder root = component.getRootFolder();
					IVirtualFolder webinf = root.getFolder(WebArtifactEdit.WEBLIB);

					IVirtualResource[] resources = new IVirtualResource[0];
					try {
						resources = webinf.members();
					} catch (CoreException ex) {
						J2EEPlugin.logError(0, ex.getMessage(), ex);
					}
					List<IVirtualResource> libsToIntrospect = new ArrayList<IVirtualResource>(Arrays
							.asList(resources));
					IVirtualReference[] references = edit.getComponent().getReferences();

					int webLibLength = -1;
					for (int i = 0; i < references.length; i++) {
						IVirtualReference reference = references[i];
						if (reference.getArchiveName() == null) {
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

					requirements.addAll(createBundleRequirements(references));
					if (!libsToIntrospect.isEmpty()) {
						requirements.addAll(createBundleRequirements(libsToIntrospect
								.toArray(new IVirtualResource[libsToIntrospect.size()])));
					}
				} finally {
					if (edit != null) {
						edit.dispose();
					}
				}

			} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EJB_FACET_ID)) {
				EJBArtifactEdit edit = null;
				try {
					edit = EJBArtifactEdit.getEJBArtifactEditForRead(project);
					IVirtualReference[] references = edit.getComponent().getReferences();
					requirements.addAll(createBundleRequirements(references));
				} finally {
					if (edit != null) {
						edit.dispose();
					}
				}
			} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JCA_FACET_ID)) {
				// TODO - need ConnectorArtifactEdit dependency from somewhere
			} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EAR_FACET_ID)) {
				EARArtifactEdit edit = null;
				try {
					edit = EARArtifactEdit.getEARArtifactEditForRead(project);
					IVirtualReference[] references = edit.getComponent().getReferences();
					requirements.addAll(createBundleRequirements(references));
				} finally {
					if (edit != null) {
						edit.dispose();
					}
				}
			} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JAVA_FACET_ID)) {
				try {
					IProject[] references = project.getReferencedProjects();
					for (Iterator iter = Arrays.asList(references).iterator(); iter.hasNext();) {
						IProject aProject = (IProject) iter.next();
						if (aProject != null) {
							String name = aProject.getName();
							EClass dmo = null;
							if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.WEB_FACET_ID)) {
								dmo = J2eePackage.Literals.WEB_MODULE_CAPABILITY;
							} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EJB_FACET_ID)) {
								dmo = J2eePackage.Literals.EJB_MODULE_CAPABILITY;
							} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JCA_FACET_ID)) {
								dmo = J2eePackage.Literals.JCA_MODULE_CAPABILITY;
							} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EAR_FACET_ID)) {
								dmo = J2eePackage.Literals.EAR_MODULE_CAPABILITY;
							} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JAVA_FACET_ID)) {
								dmo = J2eePackage.Literals.JAR_MODULE_CAPABILITY;
							}

							if (name != null && dmo != null) {
								Requirement requirement = createBundleRequirement(name, dmo);
								requirements.add(requirement);
							}
						}
					}
				} catch (CoreException ex) {
					J2EEPlugin.logError(0, ex.getMessage(), ex);
				}
			}

		} else if (anObject instanceof Archive) {

			Archive archive = (Archive) anObject;

			if (archive.isEARFile()) {
				EARFile earFile = (EARFile) archive;
				List files = earFile.getArchiveFiles();
				for (int i = 0; i < files.size(); i++) {

					Object file = files.get(i);
					if (file instanceof Archive) {

						Archive arc = (Archive) file;
						String name = removeFileNameExtension(arc.getName());
						EClass dmo = null;
						if (arc.isWARFile()) {
							dmo = J2eePackage.Literals.WEB_MODULE_CAPABILITY;
						} else if (arc.isEJBJarFile()) {
							dmo = J2eePackage.Literals.EJB_MODULE_CAPABILITY;
						} else if (arc.isRARFile()) {
							dmo = J2eePackage.Literals.JCA_MODULE_CAPABILITY;
						} else {
							dmo = J2eePackage.Literals.JAR_MODULE_CAPABILITY;
						}
						Requirement requirement = createBundleRequirement(name, dmo);
						if (requirement != null && requirement.getName() != null
								&& requirement.getName().length() > 0) {
							requirements.add(requirement);
						}
					}
				}
			} else if (archive.isWARFile()) {
				WARFile warFile = (WARFile) archive;
				List files = warFile.getLibArchives();
				for (int i = 0; i < files.size(); i++) {

					Object file = files.get(i);
					if (file instanceof Archive) {

						Archive arc = (Archive) file;
						String name = removeFileNameExtension(arc.getName());
						EClass dmo = J2eePackage.Literals.JAR_MODULE_CAPABILITY;
						Requirement requirement = createBundleRequirement(name, dmo);
						if (requirement != null && requirement.getName() != null
								&& requirement.getName().length() > 0) {
							requirements.add(requirement);
						}
					}
				}
			} else {
				ArchiveManifest manifest = archive.getManifest();
				if (manifest != null) {
					String classpath = manifest.getMainAttributes().getValue("Class-Path"); //$NON-NLS-1$
					if (classpath != null) {

						String[] entries = classpath.split(" "); //$NON-NLS-1$
						for (int i = 0; i < entries.length; i++) {
							String name = removeFileNameExtension(entries[i]);
							EClass dmo = CorePackage.Literals.BUNDLE_CAPABILITY;
							Requirement requirement = createBundleRequirement(name, dmo);
							if (requirement != null && requirement.getName() != null
									&& requirement.getName().length() > 0) {
								requirements.add(requirement);
							}
						}
					}
				}
			}

		}

		return requirements.toArray(new Requirement[requirements.size()]);
	}

	protected List<Requirement> createBundleRequirements(IVirtualReference[] references) {

		List<Requirement> requirements = new ArrayList<Requirement>();

		for (Iterator iter = Arrays.asList(references).iterator(); iter.hasNext();) {
			IVirtualReference reference = (IVirtualReference) iter.next();
			IVirtualComponent component = reference.getReferencedComponent();
			if (component != null) {

				String name = null;
				EClass dmo = null;

				if (!component.isBinary()) {

					IProject project = component.getProject();
					if (project != null) {
						name = project.getName();
						if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.WEB_FACET_ID)) {
							dmo = J2eePackage.Literals.WEB_MODULE_CAPABILITY;
						} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EJB_FACET_ID)) {
							dmo = J2eePackage.Literals.EJB_MODULE_CAPABILITY;
						} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JCA_FACET_ID)) {
							dmo = J2eePackage.Literals.JCA_MODULE_CAPABILITY;
						} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EAR_FACET_ID)) {
							dmo = J2eePackage.Literals.EAR_MODULE_CAPABILITY;
						} else if (J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JAVA_FACET_ID)) {
							dmo = J2eePackage.Literals.JAR_MODULE_CAPABILITY;
						}
					}
				} else {

					if (component instanceof VirtualArchiveComponent) {
						VirtualArchiveComponent archiveComponent = (VirtualArchiveComponent) component;

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

							String archiveURI = archiveComponent.getUnderlyingWorkbenchFile()
									.getRawLocation().toOSString();

							if (null != archiveURI) {
								Archive archive = null;
								CommonarchivePackage pkg = CommonarchivePackage.eINSTANCE;
								CommonarchiveFactory factory = pkg.getCommonarchiveFactory();

								try {

									archive = factory.openArchive(archiveURI);
									name = removeFileNameExtension(archive.getName());

									if (archive.isWARFile()) {
										dmo = J2eePackage.Literals.WEB_MODULE_CAPABILITY;
									} else if (archive.isEJBJarFile()) {
										dmo = J2eePackage.Literals.EJB_MODULE_CAPABILITY;
									} else if (archive.isRARFile()) {
										dmo = J2eePackage.Literals.JCA_MODULE_CAPABILITY;
									} else if (archive.isEARFile()) {
										dmo = J2eePackage.Literals.EAR_MODULE_CAPABILITY;
									} else {
										dmo = J2eePackage.Literals.JAR_MODULE_CAPABILITY;
									}

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
					}
				}

				if (name != null && dmo != null) {
					Requirement requirement = createBundleRequirement(name, dmo);
					requirements.add(requirement);
				}
			}
		}

		return requirements;
	}

	protected List<Requirement> createBundleRequirements(IVirtualResource[] archives) {
		List<Requirement> requirements = new ArrayList<Requirement>();
		for (Iterator<IVirtualResource> iter = Arrays.asList(archives).iterator(); iter.hasNext();) {
			IVirtualResource resource = iter.next();
			if (resource.getFileExtension().equalsIgnoreCase("jar")) { //$NON-NLS-1$
				Requirement requirement = createBundleRequirement(removeFileNameExtension(resource
						.getName()), J2eePackage.Literals.JAR_MODULE_CAPABILITY);
				requirements.add(requirement);
			}
		}

		return requirements;
	}

	protected Requirement createBundleRequirement(String name, EClass dmo) {
		Requirement bundleReq = CoreFactory.eINSTANCE.createRequirement();
		bundleReq.setDmoEType(dmo);
		bundleReq.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		bundleReq.setName(UnitUtil.fixNameForID(name));
		bundleReq.setDisplayName(name);
		bundleReq.setMutable(false);
//		bundleReq.getExpressions()
//				.add(
//						Equals.createExpression(CorePackage.Literals.BUNDLE_CAPABILITY__ID, bundleReq
//								.getName()));
		bundleReq.getConstraints()
				.add(
						createEqualsConstraint(CorePackage.Literals.BUNDLE_CAPABILITY__ID, bundleReq
								.getName()));
//		bundleReq.getExpressions().add(
//				GreaterThanEquals.createExpression(CorePackage.Literals.BUNDLE_CAPABILITY__VERSION,
//						"1.0")); //$NON-NLS-1$
		bundleReq.getConstraints().add(
				createVersionConstraint(CorePackage.Literals.BUNDLE_CAPABILITY__VERSION, "1.x")); //$NON-NLS-1$
//		bundleReq.getExpressions().add(
//				LessThan.createExpression(CorePackage.Literals.BUNDLE_CAPABILITY__VERSION, "2.0")); //$NON-NLS-1$

		return bundleReq;
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
