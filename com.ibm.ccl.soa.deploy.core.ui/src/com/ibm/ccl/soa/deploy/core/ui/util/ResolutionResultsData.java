/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * @since 7.0
 * 
 */
public class ResolutionResultsData {
	private String name;
	private String type;
	private DeployModelObject dmo = null;
	private int change;
	private boolean isUnit = false;
	private boolean isHidden = false;

	/**
	 * a dmo was added to topology
	 */
	static final public int ADDED = 0;
	/**
	 * a link was retargeted
	 */
	static final public int RETARGETED = 1;
	/**
	 * a dmo was deleted from the topology
	 */
	static final public int DELETED = 2;

	ResolutionResultsData(DeployModelObject dmo, int change) {
		if (dmo instanceof HostingLink) {
			HostingLink link = (HostingLink) dmo;
			EObject eo = link.getTarget();
			if (eo instanceof Unit) {
				isHidden = ((Unit) eo).isConfigurationUnit();
			}
			name = NLS.bind(Messages.HostingLinkType,
					DeployModelObjectUtil.getTitle(link.getTarget()), DeployModelObjectUtil
							.getTitle(link.getSource()));
		} else if (dmo instanceof MemberLink) {
			MemberLink link = (MemberLink) dmo;
			name = NLS.bind(Messages.MemberLinkType, DeployModelObjectUtil.getTitle(link.getTarget()),
					DeployModelObjectUtil.getTitle(link.getSource()));
		} else if (dmo instanceof DependencyLink) {
			DependencyLink link = (DependencyLink) dmo;
			DeployModelObject srcDmo = link.getSource();
			DeployModelObject tgtDmo = link.getTarget();
			name = NLS.bind(Messages.DependencyLinkType, new Object[] {
					srcDmo == null ? null : DeployModelObjectUtil.getTitle(srcDmo.getParent()),
					DeployModelObjectUtil.getTitle(srcDmo),
					tgtDmo == null ? null : DeployModelObjectUtil.getTitle(tgtDmo.getParent()),
					DeployModelObjectUtil.getTitle(tgtDmo) });
		} else {
			isUnit = dmo instanceof Unit;
			name = DeployModelObjectUtil.getTitle(dmo);
		}

		if (change != DELETED) {
			this.dmo = dmo;
		}
		this.change = change;
		type = "Unknown Object"; //$NON-NLS-1$
		if (dmo instanceof Unit) {
			type = "Unit"; //$NON-NLS-1$
		} else if (dmo instanceof HostingLink) {
			type = Messages.HOSTINGLINK_CATEGORY;
		} else if (dmo instanceof ConstraintLink) {
			type = Messages.CONSTRAINTLINK_CATEGORY;
		} else if (dmo instanceof MemberLink) {
			type = Messages.MEMBERSHIP_CATEGORY;
		} else if (dmo instanceof DependencyLink) {
			type = Messages.DEPENDENCYLINK_CATEGORY;
		} else if (dmo instanceof RealizationLink) {
			type = Messages.REALIZATIONLINK_CATEGORY;
		}
	}

	public DeployModelObject getDmo() {
		return dmo;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public boolean isUnit() {
		return isUnit;
	}
}
