/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.IControlCreator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.CompositeForDmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthDmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.popup.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * SAF UI handler for a {@link AttributePropagationConstraint}.
 * 
 * <p>
 * LineItem 5856
 * 
 * <p>
 * 
 * Registered through the <code>com.ibm.ccl.soa.deploy.saf.ui.uihandlers</code> extension point.
 * 
 * @author Ed Snible
 */
public class AttributePropagationConstraintUIHandler extends AbstractCompositeFactory {

	/**
	 * @param dmo
	 * @return <code>true</code> if this instance can provide a UI handler for <code>dmo</code>
	 */
	@Override
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return dmo.eClass() == ConstraintPackage.eINSTANCE.getAttributePropagationConstraint();
	}

	@Override
	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit factory) {
		DmoComposite composite = new AttributePropagationComposite(parent,
				(AttributePropagationConstraint) editDmo, factory);
		factory.adapt(composite);
		//		composite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_MAGENTA));

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.ATTRIBUTE_PROPAGATION_CONSTRAINT);
		return composite;
	}

	static class AttributePropagationComposite extends SynthDmoComposite {

		// Attributes on the composite but not the Constraint!
		protected static final EAttribute fakeSourceAttribute = EcoreFactory.eINSTANCE
				.createEAttribute();
		protected static final EAttribute fakeTargetAttribute = EcoreFactory.eINSTANCE
				.createEAttribute();

		/**
		 * @param parent
		 * @param apc
		 * @param factory
		 */
		public AttributePropagationComposite(Composite parent, AttributePropagationConstraint apc,
				FormToolkit factory) {
			super(parent, apc, factory);
			setInput(apc);
		}

		/**
		 * Exclude the attribute names. Custom composites for the source/target will handle them.
		 */
		@Override
		protected List<EStructuralFeature> getExclusions() {
			List<EStructuralFeature> retVal = new LinkedList<EStructuralFeature>(super.getExclusions());
			retVal.add(ConstraintPackage.eINSTANCE
					.getAttributePropagationConstraint_SourceAttributeName());
			retVal
					.add(ConstraintPackage.eINSTANCE.getAttributePropagationConstraint_SourceObjectURI());
			retVal.add(ConstraintPackage.eINSTANCE
					.getAttributePropagationConstraint_TargetAttributeName());
			retVal
					.add(ConstraintPackage.eINSTANCE.getAttributePropagationConstraint_TargetObjectURI());
			return retVal;
		}

		protected void synthFields(List<EStructuralFeature> synthExclusions) {
			addGenericSection(synthExclusions);
			addSourceTargetSection();
		}

		private void addSourceTargetSection() {

			// Source
			Label sourceLabel = getWidgetFactory().createLabel(this,
					Messages.AttributePropagationConstraintUIHandler_Source_);
			createDataEntryField(this, fakeSourceAttribute,
					getAttributeMetaData(ConstraintPackage.eINSTANCE
							.getAttributePropagationConstraint_SourceObjectURI()), sourceLabel);
			Label targetLabel = getWidgetFactory().createLabel(this,
					Messages.AttributePropagationConstraintUIHandler_Target_);
			createDataEntryField(this, fakeTargetAttribute,
					getAttributeMetaData(ConstraintPackage.eINSTANCE
							.getAttributePropagationConstraint_TargetObjectURI()), targetLabel);
		}

		@SuppressWarnings("deprecation")
		protected DecoratedField createDataEntryField(Composite parent, EAttribute attribute,
				AttributeMetaData amd, Label label) {
			if (attribute == fakeSourceAttribute || attribute == fakeTargetAttribute) {
				return createRelativeURIEntry(parent, attribute, amd, label);
			}

			return super.createDataEntryField(parent, attribute, amd, label);
		}

		@SuppressWarnings("deprecation")
		private DecoratedField createRelativeURIEntry(Composite parent, EAttribute attribute,
				AttributeMetaData amd, Label label) {
			DecoratedField decor = new DecoratedField(parent, SWT.NULL, getRelativeURIControlCreator());

			decor.getLayoutControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			Widget avlc = decor.getControl();
			RelativeURIComposite ruc = (RelativeURIComposite) avlc;
			ruc.setConstraint((AttributePropagationConstraint) dmo); // RelativeURIComposite needs the Constraint, not the model, so it can call ConstraintUtil
			getSynchHelper().synchPopupList(avlc, attribute, null);

			return decor;
		}

		@SuppressWarnings("deprecation")
		private IControlCreator getRelativeURIControlCreator() {
			return new IControlCreator() {

				public Control createControl(Composite parent, int style) {
					Composite comp = new RelativeURIComposite(parent, style);
					comp.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));
					getWidgetFactory().adapt(comp);
					return comp;
				}
			};
		}
	} // end inner class AttributePropagationComposite

	static class RelativeURIComposite extends Composite implements CompositeForDmoComposite {

//		private AttributePropagationConstraint apc;
		DmoSyncHelperModel model;
		private EAttribute attrib;

		private final Button button;
		private final Combo combo;
		private AttributePropagationConstraint apc;
		private boolean isSource;
		private final CLabel label;

//		private AttributePropagationConstraintValidator avcv;

		/**
		 * @param parent
		 * @param style
		 */
		public RelativeURIComposite(Composite parent, int style) {
			super(parent, style);

			setLayout(new GridLayout(3, false));

			label = new CLabel(this, SWT.NULL);
			GridData gdLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
			gdLabel.widthHint = 200;
			label.setLayoutData(gdLabel);

			button = new Button(this, SWT.PUSH);
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					popupChoices();
				}
			});
