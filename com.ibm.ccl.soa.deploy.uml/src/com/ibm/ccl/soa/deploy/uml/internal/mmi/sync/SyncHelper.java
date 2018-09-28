package com.ibm.ccl.soa.deploy.uml.internal.mmi.sync;

import com.ibm.xtools.mmi.core.ref.StructuredReference;

public class SyncHelper {
	private StructuredReference structuredReference;
	
	public SyncHelper(StructuredReference sReference) {
		setStructuredReference(sReference);
		
	}

	public StructuredReference getStructuredReference() {
		return structuredReference;
	}

	public void setStructuredReference(StructuredReference structuredReference) {
		this.structuredReference = structuredReference;
	}

}
