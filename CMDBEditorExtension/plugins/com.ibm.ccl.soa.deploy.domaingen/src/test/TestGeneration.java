package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.core.runtime.content.IContentTypeManager;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.internal.util.emf.workbench.ProjectResourceSetImpl.ModuleURI;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;

import templateclasses.DomainMatcherTemplate;
import templateclasses.DomainValidatorTemplate;
import templateclasses.EditPartProviderTemplate;
import templateclasses.FigureFactoryTemplate;
import templateclasses.IDomainValidatorsTemplate;
import templateclasses.NonUIBundleActivatorTemplate;
import templateclasses.NonUIPluginManifestTemplate;
import templateclasses.NonUIPluginPropertiesAdditionsTemplate;
import templateclasses.NonUIPluginXMLTemplate2;
import templateclasses.UIBundleActivatorTemplate;
import templateclasses.UIPluginManifestTemplate;
import templateclasses.UIPluginPropertiesTemplate;
import templateclasses.UIPluginXMLTemplate;
import templateclasses.UnitEditPartTemplate;
import templateclasses.UnitFigureTemplate;
import templateclasses.UnitTemplateTemplate;
import templateclasses.UnitValidatorTemplate;

/**
 * @author barnold
 * 
 * TODO template ids for use by unit provider
 */
public class TestGeneration extends TestCase {

	String result;

	List<String> l = new ArrayList<String>();

	private HashMap<String, String> shortCapNameToShortCapSuperName;

	private HashMap<String, String> capNameToCapSuperName;

	private HashMap<String, String> capNameToShortCapName;

	/**
	 * 
	 */
	public TestGeneration() {
		super("TestGeneration"); //$NON-NLS-1$
	}

	public void testGeneration() throws Exception {
		doGeneration("platform:/plugin/com.ibm.ccl.soa.deploy.server/models/ecore/server.genmodel", new NullProgressMonitor());		
	}

