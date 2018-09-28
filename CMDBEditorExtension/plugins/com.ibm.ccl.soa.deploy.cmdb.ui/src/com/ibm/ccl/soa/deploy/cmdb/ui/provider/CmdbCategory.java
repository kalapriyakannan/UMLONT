package com.ibm.ccl.soa.deploy.cmdb.ui.provider;

import java.util.ArrayList;
import java.util.List;

import com.collation.platform.model.ModelObject;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.cmdb.provider.CmdbModelObjectNode;
import com.ibm.ccl.soa.deploy.cmdb.provider.ICmdbNode;

/**
 * @author barnold
 *
 */
public class CmdbCategory implements ICmdbNode {

	private String categoryDisplayName;
	private String categoryClassName;
	private CmdbRoot parent;

	/**
	 * @param parent
	 * @param categoryDisplayName
	 * @param categoryClassName
	 */
	public CmdbCategory(CmdbRoot parent, String categoryDisplayName, String categoryClassName) {
		this.categoryDisplayName = categoryDisplayName;
		this.categoryClassName = categoryClassName;
		this.parent = parent;
	}

	public boolean hasChildren() {
		return CmdbQueryService.INSTANCE.hasModelObjectsOfType(categoryClassName);
	}

	public List<ICmdbNode> getChildren() {
		List<ModelObject> moList = CmdbQueryService.INSTANCE.getModelObjectsOfType(categoryClassName); 
		List<ICmdbNode> retVal = new ArrayList<ICmdbNode>();
		for (ModelObject mo : moList) {
			CmdbModelObjectNode cmon = new CmdbModelObjectNode(this, mo);
			retVal.add(cmon);
		}
		return retVal;
	}

	public ICmdbNode getParent() {
		return parent;
	}

	public String getLabel() {
		return categoryDisplayName;
	}

	public String computeLabel() {
		return categoryDisplayName;
	}
	
	/**
	 * @return the class name of the category.
	 */
	public String getCategoryClassName() {
		return categoryClassName;
	}

	@Override
	public String toString() {
		return getLabel();
	}

}
