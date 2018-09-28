package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;

public class IconUrlLabelProvider extends LabelProvider {
	private final Map<String, ImageDescriptor> urlToId = new HashMap<String, ImageDescriptor>();
	private final Map<ImageDescriptor, Image> idToImage = new HashMap<ImageDescriptor, Image>();

	public Image getImage(Object object) {

		if (object instanceof DynamicPaletteEntry) {
			DynamicPaletteEntry dpe = (DynamicPaletteEntry) object;
			return getImageForUrl(dpe.getLargeIcon());
		}

		return null;
	}

	public String getText(Object object) {

		return ""; //$NON-NLS-1$
	}

	private Image getImageForUrl(String url) {
		ImageDescriptor id = getImageDescriptor(url);
		return getImageFromDescriptor(id);
	}

	private Image getImageFromDescriptor(ImageDescriptor id) {
		if (id == null) {
			return null;
		}

		Image retVal = idToImage.get(id);
		if (retVal == null) {
			retVal = id.createImage();
			idToImage.put(id, retVal);
		}

		return retVal;
	}

	public ImageDescriptor getImageDescriptor(String url) {
		ImageDescriptor retVal = urlToId.get(url);
		if (retVal == null) {
			retVal = getIconDescriptor(url);
			urlToId.put(url, retVal);
		}

		return retVal;
	}

	private ImageDescriptor getIconDescriptor(String iconpath) {

		URL url;
		try {
			url = new URL(iconpath);
			url = FileLocator.resolve(url);
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		return ImageDescriptor.createFromURL(url);
	}

	@Override
	public void dispose() {
		for (Image image : idToImage.values()) {
			image.dispose();
		}

		idToImage.clear();

		super.dispose();
	}

}
