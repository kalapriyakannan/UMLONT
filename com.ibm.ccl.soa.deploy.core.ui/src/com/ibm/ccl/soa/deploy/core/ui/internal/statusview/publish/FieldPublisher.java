/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.publish;

import java.util.Set;
import java.util.TreeSet;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.NotSupportedTargetException;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusField;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusNode;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyPublisherDescriptor;

/**
 * Publisher field of Publish Problems View
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 */
public class FieldPublisher extends StatusField {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusField#getEntries()
	 */
	public Set getEntries() {
		TopologyPublisherDescriptor[] publishers = TopologyManager.getInstance()
				.findAvailablePublishers(null);
		Set entries = new TreeSet();

		for (int i = 0; i < publishers.length; i++) {
			if (publishers[i].getName() != null)
				entries.add(publishers[i].getName());
		}
		return entries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusField#hasEntry()
	 */
	public boolean hasEntry() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * @return publisher if obj instanceof <code>{@link IDeployPublishStatus}</code>
	 * @throws NotSupportedTargetException
	 */
	public String getValue(Object obj) throws NotSupportedTargetException {
		if (obj instanceof StatusNode) {
			IDeployPublishStatus status = (IDeployPublishStatus) ((StatusNode) obj).getStatus();
			assert (status != null);
			return status.getPublisher();
		}

		throw new NotSupportedTargetException(obj);
	}

	/**
	 * @return
	 * <li> {@value PublishMessages#Column_Title_Publisher}</li>
	 */
	public String getColumnHeaderText() {
		return Messages.Field_Publisher_Name;
	}

	/**
	 * 
	 */
	public final static FieldPublisher INSTANCE = new FieldPublisher();
}
