package test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class GenerationUtils {
	/**
	 * From Ed Snible
	 * 
	 * @param project
	 * @return
	 * 		Java codegen container
	 */
	public static IContainer getJavaCodegenContainer(IContainer project) {
		// Get the Java codegen path
		String pathFromWorkspace = getJavaCodegenPath(project);
		IPath pathJava = new Path(pathFromWorkspace);

		if (pathJava.segmentCount() == 1) {
			// ResourcesPlugin.getWorkspace().getRoot() won't search for
			// 1-segment folders, so
			// if the project's root folder is the Java classpath folder just
			// return that.
			return project;
		}

		// Convert that path to a folder. If the folder doesn't exist, create
		// it.
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot iwr = ws.getRoot();
		return iwr.getFolder(pathJava);
	}
	/**
	 * From Ed Snible
	 * 
	 * @param container
	 * @return
	 * 		String for Java codegen path
	 */
	public static String getJavaCodegenPath(IContainer container) {
		if (container instanceof IProject) {
			IProject proj = (IProject) container;

			try {
				if (proj.hasNature(JavaCore.NATURE_ID)) {
					IJavaProject javaProj = (IJavaProject) proj.getNature(JavaCore.NATURE_ID);
					IClasspathEntry[] resolved = javaProj.getResolvedClasspath(true);

					for (int i = 0; i < resolved.length; i++) {
						// Is this classpath entry a source classpath?
						if (resolved[i].getEntryKind() == IClasspathEntry.CPE_SOURCE &&
								resolved[i].getContentKind() == IPackageFragmentRoot.K_SOURCE) {

							IClasspathEntry ceForCodegen = resolved[i];
// System.out.println("@@@ Classpath for codegen " + ceForCodegen);

							return ceForCodegen.getPath().toString();
						}
					}
				}
			} catch (CoreException ce) {
				ce.printStackTrace();
			}
		}

		// Couldn't find Java; default to 'src'
		IFolder fld = container.getFolder(new Path("src"));
		IPath path = fld.getFullPath();
		String retVal = path.toString();
		return retVal;
	}

	/**
	 * From Ed Snible
	 * 
	 * @param destProjectFolder
	 * @param pkgName
	 * @param className
	 * @param javaString
	 * @throws CoreException
	 */
	public static void createJavaClass(IContainer destProjectFolder, String pkgName, String className, String javaString)
			throws CoreException {

		// Find java source folder
		IContainer javaSrcFolder = getJavaCodegenContainer(destProjectFolder);

		String convertedPkgName = pkgName.replace('.', '/');
		IFolder pluginPackageFolder = javaSrcFolder.getFolder(new Path(convertedPkgName));
		createFolderRecursively(pluginPackageFolder);

		String classFilename = className + ".java";
		IFile pluginClassFile = pluginPackageFolder.getFile(new Path(classFilename));

		InputStream is = new ByteArrayInputStream(javaString.getBytes());
		pluginClassFile.delete(true, null);
		pluginClassFile.create(is, true, null);
	}

	/**
	 * @param destProjectFolder
	 * @param xmlString
	 * @throws CoreException
	 */
	// 
	public static void createPluginXML(IContainer destProjectFolder, String xmlString) throws CoreException {

		IFile pluginXMLFile = destProjectFolder.getFile(new Path("plugin.xml"));

		InputStream is = new ByteArrayInputStream(xmlString.getBytes());
		pluginXMLFile.delete(true, null);
		pluginXMLFile.create(is, true, null);
	}

	/**
	 * @param destProjectFolder
	 * @param propertiesString
	 * @param propertiesFileName
	 * @throws CoreException
	 */
	// 
	public static void createPropertiesFile(IContainer destProjectFolder, String propertiesString,
			String propertiesFileName) throws CoreException {

		IFile pluginPropertiesFile = destProjectFolder.getFile(new Path(propertiesFileName));

		InputStream is = new ByteArrayInputStream(propertiesString.getBytes());
		pluginPropertiesFile.delete(true, null);
		pluginPropertiesFile.create(is, true, null);
	}

	/**
	 * @param destProjectFolder
	 * @param manifestString
	 * @param manifestFolderName
	 * @param manifestFileName
	 * @throws CoreException
	 */
	// 
	public static void createManifestFile(IContainer destProjectFolder, String manifestString,
			String manifestFolderName, String manifestFileName) throws CoreException {

		IFolder metaInfFolder = destProjectFolder.getFolder(new Path(manifestFolderName));
		createFolderRecursively(metaInfFolder);

		IFile manifestFile = metaInfFolder.getFile(new Path(manifestFileName));

		InputStream is = new ByteArrayInputStream(manifestString.getBytes());
		manifestFile.delete(true, null);
		manifestFile.create(is, true, null);
	}

	/**
	 * @param proj
	 * @param iconDir
	 * @param simpleClassName
	 * @param templateFileContents
	 * @throws CoreException
	 */
	public static void createTemplateFile(IProject proj, String iconDir, String simpleClassName,
			String templateFileContents) throws CoreException {

		IFolder iconFolder = proj.getFolder(new Path(iconDir));
		createFolderRecursively(iconFolder);

		String templateFilename = simpleClassName + "C.template";
		IFile templateFile = iconFolder.getFile(new Path(templateFilename));

		InputStream is = new ByteArrayInputStream(templateFileContents.getBytes());
		templateFile.delete(true, null);
		templateFile.create(is, true, null);
	}

	/**
	 * @param project
	 */
	public static void setupPluginProject(IProject project) {
		try {
			IProjectDescription description = null;
			description = project.getDescription();
			// PDE.PLUGIN_NATURE is internal
			description.setNatureIds(new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature" });
			project.setDescription(description, null);

			String srcFolder = "src";

			IJavaProject javaProj = JavaCore.create(project);
			IFolder srcDir = project.getFolder(srcFolder);
			srcDir.create(true, true, null);

			List<IClasspathEntry> newCpel = new LinkedList<IClasspathEntry>();
			javaProj.setRawClasspath(new IClasspathEntry[] {}, null);

			IPath srcPath = new Path(project.getFullPath() + "/" + srcFolder);
			IClasspathEntry srccpe = JavaCore.newSourceEntry(srcPath);
			newCpel.add(srccpe);
			newCpel
					.add(JavaCore
							.newContainerEntry(new Path(
									"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5")));
			newCpel.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
			IClasspathEntry icpeArray[] = (IClasspathEntry[]) newCpel.toArray(new IClasspathEntry[0]);
			javaProj.setRawClasspath(icpeArray, null);

			IFolder binDir = project.getFolder("bin");
			IPath binPath = binDir.getFullPath();
			javaProj.setOutputLocation(binPath, null);

		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	/**
	 * @param folder
	 * @throws CoreException
	 */
	public static void createFolderRecursively(IFolder folder) throws CoreException {
		IContainer parentFolder = folder.getParent();
		if (parentFolder instanceof IFolder) {
			createFolderRecursively((IFolder) parentFolder);
		}
		if (!folder.exists()) {
			folder.create(true, true, null);
		}
	}

	/**
	 * @param proj
	 * @param iconDir
	 * @throws CoreException
	 * @throws IOException
	 */
	public static void createIconFiles(IProject proj, String iconDir) throws CoreException, IOException {

		IFolder iconFolder = proj.getFolder(new Path(iconDir));
		createFolderRecursively(iconFolder);

		String iconFilenames[] = new String[] { "placeholder_16.gif", "placeholder_20.gif" };
		String sourceFolder = "icons/pal";
		String iconFolderPath = "platform:/plugin/com.ibm.ccl.soa.deploy.domaingen" + "/" + sourceFolder;

		for (int i = 0; i < iconFilenames.length; ++i) {
			IFile iconFileOut = iconFolder.getFile(new Path(iconFilenames[i]));
			// FIXME use appropriate Eclipse-style file I/O
			String iconFilePath = iconFolderPath + "/" + iconFilenames[i];
			URL url = new URL(iconFilePath);
			url = FileLocator.resolve(url);

			String urlString = url.toString();
			if (urlString.startsWith("file:/")) {
				urlString = urlString.substring(6);
			}
			File iconFile = new File(urlString);
			InputStream is = null;
			is = new FileInputStream(iconFile);

			iconFileOut.delete(true, null);
			iconFileOut.create(is, true, null);
		}
	}

}
