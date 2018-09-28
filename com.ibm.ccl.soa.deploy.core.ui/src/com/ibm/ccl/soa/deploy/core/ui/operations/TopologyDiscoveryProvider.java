/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.wizards.TopologyDiscoveryWizard;
import com.ibm.ccl.soa.deploy.internal.core.extension.DiscoverAndAddService;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerDataModelProvider;

/**
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * 
 * @see TopologyDiscoveryWizard
 * @see TopologyDiscoveryOperation
 */
public class TopologyDiscoveryProvider extends AbstractScribblerDataModelProvider implements
		IDataModelProvider, ITopologyDiscoveryProperties {

	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();

		propertyNames.add(SELECTED_ITEMS);
		propertyNames.add(EXPAND_SEARCH);
		propertyNames.add(CREATED_UNITS);
		propertyNames.add(IS_CREATE_FIND_HOST_FILTER);
		propertyNames.add(IS_CREATE_FIND_DEPENDENCIES_FILTER);
		propertyNames.add(TOPOLOGY_FILE);
		propertyNames.add(SELECTED_UNIT_DESCRIPTORS);
		propertyNames.add(POSSIBLE_UNIT_DESCRIPTORS);
		propertyNames.add(HAVE_SELECT_DISCOVERY_TYPE);

		return propertyNames;
	}

	public IDataModelOperation getDefaultOperation() {
		return new TopologyDiscoveryOperation(getDataModel());
	}

	public IStatus validate(String propertyName) {
		if (propertyName.equals(POSSIBLE_UNIT_DESCRIPTORS)
				&& model.getProperty(POSSIBLE_UNIT_DESCRIPTORS) == null) {
			return new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, 0,
					Messages.TOPOLOGY_DISCOVERY_WIZARD_NO_POSSIBLE_UNIT_DESCRIPTORS, null);
		} else if (propertyName.equals(SELECTED_ITEMS)) {
			Object[] selectedUnits = (Object[]) model.getProperty(SELECTED_ITEMS);
			if (selectedUnits != null && selectedUnits.length == 0) {
				return new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, 0,
						Messages.TOPOLOGY_DISCOVERY_WIZARD_NO_SOURCE_UNIT_SELECTED, null);
			}
		}

		return super.validate(propertyName);
	}

	public Object getDefaultProperty(String propertyName) {
		if (propertyName.equals(EDIT_MODEL_LABEL)) {
			IFile topologyFile = (IFile) getDataModel().getProperty(
					ITopologyDiscoveryProperties.TOPOLOGY_FILE);
			return DeploymentTopologyDomain.generateEditModelLabel(topologyFile);
		} else if (propertyName.equals(SCRIBBLER_DOMAINS)) {
			IFile topologyFile = (IFile) getDataModel().getProperty(
					ITopologyDiscoveryProperties.TOPOLOGY_FILE);
			return new IScribblerDomain[] { new DeploymentTopologyDomain(topologyFile) };
		} else if (propertyName.equals(IS_CREATE_FIND_HOST_FILTER)) {
			return new Boolean(true);
		} else if (propertyName.equals(EXPAND_SEARCH)) {
			return new Boolean(true);
		}/*
			 * else if(propertyName.equals(POSSIBLE_UNIT_DESCRIPTORS)){ return
			 * getDefaultPossibleUnitDescriptors(); }else
			 * if(propertyName.equals(SELECTED_UNIT_DESCRIPTORS)){ return
			 * null;//getDefaultSelectedUnitDescriptors(); }
			 */
		return super.getDefaultProperty(propertyName);
	}

	/**
	 * @return true if the create find host filter is set
	 */
	public boolean isCreateFindHostFilter() {
		return getBooleanProperty(IS_CREATE_FIND_HOST_FILTER);
	}

	/**
	 * @return true if the create find dependency filter is set
	 */
	public boolean isCreateFindDependencyFilter() {
		return getBooleanProperty(IS_CREATE_FIND_DEPENDENCIES_FILTER);
	}

	/**
	 * @return true if the is found on current topology
	 */
	public boolean isExpand() {
		return getBooleanProperty(EXPAND_SEARCH);
	}

	/**
	 * @param inputUnits
	 *           list of input units to be used for discovery. The POSSIBLE_UNIT_DESCRIPTORS property
	 *           is set, based on discovery. The SELECTED_ITEMS list is used for the input list.
	 * @return map of unit to possible unit descriptors
	 */
	public Map discoverPossibleUnitDescriptors() {
		DiscoverAndAddService discoverAndAddService = DiscoverAndAddService.INSTANCE;

		/*
		 * if (!isExpand()) { discoverAndAddService.setOnlyDiscoverInCurrentToplogy(); }
		 */

		if (isCreateFindHostFilter()) {
			return discoverAndAddService
					.discoverHostUnitDescriptors((Object[]) getProperty(SELECTED_ITEMS));
		}

		if (isCreateFindDependencyFilter()) {
			return discoverAndAddService.discoverDependencyUnitDescriptors(getSelectedUnits());
		}

		return null;
	}

	private List<Unit> getSelectedUnits() {
		Object[] selected = (Object[]) getProperty(SELECTED_ITEMS);
		List<Unit> units = new ArrayList<Unit>(selected.length);
		for (int i = 0; i < selected.length; i++) {
			if (selected[i] instanceof Unit) {
				units.add((Unit) selected[i]);
			}
		}
		return units;
	}

	public boolean propertySet(String propertyName, Object propertyValue) {

		if (HAVE_SELECT_DISCOVERY_TYPE.equals(propertyName)
				&& ((Boolean) propertyValue).booleanValue()) {
			// Discovery
			setProperty(POSSIBLE_UNIT_DESCRIPTORS, discoverPossibleUnitDescriptors());
		}

		return super.propertySet(propertyName, propertyValue);
	}

	/////////////////////////////// Discovery utilities ////////////////

	/**
	 * Discover the hosts descriptors for the units in the list
	 * 
	 * @param hosteeUnits
	 *           array of units that need to be hosted
	 * @return Map a map of hostee unit to the possible host descriptors
	 */
