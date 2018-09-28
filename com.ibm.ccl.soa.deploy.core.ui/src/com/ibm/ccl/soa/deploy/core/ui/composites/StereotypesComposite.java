/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.composites;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * UI for managing the {@link Stereotype}s on a {@link Unit} or {@link Capability}.
 * 
 * <p>
 * The UI includes some radio buttons and a tree or list.
 * 
 * LineItem 4881 UX Item 5327
 */
public class StereotypesComposite extends ModifiedSectionComposite {

	private static final String NAME_COL = "Stereotype"; //$NON-NLS-1$
	private static final String PROF_COL = "Profile"; //$NON-NLS-1$
	private static final String REQ_COL = "Required"; //$NON-NLS-1$
	private static final String[] COLUMN_NAMES = new String[] { NAME_COL, PROF_COL, REQ_COL };

	private static final String[] falseTrue = { Messages.StereotypesComposite_Fals_,
			Messages.StereotypesComposite_Tru_ };

	private IAction deleteAction;
	private IAction addAction;

	private TableViewer viewer;

	protected Stereotype newStereotype;

	private final List<Listener> stereotypeChangeListeners = new LinkedList<Listener>();

	private class StereoTypeListener extends ModelListener {
		@Override
		public void notifyChanged(final Notification msg) {
			// We want to filter out notifications that don't change table values,
			// to prevent flicker during, for example, validation.

			// Change whenever a Stereotype is added/removed.

			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					safeNotify(msg);

				}
			});

		}

		private void safeNotify(Notification msg) {
			if (msg.getNotifier() instanceof Stereotype) {
				safeRefresh(msg.getNotifier());
			} else if (msg.getNewValue() instanceof Stereotype) {
				adaptTarget((Stereotype) msg.getNewValue());
				safeRefresh(null);
			} else if (msg.getOldValue() instanceof Stereotype) {
				removeTarget((Stereotype) msg.getOldValue());
				safeRefresh(null);
			}
		}

		private void safeRefresh(final Object element) {
			if (!viewer.getTable().isDisposed()) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						if (isDisposed()) {
							return;
						}
						if (!viewer.getTable().isDisposed()) {
							if (element == null) {
								viewer.refresh();
							} else {
								viewer.refresh(element);
							}
						}

						if (newStereotype != null) {
							if (!viewer.getTable().isDisposed()) {
								StructuredSelection ss = new StructuredSelection(newStereotype);
								viewer.setSelection(ss, true);
							}

							newStereotype = null;
						}

						if (!isDisposed()) {
							enableDisableControls();
						}

						notifyStereotypeListeners();
					}

				});
			}
		}

		/**
		 * Handles installation of the adapter on an EObject by adding the adapter to each of the
		 * directly contained objects.
		 */
		@SuppressWarnings("unchecked")
		protected void setTarget(EObject aTarget) {
			basicSetTarget(aTarget);
			List<Stereotype> stereotypes = null;
			if (aTarget instanceof Capability) {
				stereotypes = ((Capability) aTarget).getStereotypes();
			} else if (aTarget instanceof Unit) {
				stereotypes = ((Unit) aTarget).getStereotypes();
			}
			if (stereotypes != null) {
				adaptChildren(stereotypes);
			}
		}

		private void adaptChildren(List<Stereotype> stereotypes) {
			if (!stereotypes.isEmpty()) {
				Iterator<Stereotype> it = stereotypes.iterator();
				while (it.hasNext()) {
					addAdapter(it.next());
				}
			}
		}
	};

	/**
	 * @param parent
	 * @param style
	 * @param deployModelObject
	 * @param ft
	 */
	public StereotypesComposite(Composite parent, int style, DeployModelObject deployModelObject,
			FormToolkit ft) {
		super(parent, style, deployModelObject, ft);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_STEREOTYPE_COMPOSITE);

		this.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});

	}

	/**
	 * @param newDmo
	 */
	public void setInput(DeployModelObject newDmo) {
		super.setInput(newDmo);
		viewer.setInput(dmo);
		enableDisableControls();
		notifyStereotypeListeners();
	}

	private void createTable() {
		KeyListener keyListener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.DEL && e.stateMask == 0) {
					deleteStereotype();
				}
			}
		};

		SelectionListener selectionListener = new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				enableDisableControls();
			}
		};
		Table table = formToolkit.createTable(this, SWT.MULTI | SWT.FULL_SELECTION);

		table.addSelectionListener(selectionListener);
		table.addKeyListener(keyListener);

		TableLayout tlAttribs = new TableLayout();
		tlAttribs.addColumnData(new ColumnWeightData(50)); // stereotype
		tlAttribs.addColumnData(new ColumnWeightData(30)); // profile
		tlAttribs.addColumnData(new ColumnWeightData(30)); // required
		table.setLayout(tlAttribs);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		String[] colHeadersAttrib = new String[] { Messages.StereotypesComposite_Stereotyp_,
				Messages.StereotypesComposite_Profil_, Messages.StereotypesComposite_Require_ };
		for (int i = 0; i < colHeadersAttrib.length; i++) {
			TableColumn col = new TableColumn(table, SWT.LEFT);
			col.setText(colHeadersAttrib[i]);
			col.setWidth(115);
		}

		viewer = new TableViewer(table);
		viewer.setContentProvider(new StereotypeTableProvider());
		viewer.setLabelProvider(new StereotypeLabelProvider());

		GridData tableGD = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableGD.minimumHeight = 85;
		table.setLayoutData(tableGD);

		attachCellEditors();
	}

	private void attachCellEditors() {
		// Assign 'names' to each column
		viewer.setColumnProperties(COLUMN_NAMES);

		Table table = viewer.getTable();
		viewer.setCellEditors(new CellEditor[] {
		// Stereotype
				new TextCellEditor(table, SWT.LEFT),
				// Profile
				new TextCellEditor(table, SWT.LEFT),
				// Required
				new ComboBoxCellEditor(table, falseTrue, SWT.READ_ONLY) });

		viewer.setCellModifier(new StereotypeValueModifier());
	}

	protected void enableDisableControls() {
		List<Stereotype> stereotypes = getSelectedStereotypes();
//		Stereotype first = stereotypes != null && stereotypes.size() > 0 ? stereotypes.get(0) : null;

		addAction.setEnabled(isMutable());
		boolean selected = stereotypes != null && stereotypes.size() > 0;
		deleteAction.setEnabled(isMutable() && selected);
	}

	private List<Stereotype> getSelectedStereotypes() {
		if (!viewer.getTable().isDisposed()) {
			return getSelectedStereotypes(viewer);
		}

		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	private List<Stereotype> getSelectedStereotypes(ISelectionProvider isp) {
		if (isp.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) isp.getSelection();
			if (ss.getFirstElement() instanceof Stereotype) {
				return ss.toList();
			}
		}

		return null;
	}

	protected void deleteStereotype() {
		PropertyUtils.deleteFromModel(getSelectedStereotypes(), dmo,
				Messages.StereotypesComposite_Delete_stereotype_s_);
	}

	protected void addStereotype() {
		String msg = Messages.StereotypesComposite_Add_stereotyp_;
		PropertyUtils.executeWithUndo(dmo, msg, new Runnable() {

			public void run() {
				newStereotype = CoreFactory.eINSTANCE.createStereotype();
				newStereotype.setKeyword(Messages.StereotypesComposite_newKeywor_);
				newStereotype.setProfile(Messages.StereotypesComposite_newProfil_);
				addStereotype(newStereotype);
			}
		});
	}

	protected void addStereotype(Stereotype newStereotype) {
		if (dmo instanceof Unit) {
			((Unit) dmo).getStereotypes().add(newStereotype);
		} else if (dmo instanceof Capability) {
			((Capability) dmo).getStereotypes().add(newStereotype);
		} else {
			throw new IllegalStateException();
		}
	}

	private void notifyStereotypeListeners() {
		if (stereotypeChangeListeners != null && !stereotypeChangeListeners.isEmpty()) {
			// Make a fake event.
			Event event = new Event();
			event.widget = this; // if widget is null the CCombo handleEvent() gets confused...

			for (Listener listener : stereotypeChangeListeners) {
				listener.handleEvent(event);
			}
		}
	}

	/**
	 * Called when the list of constraints changes
	 * 
	 * @param listener
	 */
	public void addStereotypeChangeListener(Listener listener) {
		stereotypeChangeListeners.add(listener);
	}

	private static String safeGet(String s) {
		return s != null ? s : ""; //$NON-NLS-1$
	}

	private static class StereotypeTableProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Unit) {
				Unit unit = (Unit) inputElement;
				return unit.getStereotypes().toArray();
			} else if (inputElement instanceof Capability) {
				Capability cap = (Capability) inputElement;
				return cap.getStereotypes().toArray();
			}

			return new Object[0];
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	}

	private class StereotypeLabelProvider extends LabelProvider implements ITableLabelProvider {

		private StereotypeLabelProvider() {
			// does nothing
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Stereotype) {
				Stereotype stereotype = (Stereotype) element;

				if (columnIndex == 0) {
					return safeGet(stereotype.getKeyword());
				} else if (columnIndex == 1) {
					return safeGet(stereotype.getProfile());
				} else if (columnIndex == 2) {
					return stereotype.isRequired() ? Messages.StereotypesComposite_Tru_
							: Messages.StereotypesComposite_Fals_;
				}
			}

			return element.toString();
		}

	} // end inner class StereotypeLabelProvider

	private class StereotypeValueModifier implements ICellModifier {

		public boolean canModify(Object element, String property) {
			return isMutable();
		}

		public Object getValue(Object element, String property) {
			// Note that it is possible for an SWT Item to be passed instead of the model element.
			if (element instanceof Item) {
				element = ((Item) element).getData();
			}

			if (element instanceof Stereotype) {
				Stereotype stereotype = (Stereotype) element;

				if (property.equals(NAME_COL)) {
					return safeGet(stereotype.getKeyword());
				} else if (property.equals(PROF_COL)) {
					return safeGet(stereotype.getProfile());
				} else if (property.equals(REQ_COL)) {
					return stereotype.isRequired() ? 1 : 0;
				}
			}

			return null;
		}

		public void modify(Object element, final String property, final Object value) {
			// Note that it is possible for an SWT Item to be passed instead of the model element.
			if (element instanceof Item) {
				element = ((Item) element).getData();
			}

			if (element instanceof Stereotype) {
				final Stereotype stereotype = (Stereotype) element;

				String msg = Messages.StereotypesComposite_Edit_stereotyp_;
				PropertyUtils.executeWithUndo(dmo, msg, new Runnable() {

					public void run() {
						if (property.equals(NAME_COL)) {
							stereotype.setKeyword((String) value);
						} else if (property.equals(PROF_COL)) {
							stereotype.setProfile((String) value);
						} else if (property.equals(REQ_COL)) {
							Integer i = (Integer) value;
							stereotype.setRequired(i.intValue() == 0 ? false : true);
						}
					}
				});
			}

		}

	} // end inner class StereotypeValueModifier

	@Override
	protected ModelListener createModelListener() {
		return new StereoTypeListener();
	}

	@Override
	protected void createToolbarTitleControls(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.StereotypesComposite_Stereotype_);
		label.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
				ISharedFonts.FIG_CATEGORY));
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	@Override
	protected void initializeBody() {
		createTable();
	}

	@Override
	protected void initializeToolBar(ToolBarManager toolbarMgr) {
		//Add action
		addAction = new Action(null, IAction.AS_UNSPECIFIED) {
			@Override
			public void run() {
				addStereotype();
			}
		};

		addAction.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ADD));
		addAction.setToolTipText(Messages.StereotypesComposite_Add_new_stereotyp_);
		toolbarMgr.add(addAction);

		//Delete action
		deleteAction = new Action(null, IAction.AS_UNSPECIFIED) {
			@Override
			public void run() {
				deleteStereotype();
			}
		};
		deleteAction.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_DELETE));
		deleteAction.setToolTipText(Messages.StereotypesComposite_Remove_stereotyp_);
		toolbarMgr.add(deleteAction);
	}
} // end class StereotypesComposite
