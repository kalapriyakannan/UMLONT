/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyUnitDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.Version;
import com.ibm.ccl.soa.deploy.core.validator.pattern.DeployValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.Db2DomainMessages;
import com.ibm.ccl.soa.deploy.db2.internal.validator.util.UseridPasswordHostnameUser;
import com.ibm.ccl.soa.deploy.os.AIXLocalGroup;
import com.ibm.ccl.soa.deploy.os.AIXLocalUser;
import com.ibm.ccl.soa.deploy.os.AIXLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystem;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups;
import com.ibm.ccl.soa.deploy.os.LinuxLocalGroup;
import com.ibm.ccl.soa.deploy.os.LinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.LinuxLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.os.WindowsLocalGroup;
import com.ibm.ccl.soa.deploy.os.WindowsLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.OsValidatorUtils;

/**
 * Static {@link DB2Database} verification utility methods.
 */
public final class DB2ValidatorUtils {

	public static String DB2ADMIN = "db2admin"; //$NON-NLS-1$
	public static String DB2INST = "db2inst"; //$NON-NLS-1$
	public static String DB2ADMNS = "DB2ADMNS"; //$NON-NLS-1$
	public static String DB2IADM = "db2iadm"; //$NON-NLS-1$
	private static String newline = System.getProperty("line.separator"); //$NON-NLS-1$
	private static String SecondaryCpSeparator = ";"; //$NON-NLS-1$;

	private DB2ValidatorUtils() {
		// static methods only
	}

