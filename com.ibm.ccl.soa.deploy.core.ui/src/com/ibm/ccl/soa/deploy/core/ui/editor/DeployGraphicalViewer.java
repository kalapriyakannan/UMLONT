/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.parts.DomainEventDispatcher;
import org.eclipse.gmf.runtime.diagram.ui.dnd.parts.DiagramGraphicalViewerWithDnD;
import org.eclipse.gmf.runtime.diagram.ui.dnd.parts.DiagramViewerDropAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.ibm.ccl.soa.deploy.core.ui.editparts.NameCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ZoomUtils;

/**
 * @author jswanke
 * 
 */
public class DeployGraphicalViewer extends DiagramGraphicalViewerWithDnD {

	private DeployDomainEventDispatcher eventDispatcher;
	private boolean _leftMousePressed;
	private boolean _primPostNotification;

	protected DomainEventDispatcher getEventDispatcher() {
		return eventDispatcher;
	}

	/**
	 * close tooltip
	 */
	public void closeToolTip() {
		((DeployToolTipHelper) eventDispatcher.getToolTipHelper()).close();
	}

	/**
	 * @param dropAdapter
	 */
	public DeployGraphicalViewer(DiagramViewerDropAdapter dropAdapter) {
		super(dropAdapter);
	}

	public void setEditDomain(EditDomain domain) {
		super.setEditDomain(domain);
		// Set the new event dispatcher, even if the new domain is null.  This will dispose
		// the old event dispatcher.
		getLightweightSystem().setEventDispatcher(
				eventDispatcher = new DeployDomainEventDispatcher(domain, this));
	}

	@Override
	// allow reselect
	public void select(EditPart editpart) {
		// allow reselect
		if (getSelectedEditParts().size() == 1 && getSelectedEditParts().get(0) == editpart) {
			deselect(editpart);
		}
		super.select(editpart);
	}

	@Override
	public void setSelection(ISelection newSelection) {
		if (((StructuredSelection) newSelection).size() == 0) {
			SelectionUtils.unfadeFigures();
		}

		// if multiple editparts selected, don't select the link editparts
		if (newSelection instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) newSelection;
			if (ss.size() > 1) {
				List list = new ArrayList();
				for (Iterator it = ss.toList().iterator(); it.hasNext();) {
					Object o = it.next();
					if (!(o instanceof ConnectionNodeEditPart)) {
						list.add(o);
					}
				}
				if (list.size() > 0) {
					newSelection = new StructuredSelection(list);
				}
			}
		}
		super.setSelection(newSelection);
	}

	@Override
	public void reveal(EditPart part) {
		// to fix 5815
		//PropertyUtils.makeVisible(part);
		if (part instanceof IGraphicalEditPart) {
			ZoomUtils.expose((IGraphicalEditPart) part);
		}
		super.reveal(part);
	}

	@Override
	public ISelection getSelection() {
		// filter out NameCompartmentEditPart's if the parent is also selected
		StructuredSelection ss = (StructuredSelection) super.getSelection();
		List<Object> list = new ArrayList<Object>();
		List<Object> ssList = ss.toList();
		for (Iterator<Object> it = ss.toList().iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof NameCompartmentEditPart) {
				NameCompartmentEditPart nameEP = (NameCompartmentEditPart) o;
				if (ssList.contains(nameEP.getParent())) {
					continue;
				}
			}
			list.add(o);
		}
		return ss.size() == list.size() ? ss : new StructuredSelection(list);
	}

	/**
	 */
	public void leftMousePressed() {
		_leftMousePressed = true;
	}

	/**
	 */
	public void leftMouseMouseReleased() {
		_leftMousePressed = false;
		if (_primPostNotification) {
			_primPostNotification = false;
			super.fireSelectionChanged();
		}
	}

	protected void fireSelectionChanged() {
		if (!_leftMousePressed) {
			super.fireSelectionChanged();
		} else {
			_primPostNotification = true;
		}
	}

}
