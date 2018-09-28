/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.db2high.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2BufferPoolUnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2ConstraintUnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2FieldUnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2IndexUnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2ManagerUnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2PartitionGroupUnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2PermissionUnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2TableSpaceUnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2TableUnitEditPart;
import com.ibm.ccl.soa.deploy.db2high.ui.editparts.DB2UserUnitEditPart;


/**
 * Deploy tool Edit Part provider for Db2high domain.
 * 
 */
public class Db2highEditPartProvider extends AbstractEditPartProvider {

	/** list of supported shape editparts. */
	private Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();
	{
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2BufferPoolUnit(), DB2BufferPoolUnitEditPart.class);
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2ConstraintUnit(), DB2ConstraintUnitEditPart.class);
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2FieldUnit(), DB2FieldUnitEditPart.class);
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2IndexUnit(), DB2IndexUnitEditPart.class);
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2ManagerUnit(), DB2ManagerUnitEditPart.class);
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2PartitionGroupUnit(), DB2PartitionGroupUnitEditPart.class);
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2PermissionUnit(), DB2PermissionUnitEditPart.class);
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2TableSpaceUnit(), DB2TableSpaceUnitEditPart.class);
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2TableUnit(), DB2TableUnitEditPart.class);
		nodeMap.put(Db2highPackage.eINSTANCE.getDB2UserUnit(), DB2UserUnitEditPart.class);
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
