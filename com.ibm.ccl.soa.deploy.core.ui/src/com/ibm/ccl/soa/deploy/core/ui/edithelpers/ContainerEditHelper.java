/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.edithelpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CopyUnitFromTemplateCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CreateConstraintLinkCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CreateDependencyLinkCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CreateHostingLinkCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CreateRealizationLinkCommand;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeploySemanticType;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * &lt;metamodelType edithelper&gt;, registered on
 * <code>org.eclipse.gmf.runtime.emf.type.core.elementTypes</code> extension point.
 * 
 * <p>
 * In SOA Deploy, <code>ContainerEditHelper</code> is the IEditHelper for {@link Topology} (and
 * only <code>Topology</code>).
 * 
 * @since 1.0
 * @see CopyUnitFromTemplateCommand
 * @see CreateDependencyLinkCommand
 */
public class ContainerEditHelper extends DeployCoreBaseEditHelper {

	/**
	 * Create a {@link CopyUnitFromTemplateCommand} given a request. The request's element type will
	 * be SOA Deploy's private UnitTypeFactory.HintedSpecializationType.
	 */
	protected ICommand getCreateCommand(CreateElementRequest req) {
		setDefaultContainmentFeature(req);
		return new CopyUnitFromTemplateCommand(req);
	}

	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		setDefaultContainmentFeature(req);
		if (req.getElementType() == DeploySemanticType.HOSTINGLINK) {
			return new CreateHostingLinkCommand(req);
		} else if (req.getElementType() == DeploySemanticType.DEPENDENCYLINK) {
			return new CreateDependencyLinkCommand(req);
		} else if (req.getElementType() == DeploySemanticType.CONSTRAINTLINK) {
			return new CreateConstraintLinkCommand(req);
		} else if (req.getElementType() == DeploySemanticType.REALIZATIONLINK) {
			return new CreateRealizationLinkCommand(req);
		}

