package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.providers;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.xtools.mmi.ui.services.IMMIUIHandler;
import com.ibm.xtools.mmi.ui.util.IUIContext;

public class DeployUmlVizUIHandler implements IMMIUIHandler {
	private static DeployUmlVizUIHandler instance = null;

	public IPath getDefaultDiagramPath(Object uiObject, IUIContext uiContext) {
		return null;
	}

	public List getSourceElements(Object referencedContext, Object uiObject, IUIContext uiContext) {
		if (uiObject instanceof Unit) {
			return Collections.singletonList(uiObject);
		}
		return null;
	}

	public EClass getTargetEClass(Object referencedContext, Object source, IUIContext uiContext) {
		if (source instanceof UMLActorUnit) {
			return UMLPackage.eINSTANCE.getActor();
		}
		// mmk
		if (source instanceof NodeUnit) {
			return UMLPackage.eINSTANCE.getNode();
		}
		if (source instanceof Unit) {
			return UMLPackage.eINSTANCE.getComponent();
		}
		return null;
	}

	public static IMMIUIHandler getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new DeployUmlVizUIHandler();
		}
		return instance;
	}

}
