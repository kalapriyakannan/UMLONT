/***************************************************************************************************
 * Copyright (c) 2007 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.ConvertedValue;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.operation.UpdateContractOperation;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployTransactionalCommand;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;

/**
 * 
 * 
 * @author NKruk
 * @see DmoSyncHelperModel
 */
public class DmoSyncHelperModel implements Adapter {
	protected DeployModelObject dmo;
	protected List<Adapter> listeners;
	private final DmoFeatureValueConverter converter;
	private final PropertyDescriptor[] emptyDescriptor = new PropertyDescriptor[0];
	protected ChangeScope scope;
	protected PropertyDescriptor[] contractStates;

	/**
	 * Default Ctor.
	 * 
	 * Note: setInput must be called before any model can be used
	 */
	public DmoSyncHelperModel() {
		converter = new DmoFeatureValueConverter();
	}

	/**
	 * @param dmo
	 */
	public void setInput(DeployModelObject dmo) {
		if (scope != null) {
			//Need to close out our change scope to avoid scribbler exceptions
			scope.close(new NullProgressMonitor());
		}
		if (this.dmo != null) {
			this.dmo.getEObject().eAdapters().remove(this);
		}
		this.dmo = dmo;
		if (this.dmo != null) {
			this.dmo.eAdapters().add(this);
			if (dmo.getEObject().eResource() != null) {
				scope = ChangeScope.createChangeScopeForWrite(dmo);
			}
		}
	}

	private final class DmoSyncHelperOperation extends DeployTransactionalCommand {
		private final Object value;
		private final EStructuralFeature propertyName;

		private DmoSyncHelperOperation(Object aValue, EStructuralFeature esf) {
			super(TransactionUtil.getEditingDomain(dmo),
					NLS.bind(Messages.DmoSyncHelperModel_Set_the_0_to_1_, new Object[] { esf.getName(),
							aValue }), getAllWorkspaceFiles(dmo));
			value = aValue;
			propertyName = esf;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			if (value instanceof ConvertedValue) {
				ConvertedValue cValue = (ConvertedValue) value;

				if (propertyName instanceof EAttribute) {
					cValue.instantiate(dmo, (EAttribute) propertyName);
				}
				doSetProperty(propertyName, cValue.deconvert());
			} else {
				// clear the units if any
				if (propertyName instanceof EAttribute) {
					ConvertedValue.clearMetadata(dmo, (EAttribute) propertyName);
				}
				doSetProperty(propertyName, value);
			}
			return null;
		}
	}

	/**
	 * A human-readable name and value. Used as choices for combo boxes.
	 */
	public static class PropertyDescriptor {
		Object value;
		String name;

		/**
		 * @param name
		 * @param value
		 */
		public PropertyDescriptor(String name, Object value) {
			this.name = name;
			this.value = value;
		}

		/**
		 * @return binary value
		 */
		public Object getPropertyValue() {
			return value;
		}

		/**
		 * @return human-readable equivelent of {@link #getPropertyValue()}
		 */
		public String getPropertyText() {
			return name;
		}

	}

