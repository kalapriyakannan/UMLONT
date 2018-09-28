package com.ibm.ccl.soa.deploy.core.internal.update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public abstract class UnitRefresherFactory {
	Unit unit;
	Topology topology;
	UnitRefresher dmoRefresher;
	List<DeployModelObject> createdUnits;
	List<DeployModelObject> existingRefreshedUnits;
	Map<DeployModelObject, DeployModelObject> replaceUnits;

	public UnitRefresherFactory(Unit aUnit) {
		unit = aUnit;
		topology = aUnit.getEditTopology();
		dmoRefresher = createRefresher(unit);
	}

	public abstract UnitRefresher createRefresher(Unit unit);

	public IStatus refresh() {
		if (dmoRefresher != null) {
			IStatus status = dmoRefresher.init();
			if (status.getSeverity() != IStatus.OK) {
				return status;
			}
			if (unit.getInitInstallState().getValue() == InstallState.INSTALLED) {
				executeReplaceOperation();
			} else {
				executeMergeOperation();
			}
		}
		return Status.OK_STATUS;
	}

	private void executeReplaceOperation() {
		try {
			AbstractEMFOperation replaceOperation = createReplaceOperation();
			if (replaceOperation != null) {
				replaceOperation.execute(new NullProgressMonitor(), null);
			}
		} catch (ExecutionException e) {
			DeployCorePlugin.logError(0,
					DeployCoreMessages.UnitRefresherFactory_Error_occurred_refreshing_uni_, e);
		}

	}

	private AbstractEMFOperation createReplaceOperation() {
		TransactionalEditingDomain ed = TransactionUtil.getEditingDomain(topology);
		AbstractEMFOperation update = new AbstractEMFOperation(ed,
				DeployCoreMessages.UnitRefresherFactory_refrsh_unit_s_) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				List<Object> environmentObjects = dmoRefresher.getEnvironmentUnits();
				Object[] objs = null;
				if (environmentObjects != null && !environmentObjects.isEmpty()) {
					objs = environmentObjects.toArray();
				}
				if (objs == null) {
					return Status.OK_STATUS;
				}
				for (int i = 0; i < objs.length; i++) {
					Object object = objs[i];
					if (object instanceof Unit) {
						Unit providerUnit = (Unit) object;
						Unit sourceUnit = getMatchingUnit(providerUnit, topology);
						if (sourceUnit == null) {
							addUnitToTopology(providerUnit);
							getCreatedUnits().add(providerUnit);
						} else {
							getReplaceUnits().put(sourceUnit, providerUnit);
						}
					}
				}

				return org.eclipse.core.runtime.Status.OK_STATUS;
			}

		};

		return update;
	}

	private void addUnitToTopology(Unit providerUnit) {
		topology.getUnits().add(providerUnit);

	}

	private void executeMergeOperation() {
		try {
			AbstractEMFOperation refreshOperation = createRefreshMergeOperation();
			if (refreshOperation != null) {
				refreshOperation.execute(new NullProgressMonitor(), null);
			}
		} catch (ExecutionException e) {
			DeployCorePlugin.logError(0,
					DeployCoreMessages.UnitRefresherFactory_Error_occurred_refreshing_uni_, e);
		}
	}

	public AbstractEMFOperation createRefreshMergeOperation() {
		TransactionalEditingDomain ed = TransactionUtil.getEditingDomain(topology);
		AbstractEMFOperation update = new AbstractEMFOperation(ed,
				DeployCoreMessages.UnitRefresherFactory_refrsh_unit_s_) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				List<Object> environmentObjects = dmoRefresher.getEnvironmentUnits();
				Object[] objs = null;
				if (environmentObjects != null && !environmentObjects.isEmpty()) {
					objs = environmentObjects.toArray();
				}
				if (objs == null) {
					return Status.OK_STATUS;
				}
				for (int i = 0; i < objs.length; i++) {
					Object object = objs[i];
					if (object instanceof Unit) {
						EObject obj = RefreshDeployEtoolsCopyUtility.createCopy((Unit) object, topology,
								null);
						if (topology.getUnits().contains(obj)) {
							getExistingRefreshedUnits().add((Unit) obj);
						} else {
							Unit copiedUnit = (Unit) obj;
							addUnitToTopology(copiedUnit);
							getCreatedUnits().add(copiedUnit);
						}
					}
				}

				return org.eclipse.core.runtime.Status.OK_STATUS;
			}

		};

		return update;
	}

	public List<DeployModelObject> getCreatedUnits() {
		if (createdUnits == null) {
			createdUnits = new ArrayList<DeployModelObject>();
		}
		return createdUnits;
	}

	public List<DeployModelObject> getExistingRefreshedUnits() {
		if (existingRefreshedUnits == null) {
			existingRefreshedUnits = new ArrayList<DeployModelObject>();
		}
		return existingRefreshedUnits;
	}

	public Unit getMatchingUnit(Unit unit, Topology topology) {
		List<Artifact> artifacts = unit.getArtifacts();
		if (artifacts.size() <= 0) {
			return null;
		}
		Artifact artifact = artifacts.get(0);
		Unit matchUnit = null;
		if (matchUnit == null) {
			List<Unit> units = topology.getUnits();
			for (Iterator iterator = units.iterator(); iterator.hasNext();) {
				Unit unit2 = (Unit) iterator.next();
				List<Artifact> artifacts2 = unit.getArtifacts();
				for (Iterator iterator2 = artifacts2.iterator(); iterator2.hasNext();) {
					Artifact artifact2 = (Artifact) iterator2.next();
					if (artifact2 instanceof FileArtifact && artifact instanceof FileArtifact) {
						if (artifact2.getKey().equals(artifact.getKey())) {
							return unit2;
						}
					}

				}

			}

		}
		return matchUnit;
	}

	public Map<DeployModelObject, DeployModelObject> getReplaceUnits() {
		if (replaceUnits == null) {
			replaceUnits = new HashMap<DeployModelObject, DeployModelObject>();
		}
		return replaceUnits;
	}

}
