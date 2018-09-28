package templateclasses;

import java.util.*;

public class UnitFilterTemplate
{
  protected static String nl;
  public static synchronized UnitFilterTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UnitFilterTemplate result = new UnitFilterTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/***************************************************************************************************" + NL + " * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights" + NL + " * reserved." + NL + " * " + NL + " * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + " * Schedule Contract with IBM Corp." + NL + " * " + NL + " * Contributors: IBM Corporation - initial API and implementation" + NL + " **************************************************************************************************/" + NL + "" + NL + "package ";
  protected final String TEXT_2 = ".internal.filter;" + NL + "" + NL + "import java.util.Arrays;" + NL + "import java.util.Collections;" + NL + "import java.util.List;" + NL + "" + NL + "import com.ibm.ccl.soa.deploy.core.Unit;" + NL + "import com.ibm.ccl.soa.deploy.core.UnitFilter;" + NL + "import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;" + NL + "import ";
  protected final String TEXT_3 = ".I";
  protected final String TEXT_4 = "TemplateConstants;" + NL + "import ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "Unit;" + NL + "import ";
  protected final String TEXT_7 = ".*;" + NL + "import ";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = "Package;" + NL + "" + NL + "/**" + NL + " * Suggests {@link Unit} types to be contained by an {@link ";
  protected final String TEXT_10 = "Unit}." + NL + " * " + NL + " * &lt;unitFilter&gt; registered on the <code>com.ibm.ccl.soa.deploy.core.unitLifecycle</code>" + NL + " * extension." + NL + " * " + NL + " * @see ";
  protected final String TEXT_11 = "Unit" + NL + " */" + NL + "public class ";
  protected final String TEXT_12 = "UnitFilter extends UnitFilter {" + NL + "" + NL + "\t/**" + NL + "\t * Add constants from I";
  protected final String TEXT_13 = "TemplateConstants, representing ids for classes to be " + NL + "\t * presented as possible hostees by ModelingAssistant to this list" + NL + "\t */" + NL + "\tprivate final static List<String> generic";
  protected final String TEXT_14 = "HostingUnitTypes = Collections" + NL + "\t\t\t.unmodifiableList(Arrays.asList(new String[] {}));" + NL + "" + NL + "\t/**" + NL + "\t * Clients don't call this directly; it should be called through DeployableUnitElementUIService" + NL + "\t * or GMF's ModelingAssistantService." + NL + "\t */" + NL + "\tpublic List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {" + NL + "\t\treturn generic";
  protected final String TEXT_15 = "HostingUnitTypes;" + NL + "\t}" + NL + "} // end class ";
  protected final String TEXT_16 = "UnitFilter";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String typeName=(String)args.get(2); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
