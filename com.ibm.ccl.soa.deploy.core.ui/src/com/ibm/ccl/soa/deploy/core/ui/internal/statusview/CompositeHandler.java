/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatusGrouper;

public abstract class CompositeHandler {

	protected FormToolkit toolKit;
	protected Section section;
	private final Composite clientComposite;
	protected Composite sectionClient;
	private final List<IStatusListener> statusListeners = new ArrayList<IStatusListener>();

	public CompositeHandler(FormToolkit toolKit, Section section) {
		this.toolKit = toolKit;
		this.section = section;
		clientComposite = createClientComposite();
	}

	protected abstract Composite createClientComposite();

	public Composite getClientComposite() {
		return clientComposite;
	}

	public void expandSection() {
		section.setExpanded(true);
	}

	public void refresh() {
		sectionClient.layout();
		section.layout();
	}

	public void enable(boolean enable) {
		sectionClient.setEnabled(enable);
	}

	public void update(DeployStatusGrouper grouper, boolean shouldUpdateTitle) {
		refresh();

	}

	public void addStatusListener(IStatusListener statusListener) {
		statusListeners.add(statusListener);

	}

	protected void notifyListeners(int type, boolean shouldFilter) {
		StatusEvent event = new StatusEvent();
		event.setSeverityType(type);
		event.setShouldFilter(shouldFilter);
		for (Iterator iterator = statusListeners.iterator(); iterator.hasNext();) {
			IStatusListener listener = (IStatusListener) iterator.next();
			listener.statusChange(event);
		}

	}

}
