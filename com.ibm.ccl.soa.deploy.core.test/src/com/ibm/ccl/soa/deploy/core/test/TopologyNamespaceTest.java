/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class TopologyNamespaceTest extends TopologyTestCase {

	public TopologyNamespaceTest() {
		super("TopologyNamespaceTest");
	}

	public void testCreateRoot() throws Exception {

		INamespaceFragmentRoot srcRoot = NamespaceCore.createRoot( getProject().getFolder( "src" ), null );

		// createRoot is a handle operation so the underlying resource should not exist yet
		assertFalse( "The underlying folder resource for the INamespaceFragmentRoot should not exist yet.", srcRoot.exists() );
		assertFalse( "The underlying folder resource for the INamespaceFragmentRoot should not exist yet.", getProject().getFolder( "src" ).exists() );
		
		srcRoot.create( null );
		
		// now a folder called "src" should exist directly under the project root
		assertTrue( "The underlying folder resource for the INamespaceFragmentRoot should now exist.", getProject().getFolder( "src" ).exists() );
		assertTrue( "The underlying folder resource for the INamespaceFragmentRoot should now exist.", getProject().getFolder( "src" ).exists() );
		
		INamespaceFragmentRoot topologies = NamespaceCore.createRoot( getProject().getFolder( "topologies" ), null );
		
		// should not be null
		assertTrue( "The INamespaceFragmentRoot should not be null.", topologies != null );
		
		// this folder should have been created in the test case setup method
		assertTrue( "The underlying folder resource for the INamespaceFragmentRoot should already exist.", topologies.exists() );
		assertTrue( "The underlying folder resource for the INamespaceFragmentRoot should already exist.", getProject().getFolder( "topologies" ).exists() );
		
		INamespaceElement element = NamespaceCore.create( getProject().getFolder( "topologies" ) );
		
		// this is the same folder as above
		assertTrue( "The underlying folder resource for the INamespaceElement should already exist", element.exists() );
		assertTrue( "The INamespaceElement should be an instance of type INamespaceFragmentRoot.", element.getType() == INamespaceElement.TOPOLOGY_NAMESPACE_ROOT );
		assertTrue( "The underlying folder resource for the INamespaceElement and the folder topologies should be the same.", element.getRoot().getCorrespondingResource().equals( getProject().getFolder( "topologies" ) ) );
	}

	public void testLocateNamespaceRoots() throws Exception {
		
		INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots( getProject(), null );
		
		assertTrue( "There should only be 1 topology namespace root folder.", roots.length == 1 );
		
		NamespaceCore.createRoot( getProject().getFolder( "src" ), null );
		roots = NamespaceCore.locateRoots( getProject(), null );
		
		assertTrue( "There should now be 2 topology namespace root folders.", roots.length == 2 );
		
		IFolder folder = getProject().getFolder( "src" ).getFolder( "com" ).getFolder( "acme" ).getFolder( "test" );
		INamespaceFragmentRoot root = NamespaceCore.getRoot( folder );
		
		assertTrue( "This folder should be a descendent of a topology namespace root folder.", root != null );
		assertTrue( "This topology namespace root should be equal to the src folder.", root.getCorrespondingResource().equals( getProject().getFolder( "src" ) ) );
	}
	
	public void testResolveTopologies() throws Exception {
		
		Topology namespaceTestTopology = createTopology( "com.ibm.tests.topologies.namespacetesttopology" , true /* save */ );
		
		// test resolve with just a qualified name for a topology
		IFile file = NamespaceCore.resolveTopology(getProject(), "com.ibm.tests.topologies.namespacetesttopology" );
		assert WorkbenchResourceHelper.getFile(namespaceTestTopology.eResource()).equals(file);
		
		// test resolve with a qualified name for a topology + the file extension '.topology'
		IFile file2 = NamespaceCore.resolveTopology(getProject(), "com.ibm.tests.topologies.namespacetesttopology.topology");
		assert !WorkbenchResourceHelper.getFile(namespaceTestTopology.eResource()).equals(file2);
	}
}
