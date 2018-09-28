/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.ui.preferences;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.common.ui.preferences.AbstractPreferencePage;
import org.eclipse.gmf.runtime.common.ui.preferences.CheckBoxFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;

import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbToTdmConversionUtils;
import com.ibm.ccl.soa.deploy.cmdb.ui.CmdbUIPlugin;
import com.ibm.ccl.soa.deploy.cmdb.ui.Messages;

/**
 * The CMDB explorer preference page.
 * 
 * @author bill arnold
 */
public class CmdbExplorerPreferencePage extends AbstractPreferencePage {

	public void createControl(Composite parent) {
		super.createControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(),
				IDeployCmdbHelpContextIds.CMDB_EXPLORER_PREFERENCE_PAGE);
	}

	//preference page editor controls
	private StringFieldEditor cmdbHostnameFieldEditor;
	private StringFieldEditor cmdbUserIdFieldEditor;
	private PasswordFieldEditor cmdbUserPasswordFieldEditor;
	private CheckBoxFieldEditor filterGenerics;
	private CheckBoxFieldEditor disableCustomUnitProviders;
	private CheckBoxFieldEditor enableNavigatorPrefetcher;
	private boolean canChange = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.xtools.common.ui.preferences.AbstractPreferencePage#addFields(org.eclipse.swt.widgets.Composite)
	 */
	protected void addFields(Composite parent) {
		canChange = canChange();
		Group generalGlobalGroup = new Group(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		generalGlobalGroup.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		generalGlobalGroup.setLayoutData(gridData);
		generalGlobalGroup.setText(Messages.CMDB_EXPLORER_SETTINGS_LABEL);

		Composite composite = new Composite(generalGlobalGroup, SWT.NONE);

		cmdbHostnameFieldEditor = new StringFieldEditor(IDeployCmdbPreferences.CMDB_HOSTNAME,
				Messages.CmdbExplorerPreferencePage_CmdbHostname, composite);
		cmdbHostnameFieldEditor.setStringValue(getPreferenceStore().getDefaultString(IDeployCmdbPreferences.CMDB_HOSTNAME));
		addField(cmdbHostnameFieldEditor);

		// User id
		cmdbUserIdFieldEditor = new StringFieldEditor(IDeployCmdbPreferences.CMDB_USERID,
				Messages.CmdbExplorerPreferencePage_CmdbUserId, composite);
		cmdbUserIdFieldEditor.setStringValue(getPreferenceStore().getDefaultString(IDeployCmdbPreferences.CMDB_USERID));
		addField(cmdbUserIdFieldEditor);
		
		// User password
		cmdbUserPasswordFieldEditor = new PasswordFieldEditor(IDeployCmdbPreferences.CMDB_USERPASSWORD,
				Messages.CmdbExplorerPreferencePage_CmdbUserPassword, composite);
		cmdbUserPasswordFieldEditor.setStringValue(getPreferenceStore().getDefaultString(IDeployCmdbPreferences.CMDB_USERPASSWORD));		
		addField(cmdbUserPasswordFieldEditor);

		// whether to filter generics from cmdb tree view
		filterGenerics = new CheckBoxFieldEditor(
				IDeployCmdbPreferences.CMDB_FILTER_GENERICS,
				Messages.CmdbExplorerPreferencePage_2, composite);
		addField(filterGenerics);
		
		// whether to filter generics from cmdb tree view
		disableCustomUnitProviders = new CheckBoxFieldEditor(
				IDeployCmdbPreferences.CMDB_DISABLE_CUSTOM_UNIT_PROVIDER,
				Messages.CmdbExplorerPreferencePage_3, composite);
		addField(disableCustomUnitProviders);
		
		// Whether to enable the ccmdb navigator speculative prefetcher
		enableNavigatorPrefetcher = new CheckBoxFieldEditor(
				IDeployCmdbPreferences.CMDB_ENABLE_NAVIGATOR_PREFETCHER,
				Messages.CmdbExplorerPreferencePage_EnableNavigatorPrefetcher, composite);
		addField(enableNavigatorPrefetcher);
	}

	/**
	 * Initializes the default preference values for this preference store.
	 * 
	 * @param preferenceStore
	 */
	public static void initDefaults(IPreferenceStore preferenceStore) {
		// TODO put the hostname/credentials defaults elsewhere, or leave them unset.
		preferenceStore.setDefault(IDeployCmdbPreferences.CMDB_HOSTNAME, CmdbQueryService.INSTANCE.getTaddmServer());
		preferenceStore.setDefault(IDeployCmdbPreferences.CMDB_USERID, CmdbQueryService.INSTANCE.getTaddmUserId());
		preferenceStore.setDefault(IDeployCmdbPreferences.CMDB_USERPASSWORD, CmdbQueryService.INSTANCE.getTaddmUserPw());
		preferenceStore.setDefault(IDeployCmdbPreferences.CMDB_FILTER_GENERICS, false);
		preferenceStore.setDefault(IDeployCmdbPreferences.CMDB_DISABLE_CUSTOM_UNIT_PROVIDER, false);
		preferenceStore.setDefault(IDeployCmdbPreferences.CMDB_ENABLE_NAVIGATOR_PREFETCHER, false);
	}

	protected void initHelp() {
		//setPageHelpContextId(...);
		//do nothing, no context help for modeler yet
	}

	/**
	 * Creates a new instance and initializes the preference store.
	 */
	public CmdbExplorerPreferencePage() {
		super();
		setPreferenceStore(CmdbUIPlugin.getDefault().getPreferenceStore());
	}

	/**
	 * The field editor preference page implementation of this <code>IPreferencePage</code> (and
	 * <code>IPropertyChangeListener</code>) method intercepts <code>IS_VALID</code> events but
	 * passes other events on to its superclass.
	 */
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
	}

	private boolean canChange() {
		boolean canChange = true;
		// Anything to check here?
		return canChange;
	}

	/**
	 * The field editor preference page implementation of a <code>PreferencePage</code> method
	 * loads all the field editors with their default values.
	 */
	protected void performDefaults() {
		super.performDefaults();
		setProperties();
	}

	/**
	 * The field editor preference page implementation of this <code>PreferencePage</code> method
	 * saves all field editors by calling <code>FieldEditor.store</code>. Note that this method
	 * does not save the preference store itself; it just stores the values back into the preference
	 * store.
	 * 
	 * @see FieldEditor#store()
	 */
	public boolean performOk() {
		boolean retVal = super.performOk();
		setProperties();
		return retVal;
	}

	protected void setProperties() {
		CmdbQueryService.INSTANCE.setTaddmServer(getPreferenceStore().getString(IDeployCmdbPreferences.CMDB_HOSTNAME));
		CmdbQueryService.INSTANCE.setTaddmUserId(getPreferenceStore().getString(IDeployCmdbPreferences.CMDB_USERID));
		CmdbQueryService.INSTANCE.setTaddmUserPw(getPreferenceStore().getString(IDeployCmdbPreferences.CMDB_USERPASSWORD));
		
		// FIXME These are to communicate a couple of preference values to the non-UI project		
		// The preference store is only for UI projects		
		boolean disableCustomUnitProviders = getPreferenceStore().getBoolean(IDeployCmdbPreferences.CMDB_DISABLE_CUSTOM_UNIT_PROVIDER);
		System.setProperty(CmdbToTdmConversionUtils.DISABLE_CUSTOM_UNIT_PROVIDERS_NAME,
				disableCustomUnitProviders ? Boolean.TRUE.toString() : Boolean.FALSE.toString());
		boolean filterGenerics = getPreferenceStore().getBoolean(IDeployCmdbPreferences.CMDB_FILTER_GENERICS);
		System.setProperty(CmdbToTdmConversionUtils.CMDB_FILTER_GENERICS,
				filterGenerics ? Boolean.TRUE.toString() : Boolean.FALSE.toString());
		
		// We should be using DeployCorePerspectiveFactory.ID_PROJECT_NAV instead, but
		// DeployCorePerspectiveFactory's package isn't exported! 
//		String id = "com.ibm.ccl.soa.deploy.core.ui.navigator.views.CommonServerNavigator"; //$NON-NLS-1$
		String id = "org.eclipse.ui.navigator.ProjectExplorer"; //$NON-NLS-1$
		IViewPart ivp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(id);
		if (ivp instanceof CommonNavigator) {
			CommonNavigator cn = (CommonNavigator) ivp;
			cn.getCommonViewer().refresh();
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	// This is to deal with a bad preferences string field editor API. 
	// This class exists so that SWT.PASSWORD may be ORed into the Text constructor parameters
	// See eclipse defect https://bugs.eclipse.org/bugs/attachment.cgi?id=33204
	class PasswordFieldEditor extends StringFieldEditor {
		
		private Text textField; 
		
		private int validateStrategy = VALIDATE_ON_KEY_STROKE;	
		
		/**
	     * Creates a password field editor.
	     * 
	     * @param name the name of the preference this field editor works on
	     * @param labelText the label text of the field editor
	     * @param width the width of the text input field in characters,
	     *  or <code>UNLIMITED</code> for no limit
	     * @param strategy either <code>VALIDATE_ON_KEY_STROKE</code> to perform
	     *  on the fly checking (the default), or <code>VALIDATE_ON_FOCUS_LOST</code> to
	     *  perform validation only after the text has been typed in
	     * @param parent the parent of the field editor's control
	     */
	    public PasswordFieldEditor(String name, String labelText, int width,
	            int strategy, Composite parent) {
	        super(name, labelText, width, strategy, parent);
	    }

	    /**
	     * Creates a password field editor.
	     * 
	     * @param name the name of the preference this field editor works on
	     * @param labelText the label text of the field editor
	     * @param width the width of the text input field in characters,
	     *  or <code>UNLIMITED</code> for no limit
	     * @param parent the parent of the field editor's control
	     */
	    public PasswordFieldEditor(String name, String labelText, int width,
	            Composite parent) {
	        this(name, labelText, width, VALIDATE_ON_KEY_STROKE, parent);
	    }

	    /**
	     * Creates a password field editor of unlimited width.
	     * 
	     * @param name the name of the preference this field editor works on
	     * @param labelText the label text of the field editor
	     * @param parent the parent of the field editor's control
	     */
	    public PasswordFieldEditor(String name, String labelText, Composite parent) {
	        this(name, labelText, UNLIMITED, parent);
	    }
		
		@Override
		public Text getTextControl(Composite parent) {
			
	        if (textField == null) {
	            textField = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
	            textField.setFont(parent.getFont());
	            switch (validateStrategy) {
	            case VALIDATE_ON_KEY_STROKE:
	                textField.addKeyListener(new KeyAdapter() {

	                    /* (non-Javadoc)
	                     * @see org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt.events.KeyEvent)
	                     */
	                    public void keyReleased(KeyEvent e) {
	                        valueChanged();
	                    }
	                });

	                break;
	            case VALIDATE_ON_FOCUS_LOST:
	                textField.addKeyListener(new KeyAdapter() {
	                    public void keyPressed(KeyEvent e) {
	                        clearErrorMessage();
	                    }
	                });
	                textField.addFocusListener(new FocusAdapter() {
	                    public void focusGained(FocusEvent e) {
	                        refreshValidState();
	                    }

	                    public void focusLost(FocusEvent e) {
	                        valueChanged();
	                        clearErrorMessage();
	                    }
	                });
	                break;
	            default:
	                Assert.isTrue(false, "Unknown validate strategy");//$NON-NLS-1$
	            }
	            textField.addDisposeListener(new DisposeListener() {
	                public void widgetDisposed(DisposeEvent event) {
	                    textField = null;
	                }
	            });
                textField.setTextLimit(UNLIMITED);
	        } else {
	            checkParent(textField, parent);
	        }
	        return textField;
		}
	}
}
