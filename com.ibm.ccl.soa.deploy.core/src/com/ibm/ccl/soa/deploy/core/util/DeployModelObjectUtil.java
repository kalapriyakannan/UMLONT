/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Static {@link DeployModelObject} utilities.
 */
public final class DeployModelObjectUtil {

	private DeployModelObjectUtil() {
		// prevent instantiation
	}

	/**
	 * Checks the mutability of a deploy model object.
	 * <p>
	 * A deploy model object is mutable if {@link DeployModelObject#isMutable()} is true, and all of
	 * its parents recursively are mutable ({@link DeployModelObject#getParent()}.
	 * 
	 * @param dmo
	 *           a deploy model object.
	 * @return true if the deploy model object is mutable and all its parents are mutable.
	 */
	public static boolean isMutable(DeployModelObject dmo) {
		if (dmo == null) {
			return false;
		}

		while (dmo != null) {
			if (dmo.isMutable() == false) {
				return false;
			}

			dmo = dmo.getParent();
		}

		return true;
	}

	/**
	 * Checks whether a deploy model object is conceptual.
	 * 
	 * @param dmo
	 *           a deploy model object, should not be null
	 * @return true if the Unit containing the DMO is conceptual
	 */
	public static boolean isConceptual(DeployModelObject dmo) {
		assert dmo != null;
		Unit unit = ValidatorUtils.getUnit(dmo);
		assert unit != null;
		return unit.isConceptual();
	}

	/**
	 * Checks the mutability of a deploy model object's attribute.
	 * <p>
	 * A deploy model object attribute is mutable if its {@link AttributeMetaData#isMutable()} is
	 * true (or null), and its deploy model object is mutable.
	 * 
	 * @param dmo
	 *           a deploy model object.
	 * @param attribute
	 *           an attribute of the deploy model object.
	 * @return true if the deploy model object attribute is mutable and its object is as well.
	 */
	public static boolean isMutable(DeployModelObject dmo, EAttribute attribute) {
		if (dmo == null || attribute == null) {
			return false;
		}

		if (!isMutable(dmo)) {
			return false;
		}

		AttributeMetaData data = DeployModelObjectUtil.getAttributeMetaData(dmo, attribute.getName());
		if (data == null) {
			return true;
		}
		return data.isMutable();
	}

	/**
	 * Checks the mutability of a deploy model object's attribute.
	 * <p>
	 * A deploy model object attribute is mutable if its {@link AttributeMetaData#isMutable()} is
	 * true (or null), and its deploy model object is mutable.
	 * 
	 * @param dmo
	 *           a deploy model object.
	 * @param attributeName
	 *           the name of an attribute of the deploy model object.
	 * @return true if the deploy model object attribute is mutable and its object is as well.
	 */
	public static boolean isMutable(DeployModelObject dmo, String attributeName) {
		if (dmo == null || attributeName == null) {
			return false;
		}

		if (!isMutable(dmo)) {
			return false;
		}

		AttributeMetaData data = DeployModelObjectUtil.getAttributeMetaData(dmo, attributeName);
		if (data == null) {
			return true;
		}
		return data.isMutable();
	}

	/**
	 * Checks if the attribute (or extended attribute) is present on the dmo and settable/editable -
	 * mutable and public-editable.
	 * 
	 * @param dmo
	 *           a deploy model object
	 * @param attributeName
	 *           the short name of the attribute
	 * @return true if the attribute (or extended attribute) is present on the dmo and is mutable and
	 *         public editable
	 * 
	 * @see DeployModelObjectUtil#isMutable(DeployModelObject, org.eclipse.emf.ecore.EAttribute)
	 */
	public static boolean isSettable(DeployModelObject dmo, String attributeName) {
		if (dmo == null || attributeName == null) {
			return false;
		}
		if (!dmo.isPublicEditable(attributeName)) {
			return false;
		}
		return DeployModelObjectUtil.isMutable(dmo, attributeName);
	}

	/**
	 * Checks if the attribute (or extended attribute) is present on the dmo and settable/editable -
	 * mutable and public-editable.
	 * 
	 * @param dmo
	 *           a deploy model object
	 * @param attribute
	 *           the attribute
	 * @return true if the attribute (or extended attribute) is present on the dmo and is mutable and
	 *         public editable
	 * 
	 * @see DeployModelObjectUtil#isMutable(DeployModelObject, org.eclipse.emf.ecore.EAttribute)
	 */
	public static boolean isSettable(DeployModelObject dmo, EAttribute attribute) {
		if (dmo == null || attribute == null) {
			return false;
		}
		if (!dmo.isPublicEditable(attribute.getName())) {
			return false;
		}
		return DeployModelObjectUtil.isMutable(dmo, attribute);
	}

