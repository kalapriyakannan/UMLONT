/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.ui.editparts.WASConfigurationUnitEditPart;
import com.ibm.ccl.soa.deploy.was.ui.editparts.WASModuleEditPart;
import com.ibm.ccl.soa.deploy.was.ui.editparts.WASUnitGroupEditPart;
import com.ibm.ccl.soa.deploy.was.ui.util.WASConstants;

/**
 * 
 * Deploy tool Edit Part provider
 */
public class WASEditPartProvider extends AbstractEditPartProvider {

	// Map to hold the Shape Views
	private final Map<String, Class> nodeHintMap = new HashMap<String, Class>();
	{
		nodeHintMap.put(WASConstants.MODULE_WAS_SEMANTICHINT, WASModuleEditPart.class);
		nodeHintMap.put(WASConstants.CONFIGURATION_WAS_SEMANTICHINT,
				WASConfigurationUnitEditPart.class);
		nodeHintMap.put(WASConstants.UNITGROUP_WAS_SEMANTICHINT, WASUnitGroupEditPart.class);
	}

	/** list of supported shape editparts. */
	private final Map<EClass, Class> nodeMap = new HashMap<EClass, Class>();
	{
		nodeMap.put(WasPackage.eINSTANCE.getWebsphereAppServerUnit(), WASModuleEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasDeploymentManagerUnit(), WASModuleEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasWebServerUnit(), WASModuleEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasSystemUnit(), WASModuleEditPart.class);

		nodeMap.put(WasPackage.eINSTANCE.getWasDatasourceUnit(), WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasLdapConfigurationUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWASJ2CAuthenticationUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getExtendedJdbcProviderUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap
				.put(WasPackage.eINSTANCE.getDB2JdbcProviderUnit(), WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getDerbyJdbcProviderUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasNodeWindowsServiceUnit(),
				WASConfigurationUnitEditPart.class);
		//nodeMap.put( WasPackage.eINSTANCE.getWasSubstitutionVariableUnit(), WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasSharedLibraryEntryUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.Literals.WAS_CLASS_LOADER_CONFIGURATION_UNIT,
				WASConfigurationUnitEditPart.class);

		nodeMap.put(WasPackage.eINSTANCE.getWasDefaultMessagingConnectionFactoryUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasDefaultMessagingTopicConnectionFactoryUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasDefaultMessagingQueueConnectionFactoryUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasDefaultMessagingQueueDestinationUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasDefaultMessagingTopicDestinationUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasJMSActivationSpecificationUnit(),
				WASConfigurationUnitEditPart.class);

		nodeMap.put(WasPackage.eINSTANCE.getWasSibDestinationUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap
				.put(WasPackage.eINSTANCE.getWasSibMediationUnit(), WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasSibOutboundServiceUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasSibOutboundPortUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasSibInboundPortUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasSibInboundServiceUnit(),
				WASConfigurationUnitEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasEndpointListenerUnit(),
				WASConfigurationUnitEditPart.class);

		nodeMap.put(WasPackage.eINSTANCE.getWasCellUnit(), WASUnitGroupEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasNodeUnit(), WASModuleEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasNodeGroupUnit(), WASUnitGroupEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasClusterUnit(), WASUnitGroupEditPart.class);
		nodeMap.put(WasPackage.eINSTANCE.getWasSIBusUnit(), WASUnitGroupEditPart.class);

	}

	/**
	 * Gets a Node's editpart class. This method should be overridden by a provider if it wants to
	 * provide this service.
	 * 
	 * @param view
	 *           the view to be <i>controlled</code> by the created editpart
	 */
	protected Class getNodeEditPartClass(View view) {
		String semanticHint = view.getType();

		Class clazz = null;
		if (semanticHint != null && semanticHint.length() > 0) {
			clazz = nodeHintMap.get(semanticHint);
		} else {
			EClass eClass = getReferencedElementEClass(view);
			if (eClass != null) {
				clazz = nodeMap.get(eClass);
			}
		}

		return clazz;
	}
}
