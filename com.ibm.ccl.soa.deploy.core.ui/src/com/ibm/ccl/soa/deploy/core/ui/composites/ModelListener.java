/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.composites;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * This listener for EMF models makes it simpler to listen to a parent as well as child elements.
 * 
 */
abstract class ModelListener extends EContentAdapter {

	List<EObject> targets = new ArrayList<EObject>();

	protected void adaptTarget(DeployModelObject aDmo) {
		adaptTarget(aDmo.getEObject());
	}

	protected void adaptTarget(EObject eObject) {
		eObject.eAdapters().add(this);
		targets.add(eObject);
	}

	protected void removeTarget(EObject eObject) {
		eObject.eAdapters().remove(this);
		targets.remove(eObject);
	}

	protected void dispose() {
		Iterator<EObject> it = targets.iterator();
		while (it.hasNext()) {
			EObject eObj = it.next();
			eObj.eAdapters().remove(this);
		}
		targets.clear();
		if (target != null) {
			target.eAdapters().remove(this);
		}
	}

	protected void adapt(DeployModelObject aDmo) {
		if (aDmo != null) {
			aDmo.getEObject().eAdapters().add(this);
//				adaptChildren(aDmo);
		}
	}

//		/**
//		 * @see #adaptTarget(DeployModelObject)
//		 */
//		protected abstract void adaptChildren(DeployModelObject aDmo);
}