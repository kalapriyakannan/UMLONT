package com.ibm.ccl.soa.deploy.core.internal.update;

import org.eclipse.emf.ecore.EStructuralFeature;

public class DeployModelBookMark implements IDeployModelBookMark{
	
	private EStructuralFeature feature;
	private int index = -1;
	public DeployModelBookMark(EStructuralFeature aFeature, int anIndex) {
		feature = aFeature;
		index = anIndex;
	}
	public EStructuralFeature getFeature() {
		// TODO Auto-generated method stub
		return feature;
	}
	public int getIndex() {
		return index;
	}


}
