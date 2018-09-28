/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jst.j2ee.common.JNDIEnvRefsGroup;
import org.eclipse.jst.j2ee.common.ResourceRef;
import org.eclipse.jst.j2ee.commonarchivecore.internal.Archive;
import org.eclipse.jst.j2ee.commonarchivecore.internal.util.ArchiveUtil;
import org.eclipse.jst.j2ee.ejb.ContainerManagedEntity;
import org.eclipse.jst.j2ee.ejb.EJBJar;
import org.eclipse.jst.j2ee.ejb.EnterpriseBean;
import org.eclipse.jst.j2ee.webapplication.WebApp;
import org.eclipse.wst.common.componentcore.internal.util.ComponentUtilities;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;

public class DatasourceProvider extends J2EEModuleCapabilityProvider {

	private static final String DATA_SOURCE = "javax.sql.DataSource"; //$NON-NLS-1$

	public Object[] resolveCapabilities(Object anObject) {
		return NO_CAPS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.CapabilityProvider#resolveRequirements(java.lang.Object,
	 *      com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Object[] resolveRequirements(Object anObject, Unit aUnit) {

		List references = new ArrayList();

		if (anObject instanceof JNDIEnvRefsGroup) {
			JNDIEnvRefsGroup referenceGroup = (JNDIEnvRefsGroup) anObject;
			EList resourceRefs = referenceGroup.getResourceRefs();
			for (Iterator iter = resourceRefs.iterator(); iter.hasNext();) {
				ResourceRef ref = (ResourceRef) iter.next();

				if (DATA_SOURCE.equals(ref.getType())) {
					String refName = ref.getName();
					references
							.addAll(createDataSourceRequirement(aUnit, fixupName(refName), null, false));
				}
			}
		} else if (anObject instanceof EJBJar) {
			resolveRequirements((EJBJar) anObject, aUnit, references);
		} else if (anObject instanceof WebApp) {
			resolveRequirements((WebApp) anObject, aUnit, references);
		}
		if (references.size() > 0) {
			return references.toArray(new Requirement[references.size()]);
		}
		return NO_REQS;
	}

	/*
	 * Setup the DataSource Requiement from resource refs found on EnterpriseBeans as well as a
	 * default DataSource requirement for CMP beans. This method will also create a logical
	 * requirement for any DataSource requirements it creates and will set the physical requirement
	 * for the datasource.
	 */
	private void resolveRequirements(EJBJar ejbJar, Unit unit, List references) {
		Set datasourceKeys = new HashSet();

		List beans = ejbJar.getEnterpriseBeans();
		if (!beans.isEmpty()) {
			for (int i = 0; i < beans.size(); i++) {
				EnterpriseBean bean = (EnterpriseBean) beans.get(i);
				if (bean.isContainerManagedEntity()) {
					String jndiName = getJNDINameForDefaultDataSource((ContainerManagedEntity) bean);
					Object key = null == jndiName ? new Object() : jndiName;
					if (jndiName != null && !datasourceKeys.contains(key)) {
						datasourceKeys.add(key);
						references.addAll(createDataSourceRequirement(unit, fixupName(jndiName), null,
								true));
					}
				} else {
					List refs = bean.getResourceRefs();
					if (!refs.isEmpty()) {
						for (int k = 0; k < refs.size(); k++) {
							ResourceRef ref = (ResourceRef) refs.get(k);
							if (DATA_SOURCE.equals(ref.getType())) {
								String jndiName = getJNDINameForRef(bean, (ResourceRef) refs.get(k));
								Object key = null == jndiName ? new Object() : jndiName;
								if (jndiName != null && !datasourceKeys.contains(key)) {
									datasourceKeys.add(key);
									references.addAll(createDataSourceRequirement(unit, fixupName(jndiName),
											null, false));
								}
							}
						}
					}
				}
			}
		}
	}

	protected void resolveRequirements(WebApp webApp, Unit unit, List requirements) {
		Set datasourceKeys = new HashSet();
		List refs = webApp.getResourceRefs();
		for (int j = 0; j < refs.size(); j++) {
			ResourceRef ref = (ResourceRef) refs.get(j);
			if (!checkForSQLType(ref)) {
				continue;
			}
			String jndiName = getJNDINameForRef(webApp, ref);
			Object key = null == jndiName ? new Object() : jndiName;
			if (jndiName != null && !datasourceKeys.contains(key)) {
				datasourceKeys.add(key);
				requirements
						.addAll(createDataSourceRequirement(unit, fixupName(jndiName), null, false));
			}
		}
	}

	private String getJNDINameForDefaultDataSource(ContainerManagedEntity bean) {
		EJBJar jar = (EJBJar) bean.eContainer();
		String defaultName = jar.getDisplayName();
		if (defaultName == null) {
			IVirtualComponent component = ComponentUtilities.findComponent(jar);
			if (component != null) {
				defaultName = component.getName();
			} else {
				Archive archive = ArchiveUtil.getArchive(jar.eResource());
				if (archive != null) {
					defaultName = archive.getName();
				}
			}
		}
		if (defaultName != null) {
			defaultName = "jdbc/" + removeFileNameExtension(defaultName); //$NON-NLS-1$
		}
		return defaultName;
	}

	private String getJNDINameForRef(EnterpriseBean bean, ResourceRef resourceRef) {
		return resourceRef.getName();
	}

	private String getJNDINameForRef(WebApp webApp, ResourceRef resourceRef) {
		return resourceRef.getName();
	}
}
