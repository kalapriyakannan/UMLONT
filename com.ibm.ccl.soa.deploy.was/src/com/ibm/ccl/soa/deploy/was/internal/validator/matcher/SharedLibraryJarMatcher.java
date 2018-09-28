/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.EndpointBasedDependencyLinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeValidatorUtils;

public class SharedLibraryJarMatcher extends EndpointBasedDependencyLinkMatcher {

	public SharedLibraryJarMatcher() {
		super(WasPackage.Literals.WAS_SHARED_LIBRARY_ENTRY_UNIT, null,
				J2eePackage.Literals.JAR_MODULE, J2eePackage.Literals.JAR_MODULE_CAPABILITY,
				new LinkDescriptorFactory() {
					public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
							DeployModelObject target) {
						return new SharedLibraryJarLinkDescriptor(type, source, target);
					}

					public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
							Requirement sourceRequirement, Unit target, Capability targetCapability) {
						return new SharedLibraryJarLinkDescriptor(type, source, sourceRequirement,
								target, targetCapability);
					}

					public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
							DeployModelObject target, int linkWeight) {
						return new SharedLibraryJarLinkDescriptor(type, source, target, linkWeight);
					}

					public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
							Requirement sourceRequirement, Unit target, Capability targetCapability,
							int linkWeight) {
						return new SharedLibraryJarLinkDescriptor(type, source, sourceRequirement,
								target, targetCapability, linkWeight);
					}

					final class SharedLibraryJarLinkDescriptor extends LinkDescriptor {

						public SharedLibraryJarLinkDescriptor(LinkType type, DeployModelObject source,
								DeployModelObject target) {
							super(type, source, target);
						}

						public SharedLibraryJarLinkDescriptor(LinkType type, Unit source,
								Requirement sourceRequirement, Unit target, Capability targetCapability) {
							super(type, source, sourceRequirement, target, targetCapability);
						}

						public SharedLibraryJarLinkDescriptor(LinkType type, DeployModelObject source,
								DeployModelObject target, int linkWeight) {
							super(type, source, target, linkWeight);
						}

						public SharedLibraryJarLinkDescriptor(LinkType type, Unit source,
								Requirement sourceRequirement, Unit target, Capability targetCapability,
								int linkWeight) {
							super(type, source, sourceRequirement, target, targetCapability, linkWeight);
						}

						@Override
						protected DependencyLink createDependencyLink() {

							Requirement source = (Requirement) this.getSource();
							Unit sourceUnit = this.getSourceUnit();
							Capability target = (Capability) this.getTarget();
							//Unit targetUnit = this.getTargetUnit();

							if (null == source) {
								// expected case; there is no requirement; we need to add one
								source = addBundleCapabilityRequirement(sourceUnit);
							}
							updateBundleCapabilityRequirementExpresssions(source,
									(BundleCapability) target);

							this.setSource(source);

							DependencyLink link = super.createDependencyLink();

							return link;
						}

						private Requirement addBundleCapabilityRequirement(Unit module) {
							Requirement r = WasJ2eeValidatorUtils.getAvailableRequirement(module,
									CorePackage.Literals.BUNDLE_CAPABILITY);
							if (null != r) {
								// there is already an available requirement for linking
								return r;
							}
							return WasJ2eeValidatorUtils.addBundleCapabilityRequirement(module);
						}

						private void updateBundleCapabilityRequirementExpresssions(Requirement source,
								BundleCapability target) {

//	MK 2008/02/07 Defect 5328: Remove usage of Requirement Expressions from the WAS domain				
//							RequirementExpression re = CoreFactory.eINSTANCE.createRequirementExpression();
//							String attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__ID.getName();
//							re.setAttributeName(attributeName);
//							re.setInterpreter(Equals.INTERPRETER_ID);
//							re.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//							re.setValue(target.getId());
//							re.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
//							source.getExpressions().add(re);
//
//							re = CoreFactory.eINSTANCE.createRequirementExpression();
//							attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__VERSION.getName();
//							re.setAttributeName(attributeName);
//							re.setInterpreter(GreaterThanEquals.INTERPRETER_ID);
//							re.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//							re.setValue(target.getVersion());
//							re.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
//							source.getExpressions().add(re);
//
//							re = CoreFactory.eINSTANCE.createRequirementExpression();
//							attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__VERSION.getName();
//							re.setAttributeName(attributeName);
//							re.setInterpreter(LessThanEquals.INTERPRETER_ID);
//							re.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//							re.setValue(target.getVersion());
//							re.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
//							source.getExpressions().add(re);

							EqualsConstraint ec = ConstraintFactory.eINSTANCE.createEqualsConstraint();
							String attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__ID.getName();
							ec.setAttributeName(attributeName);
							ec.setValue(target.getId());
							ec.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
							source.getConstraints().add(ec);

							VersionConstraint vc = ConstraintFactory.eINSTANCE.createVersionConstraint();
							attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__VERSION.getName();
							vc.setAttributeName(attributeName);
							vc.setValue(target.getVersion());
							vc.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
							source.getConstraints().add(vc);
						}
					}
				});
	}
}
