/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList;

/**
 * This is a specialized list which is used for dealing with substitution groups when serializing to
 * XML. This list works in conjunction with
 * {@link com.ibm.ccl.soa.deploy.internal.core.FeatureAdapter}.
 * 
 * @since 7.0
 * @see com.ibm.ccl.soa.deploy.internal.core.FeatureAdapter
 * 
 */
public class FeatureAwareList extends FeatureEList implements EStructuralFeature.Setting {

	private static final int END = -1;

	private final InternalEList modelList;

	/**
	 * Create a specialized {@link EList} which can is used to automatically detect and use the
	 * proper {@link EStructuralFeature} defined for a substitution group element for any given
	 * {@link EObject}.
	 * 
	 * @param anAbstractFeature -
	 *           This is the EStructuralFeature which is the base feature for the substitution group.
	 * @param aFeatureMap -
	 *           This is the FeatureMap for managing the substitution group.
	 */
	public FeatureAwareList(EStructuralFeature anAbstractFeature, FeatureMap.Internal aFeatureMap) {
		super(anAbstractFeature, aFeatureMap);
		feature = anAbstractFeature;
		featureMap = aFeatureMap;
		modelList = (InternalEList) featureMap.list(feature);
	}

	public void add(int index, Object o) {
		if (o instanceof EObject) {
			EObject eObj = (EObject) o;

			EStructuralFeature subfeature = FeatureAdapter.getFeature(eObj, feature);
			assert subfeature != null;

			featureMap.list(subfeature).add(index, eObj);
		}
		featureMap.list(feature).add(index, o);
	}

	public boolean add(Object o) {
		if (o instanceof EObject) {
			EObject eObj = (EObject) o;

			EStructuralFeature subfeature = FeatureAdapter.getFeature(eObj, feature);
			assert subfeature != null;

			return featureMap.list(subfeature).add(eObj);
		}
		return featureMap.list(feature).add(o);
	}

	public boolean addAll(Collection c) {
		return addAll(END, c);
	}

	public boolean addAll(int index, Collection c) {
		int initialSize = featureMap.size();
		//We must get an array because the passed collection will change size if it 
		//is a FeatureAwareList.
		Object[] cArray = c.toArray();
		for (int i = 0; cArray.length > i; i++) {
			Object o = cArray[i];
			if (o instanceof EObject) {
				EObject eObj = (EObject) o;

				EStructuralFeature subfeature = FeatureAdapter.getFeature(eObj, feature);
				assert subfeature != null;

				if (index == END) {
					featureMap.list(subfeature).add(eObj);
				} else {
					featureMap.list(subfeature).add(index, eObj);
				}
			} else {
				if (index == END) {
					featureMap.add(feature, o);
				} else {
					featureMap.add(feature, index, o);
				}
			}
		}
		return featureMap.size() > initialSize;
	}

	public void clear() {
		modelList.clear();
	}

	public boolean contains(Object o) {
		return modelList.contains(o);
	}

	public boolean containsAll(Collection c) {
		return modelList.containsAll(c);
	}

	public boolean equals(Object o) {
		return modelList.equals(o);
	}

	public Object get(int index) {
		return modelList.get(index);
	}

	public int hashCode() {
		return modelList.hashCode();
	}

	public int indexOf(Object o) {
		return modelList.indexOf(o);
	}

	public boolean isEmpty() {
		return modelList.isEmpty();
	}

	public Iterator iterator() {
		return modelList.iterator();
	}

	public int lastIndexOf(Object o) {
		return modelList.lastIndexOf(o);
	}

	public ListIterator listIterator() {
		return modelList.listIterator();
	}

	public ListIterator listIterator(int index) {
		return modelList.listIterator(index);
	}

	public Object remove(int index) {
		return modelList.remove(index);
	}

	public boolean remove(Object o) {
		return modelList.remove(o);
	}

	public boolean removeAll(Collection c) {
		return modelList.removeAll(c);
	}

	public boolean retainAll(Collection c) {
		return modelList.retainAll(c);
	}

	public Object set(int index, Object element) {
		return modelList.set(index, element);
	}

	public int size() {
		return modelList.size();
	}

	public List subList(int fromIndex, int toIndex) {
		return modelList.subList(fromIndex, toIndex);
	}

	public Object[] toArray() {
		return modelList.toArray();
	}

	public Object[] toArray(Object[] a) {
		return modelList.toArray(a);
	}

	public void move(int newPosition, Object object) {
		modelList.move(newPosition, object);
	}

	public Object move(int newPosition, int oldPosition) {
		return modelList.move(newPosition, oldPosition);
	}

	public Object basicGet(int index) {
		return modelList.basicGet(index);
	}

	public List basicList() {
		return modelList.basicList();
	}

	public Iterator basicIterator() {
		return modelList.basicIterator();
	}

	public ListIterator basicListIterator() {
		return modelList.basicListIterator();
	}

	public ListIterator basicListIterator(int index) {
		return modelList.basicListIterator(index);
	}

	public NotificationChain basicRemove(Object object, NotificationChain notifications) {
		return modelList.basicRemove(object, notifications);
	}

	public NotificationChain basicAdd(Object object, NotificationChain notifications) {
		return modelList.basicAdd(object, notifications);
	}

	public void addUnique(Object object) {
		modelList.addUnique(object);
	}

	public void addUnique(int index, Object object) {
		modelList.addUnique(index, object);
	}

	public Object setUnique(int index, Object object) {
		return modelList.setUnique(index, object);
	}

}
