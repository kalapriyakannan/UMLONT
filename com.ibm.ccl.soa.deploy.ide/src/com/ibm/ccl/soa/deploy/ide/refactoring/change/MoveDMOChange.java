/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IMoveDMOChangeProperties;

/**
 * 
 * Provides a type-specific implementation of the MoveDMOChange model.
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>source</b>:
 * 
 * </li>
 * <li><b>destination</b>:
 * 
 * </li>
 * </ul>
 * 
 * <p>
 * The following <b>nested models</b> are used by this datamodel. Nested datamodels are used to
 * supplement the information collected by an enclosing datamodel or to execute nested operations
 * directly. The type-safe facade provides generates type-safe facades for each of the nested
 * datamodels, and provides the appropriate accessors and mutators.
 * </p>
 * <p>
 * Accessors (methods that begin with "get") will first check the facaded datamodel for an instance
 * of the nested datamodel, and if found, wrap it in a type-safe facade. Otherwise, the appropriate
 * datamodel will be created, wrapped, and returned.
 * </p>
 * <p>
 * Clients are not required to supply their own instances of nested models (as they are created when
 * accessors ("get") methods are called, but may access the
 * {@link #getUnderlyingDataModel() underlying datamodel} directly if they require advanced
 * customization.
 * </p>
 * <ul>
 * <li><b>scribblerDefinition</b> (Type:
 * {@link com.ibm.ccl.soa.infrastructure.emf.datamodels.ScribblerDefinitionDatamodel} ) : Used by
 * {@code DeployRefactoringChange} classes that need to modify EMF models. </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public abstract class MoveDMOChange extends DeployRefactoringChange {

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveDMOChange(IDataModel mdl) {
		super(mdl);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newSource
	 *           The new value of the Source property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setSource(org.eclipse.emf.common.util.URI newSource) {
		getUnderlyingDataModel().setProperty(IMoveDMOChangeProperties.SOURCE, newSource);
	}

	/**
	 * 
	 * 
	 * @return The value of the Source property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.emf.common.util.URI getSource() {
		return (org.eclipse.emf.common.util.URI) getUnderlyingDataModel().getProperty(
				IMoveDMOChangeProperties.SOURCE);
	}

	/**
	 * Determine if the Source property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Source
	 *         property is valid.
	 * @see #getSource()
	 * @see #setSource(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateSource() {
		return getUnderlyingDataModel().validateProperty(IMoveDMOChangeProperties.SOURCE);
	}

	/**
	 * Determine the default value of the Source property.
	 * 
	 * @return The default value of the Source property.
	 * @see #getSource()
	 * @see #setSource(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.emf.common.util.URI getDefaultSource() {
		return (org.eclipse.emf.common.util.URI) getUnderlyingDataModel().getDefaultProperty(
				IMoveDMOChangeProperties.SOURCE);
	}

	/**
	 * 
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDestination
	 *           The new value of the Destination property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDestination(org.eclipse.emf.common.util.URI newDestination) {
		getUnderlyingDataModel().setProperty(IMoveDMOChangeProperties.DESTINATION, newDestination);
	}

	/**
	 * 
	 * 
	 * @return The value of the Destination property.
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.emf.common.util.URI getDestination() {
		return (org.eclipse.emf.common.util.URI) getUnderlyingDataModel().getProperty(
				IMoveDMOChangeProperties.DESTINATION);
	}

	/**
	 * Determine if the Destination property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Destination
	 *         property is valid.
	 * @see #getDestination()
	 * @see #setDestination(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDestination() {
		return getUnderlyingDataModel().validateProperty(IMoveDMOChangeProperties.DESTINATION);
	}

	/**
	 * Determine the default value of the Destination property.
	 * 
	 * @return The default value of the Destination property.
	 * @see #getDestination()
	 * @see #setDestination(org.eclipse.emf.common.util.URI)
	 * @generated (mde.utilities.datamodels)
	 */
	public org.eclipse.emf.common.util.URI getDefaultDestination() {
		return (org.eclipse.emf.common.util.URI) getUnderlyingDataModel().getDefaultProperty(
				IMoveDMOChangeProperties.DESTINATION);
	}
}
