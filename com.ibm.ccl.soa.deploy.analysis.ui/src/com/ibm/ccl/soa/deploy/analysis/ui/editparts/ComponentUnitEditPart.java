package com.ibm.ccl.soa.deploy.analysis.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.analysis.ui.figures.AnalysisFigureFactory;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitGroupEditPart;
import com.ibm.ccl.soa.deploy.analysis.ui.internal.AnalysisUIMessages;

public class ComponentUnitEditPart extends UnitGroupEditPart  {
	public ComponentUnitEditPart(View view) {
		super(view);
		setCategory(AnalysisUIMessages.ComponentUnitEditPart_Componen_);
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = AnalysisFigureFactory.createNewComponentUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
