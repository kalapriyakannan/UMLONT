/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualImageUnit.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.server.Server;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Image Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VirtualImageUnit represents a single potential virtual server. It usually contains a {@link
 * 				VirtualImage} capability describing the image and TODO capabilities describing the {@link Server} being
 * 				modeled.
 * 
 * 				<p>VirtualImageUnits usually contain an {@link Artifact} representing the image file.</p>
 * 
 * 				<p>
 * 					VirtualImageUnits are by convention configuration {@link Unit}s and have a {@link Requirement} for
 * 					the {@link Hypervisor} capability on a {@link OperatingSystemUnit}. They are hosted by Units with a
 * 					{@link Hypervisor} capability.
 * 				</p>
 * 
 * 				<p>
 * 					A VirtualImageUnit MAY host domain specific {@link PortUnit}s that model compositions it can be
 * 					programmed to enter.
 * 				</p>
 * 
 * 				<p>
 * 					A VirtualImageUnit is said to be INSTALLED if it is 'running' or 'paused'. A VirtualImageUnit is
 * 					said to be UNINSTALLED if its host doesn't know of it, or if 'stopped'.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImageUnit()
 * @model extendedMetaData="name='VirtualImageUnit' kind='elementOnly'"
 * @generated
 */
public interface VirtualImageUnit extends Unit {
} // VirtualImageUnit
