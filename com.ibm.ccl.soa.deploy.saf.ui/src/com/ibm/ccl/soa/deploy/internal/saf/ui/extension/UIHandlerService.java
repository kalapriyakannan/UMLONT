/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.ui.extension;

import java.util.HashMap;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.Substitutable;
import com.ibm.ccl.soa.deploy.saf.ui.extension.IUIHandlerService;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;
import com.ibm.ccl.soa.deploy.saf.ui.handler.IUIHandlerDescriptor;

/**
 * Provides a concrete implementation of IInterfaceUIHandlerService.
 * 
 * @since 1.0
 */
public class UIHandlerService implements IUIHandlerService {

	private static final AbstractUIHandler[] NO_ELEMENTS_UIHANDLER = new AbstractUIHandler[0];

	private final Map<UIHandlerDescriptor, AbstractUIHandler> uiHandlers = new HashMap<UIHandlerDescriptor, AbstractUIHandler>();

	private final String type;

	public UIHandlerService(String type) {
		this.type = type;
	}

	public AbstractUIHandler findSubstitutableUIHandlerForKind(String substitutableKind) {
		UIHandlerDescriptor descriptor = SAFUIManager.getInstance().findUIHandlerDescriptorFor(type,
				substitutableKind);
		if (descriptor == null) {
			return null;
		}
		return getUIHandler(descriptor);
	}

	public AbstractUIHandler findUIHandlerForSubstitutable(Substitutable substitutable) {

		UIHandlerDescriptor[] descriptors = findAllUIHandlerDescriptors();
		for (int i = 0; i < descriptors.length; i++) {
			if (descriptors[i].isEnabled(substitutable)) {
				return getUIHandler(descriptors[i]);
			}
		}
		return null;
	}

	public UIHandlerDescriptor[] findAllUIHandlerDescriptors() {
		return SAFUIManager.getInstance().findAllUIHandlerDescriptors(type);
	}

	private AbstractUIHandler getUIHandler(UIHandlerDescriptor aDescriptor) {
		AbstractUIHandler handler = null;
		synchronized (uiHandlers) {
			handler = uiHandlers.get(aDescriptor);
			if (handler == null) {
				uiHandlers.put(aDescriptor, handler = aDescriptor.createUIHandler());
			}
		}
		return handler;
	}

	public IUIHandlerDescriptor findAllUIHandlerDescriptors(String kind) {
		if (kind == null || kind.length() == 0) {
			return null;
		}
		UIHandlerDescriptor[] descriptors = findAllUIHandlerDescriptors();
		for (UIHandlerDescriptor descriptor : descriptors) {
			if (kind.equals(descriptor.getKind())) {
				return descriptor;
			}
		}
		return null;
	}
}
