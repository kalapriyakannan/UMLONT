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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit;
import com.ibm.ccl.soa.deploy.db2.DB2DeployPlugin;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.Messages;
import com.ibm.ccl.soa.deploy.db2.internal.Db2DomainMessages;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;

/**
 * @author Ed Snible
 * @see com.ibm.ccl.soa.deploy.db2.internal.validator.DB2AdminServerUnitValidator
 */
public class SuggestJdbcTypeGenerator implements IDeployResolutionGenerator {

	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof IDeployAttributeStatus)) {
			return false;
		}
		IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
		if (!ICoreProblemType.OBJECT_ATTRIBUTE_INVALID.equals(status.getProblemType())) {
			return false;
		}

		if (!(Db2Package.eINSTANCE.getDB2JdbcDriver_JdbcType() == status.getAttributeType())) {
			return false;
		}

		if (DeployModelObjectUtil.isSettable(status.getDeployObject(), status.getAttributeType())) {
			return false;
		}
		return true;
	}

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		return new IDeployResolution[] {
				new JdbcTypeResolution(context, this, JdbcTypeType._2_LITERAL),
				new JdbcTypeResolution(context, this, JdbcTypeType._4_LITERAL) };
	}

	/**
	 * Class that can set JdbcType on {@link DB2JdbcDriver} capability.
	 * 
	 * @author Ed Snible
	 */
	static class JdbcTypeResolution extends DeployResolution {

		private final JdbcTypeType value;

		public JdbcTypeResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, JdbcTypeType value) {
			super(context, generator);
			setDescription(DeployNLS.bind(Db2DomainMessages.Resolution_Set_0_JDBC_type_to_1,
					new Object[] { value, context.getDeployStatus().getDeployObject() }));
			this.value = value;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			DeployModelObject dmo = getProblemDmo(context);

			if (dmo instanceof DB2JdbcDriver) {
				DB2JdbcDriver driver = (DB2JdbcDriver) dmo;
				driver.setJdbcType(value);
				return Status.OK_STATUS;
			} else if (dmo instanceof DB2AdminServerUnit) {
				// TODO Why is the error being marked on the unit?
				DB2AdminServerUnit unit = (DB2AdminServerUnit) dmo;
				DB2JdbcDriver driver = (DB2JdbcDriver) ValidatorUtils.getCapability(unit,
						Db2Package.eINSTANCE.getDB2JdbcDriver());
				driver.setJdbcType(value);
				return Status.OK_STATUS;
			}

			return new Status(IStatus.ERROR, DB2DeployPlugin.PLUGIN_ID, 0,
					DeployCoreMessages.Marker_resolution_failed, null);
		}

		private DeployModelObject getProblemDmo(IDeployResolutionContext context) {
			IDeployStatus message = context.getDeployStatus();
			return message.getDeployObject();
		}

		public String getLabel() {
			return NLS.bind(Messages.SuggestJdbcTypeGenerator_Set_JDBC_Type_to_, value.getLiteral());
		}

	} // end inner class

}
