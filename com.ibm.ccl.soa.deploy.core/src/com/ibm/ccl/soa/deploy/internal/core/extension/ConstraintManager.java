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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jem.util.RegistryReader;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;

/**
 * Manager for the 'constraints' extension point. Parses the 'constraints' extension point into
 * structures that can be more easily manipulated.
 */
public class ConstraintManager {

	/**
	 * Empty list.
	 */
	private static final List<ConstraintDescriptor> EMPTY_LIST = new ArrayList<ConstraintDescriptor>();

	/**
	 * List of all valid constraint descriptors.
	 */
	private final List<ConstraintDescriptor> constraintDescriptorList = new ArrayList<ConstraintDescriptor>();

	/**
	 * Maps the constraint ID (String) to a the constraint descriptor.
	 */
	private final Map<String, ConstraintDescriptor> globalIdToConstraintDescriptorMap = new ConcurrentHashMap<String, ConstraintDescriptor>();

	/**
	 * Maps the constraint type (String) to a List the constraint descriptors.
	 */
	private final Map<ConstraintTypeKey, List<ConstraintDescriptor>> constraintToDescriptorListMap = new ConcurrentHashMap<ConstraintTypeKey, List<ConstraintDescriptor>>();

	/**
	 * We initialize the instance up front to force the read of the registry in the constructor and
	 * therefore avoid any potential concurrency issues.
	 */
	public static final ConstraintManager INSTANCE = new ConstraintManager();

	private ConstraintManager() {
		ConstraintRegistry registry = new ConstraintRegistry();
		registry.readRegistry();
	}

	/**
	 * @param id
	 *           ID of the constraint definition
	 * 
	 * @return constraint descriptor, or NULL, if none is found
	 */
	public ConstraintDescriptor getConstraintDescriptor(String id) {
		return globalIdToConstraintDescriptorMap.get(id);
	}

	/**
	 * @return array of the constraint descriptors
	 */
	public List<ConstraintDescriptor> getAllConstraintDescriptors() {
		return constraintDescriptorList;
	}

	/**
	 * Returns the list of constraint descriptors for the specified constraint type.
	 * 
	 * @param namespace
	 *           constraint EMF package namespace
	 * @param type
	 *           constraint type (XML complex type name)
	 * @return the list of descriptors
	 */
	public List<ConstraintDescriptor> getConstraintDescriptorListForType(String namespace,
			String type) {
		ConstraintTypeKey key = new ConstraintTypeKey(namespace, type);

		if (constraintToDescriptorListMap.containsKey(key)) {
			return constraintToDescriptorListMap.get(key);
		}
		return EMPTY_LIST;
	}

	/**
	 * Add a constraint descriptor.
	 * 
	 * @param descriptor
	 *           constraint descriptor
	 */
	private boolean addConstraintDescriptor(ConstraintDescriptor descriptor) {
		Assert.isNotNull(descriptor);

		String globalId = descriptor.getId();
		if (globalIdToConstraintDescriptorMap.containsKey(globalId)) {
			ConstraintDescriptor existing = globalIdToConstraintDescriptorMap.get(globalId);
			String message = NLS.bind(
					DeployCoreMessages.ConstraintManager_Duplicate_IDs_found_0_and_1, new Object[] {
							existing.getElement().getDeclaringExtension().getUniqueIdentifier(),
							descriptor.getElement().getDeclaringExtension().getUniqueIdentifier() });
			DeployCorePlugin.logError(0, message, null);
			return false;
		}
		constraintDescriptorList.add(descriptor);
		globalIdToConstraintDescriptorMap.put(globalId, descriptor);

		ConstraintTypeKey key = new ConstraintTypeKey(descriptor.getNamespace(), descriptor.getType());
		List<ConstraintDescriptor> list;
		if (constraintToDescriptorListMap.containsKey(key)) {
			list = constraintToDescriptorListMap.get(key);
		} else {
			list = new ArrayList<ConstraintDescriptor>();
			constraintToDescriptorListMap.put(key, list);
		}
		list.add(descriptor);

		return true;
	}

	/**
	 * Registry reader filtering constraints extension declarations.
	 */
	private class ConstraintRegistry extends RegistryReader implements
			ICommonDeployExtensionConstants {

		private ConstraintRegistry() {
			super(DeployCorePlugin.PLUGIN_ID, TAG_CONSTRAINTS);
		}

		public boolean readElement(IConfigurationElement element) {
			if (TAG_CONSTRAINT.equals(element.getName())) {
				ConstraintDescriptor descriptor = new ConstraintDescriptor(element);
				return addConstraintDescriptor(descriptor);
			}
			return false;
		}
	}

	/**
	 * Key to identify constraint type: EMF package namespace and type name.
	 */
	private static class ConstraintTypeKey {
		private final String _namespace;
		private final String _type;

		/**
		 * Public constructor.
		 * 
		 * @param _n
		 * @param _t
		 */
		public ConstraintTypeKey(String _n, String _t) {
			_namespace = _n;
			_type = _t;
		}

		/**
		 * @return namespace
		 */
		public String getNamespace() {
			return _namespace;
		}

		/**
		 * @return type
		 */
		public String getType() {
			return _type;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (_namespace == null ? 0 : _namespace.hashCode());
			result = prime * result + (_type == null ? 0 : _type.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof ConstraintTypeKey)) {
				return false;
			}
			final ConstraintTypeKey other = (ConstraintTypeKey) obj;
			if (_namespace == null) {
				if (other._namespace != null) {
					return false;
				}
			} else if (!_namespace.equals(other._namespace)) {
				return false;
			}
			if (_type == null) {
				if (other._type != null) {
					return false;
				}
			} else if (!_type.equals(other._type)) {
				return false;
			}
			return true;
		}
	}

	/**
	 * Key to identify constraint instance: EMF package namespace, constraint (XML) type name, and
	 * factory used for constraint instance creation.
	 */
	public static class ConstraintInstanceKey {

		private final String _namespace;
		private final String _type;
		private final String _factory;

		/**
		 * Public constructor.
		 * 
		 * @param cd
		 *           constraint descriptor
		 */
		public ConstraintInstanceKey(ConstraintDescriptor cd) {
			_factory = cd.getFactoryClassName();
			_namespace = cd.getNamespace();
			_type = cd.getType();
		}

		/**
		 * @return Returns the _namespace.
		 */
		public String get_namespace() {
			return _namespace;
		}

		/**
		 * @return Returns the _type.
		 */
		public String get_type() {
			return _type;
		}

		/**
		 * @return Returns the _factory.
		 */
		public String get_factory() {
			return _factory;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (_factory == null ? 0 : _factory.hashCode());
			result = prime * result + (_namespace == null ? 0 : _namespace.hashCode());
			result = prime * result + (_type == null ? 0 : _type.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof ConstraintInstanceKey)) {
				return false;
			}
			ConstraintInstanceKey other = (ConstraintInstanceKey) obj;
			if (_factory == null) {
				if (other._factory != null) {
					return false;
				}
			} else if (!_factory.equals(other._factory)) {
				return false;
			}
			if (_namespace == null) {
				if (other._namespace != null) {
					return false;
				}
			} else if (!_namespace.equals(other._namespace)) {
				return false;
			}
			if (_type == null) {
				if (other._type != null) {
					return false;
				}
			} else if (!_type.equals(other._type)) {
				return false;
			}
			return true;
		}
	}

}
