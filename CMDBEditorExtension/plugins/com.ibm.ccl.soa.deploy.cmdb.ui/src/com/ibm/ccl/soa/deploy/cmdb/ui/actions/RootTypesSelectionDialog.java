package com.ibm.ccl.soa.deploy.cmdb.ui.actions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.topology.app.db.db2.Db2Instance;
import com.collation.platform.model.topology.app.j2ee.websphere.WebSphereCluster;
import com.collation.platform.model.topology.app.j2ee.websphere.WebSphereServer;
import com.collation.platform.model.topology.meta.ObjectClass;
import com.collation.platform.model.topology.sys.ComputerSystem;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbToTdmConversionUtils;
import com.ibm.ccl.soa.deploy.cmdb.ui.CmdbUIPlugin;
import com.ibm.ccl.soa.deploy.cmdb.ui.ICmdbUIHelpContextIds;
import com.ibm.ccl.soa.deploy.cmdb.ui.Messages;

/**
 * @author barnold
 * 
 */
public class RootTypesSelectionDialog extends TrayDialog {

	private CheckboxTreeViewer tv;

	private static final String commaDelimiter = ",\\s*"; //$NON-NLS-1$

	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private static final String checkableTypesDefault = "com.collation.platform.model.topology.sys.ComputerSystem, " + //$NON-NLS-1$ 
			"com.collation.platform.model.topology.app.AppServer, " + //$NON-NLS-1$
			"com.collation.platform.model.topology.app.SoftwareModule" //$NON-NLS-1$
	;

	/**
	 * Default value for the types that are checked.
	 */
	private static final String DEFAULT_CHECKED_TYPES = ComputerSystem.class.getName() //$NON-NLS-1$
		+ "," + Db2Instance.class.getName()
		+ "," + WebSphereCluster.class.getName()
		+ "," + WebSphereServer.class.getName()
		;

	protected RootTypesSelectionDialog(Shell parentShell) {
		super(parentShell);
		IPreferenceStore ips = CmdbUIPlugin.getDefault().getPreferenceStore();
		String commaDelimitedCheckableTypes = ips.getString(RootTypesSelectionAction.ccmdbExplorerCheckableRootTypes);
		if (commaDelimitedCheckableTypes.length() == 0) {
			ips.setValue(RootTypesSelectionAction.ccmdbExplorerCheckableRootTypes, checkableTypesDefault);
			commaDelimitedCheckableTypes = checkableTypesDefault;
		}

		// Checked types default is first item in checkable types default list
		String commaDelimitedCheckedTypes = ips.getString(RootTypesSelectionAction.ccmdbExplorerRootTypes);
		if (commaDelimitedCheckedTypes.length() == 0) {
			String defaultType = getCheckedTypesDefault();
			if (defaultType != null) {
				ips.setValue(RootTypesSelectionAction.ccmdbExplorerRootTypes, defaultType);
			}
		}
	}

	/**
	 * @return default single type for ccmdb explorer root
	 */
	public static String getCheckedTypesDefault() {
		List<String> checkableTypesDefaultList = parseCommaDelimitedListAsArray(checkableTypesDefault);
		if (checkableTypesDefaultList.size() > 0) {
			return checkableTypesDefaultList.get(0);
		}
		return EMPTY_STRING;
	}

	/**
	 * @param cdl
	 *            comma-delimited string
	 * @return List of non-zero-length elements in found in parameter
	 */
	public static List<String> parseCommaDelimitedListAsArray(String cdl) {
		List<String> retVal = new ArrayList<String>();
		String types[] = cdl.split(commaDelimiter);
		for (int i = 0; i < types.length; ++i) {
			if (types[i].length() > 0) {
				retVal.add(types[i]);
			}
		}

		return retVal;
	}

