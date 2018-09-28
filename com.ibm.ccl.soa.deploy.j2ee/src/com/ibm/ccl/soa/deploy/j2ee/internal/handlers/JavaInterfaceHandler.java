/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.handlers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchScope;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.JavaInterface;
import com.ibm.ccl.soa.deploy.j2ee.internal.handlers.util.TypeInfo;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;

/**
 * 
 */
public class JavaInterfaceHandler extends AbstractInterfaceHandler {

	/*
	 * create a computed interface property label
	 * 
	 * @see com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler#getInterfacePropertyLabel(com.ibm.ccl.soa.deploy.core.Interface)
	 */
	public String getInterfacePropertyLabel(Interface interfaze) {
		JavaInterface jInterface = (JavaInterface) interfaze;
		String s;
		String d = jInterface.getInterface();
		if (d == null || d.length() == 0) {
			s = "Interface not set"; //$NON-NLS-1$
		} else {
			s = d;
		}
		return s;
	}

	public Interface createInterfaceFor(Object interfaceObj) {
		JavaInterface javaInterface = J2eeFactory.eINSTANCE.createJavaInterface();
		String fqn = null;
		if (interfaceObj instanceof TypeInfo) {
			TypeInfo type = (TypeInfo) interfaceObj;
			fqn = type.getFullyQualifiedName();
		} else if (interfaceObj instanceof IType) {
			fqn = getPackageName((IType) interfaceObj) + '.' + ((IType) interfaceObj).getElementName();
		}

		javaInterface.setInterface(fqn);

		return javaInterface;
	}

	@Override
	public Interface createInterfaceForService(EClass serviceType) throws SAFException,
			InvalidOperationException {
		JavaInterface javaInterface = J2eeFactory.eINSTANCE.createJavaInterface();
		return javaInterface;
	}

	private String getPackageName(IType type) {
		if (type.isBinary()) {
			IPackageFragment packageFragment = type.getPackageFragment();
			IJavaElement res = packageFragment.getClassFile(type.getElementName() + ".class"); //$NON-NLS-1$
			String path = res.getPath().toString();
			int index = path.indexOf(IJavaSearchScope.JAR_FILE_ENTRY_SEPARATOR);
			if (index != -1) {
				String last = path.substring(index + 1);
				index = last.lastIndexOf('/');
				if (index != -1) {
					last = last.substring(0, index);
				}
				return last.replace('/', '.');
			}
		} else {
			return type.getPackageFragment().getElementName();
		}

		return null;
	}

}