/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.expression.IRequirementExpressionInterpreter;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public class DiscoveryDescriptor {

	private final UnitDescriptor ud;
	private LinkType type;
	private Unit target;
	private Requirement req;
	private Capability cap;
	private Topology topology;
	private LinkDescriptor descriptor;

	public DiscoveryDescriptor(UnitDescriptor ud, Unit target, Topology topology, LinkType type) {
		this.type = type;
		this.ud = ud;
		this.target = target;
		req = null;
		cap = null;
		this.topology = topology;
		descriptor = null;

		assert target != null;
		assert topology != null;
	}

	public DiscoveryDescriptor(LinkDescriptor aDescriptor) {
		assert aDescriptor != null;
		type = aDescriptor.getType();
		if (type == LinkType.DEPENDENCY) {
			req = (Requirement) aDescriptor.getSource();
			cap = (Capability) aDescriptor.getTarget();
		}
		ud = null;
		target = null;
		if (aDescriptor.getTarget() != null) {
			topology = aDescriptor.getTarget().getTopology();
		}
		descriptor = aDescriptor;
	}

	/*
	 * protected Command getCommand() { ICommandProxy command = new ICommandProxy(getICommand());
	 * return command; }
	 * 
	 * private ICommand getICommand() {
	 * 
	 * TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(topology); if (type ==
	 * LinkType.HOSTING) { return new TransactionCommandWrapper4(domain,
	 * Messages.SelectMatchPage_Suggest_hostin_, new Runnable() { public void run() {
	 * DiscoverAndAddService.INSTANCE.addAndHostDiscoveredUnitToTopology(target, ud); } }); } else if
	 * (type == LinkType.DEPENDENCY) { return new TransactionCommandWrapper4(domain,
	 * Messages.SelectMatchPage_Suggest_dependenc_, new Runnable() { public void run() {
	 * DiscoverAndAddService.INSTANCE.addTargetUnitAndDependenyLinkToTopology(req, cap); } }); } else
	 * if (type == LinkType.MEMBER) { return new TransactionCommandWrapper4(domain,
	 * Messages.SelectMatchPage_Suggest_membershi_, new Runnable() { public void run() {
	 * DiscoverAndAddService.INSTANCE.addAndContainDiscoveredUnitToTopology(target, ud); } }); } else
	 * if (type == LinkType.LOGICAL) { return new TransactionCommandWrapper4(domain,
	 * Messages.SelectMatchPage_Suggest_logica_, new Runnable() { public void run() {
	 * descriptor.create(); } }); }
	 */
	/*
	 * // // Unexpected link type // return null; // }
	 */
	public LinkType getType() {
		return type;
	}

	public String getTopologyName() {
		// TODO Michael K would like this to display the Topology name, but DiscoverAndAddService
		// doesn't give Topologies for the results it finds so we can't yet do that.
		if (topology == null) {
			return ""; //$NON-NLS-1$
		}
		if (topology.getDisplayName() == null) {
			return topology.getQualifiedName();
		}
		if (topology.getNamespace() != null && topology.getDisplayName().length() > 0) {
			return topology.getNamespace() + "." + topology.getDisplayName(); //$NON-NLS-1$
		}
		return topology.getDisplayName();
	}

	public String getTargetName() {
		String displayName = null;
		if (type == LinkType.HOSTING) {
			displayName = ud.getUnitValue().getCaptionProvider().titleWithContext(ud.getUnitValue());
			if (target != null && !ud.isInTopology(target.getTopology())) {
				return displayName + " *"; //$NON-NLS-1$
			}
		} else if (type == LinkType.DEPENDENCY) {
			displayName = cap.getCaptionProvider().titleWithContext(cap);
		} else if (type == LinkType.MEMBER) {
			displayName = ud.getUnitValue().getCaptionProvider().titleWithContext(ud.getUnitValue());
			if (target != null && !ud.isInTopology(target.getTopology())) {
				return displayName + " *"; //$NON-NLS-1$
			}
		} else if (type == LinkType.CONSTRAINT) {
			if (descriptor.getTarget() instanceof Capability) {
				Capability c = (Capability) descriptor.getTarget();
				displayName = c.getCaptionProvider().titleWithContext(c);
			} else {
				displayName = descriptor.getSourceUnit().getCaptionProvider().title(
						descriptor.getSourceUnit());
			}
		}
		return displayName;
	}

	public String getSourceName() {
		if (type == LinkType.HOSTING) {
			return target.getCaptionProvider().title(target);
		} else if (type == LinkType.DEPENDENCY) {
			return getName(req);
		} else if (type == LinkType.MEMBER) {
			return target.getCaptionProvider().title(target);
		} else if (type == LinkType.CONSTRAINT) {
			if (descriptor.getSource() instanceof Requirement) {
				return getName((Requirement) descriptor.getSource());
			}
			return descriptor.getSourceUnit().getCaptionProvider().title(descriptor.getSourceUnit());
		}
		return null;
	}

	public String getName(Requirement req) {
		if (req != null && req.getDisplayName() == null) {
			// Don't use the default getName(), which will call this requirement 'anonymous'
			return calculateDisplayName(req);
		}

		return getName2(req /* , Messages.CONSUMES_LABEL */);
	}

	private String calculateDisplayName(Requirement req) {
		if (req.getExpressions().size() == 0) {
			if (req.getDmoEType() != null) {
				return req.getDmoEType().getName();
			}

			// No REs *and* no etype -- promiscuous requirement
			return "*"; //$NON-NLS-1$
		}

		StringBuffer sb = new StringBuffer();
		for (Iterator it = req.getExpressions().iterator(); it.hasNext();) {
			RequirementExpression re = (RequirementExpression) it.next();
			sb.append(getName(re));

			if (it.hasNext()) {
				sb.append(" && "); //$NON-NLS-1$
			}
		}

		return sb.toString();
	}

	private static String calculateDisplayName(RequirementExpression re) {
		IRequirementExpressionInterpreter interp = RequirementUtil.getInterpreter(re);
		return interp.computeTitle(re);
	}

	public static String getName(RequirementExpression re) {
		if (re != null && re.getDisplayName() == null) {
			// Don't use the default getName(), which will call this requirement 'anonymous'
			return calculateDisplayName(re);
		}

		return getName2(re /* , Messages.PropertyUtils_RequirementExpressio_ */);
	}

	protected static String getName2(DeployModelObject dmo /* , String def */) {
		if (dmo == null) {
			return null;
		}

		if (dmo.getDisplayName() != null && dmo.getDisplayName().length() > 0) {
			return dmo.getDisplayName();
		}

		if (dmo.getName() == null) {
			return DeployCoreMessages.DiscoveryDescriptor_no_ID_;
		}

		return dmo.getName();
	}

	public Unit getTarget() {
		return target;
	}

	public void setTarget(Unit target) {
		this.target = target;
	}

	public Requirement getReq() {
		return req;
	}

	public void setReq(Requirement req) {
		this.req = req;
	}

	public Capability getCap() {
		return cap;
	}

	public void setCap(Capability cap) {
		this.cap = cap;
	}

	public Topology getTopology() {
		return topology;
	}

	public void setTopology(Topology topology) {
		this.topology = topology;
	}

	public LinkDescriptor getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(LinkDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	public UnitDescriptor getUd() {
		return ud;
	}

	public void setType(LinkType type) {
		this.type = type;
	}

}
