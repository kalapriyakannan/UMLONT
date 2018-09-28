package com.ibm.ccl.soa.deploy.core.ui.internal.handlers;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.handlers.AttributeValueUIHandler.AttributeValueComposite;

public class AttributeCapacityConstraintUIHandler extends AbstractCompositeFactory {

	public AttributeCapacityConstraintUIHandler() {
	}

	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) /* throws SAFException */{

		DmoComposite composite = new AttributeCapacityValueComposite(parent,
				(AttributeValueConstraint) editDmo, formToolkit);
		formToolkit.adapt(composite);
		//		composite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_MAGENTA));
		return composite;
	}

	static class AttributeCapacityValueComposite extends AttributeValueComposite {

		protected AttributeCapacityValueComposite(Composite parent, AttributeValueConstraint avc,
				FormToolkit formToolkit) {
			super(parent, avc, formToolkit);
			setInput(avc);
		}

		protected void synthFields(List<EStructuralFeature> synthExclusions) {
			super.synthFields(synthExclusions);

			addRestrictionSection();
		}

		private void addRestrictionSection() {
//
//			Composite minMax = getWidgetFactory().createComposite(this, SWT.FLAT);

			Label restrictionLabel = createLabel("Restriction"); //$NON-NLS-1$
			createTextEntry(this, ConstraintPackage.Literals.ATTRIBUTE_CAPACITY_CONSTRAINT__VALUE,
					SWT.NONE, restrictionLabel);

			Label exclusiveLabel = createLabel("Exclusive access"); //$NON-NLS-1$
			createCheckboxEntry(this,
					ConstraintPackage.Literals.ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE, exclusiveLabel);

		}

	} // end static inner class AttributeValueComposite

}
