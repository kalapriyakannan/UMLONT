/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.os.internal.validator;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType;

/**
 * For use by TreeMap
 * 
 * @since 3.2
 */
public class PortSignature implements Comparable<PortSignature> {
	private final BigInteger portNum;

	private final TransportLayerProtocolType transportLayerProtocol;

	private final String ipAddressOrHostname;

	/**
	 * @param port
	 */
	public PortSignature(Port port) {
		portNum = port.getPort();
		transportLayerProtocol = port.getTransportLayerProtocol();
		ipAddressOrHostname = port.getIpAddressOrHostname();
	}

	public int compareTo(PortSignature p) {
//		PortSignature p = (PortSignature) o;
//		System.out.println("compare test - " + this.toString() + ":" + p.toString()); //$NON-NLS-1$ //$NON-NLS-2$
		// Unset port should NOT be a match with every port value. 2007/04/17 
		if (portNum == null || p.portNum == null) {
			return 1;
		}
		if (portNum.compareTo(p.portNum) != 0) {
			return portNum.compareTo(p.portNum);
		}
		if (transportLayerProtocol == null || p.transportLayerProtocol == null) {
			return 0;
		}
		if (transportLayerProtocol.toString().compareTo(p.transportLayerProtocol.toString()) != 0) {
			return transportLayerProtocol.toString().compareTo(p.transportLayerProtocol.toString());
		}
		if (ipAddressOrHostname == null || p.ipAddressOrHostname == null) {
			return 0;
		}
		if (ipAddressOrHostname.compareTo(p.ipAddressOrHostname) != 0) {
			return ipAddressOrHostname.compareTo(p.ipAddressOrHostname);
		}
		return this.toString().compareTo(p.toString());
	}

	@Override
	public String toString() {
		return (portNum != null ? portNum.toString() : "null") + "," //$NON-NLS-1$ //$NON-NLS-2$
				+ (transportLayerProtocol != null ? transportLayerProtocol.getLiteral() : "null") + "," //$NON-NLS-1$ //$NON-NLS-2$
				+ (ipAddressOrHostname != null ? ipAddressOrHostname.toString() : "null"); //$NON-NLS-1$
	}
}
