/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.exporter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Utility to compress file and dir to a zip
 * 
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> 2006-8-17
 */
public class ZipUtil {
	public static void compressStringAsFile(StringBuffer content, ZipOutputStream zipOutputStream,
			String fileName) throws Exception {

		ZipEntry entry = new ZipEntry(fileName);

		InputStream inputStream = new ByteArrayInputStream(content.toString().getBytes());
		compressInputStream2Enrty(inputStream, entry, zipOutputStream);
	}

	/**
	 * compress single file, 2006-7-17
	 * 
	 * @author zhangwei
	 * @param entryName
	 * @param zipOutputStream
	 */
	public static void compressByCopy(String entryName, InputStream inputStream,
			ZipOutputStream zipOutputStream) throws Exception {

		ZipEntry entry = new ZipEntry(entryName);

		compressInputStream2Enrty(inputStream, entry, zipOutputStream);
	}

	/**
	 * 
	 * @param inputStream
	 * @param entry
	 * @param zipOutputStream
	 * @throws Exception
	 */

	public static void compressInputStream2Enrty(InputStream inputStream, ZipEntry entry,
			ZipOutputStream zipOutputStream) throws Exception {
		zipOutputStream.putNextEntry(entry);
		int number;
		byte[] buffer = new byte[1024];
		while ((number = inputStream.read(buffer)) != -1)
			zipOutputStream.write(buffer, 0, number);
		zipOutputStream.flush();

	}

	/**
	 * @author zhangwei, 2006-7-17
	 * @param dir
	 * @param inputFileName
	 * @param zipOutputStream
	 */
	public static void compressFile2Dir(String dir, String inputFileName, InputStream inputStream,
			ZipOutputStream zipOutputStream) throws Exception {

		ZipEntry entry = new ZipEntry(dir + inputFileName);

		compressInputStream2Enrty(inputStream, entry, zipOutputStream);
	}

}
