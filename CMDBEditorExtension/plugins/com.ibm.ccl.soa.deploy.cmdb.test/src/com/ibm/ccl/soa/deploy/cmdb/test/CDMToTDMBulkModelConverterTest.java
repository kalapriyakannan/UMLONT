/*******************************************************************************
 * Copyright (c) 2005,2006 IBM Corporation
 * Licensed Material - Property of IBM. All rights reserved. 
 * US Government Users Restricted Rights - Use, duplication or disclosure  v1.0
 * restricted by GSA ADP Schedule Contract with IBM Corp. 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.Guid;
import com.collation.platform.model.ModelObject;
import com.collation.platform.model.topology.core.ManagedElement;
import com.collation.platform.model.topology.meta.ObjectClass;
import com.collation.platform.model.topology.process.itil.ConfigurationItem;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <p>
 * Generate schemas representing a 1-1 translation of CDM to the Zephyr
 * Unit/Capability structure, including the class hierarchy. Uses
 * meta-information in CMDB and Java introspection.
 * 
 * @author Bill Arnold
 */
public class CDMToTDMBulkModelConverterTest extends TestCase {

	// TADDM 7.1
	private String taddmServer = "rf18.watson.ibm.com"; //$NON-NLS-1$

	// private String taddmServer = "9.2.85.93"; //$NON-NLS-1$
	// private String taddmServer = "rfvm08.watson.ibm.com"; //$NON-NLS-1$

	private String taddmUserId = "administrator"; //$NON-NLS-1$

	private String taddmUserPw = "collation"; //$NON-NLS-1$

	private static final String GET_PREFIX = "get"; //$NON-NLS-1$

	private static final String BASE_CLASSES_SCHEMA_NAME = "Base";

	private static final Map<String, String> cdmToSchemaTypeMap = new HashMap<String, String>();
	{
		cdmToSchemaTypeMap.put("byte", "type=\"byte\"");
		cdmToSchemaTypeMap.put("double", "type=\"double\"");
		cdmToSchemaTypeMap.put("float", "type=\"float\"");
		cdmToSchemaTypeMap.put("int", "type=\"int\"");
		cdmToSchemaTypeMap.put("boolean", "type=\"boolean\"");
		cdmToSchemaTypeMap.put("java.lang.Boolean", "type=\"boolean\" nillable=\"true\"");
		cdmToSchemaTypeMap.put("java.lang.Byte", "type=\"byte\" nillable=\"true\"");
		cdmToSchemaTypeMap.put("java.lang.Double", "type=\"double\" nillable=\"true\"");
		cdmToSchemaTypeMap.put("java.lang.Float", "type=\"float\" nillable=\"true\"");
		cdmToSchemaTypeMap.put("java.lang.Integer", "type=\"int\" nillable=\"true\"");
		cdmToSchemaTypeMap.put("java.lang.Long", "type=\"long\" nillable=\"true\"");
		cdmToSchemaTypeMap.put("java.lang.Short", "type=\"short\" nillable=\"true\"");
		cdmToSchemaTypeMap.put("java.lang.String", "type=\"string\"");
		cdmToSchemaTypeMap.put("java.math.BigDecimal", "type=\"decimal\"");
		cdmToSchemaTypeMap.put("java.math.BigInteger", "type=\"integer\"");
		cdmToSchemaTypeMap.put("long", "type=\"long\"");
		cdmToSchemaTypeMap.put("short", "type=\"short\"");
	}

