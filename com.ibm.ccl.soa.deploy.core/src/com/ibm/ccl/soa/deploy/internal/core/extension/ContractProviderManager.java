/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.ibm.ccl.soa.deploy.core.ContractProvider;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.ExplicitContractProvider;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.IdentityContractProvider;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.NullContractProvider;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.PublicEditableContractProvider;

/**
 * 
 * Provides a factory that can create subtypes of {@link ContractProvider} in order to configure new
 * {@link Topology topologies}.
 * 
 * @since 1.0
 * 
 */
public class ContractProviderManager {

	public static final ContractProviderManager INSTANCE = new ContractProviderManager();

	private static final Map<String, ContractProviderDescriptor> descriptors = new LinkedHashMap<String, ContractProviderDescriptor>();

	static {

		ContractProviderDescriptor descriptor = null;

		descriptors.put(IdentityContractProvider.ID, descriptor = new ContractProviderDescriptor(
				DeployCoreMessages.ContractProviderManager_Make_All_Units_Public_By_Defaul_,
				IdentityContractProvider.class));
		descriptors.put(descriptor.getDisplayName(), descriptor);

		descriptors.put(NullContractProvider.ID, descriptor = new ContractProviderDescriptor(
				DeployCoreMessages.ContractProviderManager_Make_All_Units_Public_Editable_By_D_,
				PublicEditableContractProvider.class));
		descriptors.put(descriptor.getDisplayName(), descriptor);

		descriptors.put(ExplicitContractProvider.ID, descriptor = new ContractProviderDescriptor(
				DeployCoreMessages.ContractProviderManager_Make_Conceptual_Units_Public_By_Def_,
				ExplicitContractProvider.class));
		descriptors.put(descriptor.getDisplayName(), descriptor);

		descriptors.put(NullContractProvider.ID, descriptor = new ContractProviderDescriptor(
				DeployCoreMessages.ContractProviderManager_Make_All_Units_Private_By_Defaul_,
				NullContractProvider.class));
		descriptors.put(descriptor.getDisplayName(), descriptor);

	}

	/**
	 * 
	 * Returns the singleton instance of this factory.
	 * 
	 * @return
	 */
	public static ContractProviderManager getInstance() {
		return INSTANCE;
	}

	/**
	 * Create a provider given the identifier.
	 * 
	 * @param id
	 *           The fully qualified name of the corresponding model type (e.g.
	 *           IdentityContract.class.getCanonicalName()) or the display name (e.g. "Identity
	 *           Contract").
	 * @return The ContractProvider found for the associated id or a ContractProvider that will
	 *         create {@link IdentityContract}.
	 */
	public ContractProvider createProvider(String id) {
		// for now the id is the class name 
		ContractProviderDescriptor descriptor = descriptors.get(id);
		ContractProvider provider = descriptor.createProvider();
		provider.setDescriptor(descriptor);
		return provider;
	}

	/**
	 * Create a provider given the identifier.
	 * 
	 * @param id
	 *           The fully qualified name of the corresponding model type (e.g.
	 *           IdentityContract.class.getCanonicalName()).
	 * @return The ContractProvider found for the associated id or a ContractProvider that will
	 *         create {@link IdentityContract}.
	 */
	public ContractProviderDescriptor[] getDescriptors() {
		Collection<ContractProviderDescriptor> values = descriptors.values();
		Set<ContractProviderDescriptor> uniqueValues = new TreeSet<ContractProviderDescriptor>(
				DescriptorComparator.INSTANCE);
		uniqueValues.addAll(values);
		return uniqueValues.toArray(new ContractProviderDescriptor[uniqueValues.size()]);
	}

	public void installContract(String id, Topology topology) {
		ContractProvider provider = createProvider(id);
		provider.installContract(topology);
	}

	private static class DescriptorComparator implements Comparator {

		public static final DescriptorComparator INSTANCE = new DescriptorComparator();

		private final List providers = new ArrayList();

		public DescriptorComparator() {
			providers.add(IdentityContractProvider.class);
			providers.add(ExplicitContractProvider.class);
			providers.add(NullContractProvider.class);
		}

		public int compare(Object o1, Object o2) {
			ContractProviderDescriptor lvalue = null;
			ContractProviderDescriptor rvalue = null;
			if (o1 instanceof ContractProviderDescriptor) {
				lvalue = (ContractProviderDescriptor) o1;
			}
			if (o2 instanceof ContractProviderDescriptor) {
				rvalue = (ContractProviderDescriptor) o2;
			}

			if (lvalue == null || rvalue == null) {
				return 0;
			}

			return providers.indexOf(lvalue.getFactory()) - providers.indexOf(rvalue.getFactory());
		}

	}

}
