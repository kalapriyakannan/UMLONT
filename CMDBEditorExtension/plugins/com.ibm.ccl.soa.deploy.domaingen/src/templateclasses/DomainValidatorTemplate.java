package templateclasses;

import java.util.*;

public class DomainValidatorTemplate
{
  protected static String nl;
  public static synchronized DomainValidatorTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    DomainValidatorTemplate result = new DomainValidatorTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved." + NL + " *  " + NL + " * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + " * Schedule Contract with IBM Corp." + NL + " * " + NL + " * Contributors: IBM Corporation - initial API and implementation" + NL + " *******************************************************************************/" + NL + "package ";
  protected final String TEXT_2 = ".internal.validator;" + NL + "" + NL + "import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;" + NL + "import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "Package;";
  protected final String TEXT_5 = NL + "import ";
  protected final String TEXT_6 = ".internal.validator.";
  protected final String TEXT_7 = "UnitValidator;";
  protected final String TEXT_8 = NL + "import ";
  protected final String TEXT_9 = ".internal.validator.matcher.";
  protected final String TEXT_10 = "DomainMatcher;" + NL + "" + NL + "/**" + NL + " * Validates objects in the {@link ";
  protected final String TEXT_11 = "Package} deploy domain." + NL + " */" + NL + "public class ";
  protected final String TEXT_12 = "DomainValidator extends UnitDomainValidator {" + NL + "" + NL + "\t/**" + NL + "\t * Construct a {@link ";
  protected final String TEXT_13 = "Package} domain validator." + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_14 = "DomainValidator() {" + NL + "\t\tsuper(";
  protected final String TEXT_15 = "Package.eINSTANCE);" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t\taddValidator(new ";
  protected final String TEXT_17 = "UnitValidator());";
  protected final String TEXT_18 = NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()" + NL + "\t */" + NL + "\tprotected DomainMatcher createDomainMatcher() {" + NL + "\t\treturn new ";
  protected final String TEXT_19 = "DomainMatcher();" + NL + "\t}" + NL + "}";
  protected final String TEXT_20 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String validatorPackage=(String)args.get(2); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_4);
     for (int i=3; i<args.size(); ++i) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(args.get(i));
    stringBuffer.append(TEXT_7);
     } 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_15);
     for (int i=3; i<args.size(); ++i) { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(args.get(i));
    stringBuffer.append(TEXT_17);
     } 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
