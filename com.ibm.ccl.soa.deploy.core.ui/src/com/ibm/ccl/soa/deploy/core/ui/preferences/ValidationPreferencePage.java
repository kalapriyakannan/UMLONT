/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.preferences;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PreferenceLinkArea;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ICommonDeployExtensionConstants;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * Turn of the in-memory topology validator selectively.
 * 
 * <p>
 * Because there is no {@link FieldEditor} for trees, and we need one, we don't use
 * {@link FieldEditorPreferencePage}.
 * 
 * @author Ed Snible
 * 
 * @see DeployCoreMainPreferencePage
 * @deprecated
 */
public class ValidationPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private Button buttonOverride;
	private CheckboxTreeViewer tv;

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		//        Label label = new Label(composite, SWT.NONE);
		//        label.setText("Deployment Topology Validation is currently "  //$NON-NLS-1$
		//    		+ getEnabledString() 
		//    		+ "."); //$NON-NLS-1$

		// 'ValidationPreferencePage' is Eclipse's main validation page.
		String pageId = "ValidationPreferencePage"; //$NON-NLS-1$
		PreferenceLinkArea areaValidation = new PreferenceLinkArea(composite, SWT.NONE, pageId,
				"See <a>''{0}''</a> for workbench validation settings.",//$NON-NLS-1$
				(IWorkbenchPreferenceContainer) getContainer(), null);

		GridData data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
		areaValidation.getControl().setLayoutData(data);

		buttonOverride = new Button(composite, SWT.CHECK);
		buttonOverride
				.setText(Messages.ValidationPreferencePage_Allow_projects_and_topologies_to_ov_);
		buttonOverride.setEnabled(false); // TODO Implement

		Group groupValidators = new Group(composite, SWT.NONE);
		groupValidators.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		groupValidators.setText(Messages.ValidationPreferencePage_Deployment_Topology_Validator_);
		groupValidators.setLayout(new GridLayout());

		Label labelValidators = new Label(groupValidators, SWT.NONE);
		labelValidators
				.setText(Messages.ValidationPreferencePage_Select_validators_to_use_during_Top_);

		Tree tree = new Tree(groupValidators, SWT.BORDER | SWT.CHECK);
		tv = new CheckboxTreeViewer(tree);
		tv.setContentProvider(new ValidatorPreferencesContentProvider());
		tv.setLabelProvider(new ValidatorPreferencesLabelProvider());

		initialize();

		return composite;
	}

	protected void performDefaults() {
		initialize();
		super.performDefaults();
	}

	public boolean performOk() {
		List checked = Arrays.asList(tv.getCheckedElements());
		List allValidators = getAllValidators();
		for (Iterator it = allValidators.iterator(); it.hasNext();) {
			Object validator = it.next();
			setEnabledDomain(getId(validator), checked.contains(validator));
		}

		return super.performOk();
	}

	private List getAllValidators() {
		// Currently this dialog only support domain-level validation control,
		// so the only validators are the domains themselves.
		return Arrays.asList(getSoaDeployDomains());
	}

	private Object[] getEnabledValidators() {
		List retVal = new LinkedList();
		IConfigurationElement[] domains = getSoaDeployDomains();
		for (int i = 0; i < domains.length; i++) {
			String idDomain = getId(domains[i]);
			if (enabledDomain(idDomain)) {
				retVal.add(domains[i]);
			}
		}

		return retVal.toArray();
	}

	private void setEnabledDomain(String id, boolean enabled) {
		DeployCoreEditor.getDefaultDeployValidatorService().setDomainValidatorEnabled(id, enabled);
	}

	private boolean enabledDomain(String idDomain) {
		return DeployCoreEditor.getDefaultDeployValidatorService().isDomainValidatorEnabled(idDomain);
	}

	private String getId(Object obj) {
		if (obj instanceof IConfigurationElement) {
			IConfigurationElement ice = (IConfigurationElement) obj;
			String name = ice.getAttribute("id"); //$NON-NLS-1$
			return name;
		}

		return null;
	}

	public void init(IWorkbench workbench) {
		// do nothing
		// TODO Add context-sensative help?
	}

	private void initialize() {
		tv.setInput(this);
		tv.setCheckedElements(getEnabledValidators());
	}

	private static IConfigurationElement[] getSoaDeployDomains() {
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(
				DeployCorePlugin.PLUGIN_ID, ICommonDeployExtensionConstants.TAG_DOMAINS);
		if (point == null) {
			return new IConfigurationElement[0];
		}

		IConfigurationElement[] elements = point.getConfigurationElements();
		return elements;
	}

	private static class ValidatorPreferencesContentProvider implements ITreeContentProvider {

		private static final Object[] NO_CHILDREN = new Object[0];

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof ValidationPreferencePage) {
				return getSoaDeployDomains();
			}

			return NO_CHILDREN;
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

	private static class ValidatorPreferencesLabelProvider extends LabelProvider {

		public String getText(Object element) {
			if (element instanceof IConfigurationElement) {
				IConfigurationElement ice = (IConfigurationElement) element;
				String name = ice.getAttribute("name"); //$NON-NLS-1$
				return name == null ? "<null>" : name; //$NON-NLS-1$
			}

			return element == null ? "<null>" : element.getClass().getName();//$NON-NLS-1$
		}

	}

} // end class ValidationPreferencePage
