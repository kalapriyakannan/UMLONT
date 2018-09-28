package com.ibm.ccl.soa.deploy.uml.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.uml.ui.figures.UMLActorFigure;
import com.ibm.ccl.soa.deploy.uml.ui.internal.UmlUIMessages;

public class UMLActorEditPart extends ModuleEditPart {

	public UMLActorEditPart(View view) {
		super(view);
		setCategory(UmlUIMessages.UMLActorEditPart_UmlActor_);
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = new UMLActorFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}

}
