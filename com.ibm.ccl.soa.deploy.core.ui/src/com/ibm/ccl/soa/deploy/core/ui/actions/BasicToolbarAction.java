package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowPulldownDelegate;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

/**
 * A common base type for toolbar actions.
 * 
 * @since 7.0
 * 
 */
public abstract class BasicToolbarAction extends Action implements IMenuCreator,
		IWorkbenchWindowPulldownDelegate, IActionDelegate2 {

	private IWorkbenchWindow window = null;
	private Menu menu = null;
	private IAction lastExecutedAction = null;
	private final IAction disabled;

	private boolean rebuildEachTime = false;
	private final boolean rememberLastSelection = false;

	public BasicToolbarAction(String defaultText, ImageDescriptor defaultImage,
			ImageDescriptor disabledImage) {
		this(defaultText, defaultImage, disabledImage, false /* rebuild each time */, true /*
		 * remember
		 * last
		 */);
	}

	public BasicToolbarAction(String defaultText, ImageDescriptor defaultImage,
			ImageDescriptor disabledImage, boolean rebuildEachTime, boolean rememberLastSelection) {
		super(defaultText, IAction.AS_DROP_DOWN_MENU);
		setText(defaultText);
		setImageDescriptor(defaultImage);
		setDisabledImageDescriptor(disabledImage);
		setEnabled(false);
		setMenuCreator(this);
		this.rebuildEachTime = rebuildEachTime;

		disabled = createDisabledImage(disabledImage);
	}

	public static IAction createDisabledImage(ImageDescriptor disabledImage) {
		IAction action = new Action(Messages.BasicToolbarAction_None_availabl_, disabledImage) {
		};
		action.setImageDescriptor(disabledImage);
		action.setEnabled(false);
		return action;
	}

	public Menu getMenu(Menu parent) {
		if (rebuildEachTime || menu == null || menu.isDisposed()) {
			menu = new Menu(parent);
			if (rebuildEachTime) {
				menu.addMenuListener(new MenuListener() {
					public void menuShown(MenuEvent e) {
						Menu aMenu = (Menu) e.widget;
						//dispose existing
						MenuItem[] items = aMenu.getItems();
						for (MenuItem menuItem : items) {
							menuItem.dispose();
						}

						IWorkbenchWindow currentWindow = getWindow();
						IWorkbenchPage page = currentWindow == null ? null : currentWindow
								.getActivePage();
						populateMenu(page, aMenu);
						if (aMenu.getItemCount() == 0) {
							createMenuItem(disabled, aMenu);
						} else {
							setEnabled(true);
						}
					}

					public void menuHidden(final MenuEvent e) {
					}
				});
			} else {
				IWorkbenchWindow currentWindow = getWindow();
				if (currentWindow != null) {
					populateMenu(currentWindow.getActivePage(), menu);
				}
				if (menu.getItemCount() == 0) {
					//setEnabled(false);
					createMenuItem(disabled, menu);
				} else {
					setEnabled(true);
				}
			}

			menu.addListener(SWT.SELECTED, new Listener() {
				public void handleEvent(Event arg0) {
					run();
				}
			});
		}
		return menu;
	}

	public Menu getMenu(Control parent) {
		if (rebuildEachTime || menu == null || menu.isDisposed()) {
			menu = new Menu(parent);
			IWorkbenchWindow currentWindow = getWindow();
			if (currentWindow != null) {
				populateMenu(currentWindow.getActivePage(), menu);
			}
			if (menu.getItemCount() == 0) {
				setEnabled(false);
				createMenuItem(disabled, menu);
			} else {
				setEnabled(true);

				menu.addListener(SWT.SELECTED, new Listener() {

					public void handleEvent(Event arg0) {
						run();

					}

				});
			}
		}
		return menu;
	}

	private IWorkbenchWindow getWindow() {
		if (window == null || window.getShell() == null || window.getShell().isDisposed()) {
			return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		}
		return window;
	}

	/**
	 * Return true if the given actionset should be enabled
	 * 
	 * 
	 * @param selection
	 *           The current selection available to the action; should be catched if needed
	 * 
	 * @return true if the given actionset should be enabled
	 */
	public abstract boolean isEnabled(IStructuredSelection selection);

	/**
	 * Populate the initial menu
	 * 
	 * @param activePage
	 *           The available workbench page often used to initialize actions
	 * @param emptyMenu
	 *           The empty menu created to be returned
	 * 
	 * @see #createMenuItem(IAction, Menu)
	 */
	public abstract void populateMenu(IWorkbenchPage activePage, Menu emptyMenu);

	/**
	 * Create the default action to run before the user has selected an option from the drop down
	 * toolbar.
	 * 
	 * @param activePage
	 *           The available workbench page often used to initialize actions
	 * @return The default action to run before the user has selected an option from the drop down
	 *         toolbar.
	 */
	public abstract IAction createDefaultAction(IWorkbenchPage activePage);

	public void init(IWorkbenchWindow activeWindow) {
		window = activeWindow;
		lastExecutedAction = createDefaultAction(activeWindow.getActivePage());
		update();

	}

	public void init(IAction action) {
		lastExecutedAction = action;
	}

	public void dispose() {
		window = null;
		lastExecutedAction = null;
		if (menu != null) {
			menu.dispose();
		}
	}

	@Override
	public void run() {
		// Runs the last action
		if (lastExecutedAction == null) {
			lastExecutedAction = createDefaultAction(getWindow().getActivePage());
		}

		if (lastExecutedAction != null && lastExecutedAction != disabled) {
			lastExecutedAction.run();
		}
		update();
	}

	public void run(IAction action) {
		run();
	}

	public void runWithEvent(IAction action, Event event) {
		run();
	}

	//disable action for non-units
	public void selectionChanged(IAction action, ISelection sel) {
		if (sel != null && sel instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) sel;
			action.setEnabled(isEnabled(selection));
		}
	}

	/**
	 * Creates a menu item for the parent menu based on the action.
	 * 
	 * @param action
	 * 
	 * @param parent
	 * @return a menu item
	 */
	public MenuItem createMenuItem(final IAction action, Menu parent) {
		final MenuItem item = new MenuItem(parent, SWT.NONE);
		if (action.getImageDescriptor() != null) {
			item.setImage(action.getImageDescriptor().createImage());
		}
		item.setText(action.getText());

		item.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				//Do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				action.run();

//				if (displayAction != null && action != null) {
//					displayAction.setImageDescriptor(action.getImageDescriptor());
//					displayAction.setDisabledImageDescriptor(action.getDisabledImageDescriptor());
//					displayAction.setToolTipText(action.getToolTipText());
//				}
				lastExecutedAction = action;
				update();
			}
		});
		return item;
	}

	private void update() {
		if (rememberLastSelection && lastExecutedAction != null) {
			setImageDescriptor(lastExecutedAction.getImageDescriptor());
			setDisabledImageDescriptor(lastExecutedAction.getDisabledImageDescriptor());
			setText(lastExecutedAction.getText());
			setToolTipText(lastExecutedAction.getToolTipText());
		}

	}
}