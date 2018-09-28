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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jst.j2ee.internal.web.archive.operations.WebFacetProjectCreationDataModelProvider;
import org.eclipse.jst.j2ee.webapplication.WebApp;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.componentcore.datamodel.properties.IFacetDataModelProperties;
import org.eclipse.wst.common.componentcore.datamodel.properties.IFacetProjectCreationDataModelProperties;
import org.eclipse.wst.common.componentcore.datamodel.properties.IFacetProjectCreationDataModelProperties.FacetDataModelMap;
import org.eclipse.wst.common.componentcore.internal.util.IModuleConstants;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.project.facet.core.IProjectFacetVersion;
import org.eclipse.wst.common.project.facet.core.runtime.IRuntime;
import org.eclipse.wst.common.project.facet.core.runtime.RuntimeManager;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.synchronization.DatamodelDrivenChange;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployPlugin;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.internal.Messages;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEVersionUtil;
import com.ibm.ccl.soa.deploy.j2ee.provider.J2eeEditPlugin;

public class WebModuleCapabilityProvider extends J2EEModuleCapabilityProvider {

	/**
	 * Return the array of requirements for a WebApplication
	 */
	public Object[] resolveRequirements(Object anObject) {
		if (anObject instanceof WebApp) {
			Map requirements = new HashMap();
			WebApp webApp = (WebApp) anObject;

			int servletVersion = webApp.getVersionID();
			int j2eeVersion = J2EEVersionUtil.convertServletVersionToJ2EEVersion(servletVersion);
			int jspVersion = J2EEVersionUtil.convertJ2EEVersionToJSPVersion(j2eeVersion);

			String key = KEY_BASE_J2EE + j2eeVersion;
			/* Removed per bug 11884 */
//			if (!requirements.containsKey(key)) {
//				Requirement j2eeContainerReq = createJ2EEContainerReq(j2eeVersion);
//				requirements.put(key, j2eeContainerReq);
//			}
			key = KEY_BASE_SERVLET + servletVersion;
			if (!requirements.containsKey(key)) {
				Requirement servletContainerReq = createServletContainerReq(servletVersion);
				requirements.put(key, servletContainerReq);
			}

			key = KEY_BASE_JSP + jspVersion;
			if (!requirements.containsKey(key)) {
				Requirement jspContainerReq = createJSPContainerReq(jspVersion);
				requirements.put(key, jspContainerReq);
			}

			Requirement jarCardinality = CoreFactory.eINSTANCE.createRequirement();
			jarCardinality.setDmoEType(J2eePackage.Literals.JAR_MODULE);
			jarCardinality.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			jarCardinality.setUse(RequirementUsage.REQUIRED_LITERAL);
			jarCardinality.setName("ContainedUtilityJarComponents"); //$NON-NLS-1$
			jarCardinality.setDisplayName("Utility Jar Components"); //$NON-NLS-1$
//			RequirementExpression jarCardExpr = OutCardinality.createExpression(0, -1);
//			jarCardExpr.setUse(RequirementExpressionUsage.OPTIONAL_LITERAL);
//			jarCardinality.getExpressions().add(jarCardExpr);
			jarCardinality.getConstraints().add(createMemberConstraint(0, Integer.MAX_VALUE));
			requirements.put("jar", jarCardinality); //$NON-NLS-1$

			return toReqArray(requirements.values());
		}

		return NO_REQS;
	}

	public Object[] resolveCapabilities(Object anObject) {
		return NO_CAPS;
	}

	public boolean canImplement() {
		return true;
	}

	public RefactoringStatus checkConditionsForImplementation(Unit unit, IProgressMonitor monitor)
			throws OperationCanceledException {

		RefactoringStatus status = RefactoringStatus.create(Status.OK_STATUS);

		if (unit instanceof SoftwareComponent) {
			SoftwareComponent component = (SoftwareComponent) unit;
			String projectName = J2eeEditPlugin.computeProjectName(component.getDisplayName());

			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

			if (project.exists() && !project.isOpen()) {
				status.addWarning(NLS.bind(
						Messages.WebImplementationParticipant_The_project_0_is_closed_and_wil_, project
								.getName()));
			}
		}

		return status;
	}

