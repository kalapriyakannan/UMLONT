/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.util.Proxy;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.internal.parser.DeployTypeParser;
import com.ibm.ccl.soa.deploy.core.ui.internal.parser.NameParser;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * Provides a {@link NameParser} or {@link DeployTypeParser} for SOA Deploy objects.
 * 
 * @since 1.0
 */
public class DeployCoreParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @see com.ibm.xtools.common.ui.services.parser.IParserProvider#getParser(org.eclipse.core.runtime.IAdaptable)
	 */
	public IParser getParser(IAdaptable hint) {
		String stringHint = (String) hint.getAdapter(String.class);
		if (stringHint == null || stringHint.equals(DeployCoreConstants.DEPLOY_NAME)) {
			return NameParser.getInstance();
		}
		if (stringHint.equals(DeployCoreConstants.DEPLOY_TYPE)) {
			return DeployTypeParser.getInstance();
		}
		return null;
	}

	/**
	 * @see com.ibm.xtools.common.core.service.IProvider#provides(com.ibm.xtools.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();

			String stringHint = (String) hint.getAdapter(String.class);
			if (stringHint == null) {
				// This handles the special case for the Outline View, which receives UnitOutlineEditParts
				// instead of graphical GMF objects
				if (hint instanceof Proxy) {
					Proxy proxy = (Proxy) hint;
					return proxy.getRealObject() instanceof Unit;
				}

				return false;
			}

			EObject elementHint = (EObject) hint.getAdapter(EObject.class);
			if (elementHint instanceof DeployModelObject) {
				if (DeployCoreConstants.DEPLOY_NAME.equals(stringHint)) {
					return true;
				} else if (DeployCoreConstants.DEPLOY_TYPE.equals(stringHint)) {
					return true;
				}
			}
		}
		return false;
	}
}
