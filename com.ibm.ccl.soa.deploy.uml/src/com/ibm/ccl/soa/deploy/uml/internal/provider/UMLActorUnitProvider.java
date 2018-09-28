package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Actor;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;

/**
 * Unit Provider for UML actor elements
 * 
 * @since 7.0
 * 
 */
public class UMLActorUnitProvider extends UMLElementUnitProvider {

	@Override
	public Object[] resolveUnit(TopologyUnitStub stub, boolean toResolveLazily,
			IProgressMonitor monitor) {

		UMLActorUnit umlActor = UmlFactory.eINSTANCE.createUMLActorUnit();
		Object obj = stub.getInput();
		if (obj instanceof Actor) {
			Actor actor = (Actor) stub.getInput();
			umlActor.setName(UnitUtil.fixNameForID(actor.getName()));
			umlActor.setDisplayName(getDisplayName(actor.getName()));
			setRequirementsAndCapabilities(umlActor, actor);
			addUMLElementArtifact(umlActor, actor, stub.getTopology());

			umlActor.getStereotypes().addAll(getStereotypes(actor));
			return new DeployModelObject[] { umlActor };
		}
		return NO_MODEL_OBJS;
	}

}
