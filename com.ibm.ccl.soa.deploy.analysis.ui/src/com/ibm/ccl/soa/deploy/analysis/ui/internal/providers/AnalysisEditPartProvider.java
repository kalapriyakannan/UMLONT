package com.ibm.ccl.soa.deploy.analysis.ui.internal.providers;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.ui.editparts.ComponentUnitEditPart;
import com.ibm.ccl.soa.deploy.analysis.ui.editparts.DeploymentUnitEditPart;
import com.ibm.ccl.soa.deploy.analysis.ui.editparts.LocationUnitEditPart;
import com.ibm.ccl.soa.deploy.analysis.ui.editparts.NodeUnitEditPart;
import com.ibm.ccl.soa.deploy.core.CorePackage;


public class AnalysisEditPartProvider extends AbstractEditPartProvider {
	private Map nodeMap = new HashMap();
	{
		//nodeMap.put(CorePackage.eINSTANCE.getSoftwareComponent(), ComponentUnitEditPart.class);
		nodeMap.put(AnalysisPackage.eINSTANCE.getLocationUnit(), LocationUnitEditPart.class);
		nodeMap.put(AnalysisPackage.eINSTANCE.getNodeUnit(), NodeUnitEditPart.class);
		nodeMap.put(AnalysisPackage.eINSTANCE.getDeploymentUnit(), DeploymentUnitEditPart.class);
	}

	protected Class getNodeEditPartClass(View view) {
		Class clazz = null;
		EClass eClass = getReferencedElementEClass(view);
		if (eClass != null) {
			clazz = ((Class) nodeMap.get(eClass));
		}
		return clazz;
	}

}
