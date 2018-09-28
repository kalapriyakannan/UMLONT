package com.ibm.ccl.soa.deploy.uml.internal.mmi.providers;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.IDeployMMInterface;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.mmi.core.services.ref.AbstractCachingStructuredReferenceProvider;
import com.ibm.xtools.mmi.core.services.ref.StructuredReferenceService;

public class TopologyStructuredReferenceHandler extends
		AbstractCachingStructuredReferenceProvider implements IDeployMMInterface{
	


	@Override
	protected StructuredReference constructStructuredReference(
			Object referencedContext, Object domainElement) {
		Unit unit = (Unit) domainElement;
		StructuredReference vr = getModifier().createStructuredReference(TREF_HANDLER_ID, null, null);
		getModifier().setProperty(vr, TYPE_NAME, unit.getName());
		Topology topology = unit.getEditTopology();
		getModifier().addSupportingStructuredReference(vr, StructuredReferenceService.getStructuredReference(referencedContext, topology));
	    return vr;
	}

	public Object getInfo(Object referencedContext, StructuredReference ref,
			String infoName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object resolveToDomainElement(Object referencedContext,
			StructuredReference ref) {
		// TODO Auto-generated method stub
		return null;
	}

}
