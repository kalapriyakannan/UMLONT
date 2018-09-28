package com.ibm.ccl.soa.deploy.uml.internal.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.internal.operations.ElementOperations;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.ICapabilityProviderService;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;
import com.ibm.ccl.soa.deploy.uml.util.ZephyrUmlUtil;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.xtools.uml.navigator.IModelServerElement;
import com.ibm.xtools.uml.navigator.ModelServerElement;
import com.ibm.xtools.uml.navigator.factory.UMLNavigatorWrapperFactory;

public abstract class UMLElementUnitProvider extends UnitProvider {

	protected static final String REQUIREMENT = "Requirement"; //$NON-NLS-1$
	protected static final String CAPABILITY = "Capability"; //$NON-NLS-1$
	protected static final String PROJ_SEPARATOR = "/"; //$NON-NLS-1$
	private static final String PLATFORM_RESOURCE_PREFIX = "platform:/resource/"; //$NON-NLS-1$

	@Override
	public boolean resolveLinks(List deployModelObjects, IProgressMonitor monitor) {

		List<Unit> unitList = new ArrayList();
		Iterator dmos = deployModelObjects.iterator();
		while (dmos.hasNext()) {
			Object obj = dmos.next();
			if (obj instanceof Unit) {
				Unit unit = (Unit) obj;
				ZephyrUmlUtil.linkRequiredElements(unit);
				unitList.add(unit);
			}
		}

		// Add this check to ensure we don't handle non-unit DMOs
		if (unitList.size() > 0) {
			Topology top = unitList.get(0).getTopology();
			ZephyrUmlUtil.linkRequiredInteractionElements(unitList, top);
		}

		return false;
	}

	@Override
	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		TopologyUnitStub[] stubs = NO_STUBS;
		NamedElement element = null;
		if (anInputObject instanceof ModelServerElement) {
			Object obj = ((ModelServerElement) anInputObject).getElement();
			if (obj instanceof NamedElement) {
				element = (NamedElement) obj;
			}

		}
		if (element != null) {
			stubs = new TopologyUnitStub[1];
			stubs[0] = new TopologyUnitStub("TestStubName", null, null, element); //$NON-NLS-1$
		}
		return stubs;
	}

	protected void setRequirementsAndCapabilities(Unit unit, Object inputObj) {

		// Look up capability manager service
		ICapabilityProviderService capabilityProviderService = ExtensionsCore
				.createCapabilityProviderService();

		CapabilityProvider[] providers = capabilityProviderService
				.findEnabledCapabilityProvidersByInputOnly(inputObj);
		for (int i = 0; i < providers.length; i++) {
			CapabilityProvider provider = providers[i];
			Object[] capabilities = provider.resolveCapabilities(inputObj);
			//TODO deal with requirements
			Object[] requirements = provider.resolveRequirements(inputObj);
			for (int j = 0; j < capabilities.length; j++) {
				// Ensure uniqueness of capability and unit names
				if (capabilities[j] instanceof Capability) {
					Capability cap = (Capability) capabilities[j];
					String capName = cap.getName();
					if (capName == null) {
						capName = CAPABILITY;
						cap.setName(capName);
					}
					if (capName.equals(unit.getName())) {
						cap.setName(capName + " " + CAPABILITY); //$NON-NLS-1$
					}
				}
				unit.getCapabilities().add(capabilities[j]);
			}

			for (int j = 0; j < requirements.length; j++) {
				// Ensure uniqueness of requirement and unit names
				if (requirements[j] instanceof Requirement) {
					Requirement req = (Requirement) requirements[j];
					String reqName = req.getName();
					if (reqName == null) {
						reqName = REQUIREMENT;
						req.setName(reqName);
					}
					if (reqName.equals(unit.getName())) {
						req.setName(req.getName() + " " + REQUIREMENT); //$NON-NLS-1$
					}
				}
				unit.getRequirements().add(requirements[j]);
			}
		}

	}

	// Persist model source information
	protected void addUMLElementArtifact(Unit unit, NamedElement namedElement, Topology top) {

		if (namedElement.eResource() != null) {
			UMLElementArtifact artifact = UmlFactory.eINSTANCE.createUMLElementArtifact();
			artifact.setDisplayName(unit.getDisplayName());
			artifact.setName(unit.getName());
			URI resUri = namedElement.eResource().getURI();
			String resUriString = resUri.toString();
			IFile file = WorkbenchResourceHelper.getPlatformFile(resUri);
			String modelProjName = null;
			if (file != null) {
				modelProjName = file.getProject().getName();
			}

			IProject topProj = ProjectUtilities.getProject(top);
			if (topProj != null && modelProjName != null) {
				if (modelProjName.equals(topProj.getName())) {
					String removestr = PLATFORM_RESOURCE_PREFIX + modelProjName + PROJ_SEPARATOR;
					if (resUriString.startsWith(removestr)) {
						resUriString = resUriString.substring(removestr.length());
					}
				}
			}

			artifact.setResourceURI(resUriString);
			artifact.setQualifiedName(namedElement.getQualifiedName());
			unit.getArtifacts().add(artifact);
		}
	}

	public Object resolveUnderlyingResource(Unit unit, IProgressMonitor aMonitor) {

		List resources = new ArrayList();

		EObject namedElement = ZephyrUmlUtil.resolveNamedElement(unit);
		if (namedElement != null) {
			IModelServerElement modelElem = UMLNavigatorWrapperFactory.getInstance().getViewerElement(
					namedElement);
			resources.add(modelElem);
		}

		// no longer returning emx resource, return a ModelServerElement
		return resources;
	}

	protected List<Stereotype> getStereotypes(NamedElement element) {
		List<Stereotype> zStereotypes = new ArrayList<Stereotype>();
		List stereotypes = ElementOperations.getAppliedStereotypes(element);
		for (int i = 0; i < stereotypes.size(); i++) {
			Stereotype zst = CoreFactory.eINSTANCE.createStereotype();
			org.eclipse.uml2.uml.Stereotype st = (org.eclipse.uml2.uml.Stereotype) stereotypes.get(i);
			zst.setKeyword(st.getKeyword());
			zst.setProfile(st.getProfile().getName());
			zst.setRequired(true); // TODO derive
			zStereotypes.add(zst);
		}
		return zStereotypes;
	}

	protected String getDisplayName(String elemName) {
		String firstChar = elemName.substring(0, 1).toLowerCase();
		return firstChar + elemName.substring(1);
	}

	public Unit resolveExistingInstance(Topology top, TopologyUnitStub aStub) {

		Unit instance = null;
		Object obj = aStub.getInput();
		if (obj instanceof NamedElement) {
			NamedElement elem = (NamedElement) obj;
			// TODO could perhaps be more than one - just return first one
			instance = ZephyrUmlUtil.resolveUnit(elem, top);
		}
		return instance;
	}
}