	public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature feature) {
		if (EcorePackage.Literals.EENUM.isInstance(feature.getEType())) {
			return getValidPropertyDescriptors((EEnum) feature.getEType());
		}
		return emptyDescriptor;
	}

	private PropertyDescriptor[] getValidPropertyDescriptors(EEnum enum1) {
		List<EEnumLiteral> literals = enum1.getELiterals();
		PropertyDescriptor[] retval = new PropertyDescriptor[literals.size()];
		for (int i = 0; i < literals.size(); i++) {
			EEnumLiteral temp = literals.get(i);
			retval[i] = createPropertyDescriptor(temp);
		}
		return retval;
	}

	protected PropertyDescriptor createPropertyDescriptor(EEnumLiteral temp) {
		return new PropertyDescriptor(temp.getLiteral(), temp.getInstance());
	}

	/**
	 * Add a new listener. Events from the {@link DeployModelObject} will be forwarded to the
	 * listener.
	 * 
	 * @param adapter
	 *           An {@link Adapter} to handle the events.
	 */
	public void addListener(Adapter adapter) {
		if (adapter != null) {
			if (listeners == null) {
				listeners = new ArrayList<Adapter>();
			}
			listeners.add(adapter);
		}
	}

	/**
	 * Remove the adapter from the list of listeners.
	 * 
	 * @param adapter
	 *           An {@link Adapter} to remove.
	 */
	public void removeListener(Adapter adapter) {
		if (adapter != null && listeners != null) {
			listeners.remove(adapter);
		}
	}

	/**
	 * 
	 * @param propertyName
	 *           The name of the property to be set
	 * @param value
	 *           The converted value to set for the property or null to unset the value
	 * @return an {@link IStatus}indicating success or failure.
	 */
	public final IStatus setProperty(final EStructuralFeature propertyName, final Object value) {
		if (propertyName != null) {
			if (scope == null) {
				doSetProperty(propertyName, value);
				return Status.OK_STATUS;
			} else {
				AbstractEMFOperation op = new DmoSyncHelperOperation(value, propertyName);
				LightweightOperationFactory.addUndoContext(op, dmo);
				try {
					return scope.execute(op, ChangeScope.OPTION_DO_NOT_SAVE, new NullProgressMonitor());
				} catch (Exception e) {
					DeployCorePlugin.logError(0, e.getMessage(), e);
				}
			}
		}
		return Status.CANCEL_STATUS;
	}

	/**
	 * 
	 * @param property
	 *           The property to be set
	 * @param value
	 *           The String value to set for the property or null to unset the value; the value will
	 *           be converted as needed.
	 */
	public final void setProperty(EStructuralFeature property, String value) {
		setProperty(property, converter.convertValue(value, property));
	}

	/**
	 * @param esf
	 * @return <code>true</code> if the property should be enabled on an UI form
	 */
	public boolean isPropertyEnabled(EStructuralFeature esf) {
		// It's only safe to call PropertyUtils.isEditable() for with a matching ESF and DMO.
		// Some of the {@link DmoComposite}s are passing around unrelated ESFs, as magic
		// cookies to their get/set routines.  Don't pass one of these to PropertyUtils!
		if (esf.getContainerClass() != null && esf.getContainerClass().isInstance(dmo)) {
			return PropertyUtils.isEditable(dmo, esf);
		}

		return PropertyUtils.isEditable(dmo);
	}

	/**
	 * Clean up resources being used by this class
	 */
	public void dispose() {
		if (dmo != null) {
			dmo.eAdapters().remove(this);
		}
		if (listeners != null) {
			listeners.clear();
		}
		listeners = null;
		try {
			//Close the scribbler
			if (scope != null) {
				scope.close(new NullProgressMonitor());
			}
		} catch (Exception e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
	}

	/**
	 * @param property
	 * @return the validation status of property
	 */
	public IStatus getPropertyStatus(EStructuralFeature property) {
		return DeployCoreStatusUtil.getAttributeStatus(dmo, property);
	}

	public String getStringProperty(EStructuralFeature propertyName) {
		Object temp = getProperty(propertyName);
		if (temp != null) {

			if (propertyName instanceof EAttribute) {
				ConvertedValue cValue = ConvertedValue
						.getConvertedValue(dmo, (EAttribute) propertyName);
				if (cValue != null) {
					return convertPropertyToString(cValue);
				}
			}
			return convertPropertyToString(temp);
		}
		//Need to return empty string here so that if a text field is blank
		//we set it to blank rather than keeping text from the last input
		return IConstants.EMPTY_STRING;
	}

	private String convertPropertyToString(Object propertyValue) {
		if (propertyValue instanceof QName) {
			QName qname = (QName) propertyValue;
			StringBuffer buf = new StringBuffer();
			if (qname.getPrefix() != null) {
				buf.append(qname.getPrefix());
				buf.append('.');
			} else if (qname.getNamespaceURI() != null) {
				buf.append(qname.getNamespaceURI());
				buf.append('.');
			}
			buf.append(qname.getLocalPart());
			return buf.toString();
		}
		if (propertyValue instanceof Number) {
			return convertPropertyToString((Number) propertyValue);
		}
		if (propertyValue instanceof ConvertedValue) {
			return convertPropertyToString((ConvertedValue) propertyValue);
		}
		return propertyValue.toString();
	}

	private String convertPropertyToString(Number propertyValue) {
		return NumberFormat.getNumberInstance().format(propertyValue.doubleValue());
	}

	private String convertPropertyToString(ConvertedValue propertyValue) {
		return NumberFormat.getNumberInstance().format(propertyValue.convert().doubleValue())
				+ propertyValue.getUnits();
	}

	public Object getProperty(EStructuralFeature propertyName) {
		return dmo.eGet(propertyName);
	}

	public boolean getBooleanProperty(EStructuralFeature propertyName) {
		Object temp = getProperty(propertyName);
		if (temp != null) {
			if (temp instanceof String) {
				return Boolean.getBoolean(temp.toString());
			}
			if (temp instanceof Boolean) {
				return (Boolean) temp;
			}
		}
		return false;
	}

	public PropertyDescriptor getPropertyDescriptor(EStructuralFeature propertyName) {
		Object value = getProperty(propertyName);
		String name = getPropertyDescriptorText(propertyName, value);
		PropertyDescriptor desc = new PropertyDescriptor(name, value);
		return desc;
	}

	/** Given a feature and its value, return a human-readable version of the value */
	protected String getPropertyDescriptorText(@SuppressWarnings("unused")
	EStructuralFeature propertyName, Object value) {
		return value != null ? convertPropertyToString(value) : Messages.PropertyUtils_null_;
	}

	public boolean validPropertyDescriptorsChanged(EStructuralFeature propertyName) {
		return false;
	}

	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

	public void notifyChanged(Notification notification) {
		switch (notification.getEventType())
		{
		case Notification.SET:
		case Notification.UNSET:
			//Check enablement, check valid property descriptors
			notifyListeners(notification);
			break;
		case Notification.ADD:
		case Notification.ADD_MANY:
		case Notification.REMOVE:
		case Notification.REMOVE_MANY:
			notifyListeners(notification);
		}
	}

	protected void notifyListeners(Notification notification) {
		if (listeners != null && !listeners.isEmpty()) {
			for (Iterator<Adapter> it = listeners.iterator(); it.hasNext();) {
				it.next().notifyChanged(notification);
			}
		}
	}

	public void setTarget(Notifier newTarget) {
	}

	/**
	 * Subclasses should override to return an {@link Image} for the passed property.
	 * 
	 * @param property
	 *           A registered property with the {@link DmoSyncHelper}.
	 * @return An {@link Image} to be set on a label.
	 */
	public Image getPropertyImage(EStructuralFeature property) {
		return null;
	}

	/**
	 * Updates the topology contract based on the new contractFlag.
	 * 
	 * @param contractFlag
	 *           A valid contractFlag.
	 * 
	 * @see UpdateContractOperation#PUBLIC_EDITABLE_FLAG
	 * @see UpdateContractOperation#PUBLIC_FLAG
	 * @see UpdateContractOperation#PRIVATE_FLAG
	 */
	protected void updateContract(final int contractFlag) {
		AbstractEMFOperation op = new UpdateContractOperation(dmo, contractFlag,
				Messages.DmoSyncHelperModel_Update_Contract_);
		LightweightOperationFactory.addUndoContext(op, dmo);
		scope.execute(op, ChangeScope.OPTION_DO_NOT_SAVE, new NullProgressMonitor());
	}

	protected PropertyDescriptor[] getContractDescriptors() {
		//Populate and cache descriptors
		if (contractStates == null) {
			contractStates = new PropertyDescriptor[3];
			String[] items = {
					com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_Public_Editable_,
					com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_Public_,
					com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_Private_ };
			for (int i = 0; i < items.length; i++) {
				contractStates[i] = new PropertyDescriptor(items[i], i);
			}
		}
		return contractStates;
	}

	/**
	 * Subclasses may override.
	 */
	protected void doSetProperty(final EStructuralFeature propertyName, final Object value) {
		if (propertyName.isMany()) {
			List list = (List) dmo.eGet(propertyName);
			if (!(value instanceof Collection)) {
				list.add(value);
			} else {
				dmo.eSet(propertyName, value);
			}
		} else {
			if (value == null || value instanceof Number && ((Number) value).doubleValue() == 0.0) {
				dmo.eUnset(propertyName);
			} else {
				dmo.eSet(propertyName, value);
			}
		}
	}

	/**
	 * @param esf
	 * @return
	 */
	public List<String> getStringListProperty(EStructuralFeature esf) {
		return (List<String>) dmo.eGet(esf);
	}

	/**
	 * @return <code>true</code> if setInput() was given a valid input
	 */
	public boolean hasInput() {
		return dmo != null;
	}

}
