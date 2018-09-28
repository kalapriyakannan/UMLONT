/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.virtualization.internal.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.net.NetPackage;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.virtualization.IVirtualizationAnnotationConstants;
import com.ibm.ccl.soa.deploy.virtualization.Messages;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationFactory;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPlugin;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualImageUnit;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualServerDef;

/**
 * Parses a Xen domain configuration into a Zephyr virtualization domain model.
 * <p>
 * The Xen domain configuration format is documented on in the "xmdomain.cf"
 * manual page.
 * <p>
 * The provider is associated to files with the ".xmdomain" extension.
 * 
 * @see VirtualizationPackage
 */
public class XenVirtualImageUnitProvider extends
		AbstractVirtualImageUnitProvider {

	/** The extension for Xen domain configuration files. */
	public static final String XEN_DOMAIN_CONFIG_EXTENSION = ".xmdomain"; //$NON-NLS-1$

	/**
	 * Resolves the links between the virtual image unit and its hosted
	 * configurations.
	 */
	@Override
	public boolean resolveLinks(List deployModelObjects,
			IProgressMonitor monitor) {
		// Find the image unit
		XenVirtualImageUnit imageU = null;
		for (Iterator iter = deployModelObjects.iterator(); iter.hasNext();) {
			Object obj = iter.next();
			if (obj instanceof XenVirtualImageUnit) {
				imageU = (XenVirtualImageUnit) obj;
			}
		}

		if (imageU == null) {
			return false;
		}

		for (Iterator iter = deployModelObjects.iterator(); iter.hasNext();) {
			Object obj = iter.next();
			if ((obj instanceof Unit) && (obj != imageU)) {
				LinkFactory.createHostingLink(imageU, (Unit) obj);
			}
		}

		return true;
	}

	/**
	 * Provides a Xen domain configuration file as a Zephyr model descriptor.
	 */
	@Override
	public TopologyUnitStub[] resolveStubs(Object object) {
		if (!(object instanceof IFile)) {
			return NO_STUBS;
		}
		IFile file = (IFile) object;
		String name = file.getName();
		if ((name == null)
				|| (!name.trim().toLowerCase().endsWith(
						XEN_DOMAIN_CONFIG_EXTENSION))) {
			return NO_STUBS;
		}

		TopologyUnitStub[] stubs = new TopologyUnitStub[1];

		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
		annotation
				.setContext(IVirtualizationAnnotationConstants.XEN_DOMAIN_CONFIGURATION);
		stubs[0] = new TopologyUnitStub(name, null, annotation, file);
		return stubs;
	}

	/**
	 * Resolves a Xen domain configuration Zephyr descriptor to a model.
	 */
	@Override
	public Object[] resolveUnit(TopologyUnitStub stub, boolean toResolveLazily,
			IProgressMonitor monitor) {
		Object object = stub.getInput();
		if (!(object instanceof IFile)) {
			return NO_MODEL_OBJS;
		}
		IFile file = (IFile) object;
		BufferedReader reader = null;
		try {
			List<String> lines = new ArrayList<String>();
			reader = new BufferedReader(new InputStreamReader(file
					.getContents()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			List<Unit> units = provideXenImage(lines, monitor, file);
			if (units.size() == 0) {
				return NO_MODEL_OBJS;
			}
			return units.toArray();
		} catch (CoreException e) {
			VirtualizationPlugin.log(IStatus.ERROR, e);
			monitor.setCanceled(true);
		} catch (IOException e) {
			VirtualizationPlugin.log(IStatus.ERROR, e);
			monitor.setCanceled(true);
		} catch (RuntimeException e) {
			VirtualizationPlugin.log(IStatus.ERROR, e);
			monitor.setCanceled(true);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					monitor.setCanceled(true);
				}
			}
		}
		return NO_MODEL_OBJS;
	}

	/**
	 * Provide the units of a Xen image as defined in the xmdomain configuration
	 * lines.
	 * 
	 * @param lines
	 *            a list of lines from an xmdomain configuration file.
	 * @param monitor
	 *            a progress monitor.
	 * @param file
	 *            an optional file used to create a {@link FileArtifact} (may be
	 *            null).
	 * @return
	 */
	public List<Unit> provideXenImage(List<String> lines,
			IProgressMonitor monitor, IFile file) {
		Map<String, String> attributeValueMap = new TreeMap<String, String>(
				STRING_IGNORE_CASE_COMPARATOR);
		for (String line : lines) {
			line = trim(line);

			// Remove comment
			String[] commentSplit = line.split("#"); //$NON-NLS-1$
			if (commentSplit.length > 0) {
				line = commentSplit[0];
			}
			// Assignment operator
			int equalsIndex = line.indexOf("="); //$NON-NLS-1$
			if ((equalsIndex != -1) && (equalsIndex > 0)
					&& (equalsIndex < line.length() - 1)) {
				String var = trim(line.substring(0, equalsIndex));
				String value = trim(line.substring(equalsIndex + 1));
				attributeValueMap.put(var, value);
			}
		}
		if (attributeValueMap.size() == 0) {
			return Collections.emptyList();
		}

		//
		// Create virtual image unit
		//
		List<Unit> result = new ArrayList<Unit>();

		XenVirtualImageUnit imageU = VirtualizationFactory.eINSTANCE
				.createXenVirtualImageUnit();
		imageU.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		imageU.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		imageU.setName(Messages.Xen_image);

		if (file != null) {
			FileArtifact artifact = CoreFactory.eINSTANCE.createFileArtifact();
			artifact.setName("Domain Config"); //$NON-NLS-1$
			artifact.setDisplayName(Messages.Xen_domain_configuration);
			artifact.getFileURIs().add(file.getRawLocation().toString());
			imageU.getArtifacts().add(artifact);
		}

		XenVirtualImage image = VirtualizationFactory.eINSTANCE
				.createXenVirtualImage();
		image.setName("Xen Image"); //$NON-NLS-1$
		image.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		imageU.getCapabilities().add(image);

		XenVirtualServerDef server = VirtualizationFactory.eINSTANCE
				.createXenVirtualServerDef();
		server.setName("Xen Server Definition"); //$NON-NLS-1$
		server.setDisplayName(Messages.Xen_server_definition);
		server.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		imageU.getCapabilities().add(server);

		Requirement hReq = CoreFactory.eINSTANCE.createRequirement();
		hReq.setName("Hypervisor Host"); //$NON-NLS-1$
		hReq.setDisplayName(Messages.Xen_hypervisor);
		hReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hReq.setDmoEType(VirtualizationPackage.eINSTANCE.getXenHypervisor());
		imageU.getRequirements().add(hReq);
		
		Requirement memberReq = CoreFactory.eINSTANCE.createRequirement();
		memberReq.setName("Virtualizes Server"); //$NON-NLS-1$
		memberReq.setDisplayName(Messages.VMware_hypervisor);
		memberReq.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
		memberReq.setDmoEType(ServerPackage.eINSTANCE.getServerUnit());

		MemberCardinalityConstraint mc = ConstraintFactory.eINSTANCE
				.createMemberCardinalityConstraint();
		mc.setName("Server Cardinality");
		mc.setMinValue(Integer.toString(0));
		mc.setMaxValue(Integer.toString(1));
		memberReq.getConstraints().add(mc);

		imageU.getRequirements().add(memberReq);

		result.add(imageU);

		//
		// Set attributes
		//
		for (Map.Entry<String, String> entry : attributeValueMap.entrySet()) {
			if ("disk".equals(entry.getKey())) { //$NON-NLS-1$
				result.addAll(provideDisks(image, entry.getValue()));
			} else if ("name".equals(entry.getKey())) { //$NON-NLS-1$
				image.setDomainName(dequote(entry.getValue()));
				image
						.setDomainConfigFile("/etc/xen/vm/" + dequote(entry.getValue())); //$NON-NLS-1$
			} else if ("memory".equals(entry.getKey())) { //$NON-NLS-1$
				String value = entry.getValue();
				if (value != null) {
					value = Long
							.valueOf(Long.valueOf(value).longValue() * 1024)
							.toString();
				}
				setBigInteger(server, VirtualizationPackage.eINSTANCE
						.getVirtualServerDef_MemorySize(), value);
				// server.setMemorySizeUnits(SizeUnitsType.MB_LITERAL);
			} else if ("vcpus".equals(entry.getKey())) { //$NON-NLS-1$
				setBigInteger(server, VirtualizationPackage.eINSTANCE
						.getVirtualServerDef_Vcpus(), entry.getValue());
			} else if ("vif".equals(entry.getKey())) {//$NON-NLS-1$
				result.addAll(provideInterfaces(image, entry.getValue()));
			} else {
				addExtendedAttribute(server, entry.getKey(), dequote(entry
						.getValue()));
			}

		}

		return result;
	}

	/**
	 * Removes the quotation marks from a string.
	 * <p>
	 * Only matching single or double quotes are removed.
	 * 
	 * @param value
	 *            a string value that may be quoted.
	 * @return the value without the surrounding quotes.
	 */
	protected String dequote(String value) {
		if (value == null) {
			return null;
		}
		value = trim(value);
		if ((value.startsWith("\"") && (value.endsWith("\""))) //$NON-NLS-1$ //$NON-NLS-2$
				|| (value.startsWith("'") && (value.endsWith("'")))) { //$NON-NLS-1$ //$NON-NLS-2$
			if (value.length() < 2) {
				value = ""; //$NON-NLS-1$
			} else {
				value = value.substring(1, value.length() - 1);
			}
		}
		return value;
	}

	/**
	 * Parses a Xen "disk" definition.
	 * <p>
	 * An array of block device stanzas, in the form: <quote>
	 * disk = [ "stanza1", * "stanza2", ... ]
	 * </quote>
	 * <p>
	 * Each stanza has 3 terms, separated by commas: <quote>
	 * backend-dev,frontend-dev,mode.
	 * </quote>
	 * <ul>
	 * <li>backend-dev The device in the backend domain that will be exported
	 * to the guest (frontend) domain. Supported formats include:
	 * <ul>
	 * <li> phy:device - export the physical device listed. The device can be in
	 * symbolic form, as in sda7, or as the hex major/minor number, as in 0x301
	 * (which is hda1).
	 * <li> file://path/to/file - export the file listed as a loopback device.
	 * This will take care of the loopback setup before exporting the device.
	 * </ul>
	 * <li>frontend-dev: How the device should appear in the guest domain. The
	 * device can be in symbolic form, as in sda7, or as the hex major/minor
	 * number, as in 0x301 (which is hda1).
	 * <li> mode The access mode for the device. There are currently 2 valid
	 * options, r (read-only), w (read/write).
	 * </ul>
	 * 
	 * @param image the image on which the disk will be hosted.
	 * @param value an array of block device stanzas.
	 * @return a list of Xen virtual disk unit definitions (never null).
	 */
	protected List<XenVirtualDiskDefUnit> provideDisks(XenVirtualImage image,
			String value) {
		List<String> stanzas = parseStanzas(value);
		if (stanzas.isEmpty()) {
			return Collections.emptyList();
		}
		List<XenVirtualDiskDefUnit> result = new ArrayList<XenVirtualDiskDefUnit>();
		int diskIndex = -1;
		for (String stanza : stanzas) {
			diskIndex++;
			List<String> elements = parseStanzaElements(stanza);
			if (elements.size() == 3) {
				String backendDev = elements.get(0);
				String frontendDev = elements.get(1);
				String mode = elements.get(2);

				XenVirtualDiskDefUnit unit = VirtualizationFactory.eINSTANCE
						.createXenVirtualDiskDefUnit();
				unit.setName(image.getName() + " Disk" + diskIndex); //$NON-NLS-1$
				unit.setDisplayName(Messages.Xen_disk_definition);
				unit.setConfigurationUnit(true);
				unit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
				unit.setGoalInstallState(InstallState.INSTALLED_LITERAL);

				XenVirtualDiskDef cap = VirtualizationFactory.eINSTANCE
						.createXenVirtualDiskDef();
				cap.setName("Disk Definition"); //$NON-NLS-1$
				cap.setDisplayName(Messages.Xen_disk_definition);
				cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
				cap.setFrontendDev(frontendDev);
				cap.setBackendDev(backendDev);
				cap.setMode(mode);
				unit.getCapabilities().add(cap);

				Requirement req = CoreFactory.eINSTANCE.createRequirement();
				req.setName("Image Host"); //$NON-NLS-1$
				req.setDisplayName(Messages.Xen_hypervisor);
				req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
				req.setDmoEType(VirtualizationPackage.eINSTANCE
						.getXenVirtualServerDef());
				unit.getRequirements().add(req);

				result.add(unit);
			}
		}

		return result;
	}

	/**
	 * Parses a Xen "vif" definition.
	 * <p>
	 * vif An array of virtual interface stanzas in the form: <quote>
	 * vif = [ "stanza1", * "stanza2", ... ] 
	 * </quote>
	 * Each stanza specifies a set of name = value options
	 * separated by commas, in the form:
	 * <quote>
	 * name1=value1, name2=value2, ... OPTIONS
	 * </quote>
	 * <ul>
	 * <li> bridge The network bridge to be used for this device. This is especially
	 * needed if multiple bridges exist on the machine.
	 * <li> mac The MAC address for
	 * the virtual interface. If mac is not specified, one will be randomly
	 * chosen by xen with the 00:16:3e vendor id prefix.
	 * </ul>
	 * @param image the Xen virtual image on which the virtual interface is defined.
	 * @param value the value of the vif attribute.
	 * @return a list of Xen virtual Ethernet network interface card units (never null)
	 */
	protected List<XenVirtualEthernetNICDefUnit> provideInterfaces(
			XenVirtualImage image, String value) {
		List<String> stanzas = parseStanzas(value);
		if (stanzas.isEmpty()) {
			return Collections.emptyList();
		}
		int ifIndex = -1;
		List<XenVirtualEthernetNICDefUnit> result = new ArrayList<XenVirtualEthernetNICDefUnit>();
		for (String stanza : stanzas) {
			ifIndex++;
			List<String> elements = parseStanzaElements(stanza);
			if (elements.isEmpty()) {
				continue;
			}
			XenVirtualEthernetNICDefUnit unit = VirtualizationFactory.eINSTANCE
					.createXenVirtualEthernetNICDefUnit();
			unit.setName(image.getName() + " Interface" + ifIndex); //$NON-NLS-1$
			unit.setDisplayName(Messages.Xen_interface_definition);
			unit.setConfigurationUnit(true);
			unit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
			unit.setGoalInstallState(InstallState.INSTALLED_LITERAL);

			XenVirtualEthernetNICDef cap = VirtualizationFactory.eINSTANCE
					.createXenVirtualEthernetNICDef();
			cap.setName("Interface Definition"); //$NON-NLS-1$
			cap.setDisplayName(Messages.Xen_interface_definition);
			cap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
			unit.getCapabilities().add(cap);

			Requirement hReq = CoreFactory.eINSTANCE.createRequirement();
			hReq.setName("Image Host"); //$NON-NLS-1$
			hReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
			hReq.setDmoEType(VirtualizationPackage.eINSTANCE
					.getXenVirtualServerDef());
			unit.getRequirements().add(hReq);
			
			Requirement dReq = CoreFactory.eINSTANCE.createRequirement();
			dReq.setName("Virtualizes Interface"); //$NON-NLS-1$
			dReq.setDisplayName(Messages.VMware_disk_definition);
			dReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
			dReq.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
			dReq.setDmoEType(NetPackage.eINSTANCE.getL2Interface());
			unit.getRequirements().add(dReq);

			result.add(unit);
			for (String element : elements) {
				int equalsIndex = element.indexOf("="); //$NON-NLS-1$
				if ((equalsIndex != -1) && (equalsIndex > 0)
						&& (equalsIndex < element.length() - 1)) {
					String var = trim(element.substring(0, equalsIndex));
					String rhs = trim(element.substring(equalsIndex + 1));
					if ("mac".equals(var)) { //$NON-NLS-1$
						cap.setMacAddress(dequote(rhs));
					} else {
						addExtendedAttribute(image, var, dequote(rhs));
					}
				}
			}

		}
		return result;
	}

	/**
	 * Parses a list of Xen stanzas.
	 * <p>
	 * The format being: <quote> [ "stanza1", * "stanza2", ... ]
	 * </quote>
	 * 
	 * @param value a string array of stanzas.
	 * @return a list of containing each stanza without the quotes (never null).
	 */
	protected List<String> parseStanzas(String value) {
		if (value == null) {
			return Collections.emptyList();
		}
		value = trim(value);
		if ((!value.startsWith("[")) || (!value.endsWith("]")) //$NON-NLS-1$ //$NON-NLS-2$
				|| (value.length() <= 2)) {
			return Collections.emptyList();

		}
		value = trim(value.substring(1, value.length() - 1));
		return parseStanzaElements(value);
	}

	/**
	 * Parses a list of Xen stanza elements.
	 * <p>
	 * The format being: <quote>"stanza1", "stanza2", stanza3</quote> </quote>
	 * 
	 * @param value
	 *            a string a stanza.
	 * @return a list of containing each stanza element without the quotes
	 *         (never null).
	 */
	protected List<String> parseStanzaElements(String value) {
		if (value == null) {
			return Collections.emptyList();
		}
		value = trim(value);
		if (value.length() == 0) {
			return Collections.emptyList();
		}

		List<String> result = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		boolean inQuote = false;
		char quoteChar = 0;
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if (inQuote) {
				if (c == quoteChar) {
					inQuote = false;
					quoteChar = 0;
				} else {
					buffer.append(c);
				}
			} else {
				if ((c == '"') || (c == '\'')) {
					inQuote = true;
					quoteChar = c;
				} else if (c == ',') {
					result.add(trim(buffer.toString()));
					buffer.setLength(0);
				} else {
					buffer.append(c);
				}
			}
		}
		result.add(trim(buffer.toString()));
		return result;
	}
}
