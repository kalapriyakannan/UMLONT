/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;

/**
 * A list that can re-associate adds and removals with a list managed by the edited container,
 * rather than a list referenced from another imported container.
 * 
 * @since 1.0
 * 
 */
public class ReassociationList implements EList, EStructuralFeature.Setting,
		CompoundIterator.Modifiable {

	protected final List readOnlyList;
	protected final EList editableList;
	private int modCount = 0;
	private EchoAdapter echoAdapter;
	private final EObject listOwner;
	private final EStructuralFeature listFeature;

	/**
	 * Construct the re-association list with a editable container list and a read-only list
	 * referenced in another container.
	 * 
	 * @param editable
	 * @param readonly
	 */
	public ReassociationList(Notifier container, EStructuralFeature interceptedFeature,
			EStructuralFeature shadowedFeature, DeployModelObject source,
			InstanceConfiguration configuration, EList editable, List readonly) {
		listOwner = source;
		listFeature = shadowedFeature;
		editableList = editable;
		// just to be safe
		readOnlyList = Collections.unmodifiableList(readonly);
		echoAdapter = EchoAdapter.findAdapter(container, interceptedFeature, shadowedFeature, source,
				configuration);
	}

	/**
	 * Construct the re-association list with a editable container list and a read-only list
	 * referenced in another container.
	 * 
	 * @param editable
	 * @param readonly
	 */
	public ReassociationList(Notifier container,
			Map<EStructuralFeature, EStructuralFeature> echoedFeatures, DeployModelObject source,
			InstanceConfiguration configuration, EList editable, List readonly) {

		listOwner = source;
		listFeature = null;
		editableList = editable;
		// just to be safe
		readOnlyList = Collections.unmodifiableList(readonly);
		echoAdapter = EchoAdapter.findAdapter(container, echoedFeatures, source, configuration);
	}

	/**
	 * Construct the re-association list with a editable container list and a read-only list
	 * referenced in another container.
	 * 
	 * @param editable
	 * @param readonly
	 */
	public ReassociationList(EObject owner, EStructuralFeature feature, EList editable, List readonly) {
		listOwner = owner;
		listFeature = feature;
		editableList = editable;
		// just to be safe
		readOnlyList = Collections.unmodifiableList(readonly);

	}

	public int getModCount() {
		return modCount;
	}

	public Iterator iterator() {
		return new CompoundIterator(
				new Iterator[] { editableList.iterator(), readOnlyList.iterator() }, this);
	}

	public ListIterator listIterator() {
		throw new UnsupportedOperationException("Not yet implemented."); //$NON-NLS-1$
	}

	public ListIterator listIterator(int index) {
		throw new UnsupportedOperationException("Not yet implemented."); //$NON-NLS-1$
	}

	public Object set(int arg0, Object arg1) {
		throw new UnsupportedOperationException("Not yet implemented."); //$NON-NLS-1$
	}

	public List subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException("Not yet implemented."); //$NON-NLS-1$
	}

	public Object[] toArray() {
		Object[] containerarray = editableList.toArray();
		Object[] unitarray = readOnlyList.toArray();
		Object[] array = new Object[containerarray.length + unitarray.length];
		System.arraycopy(containerarray, 0, array, 0, containerarray.length);
		System.arraycopy(unitarray, 0, array, containerarray.length, unitarray.length);
		return array;

	}

	public Object[] toArray(Object[] newArray) {

		Object[] containerarray = editableList.toArray((Object[]) java.lang.reflect.Array
				.newInstance(newArray.getClass().getComponentType(), 0));
		Object[] unitarray = readOnlyList.toArray((Object[]) java.lang.reflect.Array.newInstance(
				newArray.getClass().getComponentType(), 0));

		if (newArray.length < size()) {
			newArray = (Object[]) java.lang.reflect.Array.newInstance(newArray.getClass()
					.getComponentType(), size());
		}

		System.arraycopy(containerarray, 0, newArray, 0, containerarray.length);
		System.arraycopy(unitarray, 0, newArray, containerarray.length, unitarray.length);

		return newArray;
	}

	public boolean add(Object added) {
		++modCount;
		return editableList.add(added);
	}

	public void add(int index, Object added) {
		++modCount;
		editableList.add(index, added);
	}

	public boolean addAll(Collection added) {
		++modCount;
		return editableList.addAll(added);
	}

	public boolean addAll(int index, Collection added) {
		++modCount;
		return editableList.addAll(index, added);
	}

	public void clear() {
		++modCount;
		editableList.clear();
	}

	public boolean contains(Object contained) {
		return editableList.contains(contained) || readOnlyList.contains(contained);
	}

	public boolean containsAll(Collection contained) {
		for (Iterator iterator = contained.iterator(); iterator.hasNext();) {
			Object obj = iterator.next();
			if (!editableList.contains(obj) && !readOnlyList.contains(obj)) {
				return false;
			}
		}
		return true;
	}

	public boolean removeAll(Collection contained) {
		++modCount;
		List removed = new ArrayList();
		for (Iterator iterator = editableList.iterator(); iterator.hasNext();) {
			Object obj = iterator.next();
			if (contained.contains(obj)) {
				removed.add(obj);
			} else if (readOnlyList.contains(obj)) {
				throw new IllegalArgumentException(
						"An attempt was made to remove " + obj + ", which may not be removed."); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		if (!removed.isEmpty()) {
			return editableList.removeAll(removed);
		}
		return false;
	}

	public boolean retainAll(Collection arg0) {
		++modCount;
		throw new UnsupportedOperationException("Not yet implemented."); //$NON-NLS-1$
	}

	public Object get(int index) {
		if (index < 0 || index > editableList.size() + readOnlyList.size()) {
			throw new IndexOutOfBoundsException(
					"Requested Index: " + index + " Max Length: " + (editableList.size() + readOnlyList.size())); //$NON-NLS-1$//$NON-NLS-2$
		}
		if (index < editableList.size()) {
			return editableList.get(index);
		}
		return readOnlyList.get(index - editableList.size());
	}

	public int indexOf(Object o) {
		int indxOf = -1;
		if ((indxOf = editableList.indexOf(o)) > -1) {
			return indxOf;
		} else if ((indxOf = readOnlyList.indexOf(o)) > -1) {
			return indxOf + editableList.size();
		}
		return -1;
	}

	public boolean isEmpty() {
		return editableList.isEmpty() && readOnlyList.isEmpty();
	}

	public int lastIndexOf(Object o) {
		int lastIndxOf = -1;
		if ((lastIndxOf = readOnlyList.lastIndexOf(o)) > -1) {
			return editableList.size() + lastIndxOf;
		}
		return editableList.lastIndexOf(o);
	}

	public boolean remove(Object o) {
		++modCount;
		if (readOnlyList.contains(o)) {
			throw new UnsupportedOperationException(
					"Elements from the delegated portion of the list may not be removed."); //$NON-NLS-1$
		}
		return editableList.remove(o);
	}

	public Object remove(int index) {
		++modCount;
		if (index < editableList.size()) {
			return editableList.remove(index);
		}
		throw new IndexOutOfBoundsException(
				"Cannot remove elements from the delegated portion of the list."); //$NON-NLS-1$
	}

	public int size() {
		return editableList.size() + readOnlyList.size();
	}

	@Override
	public String toString() {
		// I wanted to cast 'this' to List<?> to eliminate a compiler warning, but
		// when I save the file the code beautifier removes the cast...
		List<?> list = new LinkedList<Object>(this);
		return list.toString();
	}

	public void move(int newPosition, Object object) {
		move(newPosition, indexOf(object));

	}

	public Object move(int targetIndex, int sourceIndex) {

		int size = editableList.size();
		++modCount;
		if (targetIndex >= editableList.size()) {
			throw new IndexOutOfBoundsException("targetIndex=" + targetIndex + ", size=" + size); //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (sourceIndex >= editableList.size()) {
			throw new IndexOutOfBoundsException("sourceIndex=" + sourceIndex + ", size=" + size); //$NON-NLS-1$ //$NON-NLS-2$
		}

		return editableList.move(targetIndex, sourceIndex);
	}

	public boolean isSet() {
		return !isEmpty();
	}

	public void set(Object newValue) {
		clear();
		addAll((List) newValue);

	}

	public void unset() {
		clear();

	}

	public Object get(boolean resolve) {
		return this;
	}

	public EObject getEObject() {
		return listOwner;
	}

	public EStructuralFeature getEStructuralFeature() {
		return listFeature;
	}

}
