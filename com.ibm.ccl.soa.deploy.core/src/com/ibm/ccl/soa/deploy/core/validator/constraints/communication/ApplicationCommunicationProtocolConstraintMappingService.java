package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Service to provide mapping between protocol names (tags) and port numbers. Currently supports
 * only a single port per protocol.
 */
public class ApplicationCommunicationProtocolConstraintMappingService {

	/**
	 * Singleton service that is used to find protocol to port mappings.
	 */
	public static ApplicationCommunicationProtocolConstraintMappingService INSTANCE = new ApplicationCommunicationProtocolConstraintMappingService();

	public static final String FTP = "FTP"; //$NON-NLS-1$
	public static final int FTP_PORT = 21;

	public static final String TELNET = "TELNET"; //$NON-NLS-1$
	public static final int TELNET_PORT = 23;

	public static final String SMTP = "SMTP"; //$NON-NLS-1$
	public static final int SMTP_PORT = 25;

	public static final String HTTP = "HTTP"; //$NON-NLS-1$
	public static final int HTTP_PORT = 80;

	public static final String HTTPS = "HTTPS"; //$NON-NLS-1$
	public static final int HTTPS_PORT = 443;

	private final Map<String, Integer> defaultProtocolMap = new HashMap<String, Integer>();

	private ApplicationCommunicationProtocolConstraintMappingService() {
		// private constructor for singleton pattern
		defaultProtocolMap.put(FTP, new Integer(FTP_PORT));
		defaultProtocolMap.put(TELNET, new Integer(TELNET_PORT));
		defaultProtocolMap.put(SMTP, new Integer(SMTP_PORT));
		defaultProtocolMap.put(HTTP, new Integer(HTTP_PORT));
		defaultProtocolMap.put(HTTPS, new Integer(HTTPS_PORT));
	}

	/**
	 * Record association of a protocol to a port. Currently supports only one port per protocol.
	 * 
	 * @param protocol
	 *           <tt>String</tt> based key
	 * @param port
	 *           the port number to be associated with it
	 * @return true if successfully saved; false otherwise
	 */
	public boolean putPort(String protocol, Integer port) {
		if (null == protocol || 0 == protocol.trim().length()) {
			return false;
		}
		if (null == port) {
			return false;
		}
		protocol = protocol.trim();
		if (null != getPort(protocol)) {
			// already mapped this protocol
			return false;
		}

		defaultProtocolMap.put(protocol, port);
		return true;
	}

	/**
	 * Retrieve a given port for a protocol.
	 * 
	 * @param protocol
	 *           protocol
	 * @return port
	 */
	public Integer getPort(String protocol) {
		return defaultProtocolMap.get(protocol);
	}

	/**
	 * Get a Set of all of the protocols known to the service.
	 * 
	 * @return
	 */
	public Set<String> getKnownProtocols() {
		return defaultProtocolMap.keySet();
	}

}
