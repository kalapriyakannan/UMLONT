package com.ibm.ccl.soa.deploy.net.validator.pattern.attribute;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.net.Messages;

/**
 * @author barnold
 * 
 */
public class MACAddressSyntacticAttributeValidator extends DeployAttributeValidator {

	/**
	 * @param validatorID
	 * @param attribute
	 */
	public MACAddressSyntacticAttributeValidator(String validatorID, EAttribute attribute) {
		super(validatorID, attribute);
	}

	public void validate(DeployModelObject object, IDeployValidationContext context, IDeployReporter reporter) {
		String value = (String) getAttributeValue(object);
		if ((value != null) && (value.length() > 0)) {
			if (!validMACAddressSyntax(value)) {
				IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.ERROR, validatorID,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, Messages.MACAddressSyntaxInvalid, new String[] { value }, object, getFullAttributeName());
				reporter.addStatus(status);
			}
		}

	}

	/**
	 * Validate that parameter is six pairs of hex digits (upper or lower case) separated by either "-" or ":"
	 * @param value
	 * @return
	 */
	private boolean validMACAddressSyntax(String value) {
		final String hexDigits = "0123456789ABCDEF"; //$NON-NLS-1$
		String segments[] = value.split("[-:]"); //$NON-NLS-1$
		if (segments.length != 6) {
			return false;
		}
		for (int i=0; i<segments.length; ++i) {
			if (segments[i].length() != 2) {
				return false;
			}
			for (int j=0; j<2; ++j) { 
				String digit = segments[i].substring(j, j+1).toUpperCase();
				if (hexDigits.indexOf(digit) < 0) {
					return false;
				}
			}
		}
		return true;
	}

}
