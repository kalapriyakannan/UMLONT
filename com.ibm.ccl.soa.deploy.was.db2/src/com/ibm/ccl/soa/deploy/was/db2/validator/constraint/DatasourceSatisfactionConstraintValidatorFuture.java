/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator.constraint;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

public class DatasourceSatisfactionConstraintValidatorFuture extends ConstraintValidator {

	@Override
	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {

		// validate context
		if (null == context) {
			ConstraintUtil.createNullContextStatus(constraint);
		}
		if (!CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(context.getEObject().eClass())) {
			return ConstraintUtil.createInvalidContextStatus(constraint, context);
		}
		ConstraintLink link = (ConstraintLink) context;
		if (!linkEndpointsValid(link, J2eePackage.Literals.J2EE_DATASOURCE,
				DatabasePackage.Literals.DATABASE)) {
			return ConstraintUtil.createInvalidContextStatus(constraint, context);
		}

		Requirement srcReq = (Requirement) link.getSource();
//		Database target = (Database) link.getTarget();

		// validate that datasource requirement is satisfied by a datasource (eventually) hosted
		// on the same host as the module and that it has a J2EEDatasourceToDBCommunicationConstraint 
		// link to the target database.

		// identify the target datasource
		ResultStatusObject rso = getDatasourceFromRequirement(srcReq);
		if (!rso.isOK()) {
			return rso.getStatus();
		}
		J2EEDatasource ds = (J2EEDatasource) rso.getObject();

		// verify common host
		rso = verifyCommonHost(srcReq, ds, monitor);
		if (!rso.isOK()) {
			return rso.getStatus();
		}
//		Unit sourceHost = (Unit) rso.getObject();

		// validate that the datasource is referring to the target database
//		IStatus status = verifyDatasourceRefersToDB(ds, target, monitor);

		// TODO Auto-generated method stub
		return null;
	}

	private boolean linkEndpointsValid(ConstraintLink link, EClass srcType, EClass targetType) {
		DeployModelObject linkSrcObj = link.getSource();
		if (null == linkSrcObj
				|| !CorePackage.Literals.REQUIREMENT.isSuperTypeOf(linkSrcObj.getEObject().eClass())) {
			return false;
		}
		Requirement req = (Requirement) linkSrcObj;
		if (!srcType.isSuperTypeOf(req.getDmoEType())) {
			return false;
		}

		DeployModelObject linkTargetObj = link.getTarget();
		if (null == linkTargetObj || !targetType.isSuperTypeOf(linkTargetObj.getEObject().eClass())) {
			return false;
		}

		return true;
	}

	private ResultStatusObject getDatasourceFromRequirement(Requirement srcReq) {

		if (null == srcReq.getLink() || null == srcReq.getLink().getTarget()) {
			// datasource requirement not satisfied
		}
		DeployModelObject dsObj = srcReq.getLink().getTarget();
		if (!J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(dsObj.getEObject().eClass())) {
			// target of link is not a datasource
		}

		return new ResultStatusObject(dsObj);
	}

	private ResultStatusObject verifyCommonHost(DeployModelObject obj1, DeployModelObject obj2,
			IProgressMonitor monitor) {
		Unit host1 = getHost(obj1, null, monitor);
		if (null == host1) {
			// module not hosted; can not determine anything more
		}

		// get (eventual) host of ds module that is of the same type as the module host
		Unit host2 = getHost(obj2, host1.getEObject().eClass(), monitor);
		if (host1 == host2) {
			// we found a common host
			return new ResultStatusObject(host2, Status.OK_STATUS);
		}
		if (null == host2) {
			// might still have an deferred hosting constraint on it
		}

		// can't find evidence of common host
		// return can't verify that common host
		return null;
	}

	private Unit getHost(DeployModelObject source, EClass type, IProgressMonitor monitor) {
		Unit unit = null;
		if (source instanceof Unit) {
			unit = (Unit) source;
		} else if (source instanceof Requirement || source instanceof Capability) {
			unit = (Unit) source.getParent();
		}

		return null == type ? ValidatorUtils.discoverHost(unit, monitor) : ValidatorUtils
				.discoverHost(unit, type, monitor);
	}

