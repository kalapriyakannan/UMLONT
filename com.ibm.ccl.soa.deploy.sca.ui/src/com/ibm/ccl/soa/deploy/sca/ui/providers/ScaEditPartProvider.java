/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.sca.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.sca.ScaPackage;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.GenericSCAImplementationUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCABindingUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAComponentUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAImplementationBPELUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAImplementationCompositeUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAImplementationCplusplusUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAImplementationJavaUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAInterfaceUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAOperationUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAPolicyIntentUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAPolicySetUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAPropertyUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAPropertyValueUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAReferenceUnitEditPart;
import com.ibm.ccl.soa.deploy.sca.ui.editparts.SCAServiceUnitEditPart;


/**
 * Deploy tool Edit Part provider for Sca domain.
 * 
 */
public class ScaEditPartProvider extends AbstractEditPartProvider {

	/** list of supported shape editparts. */
	private Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();
	{
		nodeMap.put(ScaPackage.eINSTANCE.getGenericSCAImplementationUnit(), GenericSCAImplementationUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCABindingUnit(), SCABindingUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAComponentUnit(), SCAComponentUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAImplementationBPELUnit(), SCAImplementationBPELUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAImplementationCompositeUnit(), SCAImplementationCompositeUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAImplementationCplusplusUnit(), SCAImplementationCplusplusUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAImplementationJavaUnit(), SCAImplementationJavaUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAInterfaceUnit(), SCAInterfaceUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAOperationUnit(), SCAOperationUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAPolicyIntentUnit(), SCAPolicyIntentUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAPolicySetUnit(), SCAPolicySetUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAPropertyUnit(), SCAPropertyUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAPropertyValueUnit(), SCAPropertyValueUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAReferenceUnit(), SCAReferenceUnitEditPart.class);
		nodeMap.put(ScaPackage.eINSTANCE.getSCAServiceUnit(), SCAServiceUnitEditPart.class);
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
