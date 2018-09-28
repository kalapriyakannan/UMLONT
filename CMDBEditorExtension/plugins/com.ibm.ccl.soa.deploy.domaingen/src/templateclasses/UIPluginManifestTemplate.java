package templateclasses;

import java.util.*;

public class UIPluginManifestTemplate
{
  protected static String nl;
  public static synchronized UIPluginManifestTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UIPluginManifestTemplate result = new UIPluginManifestTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Manifest-Version: 1.0" + NL + "Bundle-ManifestVersion: 2" + NL + "Bundle-Name: %pluginName" + NL + "Bundle-SymbolicName: ";
  protected final String TEXT_2 = ";singleton:=true" + NL + "Bundle-Version: 1.0.0.qualified" + NL + "Bundle-Activator: ";
  protected final String TEXT_3 = ".Activator" + NL + "Bundle-Vendor: %providerName" + NL + "Bundle-Localization: plugin" + NL + "Export-Package: ";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = NL + " ";
  protected final String TEXT_6 = ".editparts,";
  protected final String TEXT_7 = NL + " ";
  protected final String TEXT_8 = ".figures,";
  protected final String TEXT_9 = NL + " ";
  protected final String TEXT_10 = ".providers" + NL + "Require-Bundle: org.eclipse.ui," + NL + " org.eclipse.core.runtime,";
  protected final String TEXT_11 = NL + " ";
  protected final String TEXT_12 = "," + NL + " org.eclipse.gmf.runtime.diagram.ui," + NL + " org.eclipse.gmf.runtime.diagram.ui.providers," + NL + " com.ibm.ccl.soa.deploy.core.ui," + NL + " com.ibm.ccl.soa.deploy.core" + NL + "Bundle-RequiredExecutionEnvironment: J2SE-1.5" + NL + "Eclipse-LazyStart: true";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String uiPackagePrefix=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String nonUIBundleId=(String)args.get(2); 
     String uiBundleId=(String)args.get(3); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(uiBundleId);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(uiPackagePrefix);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(uiPackagePrefix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(uiPackagePrefix);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(uiPackagePrefix);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(uiPackagePrefix);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(nonUIBundleId);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
