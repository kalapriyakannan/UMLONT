/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.os.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.ui.editparts.DirectoryUnitEditPart;
import com.ibm.ccl.soa.deploy.os.ui.editparts.FileSystemUnitEditPart;
import com.ibm.ccl.soa.deploy.os.ui.editparts.OsModuleEditPart;
import com.ibm.ccl.soa.deploy.os.ui.editparts.PortConfigUnitEditPart;
import com.ibm.ccl.soa.deploy.os.ui.editparts.UserGroupUnitEditPart;
import com.ibm.ccl.soa.deploy.os.ui.editparts.UserUnitEditPart;

/**
 * Deploy tool Edit Part provider for OS domain.
 * 
 * @author jschofie
 * @author Ed Snible
 * @author Bill Arnold
 */
public class OsEditPartProvider extends AbstractEditPartProvider {

//	// Map to hold the Shape Views
//	private Map nodeHintMap = new HashMap();
//	{
//		nodeHintMap.put( OsConstants.MODULE_OS_SEMANTICHINT, OsModuleEditPart.class);
//		nodeHintMap.put( OsConstants.CONFIGURATION_USER_SEMANTICHINT, UserUnitEditPart.class);
//		nodeHintMap.put( OsConstants.UNIT_GROUP_USER_GROUP_SEMANTICHINT, UserGroupUnitEditPart.class);		
//		nodeHintMap.put( OsConstants.CONFIGURATION_PORT_SEMANTICHINT, PortConfigUnitEditPart.class);				
//	}

	/** list of supported shape editparts. */
	private final Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();
	{
		nodeMap.put(OsPackage.eINSTANCE.getOperatingSystemUnit(), OsModuleEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getWindowsOperatingSystemUnit(), OsModuleEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getLinuxOperatingSystemUnit(), OsModuleEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getAIXOperatingSystemUnit(), OsModuleEditPart.class);

		nodeMap.put(OsPackage.eINSTANCE.getUserUnit(), UserUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getWindowsLocalUserUnit(), UserUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getLinuxLocalUserUnit(), UserUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getAIXLocalUserUnit(), UserUnitEditPart.class);

		nodeMap.put(OsPackage.eINSTANCE.getUserGroupUnit(), UserGroupUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getWindowsLocalGroupUnit(), UserGroupUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getLinuxLocalGroupUnit(), UserGroupUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getAIXLocalGroupUnit(), UserGroupUnitEditPart.class);

		nodeMap.put(OsPackage.eINSTANCE.getPortConfigUnit(), PortConfigUnitEditPart.class);

		nodeMap.put(OsPackage.eINSTANCE.getFileSystemUnit(), FileSystemUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getLocalFileSystemUnit(), FileSystemUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getNFSFileSystemUnit(), FileSystemUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getOpenVmsFileSystemUnit(), FileSystemUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getRemoteFileSystemUnit(), FileSystemUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getSMBFileSystemUnit(), FileSystemUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getSolarisFileSystemUnit(), FileSystemUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getUnixFileSystemUnit(), FileSystemUnitEditPart.class);
		nodeMap.put(OsPackage.eINSTANCE.getWindowsFileSystemUnit(), FileSystemUnitEditPart.class);

		nodeMap.put(OsPackage.eINSTANCE.getDirectoryUnit(), DirectoryUnitEditPart.class);
	}

	/**
	 * Gets a Node's editpart class.
	 * 
	 * <p>
	 * NOTE: Previously this code used the semantic hint, but I notice that when the IHS domain
	 * provides a PortConfigUnit as the second unit in a .template for IHS Server the semantic hint
	 * is 'module.ihs'. GMF correctly figures out that this provider makes PortConfigUnitEditPart,
	 * and passes the unit here, but unfortunately with a semantic hint of 'module.ihs'. The old
	 * <code>nodeHintMap</code> didn't know about this hint so gave up without checking nodeMap.
	 */
	@Override
	protected Class<?> getNodeEditPartClass(View view) {
//		String semanticHint = view.getType();

		Class<?> clazz = null;
//		if ((semanticHint != null) &&	(semanticHint.length() > 0)) {
//			clazz = (Class)nodeHintMap.get(semanticHint);
//		} else {		
		EClass eClass = getReferencedElementEClass(view);
		if (eClass != null) {
			clazz = nodeMap.get(eClass);
		}
//		}

		return clazz;
	}
}
