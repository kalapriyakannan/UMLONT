/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.extension.EncService;

/**
 * An XMLHelper with support for encrypting attributes with metadata annotation during saving.
 * During loading, when metadata is encountered, backtracks and decrypts attributes on the parent.
 * 
 * @author Ed Snible <snible@us.ibm.com>
 * @see CoreResourceImpl
 */
public class DeployEncryptingXmlHelper extends XMLHelperImpl {
	private EncService crypto;

	/**
	 * @param res
	 */
	public DeployEncryptingXmlHelper(XMLResource res) {
		super(res);

		this.crypto = EncService.INSTANCE;
	}

	/**
	 * Returns the {@link Topology} contained in the resource.
	 * 
	 * @return the topology contained in the resource, or null if not found.
	 */
	protected Topology getTopology() {
		if ((resource.getContents().size() > 0)
				&& (resource.getContents().get(0) instanceof DeployCoreRoot)) {
			return ((DeployCoreRoot) resource.getContents().get(0)).getTopology();
		}
		return null;
	}

	/**
	 * Returns the EMF packages instantiated in the resource.
	 * <p>
	 * Overrides the default behavior of {@link XmlHelperImpl#packages()} to add packages included
	 * only via {@link Requirement#getDmoEType()}.
	 * 
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl#packages()
	 */
	public EPackage[] packages() {
		EPackage[] array = super.packages();

		Topology top = getTopology();
		if (top == null) {
			return array;
		}
		List list = new ArrayList();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		boolean packageAdded = false;
		for (Iterator iter = top.findAllRequirements(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			if ((req.getDmoEType() != null) && (!list.contains(req.getDmoEType().getEPackage()))) {
				packageAdded = true;
				list.add(req.getDmoEType().getEPackage());
			}
		}
		if (!packageAdded) {
			return array;
		}

		Collections.sort(list, new Comparator() {
			public int compare(Object epkg1, Object epkg2) {
				String prefix1 = getPrefix((EPackage) epkg1);
				String prefix2 = getPrefix((EPackage) epkg2);
				if (prefix1 == null) {
					return prefix2 == null ? 0 : 1;
				}
				if (prefix2 == null) {
					return -1;
				}
				return prefix1.compareTo(prefix2);
			}
		});

		return (EPackage[]) list.toArray(new EPackage[list.size()]);
	}

	public Object getValue(EObject obj, EStructuralFeature f) {
		Object retVal = super.getValue(obj, f);

		if (shouldEncrypt(obj, f)) {
			retVal = encrypt(retVal);
		}

		return retVal;
	}

	public void setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		// Although password fields are decorated with AttributeMetaData.encrypted=true, that
		// decoration isn't yet loaded.  So there is no point in checking shouldEncrypt() here.
//		if (shouldEncrypt(object, feature)) {
//			value = decrypt(value);
//		}

		handleApplyingEncryptionMetadata(object, feature, value);

		super.setValue(object, feature, value, position);
	}

	/**
	 * If 'value' is AttributeMetaData we assume the feature is 'attributeMetaData' and attempt to
	 * decrypt the previously-loaded attribute the metadata refers to.
	 * 
	 * @param object
	 * @param feature
	 * @param value
	 */
	private void handleApplyingEncryptionMetadata(EObject object, EStructuralFeature feature,
			Object value) {
		// Do nothing if we are not applying metadata
		if (!(value instanceof AttributeMetaData)) {
			return;
		}

		// Do nothing if metadata doesn't indicate encryption
		AttributeMetaData amd = (AttributeMetaData) value;
		if (!amd.isEncrypted()) {
			return;
		}

		// We are loading metadata that specifies a previously loaded field was encrypted.
		// Go back and decrypt it.

		// Impossible to decrypt a non-attribute or null
		EStructuralFeature esf = object.eClass().getEStructuralFeature(amd.getAttributeName());
		if (!(esf instanceof EAttribute)) {
			return;
		}

		// If it isn't a String we can't decrypt
		Object encryptedValue = object.eGet(esf);
		if (!(encryptedValue instanceof String)) {
			return;
		}

		try {
			String decrypted = crypto.decrypt((String) encryptedValue);
			object.eSet(esf, decrypted);
		} catch (IllegalArgumentException iae) {
			// Do nothing.  The 'encrypted' value couldn't be decrypted.  Perhaps
			// this is a legacy file before encryption, or hand edited.  Leave the
			// value alone.
		}
	}

	private boolean shouldEncrypt(EObject obj, EStructuralFeature f) {
		// Only DMOs can be tagged to encrypt their features
		if (!(obj instanceof DeployModelObject)) {
			return false;
		}

		// Only attributes can be encrypted
		if (!(f instanceof EAttribute)) {
			return false;
		}

		return DeployModelObjectUtil.isEncrypted((DeployModelObject) obj, (EAttribute) f);
	}

	private Object encrypt(Object value) {
		// Don't encrypt non-strings
		if (!(value instanceof String)) {
			return value;
		}

		return crypto.encrypt((String) value);
	}

} // end class DeployEncryptingXmlHelper
