/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoTabbedComposite;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.UnitCaptionDialog2;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Composite that displays General Unit properties.
 * 
 * @author NKruk
 * 
 * TODO externalize strings
 * 
 */
public class GeneralPropertyComposite extends DmoTabbedComposite {
	private Label unitName;
	private Text UnitNameText;
	private Label UnitType;
	private Button conceptual;
	private Button configuration;
	private Label installTransitionLabel;
	private CCombo installTransitionCombo;
	private Label installTransitionIcon;
	private Button publishCheckBox;
	private Label imageLabel;
	private Label typeLabel;
	private Label contractIcon;
	private Label contractLabel;
	private CCombo contractCombo;
	private Hyperlink captionDialogLink;
	private Composite captionComposite;
	private List<String> keys;

	/**
	 * Creates the Composite.
	 * 
	 * @param parent
	 * @param gefDomain
	 * @param formToolkit
	 */
	public GeneralPropertyComposite(Composite parent, int style, FormToolkit formToolkit) {
		super(parent, style, formToolkit);
	}

	@Override
	protected void initializeMainContent(Composite parent, DmoSyncHelper synchHelper) {
		//Composite parent = getWidgetFactory().createComposite(main);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.marginWidth = ITabbedPropertyConstants.HSPACE + 2;
		gridLayout.marginHeight = ITabbedPropertyConstants.VSPACE;
		parent.setLayout(gridLayout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		GridData textData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		GridData imageData = new GridData(SWT.FILL, SWT.CENTER, false, false);

		FormToolkit wf = getWidgetFactory();
		//Caption
		unitName = wf.createLabel(parent, ""); //$NON-NLS-1$
		unitName.setText(Messages.GeneralPropertyComposite_Caption_);

		new Label(parent, SWT.NONE);

		createCaptionDialog(parent);

		//Type
		UnitType = wf.createLabel(parent, ""); //$NON-NLS-1$
		UnitType.setText(Messages.GeneralPropertyComposite_Type__2);
		imageLabel = wf.createLabel(parent, ""); //$NON-NLS-1$
		imageLabel.setLayoutData(imageData);

		typeLabel = wf.createLabel(parent, ""); //$NON-NLS-1$
		typeLabel.setText(Messages.GeneralPropertyComposite_Type_);
		typeLabel.setLayoutData(textData);

		//Settings
		wf.createLabel(parent, Messages.GeneralPropertyComposite_Settings_);
		new Label(parent, SWT.None); //filler
		conceptual = wf
				.createButton(parent, Messages.GeneralPropertyComposite_Conceptual_, SWT.CHECK);

		new Label(parent, SWT.None); //filler
		new Label(parent, SWT.None); //filler
		configuration = wf.createButton(parent, Messages.GeneralPropertyComposite_Configuration_,
				SWT.CHECK);

		new Label(parent, SWT.None); //filler
		new Label(parent, SWT.None); //filler
		publishCheckBox = wf.createButton(parent,
				Messages.GeneralPropertyComposite_Do_not_publish_any_unit_change_, SWT.CHECK);

		//Contract
		contractLabel = wf.createLabel(parent, ""); //$NON-NLS-1$
		contractLabel.setText(Messages.GeneralPropertyComposite_Contract_);

		contractIcon = wf.createLabel(parent, ""); //$NON-NLS-1$
		contractIcon.setLayoutData(imageData);

		contractCombo = new CCombo(parent, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
		wf.adapt(contractCombo, false, false);
		contractCombo.setLayoutData(gridData);

		//Install state
		installTransitionLabel = wf.createLabel(parent, ""); //$NON-NLS-1$
		installTransitionLabel.setText(Messages.GeneralPropertyComposite_Install_Transition_State_);

		installTransitionIcon = wf.createLabel(parent, ""); //$NON-NLS-1$
		installTransitionIcon.setLayoutData(new GridData(16, SWT.DEFAULT));

		installTransitionCombo = new CCombo(parent, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
		wf.adapt(installTransitionCombo, false, false);
		installTransitionCombo.setLayoutData(gridData);

		synchronizeFields();

		//addStereotypeSection(parent, 3, floating());
		//addConstraintSection(this, 3, floating());
		//addConstraintHyperlink(parent, 3);

	}

	private void createCaptionDialog(Composite parent) {
		captionComposite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.marginWidth = 0;
		gridLayout.marginLeft = 0;
		GridData temp = new GridData(SWT.FILL, SWT.CENTER, true, false);
		captionComposite.setLayout(gridLayout);
		captionComposite.setLayoutData(temp);

		UnitNameText = getWidgetFactory().createText(captionComposite, ""); //$NON-NLS-1$
		UnitNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	private void createCaptionDialogLink() {
		final GeneralPropertyComposite cont = this;
		captionDialogLink = getWidgetFactory().createHyperlink(captionComposite, "", //$NON-NLS-1$
				SWT.FLAT);
		captionDialogLink.addHyperlinkListener(new IHyperlinkListener() {

			public void linkActivated(HyperlinkEvent e) {
				Point location = new Point(captionDialogLink.getLocation());

				org.eclipse.swt.graphics.Point loc = location.getSWTPoint();
				loc = Display.getCurrent().map(cont, null, loc);

				//if we're using a listener (like in flyout)- use our new close mechanism
				if (popupCloser != null) {
					UnitCaptionDialog2 ucd = new UnitCaptionDialog2(cont.getShell(), (Unit) dmo, loc,
							null, false) {
						//Overwrite to use our own listeners
						protected void configureShell(Shell shell) {
							Display display = shell.getDisplay();
							shell.setBackground(display.getSystemColor(SWT.COLOR_BLACK));

							int border = (getShellStyle() & SWT.NO_TRIM) == 0 ? 0 : 1;
							GridLayoutFactory.fillDefaults().margins(border, border).spacing(5, 5)
									.applyTo(shell);

						}
					};
					ucd.open();

					popupCloser.setSecondaryPopup(ucd);
				} else {
					//Property sheet case- use generic popup
					UnitCaptionDialog2 ucd = new UnitCaptionDialog2(cont.getShell(), (Unit) dmo, loc,
							null, false) {
						protected void configureShell(Shell shell) {
							super.configureShell(shell);
						}
					};
					ucd.open();
				}

			}

			public void linkEntered(HyperlinkEvent e) {
				// Do nothing
			}

			public void linkExited(HyperlinkEvent e) {
				// Do nothing
			}
		});
	}

	/**
	 * Select the Display name for editing.
	 */
	public void selectName() {
		UnitNameText.setSelection(0, UnitNameText.getText().length());
	}

	/**
	 * Sets up the composite based on the given DeployModelObject.
	 * 
	 * @param dmo
	 *           the dmo
	 */
	public void setInput(DeployModelObject dmo) {
		super.setInput(dmo);
		imageLabel.setImage(IconService.getInstance().getIcon(new EObjectAdapter(dmo),
				IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue()));

		typeLabel.setText(PropertyUtils.getDisplayEType(dmo.eClass(), "*")); //$NON-NLS-1$
		typeLabel.pack();
		if (keys != null) {
			keys.clear();
		}
		keys = getKeys((Unit) dmo);
		if (dmo instanceof Unit && keys.size() == 0) { //Don't show link
			if (captionDialogLink != null) {
				captionDialogLink.dispose();
				captionDialogLink = null;
			}
		} else { //show the link
			if (captionDialogLink == null) { //create the link again
				createCaptionDialogLink();
			}
			//Set the text on the link
			captionDialogLink.setText(NLS.bind(Messages.GeneralPropertyComposite_Edit_0_,
					getLinkMessage()));
		}
		captionComposite.layout();
	}

	/**
	 * Sets the popup listener so it can be configured for the use of the secondary popup
	 * (UnitCaptionDialog)
	 * 
	 * @param listener
	 */
	public void setPopupListener(PopupCloserListener listener) {
		super.setPopupCloser(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.handlers.DmoComposite#createDmoSyncHelperModel()
	 * 
	 * Overide for our property customizations
	 */
	protected DmoSyncHelperModel createDmoSyncHelperModel() {
		return new GeneralDmoSyncHelperModel();
	}

	/**
	 * Sync up the fields. Must be called after input is set.
	 */
	private void synchronizeFields() {
		getSynchHelper().synchText(UnitNameText,
				CorePackage.eINSTANCE.getDeployModelObject_DisplayName(), true, null);
		//TODO Don't want to show values for import-- 
		//bug since property pages show up when NameCompartment EditPart of import is selected
		if (!(dmo instanceof Import)) {
			getSynchHelper().synchCheckbox(conceptual, CorePackage.eINSTANCE.getUnit_Conceptual(),
					null);
			getSynchHelper().synchCheckbox(configuration,
					CorePackage.eINSTANCE.getUnit_ConfigurationUnit(), null);
			getSynchHelper().synchCombo(contractCombo,
					CorePackage.eINSTANCE.getDeployModelObject_Visibility(), contractIcon, null);
			getSynchHelper().synchCombo(installTransitionCombo,
					CorePackage.eINSTANCE.getUnit_InitInstallState(), installTransitionIcon, null);
			getSynchHelper().synchCombo(installTransitionCombo,
					CorePackage.eINSTANCE.getUnit_GoalInstallState(), null);
			getSynchHelper().synchCheckbox(publishCheckBox,
					CorePackage.eINSTANCE.getUnit_PublishIntent(), null);
		}
	}

	@SuppressWarnings("unchecked")
	private List<String> getKeys(Unit unit) {
		List<String> retVal = new LinkedList<String>();

		for (Capability cap : (List<Capability>) unit.getCapabilities()) {
			List<EAttribute> k = cap.titleKeys();
			if (k != null && k.size() > 0) {
				for (EAttribute key : k) {
					retVal.add(DeployNLS.getName(key, cap));
				}
			}
		}

		return retVal;
	}

	private String getLinkMessage() {
		String retVal = "";//$NON-NLS-1$
		for (Iterator<String> it = keys.iterator(); it.hasNext();) {
			String kad = it.next();
			retVal = NLS.bind(DeployCoreMessages.CapabilityCaptionProvider_PART_SUBPART, retVal, kad); //Fix for NLS issues with RTL languages
		}
		return retVal;
	}

	@Override
	protected boolean shouldAddStereotypes() {
		return true;
	}

}
