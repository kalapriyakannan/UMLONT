package com.ibm.ccl.soa.deploy.cmdb.ui.provider;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbToTdmConversionUtils;
import com.ibm.ccl.soa.deploy.cmdb.provider.ICmdbNode;
import com.ibm.ccl.soa.deploy.cmdb.ui.CmdbUIPlugin;
import com.ibm.ccl.soa.deploy.cmdb.ui.preferences.IDeployCmdbPreferences;

/**
 * @author barnold
 * 
 */
public class CmdbContentProvider implements ITreeContentProvider {

	private IPreferenceStore prefStore;

	/**
	 * 
	 */
	public CmdbContentProvider() {
		prefStore = CmdbUIPlugin.getDefault().getPreferenceStore();

		String cmdbHostname = prefStore.getString(IDeployCmdbPreferences.CMDB_HOSTNAME);
		if (cmdbHostname != null) {
			CmdbQueryService.INSTANCE.setTaddmServer(cmdbHostname);
		}

		String cmdbUserId = prefStore.getString(IDeployCmdbPreferences.CMDB_USERID);
		if (cmdbUserId != null) {
			CmdbQueryService.INSTANCE.setTaddmUserId(cmdbUserId);
		}

		String cmdbUserPw = prefStore.getString(IDeployCmdbPreferences.CMDB_USERPASSWORD);
		if (cmdbUserPw != null) {
			CmdbQueryService.INSTANCE.setTaddmUserPw(cmdbUserPw);
		}

		// FIXME These are to communicate a couple of preference values to the non-UI project
		// The preference store is only for UI projects
		boolean disableCustomUnitProviders = prefStore.getBoolean(IDeployCmdbPreferences.CMDB_DISABLE_CUSTOM_UNIT_PROVIDER);
		System.setProperty(CmdbToTdmConversionUtils.DISABLE_CUSTOM_UNIT_PROVIDERS_NAME,
				disableCustomUnitProviders ? Boolean.TRUE.toString() : Boolean.FALSE.toString());
		boolean filterGenerics = prefStore.getBoolean(IDeployCmdbPreferences.CMDB_FILTER_GENERICS);
		System.setProperty(CmdbToTdmConversionUtils.CMDB_FILTER_GENERICS,
				filterGenerics ? Boolean.TRUE.toString() : Boolean.FALSE.toString());		
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IWorkspaceRoot) {
			Object[] retVal = { new CmdbRoot() };
			if (prefStore.getBoolean(IDeployCmdbPreferences.CMDB_ENABLE_NAVIGATOR_PREFETCHER)) {
				CMDBCachePreloadService.INSTANCE.preLoadCMDBCache(retVal);
			}
			return retVal;
		} else if (parentElement instanceof ICmdbNode) {
			List<ICmdbNode> children = ((ICmdbNode) parentElement).getChildren();
			if (children != null) {
				ICmdbNode retVal[] = children.toArray(new ICmdbNode[children.size()]);
				if (prefStore.getBoolean(IDeployCmdbPreferences.CMDB_ENABLE_NAVIGATOR_PREFETCHER)) {
					CMDBCachePreloadService.INSTANCE.preLoadCMDBCache(retVal);
				}
				CmdbTreeViewUtils.sort(retVal);
				return retVal;
			}
		}
		return null;
	}

	public Object getParent(Object element) {
		if (element instanceof ICmdbNode) {
			return ((ICmdbNode) element).getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof IWorkspaceRoot) {
			return true;
		}
		if (element instanceof ICmdbNode) {
			return ((ICmdbNode) element).hasChildren();	
		}
		// Fall back to getChildren(...)
		Object[] children = getChildren(element);
		if (children == null) {
			return false;
		}
		return children.length > 0;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}


}