	/**
	 * Checks if dmo is settable/editable - mutable and public-editable.
	 * 
	 * @param dmo
	 *           a deploy model object
	 * @return true if the dmo and is mutable and public editable
	 * 
	 * @see DeployModelObjectUtil#isMutable(DeployModelObject)
	 */
	public static boolean isSettable(DeployModelObject dmo) {
		if (!dmo.isPublicEditable()) {
			return false;
		}

		return DeployModelObjectUtil.isMutable(dmo);
	}

	/**
	 * Checks is a deploy model object's attribute is a parameter.
	 * 
	 * @param dmo
	 *           a deploy model object.
	 * @param attribute
	 *           an attribute of the deploy model object.
	 * @return true if the deploy model object attribute is a parameter
	 */
	public static boolean isParameter(DeployModelObject dmo, EAttribute attribute) {
		if (dmo == null || attribute == null) {
			return false;
		}
		assert attribute.getContainerClass().isInstance(dmo);

		AttributeMetaData data = DeployModelObjectUtil.getAttributeMetaData(dmo, attribute.getName());
		if (data == null) {
			return true;
		}
		return data.isParameter();
	}

	/**
	 * Checks is a deploy model object's attribute is a parameter.
	 * <p>
	 * 
	 * @param dmo
	 *           a deploy model object.
	 * @param attributeName
	 *           the name of an attribute of the deploy model object.
	 * @return true if the deploy model object attribute is a parameter
	 */
	public static boolean isParameter(DeployModelObject dmo, String attributeName) {
		if (dmo == null || attributeName == null) {
			return false;
		}

		AttributeMetaData data = DeployModelObjectUtil.getAttributeMetaData(dmo, attributeName);
		if (data == null) {
			return true;
		}
		return data.isParameter();
	}

	/**
	 * Checks if a deploy model object attribute is encrypted.
	 * <p>
	 * A deploy model object attribute is encrypted if its {@link AttributeMetaData#isEncrypted()} is
	 * true (or null), and its deploy model object is encrypted.
	 * 
	 * @param dmo
	 *           a deploy model object.
	 * @param attribute
	 *           an attribute of the deploy model object.
	 * @return true if the deploy model object attribute is encrypted.
	 */
	public static boolean isEncrypted(DeployModelObject dmo, EAttribute attribute) {
		if (dmo == null || attribute == null) {
			return false;
		}
		assert attribute.getContainerClass().isInstance(dmo);

		AttributeMetaData data = DeployModelObjectUtil.getAttributeMetaData(dmo, attribute.getName());
		if (data == null) {
			return false;
		}
		return data.isEncrypted();
	}

	/**
	 * Checks if a deploy model object attribute is encrypted.
	 * <p>
	 * A deploy model object attribute is encrypted if its {@link AttributeMetaData#isEncrypted()} is
	 * true (or null), and its deploy model object is encrypted..
	 * 
	 * @param dmo
	 *           a deploy model object.
	 * @param attributeName
	 *           the name of an attribute of the deploy model object.
	 * @return true if the deploy model object attribute is encrypted.
	 */
	public static boolean isEncrypted(DeployModelObject dmo, String attributeName) {
		if (dmo == null || attributeName == null) {
			return false;
		}

		AttributeMetaData data = DeployModelObjectUtil.getAttributeMetaData(dmo, attributeName);
		if (data == null) {
			return false;
		}
		return data.isEncrypted();
	}

	/**
	 * Returns a full path to the static attribute of the deploy model object.
	 * <p>
	 * Appends:
	 * <ol>
	 * <li> {@link DeployModelObject#getFullPath()}
	 * <li> {@link IConstants#ATTRIBUTE_SEPARATOR}
	 * <li> {@link EAttribute#getName()}
	 * </ol>
	 * 
	 * @param dmo
	 *           a deploy model object.
	 * @param attribute
	 *           a static attribute of the object.
	 * @return a full path to attribute that can be resolved through
	 *         {@link #getAttributeValue(DeployModelObject, String)}.
	 * @see #getAttributeValue(DeployModelObject, String)
	 */
	public static String getFullPathToAttribute(DeployModelObject dmo, EAttribute attribute) {
		return dmo.getFullPath() + IConstants.ATTRIBUTE_SEPARATOR + attribute.getName();
	}

