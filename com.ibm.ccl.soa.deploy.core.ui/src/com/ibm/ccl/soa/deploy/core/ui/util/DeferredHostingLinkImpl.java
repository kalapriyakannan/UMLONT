package com.ibm.ccl.soa.deploy.core.ui.util;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * @since 7.0
 * 
 */
public class DeferredHostingLinkImpl implements HostingLink {

	final ConstraintLink _constraintLink;

	public ConstraintLink getContraintLink() {
		return _constraintLink;
	}

	/**
	 * @param link
	 */
	public DeferredHostingLinkImpl(ConstraintLink link) {
		super();
		_constraintLink = link;
	}

	public Unit getHost() {
		return GMFUtils.getUnit(_constraintLink.getTarget());
	}

	public Unit getHosted() {
		return GMFUtils.getUnit(_constraintLink.getSource());
	}

	public Unit getSource() {
		return GMFUtils.getUnit(_constraintLink.getSource());
	}

	public Unit getTarget() {
		return GMFUtils.getUnit(_constraintLink.getTarget());
	}

	public Topology getEditTopology() {
		return _constraintLink.getEditTopology();
	}

	public void setHosted(Unit hosted) {
	}

	public void setSource(Unit sourceUnit) {
		_constraintLink.setSource(sourceUnit);
	}

	public void setTarget(Unit targetUnit) {
		_constraintLink.setTarget(targetUnit);
	}

	public String getSourceURI() {
		return _constraintLink.getSourceURI();
	}

	public String getTargetURI() {
		return _constraintLink.getTargetURI();
	}

	public IStatus addStatus(IStatus newStatus) {
		return _constraintLink.addStatus(newStatus);
	}

	public void clearStatus() {
		_constraintLink.clearStatus();
	}

	public Annotation findAnnotation(String context) {
		return _constraintLink.findAnnotation(context);
	}

	public List getAnnotations() {
		return _constraintLink.getAnnotations();
	}

	public List getArtifacts() {
		return _constraintLink.getArtifacts();
	}

	public List getAttributeMetaData() {
		return _constraintLink.getAttributeMetaData();
	}

	public AttributeMetaData getAttributeMetaData(String name) {
		return _constraintLink.getAttributeMetaData(name);
	}

	public Constraint getConstraint(String name) {
		return _constraintLink.getConstraint(name);
	}

	public List getConstraints() {
		return _constraintLink.getConstraints();
	}

	public List getContainedModelObjects() {
		return _constraintLink.getContainedModelObjects();
	}

	public String getDescription() {
		return _constraintLink.getDescription();
	}

	public String getDisplayName() {
		return _constraintLink.getDisplayName();
	}

	public EObject getEObject() {
		return _constraintLink.getEObject();
	}

	public ExtendedAttribute getExtendedAttribute(String name) {
		return _constraintLink.getExtendedAttribute(name);
	}

	public List getExtendedAttributes() {
		return _constraintLink.getExtendedAttributes();
	}

	public String getFullPath() {
		return _constraintLink.getFullPath();
	}

	public String getName() {
		return _constraintLink.getName();
	}

	public DeployModelObject getParent() {
		return _constraintLink.getParent();
	}

	public String getQualifiedName() {
		return _constraintLink.getQualifiedName();
	}

	public String getRelativePath(DeployModelObject relativeObject) {
		return _constraintLink.getRelativePath(relativeObject);
	}

	public IStatus getStatus() {
		return _constraintLink.getStatus();
	}

	public Topology getTopology() {
		return _constraintLink.getTopology();
	}

	public boolean isMutable() {
		return _constraintLink.isMutable();
	}

	public boolean isPublic() {
		return _constraintLink.isPublic();
	}

	public boolean isPublicEditable() {
		return _constraintLink.isPublicEditable();
	}

	public boolean isPublicEditable(String propertyName) {
		return _constraintLink.isPublicEditable(propertyName);
	}

	public boolean isSetMutable() {
		return _constraintLink.isSetMutable();
	}

	public boolean isVisible() {
		return _constraintLink.isVisible();
	}

	public DeployModelObject resolve(String path) {
		return _constraintLink.resolve(path);
	}

	public void setDescription(String value) {
		_constraintLink.setDescription(value);
	}

	public void setDisplayName(String value) {
		_constraintLink.setDisplayName(value);
	}

	public void setMutable(boolean value) {
		_constraintLink.setMutable(value);
	}

	public void setName(String value) {
		_constraintLink.setName(value);
	}

	public void unsetMutable() {
		_constraintLink.unsetMutable();
	}

	public TreeIterator<EObject> eAllContents() {
		return _constraintLink.eAllContents();
	}

	public EClass eClass() {
		return _constraintLink.eClass();
	}

	public EObject eContainer() {
		return _constraintLink.eContainer();
	}

	public EStructuralFeature eContainingFeature() {
		return _constraintLink.eContainingFeature();
	}

	public EReference eContainmentFeature() {
		return _constraintLink.eContainmentFeature();
	}

	public EList<EObject> eContents() {
		return _constraintLink.eContents();
	}

	public EList<EObject> eCrossReferences() {
		return _constraintLink.eCrossReferences();
	}

	public Object eGet(EStructuralFeature feature) {
		return _constraintLink.eGet(feature);
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return _constraintLink.eGet(feature, resolve);
	}

	public boolean eIsProxy() {
		return _constraintLink.eIsProxy();
	}

	public boolean eIsSet(EStructuralFeature feature) {
		return _constraintLink.eIsSet(feature);
	}

	public Resource eResource() {
		return _constraintLink.eResource();
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		_constraintLink.eSet(feature, newValue);
	}

	public void eUnset(EStructuralFeature feature) {
		_constraintLink.eUnset(feature);
	}

	public EList<Adapter> eAdapters() {
		return _constraintLink.eAdapters();
	}

	public boolean eDeliver() {
		return _constraintLink.eDeliver();
	}

	public void eNotify(Notification notification) {
		_constraintLink.eNotify(notification);
	}

	public void eSetDeliver(boolean deliver) {
		_constraintLink.eSetDeliver(deliver);
	}

}
