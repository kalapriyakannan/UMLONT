/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

/**
 * A FeatureAdapter provides the feature that a given EObject should be persisted as. Each feature
 * represents a possible substitution group from a (potentially) custom package.
 * 
 * <p>
 * <b>Usage:</b> <table>
 * <tr>
 * <td> <code>
 * ACustomModelImplementation implementation = 
 * 		ACustomModelFactory.eINSTANCE.createACustomModelImplementation();
 * implementation.setCustomProperty(...);
 * 
 * FeatureAdapter.setFeature(implementation, 
 * 		ACustomModelPackage.eINSTANCE.getDocumentRoot_ImplementationACustomModel());
 * </code>
 * </td>
 * </tr>
 * </table>
 * <p>
 * For more information, take a look at Properties Implementation in <i>com.ibm.ccl.soa.core.tests</i>.
 * In that plugin, see schemas/ for defining the EMF model, and props-ext-model/ for the generated
 * version of the model.
 * </p>
 * 
 * </p>
 * 
 * @since 7.0
 * 
 */
public final class FeatureAdapter extends AdapterImpl implements Adapter {

	private static final Map featureAdapters = new WeakHashMap();

	/**
	 * The adapter type to search for when looking for the FeatureAdapter.
	 * 
	 * @see EcoreUtil#getAdapter(java.util.List, java.lang.Object)
	 */
	public static final String ADAPTER_TYPE = FeatureAdapter.class.getName();

	/**
	 * 
	 * <p>
	 * This method may return null.
	 * </p>
	 * 
	 * @param anObject
	 *           The object representing a substitution group.
	 * @param modelFeature
	 *           The feature being set on anObject.
	 * @return The structural feature that should be used for the feature map when setting this
	 *         implementation.
	 */
	public static EStructuralFeature getFeature(EObject anObject, EStructuralFeature modelFeature) {
		FeatureAdapter adapter = findAdapter(anObject);
		if (adapter == null) {
			EClass eClass = anObject.eClass();
			adapter = findAdapter(eClass);
			if (adapter == null) {
				initializeFeatureAdaptersForPackage(eClass.getEPackage());
				// Locate the adapter for this eClass again, should be there now
				adapter = findAdapter(eClass);
			}
		}
		return adapter == null ? null : adapter.getFeature(modelFeature);
	}

