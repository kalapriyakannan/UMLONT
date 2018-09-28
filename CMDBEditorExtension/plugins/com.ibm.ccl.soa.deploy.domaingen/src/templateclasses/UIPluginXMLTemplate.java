package templateclasses;

import java.util.*;

public class UIPluginXMLTemplate
{
  protected static String nl;
  public static synchronized UIPluginXMLTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UIPluginXMLTemplate result = new UIPluginXMLTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL + "<plugin>" + NL + "<!-- Palette Provider -->" + NL + "   \t<extension point=\"org.eclipse.gmf.runtime.diagram.ui.paletteProviders\">" + NL + "    \t<paletteProvider" + NL + "        \tclass=\"org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider\">" + NL + "         \t<Priority" + NL + "         \t\tname=\"Medium\">" + NL + "         \t</Priority>" + NL + "         \t<editor" + NL + "            \tid=\"DeployCoreEditor\">" + NL + "         \t</editor>" + NL + "         \t<contribution" + NL + "            \tfactoryClass=\"com.ibm.ccl.soa.deploy.core.ui.providers.DeployCorePaletteFactory\">            \t        \t\t        <entry " + NL + "            \t\tlabel=\"%";
  protected final String TEXT_2 = "Stack.Label\" " + NL + "            \t\tkind=\"stack\" " + NL + "            \t\tdescription=\"%";
  protected final String TEXT_3 = "Stack.Description\" " + NL + "            \t\tsmall_icon=\"icons/pal/placeholder_16.gif\" " + NL + "            \t\tpath=\"/serverSoftwareDrawer/\" " + NL + "            \t\tid=\"";
  protected final String TEXT_4 = "Stack\">" + NL + "            \t</entry>           \t" + NL + "\t        </contribution>" + NL + "      \t</paletteProvider>" + NL + "   \t</extension>" + NL + "" + NL + "\t<!-- Deploy Core Editpart Provider -->" + NL + "  \t<extension point=\"org.eclipse.gmf.runtime.diagram.ui.editpartProviders\">" + NL + "      <editpartProvider class=\"";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "EditPartProvider\">" + NL + "         <Priority name=\"Medium\">" + NL + "         </Priority> " + NL + "         <object class=\"org.eclipse.gmf.runtime.notation.Node\" id=\"Nodes\">" + NL + "            <staticMethod " + NL + "                name=\"org.eclipse.gmf.runtime.diagram.core/org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.getSemanticEClassName(%Context[org.eclipse.gmf.runtime.notation/org.eclipse.gmf.runtime.notation.View])\"            \t " + NL + "            \tvalue=\"";
  protected final String TEXT_7 = "\">" + NL + "            </staticMethod>" + NL + "         </object>        " + NL + "         <object class=\"org.eclipse.gmf.runtime.notation.Node\" id=\"NodesByType\">" + NL + "        \t <method name=\"getType()\" value=\"module.";
  protected final String TEXT_8 = ", configurationUnit.";
  protected final String TEXT_9 = "\"/>" + NL + "\t     </object>" + NL + "        <context" + NL + "               views=\"NodesByType, Nodes\">" + NL + "         </context>" + NL + "      </editpartProvider>" + NL + "   \t</extension>" + NL + "   \t" + NL + "   \t<extension point=\"org.eclipse.gmf.runtime.diagram.core.viewProviders\">" + NL + "      <viewProvider class=\"com.ibm.ccl.soa.deploy.core.ui.providers.DeployCoreViewProvider\">" + NL + "         <Priority name=\"Medium\">" + NL + "         </Priority>" + NL + "         <object class=\"org.eclipse.gmf.runtime.emf.core.util.IProxyEObject(org.eclipse.gmf.runtime.emf.core)\" id=\"Nodes\">" + NL + "            <method name=\"getProxyClassID()\" value=\"";
  protected final String TEXT_10 = "\">" + NL + "            </method>" + NL + "         </object>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Node\" semanticHints=\"module.";
  protected final String TEXT_11 = ", configurationUnit.";
  protected final String TEXT_12 = "\">" + NL + "         </context>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Node\" semanticHints=\"\" elements=\"Nodes\">" + NL + "         </context>         " + NL + "      </viewProvider>" + NL + "   </extension>" + NL + "   " + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.type.core.elementTypes\">    \t" + NL + "    \t<metamodel" + NL + "                nsURI=\"";
  protected final String TEXT_13 = "\">" + NL + "\t    \t<metamodelType" + NL + "\t        \tid=\"";
  protected final String TEXT_14 = ".ModelObjectUnit\"            " + NL + "\t            name=\"%ModelObjectUnit.label\"" + NL + "\t            icon=\"icons/pal/placeholder_16.gif\"" + NL + "\t            eclass=\"ModelObjectUnit\"/>        " + NL + "        </metamodel> " + NL + "\t</extension>" + NL + "   " + NL + "" + NL + "</plugin>";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String lcModelPackagePrefix=(String)args.get(2); 
     String uri=(String)args.get(3); 
     String providersPackage=(String)args.get(4); 
     String values=""; 
     for (int i=5; i<args.size(); ++i) { 
     if (values.length() > 0) { values += ", "; } 
     values += lcModelPackagePrefix + "." + (String)args.get(i) + "Unit"; 
     } 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(providersPackage);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(values);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(values);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
