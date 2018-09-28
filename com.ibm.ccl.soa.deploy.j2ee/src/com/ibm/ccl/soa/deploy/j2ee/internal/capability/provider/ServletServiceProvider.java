/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jem.java.JavaClass;
import org.eclipse.jst.j2ee.application.internal.operations.IAnnotationsDataModel;
import org.eclipse.jst.j2ee.internal.common.operations.INewJavaClassDataModelProperties;
import org.eclipse.jst.j2ee.internal.web.operations.INewServletClassDataModelProperties;
import org.eclipse.jst.j2ee.internal.web.operations.INewWebClassDataModelProperties;
import org.eclipse.jst.j2ee.internal.web.operations.NewServletClassDataModelProvider;
import org.eclipse.jst.j2ee.web.componentcore.util.WebArtifactEdit;
import org.eclipse.jst.j2ee.webapplication.Servlet;
import org.eclipse.jst.j2ee.webapplication.ServletMapping;
import org.eclipse.jst.j2ee.webapplication.WebApp;
import org.eclipse.jst.j2ee.webapplication.WebapplicationFactory;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.componentcore.internal.operation.IArtifactEditOperationDataModelProperties;
import org.eclipse.wst.common.componentcore.internal.util.IModuleConstants;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.AbstractEMFOperationChange;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.operation.DeployModelObjectOperation;
import com.ibm.ccl.soa.deploy.core.synchronization.DatamodelDrivenChange;
import com.ibm.ccl.soa.deploy.core.util.CapabilityLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.URLInterface;
import com.ibm.ccl.soa.deploy.j2ee.URLService;
import com.ibm.ccl.soa.deploy.j2ee.internal.Messages;
import com.ibm.ccl.soa.deploy.j2ee.provider.J2eeEditPlugin;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class ServletServiceProvider extends CapabilityProvider {

	private static final String SERVLETS_SUFFIX = "servlets"; //$NON-NLS-1$

	public Object[] resolveCapabilities(Object anObject) {
		if (anObject instanceof WebApp) {

			List services = new ArrayList();
			WebApp webApp = (WebApp) anObject;
			EList servlets = webApp.getServlets();

			Servlet servlet;
			ServletMapping servletMapping;
			for (Iterator iter = servlets.iterator(); iter.hasNext();) {
				servlet = (Servlet) iter.next();
				servletMapping = webApp.getServletMapping(servlet);
				if (servletMapping != null) {
					services.add(createURLService(servlet, servletMapping));
				}
			}

			if (services.size() == 0) {
				return NO_CAPS;
			}

			return services.toArray(new Capability[services.size()]);

		}
		return NO_CAPS;
	}

	public Object[] resolveRequirements(Object anObject) {
		return NO_REQS;
	}

	protected URLService createURLService(Servlet servlet, ServletMapping mapping) {
		URLService urlService = J2eeFactory.eINSTANCE.createURLService();
		urlService.getUrlPattern().add(mapping.getUrlPattern());
		urlService.setName(servlet.getServletName());
		urlService.setDisplayName(servlet.getDisplayName());
		urlService.setDescription(servlet.getDescription());
		urlService.setProtocol("http"); //$NON-NLS-1$

		// Should we make the default version configurable?
		urlService.setVersion("1.0.0"); //$NON-NLS-1$

		URLInterface urlIntf = J2eeFactory.eINSTANCE.createURLInterface();
		urlService.setInterface(urlIntf);

		return urlService;
	}

	public boolean canImplement() {
		return true;
	}

	public RefactoringStatus checkConditionsForImplementation(Unit unit, IProgressMonitor monitor)
			throws OperationCanceledException {
		return super.checkConditionsForImplementation(unit, monitor);
	}

	public Change[] createImplementationChange(Unit unit, IProgressMonitor monitor) {

		List changes = new ArrayList();

		try {

			CompositeChange change = null;

			/* The unit may not be associated with a project, so we use the display name. */
			IProject project = J2eeEditPlugin.findProject(unit);
			/* If the display name is null, the returned value could be null. */
			if (project != null) {

				monitor.beginTask(NLS.bind(
						Messages.ServletServiceProvider_Creating_Implementation_Change_to_s_, project
								.getName()), 30);

				if (!project.exists()) {

					change = createNewServletsChange(unit, project, null, new SubProgressMonitor(
							monitor, 30));
					if (change != null && change.getChildren().length > 0) {
						changes.add(change);
					}

				} else {

					WebArtifactEdit webEdit = WebArtifactEdit.getWebArtifactEditForRead(project);
					try {

						WebApp webApp = webEdit.getWebApp();

						change = createNewServletsChange(unit, project, webApp, new SubProgressMonitor(
								monitor, 10));
						if (change != null && change.getChildren().length > 0) {
							changes.add(change);
						}

						change = createDeleteServletsChange(unit, project, webApp,
								new SubProgressMonitor(monitor, 10));
						if (change != null && change.getChildren().length > 0) {
							changes.add(change);
						}

						change = createUpdateServletsChange(unit, project, webApp,
								new SubProgressMonitor(monitor, 10));
						if (change != null && change.getChildren().length > 0) {
							changes.add(change);
						}

					} finally {
						if (webEdit != null) {
							webEdit.dispose();
						}
					}
				}
			}

		} finally {
			monitor.done();
		}

		if (changes.size() == 0) {
			return NO_CHANGES;
		}

		return (Change[]) changes.toArray(new Change[changes.size()]);
	}

	@Override
	public RefactoringStatus checkConditionsForReflection(Unit unit, IProgressMonitor monitor)
			throws OperationCanceledException {
		return super.checkConditionsForReflection(unit, monitor);
	}

	@Override
	public Change[] createReflectionChange(Unit unit, IProgressMonitor monitor) {

		List changes = new ArrayList();

		try {

			CompositeChange change = null;

			/* The unit may not be associated with a project, so we use the display name. */
			IProject project = J2eeEditPlugin.findProject(unit);
			/* If the display name is null, the returned value could be null. */
			if (project != null) {

				monitor.beginTask(NLS.bind(
						Messages.ServletServiceProvider_Creating_Implementation_Change_to_s_, project
								.getName()), 30);
				WebArtifactEdit webEdit = WebArtifactEdit.getWebArtifactEditForRead(project);

				try {

					WebApp webApp = webEdit.getWebApp();

					change = createNewURLServicesChange(unit, project, webApp, new SubProgressMonitor(
							monitor, 10));
					if (change != null && change.getChildren().length > 0) {
						changes.add(change);
					}

				} finally {
					if (webEdit != null) {
						webEdit.dispose();
					}
				}
			}

		} finally {
			monitor.done();
		}

		if (changes.size() == 0) {
			return NO_CHANGES;
		}

		return (Change[]) changes.toArray(new Change[changes.size()]);
	}

	private CompositeChange createNewServletsChange(Unit unit, final IProject project,
			WebApp webApp, IProgressMonitor monitor) {

		CompositeChange compositeChange = new CompositeChange(NLS.bind(
				Messages.ServletServiceProvider_Create_Servlets_found_in_model_for_, project.getName()));

		try {

			List dependencyCapabilities = unit.getCapabilities(
					CapabilityLinkTypeFilter.DEPENDENCY_FILTER, null);
			monitor.beginTask(NLS.bind(
					Messages.ServletServiceProvider_Creating_the_Create_Servlets_Chang_, unit
							.getDisplayName()), dependencyCapabilities.size());

			String servletPackage = calculateServletPackage(unit);

			Servlet servlet = null;
			for (Iterator iter = dependencyCapabilities.iterator(); iter.hasNext();) {
				Capability capability = (Capability) iter.next();
				if (capability instanceof URLService) {
					final URLService urlService = (URLService) capability;
					String servletName = getNameForGeneration(urlService);
					if (webApp != null) {
						servlet = webApp.getServletNamed(servletName);
					}

					if (servlet == null) {

						// if it doesn't exist ...
						IDataModel newServletModel = DataModelFactory
								.createDataModel(new NewServletClassDataModelProvider());

						// setup information
						newServletModel.setProperty(
								IArtifactEditOperationDataModelProperties.PROJECT_NAME, project.getName());
						newServletModel
								.setProperty(IArtifactEditOperationDataModelProperties.COMPONENT_NAME,
										project.getName());
						newServletModel.setProperty(IArtifactEditOperationDataModelProperties.TYPE_ID,
								IModuleConstants.JST_WEB_MODULE);

						// metadata information
						// can't set the actual name to something different yet -- not supported in
						// provider will probably have to override
						newServletModel.setStringProperty(INewWebClassDataModelProperties.DISPLAY_NAME,
								servletName);
						newServletModel.setStringProperty(INewWebClassDataModelProperties.DESCRIPTION,
								urlService.getDescription());

						List mappings = new ArrayList();
						String[] mapping = null;
						EList urlPattern = urlService.getUrlPattern();
						for (Iterator iterator = urlPattern.iterator(); iterator.hasNext();) {
							String pattern = (String) iterator.next();
							mapping = new String[] { pattern };
							mappings.add(mapping);
						}

						newServletModel.setProperty(INewServletClassDataModelProperties.URL_MAPPINGS,
								mappings);

						// source code generation
						newServletModel.setBooleanProperty(IAnnotationsDataModel.USE_ANNOTATIONS, false);
						newServletModel.setStringProperty(INewJavaClassDataModelProperties.CLASS_NAME,
								servletName);
						newServletModel.setStringProperty(INewJavaClassDataModelProperties.JAVA_PACKAGE,
								servletPackage);
						newServletModel
								.setBooleanProperty(INewServletClassDataModelProperties.INIT, true);
						newServletModel.setBooleanProperty(INewServletClassDataModelProperties.DESTROY,
								true);
						newServletModel.setBooleanProperty(INewServletClassDataModelProperties.DO_GET,
								true);
						newServletModel.setBooleanProperty(INewServletClassDataModelProperties.DO_POST,
								true);

						DatamodelDrivenChange newServletChange = new DatamodelDrivenChange(NLS.bind(
								Messages.ServletServiceProvider_Create_the_0_Servlet_metadata_and_,
								servletName), unit, newServletModel) {
							public Change perform(IProgressMonitor monitor) throws CoreException {

								Change undoChange = super.perform(new SubProgressMonitor(monitor, 10));

								// correction due to problem with NewServletOperation
								String servletName = getDatamodel().getStringProperty(
										INewWebClassDataModelProperties.DISPLAY_NAME);

								WebArtifactEdit webEdit = WebArtifactEdit
										.getWebArtifactEditForWrite(project);
								try {
									WebApp webApp = webEdit.getWebApp();
									Servlet servlet = webApp.getServletNamed(servletName);
									servlet.setDisplayName(urlService.getDisplayName());
								} finally {
									if (webEdit != null) {
										webEdit.save(new SubProgressMonitor(monitor, 2));
										webEdit.dispose();
									}
								}

								return undoChange;
							}
						};

						compositeChange.add(newServletChange);

					}
					monitor.worked(1);
				}

			}
		} finally {
			monitor.done();
		}

		return compositeChange;

	}

	private CompositeChange createNewURLServicesChange(final Unit unit, final IProject project,
			WebApp webApp, IProgressMonitor monitor) {

		CompositeChange compositeChange = new CompositeChange(NLS
				.bind(Messages.ServletServiceProvider_Create_URLServices_found_in_project_, project
						.getName()));

		try {

			monitor.beginTask(NLS.bind(
					Messages.ServletServiceProvider_Creating_the_Create_URLServices_Chang_, unit
							.getDisplayName()), webApp.getServlets().size());

			for (Iterator iter = webApp.getServlets().iterator(); iter.hasNext();) {
				boolean exists = false;
				final Servlet servlet = (Servlet) iter.next();
				final ServletMapping mapping = webApp.getServletMapping(servlet);
				monitor.subTask(NLS.bind(
						Messages.ServletServiceProvider_Checking_if_URLService_exists_for_Servlet_0_,
						servlet.getServletName()));
				for (Iterator capsIter = unit.getCapabilities().iterator(); capsIter.hasNext()
						&& exists == false;) {
					Capability cap = (Capability) capsIter.next();
					if (J2eePackage.Literals.URL_SERVICE.isSuperTypeOf(cap.eClass())) {
						URLService service = (URLService) cap;
						if (service.getName() != null) {
							if (servlet.getServletName().equals(service.getName())) {
								exists = true;
							}
						}
					}
				}

				if (!exists && mapping != null) {

					AbstractEMFOperation operation = new DeployModelObjectOperation(unit,
							"Modifing Resources") { //$NON-NLS-1$
						protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
								throws ExecutionException {

							URLService service = createURLService(servlet, mapping);
							if (service != null) {
								monitor.subTask(NLS.bind(
										Messages.ServletServiceProvider_Creating_URLService_0_, service
												.getName()));
								unit.getCapabilities().add(service);
							}

							return Status.OK_STATUS;
						}
					};

					AbstractEMFOperationChange emfChange = new AbstractEMFOperationChange(NLS.bind(
							Messages.ServletServiceProvider_Creating_the_Create_URLService_Chang_for_,
							servlet.getServletName()), unit, operation, false);
					compositeChange.add(emfChange);
				}

				monitor.worked(1);
			}

		} finally {
			monitor.done();
		}

		return compositeChange;
	}

	private String getNameForGeneration(URLService urlService) {
		return DeployModelObjectUtil.getTitle(urlService);
	}

	/**
	 * @return The Java package to generate Servlets into for this unit.
	 */
	private String calculateServletPackage(Unit unit) {
		String namespace = null; // replace with correct API call
		// for now, calculate a package:
		IFile topologyFile = WorkbenchResourceHelper.getFile(unit);
		// remove first folder and file
		IPath packagePath = topologyFile.getProjectRelativePath().removeFirstSegments(1)
				.removeLastSegments(1);
		namespace = packagePath.toString().replace('/', '.');

		String servletPackage = namespace.trim().length() > 0 ? namespace.trim()
				+ IConstants.DOT_SEPARATOR + SERVLETS_SUFFIX : SERVLETS_SUFFIX;
		return servletPackage;
	}

	private CompositeChange createDeleteServletsChange(final Unit unit, final IProject project,
			WebApp webApp, IProgressMonitor monitor) {

		CompositeChange compositeChange = new CompositeChange(NLS.bind(
				Messages.ServletServiceProvider_Delete_Servlets_not_found_in_model_, project.getName()));

		try {

			IResource modifiedElement = WorkbenchResourceHelper.getFile(webApp);
			EList servlets = webApp.getServlets();

			monitor.beginTask(NLS.bind(
					Messages.ServletServiceProvider_Creating_the_Delete_Servlets_Chang_, unit
							.getDisplayName()), servlets.size());

			boolean found = false;
			for (Iterator iterator = servlets.iterator(); iterator.hasNext();) {
				Servlet servlet = (Servlet) iterator.next();

				if (servlet.getServletName() != null) {

					found = false;
					List dependencyCapabilities = unit.getCapabilities(
							CapabilityLinkTypeFilter.DEPENDENCY_FILTER, null);
					for (Iterator iter = dependencyCapabilities.iterator(); iter.hasNext() && !found;) {
						Capability capability = (Capability) iter.next();
						if (capability instanceof URLService) {
							URLService urlService = (URLService) capability;
							if (servlet.getServletName().equals(urlService.getDisplayName())) {
								found = true;
							}
						}
					}
					if (!found) {
						compositeChange.add(new DeleteServletMetadataChange(unit, project, servlet
								.getServletName(), modifiedElement));

						JavaClass servletClass = servlet.getServletClass();
						compositeChange.add(new DeleteServletClassChange(unit, project, servlet
								.getServletName(), servletClass.getQualifiedName(), modifiedElement));
					}
				}
				monitor.worked(1);
			}

		} finally {
			monitor.done();
		}

		return compositeChange;
	}

	private CompositeChange createUpdateServletsChange(Unit unit, IProject project, WebApp webApp,
			IProgressMonitor monitor) {
		CompositeChange compositeChange = new CompositeChange(NLS
				.bind(Messages.ServletServiceProvider_Update_existing_Servlets_with_chang_, project
						.getName()));

		try {

			IResource modifiedElement = WorkbenchResourceHelper.getFile(webApp);

			EList servlets = webApp.getServlets();

			monitor.beginTask(NLS.bind(
					Messages.ServletServiceProvider_Creating_the_Delete_Servlets_Chang_, unit
							.getDisplayName()), servlets.size());

			boolean found = false;
			for (Iterator iterator = servlets.iterator(); iterator.hasNext();) {
				Servlet servlet = (Servlet) iterator.next();

				if (servlet.getServletName() != null) {

					found = false;
					List dependencyCapabilities = unit.getCapabilities(
							CapabilityLinkTypeFilter.DEPENDENCY_FILTER, null);
					URLService urlService = null;
					for (Iterator iter = dependencyCapabilities.iterator(); iter.hasNext() && !found;) {
						Capability capability = (Capability) iter.next();
						if (capability instanceof URLService) {
							urlService = (URLService) capability;
							if (servlet.getServletName().equals(urlService.getDisplayName())) {
								found = true;
							}
						}
					}
					if (found) {

						List modelMappings = urlService.getUrlPattern();
						List<String> modelMappingsCheckList = new ArrayList<String>(modelMappings);
						List workspaceMappings = webApp.getServletMappings();
						List<String> workspaceMappingsCheckList = new ArrayList<String>();

						for (Iterator wMappingIter = workspaceMappings.iterator(); wMappingIter.hasNext();) {
							ServletMapping wMap = (ServletMapping) wMappingIter.next();
							if (servlet == wMap.getServlet()) {
								// try to remove it 
								if (!modelMappingsCheckList.remove(wMap.getUrlPattern())) {
									workspaceMappingsCheckList.add(wMap.getUrlPattern());
								}
							}
						}

						if (workspaceMappingsCheckList.size() > 0) {
							for (Iterator checklist = workspaceMappingsCheckList.iterator(); checklist
									.hasNext();) {
								String mapping = (String) checklist.next();
								compositeChange.add(new DeleteServletMappingChange(unit, project, servlet
										.getDisplayName(), mapping, modifiedElement));
							}
						}

						if (modelMappingsCheckList.size() > 0) {
							for (Iterator checklist = modelMappingsCheckList.iterator(); checklist
									.hasNext();) {
								String mapping = (String) checklist.next();
								compositeChange.add(new AddServletMappingChange(unit, project, servlet
										.getDisplayName(), mapping, modifiedElement));
							}
						}

						// we don't yet allow customization of the generated artifact 
						// JavaClass servletClass = servlet.getServletClass();
						// update the servletClass information 

					}
				}
				monitor.worked(1);
			}

		} finally {
			monitor.done();
		}
		return compositeChange;

	}

	public class DeleteServletMetadataChange extends Change {

		private final String servletName;
		private final IProject project;
		private final Unit unit;
		private final IResource modifiedElement;

		public DeleteServletMetadataChange(Unit unit, IProject project, String servletName,
				IResource modifiedElement) {
			this.unit = unit;
			this.project = project;
			this.servletName = servletName;
			this.modifiedElement = modifiedElement;
		}

		public Object getModifiedElement() {
			return modifiedElement;
		}

		public Change perform(IProgressMonitor monitor) throws CoreException {

			monitor.beginTask(getName(), 3);

			try {
				WebArtifactEdit webEdit = WebArtifactEdit.getWebArtifactEditForWrite(project);
				try {
					WebApp webApp = webEdit.getWebApp();

					Servlet servlet = webApp.getServletNamed(servletName);
					List mappings = servlet.getMappings();

					if (mappings.size() > 0) {
						webApp.getServletMappings().removeAll(mappings);
					}
					monitor.worked(1);

					webApp.getServlets().remove(servlet);
					monitor.worked(1);

				} finally {
					webEdit.save(new SubProgressMonitor(monitor, 1));
					webEdit.dispose();
				}
			} finally {
				monitor.done();
			}

			// return undo change to create the metadata
			return null;
		}

		public String getName() {
			return NLS
					.bind(Messages.ServletServiceProvider_Delete_the_0_Servlet_metadat_, servletName);
		}

		public void initializeValidationData(IProgressMonitor pm) {

		}

		public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
				OperationCanceledException {
			return RefactoringStatus.create(Status.OK_STATUS);
		}
	}

	public class DeleteServletMappingChange extends Change {

		private final String servletName;
		private final IProject project;
		private final Unit unit;
		private final String mapping;
		private final IResource modifiedElement;

		public DeleteServletMappingChange(Unit unit, IProject project, String servletName,
				String mapping, IResource modifiedElement) {
			this.unit = unit;
			this.project = project;
			this.servletName = servletName;
			this.mapping = mapping;
			this.modifiedElement = modifiedElement;
		}

		public Object getModifiedElement() {
			return modifiedElement;
		}

		public Change perform(IProgressMonitor monitor) throws CoreException {

			monitor.beginTask(getName(), 1);

			try {
				WebArtifactEdit webEdit = WebArtifactEdit.getWebArtifactEditForWrite(project);
				try {
					WebApp webApp = webEdit.getWebApp();

					Servlet servlet = webApp.getServletNamed(servletName);
					if (servlet != null) {
						for (Iterator iterator = servlet.getMappings().iterator(); iterator.hasNext();) {
							ServletMapping wMapping = (ServletMapping) iterator.next();
							if (mapping.equals(wMapping.getUrlPattern())) {
								webApp.getServletMappings().remove(wMapping);
								break;
							}
						}
					}
					monitor.worked(1);

				} finally {
					webEdit.save(new SubProgressMonitor(monitor, 1));
					webEdit.dispose();
				}
			} finally {
				monitor.done();
			}

			// return undo change to create the metadata
			return null;
		}

		public String getName() {
			return NLS.bind(Messages.ServletServiceProvider_Delete_the_0_for_the_1_serv_,
					new Object[] { mapping, servletName });
		}

		public void initializeValidationData(IProgressMonitor pm) {

		}

		public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
				OperationCanceledException {
			return RefactoringStatus.create(Status.OK_STATUS);
		}

	}

	public class AddServletMappingChange extends Change {

		private final String servletName;
		private final IProject project;
		private final Unit unit;
		private final String mapping;
		private final IResource modifiedElement;

		public AddServletMappingChange(Unit unit, IProject project, String servletName,
				String mapping, IResource modifiedElement) {
			this.unit = unit;
			this.project = project;
			this.servletName = servletName;
			this.mapping = mapping;
			this.modifiedElement = modifiedElement;
		}

		public Object getModifiedElement() {
			return modifiedElement;
		}

		public Change perform(IProgressMonitor monitor) throws CoreException {

			monitor.beginTask(getName(), 1);

			try {
				WebArtifactEdit webEdit = WebArtifactEdit.getWebArtifactEditForWrite(project);
				try {
					WebApp webApp = webEdit.getWebApp();

					Servlet servlet = webApp.getServletNamed(servletName);
					if (servlet != null) {
						ServletMapping sMapping = WebapplicationFactory.eINSTANCE.createServletMapping();
						sMapping.setServlet(servlet);
						sMapping.setUrlPattern(mapping);
						webApp.getServletMappings().add(sMapping);
					}
					monitor.worked(1);

				} finally {
					webEdit.save(new SubProgressMonitor(monitor, 1));
					webEdit.dispose();
				}
			} finally {
				monitor.done();
			}

			// return undo change to create the metadata
			return null;
		}

		public String getName() {
			return NLS.bind(Messages.ServletServiceProvider_Add_the_0_mapping_to_the_1_, new Object[] {
					mapping, servletName });
		}

		public void initializeValidationData(IProgressMonitor pm) {

		}

		public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
				OperationCanceledException {
			return RefactoringStatus.create(Status.OK_STATUS);
		}

	}

	public class DeleteServletClassChange extends Change {

		private final Unit unit;
		private final IProject project;
		private final String servletName;
		private final String servletClass;
		private final IResource modifiedElement;

		public DeleteServletClassChange(Unit unit, IProject project, String servletName,
				String servletClass, IResource modifiedElement) {
			this.unit = unit;
			this.project = project;
			this.servletName = servletName;
			this.servletClass = servletClass;
			this.modifiedElement = modifiedElement;
		}

		public Object getModifiedElement() {
			return modifiedElement;
		}

		public Change perform(IProgressMonitor monitor) throws CoreException {

			monitor.beginTask(getName(), 10);

			try {
				IJavaProject javaProject = JavaCore.create(project);
				IType type = javaProject.findType(servletClass);
				if (type != null) {
					ICompilationUnit compilationUnit = type.getCompilationUnit();
					if (type != null && type.exists()) {
						type.delete(true, new SubProgressMonitor(monitor, 5));
					}

					if (compilationUnit != null && compilationUnit.exists()) {
						IType[] types = compilationUnit.getAllTypes();
						if (types == null || types.length == 0) {
							compilationUnit.delete(true, new SubProgressMonitor(monitor, 5));
						}
					}
				}

			} finally {
				monitor.done();
			}

			// return undo change to create the JavaClass
			return null;
		}

		public String getName() {
			return NLS.bind(Messages.ServletServiceProvider_Delete_the_0_Servlet_class_, servletName);
		}

		public void initializeValidationData(IProgressMonitor pm) {

		}

		public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
				OperationCanceledException {
			return RefactoringStatus.create(Status.OK_STATUS);
		}

	}

}
