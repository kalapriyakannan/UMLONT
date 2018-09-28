package com.ibm.ccl.soa.deploy.uml.internal.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Interaction;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.SynchronizationChange;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;
import com.ibm.ccl.soa.deploy.uml.util.ZephyrUmlUtil;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.xtools.uml.navigator.FileViewerElement;
import com.ibm.xtools.uml.navigator.ModelServerElement;

public class UMLInteractionProvider extends UnitProvider {

	private final String RESOURCE_URI = "resource.uri"; //$NON-NLS-1$
	private final String INTERACTION_QNAME = "interaction.qname"; //$NON-NLS-1$
	protected static final String PROJ_SEPARATOR = "/"; //$NON-NLS-1$
	private static final String PLATFORM_RESOURCE_PREFIX = "platform:/resource"; //$NON-NLS-1$

	@Override
	public boolean resolveLinks(List deployModelObjects, IProgressMonitor monitor) {

		if (deployModelObjects != null & deployModelObjects.size() > 0) {
			Topology top = ((DeployModelObject) deployModelObjects.get(0)).getTopology();
			ZephyrUmlUtil.linkRequiredInteractionElements(top);
		}

		return false;
	}

	@Override
	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		TopologyUnitStub[] stubs = NO_STUBS;
		Object input = anInputObject;
		if (anInputObject instanceof FileViewerElement) {
			FileViewerElement fileElement = (FileViewerElement) anInputObject;
			Object element = fileElement.getElement();
			if (element instanceof IFile) {
				input = element;
			}
		} else if (anInputObject instanceof ModelServerElement) {
			ModelServerElement modElem = (ModelServerElement) anInputObject;
			Object elem = modElem.getElement();
			if (elem instanceof Diagram) {
				Diagram diag = (Diagram) elem;
				input = diag.getElement();
			} else {
				input = elem;
			}
		}

		stubs = new TopologyUnitStub[1];
		stubs[0] = new TopologyUnitStub("TestStubName", null, null, input); //$NON-NLS-1$
		return stubs;
	}

	@Override
	public Object[] resolveUnit(TopologyUnitStub stub, boolean toResolveLazily,
			IProgressMonitor monitor) {

		String intQName = null;
		Object input = stub.getInput();
		IProject inputProject = null;
		ArrayList<UMLInteractionConstraint> constraints = new ArrayList<UMLInteractionConstraint>();
		if (input instanceof IFile) {
			IFile file = (IFile) input;
			inputProject = file.getProject();
			String resourceURI = file.getFullPath().toString();
			UMLInteractionConstraint umlConstr = createConstraint(resourceURI, null, stub
					.getTopology(), inputProject);
			if (umlConstr != null) {
				constraints.add(umlConstr);
			}

		} else if (input instanceof Interaction) {
			Interaction interaction = (Interaction) input;
			intQName = interaction.getQualifiedName();
			URI resUri = interaction.eResource().getURI();
			IFile file = WorkbenchResourceHelper.getPlatformFile(resUri);
			if (file != null) {
				inputProject = file.getProject();
			}
			UMLInteractionConstraint umlConstr = createConstraint(resUri.toString(), intQName, stub
					.getTopology(), inputProject);
			if (umlConstr != null) {
				constraints.add(umlConstr);
			}
		} else if (input instanceof Collaboration) {
			List behavs = ((Collaboration) input).getOwnedBehaviors();
			for (int i = 0; i < behavs.size(); i++) {
				Object obj = behavs.get(i);
				if (obj instanceof Interaction) {
					Interaction interaction = (Interaction) obj;
					intQName = interaction.getQualifiedName();
					URI resUri = interaction.eResource().getURI();
					IFile file = WorkbenchResourceHelper.getPlatformFile(resUri);
					if (file != null) {
						inputProject = file.getProject();
					}
					UMLInteractionConstraint umlConstr = createConstraint(resUri.toString(), intQName,
							stub.getTopology(), inputProject);
					if (umlConstr != null) {
						constraints.add(umlConstr);
					}

				}
			}
		}

		return constraints.toArray(new DeployModelObject[constraints.size()]);

	}

	@Override
	public Change[] createImportChange(final Topology topology, final TopologyUnitStub stub,
			IProgressMonitor monitor) {
		Change[] changes = new Change[] { new SynchronizationChange(stub.getTopology(),
				getDescriptor().getDescription()) {

			@Override
			public Change perform(IProgressMonitor monitor) throws CoreException {

				try {
					monitor.beginTask(NLS.bind(DeployCoreMessages.UnitProvider_Resolving_Units_for_0_,
							stub.getName()), 10);

					Object[] resolvedConstraints = resolveUnit(stub, true, monitor);
					monitor.worked(8);

					// Uniquify name
					for (int i = 0; i < resolvedConstraints.length; i++) {
						((DeployModelObject) resolvedConstraints[i]).setName(getUniqueName(topology,
								"iC0")); //$NON-NLS-1$
					}

					List constraintList = Arrays.asList(resolvedConstraints);

					topology.getConstraints().addAll(constraintList);

					resolveLinks(constraintList, new SubProgressMonitor(monitor, 2,
							SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));

					monitor.worked(2);
				} finally {
					monitor.done();
				}

				return null;
			}

		} };
		return changes;
	}

	private String getUniqueName(DeployModelObject container, String name) {
		String newName = name;
		int uniqifier = 0;
		while (null != container.resolve(newName)) {
			newName += uniqifier++;
		}

		return newName;
	}

	UMLInteractionConstraint createConstraint(String resourceUri, String qName, Topology top,
			IProject inputProj) {

		UMLInteractionConstraint umlConstr = null;

		// Add platform URI if it doesn't exist
		if (!resourceUri.startsWith(PLATFORM_RESOURCE_PREFIX)) {
			resourceUri = PLATFORM_RESOURCE_PREFIX + resourceUri;
		}

		IProject topProj = ProjectUtilities.getProject(top);
		// Strip out platform URI + project info in model and topology are in same project
		if (topProj != null && inputProj != null) {
			if (inputProj.getName().equals(topProj.getName())) {
				String removestr = PLATFORM_RESOURCE_PREFIX + PROJ_SEPARATOR + inputProj.getName()
						+ PROJ_SEPARATOR;
				if (resourceUri.startsWith(removestr)) {
					resourceUri = resourceUri.substring(removestr.length());
				}
			}
		}
		if (shouldConstrainTopology(top, resourceUri)) {

			umlConstr = UmlFactory.eINSTANCE.createUMLInteractionConstraint();
			umlConstr.setResourceURI(resourceUri);
			umlConstr.setInteractionQName(qName);
			umlConstr.setDisplayName(qName);
		}
		return umlConstr;
	}

	private boolean shouldConstrainTopology(Topology topology, String resourceURI) {
		List<DeployModelObject> constraints = topology.getConstraints();
		for (Iterator iterator = constraints.iterator(); iterator.hasNext();) {
			DeployModelObject dObject = (DeployModelObject) iterator.next();
			if (dObject instanceof UMLInteractionConstraint) {
				UMLInteractionConstraint constraint = (UMLInteractionConstraint) dObject;
				if (constraint.getResourceURI().equals(resourceURI)) {
					return false;
				}
			}
		}
		return true;

	}

}
