/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.CompositeEMFOperation;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * This simple operation will delete a DeployModelObject from its parent. This operation does not
 * create a new edit model. It assumes it is being run under a write resource.
 * 
 * @since CCL 2.0
 * 
 */
public class DeleteModelObjectOperation extends DeployModelObjectOperation {

	private EObject owner;
	private EStructuralFeature containerFeature;
	private boolean processLinks;

	/**
	 * Create an {@link IUndoableOperation} that will be able to delete the List of
	 * {@link DeployModelObject}s in a single operation.
	 * 
	 * @param objectsToDelete
	 *           A {@link List} of {@link DeployModelObject}s to delete.
	 * @param operationLabel
	 *           A label for the new {@link IUndoableOperation}.
	 * @return An {@link IUndoableOperation} or null if the objectsToDelete is null or empty.
	 */
	public static IUndoableOperation createDeleteModelObjectOperation(
			List<? extends EObject> objectsToDelete, String operationLabel) {
		if (objectsToDelete != null && !objectsToDelete.isEmpty()) {
			EObject firstObject = objectsToDelete.get(0);
			//Get editing Domain.
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(firstObject);
			if (objectsToDelete.size() > 1) {
				List<DeleteModelObjectOperation> childOps = new ArrayList<DeleteModelObjectOperation>(
						objectsToDelete.size());
				for (Iterator<? extends EObject> it = objectsToDelete.iterator(); it.hasNext();) {
					childOps.add(new DeleteModelObjectOperation(it.next(), operationLabel));
				}
				return new CompositeEMFOperation(domain, operationLabel, childOps);
			}
			return new DeleteModelObjectOperation(firstObject, operationLabel);
		}
		return null;
	}

	/**
	 * @param objectToDelete
	 *           The {@link DeployModelObject} to be removed from the model.
	 * @param label
	 *           a label for the operation.
	 */
	public DeleteModelObjectOperation(EObject objectToDelete, String label) {
		super(objectToDelete, label);
	}

	/**
	 * @param objectToDelete
	 *           The {@link DeployModelObject} to be removed from the model.
	 * @param label
	 *           a label for the operation.
	 * @param processLinks
	 *           flag to delete relvant links for the unit
	 */
	public DeleteModelObjectOperation(EObject objectToDelete, String label, boolean processLinks) {
		super(objectToDelete, label);
		this.processLinks = processLinks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.workspace.AbstractEMFOperation#doExecute(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
		//Need to react to feature maps.
		EStructuralFeature containmentFeature = getContainerFeature();
		if (FeatureMapUtil.isFeatureMap(containmentFeature)) {
			containmentFeature = context.eContainmentFeature();
		}
		if (processLinks) {
			doDelete(context);
		} else {
			EcoreUtil.remove(getOwner(), containmentFeature, context);
		}
		return Status.OK_STATUS;
	}

	private EStructuralFeature getContainerFeature() {
		if (containerFeature == null) {
			containerFeature = context.eContainingFeature();
		}
		return containerFeature;
	}

	private EObject getOwner() {
		if (owner == null) {
			owner = context.eContainer();
		}
		return owner;
	}

	private void doDelete(EObject element) {
		if (element instanceof Unit) {
			Unit unit = (Unit) element;
			Topology topology = unit.getEditTopology();
			if (topology != null) {

				// get local copy of hosting, dependency and member links
				List hostingLinks = new ArrayList();
				for (Iterator it = topology.findAllHostingLinks(); it.hasNext();) {
					hostingLinks.add(it.next());
				}
				List dependencyLinks = new ArrayList();
				for (Iterator it = topology.findAllDependencyLinks(); it.hasNext();) {
					dependencyLinks.add(it.next());
				}
				List logicalLinks = new ArrayList();
				for (Iterator it = topology.findAllConstraintLinks(); it.hasNext();) {
					logicalLinks.add(it.next());
				}
				List memberLinks = new ArrayList();
				for (Iterator it = topology.findAllMemberLinks(); it.hasNext();) {
					memberLinks.add(it.next());
				}
				List realizeLinks = new ArrayList();
				for (Iterator it = topology.findAllRealizationLinks(); it.hasNext();) {
					realizeLinks.add(it.next());
				}

				// create maps that will hold links and units to delete
				HashMap linkMap = new HashMap();
				HashMap unitMap = new HashMap();
				HashMap unitInGroupMap = new HashMap();
				unitMap.put(unit, null);

				destroyElementHelper(unit, hostingLinks, dependencyLinks, logicalLinks, memberLinks,
						realizeLinks, linkMap, unitMap, unitInGroupMap);

				// now delete the links and units in the maps
				Object links[] = linkMap.keySet().toArray();
				for (int i = 0; i < links.length; i++) {
					EcoreUtil.remove((EObject) links[i]);
				}
				Object units[] = unitMap.keySet().toArray();
				for (int i = 0; i < units.length; i++) {
					EcoreUtil.remove((EObject) units[i]);
				}

			}
		}
	}

	private void destroyElementHelper(Unit unit, List hostingLinks, List dependencyLinks,
			List logicalLinks, List memberLinks, List realizeLinks, HashMap linkMap, HashMap unitMap,
			HashMap unitInGroupMap) {

		Iterator it = hostingLinks.iterator();
		while (it.hasNext()) {
			HostingLink link = (HostingLink) it.next();
			if (!linkMap.keySet().contains(link)) {
				if (unit == link.getHost() || unit == link.getHosted()) {
					linkMap.put(link, null);
				}
			}
		}

		// add dependency links to delete
		it = dependencyLinks.iterator();
		while (it.hasNext()) {
			DependencyLink link = (DependencyLink) it.next();
			if (unit == getUnit(link.getSource()) || unit == getUnit(link.getTarget())) {
				linkMap.put(link, null);
			}
		}

		// add logical links to delete
		it = logicalLinks.iterator();
		while (it.hasNext()) {
			ConstraintLink link = (ConstraintLink) it.next();
			if (unit == getUnit(link.getSource()) || unit == getUnit(link.getTarget())) {
				linkMap.put(link, null);
			}
		}

		// add realization links to delete
		it = realizeLinks.iterator();
		while (it.hasNext()) {
			RealizationLink link = (RealizationLink) it.next();
			if (unit == getUnit(link.getSource()) || unit == getUnit(link.getTarget())) {
				linkMap.put(link, null);
			}
		}

		// add memeber links to delete
		it = memberLinks.iterator();
		while (it.hasNext()) {
			MemberLink link = (MemberLink) it.next();
			// if either the member unit OR the unit group is being deleted, delete the member link too
			if (unit == link.getSource() || unit == link.getTarget()) {
				linkMap.put(link, null);
			}
			// if the unit group is being deleted, make sure to delete the member unit too!
			if (unit == link.getSource()) {
				// we don't know if we can delete this yet-- got to 
				unitInGroupMap.put(link.getTarget(), null);
			}
		}

	}

	private Unit getUnit(EObject obj) {
		while (!(obj instanceof Unit) && obj != null) {
			obj = obj.eContainer();
		}
		if (obj instanceof Unit) {
			return (Unit) obj;
		}
		return null;
	}

}
