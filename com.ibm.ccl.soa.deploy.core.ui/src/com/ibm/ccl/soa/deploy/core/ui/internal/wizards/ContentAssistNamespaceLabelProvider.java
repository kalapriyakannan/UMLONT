/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.fieldassist.ContentAssistField;
import org.eclipse.wst.common.frameworks.datamodel.DataModelEvent;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelListener;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;

/**
 * This {@link ILabelProvider} is a specialization of the {@link NamespaceLabelProvider} for use
 * with {@link ContentAssistField}s displaying the namespace of a {@link Topology}. This
 * specialization is necessary since the element passed to get the text and image is not an
 * {@link IFolder}. Instead it is a {@link NamespaceContentProposal}. From the
 * {@link NamespaceContentProposal} we can get the wrapped {@link IFolder} and call the super
 * methods.
 * 
 */
public class ContentAssistNamespaceLabelProvider extends NamespaceLabelProvider implements
		IDataModelListener {
	private CreateTopologyDataModel dataModel;

	/**
	 * @param dataModel -
	 *           A {@link CreateTopologyDataModel} instance.
	 */
	public ContentAssistNamespaceLabelProvider(CreateTopologyDataModel dataModel) {
		super(dataModel.getSourceContainer());
		this.dataModel = dataModel;
		dataModel.getUnderlyingDataModel().addListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceLabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		return super.getText(((NamespaceContentProposal) element).getFolder());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceLabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		return super.getImage(((NamespaceContentProposal) element).getFolder());
	}

	/*
	 * If the SOURCE_PATH changes then we have to reset the sourceContainer to ensure that we are
	 * tracking the correct number of source path segments.
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelListener#propertyChanged(org.eclipse.wst.common.frameworks.datamodel.DataModelEvent)
	 */
	public void propertyChanged(DataModelEvent event) {
		if (event.getFlag() == DataModelEvent.VALUE_CHG
				&& ICreateTopologyDataModelProperties.SOURCE_PATH.equals(event.getPropertyName())) {
			super.setSourceContainer(dataModel.getSourceContainer());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceLabelProvider#dispose()
	 */
	public void dispose() {
		//Remove ourself as a listener to the data model.
		if (dataModel != null && dataModel.getUnderlyingDataModel() != null) {
			dataModel.getUnderlyingDataModel().removeListener(this);
		}
		super.dispose();
	}

}
