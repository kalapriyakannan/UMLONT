package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

public class ProductVersionManager {

	private static final ProductVersionManager instance = new ProductVersionManager();
	private final Map<String, SortedSet<ProductVersionValue>> productVersionMap = new HashMap<String, SortedSet<ProductVersionValue>>();
	int priority = 0;

	public static ProductVersionManager getInstance() {
		return instance;
	}

	public void addProductVersion(String versionKey, ProductVersionValue productVersionValue) {
		Object obj = productVersionMap.get(versionKey);
		if (obj == null) {
			SortedSet<ProductVersionValue> pvSet = new TreeSet<ProductVersionValue>();
			pvSet.add(productVersionValue);
			productVersionMap.put(versionKey, pvSet);
		} else {
			TreeSet<ProductVersionValue> pvSet = (TreeSet<ProductVersionValue>) obj;
			pvSet.add(productVersionValue);
		}

	}

	public boolean inRange(String versionKey, ProductVersionValue sourceValue,
			ProductVersionValue targetValue) {
		Object obj = productVersionMap.get(versionKey);
		if (obj == null) {
			return false;
		}
		if (sourceValue == null || targetValue == null) {
			return false;
		}
		TreeSet<ProductVersionValue> pvSet = (TreeSet<ProductVersionValue>) obj;
		SortedSet sampleSet = pvSet.headSet(targetValue);
		Object[] prodVersions = sampleSet.toArray();
		for (int i = 0; i < prodVersions.length; i++) {
			Object prodVersion = prodVersions[i];
			if (prodVersion == sourceValue) {
				return true;
			}

		}
		return false;
	}

	public boolean loadProductVersionData(String productVersionKey, String fileName, Bundle bundle) {
		try {
			priority = 0;
			URL url = FileLocator.find(bundle, new Path(fileName), Collections.EMPTY_MAP);
			if (url == null) {
				return false;
			}
			url = FileLocator.toFileURL(url);
			Path path = new Path(url.getPath());
			File file = path.toFile();
			if (file.exists() && file.canRead()) {
				BufferedReader in = new BufferedReader(new FileReader(file));
				String str;
				while ((str = in.readLine()) != null) {
					process(str, productVersionKey);
				}
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void process(String str, String familyName) {
		priority++;
		ProductVersionValue productVersionValue = new ProductVersionValue();
		productVersionValue.setPriority(priority);
		productVersionValue.setFamily(familyName);
		int end = str.indexOf(',');
		if (end <= 0) {
			return;
		}
		String productName = str.substring(0, end);
		str = str.substring(end + 1, str.length());
		end = str.indexOf(',');
		productVersionValue.setProductName(productName);
		String productVersion = str.substring(0, end);
		str = str.substring(end + 1, str.length());
		end = str.length();
		productVersionValue.setVersion(productVersion);
		String productLevel = str.substring(0, end);
		productVersionValue.setProductLevel(productLevel);
		addProductVersion(familyName, productVersionValue);
	}

	public boolean isLoaded(String productKey) {
		return productVersionMap.containsKey(productKey);
	}

	public String[] getValues(String productKey) {
		Object obj = productVersionMap.get(productKey);
		if (obj == null) {
			return new String[0];
		}
		TreeSet<ProductVersionValue> pvSet = (TreeSet<ProductVersionValue>) obj;
		String[] values = new String[pvSet.size()];
		int x = 0;
		for (Iterator iterator = pvSet.iterator(); iterator.hasNext();) {
			ProductVersionValue versionValue = (ProductVersionValue) iterator.next();
			values[x] = versionValue.getVersion();
			x++;
		}
		return values;
	}

	public ProductVersionValue getProductVersionValue(String productKey, String value) {
		Object obj = productVersionMap.get(productKey);
		if (obj == null) {
			return null;
		}
		TreeSet<ProductVersionValue> pvSet = (TreeSet<ProductVersionValue>) obj;
		for (Iterator iterator = pvSet.iterator(); iterator.hasNext();) {
			ProductVersionValue versionValue = (ProductVersionValue) iterator.next();
			if (versionValue.getVersion().equals(value)) {
				return versionValue;
			}

		}
		return null;

	}
}