	/**
	 * @param uriString
	 * @param monitor 
	 * @throws Exception
	 */
	public void doGeneration(String uriString, IProgressMonitor monitor) throws Exception {
		String result;

		GenModel gm = loadGenModel(uriString);
		GenJDKLevel gjdkl = gm.getComplianceLevel();
		GenJDKLevel cl = gm.getComplianceLevel();
		String editDirectory = gm.getEditDirectory();
		String editPluginClass = gm.getEditPluginClass();
		String editPluginClassName = gm.getEditPluginClassName();
		String editPluginDirectory = gm.getEditPluginDirectory();
		String editPluginID = gm.getEditPluginID();
		String editPluginPackageName = gm.getEditPluginPackageName();
		String editProjectDirectory = gm.getEditProjectDirectory();
		List<String> editQualifiedPackageNames = gm.getEditQualifiedPackageNames();
		EList<GenPackage> genPackages = gm.getGenPackages();
		GenPackage genPackage = genPackages.get(0);
		List<GenDataType> genDataType = genPackage.getAllGenDataTypes();
		String modelDirectory = gm.getModelDirectory();
		String modelName = gm.getModelName();
		String modelPluginClass = gm.getModelPluginClass();
		String modelPluginID = gm.getModelPluginID();
		String modelPluginPackageName = gm.getModelPluginPackageName();
		String modelProjectDirectory = gm.getModelProjectDirectory();
		List<String> modelQualifiedPackageNames = gm.getModelQualifiedPackageNames();
		String qualifiedEditPluginClassName = gm.getQualifiedEditPluginClassName();
		String qualifiedModelPluginClassName = gm.getQualifiedModelPluginClassName();
		String relativeGenModelLocation = gm.getRelativeGenModelLocation();
		EList<GenPackage> staticGenPackages = gm.getStaticGenPackages();
		EList<String> staticPackages = gm.getStaticPackages();
		EList<GenPackage> usedGenPackages = gm.getUsedGenPackages();

		String modelNamePrefix = coerceToCapabilized(modelName); // e.g
		// "CdmBase",
		// forced to
		// "Cdmbase"
		String lcModelNamePrefix = modelName.toLowerCase(); // e.g
		// "CdmBase",
		// forced to
		// "cdmbase"
		String shortestPN = null;
		for (String pn : modelQualifiedPackageNames) {
			if (shortestPN == null) {
				shortestPN = pn;
			} else {
				if (pn.length() < shortestPN.length()) {
					shortestPN = pn;
				}
			}
		}
		String modelPackage = shortestPN; // e.g "com.ibm.ccl.soa.deploy.cdmbase";

		List<String> unitClassNames = new ArrayList<String>();
		List<String> capabilityClassNames = new ArrayList<String>();
		List<String> capabilityClassShortNames = new ArrayList<String>();
		Collections.sort(unitClassNames);
		Collections.sort(capabilityClassNames);
		Collections.sort(capabilityClassShortNames);

		shortCapNameToShortCapSuperName = new HashMap<String, String>();
		capNameToCapSuperName = new HashMap<String, String>();
		capNameToShortCapName = new HashMap<String,String>();
		EPackage ecorePackage = genPackage.getEcorePackage();
		for (EClassifier ec : ecorePackage.getEClassifiers()) {
			if (ec instanceof EClass) {
				EClass eClass = (EClass) ec;
				String shortName = eClass.getName();
				if (shortName.endsWith("Unit")) {
					String shortCapName = shortName.substring(0, shortName.length() - "Unit".length());
					List<EClass> east = eClass.getEAllSuperTypes();
					// TODO find the superclass that has the most superclasses in the list
					String shortCapSuperName = east.get(east.size() - 1).getName();
					if (shortCapSuperName.endsWith("Unit")) {
						shortCapSuperName = shortCapSuperName.substring(0, shortCapSuperName.length() - "Unit".length());
					}
					String capSuperName = modelPackage + "." + shortCapSuperName; 
					String capName = modelPackage + "." + shortCapName; 
					capabilityClassShortNames.add(shortCapName);
					capabilityClassNames.add(capName);
					shortCapNameToShortCapSuperName.put(shortCapName, shortCapSuperName);
					capNameToCapSuperName.put(capName, capSuperName);
					System.out.println(shortCapName + "," + shortCapSuperName);
					System.out.println(capName + "," + capSuperName);
					capNameToShortCapName.put(capName, shortCapName);
					capNameToShortCapName.put(capSuperName, shortCapSuperName);
				}
			}
		}

		// TODO also need a map to translated name if there is one

		String projectName = modelProjectDirectory;
		String uiProjectName = modelProjectDirectory + ".ui"; // convention

		String packagePrefix = modelPackage; // e.g.
		// "com.ibm.ccl.soa.deploy.cdmbase";
		String nonUIPackagePrefix = modelPackage;
		String nonUIBundleId = modelPackage;
		String uiPackagePrefix = modelPackage + ".ui"; // convention. e.g.
		// "com.ibm.ccl.soa.deploy.cdmbase.ui";
		String uiBundleId = uiPackagePrefix;
		String domainMatcherPackage = packagePrefix + ".internal.validator.matcher";
		String domainValidatorPackage = packagePrefix + ".internal.validator";
		String editPartProviderPackage = uiPackagePrefix + ".providers";
		String iDomainValidatorsPackage = packagePrefix + ".validator"; // ???
		String unitEditPartPackageSuffix = ".editparts";
		String unitEditPartPackage = uiPackagePrefix + unitEditPartPackageSuffix;
		String unitFiguresPackage = uiPackagePrefix + ".figures"; // Needed?
		String unitFilterPackage = packagePrefix + ".internal.filter";
		String unitValidatorPackage = packagePrefix + ".internal.validator";
		String uri = ecorePackage.getNsURI();

		// ------------------------
		// for each type
		monitor.beginTask("Generating", capabilityClassNames.size()*3 + 17);
		createIconFiles("icons/pal", projectName);
		monitor.worked(1);
		createIconFiles("icons/pal", uiProjectName);
		monitor.worked(1);
		createIconFiles("icons/dgm", uiProjectName);
		monitor.worked(1);

		for (String capabilityClassName : capabilityClassNames) {
			generateUnitValidator(modelPackage, modelNamePrefix, unitValidatorPackage, capabilityClassName, projectName);
			monitor.worked(1);
			generateUnitEditPart(modelPackage, modelNamePrefix, unitEditPartPackage, capabilityClassName, uiProjectName, unitEditPartPackageSuffix);
			monitor.worked(1);
			generateUnitTemplate(modelPackage, uri, capabilityClassName, lcModelNamePrefix, projectName);
			monitor.worked(1);
		}

		// ------------------------
		generateDomainValidator(modelPackage, modelNamePrefix, domainValidatorPackage, capabilityClassShortNames,
				projectName);
		monitor.worked(1);		
		generateDomainMatcher(modelPackage, modelNamePrefix, domainMatcherPackage, projectName);
		monitor.worked(1);
		generateUnitFigure(modelPackage, modelNamePrefix, unitFiguresPackage, uiProjectName);
		monitor.worked(1);
		generateFigureFactory(modelPackage, modelNamePrefix, unitFiguresPackage, uiProjectName);
		monitor.worked(1);
		generateEditPartProvider(modelPackage, modelNamePrefix, editPartProviderPackage, unitEditPartPackage,
				capabilityClassShortNames, uiProjectName);
		monitor.worked(1);
		generateIDomainValidators(modelPackage, modelNamePrefix, iDomainValidatorsPackage, projectName);
		monitor.worked(1);

		generateNonUIPluginXML(modelPackage, modelNamePrefix, lcModelNamePrefix, uri, modelProjectDirectory,
				domainValidatorPackage, capabilityClassShortNames, projectName);
		monitor.worked(1);
		generateUIPluginXML(modelPackage, modelNamePrefix, lcModelNamePrefix, uri, editPartProviderPackage,
				capabilityClassShortNames, uiProjectName);
		monitor.worked(1);

		generateUIPluginProperties(modelNamePrefix, lcModelNamePrefix, uiProjectName);
		monitor.worked(1);
		generateNonUIPluginPropertiesAdditions(modelNamePrefix, lcModelNamePrefix, capabilityClassShortNames,
				projectName);
		monitor.worked(1);

		generateNonUIPluginManifest(modelPackage, modelNamePrefix, nonUIBundleId, projectName);
		monitor.worked(1);
		generateuiPluginManifest(uiPackagePrefix, modelNamePrefix, nonUIBundleId, uiBundleId, uiProjectName);
		monitor.worked(1);
		generateNonUIBundleActivator(nonUIPackagePrefix, projectName);
		monitor.worked(1);
		generateUIBundleActivator(uiPackagePrefix, uiProjectName);
		monitor.worked(1);
		monitor.done();
	}

