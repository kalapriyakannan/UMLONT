/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.internal.provider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.DDLInterface;
import com.ibm.ccl.soa.deploy.database.DatabaseComponent;
import com.ibm.ccl.soa.deploy.database.DatabaseDefinition;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.SQLUser;

public class DatabaseProviderUtil {

	final static String DDL_FILE_EXTENSION = "ddl"; //$NON-NLS-1$

	final static String SQL_FILE_EXTENSION = "sql"; //$NON-NLS-1$

	private DatabaseProviderUtil() {
		super();
	}

	public static IFolder getFolderOfPath(IPath fullLocalIPath) {
		final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		final IFolder folder = workspace.getFolder(fullLocalIPath);
		return folder;
	}

	public static IFile getFileOfPath(IPath fullLocalIPath) {
		final IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		final IFile file = workspace.getFile(fullLocalIPath);
		return file;
	}

	public static boolean isDDLFile(IResource resource) {
		String extension = resource.getFileExtension();
		return resource.getType() == IResource.FILE
				&& (extension.equals(DDL_FILE_EXTENSION) || extension.equals(SQL_FILE_EXTENSION));

	}

	public static boolean isDDLFile(Object obj) {
		if (obj instanceof IResource) {
			return isDDLFile((IResource) obj);
		}
		return false;
	}

	/**
	 * Create a SqlUserCapability on the database unit
	 * 
	 * @param unit
	 *           the unit to be used
	 * @return the SqlUser capability that is created
	 */
	public static SQLUser createSqlUserCapability(Unit unit) {
		// Add SQLUser capability - userId/userPassword attributes left null
		SQLUser sqlUser = DatabaseFactory.eINSTANCE.createSQLUser();
		sqlUser.setName("SQLUser"); //$NON-NLS-1$
		sqlUser.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);

		AttributeMetaData sqlUserPwdMetatData = CoreFactory.eINSTANCE.createAttributeMetaData();
		sqlUserPwdMetatData.setAttributeName(DatabasePackage.eINSTANCE.getSQLUser_UserPassword()
				.getName());
		sqlUserPwdMetatData.setEncrypted(true);
		sqlUser.getAttributeMetaData().add(sqlUserPwdMetatData);

