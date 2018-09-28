package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jst.j2ee.commonarchivecore.internal.Archive;
import org.eclipse.jst.j2ee.commonarchivecore.internal.helpers.ArchiveManifest;
import org.eclipse.jst.j2ee.internal.plugin.J2EEPlugin;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEDeployUtils;
import com.ibm.ccl.soa.deploy.java.JREVersion;
import com.ibm.ccl.soa.deploy.java.JavaPackage;

public class JRECapabilityProvider extends J2EEModuleCapabilityProvider {

	@Override
	public Object[] resolveRequirements(Object anObject) {

		List<Requirement> requirements = new ArrayList<Requirement>();

		if (anObject instanceof IProject) {
			IProject project = (IProject) anObject;
			if (!J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.APPCLIENT_FACET_ID)
					&& !J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.WEB_FACET_ID)
					&& !J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EJB_FACET_ID)
					&& !J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JCA_FACET_ID)
					&& !J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.EAR_FACET_ID)
					&& J2EEDeployUtils.hasFacet(project, J2EEDeployUtils.JAVA_FACET_ID)) {
				Requirement requirement = resolveJreRequirement(project);
				requirements.add(requirement);
				return requirements.toArray(new Requirement[requirements.size()]);
			}
		} else if (anObject instanceof Archive) {
			Archive archive = (Archive) anObject;
			if (!archive.isApplicationClientFile() && !archive.isWARFile() && !archive.isEJBJarFile()
					&& !archive.isRARFile() && !archive.isEARFile()) {
				Requirement requirement = resolveJreRequirement(archive);
				requirements.add(requirement);
				return requirements.toArray(new Requirement[requirements.size()]);
			}
		}

		return NO_REQS;
	}

	private Requirement resolveJreRequirement(Archive archive) {
		ArchiveManifest manifest = archive.getManifest();
		return resolveJreRequirement(manifest.getImplementationVersion());
	}

	private Requirement resolveJreRequirement(IProject project) {
		try {
			if (project.hasNature(JavaCore.NATURE_ID)) {
				IJavaProject javaProject = JavaCore.create(project);
				return resolveJreRequirement(javaProject.getOption(JavaCore.COMPILER_SOURCE, false));
			}
		} catch (CoreException ex) {
			J2EEPlugin.logError(0, ex.getMessage(), ex);
		}

		return null;
	}

	private Requirement resolveJreRequirement(String versionString) {
		JREVersion version = JREVersion.get(versionString);
		Requirement requirement = CoreFactory.eINSTANCE.createRequirement();
		requirement.setDmoEType(JavaPackage.Literals.JRE);
		requirement.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		requirement.setName(UnitUtil
				.fixNameForID("JRE" + (version != null ? "_" + version.getLiteral() : ""))); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
		requirement.setDisplayName("JRE" + (version != null ? version.getLiteral() : ""));//$NON-NLS-1$ //$NON-NLS-2$
		requirement.setMutable(version == null);

		requirement.setUse(RequirementUsage.OPTIONAL_LITERAL);

		//Do not constrain if we did not detect a version.
		if (version != null) {
//			requirement.getConstraints().add(
//					GreaterThanEquals.createExpression(JavaPackage.Literals.JRE__JRE_VERSION, version));
			requirement.getConstraints().add(
					createVersionConstraint(JavaPackage.Literals.JRE__JRE_VERSION, version + "+")); //$NON-NLS-1$
		}

		return requirement;
	}

}
