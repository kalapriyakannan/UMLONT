/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.export;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DomainPackager;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDomainPackagerDescriptor;
import com.ibm.ccl.soa.deploy.core.extension.IDomainPackagerService;
import com.ibm.ccl.soa.deploy.core.locationbinding.LocationBindingService;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.location.LocationBinding;

/**
 * This service is to be used when there is a need to provide an export option rather than reusing
 * the existing export wizard, supplied with the platform. This class provides for the functions to
 * invoke the export process with the desired exporter and set of options to create an output
 * archive. It invokes the domain packagers to package the units associated with the workspace
 * projects, to create an archive entry in the output zip.
 */
public class DeployTopologyExportService {
	TopologyExporter exporter;
	private ExportOptionsMetaData exportOptions;

	/**
	 * Constructor for the service with exporter.
	 * 
	 * @param anExporter
	 *           the exporter instance to be used
	 */
	public DeployTopologyExportService(TopologyExporter anExporter) {
		exporter = anExporter;
	}

	/**
	 * Constructor for the service with the set of parameters than can be passed as input.
	 * 
	 * @param exporter
	 *           the exporter instance to be used
	 * @param exportWithErrors
	 *           the option for exporting with errors by ignoring any exporter validation
	 * @param createLocationBinding
	 *           option to create the location binding file for the file uri's
	 * @param exportProjectName
	 *           the export output project name to be used when the option to create project is
	 *           enabled
	 * @param createExportProject
	 *           the option to create the export project
	 * @param exportDiagramResourceIfPresent
	 *           the option to export the diagram resource if present
	 * @param exportModules
	 *           the option to export the modules with-in the topology
	 */
	public DeployTopologyExportService(TopologyExporter exporter, boolean exportWithErrors,
			boolean createLocationBinding, String exportProjectName, boolean createExportProject,
			boolean exportDiagramResourceIfPresent, boolean exportModules) {
		this.exporter = exporter;
		this.getExportOptions().setExportWithErrors(exportWithErrors);
		this.getExportOptions().setCreateLocationBinding(createLocationBinding);
		this.getExportOptions().setCreateExportProject(createExportProject);
		this.getExportOptions().setExportProjectName(exportProjectName);
		this.getExportOptions().setExportDiagramResourceIfPresent(exportDiagramResourceIfPresent);
		this.getExportOptions().setExportModules(exportModules);
	}

	/**
	 * Constructor for the service with the set of parameters than can be passed as input. The option
	 * to export the modules is set to true.
	 * 
	 * @param exporter
	 *           the exporter instance to be used
	 * @param exportWithErrors
	 *           the option for exporting with errors by ignoring any exporter validation
	 * @param createLocationBinding
	 *           option to create the location binding file for the file uri's
	 * @param exportProjectName
	 *           the export output project name to be used when the option to create project is
	 *           enabled
	 * @param createExportProject
	 *           the option to create the export project
	 * @param exportDiagramResourceIfPresent
	 *           the option to export the diagram resource if present
	 */
	public DeployTopologyExportService(TopologyExporter exporter, boolean exportWithErrors,
			boolean createLocationBinding, String exportProjectName, boolean createExportProject,
			boolean exportDiagramResourceIfPresent) {
		this(exporter, exportWithErrors, createLocationBinding, exportProjectName,
				createExportProject, exportDiagramResourceIfPresent, true);
	}

	/**
	 * This method exports the topology along with it;s packaged units to the passed zip. It creates
	 * a zip output stream and invokes the domain packagers as needed for workspace projects that are
	 * backing a unit in the topology.
	 * 
	 * @param topology
	 *           the topology to be exported
	 * @param zipFileName
	 *           the name of the output zip file
	 * @throws Exception
	 *            an exception if export fails
	 */
	public void exportDeploymentTopology(Topology topology, String zipFileName) throws Exception {
		ZipOutputStream out = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(zipFileName));
			exportDeploymentTopology(topology, out);
			if (isCreateExportProject()) {
				this.getExportOptions().setExportProjectName(topology.getName());
				createExportProjectMetaData(topology, out);
			} else {
				this.getExportOptions().setExportProjectName(""); //$NON-NLS-1$
			}
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private void createExportProjectMetaData(Topology topology, ZipOutputStream out) {
		String contents = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><projectDescription><name>" + getExportProjectName() + "</name><comment></comment></projectDescription>"; //$NON-NLS-1$ //$NON-NLS-2$
		addExportMetaDataToArchive(".project", contents, out); //$NON-NLS-1$
	}

