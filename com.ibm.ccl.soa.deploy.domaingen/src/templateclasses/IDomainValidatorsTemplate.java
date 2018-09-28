package templateclasses;

import java.util.*;

public class IDomainValidatorsTemplate
{
  protected static String nl;
  public static synchronized IDomainValidatorsTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    IDomainValidatorsTemplate result = new IDomainValidatorsTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved." + NL + " *  " + NL + " * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + " * Schedule Contract with IBM Corp." + NL + " * " + NL + " * Contributors: IBM Corporation - initial API and implementation" + NL + " *******************************************************************************/" + NL + "" + NL + "package ";
  protected final String TEXT_2 = ".validator;" + NL + "" + NL + "//import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;" + NL + "//import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;" + NL + "//import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;" + NL + "//import ";
  protected final String TEXT_3 = ".Activator;" + NL + "//import ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = "Package;" + NL + "" + NL + "/**" + NL + " * {@link IDeployStatus#getValidatorID()} declarations for the {@link ";
  protected final String TEXT_6 = "Package}" + NL + " * deploy domain." + NL + " */" + NL + "public interface I";
  protected final String TEXT_7 = "DomainValidators {" + NL + "" + NL + "// /**" + NL + "// * <ul>" + NL + "// * <li>ID ={@value}" + NL + "// * <li>Status = {@link IDeployAttributeStatus}" + NL + "// * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}" + NL + "// * <li>Description = The {@link AttributeName} path must be set" + NL + "// * </ul>" + NL + "// */" + NL + "// public final static String SAMPLE_ID_001 = ";
  protected final String TEXT_8 = "DeployPlugin.PLUGIN_ID" + NL + "// + \".SAMPLE_ID_001\"; //$NON-NLS-1$;" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String iDomainValidatorsPackage=(String)args.get(2); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
