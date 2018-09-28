/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.util.TopologyNamespaceUtil;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.RenameTopologyChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.operation.RenameTopologyChangeOperation;

/**
 * 
 * Provides a type-specific implementation of the RenameTopologyChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>source</b>: The Source property. </li>
 * <li><b>destination</b>: The Destination property. </li>
 * </ul>
 * 
 */
public class RenameTopologyChange extends RenameResourceChange {

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static RenameTopologyChange createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new RenameTopologyChange(model);
	}

	/**
	 * Creates and returns an instance of the underlying provider for this facade.
	 * 
	 * <p>
	 * A provider implements the actual logic of a data model. All validation logic, calculation of
	 * default values, and management of property dependencies is handled by the provider.
	 * </p>
	 * 
	 * @return An instance of the underlying provider for this facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public static IDataModelProvider createDatamodelProvider() {
		return new RenameTopologyChangeProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameTopologyChange(IDataModel mdl) {
		super(mdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameResourceChange#getName()
	 */
	@Override
	public String getName() {
		return NLS.bind(Messages.RenameTopologyChange_update_resource_uri_to_0_, URI
				.createPlatformResourceURI(getDestination().toString()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange#getAffectedObjects()
	 */
	@Override
	public Object[] getAffectedObjects() {
		return new Object[] { getModifiedElement(),
				ResourcesPlugin.getWorkspace().getRoot().getFile(getDestination()) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getSource());
	}

	public String getNewQualifiedName() {
		IFile newTopologyFile = ResourcesPlugin.getWorkspace().getRoot().getFile(getDestination());

		INamespaceFragmentRoot namespaceRoot = NamespaceCore.getRoot(newTopologyFile.getParent());
		IPath relativePath = newTopologyFile.getFullPath().removeFirstSegments(
				namespaceRoot.getCorrespondingResource().getFullPath().segmentCount());
		String namespace = TopologyNamespaceUtil.concatWith(relativePath.removeLastSegments(1)
				.segments(), IConstants.DOT_SEPARATOR);
		String name = relativePath.removeFileExtension().lastSegment();

		return namespace.length() > 0 ? namespace + IConstants.DOT_SEPARATOR + name : name;
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		return new RenameTopologyChangeOperation(this);
//		RenameTopologyChangeOperation rename = new RenameTopologyChangeOperation(this);
//		CompositeEMFDataModelOperation operation = new CompositeEMFDataModelOperation(rename
//				.getEditingDomain(), getName());
//		operation.setTransactionNestingEnabled(false);
//
//		IFile source = ResourcesPlugin.getWorkspace().getRoot().getFile(getSource());
//		operation.add(new MoveResourcesOperation(source, getDestination(), getName()));
//		operation.add(rename);
//		return operation;
	}
}