/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.ui.editparts;

import java.util.Iterator;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConfigurationEditPart;
import com.ibm.ccl.soa.deploy.os.WindowsLocalService;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider;
import com.ibm.ccl.soa.deploy.was.ExtendedJdbcProvider;
import com.ibm.ccl.soa.deploy.was.SharedLibraryEntry;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.was.WasClassLoaderPolicy;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestination;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration;
import com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibInboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibInboundService;
import com.ibm.ccl.soa.deploy.was.WasSibMediation;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundService;
import com.ibm.ccl.soa.deploy.was.WasV4Datasource;
import com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.ui.figures.WASFigureFactory;

/**
 * Holds a logiocal node, which is a container capable of holding deployable units.
 */
public class WASConfigurationUnitEditPart extends ConfigurationEditPart {
	/**
	 * @param view
	 */
	public WASConfigurationUnitEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}
		Iterator it = unit.getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof WasV5DB2Datasource) {
				setCategory(WASEditPartMessages.Was_Db2_V5_Datasource);
				break;
			} else if (capability instanceof WasV5Datasource) {
				setCategory(WASEditPartMessages.Was_V5_Datasource);
				break;
			} else if (capability instanceof WasV4Datasource) {
				setCategory(WASEditPartMessages.Was_V4_Datasource);
				break;
			} else if (capability instanceof WASJ2CAuthenticationDataEntry) {
				setCategory(WASEditPartMessages.Was_J2c_Authentication);
				break;
			} else if (capability instanceof DB2JdbcProvider) {
				setCategory(WASEditPartMessages.Was_Db2_Jdbc_Provider);
				break;
			} else if (capability instanceof DerbyJdbcProvider) {
				setCategory(WASEditPartMessages.Was_Derby_Jdbc_Provider);
				break;
			} else if (capability instanceof ExtendedJdbcProvider) {
				setCategory(WASEditPartMessages.Was_Jdbc_Provider);
				break;
			} else if (capability instanceof SharedLibraryEntry) {
				setCategory(WASEditPartMessages.Was_Shared_Library_Entry);
				break;
			} else if (capability instanceof WasClassLoaderPolicy) {
				setCategory(WASEditPartMessages.Was_Class_Loader_Policy);
				break;
			} else if (capability instanceof ExtendedJdbcProvider) {
				setCategory(WASEditPartMessages.Was_Jdbc_Provider);
				break;
			} else if (capability instanceof WasDefaultMessagingConnectionFactoryConfiguration) {
				setCategory(WASEditPartMessages.Was_Default_Messageing_Connection_Factory);
				break;
			} else if (capability instanceof WasDefaultMessagingQueueConnectionFactoryConfiguration) {
				setCategory(WASEditPartMessages.Was_Default_Messageing_Queue_Connection_Factory);
				break;
			} else if (capability instanceof WasDefaultMessagingTopicConnectionFactoryConfiguration) {
				setCategory(WASEditPartMessages.Was_Default_Messageing_Topic_Connection_Factory);
				break;
			} else if (capability instanceof WasDefaultMessagingQueueDestination) {
				setCategory(WASEditPartMessages.Was_Default_Messageing_Queue_Destination);
				break;
			} else if (capability instanceof WasDefaultMessagingTopicDestination) {
				setCategory(WASEditPartMessages.Was_Default_Messageing_Topic_Destination);
				break;
			} else if (capability instanceof WasJMSActivationSpecification) {
				setCategory(WASEditPartMessages.Was_Default_Messageing_Jms_ActivationSpecification);
				break;
			} else if (capability instanceof WasSibOutboundService) {
				setCategory(WASEditPartMessages.Sib_Outbound_Service);
				break;
			} else if (capability instanceof WasSibInboundService) {
				setCategory(WASEditPartMessages.Sib_Inbound_Service);
				break;
			} else if (capability instanceof WasSibInboundPort) {
				setCategory(WASEditPartMessages.Sib_Inbound_Port);
				break;
			} else if (capability instanceof WasSibOutboundPort) {
				setCategory(WASEditPartMessages.Sib_Outbound_Port);
				break;
			} else if (capability instanceof WasSibMediation) {
				setCategory(WASEditPartMessages.Sib_Mediation);
				break;
			} else if (capability instanceof WasSibDestination) {
				setCategory(WASEditPartMessages.Sib_Destination);
				break;
			} else if (capability instanceof WasEndpointListenerConfiguration) {
				setCategory(WASEditPartMessages.Was_Endpoint_Listener);
				break;
			} else if (capability instanceof WindowsLocalService) {
				setCategory(WASEditPartMessages.Was_Windows_Local_Service);
				break;
			} else {
				setCategory(WASEditPartMessages.Was_Unrecognized_Configuration);
			}
		}
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = WASFigureFactory.createNewWASUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
