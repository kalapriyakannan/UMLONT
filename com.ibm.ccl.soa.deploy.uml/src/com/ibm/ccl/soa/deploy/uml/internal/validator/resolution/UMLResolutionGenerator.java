package com.ibm.ccl.soa.deploy.uml.internal.validator.resolution;

import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeleteDmoResolution;
import com.ibm.ccl.soa.deploy.uml.UMLDomainMessages;
import com.ibm.ccl.soa.deploy.uml.internal.validator.IUMLDomainValidators;
import com.ibm.ccl.soa.deploy.uml.internal.validator.IUMLProblemType;

/**
 * Resolution Generator for UML domain.
 * 
 */
public class UMLResolutionGenerator implements IDeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		String problemType = status.getProblemType();
		if (ICoreProblemType.MISSING_APP_COMM.equals(problemType)) {
			return new IDeployResolution[] { new CreateCommunicationConstraintResolution(context,
					this, ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT) };
		} else if (ICoreProblemType.MISSING_NET_COMM.equals(problemType)) {
			return new IDeployResolution[] { new CreateCommunicationConstraintResolution(context,
					this, ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT) };
		} else if (IUMLProblemType.UML_ELEMENT_TYPE_NOT_RESOLVED.equals(problemType)) {
			// TODO resolution to unbind?
			String message = NLS.bind(UMLDomainMessages.Delete_element_from_topology, new Object[] {});
			return new IDeployResolution[] { new DeleteDmoResolution(context, this, message) };
		} else if (IUMLProblemType.MISSING_UML_STEREOTYPE.equals(problemType)) {
			return new IDeployResolution[] { new AddMissingUmlStereotypeResolution(context, this) };
		}

		return new IDeployResolution[0];
	}

	public boolean hasResolutions(IDeployResolutionContext context) {

		//MK: 2008/1/10 - I keep seeing a NPE on the conditional test
		if (null == context) {
			return false;
		}
		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}
		String validator = status.getValidatorID();
		if (null == validator || 0 == validator.trim().length()) {
			return false;
		}
		String problemType = status.getProblemType();
		if (null == problemType || 0 == problemType.trim().length()) {

		}
		if (status.getValidatorID().equals(IUMLDomainValidators.UNIT_MISSING_CONNECTION_001)
				&& status.getProblemType().equals(ICoreProblemType.MISSING_NET_COMM)
				|| status.getProblemType().equals(ICoreProblemType.MISSING_APP_COMM)) {
			return true;
		}
		if (status.getValidatorID().equals(IUMLDomainValidators.UNRESOLVED_ELEMENT_001)
				&& status.getProblemType().equals(IUMLProblemType.UML_ELEMENT_TYPE_NOT_RESOLVED)) {
			return true;
		}
		if (status.getValidatorID().equals(IUMLDomainValidators.MISSING_UML_STEREOTYPE_001)
				&& status.getProblemType().equals(IUMLProblemType.MISSING_UML_STEREOTYPE)) {
			return true;
		}

		return false;
	}

}
