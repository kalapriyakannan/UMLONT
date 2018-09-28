/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.ui.editparts;

import java.util.Iterator;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.ui.figures.DB2FigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class DB2ModuleEditPart extends ModuleEditPart {
	/**
	 * @param view
	 */
	public DB2ModuleEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}
		Iterator<Capability> it = unit.getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = it.next();
			if (capability instanceof DB2Instance) {
				DB2Instance db = (DB2Instance) capability;
				setCategory(NLS.bind(DB2EditPartMessages.DB2_0_Instance, new Object[] { (db
						.getDb2Version() == null ? "" : db.getDb2Version()) + " " })); //$NON-NLS-1$ //$NON-NLS-2$
				break;
			} else if (capability instanceof DB2ClientInstance) {
				DB2ClientInstance dbcli = (DB2ClientInstance) capability;
				setCategory(NLS.bind(DB2EditPartMessages.DB2_Client_0_Instance, new Object[] { (dbcli
						.getDb2Version() == null ? "" : dbcli.getDb2Version()) + " " })); //$NON-NLS-1$ //$NON-NLS-2$
				break;
			} else if (capability instanceof DB2System) {
				DB2System dbs = (DB2System) capability;
				setCategory(NLS.bind(DB2EditPartMessages.DB2_0_System, new Object[] { (dbs
						.getDb2Version() == null ? "" : dbs.getDb2Version()) + " " })); //$NON-NLS-1$ //$NON-NLS-2$
				break;
			} else if (capability instanceof DB2Client) {
				DB2Client dbc = (DB2Client) capability;
				if (unit instanceof DB2RuntimeClientUnit) {
					setCategory(NLS.bind(DB2EditPartMessages.DB2_0_Runtime_Client, new Object[] { (dbc
							.getDb2ClientVersion() == null ? "" : dbc.getDb2ClientVersion()) + " " })); //$NON-NLS-1$ //$NON-NLS-2$
				} else {
					setCategory(NLS.bind(DB2EditPartMessages.DB2_0_Client, new Object[] { (dbc
							.getDb2ClientVersion() == null ? "" : dbc.getDb2ClientVersion()) + " " })); //$NON-NLS-1$ //$NON-NLS-2$
				}
				break;
			} else if (capability instanceof DB2Database) {
				DB2Database db = (DB2Database) capability;
				setCategory(NLS.bind(DB2EditPartMessages.DB2_0_Database, new Object[] { (db
						.getDb2Version() == null ? "" : db.getDb2Version()) + " " })); //$NON-NLS-1$ //$NON-NLS-2$
				break;
			}
		}

	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = DB2FigureFactory.createNewDB2UnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
