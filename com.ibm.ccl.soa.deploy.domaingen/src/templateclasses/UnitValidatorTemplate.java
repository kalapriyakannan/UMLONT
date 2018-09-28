package templateclasses;

import java.util.*;

public class UnitValidatorTemplate
{
  protected static String nl;
  public static synchronized UnitValidatorTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UnitValidatorTemplate result = new UnitValidatorTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved." + NL + " *  " + NL + " * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + " * Schedule Contract with IBM Corp." + NL + " * " + NL + " * Contributors: IBM Corporation - initial API and implementation" + NL + " *******************************************************************************/" + NL + "package ";
  protected final String TEXT_2 = ".internal.validator;" + NL + "" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "" + NL + "import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;" + NL + "import com.ibm.ccl.soa.deploy.core.Unit;" + NL + "import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;" + NL + "import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;";
  protected final String TEXT_3 = NL + "import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;";
  protected final String TEXT_4 = NL + "import ";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + "import ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "Package;" + NL + "" + NL + "/**" + NL + " * Validates {@link ";
  protected final String TEXT_9 = "Unit}." + NL + " * <p>" + NL + " * Validator IDs:" + NL + " * <ul>" + NL + " * </ul>" + NL + " */" + NL + "public class ";
  protected final String TEXT_10 = "UnitValidator extends ";
  protected final String TEXT_11 = "UnitValidator {" + NL + "" + NL + "\t/**" + NL + "\t * Construct a {@link ";
  protected final String TEXT_12 = "Unit} instance validator." + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_13 = "UnitValidator() {" + NL + "\t\tthis(";
  protected final String TEXT_14 = "Package.eINSTANCE.get";
  protected final String TEXT_15 = "Unit());" + NL + "" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Construct a {@link ";
  protected final String TEXT_16 = "Unit} subtype validator." + NL + "\t * " + NL + "\t * @param unitType" + NL + "\t *           a subtype of {@link ";
  protected final String TEXT_17 = "Unit}." + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_18 = "UnitValidator(EClass unitType) {" + NL + "\t\tsuper(unitType);" + NL + "\t\tassert ";
  protected final String TEXT_19 = "Package.eINSTANCE.get";
  protected final String TEXT_20 = "Unit().isSuperTypeOf(unitType);" + NL + "" + NL + "\t\t//" + NL + "\t\t// Constraints on capabilities and requirement types." + NL + "\t\t//" + NL + "\t\taddCapabilityTypeConstraint(";
  protected final String TEXT_21 = "Package.eINSTANCE.get";
  protected final String TEXT_22 = "()," + NL + "\t\t\t\tCapabilityLinkTypes.ANY_LITERAL, 1, 1);" + NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t * (non-Javadoc)" + NL + "\t * " + NL + "\t * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validate(com.ibm.ccl.soa.deploy.core.Unit," + NL + "\t *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext," + NL + "\t *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)" + NL + "\t */" + NL + "\t@Override" + NL + "\tpublic void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {" + NL + "\t\tsuper.validateUnit(unit, context, reporter);" + NL + "\t}" + NL + "}";
  protected final String TEXT_23 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String unitValidatorPackage=(String)args.get(2); 
     String classNamePrefix=(String)args.get(3); 
     String superClassNamePrefix=(String)args.get(4); 
     String fullSuperUnitValidatorClassName=(String)args.get(5); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_2);
     if (superClassNamePrefix.length() == 0) { 
    stringBuffer.append(TEXT_3);
     } else { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(fullSuperUnitValidatorClassName);
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(superClassNamePrefix);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(classNamePrefix);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
