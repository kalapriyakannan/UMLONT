package com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation;

import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IRefactoringDataModelChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.ChangeScribblerDomain;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange;
import com.ibm.ccl.soa.infrastructure.emf.EclipseResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.datamodels.ScribblerDefinitionDatamodel;
import com.ibm.ccl.soa.infrastructure.operations.AbstractEMFScribblerOperation;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

/**
 * 
 * Base type for all {@code Change}s contributed by the soa deploy ide plugin.
 * 
 * <p>
 * Clients should use {@link DeployRefactoringChange#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.infrastructure.operations.AbstractEMFScribblerOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange
 * @generated (mde.utilities.datamodels)
 */
public abstract class DeployRefactoringChangeOperation extends AbstractEMFScribblerOperation
		implements IRefactoringDataModelChangeProperties {

	private DeployRefactoringChange typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeployRefactoringChangeOperation(IDataModel dMdl) {
		super(dMdl);
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeployRefactoringChangeOperation(DeployRefactoringChange tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(DeployRefactoringChange mdl) {
		typesafeModel = mdl;
	}

	protected IScribblerDomain getScribblerDomain(IResource resource) {

		ScribblerDefinitionDatamodel scribblerDefinitionModel = typesafeModel
				.getScribblerDefinition();

		if (!model.isPropertySet(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL)) {

			ChangeScribblerDomain domain = new ChangeScribblerDomain(resource);
			scribblerDefinitionModel.setEditModelLabel(domain.getEditModelLabel());
			scribblerDefinitionModel.setProjectName(resource.getProject().getName());
			scribblerDefinitionModel.setScribblerDomains(Arrays
					.asList(new IScribblerDomain[] { domain }));

			model.setProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL, domain
					.getEditModelLabel());
			model.setProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME, resource
					.getProject().getName());
			model.setProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS,
					new IScribblerDomain[] { domain });

			return domain;
		} else {
			for (Iterator iter = scribblerDefinitionModel.getScribblerDomains().iterator(); iter
					.hasNext();) {

				IScribblerDomain domain = (IScribblerDomain) iter.next();
				if (resource.getProject().equals(super.getProject())) {
					return domain;
				}

				IResourceDescriptor descriptor = null;
				switch (resource.getType())
				{
				case IResource.FILE:
					descriptor = new EclipseResourceDescriptor((IFile) resource);
					break;

				default:
					descriptor = new EclipseResourceDescriptor(resource.getProjectRelativePath(),
							resource.getFullPath());
				}

				if (domain.isContained(descriptor)) {
					return domain;
				}
			}

			ChangeScribblerDomain domain = new ChangeScribblerDomain(resource);
			scribblerDefinitionModel.getScribblerDomains().add(domain);
			return domain;
		}
	}

	protected IEditModelScribbler getScribbler() throws CoreException {
		return super.getEditModelScribbler();
	}

	protected Resource getResource(IFile aFile) throws CoreException {
		Resource resource = getScribbler().getResource(aFile);
		if (resource == null || resource.getContents().size() < 1) {
			throw new CoreException(new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, NLS.bind(
					Messages.DeployCoreChange_Cannot_read_EMF_resource_from_file_, aFile.getFullPath())));
		}

//		IStatus status = diagnose(resource);
//		if (getStatusWithHighestSeverity(status).matches(IStatus.WARNING | IStatus.ERROR)) {
//			throw new CoreException(getStatusWithHighestSeverity(status));
//		}

		return resource;
	}

	protected Topology getTopology(IFile aFile) throws CoreException {
		DeployCoreRoot root = (DeployCoreRoot) getResource(aFile).getContents().get(0);

		if (root == null) {
			throw new CoreException(
					new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, NLS.bind(
							Messages.DeployCoreChange_A_DeployCoreRoot_EMF_object_could_n_, aFile
									.getFullPath())));
		}

		Topology topology = root.getTopology();

		if (topology == null) {
			throw new CoreException(
					new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, NLS.bind(
							Messages.DeployCoreChange_A_Topology_EMF_object_was_not_found_, aFile
									.getFullPath())));
		}

		return topology;
	}

	protected Diagram getDiagram(IFile aFile) throws CoreException {
		Diagram diagram = (Diagram) getResource(aFile).getContents().get(0);

		if (diagram == null) {
			throw new CoreException(
					new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, NLS.bind(
							Messages.DeployCoreChange_A_Diagram_EMF_object_could_not_be_f_, aFile
									.getFullPath())));
		}

		return diagram;
	}

	protected IStatus diagnose(Resource resource) {
		Diagnostic diagnostic = EcoreUtil.computeDiagnostic(resource, true);
		return diagnose(diagnostic);
	}

	private IStatus diagnose(Diagnostic diagnostic) {

		IStatus status = Status.OK_STATUS;

		if (diagnostic.getChildren().size() > 0) {
			status = new MultiStatus(diagnostic.getSource() != null ? diagnostic.getSource()
					: IDEPlugin.PLUGIN_ID, diagnostic.getCode(), diagnostic.getMessage(), diagnostic
					.getException());

			for (Iterator<Diagnostic> iter = diagnostic.getChildren().iterator(); iter.hasNext();) {
				((MultiStatus) status).add(diagnose(iter.next()));
			}
		} else {
			status = new Status(diagnostic.getSeverity(), diagnostic.getSource() != null ? diagnostic
					.getSource() : IDEPlugin.PLUGIN_ID, diagnostic.getCode(), diagnostic.getMessage(),
					diagnostic.getException());
		}

		return status;
	}

	protected IStatus getStatusWithHighestSeverity(IStatus status) {
		if (!status.isMultiStatus()) {
			return status;
		}

		IStatus highest = status;
		for (int i = 0; i < status.getChildren().length; i++) {
			IStatus aStatus = status.getChildren()[i];
			if (highest.getSeverity() == aStatus.getSeverity()) {
				highest = aStatus;
				break;
			}
		}

		return highest;
	}

	private static Object adapt(Object adaptable, Class adapter) {
		Object adapted = null;
		if (adaptable instanceof IAdaptable) {
			adapted = ((IAdaptable) adaptable).getAdapter(adapter);
		}
		if (null == adapted) {
			adapted = Platform.getAdapterManager().getAdapter(adaptable, adapter);
		}
		return adapted;
	}
}
