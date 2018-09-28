package com.ibm.ccl.soa.deploy.uml.internal.mmi.providers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.uml.internal.mmi.manager.IDeployMMInterface;
import com.ibm.xtools.mmi.core.ref.StructuredReference;
import com.ibm.xtools.mmi.core.services.ref.AbstractCachingStructuredReferenceProvider;
import com.ibm.xtools.mmi.core.services.ref.StructuredReferenceService;

public class UnitStructuredReferenceHandler extends AbstractCachingStructuredReferenceProvider
		implements IDeployMMInterface {

	private static UnitStructuredReferenceHandler unitStructuredReferenceHandler = null;
	private ChangeScope<Topology, DeploymentTopologyDomain> changeScope;

	@Override
	protected StructuredReference constructStructuredReference(Object referencedContext,
			Object domainElement) {
		StructuredReference vr = getModifier().createStructuredReference(UREF_HANDLER_ID, null, null);
		assert domainElement != null;
		assert domainElement instanceof Unit;
		Unit unit = (Unit) domainElement;
		IProject project = ProjectUtilities.getProject(unit);
		assert project != null;
		getModifier().setProperty(vr, CONTAINER_NAME, project.getName());
		getModifier().setProperty(vr, CONTAINTER_PATTERN, getPattern(unit));
		getModifier().setProperty(vr, TYPE_NAME, unit.getName());
		return vr;

	}

	private String getPattern(Unit unit) {
		Topology topology = unit.getEditTopology();
		assert topology != null;
		return topology.getQualifiedName();
	}

	public Object getInfo(Object referencedContext, StructuredReference ref, String infoName) {
		return null;
	}

	public Object resolveToDomainElement(Object referencedContext, StructuredReference ref) {
		String containerName = ref.getProperty(CONTAINER_NAME);
		String containerPattern = ref.getProperty(CONTAINTER_PATTERN);
		String name = ref.getProperty(TYPE_NAME);
		assert containerName != null;
		assert containerPattern != null;
		assert name != null;
		DeployModelObject dmo = resolveToDomainElement(containerName, containerPattern, name);
		return dmo;
	}

	private DeployModelObject resolveToDomainElement(String containerName, String containerPattern,
			String name) {
		IProject context = getProject(containerName);
		if (context == null || containerPattern == null || !context.isAccessible()) {
			return null;
		}
		IFile file = NamespaceCore.resolveTopology(context, containerPattern);
		if (file == null) {
			return null;
		}
		return getDeployModelObject(file, name);

	}

	private DeployModelObject getDeployModelObject(IFile file, String name) {
		if (isChangeScopeOpen()) {
			closeChangeScope(new NullProgressMonitor());
		}
		if (file == null || !(file.isAccessible() && file.exists())) {
			return null;
		}
		changeScope = ChangeScope.createChangeScopeForRead(file);
		Topology topology = changeScope.openTopology();
		if (topology == null) {
			return null;
		}
		DeployModelObject dmo = topology.resolve(name);
		assert dmo != null;
		assert dmo instanceof Unit;
		Unit unit = (Unit) dmo;
		return unit;
	}

	private Unit getUnit(List units, String name) {
		for (Iterator iterator = units.iterator(); iterator.hasNext();) {
			Unit unit = (Unit) iterator.next();
			if (unit.getName().equals(name)) {
				return unit;
			}
		}
		return null;

	}

	private IProject getProject(String projectName) {
		IProject project = ProjectUtilities.getProject(projectName);
		assert project != null;
		return project;
	}

	public static UnitStructuredReferenceHandler getInstance() {
		if (unitStructuredReferenceHandler == null) {
			unitStructuredReferenceHandler = (UnitStructuredReferenceHandler) StructuredReferenceService
					.getInstance().getHandler(UREF_HANDLER_ID);
		}
		return unitStructuredReferenceHandler;

	}

	public boolean isChangeScopeOpen() {
		return changeScope != null;
	}

	public boolean closeChangeScope(IProgressMonitor monitor) {
		if (changeScope == null) {
			return false;
		}
		changeScope.close(monitor);
		changeScope = null;
		return true;

	}

}
