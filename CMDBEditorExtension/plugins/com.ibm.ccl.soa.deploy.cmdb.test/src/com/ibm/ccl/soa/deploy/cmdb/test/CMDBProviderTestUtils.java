package com.ibm.ccl.soa.deploy.cmdb.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.topology.meta.ObjectClass;
import com.ibm.ccl.soa.deploy.cmdb.model2model.RelationshipTranslationService;
import com.ibm.ccl.soa.deploy.cmdb.provider.CmdbModelObjectNode;
import com.ibm.ccl.soa.deploy.cmdb.provider.ICmdbNode;
import com.ibm.ccl.soa.deploy.cmdb.ui.CmdbUIPlugin;
import com.ibm.ccl.soa.deploy.cmdb.ui.preferences.IDeployCmdbPreferences;
import com.ibm.ccl.soa.deploy.cmdb.ui.provider.CmdbContentProvider;
import com.ibm.ccl.soa.deploy.cmdb.ui.provider.CmdbLabelProvider;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

/**
 * @since 3.2
 * @author barnold Some supporting classes adapted from code by Ed Snible
 */
public final class CMDBProviderTestUtils {

	private static List<ICmdbNode> allCmdbNodes = null;

	private static IUnitProviderService ups;

	private static String pathFilter = null;

	private static String filterGenerics = "true";

	/**
	 * @param navigatorPathTail
	 * @param top 
	 * @return List of Units that represent the resolved node
	 */
	public static List<Unit> resolveByNavigatorPathTail(String navigatorPathTail, Topology top) {
		System.out.println("resolveByNavigatorPathTail : " + navigatorPathTail);
		List<Unit> unitsList = new ArrayList<Unit>();

		init(pathFilter);
		LabelProvider labelProvider = new CmdbLabelProvider();
		for (Object node : allCmdbNodes) {

			// If node is the node we're looking for...
			if (node instanceof ICmdbNode) {
				ICmdbNode dnode = (ICmdbNode) node;

				String pathInNavigator = nodeToPath(node, labelProvider);
				if (pathInNavigator.endsWith(navigatorPathTail)) {
					System.out.println("found target path " + pathInNavigator);
					unitsList.addAll(resolveNodeToTopology(dnode, ups, top, pathInNavigator));
					break;
				} else {
					continue;
				}
			}
		}
		return unitsList;
	}

	/**
	 * @param navigatorPathSubString
	 * @param top 
	 * @return List of Units that represent the resolved node
	 */
	public static List<Unit> resolveByNavigatorPathSubString(String navigatorPathSubString, Topology top) {
		System.out.println("resolveByNavigatorPathSubString : " + navigatorPathSubString);
		List<Unit> unitsList = new ArrayList<Unit>();

		init(pathFilter);
		LabelProvider labelProvider = new CmdbLabelProvider();
		for (Object node : allCmdbNodes) {
			if (node instanceof ICmdbNode) {
				ICmdbNode dnode = (ICmdbNode) node;

				String pathInNavigator = nodeToPath(node, labelProvider);
				// If node is a node we're looking for...
				if (pathInNavigator.indexOf(navigatorPathSubString) >= 0) {
					System.out.println("found target path " + pathInNavigator);
					unitsList.addAll(resolveNodeToTopology(dnode, ups, top, pathInNavigator));
				}
			}
		}
		return unitsList;
	}

	/**
	 * @param dcmObjectClass 
	 * @param name 
	 * @param top 
	 * @return List of Units that represent the resolved node
	 */
	public static List<Unit> resolveByDcmObjectType(Class<?> dcmObjectClass, String name, Topology top) {
		List<Unit> unitsList = new ArrayList<Unit>();

		init(pathFilter);

		return unitsList;
	}

