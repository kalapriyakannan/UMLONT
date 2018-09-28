package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validates that {@link Unit}s that contain <tt>&lt;constraint.realization / &gt;</tt> elements
 * have 0..* realizations that satisfy the nested constraints.
 * 
 * @since 7.0
 * 
 */
public class RealizationConstraintValidator extends ConstraintValidator {

	/**
	 * Validator for the Realization Constraint
	 */
	public static final String VALIDATOR_ID = RealizationConstraintValidator.class.getName();

	private static final String NULL_CAPTION = ""; //$NON-NLS-1$

	/**
	 * Default Constructor
	 */
	public RealizationConstraintValidator() {
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return ConstraintPackage.Literals.REALIZATION_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass());
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		MultiStatus retval = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, Status.OK_STATUS
				.getMessage(), null);
		SubMonitor submonitor = SubMonitor.convert(monitor);
		try {
			if (context instanceof Unit) {
				Unit conceptualUnit = (Unit) context;
				Unit[] realizations = RealizationLinkUtil.getRealizations(conceptualUnit);
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				} else {
					monitor
							.beginTask(
									NLS
											.bind(
													DeployCoreMessages.RealizationConstraintValidator_Validating_realizations_of_0_,
													conceptualUnit.getCaptionProvider().title(conceptualUnit)),
									realizations.length);
				}
				for (int i = 0; i < realizations.length; i++) {
					IStatus status = internalValidate(constraint, realizations[i], submonitor
							.newChild(1));
					if (!status.isOK()) {
						if (status.isMultiStatus()) {
							IStatus[] children = status.getChildren();
							for (int j = 0; j < children.length; j++) {
								retval.add(wrapStatusResult(conceptualUnit, realizations[i], children[j]));
							}
						} else {
							retval.add(wrapStatusResult(conceptualUnit, realizations[i], status));
						}
					}
				}

			}
		} finally {
			if (monitor != null) {
				monitor.done();
			}
		}
		return retval;
	}

	public String title(Constraint constraint) {
		String caption = computeCaptionTitle(constraint);
		if (caption == null || caption.length() == 0) {
			caption = DeployCoreMessages.RealizationConstraintFactory_Realization_Constrain_;
		}

		List constraints = constraint.getConstraints();
		String assembled = null;
		for (Iterator iterator = constraints.iterator(); iterator.hasNext();) {
			Constraint child = (Constraint) iterator.next();
			String childCaption = describe(child);
			if (assembled == null) {
				assembled = childCaption;
			} else if (iterator.hasNext()) {
				assembled = NLS.bind(DeployCoreMessages.RealizationConstraintValidator_0_1_,
						new Object[] { assembled, childCaption });
			} else {
				assembled = NLS.bind(DeployCoreMessages.RealizationConstraintValidator_0_1__2,
						new Object[] { assembled, childCaption });
			}
		}
		return NLS.bind(DeployCoreMessages.RealizationConstraintValidator_0_1__4, new Object[] {
				caption, assembled });
	}

	protected IDeployStatus wrapStatusResult(Unit conceptualUnit, Unit realization, IStatus status) {
		if (status instanceof IDeployStatus) {
			return DeployCoreStatusFactory.INSTANCE.createDeployWrapperStatus(status.getSeverity(),
					VALIDATOR_ID, ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH,
					DeployCoreMessages.RealizationConstraintValidator_Cannot_realize_0_to_1_Unsa_,
					new Object[] { conceptualUnit, realization, status.getMessage() }, conceptualUnit,
					(IDeployStatus) status);
		}
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(status.getSeverity(),
				VALIDATOR_ID, ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH,
				DeployCoreMessages.RealizationConstraintValidator_Cannot_realize_0_to_1_Unsa_,
				new Object[] { conceptualUnit, realization, status.getMessage() }, conceptualUnit);
	}

}
