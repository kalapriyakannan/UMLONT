package templateclasses;

import java.util.*;

public class UIBundleActivatorTemplate
{
  protected static String nl;
  public static synchronized UIBundleActivatorTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UIBundleActivatorTemplate result = new UIBundleActivatorTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.ui.plugin.AbstractUIPlugin;" + NL + "import org.osgi.framework.BundleContext;" + NL + "" + NL + "/**" + NL + " * The activator class controls the plug-in life cycle" + NL + " */" + NL + "public class Activator extends AbstractUIPlugin {" + NL + "" + NL + "\t/**" + NL + "\t * The plug-in ID" + NL + "\t */" + NL + "\tpublic static final String PLUGIN_ID = \"";
  protected final String TEXT_3 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t// The shared instance" + NL + "\tprivate static Activator plugin;" + NL + "\t" + NL + "\t/**" + NL + "\t * The constructor" + NL + "\t */" + NL + "\tpublic Activator() {" + NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t * (non-Javadoc)" + NL + "\t * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)" + NL + "\t */" + NL + "\t@Override" + NL + "\tpublic void start(BundleContext context) throws Exception {" + NL + "\t\tsuper.start(context);" + NL + "\t\tplugin = this;" + NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t * (non-Javadoc)" + NL + "\t * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)" + NL + "\t */" + NL + "\t@Override" + NL + "\tpublic void stop(BundleContext context) throws Exception {" + NL + "\t\tplugin = null;" + NL + "\t\tsuper.stop(context);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns the shared instance" + NL + "\t *" + NL + "\t * @return the shared instance" + NL + "\t */" + NL + "\tpublic static Activator getDefault() {" + NL + "\t\treturn plugin;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String uiPackagePrefix=(String)args.get(0); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(uiPackagePrefix);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(uiPackagePrefix);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
