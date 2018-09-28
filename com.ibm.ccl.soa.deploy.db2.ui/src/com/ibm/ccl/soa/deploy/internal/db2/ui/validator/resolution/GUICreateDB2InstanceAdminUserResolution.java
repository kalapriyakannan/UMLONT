/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.db2.ui.validator.resolution;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.Version;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.ui.DB2UIPlugin;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystem;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit;

/**
 * @since 7.0
 * 
 */
public class GUICreateDB2InstanceAdminUserResolution extends DeployResolution {

	protected GUICreateDB2InstanceAdminUserResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description) {
		super(context, generator, description);
		setRequiresUserInput(true);
	}

	public IStatus resolve(IProgressMonitor monitor) {

		UserPropertiesSetDialog dlg = new UserPropertiesSetDialog(new Shell());
		try {
			// Marker on DB2Instance capability
			IDeployStatus status = context.getDeployStatus();
			DB2InstanceUnit unit = (DB2InstanceUnit) status.getDeployObject();
			// Find hosting operating system
			UnitDescriptor hostingOSUnitDescriptor = ValidatorUtils.discoverHostUDInStack(unit,
					OsPackage.eINSTANCE.getOperatingSystemUnit(), monitor);
			OperatingSystemUnit hostingOSUnit = (OperatingSystemUnit) hostingOSUnitDescriptor
					.getUnitValue();
			if (hostingOSUnit instanceof LinuxOperatingSystemUnit
					|| hostingOSUnit instanceof AIXOperatingSystemUnit) {
				dlg.setDefaultUserId(SelectUserConstants.DEFAULT_UNIX_DB2_INSTANCE_ADMIN_USERID);
			} else if (hostingOSUnit instanceof WindowsOperatingSystemUnit) {
				dlg.setDefaultUserId(SelectUserConstants.DEFAULT_WINDOWS_DB2_INSTANCE_ADMIN_USERID);
			} else {
				return Status.OK_STATUS;
			}
			dlg.create();
			if (dlg.open() == Window.OK) {
				DB2Instance db2Instance = (DB2Instance) ValidatorUtils.getCapability(unit,
						Db2Package.eINSTANCE.getDB2Instance());
				if (db2Instance == null) {
					return Status.OK_STATUS;
				}
				UserUnit userUnit = createUserOnOSInTopology(hostingOSUnitDescriptor, context
						.getTopology(), dlg.getEditorUserid(), dlg.getEditorUserPassword(), db2Instance
						.getDb2Version(), context);
				if (userUnit == null) {
					return Status.OK_STATUS;
				}

				User userCap = (User) ValidatorUtils.getCapability(userUnit, OsPackage.eINSTANCE
						.getUser());
				assert userCap != null;
				Requirement userReq = ValidatorUtils.getFirstRequirement(unit, OsPackage.eINSTANCE
						.getUser());
				LinkDescriptor newLinkDescriptor = new LinkDescriptor(LinkType.DEPENDENCY, unit,
						userReq, userUnit, userCap);
				newLinkDescriptor.create();

				if (userCap.getUserId() != null) {
					db2Instance.setUsername(userCap.getUserId());
				}
				if (userCap.getUserPassword() != null) {
					db2Instance.setPassword(userCap.getUserPassword());
				}
				OperatingSystemUnit osUnit = (OperatingSystemUnit) ValidatorUtils.getHost(userUnit);
				if (osUnit != null) {
					OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getCapability(osUnit,
							OsPackage.eINSTANCE.getOperatingSystem());
					if (osCap != null) {
						if (osCap.getHostname() != null) {
							db2Instance.setHostname(osCap.getHostname());
						}
					}
				}
			}
		} catch (Exception ex) {
			DB2UIPlugin.logError(0, ex.getMessage(), ex);
		} finally {

		}

		return Status.OK_STATUS;
	}

	public static UserUnit createUserOnOSInTopology(UnitDescriptor hostingOSUD, Topology topology,
			String userID, String userPassword, String db2Version, IDeployResolutionContext context) {

		Unit hostingOSUnit = hostingOSUD.getUnitValueAndAddToTopology(topology);
		if (hostingOSUnit == null) {
			return null;
		}
		OperatingSystem hostingOSCap = (OperatingSystem) ValidatorUtils.getCapability(hostingOSUnit,
				OsPackage.eINSTANCE.getOperatingSystem());
		if (hostingOSCap == null) {
			return null;
		}
		boolean isWindowsOS = false;
		boolean isUnixOS = false;
		if (hostingOSCap.getOsType() != null) {
			if (hostingOSCap.getOsType().equalsIgnoreCase(
					OperatingSystemType.WINDOWS_LITERAL.getLiteral())
					|| hostingOSCap.getOsType().equalsIgnoreCase(
							OperatingSystemType.WINDOWS_CYGWIN_LITERAL.getLiteral())) {
				isWindowsOS = true;
			}
			if (hostingOSCap.getOsType()
					.equalsIgnoreCase(OperatingSystemType.AIX_LITERAL.getLiteral())
					||
					//hostingOSCap.getOsType().equalsIgnoreCase(OperatingSystemType.HPUX_LITERAL.getLiteral()) ||			
					hostingOSCap.getOsType().equalsIgnoreCase(
							OperatingSystemType.LINUX_LITERAL.getLiteral())
			//hostingOSCap.getOsType().equalsIgnoreCase(OperatingSystemType.SOLARIS_LITERAL.getLiteral()) 								
			) {
				isUnixOS = true;
			}
		}

//			System.out.println("isWindows:" + isWindowsOS + " - " + hostingOSCap.getOsType()); //$NON-NLS-1$ //$NON-NLS-2$

		UserUnit userUnit = null;
		if (isWindowsOS) {
			userUnit = (UserUnit) ResolutionUtils.addFromTemplate(
					IOsTemplateConstants.OS_WINDOWS_LOCAL_USER_UNIT, topology);
			setInstallStateForAddedUnit(userUnit);
			User userCap = (User) ValidatorUtils
					.getCapability(userUnit, OsPackage.eINSTANCE.getUser());
			assert userCap != null;
//				userUnit.setDisplayName(userID);
			userCap.setUserId(userID);
			userCap.setUserPassword(userPassword);
			ResolutionUtils.hosts(context, hostingOSUnit, userUnit);

			List<UnitDescriptor> osuHostedUnitDescriptors = TopologyDiscovererService.INSTANCE
					.findHosted(hostingOSUnit, topology);
			UserGroupUnit instanceAdminsUserGroupUnit = null;
			UserGroupUnit administratorsUserGroupUnit = null;

			// Find InstanceAdmin groups
			for (UnitDescriptor hostedUnitUD : osuHostedUnitDescriptors) {
				Unit hostedUnit = hostedUnitUD.getUnitValue();
				if (hostedUnit instanceof UserGroupUnit) {
					UserGroup userGroupCap = (UserGroup) ValidatorUtils.getCapability(hostedUnit,
							OsPackage.eINSTANCE.getUserGroup());
					if (userGroupCap.getGroupName() == null) {
						continue;
					}
					if (userGroupCap.getGroupName().equalsIgnoreCase(
							SelectUserConstants.DEFAULT_WIN_DB2_82PLUS_INSTANCE_ADMIN_GROUP)) {
						instanceAdminsUserGroupUnit = (UserGroupUnit) hostedUnit;
						break;
					}
					if (userGroupCap.getGroupName().equalsIgnoreCase(
							SelectUserConstants.ADMINISTRATORS_GROUP)) {
						administratorsUserGroupUnit = (UserGroupUnit) hostedUnit;
					}
				}
			}
			if (instanceAdminsUserGroupUnit == null) {
				Version v = new Version();
				if (v.interpString("8.2+", db2Version)) { //$NON-NLS-1$
					instanceAdminsUserGroupUnit = (UserGroupUnit) ResolutionUtils.addFromTemplate(
							IOsTemplateConstants.OS_WINDOWS_LOCAL_GROUP_UNIT, topology);
					setInstallStateForAddedUnit(instanceAdminsUserGroupUnit);

					UserGroup userGroupCap = (UserGroup) ValidatorUtils.getCapability(
							instanceAdminsUserGroupUnit, OsPackage.eINSTANCE.getUserGroup());
					instanceAdminsUserGroupUnit
							.setDisplayName(SelectUserConstants.DEFAULT_WIN_DB2_82PLUS_INSTANCE_ADMIN_GROUP);
					userGroupCap
							.setGroupName(SelectUserConstants.DEFAULT_WIN_DB2_82PLUS_INSTANCE_ADMIN_GROUP);
				}
			}
			if (administratorsUserGroupUnit == null) {
				administratorsUserGroupUnit = (UserGroupUnit) ResolutionUtils.addFromTemplate(
						IOsTemplateConstants.OS_WINDOWS_LOCAL_USER_UNIT, topology);
				setInstallStateForAddedUnit(administratorsUserGroupUnit);

				UserGroup userGroupCap = (UserGroup) ValidatorUtils.getCapability(
						administratorsUserGroupUnit, OsPackage.eINSTANCE.getUserGroup());
				administratorsUserGroupUnit.setDisplayName(SelectUserConstants.ADMINISTRATORS_GROUP);
				userGroupCap.setGroupName(SelectUserConstants.ADMINISTRATORS_GROUP);
			}
			if (instanceAdminsUserGroupUnit != null) {
				ResolutionUtils.hosts(context, hostingOSUnit, instanceAdminsUserGroupUnit);
				ResolutionUtils.addMember(context, instanceAdminsUserGroupUnit, userUnit);
			}
			if (administratorsUserGroupUnit != null) {
				ResolutionUtils.hosts(context, hostingOSUnit, administratorsUserGroupUnit);
				ResolutionUtils.addMember(context, administratorsUserGroupUnit, userUnit);
			}
		}
		if (userUnit != null) {
			return userUnit;
		}

		if (isUnixOS) {
			if (hostingOSCap instanceof RedhatLinuxOperatingSystem) {
				userUnit = (UserUnit) ResolutionUtils.addFromTemplate(
						IOsTemplateConstants.OS_REDHAT_4_LINUX_UNIT, topology);
			} else if (hostingOSCap instanceof SUSELinuxOperatingSystem) {
				userUnit = (UserUnit) ResolutionUtils.addFromTemplate(
						IOsTemplateConstants.OS_SUSE_LOCAL_USER_UNIT, topology);
			} else if (hostingOSCap instanceof AIXOperatingSystem) {
				userUnit = (UserUnit) ResolutionUtils.addFromTemplate(
						IOsTemplateConstants.OS_AIX_LOCAL_USER_UNIT, topology);
			}
			if (userUnit != null) {
				setInstallStateForAddedUnit(userUnit);

				User userCap = (User) ValidatorUtils.getCapability(userUnit, OsPackage.eINSTANCE
						.getUser());
				assert userCap != null;
				// userUnit.setDisplayName(userID);
				userCap.setUserId(userID);
				userCap.setUserPassword(userPassword);
				ResolutionUtils.hosts(context, hostingOSUnit, userUnit);

				List<UnitDescriptor> osuHostedUnitDescriptors = TopologyDiscovererService.INSTANCE
						.findHosted(hostingOSUnit, topology);
				UserGroupUnit instanceAdminsUserGroupUnit = null;

				// Find InstanceAdmin groups
				for (UnitDescriptor hostedUnitUD : osuHostedUnitDescriptors) {
					Unit hostedUnit = hostedUnitUD.getUnitValue();
					if (hostedUnit instanceof UserGroupUnit) {
						UserGroup userGroupCap = (UserGroup) ValidatorUtils.getCapability(hostedUnit,
								OsPackage.eINSTANCE.getUserGroup());
						if (userGroupCap.getGroupName() == null) {
							continue;
						}
						if (userGroupCap.getGroupName().startsWith(
								SelectUserConstants.DEFAULT_UNIX_DB2_INSTANCE_ADMIN_GROUPNAME_TEMPLATE)) {
							instanceAdminsUserGroupUnit = (UserGroupUnit) hostedUnit;
							break;
						}
					}
				}
				if (instanceAdminsUserGroupUnit == null) {
					if (hostingOSCap instanceof RedhatLinuxOperatingSystem) {
						instanceAdminsUserGroupUnit = (UserGroupUnit) ResolutionUtils.addFromTemplate(
								IOsTemplateConstants.OS_REDHAT_LOCAL_GROUP_UNIT, topology);
					} else if (hostingOSCap instanceof RedhatLinuxOperatingSystem) {
						instanceAdminsUserGroupUnit = (UserGroupUnit) ResolutionUtils.addFromTemplate(
								IOsTemplateConstants.OS_SUSE_LOCAL_GROUP_UNIT, topology);
					} else if (hostingOSCap instanceof AIXOperatingSystem) {
						instanceAdminsUserGroupUnit = (UserGroupUnit) ResolutionUtils.addFromTemplate(
								IOsTemplateConstants.OS_AIX_LOCAL_GROUP_UNIT, topology);
					}
					if (instanceAdminsUserGroupUnit != null) {
						setInstallStateForAddedUnit(instanceAdminsUserGroupUnit);

						UserGroup userGroupCap = (UserGroup) ValidatorUtils.getCapability(
								instanceAdminsUserGroupUnit, OsPackage.eINSTANCE.getUserGroup());
						instanceAdminsUserGroupUnit
								.setDisplayName(SelectUserConstants.DEFAULT_UNIX_DB2_INSTANCE_ADMIN_GROUPNAME_TEMPLATE);
						userGroupCap
								.setGroupName(SelectUserConstants.DEFAULT_UNIX_DB2_INSTANCE_ADMIN_GROUPNAME_TEMPLATE);
					}
				}
				if (instanceAdminsUserGroupUnit != null) {
					ResolutionUtils.hosts(context, hostingOSUnit, instanceAdminsUserGroupUnit);
					ResolutionUtils.addMember(context, instanceAdminsUserGroupUnit, userUnit);
				}
			}
		}
		return userUnit;
	}

	/**
	 * In general, the system does not know for sure the init state, and the desired state is
	 * installed.
	 * 
	 * @param unit
	 */
	private static void setInstallStateForAddedUnit(Unit unit) {
		unit.setInitInstallState(InstallState.UNKNOWN_LITERAL);
		unit.setGoalInstallState(InstallState.INSTALLED_LITERAL);
	}

}
