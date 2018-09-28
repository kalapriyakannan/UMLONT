package com.ibm.ccl.soa.deploy.core.ui.editparts.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.ref.StructuredReference;

public class ViewAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof View) {
			if (adapterType == DeployModelObject.class || adapterType == Unit.class
					|| adapterType == ITarget.class || adapterType == StructuredReference.class) {
				View view = (View) adaptableObject;
				EObject element = view.getElement();
				if (null != element) {
					if (CorePackage.Literals.DEPLOY_MODEL_OBJECT.isSuperTypeOf(element.eClass())) {
						if (adapterType == DeployModelObject.class) {
							return element;
						} else if (adapterType == Unit.class) {
							if (CorePackage.Literals.UNIT.isSuperTypeOf(element.eClass())) {
								return element;
							}
						}
					} else if (element instanceof ITarget) {
						if (adapterType == ITarget.class) {
							return element;
						} else if (adapterType == StructuredReference.class) {
							return ((ITarget) element).getStructuredReference();
						}
					}
				}
			}
		}

		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { Unit.class, DeployModelObject.class, ITarget.class,
				StructuredReference.class };
	}

}
