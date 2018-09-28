/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.widgets;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

public class AnimatedCheckBox extends Canvas implements PaintListener {
	private final Font categoryFont = new Font(null, new FontData("Tahoma", 10, SWT.BOLD));//$NON-NLS-1$
	private Image gif;
	private String fileName;
	private final String text;
	static Thread animateThread;
	private ImageLoader imageLoader = null;
	private ImageData[] imageDataArray;
	private Image image = null;
	private final List children = new ArrayList();
	private Label link;
	private static Path checkPath = new Path("/icons/images/check.gif"); //$NON-NLS-1$
	Image behindScreenImage;
	int imageDataIndex = 0;
	GC behindSIGC;
	private GC labelGC;
	GC canvasGC = new GC(this);
	ImageData imageData;
	Button button;
	Label imageLabel;
	private final Color colorBlue = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
	private final Color colorWhite = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
	boolean useGIFBackground = false;
	boolean shouldUnderLine = false;
	boolean check;

	public AnimatedCheckBox(Composite parent, int style, String text, int x, boolean child) {
		super(parent, SWT.NONE);
		this.text = text;
		setLayoutData(getDefaultLayoutData());
		setLayout(getDefaultLayout());
		setBackground(colorWhite);
		if (!child) {
			createNumber(this, x);
			createImage(this);
			createLabel(this);
			createError(this);
		}
	}

	private void createError(AnimatedCheckBox animatedCheckBoxWidget) {
		GridData data = new GridData();
		data.widthHint = 200;
		Label label = new Label(this, SWT.None);
		label.setLayoutData(data);
		label.setFont(categoryFont);
		label.setForeground(colorBlue);
		label.setBackground(colorWhite);

	}

	private void createNumber(Composite parent, int x) {
		GridData data = new GridData();
		Label label = new Label(parent, SWT.None);
		label.setBackground(colorWhite);
		label.setLayoutData(data);
		if (x == -1) {
			return;
		}
		label.setText(x + "."); //$NON-NLS-1$
		//label.setFont(categoryFont);
		//	label.setForeground(colorBlue);
		label.setBackground(colorWhite);

	}

