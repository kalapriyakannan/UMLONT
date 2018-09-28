/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.IActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ISignature;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.UnitSignature;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JarModule;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeValidatorUtils;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Precondition test for action to refactor a EAR module by externalizing a utility JAR.
 */
public class CreateSharedLibraryForApplicationTest extends ActionPreconditionTest implements
		IActionPreconditionTest {

	/**
	 * Constructor for precondition test.
	 */
	public CreateSharedLibraryForApplicationTest() {
		super(IWasValidatorID.WAS_CREATE_SHARED_LIBRARY_FOR_APPLICATION, new UnitSignature(
				new EClass[] { J2eePackage.Literals.JAR_MODULE, J2eePackage.Literals.EAR_MODULE,
						WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT }));
	}

	@Override
	public boolean appliesTo(ISignature signature) {
		if (3 != signature.getNumberParameters()) {
			return false;
		}
		if (!J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(signature.get(0))) {
			return false;
		}
		if (!J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(signature.get(1))) {
			return false;
		}
		if (!WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT.isSuperTypeOf(signature.get(2))) {
			return false;
		}

		return true;
	}

	@Override
	public void testActionPreconditions(List<DeployModelObject> parameters,
			IDeployValidationContext context, IDeployReporter reporter) {

		if (!appliesTo(parameters)) {
			return;
		}

		JarModule jarModule = (JarModule) parameters.get(0);
		EarModule appModule = (EarModule) parameters.get(1);
		WebsphereAppServerUnit wasHost = (WebsphereAppServerUnit) parameters.get(2);

		//test if the AppModule has a file URI. If it has it has to be tested for being an EAR file
		List<Artifact> artifacts = appModule.getArtifacts();
		for (Artifact artifact : artifacts) {
//		for (Iterator<Artifact> iterator = artifacts.iterator(); iterator.hasNext();) {
//			Artifact artifact = iterator.next();
			if (artifact instanceof FileArtifact) {
				List uRIs = ((FileArtifact) artifact).getFileURIs();
				for (Iterator iterator2 = uRIs.iterator(); iterator2.hasNext();) {
					//if the URI points to an EAR file this action is not allowed
					if (iterator2.next().toString().endsWith(".ear")) { //$NON-NLS-1$
						return;
					}
				}
			}

		}
		//check if utility jar is member of appModule
		// MK 2/18/2008 - Defect 5362; remove reference to deprecated method
		//List members = UnitUtil.getMemberUnits(appModule);
		List<Unit> members = ValidatorUtils.getMembers(appModule);
		if (!members.contains(jarModule)) {
			return;
		}

		//check if the appModule is hosted by the WAS Server
		// MK 2/18/2008 - Defect 5362; remove reference to deprecated method
		// List hostedUnits = UnitUtil.getHostedUnits(wasHost);
		List<Unit> hostedUnits = ValidatorUtils.getHosted(wasHost);
		if (!hostedUnits.contains(appModule)) {
			return;
		}

		// check that the appModule is editable
		// the action will do the following things:
		//   (a) create a new shared library entry
		//   (b) host the shared library entry on the wasHost
		//   (c) may add a shared library requirement to the appModule
		//   (d) link from existing shared library requirement to new shared library entry
		//   (e) create link from share library entry to JAR
		//   (f) remove JAR from appModule

		//   (a) create a new shared library entry - can always do this
		//   (b) host the shared library entry on the wasHost
		if (wasHost.getTopology() != wasHost.getEditTopology()) {
			if (!ValidatorUtils.areHostingCapabilitiesPublic(wasHost,
					new EClass[] { WasPackage.Literals.WAS_SHARED_LIB_CONTAINER })) {
				return;
			}
		}
		//   (c) may add a shared library requirement to the appModule
		// if one does not exist then will need to do so
		Requirement slReq = WasJ2eeValidatorUtils.getAvailableRequirement(appModule,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
//		if (appModule.getTopology() != appModule.getEditTopology()) {
//			if (null == slReq
//					&& !appModule.getTopology().getConfigurationContract().isPublic(appModule)) {
//				return;
//			}
//		}
		if (!appModule.isPublic()) {
			return;
		}
		//   (d) link from existing shared library requirement to new shared library entry
//		if (null != slReq && slReq.getTopology() != slReq.getEditTopology()
//				&& !slReq.getTopology().getConfigurationContract().isPublic(slReq)) {
//			return;
//		}
		if (!slReq.isPublic()) {
			return;
		}
		//   (e) create link from share library entry to JAR
//		if (jarModule.getTopology() != jarModule.getEditTopology()) {
//			if (!jarModule.getTopology().getConfigurationContract().isPublic(
//					ValidatorUtils.getFirstCapability(jarModule,
//							J2eePackage.Literals.JAR_MODULE_CAPABILITY))) {
//				return;
//			}
//		}
		if (!ValidatorUtils.getFirstCapability(jarModule, J2eePackage.Literals.JAR_MODULE_CAPABILITY)
				.isPublic()) {
			return;
		}
		//   (f) remove JAR from appModule
		// currently cannot do so if units in an import topology
		if (appModule.getTopology() != appModule.getEditTopology()) {
			return;
		}

		reporter.addStatus(WasValidationUtil.createActionPreconditionValid(getId(),
				WasDomainMessages.Action_Create_Shared_Library_For_Application_0,
				new Object[] { wasHost.getCaptionProvider().title(wasHost) }, jarModule, parameters));

	}

}
