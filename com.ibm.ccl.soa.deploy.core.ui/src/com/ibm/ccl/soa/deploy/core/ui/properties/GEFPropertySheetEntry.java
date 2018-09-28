/***************************************************************************************************
 * Copyright (c) 2007 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.text.MessageFormat;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.ui.properties.commands.SetModelPropertyValueCommand;
import org.eclipse.gmf.runtime.emf.ui.properties.internal.l10n.EMFUIPropertiesMessages;
import org.eclipse.gmf.runtime.emf.ui.properties.sections.PropertySheetEntry;

/**
 * Instead of using UndoableModelPropertySheetEntry as other applications do, use our own version
 * which uses GEF's UNDO stack rather than IOperationHistory.
 * 
 * <p>
 * NOTE: Code based on UndoableModelPropertySheetEntry. I needed to change how value setting was
 * done -- I wanted to use GEF stack -- and couldn't do it through subclassing.
 * 
 * @author Ed Snible
 */
public class GEFPropertySheetEntry extends PropertySheetEntry {

	private TransactionalEditingDomain editingDomain;
	protected final GEFProvider gefProvider;

	/**
	 * @param gefProvider
	 */
	public GEFPropertySheetEntry(GEFProvider gefProvider) {
		this.gefProvider = gefProvider;
	}

	protected GEFPropertySheetEntry getParentEntry() {
		return (GEFPropertySheetEntry) parent;
	}

	protected PropertySheetEntry createChildEntry() {
		return new GEFPropertySheetEntry(gefProvider);
	}

	// NOTE: COPIED FROM UndoableModelPropertySheetEntry
	protected void setValue(Object newValue) {

		// Set the value
		for (int i = 0; i < values.length; i++) {
			values[i] = newValue;
		}

		// Inform our parent
		getParentEntry().valueChanged(
				this,
				getCompositeCommand(MessageFormat.format(
						EMFUIPropertiesMessages.UndoablePropertySheetEntry_commandName,
						new String[] { getDescriptor().getDisplayName() })));

		// Remember the new value so that we don't apply this same value more
		// than once.
		editValue = newValue;
	}

	protected ICompositeCommand getCompositeCommand(String propertyName) {
		return new CompositeTransactionalCommand(getEditingDomain(), propertyName);
	}

	// NOTE: COPIED FROM UndoableModelPropertySheetEntry
	/**
	 * @return the EMF Transaction domain
	 */
	public TransactionalEditingDomain getEditingDomain() {

		GEFPropertySheetEntry parentEntry = getParentEntry();

		if (parentEntry == null || editingDomain != null) {
			return editingDomain;
		}

		return parentEntry.getEditingDomain();
	}

	// NOTE: COPIED FROM UndoableModelPropertySheetEntry
	public void setValues(Object[] objects) {
		super.setValues(objects);

		if (getParentEntry() == null) {
			// I'm the root
			for (int i = 0; i < objects.length; i++) {
				EObject eObject = null;

				if (objects[i] instanceof EObject) {
					eObject = (EObject) objects[i];

				} else if (objects[i] instanceof IAdaptable) {
					eObject = (EObject) ((IAdaptable) objects[i]).getAdapter(EObject.class);
				}

				if (eObject != null) {
					setEditingDomain(TransactionUtil.getEditingDomain(eObject));
				}
			}
		}
	}

	/**
	 * @param editingDomain
	 */
	// NOTE: COPIED FROM UndoableModelPropertySheetEntry
	public void setEditingDomain(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	// NOTE: COPIED FROM UndoableModelPropertySheetEntry
	protected void valueChanged(GEFPropertySheetEntry child, ICommand command) {

		String propertyName = child.getDescriptor().getDisplayName();

		Object propertyId = child.getDescriptor().getId();

		for (int i = 0; i < values.length; i++) {
			command.compose(getPropertyCommand(propertyName, values[i], propertyId, child
					.getEditValue(i)));
		}

		// inform our parent
		if (getParentEntry() != null) {
			getParentEntry().valueChanged(this, command);
		} else {
			//I am the root entry
//            try {
//                TriggeredOperations triggerOperation = 
//                    new TriggeredOperations(command, getOperationHistory());
//                getOperationHistory().execute(triggerOperation, new NullProgressMonitor(), null);
			ICommandProxy icp = new ICommandProxy(command);
			gefProvider.getEditDomain().getCommandStack().execute(icp);

//            } catch (ExecutionException e) {
//                Trace.catching(EMFPropertiesPlugin.getDefault(),
//                    EMFPropertiesDebugOptions.EXCEPTIONS_CATCHING,
//                    DeployPropertySheetEntry2.class,
//                    "valueChanged", e); //$NON-NLS-1$
//                Log.error(EMFPropertiesPlugin.getDefault(),
//                    EMFPropertiesStatusCodes.COMMAND_FAILURE, e
//                        .getLocalizedMessage(), e);
//            }
		}
	}

	// NOTE: COPIED FROM UndoableModelPropertySheetEntry
	protected ICommand getPropertyCommand(String propertyName, Object object, Object propertyId,
			Object value) {

		return new SetModelPropertyValueCommand(getEditingDomain(), propertyName, object,
				getPropertySource(object), propertyId, value);
	}
} // end class GEFPropertySheetEntry