	private void generateUIBundleActivator(String uiPackagePrefix, String projectName) throws CoreException {
		UIBundleActivatorTemplate uibat = new UIBundleActivatorTemplate();
		l.clear();
		l.add(uiPackagePrefix);
		result = uibat.generate(l);
//		System.out.println(result);

		createJavaClassFile(uiPackagePrefix, projectName, "Activator", result);
	}

	private void generateNonUIBundleActivator(String nonUIPackagePrefix, String projectName) throws CoreException {
		NonUIBundleActivatorTemplate nuibat = new NonUIBundleActivatorTemplate();
		l.clear();
		l.add(nonUIPackagePrefix);
		result = nuibat.generate(l);
//		System.out.println(result);

		createJavaClassFile(nonUIPackagePrefix, projectName, "Activator", result);
	}

	private void generateuiPluginManifest(String uiPackagePrefix, String modelNamePrefix, String nonUIBundleId,
			String uiBundleId, String uiProjectName) throws CoreException {
		UIPluginManifestTemplate uipmt = new UIPluginManifestTemplate();
		l.clear();
		l.add(uiPackagePrefix);
		l.add(modelNamePrefix);
		l.add(nonUIBundleId);
		l.add(uiBundleId);
		result = uipmt.generate(l);
//		System.out.println(result);

		createManifestFile(uiProjectName, result, "META-INF", "MANIFEST.MF");
	}

