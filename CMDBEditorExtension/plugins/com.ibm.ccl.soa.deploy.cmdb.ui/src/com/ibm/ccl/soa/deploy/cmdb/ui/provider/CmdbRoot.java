package com.ibm.ccl.soa.deploy.cmdb.ui.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.topology.meta.ObjectClass;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.cmdb.provider.ICmdbNode;
import com.ibm.ccl.soa.deploy.cmdb.ui.CmdbUIPlugin;
import com.ibm.ccl.soa.deploy.cmdb.ui.Messages;
import com.ibm.ccl.soa.deploy.cmdb.ui.actions.RootTypesSelectionDialog;

/**
 * @author barnold
 *
 */
public class CmdbRoot implements ICmdbNode {
	
	private String cachedLabel;

	public boolean hasChildren() {
		return true;
	}
	
	public List<ICmdbNode> getChildren() {
		List<ICmdbNode> retVal = new ArrayList<ICmdbNode>();	
		if (!CmdbQueryService.INSTANCE.isAPIHealthy()) {
			return retVal;
		}
		CmdbUIPlugin cmdbUIPlugin = CmdbUIPlugin.getDefault();
		if (cmdbUIPlugin == null) {
			return retVal;
		}
	
		IPreferenceStore ips = cmdbUIPlugin.getPreferenceStore();
		// TODO when the preferences page supports editing of roots replace "" with ips.getString(RootTypesSelectionAction.ccmdbExplorerRootTypes); 
		String rootTypes = "";
		List<String> typesList;
		if ((rootTypes == null) || (rootTypes.length() == 0)) { 
			typesList = RootTypesSelectionDialog.getDefaultCheckedTypeNames();
		} else {
			typesList = RootTypesSelectionDialog.parseCommaDelimitedListAsArray(rootTypes);
		}
		for (String type : typesList) {
			// TODO How to do NLSed plurals?
			String typeDisplayName = type;
			try {
				ObjectClass oc = CmdbQueryService.INSTANCE.getMetaData(type);
				if (oc == null) break;
				typeDisplayName = oc.getDisplayString();
			} catch (AttributeNotSetException e) {
				// Should not be seeing this
				e.printStackTrace();
			}
			CmdbCategory cc = new CmdbCategory(this, typeDisplayName, type);  
			retVal.add(cc);
		}
		CmdbTreeViewUtils.sort(retVal);
		return retVal;
	}

	public ICmdbNode getParent() {
		return null;
	}
	
	public String getLabel() {
		if (cachedLabel == null) {
			return computeLabel();
		}
		return cachedLabel;
	}
	
	/**
	 * @return the computed label of the node.
	 */
	public String computeLabel() {
		cachedLabel = Messages.CmdbRoot_CCMDBProductName + " (" + CmdbQueryService.INSTANCE.getTaddmServer() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		return cachedLabel;
	}
		
	@Override
	public String toString() {
		return getLabel();
	}

}