	/**
	 * Checks a DB2 name using the DB2 "naming conventions".
	 * <p>
	 * {@link "http://publib.boulder.ibm.com/infocenter/db2luw/v8/index.jsp?topic=/com.ibm.db2.udb.doc/core/c0008278.htm"}
	 * <p>
	 * This section provides information about the conventions that apply when naming database
	 * manager objects, such as databases and tables, and authentication IDs.
	 * <p>
	 * <ul>
	 * <li> Character strings that represent names of database manager objects can contain any of the
	 * following: a-z, A-Z, 0-9, @, #, and $.
	 * 
	 * <li> User IDs and groups may also contain any of the following additional characters when
	 * supported by the security plug-in: 7 _, !, %, (, ), {, }, -, ., ^.
	 * 
	 * <li> User IDs and groups containing any of the following characters must be delimited with
	 * quotations when entered through the command line processor: 7 !, %, (, ), {, }, -, ., ^,
	 * 
	 * <li> The first character in the string must be an alphabetic character, @, #, or $; it cannot
	 * be a number or the letter sequences SYS, DBM, or IBM.
	 * <p>
	 * Unless otherwise noted, names can be entered in lowercase letters; however, the database
	 * manager processes them as if they were uppercase.
	 * <p>
	 * The exception to this is character strings that represent names under the systems network
	 * architecture (SNA). Many values, such as logical unit names (partner_lu and local_lu), are
	 * case sensitive. The name must be entered exactly as it appears in the SNA definitions that
	 * correspond to those terms.
	 * 
	 * <li> A database name or database alias is a unique character string containing from one to
	 * eight letters, numbers, or keyboard characters from the set described above.
	 * <p>
	 * Databases are cataloged in the system and local database directories by their aliases in one
	 * field, and their original name in another. For most functions, the database manager uses the
	 * name entered in the alias field of the database directories. (The exceptions are CHANGE
	 * DATABASE COMMENT and CREATE DATABASE, where a directory path must be specified.)
	 * 
	 * <li> The name or the alias name of a table or a view is an SQL identifier that is a unique
	 * character string 1 to 128 characters in length. Column names can be 1 to 30 characters in
	 * length.
	 * <p>
	 * A fully qualified table name consists of the schema.tablename. The schema is the unique user
	 * ID under which the table was created. The schema name for a declared temporary table must be
	 * SESSION.
	 * 
	 * <li> Authentication IDs cannot exceed 30 characters on Windows 32-bit operating systems and 8
	 * characters on all other operating systems.
	 * 
	 * <li> Group IDs cannot exceed 30 characters in length.
	 * 
	 * <li> Local aliases for remote nodes that are to be cataloged in the node directory cannot
	 * exceed eight characters in length.
	 * </ul>
	 * 
	 * @param name
	 *           the database name to be checked.
	 */
	public static void validateDB2GenericName(String name, DeployModelObject object,
			EAttribute attribute, IDeployReporter reporter) {

		if (name == null || name.length() == 0) {
//			reporter.addMessage(DeployCoreStatusUtil.createObjectAttributeUndefinedMarker(object, attribute));
			return;
		}

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			// a-z, A-Z, 0-9, @, #, and $.
			if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '@'
					|| c == '#' || c == '$') {
				// ok
			} else {
				IDeployStatus message = DeployCoreStatusUtil.createObjectAttributeInvalidStatus(object,
						attribute);
				message
						.setUnboundMessage(Db2DomainMessages.Validator_DB2_generic_name_0_contains_invalid_character_1);
				message.setBindings(new String[] { name, Character.toString(c) });
				reporter.addStatus(message);
				return;
			}
		}

		char firstChar = name.charAt(0);
		if (Character.isDigit(firstChar)) {
			IDeployStatus message = DeployCoreStatusUtil.createObjectAttributeInvalidStatus(object,
					attribute);
			message
					.setUnboundMessage(Db2DomainMessages.Validator_DB2_generic_name_0_first_character_is_digit);
			reporter.addStatus(message);
			return;
		}

		String upperName = name.toUpperCase();
		if (upperName.startsWith("SYS") || upperName.startsWith("DBM") || upperName.startsWith("IBM")) {//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			IDeployStatus message = DeployCoreStatusUtil.createObjectAttributeInvalidStatus(object,
					attribute);
			message
					.setUnboundMessage(Db2DomainMessages.Validator_DB2_generic_name_0_has_restricted_prefix_1);
			message.setBindings(new String[] { name, upperName.substring(0, 3) });
			reporter.addStatus(message);
			return;
		}

		if (upperName.equals("USERS") || //$NON-NLS-1$
				upperName.equals("ADMINS") || //$NON-NLS-1$
				upperName.equals("GUESTS") || //$NON-NLS-1$
				upperName.equals("PUBLIC") || //$NON-NLS-1$
				upperName.equals("LOCAL") //$NON-NLS-1$
		) {
			IDeployStatus message = DeployCoreStatusUtil.createObjectAttributeInvalidStatus(object,
					attribute);
			message
					.setUnboundMessage(Db2DomainMessages.Validator_DB2_generic_name_has_restricted_name_0);
			message.setBindings(new String[] { name });
			reporter.addStatus(message);
			return;
		}

		if (name.length() > 8) {
			IDeployStatus message = DeployCoreStatusUtil.createObjectAttributeInvalidStatus(object,
					attribute);
			message
					.setUnboundMessage(Db2DomainMessages.Validator_DB2_generic_name_0_max_length_1_exceeded);
			message.setBindings(new String[] { name, Integer.toString(8) });
			reporter.addStatus(message);
			return;
		}

	}

	/**
	 * Validate DB2 Name and Alias fields on a DB2 database capability
	 * 
	 * @param database
	 * @param reporter
	 */
	public static void validateDBNameAndDBAlias(DB2Database database, IDeployReporter reporter) {
		if (database != null) {
			if (database.getDbName() == null || database.getDbName().length() == 0) {
				reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(database,
						Db2Package.eINSTANCE.getDB2Database_DbName()));
			} else {
				DB2ValidatorUtils.validateDB2GenericName(database.getDbName(), database,
						Db2Package.eINSTANCE.getDB2Database_DbName(), reporter);
			}

			if (database.getDbAlias() == null || database.getDbAlias().length() == 0) {
				// OK ???
			} else {
				DB2ValidatorUtils.validateDB2GenericName(database.getDbAlias(), database,
						Db2Package.eINSTANCE.getDB2Database_DbAlias(), reporter);
			}
		} else {
			// should never get here.
		}
	}

	/**
	 * Returns the first requirement of the specified type, null if none exists.
	 * 
	 * @param reqlist
	 *           a list of Requirements (List<Requirement>)
	 * @param type
	 *           the type of a requirement.
	 * @return the first requirement that is a subtype of the type.
	 */
	protected static Requirement getFirstRequirementOfType(List<Requirement> reqList, EClass type) {
		for (Requirement requirement : reqList) {
			if (type.isSuperTypeOf(requirement.getDmoEType())) {
				return requirement;
			}
		}

		return null;
	}

	/**
	 * Find available users on the hosting operating system. For each available user, gather up
	 * userid/password information and hostname of operating system. User must be member of (a)
	 * Windows: Administrators, or DB2ADMNS if DB2 8.2. or later. (b) Unix equivalent If usergroups
	 * are not supplied by TPM as part of the operating system model, then punt. Assume db2admin is a
	 * admin user.
	 * 
	 * @param unit
	 *           The unit (which should be a DB2InstanceUnit or subtype) which owns the user
	 *           requirement
	 * @param os
	 *           Operating system which eventually hosts the unit
	 * @return List of structures of 3 attributes (userid/password/hostname) plus one UserUnit to
	 *         link to
	 */
	public static List<UseridPasswordHostnameUser> useridPasswordHostnameFixesAvailable(Unit unit,
			OperatingSystem os) {
		List<UseridPasswordHostnameUser> retval = new LinkedList<UseridPasswordHostnameUser>();
		if (os == null || os.getHostname() == null || unit == null) {
			return retval;
		}
		Topology top = unit.getEditTopology();
		Requirement userReq = DB2ValidatorUtils.getFirstRequirementOfType(unit
				.getOnlyDependencyRequirements(), OsPackage.eINSTANCE.getUser());
		if (userReq == null) {
			return retval;
		}

		if (ValidatorUtils.discoverDependencyLinkTarget(userReq, null) != null) {
			return retval;
		}
		UnitDescriptor userUnitUD = TopologyDiscovererService.INSTANCE.findTarget(unit, userReq, top);
		if (userUnitUD != null) {
			return retval;
		}
		if (!(os.getParent() instanceof OperatingSystemUnit)) {
			return retval;
		}

		//
		// For parameter operating system, find each hosted UserUnit.
		// If User exposed by UserUnit has userid/password both set, add to list.
		//
		OperatingSystemUnit osu = (OperatingSystemUnit) os.getParent();

		UnitDescriptor osUD = new TopologyUnitDescriptor(osu, top, null);
		// MK 7/19/2007 cf. defect 2640; added second condition
		if (osUD == null || osUD.getUnitValue() == null) {
			return retval;
		}
		List<UnitDescriptor> osuHostedUnitDescriptors = TopologyDiscovererService.INSTANCE
				.findHosted(osu, top);
		for (Iterator<UnitDescriptor> iter = osuHostedUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor ud = iter.next();
			Unit tmpu = ud.getUnitValue();
			if (!(tmpu instanceof UserUnit)) {
				continue;
			}
			UserUnit uu = (UserUnit) tmpu;
			if (uu == null) {
				continue;
			}
			User user = (User) ValidatorUtils.getCapability(uu, OsPackage.Literals.USER);
			if (user == null) {
				continue;
			}
			if (user.getUserId() == null || user.getUserPassword() == null) {
				continue;
			}

			if (userIsInstanceAdminUser(uu, top, true, true)) {
				UseridPasswordHostnameUser uphu = new UseridPasswordHostnameUser(user.getUserId(), user
						.getUserPassword(), os.getHostname(), user, ud, userReq, osUD);
				retval.add(uphu);
			}
		}

		return retval;
	}

	/**
	 * Return true if operating system is in DB2 instances hosting stack, but no available users
	 * qualify as a db2 instance admin user User must be member of (a) Windows: Administrators, or
	 * DB2ADMNS if DB2 8.2. or later. (b) Unix equivalent If usergroups are not supplied by TPM as
	 * part of the operating system model, then punt. Assume db2admin is safe - return false, and
	 * otherwise, if user is in no groups, return true. Option administratorAcceptableOnDB282
	 * disables allowing Adminstrator on db2 8.2, so that we offer a resolution when hosted on
	 * default windows.
	 * 
	 * @param unit
	 *           The unit (which must be a DB2InstanceUnit or subtype) which owns the user
	 *           requirement
	 * @param os
	 *           Operating system which eventually hosts the unit
	 * @param administratorAcceptableOnDB282
	 *           If set, return false if the only available adminstrator is in the Adminstrators
	 *           group and DB2 version 8.2+
	 * @return true if it would be reasonable to add a instance admin user
	 */
	public static boolean hostingOSNoDB2InstanceAdminUser(Unit unit, OperatingSystem os,
			boolean administratorAcceptableOnDB282) {
		if (os == null) {
			return false;
		}
		assert unit instanceof DB2InstanceUnit;
		Topology top = unit.getEditTopology();

		DB2Instance db2Instance = (DB2Instance) ValidatorUtils.getFirstCapability(unit,
				Db2Package.eINSTANCE.getDB2Instance());
		if (db2Instance == null) {
			return false;
		}

		Requirement userReq = DB2ValidatorUtils.getFirstRequirementOfType(unit
				.getOnlyDependencyRequirements(), OsPackage.eINSTANCE.getUser());
		if (userReq == null) {
			return false;
		}

		UnitDescriptor userUnitUD = TopologyDiscovererService.INSTANCE.findTarget(unit, userReq, top);
		if (userUnitUD != null) {
			return false;
		}
		if (!(os.getParent() instanceof OperatingSystemUnit)) {
			return false;
		}

		OperatingSystemUnit osu = (OperatingSystemUnit) os.getParent();

		UnitDescriptor osUD = new TopologyUnitDescriptor(osu, top, null);
		// MK 7/19/2007 cf. defect 2640; added second condition
		if (osUD == null || osUD.getUnitValue() == null) {
			return false;
		}
		List<UnitDescriptor> osuHostedUnitDescriptors = TopologyDiscovererService.INSTANCE
				.findHosted(osu, top);
		boolean foundInstanceAdminUser = false;
		for (Iterator<UnitDescriptor> iter = osuHostedUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor ud = iter.next();
			Unit tmpu = ud.getUnitValue();
			if (!(tmpu instanceof UserUnit)) {
				continue;
			}
			UserUnit uu = (UserUnit) tmpu;
			if (uu == null) {
				continue;
			}
			if (os.getOsType() != null) {
				if (os.getOsType().equals(OperatingSystemType.WINDOWS_LITERAL.getLiteral())
						|| os.getOsType().equals(OperatingSystemType.WINDOWS_CYGWIN_LITERAL.getLiteral())) {
					// Here we want to offer to create a instance admin user if db2 8.2+ and option is set
					Version v = new Version();
					String db2Version = db2Instance.getDb2Version();
					if (db2Version != null && v.interpString("8.2+", db2Version)) { //$NON-NLS-1$
						if (userIsInstanceAdminUser(uu, top, true, administratorAcceptableOnDB282)) {
							foundInstanceAdminUser = true;
						}
					} else
					// Version not identifiably 8.2+
					if (userIsInstanceAdminUser(uu, top, true, true)) {
						foundInstanceAdminUser = true;
					}
				} else if (os.getOsType().equals(OperatingSystemType.LINUX_LITERAL.getLiteral())) {
					if (userIsInstanceAdminUser(uu, top, true, true)) {
						foundInstanceAdminUser = true;
					}
				} else if (os.getOsType().equals(OperatingSystemType.AIX_LITERAL.getLiteral())) {
					if (userIsInstanceAdminUser(uu, top, true, true)) {
						foundInstanceAdminUser = true;
					}
				}
			}
		}

		// return true if there is an operating system but no qualifying instance admin user.
		return !foundInstanceAdminUser;
	}

	/**
	 * @param uu
	 *           User Unit to check
	 * @param topology
	 *           Topology to check in
	 * @param ungroupedUserAcceptable
	 *           Set to true if a simple ungrouped user is acceptable.
	 * @param administratorAcceptable
	 *           Set to true if administrator is acceptable DB2 admin user on Windows
	 * @return true if user is a plausible DB2 Instance Admin user.
	 */
	public static boolean userIsInstanceAdminUser(UserUnit uu, Topology topology,
			boolean ungroupedUserAcceptable, boolean administratorAcceptable) {
		User user = (User) ValidatorUtils.getCapability(uu, OsPackage.Literals.USER);
		if (user == null) {
			return false;
		}
		if (ungroupedUserAcceptable) {
			// This check is too strong for the DP beta.
			// "root" won't work for Linux (Unix) db2 installs so don't allow it.
//			// Loose check - "db2admin" (windows) or "db2inst*" (unix) qualifies even if not a member of a group, 
//			to accomodate partial modeling.
//			if (user.getUserId() != null) {
//				String uid = user.getUserId();
//				if (isWindowsUser(uu)) {
//					if (uid.equalsIgnoreCase(DB2ADMIN)) {
//						return true;
//					}
//				}
//				if (isUnixUser(uu)) {
//					if (uid.toUpperCase().startsWith(DB2INST.toUpperCase())) {
//						return true;
//					}
//				}
//			}
			if (uu.getTopology() != null) {
				if (uu.getTopology().findMemberOf(uu).length == 0) {
					if (!((uu instanceof LinuxLocalUserUnit || uu instanceof AIXLocalUserUnit)
							&& user.getUserId() != null && user.getUserId().equals("root"))) { //$NON-NLS-1$
						return true;
					}
				}
			}
		}

		List<Requirement> userGroupReqsList = ValidatorUtils.findRequirements(uu, OsPackage.eINSTANCE
				.getUserGroupUnit(), RequirementLinkTypes.MEMBER_LITERAL);
		if (userGroupReqsList.size() == 0) {
			return false;
		}
		boolean foundGroupCardinalityConstraint = false;
		Requirement req0 = userGroupReqsList.get(0);
		for (Constraint c : (List<Constraint>) req0.getConstraints()) {
			if (ConstraintPackage.eINSTANCE.getGroupCardinalityConstraint().isSuperTypeOf(c.eClass())) {
				foundGroupCardinalityConstraint = true;
			}
		}

		// Is this test safe and necessary? It is a reasonable early-out before doing discovery, but assumes user units will have constraints.
		if (!foundGroupCardinalityConstraint) {
			return false;
		}
		List<UnitDescriptor> uuGroupsList = TopologyDiscovererService.INSTANCE.getGroups(uu, req0,
				topology);
		for (Iterator<UnitDescriptor> uuGroupsUDIter = uuGroupsList.iterator(); uuGroupsUDIter
				.hasNext();) {
			UnitDescriptor uuUD = uuGroupsUDIter.next();
			if (uuUD == null) {
				continue;
			}
			UserGroupUnit userGroupUnit = (UserGroupUnit) uuUD.getUnitValue();
			if (userGroupUnit == null) {
				continue;
			}
			UserGroup userGroup = (UserGroup) ValidatorUtils.getCapability(userGroupUnit,
					OsPackage.eINSTANCE.getUserGroup());
			if (userGroup == null || userGroup.getGroupName() == null) {
				continue;
			}
			if (userGroup instanceof WindowsLocalGroup) {
				if (userGroup.getGroupName().equalsIgnoreCase(DB2ADMNS)) {
					return true;
				}
				if (administratorAcceptable
						&& userGroup.getGroupName().equalsIgnoreCase(
								DefaultWindowsUserGroups.ADMINISTRATORS_LITERAL.toString())) {
					return true;
				}
			} else if (userGroup instanceof LinuxLocalGroup || userGroup instanceof AIXLocalGroup) {
				if (userGroup.getGroupName().startsWith(DB2IADM)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isUnixUser(UserUnit uu) {
		if (uu instanceof WindowsLocalUserUnit) {
			return true;
		}
		User u = (User) ValidatorUtils.getCapability(uu, OsPackage.eINSTANCE.getUser());
		if (u != null) {
			if (u instanceof LinuxLocalUser) {
				return true;
			}
			if (u instanceof AIXLocalUser) {
				return true;
			}
		}
		Unit uuHost = ValidatorUtils.getHost(uu);
		if (uuHost != null && uuHost instanceof OperatingSystemUnit) {
			if (uuHost instanceof LinuxOperatingSystemUnit || uuHost instanceof AIXOperatingSystemUnit) {
				return true;
			}
			OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getCapability(uuHost,
					OsPackage.eINSTANCE.getOperatingSystem());
			if (osCap != null) {
				if (osCap instanceof LinuxOperatingSystem || osCap instanceof AIXOperatingSystem) {
					return true;
				}
				if (osCap.getOsType() != null) {
					if (osCap.getOsType().equalsIgnoreCase("linux") || osCap.getOsType().equalsIgnoreCase("aix")) { //$NON-NLS-1$ //$NON-NLS-2$
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean isWindowsUser(UserUnit uu) {
		if (uu instanceof WindowsLocalUserUnit) {
			return true;
		}
		if (ValidatorUtils.getCapability(uu, OsPackage.eINSTANCE.getWindowsLocalUser()) != null) {
			return true;
		}
		Unit uuHost = ValidatorUtils.getHost(uu);
		if (uuHost != null) {
			if (uuHost instanceof WindowsOperatingSystemUnit) {
				return true;
			}
			OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getCapability(uuHost,
					OsPackage.eINSTANCE.getOperatingSystem());
			if (osCap != null) {
				if (osCap instanceof WindowsOperatingSystem) {
					return true;
				}
				if (osCap.getOsType() != null && osCap.getOsType().equalsIgnoreCase("windows")) { //$NON-NLS-1$
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * see {@link #useridPasswordHostnameFixesAvailable(Unit, OperatingSystem)}
	 * 
	 * @param unit
	 * @return list of UseridPasswordHostnameUser
	 */
	public static List<UseridPasswordHostnameUser> useridPasswordHostnameFixesAvailable(Unit unit) {
		OperatingSystem os = (OperatingSystem) DeployValidatorUtils
				.findProvidedCapabilityInHostingStack(OsPackage.eINSTANCE.getOperatingSystem(), unit);
		return useridPasswordHostnameFixesAvailable(unit, os);
	}

	/**
	 * Note: unique userids assumed on a hosting operating system.
	 * 
	 * @param unit
	 * @return map of userid strings to User capabilities on the hosting operating system.
	 */
	public static Map<String, Capability> getUsersOnHostingOS(Unit unit) {
		Map<String, Capability> hmUsers = new HashMap<String, Capability>();
		OperatingSystemUnit hostingOS = (OperatingSystemUnit) ValidatorUtils.discoverHostInStack(
				unit, OsPackage.eINSTANCE.getOperatingSystemUnit(), null);
		if (hostingOS != null) {
			List<UnitDescriptor> hostedByOSUDs = TopologyDiscovererService.INSTANCE.findHosted(
					hostingOS, unit.getTopology());
			for (Iterator<UnitDescriptor> hostedByOSUDsIter = hostedByOSUDs.iterator(); hostedByOSUDsIter
					.hasNext();) {
				UnitDescriptor hostedByOSUD = hostedByOSUDsIter.next();
				if (hostedByOSUD != null) {
					Unit hostedUnit = hostedByOSUD.getUnitValue();
					if (hostedUnit != null && hostedUnit instanceof UserUnit) {
						User u = (User) ValidatorUtils.getFirstCapability(hostedUnit, OsPackage.eINSTANCE
								.getUser());
						if (u != null) {
							if (u.getUserId() != null) {
								hmUsers.put(u.getUserId(), u);
							}
						}
					}
				}
			}
		}
		return hmUsers;
	}

	public final static String WAS_VARIABLE_PREFIX = "${"; //$NON-NLS-1$	

	/**
	 * Static syntactical classPath validator. A classpath in this context is a WAS classPath, which
	 * uses line separators rather than typical classpath separators, and can include substitution
	 * variables.
	 * 
	 * @param classPath
	 * @param osType
	 * @return false if path found to be invalid, true otherwise
	 */
	public static boolean wasClassPathValid(String classPath, String osType) {

		if (classPath == null) {
			return false;
		}

		String classPathParts[] = classPath.split(newline);
		for (int i = 0; i < classPathParts.length; ++i) {

			String cpp = classPathParts[i];
			if (cpp == null || cpp.trim().length() <= 0) {
				return false;
			}

			String classPathPartParts[] = cpp.split(SecondaryCpSeparator);
			for (int j = 0; j < classPathPartParts.length; ++j) {
				String classPathPart = classPathPartParts[j];
				if (classPathPart == null || classPathPart.trim().length() <= 0) {
					return false;
				}

				if (!classPathPart.endsWith(".jar") && !classPathPart.endsWith(".zip") && !classPathPart.endsWith(".dll") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						&& !classPathPart.endsWith(".so") && !classPathPart.endsWith(".lib")) {//$NON-NLS-1$ //$NON-NLS-2$
					return false;
				}
				// TODO is starting with "." legal? 
				if (!(classPathPart.indexOf(WAS_VARIABLE_PREFIX) == 0 || classPathPart.startsWith("."))) { //$NON-NLS-1$
					if (OsValidatorUtils.isUnixOsType(osType)) {
						if (!OsValidatorUtils.isValidRootedUnixPath(classPathPart, true)) {
							return false;
						}
					} else if (OsValidatorUtils.isWindowsOsType(osType)) {
						if (!OsValidatorUtils
								.isValidWindowsPathWithDriveLetter(classPathPart, true, true)) {
							return false;
						}
					} else {
						// OS unknown
						if (!(OsValidatorUtils.isValidWindowsPathWithDriveLetter(classPathPart, true,
								true) || OsValidatorUtils.isValidRootedUnixPath(classPathPart, true))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
