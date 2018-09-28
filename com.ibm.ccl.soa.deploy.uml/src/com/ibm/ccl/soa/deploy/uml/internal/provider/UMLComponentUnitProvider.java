package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Component;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

public class UMLComponentUnitProvider extends UMLElementUnitProvider {

	@Override
	public Object[] resolveUnit(TopologyUnitStub stub, boolean toResolveLazily,
			IProgressMonitor monitor) {

		SoftwareComponent umlComp = CoreFactory.eINSTANCE.createSoftwareComponent();
		Component comp = (Component) stub.getInput();
		umlComp.setName(UnitUtil.fixNameForID(comp.getName()));
		umlComp.setDisplayName(getDisplayName(comp.getName()));
		umlComp.setConceptual(true);
		setRequirementsAndCapabilities(umlComp, comp);
		umlComp.getStereotypes().addAll(getStereotypes(comp));

		addUMLElementArtifact(umlComp, comp, stub.getTopology());

		return new DeployModelObject[] { umlComp };
	}
}
