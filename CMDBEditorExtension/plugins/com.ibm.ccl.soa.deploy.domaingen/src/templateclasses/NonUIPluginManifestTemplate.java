package templateclasses;

import java.util.*;

public class NonUIPluginManifestTemplate
{
  protected static String nl;
  public static synchronized NonUIPluginManifestTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    NonUIPluginManifestTemplate result = new NonUIPluginManifestTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Manifest-Version: 1.0" + NL + "Bundle-ManifestVersion: 2" + NL + "Bundle-Name: %pluginName" + NL + "Bundle-SymbolicName: ";
  protected final String TEXT_2 = "; singleton:=true" + NL + "Bundle-Version: 1.0.0.qualified" + NL + "Bundle-ClassPath: ." + NL + "Bundle-Activator: ";
  protected final String TEXT_3 = ".Activator" + NL + "Bundle-Vendor: %providerName" + NL + "Bundle-Localization: plugin" + NL + "Export-Package: ";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = NL + " ";
  protected final String TEXT_6 = ".impl,";
  protected final String TEXT_7 = NL + " ";
  protected final String TEXT_8 = ".provider,";
  protected final String TEXT_9 = NL + " ";
  protected final String TEXT_10 = ".util" + NL + "Require-Bundle: org.eclipse.core.runtime," + NL + " org.eclipse.emf.ecore;visibility:=reexport," + NL + " org.eclipse.emf.ecore.xmi;visibility:=reexport," + NL + " com.ibm.ccl.soa.deploy.core;visibility:=reexport," + NL + " org.eclipse.emf.edit;visibility:=reexport," + NL + " org.eclipse.emf.ecore.edit;visibility:=reexport" + NL + "Eclipse-LazyStart: true";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String nonUIBundleId=(String)args.get(2); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(nonUIBundleId);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