//			button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			button.setText(com.ibm.ccl.soa.deploy.core.ui.Messages.BROWSE_LABEL);

			combo = new Combo(this, SWT.DROP_DOWN | style);
			combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			combo.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					selectedAttributeChanged();
				}
			});
		}

		@Override
		public void layout(boolean changed, boolean all) {
			super.layout(changed, all);
		}

		@Override
		public void setEnabled(boolean enabled) {
			super.setEnabled(enabled);

			button.setEnabled(enabled && hasChoices());
			combo.setEnabled(enabled);
		}

		protected void setConstraint(AttributePropagationConstraint propConstraint) {
			apc = propConstraint;
		}

		public void setup(DmoSyncHelperModel model2, EStructuralFeature esf) {
//			setBackground(Display.getDefault().getSystemColor(SWT.COLOR_BLUE));
			model = model2;
			attrib = (EAttribute) esf;
			isSource = attrib == AttributePropagationComposite.fakeSourceAttribute;

			populateCombo();
		}

		private void populateCombo() {
			if (combo.isDisposed()) {
				return;
			}

			DeployModelObject dmo = getDmo();
			if (dmo == null) {
				combo.setItems(new String[0]);
			} else {
				Map<String, EStructuralFeature> attribs = getAttributes(dmo);
				String[] fieldLabels = attribs.keySet().toArray(new String[0]);
				combo.setItems(fieldLabels);

				// Look up the constraint's source/target attribute name, find the label for it, select that label
				String attribName = getAttributeName();
				for (Map.Entry<String, EStructuralFeature> me : attribs.entrySet()) {
					if (me.getValue().getName().equals(attribName)) {
						String labelName = me.getKey();
						for (int i = 0; i < fieldLabels.length; i++) {
							if (fieldLabels[i].equals(labelName)) {
								combo.select(i);
								return;
							}
						}
					}
				}
			}
		}

		private DeployModelObject getDmo() {
			return isSource ? getSourceObject() : getTargetObject();
		}

		private void selectedAttributeChanged() {
			// What is selected in the combo box?
			String labelName = combo.getItem(combo.getSelectionIndex());

			Map<String, EStructuralFeature> attribs = getAttributes(getDmo());
			for (Map.Entry<String, EStructuralFeature> me : attribs.entrySet()) {
				if (me.getKey().equals(labelName)) {
					setAttributeName(me.getValue().getName());
					return;
				}
			}

			// If we got here, we couldn't find the attribute...
			setAttributeName(""); //$NON-NLS-1$
		}

		private void setAttributeName(final String s) {
			PropertyUtils.executeWithUndo(apc,
					Messages.AttributePropagationConstraintUIHandler_Set_Attribute_Nam_, new Runnable() {

						public void run() {
							if (isSource) {
								apc.setSourceAttributeName(s);
							} else {
								apc.setTargetAttributeName(s);
							}
						}
					});

		}

		/**
		 * Subclasses should override if a custom model is required.
		 * 
		 * @return {@link DmoSyncHelperModel}.
		 */
		protected DmoSyncHelperModel createDmoSyncHelperModel() {
			return new APCHelperModel();
		}

		private void setURI(final String s) {
			PropertyUtils.executeWithUndo(apc,
					Messages.AttributePropagationConstraintUIHandler_Set_Pat_, new Runnable() {

						public void run() {
							if (isSource) {
								apc.setSourceObjectURI(s);
							} else {
								apc.setTargetObjectURI(s);
							}
						}
					});

			// Refresh button
			showValue();

			// Refresh combo
			populateCombo();
		}

		private String getAttributeName() {
			return isSource ? apc.getSourceAttributeName() : apc.getTargetAttributeName();
		}

		private Map<String, EStructuralFeature> getAttributes(DeployModelObject dmo) {
			Map<String, EStructuralFeature> retVal = new HashMap<String, EStructuralFeature>();

			// Add all ESFs
			IItemPropertySource iips = PropertyUtils.getPropertySource(dmo);
			for (EAttribute ea : dmo.eClass().getEAllAttributes()) {
				if (suitableAttribute(ea)) {
					ItemPropertyDescriptor ipd = PropertyUtils.getItemPropertyDescriptor(iips, dmo, ea);
					String displayName = ipd != null ? ipd.getDisplayName(dmo) : ea.getName();
					retVal.put(displayName, ea);
				}
			}

			// Add all ExtendedAttributes
			for (ExtendedAttribute ea : (List<ExtendedAttribute>) dmo.getExtendedAttributes()) {
				retVal.put(getLabel(dmo, ea), ea);
			}

			return retVal;
		}

		private String getLabel(DeployModelObject dmo, ExtendedAttribute ea) {
			AttributeMetaData amd = dmo.getAttributeMetaData(ea.getName());
			if (amd != null && amd.getLabel() != null) {
				return amd.getLabel();
			}

			return ea.getName();
		}

		private boolean suitableAttribute(EStructuralFeature esf) {
			// Don't use attributes that are feature maps.
			if (FeatureMapUtil.isFeatureMap(esf)) {
				return false;
			}

			if (esf.getUpperBound() != 1) {
				return false;
			}

			return true;
		}

		public void showValue() {
			if (model != null) {
//				button.setText(getURIName());
				label.setText(getURIName());
			}
		}

		private String getURIName() {
			DeployModelObject dmo = getDmo();
			return DeployModelObjectUtil.getTitle(dmo);
//			return PropertyUtils.getSoaLabelProvider().getText(dmo);
		}

		private DeployModelObject getSourceObject() {
			List<DeployModelObject> ldmos = apc.getSourceObjects();
//			getAttributePropagationConstraintValidator().getSourceObjects(apc, context, outStatus)
//			StatusInOutParameter statusResult = new StatusInOutParameter();
//			statusResult.clear();
//			List<DeployModelObject> ldmos = getAttributePropagationConstraintValidator()
//					.getSourceObjects(apc, getContext(), statusResult);
			if (ldmos.size() == 0) {
				return null;
			}

			// According to LineItem 5959, placement of an AttributePropagationConstraint on
			// a MEMBER Requirement means that propagation is between all sources and all targets.
			// We are currently ignoring that case.  This is a small problem for calculating
			// attributes (two sources might have different extended attributes) but a big problem
			// for calculating source (our button only has room for one display name).
			return ldmos.get(0);
		}

		private DeployModelObject getTargetObject() {
			List<DeployModelObject> ldmos = apc.getTargetObjects();
//			StatusInOutParameter statusResult = new StatusInOutParameter();
//			statusResult.clear();
//			List<DeployModelObject> ldmos = getAttributePropagationConstraintValidator()
//					.getTargetObjects(apc, getContext(), statusResult);

			if (ldmos.size() == 0) {
				return null;
			}

			// According to LineItem 5959, placement of an AttributePropagationConstraint on
			// a MEMBER Requirement means that propagation is between all sources and all targets.
			// We are currently ignoring that case.  This is a small problem for calculating
			// attributes (two sources might have different extended attributes) but a big problem
			// for calculating source (our button only has room for one display name).
			return ldmos.get(0);
		}