	/**
	 * @param node
	 * @param ups
	 * @param top
	 * @param pathInNavigator
	 * @return
	 */
	private static List<Unit> resolveNodeToTopology(ICmdbNode node, IUnitProviderService ups, Topology top,
			String pathInNavigator) {
		List<Unit> unitsList = new ArrayList<Unit>();
		UnitProvider[] unitProviders = ups.findEnabledProvidersByInputOnly(node);
		// Should be only one unit provider
		assert (unitProviders.length == 1);
		// Resolve node into stubs
		TopologyUnitStub[] topUnitStubs = unitProviders[0].resolveStubs(node);
		assert (topUnitStubs != null);
		System.out.println("topUnitStubs.length=" + topUnitStubs.length);
		// For each unit stub
		for (int stubIndex = 0; stubIndex < topUnitStubs.length; ++stubIndex) {
			// Make unit stub more convincing to other utility methods.
			topUnitStubs[stubIndex].setTopology(top);
			// Time resolution into units
			long startTime = System.currentTimeMillis();
			Object[] units = unitProviders[0].resolveUnit(topUnitStubs[stubIndex], true, null);
			System.out.println("UnitProvider.resolveUnit() took " + (System.currentTimeMillis() - startTime) +
					"ms for " + pathInNavigator);
			System.out.println("Provider " + unitProviders[0].getClass() + " resolved " + units.length + " units");
			if (units.length > 0) {
				for (int i = 0; i < units.length; ++i) {
					System.out.println(units[i].getClass() + " : " + ((Unit) units[i]).getName());
					top.getUnits().add(units[i]);
					UnitUtil.assignUniqueName((Unit)units[i]);
					unitsList.add((Unit) units[i]);
				}

				unitProviders[0].resolveLinks(unitsList, null);
			}
		}
		return unitsList;
	}

