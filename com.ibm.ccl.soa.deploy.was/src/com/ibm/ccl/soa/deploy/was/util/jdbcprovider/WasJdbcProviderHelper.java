/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.util.jdbcprovider;

import java.util.HashMap;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;

/**
 * Registry of known provider definitions that can be used to obtain expected values for various
 * fields, to create providers, and to set a providers values.
 */
public class WasJdbcProviderHelper {

	/** The singleton instance of this class */
	public static final WasJdbcProviderHelper INSTANCE = new WasJdbcProviderHelper();

	/** implementation name to definition map */
	protected final Map definitionByImplementation;

	/** provider definitons by provider type map */
	protected final Map definitionByProviderType;

	/** default provider unit template id */
	public static final String DEFAULT_JDBC_PROVIDER_TEMPLATE = "was.DB2JdbcProviderUnit"; //$NON-NLS-1$

	protected static final String UNKNOWN_PROVIDER_TYPE = "Unknown Provider Type"; //$NON-NLS-1$

	/** private constructor to make this a singleton class */
	private WasJdbcProviderHelper() {
		definitionByImplementation = new HashMap();
		definitionByProviderType = new HashMap();
		registerProviderDefinition(new WasDb2UniversalProviderDefinition());
		registerProviderDefinition(new WasDb2UniversalProviderXADefinition());
		registerProviderDefinition(new WasDb2LegacyCLIType2ProviderDefinition());
		registerProviderDefinition(new WasDb2LegacyCLIType2ProviderXADefinition());
	}

	/**
	 * Registers a provider definition
	 * 
	 * @param definition
	 *           the definition
	 */
	public void registerProviderDefinition(IWasJdbcProviderDefinition definition) {
		String className = definition.getExpectedImplementationClass();
		if (null != className) {
			definitionByImplementation.put(className, definition);
		}
		String providerType = definition.getProviderTypeAsString();
		if (null != providerType) {
			definitionByProviderType.put(providerType, definition);
		}
	}

	/**
	 * Create a new {@link JdbcProviderUnit} given an implementation class name. If no definition can
	 * be found, a default provider is created using template {@link DEFAULT_JDBC_PROVIDER_TEMPLATE}.
	 * The provider created is NOT in any topology. Note that while many fields will represent their
	 * final values the path fields (classpath and nativepath) will not. They can only be set
	 * correctly in context of a deployment.
	 * 
	 * @param implementationClassName
	 *           the class name of the provider unit.
	 * @return the provider unit
	 */
	public JdbcProviderUnit createProviderUnit(String implementationClassName) {
		return createProviderUnit(implementationClassName, null);
	}

	/**
	 * Create a new {@link JdbcProviderUnit} given an implementation class name. If no definition can
	 * be found, a default provider is created using template {@link DEFAULT_JDBC_PROVIDER_TEMPLATE}.
	 * The provider created is added to the specified topolgoy. Note that while many fields will
	 * represent their final values the path fields (classpath and nativepath) will not. They can
	 * only be set correctly in context of a deployment.
	 * 
	 * @param implementationClassName
	 *           the class name of the provider unit.
	 * @param topology
	 *           the topology to which the created unit should be added
	 * @return the provider unit
	 */
	public JdbcProviderUnit createProviderUnit(String implementationClassName, Topology topology) {
		String templateId = getTemplateId(implementationClassName);
		if (null == templateId) {
			templateId = DEFAULT_JDBC_PROVIDER_TEMPLATE;
		}

		JdbcProviderUnit providerUnit = (JdbcProviderUnit) ResolutionUtils.addFromTemplate(
				templateId, topology);
		return providerUnit;
	}

	/**
	 * Set the variables to the expected values for a given provider type. The provider type to use
	 * is determined using the following rules:
	 * <ol>
	 * <li>if provider type is set, this is used to determine what default values to use</li>
	 * <li>if the provider type is not set, the implementation class name is used as a key</li>
	 * </ol>
	 * <p>
	 * If the provider type cannot be determined, no change to the unit is made.
	 * 
	 * @param providerUnit
	 *           the starting provider unit
	 * @return true if the provider type was identified and changes were made; false otherwise
	 */
	public boolean setProviderDetails(JdbcProviderUnit providerUnit) {
		IWasJdbcProviderDefinition definition = getDefinition(providerUnit);
		if (null == definition) {
			return false;
		}
		definition.defineProvider(providerUnit, null);
		return true;
	}

	/**
	 * Set the variables of a provider to the expected values for a given provider type. The provider
	 * type is determined using the user specified preferences and the following rules:
	 * <p>
	 * If the provider type cannot be determined, no change to the unit is made.
	 * <p>
	 * 
	 * @param providerUnit
	 *           the starting provider unit
	 * @param preferences
	 *           the user preferences
	 * @return true if the provider type was identified and changes were made; false otherwise
	 */
	public boolean setProviderDetails(JdbcProviderUnit providerUnit,
			JdbcProviderPreferences preferences) {
		IWasJdbcProviderDefinition definition = getDefinition(preferences);
		if (null == definition) {
			return false;
		}
		definition.defineProvider(providerUnit, null);
		return true;
	}