//	public Map discoverHostUnitDescriptors(Object[] hosteeUnits){
//		return discoverHostUnitDescriptors(Arrays.asList(hosteeUnits));		
//	}
	/**
	 * Discover the hosts descriptors for the units in the list
	 * 
	 * @param hosteeUnitList
	 *           list of units that need to be hosted
	 * @return Map a map of hostee unit to the possible host descriptors
	 */
//	public Map discoverHostUnitDescriptors(List hosteeUnitList){
//		Map possibleHostDescrs = new HashMap();
//		for (Iterator iter = hosteeUnitList.iterator(); iter.hasNext();) {
//			Unit hosteeUnit = (Unit) iter.next();
//			List hostDescList =  discoverHostUnitDescriptors(hosteeUnit);
//			if(hostDescList != null && !hostDescList.isEmpty())
//				possibleHostDescrs.put(hosteeUnit, hostDescList);
//		}
//		return possibleHostDescrs;
//	}
	/**
	 * Discover the hosts descriptors for the hostee unit
	 * 
	 * @param hostee
	 *           a unit that need to be hosted
	 * @return List possible host descriptors
	 */
//	public List discoverHostUnitDescriptors(Unit hostee) {
//		Topology topology = hostee.getTopology();
//		DiscoveryFilter filter = 
//			DiscoveryFilterFactory.createFindPossibleHostsFilter(hostee, topology);
//		if (TopologyDiscovererService.INSTANCE.canDiscover(filter)) {
//			if(isExpand()){
//				return TopologyDiscovererService.INSTANCE.findAll(filter);
//			}
//			return findAllOnCurrent(filter);
//		}
//		return new ArrayList(0);
//	}
	/**
	 * Discover the Dependency descriptors for the units in the list
	 * 
	 * @param hosteeUnits
	 *           array of units that need to be hosted
	 * @return Map a map of hostee unit to the possible host descriptors
	 */
