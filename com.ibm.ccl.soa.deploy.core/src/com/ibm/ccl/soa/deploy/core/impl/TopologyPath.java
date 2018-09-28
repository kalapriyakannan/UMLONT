package com.ibm.ccl.soa.deploy.core.impl;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;

public class TopologyPath {

	private static final String EMPTY = ""; //$NON-NLS-1$

	private static final String[] NO_BRANCHES = new String[0];

	private final String path;

	private String namespace = INamespaceElement.DEFAULT_NAMESPACE;
	private String topologyName = EMPTY;
	private String relativePath = EMPTY;
	private String attributeName = EMPTY;

	private boolean valid = true;

	public TopologyPath(String path) {
		this.path = path;
		init();
	}

	public boolean isRelative() {
		return topologyName == null;
	}

	public boolean isAbsolute() {
		return topologyName != null;
	}

	public boolean isValid() {
		return valid;
	}

	public String getNamespace() {
		return namespace;
	}

	public String getTopologyName() {
		return topologyName;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public String getAttributeName() {
		return attributeName;
	}

	private void init() {

		// Format:
		// { { namespace + '.' } + topology-name + ':' } + #getFullPath()
		// Example:
		// com.foo.namespace.TopologyName:/path/to/element

		// Check for topology namespace and name separator
		int contextIndx = path.indexOf(IConstants.TOPOLOGY_SEPARATOR);
		// Parse { { namespace + '.' } + topology-name + ':' }
		String contextPath = path.substring(0, contextIndx);
		int lastdotIndx = contextPath.lastIndexOf(IConstants.DOT_SEPARATOR);
		if (lastdotIndx == -1) {
			// No namespace found
			namespace = INamespaceElement.DEFAULT_NAMESPACE;
			topologyName = contextPath;
		} else {
			namespace = path.substring(0, lastdotIndx);
			if (lastdotIndx + 1 == contextPath.length()) {
				// No name included (can't recover)
				valid = false;
				return;
			}
			topologyName = contextPath.substring(lastdotIndx + 1);
		}

		int firstBranchIndx = path.indexOf(IConstants.TOPOLOGY_SEPARATOR);

		int attrIndx = path.lastIndexOf(IConstants.ATTRIBUTE_SEPARATOR);
		if (attrIndx > -1) {
			attributeName = path.substring(attrIndx + 1, path.length());
		} else {
			attrIndx = path.length();
		}

		// Parse relative path 
		if (contextIndx + 1 >= path.length()) {
			relativePath = ""; //$NON-NLS-1$
		} else {
			relativePath = path.substring(firstBranchIndx + 1, attrIndx);
		}
	}

}
