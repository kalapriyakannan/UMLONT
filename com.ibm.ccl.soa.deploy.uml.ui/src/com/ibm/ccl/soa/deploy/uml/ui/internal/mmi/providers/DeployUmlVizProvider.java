package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.providers;

import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.xtools.mmi.ui.services.GetUIHandlerOperation;
import com.ibm.xtools.mmi.ui.services.IMMIUIHandler;
import com.ibm.xtools.mmi.ui.services.IMMIUIProvider;
import com.ibm.xtools.mmi.ui.services.IStructuredReferenceOpenHandler;
import com.ibm.xtools.mmi.ui.util.IUIContext;

public class DeployUmlVizProvider extends AbstractProvider implements
		IMMIUIProvider {

	public IStructuredReferenceOpenHandler getStructuredReferenceOpenHandler(
			String providerId) {
		return null;
	}

	public IMMIUIHandler getUIHandler(Object uiObject, IUIContext uiContext) {
		return DeployUmlVizUIHandler.getInstance();
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof GetUIHandlerOperation) {
			GetUIHandlerOperation vizUIOp = (GetUIHandlerOperation) operation;
			Object uiObject = vizUIOp.getUIObject();
			return (uiObject instanceof Unit);}
		return false;
				
	}

}
