package com.ibm.ccl.soa.deploy.analysis.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.analysis.ui.figures.AnalysisFigureFactory;
import com.ibm.ccl.soa.deploy.analysis.ui.internal.AnalysisUIMessages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitGroupEditPart;

public class LocationUnitEditPart extends UnitGroupEditPart  {
	public LocationUnitEditPart(View view) {
		super(view);
		setCategory(AnalysisUIMessages.LocationUnitEditPart_LocationUni_);
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = AnalysisFigureFactory.createNewLocationUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
