/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.internal.core.ui.providers.DeployDynamicPaletteFactory;

/**
 * Context action: Discover Links
 * 
 * @author snible@us.ibm.com
 * 
 * @see DeployDynamicPaletteFactory
 */
public class BankUnitAction extends Action {

	// If a Unit is selected, should be bank Units contained by that Unit as well?
	private static final boolean INCLUDE_CONTAINED_UNITS = true;

	private IStructuredSelection selection;
	private IWorkbenchPage page;
	private final boolean fromContext;

	/**
	 * @param wbPage
	 */
	public BankUnitAction(IWorkbenchPage wbPage) {
		fromContext = true;
		page = wbPage;
		setText(Messages.BankUnitAction_Bank_Unit_s_);
	}

	/**
	 * <pre>
	 * <code>
	 * IStructuredSelection selection = new StructuredSelection(graphicalPart);
	 * or IStructuredSelection selection = new StructuredSelection(unit);
	 * DiscoverHostLinksAction action = new DiscoverHostLinksAction(selection);
	 * </code>
	 * </pre>
	 * 
	 * @param selection
	 *           the instance of structured selection
	 * @param qfEditDomain
	 *           domain (for Undo)
	 */
	public BankUnitAction(IStructuredSelection selection) {
		fromContext = false;
		this.selection = selection;
		setText(Messages.BankUnitAction_Bank_Unit_s_);
	}

	public void run() {
		if (fromContext) {
			selection = (IStructuredSelection) page.getSelection();
		}

		List<Unit> srcUnits = INCLUDE_CONTAINED_UNITS ? getSelectedUnits()
				: getDirectlySelectedUnits();

		// Nothing to bank!
		if (srcUnits.size() == 0) {
			return;
		}

		Shell parentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		//		List<Unit> copy = new LinkedList<Unit>();
		//		
		//		for (Iterator<Unit> it = srcUnits.iterator(); it.hasNext();) {
		//			Unit unit = it.next();
		//			
		//			copy.add(copyAndIsolate(unit));
		//		}

		//		List<Unit> copy = new LinkedList<Unit>(UnitUtil.duplicate(srcUnits));

		BankUnitDialog dlg = new BankUnitDialog(parentShell, srcUnits);
		if (dlg.open() == Window.OK) {
			String label = dlg.getLabel();
			String description = dlg.getDescription();
			String smallIcon = dlg.getSmallIcon();
			String largeIcon = dlg.getLargeIcon();
			String path = dlg.getPath();

			String id = generateUniqueId();
			String projectName = getProjectName();
			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			rts.addDynamicResourceType(id, path, label, description, smallIcon, largeIcon, srcUnits
					.toArray(new Unit[0]), projectName);
		}

	}

	//	/** Make this one or two core utility methods? */
	//	private Unit copyAndIsolate(Unit unit) {
	//		Unit retVal = CoreUtil.duplicate(unit);
	//		
	//		retVal.getUnitLinks().clear();
	//		
	//		for (Iterator it = retVal.getRequirements().iterator(); it.hasNext();) {
	//			Requirement req = (Requirement) it.next();
	//			req.setLink(null);
	//		}
	//		
	//		return retVal;
	//	}

	private static String getProjectName() {
		Resource res = getActiveTopologyResource();
		IFile file = resourceToFile(res);
		IProject project = file.getProject();
		return project.getName();
	}

	// TODO Refactor to a public API
	private static Resource getActiveTopologyResource() {
		Diagram dgm = ResourceUtils.getActiveDeployEditDomain().getDiagram();
		Resource res = dgm.getElement().eResource();
		return res;
	}

	// TODO Refactor to a public API
	private static IFile resourceToFile(Resource resource) {
		URI uri = resource.getURI();
		uri = resource.getResourceSet().getURIConverter().normalize(uri);
		String scheme = uri.scheme();
		if ("platform".equals(scheme) && uri.segmentCount() > 1 && //$NON-NLS-1$
				"resource".equals(uri.segment(0))) { //$NON-NLS-1$
			StringBuffer platformResourcePath = new StringBuffer();
			for (int j = 1, size = uri.segmentCount(); j < size; ++j) {
				platformResourcePath.append('/');
				platformResourcePath.append(uri.segment(j));
			} // end for

			IPath path = new Path(platformResourcePath.toString());
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		}

		return null;
	}

	private static String generateUniqueId() {
		// TODO Write a real method, or get help from service?  Slim chance of collisions.
		Random r = new Random();
		int rint = r.nextInt(99999);
		return Integer.toString(rint);
	}