	/**
	 * Return comma delimited string of types names
	 * 
	 * @return comma-delimited string of CDM types to use as CCMDB explorer
	 *         roots
	 */
	public String getCheckedTypeStrings() {
		IPreferenceStore ips = CmdbUIPlugin.getDefault().getPreferenceStore();
		String commaDelimitedCheckedTypes = ips.getString(RootTypesSelectionAction.ccmdbExplorerRootTypes);
		return commaDelimitedCheckedTypes;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.RootTypesSelectionDialog_SelectRootTypesForExplorer);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				ICmdbUIHelpContextIds.RootTypesSelectionDialog_HelpContextID);
		Composite composite = (Composite) super.createDialogArea(parent);

		addSelectedTypesSection(composite);

		applyDialogFont(composite);

		return composite;
	}

	@Override
	public boolean close() {
		return super.close();
	}

	private void addSelectedTypesSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);

		Tree tree = new Tree(composite, SWT.BORDER | SWT.CHECK);
		tv = new CheckboxTreeViewer(tree);
		tv.setContentProvider(new CmdbCheckableTypesProvider());
		tv.setLabelProvider(new CmdbRootTypesLabelProvider());

		tv.setInput(this);
		tv.setCheckedElements(getSelectedRootTypes().toArray());

		Button buttonIcon = new Button(composite, SWT.PUSH);
		buttonIcon.setText(Messages.RootTypesSelectionDialog_AddNewCDMType);
		buttonIcon.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				browseForCDMType();
			}
		});
	}

	protected void browseForCDMType() {
		FindCDMTypeDialog fcdmtd = new FindCDMTypeDialog(getShell(), Messages.RootTypesSelectionDialog_FindNewCDMTypes);
		List<ObjectClass> prunedMetadata = CmdbToTdmConversionUtils.managedSystemElementMetadata();

		fcdmtd.setElements(prunedMetadata.toArray());
		if (fcdmtd.open() == Window.OK) {
			Object typeMetadata = fcdmtd.getFirstResult();
			assert typeMetadata instanceof ObjectClass;
//			this.preLoadCMDBCache(new ObjectClass[] { (ObjectClass)typeMetadata} );
			addNewCDMTypeToPreferences((ObjectClass) typeMetadata);
			tv.refresh();
		}
	}

	@Override
	protected void okPressed() {

		Object checkedElements[] = tv.getCheckedElements();
		List<ObjectClass> ocList = new ArrayList<ObjectClass>();
		String commaDelimitedCheckedTypes = EMPTY_STRING;
		for (int i = 0; i < checkedElements.length; ++i) {
			assert (checkedElements[i] instanceof ObjectClass);
			ObjectClass oc = (ObjectClass) checkedElements[i];
			ocList.add(oc);
			String typeName = EMPTY_STRING;
			try {
				typeName = oc.getName();
			} catch (AttributeNotSetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (typeName.length() > 0) {
				if (commaDelimitedCheckedTypes.length() > 0) {
					commaDelimitedCheckedTypes += ", "; //$NON-NLS-1$
				}
				commaDelimitedCheckedTypes += typeName;
			}
		}
		IPreferenceStore ips = CmdbUIPlugin.getDefault().getPreferenceStore();
//		if (ips.getBoolean(IDeployCmdbPreferences.CMDB_ENABLE_NAVIGATOR_PREFETCHER)) {
//			preLoadCMDBCache(ocList.toArray(new ObjectClass[ocList.size()]));
//		}
		ips.setValue(RootTypesSelectionAction.ccmdbExplorerRootTypes, commaDelimitedCheckedTypes);
		super.okPressed();
	}

	private class CmdbCheckableTypesProvider implements ITreeContentProvider {

		private final Object[] NO_CHILDREN = new Object[0];

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof RootTypesSelectionDialog) {
				return getCheckableTypeObjectClasses().toArray();
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

	private static class CmdbRootTypesLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof ObjectClass) {

				try {
// String longName = ((ObjectClass) element).getName();
// return RootTypesSelectionDialog.shortClassName(longName);
					return ((ObjectClass) element).getDisplayString();
				} catch (AttributeNotSetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return element == null ? "<null>" : element.getClass().getName();//$NON-NLS-1$
		}

	}

	/**
	 * @return a list of type names that are checked by default.
	 */
	public static List<String> getDefaultCheckedTypeNames() {
		return parseCommaDelimitedListAsArray(DEFAULT_CHECKED_TYPES);
	}
	
	/**
	 * @return List of CDM type names presented in dialog, from preferences
	 */
	public List<String> getCheckedTypeNames() {
		IPreferenceStore ips = CmdbUIPlugin.getDefault().getPreferenceStore();
		String commaDelimitedCheckedTypes = ips.getString(RootTypesSelectionAction.ccmdbExplorerCheckableRootTypes);
		if ((commaDelimitedCheckedTypes == null) || (commaDelimitedCheckedTypes.length() == 0)) {
			return getDefaultCheckedTypeNames();
		}
		return parseCommaDelimitedListAsArray(commaDelimitedCheckedTypes);
	}

	/**
	 * @return List of CDM type names presented in dialog, from preferences
	 */
	public List<String> getCheckableTypeNames() {
		IPreferenceStore ips = CmdbUIPlugin.getDefault().getPreferenceStore();
		String commaDelimitedCheckableTypes = ips.getString(RootTypesSelectionAction.ccmdbExplorerCheckableRootTypes);
		return parseCommaDelimitedListAsArray(commaDelimitedCheckableTypes);
	}

	/**
	 * @return List of objectClass objects for the types checkable in the dialog
	 */
	public List<ObjectClass> getCheckableTypeObjectClasses() {
		List<String> checkableTypeStrings = getCheckableTypeNames();
		List<ObjectClass> retVal = new LinkedList<ObjectClass>();
		for (String typeString : checkableTypeStrings) {
			retVal.add(CmdbQueryService.INSTANCE.getMetaData(typeString));
		}
		return retVal;
	}

	private void addNewCDMTypeToPreferences(ObjectClass oc) {
		String newCDMType = EMPTY_STRING;
		try {
			newCDMType = oc.getName();
		} catch (AttributeNotSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IPreferenceStore ips = CmdbUIPlugin.getDefault().getPreferenceStore();
		String commaDelimitedCheckableTypes = ips.getString(RootTypesSelectionAction.ccmdbExplorerCheckableRootTypes);
		List<String> typesAsList = parseCommaDelimitedListAsArray(commaDelimitedCheckableTypes);
		if (!typesAsList.contains(newCDMType)) {
			typesAsList.add(newCDMType);
		}
		commaDelimitedCheckableTypes = arrayToCommaDelimitedList(typesAsList);
		ips.setValue(RootTypesSelectionAction.ccmdbExplorerCheckableRootTypes, commaDelimitedCheckableTypes);
	}

	private String arrayToCommaDelimitedList(List<String> typesAsList) {
		String commaDelimitedTypes = EMPTY_STRING;
		for (String typeName : typesAsList) {
			if (commaDelimitedTypes.length() > 0) {
				commaDelimitedTypes += ", "; //$NON-NLS-1$
			}
			commaDelimitedTypes += typeName;
		}
		return commaDelimitedTypes;
	}

// private List<String> getSelectedRootTypes() {
	private List<ObjectClass> getSelectedRootTypes() {

// List<String> qtList = CmdbTreeViewUtils.queryableCDMTypes();

		List<ObjectClass> retVal = new ArrayList<ObjectClass>();
		IPreferenceStore ips = CmdbUIPlugin.getDefault().getPreferenceStore();
		String commaDelimitedCheckedTypes = ips.getString(RootTypesSelectionAction.ccmdbExplorerRootTypes);
		String commaDelimitedCheckableTypes = ips.getString(RootTypesSelectionAction.ccmdbExplorerCheckableRootTypes);
		List<String> checkableTypesList = parseCommaDelimitedListAsArray(commaDelimitedCheckableTypes);
		if (commaDelimitedCheckedTypes != null) {
			String types[] = commaDelimitedCheckedTypes.split(commaDelimiter);
			for (int i = 0; i < types.length; ++i) {
				if (types[i].length() > 0) {
					if (checkableTypesList.contains(types[i])) {
						ObjectClass typeOC = CmdbQueryService.INSTANCE.getMetaData(types[i]);
						retVal.add(typeOC);
					}
				}
			}
		}
		return retVal;
	}
	
//	private void preLoadCMDBCache(final ObjectClass ocArray[]) {
//		Runnable runnable = new Runnable() {
//
//			public void run() {
//				try {
//					List<List<ModelObject>> moListsForTypes = new ArrayList<List<ModelObject>>();
//					for (int i=0; i<ocArray.length; ++i) {
//						ObjectClass oc = ocArray[i];
//						String typeName = oc.getName();
//						List<ModelObject> moList = CmdbQueryService.INSTANCE.getModelObjectsOfType(typeName);
//						moListsForTypes.add(moList);
//						Thread.sleep(100);
//					}
//					List<ModelObject> allTargetingMOs = new ArrayList<ModelObject>();
//					for (List<ModelObject> moList : moListsForTypes) {
//						for (ModelObject mo : moList) {
//							mo = CmdbQueryService.INSTANCE.deStubify(mo);
//							List<ModelObject> targetingMOs = CmdbQueryService.INSTANCE.getTargetingModelObjects(mo);
//							allTargetingMOs.addAll(targetingMOs);
//							Thread.sleep(10);
//						}
//						Thread.sleep(100);
//					}
//					List<ModelObject> allChildMOs = new ArrayList<ModelObject>();
//					for (List<ModelObject> moList : moListsForTypes) {
//						for (ModelObject mo : moList) {
//							mo = CmdbQueryService.INSTANCE.deStubify(mo);
//							List<ModelObject> childMOs = CmdbQueryService.INSTANCE.getChildModelObjects(mo);
//							allChildMOs.addAll(childMOs);
//							Thread.sleep(10);
//						}
//						Thread.sleep(100);
//					}
//					for (ModelObject targetingMO : allTargetingMOs) {
//						targetingMO = CmdbQueryService.INSTANCE.deStubify(targetingMO);
//						Thread.sleep(10);
//					}
//					for (ModelObject childMO : allChildMOs) {
//						childMO = CmdbQueryService.INSTANCE.deStubify(childMO);
//						Thread.sleep(10);
//					}
//					this.getClass();
//				} catch (AttributeNotSetException anse) {
//					// TODO Auto-generated catch block
//					anse.printStackTrace();
//				} catch (InterruptedException ie) {
//					ie.printStackTrace();
//				}
//			}
//		};
//		if (ocArray == null) {
//			return;
//		}
//		Thread cachePreloadThread = new Thread(runnable);
//		cachePreloadThread.setName("CMDB cache preload"); //$NON-NLS-1$
////		cachePreloadThread.setPriority(Thread.MIN_PRIORITY);
//		cachePreloadThread.setPriority(cachePreloadThread.getPriority()-1);
//		cachePreloadThread.start();
//	}
} // end class RootTypesSelectionDialog

