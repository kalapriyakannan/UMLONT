package com.ibm.ccl.soa.deploy.ide.tests.refactoring;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

import com.ibm.ccl.soa.deploy.core.test.TestWorkspace;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestPlugin;
import com.ibm.ccl.soa.deploy.ide.tests.Activator;
import com.ibm.ccl.soa.deploy.ide.tests.TopologyIdeTestsPlugin;

public class RefactoringTestsWorkspace extends TestWorkspace {
	
	public static final IWorkspaceRoot ROOT = ResourcesPlugin.getWorkspace().getRoot();
	protected static final String META_PROJECT_NAME = ".project";
	protected static final int COPY_BUFFER_SIZE = 4096;
	
	protected final Bundle testdataBundle;
	protected final IPath testdata;
	protected final String projectName;
	
	public RefactoringTestsWorkspace( String projectName ) {
		testdataBundle = Activator.getDefault().getBundle();
		testdata = new Path("testData/RefactoringTests.zip");
		this.projectName = projectName;
	}
	
	public IProject getRefactoringTestsProject() {
		return ROOT.getProject(projectName);
	}
	
	public IFile getTopologyA() {
		return getRefactoringTestsProject().getFile(new Path( "topologies/com/acme/topologies/A.topology" ) );
	}
	
	public IFile getTopologyADiagram() {
		return getRefactoringTestsProject().getFile(new Path( "topologies/com/acme/topologies/A.topologyv" ) );
	}
	
	public IFile getTopologyB() {
		return getRefactoringTestsProject().getFile(new Path( "topologies/com/acme/topologies/B.topology" ) );
	}
	
	public IFile getTopologyBDiagram() {
		return getRefactoringTestsProject().getFile(new Path( "topologies/com/acme/topologies/B.topologyv" ) );
	}
	
	public IFile getTopologyC() {
		return getRefactoringTestsProject().getFile(new Path( "topologies/com/acme/topologies/C.topology" ) );
	}
	
	public IFile getTopologyCDiagram() {
		return getRefactoringTestsProject().getFile(new Path( "topologies/com/acme/topologies/C.topologyv" ) );
	}
	
	public void init() throws CoreException, IOException {

		preclean();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath projectPath = new Path("/" + projectName + "/" + META_PROJECT_NAME); //$NON-NLS-1$//$NON-NLS-2$
		IPath path = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(projectPath);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if(!project.exists()) {
			IProjectDescription description = new ProjectDescription();
			description.setName(projectName);
			project.create(description, null);
			project.open(null);
		} else {
			project.getDescription().setName(projectName);
		}
		
		URL url = FileLocator.toFileURL(FileLocator.find(testdataBundle,testdata, Collections.EMPTY_MAP));
		expandZip(project, new Path(url.getPath()));
		
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch ( CoreException ex ) {
		}
	}
	
	protected void expandZip(IProject project, IPath location) throws CoreException, IOException {

		ZipFile zipFile = new ZipFile(location.toFile());
		Enumeration entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) entries.nextElement();

			File aFile = computeLocation(project, entry.getName()).toFile();
			File parentFile = null;
			if (entry.isDirectory()) {
				aFile.mkdirs();
			} else {
				parentFile = aFile.getParentFile();
				if (!parentFile.exists())
					parentFile.mkdirs();
				if (!aFile.exists())
					aFile.createNewFile();
				copy(zipFile.getInputStream(entry), new FileOutputStream(aFile));
				if (entry.getTime() > 0)
					aFile.setLastModified(entry.getTime());
			}
		}
	}
	
	protected IPath computeLocation(IProject project, String name) {
		IPath path = new Path(name);
		path = path.removeFirstSegments(1);
		return ResourcesPlugin.getWorkspace().getRoot().getLocation().append(project.getFullPath().append(path));
	}
	
	protected void preclean() {
		IProject project = ROOT.getProject(projectName);
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
		}

		try {
			project.delete(true, null);
		} catch (CoreException e) {
		}
	}

	protected void dispose() throws CoreException {

		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			
			public void run(IProgressMonitor monitor) throws CoreException {
				IProject project = ROOT.getProject(projectName);
				if (project.exists())
					project.delete(true, monitor);
			}
		}, ResourcesPlugin.getWorkspace().getRoot(), IWorkspace.AVOID_UPDATE | IResource.DEPTH_INFINITE | IResource.FORCE, new NullProgressMonitor()); 
	}
	
	protected static void copy(InputStream in, OutputStream out)
		throws IOException {
		
		byte[] buffer = new byte[COPY_BUFFER_SIZE];
		try {
			int n = in.read(buffer);
			while (n > 0) {
				out.write(buffer, 0, n);
				n = in.read(buffer);
			}
		} finally {
			in.close();
			out.close();
		}
	}
}