	/**
	 * Returns a full path to the dynamic attribute of the deploy model object.
	 * <p>
	 * Appends:
	 * <ol>
	 * <li> {@link ExtendedAttribute#getContainer()} . {@link DeployModelObject#getFullPath()}
	 * <li> {@link IConstants#ATTRIBUTE_SEPARATOR}
	 * <li> {@link EAttribute#getName()}
	 * </ol>
	 * 
	 * @param attribute
	 *           the extended attribute of a deploy model object.
	 * @return a full path to attribute that can be resolved through
	 *         {@link #getAttributeValue(DeployModelObject, String)}.
	 * @see #getAttributeValue(DeployModelObject, String)
	 */
	public static String getFullPathToAttribute(ExtendedAttribute attribute) {
		if (attribute.getContainer() == null) {
			return IConstants.ATTRIBUTE_SEPARATOR + attribute.getName();
		}
		return attribute.getContainer().getFullPath() + IConstants.ATTRIBUTE_SEPARATOR
				+ attribute.getName();
	}

	/**
	 * Returns a full path to the static or dynamic attribute of the deploy model object.
	 * <p>
	 * Appends:
	 * <ol>
	 * <li> {@link DeployModelObject#getFullPath()}
	 * <li> {@link IConstants#ATTRIBUTE_SEPARATOR}
	 * <li> <code>attributeName</code>
	 * </ol>
	 * 
	 * @param dmo
	 *           a deploy model object.
	 * @param attributeName
	 *           the name of a static or dynamic attribute of the object.
	 * @return a full path to attribute that can be resolved through
	 *         {@link #getAttributeValue(DeployModelObject, String)}.
	 * @see #getAttributeValue(DeployModelObject, String)
	 */
	public static String getFullPathToAttribute(DeployModelObject dmo, String attributeName) {
		return dmo.getFullPath() + IConstants.ATTRIBUTE_SEPARATOR + attributeName;
	}

	/**
	 * Returns the value of the static or dynamic deploy model object attribute.
	 * <p>
	 * The method returns null if an attribute is not defined as either static or dynamic. To find
	 * out if an attribute has been defined use {@link #hasAttribute(DeployModelObject, String)}.
	 * <p>
	 * The attribute name make be local, or relative to the deploy object. For example, if the
	 * attribute name was created using
	 * {@link #getFullPathToAttribute(DeployModelObject, EAttribute)} then the <code>dmo</code>
	 * object will be used to {@link DeployModelObject#resolve(String)}, and then the attribute will
	 * be retrieved from the specified object. In such cases, the <code>dmo</code> parameter to
	 * this method will typically be a {@link Topology} instance.
	 * 
	 * @param dmo
	 * @param attributeName
	 *           the name of a static or dynamic attribute: local or contextual (embedding a
	 *           {@link DeployModelObject#getFullPath()}).
	 * @return the attribute value or null if the attribute is defined. To find out if an attribute
	 *         is defined use {@link #hasAttribute(DeployModelObject, String)}.
	 * @see #hasAttribute(DeployModelObject, String)
	 */
	public static Object getAttributeValue(DeployModelObject dmo, String attributeName) {
		return getAttributeValue(dmo, getAttribute(dmo, attributeName));
	}

	/**
	 * Returns the value of the static or dynamic deploy model object attribute.
	 * <p>
	 * The method returns null if an attribute is not defined as either static or dynamic. To find
	 * out if an attribute has been defined use {@link #hasAttribute(DeployModelObject, String)}.
	 * 
	 * @param dmo
	 * @param attribute
	 *           a static ({@link EAttribute}) or dynamic ({@link ExtendedAttribute}) structural
	 *           feature of the object.
	 * @return the attribute value or null if the attribute is defined. To find out if an attribute
	 *         is defined use {@link #hasAttribute(DeployModelObject, String)}.
	 * @see #hasAttribute(DeployModelObject, String)
	 */
	public static Object getAttributeValue(DeployModelObject dmo, EAttribute attribute) {
		if (dmo == null || attribute == null) {
			return null;
		}
		if (attribute instanceof ExtendedAttribute) {
			((ExtendedAttribute) attribute).getValue();
		}
		return dmo.eGet(attribute);
	}

