package com.ibm.ccl.soa.deploy.core.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.DynamicReassociationList;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalInstanceConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.MethodHandler;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyList;

public class ConfigurationAssistant {

	private final InternalInstanceConfiguration owner;

	public ConfigurationAssistant(InternalInstanceConfiguration config) {
		owner = config;
	}

	public void configure(DeployModelObject source, String field, Object value) {
		if (field == null || field.length() == 0) {
			DeployCorePlugin
					.logError(
							0,
							"Persistence of the " + field + " field for " + source.getFullPath() + " is not yet supported.", null); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		} else if (Character.isUpperCase(field.charAt(0))) {
			StringBuffer converted = new StringBuffer();
			converted.append(Character.toLowerCase(field.charAt(0))).append(field.substring(1))
					.toString();
			field = converted.toString();
		}

		String oldValue = null;
		String newValue = null;
		EDataType extendedType = MethodHandler.getType(source, field);

		Object oldObjectValue = getConfiguredValue(source, field);
		if (oldObjectValue == null) {
			// fetch the unconfigured value
			oldObjectValue = MethodHandler.getValue(source, field);
		}
		oldValue = EcoreUtil.convertToString(extendedType, oldObjectValue);
		newValue = EcoreUtil.convertToString(extendedType, value);

		if (oldValue == null || !oldValue.equals(newValue)) {
			Instantiation instantiation = owner.createInstantiation(source);
			Property foundProperty = null;
			for (Iterator iterator = instantiation.getConfiguredProperties().iterator(); iterator
					.hasNext()
					&& foundProperty == null;) {
				Property property = (Property) iterator.next();
				if (field.equals(property.getSelect())) {
					foundProperty = property;
				}
			}
			if (foundProperty == null) {
				foundProperty = CoreFactory.eINSTANCE.createProperty();
				foundProperty.setSelect(field);
				instantiation.getConfiguredProperties().add(foundProperty);
			}
			foundProperty.setValue(newValue);
		}
	}

	public void deconfigure(DeployModelObject source, String field) {
		if (field == null || field.length() == 0) {
			DeployCorePlugin
					.logError(
							0,
							"Persistence of the " + field + " field for " + source.getFullPath() + " is not yet supported.", null); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		} else if (Character.isUpperCase(field.charAt(0))) {
			StringBuffer converted = new StringBuffer();
			converted.append(Character.toLowerCase(field.charAt(0))).append(field.substring(1))
					.toString();
			field = converted.toString();
		}

		Object oldObjectValue = getConfiguredValue(source, field);
		if (oldObjectValue != null) {
			Instantiation instantiation = owner.createInstantiation(source);
			Property foundProperty = null;
			for (Iterator iterator = instantiation.getConfiguredProperties().iterator(); iterator
					.hasNext()
					&& foundProperty == null;) {
				Property property = (Property) iterator.next();
				if (field.equals(property.getSelect())) {
					iterator.remove();
					break;
				}
			}
		}
	}

	/**
	 * Returns either the sewn together list of non-editable
	 */
	public Object getConfiguredValue(DeployModelObject source, String field) {

		if (field == null) {
			DeployCorePlugin
					.logError(
							0,
							"Retrieval of the " + field + " field for " + source.getFullPath() + " is not yet supported.", null); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		} else if (Character.isUpperCase(field.charAt(0))) {
			StringBuffer converted = new StringBuffer();
			converted.append(Character.toLowerCase(field.charAt(0))).append(field.substring(1))
					.toString();
			field = converted.toString();
		}

		EStructuralFeature feature = source.eClass().getEStructuralFeature(field);
		if (feature != null && feature.isMany()) {
			InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
					.findScopeService(owner.getEditTopology());
			if (scopeService != null) {
				List readonly = (List) source.getEObject().eGet(feature);
				List proxified = new ProxyList(scopeService.getCacheService(), owner.getImported(),
						readonly);
				return new DynamicReassociationList(owner, source, feature, proxified);
			} else {
				return null;
			}
		} else {
			EDataType extendedType = MethodHandler.getType(source, field);

			if (extendedType != null) {
				Instantiation instantiation = owner.getInstantiation(source.getFullPath());
				if (instantiation != null) {
					for (Iterator iterator = instantiation.getConfiguredProperties().iterator(); iterator
							.hasNext();) {
						Property property = (Property) iterator.next();
						if (field.equals(property.getSelect())) {
							String value = property.getValue();
							return EcoreUtil.createFromString(extendedType, value);
						}
					}
				}
			}
		}
		return null;
	}

}