//	public Map discoverDependencyUnitDescriptors(Object[] hosteeUnits){
//		return discoverDependencyUnitDescriptors(Arrays.asList(hosteeUnits));		
//	}
//		
	/**
	 * Discover the dependency descriptors for the units in the list
	 * 
	 * @param hosteeUnitList
	 *           list of units that need to be hosted
	 * @return Map a map of hostee unit to the possible host descriptors
	 */
//	public Map discoverDependencyUnitDescriptors(List hosteeUnitList){
//		Map possibleHostDescrs = new HashMap();
//		for (Iterator iter = hosteeUnitList.iterator(); iter.hasNext();) {
//			Unit hosteeUnit = (Unit) iter.next();
//			List requirements =  hosteeUnit.getRequirements();
//			List hostDescList = new ArrayList();
//			for (Iterator iterRe = requirements.iterator(); iterRe.hasNext();) {
//				Requirement unitRequirement = (Requirement) iterRe.next();
//				if (unitRequirement.getLinkType().getValue() == RequirementLinkTypes.DEPENDENCY){
//					List tempList =  discoverDependencyUnitDescriptors(hosteeUnit,unitRequirement);
//					for(int i=0;i<tempList.size();i++){
//						hostDescList.add(tempList.get(i));									 
//					}
//									
//				}
//			}
//			if(hostDescList != null && !hostDescList.isEmpty())
//				possibleHostDescrs.put(hosteeUnit, hostDescList);
//						
//		}	
//		return possibleHostDescrs;		
//	}
	/**
	 * Discover the dependency descriptors for the hostee unit
	 * 
	 * @param hostee
	 *           a unit that need to be hosted
	 * @return List possible host descriptors
	 */
//	public List discoverDependencyUnitDescriptors(Unit hostee, Requirement sourceRequirement) {
//		Topology topology = hostee.getTopology();			
//				
//		DiscoveryFilter filter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(hostee, sourceRequirement, topology);
//		if (TopologyDiscovererService.INSTANCE.canDiscover(filter)) {
//			if(isExpand()){
//				return TopologyDiscovererService.INSTANCE
//						.findAll(filter);
//						
//			}
//			return findAllOnCurrent(filter);
//		}
//		return new ArrayList(0);
//	}
	/**
	 * Discover the dependency descriptors for the hostee unit
	 * 
	 * @return return List of {@link UnitDescriptor}
	 */
//	public List findAllOnCurrent(DiscoveryFilter filter) {			
//				
//				
//		TopologyDiscoverer discoverer = new CurrentTopologyDiscoverer();	
//			
//		if (null == filter) return new ArrayList();			
//				
//		List[] results = new List[1];
//				
//		results[0] = discoverer.findAll(filter);			
//		List filteredResults = filterOutDuplicates (results);
//			
//		return filteredResults;
//	}
//			
//	public static List filterOutDuplicates (List [] results) {
//		// prepare list of the final, collaged results
//		List finalResults = new ArrayList ();
//				
//		// filter results as copy to make sure they are unique
//		for (int i = 0; i < results.length; i++) {
//			List resultList = results[i];
//			if (resultList == null) continue;
//			for (int j = 0; j < resultList.size(); j++) {
//				UnitDescriptor ud = (UnitDescriptor) resultList.get(j);
//				// is it the same as any other unit descriptor?
//				boolean newUD = true;
//				for (int k = 0; k < finalResults.size(); k++) {
//					// FIXME: this is the wrong way to compare units since the unit has a different topology
//					// need to look for unit in the new topology but this doesn't work either since it might not 
//					// should only need to compare ud that are on the current topology
//					if (ud.getUnitValue().equals(((UnitDescriptor) finalResults.get(k)).getUnitValue())) {
//					// if (ud.equals(finalResults.get(k))) {
//						newUD = false;
//						break;
//					}
//				}
//				if (newUD) {
//					finalResults.add(ud);
//				}
//			}
//		}
//				
//		return finalResults;
//	}
}
