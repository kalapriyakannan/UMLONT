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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.net.NetPackage;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType;
import com.ibm.ccl.soa.deploy.virtualization.IVirtualizationAnnotationConstants;
import com.ibm.ccl.soa.deploy.virtualization.Messages;
import com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshotUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualIDEDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshotUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationFactory;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPlugin;


/**
 * Parses a VMware vmx configuration.
 * <p>
 * The VMX file format appears to be undocumented. Informal documentation is
 * available at <a
 * href="http://sanbarrow.com/vmx.html">http://sanbarrow.com/vmx.html</a>
 * 
 * @see VirtualizationPackage
 */
public class VMwareVirtualImageUnitProvider extends
		AbstractVirtualImageUnitProvider {

	/**
	 * Extended attribute on {@link VMwareVirtualDiskSnapshot} to represent the
	 * value of the host {@link VMwareVirtualServerSnapshot#getUid()}.
	 */
	public static final String DISK_SNAPSHOT_SERVER_SNAPSHOT_UID = "serverSnapshotUid";//$NON-NLS-1$

	/**
	 * Extended attribute on {@link VMwareVirtualDiskSnapshot} to represent the
	 * value of the host {@link VMwareVirtualDiskDef} extended attribute
	 * {@link #SCSI_DISK_DEF_DISK_PRESENT}.
	 */
	public static final String DISK_SNAPSHOT_NODE = "node";//$NON-NLS-1$

	/**
	 * Extended attribute on {@link VMwareVirtualDiskDef} to store the complete
	 * node name.
	 */
	public static final String DISK_DEF_NODE_NAME = "diskNodeName"; //$NON-NLS-1$

	/**
	 * Extended attribute on {@link VMwareVirtualSCSIDiskDef} to store the
	 * boolean value of the disk being active in the SCSI controller.
	 */
	public static final String SCSI_DISK_DEF_DISK_PRESENT = "diskPresent"; //$NON-NLS-1$

	/**
	 * A parsed entry from a VMX file.
	 */
	public class VmxEntry {
		public final String prefix;

		public final String name;

		public final String value;

		public VmxEntry(String prefix, String name, String value) {
			this.prefix = prefix;
			this.name = name;
			this.value = value;
		}
	}

	/** The extension for VMware domains. */
	public static final String VMWARE_VMX_EXTENSION = "vmx"; //$NON-NLS-1$

	/** The extension for VMware snapshots. */
	public static final String VMWARE_VMSD_EXTENSION = "vmsd"; //$NON-NLS-1$

	protected VMwareVirtualDiskDef getDiskDef(VMwareVirtualDiskDefUnit diskU) {
		return (VMwareVirtualDiskDef) ValidatorUtils.getFirstCapability(diskU,
				VirtualizationPackage.eINSTANCE.getVMwareVirtualDiskDef());
	}

	protected VMwareVirtualDiskSnapshot getDiskSnapshot(
			VMwareVirtualDiskSnapshotUnit snapshotU) {
		return (VMwareVirtualDiskSnapshot) ValidatorUtils.getFirstCapability(
				snapshotU, VirtualizationPackage.eINSTANCE
						.getVMwareVirtualDiskSnapshot());
	}

	protected VMwareVirtualServerSnapshot getServerSnapshot(
			VMwareVirtualServerSnapshotUnit snapshotU) {
		return (VMwareVirtualServerSnapshot) ValidatorUtils.getFirstCapability(
				snapshotU, VirtualizationPackage.eINSTANCE
						.getVMwareVirtualServerSnapshot());
	}

	/**
	 * Resolves the links between the virtual image unit and its hosted
	 * configurations.
	 */
	@Override
	public boolean resolveLinks(List deployModelObjects,
			IProgressMonitor monitor) {
		//
		// Find the image unit and populate maps
		//
		VMwareVirtualImageUnit imageU = null;
		Map<String, VMwareVirtualServerSnapshotUnit> uidServerUnitMap = new HashMap<String, VMwareVirtualServerSnapshotUnit>();
		Map<String, VMwareVirtualServerSnapshot> uidServerMap = new HashMap<String, VMwareVirtualServerSnapshot>();
		Map<String, VMwareVirtualDiskDefUnit> nodeDiskUnitMap = new HashMap<String, VMwareVirtualDiskDefUnit>();
		Map<String, VMwareVirtualDiskDef> nodeDiskMap = new HashMap<String, VMwareVirtualDiskDef>();
		for (Iterator iter = deployModelObjects.iterator(); iter.hasNext();) {
			Object obj = iter.next();
			if (obj instanceof VMwareVirtualImageUnit) {
				imageU = (VMwareVirtualImageUnit) obj;
			} else if (obj instanceof VMwareVirtualDiskDefUnit) {
				VMwareVirtualDiskDefUnit diskU = (VMwareVirtualDiskDefUnit) obj;
				VMwareVirtualDiskDef disk = getDiskDef(diskU);
				if (disk != null) {
					String nodeName = (String) DeployModelObjectUtil
							.getAttributeValue(disk, DISK_DEF_NODE_NAME);
					if (nodeName != null) {
						nodeDiskMap.put(nodeName, disk);
						nodeDiskUnitMap.put(nodeName, diskU);
					}
				}
			} else if (obj instanceof VMwareVirtualServerSnapshotUnit) {
				VMwareVirtualServerSnapshotUnit snapshotU = (VMwareVirtualServerSnapshotUnit) obj;
				VMwareVirtualServerSnapshot snapshot = getServerSnapshot(snapshotU);
				if (snapshot != null && snapshot.getUid() != null) {
					uidServerUnitMap.put(snapshot.getUid(), snapshotU);
					uidServerMap.put(snapshot.getUid(), snapshot);
				}
			}
		}

		//
		// Create the links
		// 
		for (Iterator iter = deployModelObjects.iterator(); iter.hasNext();) {
			Object obj = iter.next();
			if (!(obj instanceof Unit)) {
				continue;
			}
			Unit unit = (Unit) obj;
			//
			// Hosting
			//
			if (unit instanceof VMwareVirtualImageUnit) {
				// No hosting for image unit
			} else if (unit instanceof VMwareVirtualDiskSnapshotUnit) {
				VMwareVirtualDiskSnapshotUnit snapshotU = (VMwareVirtualDiskSnapshotUnit) unit;
				VMwareVirtualDiskSnapshot snapshot = getDiskSnapshot(snapshotU);
				if (snapshot != null) {
					String uid = (String) DeployModelObjectUtil
							.getAttributeValue(snapshot,
									DISK_SNAPSHOT_SERVER_SNAPSHOT_UID);
					if (uid != null) {
						VMwareVirtualServerSnapshotUnit serverU = uidServerUnitMap
								.get(uid);
						if (serverU != null) {
							LinkFactory.createHostingLink(serverU, snapshotU);
						}
					}
				}
			} else {
				// Default to host on the image
				if (imageU != null) {
					LinkFactory.createHostingLink(imageU, unit);
				}
			}

			//
			// Dependency
			//
			if (unit instanceof VMwareVirtualServerSnapshotUnit) {
				VMwareVirtualServerSnapshotUnit serverU = (VMwareVirtualServerSnapshotUnit) unit;
				VMwareVirtualServerSnapshot server = getServerSnapshot(serverU);
				if (server != null && server.getParentSnapshotUid() != null) {
					VMwareVirtualServerSnapshot parentServer = uidServerMap
							.get(server.getParentSnapshotUid());
					Requirement req = ValidatorUtils.getFirstRequirement(
							serverU, VirtualizationPackage.eINSTANCE
									.getVMwareVirtualServerSnapshot());
					if (parentServer != null && req != null) {
						LinkFactory.createDependencyLink(req, parentServer);
					}
				}
			} else if (unit instanceof VMwareVirtualDiskSnapshotUnit) {
				VMwareVirtualDiskSnapshotUnit snapshotU = (VMwareVirtualDiskSnapshotUnit) unit;
				Requirement req = ValidatorUtils.getFirstRequirement(snapshotU,
						VirtualizationPackage.eINSTANCE
								.getVMwareVirtualDiskDef());
				if (req != null) {
					VMwareVirtualDiskSnapshot snapshot = getDiskSnapshot(snapshotU);
					if (snapshot != null) {
						String node = (String) DeployModelObjectUtil
								.getAttributeValue(snapshot, DISK_SNAPSHOT_NODE);
						if (node != null) {
							VMwareVirtualDiskDef diskDef = nodeDiskMap
									.get(node);
							if (diskDef != null) {
								LinkFactory.createDependencyLink(req, diskDef);
							}
						}
					}
				}
			}
		}

		return true;
	}

	/**
	 * Provides a VMware vmx file as a Zephyr model descriptor.
	 */
	@Override
	public TopologyUnitStub[] resolveStubs(Object object) {
		if (!(object instanceof IFile)) {
			return NO_STUBS;
		}
		IFile file = (IFile) object;
		String type = null;
		if (VMWARE_VMX_EXTENSION.equalsIgnoreCase(file.getFullPath()
				.getFileExtension())) {
			type = IVirtualizationAnnotationConstants.VMWARE_MACHINE_CONFIGURATION;
		} else if (VMWARE_VMSD_EXTENSION.equalsIgnoreCase(file.getFullPath()
				.getFileExtension())) {
			type = IVirtualizationAnnotationConstants.VMWARE_SNAPSHOT_CONFIGURATION;
		}
		if (type == null) {
			return NO_STUBS;
		}
		TopologyUnitStub[] stubs = new TopologyUnitStub[1];
		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
		annotation.setContext(type);
		stubs[0] = new TopologyUnitStub(file.getFullPath().toString(), null,
				annotation, file);
		return stubs;

	}

	/**
	 * Resolves a VMware configuration descriptor to a model.
	 */
	@Override
	public Object[] resolveUnit(TopologyUnitStub stub, boolean toResolveLazily,
			IProgressMonitor monitor) {
		Object object = stub.getInput();
		if (!(object instanceof IFile)) {
			return NO_MODEL_OBJS;
		}
		IFile file = (IFile) object;
		List<Unit> result = new ArrayList<Unit>();
		IFile vmxFile = null;
		IFile vmsdFile = null;
		if (VMWARE_VMX_EXTENSION.equalsIgnoreCase(file.getFullPath()
				.getFileExtension())) {
			vmxFile = file;
		} else if (VMWARE_VMSD_EXTENSION.equalsIgnoreCase(file.getFullPath()
				.getFileExtension())) {
			vmsdFile = file;
		}
		if (vmxFile == null && vmsdFile == null) {
			return NO_MODEL_OBJS;
		}
		if (vmxFile != null && vmsdFile == null) {
			IPath vmsdPath = file.getFullPath().removeFileExtension()
					.addFileExtension(VMWARE_VMSD_EXTENSION);
			IResource vmsdResource = file.getParent().findMember(
					vmsdPath.lastSegment());
			if (vmsdResource instanceof IFile) {
				vmsdFile = (IFile) vmsdResource;
			}
		}
		if (vmsdFile != null && vmxFile == null) {
			IPath vmxPath = file.getFullPath().removeFileExtension()
					.addFileExtension(VMWARE_VMX_EXTENSION);
			IResource vmxResource = file.getParent().findMember(
					vmxPath.lastSegment());
			if (vmxResource instanceof IFile) {
				vmxFile = (IFile) vmxResource;
			}
		}
		if (vmxFile != null && vmxFile.exists()) {
			Map<String, String> attributeValueMap = parseAttributeValuePairs(
					file, monitor);
			List<Unit> units = provideVMX(attributeValueMap, monitor, vmxFile);
			result.addAll(units);
		}
		if (vmsdFile != null && vmsdFile.exists()) {
			Map<String, String> attributeValueMap = parseAttributeValuePairs(
					vmsdFile, monitor);
			VMwareVirtualImageUnit imageU = null;
			for (DeployModelObject dmo : result) {
				if (dmo instanceof VMwareVirtualImageUnit) {
					imageU = (VMwareVirtualImageUnit) dmo;
					break;
				}
			}
			List<Unit> units = provideVMSD(attributeValueMap, monitor,
					vmsdFile, imageU);
			result.addAll(units);
		}
		return result.toArray();
	}

	/**
	 * Reads a file with attribute value pairs.
	 * 
	 * @param file
	 *            text file.
	 * @param monitor
	 *            a progress monitor.
	 * @return a map of attribute names to values.
	 */
	protected Map<String, String> parseAttributeValuePairs(IFile file,
			IProgressMonitor monitor) {
		Map<String, String> attributeValueMap = new TreeMap<String, String>(
				STRING_IGNORE_CASE_COMPARATOR);

		List<String> lines = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(file
					.getContents()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
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
					VirtualizationPlugin.log(IStatus.ERROR, e);
					monitor.setCanceled(true);
				}
			}
		}
		if (monitor.isCanceled()) {
			return Collections.emptyMap();
		}
		return parseAttributeValuePairs(lines, monitor);
	}

	/**
	 * Reads a file with attribute value pairs.
	 * 
	 * @param lines
	 *            a list of string lines.
	 * @param monitor
	 *            a progress monitor.
	 * @return a map of attribute names to values.
	 */
	public Map<String, String> parseAttributeValuePairs(List<String> lines,
			IProgressMonitor monitor) {
		Map<String, String> attributeValueMap = new TreeMap<String, String>(
				STRING_IGNORE_CASE_COMPARATOR);
		if (lines == null || lines.size() == 0) {
			return attributeValueMap;
		}

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
				String value = dequote(trim(line.substring(equalsIndex + 1)));
				attributeValueMap.put(var, value);
			}
		}
		return attributeValueMap;
	}

	/**
	 * Provide the VMware image unit.
	 * 
	 * @param attributeValueMap
	 *            a map of VMX attributes to their serialized values.
	 * @param monitor
	 *            a progress monitor for long lasting operations.
	 * @param file
	 *            the vmx configuration file (may be null).
	 * @return all the units created for the VMX file.
	 */
	public List<Unit> provideVMX(Map<String, String> attributeValueMap,
			IProgressMonitor monitor, IFile file) {
		if (attributeValueMap == null || attributeValueMap.size() == 0) {
			return Collections.emptyList();
		}

		//
		// Provide the main VMware Virtual Image Unit
		//
		List<Unit> result = new ArrayList<Unit>();

		VMwareVirtualImageUnit imageU = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualImageUnit();
		imageU.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		imageU.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		imageU.setName(Messages.VMware_image);

		if (file != null) {
			FileArtifact artifact = CoreFactory.eINSTANCE.createFileArtifact();
			artifact.setName(VMWARE_VMX_EXTENSION);
			artifact.setDisplayName(Messages.VMware_domain_configuration);
			artifact.getFileURIs().add(file.getRawLocation().toString());
			imageU.getArtifacts().add(artifact);
		}

		VMwareVirtualImage image = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualImage();
		image.setName("VMware Image"); //$NON-NLS-1$
		image.setDisplayName(Messages.VMware_image);
		image.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		imageU.getCapabilities().add(image);

		VMwareVirtualServerDef server = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualServerDef();
		server.setName("VMware Server Definition"); //$NON-NLS-1$
		server.setDisplayName(Messages.VMware_server_definition);
		server.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		imageU.getCapabilities().add(server);

		VMwareVirtualImageSnapshotContainer sc = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualImageSnapshotContainer();
		sc.setName(Messages.VMware_image_snapshot_container);
		sc.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		sc.setNumSnapshots(0);
		if (imageU != null) {
			imageU.getCapabilities().add(sc);
		}
		imageU.getCapabilities().add(sc);

		Requirement hostReq = CoreFactory.eINSTANCE.createRequirement();
		hostReq.setName("VMware Hypervisor Host"); //$NON-NLS-1$
		hostReq.setDisplayName(Messages.VMware_hypervisor);
		hostReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hostReq.setDmoEType(VirtualizationPackage.eINSTANCE
				.getVMwareHypervisor());
		imageU.getRequirements().add(hostReq);

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
		// Set image and server attributes
		//
		Map<String, Set<VmxEntry>> prefixNameMap = new LinkedHashMap<String, Set<VmxEntry>>();
		for (Map.Entry<String, String> entry : attributeValueMap.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();
			if ("config.version".equalsIgnoreCase(name)) { //$NON-NLS-1$
				image.setConfigVersion(value);
			} else if ("deploymentPlatform".equalsIgnoreCase(name)) { //$NON-NLS-1$
				// TODO support in schema
				addExtendedStringAttribute(server, name, value);
			} else if ("displayName".equalsIgnoreCase(name)) { //$NON-NLS-1$
				imageU.setDisplayName(value);
				image.setDisplayName(value);
			} else if ("description".equalsIgnoreCase(name)) { //$NON-NLS-1$
				imageU.setDescription(value);
			} else if ("guestos".equalsIgnoreCase(name)) { //$NON-NLS-1$
				server.setGuestOS(value);
			} else if ("memsize".equalsIgnoreCase(name)) { //$NON-NLS-1$
				if (value != null) {
					value = Long
							.valueOf(Long.valueOf(value).longValue() * 1024)
							.toString();
				}
				setBigInteger(server, VirtualizationPackage.eINSTANCE
						.getVirtualServerDef_MemorySize(), value);
			} else if ("nvram".equalsIgnoreCase(name)) { //$NON-NLS-1$
				// TODO support in schema
				addExtendedStringAttribute(server, name, value);
			} else if ("virtualHW.version".equalsIgnoreCase(name)) { //$NON-NLS-1$
				server.setVirtualHWVersion(value);
			} else {
				int dotIndex = name.indexOf('.');
				if (dotIndex == -1) {
					addExtendedAttribute(server, name, value);
				} else if ((dotIndex > 0) && (dotIndex < name.length() - 1)) {
					String prefix = name.substring(0, dotIndex);
					String postfix = name.substring(dotIndex + 1);
					Set<VmxEntry> set = prefixNameMap.get(prefix);
					if (set == null) {
						set = new LinkedHashSet<VmxEntry>();
						prefixNameMap.put(prefix, set);
					}
					set.add(new VmxEntry(prefix, postfix, value));
				}
			}
		}

		//
		// Dotted attributes
		//
		for (Map.Entry<String, Set<VmxEntry>> entry : prefixNameMap.entrySet()) {
			String name = entry.getKey();
			Set<VmxEntry> vmx = entry.getValue();
			if (name.startsWith("ethernet")) { //$NON-NLS-1$
				result.addAll(provideEthernetInterface(image, name, vmx));
			} else if (name.startsWith("ide")) { //$NON-NLS-1$
				result.addAll(provideIdeDisk(image, name, vmx));
			} else if (name.startsWith("scsi")) { //$NON-NLS-1$ 
				if (name.indexOf(':') != -1) {
					result.addAll(provideScsiDisk(image, name, vmx,
							prefixNameMap));
				}
			} else {
				for (VmxEntry ventry : vmx) {
					String vname = ventry.prefix + '_'
							+ ventry.name.replace('.', '_');
					addExtendedAttribute(server, vname, ventry.value);
				}
			}
		}

		return result;
	}

	/**
	 * Provide the VMware disk configuration unit.
	 * 
	 * @param attributeValueMap
	 *            a map of vmsd attribute names to their serialized values.
	 * @param monitor
	 *            a progress monitor for long lasting operations.
	 * @param file
	 *            the optional vmsd configuration file (may be null).
	 * @param imageU
	 *            optionally identifies the VMWare image unit where the snapshot
	 *            container {@link VMwareVirtualImageSnapshotContainer} will set
	 *            and/or added (may be null).
	 * @return all the units created for the VMSD file.
	 */
	public List<Unit> provideVMSD(Map<String, String> attributeValueMap,
			IProgressMonitor monitor, IFile file, VMwareVirtualImageUnit imageU) {
		if (attributeValueMap == null || attributeValueMap.size() == 0) {
			return Collections.emptyList();
		}

		//
		// Find or create the snapshot container capability for the image unit
		//
		VMwareVirtualImageSnapshotContainer sc = null;
		if (imageU != null) {
			sc = (VMwareVirtualImageSnapshotContainer) ValidatorUtils
					.getFirstCapability(imageU, VirtualizationPackage.eINSTANCE
							.getVMwareVirtualImageSnapshotContainer());
		}
		if (sc == null) {
			sc = VirtualizationFactory.eINSTANCE
					.createVMwareVirtualImageSnapshotContainer();
			sc.setName(Messages.VMware_image_snapshot_container);
			sc.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			if (imageU != null) {
				imageU.getCapabilities().add(sc);
			}
		}

		//
		// Set image and server attributes
		//
		Map<String, Set<VmxEntry>> prefixNameMap = new LinkedHashMap<String, Set<VmxEntry>>();
		for (Map.Entry<String, String> entry : attributeValueMap.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();
			if ("snapshot.lastUID".equalsIgnoreCase(name)) { //$NON-NLS-1$
				sc.setLastSnapshotUid(value);
			} else if ("snapshot.numSnapshots".equalsIgnoreCase(name)) { //$NON-NLS-1$
				setInteger(sc, VirtualizationPackage.eINSTANCE
						.getVMwareVirtualImageSnapshotContainer_NumSnapshots(),
						value);
			} else if ("snapshot.current".equalsIgnoreCase(name)) { //$NON-NLS-1$
				sc.setCurrentSnapshotUid(value);
			} else if (name != null
					&& name.toLowerCase().startsWith("snapshot.")) { //$NON-NLS-1$
				if (name.length() > 9) {
					name = name.substring(9);
					addExtendedAttribute(sc, name, value);
				}
			} else if (name != null) {
				int dotIndex = name.indexOf('.');
				if (dotIndex == -1) {
					addExtendedAttribute(sc, name, value);
				} else if ((dotIndex > 0) && (dotIndex < name.length() - 1)) {
					String prefix = name.substring(0, dotIndex);
					String postfix = name.substring(dotIndex + 1);
					Set<VmxEntry> set = prefixNameMap.get(prefix);
					if (set == null) {
						set = new LinkedHashSet<VmxEntry>();
						prefixNameMap.put(prefix, set);
					}
					set.add(new VmxEntry(prefix, postfix, value));
				}
			}
		}

		if (sc.getNumSnapshots() == 0) {
			return Collections.emptyList();
		}

		//
		// Dotted attributes
		//
		Map<String, List<Unit>> uidSnapshotListMap = new HashMap<String, List<Unit>>();
		Map<String, String> uidParentUidMap = new HashMap<String, String>();
		for (Map.Entry<String, Set<VmxEntry>> entry : prefixNameMap.entrySet()) {
			String name = entry.getKey();
			Set<VmxEntry> vmx = entry.getValue();
			if (name.startsWith("snapshot")) { //$NON-NLS-1$
				List<Unit> snapshots = provideServerSnapshot(name, vmx, file);
				VMwareVirtualServerSnapshotUnit serverU = null;
				for (Unit unit : snapshots) {
					if (unit instanceof VMwareVirtualServerSnapshotUnit) {
						serverU = (VMwareVirtualServerSnapshotUnit) unit;
						break;
					}
				}
				if (serverU != null) {
					VMwareVirtualServerSnapshot server = this
							.getServerSnapshot(serverU);
					if (server != null && server.getUid() != null) {
						uidSnapshotListMap.put(server.getUid(), snapshots);
						uidParentUidMap.put(server.getUid(), server
								.getParentSnapshotUid());
					}
				}
			} else {
				for (VmxEntry ventry : vmx) {
					String vname = ventry.prefix + '_'
							+ ventry.name.replace('.', '_');
					addExtendedAttribute(sc, vname, ventry.value);
				}
			}
		}
		//
		// Include the current snapshots and all their parents
		//
		Set<String> visitSet = new HashSet<String>();
		String uid = sc.getCurrentSnapshotUid();
		List<Unit> result = new ArrayList<Unit>();
		while (uid != null) {
			if (visitSet.contains(uid)) {
				// prevent cycles
				break;
			}
			visitSet.add(uid);
			List<Unit> list = uidSnapshotListMap.get(uid);
			if (list == null) {
				break;
			}
			result.addAll(list);
			uid = uidParentUidMap.get(uid);
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
		if (value.startsWith("\"") && (value.endsWith("\""))) { //$NON-NLS-1$ //$NON-NLS-2$
			if (value.length() < 2) {
				value = ""; //$NON-NLS-1$
			} else {
				value = value.substring(1, value.length() - 1);
			}
		}
		return value;
	}

	/**
	 * Provide a VMware virtual IDE disk definition.
	 * 
	 * @param key
	 *            the config file prefix key (e.g. ide1:0)
	 * @param entries
	 *            a set of entries for that key.
	 * @param file
	 *            the file containing the server snapshot definition used to add
	 *            an {@link FileArtifact} to the unit (may be null).
	 * @return a collection of server and disk units (never null).
	 */
	public List<Unit> provideServerSnapshot(String key, Set<VmxEntry> entries,
			IFile file) {

		//
		// Provide the main VMware Virtual Server Snapshot Unit
		//
		List<Unit> result = new ArrayList<Unit>();

		VMwareVirtualServerSnapshotUnit snapshotU = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualServerSnapshotUnit();
		snapshotU.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		snapshotU.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		snapshotU.setConfigurationUnit(true);
		// TODO also prefix with vmx name too?
		snapshotU.setName(key);
		snapshotU.setDisplayName(key);

		if (file != null) {
			FileArtifact artifact = CoreFactory.eINSTANCE.createFileArtifact();
			artifact.setName(VMWARE_VMSD_EXTENSION);
			artifact.setDisplayName(Messages.VMware_domain_configuration);
			artifact.getFileURIs().add(file.getRawLocation().toString());
			snapshotU.getArtifacts().add(artifact);
		}

		VMwareVirtualServerSnapshot snapshot = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualServerSnapshot();
		snapshot.setName("VMware Image"); //$NON-NLS-1$
		snapshot.setDisplayName(Messages.VMware_image);
		snapshot.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		snapshot
				.setDesiredSnapshotState(DesiredSnapshotStateType.ACTIVE_LITERAL);
		snapshotU.getCapabilities().add(snapshot);

		Requirement hReq = CoreFactory.eINSTANCE.createRequirement();
		hReq.setName("VMware Virtual Image Host"); //$NON-NLS-1$
		hReq.setDisplayName(Messages.VMware_image);
		hReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hReq.setDmoEType(VirtualizationPackage.eINSTANCE
				.getVMwareVirtualImage());
		snapshotU.getRequirements().add(hReq);

		result.add(snapshotU);

		//
		// Set the attributes
		//
		Map<String, Set<VmxEntry>> prefixNameMap = new LinkedHashMap<String, Set<VmxEntry>>();
		for (VmxEntry entry : entries) {
			if ("filename".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				snapshot.setFilename(entry.value);
			} else if ("displayName".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				snapshotU.setDisplayName(key + ": " + entry.value); //$NON-NLS-1$
				snapshot.setDisplayName(entry.value);
			} else if ("description".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				snapshot.setDescription(entry.value);
			} else if ("createTimeHigh".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				setLong(snapshot, VirtualizationPackage.eINSTANCE
						.getVMwareVirtualServerSnapshot_CreateTimeHigh(),
						entry.value);
			} else if ("createTimeLow".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				setLong(snapshot, VirtualizationPackage.eINSTANCE
						.getVMwareVirtualServerSnapshot_CreateTimeLow(),
						entry.value);
			} else if ("numDisks".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				setInteger(snapshot, VirtualizationPackage.eINSTANCE
						.getVMwareVirtualServerSnapshot_NumDisks(), entry.value);
			} else if ("parent".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				snapshot.setParentSnapshotUid(entry.value);
			} else if ("type".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				snapshot.setSnapshotType(entry.value);
			} else if ("uid".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				snapshot.setUid(entry.value);
			} else {
				int dotIndex = entry.name.indexOf('.');
				if (dotIndex == -1) {
					addExtendedAttribute(snapshot, entry.name, entry.value);
				} else if ((dotIndex > 0)
						&& (dotIndex < entry.name.length() - 1)) {
					String prefix = entry.name.substring(0, dotIndex);
					String postfix = entry.name.substring(dotIndex + 1);
					Set<VmxEntry> set = prefixNameMap.get(prefix);
					if (set == null) {
						set = new LinkedHashSet<VmxEntry>();
						prefixNameMap.put(prefix, set);
					}
					set.add(new VmxEntry(prefix, postfix, entry.value));
				}
			}
		}
		if (snapshot.getParentSnapshotUid() != null) {
			Requirement mReq = CoreFactory.eINSTANCE.createRequirement();
			mReq.setName("VMware Virtual Server Snapshot"); //$NON-NLS-1$
			mReq.setDisplayName(Messages.VMware_snapshot_configuration);
			mReq.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
			mReq.setDmoEType(VirtualizationPackage.eINSTANCE
					.getVMwareVirtualServerSnapshot());
			mReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
			snapshotU.getRequirements().add(mReq);
		}

		//
		// Dotted attributes
		//
		//
		// Dotted attributes
		//
		for (Map.Entry<String, Set<VmxEntry>> entry : prefixNameMap.entrySet()) {
			String name = entry.getKey();
			Set<VmxEntry> vmx = entry.getValue();
			if (name.startsWith("disk")) { //$NON-NLS-1$
				result.addAll(provideDiskSnapshot(snapshot, name, vmx));
			} else {
				for (VmxEntry ventry : vmx) {
					String vname = ventry.prefix + '_'
							+ ventry.name.replace('.', '_');
					addExtendedAttribute(snapshot, vname, ventry.value);
				}
			}
		}

		return result;
	}

	/**
	 * Provide a VMware virtual IDE disk definition.
	 * 
	 * @param serverSnapshot
	 *            the server snapshot capability.
	 * @param key
	 *            the config file prefix key (e.g. ide1:0)
	 * @param entries
	 *            a set of entries for that key.
	 * @return a collection of disk units (never null).
	 */
	protected List<VMwareVirtualDiskSnapshotUnit> provideDiskSnapshot(
			VMwareVirtualServerSnapshot serverSnapshot, String key,
			Set<VmxEntry> entries) {
		//
		// Provide the main VMware Virtual Disk Snapshot Unit
		//

		VMwareVirtualDiskSnapshotUnit snapshotU = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualDiskSnapshotUnit();
		snapshotU.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		snapshotU.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		snapshotU.setConfigurationUnit(true);
		snapshotU.setName(key);
		snapshotU.setDisplayName(key);

		VMwareVirtualDiskSnapshot snapshot = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualDiskSnapshot();
		snapshot.setName(key); //$NON-NLS-1$
		snapshot.setDisplayName(key);
		snapshot.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		addExtendedAttribute(snapshot, DISK_SNAPSHOT_SERVER_SNAPSHOT_UID,
				serverSnapshot.getUid());
		snapshotU.getCapabilities().add(snapshot);

		Requirement hReq = CoreFactory.eINSTANCE.createRequirement();
		hReq.setName("VMware Virtual Server Snapshot Host"); //$NON-NLS-1$
		hReq.setDisplayName(Messages.VMware_snapshot_configuration);
		hReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hReq.setDmoEType(VirtualizationPackage.eINSTANCE
				.getVMwareVirtualServerSnapshot());
		snapshotU.getRequirements().add(hReq);

		Requirement mReq = CoreFactory.eINSTANCE.createRequirement();
		mReq.setName("VMware Virtual Disk Definition"); //$NON-NLS-1$
		mReq.setDisplayName(Messages.VMware_disk_definition);
		mReq.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		mReq.setDmoEType(VirtualizationPackage.eINSTANCE
				.getVMwareVirtualDiskDef());
		mReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
		snapshotU.getRequirements().add(mReq);

		// snapshot0.disk%d.fileName
		// snapshot0.disk%d.mode
		// snapshot0.disk%d.node
		for (VmxEntry entry : entries) {
			if ("fileName".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				snapshot.setDiskFileName(entry.value);
			} else if ("mode".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				// TODO support in schema
				addExtendedAttribute(snapshot, entry.name, entry.value);
			} else if ("node".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				// TODO support in schema
				addExtendedAttribute(snapshot, DISK_SNAPSHOT_NODE, entry.value);
			} else {
				addExtendedAttribute(snapshot, entry.name, entry.value);
			}
		}

		// disk + num
		if (key.length() > 4) {
			String numStr = key.substring(4).trim();
			try {
				int num = Integer.parseInt(numStr);
				snapshot.setDiskNum(num);
			} catch (NumberFormatException e) {
				return Collections.emptyList();
			}
		}

		return Collections.singletonList(snapshotU);
	}

	/**
	 * Provide a VMware virtual IDE disk definition.
	 * 
	 * @param image
	 *            the image capability.
	 * @param key
	 *            the config file prefix key (e.g. ide1:0)
	 * @param entries
	 *            a set of entries for that key.
	 * @return a collection of disk units (never null).
	 */
	protected List<VMwareVirtualDiskDefUnit> provideIdeDisk(
			VMwareVirtualImage image, String key, Set<VmxEntry> entries) {
		VMwareVirtualDiskDefUnit unit = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualDiskDefUnit();
		unit.setName(image.getName() + " " + key); //$NON-NLS-1$
		unit.setDisplayName(key);
		unit.setConfigurationUnit(true);
		unit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		unit.setGoalInstallState(InstallState.INSTALLED_LITERAL);

		VMwareVirtualIDEDiskDef cap = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualIDEDiskDef();
		cap.setName("Disk Definition"); //$NON-NLS-1$
		cap.setDisplayName(Messages.VMware_disk_definition);
		cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		addExtendedAttribute(cap, DISK_DEF_NODE_NAME, key);
		unit.getCapabilities().add(cap);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("Image Host"); //$NON-NLS-1$
		req.setDisplayName(Messages.VMware_hypervisor);
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		req
				.setDmoEType(VirtualizationPackage.eINSTANCE
						.getVMwareVirtualImage());
		unit.getRequirements().add(req);

		//
		// Set the IDE attributes
		//
		for (VmxEntry entry : entries) {
			if ("autodetect".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				Boolean b = getBooleanValue(entry.value);
				if (b != null) {
					cap.setAutodetect(b);
				}
			} else if ("deviceType".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				cap.setDeviceType(entry.value);
			} else if ("fileName".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				cap.setFileName(entry.value);
			} else if ("present".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				Boolean b = getBooleanValue(entry.value);
				if (b != null) {
					cap.setPresent(b);
				}
			} else if ("startConnected".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				Boolean b = getBooleanValue(entry.value);
				if (b != null) {
					cap.setStartConnected(b);
				}
			} else {
				addExtendedAttribute(cap, entry.name, entry.value);
			}
		}

		return Collections.singletonList(unit);
	}

	/**
	 * Provide a VMware virtual SCSI disk definition.
	 * 
	 * @param image
	 *            the image capability.
	 * @param key
	 *            the config file prefix key (e.g. ide1:0)
	 * @param entries
	 *            a set of entries for that key.
	 * @param map
	 *            a map of to entry sets to obtain the properties of the SCSI
	 *            controller.
	 * @return a collection of disk units (never null).
	 */
	protected List<VMwareVirtualDiskDefUnit> provideScsiDisk(
			VMwareVirtualImage image, String key, Set<VmxEntry> entries,
			Map<String, Set<VmxEntry>> map) {
		VMwareVirtualDiskDefUnit unit = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualDiskDefUnit();
		unit.setName(image.getName() + " " + key); //$NON-NLS-1$
		unit.setDisplayName(key);
		unit.setConfigurationUnit(true);
		unit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		unit.setGoalInstallState(InstallState.INSTALLED_LITERAL);

		VMwareVirtualSCSIDiskDef cap = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualSCSIDiskDef();
		cap.setName("Disk Definition"); //$NON-NLS-1$
		cap.setDisplayName(Messages.VMware_disk_definition);
		cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		addExtendedAttribute(cap, DISK_DEF_NODE_NAME, key);
		unit.getCapabilities().add(cap);

		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setName("Image Host"); //$NON-NLS-1$
		req.setDisplayName(Messages.VMware_hypervisor);
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		req
				.setDmoEType(VirtualizationPackage.eINSTANCE
						.getVMwareVirtualImage());
		unit.getRequirements().add(req);

		// Device ID encoded in name
		int colonIndex = key.indexOf(':');
		Set<VmxEntry> controllerEntries = null;
		if (colonIndex != -1) {
			if (colonIndex < key.length() - 1) {
				try {
					cap.setDeviceNumber(Integer.parseInt(trim(key
							.substring(colonIndex + 1))));
				} catch (RuntimeException e) {
					VirtualizationPlugin.log(IStatus.WARNING, e);
				}
			}
		}
		if (colonIndex > 0) {
			String controller = key.substring(0, colonIndex);
			controllerEntries = map.get(controller);
			if ((controller.startsWith("scsi")) && (controller.length() > 4)) { //$NON-NLS-1$
				try {
					cap.setControllerNumber(Integer.parseInt(trim(controller
							.substring(4))));
				} catch (RuntimeException e) {
					VirtualizationPlugin.log(IStatus.WARNING, e);
				}
			}
		}

		//
		// Set the controller attributes
		//
		if (controllerEntries != null) {
			for (VmxEntry entry : controllerEntries) {
				if ("present".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
					Boolean b = getBooleanValue(entry.value);
					if (b != null) {
						cap.setPresent(b);
					}
				} else if ("virtualDev".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
					cap.setControllerType(VMwareSCSIControllerType
							.getByName(entry.value));
				} else if ("priSlotNumber".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
					// TODO support in schema
					addExtendedStringAttribute(cap, entry.name, entry.value);
				} else {
					addExtendedAttribute(cap, entry.name, entry.value);
				}
			}
		}

		//
		// Set the device attributes
		//
		for (VmxEntry entry : entries) {
			if ("autodetect".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				Boolean b = getBooleanValue(entry.value);
				if (b != null) {
					cap.setAutodetect(b);
				}
			} else if ("deviceType".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				cap.setDeviceType(entry.value);
			} else if ("fileName".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				cap.setFileName(entry.value);
			} else if ("mode".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				cap.setDiskMode(entry.value);
			} else if ("present".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				// TODO support in schema (avoid conflict with controller's
				// static present attribute
				addExtendedBooleanAttribute(cap, SCSI_DISK_DEF_DISK_PRESENT,
						entry.value); //$NON-NLS-1$
			} else if ("startConnected".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				Boolean b = getBooleanValue(entry.value);
				if (b != null) {
					cap.setStartConnected(b);
				}
			} else {
				addExtendedAttribute(cap, entry.name, entry.value);
			}
		}

		return Collections.singletonList(unit);
	}

	/**
	 * Provides a VMWare Ethernet network interface.
	 * 
	 * @param image
	 *            the VMware image.
	 * @param key
	 *            the configuration key (e.g. ethernet0)
	 * @param entries
	 *            the attribute value entries associated with the key.
	 * @return a list of units created.
	 */
	protected List<VMwareVirtualEthernetNICDefUnit> provideEthernetInterface(
			VMwareVirtualImage image, String key, Set<VmxEntry> entries) {
		VMwareVirtualEthernetNICDefUnit unit = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualEthernetNICDefUnit();
		unit.setName(image.getName() + " " + key); //$NON-NLS-1$
		unit.setDisplayName(key);
		unit.setConfigurationUnit(true);
		unit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		unit.setGoalInstallState(InstallState.INSTALLED_LITERAL);

		VMwareVirtualEthernetNICDef cap = VirtualizationFactory.eINSTANCE
				.createVMwareVirtualEthernetNICDef();
		cap.setName("Interface Definition"); //$NON-NLS-1$
		cap.setDisplayName(Messages.VMware_interface_definition);
		cap.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		unit.getCapabilities().add(cap);

		Requirement hostReq = CoreFactory.eINSTANCE.createRequirement();
		hostReq.setName("Image Host"); //$NON-NLS-1$
		hostReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		hostReq
				.setDmoEType(VirtualizationPackage.eINSTANCE
						.getVMwareVirtualImage());
		unit.getRequirements().add(hostReq);
		
		Requirement dReq = CoreFactory.eINSTANCE.createRequirement();
		dReq.setName("Virtualizes Interface"); //$NON-NLS-1$
		dReq.setDisplayName(Messages.VMware_disk_definition);
		dReq.setUse(RequirementUsage.OPTIONAL_LITERAL);
		dReq.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		dReq.setDmoEType(NetPackage.eINSTANCE.getL2Interface());
		unit.getRequirements().add(dReq);

		//
		// Set the attributes
		//
		for (VmxEntry entry : entries) {
			if ("addressType".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				// TODO support in schema
				addExtendedStringAttribute(cap, entry.name, entry.value);
			} else if ("connectionType".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				cap.setVirtualConnectionType(VirtualNetworkConnectionType
						.getByName(entry.value));
			} else if ("generatedAddress".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				cap.setMacAddress(entry.value);
				addExtendedStringAttribute(cap, entry.name, entry.value);
			} else if ("generatedAddressOffset".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				// TODO support in schema
				addExtendedStringAttribute(cap, entry.name, entry.value);
			} else if ("present".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				// TODO support in schema
				addExtendedBooleanAttribute(cap, entry.name, entry.value);
			} else if ("vnet".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				// TODO support in schema
				addExtendedStringAttribute(cap, entry.name, entry.value);
			} else if ("wakeOnPcktRcv".equalsIgnoreCase(entry.name)) { //$NON-NLS-1$
				// TODO support in schema
				addExtendedBooleanAttribute(cap, entry.name, entry.value);
			} else {
				addExtendedAttribute(cap, entry.name, entry.value);
			}
		}

		return Collections.singletonList(unit);
	}
}
