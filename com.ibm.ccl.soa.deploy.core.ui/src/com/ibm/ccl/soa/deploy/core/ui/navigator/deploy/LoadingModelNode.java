/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

public class LoadingModelNode {

	private static Image loadingOne;
	private static Image loadingTwo;
	private static Image loadingThree;
	private static Image loadingFour;

	private static final Set loadingFiles = new HashSet();
	private static final Map placeHolders = new HashMap();

	static {
		try {

			loadingOne = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_LOADING_MODEL_NODE_1);
			loadingTwo = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_LOADING_MODEL_NODE_2);
			loadingThree = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_LOADING_MODEL_NODE_3);
			loadingFour = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_LOADING_MODEL_NODE_4);

		} catch (RuntimeException e) {
			String msg = e.getMessage() != null ? e.getMessage() : e.toString();
			DeployCoreUIPlugin.logError(0, msg, e);
			ISharedImages images = DeployCoreUIPlugin.getDefault().getSharedImages();
			Image missing = images.getImage(ImageDescriptor.getMissingImageDescriptor());
			loadingOne = loadingTwo = loadingThree = loadingFour = missing;
		}
	}

	private final String text;
	private final String text1;
	private final String text2;
	private final String text3;
	private int count = 0;
	private boolean disposed = false;
	private final IFile modelFile;;

	/**
	 * Return a place holder node to sit in the tree until data is available. This place holder node
	 * will be animated for the user's enjoyment.
	 * 
	 * @param modelFile
	 *           The modelFile to be loaded
	 * @return A new unique place holder for this file for a given load cycle
	 */
	public static LoadingModelNode createPlaceHolder(IFile modelFile) {
		LoadingModelNode node = null;
		synchronized (LoadingModelNode.class) {
			if (placeHolders.containsKey(modelFile)) {
				node = (LoadingModelNode) placeHolders.get(modelFile);
			} else {
				placeHolders.put(modelFile, node = new LoadingModelNode(modelFile));
			}
		}
		return node;
	}

	public LoadingModelNode(IFile modelFile) {
		text = Messages.LoadingModelNode_Loading_Topology_Diagram_;
		text1 = text + "."; //$NON-NLS-1$
		text2 = text + ".."; //$NON-NLS-1$
		text3 = text + "..."; //$NON-NLS-1$
		this.modelFile = modelFile;
	}

	public String getText() {

		switch (count % 4)
		{
		case 0:
			return text;
		case 1:
			return text1;
		case 2:
			return text2;
		case 3:
		default:
			return text3;
		}
	}

	public Image getImage() {
		switch (count = ++count % 4)
		{
		case 0:
			return loadingOne;
		case 1:
			return loadingTwo;
		case 2:
			return loadingThree;
		case 3:
		default:
			return loadingFour;
		}
	}

	public boolean isDisposed() {
		return disposed;
	}

	public void dispose() {
		synchronized (LoadingModelNode.class) {
			disposed = true;
			placeHolders.remove(modelFile);
			loadingFiles.remove(modelFile);
		}
	}

	/**
	 * Employ a Test and Set (TST) primitive to ensure that only job is spawned to load the model
	 * file
	 * 
	 * 
	 * @return True only if no other jobs are trying to load this model.
	 */
	public static boolean canBeginLoading(IFile modelFile) {
		synchronized (LoadingModelNode.class) {
			if (loadingFiles.contains(modelFile)) {
				return false;
			}
			loadingFiles.add(modelFile);
			return true;
		}

	}

	/**
	 * Return true if a job has requested permission to load the model file
	 * 
	 * @param modelFile
	 *           The model file that should be loaded
	 * @return True only if a job is trying to load the model.
	 */
	public static boolean isBeingLoaded(IFile modelFile) {
		synchronized (LoadingModelNode.class) {
			return loadingFiles.contains(modelFile);
		}
	}

	public int hashCode() {
		return modelFile.hashCode();
	}

	public boolean equals(Object o) {
		if (o instanceof LoadingModelNode) {
			return modelFile.equals(((LoadingModelNode) o).modelFile);
		}
		return false;
	}

	public String toString() {
		return "LoadingModelNode for " + modelFile.getName(); //$NON-NLS-1$
	}

}
