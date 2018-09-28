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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;

public class DynamicFeatureAwareList implements EList {

	private static final int END = -1;

	private final EStructuralFeature feature;
	private final IDynamicFeatureMapStrategy resolver;

	public DynamicFeatureAwareList(InstanceConfiguration configuration, DeployModelObject source,
			EStructuralFeature feature) {
		this(feature, new AugmentationFeatureMapStrategy(configuration, source, feature));
	}

	public DynamicFeatureAwareList(EStructuralFeature feature, IDynamicFeatureMapStrategy resolver) {
		this.feature = feature;
		this.resolver = resolver;
	}

	public void add(int index, Object o) {
		createEditableList().add(index, o);
	}

	public boolean add(Object o) {
		return createEditableList().add(o);
	}

	public boolean addAll(Collection c) {
		return createEditableList().addAll(END, c);
	}

	public boolean addAll(int index, Collection c) {
		return createEditableList().addAll(index, c);
	}

	public void clear() {
		getEditableList().clear();
	}

	public boolean contains(Object o) {
		return getEditableList().contains(o);
	}

	public boolean containsAll(Collection c) {
		return getEditableList().containsAll(c);
	}

	public Object get(int index) {
		Object o = getEditableList().get(index);
		if (o instanceof FeatureMap.Entry) {
			return ((FeatureMap.Entry) o).getValue();
		}
		return o;
	}

	public int indexOf(Object o) {
		return getEditableList().indexOf(o);
	}

	public boolean isEmpty() {
		return getEditableList().isEmpty();
	}

	public Iterator iterator() {
		if (getFeatureMap() != null) {
			return new ValueIterator(feature, resolver.resolveFeatureMap());
		}
		return Collections.emptyList().iterator();
	}

	public int lastIndexOf(Object o) {
		return getEditableList().lastIndexOf(o);
	}

	public ListIterator listIterator() {
		if (getFeatureMap() != null) {
			return new ValueIterator(feature, resolver.resolveFeatureMap());
		}
		return Collections.emptyList().listIterator();
	}

	public ListIterator listIterator(int index) {
		if (getFeatureMap() != null) {
			return new ValueIterator(feature, resolver.resolveFeatureMap(), index);
		}
		return Collections.emptyList().listIterator();
	}

	public Object remove(int index) {

		Object o = getEditableList().remove(index);
		if (o instanceof FeatureMap.Entry) {
			return ((FeatureMap.Entry) o).getValue();
		}
		return o;
	}

	public boolean remove(Object o) {
		if (o == null) {
			return false;
		}
		// there must be data if this returns a valid list .		
		if (getEditableList() != null && getFeatureMap() != null) {
			for (Iterator<FeatureMap.Entry> iterator = getFeatureMap().iterator(); iterator.hasNext();) {
				FeatureMap.Entry entry = iterator.next();
				if (o.equals(entry.getValue())) {
					iterator.remove();
					return true;
				}
			}
		}
		return false;
	}

	public boolean removeAll(Collection c) {
		if (c == null || c.isEmpty()) {
			return false;
		}
		boolean removed = false;
		// there must be data if this returns a valid list .		
		if (getEditableList() != null) {
			for (Iterator<FeatureMap.Entry> iterator = getFeatureMap().iterator(); iterator.hasNext();) {
				FeatureMap.Entry entry = iterator.next();
				if (c.contains(entry.getValue())) {
					iterator.remove();
					removed = true;
				}
			}
		}
		return removed;
	}

	public boolean retainAll(Collection c) {
		return getEditableList().retainAll(c);
	}

	public Object set(int index, Object element) {
		return createEditableList().set(index, element);
	}

	public int size() {
		return getEditableList().size();
	}

	public List subList(int fromIndex, int toIndex) {
		return getEditableList().subList(fromIndex, toIndex);
	}

	public Object[] toArray() {

		Object[] data = getEditableList().toArray();
		Object[] parsed = new Object[data.length];
		for (int i = 0; i < data.length; i++) {
			if (data[i] instanceof FeatureMap.Entry) {
				parsed[i] = ((FeatureMap.Entry) data[i]).getValue();
			} else {
				parsed[i] = data[i];
			}
		}
		return parsed;
	}

	public Object[] toArray(Object[] a) {

		Object[] data = getEditableList().toArray();
		Object[] parsed = a.length == data.length ? a : (Object[]) java.lang.reflect.Array
				.newInstance(a.getClass().getComponentType(), data.length);
		for (int i = 0; i < data.length; i++) {
			if (data[i] instanceof FeatureMap.Entry) {
				parsed[i] = ((FeatureMap.Entry) data[i]).getValue();
			} else {
				parsed[i] = data[i];
			}
		}
		return parsed;
	}

	private List getEditableList() {
		return resolver.getEditableList();
	}

	private EList createEditableList() {
		return resolver.createEditableList();
	}

	private FeatureMap.Internal getFeatureMap() {
		return resolver.getFeatureMap();
	}

	private static class ValueIterator extends FeatureMapUtil.BasicFeatureEIterator {

		private final FeatureMap.Entry[] TYPE = new FeatureMap.Entry[0];

		public ValueIterator(EStructuralFeature structuralFeature, FeatureMap.Internal featureMap) {
			super(structuralFeature, featureMap);
			isFeatureMap = false;
		}

		public ValueIterator(EStructuralFeature structuralFeature, FeatureMap.Internal featureMap,
				int initCursor) {
			super(structuralFeature, featureMap);
			isFeatureMap = false;
			entryCursor = initCursor;
		}

		@Override
		protected boolean scanNext() {
			FeatureMap.Entry[] entries = featureMap.basicList().toArray(TYPE);
			if (entryCursor < featureMap.size()) {
				FeatureMap.Entry entry = entries[entryCursor];
				preparedResult = entry.getValue();
				prepared = 2;
				return true;
			}

			prepared = 1;
			lastCursor = -1;
			return false;

		}

		protected boolean scanPrevious() {
			FeatureMap.Entry[] entries = featureMap.basicList().toArray(TYPE);
			while (--entryCursor >= 0) {
				FeatureMap.Entry entry = entries[entryCursor];
				if (entry.getEStructuralFeature() == eStructuralFeature) {
					preparedResult = entry.getValue();
					prepared = -2;
					return true;
				}
			}

			prepared = -1;
			lastCursor = -1;
			return false;
		}

	}

	public void move(int newPosition, Object object) {
		createEditableList().move(newPosition, object);
	}

	public Object move(int newPosition, int oldPosition) {
		return createEditableList().move(newPosition, oldPosition);
	}
}
