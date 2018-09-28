package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;

/**
 * As the name suggests this class is stateful. This means you should not use this class if you
 * modify the topology between validation passes and use the same context. If this is required use
 * the superclass.
 * 
 * @see DeployValidatorService
 * @see DeployValidationContext
 * 
 */
public class StatefulDeployValidationContext extends DeployValidationContext {

	private Map<EPackage, List<Unit>> domainMap;

	public StatefulDeployValidationContext(Topology topology, DeployValidatorService service,
			IProgressMonitor monitor) {
		super(topology, service, monitor);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllUnits(org.eclipse.emf.ecore.EPackage)
	 */
	public Iterator findAllUnits(final EPackage domain) {
		assert domain != null;
		if (domainMap == null) {
			processTopology();
		}
		List units = domainMap.get(domain);
		if (units == null) {
			return Collections.EMPTY_LIST.iterator();
		}
		return units.iterator();
	}

	private void processTopology() {
		domainMap = new HashMap<EPackage, List<Unit>>();
		Iterator<Unit> it = topology.findAllUnits();
		while (it.hasNext()) {
			process(it.next());
		}
	}

	private void process(Unit unit) {
		EClass eClass = unit.getEObject().eClass();
		EPackage pack = eClass.getEPackage();
		List<Unit> list = domainMap.get(pack);
		if (list == null) {
			list = new ArrayList<Unit>();
			domainMap.put(pack, list);
		}
		list.add(unit);
	}
}
