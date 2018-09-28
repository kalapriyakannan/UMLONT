package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import java.util.Map;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.CompositeEMFOperation;
import org.eclipse.wst.common.environment.IEnvironment;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

public class CompositeEMFDataModelOperation extends CompositeEMFOperation implements
		IDataModelOperation {
	/**
	 * <p>
	 * Convenience IStatus.OK.
	 * </p>
	 */
	protected static final IStatus OK_STATUS = IDataModelProvider.OK_STATUS;

	private String id;
	private IEnvironment environment;

	/**
	 * <p>
	 * The IDataModel used by this IDataModelOperation
	 * </p>
	 */
	protected IDataModel model;

	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 * 
	 * @param domain
	 * @param label
	 */
	public CompositeEMFDataModelOperation(TransactionalEditingDomain domain, String label) {
		super(domain, label);
		id = getClass().getName();
	}

	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 * 
	 * @param domain
	 */
	public CompositeEMFDataModelOperation(TransactionalEditingDomain domain, String label,
			Map<?, ?> options) {
		super(domain, label, options);
		id = getClass().getName();
	}

	/**
	 * <p>
	 * Constructor taking an IDataModel
	 * </p>
	 * 
	 * @param model
	 *           the IDataModel used to drive this operation
	 */
	public CompositeEMFDataModelOperation(TransactionalEditingDomain domain, String label,
			IDataModel model, Map<?, ?> options) {
		super(domain, label, options);
		this.model = model;
		id = getClass().getName();
	}

	/**
	 * <p>
	 * Default implementation of setID().
	 * <p>
	 * 
	 * @see IDataModelOperation#setID(String)
	 */
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * <p>
	 * Default implementation of getID().
	 * </p>
	 * 
	 * @see IDataModelOperation#getID()
	 */
	public String getID() {
		return id;
	}

	/**
	 * <p>
	 * Default implementation of setDataModel()
	 * </p>
	 * 
	 * @see IDataModelOperation#setDataModel(IDataModel)
	 */
	public void setDataModel(IDataModel model) {
		this.model = model;
	}

	/**
	 * <p>
	 * Default implementation of getDataModel()
	 * </p>
	 * 
	 * @see IDataModelOperation#getDataModel()
	 */
	public IDataModel getDataModel() {
		return model;
	}

	/**
	 * <p>
	 * Default implementation of getSchedulingRule() returns
	 * <code>ResourcesPlugin.getWorkspace().getRoot()</code>.
	 * </p>
	 * 
	 * @see IDataModelOperation#getSchedulingRule()
	 */
	public ISchedulingRule getSchedulingRule() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	/**
	 * <p>
	 * Default implementation of getOperationExecutionFlags() returns
	 * <code>IWorkspace.AVOID_UPDATE</code>.
	 * </p>
	 * 
	 * @see IDataModelOperation#getOperationExecutionFlags()
	 */
	public int getOperationExecutionFlags() {
		return IWorkspace.AVOID_UPDATE;
	}

	/**
	 * <p>
	 * The framework will set the environment on this operation before it is executed. The operation
	 * can then use the environment to report status, log information, and access resources in an
	 * environment neutral way.
	 * </p>
	 * 
	 * @param env
	 *           the environment.
	 * 
	 */
	public final void setEnvironment(IEnvironment env) {
		environment = env;
	}

	/**
	 * <p>
	 * An operation can call this method to get the environment that has been set by the operations
	 * framework.
	 * </p>
	 * 
	 * @return returns an environment.
	 */
	public final IEnvironment getEnvironment() {
		return environment;
	}
}
