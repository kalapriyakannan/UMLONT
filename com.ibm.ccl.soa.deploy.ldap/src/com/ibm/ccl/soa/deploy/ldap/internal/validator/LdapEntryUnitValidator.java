/***************************************************************************************************
 * LdapEntryUnitValidator.java -- Validator for {@link LdapEntryUnit} objects
 * 
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.ldap.internal.validator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.ldap.LdapDeployPlugin;
import com.ibm.ccl.soa.deploy.ldap.LdapEntry;
import com.ibm.ccl.soa.deploy.ldap.LdapEntryUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.internal.LdapDomainMessages;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.marker.ILdapDomainValidators;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.marker.ILdapProblemType;

/**
 * Validator for {@link LdapEntryUnit} objects.
 * 
 * Make sure that we have exactly one structural LDAP class capability attached. For all of the LDAP
 * class capabilities, make sure all "MUST" attributes are represented by an
 * {@link ExtendedAttribute} attached to our {@link LdapEntry} capability, and that they have
 * values. Make sure that all other {@link ExtendedAttribute ExtendedAttributes} are listed as an
 * optional attribute of at least one LDAP class.
 * 
 */
public class LdapEntryUnitValidator extends UnitValidator implements ILdapDomainValidators,
		ILdapProblemType {

	/**
	 * Constructor -- add cardinality constraints on requirements and capabilities.
	 */
	public LdapEntryUnitValidator() {
		super(LdapPackage.eINSTANCE.getLdapEntryUnit());

		addCapabilityTypeConstraint(LdapPackage.eINSTANCE.getLdapEntry(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		// TODO Declarative way to specify a <constraint.or> requirement constraint?

//		addRequirementTypeConstraint(LdapPackage.eINSTANCE.getLdapEntry(),
//				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
	}

	private final static HashMap<EClass, String[]> ldapCap2MUSTAttrs = new HashMap<EClass, String[]>();
	private final static HashMap<EClass, String[]> ldapCap2MAYAttrs = new HashMap<EClass, String[]>();
	private final static HashMap<EClass, String[]> ldapCap2MUSTNOTAttrs = new HashMap<EClass, String[]>();
	{
		ldapCap2MAYAttrs.put(LdapPackage.eINSTANCE.getEPerson(), new String[] { "accesshint", //$NON-NLS-1$ 
				"accounthint", //$NON-NLS-1$
				"audio", //$NON-NLS-1$
				"businesscategory", //$NON-NLS-1$
				"c", //$NON-NLS-1$
				"carlicense", //$NON-NLS-1$
				"configptr", //$NON-NLS-1$
				"departmentnumber", //$NON-NLS-1$
				"Description", //$NON-NLS-1$
				"destinationindicator", //$NON-NLS-1$
				"displayname", //$NON-NLS-1$
				"employeenumber", //$NON-NLS-1$
				"employeetype", //$NON-NLS-1$
				"facsimiletelephonenumber", //$NON-NLS-1$
				"generationqualifier", //$NON-NLS-1$
				"givenname", //$NON-NLS-1$
				"homefax", //$NON-NLS-1$
				"homephone", //$NON-NLS-1$
				"homepostaladdress", //$NON-NLS-1$
				"initials", //$NON-NLS-1$
				"internationalisdnnumber", //$NON-NLS-1$
				"jpegphoto", //$NON-NLS-1$
				"l", //$NON-NLS-1$
				"labeleduri", //$NON-NLS-1$
				"mail", //$NON-NLS-1$
				"manager", //$NON-NLS-1$
				"middlename", //$NON-NLS-1$
				"mobile", //$NON-NLS-1$
				"o", //$NON-NLS-1$
				"organizationalstatus", //$NON-NLS-1$ 
				"othermailbox", //$NON-NLS-1$
				"ou", //$NON-NLS-1$
				"pager", //$NON-NLS-1$
				"personaltitle", //$NON-NLS-1$
				"photo", //$NON-NLS-1$
				"physicaldeliveryofficename", //$NON-NLS-1$ 
				"postaladdress", //$NON-NLS-1$
				"postalcode", //$NON-NLS-1$
				"postofficebox", //$NON-NLS-1$
				"preferreddeliverymethod", //$NON-NLS-1$
				"preferredlanguage", //$NON-NLS-1$
				"registeredaddress", //$NON-NLS-1$
				"roomnumber", //$NON-NLS-1$
				"secretary", //$NON-NLS-1$
				"seealso", //$NON-NLS-1$
				"st", //$NON-NLS-1$
				"street", //$NON-NLS-1$
				"telephonenumber", //$NON-NLS-1$
				"teletexterminalidentifier", //$NON-NLS-1$
				"telexnumber", //$NON-NLS-1$
				"thumbnaillogo", //$NON-NLS-1$
				"thumbnailphoto", //$NON-NLS-1$
				"title", //$NON-NLS-1$
				"uid", //$NON-NLS-1$
				"uniqueidentifier", //$NON-NLS-1$
				"usercertificate", //$NON-NLS-1$
				"userpassword", //$NON-NLS-1$
				"userpkcs12", //$NON-NLS-1$
				"usersmimecertificate", //$NON-NLS-1$
				"x121address", //$NON-NLS-1$
				"x500uniqueidentifier" //$NON-NLS-1$
		});

		ldapCap2MAYAttrs.put(LdapPackage.eINSTANCE.getInetOrgPerson(), new String[] { "audio", //$NON-NLS-1$ 
				"businessCategory", //$NON-NLS-1$
				"carLicense", //$NON-NLS-1$
				"departmentNumber", //$NON-NLS-1$
				"displayname", //$NON-NLS-1$
				"employeeNumber", //$NON-NLS-1$
				"employeeType", //$NON-NLS-1$
				"givenName", //$NON-NLS-1$
				"homePhone", //$NON-NLS-1$
				"homePostalAddress", //$NON-NLS-1$
				"initials", //$NON-NLS-1$
				"jpegPhoto", //$NON-NLS-1$
				"labeledURI", //$NON-NLS-1$
				"mail", //$NON-NLS-1$
				"manager", //$NON-NLS-1$
				"mobile", //$NON-NLS-1$
				"o", //$NON-NLS-1$
				"pager", //$NON-NLS-1$
				"photo", //$NON-NLS-1$
				"preferredLanguage", //$NON-NLS-1$
				"roomNumber", //$NON-NLS-1$
				"secretary", //$NON-NLS-1$
				"uid", //$NON-NLS-1$
				"userCertificate", //$NON-NLS-1$
				"userPKCS12", //$NON-NLS-1$
				"userSMIMECertificate", //$NON-NLS-1$
				"x500uniqueIdentifier" //$NON-NLS-1$
		});

		ldapCap2MUSTAttrs.put(LdapPackage.eINSTANCE.getOrganization(), new String[] { "o" //$NON-NLS-1$
				});
		ldapCap2MAYAttrs.put(LdapPackage.eINSTANCE.getOrganization(), new String[] {
				"businessCategory", //$NON-NLS-1$
				"Description", //$NON-NLS-1$
				"destinationIndicator", //$NON-NLS-1$
				"facsimileTelephoneNumber", //$NON-NLS-1$
				"internationalISDNNumber", //$NON-NLS-1$
				"l", //$NON-NLS-1$
				"physicalDeliveryOfficeName", //$NON-NLS-1$
				"postOfficeBox", //$NON-NLS-1$
				"postalAddress", //$NON-NLS-1$
				"postalCode", //$NON-NLS-1$
				"preferredDeliveryMethod", //$NON-NLS-1$
				"registeredAddress", //$NON-NLS-1$
				"searchGuide", //$NON-NLS-1$
				"seeAlso", //$NON-NLS-1$
				"st", //$NON-NLS-1$
				"street", //$NON-NLS-1$
				"telephoneNumber", //$NON-NLS-1$
				"teletexTerminalIdentifier", //$NON-NLS-1$
				"telexNumber", //$NON-NLS-1$
				"userPassword", //$NON-NLS-1$
				"x121Address" //$NON-NLS-1$
		});

		ldapCap2MAYAttrs.put(LdapPackage.eINSTANCE.getOrganizationalPerson(), new String[] {
				"destinationIndicator", //$NON-NLS-1$
				"facsimileTelephoneNumber", //$NON-NLS-1$
				"internationalISDNNumber", //$NON-NLS-1$
				"l", //$NON-NLS-1$
				"ou", //$NON-NLS-1$
				"physicalDeliveryOfficeName", //$NON-NLS-1$ 
				"postalAddress", //$NON-NLS-1$
				"postalCode", //$NON-NLS-1$
				"postOfficeBox", //$NON-NLS-1$
				"preferredDeliveryMethod", //$NON-NLS-1$
				"registeredAddress", //$NON-NLS-1$
				"st", //$NON-NLS-1$
				"street", //$NON-NLS-1$
				"telephoneNumber", //$NON-NLS-1$
				"teletexTerminalIdentifier", //$NON-NLS-1$
				"telexNumber", //$NON-NLS-1$
				"title", //$NON-NLS-1$
				"x121Address" //$NON-NLS-1$
		});

		ldapCap2MUSTAttrs.put(LdapPackage.eINSTANCE.getPerson(), new String[] { "cn", //$NON-NLS-1$
				"sn" //$NON-NLS-1$
		});
		ldapCap2MAYAttrs.put(LdapPackage.eINSTANCE.getPerson(), new String[] { "Description", //$NON-NLS-1$ 
				"seeAlso", //$NON-NLS-1$
				"telephoneNumber", //$NON-NLS-1$
				"userPassword" //$NON-NLS-1$
		});

	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy
	 * .core.Unit, com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 * com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	protected void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);

		LdapEntryUnit ldapEntryUnit = (LdapEntryUnit) unit;

		// XXX Performance: Make one pass thru caps, rather than multiple findCaps() calls

		List<Capability> ldapEntryCaps = ValidatorUtils.findCapabilities(ldapEntryUnit,
				LdapPackage.eINSTANCE.getLdapEntry());
//	

		// TODO Validate that we have the correct <constraint.or> hosting requirement

		// Ensure that entry has exactly one structural LDAP Type...

		List<Capability> structuralCaps = ValidatorUtils.findCapabilities(ldapEntryUnit,
				LdapPackage.eINSTANCE.getTop());
		if (structuralCaps.size() != 1) {
			if (structuralCaps.size() == 0) {
				reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						LDAP_ENTRY_UNIT_VALIDATOR, LDAP_ENTRY_HAS_NO_STRUCTURAL_CAPS,
						LdapDomainMessages.Ldap_entry_0_must_have_a_structural_cap,
						new Object[] { ldapEntryUnit }, ldapEntryUnit));
			} else /* structuralCaps.size() > 1 */{
				reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						LDAP_ENTRY_UNIT_VALIDATOR, LDAP_ENTRY_HAS_MULTI_STRUCTURAL_CAPS,
						LdapDomainMessages.Ldap_entry_0_has_multi_structural_caps,
						new Object[] { ldapEntryUnit }, ldapEntryUnit));
			}
		}

		// Gather up all attribute constraints (from the LDAP class definitions)...

		HashSet<String> MUSTAttrs = new HashSet<String>();
		HashSet<String> MAYAttrs = new HashSet<String>();
		HashSet<String> MUSTNOTAttrs = new HashSet<String>();

		List<Capability> ldapClasses = ValidatorUtils.findCapabilities(ldapEntryUnit,
				LdapPackage.eINSTANCE.getLdapObject());
		for (Capability ldapClass : ldapClasses) {
			HashSet<EClass> eClasses = new HashSet<EClass>();
			eClasses.add(ldapClass.eClass());
			while (eClasses.size() > 0) {
				EClass clazz = eClasses.iterator().next();
				eClasses.remove(clazz);
				if (LdapPackage.eINSTANCE.getLdapObject().isSuperTypeOf(clazz)) {
					String[] attrs = ldapCap2MUSTAttrs.get(clazz);
					if (attrs != null) {
						for (String attr : attrs) {
							MUSTAttrs.add(attr.toLowerCase());
						}
					}
					attrs = ldapCap2MAYAttrs.get(clazz);
					if (attrs != null) {
						for (String attr : attrs) {
							MAYAttrs.add(attr.toLowerCase());
						}
					}
					attrs = ldapCap2MUSTNOTAttrs.get(clazz);
					if (attrs != null) {
						for (String attr : attrs) {
							MUSTNOTAttrs.add(attr.toLowerCase());
						}
					}
					eClasses.addAll(clazz.getESuperTypes());
				}
			}
		}
		MAYAttrs.removeAll(MUSTAttrs);
		MAYAttrs.removeAll(MUSTNOTAttrs);

		for (String MUSTNOTAttr : MUSTNOTAttrs) {
			if (MUSTAttrs.contains(MUSTNOTAttr)) {
				LdapDeployPlugin.logError(0, "Consistency problem with LDAP Classes -- " + MUSTNOTAttr //$NON-NLS-1$
						+ " is both required and prohibited", null); //$NON-NLS-1$
			}
		}

		if (ldapEntryCaps.size() > 0) {
			LdapEntry ldapEntryCap = (LdapEntry) ldapEntryCaps.get(0);
			// Validate all of the EAs (all must be on the LdapEntry capability)...

			List<ExtendedAttribute> extAttrs = ldapEntryCap.getExtendedAttributes();
			for (ExtendedAttribute ea : extAttrs) {

				String eaname = ea.getName().toLowerCase();

				if (MUSTNOTAttrs.contains(eaname)) {
					reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
							IStatus.ERROR, LDAP_ENTRY_UNIT_VALIDATOR, EA_PROHIBITED_BY_LDAP_SCHEMA,
							LdapDomainMessages.EA_0_prohibited_by_LDAP_schema,
							new Object[] { ea.getName() }, ldapEntryUnit, ea));
				}

				else if (MUSTAttrs.contains(eaname)) {
					String str = ea.getValue().toString();
					if (str.equals("")) { //$NON-NLS-1$
						reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
								IStatus.ERROR, LDAP_ENTRY_UNIT_VALIDATOR, EA_MUST_HAVE_A_VALUE,
								LdapDomainMessages.EA_0_must_have_a_value, new Object[] { ea.getName() },
								ldapEntryUnit, ea));
					}
					MUSTAttrs.remove(eaname);
				}

				else if (MAYAttrs.contains(eaname) == false) {
					reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
							IStatus.WARNING, LDAP_ENTRY_UNIT_VALIDATOR, EA_NOT_PART_OF_SCHEMA,
							LdapDomainMessages.EA_0_not_part_of_schema, new Object[] { ea.getName() },
							ldapEntryUnit, ea));
				}

				MAYAttrs.remove(eaname);
			}

			// Are there any required EAs left over?

			for (String mustAttr : MUSTAttrs) {
				reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						LDAP_ENTRY_UNIT_VALIDATOR, LDAP_ENTRY_MISSING_REQD_ATTR,
						LdapDomainMessages.Ldap_entry_0_missing_required_attr_1, new Object[] {
								ldapEntryUnit, mustAttr }, ldapEntryUnit));
			}

			// Are there any optional EAs left over?

			for (String mayAttr : MAYAttrs) {
				reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO,
						LDAP_ENTRY_UNIT_VALIDATOR, LDAP_ENTRY_MISSING_OPT_ATTR,
						LdapDomainMessages.Ldap_entry_0_missing_optional_attr_1, new Object[] {
								ldapEntryUnit, mayAttr }, ldapEntryUnit));
			}
		}
	}
}
