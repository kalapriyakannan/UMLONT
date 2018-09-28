/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.util.CapabilityLinkTypeAdapter;
import com.ibm.ccl.soa.deploy.core.util.CapabilityLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.EObjectTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.FilterList;
import com.ibm.ccl.soa.deploy.core.util.IObjectAdapter;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.RequirementLinkTypeAdapter;
import com.ibm.ccl.soa.deploy.core.util.RequirementLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.UnitCaptionProvider;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityChecker;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAwareList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Unit</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getCapabilityGroup <em>Capability Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getCapabilities <em>Capabilities</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getRequirementGroup <em>Requirement Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getRequirements <em>Requirements</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getUnitLinksGroup <em>Unit Links Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getUnitLinks <em>Unit Links</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getConstraintLinks <em>Constraint Links</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getRealizationLinks <em>Realization Links</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getStereotypes <em>Stereotypes</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getBuildVersion <em>Build Version</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#isConceptual <em>Conceptual</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#isConfigurationUnit <em>Configuration Unit</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getGoalInstallState <em>Goal Install State</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getInitInstallState <em>Init Install State</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getOrigin <em>Origin</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl#getPublishIntent <em>Publish Intent</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UnitImpl extends DeployModelObjectImpl implements Unit {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getCapabilityGroup() <em>Capability Group</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCapabilityGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap capabilityGroup;

	/**
	 * The cached value of the '{@link #getRequirementGroup() <em>Requirement Group</em>}'
	 * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequirementGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap requirementGroup;

	/**
	 * The cached value of the '{@link #getUnitLinksGroup() <em>Unit Links Group</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUnitLinksGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap unitLinksGroup;

	/**
	 * The cached value of the '{@link #getConstraintLinks() <em>Constraint Links</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstraintLinks()
	 * @generated
	 * @ordered
	 */
	protected EList constraintLinks;

	/**
	 * The cached value of the '{@link #getRealizationLinks() <em>Realization Links</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRealizationLinks()
	 * @generated
	 * @ordered
	 */
	protected EList realizationLinks;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList stereotypes;

	/**
	 * The default value of the '{@link #getBuildVersion() <em>Build Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBuildVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String BUILD_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBuildVersion() <em>Build Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBuildVersion()
	 * @generated
	 * @ordered
	 */
	protected String buildVersion = BUILD_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isConceptual() <em>Conceptual</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isConceptual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONCEPTUAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConceptual() <em>Conceptual</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isConceptual()
	 * @generated
	 * @ordered
	 */
	protected boolean conceptual = CONCEPTUAL_EDEFAULT;

	/**
	 * This is true if the Conceptual attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean conceptualESet;

	/**
	 * The default value of the '{@link #isConfigurationUnit() <em>Configuration Unit</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isConfigurationUnit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONFIGURATION_UNIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConfigurationUnit() <em>Configuration Unit</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isConfigurationUnit()
	 * @generated
	 * @ordered
	 */
	protected boolean configurationUnit = CONFIGURATION_UNIT_EDEFAULT;

	/**
	 * This is true if the Configuration Unit attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean configurationUnitESet;

	/**
	 * The default value of the '{@link #getGoalInstallState() <em>Goal Install State</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGoalInstallState()
	 * @generated
	 * @ordered
	 */
	protected static final InstallState GOAL_INSTALL_STATE_EDEFAULT = InstallState.UNKNOWN_LITERAL;

	/**
	 * The cached value of the '{@link #getGoalInstallState() <em>Goal Install State</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGoalInstallState()
	 * @generated
	 * @ordered
	 */
	protected InstallState goalInstallState = GOAL_INSTALL_STATE_EDEFAULT;

	/**
	 * This is true if the Goal Install State attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean goalInstallStateESet;

	/**
	 * The default value of the '{@link #getInitInstallState() <em>Init Install State</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInitInstallState()
	 * @generated
	 * @ordered
	 */
	protected static final InstallState INIT_INSTALL_STATE_EDEFAULT = InstallState.UNKNOWN_LITERAL;

	/**
	 * The cached value of the '{@link #getInitInstallState() <em>Init Install State</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInitInstallState()
	 * @generated
	 * @ordered
	 */
	protected InstallState initInstallState = INIT_INSTALL_STATE_EDEFAULT;

	/**
	 * This is true if the Init Install State attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean initInstallStateESet;

	/**
	 * The default value of the '{@link #getOrigin() <em>Origin</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected String origin = ORIGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublishIntent() <em>Publish Intent</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPublishIntent()
	 * @generated
	 * @ordered
	 */
	protected static final PublishIntent PUBLISH_INTENT_EDEFAULT = PublishIntent.PUBLISH_LITERAL;

	/**
	 * The cached value of the '{@link #getPublishIntent() <em>Publish Intent</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPublishIntent()
	 * @generated
	 * @ordered
	 */
	protected PublishIntent publishIntent = PUBLISH_INTENT_EDEFAULT;

	/**
	 * This is true if the Publish Intent attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean publishIntentESet;

	/*
	 * <doc-ku> a slight of hand with the hosting service set makes for some delectable code
	 * </doc-ku>
	 */
	private List unitLinkList;

	private List hostingLinkList;

	private List memberLinkList;

	private List dependencyLinkList;

	/** Transient view of capabilities whose link type is {@link CapabilityLinkTypes#ANY}. */
	private List onlyAnyCapabilities;

	/** Transient view of capabilities whose link type is {@link CapabilityLinkTypes#DEPENDENCY}. */
	private List onlyDependencyCapabilities;

	/** Transient view of capabilities whose link type is {@link CapabilityLinkTypes#HOSTING}. */
	private List onlyHostingCapabilities;

	/**
	 * Transient view of capabilities whose link type is {@link CapabilityLinkTypes#HOSTING} or
	 * {@link CapabilityLinkTypes#ANY}.
	 */
	private List hostingOrAnyCapabilities;

	/**
	 * Transient view of capabilities whose link type is {@link CapabilityLinkTypes#DEPENDENCY} or
	 * {@link CapabilityLinkTypes#ANY}.
	 */
	private List dependencyOrAnyCapabilities;

	/** Transient view of requirements whose link type is {@link RequirementLinkTypes#ANY}. */
	private List onlyAnyRequirements;

	/**
	 * Transient view of requirements whose link type is {@link RequirementLinkTypes#HOSTING} or
	 * {@link RequirementLinkTypes#ANY}.
	 */
	private List onlyHostingRequirements;

	/** Transient view of requirements whose link type is {@link RequirementLinkTypes#DEPENDENCY}. */
	private List onlyDependencyRequirements;

	/** Transient view of requirements whose link type is {@link RequirementLinkTypes#MEMBER}. */
	private List onlyMemberRequirements;

	/**
	 * Transient view of requirements whose link type is {@link RequirementLinkTypes#HOSTING} or
	 * {@link RequirementLinkTypes#ANY}.
	 */
	private List hostingOrAnyRequirements;

	/**
	 * Transient view of requirements whose link type is {@link RequirementLinkTypes#DEPENDENCY} or
	 * {@link RequirementLinkTypes#ANY}.
	 */
	private List dependencyOrAnyRequirements;

	/**
	 * Transient view of requirements whose link type is {@link RequirementLinkTypes#MEMBER} or
	 * {@link RequirementLinkTypes#ANY}.
	 */
	private List memberOrAnyRequirements;

	private FeatureAwareList capabilities;

	private FeatureAwareList requirements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.UNIT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getCapabilityGroup() {
		if (capabilityGroup == null) {
			capabilityGroup = new BasicFeatureMap(this, CorePackage.UNIT__CAPABILITY_GROUP);
		}
		return capabilityGroup;
	}

	public final boolean isGroup() {
		return MultiplicityChecker.canBeLinkSource(this);
		//		for (Iterator iter = getOnlyMemberRequirements().iterator(); iter.hasNext(); ) {
		//			List exprList = ((Requirement)iter.next()).getExpressions();
		//			if (exprList.size() == 0) {
		//				return true;
		//			}
		//			for (Iterator innerIter = exprList.iterator(); innerIter.hasNext(); ) {
		//				RequirementExpression re = (RequirementExpression)innerIter.next();
		//				if (re.getInterpreter().equals(OutCardinality.INTERPRETER_ID)) {
		//					return true;
		//				}
		//			}
		//		}
		//		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isVisible() {
		return super.isVisible();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isPublic() {
		return super.isPublic();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isPublicEditable() {
		return super.isPublicEditable();
	}

	public final boolean isBound() {
		// TODO update with proper logic when available, not sure if using origin attribute or not
		if (this.getOrigin() != null && this.getOrigin().length() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List getRequirements() {

		if (requirements == null) {
			requirements = new FeatureAwareList(CorePackage.eINSTANCE.getUnit_Requirements(),
					(FeatureMap.Internal) getRequirementGroup());
		}
		return requirements;
	}

	public List getRequirements(IObjectFilter filter, IObjectAdapter adapter) {
		return new FilterList((EList) getRequirements(), filter, adapter);
	}

	public List getOnlyAnyRequirements() {
		if (onlyAnyRequirements == null) {
			onlyAnyRequirements = getRequirements(RequirementLinkTypeFilter.ANY_FILTER,
					RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_EXPOSED_HOSTING_ADAPTER);
		}
		return onlyAnyRequirements;
	}

	public List getOnlyHostingRequirements() {
		if (onlyHostingRequirements == null) {
			onlyHostingRequirements = getRequirements(RequirementLinkTypeFilter.HOSTING_FILTER,
					RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_HOSTING_ADAPTER);
		}
		return onlyHostingRequirements;
	}

	public List getOnlyDependencyRequirements() {
		if (onlyDependencyRequirements == null) {
			onlyDependencyRequirements = getRequirements(RequirementLinkTypeFilter.DEPENDENCY_FILTER,
					RequirementLinkTypeAdapter.SET_REQUIREMENT_DEPENDENCY_LINK_TYPE_ADAPTER);
		}
		return onlyDependencyRequirements;
	}

	public List getOnlyMemberRequirements() {
		if (onlyMemberRequirements == null) {
			onlyMemberRequirements = getRequirements(RequirementLinkTypeFilter.MEMBER_FILTER,
					RequirementLinkTypeAdapter.SET_REQUIREMENT_MEMBER_LINK_TYPE_ADAPTER);
		}
		return onlyMemberRequirements;
	}

	public List getHostingOrAnyRequirements() {
		if (hostingOrAnyRequirements == null) {
			hostingOrAnyRequirements = getRequirements(
					RequirementLinkTypeFilter.ANY_OR_HOSTING_FILTER,
					RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_ANY_IF_NON_HOSTING_ADAPTER);
		}
		return hostingOrAnyRequirements;
	}

	public List getDependencyOrAnyRequirements() {
		if (dependencyOrAnyRequirements == null) {
			dependencyOrAnyRequirements = getRequirements(
					RequirementLinkTypeFilter.ANY_OR_DEPENDENCY_FILTER,
					RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_ANY_IF_NON_DEPENDENCY_ADAPTER);
		}
		return dependencyOrAnyRequirements;
	}

	public List getMemberOrAnyRequirements() {
		if (memberOrAnyRequirements == null) {
			memberOrAnyRequirements = getRequirements(RequirementLinkTypeFilter.ANY_OR_MEMBER_FILTER,
					RequirementLinkTypeAdapter.SET_REQUIREMENT_LINK_TYPE_ANY_IF_NON_MEMBER_ADAPTER);
		}
		return memberOrAnyRequirements;
	}

	public List getCapabilities() {
		if (capabilities == null) {
			capabilities = new FeatureAwareList(CorePackage.eINSTANCE.getUnit_Capabilities(),
					(FeatureMap.Internal) getCapabilityGroup());
		}
		return capabilities;
	}

	/**
	 * @generated
	 */
	public List getCapabilitiesGen() {
		return getCapabilityGroup().list(CorePackage.Literals.UNIT__CAPABILITIES);
	}

	public List getCapabilities(IObjectFilter filter, IObjectAdapter adapter) {
		return new FilterList((EList) getCapabilities(), filter, adapter);
	}

	public List getOnlyAnyCapabilities() {
		if (onlyAnyCapabilities == null) {
			onlyAnyCapabilities = getCapabilities(CapabilityLinkTypeFilter.ANY_FILTER,
					CapabilityLinkTypeAdapter.SET_CAPABILITY_LINK_TYPE_ANY_ADAPTER);
		}
		return onlyAnyCapabilities;
	}

	public List getOnlyDependencyCapabilities() {
		if (onlyDependencyCapabilities == null) {
			onlyDependencyCapabilities = getCapabilities(CapabilityLinkTypeFilter.DEPENDENCY_FILTER,
					CapabilityLinkTypeAdapter.SET_CAPABILITY_LINK_TYPE_DEPENDENCY_ADAPTER);
		}
		return onlyDependencyCapabilities;
	}

	public List getOnlyHostingCapabilities() {
		if (onlyHostingCapabilities == null) {
			onlyHostingCapabilities = getCapabilities(CapabilityLinkTypeFilter.HOSTING_FILTER,
					CapabilityLinkTypeAdapter.SET_CAPABILITY_LINK_TYPE_HOSTING_ADAPTER);
		}
		return onlyHostingCapabilities;
	}

	public List getHostingOrAnyCapabilities() {
		if (hostingOrAnyCapabilities == null) {
			hostingOrAnyCapabilities = getCapabilities(CapabilityLinkTypeFilter.ANY_OR_HOSTING_FILTER,
					CapabilityLinkTypeAdapter.SET_CAPABILITY_LINK_TYPE_ANY_IF_NON_HOSTING_ADAPTER);
		}
		return hostingOrAnyCapabilities;
	}

	public List getDependencyOrAnyCapabilities() {
		if (dependencyOrAnyCapabilities == null) {
			dependencyOrAnyCapabilities = getCapabilities(
					CapabilityLinkTypeFilter.ANY_OR_DEPENDENCY_FILTER,
					CapabilityLinkTypeAdapter.SET_CAPABILITY_LINK_TYPE_ANY_IF_NON_DEPENDENCY_ADAPTER);
		}
		return dependencyOrAnyCapabilities;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getRequirementGroup() {
		if (requirementGroup == null) {
			requirementGroup = new BasicFeatureMap(this, CorePackage.UNIT__REQUIREMENT_GROUP);
		}
		return requirementGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getUnitLinksGroup() {
		if (unitLinksGroup == null) {
			unitLinksGroup = new BasicFeatureMap(this, CorePackage.UNIT__UNIT_LINKS_GROUP);
		}
		return unitLinksGroup;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Unit#getUnitLinks()
	 */
	public List getUnitLinks() {
		if (unitLinkList == null) {
			unitLinkList = new FeatureAwareList(CorePackage.eINSTANCE.getUnit_UnitLinks(),
					(FeatureMap.Internal) getUnitLinksGroup());
		}
		return unitLinkList;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Unit#getHostingLinks()
	 */
	public List getHostingLinks() {
		if (hostingLinkList == null) {
			hostingLinkList = new FilterList((EList) getUnitLinks(),
					EObjectTypeFilter.HOSTING_LINK_FILTER);
		}
		return hostingLinkList;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Unit#getMemberLinks()
	 */
	public List getMemberLinks() {
		if (memberLinkList == null) {
			memberLinkList = new FilterList((EList) getUnitLinks(),
					EObjectTypeFilter.MEMBER_LINK_FILTER);
		}
		return memberLinkList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getUnitLinksGen() {
		return getUnitLinksGroup().list(CorePackage.Literals.UNIT__UNIT_LINKS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getConstraintLinks() {
		if (constraintLinks == null) {
			constraintLinks = new EObjectContainmentEList(ConstraintLink.class, this,
					CorePackage.UNIT__CONSTRAINT_LINKS);
		}
		return constraintLinks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getRealizationLinks() {
		if (realizationLinks == null) {
			realizationLinks = new EObjectContainmentEList(RealizationLink.class, this,
					CorePackage.UNIT__REALIZATION_LINKS);
		}
		return realizationLinks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getStereotypes() {
		if (stereotypes == null) {
			stereotypes = new EObjectContainmentEList(Stereotype.class, this,
					CorePackage.UNIT__STEREOTYPES);
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getBuildVersion() {
		return buildVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBuildVersion(String newBuildVersion) {
		String oldBuildVersion = buildVersion;
		buildVersion = newBuildVersion;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UNIT__BUILD_VERSION,
					oldBuildVersion, buildVersion));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isConceptual() {
		return conceptual;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConceptual(boolean newConceptual) {
		boolean oldConceptual = conceptual;
		conceptual = newConceptual;
		boolean oldConceptualESet = conceptualESet;
		conceptualESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UNIT__CONCEPTUAL,
					oldConceptual, conceptual, !oldConceptualESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetConceptual() {
		boolean oldConceptual = conceptual;
		boolean oldConceptualESet = conceptualESet;
		conceptual = CONCEPTUAL_EDEFAULT;
		conceptualESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.UNIT__CONCEPTUAL,
					oldConceptual, CONCEPTUAL_EDEFAULT, oldConceptualESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetConceptual() {
		return conceptualESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isConfigurationUnit() {
		return configurationUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConfigurationUnit(boolean newConfigurationUnit) {
		boolean oldConfigurationUnit = configurationUnit;
		configurationUnit = newConfigurationUnit;
		boolean oldConfigurationUnitESet = configurationUnitESet;
		configurationUnitESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.UNIT__CONFIGURATION_UNIT, oldConfigurationUnit, configurationUnit,
					!oldConfigurationUnitESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetConfigurationUnit() {
		boolean oldConfigurationUnit = configurationUnit;
		boolean oldConfigurationUnitESet = configurationUnitESet;
		configurationUnit = CONFIGURATION_UNIT_EDEFAULT;
		configurationUnitESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					CorePackage.UNIT__CONFIGURATION_UNIT, oldConfigurationUnit,
					CONFIGURATION_UNIT_EDEFAULT, oldConfigurationUnitESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetConfigurationUnit() {
		return configurationUnitESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstallState getGoalInstallState() {
		return goalInstallState;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGoalInstallState(InstallState newGoalInstallState) {
		InstallState oldGoalInstallState = goalInstallState;
		goalInstallState = newGoalInstallState == null ? GOAL_INSTALL_STATE_EDEFAULT
				: newGoalInstallState;
		boolean oldGoalInstallStateESet = goalInstallStateESet;
		goalInstallStateESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.UNIT__GOAL_INSTALL_STATE, oldGoalInstallState, goalInstallState,
					!oldGoalInstallStateESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetGoalInstallState() {
		InstallState oldGoalInstallState = goalInstallState;
		boolean oldGoalInstallStateESet = goalInstallStateESet;
		goalInstallState = GOAL_INSTALL_STATE_EDEFAULT;
		goalInstallStateESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					CorePackage.UNIT__GOAL_INSTALL_STATE, oldGoalInstallState,
					GOAL_INSTALL_STATE_EDEFAULT, oldGoalInstallStateESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetGoalInstallState() {
		return goalInstallStateESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstallState getInitInstallState() {
		return initInstallState;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInitInstallState(InstallState newInitInstallState) {
		InstallState oldInitInstallState = initInstallState;
		initInstallState = newInitInstallState == null ? INIT_INSTALL_STATE_EDEFAULT
				: newInitInstallState;
		boolean oldInitInstallStateESet = initInstallStateESet;
		initInstallStateESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.UNIT__INIT_INSTALL_STATE, oldInitInstallState, initInstallState,
					!oldInitInstallStateESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetInitInstallState() {
		InstallState oldInitInstallState = initInstallState;
		boolean oldInitInstallStateESet = initInstallStateESet;
		initInstallState = INIT_INSTALL_STATE_EDEFAULT;
		initInstallStateESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					CorePackage.UNIT__INIT_INSTALL_STATE, oldInitInstallState,
					INIT_INSTALL_STATE_EDEFAULT, oldInitInstallStateESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetInitInstallState() {
		return initInstallStateESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOrigin(String newOrigin) {
		String oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UNIT__ORIGIN, oldOrigin,
					origin));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PublishIntent getPublishIntent() {
		return publishIntent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPublishIntent(PublishIntent newPublishIntent) {
		PublishIntent oldPublishIntent = publishIntent;
		publishIntent = newPublishIntent == null ? PUBLISH_INTENT_EDEFAULT : newPublishIntent;
		boolean oldPublishIntentESet = publishIntentESet;
		publishIntentESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UNIT__PUBLISH_INTENT,
					oldPublishIntent, publishIntent, !oldPublishIntentESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetPublishIntent() {
		PublishIntent oldPublishIntent = publishIntent;
		boolean oldPublishIntentESet = publishIntentESet;
		publishIntent = PUBLISH_INTENT_EDEFAULT;
		publishIntentESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.UNIT__PUBLISH_INTENT,
					oldPublishIntent, PUBLISH_INTENT_EDEFAULT, oldPublishIntentESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetPublishIntent() {
		return publishIntentESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case CorePackage.UNIT__CAPABILITY_GROUP:
			return ((InternalEList) getCapabilityGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.UNIT__CAPABILITIES:
			return ((InternalEList) getCapabilities()).basicRemove(otherEnd, msgs);
		case CorePackage.UNIT__REQUIREMENT_GROUP:
			return ((InternalEList) getRequirementGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.UNIT__REQUIREMENTS:
			return ((InternalEList) getRequirements()).basicRemove(otherEnd, msgs);
		case CorePackage.UNIT__UNIT_LINKS_GROUP:
			return ((InternalEList) getUnitLinksGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.UNIT__UNIT_LINKS:
			return ((InternalEList) getUnitLinks()).basicRemove(otherEnd, msgs);
		case CorePackage.UNIT__CONSTRAINT_LINKS:
			return ((InternalEList) getConstraintLinks()).basicRemove(otherEnd, msgs);
		case CorePackage.UNIT__REALIZATION_LINKS:
			return ((InternalEList) getRealizationLinks()).basicRemove(otherEnd, msgs);
		case CorePackage.UNIT__STEREOTYPES:
			return ((InternalEList) getStereotypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case CorePackage.UNIT__CAPABILITY_GROUP:
			if (coreType) {
				return getCapabilityGroup();
			}
			return ((FeatureMap.Internal) getCapabilityGroup()).getWrapper();
		case CorePackage.UNIT__CAPABILITIES:
			return getCapabilities();
		case CorePackage.UNIT__REQUIREMENT_GROUP:
			if (coreType) {
				return getRequirementGroup();
			}
			return ((FeatureMap.Internal) getRequirementGroup()).getWrapper();
		case CorePackage.UNIT__REQUIREMENTS:
			return getRequirements();
		case CorePackage.UNIT__UNIT_LINKS_GROUP:
			if (coreType) {
				return getUnitLinksGroup();
			}
			return ((FeatureMap.Internal) getUnitLinksGroup()).getWrapper();
		case CorePackage.UNIT__UNIT_LINKS:
			return getUnitLinks();
		case CorePackage.UNIT__CONSTRAINT_LINKS:
			return getConstraintLinks();
		case CorePackage.UNIT__REALIZATION_LINKS:
			return getRealizationLinks();
		case CorePackage.UNIT__STEREOTYPES:
			return getStereotypes();
		case CorePackage.UNIT__BUILD_VERSION:
			return getBuildVersion();
		case CorePackage.UNIT__CONCEPTUAL:
			return isConceptual() ? Boolean.TRUE : Boolean.FALSE;
		case CorePackage.UNIT__CONFIGURATION_UNIT:
			return isConfigurationUnit() ? Boolean.TRUE : Boolean.FALSE;
		case CorePackage.UNIT__GOAL_INSTALL_STATE:
			return getGoalInstallState();
		case CorePackage.UNIT__INIT_INSTALL_STATE:
			return getInitInstallState();
		case CorePackage.UNIT__ORIGIN:
			return getOrigin();
		case CorePackage.UNIT__PUBLISH_INTENT:
			return getPublishIntent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case CorePackage.UNIT__CAPABILITY_GROUP:
			((FeatureMap.Internal) getCapabilityGroup()).set(newValue);
			return;
		case CorePackage.UNIT__CAPABILITIES:
			getCapabilities().clear();
			getCapabilities().addAll((Collection) newValue);
			return;
		case CorePackage.UNIT__REQUIREMENT_GROUP:
			((FeatureMap.Internal) getRequirementGroup()).set(newValue);
			return;
		case CorePackage.UNIT__REQUIREMENTS:
			getRequirements().clear();
			getRequirements().addAll((Collection) newValue);
			return;
		case CorePackage.UNIT__UNIT_LINKS_GROUP:
			((FeatureMap.Internal) getUnitLinksGroup()).set(newValue);
			return;
		case CorePackage.UNIT__UNIT_LINKS:
			getUnitLinks().clear();
			getUnitLinks().addAll((Collection) newValue);
			return;
		case CorePackage.UNIT__CONSTRAINT_LINKS:
			getConstraintLinks().clear();
			getConstraintLinks().addAll((Collection) newValue);
			return;
		case CorePackage.UNIT__REALIZATION_LINKS:
			getRealizationLinks().clear();
			getRealizationLinks().addAll((Collection) newValue);
			return;
		case CorePackage.UNIT__STEREOTYPES:
			getStereotypes().clear();
			getStereotypes().addAll((Collection) newValue);
			return;
		case CorePackage.UNIT__BUILD_VERSION:
			setBuildVersion((String) newValue);
			return;
		case CorePackage.UNIT__CONCEPTUAL:
			setConceptual(((Boolean) newValue).booleanValue());
			return;
		case CorePackage.UNIT__CONFIGURATION_UNIT:
			setConfigurationUnit(((Boolean) newValue).booleanValue());
			return;
		case CorePackage.UNIT__GOAL_INSTALL_STATE:
			setGoalInstallState((InstallState) newValue);
			return;
		case CorePackage.UNIT__INIT_INSTALL_STATE:
			setInitInstallState((InstallState) newValue);
			return;
		case CorePackage.UNIT__ORIGIN:
			setOrigin((String) newValue);
			return;
		case CorePackage.UNIT__PUBLISH_INTENT:
			setPublishIntent((PublishIntent) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case CorePackage.UNIT__CAPABILITY_GROUP:
			getCapabilityGroup().clear();
			return;
		case CorePackage.UNIT__CAPABILITIES:
			getCapabilities().clear();
			return;
		case CorePackage.UNIT__REQUIREMENT_GROUP:
			getRequirementGroup().clear();
			return;
		case CorePackage.UNIT__REQUIREMENTS:
			getRequirements().clear();
			return;
		case CorePackage.UNIT__UNIT_LINKS_GROUP:
			getUnitLinksGroup().clear();
			return;
		case CorePackage.UNIT__UNIT_LINKS:
			getUnitLinks().clear();
			return;
		case CorePackage.UNIT__CONSTRAINT_LINKS:
			getConstraintLinks().clear();
			return;
		case CorePackage.UNIT__REALIZATION_LINKS:
			getRealizationLinks().clear();
			return;
		case CorePackage.UNIT__STEREOTYPES:
			getStereotypes().clear();
			return;
		case CorePackage.UNIT__BUILD_VERSION:
			setBuildVersion(BUILD_VERSION_EDEFAULT);
			return;
		case CorePackage.UNIT__CONCEPTUAL:
			unsetConceptual();
			return;
		case CorePackage.UNIT__CONFIGURATION_UNIT:
			unsetConfigurationUnit();
			return;
		case CorePackage.UNIT__GOAL_INSTALL_STATE:
			unsetGoalInstallState();
			return;
		case CorePackage.UNIT__INIT_INSTALL_STATE:
			unsetInitInstallState();
			return;
		case CorePackage.UNIT__ORIGIN:
			setOrigin(ORIGIN_EDEFAULT);
			return;
		case CorePackage.UNIT__PUBLISH_INTENT:
			unsetPublishIntent();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case CorePackage.UNIT__CAPABILITY_GROUP:
			return capabilityGroup != null && !capabilityGroup.isEmpty();
		case CorePackage.UNIT__CAPABILITIES:
			return !getCapabilities().isEmpty();
		case CorePackage.UNIT__REQUIREMENT_GROUP:
			return requirementGroup != null && !requirementGroup.isEmpty();
		case CorePackage.UNIT__REQUIREMENTS:
			return !getRequirements().isEmpty();
		case CorePackage.UNIT__UNIT_LINKS_GROUP:
			return unitLinksGroup != null && !unitLinksGroup.isEmpty();
		case CorePackage.UNIT__UNIT_LINKS:
			return !getUnitLinks().isEmpty();
		case CorePackage.UNIT__CONSTRAINT_LINKS:
			return constraintLinks != null && !constraintLinks.isEmpty();
		case CorePackage.UNIT__REALIZATION_LINKS:
			return realizationLinks != null && !realizationLinks.isEmpty();
		case CorePackage.UNIT__STEREOTYPES:
			return stereotypes != null && !stereotypes.isEmpty();
		case CorePackage.UNIT__BUILD_VERSION:
			return BUILD_VERSION_EDEFAULT == null ? buildVersion != null : !BUILD_VERSION_EDEFAULT
					.equals(buildVersion);
		case CorePackage.UNIT__CONCEPTUAL:
			return isSetConceptual();
		case CorePackage.UNIT__CONFIGURATION_UNIT:
			return isSetConfigurationUnit();
		case CorePackage.UNIT__GOAL_INSTALL_STATE:
			return isSetGoalInstallState();
		case CorePackage.UNIT__INIT_INSTALL_STATE:
			return isSetInitInstallState();
		case CorePackage.UNIT__ORIGIN:
			return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
		case CorePackage.UNIT__PUBLISH_INTENT:
			return isSetPublishIntent();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (capabilityGroup: "); //$NON-NLS-1$
		result.append(capabilityGroup);
		result.append(", requirementGroup: "); //$NON-NLS-1$
		result.append(requirementGroup);
		result.append(", unitLinksGroup: "); //$NON-NLS-1$
		result.append(unitLinksGroup);
		result.append(", buildVersion: "); //$NON-NLS-1$
		result.append(buildVersion);
		result.append(", conceptual: "); //$NON-NLS-1$
		if (conceptualESet) {
			result.append(conceptual);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", configurationUnit: "); //$NON-NLS-1$
		if (configurationUnitESet) {
			result.append(configurationUnit);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", goalInstallState: "); //$NON-NLS-1$
		if (goalInstallStateESet) {
			result.append(goalInstallState);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", initInstallState: "); //$NON-NLS-1$
		if (initInstallStateESet) {
			result.append(initInstallState);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", origin: "); //$NON-NLS-1$
		result.append(origin);
		result.append(", publishIntent: "); //$NON-NLS-1$
		if (publishIntentESet) {
			result.append(publishIntent);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(')');
		return result.toString();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#getContainedModelObjects()
	 */
	public List getContainedModelObjects() {
		//		List resultList = null;
		//		List existingList = null;
		//		
		//		if (!getCapabilities().isEmpty()) {
		//			if (resultList != null) {
		//				resultList.addAll(getCapabilities());
		//			} else if (existingList != null) {
		//				resultList = new ArrayList(existingList);
		//				resultList.addAll(getCapabilities());
		//			} else {
		//				existingList = getCapabilities();
		//			}
		//		}
		//
		//		if (!getRequirements().isEmpty()) {
		//			// Compatibility (do not require adapted requirements)
		//			if (resultList == null) {
		//				if (existingList != null) {
		//					resultList = new ArrayList(existingList);
		//				} else {
		//					resultList = new ArrayList();
		//				}
		//			}
		//			for (Iterator iter = getRequirements().iterator(); iter.hasNext();) {
		//				Requirement req = (Requirement) iter.next();
		//				resultList.add(req);
		//			}
		//		}
		//
		//		if (!getUnitLinks().isEmpty()) {
		//			if (resultList != null) {
		//				resultList.addAll(getUnitLinks());
		//			} else if (existingList != null) {
		//				resultList = new ArrayList(existingList);
		//				resultList.addAll(getUnitLinks());
		//			} else {
		//				existingList = getUnitLinks();
		//			}
		//		}
		//
		//		if (!getLogicalLinks().isEmpty()) {
		//			if (resultList != null) {
		//				resultList.addAll(getLogicalLinks());
		//			} else if (existingList != null) {
		//				resultList = new ArrayList(existingList);
		//				resultList.addAll(getLogicalLinks());
		//			} else {
		//				existingList = getLogicalLinks();
		//			}
		//		}
		//
		//		if (!getArtifacts().isEmpty()) {
		//			if (resultList != null) {
		//				resultList.addAll(getArtifacts());
		//			} else if (existingList != null) {
		//				resultList = new ArrayList(existingList);
		//				resultList.addAll(getArtifacts());
		//			} else {
		//				existingList = getArtifacts();
		//			}
		//		}
		//
		//		if (resultList != null) {
		//			return Collections.unmodifiableList(resultList);
		//		} else if (existingList != null) {
		//			return Collections.unmodifiableList(existingList);
		//		} else {
		//			return Collections.EMPTY_LIST;
		//		}

		List resultList = new ArrayList();

		resultList.addAll(getCapabilities());
		resultList.addAll(getRequirements());
		resultList.addAll(getUnitLinks());
		resultList.addAll(getConstraintLinks());
		resultList.addAll(getConstraintsGen());
		resultList.addAll(getArtifacts());

		if (resultList.size() > 0) {
			return Collections.unmodifiableList(resultList);
		} else {
			return Collections.EMPTY_LIST;
		}
	}

	public boolean isHosting(Unit hostedUnit, boolean checkContained) {
		if (hostedUnit == null) {
			return false;
		}
		if (!getHostingLinks().isEmpty()) {
			for (Iterator it = getHostingLinks().iterator(); it.hasNext();) {
				UnitLink unitLink = (UnitLink) it.next();
				if (unitLink instanceof HostingLink) {
					HostingLink link = (HostingLink) unitLink;
					if (hostedUnit == link.getHosted()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public String getSpecializedTypeId() {
		return this.getClass().getName();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List getDependencyLinks() {
		if (dependencyLinkList == null) {
			List requirements = getDependencyOrAnyRequirements();
			for (Iterator iterator = requirements.iterator(); iterator.hasNext();) {
				Requirement req = (Requirement) iterator.next();
				DependencyLink link = req.getLink();
				if (link != null && link.getTarget() != null) {
					dependencyLinkList.add(link);
				}

			}
		}
		return dependencyLinkList;
	}

	//	/**
	//	 * @param hypotheticals
	//	 *           Map of Capability->Map(of String->Object)
	//	 * @return if not-null, the Capability's contribution to the Unit's recommended title
	//	 * @deprecated
	//	 */
	//	public String calculatedTitle(Map<Capability, Map<EAttribute, String>> hypotheticals) {
	//		// Use the title of the first Capability.  Ignore conflicts.
	//		for (Iterator<Capability> it = getCapabilities().iterator(); it.hasNext();) {
	//			Capability cap = it.next();
	//			Map<EAttribute, String> capHypotheticals = hypotheticals == null ? null : hypotheticals
	//					.get(cap);
	//			//			String retVal = cap.calculatedTitle(capHypotheticals);
	//			String retVal = cap.getCaptionProvider().calculatedTitle(cap, capHypotheticals);
	//			if (retVal != null) {
	//				return retVal;
	//			}
	//		}
	//
	//		return null;
	//	}
	//
	//	/**
	//	 * @return A String that names the Capability
	//	 * @deprecated
	//	 */
	//	public String title() {
	//		if (getDisplayName() != null) {
	//			return getDisplayName();
	//		}
	//
	//		String retVal = calculatedTitle(null);
	//		if (retVal != null) {
	//			return retVal;
	//		}
	//
	//		return getName();
	//	}
	//
	//	/**
	//	 * @return A String that names the Capability and supplies additional information
	//	 * @deprecated
	//	 */
	//	public String titleWithContext() {
	//		Topology top = getTopology();
	//		if (top != null) {
	//			Unit[] hosters = top.findHosts(this);
	//			if (hosters != null && hosters.length > 0) {
	//				Unit host = hosters[0];
	//				return title() + " on " + host.title(); //$NON-NLS-1$
	//			}
	//			// Check membership if unit has no hosting requirements
	//			if (getHostingOrAnyRequirements().size() == 0 && getOnlyMemberRequirements().size() != 0) {
	//				Unit[] groups = top.findMemberOf(this);
	//				if (groups.length > 0) {
	//					StringBuffer buffer = new StringBuffer();
	//					buffer.append(title());
	//					buffer.append(" in "); //$NON-NLS-1$
	//					for (int i = 0; i < groups.length; i++) {
	//						if (i > 0) {
	//							buffer.append(',');
	//							buffer.append(' ');
	//						}
	//						buffer.append(groups[i].title());
	//					}
	//					return buffer.toString();
	//				}
	//			}
	//		}
	//
	//		return title();
	//	}

	public UnitCaptionProvider getCaptionProvider() {
		return unitCaptionProvider;
	}

	private static UnitCaptionProvider unitCaptionProvider = new UnitCaptionProvider();

} //UnitImpl