	/**
	 * Set the provider classpath and nativepath attributes
	 * 
	 * @param providerUnit
	 *           the provider unit
	 */
	public void setProviderPaths(JdbcProviderUnit providerUnit) {
		JdbcProvider provider = getProvider(providerUnit);
		provider.setClasspath(getExpectedClasspath(providerUnit));
		provider.setNativepath(getExpectedNativepath(providerUnit));
	}

	/**
	 * Set the provider classpath and nativepath attributes
	 * 
	 * @param providerUnit
	 *           the provider unit
	 * @param driver
	 *           a database driver if known
	 */
	public void setProviderPaths(JdbcProviderUnit providerUnit, DB2JdbcDriver driver) {
		JdbcProvider provider = getProvider(providerUnit);
		provider.setClasspath(getExpectedClasspath(providerUnit, driver));
		provider.setNativepath(getExpectedNativepath(providerUnit));
	}

	/**
	 * Get the expected value of the classpath for the provider unit, if it can be determined. If the
	 * provider unit is hosted the hosting context is taken into account.
	 * 
	 * @param providerUnit
	 *           the JDBC provider unit
	 * @return the expected classpath, or null if not known.
	 */
	public String getExpectedClasspath(JdbcProviderUnit providerUnit) {
		return getExpectedClasspath(providerUnit, null);
	}

	/**
	 * Get the expected value of the classpath for the provider unit, if it can be determined. If the
	 * provider unit is hosted the hosting context is taken into account. Further, if a (local) DB2
	 * database driver is known, it is also taken into account.
	 * 
	 * @param providerUnit
	 *           the JDBC provider unit
	 * @param driver
	 *           the DB2 JDBC driver (capability)
	 * @return the expected classpath, or null if not known.
	 */
	public String getExpectedClasspath(JdbcProviderUnit providerUnit, DB2JdbcDriver driver) {
		IWasJdbcProviderDefinition definition = getDefinition(providerUnit);
		if (null != definition) {
			JdbcProvider provider = getProvider(providerUnit);
			Unit wasUnit = TopologyDiscovererService.INSTANCE.findHost(providerUnit, providerUnit
					.getTopology());
			WebsphereContext wasContext = new WebsphereContext(wasUnit);
			return definition.getExpectedClassPath(provider, wasContext, driver);
		}
		return null;
	}

	/**
	 * Get the expected value of the nativepath for a provider, if it can be determined. If the
	 * provider unit is hosted, the hosting context is taken into account.
	 * 
	 * @param providerUnit
	 *           the JDBC provider unit
	 * @return the expected nativepath, or null if not known
	 */
	public String getExpectedNativepath(JdbcProviderUnit providerUnit) {
		IWasJdbcProviderDefinition definition = getDefinition(providerUnit);
		if (null != definition) {
			JdbcProvider provider = getProvider(providerUnit);
			Unit wasUnit = TopologyDiscovererService.INSTANCE.findHost(providerUnit, providerUnit
					.getTopology());
			WebsphereContext wasContext = new WebsphereContext(wasUnit);
			return definition.getExpectedNativepath(provider, wasContext);
		}
		return null;
	}

	/**
	 * Get the expected name of the implementation class. This method relies on a provider type to
	 * determine. If the provider type is not set, then the expected implementation class will be
	 * whatever the current value of the implementation class name attribute.
	 * 
	 * @param providerUnit
	 *           the JDBC provider unit
	 * @return the expected implementation class name
	 */
	public String getExpectedImplementationClassName(JdbcProviderUnit providerUnit) {
		IWasJdbcProviderDefinition definition = getDefinition(providerUnit);
		if (null != definition) {
			return definition.getExpectedImplementationClass();
		}
		return null;
	}

	/**
	 * Get the expected provider type as a String. This method uses the provider type as a key to
	 * find the defintion. If not set (the usual case when using this method), the implementation
	 * class name is used as a key.
	 * 
	 * @param providerUnit
	 *           the JDBC provider unit
	 * @return the provider type as a String
	 */
	public String getExpectedProviderType(JdbcProviderUnit providerUnit) {
		IWasJdbcProviderDefinition definition = getDefinition(providerUnit);
		if (null != definition) {
			return definition.getProviderTypeAsString();
		}
		return null;
	}

	/**
	 * Identify a template id that can be used to create a {@link JdbcProviderUnit}.
	 * 
	 * @param implementationClassName
	 *           the implementation class name
	 * @return the template id; if no known template can be found,
	 *         {@link DEFAULT_JDBC_PROVIDER_TEMPLATE} is returned.
	 */
	public String getTemplateId(String implementationClassName) {
		IWasJdbcProviderDefinition definition = getDefinition(implementationClassName);
		if (null == definition) {
			return DEFAULT_JDBC_PROVIDER_TEMPLATE;
		}

		return definition.getTemplateId();
	}

