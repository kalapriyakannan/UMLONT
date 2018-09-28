package com.ibm.ccl.soa.deploy.index.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	public static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.index.internal.messages"; //$NON-NLS-1$
	public static String ScribblerTemplate_Cannot_read_EMF_resource_from_file_;
	public static String ScribblerTemplate_A_DeployCoreRoot_object_could_not_b_;
	public static String ScribblerTemplate_A_Topology_EMF_object_was_not_found_;
	public static String ScribblerTemplate_A_Diagram_object_could_not_be_found_;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

}
