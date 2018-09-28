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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.LinkDetailComposite;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * Property section on the 'Link' tab. See plugin.xml for enablement.
 * 
 * <p>
 * The UI is a Table.
 * 
 * @author Ed Snible
 * @see LinkDetailComposite
 */
public class LinksPropertySection3 extends AbstractPropertySection {

	private IActionBars actionBars;
	private Action removeLinkAction;
	//	private List<DeployLink> links;
	private LinkDetailComposite linkDetailComposite;

	/**
	 * constructor
	 */
	public LinksPropertySection3() {
		// do nothing
	}

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_LINKS_TAB);
		// Create a new section to wrap and layout our table
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		composite.setLayout(new GridLayout());
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);

		linkDetailComposite = new LinkDetailComposite(composite, getWidgetFactory());
		//getWidgetFactory().adapt(linkDetailComposite);
		linkDetailComposite.setLayout(new GridLayout());
		linkDetailComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		linkDetailComposite.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				updateToolbarEnablement();
			}
		});

		actionBars = aTabbedPropertySheetPage.getSite().getActionBars();
		createActions();
	}

	private void createActions() {

		String unlink = Messages.ConfigurationsPropertySection2_Unlin_;
		removeLinkAction = propAction(unlink, "icons/elcl16/rmove_link.gif", new Action() { //$NON-NLS-1$
					public void run() {
						unlink();
					}
				});

	}

	private Action propAction(String msg, String icon, Action a) {
		a.setText(msg);
		a.setToolTipText(msg);
		ImageDescriptor id = PropertyUtils.createImageDescriptor(icon);
		a.setImageDescriptor(id);
		return a;
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) selection;
			Object sel = iss.getFirstElement();
			if (sel instanceof DeployConnectionNodeEditPart) {
				DeployConnectionNodeEditPart linkEP = (DeployConnectionNodeEditPart) sel;
				List<DeployConnectionNodeEditPart> l = GMFUtils.getOverlappingLinkEditPartsFor(linkEP);
				setInput(getModelLinks(l));
			}
		}

		setInput(null);
	}

	private List<DeployLink> getModelLinks(List<DeployConnectionNodeEditPart> l) {
		List<DeployLink> retVal = new LinkedList<DeployLink>();

		for (Iterator<DeployConnectionNodeEditPart> it = l.iterator(); it.hasNext();) {
			DeployConnectionNodeEditPart linkEP = it.next();
			if (linkEP.getModel() instanceof View) {
				View view = (View) linkEP.getModel();
				if (view.getElement() instanceof DeployLink) {
					retVal.add((DeployLink) view.getElement());
				}
			}

		}

		return retVal;
	}

	private void setInput(List<DeployLink> links) {
		if (links != null) {
			linkDetailComposite.setInput(links);
		}

		updateToolbarEnablement();
	}

	protected void updateToolbarEnablement() {
		boolean canDelete = linkDetailComposite.canDeleteSelectedLinks();
		linkDetailComposite.setEnabled(canDelete);
	}

	private void unlink() {
		linkDetailComposite.deleteSelectedLinks();
		removeLinkAction.setEnabled(false);
	}

	public boolean shouldUseExtraSpace() {
		return true;
	}

	public void refresh() {

		super.refresh();

		actionBars.getMenuManager().removeAll();
		actionBars.getStatusLineManager().removeAll();
		actionBars.getToolBarManager().removeAll();

		actionBars.getToolBarManager().add(removeLinkAction);

		actionBars.getMenuManager().add(removeLinkAction);

		actionBars.getToolBarManager().update(true);
	}

	@Override
	public void dispose() {
		if (linkDetailComposite != null) {
			linkDetailComposite.dispose();
		}
	}

} // end class LinksPropertySection3