	private IStatus verifyDatasourceRefersToDB(J2EEDatasource ds, Database db,
			IProgressMonitor monitor) {
		// one of the following should hold
		//    (a) ds has a dependency link to the target
		//    (b) ds has a dependency link chaing (via clients) to the target
		//    (c) ds has J2EEDatasourceToDBCommunicationConstraintLink to target
		//    (d) ds is configured with information about the target database

		Unit dsUnit = ValidatorUtils.getOwningUnit(ds);

		// test (a) && (b)
		List<Requirement> dbReqs = ValidatorUtils.getRequirements(dsUnit,
				DatabasePackage.Literals.DATABASE);
		for (Requirement req : dbReqs) {
			if (db == getTargetDatabase(req, db, monitor)) {
				return Status.OK_STATUS;
			}
		}

		// test (c)
//		for (Iterator<ConstraintLink> constraints = dsUnit.getEditTopology().findAllConstraintLinks(); constraints
//				.hasNext();) {
//			ConstraintLink constraint = constraints.next();
//			if (! WasDb2Package.Literals.J2EE_DATASOURCE_TO_DB_COMMUNICATION_CONSTRAINT_LINK
//					.isSuperTypeof(constraint.getEObject().eClass())) {
//				continue;
//			}
//			if (constraint.getSource() != ds || constraint.getTarget() != db) {
//				continue;
//			}
//
//			// found constraint
//			return Status.OK_STATUS;
//		}

		// test (d)
		// we can test several parameters  
		// If they are set (or not), don't match and are not setable/mutable, then we have an error
		// If they are set (or not), don't match and are setable/mutable, then we have a warning
		// We can consider, for example, the following parameters:
		//    (i) J2EE_DATASOURCE__DB_NAME
		//   (ii) J2EE_DATASOURCE__HOSTNAME
		//  (iii) J2EE_DATASOURCE__PORT
		//   (iv) username?
		//    (v) password?
		//
		// Unfortunately, these parameters are all not used in the default Database object
		// So we define a method to do these checks and leave it blank.  Technology specific 
		// extensions can overwrite this method to add checks.
		if (!verifyDatasourceDefinition(ds, db)) {
			// datasource definition does not satisfy requirement
		}

		return Status.OK_STATUS;
	}

	private Database getTargetDatabase(Requirement source, Capability target,
			IProgressMonitor monitor) {
		if (null == source || null == source.getLink() || null == source.getLink().getTarget()) {
			return null;
		}

		Capability reqTarget = ValidatorUtils.discoverDependencyLinkTarget(source, monitor);
		if (target == reqTarget) {
			return (Database) reqTarget;
		}

		Unit targetUnit = ValidatorUtils.getOwningUnit(reqTarget);
		if (DatabasePackage.Literals.DATABASE.isSuperTypeOf(reqTarget.getEObject().eClass())) {
			List<Requirement> reqs = ValidatorUtils.getRequirements(targetUnit,
					DatabasePackage.Literals.DATABASE);
			for (Requirement req : reqs) {
				return getTargetDatabase(req, target, monitor);
			}
		}

		return null;
	}

	protected boolean verifyDatasourceDefinition(J2EEDatasource ds, Database db) {
		return true;
	}

	private class ResultStatusObject {
		private final DeployModelObject _object;
		private final IStatus _status;

		public ResultStatusObject(DeployModelObject object) {
			_object = object;
			_status = Status.OK_STATUS;
		}

		public ResultStatusObject(DeployModelObject object, IStatus status) {
			_object = object;
			_status = status;
		}

		public DeployModelObject getObject() {
			return _object;
		}

		public IStatus getStatus() {
			return _status;
		}

		public boolean isOK() {
			return _status.isOK();
		}
	}

}
