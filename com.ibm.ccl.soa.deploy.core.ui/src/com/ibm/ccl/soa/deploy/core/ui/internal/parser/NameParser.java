/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.parser;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ParseCommand;

/**
 * @author jswanke
 * 
 */
public class NameParser implements IParser {
	/** invalid format status */
	private static final IParserEditStatus INVALID_EMPTY_STATUS = new ParserEditStatus(
			DeployCoreUIPlugin.PLUGIN_ID, IParserEditStatus.UNEDITABLE, Messages.INVALID_EMPTY_STRING);

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEditString(IAdaptable adaptable, int flags) {
		return getPrintString(adaptable, flags);
	}

	public ICommand getParseCommand(IAdaptable elementAdapter, String newString, int flags) {
		EObject element = (EObject) elementAdapter.getAdapter(EObject.class);
		return new NameParseCommand(element, newString, flags);
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			if (feature == CorePackage.eINSTANCE.getDeployModelObject_Name()) {
				return true;
			}
		}

		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		editString = editString.trim();
		//check for empty string
		if (editString.length() == 0) {
			return INVALID_EMPTY_STATUS;
		}

		// not stored in internal name anymore		
		//		//Invalid charaters.
		//		if (!TopologyMarkerFactory.isValidDeployModelObjectName(editString))
		//			return INVALID_CHARACTER_STATUS;

		// TODO Here we need to more validation like uniqueness of name within a topology
		//the String entered by the user. 
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/** instance of parser */
	static protected IParser instance = null;

	/**
	 * Constructor for DescriptionParser.
	 */
	protected NameParser() {
		super();
	}

	/**
	 * Gets the instance of the parser
	 * 
	 * @return IParser the single instance of the parser
	 */
	static public IParser getInstance() {
		if (instance == null) {
			instance = new NameParser();
		}
		return instance;
	}

	public String getPrintString(IAdaptable adaptable, int flags) {
		String printString = null;
		EObject element = (EObject) adaptable.getAdapter(EObject.class);

		if (element instanceof Unit) {
			//			printString = ((Unit) element).title();
			Unit unit = (Unit) element;
			return unit.getCaptionProvider().title(unit);
		} else if (element instanceof DeployModelObject) {
			printString = ((DeployModelObject) element).getDisplayName();
		}
		if (element instanceof DeployModelObject
				&& (printString == null || printString.trim().length() == 0)) {
			printString = ((DeployModelObject) element).getName();

		}

		return printString;
	}

	/**
	 * Command for applying the inline edited string
	 */
	protected class NameParseCommand extends ParseCommand {

		/* undo/redo states */
		private String oldName;

		private String newName;

		/**
		 * @param element
		 * @param newString
		 * @param flags
		 * @see com.ibm.xtools.model.providers.parser.ParseCommand#ParseCommand(IUMLElement, String,
		 *      int)
		 */
		public NameParseCommand(EObject element, String newString, int flags) {
			super(element, newString, flags);
		}

		/**
		 * @see ParseCommand#doExecute(IProgressMonitor)
		 */
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
			DeployModelObject object = (DeployModelObject) element;
			oldName = object.getDisplayName();
			if (object instanceof Unit) {
				//				oldName = ((Unit) object).getTitle();
				newName = newString;

				if (((Unit) object).getCaptionProvider().title((Unit) object) == null) {
					object.setDisplayName(newName);
				}

				//				((Unit) object).setTitle(newName);
				return CommandResult.newOKCommandResult();
			}

			//			 not stored in internal name anymore		
			//			if (object.getName().equals(oldName))
			//				object.setName(newName);

			//			return CommandResult.newOKCommandResult();
			return CommandResult.newErrorCommandResult("Only Units may have parser"); //$NON-NLS-1$
		}

		/**
		 * Returns the newName.
		 * 
		 * @return String
		 */
		protected String getNewName() {
			return newName;
		}

		/**
		 * Returns the oldName.
		 * 
		 * @return String
		 */
		protected String getOldName() {
			return oldName;
		}

		/**
		 * Sets the newName.
		 * 
		 * @param newName
		 *           The newName to set
		 */
		protected void setNewName(String newName) {
			this.newName = newName;
		}

		/**
		 * Sets the oldName.
		 * 
		 * @param oldName
		 *           The oldName to set
		 */
		protected void setOldName(String oldName) {
			this.oldName = oldName;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ibm.xtools.uml.core.internal.providers.parser.ParseCommand#getDescription()
		 */
		public String getDescription() {
			return "Parse Command Description"; //$NON-NLS-1$
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gmf.runtime.common.core.command.ICommand#getLabel()
		 */
		public String getLabel() {
			return "Parse Command Label"; //$NON-NLS-1$
		}

	}
}