	private void generateNonUIPluginManifest(String modelPackage, String modelNamePrefix, String nonUIBundleId,
			String projectName) throws CoreException {
		NonUIPluginManifestTemplate nuipmt = new NonUIPluginManifestTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(nonUIBundleId);
		result = nuipmt.generate(l);
//		System.out.println(result);

		createManifestFile(projectName, result, "META-INF", "MANIFEST.MF");
	}

	private void generateNonUIPluginPropertiesAdditions(String modelNamePrefix, String lcModelNamePrefix,
			List<String> capabilityClassShortNames, String projectName) throws CoreException {
		NonUIPluginPropertiesAdditionsTemplate nuippat = new NonUIPluginPropertiesAdditionsTemplate();
		l.clear();
		l.add(modelNamePrefix);
		l.add(lcModelNamePrefix);
		l.addAll(capabilityClassShortNames);
		result = nuippat.generate(l);
//		System.out.println(result);

		createPropertiesFile(projectName, result, "plugin.properties.additions");
	}

	private void generateUIPluginProperties(String modelNamePrefix, String lcModelNamePrefix, String uiProjectName)
			throws CoreException {
		UIPluginPropertiesTemplate uippt = new UIPluginPropertiesTemplate();
		l.clear();
		l.add(modelNamePrefix);
		l.add(lcModelNamePrefix);
		result = uippt.generate(l);
//		System.out.println(result);

		createPropertiesFile(uiProjectName, result, "plugin.properties");
	}

	private void generateUIPluginXML(String modelPackage, String modelNamePrefix, String lcModelNamePrefix, String uri,
			String editPartProviderPackage, List<String> capabilityClassShortNames, String uiProjectName)
			throws CoreException {
		UIPluginXMLTemplate uipxmlt = new UIPluginXMLTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(lcModelNamePrefix);
		l.add(uri);
		l.add(editPartProviderPackage);
		l.addAll(capabilityClassShortNames);
		result = uipxmlt.generate(l);
//		System.out.println(result);

		createPluginXMLFile(uiProjectName, result);
	}

	private void generateNonUIPluginXML(String modelPackage, String modelNamePrefix, String lcModelNamePrefix,
			String uri, String modelProjectDirectory, String domainValidatorPackage,
			List<String> capabilityClassShortNames, String projectName) throws CoreException {
		NonUIPluginXMLTemplate2 nuipxmlt = new NonUIPluginXMLTemplate2();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(lcModelNamePrefix);
		l.add(uri);
		l.add(modelProjectDirectory);
		l.add(domainValidatorPackage);
		// pass each capability class name (proxies for CDM MO name)
		l.addAll(capabilityClassShortNames);
		result = nuipxmlt.generate(l);
//		System.out.println(result);

		createPluginXMLFile(projectName, result);
	}

	private void generateIDomainValidators(String modelPackage, String modelNamePrefix,
			String iDomainValidatorsPackage, String projectName) throws CoreException {
		// Sample registry of validator ids
		IDomainValidatorsTemplate idvt = new IDomainValidatorsTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(iDomainValidatorsPackage);
		result = idvt.generate(l);
//		System.out.println(result);

		createJavaClassFile(iDomainValidatorsPackage, projectName, "I" + modelNamePrefix + "DomainValidators", result);
	}

