package com.ibm.ccl.soa.deploy.internal.core.extension;

public class ProductVersionValue implements Comparable {

	public int priority = -1;
	private String version;
	private String productName;
	private String productLevel;
	private String family;

	public int compareTo(Object o) {
		if (!(o instanceof ProductVersionValue)) {
			return 0;
		}
		ProductVersionValue versionValue = (ProductVersionValue) o;
		if (priority > versionValue.getPriority()) {
			return 1;
		}
		return -1;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLevel() {
		return productLevel;
	}

	public void setProductLevel(String productLevel) {
		this.productLevel = productLevel;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

}
