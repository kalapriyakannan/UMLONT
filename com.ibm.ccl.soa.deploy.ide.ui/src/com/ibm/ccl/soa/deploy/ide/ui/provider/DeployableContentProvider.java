/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitProviderDescriptor;

public class DeployableContentProvider implements IStructuredContentProvider {

	public Object[] getElements(Object inputElement) {
		List result = new ArrayList();
		/*
		 * if(inputElement instanceof IDataModel){ return (Object[] )
		 * ((IDataModel)inputElement).getProperty(ITopologyDiscoveryProperties.SELECTED_ITEMS);
		 */
		IProject[] projects = ProjectUtilities.getAllProjects();
		for (int i = 0; projects != null && i < projects.length; i++) {
			if (hasDeployables(projects[i])) {
				result.add(projects[i]);
				//TODO	result.addAll(findAllFileDeployable(projects[i]));
			}
		}
		return result.toArray();
	}

	private Collection findAllFileDeployable(IProject project) {
		List result = new ArrayList();
		List files = ProjectUtilities.getAllProjectFiles(project);
		for (int i = 0; files != null && i < files.size(); i++) {
			IFile file = (IFile) files.get(0);
			if (hasDeployables(file)) {
				result.add(file);
			}
		}
		return result;
	}

	/*
	 * private Object[] getUnitProviders(Object inputElement) { int totalDescriptorSize = 0; List
	 * descriptorList = new ArrayList(); if (inputElement instanceof Object) { IProject[] projects =
	 * ProjectUtilities.getAllProjects(); for (int i = 0; i < projects.length; i++) { IProject
	 * project = projects[i]; UnitProviderDescriptor[] descriptors = getDeployables(project);
	 * descriptorList.add(descriptors); totalDescriptorSize = descriptors.length +
	 * totalDescriptorSize; } return combineUnitProviderDescriptors(descriptorList,
	 * totalDescriptorSize); } return null;
	 *  }
	 */

	/*
	 * private UnitProviderDescriptor[] getDeployables(IProject project) { // TODO Auto-generated
	 * method stub return null; }
	 */

	/*
	 * private Object[] combineUnitProviderDescriptors(List descriptorList, int totalDescriptorSize) {
	 * UnitProviderDescriptor[] combinedDescriptors = new
	 * UnitProviderDescriptor[totalDescriptorSize]; int items = 0; for (int i = 0; i <
	 * descriptorList.size(); i++) { UnitProviderDescriptor[] descriptors =
	 * (UnitProviderDescriptor[]) descriptorList.get(i); System.arraycopy(descriptors, 0,
	 * combinedDescriptors, items, Math.min(totalDescriptorSize, descriptors.length)); items +=
	 * descriptors.length; } return combinedDescriptors; }
	 */

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	private boolean hasDeployables(IProject project) {
		if (!project.isAccessible())
			return false;
		UnitProviderDescriptor[] unitProviders = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitProvidersByInputOnly(project);
		return unitProviders.length > 0;
	}

	private boolean hasDeployables(IFile file) {
		if (!file.isAccessible())
			return false;
		UnitProviderDescriptor[] unitProviders = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitProvidersByInputOnly(file);
		return unitProviders.length > 0;
	}
}
