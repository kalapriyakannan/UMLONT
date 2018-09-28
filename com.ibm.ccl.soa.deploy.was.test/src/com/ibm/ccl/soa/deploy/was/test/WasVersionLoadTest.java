package com.ibm.ccl.soa.deploy.was.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

import com.ibm.ccl.soa.deploy.was.WasDeployPlugin;

public class WasVersionLoadTest extends TestCase {

	public void testLoadingVersions() {

		try {
			Bundle bundle = WasDeployPlugin.getDefault().getBundle();
			URL url = FileLocator.find(bundle, new Path(
					"versions/was60versionInfo.txt"), Collections.EMPTY_MAP);
			url = FileLocator.toFileURL(url);
			Path path = new Path(url.getPath());
			File file = path.toFile();
			if (file.exists() && file.canRead()) {
				BufferedReader in = new BufferedReader(new FileReader(file));
				String str;
				while ((str = in.readLine()) != null) {
					process(str);
				}
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void process(String str) {
		int end = str.indexOf(',');
		if (end <= 0)
			return;
		String productName = str.substring(0, end);
		str = str.substring(end + 1, str.length());
		end = str.indexOf(',');
		String productVersion = str.substring(0, end);
		str = str.substring(end + 1, str.length());
		end = str.length();
		String productLevel = str.substring(0, end);
	}


}
