package templateclasses;

import java.util.*;

public class NonUIPluginXMLTemplate2
{
  protected static String nl;
  public static synchronized NonUIPluginXMLTemplate2 create(String lineSeparator)
  {
    nl = lineSeparator;
    NonUIPluginXMLTemplate2 result = new NonUIPluginXMLTemplate2();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL + "" + NL + "<!--" + NL + " <copyright>" + NL + " </copyright>" + NL + "" + NL + " $Id: NonUIPluginXMLTemplate2.java,v 1.3 2008/03/02 00:14:47 barnold Exp $" + NL + "-->" + NL + "" + NL + "<plugin>" + NL + "    " + NL + "  <extension point=\"org.eclipse.emf.edit.itemProviderAdapterFactories\">" + NL + "    <factory " + NL + "       uri = \"";
  protected final String TEXT_2 = "\" " + NL + "       class = \"";
  protected final String TEXT_3 = ".provider.";
  protected final String TEXT_4 = "ItemProviderAdapterFactory\" " + NL + "       supportedTypes = " + NL + "         \"org.eclipse.emf.edit.provider.IEditingDomainItemProvider" + NL + "          org.eclipse.emf.edit.provider.IStructuredItemContentProvider" + NL + "          org.eclipse.emf.edit.provider.ITreeItemContentProvider" + NL + "          org.eclipse.emf.edit.provider.IItemLabelProvider" + NL + "          org.eclipse.emf.edit.provider.IItemPropertySource\" />" + NL + "  </extension>" + NL + "" + NL + "  <extension point=\"org.eclipse.emf.ecore.generated_package\">" + NL + "    <package" + NL + "       uri = \"";
  protected final String TEXT_5 = "\"" + NL + "       class = \"";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = "Package\" />" + NL + "  </extension>" + NL + "" + NL + "  <extension point=\"org.eclipse.emf.ecore.extension_parser\">" + NL + "    <parser" + NL + "       type=\"";
  protected final String TEXT_8 = "\"" + NL + "       class=\"";
  protected final String TEXT_9 = ".util.";
  protected final String TEXT_10 = "ResourceFactoryImpl\" />" + NL + "  </extension>" + NL + "  " + NL + "  <extension point=\"com.ibm.ccl.soa.deploy.core.domains\">" + NL + "    <domain" + NL + "       id=\"";
  protected final String TEXT_11 = ".domain\"" + NL + "       name=\"%extension.";
  protected final String TEXT_12 = "Domain\"" + NL + "       targetNamespace=\"";
  protected final String TEXT_13 = "\">" + NL + "       <validator class=\"";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "DomainValidator\"/>";
  protected final String TEXT_16 = NL + "       <resourceType" + NL + "             id=\"";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ".conceptual\"" + NL + "             name=\"";
  protected final String TEXT_19 = "\"" + NL + "             templateURI=\"platform:/plugin";
  protected final String TEXT_20 = "/templates/";
  protected final String TEXT_21 = "C.template\">" + NL + "       </resourceType>" + NL + "       <resourceTypeUIBinding" + NL + "             description=\"%";
  protected final String TEXT_22 = "Tool.Description\"" + NL + "             label=\"%";
  protected final String TEXT_23 = "Tool.Label\"" + NL + "             path=\"/serverSoftwareDrawer/";
  protected final String TEXT_24 = "Stack\"" + NL + "             smallIcon=\"icons/pal/placeholder_16.gif\"" + NL + "             largeIcon=\"icons/pal/placeholder_20.gif\"" + NL + "             resourceTypeId=\"";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ".conceptual\">" + NL + "       </resourceTypeUIBinding>";
  protected final String TEXT_27 = "       " + NL + "    </domain>" + NL + "  </extension>" + NL + "    " + NL + "" + NL + "</plugin>";
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String lcModelPackagePrefix=(String)args.get(2); 
     String uri=(String)args.get(3); 
     String modelDirectory=(String)args.get(4); 
     String domainValidatorPackage=(String)args.get(5); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(domainValidatorPackage);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_15);
     for (int i=6; i<args.size(); ++i) { 
     String capClassName=(String)args.get(i); 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(capClassName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(capClassName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelDirectory);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(capClassName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(capClassName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(capClassName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(capClassName);
    stringBuffer.append(TEXT_26);
     } 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
