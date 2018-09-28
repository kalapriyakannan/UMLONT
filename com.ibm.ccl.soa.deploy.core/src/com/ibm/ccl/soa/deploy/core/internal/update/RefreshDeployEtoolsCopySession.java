package com.ibm.ccl.soa.deploy.core.internal.update;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.wst.common.internal.emf.utilities.EtoolsCopySession;
import org.eclipse.wst.common.internal.emf.utilities.EtoolsCopyUtility;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

public class RefreshDeployEtoolsCopySession extends EtoolsCopySession {
	private final Topology topology;
	private Stack<Object> stack;
	private final Map<EStructuralFeature, EStructuralFeature> featureMap = new HashMap<EStructuralFeature, EStructuralFeature>();
	private final boolean isInstalledState = false;

	public RefreshDeployEtoolsCopySession(EtoolsCopyUtility copyUtility, Topology aTopology) {
		super(copyUtility);
		topology = aTopology;
		loadFeatureMap();
	}

	private void loadFeatureMap() {
		featureMap.put(CorePackage.eINSTANCE.getDeployModelObject_ArtifactGroup(),
				CorePackage.eINSTANCE.getDeployModelObject_Artifacts());
		featureMap.put(CorePackage.eINSTANCE.getDeployModelObject_ConstraintGroup(),
				CorePackage.eINSTANCE.getDeployModelObject_Constraints());
		featureMap.put(CorePackage.eINSTANCE.getUnit_CapabilityGroup(), CorePackage.eINSTANCE
				.getUnit_Capabilities());
		featureMap.put(CorePackage.eINSTANCE.getUnit_RequirementGroup(), CorePackage.eINSTANCE
				.getUnit_Requirements());
		featureMap.put(CorePackage.eINSTANCE.getUnit_UnitLinksGroup(), CorePackage.eINSTANCE
				.getUnit_UnitLinks());
	}

	@Override
	public EObject newInstance(EObject aRefObject) {
		if (aRefObject == null || topology == null) {
			return super.newInstance(aRefObject);
		}
		if (aRefObject instanceof Unit) {
			Unit unit = (Unit) aRefObject;
			Unit matchUnit = getMatchingUnit(unit);
			if (matchUnit == null) {
				return super.newInstance(aRefObject);
			}
			return matchUnit;
		} else {
			getStack().clear();
			Unit unit = pushStack(aRefObject);
			if (unit == null) {
				return super.newInstance(aRefObject);
			}
			Unit matchUnit = getMatchingUnit(unit);
			if (matchUnit == null) {
				return super.newInstance(aRefObject);
			}
			EObject obj = popStackPopulateUnit(matchUnit);
			if (obj == null) {
				return super.newInstance(aRefObject);
			} else {
				if (obj.getClass() == aRefObject.getClass()) {
					return obj;
				}
			}

		}
		return super.newInstance(aRefObject);
	}

	private EObject popStackPopulateUnit(Unit matchUnit) {
		EObject eObj = matchUnit;
		while (!stack.isEmpty()) {
			DeployModelBookMark tracker = (DeployModelBookMark) getStack().pop();
			EStructuralFeature feature = tracker.getFeature();
			Object object = eObj.eGet(feature);
			if (object instanceof EObject) {
				eObj = (EObject) object;
			} else if (object instanceof EList) {
				EList list = (EList) object;
				int index = tracker.getIndex();
				if (list.isEmpty() || list.size() <= index) {
					return null;
				}
				object = list.get(index);
				if (object instanceof EObject) {
					eObj = (EObject) object;
				}
			}
		}
		return eObj;
	}

	public Unit getMatchingUnit(Unit unit) {
		List<Artifact> artifacts = unit.getArtifacts();
		if (artifacts.size() <= 0) {
			return null;
		}
		Artifact artifact = artifacts.get(0);
		Unit matchUnit = null;
		if (matchUnit == null) {
			List<Unit> units = topology.getUnits();
			for (Iterator iterator = units.iterator(); iterator.hasNext();) {
				Unit unit2 = (Unit) iterator.next();
				List<Artifact> artifacts2 = unit.getArtifacts();
				for (Iterator iterator2 = artifacts2.iterator(); iterator2.hasNext();) {
					Artifact artifact2 = (Artifact) iterator2.next();
					if (artifact2.equals(artifact) && unit.getClass() == unit2.getClass()) {
						matchUnit = unit2;
						if (matchUnit.getName() == unit.getName()) {
							return unit2;
						}
					}

				}

			}

		}
		return matchUnit;
	}

	private Unit pushStack(EObject eObject) {
		while (eObject != null && !(eObject instanceof Unit)) {
			EStructuralFeature feature = eObject.eContainingFeature();
			EObject container = eObject.eContainer();
			int index = -1;
			if (feature.isMany()) {
				if (FeatureMapUtil.isFeatureMap(feature)) {
					feature = getBaseFeature(feature);
				}
				index = deriveIndex(eObject, feature, container);
				if (index == -1) {
					return null;
				}
			}
			pushToStack(feature, index);
			eObject = eObject.eContainer();
		}
		return (Unit) eObject;
	}

	private EStructuralFeature getBaseFeature(EStructuralFeature feature) {
		if (featureMap.containsKey(feature)) {

			feature = featureMap.get(feature);

		}
		return feature;
	}

	private void pushToStack(EStructuralFeature feature, int index) {

		DeployModelBookMark deployTracker = new DeployModelBookMark(feature, index);
		getStack().push(deployTracker);
	}

	private int deriveIndex(EObject eObject, EStructuralFeature feature, EObject container) {
		Object obj = container.eGet(feature);
		if (obj instanceof EList) {
			EList list = (EList) obj;
			return list.indexOf(eObject);
		}

		return -1;
	}

	@SuppressWarnings("restriction")
	protected void copyManyAttribute(EAttribute attribute, List aValue, EObject aRefObject,
			String idSuffix, EObject copyRef) {
		if (!FeatureMapUtil.isFeatureMap(attribute) && !(aValue instanceof EDataTypeEList)) {
			super.copyManyAttribute(attribute, aValue, aRefObject, idSuffix, copyRef);
		}

	}

	public Stack<Object> getStack() {
		if (stack == null) {
			stack = new Stack<Object>();
		}
		return stack;
	}

}