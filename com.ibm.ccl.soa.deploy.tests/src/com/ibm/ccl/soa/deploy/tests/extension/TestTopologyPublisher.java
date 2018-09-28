/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.internal.core.CacheTopologyPublisher;

public class TestTopologyPublisher extends CacheTopologyPublisher {

	public String getName() {
		// TODO Auto-generated method stub
		return "Test Topology Publisher";
	}

	public TestTopologyPublisher() {

	}

	protected IStatus doPublish(Topology aTopology) {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(aTopology);
		if (editingDomain == null) {
			// if the topology hasn't been associated with a domain yet,
			// create one
			editingDomain = GMFEditingDomainFactory.getInstance()
					.createEditingDomain();
		}
// Add status to units
		Iterator units = aTopology.getUnits().iterator();
		while (units.hasNext()) {
			Unit unit = (Unit) units.next();
			final Unit finalUnit = unit;

			AbstractEMFOperation operation = new AbstractEMFOperation(
					editingDomain, StringStatics.BLANK) {
				protected IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) {
					return addError(finalUnit);

				}
			};
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}

		}

		return Status.OK_STATUS;
	}

	public IStatus unpublish(Topology aTopology) {
		// TODO Auto-generated method stub
		return null;
	}

	protected IStatus addError(Unit unit) {
		for (Iterator index = unit.getCapabilities().iterator(); index
				.hasNext();) {
			Capability cap = (Capability) index.next();
			IDeployPublishStatus newStatus = DeployCoreStatusFactory.INSTANCE
					.createPublisherStatus(IStatus.ERROR, getName(),
							"capability problem",
							"there are errores in capability {0}",
							new Object[] { cap }, getCapException(), unit);
			this.topologyCache.addUnitStatus(newStatus, unit);

		}
		for (Iterator index = unit.getRequirements().iterator(); index
				.hasNext();) {
			Requirement req = (Requirement) index.next();
			IDeployPublishStatus newStatus = DeployCoreStatusFactory.INSTANCE
					.createPublisherStatus(IStatus.WARNING, getName(),
							"requirement problem",
							"there are warnings in requrement {0}",
							new Object[] { req }, getReqException(), unit);
			this.topologyCache.addUnitStatus(newStatus, unit);
		}
		IDeployPublishStatus newStatus = DeployCoreStatusFactory.INSTANCE
				.createPublisherStatus(IStatus.INFO, getName(),
						"unit is published", "{0} is published",
						new Object[] { unit }, null, unit);
		this.topologyCache.addUnitStatus(newStatus, unit);
		return Status.OK_STATUS;

	}

	private Exception getCapException() {
		class CapException extends Exception {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public String getMessage() {
				// TODO Auto-generated method stub
				return "Capability Exception";
			}

		}
		return new CapException();
	}

	private Exception getReqException() {
		class ReqException extends Exception {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public String getMessage() {
				// TODO Auto-generated method stub
				return "Requirement Exception";
			}

		}
		return new ReqException();
	}
}
