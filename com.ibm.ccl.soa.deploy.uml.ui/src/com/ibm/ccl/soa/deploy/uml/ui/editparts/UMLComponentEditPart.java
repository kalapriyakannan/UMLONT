package com.ibm.ccl.soa.deploy.uml.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.uml.ui.figures.UMLComponentFigure;
import com.ibm.ccl.soa.deploy.uml.ui.internal.UmlUIMessages;

public class UMLComponentEditPart extends ModuleEditPart {

	public UMLComponentEditPart(View view) {
		super(view);
		setCategory(UmlUIMessages.UMLComponentEditPart_UmlComp_);
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = new UMLComponentFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