		return super.getCreateRelationshipCommand(req);
	}

	protected void setDefaultContainmentFeature(CreateElementRequest req) {
		/*
		 * if the container for this command hasn't been set yet, set it now to the default container
		 */
		if (req.getContainmentFeature() == null) {
			/*
			 * if this is a hosting link, its default container is a hosting services set; we use the
			 * DeployValidatorService to actually create the link, so this is just for show
			 */
			if (req.getElementType() == DeploySemanticType.HOSTINGLINK) {
				req.setContainmentFeature(CorePackage.eINSTANCE.getDeployCoreRoot_LinkHosting());
			}
			/*
			 * if this is a service link, it has no GMF authorized default container so we're using the
			 * HostingLinks again-- the DeployValidatorService provides a method to create a service
			 * link so we don't nned to know it's containment feature nor do we use it in
			 * CreateServiceLinkCommand.doDefaultElementCreation()
			 */
			else if (req.getElementType() == DeploySemanticType.DEPENDENCYLINK) {
				req.setContainmentFeature(CorePackage.eINSTANCE.getDeployCoreRoot_LinkHosting());
			}

			/*
			 * if this is a unit, the default container is the topology units container
			 */
			else {
				req.setContainmentFeature(CorePackage.eINSTANCE.getTopology_Units());
			}

		}
	}

	@Override
	// we take care of the elements, thank you very much
	protected ICommand getMoveCommand(MoveRequest req) {
		return new MoveElementsCommand(req) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				return null;
			}

		};
	}

	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		return new DestroyElementCommand(req) {

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				/*
				 * if we're deleting a Unit, delete its links first
				 */
				EObject element = getElementToDestroy();
				// don't delete proxies
				if (PropertyUtils.isProxy((DeployModelObject) element)) {
					return CommandResult.newOKCommandResult();
				}

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
						List unitList = new ArrayList();
						unitList.add(unit);

						// keep processing until no more units
						do {
							for (Iterator it = unitList.iterator(); it.hasNext();) {
								destroyElementHelper((Unit) it.next(), hostingLinks, dependencyLinks,
										logicalLinks, memberLinks, realizeLinks, linkMap, unitMap,
										unitInGroupMap);
							}
							unitList = getNonDupUnits(unitInGroupMap, memberLinks, unitMap);
						} while (!unitList.isEmpty());

						// now delete the links and units in the maps
						Object links[] = linkMap.keySet().toArray();
						for (int i = 0; i < links.length; i++) {
							if (!PropertyUtils.isProxy((DeployModelObject) links[i])) {
								EcoreUtil.remove((EObject) links[i]);
							}
						}
						Object units[] = unitMap.keySet().toArray();
						for (int i = 0; i < units.length; i++) {
							if (!PropertyUtils.isProxy((DeployModelObject) units[i])) {
								EcoreUtil.remove((EObject) units[i]);
							}
						}

						ConfigurationContract contract = topology.getConfigurationContract();
						if (contract != null) {
							contract.clear(unit);
						}

					}

					// for imports delete any links from an imported unit to an editing canvas unit
				} else if (element instanceof Import) {
					Import theImport = (Import) element;
					//
					// delete any links to the import
					List candidates = new ArrayList(); //List of links to be deleted
					Iterator iter = theImport.getTopology().findAllDeployLinks();
					//Find all deploy links referencing import and tag to be removed
					while (iter.hasNext()) {
						DeployLink link = (DeployLink) iter.next();
						if (theImport.isReferencingMe(link.getTargetURI())
								|| theImport.isReferencingMe(link.getSourceURI())) {
							// is the link contained in the edit topology and has it been recorded
							if (link.getTopology() == theImport.getEditTopology()
									&& !candidates.contains(link)) {
								candidates.add(link);
							}
						}
					}
					//Delete the links
					iter = candidates.iterator();
					while (iter.hasNext()) {
						DeployLink link = (DeployLink) iter.next();
						EcoreUtil.remove(link);
					}

				}
				return super.doExecuteWithResult(monitor, info);
			}

			private void destroyElementHelper(Unit unit, List hostingLinks, List dependencyLinks,
					List logicalLinks, List memberLinks, List realizeLinks, HashMap linkMap,
					HashMap unitMap, HashMap unitInGroupMap) {

				// add hosting links to delete
				Iterator it = hostingLinks.iterator();
				while (it.hasNext()) {
					HostingLink link = (HostingLink) it.next();
					if (!linkMap.keySet().contains(link)) {
						if (unit == link.getHost() || unit == link.getHosted()) {
							linkMap.put(link, null);
						}
						// if what were are hosting is a contained unit, delete that too
						if (unit == link.getHost() && link.getHosted() != null
								&& ContainmentStateUtils.isContainedUnit(link.getHosted())) {
							unitMap.put(link.getHosted(), null);
							// since we're deleting a unit, see if we need to delete links to that
							destroyElementHelper(link.getHosted(), hostingLinks, dependencyLinks,
									logicalLinks, memberLinks, realizeLinks, linkMap, unitMap,
									unitInGroupMap);
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

			private List getNonDupUnits(HashMap unitInGroupMap, List memberLinks, HashMap unitMap) {
				List unitList = new ArrayList();

				for (Iterator it = unitInGroupMap.keySet().iterator(); it.hasNext();) {
					Unit unit = (Unit) it.next();

					// if we're already deleting it, never mind
					if (unitMap.containsKey(unit)) {
						continue;
					}

					// get total number of member links in model and see if we're deleting them all
					int nViews = getDuplicateViews(unit);
					for (Iterator it2 = memberLinks.iterator(); it2.hasNext();) {
						MemberLink link = (MemberLink) it2.next();
						if (link.getTarget() == unit) {
							nViews--;
						}
					}
					// if no more member links--or there never was, this is a non dup view
					if (nViews <= 0) {
						unitList.add(unit);
					}
				}

				// make sure to add these in delete map
				for (Iterator it = unitList.iterator(); it.hasNext();) {
					unitMap.put(it.next(), null);
				}
				unitInGroupMap.clear();
				return unitList;
			}

		};
	}

	protected int getDuplicateViews(Unit unit) {
		Topology topology = unit.getTopology();
		int nLinks = topology.findMemberOf(unit).length;
		DiagramEditPart diagramEP = ResourceUtils.getActiveDeployEditDomain().getDiagramEditPart();
		Iterator it = diagramEP.getChildren().iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof IGraphicalEditPart) {
				IGraphicalEditPart ep = (IGraphicalEditPart) o;
				if (unit == ViewUtil.resolveSemanticElement((View) ep.getModel())) {
					return nLinks + 1;
				}
			}
		}
		return nLinks;
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
