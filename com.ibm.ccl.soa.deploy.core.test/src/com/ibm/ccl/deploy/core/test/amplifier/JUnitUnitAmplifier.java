/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.deploy.core.test.amplifier;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitAmplifier;

/**
 * Amplifier for unit-testing purposes.
 */
public class JUnitUnitAmplifier extends UnitAmplifier {

	@Override
	public String[] getValues(Unit unit) {
	String[] values = new String[] {"foo", "bar", "foobar"};
		return values;
	}

	@Override
	public IStatus modify(Unit unit, Object input) {
		if (input instanceof String){
			final ChangeScope changeScope = ChangeScope.createChangeScopeForWrite(unit);
			try {
				String value = (String) input;
				System.out.println(value);
				changeScope.execute(getModifyOperation( unit, changeScope,value),
						ChangeScope.OPTION_DO_NOT_SAVE, null);
			} finally {
				if (changeScope != null) {
					changeScope.close(null);
				}
			}
			}
		return Status.OK_STATUS;
	}
	
	
	public AbstractEMFOperation getModifyOperation(final Unit sourceUnit,
			ChangeScope changeScope, final String value) {
		AbstractEMFOperation op = new AbstractEMFOperation(changeScope
				.getTransactionalEditingDomain(),
			"test operation") {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {	
				sourceUnit.setDisplayName(value);
				return Status.OK_STATUS;


			}
		};

		return op;

	}

	@Override
	public String getExistingProductConstraintValue(Unit unit) {
		// TODO Auto-generated method stub
		return "test";
	}



}
