package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jst.j2ee.commonarchivecore.internal.Archive;

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEDeployUtils;
import com.ibm.ccl.soa.deploy.os.OsPackage;

public class OSCapabilityProvider extends CapabilityProvider {

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
				Requirement requirement = createOSRequirement();
				requirements.add(requirement);
				return requirements.toArray(new Requirement[requirements.size()]);
			}
		} else if (anObject instanceof Archive) {
			Archive archive = (Archive) anObject;
			if (!archive.isApplicationClientFile() && !archive.isWARFile() && !archive.isEJBJarFile()
					&& !archive.isRARFile() && !archive.isEARFile()) {
				Requirement requirement = createOSRequirement();
				requirements.add(requirement);
				return requirements.toArray(new Requirement[requirements.size()]);
			}
		}

		return NO_REQS;
	}

	protected Requirement createOSRequirement() {
		Requirement requirement = CoreFactory.eINSTANCE.createRequirement();
		requirement.setDmoEType(OsPackage.Literals.DIRECTORY);
		requirement.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		requirement.setUse(RequirementUsage.OPTIONAL_LITERAL);
		requirement.setName("location"); //$NON-NLS-1$
		requirement.setDisplayName(requirement.getName());
		requirement.setMutable(true);

		return requirement;
	}

}