		unit.getCapabilities().add(sqlUser);
		return sqlUser;

	}

	/**
	 * Create a database hosting requirement
	 * 
	 * @param unit
	 *           the unit to be used
	 * @return the requirement created
	 */
	public static Requirement createDatabaseHostingRequirement(Unit unit) {
		// Add requirement for database capability to module
		Requirement requiredDBHosting = CoreFactory.eINSTANCE.createRequirement();
		requiredDBHosting.setName("Required Database Hosting"); //$NON-NLS-1$
		requiredDBHosting.setDmoEType(DatabasePackage.Literals.DATABASE);
		requiredDBHosting.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		unit.getRequirements().add(requiredDBHosting);
		return requiredDBHosting;
	}

	/**
	 * Create or update the DDLArtifact for the database component
	 * 
	 * @param component
	 *           the database component to be used
	 * @param databaseDefinition
	 *           the database definition to extract the schema uri from
	 * @return
	 */
	public static DDLArtifact createOrUpdateDDLArtifact(DatabaseComponent component,
			DatabaseDefinition databaseDefinition) {
		DDLInterface ddlInterface = (DDLInterface) databaseDefinition.getInterface();
		List fileArtifacts = component.getArtifacts();
		DDLArtifact fileArtifact = null;
		if (fileArtifacts.size() > 0) {
			fileArtifact = (DDLArtifact) fileArtifacts.get(0);
		} else {
			fileArtifact = DatabaseFactory.eINSTANCE.createDDLArtifact();
			fileArtifacts.add(fileArtifact);
			fileArtifact.setDisplayName(component.getDisplayName());
			fileArtifact.setName(UnitUtil.fixNameForID(fileArtifact.getDisplayName()));
		}
		List fileURIs = fileArtifact.getFileURIs();
		fileURIs.add(ddlInterface.getSchemaUri());
		return fileArtifact;
	}

	/**
	 * Get the first database definition service for the component
	 * 
	 * @param component
	 *           the database component
	 * @return the DatabaseDefinition service with the DDL interface
	 */
	public static DatabaseDefinition getDatabaseDefinition(DatabaseComponent component) {
		List capabilities = component.getDependencyOrAnyCapabilities();
		for (Iterator iter = capabilities.iterator(); iter.hasNext();) {
			Capability cap = (Capability) iter.next();
			if (cap instanceof DatabaseDefinition) {
				return (DatabaseDefinition) cap;
			}
		}
		return null;
	}

	/**
	 * Get the database definition service list for the component
	 * 
	 * @param component
	 *           the database component
	 * @return the DatabaseDefinition service list with the DDL interface
	 */
	public static List getDatabaseDefinitions(DatabaseComponent component) {
		List result = new ArrayList();
		List capabilities = component.getDependencyOrAnyCapabilities();
		for (Iterator iter = capabilities.iterator(); iter.hasNext();) {
			Capability cap = (Capability) iter.next();
			if (cap instanceof DatabaseDefinition) {
				result.add(cap);
			}
		}
		return result;
	}

	/**
	 * Create a database definition along with the interface for the DDL resource. Set the
	 * interface's schema uri with the ddl resource.
	 * 
	 * @param component
	 *           the database component
	 * @param Resource
	 *           the database schema resource for which this service is defined
	 * @return the DatabaseDefinition service with the DDL interface
	 */
	public static DatabaseDefinition createDatabaseDefinition(DatabaseComponent component,
			IResource ddlResource) {
		DatabaseDefinition databaseDefinition = DatabaseFactory.eINSTANCE.createDatabaseDefinition();
		databaseDefinition.setName(generateUniqueName(component, ddlResource.getName()));
		databaseDefinition.setDisplayName(ddlResource.getName());
		component.getCapabilities().add(databaseDefinition);
		DDLInterface ddlInterface = DatabaseFactory.eINSTANCE.createDDLInterface();
		databaseDefinition.setInterface(ddlInterface);
		ddlInterface.setSchemaUri(ddlResource.getFullPath().toPortableString());
		return databaseDefinition;
	}

	/**
	 * Generates a unique name for a {@link DeployModelObject}. The 'name' field on a
	 * DeployModelObject must be unique among its siblings.
	 * 
	 * <p>
	 * NOTE: Although this method is in UnitUtil it's safe to call for any DeployModelObject.
	 * 
	 * @param parent
	 * @param prefix
	 * @return a String this is unique among the direct children of 'dmo' and can be safely used as
	 *         the 'name' field.
	 */
	public static String generateUniqueName(DeployModelObject parent, String prefix) {

		synchronized (parent) {
			// Collect names of all model objects directly contained by on this dmo
			Set names = new HashSet();
			for (Iterator it = parent.getContainedModelObjects().iterator(); it.hasNext();) {
				DeployModelObject child = (DeployModelObject) it.next();
				names.add(child.getName());
			}

			// Generate a string prefixed by 'prefix' that isn't in 'names'
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				String candidate = prefix;
				if (i > 0) {
					candidate += i;
				}
				if (!names.contains(candidate)) {
					return candidate;
				}
			}
		} // end synchronized

		// If we reach here it means that 'dmo' has more than 2^31 children with 'prefix';
		// this is unlikely.
		throw new IllegalArgumentException();

	} // end method generateUniqueName()

	/**
	 * 
	 * @param addUnit
	 * @param topology
	 */
	public static void makeUnitNameUnique(Unit addUnit, Topology topology) {
		String initialName = addUnit.getName();
		if (initialName == null) {
			initialName = "Unit"; //$NON-NLS-1$
		}
		String name = initialName;
		int i = 0;
		while (topology.resolve(name) != null) {
			name = initialName + i;
			i++;
		}
		if (!name.equals(initialName)) {
			addUnit.setName(name);
			if (addUnit.getCaptionProvider().title(addUnit) == null) {
				addUnit.setDisplayName(name);
			}
		}
	}
}