	private List<Unit> getSelectedUnits() {
		List<Unit> retVal = new LinkedList<Unit>();

		if (selection instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) selection;
			for (Iterator it = ss.iterator(); it.hasNext();) {
				Object element = it.next();
				if (element instanceof DeployShapeNodeEditPart) {
					addIncludingChildren(retVal, (EditPart) element);
				}
			}
		}

		return retVal;
	}

	// recursive
	private void addIncludingChildren(List<Unit> outUnits, EditPart ep) {
		if (ep.getModel() instanceof Node) {
			Node node = (Node) ep.getModel();
			if (node.getElement() instanceof Unit) {
				Unit unit = (Unit) node.getElement();
				if (!outUnits.contains(unit)) {
					outUnits.add(unit);
				}
			}
		}

		for (EditPart epChild : (List<EditPart>) ep.getChildren()) {
			addIncludingChildren(outUnits, epChild);
		}
	}

	private List<Unit> getDirectlySelectedUnits() {
		List<Unit> retVal = new LinkedList<Unit>();

		if (selection instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) selection;
			for (Iterator it = ss.iterator(); it.hasNext();) {
				Object element = it.next();
				if (element instanceof DeployShapeNodeEditPart) {
					DeployShapeNodeEditPart epUnit = (DeployShapeNodeEditPart) element;
					//					System.out.println(epUnit.getModel());
					if (epUnit.getModel() instanceof Node) {
						Node node = (Node) epUnit.getModel();
						if (node.getElement() instanceof Unit) {
							retVal.add((Unit) node.getElement());
						}
					}
					//				} else {
					//					System.out.println(element.getClass());
				}
			}
		}
		return retVal;
	}

	/**
	 * UI
	 */
	static private class BankUnitDialog extends TrayDialog {

		private final List<Unit> units;

		private Text txtLabel;
		private Text txtDescr;

		private String label;
		private String description;
		private String path;
		private String largeIcon;
		private String smallIcon;

		private Label labelIcon;

		private Button buttonIcon;

		private final IconUrlLabelProvider iconUrlLabelProvider = new IconUrlLabelProvider();

		private String urlIconSmall = "platform:///plugin/com.ibm.ccl.soa.deploy.generic.ui/icons/pal/generic_mdl_16.gif"; //$NON-NLS-1$;
		private String urlIconLarge = "platform:///plugin/com.ibm.ccl.soa.deploy.generic.ui/icons/pal/generic_mdl_24.gif"; //$NON-NLS-1$;

		private Combo comboStack;

		private StackHelper stackHelper;

		private Image imageIcon;

		protected BankUnitDialog(Shell parentShell, List<Unit> copy) {
			super(parentShell);

			assert copy.size() > 0;

			units = copy;
		}

		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			shell.setText(Messages.BankUnitAction_Add_to_Palett_);
		}

		protected Control createDialogArea(Composite parent) {
			Composite composite = (Composite) super.createDialogArea(parent);

			addPalettEntrySection(composite);

			applyDialogFont(composite);

			return composite;
		}

		@Override
		public boolean close() {
			if (imageIcon != null) {
				imageIcon.dispose();
			}

			return super.close();
		}

		private void addPalettEntrySection(Composite parent) {
			Composite composite = new Composite(parent, SWT.NULL);
			composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			GridLayout layout = new GridLayout(2, false);
			composite.setLayout(layout);

			Label prompt1 = new Label(composite, SWT.NONE);
			prompt1.setText(Messages.BankUnitAction_Label_);

			txtLabel = new Text(composite, SWT.BORDER);
			txtLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			txtLabel.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent e) {
					txtDescr.setText(NLS.bind(Messages.BankUnitAction_Add_a_0_, txtLabel.getText()));
				}
			});

			Label promptDescr = new Label(composite, SWT.NONE);
			promptDescr.setText(Messages.BankUnitAction_Description_);

			txtDescr = new Text(composite, SWT.BORDER);
			txtDescr.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			GridData gdDescr = new GridData();
			gdDescr.widthHint = 300;
			txtDescr.setLayoutData(gdDescr);

			Label promptIcon = new Label(composite, SWT.NONE);
			promptIcon.setText(Messages.BankUnitAction_Icon_);

			Composite compIcon = new Composite(composite, SWT.NULL);
			compIcon.setLayout(new GridLayout(2, false));
			labelIcon = new Label(compIcon, SWT.NULL);

			buttonIcon = new Button(compIcon, SWT.PUSH);
			buttonIcon.setText(Messages.CreateTopologyComposite_Browse_);
			buttonIcon.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					browseForIcon();
				}
			});

			Label promptStack = new Label(composite, SWT.NONE);
			promptStack.setText(Messages.BankUnitAction_Stack_);

			Composite compStack = new Composite(composite, SWT.NULL);
			compStack.setLayout(new GridLayout(2, false));
			compStack.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

			comboStack = new Combo(compStack, SWT.BORDER | SWT.READ_ONLY);
			comboStack.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
			initStack();

			Button buttonNewStack = new Button(compStack, SWT.PUSH);
			buttonNewStack.setText(Messages.BankUnitAction_Define_new_stack_);
			buttonNewStack.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					defineNewStack();
				}
			});
		}

		private void defineNewStack() {
			InputDialog dlg = new StackCreationDialog(getShell(),
					Messages.BankUnitAction_New_Stack_Nam_, Messages.BankUnitAction_Stack_,
					Messages.BankUnitAction_newStac_, stackHelper.getPaletteStackNameValidator());
			if (dlg.open() == Window.OK) {
				String newStackName = dlg.getValue();
				String id = StackHelper.makeIdFromStackName(newStackName);
				String projectName = getProjectName();
				ExtensionsCore.createResourceTypeService().addDynamicPaletteStack(id, getDrawerId(),
						newStackName, null, projectName);

				// Refresh the combo
				initStack();

				// Select the new stack
				String newComboEntry = StackHelper.getDrawerStackNameStackLabel(newStackName);
				for (int i = 0; i < comboStack.getItems().length; i++) {
					if (comboStack.getItem(i).equals(newComboEntry)) {
						comboStack.select(i);
						break;
					}
				} // end looking for entry
			} // end user entered new stack name
		} // end method defineNewStack()

		private void browseForIcon() {
			IconSelectionDialog elsd = new IconSelectionDialog(getShell(), iconUrlLabelProvider,
					getPaletteFilteredForIconUniqueness());
			/*
			 * PlatformUI.getWorkbench().getHelpSystem().setHelp(elsd.getShell(),
			 * IDeployHelpContextIds.TOPOLOGY_EDITOR_ADD_TO_PALETTE_BROWSE_ICON);
			 */
			if (elsd.open() == Window.OK) {
				DynamicPaletteEntry dpe = (DynamicPaletteEntry) elsd.getFirstResult();
				if (dpe != null) {
					urlIconSmall = dpe.getSmallIcon();
					urlIconLarge = dpe.getLargeIcon();
					//				labelIcon.setImage(iconUrlLabelProvider.getImageForUrl(calculateLargeIcon()));
					ImageDescriptor idIcon = iconUrlLabelProvider
							.getImageDescriptor(calculateLargeIcon());
					imageIcon = idIcon.createImage();
					labelIcon.setImage(imageIcon);
				}
			}
		}

		//		private Collection<String> getIconURLs() {
		//			Set<String> ss = new HashSet<String>();
		//			DeployPaletteEntry[] entries = ResourceTypeService.INSTANCE.getAllPaletteEntries();
		//			for (int i = 0; i < entries.length; i++) {
		//				if (entries[i].getSmallIcon() != null) {
		//					ss.add(entries[i].getSmallIcon());
		//				}
		//			}
		//			
		//			return ss;
		//		}

		/** Initialize the 'stack' combo based on populating with the stacks already there */
		private void initStack() {
			stackHelper = new StackHelper();

			comboStack.removeAll();
			comboStack.add(stackHelper.getDrawerStackNameFromPaletteEntry(null));

			DynamicPaletteEntry[] adpe = stackHelper.getDynamicStackEntries();
			for (int i = 0; i < adpe.length; i++) {
				comboStack.add(stackHelper.getDrawerStackNameFromPaletteEntry(adpe[i]));
			}

			comboStack.select(0);
		}

		private DynamicPaletteEntry[] getPaletteFilteredForIconUniqueness() {
			Map<String, DynamicPaletteEntry> retVal = new HashMap<String, DynamicPaletteEntry>();

			DynamicPaletteEntry[] adpe = ExtensionsCore.createResourceTypeService()
					.getAllPaletteEntries();
			for (int i = 0; i < adpe.length; i++) {
				retVal.put(adpe[i].getLargeIcon(), adpe[i]);
			}

			return retVal.values().toArray(new DynamicPaletteEntry[0]);
		}

		protected Control createButtonBar(Composite parent) {
			Control c = super.createButtonBar(parent);

			initializeControls();

			return c;
		}

		private void initializeControls() {
			if (units.size() == 1) {
				txtLabel.setText(units.get(0).getCaptionProvider().title(units.get(0)));
				txtDescr.setText(NLS.bind(Messages.BankUnitAction_Add_a_0_, units.get(0)
						.getCaptionProvider().title(units.get(0))));
				//				txtDescr.setText("Add a " + units.get(0).title());
			} else {
				//				txtLabel.setText(units.get(0).title() + " + " + (units.size()-1)); //$NON-NLS-1$
				txtLabel.setText(NLS.bind(Messages.BankUnitAction_0_1_, units.get(0)
						.getCaptionProvider().title(units.get(0)), units.size() - 1));
				//				txtDescr.setText("Add a " + units.get(0).title() + " + " + (units.size()-1)); //$NON-NLS-1$ //$NON-NLS-2$
				txtDescr.setText(NLS.bind(Messages.BankUnitAction_Add_a_0_1_, units.get(0)
						.getCaptionProvider().title(units.get(0)), units.size() - 1));
			}

			ImageDescriptor idIcon = iconUrlLabelProvider.getImageDescriptor(calculateLargeIcon());
			imageIcon = idIcon.createImage();
			labelIcon.setImage(imageIcon);

			dialogChanged();
		}

		private void dialogChanged() {
			//			boolean matches = txtPassword.getText().equals(txtConfirm.getText());
			//			if (!matches) {
			//				updateStatus("The passwords do not match"); //$NON-NLS-1$
			//				return;
			//			}

			updateStatus(null);
		}

		private void updateStatus(String message) {
			//		    setErrorMessage(message);
			getButton(IDialogConstants.OK_ID).setEnabled(message == null);
		}

		protected void okPressed() {
			label = txtLabel.getText();
			description = txtDescr.getText();
			path = calculatePath();
			largeIcon = calculateLargeIcon();
			smallIcon = calculateSmallIcon();

			super.okPressed();
		}

		private String calculateSmallIcon() {
			return urlIconSmall;
		}

		private String calculateLargeIcon() {
			return urlIconLarge;
		}

		private String calculatePath() {
			//			System.out.println("combo = " + comboStack.getText()); //$NON-NLS-1$

			DynamicPaletteEntry dpe = stackHelper.getDrawerPaletteEntryFromName(comboStack.getText());
			if (dpe == null) {
				return getDrawerId();
			}

			return getDrawerId() + dpe.getId() + '/';
		}

		// Always hardcoded in this version
		private String getDrawerId() {
			return "/extensionDrawer/"; //$NON-NLS-1$
		}

		/**
		 * @return the user's selected palette path
		 */
		public String getPath() {
			return path;
		}

		/**
		 * @return the user's selected large icon
		 */
		public String getLargeIcon() {
			return largeIcon;
		}

		/**
		 * @return the user's selected small icon
		 */
		public String getSmallIcon() {
			return smallIcon;
		}

		/**
		 * @return the user's selected description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @return the user's selected label
		 */
		public String getLabel() {
			return label;
		}

		/**
		 * 
		 * @since 7.0
		 * 
		 */
		private class IconUrlLabelProvider extends LabelProvider {
			private final Map<String, ImageDescriptor> urlToId = new HashMap<String, ImageDescriptor>();
			private final Map<ImageDescriptor, Image> idToImage = new HashMap<ImageDescriptor, Image>();

			public Image getImage(Object object) {
//				if (object instanceof String) {
//					return getImageForUrl((String) object);
//				}

				if (object instanceof DynamicPaletteEntry) {
					DynamicPaletteEntry dpe = (DynamicPaletteEntry) object;
					return getImageForUrl(dpe.getLargeIcon());
				}

				return null;
			}

			public String getText(Object object) {
//				return txtLabel.getText();
				// Just icons, no text
				return ""; //$NON-NLS-1$
			}

			private Image getImageForUrl(String url) {
				ImageDescriptor id = getImageDescriptor(url);
				return getImageFromDescriptor(id);
			}

			private Image getImageFromDescriptor(ImageDescriptor id) {
				if (id == null) {
					return null;
				}

				Image retVal = idToImage.get(id);
				if (retVal == null) {
					retVal = id.createImage();
					idToImage.put(id, retVal);
				}

				return retVal;
			}

			private ImageDescriptor getImageDescriptor(String url) {
				ImageDescriptor retVal = urlToId.get(url);
				if (retVal == null) {
					retVal = getIconDescriptor(url);
					urlToId.put(url, retVal);
				}

				return retVal;
			}

			private ImageDescriptor getIconDescriptor(String iconpath) {
				//				Bundle bundle = Platform.getBundle(symbolicName);
				//				URL url = FileLocator.find(bundle, path, null);
				URL url;
				try {
					url = new URL(iconpath);
					url = FileLocator.resolve(url);
				} catch (MalformedURLException e) {
					return null;
				} catch (IOException e) {
					return null;
				}
				return ImageDescriptor.createFromURL(url);
			}

			@Override
			public void dispose() {
				for (Image image : idToImage.values()) {
					image.dispose();
				}

				idToImage.clear();

				super.dispose();
			}

		} // end inner class IconUrlLabelProvider

		private static class StackCreationDialog extends InputDialog {

			private StackCreationDialog(Shell parentShell, String dialogTitle, String dialogMessage,
					String initialValue, IInputValidator validator) {
				super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
			}

			protected Control createDialogArea(Composite parent) {
				PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
						IDeployHelpContextIds.TOPOLOGY_EDITOR_ADD_TO_PALETTE_DEFINE_NEW_STACK);
				return super.createDialogArea(parent);
			}

		}

		private static class IconSelectionDialog extends TrayDialog {

			private static final int MAX_COLUMNS = 8;

			private final ILabelProvider renderer;

			private TableViewer tv;

			private final Object[] adpe;

			private DynamicPaletteEntry result;

			private TableCursor cursor;

			private IconSelectionDialog(Shell parent, ILabelProvider rend, Object[] acontent) {
				super(parent);

				renderer = rend;
				adpe = acontent;
			}

			protected void configureShell(Shell shell) {
				super.configureShell(shell);
				shell.setText(Messages.BankUnitAction_Select_Ico_);
			}

			protected Control createButtonBar(Composite parent) {
				Control c = super.createButtonBar(parent);

				getButton(IDialogConstants.OK_ID).setEnabled(getSelectedIcon() != null);

				return c;
			}

			private DynamicPaletteEntry getSelectedIcon() {
				if (tv.getSelection() instanceof StructuredSelection) {
					StructuredSelection ss = (StructuredSelection) tv.getSelection();
					Object res = ss.getFirstElement();
					if (res instanceof List) {
						List<?> l = (List<?>) res;
						if (l.size() > cursor.getColumn()) {
							return (DynamicPaletteEntry) l.get(cursor.getColumn());
						}
					}
				}

				return null;
			}

			/**
			 * @return an object of the type originally passed to constructor
			 */
			public Object getFirstResult() {
				return result;
			}

			private List<List<Object>> chunk(Object[] adpe2) {
				List<List<Object>> retVal = new LinkedList<List<Object>>();
				List<Object> lrow = null;
				for (int i = 0; i < adpe2.length; i++) {
					int row = i / MAX_COLUMNS;
					if (retVal.size() <= row) {
						lrow = new ArrayList<Object>();
						retVal.add(lrow);
					}
					lrow.add(adpe2[i]);
				}

				return retVal;
			}

			protected Control createDialogArea(Composite parent) {
				Composite contents = (Composite) super.createDialogArea(parent);

				PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
						IDeployHelpContextIds.TOPOLOGY_EDITOR_ADD_TO_PALETTE_BROWSE_ICON);

				final Table table = new Table(contents, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);

				for (int i = 0; i < MAX_COLUMNS; i++) {
					TableColumn tc = new TableColumn(table, SWT.CENTER);
					tc.setWidth(32);
					tc.setResizable(false);
				}

				cursor = new TableCursor(table, SWT.NONE);
				cursor.addSelectionListener(new SelectionListener() {
					// when the TableEditor is over a cell, select the corresponding row in 
					// the table
					public void widgetSelected(SelectionEvent e) {
						table.setSelection(new TableItem[] { cursor.getRow() });
						getButton(IDialogConstants.OK_ID).setEnabled(getSelectedIcon() != null);
					}

					public void widgetDefaultSelected(SelectionEvent e) {
						okPressed();
					}

				});

				cursor.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent e) {
						okPressed();
					}
				});

				table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

				tv = new TableViewer(table);
				tv.setContentProvider(new IconContentProvider());
				tv.setLabelProvider(new IconLabelProvider(renderer));
				tv.setInput(chunk(adpe));

				cursor.setSelection(0, 0);
				table.setSelection(new TableItem[] { cursor.getRow() });

				return contents;
			}

			@Override
			protected void okPressed() {
				result = getSelectedIcon();
				if (result != null) {
					super.okPressed();
				}
			}

			private static class IconContentProvider implements IStructuredContentProvider {

				public Object[] getElements(Object inputElement) {
					if (inputElement instanceof Collection) {
						Collection<?> c = (Collection<?>) inputElement;
						return c.toArray();
					}
					return null;
				}

				public void dispose() {
					// do nothing
				}

				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
					// do nothing
				}

			}

			private static class IconLabelProvider extends LabelProvider implements
					ITableLabelProvider {

				private final ILabelProvider baseLabelProvider;

				private IconLabelProvider(ILabelProvider labelProvider) {
					baseLabelProvider = labelProvider;
				}

				public Image getColumnImage(Object element, int columnIndex) {
					if (element instanceof List) {
						List<?> l = (List<?>) element;
						if (l.size() > columnIndex) {
							Object nth = l.get(columnIndex);
							return baseLabelProvider.getImage(nth);
						}
					}

					return null;
				}

				public String getColumnText(Object element, int columnIndex) {
					return ""; //$NON-NLS-1$
				}

			}
		}

	} // end private inner class BankUnitDialog

	/**
	 * Knows about dynamic palette entry rules and names
	 */
	public static class StackHelper {

		/**
		 * Map from drawer/stack name to corresponding palette stack entry, or null for directly under
		 * Local Additions
		 */
		private final HashMap<String, DynamicPaletteEntry> stackMap;

		private final LinkedList<String> idsInUse;

		/**
		 * 
		 */
		public StackHelper() {
			stackMap = new HashMap<String, DynamicPaletteEntry>();
			idsInUse = new LinkedList<String>();

			DynamicPaletteEntry adpe[] = getDynamicStackEntries();
			for (int i = 0; i < adpe.length; i++) {
				idsInUse.add(adpe[i].getId());
			}
		}

		/**
		 * @return palette entries known to Resource Type Service
		 */
		private DynamicPaletteEntry[] getDynamicStackEntries() {
			return ExtensionsCore.createResourceTypeService().getDynamicStackEntries();
		}

		/**
		 * @return validator with rules for new palette entry names
		 */
		public IInputValidator getPaletteStackNameValidator() {
			return new IInputValidator() {

				public String isValid(String newText) {
					String proposedName = getDrawerStackNameStackLabel(newText);
					String proposedId = makeIdFromStackName(newText);
					if (stackMap.containsKey(proposedName) || duplicateStackId(proposedId)) {
						return Messages.BankUnitAction_Duplicate_Stack_Nam_;
					}

					if (proposedId == null || newText.length() == 0) {
						return Messages.BankUnitAction_Unsupported_characte_;
					}

					return null;
				}
			};
		}

		private boolean duplicateStackId(String proposedId) {
			return idsInUse.contains(proposedId);
		}

		public static String getDrawerStackNameStackLabel(String stackLabel) {
			String drawer = Messages.DeployCoreEditor_Local_Extension_;
			String name = NLS.bind(Messages.BankUnitAction_0_1__2, drawer, stackLabel);
			return name;
		}

		public static String makeIdFromStackName(String newText) {
			// TODO Move this method to ResourceTypeService; it knows better what characters are legal.
			// For example, are spaces legal?  I don't know....

			// We could be clever here, and handle forbidden characters by mapping to non-forbidden ones
			// in a reversible way, but instead we just ban anything that isn't already a valid palette ID
			if (newText.indexOf('/') >= 0) {
				return null;
			}

			return newText;
		}

		private String getDrawerStackNameFromPaletteEntry(DynamicPaletteEntry stackPaletteEntry) {
			String drawer = Messages.DeployCoreEditor_Local_Extension_;
			String name = drawer;
			if (stackPaletteEntry == null) {
				name = Messages.DeployCoreEditor_Local_Extension_;
			} else {
				name = StackHelper.getDrawerStackNameStackLabel(stackPaletteEntry.getLabel());
			}

			stackMap.put(name, stackPaletteEntry);
			return name;
		}

		private DynamicPaletteEntry getDrawerPaletteEntryFromName(String name) {
			return stackMap.get(name);
		}

	} // end public inner class StackHelper

} // end class BankUnitAction
