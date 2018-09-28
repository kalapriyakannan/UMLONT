/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels.tests;

import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import junit.framework.TestCase;

/**
 * Unit tests for
 * {@link  com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel }
 * 
 * <p>
 * Clients should use
 * {@link SynchronizationDatamodel#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.internal.datamodels.SynchronizationDatamodelOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel
 */
public class SynchronizationDatamodelTests extends TestCase {

	/**
	 * Sets up the fixture, for example, open a network connection. This method
	 * is called before a test is executed.
	 */
	protected void setUp() throws Exception {
	}

	/**
	 * Tears down the fixture, for example, close a network connection. This
	 * method is called after a test is executed.
	 */
	protected void tearDown() throws Exception {
	}

	public void testOperationWithRequiredProperties() throws Exception {

		SynchronizationDatamodel typesafeModel = SynchronizationDatamodel
				.createModel();

		typesafeModel.setTopology(null);
		typesafeModel.setComponents(null);
		IDataModelOperation op = typesafeModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status
				.isOK()); // $NON-NLS-1$

		// TODO Verify the proper execution of the operation.

	}

	public IProgressMonitor createProgressMonitor() {
		// TODO Consider using a smarter progress monitor that can enforce a
		// minimum number of messages.
		return new NullProgressMonitor();
	}
}