	/**
	 * Identify a template id that can be used to create a {@link JdbcProviderUnit}
	 * 
	 * @param preferences
	 *           user provider preferences
	 * @return the template id; if no known template can be found,
	 *         {@link DEFAULT_JDBC_PROVIDER_TEMPLATE} is returned.
	 */
	public String getTemplateId(JdbcProviderPreferences preferences) {
		if (null == preferences) {
			return DEFAULT_JDBC_PROVIDER_TEMPLATE;
		}

		IWasJdbcProviderDefinition definition = getDefinition(preferences);
		if (null == definition) {
			return DEFAULT_JDBC_PROVIDER_TEMPLATE;
		}

		return definition.getTemplateId();
	}

	/**
	 * Identify a provider type from its provider preferences.
	 * 
	 * @param preferences
	 *           user provider preferences
	 * @return the provider type as a string; if no known type can be found,
	 *         {@link UNKNOWN_PROVIDER_TYPE} is returned.
	 */
	public String getProviderTypeAsString(JdbcProviderPreferences preferences) {
		IWasJdbcProviderDefinition definition = getDefinition(preferences);
		if (null == definition) {
			return UNKNOWN_PROVIDER_TYPE;
		}

		return definition.getProviderTypeAsString();
	}

	public Boolean providesXA(String implementationClassName) {
		IWasJdbcProviderDefinition definition = getDefinition(implementationClassName);
		// for now this is a hack
		if (null == definition) {
			return null;
		}
		return new Boolean(definition.getProviderTypeAsString().indexOf("(XA)") > -1); //$NON-NLS-1$
	}

	private IWasJdbcProviderDefinition getDefinition(JdbcProviderUnit providerUnit) {
		IWasJdbcProviderDefinition definition = null;
		JdbcProvider provider = getProvider(providerUnit);

		// try first by provider type; this is database type specific and is
		// restricted by an ennumeration. Consequently, it is harder to change
		// by mistake. However, it may not be set.
		String providerType = null;
		if (provider instanceof DB2JdbcProvider) {
			providerType = ((DB2JdbcProvider) provider).getTemplate().toString();
		} else {
			// handle other types of providers
		}
		if (null != providerType) {
			definition = (IWasJdbcProviderDefinition) definitionByProviderType.get(providerType);
		}

		// next try using the implementation class as a key. It should also be
		// unique.
		if (null == definition) {
			String implementationClassname = provider.getImplementationClassName();
			if (null != implementationClassname) {
				definition = (IWasJdbcProviderDefinition) definitionByImplementation
						.get(implementationClassname);
			}
		}

		return definition;
	}

	private IWasJdbcProviderDefinition getDefinition(String implementationClassName) {
		return (IWasJdbcProviderDefinition) definitionByImplementation.get(implementationClassName);
	}

	private IWasJdbcProviderDefinition getDefinition(JdbcProviderPreferences preferences) {
		IWasJdbcProviderDefinition definition = null;

		String key = null;
		// DB2 provider types
		if (Db2Package.Literals.DB2_DATABASE.isSuperTypeOf(preferences.getDbType())) {
			if (JdbcTypeType._4_LITERAL.equals(preferences.getJdbcType())) {
				Boolean XA = preferences.isXARequired();
				if (XA != null && XA.booleanValue()) {
					key = DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL.toString();
				} else {
					key = DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL.toString();
				}
			} else if (JdbcTypeType._2_LITERAL.equals(preferences.getJdbcType())) {
				Boolean XA = preferences.isXARequired();
				if (null == preferences.getTag()
						|| preferences.getTag().indexOf(
								(new WasDb2UniversalProviderDefinition()).getProviderTypeAsString()) != -1) {
					if (XA != null && XA.booleanValue()) {
						key = DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL
								.toString();
					} else {
						key = DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL.toString();
					}
				} else {
					if (XA != null && XA.booleanValue()) {
						key = DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA_LITERAL
								.toString();
					} else {
						key = DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
								.toString();
					}
				}
			}
		} else {
			// handle other database types
		}

		if (null != key) {
			definition = (IWasJdbcProviderDefinition) definitionByProviderType.get(key);
		}

		return definition;
	}

	private JdbcProvider getProvider(JdbcProviderUnit providerUnit) {
		return (JdbcProvider) ValidatorUtils.getFirstCapability(providerUnit,
				JavaPackage.Literals.JDBC_PROVIDER);
	}

	public static IWasJdbcProviderDefinition db2LegacyDefinition = new WasDb2LegacyCLIType2ProviderDefinition();
	public static IWasJdbcProviderDefinition db2LegacyXADefinition = new WasDb2LegacyCLIType2ProviderXADefinition();
	public static IWasJdbcProviderDefinition db2UniversalDefinition = new WasDb2UniversalProviderDefinition();
	public static IWasJdbcProviderDefinition db2UniversalXADefinition = new WasDb2UniversalProviderXADefinition();
}
