/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: BaseComponentUnitImpl.java,v 1.7 2008/02/05 22:20:16 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.internal.core.extension.ConstraintDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ConstraintManager;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.ReassociationList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Base Component Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BaseComponentUnitImpl extends UnitImpl implements BaseComponentUnit {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseComponentUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.BASE_COMPONENT_UNIT;
	}

	public List getConstraints() {

		List<Constraint> assembled = new BasicEList<Constraint>();

		if (getEditTopology() != null) {
			IRelationshipChecker relationships = getEditTopology().getRelationships();
			Collection<Unit> members = relationships.getMembers(this);

			boolean foundMatch = false;
			for (Iterator<Unit> unitItr = members.iterator(); unitItr.hasNext();) {
				Unit member = unitItr.next();
				if (member != null) {
					for (Iterator<Constraint> memberConstraints = member.getConstraints().iterator(); memberConstraints
							.hasNext();) {
						Constraint memberConstraint = memberConstraints.next();
						foundMatch = false;
						for (Iterator<Constraint> myItr = assembled.iterator(); myItr.hasNext()
								&& !foundMatch;) {
							foundMatch = areEquivalent(memberConstraint, myItr.next());
						}
						if (!foundMatch) {

							// validate that the member constraints allow "this" as a context via their ConstraintDescriptor
							String constraintNS = ExtendedMetaData.INSTANCE.getNamespace(memberConstraint
									.getEObject().eClass());
							String constraintType = memberConstraint.getEObject().eClass().getName();
							List<ConstraintDescriptor> descrList = ConstraintManager.INSTANCE
									.getConstraintDescriptorListForType(constraintNS, constraintType);
							for (Iterator<ConstraintDescriptor> descrIter = descrList.iterator(); descrIter
									.hasNext()
									&& !foundMatch;) {
								foundMatch = descrIter.next().isContextLegal(this);
							}
							if (foundMatch) {
								assembled.add(memberConstraint);
							}
						}
					}
				}
			}
		}
		return new ReassociationList(this, CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS,
				(EList) super.getConstraints(), assembled);
	}

	@Override
	public List getHostingOrAnyRequirements() {

		List<Requirement> assembled = new BasicEList<Requirement>();

		if (getEditTopology() != null) {
			IRelationshipChecker relationships = getEditTopology().getRelationships();
			Collection<Unit> members = relationships.getMembers(this);

			boolean foundMatch = false;
			for (Iterator<Unit> unitItr = members.iterator(); unitItr.hasNext();) {
				Unit member = unitItr.next();
				if (member != null) {
					for (Iterator<Requirement> memberHostingReqs = member.getHostingOrAnyRequirements()
							.iterator(); memberHostingReqs.hasNext();) {
						Requirement memberHostingReq = memberHostingReqs.next();

						foundMatch = false;
						for (Iterator<Requirement> myItr = assembled.iterator(); myItr.hasNext()
								&& !foundMatch;) {
							foundMatch = areEquivalent(memberHostingReq, myItr.next());
						}
						if (!foundMatch) {
							assembled.add(memberHostingReq);
						}
					}
				}
			}
		}
		return new ReassociationList(this, CorePackage.Literals.UNIT__REQUIREMENTS, (EList) super
				.getHostingOrAnyRequirements(), assembled);
	}

	/**
	 * <p>
	 * Returns a list of all the hosting requirements for this Component as well as any hosting
	 * requirements found on any of it's direct members.
	 * 
	 * @return
	 */
	@Override
	public List getOnlyHostingRequirements() {

		List<Requirement> hostingRequirements = new ReassociationList(this,
				CorePackage.Literals.UNIT__REQUIREMENTS, new BasicEList(), super
						.getOnlyHostingRequirements());

		IRelationshipChecker relationships = getEditTopology().getRelationships();
		Collection<Unit> members = relationships.getMembers(this);

		boolean foundMatch = false;
		for (Iterator<Unit> unitItr = members.iterator(); unitItr.hasNext();) {
			Unit member = unitItr.next();
			if (member != null) {
				for (Iterator<Requirement> memberHostingReqItr = member.getOnlyHostingRequirements()
						.iterator(); memberHostingReqItr.hasNext();) {
					Requirement memberHostingReq = memberHostingReqItr.next();

					foundMatch = false;
					for (Iterator<Requirement> myItr = hostingRequirements.iterator(); myItr.hasNext()
							&& !foundMatch;) {
						foundMatch = areEquivalent(memberHostingReq, myItr.next());
					}
					if (!foundMatch) {
						hostingRequirements.add(memberHostingReq);
					}
				}
			}
		}

		return hostingRequirements;

	}

	/**
	 * <p>
	 * This method tests the equivalency of two respective Requirements. This method can accept null
	 * parameters. The properties of the {@link Requirement}s tested for equivalency are as follows:
	 * </p>
	 * 
	 * <p>
	 * What properties are tested for equality
	 * </p>
	 * <ul>
	 * <li>{@link Requirement#getClass()}
	 * <li>{@link Requirement#getDmoEType()}
	 * <li>{@link Requirement#getLinkType()}
	 * <li>{@link Requirement#getUse()}
	 * <li>{@link Requirement#getExpressions()} ( Note, size of list must match and each expression
	 * must be equivalent {@link #areEquivalent(RequirementExpression, RequirementExpression)}
	 * </ul>
	 * 
	 * @param aReq
	 *           a requirement to test
	 * @param bReq
	 *           a requirement to test
	 * @return true if all the properties listed above of the two {@link Requirement}s are equal
	 *         using the equals() method except where noted for the collection of
	 *         {@link RequirementExpression}s.
	 */
	private static boolean areEquivalent(Requirement aReq, Requirement bReq) {
		if (aReq == bReq) {
			return true;
		}
		if (bReq == null) {
			return false;
		}
		if (aReq.getClass() != bReq.getClass()) {
			return false;
		}
		if (aReq.getDmoEType() == null) {
			if (bReq.getDmoEType() != null) {
				return false;
			}
		} else if (!aReq.getDmoEType().equals(bReq.getDmoEType())) {
			return false;
		}
		if (aReq.getDmoEType() == null) {
			if (bReq.getDmoEType() != null) {
				return false;
			}
		} else if (!aReq.getDmoEType().equals(bReq.getDmoEType())) {
			return false;
		}
		if (aReq.getLinkType() == null) {
			if (bReq.getLinkType() != null) {
				return false;
			}
		} else if (!aReq.getLinkType().equals(bReq.getLinkType())) {
			return false;
		}
		if (aReq.getUse() == null) {
			if (bReq.getUse() != null) {
				return false;
			}
		} else if (!aReq.getUse().equals(bReq.getUse())) {
			return false;
		}
		if (aReq.getConstraints() == null) {
			if (bReq.getConstraints() != null) {
				return false;
			}
		} else {
			if (!areEquivalent(aReq.getConstraints(), bReq.getConstraints())) {
				return false;
			}
		}

		return true;
	}

	/**
	 * This method tests the equivalency of two lists of constraints. It will return false if there
	 * is uncertainty about the equivalence.
	 * 
	 * @param aConstraintList
	 * @param bConstraintList
	 * @return
	 */
	private static boolean areEquivalent(List<Constraint> aConstraintList,
			List<Constraint> bConstraintList) {
		if (aConstraintList.size() != bConstraintList.size()) {
			return false;
		}
		for (Constraint aConstraint : aConstraintList) {
			boolean foundMatch = false;
			for (Constraint bConstraint : bConstraintList) {
				if (areEquivalent(aConstraint, bConstraint)) {
					foundMatch = true;
					break;
				}
			}
			if (!foundMatch) {
				return false;
			}
		}
		for (Constraint bConstraint : bConstraintList) {
			boolean foundMatch = false;
			for (Constraint aConstraint : aConstraintList) {
				if (areEquivalent(bConstraint, aConstraint)) {
					foundMatch = true;
					break;
				}
			}
			if (!foundMatch) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method tests the equivalency of two constraints. It will delegate to the TypeConstraint
	 * or RequirementExpression comparator as required, else it will do generic comparison.
	 * 
	 * @param aConstraint
	 * @param bConstraint
	 * @return
	 */
	private static boolean areEquivalent(Constraint aConstraint, Constraint bConstraint) {
		// Delegate if known comparator
		if (aConstraint instanceof RequirementExpression
				&& bConstraint instanceof RequirementExpression) {
			return areEquivalent((RequirementExpression) aConstraint,
					(RequirementExpression) bConstraint);
		} else if (aConstraint instanceof TypeConstraint && bConstraint instanceof TypeConstraint) {
			return areEquivalent((TypeConstraint) aConstraint, (TypeConstraint) bConstraint);
		}
		// No comparator to delegate to - do generic comparison.
		if (!areEquivalent(aConstraint.getConstraints(), bConstraint.getConstraints())) {
			return false;
		}

		return aConstraint.equals(bConstraint);
	}

	/**
	 * <p>
	 * This method tests the equivalency of two respective TypeConstraints. This method can accept
	 * null parameters. The properties of the {@link TypeConstraint}s that are tested for
	 * equivalency are as follows:
	 * </p>
	 * 
	 * TODO core constraints should implement equals
	 * 
	 * <p>
	 * What properties are tested for equivalency.
	 * </p>
	 * <ul>
	 * <li>{@link RequirementExpression#getClass()}
	 * <li>{@link RequirementExpression#getDmoType()}
	 * <li>{@link RequirementExpression#getConstraints()}
	 * </ul>
	 * 
	 * @param aTypeConstraint
	 *           a {@link TypeConstraint} to test
	 * @param bTypeConstraint
	 *           a {@link TypeConstraint} to test
	 * @return true if the properties listed above are equal between the two {@link TypeConstraint}s
	 */
	private static boolean areEquivalent(TypeConstraint aTypeConstraint,
			TypeConstraint bTypeConstraint) {
		if (aTypeConstraint == bTypeConstraint) {
			return true;
		}
		if (aTypeConstraint == null) {
			return false;
		}
		if (aTypeConstraint.getClass() != bTypeConstraint.getClass()) {
			return false;
		}
		if (aTypeConstraint.equals(bTypeConstraint)) {
			return true;
		}
		if (aTypeConstraint.getDmoEType() != null && aTypeConstraint.getDmoEType() == null) {
			return false;
		}
		if (aTypeConstraint.getDmoEType() == null && aTypeConstraint.getDmoEType() != null) {
			return false;
		}
		if (aTypeConstraint.getDmoEType() != null && aTypeConstraint.getDmoEType() != null) {
			if (!aTypeConstraint.getDmoEType().equals(bTypeConstraint.getDmoEType())) {
				return false;
			}
		}
		if (!areEquivalent(aTypeConstraint.getConstraints(), bTypeConstraint.getConstraints())) {
			return false;
		}

		return true;
	}

	/**
	 * <p>
	 * This method tests the equivalency of two respective Requirements. This method can accept null
	 * parameters. The properties of the {@link RequirementExpression}s that are tested for
	 * equivalency are as follows:
	 * </p>
	 * 
	 * TODO core constraints should implement equals
	 * 
	 * <p>
	 * What properties are tested for equivalency.
	 * </p>
	 * <ul>
	 * <li>{@link RequirementExpression#getClass()}
	 * <li>{@link RequirementExpression#getAttributeName()}
	 * <li>{@link RequirementExpression#getInterpreter()}
	 * <li>{@link RequirementExpression#getUse()}
	 * <li>{@link RequirementExpression#getValue()}
	 * <li>{@link RequirementExpression#getConstraints()}
	 * </ul>
	 * 
	 * @param aReq
	 *           a {@link RequirementExpression} to test
	 * @param bReq
	 *           a {@link RequirementExpression} to test
	 * @return true if the properties listed above are equal between the two
	 *         {@link RequirementExpression}s using the equals() method.
	 */
	private static boolean areEquivalent(RequirementExpression aRexp, RequirementExpression bRexp) {
		if (aRexp == bRexp) {
			return true;
		}
		if (bRexp == null) {
			return false;
		}
		if (aRexp.getClass() != bRexp.getClass()) {
			return false;
		}
		if (aRexp.getAttributeName() == null) {
			if (bRexp.getAttributeName() != null) {
				return false;
			}
		} else if (!aRexp.getAttributeName().equals(bRexp.getAttributeName())) {
			return false;
		}
		if (aRexp.getInterpreter() == null) {
			if (bRexp.getInterpreter() != null) {
				return false;
			}
		} else if (!aRexp.getInterpreter().equals(bRexp.getInterpreter())) {
			return false;
		}
		if (aRexp.getUse() == null) {
			if (bRexp.getUse() != null) {
				return false;
			}
		} else if (!aRexp.getUse().equals(bRexp.getUse())) {
			return false;
		}
		if (aRexp.getValue() == null) {
			if (bRexp.getValue() != null) {
				return false;
			}
		} else if (!aRexp.getValue().equals(bRexp.getValue())) {
			return false;
		}
		// Can requirement expressions have child constraints?
		if (!areEquivalent(aRexp.getConstraints(), bRexp.getConstraints())) {
			return false;
		}

		return true;
	}

} //BaseComponentUnitImpl
