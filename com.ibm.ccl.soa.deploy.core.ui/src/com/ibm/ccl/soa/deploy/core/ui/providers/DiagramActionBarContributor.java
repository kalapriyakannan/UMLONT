/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.providers;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.actions.FindUnitAction;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;

/**
 * The deploy tool diagram editor action bar contributor. This allows the deploy tool diagram to
 * inherit the Diagram main menu and the toolbar from the basic diagram editor.
 * 
 */
public class DiagramActionBarContributor extends
		org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor {

	/**
	 * @see com.ibm.xtools.diagram.ui.parts.DiagramActionBarContributor#getEditorClass()
	 */
	protected Class getEditorClass() {
		return DeployCoreEditor.class;
	}

	/**
	 * @see com.ibm.xtools.diagram.ui.parts.DiagramActionBarContributor#getEditorId()
	 */
	protected String getEditorId() {
		return DeployCoreUIPlugin.EDITOR_ID;
	}

	public void setActiveEditor(IEditorPart editor) {
		super.setActiveEditor(editor);

		// Attach our Find dialog to Eclipse's global Find/Replace menu item
		getActionBars().setGlobalActionHandler(ActionFactory.FIND.getId(),
				new FindUnitAction(getPage()));
	}
}
