package com.ibm.ccl.soa.deploy.ide.tests.refactoring;

import com.ibm.ccl.soa.deploy.ide.tests.IdeTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RefactoringTestSuite extends TestSuite {

	public RefactoringTestSuite(String name) {
		super(name);
	}
	
	public static Test suite() {
		TestSuite suite = new RefactoringTestSuite("Deploy Refactoring Test Suite"); //$NON-NLS-1$
		
		// com.ibm.ccl.soa.deploy.ide.tests.refactoring
		suite.addTestSuite(MoveTopologyRefactoringTests.class);
		suite.addTestSuite(RenameTopologyRefactoringTests.class);
		suite.addTestSuite(MoveUnitsRefactoringTests.class);
		
		return suite;
	}
}
