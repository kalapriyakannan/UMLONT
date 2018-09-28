/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConfigurationEditPart;
import com.ibm.ccl.soa.deploy.os.FileSystemUnit;
import com.ibm.ccl.soa.deploy.os.LocalFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.NFSFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.OpenVmsFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.RemoteFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.SMBFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.SolarisFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.UnixFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.WindowsFileSystemUnit;
import com.ibm.ccl.soa.deploy.os.ui.OsUIMessages;
import com.ibm.ccl.soa.deploy.os.ui.figures.OsFigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class FileSystemUnitEditPart extends ConfigurationEditPart {
	/**
	 * @param view
	 */
	public FileSystemUnitEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}

		if (unit instanceof FileSystemUnit) {
			if (unit instanceof LocalFileSystemUnit) {
				if (unit instanceof WindowsFileSystemUnit) {
				} else if (unit instanceof UnixFileSystemUnit) {
					if (unit instanceof SolarisFileSystemUnit) {
						setCategory(OsUIMessages.FileSystemUnitEditPart_SolarisFileSystem);
					} else {
						setCategory(OsUIMessages.FileSystemUnitEditPart_UnixFileSystem);
					}
				} else if (unit instanceof OpenVmsFileSystemUnit) {
					setCategory(OsUIMessages.FileSystemUnitEditPart_OpenVMSFileSystem);
				} else {
					setCategory(OsUIMessages.FileSystemUnitEditPart_LocalFileSystem);
				}
			} else if (unit instanceof RemoteFileSystemUnit) {
				if (unit instanceof NFSFileSystemUnit) {
					setCategory(OsUIMessages.FileSystemUnitEditPart_NFSFileSystem);
				} else if (unit instanceof SMBFileSystemUnit) {
					setCategory(OsUIMessages.FileSystemUnitEditPart_SMBFileSystem);
				} else {
					setCategory(OsUIMessages.FileSystemUnitEditPart_RemoteFileSystem);
				}
			} else {
				setCategory(OsUIMessages.FileSystemUnitEditPart_FileSystem);
			}
		}
	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = OsFigureFactory.createNewConfigurationUserFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
