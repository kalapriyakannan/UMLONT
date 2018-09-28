/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change;

/**
 * Clients should not use the Properties interface directly, but instead should refer to the
 * type-safe API class {@link com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange}. The
 * properties interface is required by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange
 * @generated (mde.utilities.datamodels)
 */
public interface IUpdateLinkChangeProperties extends IRefactoringDataModelChangeProperties {

	Integer END_POINT_SOURCE = 0;

	Integer END_POINT_TARGET = 1;

	/**
	 * 
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link org.eclipse.emf.common.util.URI}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String LINK = "IUpdateLinkChangeProperties.LINK"; //$NON-NLS-1$

	/**
	 * 
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link String}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String SOURCE = "IUpdateLinkChangeProperties.SOURCE"; //$NON-NLS-1$

	/**
	 * 
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link String}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String DESTINATION = "IUpdateLinkChangeProperties.DESTINATION"; //$NON-NLS-1$

	/**
	 * 
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * <p>
	 * Type = {@link Integer}.
	 * </p>
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	String ENDPOINT = "IUpdateLinkChangeProperties.ENDPOINT"; //$NON-NLS-1$
}
