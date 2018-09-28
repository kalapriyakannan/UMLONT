package com.ibm.ccl.soa.deploy.uml.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;
import com.ibm.ccl.soa.deploy.uml.ui.editparts.UMLActorEditPart;
import com.ibm.ccl.soa.deploy.uml.ui.editparts.UMLComponentEditPart;

public class UMLEditPartProvider extends AbstractEditPartProvider {
	private final Map nodeMap = new HashMap();
	{
		nodeMap.put(CorePackage.eINSTANCE.getSoftwareComponent(), UMLComponentEditPart.class);
		nodeMap.put(UmlPackage.eINSTANCE.getUMLActorUnit(), UMLActorEditPart.class);
	}

	protected Class getNodeEditPartClass(View view) {
		Class clazz = null;
		EClass eClass = getReferencedElementEClass(view);
		if (eClass != null) {
			clazz = (Class) nodeMap.get(eClass);
		}
		return clazz;
	}
}