	/**
	 * Returns true if the object has a static or dynamic attribute by of the specified name.
	 * <p>
	 * Equivalent to comparing {@link #getAttribute(DeployModelObject, String)} to null.
	 * 
	 * @param dmo
	 *           a deploy object.
	 * @param attributeName
	 *           the name of a static or dynamic attribute.
	 * @return true if a static {@link EAttribute} has been declared or a dynamic
	 *         {@link ExtendedAttribute} of the specified name has been associated with the object.
	 * 
	 * @see #getAttributeValue(DeployModelObject, String)
	 */
	public static boolean hasAttribute(DeployModelObject dmo, String attributeName) {
		return getAttribute(dmo, attributeName) != null;
	}

	/**
	 * Adds an extended attribute of the specified type to the deploy model object.
	 * <p>
	 * If the object already has an extended attribute with the specified name, it will be deleted.
	 * 
	 * @param object
	 *           a deploy model object.
	 * @param attributeName
	 *           the name of the extended attribute.
	 * @param type
	 *           the type of the extended attribute.
	 * @return the extended attribute created.
	 */
	public static ExtendedAttribute createExtendedAttribute(DeployModelObject object,
			String attributeName, EDataType type) {
		ExtendedAttribute attr = object.getExtendedAttribute(attributeName);
		if (attr != null) {
			object.getExtendedAttributes().remove(attr);
		}

		attr = CoreFactory.eINSTANCE.createExtendedAttribute();
		attr.setName(attributeName);
		attr.setInstanceType(type);
		object.getExtendedAttributes().add(attr);
		return attr;
	}

	/**
	 * Returns the static or dynamic attribute of the object associated with the name.
	 * <p>
	 * Static attributes will be instances of {@link EAttribute} and dynamic ones will be instances
	 * of its subtype {@link ExtendedAttribute}.
	 * <p>
	 * Deploy model objects have static EMF attributes defined in {@link DeployModelObject#eClass()}
	 * and dynamic attributes defined in {@link DeployModelObject#getExtendedAttributes()}. This
	 * method first attempts to resolve the attribute name as a static attribute, and then as a
	 * dynamic one.
	 * <p>
	 * The attribute name make be local, or relative to the deploy object. For example, if the
	 * attribute name was created using
	 * {@link #getFullPathToAttribute(DeployModelObject, EAttribute)} then the <code>dmo</code>
	 * object will be used to {@link DeployModelObject#resolve(String)}, and then the attribute will
	 * be retrieved from the specified object. In such cases, the <code>dmo</code> parameter to
	 * this method will typically be a {@link Topology} instance.
	 * 
	 * @param dmo
	 *           a deploy object (may be null).
	 * @param attributeName
	 *           the name of a static or dynamic attribute (may be null).
	 * @return the static or dynamic structural feature associated with the object, or null if not
	 *         found or one of the parameters is null.
	 */
	public static EAttribute getAttribute(DeployModelObject dmo, String attributeName) {
		if (dmo == null || attributeName == null) {
			return null;
		}
		// Handle attribute names embedding a DMO full path
		int index = attributeName.indexOf(IConstants.ATTRIBUTE_SEPARATOR);
		if (index != -1) {
			if (index + 1 == attributeName.length()) {
				return null;
			}
			dmo = dmo.resolve(attributeName.substring(0, index));
			if (dmo == null) {
				return null;
			}
			attributeName = attributeName.substring(index + 1);
		}

		EStructuralFeature feature = dmo.eClass().getEStructuralFeature(attributeName);
		if (feature instanceof EAttribute) {
			return (EAttribute) feature;
		}

		return dmo.getExtendedAttribute(attributeName);
	}

	/**
	 * Sets the value of a static or dynamic deploy model object attribute.
	 * 
	 * @param dmo
	 *           a deploy object.
	 * @param attributeName
	 *           the name of a static or dynamic attribute.
	 * @param value
	 *           the value of the attribute.
	 * @return true if the attribute was set, false if the attribute did not exist and thus could not
	 *         be set, or the type of the value was invalid.
	 */
	public static boolean setAttributeValue(DeployModelObject dmo, String attributeName, Object value) {
		return setAttributeValue(dmo, getAttribute(dmo, attributeName), value);
	}

