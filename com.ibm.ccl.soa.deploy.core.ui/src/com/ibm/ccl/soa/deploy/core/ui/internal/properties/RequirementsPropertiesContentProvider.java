/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Tree;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.comparator.DeployModelObjectComparator;

/**
 * @author daberg
 * 
 * <p>
 * Create the {@link Requirement} contents for a {@link Unit} in a {@link Tree}.
 * </p>
 * 
 */
public class RequirementsPropertiesContentProvider implements ITreeContentProvider {

	private final Object[] emptyResults = new Object[0];
	private final boolean showGroups = true;

	protected static final class RequirementGroup extends ArrayList<Requirement> {
		private static final long serialVersionUID = 1L;
		private final Unit parentUnit;
		private final RequirementLinkTypes linkType;

		private RequirementGroup(Unit parentUnit, RequirementLinkTypes linkType) {
			super();
			this.parentUnit = parentUnit;
			this.linkType = linkType;
		}

		private RequirementGroup(Unit parentUnit, int size, RequirementLinkTypes linkType) {
			super(size);
			this.parentUnit = parentUnit;
			this.linkType = linkType;
		}

		protected Unit getParent() {
			return parentUnit;
		}

		protected boolean isMember() {
			return RequirementLinkTypes.MEMBER_LITERAL == linkType;
		}

	}

	/**
	 * Default constructor.
	 */
	public RequirementsPropertiesContentProvider() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parentElement) {
		Object[] result = emptyResults;
		if (parentElement != null) {
			if (parentElement instanceof Reference) {
				Reference ref = (Reference) parentElement;
				Interface refInterface = ref.getInterface();
				if (refInterface == null) {
					//Create unset interface object.
					UnsetInterface unset = new UnsetInterface(ref);
					unset.setReference(true);
					result = new Object[] { unset };
				} else {
					result = new Object[] { refInterface };
				}
			} else if (parentElement instanceof RequirementGroup) {
				result = ((RequirementGroup) parentElement).toArray();
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		if (element != null) {
			if (element instanceof UnsetInterface) {
				return ((UnsetInterface) element).getParent();
			}
			if (element instanceof RequirementGroup) {
				return ((RequirementGroup) element).getParent();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		return element != null
				&& (element instanceof Reference || element instanceof RequirementGroup);
	}

	/*
	 * Gather the Requirements for a passed Unit. Ensure the Hosting requirements are grouped
	 * separately from all other requirements.
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public Object[] getElements(Object inputElement) {
		Object[] result = emptyResults;
		if (inputElement != null && inputElement instanceof Unit) {
			Unit parentUnit = (Unit) inputElement;
			boolean isImport = parentUnit.getTopology() != parentUnit.getEditTopology();
			List<Requirement> requirementsList = parentUnit.getRequirements();
			if (!requirementsList.isEmpty()) {
				List<Requirement> dependencyList = new ArrayList<Requirement>();
				Requirement hostReq = null;
				List<Requirement> hostingList = null;
				RequirementGroup members = null;
				//Filter out hosting.
				for (Iterator<Requirement> it = requirementsList.iterator(); it.hasNext();) {
					Requirement req = it.next();
					//Filter requirements from an import that are not public.
					if (!isImport || req.isPublic()) {
						switch (req.getLinkType().getValue())
						{
						case RequirementLinkTypes.HOSTING:
							if (hostReq == null) {
								hostReq = req;
							} else {
								if (hostingList == null) {
									hostingList = new ArrayList<Requirement>();
									hostingList.add(hostReq);
								}
								hostingList.add(req);
							}
							break;
						case RequirementLinkTypes.MEMBER:
							if (members == null) {
								members = new RequirementGroup(parentUnit,
										RequirementLinkTypes.MEMBER_LITERAL);
							}
							members.add(req);
							break;
						default:
							dependencyList.add(req);
						}
					}
				}
				//Sort
				Comparator<DeployModelObject> dmoComparator = new DeployModelObjectComparator();
				Collections.sort(dependencyList, dmoComparator);
				if (hostingList != null) {
					Collections.sort(hostingList, dmoComparator);
				}
				int resultSize = dependencyList.size();
				if (hostingList != null) {
					resultSize = resultSize + hostingList.size();
				} else if (hostReq != null) {
					resultSize++;
				}
				if (members != null) {
					resultSize++;
				}
				result = new Object[resultSize];
				dependencyList.toArray(result);
				int index = dependencyList.size();
				if (members != null) {
					result[index] = members;
					index++;
				}
				if (hostingList != null) {
					for (int i = 0; i < hostingList.size(); i++) {
						result[index] = hostingList.get(i);
						index++;
					}
				} else if (hostReq != null) {
					result[index] = hostReq;
				}
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//Nothing to do at this time.
	}

}
