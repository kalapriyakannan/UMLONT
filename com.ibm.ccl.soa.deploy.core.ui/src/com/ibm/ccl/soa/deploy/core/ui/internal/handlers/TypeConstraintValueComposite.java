package com.ibm.ccl.soa.deploy.core.ui.internal.handlers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthDmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * 
 */
class TypeConstraintValueComposite extends SynthDmoComposite {

	private TypeConstraint typeConstraint;
//		private boolean mutable;
	private Text textDmoType;
	final private boolean useCaps;
	final private boolean useUnits;

	protected TypeConstraintValueComposite(Composite parent, TypeConstraint tc,
			FormToolkit formToolkit, boolean allowCapTypes, boolean allowUnitTypes) {
		super(parent, tc, formToolkit);

		setInput(tc);
		typeConstraint = tc;
		useCaps = allowCapTypes;
		useUnits = allowUnitTypes;
	}

	protected void synthFields(List<EStructuralFeature> synthExclusions) {
		super.synthFields(synthExclusions);

		addDmoTypeSection();
	}

	@Override
	protected List<EStructuralFeature> getExclusions() {
		List<EStructuralFeature> retVal = new LinkedList<EStructuralFeature>(super.getExclusions());
		retVal.add(ConstraintPackage.eINSTANCE.getTypeConstraint_DmoType());
		return retVal;
	}

	/**
	 * Type: [read-only] [browse...]
	 */
	private void addDmoTypeSection() {

		Label label = getWidgetFactory().createLabel(this, Messages.TypeConstraintUIHandler_Type_);

		Composite comp = getWidgetFactory().createComposite(this);
		comp.setLayout(new GridLayout(2, false));
		comp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// We cannot create a DecoratedField for dmoType, because it is a QName.  The Sync Helper
		// and value converter aren't able to deal with SWT Text fields editing QNames (as of M6).
//			DecoratedField df = createTextEntry(comp,
//					ConstraintPackage.Literals.TYPE_CONSTRAINT__DMO_TYPE, SWT.READ_ONLY, label);
		textDmoType = getWidgetFactory().createText(comp, "", SWT.READ_ONLY); //$NON-NLS-1$
		textDmoType.setText(PropertyUtils.getDisplayEType(typeConstraint.getDmoEType(), "*")); //$NON-NLS-1$
		GridData gdDmoType = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gdDmoType.widthHint = 200;
		textDmoType.setLayoutData(gdDmoType);

		Button buttonBrowse = getWidgetFactory().createButton(comp,
				Messages.TypeConstraintUIHandler_Browse_, SWT.PUSH);
		buttonBrowse.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				browse();
			}
		});

		// Disable the button when the field is disabled
//			textDmoType = (Text) df.getControl();
//			getSynchHelper().synchText(textDmoType,
//					ConstraintPackage.Literals.TYPE_CONSTRAINT__DMO_TYPE, true,
//					new Control[] { label, buttonBrowse });

		if (!PropertyUtils.isEditable(typeConstraint,
				ConstraintPackage.Literals.TYPE_CONSTRAINT__DMO_TYPE)) {
			label.setEnabled(false);
			buttonBrowse.setEnabled(false);
		}
	}

	protected void browse() {
		TypeConstraintBrowseDialog elsd = new TypeConstraintBrowseDialog(getShell(),
				Messages.TypeConstraintUIHandler_Set_Constraint_Match_Typ_, useCaps, useUnits);
		if (elsd.open() == Window.OK) {
			final EClass ec = elsd.getSelectedEType();
			String msg = Messages.TypeConstraintUIHandler_Set_Constraint_Match_Typ_;
			PropertyUtils.executeWithUndo(typeConstraint, msg, new Runnable() {

				public void run() {
					typeConstraint.setDmoEType(ec);
				}
			});

//				textDmoType.setText(typeConstraint.getDmoType().toString());
			if (!textDmoType.isDisposed()) {
				textDmoType.setText(PropertyUtils.getDisplayEType(ec, "*")); //$NON-NLS-1$
			}
		}
	}

	@Override
	public void setInput(Object object) {
		assert object instanceof TypeConstraint;
		super.setInput(object);
		typeConstraint = (TypeConstraint) object;
//			mutable = DeployModelObjectUtil.isMutable(typeConstraint);
	}

}
