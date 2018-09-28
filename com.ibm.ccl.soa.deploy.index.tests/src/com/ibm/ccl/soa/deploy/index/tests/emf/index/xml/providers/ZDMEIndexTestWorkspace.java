package com.ibm.ccl.soa.deploy.index.tests.emf.index.xml.providers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.ibm.ccl.soa.deploy.core.test.TestWorkspace;
import com.ibm.ccl.soa.deploy.index.tests.IndexTestPlugin;

public class ZDMEIndexTestWorkspace extends TestWorkspace {
	
	public static final String ZDME_INDEX_TEST = "ZDMEIndexTest";

	public static final IPath TESTDATA = new Path("testdata/ZDMEIndexTest.zip");
	
	public static final String[] PROJECT_NAMES = new String[] { ZDME_INDEX_TEST };
	
	public ZDMEIndexTestWorkspace() {
		super(IndexTestPlugin.getDefault().getBundle(), TESTDATA, PROJECT_NAMES);
	}
	
	public IProject getZDMEIndexTestProject() {
		return ROOT.getProject(ZDME_INDEX_TEST);
	}
	
	public IFile getTopologyA() {
		return (IFile) getZDMEIndexTestProject().findMember(new Path( "topologies/com/acme/topologies/A.topology" ) );
	}
	
	public IFile getTopologyB() {
		return (IFile) getZDMEIndexTestProject().findMember(new Path( "topologies/com/acme/topologies/B.topology" ) );
	}
}
