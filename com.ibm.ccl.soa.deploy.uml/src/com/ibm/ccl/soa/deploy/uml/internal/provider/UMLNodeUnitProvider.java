package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Node;

import com.ibm.ccl.soa.deploy.analysis.IAnalysisTemplateConstants;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

public class UMLNodeUnitProvider extends UMLElementUnitProvider {

	@Override
	public Object[] resolveUnit(TopologyUnitStub stub, boolean toResolveLazily,
			IProgressMonitor monitor) {

		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();

		Unit node = (Unit) rts.createFromTemplate(IAnalysisTemplateConstants.NODE_UNIT);

		Node umlNode = (Node) stub.getInput();
		node.setName(UnitUtil.fixNameForID(umlNode.getName()));
		node.setDisplayName(getDisplayName(umlNode.getName()));
		node.setConceptual(true);
		setRequirementsAndCapabilities(node, umlNode);
		node.getStereotypes().addAll(getStereotypes(umlNode));

		addUMLElementArtifact(node, umlNode, stub.getTopology());

		return new DeployModelObject[] { node };
	}
}
