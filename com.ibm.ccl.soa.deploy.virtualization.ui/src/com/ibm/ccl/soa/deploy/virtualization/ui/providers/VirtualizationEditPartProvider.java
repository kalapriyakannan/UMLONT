/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.virtualization.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VMwareESXUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VMwareVirtualDiskDefUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VMwareVirtualDiskSnapshotUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VMwareVirtualEthernetNICDefUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VMwareVirtualImageUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VMwareVirtualServerSnapshotUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VirtualDiskDefUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VirtualEthernetNICDefUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VirtualImageCollectionUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.VirtualImageUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.XenVirtualDiskDefUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.XenVirtualEthernetNICDefUnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.editparts.XenVirtualImageUnitEditPart;


/**
 * Deploy tool Edit Part provider for Virtualization domain.
 * 
 */
public class VirtualizationEditPartProvider extends AbstractEditPartProvider {

	/** list of supported shape editparts. */
	private Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();
	{
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVirtualImageUnit(), VirtualImageUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVirtualEthernetNICDefUnit(), VirtualEthernetNICDefUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVirtualDiskDefUnit(), VirtualDiskDefUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVMwareVirtualImageUnit(), VMwareVirtualImageUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVMwareVirtualEthernetNICDefUnit(), VMwareVirtualEthernetNICDefUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVMwareVirtualDiskDefUnit(), VMwareVirtualDiskDefUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getXenVirtualImageUnit(), XenVirtualImageUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getXenVirtualEthernetNICDefUnit(), XenVirtualEthernetNICDefUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getXenVirtualDiskDefUnit(), XenVirtualDiskDefUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVMwareVirtualServerSnapshotUnit(), VMwareVirtualServerSnapshotUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVMwareVirtualDiskSnapshotUnit(), VMwareVirtualDiskSnapshotUnitEditPart.class);
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVirtualImageCollectionUnit(), VirtualImageCollectionUnitEditPart.class);
		
		nodeMap.put(VirtualizationPackage.eINSTANCE.getVMwareESXUnit(), VMwareESXUnitEditPart.class);		
	}

	/**
	 * Gets a Node's editpart class.
	 */
	@Override
	protected Class<?> getNodeEditPartClass(View view) {
		Class<?> clazz = null;
		EClass eClass = getReferencedElementEClass(view);
		if (eClass != null) {
			clazz = ((Class<?>) nodeMap.get(eClass));
		}

		return clazz;
	}
}