	private static void initializeFeatureAdaptersForPackage(EPackage ePackage) {
		EClass docRoot = FeatureAdapter.getDocumentRootForPackage(ePackage);
		if (docRoot != null) {
			List list = docRoot.getEReferences();
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				// Add feature adapater to each reference
				EReference ref = (EReference) iter.next();
				EClassifier type = ref.getEType();
				FeatureAdapter.setFeature(type, ref);
			}
		}
	}

	/**
	 * Locate the document root classifier in a specified ePackage.
	 * <p>
	 * This method may return null.
	 * </p>
	 * 
	 * 
	 * @param ePackage
	 *           The package
	 * @return The EClass representing the document root of the package
	 */
	public static EClass getDocumentRootForPackage(EPackage ePackage) {
		// Find the document root classifier for this Epackage
		// annotation kind = "mixed", name is empty
		Iterator classifiers = ePackage.getEClassifiers().iterator();
		while (classifiers.hasNext()) {
			EClassifier classifier = (EClassifier) classifiers.next();
			EAnnotation annotation = classifier.getEAnnotations().get(0); //Look in all annotations?
			String kind = annotation.getDetails().get("kind"); //$NON-NLS-1$
			String name = annotation.getDetails().get("name"); //$NON-NLS-1$
			if (kind != null && name != null) {
				if (kind.equals("mixed") && name.equals("")) { //$NON-NLS-1$ //$NON-NLS-2$
					return (EClass) classifier;
				}
			}
		}

		return null;
	}

	/**
	 * Add a FeatureAdapter on the given object for the given feature if not already present. An
	 * invocation of this method for a feature already noted on the object will not result in any
	 * modifications.
	 * 
	 * @param anObject
	 *           The object representing a substitution group.
	 * @param aFeature
	 *           The feature that represents how the element should be persisted.
	 */
	private static void setFeature(EObject anObject, EStructuralFeature aFeature) {
		if (anObject != EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY) {
			synchronized (anObject) {
				FeatureAdapter adapter = findAdapter(anObject);
				if (adapter == null) {
					adapter = getAdapterForFeature(aFeature);
					anObject.eAdapters().add(adapter);
				} else {
					adapter.addFeature(aFeature);
				}
			}
		}
	}

	/**
	 * 
	 * @param anObject
	 *           The object to search for the FeatureAdapter.
	 * @return The adapter for {@link #ADAPTER_TYPE} from the given object, or null if not found.
	 */
	public static FeatureAdapter findAdapter(EObject anObject) {
		return (FeatureAdapter) EcoreUtil.getAdapter(anObject.eAdapters(), ADAPTER_TYPE);
	}

	private static FeatureAdapter getAdapterForFeature(EStructuralFeature aFeature) {
		FeatureAdapter adapter = (FeatureAdapter) featureAdapters.get(aFeature);
		if (adapter != null) {
			return adapter;
		}
		synchronized (featureAdapters) {
			adapter = (FeatureAdapter) featureAdapters.get(aFeature);
			if (adapter == null) {
				featureAdapters.put(aFeature, (adapter = new FeatureAdapter(aFeature)));
			}
		}
		return adapter;
	}

	private EStructuralFeature[] features;

	private FeatureAdapter(EStructuralFeature aFeature) {
		features = new EStructuralFeature[] { aFeature };
	}

	public boolean isAdapterForType(Object type) {
		return type == ADAPTER_TYPE;
	}

	/**
	 * @return The structural feature held by this FeatureAdapter which is a substitutable for the
	 *         passed modelFeature.
	 */
	public EStructuralFeature getFeature(EStructuralFeature modelFeature) {
		if (features == null) {
			return null;
		}
		if (features.length == 1 || modelFeature == null) {
			return features[0];
		}
		EStructuralFeature feature = getAffiliatedFeature(modelFeature);
		return feature != null ? feature : features[0];
	}

	private EStructuralFeature getAffiliatedFeature(EStructuralFeature modelFeature) {
		EStructuralFeature foundFeature = null;
		//EStructuralFeature group = ExtendedMetaData.INSTANCE.getGroup(modelFeature);
		String namespace = ExtendedMetaData.INSTANCE.getNamespace(modelFeature);
		String name = ExtendedMetaData.INSTANCE.getName(modelFeature);
		EStructuralFeature baseAffiliation = ExtendedMetaData.INSTANCE.getElement(namespace, name);
		if (baseAffiliation != null) {
			for (int i = 0; i < features.length; i++) {
				EStructuralFeature feature = features[i];
				if (feature != null) {
					EStructuralFeature affiliation = ExtendedMetaData.INSTANCE.getAffiliation(feature);
					if (affiliation != null && baseAffiliation == affiliation) {
						foundFeature = feature;
						break;
					}
				}
			}
		}
		return foundFeature;
	}

	private boolean hasFeature(EStructuralFeature feature) {
		if (features != null) {
			for (int i = 0; i < features.length; i++) {
				if (features[i] == feature) {
					return true;
				}
			}
		}
		return false;
	}

	private void addFeature(EStructuralFeature feature) {
		if (feature != null) {
			if (features == null) {
				features = new EStructuralFeature[] { feature };
			} else if (!hasFeature(feature)) {
				EStructuralFeature[] newFeatures = new EStructuralFeature[features.length + 1];
				newFeatures[features.length] = feature;
				System.arraycopy(features, 0, newFeatures, 0, features.length);
				features = newFeatures;
			}
		}
	}
}
