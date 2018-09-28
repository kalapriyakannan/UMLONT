package com.ibm.ccl.soa.deploy.core.ui.editparts.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.xtools.mmi.core.ITarget;
import com.ibm.xtools.mmi.core.ref.StructuredReference;

public class EditPartAdapterFactory implements IAdapterFactory {

	private final ViewAdapterFactory adapter = new ViewAdapterFactory();

	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof EditPart) {

			EditPart part = (EditPart) adaptableObject;
			Object model = part.getModel();
			if (model instanceof View) {
				View view = (View) model;
				if (adapterType == View.class) {
					return view;
				}

				return adapter.getAdapter(view, adapterType);
			}
		}

		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { View.class, Unit.class, DeployModelObject.class, ITarget.class,
				StructuredReference.class };
	}
}
