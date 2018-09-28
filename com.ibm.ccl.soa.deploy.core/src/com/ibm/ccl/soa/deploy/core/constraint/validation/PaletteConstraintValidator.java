package com.ibm.ccl.soa.deploy.core.constraint.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployTransactionReporter;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

public class PaletteConstraintValidator extends ConstraintValidator {
	private Topology topology;

	public PaletteConstraintValidator() {
		reporter.setGroupID(IConstants.PALETTE_VALDIATOR_ID);
	}

	private final Adapter constraintListener = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			if (msg.getEventType() == Notification.SET) {
				List constraints = ValidatorUtils.getConstraints(topology,
						ConstraintPackage.Literals.PALETTE_CONSTRAINT);
				if (constraints.isEmpty()) {
					List units = topology.getImports();
					for (Iterator iterator = units.iterator(); iterator.hasNext();) {
						Import importObj = (Import) iterator.next();
						flushStatus(importObj);
						removeAdapter();
					}

				}
			}

		}

		private void removeAdapter() {
			topology.removeTopologyListener(constraintListener, ConstraintPackage.eINSTANCE
					.getConstraintRoot_ConstraintPalette());
		}

		private void flushStatus(DeployModelObject dmo) {
			reporter.updateStatus(dmo, new ArrayList(), new ArrayList());
		}
	};
	DeployTransactionReporter reporter = new DeployTransactionReporter();

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return constraint instanceof PaletteConstraint;
	}

	private void addTopologyListener() {
		if (!topology.eAdapters().contains(constraintListener)) {
			topology.addTopologyListener(constraintListener, ConstraintPackage.eINSTANCE
					.getConstraintRoot_ConstraintPalette());
		}

	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		topology = context.getTopology();
		// Validate imports
		List imports = topology.getImports();
		for (Iterator iterator = imports.iterator(); iterator.hasNext();) {
			Import importObj = (Import) iterator.next();
			updateStatus(getWarningStatus(importObj), importObj);

		}
		// Validate resource type id
		PaletteConstraint paletteConstraint = (PaletteConstraint) constraint;
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		String rtid = paletteConstraint.getResourceTypeId();
		if (!rts.isDynamicPaletteEntry(rtid)) {
			updateStatus(getInvalidResourceTypeIdStatus(rtid, constraint), constraint);
		}

		addTopologyListener();
		return Status.OK_STATUS;
	}

	private IStatus getWarningStatus(Import importObj) {
		DeployStatus status = (DeployStatus) DeployCoreStatusFactory.INSTANCE.createDeployStatus(
				IStatus.ERROR, IDeployCoreValidators.INVALID_IMPORT_001,
				ICoreProblemType.NO_APPLICATION_PROTOCOL_DETAILS,
				DeployCoreMessages.PaletteConstraintValidator_Imported_topologies_are_not_support_,
				new Object[] {}, importObj);
		status.setValidatorGroupID(IConstants.PALETTE_VALDIATOR_ID);

		return status;
	}

	private IStatus getInvalidResourceTypeIdStatus(String id, Constraint constraint) {
		DeployStatus status = (DeployStatus) DeployCoreStatusFactory.INSTANCE.createDeployStatus(
				IStatus.ERROR, IDeployCoreValidators.INVALID_RESOURCE_TYPE_ID_001,
				ICoreProblemType.INVALID_RESOURCE_TYPE_ID,
				DeployCoreMessages.PaletteConstraintValidator_UnknownResourceTypeId_0,
				new Object[] { id }, constraint);
		status.setValidatorGroupID(IConstants.PALETTE_VALDIATOR_ID);

		return status;
	}

	protected void updateStatus(final IStatus status, final DeployModelObject dmo) {
		Topology topology = dmo.getEditTopology();
		if (topology == null) {
			return;
		}
		final ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(topology);
		try {
			changeScope.execute(getModifyOperation(status, dmo, changeScope, reporter),
					ChangeScope.OPTION_DO_NOT_SAVE, null);

		} finally {
			if (changeScope != null) {
				changeScope.close(null);
			}
		}

	}

	public AbstractEMFOperation getModifyOperation(final IStatus status,
			final DeployModelObject source, ChangeScope changeScope,
			final DeployTransactionReporter reporter) {
		AbstractEMFOperation op = new AbstractEMFOperation(changeScope
				.getTransactionalEditingDomain(),
				DeployCoreMessages.PaletteConstraintValidator_Add_import_error_statu_) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				ArrayList<IStatus> list = new ArrayList<IStatus>();
				if (status != null) {
					list.add(status);
				}
				reporter.updateStatus(source, new ArrayList(), list);
				return Status.OK_STATUS;

			}

			@Override
			public boolean canUndo() {
				return true;
			}
		};

		return op;

	}

}