	private String getFileName() {
		URL url = FileLocator.find(DeployCoreUIPlugin.getDefault().getBundle(), checkPath, null);
		try {
			url = Platform.asLocalURL(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Path(url.getPath()).toOSString();

	}

	private void createImage(Composite composite) {
		GridData data = new GridData();
		imageLabel = new Label(composite, SWT.NONE);
		imageLabel.setLayoutData(data);
		imageLabel.setBackground(colorWhite);
		fileName = getFileName();
		loadImage();

	}

	private void loadImage() {
		if (fileName != null) {
			imageLoader = new ImageLoader();
			imageDataArray = imageLoader.load(fileName);
			behindScreenImage = new Image(getDisplay(), imageLoader.logicalScreenWidth,
					imageLoader.logicalScreenHeight);
			behindSIGC = new GC(behindScreenImage);
			behindSIGC.setBackground(getBackground());
			behindSIGC.fillRectangle(0, 0, imageLoader.logicalScreenWidth,
					imageLoader.logicalScreenHeight);
			drawImage();
		}
	}

	private void drawImage() {
		try {
			int imageDataIndex = 0;
			imageData = imageDataArray[imageDataIndex];
			if (image != null && !image.isDisposed()) {
				image.dispose();
			}
			image = new Image(getDisplay(), imageData);
			imageLabel.setImage(behindScreenImage);
			behindSIGC.drawImage(image, 0, 0, imageData.width, imageData.height, imageData.x,
					imageData.y, imageData.width, imageData.height);
		} catch (SWTException ex) {
			ex.printStackTrace();
		}
	}

	private Object getDefaultLayoutData() {
		GridData data = new GridData();
		data.widthHint = 30;
		// data.
		return data;
	}

	private GridLayout getDefaultLayout() {
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
		layout.marginTop = 0;
		return layout;
	}

	private void createLabel(Composite parent) {
		GridData data = new GridData();
		link = new Label(parent, SWT.None);
		link.setLayoutData(data);
		link.setText(text);
		link.setFont(categoryFont);
		link.setForeground(colorBlue);
		link.setBackground(colorWhite);
		link.addPaintListener(this);

	}

	public void setChecked(boolean checked) {
		if (check == checked) {
			return;
		}
		check = checked;
		if (checked) {
			animate();
			setChildrenChecked(checked);
		} else {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					loadImage();

				}
			});

		}
	}

	private void setChildrenChecked(boolean childCheck) {
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			AnimatedCheckBox widget = (AnimatedCheckBox) iterator.next();
			widget.setChecked(childCheck);

		}

	}

	public void addMouseListener(MouseListener listener) {
		link.addMouseListener(listener);

	}

	private void animate() {
		Thread animateThread = createAnimateThread();
		animateThread.setPriority(Thread.MIN_PRIORITY);
		Display.getDefault().asyncExec(animateThread);

	}

	private Thread createAnimateThread() {
		Thread animateThread = new Thread("gif loader") { //$NON-NLS-1$
			public void run() {
				int repeatCount = 1;// imageLoader.repeatCount;
				while (imageLoader.repeatCount == 0 || repeatCount > 0) {
					buildBackGround();
					drawBackGroundImage();

					try {
						int milliSeconds = imageData.delayTime + 5 * 10;
						Thread.sleep(milliSeconds);
					} catch (InterruptedException e) {
					}

					if (imageDataIndex == imageDataArray.length - 1) {
						--repeatCount;
					}
				}
				imageLabel.setVisible(true);

			}

			private void buildBackGround() {
				switch (imageData.disposalMethod)
				{
				case SWT.DM_FILL_BACKGROUND:
					Color backgroundColor = null;
					if (useGIFBackground && imageLoader.backgroundPixel != -1) {
						backgroundColor = new Color(getDisplay(), imageData.palette
								.getRGB(imageLoader.backgroundPixel));
					}
					behindSIGC.setBackground(backgroundColor != null ? backgroundColor : colorBlue);
					behindSIGC
							.fillRectangle(imageData.x, imageData.y, imageData.width, imageData.height);
					if (backgroundColor != null) {
						backgroundColor.dispose();
					}
					break;
				case SWT.DM_FILL_PREVIOUS:
					behindSIGC.drawImage(image, 0, 0, imageData.width, imageData.height, imageData.x,
							imageData.y, imageData.width, imageData.height);
					break;
				}
			}

			private void drawBackGroundImage() {
				imageDataIndex = (imageDataIndex + 1) % imageDataArray.length;
				imageData = imageDataArray[imageDataIndex];
				image.dispose();
				image = new Image(getDisplay(), imageData);
				behindSIGC.drawImage(image, 0, 0, imageData.width, imageData.height, imageData.x,
						imageData.y, imageData.width, imageData.height);
				imageLabel.setVisible(false);
				canvasGC.drawImage(behindScreenImage, imageLabel.getBounds().x,
						imageLabel.getBounds().y);
			}
		};
		return animateThread;
	}

	public void addChild(String text, int style) {
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		AnimatedCheckBox child = new AnimatedCheckBox(this, SWT.NONE, text, 0, true);
		child.createNumber(child, -1);
		child.createImage(child);
		child.createLabel(child);
		child.createError(child);
		GridLayout childLayout = (GridLayout) child.getLayout();
		childLayout.marginWidth = 0;
		childLayout.marginHeight = 0;
		getParent().layout();
		new Label(this, SWT.NONE);
		children.add(child);
	}

	public void dispose() {
		if (categoryFont != null && !categoryFont.isDisposed()) {
			categoryFont.dispose();
		}
		if (gif != null && !gif.isDisposed()) {
			gif.dispose();
		}
		if (image != null && !image.isDisposed()) {
			image.dispose();
		}
		if (behindScreenImage != null && !behindScreenImage.isDisposed()) {
			behindScreenImage.dispose();
		}
		if (canvasGC != null && !canvasGC.isDisposed()) {
			canvasGC.dispose();
		}
		if (colorBlue != null && !colorBlue.isDisposed()) {
			colorBlue.dispose();
		}
		colorBlue.dispose();
		if (colorWhite != null && !colorWhite.isDisposed()) {
			colorWhite.dispose();
		}
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			Composite widget = (Composite) iterator.next();
			widget.dispose();
		}

		super.dispose();
	}

	public void paintControl(PaintEvent e) {
		GC gc = e.gc;
		labelGC = gc;
		Rectangle tangle = link.getBounds();
		if (shouldUnderLine) {
			gc.drawLine(0, tangle.height - 1, tangle.y + tangle.width, tangle.height - 1);
		}

	}

	public void setShouldUnderLine(boolean shouldUnderLine) {
		this.shouldUnderLine = shouldUnderLine;
	}

	public GC getLabelGC() {
		return labelGC;
	}

	public Label getLink() {
		return link;
	}

}