	private void generateEditPartProvider(String modelPackage, String modelNamePrefix, String editPartProviderPackage,
			String unitEditPartPackage, List<String> capabilityClassShortNames, String uiProjectName)
			throws CoreException {
		EditPartProviderTemplate eppt = new EditPartProviderTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(editPartProviderPackage);
		l.add(unitEditPartPackage);
		l.addAll(capabilityClassShortNames);
		result = eppt.generate(l);
//		System.out.println(result);

		createJavaClassFile(editPartProviderPackage, uiProjectName, modelNamePrefix + "EditPartProvider", result);
	}

	private void generateFigureFactory(String modelPackage, String modelNamePrefix, String unitFiguresPackage,
			String uiProjectName) throws CoreException {
		FigureFactoryTemplate fft = new FigureFactoryTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(unitFiguresPackage);
		result = fft.generate(l);
//		System.out.println(result);

		createJavaClassFile(unitFiguresPackage, uiProjectName, modelNamePrefix + "FigureFactory", result);
	}

	private void generateUnitFigure(String modelPackage, String modelNamePrefix, String unitFiguresPackage,
			String uiProjectName) throws CoreException {
		UnitFigureTemplate uft = new UnitFigureTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(unitFiguresPackage);
		result = uft.generate(l);
//		System.out.println(result);

		createJavaClassFile(unitFiguresPackage, uiProjectName, modelNamePrefix + "UnitFigure", result);
	}

	private void generateDomainMatcher(String modelPackage, String modelNamePrefix, String domainMatcherPackage,
			String projectName) throws CoreException {
		DomainMatcherTemplate dmt = new DomainMatcherTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(domainMatcherPackage);
		result = dmt.generate(l);
//		System.out.println(result);

		createJavaClassFile(domainMatcherPackage, projectName, modelNamePrefix + "DomainMatcher", result);
	}

	private void generateDomainValidator(String modelPackage, String modelNamePrefix, String domainValidatorPackage,
			List<String> capabilityClassShortNames, String projectName) throws CoreException {
		DomainValidatorTemplate dvt = new DomainValidatorTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(domainValidatorPackage);
		l.addAll(capabilityClassShortNames);
		result = dvt.generate(l);
//		System.out.println(result);

		createJavaClassFile(domainValidatorPackage, projectName, modelNamePrefix + "DomainValidator", result);
	}

	private void generateUnitTemplate(String modelPackage, String uri, String capabilityClassName,
			String lcModelNamePrefix, String projectName) throws CoreException {
		// placeholder templates, one for each capability class name
		// (proxies for CDM MO name)
		UnitTemplateTemplate utt = new UnitTemplateTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(uri);
		l.add(simpleNameForClassName(capabilityClassName));
		l.add(coerceToLowerCaseFirstChar(simpleNameForClassName(capabilityClassName)));
		l.add(lcModelNamePrefix);
		result = utt.generate(l);
//		System.out.println(result);

		createTemplateFile("templates", projectName, simpleNameForClassName(capabilityClassName), result);
	}

	private void generateUnitEditPart(String modelPackage, String modelNamePrefix, String unitEditPartPackage,
			String capabilityClassName, String uiProjectName, String unitEditPartPackageSuffix) throws CoreException {
		UnitEditPartTemplate uept = new UnitEditPartTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(unitEditPartPackage);
		l.add(simpleNameForClassName(capabilityClassName));
		// FIXME
		// TODO use a computed
		// capabilility typename to
		// capability supertypename map
//		String capabilityClassSuperName = getSuperClassName(capabilityClassName);
		String capabilityClassSuperName = capNameToCapSuperName.get(capabilityClassName);
		// Special case for ModelObject
		if (capabilityClassSuperName.endsWith(".Capability")) {
			l.add("");
			l.add("");
		} else {
			l.add(simpleNameForClassName(capabilityClassSuperName));
			l.add(packageFor(capabilityClassSuperName)+".ui"+unitEditPartPackageSuffix);
		}
		result = uept.generate(l);
//		System.out.println(result);
		createJavaClassFile(unitEditPartPackage, uiProjectName, simpleNameForClassName(capabilityClassName) +
				"UnitEditPart", result);
	}

