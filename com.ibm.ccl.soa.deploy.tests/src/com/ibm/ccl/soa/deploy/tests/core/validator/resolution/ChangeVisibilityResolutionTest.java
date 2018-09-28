/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.validator.resolution;

import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.validator.CoreDomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.os.UserUnit;

public class ChangeVisibilityResolutionTest extends TopologyTestCase {

	public static final String PROJECT_NAME = ChangeVisibilityResolutionTest.class.getName();

	private static final DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
	DomainValidator validator = new CoreDomainValidator();

	public ChangeVisibilityResolutionTest() {
		super(PROJECT_NAME);
	}

	public void testMakeAttributePublicEditableResolution() throws Exception {
		Topology top = createTopology("testMakeAttributePublicEditableResolution");
		
		// create explicit contract
		ExplicitContract contract = CoreFactory.eINSTANCE.createExplicitContract();
		contract.setName("contract");
		contract.setDefaultConceptualPolicy(Visibility.PRIVATE_LITERAL);
		contract.setDefaultPolicy(Visibility.PRIVATE_LITERAL);
		top.setConfigurationContract(contract);

		// create private user
		UserUnit privateUser = (UserUnit) ResolutionUtils.addFromTemplate(IOsTemplateConstants.OS_USER_UNIT, top);
		privateUser.setInitInstallState(InstallState.INSTALLED_LITERAL);
		privateUser.setName("privateUser");
		top.getUnits().add(privateUser);
		
		// create public user
		UserUnit publicUser = (UserUnit) ResolutionUtils.addFromTemplate(IOsTemplateConstants.OS_USER_UNIT, top);
		publicUser.setInitInstallState(InstallState.INSTALLED_LITERAL);
		publicUser.setName("publicUser");
		contract.export(publicUser, false);
		top.getUnits().add(publicUser);
		
		// create public editable user
		UserUnit publicEditableUser = (UserUnit) ResolutionUtils.addFromTemplate(IOsTemplateConstants.OS_USER_UNIT, top);
		publicEditableUser.setInitInstallState(InstallState.INSTALLED_LITERAL);
		publicEditableUser.setName("publicEditableUser");
		contract.export(publicEditableUser, true);
		top.getUnits().add(publicEditableUser);
		
		// explore each
		DeployModelObject o = top.resolve ("/privateUser/WindowsLocalUser");
		if (o != null) {
			// unit
			assert !contract.isPublic(o.getParent());
			assert !contract.isPublicEditable(o.getParent());
			// capability
			assert !contract.isPublic(o);
			assert !contract.isPublicEditable(o);
			// attribute
			assert !contract.isPublicEditable(o, "userId");
			contract.export(o, "userId");
			/////////////// PROBLEM ////////////
			assert contract.isPublicEditable(o, "userId");
		}
		
		o = top.resolve ("/publicUser/WindowsLocalUser");
		if (o != null) {
			// unit
			assert contract.isPublic(o.getParent());
			assert !contract.isPublicEditable(o.getParent());
			// capability
			assert contract.isPublic(o);
			assert !contract.isPublicEditable(o);
			// attribute
			assert !contract.isPublicEditable(o, "userId");
			contract.export(o, "userId");
			assert contract.isPublicEditable(o, "userId");
		}
		
		o = top.resolve ("/publicEditableUser/WindowsLocalUser");
		if (o != null) {
			// unit
			assert contract.isPublic(o.getParent());
			assert contract.isPublicEditable(o.getParent());
			// capability
			assert contract.isPublic(o);
			assert contract.isPublicEditable(o);
			// attribute
			assert contract.isPublicEditable(o, "userId");
			contract.export(o, "userId");
			assert contract.isPublicEditable(o, "userId");
		}
		
//		System.out.println ("RESOLUTION COMPLETED ====================");
//		dvs.validate(top);
//		dumpStatus(top);
	}
	
	private IDeployStatus assertContainsStatus(IStatus s, String problemType,
			int count) throws CoreException {
		int found = 0;
		StringBuffer markerDescriptions = new StringBuffer();
		IDeployStatus lastFound = null;
		for (Iterator iter = new StatusIterator(s); iter.hasNext();) {
			IStatus st = (IStatus) iter.next();
			if (st instanceof IDeployStatus) {
				IDeployStatus status = (IDeployStatus) st;

				if ((problemType != null)
						&& (!problemType.equals(status.getProblemType()))) {
					continue;
				}

				if (markerDescriptions.length() > 0) {
					markerDescriptions.append('\n');
				}
				markerDescriptions.append(DeployMarker.toString(status
						.getMarker()));

				found++;
				lastFound = status;
			}
		}

		if (count < 0) {
			assert found > 0 : "status does not contain required problem type";
		} else {
			assert found == count : "status has " + found
					+ " required problem type; expected " + count + ":\n"
					+ markerDescriptions;
		}
		return lastFound;
	}

	private void assertDoesNotContainStatus(IStatus s, String problemType)
			throws CoreException {
		int found = 0;
		StringBuffer problemDescriptions = new StringBuffer();

		for (Iterator iter = new StatusIterator(s); iter.hasNext();) {
			IStatus st = (IStatus) iter.next();
			if (st instanceof IDeployStatus) {
				IDeployStatus status = (IDeployStatus) st;

				if ((problemType != null)
						&& (!problemType.equals(status.getProblemType()))) {
					continue;
				}

				if (problemDescriptions.length() > 0) {
					problemDescriptions.append('\n');
				}
				problemDescriptions.append(DeployMarker.toString(status
						.getMarker()));

				found++;
			}
		}

		assert found == 0 : "status has " + found
				+ " required problem type; expected " + 0 + ":\n"
				+ problemDescriptions;
	}

	private String getProblemDescriptions(IStatus status) {
		StringBuffer problemDescriptions = new StringBuffer();
		for (Iterator iter = new StatusIterator(status); iter.hasNext();) {
			IStatus st = (IStatus) iter.next();
			if (st instanceof IDeployStatus) {
				IDeployStatus s = (IDeployStatus) st;

				if (!s.isOK()) {
					if (problemDescriptions.length() > 0) {
						problemDescriptions.append('\n');
					}
				}

				if (!s.isOK()) {
					problemDescriptions.append(s.getProblemType());
				}
			}
		}

		return problemDescriptions.toString();
	}

	private String getStatusDescriptions(IStatus status) {
		StringBuffer statusDescriptions = new StringBuffer();
		for (Iterator iter = new StatusIterator(status); iter.hasNext();) {
			IStatus st = (IStatus) iter.next();
			if (st instanceof IDeployStatus) {
				IDeployStatus s = (IDeployStatus) st;

				if (statusDescriptions.length() > 0) {
					statusDescriptions.append('\n');
				}

				statusDescriptions.append(s.toString());
			}
		}

		return statusDescriptions.toString();
	}

}