	public Change[] createImplementationChange(Unit unit, IProgressMonitor monitor) {

//		CompositeChange change = new CompositeChange(Messages.WebImplementationParticipant_Implement_Web_Component_);
//		//Change change = null;

		List changes = new ArrayList();

		if (unit instanceof WebModule) { // limit to web module for now
			SoftwareComponent component = (SoftwareComponent) unit;

			String displayName = component.getDisplayName();
			String projectName = J2eeEditPlugin.computeProjectName(displayName);

			// ensure the project exists
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (!project.exists()) {

				IDataModel projectCreationModel = DataModelFactory
						.createDataModel(new WebFacetProjectCreationDataModelProvider());
				projectCreationModel.setProperty(
						IFacetProjectCreationDataModelProperties.FACET_PROJECT_NAME, project.getName());

				Set facets = new HashSet();
				FacetDataModelMap facetMap = (FacetDataModelMap) projectCreationModel
						.getProperty(IFacetProjectCreationDataModelProperties.FACET_DM_MAP);
				if (facetMap != null) {
					Collection facetDatamodels = facetMap.values();
					for (Iterator iter = facetDatamodels.iterator(); iter.hasNext();) {
						IDataModel model = (IDataModel) iter.next();
						IProjectFacetVersion facetVersion = (IProjectFacetVersion) model
								.getProperty(IFacetDataModelProperties.FACET_VERSION);
						if (facetVersion != null) {
							facets.add(facetVersion);
						}
					}

					Set runtimes = RuntimeManager.getRuntimes(facets);
					if (runtimes.size() > 0) {
						IRuntime runtime = (IRuntime) runtimes.iterator().next();
						projectCreationModel.setProperty(
								IFacetProjectCreationDataModelProperties.FACET_RUNTIME, runtime);
					} // TODO -- add validation to inform user that a runtime could not be found

				}
				changes.add(new DatamodelDrivenChange(NLS.bind(
						Messages.WebModuleCapabilityProvider_Create_a_Dynamic_Web_Project_named_, project
								.getName()), project, projectCreationModel));
				changes.add(new AddAnnotationChange(unit, projectCreationModel));
			}
		}

		if (changes.size() == 0) {
			return NO_CHANGES;
		}

		return (Change[]) changes.toArray(new Change[changes.size()]);
	}

	public class AddAnnotationChange extends Change {

		private final Unit unit;
		private final IDataModel projectCreationModel;

		public AddAnnotationChange(Unit unit, IDataModel projectCreationModel) {
			this.unit = unit;
			this.projectCreationModel = projectCreationModel;

		}

		public Object getModifiedElement() {
			return unit;
		}

		public String getName() {
			return NLS.bind(Messages.WebModuleCapabilityProvider_Add_annotation_to_0_to_coordinate_,
					unit.getDisplayName());
		}

		public void initializeValidationData(IProgressMonitor pm) {

		}

		public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
				OperationCanceledException {
			return RefactoringStatus.create(Status.OK_STATUS);
		}

		public Change perform(final IProgressMonitor monitor) throws CoreException {
			try {
				try {
					new AbstractEMFOperation(TransactionUtil.getEditingDomain(unit), getName()) {
						protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
								throws ExecutionException {

							monitor.beginTask(getName(), 10);
							createAnnotation(new SubProgressMonitor(monitor, 8));
							createLocation(new SubProgressMonitor(monitor, 2));
							monitor.done();
							return Status.OK_STATUS;
						}

						private void createLocation(IProgressMonitor monitor) {
							monitor.beginTask(
									Messages.WebModuleCapabilityProvider_Setting_artifact_location_, 1);
							FileArtifact artifact = CoreFactory.eINSTANCE.createFileArtifact();
							List files = artifact.getFileURIs();
							String projectName = projectCreationModel
									.getStringProperty(IFacetProjectCreationDataModelProperties.FACET_PROJECT_NAME);
							String projectURI = URI.createPlatformResourceURI(
									IPath.SEPARATOR + projectName).toPlatformString(false);
							monitor.subTask(projectURI);
							files.add(projectURI);
							unit.getArtifacts().add(artifact);
							UnitUtil.assignUniqueName(unit);
							monitor.done();

						}

						private void createAnnotation(IProgressMonitor monitor) {
							monitor.beginTask(Messages.WebModuleCapabilityProvider_Adding_annotations_, 6);
							Annotation annotation = unit
									.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
							if (annotation == null) {
								monitor.subTask(IAnnotationConstants.ENVIRONMENT_WTP);
								annotation = CoreFactory.eINSTANCE.createAnnotation();
								annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
								unit.getAnnotations().add(annotation);
							}
							monitor.worked(1);
							Map details = annotation.getDetails();
							IRuntime runtime = (IRuntime) projectCreationModel
									.getProperty(IFacetProjectCreationDataModelProperties.FACET_RUNTIME);
							if (runtime != null) {
								monitor.subTask(runtime.getName());
								// add runtime_id
								details.put(IAnnotationConstants.RUNTIME_ID, runtime.getName());
								monitor.worked(1);

								monitor.subTask(ServerRuntimeUtils.getRuntimeId(runtime));
								// add runtime_type
								details.put(IAnnotationConstants.RUNTIME_TYPE, ServerRuntimeUtils
										.getRuntimeId(runtime));
								monitor.worked(1);
							} else {
								monitor.worked(2);
							}

							String projectName = projectCreationModel
									.getStringProperty(IFacetProjectCreationDataModelProperties.FACET_PROJECT_NAME);
							monitor.subTask(projectName);
							details.put(IAnnotationConstants.PROJECT_NAME, projectName);
							monitor.worked(1);
							// add module_type 
							monitor.subTask(IModuleConstants.JST_WEB_MODULE);
							details.put(IAnnotationConstants.MODULE_TYPE, IModuleConstants.JST_WEB_MODULE);
							unit.setConceptual(false);

							monitor.worked(1);

							monitor.done();
						}
					}.execute(monitor, null);
				} catch (ExecutionException e) {
					throw new CoreException(J2EEDeployPlugin.createErrorStatus(0, NLS.bind(
							Messages.WebModuleCapabilityProvider_Could_not_execute_0_, getName()), e));
				}

			} finally {
				monitor.done();
			}

			// return the undo change 
			return null;
		}

	}

}