	private void generateUnitValidator(String modelPackage, String modelNamePrefix, String unitValidatorPackage,
			String capabilityClassName, String projectName) throws CoreException {
		UnitValidatorTemplate uvt = new UnitValidatorTemplate();
		l.clear();
		l.add(modelPackage);
		l.add(modelNamePrefix);
		l.add(unitValidatorPackage);
		l.add(simpleNameForClassName(capabilityClassName));
		// FIXME
		// TODO use a computed
		// capabilility typename to
		// capability supertypename map
		String capabilityClassSuperName = capNameToCapSuperName.get(capabilityClassName);
		// Special case for ModelObject
		if (capabilityClassSuperName.endsWith(".Capability")) {
			l.add("");
			l.add("");
		} else {
			String simpleCapSuperClassName = simpleNameForClassName(capabilityClassSuperName);
			l.add(simpleCapSuperClassName);
			String superUnitValidatorPackage = packageFor(capabilityClassSuperName);
			// TODO confirm that this class exists by trying to load it.
			l.add(superUnitValidatorPackage + ".internal.validator." + simpleCapSuperClassName + "UnitValidator");
		}
		result = uvt.generate(l);
//		System.out.println(result);
		createJavaClassFile(unitValidatorPackage, projectName, simpleNameForClassName(capabilityClassName) +
				"UnitValidator", result);
	}

	/**
	 * Returned value does not include a final "."
	 * @param className
	 * @return
	 */
	private String packageFor(String className) {
		int lastDotIndex = className.lastIndexOf(".");
		if (lastDotIndex == -1) {
			return null;
		} else {
			if (className.length() > lastDotIndex + 1) {
				return className.substring(0, lastDotIndex);
			} else {
				return null;
			}
		}
	}

