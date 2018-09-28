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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditDomain;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.DataModelPropertyDescriptor;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;

/**
 * Used with {@link DataModelFactory#createDataModel()} to create an IDataModel.
 * 
 * @author Ed Snible
 * @deprecated
 */
public class DmoDataModelProvider extends AbstractDataModelProvider {

	private final Map attribs;
	private final DeployModelObject dmo;
	private final EditDomain gefDomain;

	/**
	 * @param dmo
	 * @param gefDomain
	 */
	public DmoDataModelProvider(DeployModelObject dmo, EditDomain gefDomain) {
		this.dmo = dmo;
		this.gefDomain = gefDomain;

		attribs = new HashMap();
		for (Iterator it = dmo.eClass().getEAllAttributes().iterator(); it.hasNext();) {
			EAttribute attr = (EAttribute) it.next();
			attribs.put(attr.getName(), attr);
		}

		for (Iterator it = dmo.getExtendedAttributes().iterator(); it.hasNext();) {
			ExtendedAttribute ea = (ExtendedAttribute) it.next();
			attribs.put(ea.getName(), ea);
		}
	}

	public Set getPropertyNames() {
		Set retVal = new HashSet();

		retVal.addAll(attribs.keySet());

		return retVal;
	}

	public Object getDefaultProperty(String propertyName) {
		Object attr = attribs.get(propertyName);
		if (attr instanceof EStructuralFeature) {
			return getDefaultProperty((EStructuralFeature) attr);
		}

		return getDefaultProperty((ExtendedAttribute) attr);
	}

	public boolean propertySet(String propertyName, Object propertyValue) {
		//		// Don't do anything, let the IDataModel hold on to the change.
		//		return false;
		Object attr = attribs.get(propertyName);
		if (attr instanceof EStructuralFeature) {
			return propertySet((EStructuralFeature) attr, propertyValue);
		}

		return propertySet((ExtendedAttribute) attr, propertyValue);
	}

	public IStatus validate(String name) {
		Object attr = attribs.get(name);
		if (attr instanceof EStructuralFeature) {
			return validate((EStructuralFeature) attr);
		}

		return validate((ExtendedAttribute) attr);
	}

	public DataModelPropertyDescriptor getPropertyDescriptor(String propertyName) {
		Object attr = attribs.get(propertyName);
		if (attr instanceof EStructuralFeature) {
			return getPropertyDescriptor((EStructuralFeature) attr);
		}

		return getPropertyDescriptor((ExtendedAttribute) attr);
	}

	public DataModelPropertyDescriptor[] getValidPropertyDescriptors(String propertyName) {
		Object attr = attribs.get(propertyName);
		if (attr instanceof EStructuralFeature) {
			return getValidPropertyDescriptors((EStructuralFeature) attr);
		}

		return getValidPropertyDescriptors((ExtendedAttribute) attr);
	}

	private Object getDefaultProperty(EStructuralFeature feature) {
		Object retVal = dmo.eGet(feature);

		return retVal;
	}

	private Object getDefaultProperty(ExtendedAttribute attribute) {
		return attribute.getValue();
	}

	private boolean propertySet(EStructuralFeature feature, Object propertyValue) {
		//		dmo.eSet(feature, propertyValue);

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(dmo);
		SetCommand sc = new SetCommand(domain, dmo, feature, propertyValue);
		execute(sc);

		return true;
	}

	private boolean propertySet(ExtendedAttribute attribute, Object propertyValue) {
		//		attribute.setValue(propertyValue);

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(dmo);
		SetCommand sc = new SetCommand(domain, attribute, CorePackage.eINSTANCE
				.getExtendedAttribute_Data(), propertyValue);
		execute(sc);

		return true;
	}

	private void execute(Command c) {
		TransactionCommandWrapper2 tcw = new TransactionCommandWrapper2(dmo, c, false);
		gefDomain.getCommandStack().execute(new ICommandProxy(tcw));
	}

	private IStatus validate(EStructuralFeature feature) {
		IStatus retVal = DeployCoreStatusUtil.getAttributeStatus(dmo, feature);
		return retVal;
	}

	private IStatus validate(ExtendedAttribute attribute) {
		// TODO Use DeployCoreStatusUtil (currently not available, 
		// because validation doesn't check extended attributes?)
		return Status.OK_STATUS;
	}

	private DataModelPropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature feature) {
		List retVal = new LinkedList();

		ItemPropertyDescriptor ipd = getItemPropertyDescriptor(feature);
		for (Iterator it = ipd.getChoiceOfValues(dmo).iterator(); it.hasNext();) {
			Enumerator ae = (Enumerator) it.next();
			retVal.add(new DataModelPropertyDescriptor(ae, ae.toString()));
		}

		return (DataModelPropertyDescriptor[]) retVal.toArray(new DataModelPropertyDescriptor[0]);
	}

	private DataModelPropertyDescriptor[] getValidPropertyDescriptors(ExtendedAttribute attribute) {
		// Extended attributes can't be combo boxes
		return null;
	}

	private DataModelPropertyDescriptor getPropertyDescriptor(EStructuralFeature feature) {
		//		ItemPropertyDescriptor ipd = getItemPropertyDescriptor(feature);
		Object raw = dmo.eGet(feature);
		return new DataModelPropertyDescriptor(raw, raw == null ? null : raw.toString());
	}

	private DataModelPropertyDescriptor getPropertyDescriptor(ExtendedAttribute attribute) {
		return new DataModelPropertyDescriptor(attribute.getValue());
	}

	private ItemPropertyDescriptor getItemPropertyDescriptor(EStructuralFeature feature) {
		IItemPropertySource ips = getPropertySource(dmo);
		if (ips != null) {
			for (Iterator it = ips.getPropertyDescriptors(dmo).iterator(); it.hasNext();) {
				ItemPropertyDescriptor ipd = (ItemPropertyDescriptor) it.next();
				if (ipd.getFeature(dmo) == feature) {
					return ipd;
				}
			}
		}

		return null;
	}

	private static IItemPropertySource getPropertySource(DeployModelObject dmo) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(dmo);
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			AdapterFactoryEditingDomain afed = (AdapterFactoryEditingDomain) editingDomain;
			IItemPropertySource ips = (IItemPropertySource) afed.getAdapterFactory().adapt(dmo,
					IItemPropertySource.class);
			return ips;
		}

		return null;
	}

} // end class DmoDataModel
