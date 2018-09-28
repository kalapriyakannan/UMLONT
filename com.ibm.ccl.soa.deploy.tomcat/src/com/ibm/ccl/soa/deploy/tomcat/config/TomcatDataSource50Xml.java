/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jst.server.tomcat.core.internal.TomcatServer;
import org.eclipse.jst.server.tomcat.core.internal.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.publisher.ITomcatConstants;

// import com.ibm.ccl.app.deploy.core.j2ee.GenericJ2eeDatasource;

public class TomcatDataSource50Xml implements ITomcatConstants {

	private TomcatServer server = null;

	private Tomcat50Datasource dataSource = null;

	private String password = ""; //$NON-NLS-1$

	private String driverName = ""; //$NON-NLS-1$

	private String url = ""; //$NON-NLS-1$

	private String userName = ""; //$NON-NLS-1$

	private String jndiName = ""; //$NON-NLS-1$

	public TomcatDataSource50Xml(TomcatServer tomcatServer, Tomcat50Datasource aDataSource)
			throws IOException, SAXException {
		this.server = tomcatServer;
		this.dataSource = aDataSource;
		createDataSource(aDataSource);
	}

	protected void createDataSource(Tomcat50Datasource dataSource) throws IOException, SAXException {
		if (server == null)
			return;
		IPath path = getPath(server);
		InputStream in = new FileInputStream(path.toFile());
		Document document = null;

		// databaseInfo
		url = dataSource.getUrl();
		userName = dataSource.getUsername();
		password = dataSource.getPassword();
		driverName = dataSource.getDriverClassName();

		if (url == null || userName == null || driverName == null || password == null)
			return; //TODO this should be a validation error.
		String loadingPath = dataSource.getClientJarLocation();

		if (loadingPath != null && loadingPath.length() > 0) {
			File dbJarSrc = new File(loadingPath);
			int beginJarInt = loadingPath.lastIndexOf('\\');
			int endJarInt = loadingPath.length();
			if (beginJarInt > 0 & endJarInt > 0) {
				String jarName = loadingPath.substring(beginJarInt, endJarInt);
				File dbJarTarget = getLibPath(server).append(jarName).toFile();
				if (!dbJarTarget.exists())
					copy(dbJarSrc, dbJarTarget);
			}
			// temp until propertydescriptor working
		}
		jndiName = dataSource.getJndiName();
		try {
			document = XMLUtil.getDocumentBuilder().parse(new InputSource(in));
			Element parentElement = document.getDocumentElement();
			NodeList list = parentElement.getElementsByTagName(GLOBAL_NAMEING_ELEMENT_NAME);
			Element globalElement = (Element) list.item(0);
			if (!containsElementValue(globalElement, ResourceElementHelper.RESOURCE_ELEMENT,
					ResourceElementHelper.NAME_ATTRIBUTE, jndiName)) {
				ResourceElementHelper resourceElement = new ResourceElementHelper(document);
				Element element = resourceElement.createResourceElement(jndiName, AUTH, TYPE);
				globalElement.appendChild(element);
			}
			// already defined
			else
				return;
			if (!containsElementValue(globalElement,
					ResourceParameterElementHelper.RESOURCE_PARAMS_ELEMENT, null, jndiName)) {
				HashMap map = new HashMap();
				map.put(PARAM_USERNAME, userName);
				map.put(PARAM_PASSWORD, password);
				map.put(PARAM_DRIVER_CLASS, driverName);
				map.put(PARAM_URL, url);
				map.put(PARAM_FACTORY, TOMCAT50_DATASOURCE_FACTORY);
				ResourceParameterElementHelper paramElement = new ResourceParameterElementHelper();
				Element element = paramElement.createResourceParameterElement(document, jndiName, map,
						false);
				globalElement.appendChild(element);

			}
			in.close();
		} catch (IllegalArgumentException exception) {
			throw new IOException(Messages.getString("TomcatDataSource50Xml.0")); //$NON-NLS-1$
		}
		document.normalize();
		XMLUtil.save(path.toString(), document);
	}

	private IPath getPath(TomcatServer server) {
		IPath path = server.getTomcatRuntime().getRuntime().getLocation();
		path = path.append(CONFIG);
		path = path.append(SERVER);
		return path;
	}

	private IPath getLibPath(TomcatServer server) {
		IPath path = server.getTomcatRuntime().getRuntime().getLocation();
		path = path.append(COMMON_PATH);
		path = path.append(LIB_PATH);
		return path;
	}

	private boolean containsElementValue(Element parentElement, String elementName, String attName,
			String value) {
		NodeList nodes = parentElement.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node element = nodes.item(i);
			if (element.getNodeName().equals(elementName)) {
				if (attName != null) {
					NamedNodeMap map = element.getAttributes();
					Node node = map.getNamedItem(attName);
					element = node;
				}
				if (element.getNodeValue() != null && element.getNodeValue().equals(value))
					return true;
			}
		}
		return false;
	}

	void copy(File src, File dest) throws IOException {
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dest);
		byte[] buf = new byte[1028];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

}
