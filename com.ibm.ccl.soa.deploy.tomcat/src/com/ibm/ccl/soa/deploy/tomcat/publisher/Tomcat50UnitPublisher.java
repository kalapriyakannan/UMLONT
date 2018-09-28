/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.publisher;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jst.server.tomcat.core.internal.TomcatConfiguration;
import org.eclipse.jst.server.tomcat.core.internal.TomcatServer;
import org.xml.sax.SAXException;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.config.TomcatDataSource50Xml;

public class Tomcat50UnitPublisher extends TomcatUnitPublisher {

	protected void createTomcatConfigUnits(TomcatServer tomcatServer, TomcatConfiguration config,
			Unit[] units) {
		if (units == null)
			return;
		for (int i = 0; i < units.length; i++) {
			Unit unit = units[i];
			if (unit instanceof TomcatDatasourceUnit) {
				TomcatDatasourceUnit dataSource = (TomcatDatasourceUnit) unit;
				List services = dataSource.getOnlyDependencyCapabilities();
				for (Iterator iter = services.iterator(); iter.hasNext();) {
					Object element = iter.next();
					if (element instanceof Tomcat50Datasource) {
						Tomcat50Datasource tomcatDataSource50 = (Tomcat50Datasource) element;
						try {
							new TomcatDataSource50Xml(tomcatServer, tomcatDataSource50);
						} catch (IOException e) {
							e.printStackTrace();
						} catch (SAXException e) {

							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