	/**
	 * Sets the value of a static or dynamic deploy model object attribute.
	 * 
	 * @param dmo
	 *           a deploy object (may be null).
	 * @param attribute
	 *           the static ({@link EAttribute}) or dynamic ({@link ExtendedAttribute}) attribute
	 *           of the object (may be null).
	 * @param value
	 *           the value of the attribute.
	 * @return true if the attribute was set, false if the attribute did not exist and thus could not
	 *         be set, or the type of the value was invalid.
	 */
	public static boolean setAttributeValue(DeployModelObject dmo, EAttribute attribute, Object value) {
		if (dmo == null || attribute == null) {
			return false;
		}

		if (attribute instanceof ExtendedAttribute) {
			ExtendedAttribute ext = (ExtendedAttribute) attribute;
			if (ext != null) {
				if (value == null) {
					ext.setValue(null);
					return true;
				}
				if (ext.getInstanceType() == null || ext.getInstanceType().isInstance(value)) {
					ext.setValue(value);
					return true;
				}
				// types are incompatible
				return false;
			}
		} else if (attribute != null) {
			if (attribute.getEContainingClass() != null
					&& attribute.getEContainingClass().isInstance(dmo)) {

				EDataType attrType = attribute.getEAttributeType();
				Object attrValue = dmo.eGet(attribute);

				if (value == null) {
					if (attrValue instanceof List) {
						((List) attrValue).clear();
					} else {
						dmo.eUnset(attribute);
					}
					return true;
				}

				if (attrValue instanceof List) {
					List attrAsList = (List) attrValue;
					if (value instanceof List) {
						// 'attribute' is List, 'value' is List 
						List valueAsList = (List) value;
						// check that all elements of 'value' (as a List) are of appropriate type
						for (Object v : valueAsList) {
							if (!attrType.isInstance(v)) {
								return false;
							}
						}
						// copy the values from one list to another
						attrAsList.clear();
						for (Object v : valueAsList) {
							attrAsList.add(v);
						}
						return true;
					}
					// attribute value is a List, but 'value' is not
					return false;
				}

				if (value instanceof List) {
					// attribute is single value, value is EcoreEList 
					return false;
				}

				// 'attribute' is single value, 'value' is single value 
				if (attrType.isInstance(value)) {
					dmo.eSet(attribute, value);
					return true;
				}
				// type is incompatible
				return false;
			}
		}
		return false;
	}

	/**
	 * Returns the title describing the object.
	 * <p>
	 * <table>
	 * <tr>
	 * <th>Type
	 * <th>Value
	 * <tr>
	 * <td>{@link Unit}
	 * <td>{@link Unit#title()}
	 * <tr>
	 * <td>{@link Capability}
	 * <td>{@link Capability#title()}
	 * <tr>
	 * <td>other
	 * <td>First non-null value:
	 * <ul>
	 * <li> {@link DeployModelObject#getDisplayName()}
	 * <li> {@link DeployModelObject#getName()}
	 * </ul>
	 * </table>
	 * 
	 * @param object
	 *           a deploy object (may be null).
	 * @return the title of the unit (never null).
	 */
	public static String getTitle(DeployModelObject object) {
		if (object == null) {
			return DeployCoreMessages.null_value;
		}
		if (object instanceof Unit) {
			return ((Unit) object).getCaptionProvider().title((Unit) object);
		}
		if (object instanceof Capability) {
			return ((Capability) object).getCaptionProvider().title((Capability) object);
		}

		if (object instanceof Constraint) {
			return ConstraintService.INSTANCE.title((Constraint) object);
		}

		if (object.getDisplayName() != null) {
			return object.getDisplayName();
		}
		if (object.getName() != null) {
			return object.getName();
		}
		return DeployCoreMessages.null_value;
	}

	/**
	 * Returns a path to the deploy model object including the topology namespace and name.
	 * 
	 * @param object
	 *           a deploy model object.
	 * @return the global URI to the object.
	 */
	public static String getGlobalPath(DeployModelObject object) {
		if (Proxy.isProxyClass(object.getClass())) {
			return object.getFullPath();
		}
		Topology top = object.getTopology();
		if (top == null) {
			return object.getFullPath();
		}
		return top.getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR + object.getFullPath();
	}

