package com.ibm.ccl.soa.deploy.core.ui.internal.search.util;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.internal.content.ContentTypeManager;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;

import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match;

public class MatchReferencerPropertyTester extends PropertyTester {

	private static final String REFERENCER_CONTENT_TYPE = "referencerContentType"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		Object adapted = adapt(receiver, Match.class);
		if (null != adapted) {
			Match match = (Match) adapted;
			URI referencer = match.getReferencing();
			if (REFERENCER_CONTENT_TYPE.equalsIgnoreCase(property)) {
				IContentType type = ContentTypeManager.getInstance().findContentTypeFor(
						referencer.lastSegment());
				if (null != type && type.getId().equalsIgnoreCase(expectedValue.toString())) {
					return true;
				}
			}
		}

		return false;
	}
	
	private Object adapt(Object adaptable, Class adapter) {
		if (null == adaptable) {
			return null;
		}
		Object adapted = null;
		if (adaptable instanceof IAdaptable) {
			adapted = ((IAdaptable) adaptable).getAdapter(adapter);
		}
		if (null == adapted) {
			adapted = Platform.getAdapterManager().getAdapter(adaptable, adapter);
		}
		return adapted;
	}

}
