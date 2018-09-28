/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitProviderDescriptor;

/**
 * Provide information about elements that may be deployed including adapting an arbitrary element
 * to a {@link DeployModelObject}.
 * 
 * <p>
 * Any element is potentially deployable. Clients must describe to the SOA Topology Modeler
 * framework which elements may be deployed using the
 * <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitProvider</b> extension point. That extension
 * point requires clients to supply a subclass of this object. The client implementation will only
 * be invoked when an element matching the expression defined by the client's extension is
 * encountered.
 * </p>
 * <p>
 * Please refer to the extension point documentation for
 * <b>com.ibm.ccl.soa.deploy.core.unitLifecycle/unitProvider</b> for more information.
 * </p>
 * 
 * @since 1.0
 * 
 */
public abstract class UnitProvider extends ChangeProvider {

	/**
	 * An empty array of {@link TopologyUnitStub} to return instead of <b>null</b>.
	 */
	public static final TopologyUnitStub[] NO_STUBS = new TopologyUnitStub[0];

	/**
	 * An empty array of {@link DeployModelObject} to return instead of <b>null</b>.
	 */
	public static final DeployModelObject[] NO_MODEL_OBJS = new DeployModelObject[0];

	private UnitProviderDescriptor descriptor;

	/**
	 * Given an input object (from a view or otherwise indicated by the user), quickly determine what
	 * underlying domain model elements the input object may correspond to. Avoid any heavy
	 * operations or more document loading than is absolutely necessary.
	 * 
	 * @param anInputObject
	 *           An element that matches the input enablement specified by the extension
	 *           corresponding to this provider.
	 * @return An array of stub elements that can be used to represent the potential underlying
	 *         domain model elements.
	 */
	public abstract TopologyUnitStub[] resolveStubs(Object anInputObject);

	/**
	 * 
	 * @param aStub
	 *           The stub that was selected by the user or the framework for more detailed
	 *           resolution.
	 * @param toResolveLazily
	 *           <b>True</b> indicates that the underlying EMF model should initially restrict the
	 *           population of its fields to the bare minimum; fields should be resolved and
	 *           populated as the client of this provider requests them. <b>False</b> indicates that
	 *           the EMF object should be fully resolved (and thus all of its fields completely
	 *           populated) when returned.
	 * @param aMonitor
	 *           Announce the underlying events to the monitor to provide user-feedback in long
	 *           running operations. Implementations should be prepared to handle <b>null</b> (even
	 *           if only converting the <b>null</b> value to a {@link NullPointerException}.
	 * @return An array of DeployModelObjects representing the underlying domain model corresponding
	 *         to the given stub.
	 */
	public abstract Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor);

	/**
	 * 
	 * @param aDeployModelObjects
	 *           The list of deploy model objects that need to be used as source to resolve the links
	 *           for.
	 * @param aMonitor
	 *           Announce the underlying events to the monitor to provide user-feedback in long
	 *           running operations. Implementations should be prepared to handle <b>null</b> (even
	 *           if only converting the <b>null</b> value to a {@link NullPointerException}.
	 * @return A boolean value as true, if any links were added or updated.
	 */

	public abstract boolean resolveLinks(List aDeployModelObjects, IProgressMonitor aMonitor);

	/**
	 * TODO : Replace with resolution framework.
	 * 
	 * @param unit
	 *           Unit used to derive an underlying input object.
	 * @param aMonitor
	 *           Announce the underlying events to the monitor to provide user-feedback in long
	 *           running operations. Implementations should be prepared to handle <b>null</b> (even
	 *           if only converting the <b>null</b> value to a {@link NullPointerException}.
	 * @return The object the unit was derived from.
	 */
	public Object resolveUnderlyingResource(Unit unit, IProgressMonitor aMonitor) {
		return null;
	}

	public final void setDescriptor(UnitProviderDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	public final UnitProviderDescriptor getDescriptor() {
		return descriptor;
	}

	@Override
	public Change[] createImportChange(final Topology topology, final TopologyUnitStub stub,
			IProgressMonitor monitor) {
		final String providerName = getDescriptor().getName();
		Change[] changes = new Change[] { new SynchronizationChange(stub.getTopology(),
				getDescriptor().getDescription()) {

			@Override
			public Change perform(IProgressMonitor monitor) throws CoreException {

				try {
					monitor.beginTask(NLS.bind(DeployCoreMessages.UnitProvider_Resolving_Units_for_0_,
							stub.getName()), 10);

					monitor.subTask(DeployCoreMessages.UnitProvider_Resolving_units_);
					Object[] resolvedUnits = resolveUnit(stub, true, new SubProgressMonitor(monitor, 6,
							SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));

					if (resolvedUnits != null && resolvedUnits.length > 0) {
						List resolved = Arrays.asList(resolvedUnits);
						for (int i = 0; i < resolved.size(); i++) {
							Unit unit = (Unit) resolved.get(i);
							unit.setOrigin(providerName);
							ResolutionUtils.makeNameUnique(unit, topology);
							topology.getUnits().add(unit);
						}
						//topology.getUnits().addAll(resolved);
						monitor.subTask(DeployCoreMessages.UnitProvider_Resolving_links_);
						resolveLinks(Arrays.asList(resolvedUnits), new SubProgressMonitor(monitor, 2,
								SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
					} else {
						DeployCorePlugin
								.logError(
										0,
										"No units were provided for \"" + stub.getName() + "\" by the \"" + stub.getSource().getDescriptor().getName() + "\" provider.", null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						monitor.worked(2);
					}

				} finally {
					monitor.done();
				}

				return null;
			}

		} };
		return changes;
	}

	/**
	 * 
	 * @param top
	 *           the topology
	 * @param aStub
	 *           the topology stub to resolve
	 * @return The resolved Unit, or none if no existing instance in topology
	 */
	public Unit resolveExistingInstance(Topology top, TopologyUnitStub aStub) {
		return null;
	}
}