	/**
	 * This method exports the topology along with it;s packaged units to the passed stream. It
	 * invokes the domain packagers as needed for workspace projects that are backing a unit in the
	 * topology.
	 * 
	 * @param topology
	 *           the topology to be exported
	 * @param zipFileName
	 *           the name of the output zip file
	 * @throws Exception
	 *            an exception if export fails
	 */
	public void exportDeploymentTopology(Topology topology, OutputStream out) throws Exception {
		LocationBinding locationBinding = null;
		if (isCreateLocationBinding()) {
			locationBinding = LocationBindingService.INSTANCE.createLocationBindingForExport(topology);
			if (locationBinding == null) {
				//log error
				getExportOptions()
						.getExportLog()
						.addStatus(
								new DeployExportStatus(
										IStatus.ERROR,
										DeployCorePlugin.PLUGIN_ID,
										0,
										NLS
												.bind(
														DeployCoreMessages.DeployTopologyExportService_location_file_creation_error,
														topology.getName()), null, topology));
			} else {
				if (!isCreateExportProject()) {
					locationBinding.setContext(IConstants.LocationBindingConstants.LOC_CTX_RELATIVE);
				} else {
					locationBinding.setContext(IConstants.LocationBindingConstants.LOC_CTX_ABSOLUTE);
				}
			}
		}
		if (isExportModules()) {
			addDeployableModules(topology, locationBinding, out);
		}
		addExportedLocationBinding(topology, locationBinding, out);
		addExportedDeploymentPlan(topology, out);
		Iterator importListItr = topology.getImports().iterator();
		while (importListItr.hasNext()) {
			Import importElement = (Import) importListItr.next();
			exportImportedTopology(importElement, topology, out);
		}
	}

	private void addExportedLocationBinding(Topology topology, LocationBinding locationBinding,
			OutputStream stream) {
		try {
			if (locationBinding == null) {
				return;
			}
			Resource locResource = locationBinding.eResource();
			IFile locationFile = WorkbenchResourceHelperBase.getIFile(locResource.getURI());
			if (locationFile != null) {
				IFile topologyFile = WorkbenchResourceHelperBase
						.getIFile(topology.eResource().getURI());
				if (topologyFile != null) {
					//strip the source folder if no create project
					IPath path = topologyFile.getFullPath().removeFirstSegments(
							!isCreateExportProject() && hasSourceFolder(topologyFile) ? 2 : 1);
					path = path.removeLastSegments(1);
					path = path.append(locationFile.getName());
					String archiveName = path.toPortableString();
					addExportMetaDataToArchive(archiveName, locResource, stream);
				}
				// String archiveName = topology.
				// addExportMetaDataToArchive(locationFile.getFullPath().removeFirstSegments(1).toPortableString(),resources,
				// stream);
			}
		} catch (Exception ex) {
			getExportOptions().getExportLog().addStatus(
					new DeployExportStatus(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, NLS.bind(
							DeployCoreMessages.DeployTopologyExportService_location_file_export_error,
							topology.getName()), ex, topology));
		}
	}

	protected boolean hasSourceFolder(IFile topologyFile) {
		INamespaceFragmentRoot root = NamespaceCore.getRoot(topologyFile.getParent());
		return root != null;
	}

	protected void exportImportedTopology(Import importElement, Topology topology, OutputStream out)
			throws Exception {
		IFile topologyFile = NamespaceCore.resolveTopology(ProjectUtilities.getProject(topology),
				importElement.getNamespace(), importElement.getPattern());
		DeployTopologyExportDataModel typeSafeModel = DeployTopologyExportDataModel.createModel();
		// run export operation
		typeSafeModel.setTopologyFile(topologyFile);
		typeSafeModel.setExporter(exporter);
		typeSafeModel.setExportWithError(new Boolean(isExportWithErrors()));
		typeSafeModel.setCreateLocationBinding(new Boolean(isCreateLocationBinding()));
		typeSafeModel.setExportOutput(out);
		typeSafeModel.setImportedTopologyInUse(new Boolean(true));
		typeSafeModel.setExportProjectName(getExportProjectName());
		typeSafeModel.setCreateExportProject(isCreateExportProject());
		typeSafeModel.setExportDiagramResourceIfPresent(isExportDiagramResourceIfPresent());
		typeSafeModel.setExportModules(isExportModules());
		IStatus status = typeSafeModel.createConfiguredOperation().execute(new NullProgressMonitor(),
				null);
		getExportOptions().getExportLog().addStatus(status);
	}

