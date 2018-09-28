package com.ibm.ccl.soa.deploy.cmdb.ui.provider;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.topology.meta.ObjectClass;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.cmdb.provider.ICmdbNode;


/**
 * @author barnold
 * 
 */
public class CmdbTreeViewUtils {

	/**
	 * @param className
	 * 			CDM class name
	 * @return
	 * 			Display name for class (displayString)
	 */
	public static String classDisplayName(String className) {
		ObjectClass cmd = CmdbQueryService.INSTANCE.getMetaData(className);
		if (cmd != null) {
			try {
				return cmd.getDisplayString();
			} catch (AttributeNotSetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return className;
	}
	

	/**
	 * Does not use class loader
	 * @param className
	 * 			full class name
	 * @return
	 * 			shortname for class
	 */
	public static String shortClassName(String className) {
		return lastPackageSegment(className);
	}

	/**
	 * @param classNames
	 * 		list of full class names
	 * @return
	 * 		list of corresponding shortnames
	 */
	public static List<String> shortClassNames(List<String> classNames) {
		List<String> retVal = new LinkedList<String>();
		for (String cn : classNames) {
			retVal.add(shortClassName(cn));
		}
		return retVal;
	}


	private static String lastPackageSegment(String className) {
		if (className == null || className.length() == 0 || className.indexOf(".") < 0) { //$NON-NLS-1$
			return className;
		}
		String psSegs[] = className.split("\\."); //$NON-NLS-1$
		return psSegs[psSegs.length - 1];
	}

	/**
	 * Sorts model objects by type then string description.
	 */
	public static final Comparator<ICmdbNode> CMDB_NODE_COMPARATOR = new Comparator<ICmdbNode>(){
		/**
		 * @see Comparator#compare(Object, Object)
		 */
		public int compare(ICmdbNode o1, ICmdbNode o2) {
			if (o1 == o2) {
				return 0;
			}
			if (o1 == null) {
				return -1;
			}
			if (o2 == null) {
				return 1;
			}

			return o1.getLabel().compareToIgnoreCase(o2.getLabel());
		}
	};
	
	/**
	 * Sorts the CMDB nodes by their label.
	 * <p>
	 * Efficiently caches the label during the sort to reduce
	 * the number of label generation queries.
	 *  
	 * @param nodes an array of CMDB nodes.
	 */
	public static void sort(ICmdbNode[] nodes) {
		if ((nodes == null) || (nodes.length <= 1)){
			return;
		}
		Arrays.sort(nodes, CMDB_NODE_COMPARATOR);
	}
	
	/**
	 * Sorts the CMDB nodes by their label.
	 * <p>
	 * Efficiently caches the label during the sort to reduce
	 * the number of label generation queries.
	 *  
	 * @param nodes an array of CMDB nodes.
	 */
	public static void sort(List<ICmdbNode> nodes) {
		if ((nodes == null) || (nodes.size() <= 1)){
			return;
		}
		Collections.sort(nodes, CMDB_NODE_COMPARATOR);
	}
}
