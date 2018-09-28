/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.validator.resolution;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2DeployPlugin;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.Messages;

/**
 * Resolves an attribute expected value by overwritting the attribute value.
 */
public class InsertNewDatabaseInstance extends DeployResolution {

	/** Descriptor of existing (or installable) instance to create. */
	private final UnitDescriptor instanceDescriptor;

	/** URI of template to use to create a new (logical) instance */
	private final String templateURI;

	/**
	 * Construct a resolution to insert an existing or installable database instance between a
	 * database and a database system.
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param instanceDescriptor
	 *           UnitDescriptor of an instance unit
	 * @param description
	 *           the resolution description
	 */
	public InsertNewDatabaseInstance(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, UnitDescriptor instanceDescriptor, String description) {
		this(context, generator, instanceDescriptor, null, description);
	}

	/**
	 * Construct a resolution to insert an existing or installable database instance between a
	 * database and a database system.
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param templateURI
	 *           URI of an instance template to create a new instance unit
	 * @param description
	 *           the resolution description
	 */
	public InsertNewDatabaseInstance(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String templateURI, String description) {
		this(context, generator, null, templateURI, description);
	}

	/**
	 * Construct a resolution to insert an existing or installable database instance between a
	 * database and a database system.
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param instanceDescriptor
	 *           UnitDescriptor of an instance unit
	 * @param templateURI
	 *           URI of an instance template to create a new instance unit
	 * @param description
	 *           the resolution description
	 */
	public InsertNewDatabaseInstance(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, UnitDescriptor instanceDescriptor,
			String templateURI, String description) {
		super(context, generator);
		this.instanceDescriptor = instanceDescriptor;
		this.templateURI = templateURI;
		setDescription(description);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		IDeployStatus status = context.getDeployStatus();

		try {
			String name = status.getProblemType();
			assert name != null;

			DeployModelObject object = status.getDeployObject();
			assert object != null;
			assert isRequirement(object);

			Requirement req = (Requirement) object;
			Unit owningUnit = ValidatorUtils.getOwningUnit(req);
			assert isDb2DatabaseUnit(owningUnit);
			DB2DatabaseUnit dbUnit = (DB2DatabaseUnit) owningUnit;
			assert dbUnit != null;

			// get database system; both are in the topology, linked by hosting link
			Unit logicalHost = ValidatorUtils.getHost(dbUnit);
			assert logicalHost != null;
			assert isDb2SystemUnit(logicalHost);
			DB2SystemUnit systemUnit = (DB2SystemUnit) logicalHost;

			// get instance either from unit descriptor or from template
			Unit instanceUnit = null;
			if (null != instanceDescriptor) {
				instanceUnit = instanceDescriptor
						.getUnitValueAndAddToTopology(dbUnit.getEditTopology());
			} else if (null != templateURI) {
				instanceUnit = (Unit) ResolutionUtils.addFromTemplate(templateURI, dbUnit
						.getEditTopology());
			}

			// remove existing hosting link (of course, find it first)
			if (systemUnit.getEditTopology() != null) {
				HostingLink targetLink = null;
				Collection<HostingLink> hlc = systemUnit.getEditTopology().getRelationships()
						.getHostedLinks(systemUnit);
				for (HostingLink link : hlc) {
					if (link.getTarget() == dbUnit) {
						// this is it
						targetLink = link;
						break;
					}
				}
				if (targetLink != null) {
					systemUnit.getHostingLinks().remove(targetLink);
				}
			}

			// add new hosting links
			if (null != instanceUnit) {
				LinkFactory.createHostingLink(logicalHost, instanceUnit);
				LinkFactory.createHostingLink(instanceUnit, dbUnit);
			}

			return Status.OK_STATUS;
		} catch (Throwable e) {
			DB2DeployPlugin.logError(0, e.getMessage(), e);
			return new Status(IStatus.ERROR, DB2DeployPlugin.PLUGIN_ID, 0,
					Messages.InsertNewDatabaseInstance_Exception_trying_to_resolve_marker_, e);
		}
	}

	protected boolean isDb2DatabaseUnit(DeployModelObject object) {
		return Db2Package.eINSTANCE.getDB2DatabaseUnit().isSuperTypeOf(object.getEObject().eClass());
	}

	protected boolean isRequirement(DeployModelObject object) {
		return CorePackage.eINSTANCE.getRequirement().isSuperTypeOf(object.getEObject().eClass());
	}

	protected boolean isDb2SystemUnit(DeployModelObject object) {
		return Db2Package.eINSTANCE.getDB2SystemUnit().isSuperTypeOf(object.getEObject().eClass());
	}

	protected boolean isDb2Instance(DeployModelObject object) {
		return Db2Package.eINSTANCE.getDB2Instance().isSuperTypeOf(object.getEObject().eClass());
	}

}
