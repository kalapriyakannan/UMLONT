/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.virtualization.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VirtualDiskDefUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VirtualDiskSnapshotUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VirtualEthernetNICDefUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VirtualImageCollectionUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VirtualImageUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VirtualServerSnapshotUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VMwareVirtualDiskDefUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VMwareVirtualDiskSnapshotUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VMwareVirtualEthernetNICDefUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VMwareVirtualImageUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.VMwareVirtualServerSnapshotUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.XenVirtualDiskDefUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.XenVirtualEthernetNICDefUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.XenVirtualImageUnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.internal.validator.matcher.VirtualizationDomainMatcher;

/**
 * Validates objects in the {@link VirtualizationPackage} deploy domain.
 */
public class VirtualizationDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link VirtualizationPackage} domain validator.
	 */
	public VirtualizationDomainValidator() {
		super(VirtualizationPackage.eINSTANCE);
		
		addValidator(new VirtualDiskDefUnitValidator());
		addValidator(new VirtualDiskSnapshotUnitValidator());
		addValidator(new VirtualEthernetNICDefUnitValidator());
		addValidator(new VirtualImageCollectionUnitValidator());
		addValidator(new VirtualImageUnitValidator());
		addValidator(new VirtualServerSnapshotUnitValidator());
		addValidator(new VMwareVirtualDiskDefUnitValidator());
		addValidator(new VMwareVirtualDiskSnapshotUnitValidator());
		addValidator(new VMwareVirtualEthernetNICDefUnitValidator());
		addValidator(new VMwareVirtualImageUnitValidator());
		addValidator(new VMwareVirtualServerSnapshotUnitValidator());
		addValidator(new XenVirtualDiskDefUnitValidator());
		addValidator(new XenVirtualEthernetNICDefUnitValidator());
		addValidator(new XenVirtualImageUnitValidator());
		addValidator(new VMwareESXUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new VirtualizationDomainMatcher();
	}
}