	/**
	 * Returns the attribute meta-data associated with the object object attribute, or creates a new
	 * one.
	 * <p>
	 * Note: this method may change the object, and thus should not be invoked on read-only
	 * topologies.
	 * 
	 * @param object
	 *           a deploy object.
	 * @param attribute
	 *           the attribute whose meta-data will be returned or created.
	 * @return the attribute meta-data.
	 */
	public static AttributeMetaData getOrCreateAttributeMetaData(DeployModelObject object,
			String attribute) {
		if (object == null || attribute == null || attribute.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		AttributeMetaData meta = getAttributeMetaData(object, attribute);
		if (meta != null) {
			return meta;
		}
		meta = CoreFactory.eINSTANCE.createAttributeMetaData();
		meta.setAttributeName(attribute);
		object.getAttributeMetaData().add(meta);
		return meta;
	}

	/**
	 * Returns the extended attribute, or creates a new one.
	 * <p>
	 * Note: this method may change the object, and thus should not be invoked on read-only
	 * topologies.
	 * 
	 * @param object
	 *           a deploy object.
	 * @param attributeName
	 *           the extended attribute name.
	 * @param attributeType
	 *           the type of the extended attribute should it be created (may be null).
	 * @return the attribute meta-data.
	 */
	public static ExtendedAttribute getOrCreateExtendedAttribute(DeployModelObject object,
			String attributeName, EDataType attributeType) {
		if (object == null || attributeName == null || attributeName.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		ExtendedAttribute extAttr = object.getExtendedAttribute(attributeName);
		if (extAttr != null) {
			return extAttr;
		}
		extAttr = CoreFactory.eINSTANCE.createExtendedAttribute();
		extAttr.setName(attributeName);
		if (attributeType != null) {
			extAttr.setInstanceType(attributeType);
		}

		object.getExtendedAttributes().add(extAttr);
		return extAttr;
	}

	/*
	 * Extended version of
	 * com.ibm.ccl.soa.deploy.core.DeployModelObject#getAttributeMetaData(java.lang.String)
	 */
	private static AttributeMetaData getAttributeMetaData(DeployModelObject dmo, String attributeName) {
		AttributeMetaData data = dmo.getAttributeMetaData(attributeName);
		if (data == null) {
			// No meta data under the attribute name, but for some rare
			// attributes, such as cpu.architecture,
			// the metadata refers to the XML tag name, not the attribute name.
			data = dmo.getAttributeMetaData(getTagName(dmo.eClass().getEStructuralFeature(
					attributeName)));
			// If data == null, neither method yielded any metadata
		}
		return data;
	}

	/**
	 * Given an ESF, what XML tag name refers to it?
	 */
	private static String getTagName(EStructuralFeature esf) {
		if (esf == null) {
			return null;
		}
		for (Iterator<EAnnotation> it = esf.getEAnnotations().iterator(); it.hasNext();) {
			EAnnotation ann = it.next();
			if (ann == null || ann.getDetails() == null) {
				continue;
			}
			String tagName = ann.getDetails().get("name"); //$NON-NLS-1$
			if (tagName != null) {
				return tagName;
			}
		}

		return null;
	}

	/**
	 * Creates a valid name for the deploy object.
	 * <p>
	 * The method does not set the object's name (no side-effect). Callers should invoke
	 * {@link DeployModelObject#setName(String)} on their own.
	 * <p>
	 * If the deploy object parameter is not null, the name created will be checked for uniqueness
	 * against the object's parent contained deploy model objects.
	 * 
	 * @param proposedName
	 *           a proposed name which will be "cleaned-up" to be valid (non-null)
	 * @return the proposed name without the invalid characters.
	 */
	public static String createDeployModelObjectName(String proposedName) {
		if (proposedName == null) {
			return null;
		}
		StringBuffer b = null;
		for (int i = 0; i < proposedName.length(); i++) {
			char c = proposedName.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				if (b != null) {
					b.append(c);
				}
			} else {
				// ignore but check if we need to copy previously skipped over parts.
				if (b == null) {
					b = new StringBuffer(proposedName.length() - 1);
					if (i > 0) {
						for (int j = 0; j < i; j++) {
							b.append(proposedName.charAt(j));
						}
					}
				}
			}
		}
		if (b != null) {
			return b.toString();
		}
		return proposedName;
	}
}
