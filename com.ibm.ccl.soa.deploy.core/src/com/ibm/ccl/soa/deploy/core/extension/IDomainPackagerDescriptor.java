package com.ibm.ccl.soa.deploy.core.extension;

import com.ibm.ccl.soa.deploy.core.DomainPackager;

/**
 * Provides a wrapper around <b>&lt;domains /&gt;</b> configuration elements parsed from the
 * <b>com.ibm.ccl.soa.deploy.core.domains/packager</b> extension point.
 */
public interface IDomainPackagerDescriptor {

	/**
	 * Create an instance of the domain packager for this descriptor
	 * 
	 * @return an instance of the domain packager
	 */
	public DomainPackager createDomainPackager();
}