	/** Test case ctor */
	public CDMToTDMBulkModelConverterTest() {
		super("CDMToTDMBulkModelConverterTest");
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void testCDMToTDMBulkModelConverter() {
		CmdbQueryService.INSTANCE.setTaddmServer(taddmServer);
		CmdbQueryService.INSTANCE.setTaddmUserId(taddmUserId);
		CmdbQueryService.INSTANCE.setTaddmUserPw(taddmUserPw);
		List<ObjectClass> ocList = new LinkedList<ObjectClass>(Arrays
				.asList(CmdbQueryService.INSTANCE.getAllMetaData()));
		ocList.removeAll(filteredOCList(ocList, "com.collation.platform.model.topology.relation"));

// String filterStrings[] = {
// "com.collation.platform.model.topology.app.db.db2",
// "com.collation.platform.model.topology.app.j2ee.websphere",
// "com.collation.platform.model.topology.app.db.oracle",
// "com.collation.platform.model.topology.phys",
// "com.collation.platform.model.topology.app.j2ee.oracleapp",
// "com.collation.platform.model.topology.app.j2ee.jboss",
// "com.collation.platform.model.workflow",
// "com.collation.platform.model.topology.app.lotus",
// "com.collation.platform.model.provision",
// "com.collation.platform.model.topology.storage",
// "com.collation.platform.model.topology.app.sms",
// "com.collation.platform.model.discovery",
// "com.collation.platform.model.topology.app.j2ee.weblogic",
// // "com.collation.platform.model.topology.process",
// "com.collation.platform.model.topology.app.citrix",
// "com.collation.platform.model.topology.net",
// "com.collation.platform.model.topology.meta",
// "com.collation.platform.model.topology.soa",
// // "com.collation.platform.model.topology.app.web",
// "com.collation.platform.model.topology.app.messaging" };

		String filterStrings[] = {
 "com.collation.platform.model.topology.app.db",
 "com.collation.platform.model.topology.app.j2ee",
 "com.collation.platform.model.topology.sys",
 "com.collation.platform.model.topology.app.web",
 "com.collation.platform.model.topology.app.soa",
 "com.collation.platform.model.topology.app.messaging",
 "com.collation.platform.model.topology.app.citrix",
 "com.collation.platform.model.topology.phys",
 "com.collation.platform.model.topology.net"
		};
// String filterStrings[] = { "com.collation.platform.model.topology" };

		Set<String> baseClassNames = new HashSet<String>();
// Set<String> allClassNames = new HashSet<String>();
		List<Set<String>> filteredOCNamesSetsList = new ArrayList<Set<String>>();
		Map<Set<String>, String> partitionSetToFilterStringMap = new HashMap<Set<String>, String>();
		try {
			// for each filter string
			for (int filterNum = 0; filterNum < filterStrings.length; ++filterNum) {
				// assemble list of classes in full oc list that have full name
				// starting with filter
				List<ObjectClass> filteredOCList = filteredOCList(ocList, filterStrings[filterNum]);
				Set<String> filteredOCNamesSet = new HashSet<String>();
				for (ObjectClass oc : filteredOCList) {
					String cName = oc.getName();
// filteredOCNamesSet.add(oc.getName());
					List<String> moHierarchy = CMDBProviderTestUtils.getMOHierarchy(oc);
					// If it's a Relationship (scattered through the type
					// system) don't include it
					if (moHierarchy.contains("com.collation.platform.model.topology.core.Relationship")) {
						continue;
					}
					// for each class in ModelObject hierarchy for class,
					// add to set if it is in partition
					boolean restToBase = false;
					for (String n : moHierarchy) {
						if (!restToBase && n.startsWith(filterStrings[filterNum])) {
							System.out.println("Adding to set : " + n);
							filteredOCNamesSet.add(n);
						} else {
							System.out.println("Adding to base : " + n);
							baseClassNames.add(n);
							restToBase = true;
						}
// allClassNames.add(n);
					}
				}
				filteredOCNamesSetsList.add(filteredOCNamesSet);
				partitionSetToFilterStringMap.put(filteredOCNamesSet, filterStrings[filterNum]);

				ocList.removeAll(filteredOCList);
				baseClassNames.removeAll(filteredOCNamesSet);
			}
		} catch (AttributeNotSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Now remove dups that are in both base and extensions
		for (Set<String> filteredOCNamesSet : filteredOCNamesSetsList) {
			Set<String> removals = new HashSet<String>();
			for (String filteredOCName : filteredOCNamesSet) {
				if (baseClassNames.contains(filteredOCName)) {
					System.out.println("removing from non-base - " + filteredOCName);
					removals.add(filteredOCName);
				}
			}
			String filter = partitionSetToFilterStringMap.get(filteredOCNamesSet);
			partitionSetToFilterStringMap.remove(filteredOCNamesSet);
			filteredOCNamesSet.removeAll(removals);
			partitionSetToFilterStringMap.put(filteredOCNamesSet, filter);
		}
		// Now move any cross references to base
		Set<String> movesToBase = new HashSet<String>();
		for (Set<String> filteredOCNamesSet : filteredOCNamesSetsList) {
			// Test each set against other sets
			for (Set<String> testFilteredOCNamesSet : filteredOCNamesSetsList) {
				if (filteredOCNamesSet == testFilteredOCNamesSet) {
					continue;
				}
				// For each name in set being tested
				for (String filteredOCName : filteredOCNamesSet) {
					// if name is in another set, mark it for move
					if (testFilteredOCNamesSet.contains(filteredOCName)) {
						System.out.println("name to base: " + filteredOCName);
						movesToBase.add(filteredOCName);
					}
					for (String superName : CMDBProviderTestUtils.getMOHierarchy(filteredOCName)) {
					// if supername is in another set, mark supername for move
//					String superName = CMDBProviderTestUtils.getSuperNameClass(filteredOCName);
					if (testFilteredOCNamesSet.contains(superName)) {
						System.out.println("supername to base: " + filteredOCName + "->" + superName);
						movesToBase.add(superName);
					}
					}
				}
			}
		}
		baseClassNames.addAll(movesToBase);
		for (Set<String> filteredOCNamesSet : filteredOCNamesSetsList) {
			String filter = partitionSetToFilterStringMap.get(filteredOCNamesSet);
			partitionSetToFilterStringMap.remove(filteredOCNamesSet);
			filteredOCNamesSet.removeAll(movesToBase);
			partitionSetToFilterStringMap.put(filteredOCNamesSet, filter);
		}

		filteredOCNamesSetsList.add(baseClassNames);
		partitionSetToFilterStringMap.put(baseClassNames, BASE_CLASSES_SCHEMA_NAME);

		for (Set<String> filteredOCNamesSet : filteredOCNamesSetsList) {
			PrintStream p = printStreamForSchema(partitionSetToFilterStringMap.get(filteredOCNamesSet));
			printSchema(p, partitionSetToFilterStringMap.get(filteredOCNamesSet), BASE_CLASSES_SCHEMA_NAME,
					filteredOCNamesSet, filteredOCNamesSetsList, partitionSetToFilterStringMap, baseClassNames);
		}

// PrintStream p = printStreamForSchema(BASE_CLASSES_SCHEMA_NAME);
// printSchema(p, BASE_CLASSES_SCHEMA_NAME, null, baseClassNames);

// TODO why is this broken?
// assert
// (baseClassNames.remove("com.collation.platform.model.topology.app.web.WebContainer"));
// assert
// (baseClassNames.remove("com.collation.platform.model.topology.app.j2ee.J2EEWebContainer"));
// assert(baseClassNames.contains("com.collation.platform.model.topology.app.web.WebVirtualHost"));
// printSchema(p, BASE_CLASSES_SCHEMA_NAME, null, allClassNames);

	}

	private PrintStream printStreamForSchema(String packageName) {
		PrintStream p = System.out;
		try {
			String schemaName = "cdm" +
					CMDBProviderTestUtils
							.forceFirstCharUpperCase(CMDBProviderTestUtils.lastPackageSegment(packageName));
			OutputStream os;
			os = new FileOutputStream(new File("c:/tmp/xsd/" + schemaName + ".xsd"));
			p = new PrintStream(os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	private void printSchema(PrintStream p, String packageName, String baseClassesPackageName,
			Collection<String> allClassNames, List<Set<String>> partitionedNamesSetsList,
			Map<Set<String>, String> partitionSetToFilterStringMap, Set<String> baseClassNames) {
		String nlsPrefix = CMDBProviderTestUtils.lastPackageSegment(packageName).toLowerCase();
		Set<String> nlsBasePrefixes = new HashSet<String>();

		// Map is class names to lower case prefix name
		Map<String, String> classNameToPrefixMap = new HashMap<String, String>();
		for (String className : allClassNames) {
			String superClassName = CMDBProviderTestUtils.getSuperNameClass(className);
			for (Set<String> partitionedNamesSet : partitionedNamesSetsList) {
				String filt = partitionSetToFilterStringMap.get(partitionedNamesSet);
				String lcprefixn = CMDBProviderTestUtils.lastPackageSegment(filt).toLowerCase();
				if (partitionedNamesSet.contains(superClassName)) {
					if (!nlsBasePrefixes.contains(lcprefixn)) {
						nlsBasePrefixes.add(lcprefixn);
					}
					System.out.println("prefix for " + superClassName + " = " + lcprefixn);
					classNameToPrefixMap.put(superClassName, lcprefixn);
				}
				if (partitionedNamesSet.contains(className)) {
					if (!nlsBasePrefixes.contains(lcprefixn)) {
						nlsBasePrefixes.add(lcprefixn);
					}
					System.out.println("prefix for " + className + " = " + lcprefixn);
					classNameToPrefixMap.put(className, lcprefixn);
				}
			}
		}

		printSchemaHeader(p, nlsPrefix, nlsBasePrefixes);
		for (String className : allClassNames) {
			String superClassName = CMDBProviderTestUtils.getSuperNameClass(className);
			printCapDef(p, className, superClassName, nlsPrefix, classNameToPrefixMap.get(superClassName));
			printUnitDef(p, className, superClassName, nlsPrefix, classNameToPrefixMap.get(superClassName));

// if (allClassNames.contains(superClassName)) {
// printCapDef(p, className, superClassName, nlsPrefix, nlsPrefix);
// printUnitDef(p, className, superClassName, nlsPrefix, nlsPrefix);
// } else {
// printCapDef(p, className, superClassName, nlsPrefix,
// classNameToPrefixMap.get(superClassName));
// printUnitDef(p, className, superClassName, nlsPrefix,
// classNameToPrefixMap.get(superClassName));
// }
		}
		printSchemaFinish(p);
	}

// private void dumpOCList(List<ObjectClass> ocList) {
// for (ObjectClass oc : ocList) {
// try {
// System.out.println(oc.getName());
// } catch (AttributeNotSetException e) {
// e.printStackTrace();
// }
// }
// }

	private List<ObjectClass> filteredOCList(List<ObjectClass> ocList, String classNameStartsWithString) {
		List<ObjectClass> fOCList = new LinkedList<ObjectClass>();
		for (ObjectClass oc : ocList) {
			try {
				if (!oc.getName().startsWith(classNameStartsWithString)) {
					continue;
				}
			} catch (AttributeNotSetException e) {
				e.printStackTrace();
			}
			fOCList.add(oc);
		}
		return fOCList;
	}

	private void printUnitDef(PrintStream p, String className, String superClassName, String nlsPrefix,
			String nlsBasePrefix) {
		className = CMDBProviderTestUtils.classNameToShortName(className);
		superClassName = CMDBProviderTestUtils.classNameToShortName(superClassName);
		nlsBasePrefix = "cdm" + CMDBProviderTestUtils.forceFirstCharUpperCase(nlsBasePrefix);
		nlsPrefix = "cdm" + CMDBProviderTestUtils.forceFirstCharUpperCase(nlsPrefix);
		if (superClassName == null) {
			superClassName = "";
			nlsBasePrefix = "core";
		}
		className += "Unit";
		superClassName += "Unit";
		String lcClassName = CMDBProviderTestUtils.forceFirstCharLowerCase(className);

		p.println("	<element name=\"unit." + lcClassName + "\" substitutionGroup=\"core:unit\" type=\"" + nlsPrefix +
				":" + className + "\"/>");
		p.println("	<complexType name=\"" + className + "\">");
		p.println("		<complexContent>");
		p.println("			<extension base=\"" + nlsBasePrefix + ":" + superClassName + "\"/>");
		p.println("		</complexContent>");
		p.println("	</complexType>");
		p.println();
	}

	private void printCapDef(PrintStream p, String className, String superClassName, String nlsPrefix,
			String nlsBasePrefix) {

		printCapHeader(p, className, superClassName, nlsPrefix, nlsBasePrefix);
		printCapAttributes(p, className, superClassName);
		printCapFinish(p);
	}

	private void printCapAttributes(PrintStream p, String className, String superClassName) {
		Class<?> c = CMDBProviderTestUtils.nameToClass(className);
		Map<String, Class<?>> classAttrsMap = getAttrToTypeMap(c);
		if (superClassName != null) {
			Class<?> superC = CMDBProviderTestUtils.nameToClass(superClassName);
			Map<String, Class<?>> superClassAttrsMap = getAttrToTypeMap(superC);
			for (String aName : superClassAttrsMap.keySet()) {
				classAttrsMap.remove(aName);
			}
		}
		for (String aName : classAttrsMap.keySet()) {
			Class<?> type = classAttrsMap.get(aName);
			if (ModelObject.class.isAssignableFrom(type)) {
				continue;
			}
			if (aName.startsWith("com.collation.platform.model") || Guid.class.isAssignableFrom(type)) {
				System.out.println("Non-ModelObject collation type " + aName + " excluded");
				continue;
			}
			String convertedTypeString = cdmToSchemaTypeMap.get(type.getName());
			if (convertedTypeString == null) {
				System.out.println("!!!!No conversion for " + type.getName());
			}
			p.println("				<attribute name=\"" + aName + "\" " + convertedTypeString + " />");
		}
	}

	private void printCapHeader(PrintStream p, String className, String superClassName, String nlsPrefix,
			String nlsBasePrefix) {
		className = CMDBProviderTestUtils.classNameToShortName(className);
		superClassName = CMDBProviderTestUtils.classNameToShortName(superClassName);
		if (nlsBasePrefix != null) {
			nlsBasePrefix = "cdm" + CMDBProviderTestUtils.forceFirstCharUpperCase(nlsBasePrefix);
		}
		assert (nlsPrefix != null);
		nlsPrefix = "cdm" + CMDBProviderTestUtils.forceFirstCharUpperCase(nlsPrefix);
		if (superClassName == null) {
			superClassName = "Capability";
			nlsBasePrefix = "core";
		}
		assert (nlsBasePrefix != null);
		String lcClassName = CMDBProviderTestUtils.forceFirstCharLowerCase(className);

		p.println("	<element name=\"capability." + lcClassName + "\" substitutionGroup=\"core:capability\" type=\"" +
				nlsPrefix + ":" + className + "\"/>");
		p.println("	<complexType name=\"" + className + "\">");
		p.println("		<complexContent>");
		p.println("			<extension base=\"" + nlsBasePrefix + ":" + superClassName + "\">");
	}

	private void printCapFinish(PrintStream p) {
		p.println("			</extension>");
		p.println("		</complexContent>");
		p.println("	</complexType>");

	}

	private void printSchemaHeader(PrintStream p, String nlsPrefix, Set<String> nlsBasePrefixes) {
		String ucNLSPrefix = CMDBProviderTestUtils.forceFirstCharUpperCase(nlsPrefix);
		p.println("<schema xmlns=\"http://www.w3.org/2001/XMLSchema\"");
		p.println("	targetNamespace=\"http://www.ibm.com/ccl/soa/deploy/cdm" + nlsPrefix + "/1.0.0/\"");
		if (!nlsBasePrefixes.contains(nlsPrefix)) {
			p
					.println("	xmlns:cdm" + ucNLSPrefix + "=\"http://www.ibm.com/ccl/soa/deploy/cdm" + nlsPrefix +
							"/1.0.0/\"");
		}
		for (String nlsBasePrefix : nlsBasePrefixes) {
			p.println("	xmlns:cdm" + CMDBProviderTestUtils.forceFirstCharUpperCase(nlsBasePrefix) +
					"=\"http://www.ibm.com/ccl/soa/deploy/cdm" + nlsBasePrefix + "/1.0.0/\"");
		}
		p.println("	xmlns:core=\"http://www.ibm.com/ccl/soa/deploy/core/1.0.0/\"");
		p.println("	xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\"");
		p.println("	elementFormDefault=\"qualified\" ecore:documentRoot=\"Cdm" +
				CMDBProviderTestUtils.forceFirstCharUpperCase(nlsPrefix) + "Root\"");
		p.println("	ecore:name=\"cdm" + ucNLSPrefix + "\"");
		p.println("	ecore:package=\"com.ibm.ccl.soa.deploy.cdm" + nlsPrefix + "\"");
		p.println("	ecore:nsPrefix=\"cdm" + ucNLSPrefix + "\">");
		p.println("");
		p.println("	<import namespace=\"http://www.ibm.com/ccl/soa/deploy/core/1.0.0/\"");
		p.println("		schemaLocation=\"platform:/resource/com.ibm.ccl.soa.deploy.core/models/schemas/core.xsd\" />");
		for (String nlsBasePrefix : nlsBasePrefixes) {
			if (nlsBasePrefix.equalsIgnoreCase(nlsPrefix)) {
				// Don't import self
				continue;
			}
			p.println("	<import namespace=\"http://www.ibm.com/ccl/soa/deploy/cdm" + nlsBasePrefix + "/1.0.0/\"");
			p.println("		schemaLocation=\"platform:/resource/com.ibm.ccl.soa.deploy.cmdb.cdm.test/models/schemas/cdm" +
					CMDBProviderTestUtils.forceFirstCharUpperCase(nlsBasePrefix) + ".xsd\" />");
		}
	}

	private void printSchemaFinish(PrintStream p) {
		p.println("</schema>");
	}

	private Map<String, Class<?>> getAttrToTypeMap(Class<?> c) {
		Map<String, Class<?>> retVal = new HashMap<String, Class<?>>();

		Method methods[] = c.getMethods();
		assert methods.length > 0;

		Set<String> excludedMethodNamesSet = getExcludedMethodNames();

		for (int i = 0; i < methods.length; ++i) {
			Method m = methods[i];
			if (!m.getName().startsWith(GET_PREFIX)) {
				continue;
			}
			if (m.getParameterTypes().length != 0) {
				continue;
			}
			if (excludedMethodNamesSet.contains(m.getName())) {
				continue;
			}

			String attrName = m.getName().substring(GET_PREFIX.length());

			Class<?> ac = m.getReturnType();
			if (ac == null) {
				continue;
			}

			if (ac.isArray()) {
				continue;
			}
			retVal.put(attrName, ac);
		}
		return retVal;
	}

	private Set<String> getExcludedMethodNames() {
		Set<String> excludedMethodNames = new HashSet<String>();
		Set<Method> methods = new HashSet<Method>();
		methods.addAll(Arrays.asList(ManagedElement.class.getMethods()));
		methods.addAll(Arrays.asList(ConfigurationItem.class.getMethods()));
		methods.addAll(Arrays.asList(Capability.class.getMethods()));

		for (Method m : methods) {
			String methodName = m.getName();
			if (methodName.startsWith(GET_PREFIX)) {
				excludedMethodNames.add(methodName);
			}
		}
		excludedMethodNames.add("getClass"); //$NON-NLS-1$
		return excludedMethodNames;
	}
}
