/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * Variant of GMF's {@link AdvancedPropertySection} that cleans up its action menu on refresh().
 * 
 * @author Ed Snible
 */
public class AdvancedPropertySection2 extends AdvancedPropertySection implements GEFProvider {

	private IActionBars actionBars;
	private EditDomain gefDomain;

	/**
	 * Constructor
	 */
	public AdvancedPropertySection2() {
		// do nothing
	}

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_ADVANCED_TAB);
		// The parent set up an UndoableModelPropertySheetEntry, but we want to use our own
		// class instead, so we get GEF-style UNDO
		GEFPropertySheetEntry root = new GEFPropertySheetEntry(this);
		root.setPropertySourceProvider(getPropertySourceProvider());
		page.setRootEntry(root);

		actionBars = aTabbedPropertySheetPage.getSite().getActionBars();
	}

	public void refresh() {
		super.refresh();

		setActionBars(actionBars);
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		// Set GEF domain, if we can find it.
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) selection;
			Object sel = iss.getFirstElement();
			if (sel instanceof EditPart) {
				EditPart ep = (EditPart) sel;
				gefDomain = PropertyUtils.getEditDomain(ep);
			}
		}
	}

	public EditDomain getEditDomain() {
		return gefDomain;
	}

	// The follow would actually never be called, all execution is done through the
	// UndoableModelPropertySheetEntry and its OperationHistoryFactory.getOperationHistory()

//	protected CommandResult executeAsCompositeCommand(String actionName, List commands) {
//		if (gefDomain == null) {
//			return super.executeAsCompositeCommand(actionName, commands);
//		}
//		
//        CompositeCommand command = new CompositeCommand(actionName, commands);
//		ICommandProxy icp = new ICommandProxy(command);
//		gefDomain.getCommandStack().execute(icp);
//		return command.getCommandResult();
//	}

	// What actually happens is UndoableModelPropertySheetEntry.valueChanged() does 
	//    TriggeredOperations triggerOperation = 
	//       new TriggeredOperations(command, getOperationHistory());
	//    getOperationHistory().execute(triggerOperation, new NullProgressMonitor(), null);

} // end class AdvancedPropertySection2