//		private DeployModelObject getContext() {
//			DeployModelObject context = ConstraintUtil.getExpectedContext(apc);
//			return context;
//		}

//		private AttributePropagationConstraintValidator getAttributePropagationConstraintValidator() {
//			AttributePropagationConstraintValidator avcv = new AttributePropagationConstraintValidator();
//			return avcv;
//		}

		private DeployModelObject getBaseForLinking() {
			return isSource ? getSourceBase() : getTargetBase();
		}

		private DeployModelObject getSourceBase() {
			List<DeployModelObject> ldmos = apc.getBaseSourceObjects();

			if (ldmos.size() == 0) {
				return null;
			}

			// According to LineItem 5959, placement of an AttributePropagationConstraint on
			// a MEMBER Requirement means that propagation is between all sources and all targets.
			// We are currently ignoring that case.  This is a small problem for calculating
			// attributes (two sources might have different extended attributes) but a big problem
			// for calculating source (our button only has room for one display name).
			return ldmos.get(0);
		}

		private DeployModelObject getTargetBase() {
			List<DeployModelObject> ldmos = apc.getBaseTargetObjects();

			if (ldmos.size() == 0) {
				return null;
			}

			// According to LineItem 5959, placement of an AttributePropagationConstraint on
			// a MEMBER Requirement means that propagation is between all sources and all targets.
			// We are currently ignoring that case.  This is a small problem for calculating
			// attributes (two sources might have different extended attributes) but a big problem
			// for calculating source (our button only has room for one display name).
			return ldmos.get(0);
		}

		protected void popupChoices() {
			Rectangle bounds = button.getBounds();
			Point loc = toDisplay(bounds.x, bounds.y + bounds.height);

			SetUriPopupDialog ncpd = new SetUriPopupDialog(getShell(), loc, getBaseForLinking(), this);
			ncpd.open();

			populateCombo();
		}

		/**
		 * @return <code>true</code> if popupChoice() will display a UI with > 1 choice
		 */
		private boolean hasChoices() {
			DeployModelObject base = getBaseForLinking();
			ITreeContentProvider itcp = new SetUriPopupDialog.SetUriPopupDialogTreeContentProvider();
			return itcp.hasChildren(base);
		}

	}

	private static class SetUriPopupDialog extends PopupDialog {
		private final Point location;
		private final DeployModelObject baseObject;
		private final RelativeURIComposite uriComp;
		private TreeViewer viewer;

		/**
		 * @param parent
		 * @param upperLeft
		 * @param root
		 *           the DMO to display as the root of the tree
		 * @param relativeURIComposite
		 */
		private SetUriPopupDialog(Shell parent, Point upperLeft, DeployModelObject root,
				RelativeURIComposite relativeURIComposite) {
			super(parent, SWT.NONE, true, false, false, false,
					"", Messages.AttributePropagationConstraintUIHandler_Attribute_value_propagatio_); //$NON-NLS-1$
			location = upperLeft;
			baseObject = root;
			uriComp = relativeURIComposite;
		}

		protected Control createDialogArea(Composite parent) {
			Tree uriTree = new Tree(parent, SWT.V_SCROLL | SWT.BORDER | SWT.SINGLE);
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
					IDeployHelpContextIds.ATTRIBUTE_PROPAGATION_CONSTRAINT_POPUP);
			viewer = new TreeViewer(uriTree);

			viewer.setLabelProvider(PropertyUtils.getSoaLabelProvider());
			viewer.setContentProvider(new SetUriPopupDialogTreeContentProvider());
			viewer.setInput(Collections.singletonList(baseObject));
			viewer.expandAll();

			TreeConfirmListener tcl = new TreeConfirmListener();
			uriTree.addKeyListener(tcl);
			uriTree.addMouseListener(tcl);

			return uriTree;
		}

		@Override
		protected Point getInitialLocation(Point initialSize) {
			return location;
		}

		@Override
		public int open() {
			int retVal = super.open();
			viewer.getTree().setFocus();
			return retVal;
		}

		protected void openSelection() {
			openDmo((DeployModelObject) getSelectionAs(viewer, DeployModelObject.class));
		}

		private static Object getSelectionAs(ISelectionProvider isp, Class<?> clazz) {
			ISelection sel = isp.getSelection();
			if (sel instanceof StructuredSelection) {
				StructuredSelection ss = (StructuredSelection) sel;
				Object obj = ss.getFirstElement();
				if (clazz.isInstance(obj)) {
					return obj;
				}
			}

			return null;
		}

		private void openDmo(DeployModelObject dmo) {
			if (dmo == null) {
				return;
			}

			String relPath = dmo.getRelativePath(baseObject);
			uriComp.setURI(relPath);

			close();
		}

		private static List<DeployModelObject> filterOutInappropriates(List<DeployModelObject> l) {
			List<DeployModelObject> retVal = new LinkedList<DeployModelObject>();

			for (DeployModelObject dmo : l) {
				if (appropriateForApcEndpoint(dmo)) {
					retVal.add(dmo);
				}
			}

			return retVal;
		}

		private static boolean appropriateForApcEndpoint(DeployModelObject dmo) {
			if (dmo instanceof DeployLink) {
				return false;
			}

			return true;
		}

		private class TreeConfirmListener extends MouseAdapter implements KeyListener {

			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR && e.stateMask == 0) {
					openSelection();
				}
			}

			public void keyReleased(KeyEvent e) {
				// do nothing
			}

			@Override
			public void mouseDown(MouseEvent e) {
				openSelection();
			}

		}

		private static class SetUriPopupDialogTreeContentProvider implements ITreeContentProvider {

			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof List) {
					return ((List<?>) parentElement).toArray();
				} else if (parentElement instanceof DeployModelObject) {
					DeployModelObject dmo = (DeployModelObject) parentElement;
					List<DeployModelObject> l = new ArrayList<DeployModelObject>(dmo
							.getContainedModelObjects());
					l = filterOutInappropriates(l);
					return l.toArray();
				}

				return new Object[0];
			}

			public Object getParent(Object element) {
				return null;
			}

			public boolean hasChildren(Object element) {
				return getChildren(element).length > 0;
			}

			public Object[] getElements(Object inputElement) {
				return getChildren(inputElement);
			}

			public void dispose() {
				// do nothing
			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// do nothing
			}

		}

	} // end inner class SetUriPopupDialog

	private static class APCHelperModel extends DmoSyncHelperModel {

	}
}
