/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;

/**
 * save the state of a topology before a resolution in order to select new dmo's afterwards
 * 
 * @since 7.0
 * 
 */
public class TopologyStateData {
	private Topology _topology = null;
	private final List<DeployModelObject> _oldDmos = new ArrayList<DeployModelObject>();
	private final Map<DeployLink, DeployModelObject> _srcMap = new HashMap<DeployLink, DeployModelObject>();
	private final Map<DeployLink, DeployModelObject> _tgtMap = new HashMap<DeployLink, DeployModelObject>();
	private final List<Unit> _newUnits = new ArrayList<Unit>();
	private final List<DeployModelObject> _newLinks = new ArrayList<DeployModelObject>();
	private final List<DeployModelObject> _newViews = new ArrayList<DeployModelObject>();
	private final Set<DeployModelObject> _modDmos = new HashSet<DeployModelObject>();
	private final List<DeployModelObject> _deletedDmos = new ArrayList<DeployModelObject>();

	/**
	 * @return dmo's in current topology
	 */
	public List<DeployModelObject> getOldDmos() {
		return _oldDmos;
	}

	/**
	 * @return saved source of a link dmo
	 */
	public Map<DeployLink, DeployModelObject> getSrcMap() {
		return _srcMap;
	}

	/**
	 * @return saved target of a link dmo
	 */
	public Map<DeployLink, DeployModelObject> getTgtMap() {
		return _tgtMap;
	}

	/**
	 * @return new units
	 */
	public List<Unit> getNewUnits() {
		return _newUnits;
	}

	/**
	 * @return new links
	 */
	public List<DeployModelObject> getNewLinks() {
		return _newLinks;
	}

	/**
	 * @return deleted dmos
	 */
	public List<DeployModelObject> getDeletedDmos() {
		return _deletedDmos;
	}

	/**
	 * @return modified dmos (retargeted links)
	 */
	public Set<DeployModelObject> getModifiedDmos() {
		return _modDmos;
	}

	/**
	 * @return units that new views have to be created for-- can include new units or new links to
	 *         existing units
	 */
	public List<DeployModelObject> getNewViews() {
		return _newViews;
	}

	/**
	 * save current topology state
	 * 
	 * @param topology
	 *           topology to be saved
	 */
	public TopologyStateData(Topology topology) {
		if (topology == null) {
			topology = getTopology();
		}
		if (topology == null) {
			return;
		}
		_topology = topology;

		// save topology state
		for (Iterator<DeployModelObject> it = _topology.findAllUnits(); it.hasNext();) {
			Unit unit = (Unit) it.next();
			//cfgMap.put(unit, new Boolean(unit.isConfigurationUnit()));
			_oldDmos.add(unit);
		}
		for (Iterator<DeployModelObject> it = _topology.findAllHostingLinks(); it.hasNext();) {
			HostingLink link = (HostingLink) it.next();
			_srcMap.put(link, link.getSource());
			_tgtMap.put(link, link.getTarget());
			_oldDmos.add(link);
		}
		for (Iterator<DeployModelObject> it = _topology.findAllMemberLinks(); it.hasNext();) {
			MemberLink link = (MemberLink) it.next();
			_srcMap.put(link, link.getSource());
			_tgtMap.put(link, link.getTarget());
			_oldDmos.add(link);
		}
		for (Iterator<DeployModelObject> it = _topology.findAllDependencyLinks(); it.hasNext();) {
			DependencyLink link = (DependencyLink) it.next();
			_srcMap.put(link, link.getSource());
			_tgtMap.put(link, link.getTarget());
			_oldDmos.add(link);
		}

		// stop canonical refreshes on changes to topology		
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			CanonicalUtils.pauseSemanticCacheRefresh((DeployDiagramEditPart) editor
					.getDiagramEditPart());
		}
	}

	/**
	 * find
	 * 
	 * @param topology
	 */
	public void markChanges() {
		if (_topology == null) {
			return;
		}

		//////////////////////////////////////////////////
		////////////// build map of resolution results
		///////////////////////////////////////////////////		
		for (Iterator<DeployModelObject> it = _topology.findAllUnits(); it.hasNext();) {
			_newUnits.add((Unit) it.next());
		}
		for (Iterator<DeployModelObject> it = _topology.findAllHostingLinks(); it.hasNext();) {
			HostingLink link = (HostingLink) it.next();
			if (_srcMap.containsKey(link)
					&& (_srcMap.get(link) != link.getSource() || _tgtMap.get(link) != link.getTarget())) {
				_modDmos.add(link);
			}
			_newLinks.add(link);
		}
		for (Iterator<DeployModelObject> it = _topology.findAllMemberLinks(); it.hasNext();) {
			MemberLink link = (MemberLink) it.next();
			if (_srcMap.containsKey(link)
					&& (_srcMap.get(link) != link.getSource() || _tgtMap.get(link) != link.getTarget())) {
				_modDmos.add(link);
			}
			_newLinks.add(link);
		}
		for (Iterator<DeployModelObject> it = _topology.findAllDependencyLinks(); it.hasNext();) {
			DependencyLink link = (DependencyLink) it.next();
			if (_srcMap.containsKey(link)
					&& (_srcMap.get(link) != link.getSource() || _tgtMap.get(link) != link.getTarget())) {
				_modDmos.add(link);
			}
			_newLinks.add(link);
		}
		for (Iterator<DeployModelObject> it = _oldDmos.iterator(); it.hasNext();) {
			DeployModelObject dmo = it.next();
			if (dmo instanceof Unit) {
				if (_newUnits.contains(dmo)) {
					_newUnits.remove(dmo);
				} else {
					_deletedDmos.add(dmo);
				}
			} else {
				if (_newLinks.contains(dmo)) {
					_newLinks.remove(dmo);
				} else {
					_deletedDmos.add(dmo);
				}
			}
		}

		// add new units and source/targets of new links to new views list
		Set<DeployModelObject> createViewSet = new HashSet<DeployModelObject>();
		createViewSet.addAll(_newUnits);
		for (Iterator<DeployModelObject> it = _newLinks.iterator(); it.hasNext();) {
			DeployModelObject dmo = it.next();
			if (dmo instanceof DependencyLink) {
				createViewSet.add(((DependencyLink) dmo).getSource());
				createViewSet.add(((DependencyLink) dmo).getTarget());
			} else if (dmo instanceof ConstraintLink) {
				createViewSet.add(((ConstraintLink) dmo).getSource());
				createViewSet.add(((ConstraintLink) dmo).getTarget());
			} else if (dmo instanceof RealizationLink) {
				createViewSet.add(((RealizationLink) dmo).getSource());
				createViewSet.add(((RealizationLink) dmo).getTarget());
			} else if (dmo instanceof UnitLink) {
				createViewSet.add(((UnitLink) dmo).getSource());
				createViewSet.add(((UnitLink) dmo).getTarget());
			}
		}
		_newViews.addAll(createViewSet);

		//resume canonical refreshes on changes to topology
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			DeployDiagramEditPart diagramEP = (DeployDiagramEditPart) editor.getDiagramEditPart();
			CanonicalUtils.resumeSemanticCacheRefresh(diagramEP);
		}
	}

	private Topology getTopology() {
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			EObject eo = editor.getDiagramEditPart().resolveSemanticElement();
			if (eo instanceof Topology) {
				return (Topology) eo;
			}
		}
		return null;
	}

}