	private GenModel loadGenModel(String url) {
		URI templateURI = URI.createURI(url);
// Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new
// EnvelopeResourceFactoryImpl());
		String segment = templateURI.segment(ModuleURI.CONTENT_TYPE_INDX);
		IContentTypeManager ctm = Platform.getContentTypeManager();
		IContentType ct = ctm.getContentType(segment);
		Platform.getContentTypeManager().getContentType(segment);
		Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(templateURI, true);
		GenModel gm = (GenModel) resource.getContents().get(0);

		return gm;
	}

//	private static String getSuperClassName(String className) {
//		Class<?> c = nameToClass(className);
//		if (c != null) {
//			Class<?>[] is = c.getInterfaces();
//			assert is.length == 1;
//
//			Class<?> superC = is[0];
//			if (superC != null) {
//				return superC.getName();
//			}
//		}
//		return null;
//	}

//	
// private static String getSuperNameClassForCapUsingCDMTypes(String className)
// {
// return null;
// }

//	private static Class<?> nameToClass(String className) {
//		try {
//			return Class.forName(className);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

//	private static String simpleNameForClassName(String className) {
//		try {
//			assert (className != null);
//			Class<?> cn = Class.forName(className);
//			return cn.getSimpleName();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	private String simpleNameForClassName(String className) {
		System.out.println(className + "," + capNameToShortCapName.get(className));
		return capNameToShortCapName.get(className);
	}

	/**
	 * @param pkgName
	 * @param projectName
	 * @param className
	 * @param javaFileContents
	 * @throws CoreException
	 */
	public static void createJavaClassFile(String pkgName, String projectName, String className, String javaFileContents)
			throws CoreException {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IProject proj = ws.getRoot().getProject(projectName);
		if (!proj.exists()) {
			proj.create(null);
			proj.open(null);
			GenerationUtils.setupPluginProject(proj);
		} else {
			proj.open(null);
		}
		GenerationUtils.createJavaClass(proj, pkgName, className, javaFileContents);
	}

	/**
	 * @param projectName
	 * @param xmlFileContents
	 * @throws CoreException
	 */
	public static void createPluginXMLFile(String projectName, String xmlFileContents) throws CoreException {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IProject proj = ws.getRoot().getProject(projectName);
		if (!proj.exists()) {
			proj.create(null);
			proj.open(null);
			GenerationUtils.setupPluginProject(proj);
		} else {
			proj.open(null);
		}
		GenerationUtils.createPluginXML(proj, xmlFileContents);
	}

	/**
	 * Create in root.
	 * 
	 * @param projectName
	 * @param propertiesFileContents
	 * @param propertiesFileName
	 * @throws CoreException
	 */
	public static void createPropertiesFile(String projectName, String propertiesFileContents, String propertiesFileName)
			throws CoreException {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IProject proj = ws.getRoot().getProject(projectName);
		if (!proj.exists()) {
			proj.create(null);
			proj.open(null);
			GenerationUtils.setupPluginProject(proj);
		} else {
			proj.open(null);
		}
		GenerationUtils.createPropertiesFile(proj, propertiesFileContents, propertiesFileName);
	}

	/**
	 * Create in root.
	 * 
	 * @param projectName
	 * @param manifestFileContents
	 * @param manifestFolderName
	 * @param manifestFileName
	 * @throws CoreException
	 */
	public static void createManifestFile(String projectName, String manifestFileContents, String manifestFolderName,
			String manifestFileName) throws CoreException {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IProject proj = ws.getRoot().getProject(projectName);
		if (!proj.exists()) {
			proj.create(null);
			proj.open(null);
			GenerationUtils.setupPluginProject(proj);
		} else {
			proj.open(null);
		}
		GenerationUtils.createManifestFile(proj, manifestFileContents, manifestFolderName, manifestFileName);
	}

	/**
	 * @param templateFolder
	 * @param projectName
	 * @param simpleClassName
	 * @param templateFileContents
	 * @throws CoreException
	 */
	public static void createTemplateFile(String templateFolder, String projectName, String simpleClassName,
			String templateFileContents) throws CoreException {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IProject proj = ws.getRoot().getProject(projectName);
		if (!proj.exists()) {
			proj.create(null);
			proj.open(null);
			GenerationUtils.setupPluginProject(proj);
		} else {
			proj.open(null);
		}
		GenerationUtils.createTemplateFile(proj, templateFolder, simpleClassName, templateFileContents);
	}
	

	/**
	 * @param iconFolder 
	 * @param projectName
	 * @throws CoreException
	 * @throws IOException 
	 */
	public static void createIconFiles(String iconFolder, String projectName) 
			throws CoreException, IOException {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IProject proj = ws.getRoot().getProject(projectName);
		if (!proj.exists()) {
			proj.create(null);
			proj.open(null);
			GenerationUtils.setupPluginProject(proj);
		} else {
			proj.open(null);
		}
		GenerationUtils.createIconFiles(proj, iconFolder);
	}

	// Convert string to upper case first character, lower case otherwise.
	// This appears (todo verify) the convention for code genned from a
	// genmodel.
	private static String coerceToCapabilized(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		if (s.length() == 1) {
			return s.toUpperCase();
		}
		String first = s.substring(0, 1);
		String rest = s.substring(1);
		return first.toUpperCase() + rest.toLowerCase();
	}

	// Convert string to lower case first character, unchanged otherwise
	private static String coerceToLowerCaseFirstChar(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		if (s.length() == 1) {
			return s.toLowerCase();
		}
		String first = s.substring(0, 1);
		String rest = s.substring(1);
		return first.toLowerCase() + rest;
	}

}
