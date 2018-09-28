package com.ibm.ccl.soa.deploy.analysis.ui.editparts;

import java.util.Iterator;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.analysis.Deployment;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet;
import com.ibm.ccl.soa.deploy.analysis.ui.figures.AnalysisFigureFactory;
import com.ibm.ccl.soa.deploy.analysis.ui.internal.AnalysisUIMessages;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;

public class DeploymentUnitEditPart extends ModuleEditPart{
	/**
	 * @param view
	 */
	public DeploymentUnitEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}
		if (unit instanceof DeploymentUnit) {
			Iterator it = unit.getCapabilities().iterator();
			Deployment depCap = null;
			while (it.hasNext()) {
				Capability capability = (Capability) it.next();
				if (capability instanceof Deployment) {
					depCap = (Deployment) capability;
					if(depCap.getFacet() == DeploymentUnitFacet.PRESENTATION_LITERAL){
						setCategory(AnalysisUIMessages.DeploymentUnitEditPart_PresentationDeploymentUni_);
					}else if(depCap.getFacet() == DeploymentUnitFacet.DATA_LITERAL){
						setCategory(AnalysisUIMessages.DeploymentUnitEditPart_DataDeploymentUni_);
					}else if(depCap.getFacet() == DeploymentUnitFacet.EXECUTION_LITERAL){
						setCategory(AnalysisUIMessages.DeploymentUnitEditPart_ExecutionDeploymentUni_);
					}else{
						setCategory(AnalysisUIMessages.DeploymentUnitEditPart_Deployment_Uni_);
					}
					break;
				}
			}
			
		} 
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = AnalysisFigureFactory.createNewDeploymentUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
