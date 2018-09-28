/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
/**
 * 
 */
package com.ibm.ccl.soa.deploy.core.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.console.IConsoleConstants;

import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * @author jswanke
 * 
 */
public class DeployCorePerspectiveFactory implements IPerspectiveFactory {

	/**
	 * ID of the Project Explorer
	 */
	final public static String ID_PROJECT_NAV = "org.eclipse.ui.navigator.ProjectExplorer"; //$NON-NLS-1$
	/**
	 * ID of the server navigator
	 */

	final public static String ID_PUBLISH_PROBLEM = "com.ibm.ccl.soa.deploy.core.ui.views.publish";//$NON-NLS-1$
	/**
	 * ID for export problem views
	 */
	final public static String ID_EXPORT_VIEW = "com.ibm.ccl.soa.deploy.core.ui.views.export";//$NON-NLS-1$

	//public static String ID_STATUS_VIEW="com.ibm.ccl.soa.deploy.core.ui.statusview";//$NON-NLS-1$
	/**
	 * Constructs a new Default layout engine.
	 */

	final public static String ID_TOPOLOGY_STATUS_VIEW = "com.ibm.ccl.soa.deploy.core.ui.views.topology.view";//$NON-NLS-1$

	/**
	 * 
	 * public DeployCorePerspectiveFactory() { super(); } /* (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);
	}

	private void defineLayout(IPageLayout layout) {
		// Top left:
		IFolderLayout topLeftFolder = layout.createFolder(
				"topLeft", IPageLayout.LEFT, 0.25f, IPageLayout.ID_EDITOR_AREA); //$NON-NLS-1$
		topLeftFolder.addView(ID_PROJECT_NAV);

		// Bottom left
		IFolderLayout bottomLeftFolder = layout.createFolder(
				"bottomLeft", IPageLayout.BOTTOM, 0.6f, "topLeft"); //$NON-NLS-1$ //$NON-NLS-2$ 
		bottomLeftFolder.addView(ID_TOPOLOGY_STATUS_VIEW);
		bottomLeftFolder.addView(IPageLayout.ID_OUTLINE);

		// Bottom 
		IFolderLayout bottomFolder = layout.createFolder(
				"bottom", IPageLayout.BOTTOM, 0.8f, IPageLayout.ID_EDITOR_AREA); //$NON-NLS-1$
		bottomFolder.addView(IPageLayout.ID_PROP_SHEET);
		bottomFolder.addView(IPageLayout.ID_PROBLEM_VIEW);

		bottomFolder.addView(IPageLayout.ID_TASK_LIST);
		//add by Ella Feng fenglin@cn.ibm.com
		//bottomFolder.addView(ID_PUBLISH_PROBLEM);
		bottomFolder.addView(ID_EXPORT_VIEW);
		//bottomFolder.addView(ID_STATUS_VIEW);
		// views

		layout.addShowViewShortcut(ID_TOPOLOGY_STATUS_VIEW);
		layout.addShowViewShortcut(ID_EXPORT_VIEW);

		// views - debugging
		layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);

		// views - standard workbench
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);
	}

	/**
	 * Filter the views by decorator semantic
	 * 
	 * @param semantic
	 *           the decorator semantic
	 */
	public static void filterViewsByDecoratorSemantic(String semantic) {
		String[] allViews = new String[] { ID_TOPOLOGY_STATUS_VIEW, ID_EXPORT_VIEW,
				IPageLayout.ID_OUTLINE, IPageLayout.ID_PROBLEM_VIEW, IPageLayout.ID_RES_NAV };
		IWorkbenchPage page = ResourceUtils.getActiveWorkbenchPage();
		if (page != null) {
			for (int j = 0; j < allViews.length; j++) {
				String viewid = allViews[j];
				IViewReference viewReference = page.findViewReference(allViews[j]);
				if (viewReference == null) {
					/*
					 * try { IViewPart view = page.showView(allViews[j]); viewReference =
					 * page.findViewReference(allViews[j]); if(viewReference == null){
					 */
					continue;
					/*
					 * } } catch (PartInitException e) { DeployCoreUIPlugin.log(IStatus.ERROR, 0,
					 * NLS.bind(Messages.FilterViewsByDecoratorSemantic_Error, semantic), e); }
					 */
				}

				IDecoratorSemanticService dsService = ExtensionsCore.createDecoratorSemanticService();
				if (dsService.isViewMemberOf(semantic, viewid)) {
					viewReference.getView(true);
				} else {
					IViewPart part = viewReference.getView(false);
					if (part == null) {
						continue;
					}
					if (viewid != ID_TOPOLOGY_STATUS_VIEW) {
						page.hideView(viewReference);
					}
				}
			}
		}
	}

	private void defineActions(IPageLayout layout) {
		// Add "new wizards".
		layout.addNewWizardShortcut("com.ibm.ccl.soa.deploy.core.ui.wizard.new.file"); //$NON-NLS-1$
	}
}
