/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.Collection;

import org.eclipse.jst.j2ee.common.EJBLocalRef;
import org.eclipse.jst.j2ee.common.EjbRef;
import org.eclipse.jst.j2ee.common.EjbRefType;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JavaInterface;
import com.ibm.ccl.soa.deploy.j2ee.Vicinity;

public class EnterpriseBeanProvider extends J2EEModuleCapabilityProvider {

	protected Reference createEjbReference(EjbRef ref) {
		Reference req = CoreFactory.eINSTANCE.createReference();
		req
				.setDmoEType(ref.getType() == EjbRefType.ENTITY_LITERAL ? J2eePackage.Literals.ENTITY_SERVICE
						: J2eePackage.Literals.SESSION_SERVICE);
		req.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		req.setName(ref.getName().replace('/', '_'));
		req.setDisplayName(req.getName());
		JavaInterface jInterface = J2eeFactory.eINSTANCE.createJavaInterface();
		req.setInterface(jInterface);
		if (ref.isLocal()) {
			jInterface.setInterface(((EJBLocalRef) ref).getLocal());
//			req.getExpressions().add(
//					Equals.createExpression(J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__VICINITY,
//							Vicinity.LOCAL_LITERAL));
			req.getConstraints().add(
					createEqualsConstraint(J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__VICINITY,
							Vicinity.LOCAL_LITERAL.getLiteral()));
		} else {
			jInterface.setInterface(ref.getRemote());
//			req.getExpressions().add(
//					Equals.createExpression(J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__VICINITY,
//							Vicinity.REMOTE_LITERAL));
			req.getConstraints().add(
					createEqualsConstraint(J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__VICINITY,
							Vicinity.REMOTE_LITERAL.getLiteral()));
		}

		String link = ref.getLink();
		if (link != null && link.length() > 0) {
			//For now remove the path segment.
			int i = link.indexOf('#');
			if (i > -1 && i + 1 < link.length()) {
				link = link.substring(i + 1);
			}
//			req.getExpressions()
//					.add(
//							Equals.createExpression(
//									J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__EJB_NAME, link));
			req.getConstraints()
					.add(
							createEqualsConstraint(J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE__EJB_NAME,
									link));
		}

		return req;
	}

	protected Requirement[] toReqArray(Collection reqList) {
		if (reqList == null) {
			return null;
		}
		return (Requirement[]) reqList.toArray(new Requirement[reqList.size()]);

	}
}