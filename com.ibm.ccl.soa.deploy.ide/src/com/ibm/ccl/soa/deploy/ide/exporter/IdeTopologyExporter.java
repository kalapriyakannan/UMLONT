/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.exporter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.export.ExportOptionConstants;
import com.ibm.ccl.soa.deploy.core.export.ExportOptionsMetaData;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.index.search.Query;

/**
 * @since 7.0
 * 
 */
public class IdeTopologyExporter extends TopologyExporter {

	private ExportOptionsMetaData options;
	private Topology topology;

	/**
	 * export the topology
	 */
	public Resource[] export(Topology aTopology, ExportOptionsMetaData aOptions) {
		options = aOptions;
		topology = aTopology;
		List<Resource> result = new ArrayList<Resource>();
		result.add(aTopology.eResource());
		result.addAll(getDiagramResources());
		return result.toArray(new Resource[result.size()]);
	}

	public int[] getSupportedOutputOptions() {
		return new int[] { ExportOptionConstants.OUTPUT_AS_ZIP };
	}

	public IStatus validate(Topology aTopology) {
		// TODO Auto-generated method stub
		return Status.OK_STATUS;

	}

	/**
	 * the option to export the diagram resource if present
	 * 
	 * @return the option to export the diagram resource if present
	 */
	protected boolean isExportDiagramResourceIfPresent() {
		return this.getExportOptions().isExportDiagramResourceIfPresent();
	}

	private List<Resource> getDiagramResources() {
		List<Resource> result = new ArrayList<Resource>();
		//export the diagram file if present
		if (isExportDiagramResourceIfPresent()) {

			Collection<IFile> c;
			try {
				c = Query.findReferencingDiagramResources(getTopology(), null, true, false, true,
						false, new NullProgressMonitor());
				for (Iterator<IFile> iterator = c.iterator(); iterator.hasNext();) {
					IFile file = iterator.next();
					result.add(WorkbenchResourceHelperBase.getResource(file, true));
				}
			} catch (CoreException e) {
				IDEPlugin.logError(0, "", e); //$NON-NLS-1$
			}
		}
		return result;
	}

	private ExportOptionsMetaData getExportOptions() {
		return options;
	}

	private Topology getTopology() {
		return topology;
	}
}
