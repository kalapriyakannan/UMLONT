package com.ibm.ccl.soa.deploy.core.internal.update;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.wst.common.internal.emf.utilities.EtoolsCopyUtility;

import com.ibm.ccl.soa.deploy.core.Topology;

public class RefreshDeployEtoolsCopyUtility extends EtoolsCopyUtility {
	private final Topology topology;

	public RefreshDeployEtoolsCopyUtility(Topology aTopology) {
		topology = aTopology;
	}

	public static EObject createCopy(EObject aRefObject, Topology topology, String idSuffix) {
		RefreshDeployEtoolsCopyUtility utility = new RefreshDeployEtoolsCopyUtility(topology);
		return utility.copy(aRefObject, idSuffix);
	}

	public EObject copy(EObject aRefObject, String idSuffix) {
		RefreshDeployEtoolsCopySession session = new RefreshDeployEtoolsCopySession(this, topology);
		EObject copied = session.copy(aRefObject, idSuffix);
		session.flush();
		return copied;
	}

	@SuppressWarnings("restriction")
	protected void copyManyAttribute(EAttribute attribute, List aValue, EObject aRefObject,
			String idSuffix, EObject copyRef) {
		if (!FeatureMapUtil.isFeatureMap(attribute)) {
			super.copyManyAttribute(attribute, aValue, aRefObject, idSuffix, copyRef);
		}

	}

}