	protected IProject getProject(Unit unit) {
		Object projectName = null;
		List annotations = unit.getAnnotations();
		for (int i = 0; null == projectName && i < annotations.size(); i++) {
			Annotation annotation = (Annotation) annotations.get(i);
			projectName = annotation.getDetails().get(IAnnotationConstants.PROJECT_NAME);
			break;
		}
		return null == projectName ? null : ProjectUtilities.getProject((String) projectName);
	}

	private void addDeployableModules(Topology topology, LocationBinding locationBinding,
			OutputStream stream) throws Exception {
		//List<Unit> addedUnits = new ArrayList<Unit>();
		List units = topology.getUnits();
		Iterator unitItr = units.iterator();
		while (unitItr.hasNext()) {
			Unit unit = (Unit) unitItr.next();
			if (!isMemberUnit(unit)) {
				addDeployableModules(unit, locationBinding, stream);
				//addedUnits.add(unit);
			}
		}
		//return addedUnits;
	}

	private boolean isMemberUnit(Unit unit) {
		boolean result = false;
		for (Iterator it = unit.getTopology().getUnits().iterator(); it.hasNext();) {
			Unit candidateContainer = (Unit) it.next();
			for (Iterator it2 = candidateContainer.getMemberLinks().iterator(); it2.hasNext();) {
				MemberLink ml = (MemberLink) it2.next();
				if (ml.getTarget() == unit) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private void addDeployableModules(Unit unit, LocationBinding locationBinding, OutputStream stream)
			throws Exception {
		if (unit.isConfigurationUnit()
				|| unit.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			return;
		}
		if (!isWorkspaceProject(unit)) {
			addDeployableModulesArchive(unit, locationBinding, stream);
		} else {
			addDeployableModuleProject(unit, locationBinding, stream);
		}
	}

	/**
	 * If any of the URI does not have an extension defined for the last segment then it's assumed as
	 * a project.
	 * 
	 * @param unit
	 *           the input unit
	 * @return true, if workspace project
	 */
	protected boolean isWorkspaceProject(Unit unit) {
		List artifacts = unit.getArtifacts();
		for (Iterator iter = artifacts.iterator(); iter.hasNext();) {
			FileArtifact artifact = (FileArtifact) iter.next();
			List fileURIs = artifact.getFileURIs();
			for (Iterator iterator = fileURIs.iterator(); iterator.hasNext();) {
				String fileURI = (String) iterator.next();
				if (fileURI != null) {
					return UnitUtil.getProjectName(fileURI) != null;
				}
			}
		}
		return false;
	}

	private void addDeployableModulesArchive(Unit unit, LocationBinding locationBinding,
			OutputStream stream) throws Exception {
		Unit module = unit;
		List artifacts = module.getArtifacts();
		for (Iterator iter = artifacts.iterator(); iter.hasNext();) {
			FileArtifact artifact = (FileArtifact) iter.next();
			List fileURIs = artifact.getFileURIs();
			for (Iterator iterator = fileURIs.iterator(); iterator.hasNext();) {
				String fileURI = (String) iterator.next();
				FileInputStream fileInStream = null;
				try {
					if (null != fileURI) {
						URI uri = URI.createURI(fileURI);
						String archiveName = null;
						if (uri.isPlatformResource() || uri.isRelative()) {
							IFile file = WorkbenchResourceHelperBase.getIFile(uri);
							if (file != null) {
								archiveName = file.getFullPath().removeFirstSegments(1).toPortableString();
								fileInStream = new FileInputStream(file.getLocation().toPortableString());
							}
						} else {
							URI tFileURI = URI.createFileURI(fileURI);
							if (tFileURI != null) {
								archiveName = tFileURI.path();
								if (archiveName != null) {
									archiveName = archiveName.substring(1, archiveName.length());
									fileInStream = new FileInputStream(fileURI);
								}
							}
						}
						if (null != fileInStream) {
							addExportMetaDataToArchive(archiveName, fileInStream, stream);
							addLocationBindingEntry(locationBinding, artifact, archiveName);
							//add location entries for member units
							addMemberLocationBindingEntries(unit, locationBinding, archiveName);

						} else {
							getExportOptions()
									.getExportLog()
									.addStatus(
											new DeployExportStatus(
													IStatus.ERROR,
													DeployCorePlugin.PLUGIN_ID,
													0,
													NLS
															.bind(
																	DeployCoreMessages.DeployTopologyExportService_file_open_error,
																	fileURI), null, module));
						}
					}
				} finally {
					if (fileInStream != null) {
						fileInStream.close();
					}
				}
			}
		}
	}

	private void addLocationBindingEntry(LocationBinding locationBinding, FileArtifact artifact,
			String archiveName) throws IOException {
		if (locationBinding != null) {
			LocationBindingService.INSTANCE.addBindingEntry(locationBinding, artifact,
					getExportProjectPrefix() + archiveName);
		}
	}

	/**
	 * Returns the filename from the uri, or the segment after the last occurrence of a separator
	 */
	protected static String getFileNameTail(String uri) {
		String tempURI = uri.replace('\\', '/');
		while (tempURI.endsWith(String.valueOf(IConstants.PATH_SEPARATOR))) {
			tempURI = tempURI.substring(0, tempURI.length() - 1);
		}
		int lastIndex = tempURI.lastIndexOf('/');
		if (lastIndex == -1) {
			return uri;
		}
		return uri.substring(lastIndex + 1, tempURI.length());
	}

	private void addDeployableModuleProject(Unit unit, LocationBinding locationBinding,
			OutputStream stream) throws Exception {
		StringBuffer sBuf = new StringBuffer();
		IDomainPackagerService domainPackagerService = ExtensionsCore.createDomainPackagerService();
		IDomainPackagerDescriptor[] domainPackagerDescr = domainPackagerService
				.findDomainPackagers(unit);
		for (int i = 0; i < domainPackagerDescr.length; i++) {
			DomainPackager domainPackager = domainPackagerService
					.createDomainPackager(domainPackagerDescr[i]);
			InputStream inStream = domainPackager.export(unit);
			if (inStream == null) {
				continue;
			}
			// go through all the artifacts and package them in archive
			// in general there will only be 1 file artifact with 1 file URI set
			// for project type units
			List artifacts = unit.getArtifacts();
			for (Iterator iter = artifacts.iterator(); iter.hasNext();) {
				FileArtifact artifact = (FileArtifact) iter.next();
				sBuf.setLength(0);
				sBuf.append(artifact.getName());
				sBuf.append("."); //$NON-NLS-1$
				sBuf.append(domainPackager.getExtension(unit));
				String archiveName = sBuf.toString();
				addExportMetaDataToArchive(archiveName, inStream, stream);
				addLocationBindingEntry(locationBinding, artifact, archiveName);
				//add location entries for member units
				addMemberLocationBindingEntries(unit, locationBinding, archiveName);
			}
		}
	}

	private void addMemberLocationBindingEntries(Unit unit, LocationBinding locationBinding,
			String archiveName) throws IOException {
		if (locationBinding != null) {
			List<Unit> memberUnits = ValidatorUtils.getMembers(unit);
			for (int j = 0; j < memberUnits.size(); j++) {
				Unit memberUnit = memberUnits.get(j);
				List memberArtifacts = memberUnit.getArtifacts();
				for (Iterator memberArtIter = memberArtifacts.iterator(); memberArtIter.hasNext();) {
					FileArtifact memberArtifact = (FileArtifact) memberArtIter.next();
					addLocationBindingEntry(locationBinding, memberArtifact, archiveName);
				}
			}
		}
	}

	private void addExportMetaDataToArchive(String archiveName, InputStream in, OutputStream out) {
		if (archiveName == null) {
			return;
		}
		archiveName = getExportProjectPrefix() + archiveName;
		byte[] buf = new byte[1024];
		int len;
		ZipOutputStream zipOut = (ZipOutputStream) out;
		try {
			zipOut.putNextEntry(new ZipEntry(archiveName));
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			zipOut.closeEntry();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addExportMetaDataToArchive(String archiveName, String data, OutputStream out) {
		if (archiveName == null) {
			return;
		}
		archiveName = getExportProjectPrefix() + archiveName;
		ZipOutputStream zipOut = (ZipOutputStream) out;
		try {
			zipOut.putNextEntry(new ZipEntry(archiveName));
			if (data != null) {
				out.write(data.getBytes());
			}
			zipOut.closeEntry();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addExportMetaDataToArchive(String archiveName, Resource resource, OutputStream out) {
		if (archiveName == null) {
			return;
		}
		archiveName = getExportProjectPrefix() + archiveName;
		ZipOutputStream zipOut = (ZipOutputStream) out;
		try {
			zipOut.putNextEntry(new ZipEntry(archiveName));
			resource.save(zipOut, null);
			zipOut.closeEntry();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addExportedDeploymentPlan(Topology topology, OutputStream stream) throws Exception {
		getExportOptions().setOutput(stream);
		// TODO enable on UI - exporter.getSupportedOutputOptions()[0]
		getExportOptions().setOutputAs(ExportOptionConstants.OUTPUT_AS_ZIP);
		List<Resource> resList = new ArrayList<Resource>();

		Resource[] resources = exporter.export(topology, getExportOptions());
		if (resources != null) {
			resList.addAll(Arrays.asList(resources));
		}
		for (int i = 0; i < resList.size(); i++) {
			Resource res = resList.get(i);
			IFile file = WorkbenchResourceHelperBase.getIFile(res.getURI());
			if (file != null) {
				IPath path = file.getFullPath().removeFirstSegments(
						!isCreateExportProject() && hasSourceFolder(file) ? 2 : 1);
				addExportMetaDataToArchive(path.toPortableString(), res, stream);
			}
		}
	}

	/**
	 * the computed project prefix for the URI's, if option to create the project is set
	 * 
	 * @return the computed project prefix for the URI's, if option to create the project is set
	 */
	protected String getExportProjectPrefix() {
		String name = getExportProjectName();
		return isCreateExportProject() == false || name == null || name.length() == 0 ? "" : name + "/"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * the exporter as passed to the service
	 * 
	 * @return the exporter as passed to the service
	 */
	public TopologyExporter getExporter() {
		return exporter;
	}

	/**
	 * set the exporter to the service
	 * 
	 * @param exporter
	 *           the exporter to be used
	 */
	public void setExporter(TopologyExporter exporter) {
		this.exporter = exporter;
	}

	/**
	 * set the export optiosn
	 * 
	 * @param exportOptions
	 *           the exportOptions to set
	 * 
	 */
	public void setExportOptions(ExportOptionsMetaData exportOptions) {
		this.exportOptions = exportOptions;
	}

	/**
	 * @return the exportOptions
	 */
	public ExportOptionsMetaData getExportOptions() {
		if (exportOptions == null) {
			exportOptions = new ExportOptionsMetaData();
		}
		return exportOptions;
	}

	/**
	 * 
	 * @return the option to create the location binding
	 */
	protected boolean isCreateLocationBinding() {
		return this.getExportOptions().isCreateLocationBinding();
	}

	/**
	 * 
	 * @return the project name to be used for export
	 */
	protected String getExportProjectName() {
		return this.getExportOptions().getExportProjectName();
	}

	/**
	 * the option to create the project
	 * 
	 * @return the option to create the project
	 */
	protected boolean isCreateExportProject() {
		return this.getExportOptions().isCreateExportProject();
	}

	/**
	 * the option to export the diagram resource if present
	 * 
	 * @return the option to export the diagram resource if present
	 */
	protected boolean isExportDiagramResourceIfPresent() {
		return this.getExportOptions().isExportDiagramResourceIfPresent();
	}

	/**
	 * @return Returns the exportWithErrors.
	 */
	protected boolean isExportWithErrors() {
		return this.getExportOptions().isExportWithErrors();
	}

	/**
	 * option to export the modules present in the topology through the export service
	 * 
	 * @return option to export the modules present in the topology through the export service
	 */
	protected boolean isExportModules() {
		return this.getExportOptions().isExportModules();
	}
}