	/**
	 * 
	 */
	private static void init(String filter) {

		if (allCmdbNodes == null) {
			try {
				allCmdbNodes = getAllCmdbNodes(filter);
				assert (allCmdbNodes != null);
				System.out.println("Found " + allCmdbNodes.size() + " nodes");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (ups == null) {
			ups = DeployCoreUIPlugin.getDefault().getUnitProviderService();
			assert (ups != null);
		}
		if (false) {
			LabelProvider labelProvider = new CmdbLabelProvider();
			for (Object node : allCmdbNodes) {
				// If node is the node we're looking for...
				if (node instanceof ICmdbNode) {
					ICmdbNode dnode = (ICmdbNode) node;

					String pathInNavigator = nodeToPath(node, labelProvider);
					System.out.println(pathInNavigator);
				}
			}
		}
	}

	/**
	 * @param node
	 * @param labelProvider 
	 * @return String representing position in treeview
	 */
	public static String nodeToPath(Object node, LabelProvider labelProvider) {
		if (node instanceof ICmdbNode) {
			return vnodeToPath((ICmdbNode) node, labelProvider);
		} else if (node instanceof IWorkspaceRoot) {
			return node.toString();
		}

		return "?";
	}

	private static String vnodeToPath(ICmdbNode node, LabelProvider labelProvider) {
		return nodeToPath(node.getParent(), labelProvider) + "->" + labelProvider.getText(node);
	}

	/**
	 * @param filter 
	 * @return List of all DCM nodes
	 * @throws Exception
	 */
	public static List<ICmdbNode> getAllCmdbNodes(String filter) throws Exception {

		if (allCmdbNodes == null) {
			IPreferenceStore store = CmdbUIPlugin.getDefault().getPreferenceStore();
			boolean filterGenericsSave = store.getBoolean(IDeployCmdbPreferences.CMDB_FILTER_GENERICS);
			store.setValue(IDeployCmdbPreferences.CMDB_FILTER_GENERICS, filterGenerics );
			boolean cmdbHostnameSave = store.getBoolean(IDeployCmdbPreferences.CMDB_HOSTNAME);
			 store.setValue(IDeployCmdbPreferences.CMDB_HOSTNAME, "rf18.watson.ibm.com"); //$NON-NLS-1$
//			 store.setValue(IDeployCmdbPreferences.CMDB_HOSTNAME, "rfvm08.watson.ibm.com"); //$NON-NLS-1$

			ITreeContentProvider provider = new CmdbContentProvider();
			IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
			LabelProvider labelProvider = new CmdbLabelProvider();
			List<ICmdbNode> allNodes = new LinkedList<ICmdbNode>();

			System.gc();
			Thread.sleep(4000);
			long startMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			enumerateChildren(provider, workspace, new LinkedList<Object>(), labelProvider, allNodes, filter);
			System.gc();
			Thread.sleep(4000);
			long mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			System.out.println("Total memory delta after enumerating children = " + (mem - startMem)); //$NON-NLS-1$

			store.setValue(IDeployCmdbPreferences.CMDB_FILTER_GENERICS, filterGenericsSave);
			store.setValue(IDeployCmdbPreferences.CMDB_HOSTNAME, cmdbHostnameSave);

			allCmdbNodes = allNodes;
		}

		return allCmdbNodes;
	}

	/**
	 * @param provider
	 * @param parent
	 * @param backtrace
	 * @param labelProvider
	 * @param outAllNodes
	 * @throws Exception
	 */
	private static void enumerateChildren(ITreeContentProvider provider, Object parent, List<Object> backtrace,
			LabelProvider labelProvider, List<ICmdbNode> outAllNodes, String rootCmdbNodeNameFilter) throws Exception {
		backtrace.add(parent);
		if (parent instanceof ICmdbNode) {
			outAllNodes.add((ICmdbNode) parent);
			if (rootCmdbNodeNameFilter != null) {
				String path = vnodeToPath((ICmdbNode) parent, labelProvider);
				System.out.println(path);
				if (parent instanceof CmdbModelObjectNode) {
					String pathParts[] = path.split("->");
					if (pathParts.length >= 4) {
						if (!(pathParts[3].indexOf(rootCmdbNodeNameFilter) >= 0)) {
							return;
						}
					}
				}
			}
		}
		Object[] children;
		children = provider.getChildren(parent);

		for (int i = 0; i < children.length; i++) {
			enumerateChildren(provider, children[i], new LinkedList<Object>(backtrace), labelProvider, outAllNodes,
					rootCmdbNodeNameFilter);
		}
	}
	

	/**
	 * Return superclass in ModelObject hierarchy for class
	 * @param className
	 * @return
	 * 		class name for superclass in model object interface hierarchy
	 */
	public static String getSuperNameClass(String className) {
		Class<?> c = nameToClass(className);
		if (c != null) {
			c = RelationshipTranslationService.INSTANCE.moHierarchyInterface(c);
			if (c != null) {
				return c.getName();
			}
		}
		return null;
	}

	/**
	 * Return all classnames in ModelObject hierarchy for parameter, 
	 * including classname of parameter
	 * @param oc
	 * 		CDM metadata object for a class
	 * @return
	 * 		class names for all classes in model object superclass interface hierarchy
	 */
	public static  List<String> getMOHierarchy(ObjectClass oc) {
		List<String> retVal = Collections.emptyList();
		try {
			retVal = getMOHierarchy(oc.getName());
		} catch (AttributeNotSetException e) {
// e.printStackTrace();
		}
		return retVal;
	}
	
	/**
	 * Return all classnames in ModelObject hierarchy for parameter, 
	 * including classname of parameter
	 * @param className 
	 * 		full classname for class
	 * @return
	 * 		class names for all classes in model object superclass interface hierarchy
	 */
	public static  List<String> getMOHierarchy(String className) {
		List<String> retVal = new ArrayList<String>();
			Class<?> c = nameToClass(className);
			while (c != null) {
				retVal.add(c.getName());
				c = RelationshipTranslationService.INSTANCE.moHierarchyInterface(c);
			}
		return retVal;
	}

	/**
	 * @param className
	 * @return
	 * 		Class for classname
	 */
	public static  Class<?> nameToClass(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param className
	 * @return
	 * 		Shortname for class specified by classname
	 */
	public static  String classNameToShortName(String className) {
		if (className == null) {
			return null;
		}
		Class<?> c = nameToClass(className);
		if (c != null) {
			return c.getSimpleName();
		}
		return className;
	}

	/**
	 * @param s
	 * @return
	 * 		string with lowercased first character
	 */
	public static String forceFirstCharLowerCase(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		if (s.length() == 1) {
			return s.toLowerCase();
		} else {
			return s.substring(0, 1).toLowerCase() + s.substring(1);
		}
	}

	/**
	 * @param s
	 * @return
	 * 		string with uppercased first character
	 */
	public static String forceFirstCharUpperCase(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		if (s.length() == 1) {
			return s.toUpperCase();
		} else {
			return s.substring(0, 1).toUpperCase() + s.substring(1);
		}
	}
	
	/**
	 * @param ps
	 * @return
	 * 		Segment past the last "." in the string, or the string, if it has no "."
	 */
	public static String lastPackageSegment(String ps) {
		if (ps == null || ps.length() == 0 || ps.indexOf(".") < 0) {
			return ps;
		}
		String psSegs[] = ps.split("\\.");
		return psSegs[psSegs.length - 1];
	}
}
