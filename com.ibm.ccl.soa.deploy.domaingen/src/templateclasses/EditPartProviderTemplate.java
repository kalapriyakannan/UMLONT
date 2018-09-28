package templateclasses;

import java.util.*;

public class EditPartProviderTemplate
{
  protected static String nl;
  public static synchronized EditPartProviderTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    EditPartProviderTemplate result = new EditPartProviderTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved." + NL + " *  " + NL + " * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + " * Schedule Contract with IBM Corp." + NL + " * " + NL + " * Contributors: IBM Corporation - initial API and implementation" + NL + " *******************************************************************************/" + NL + "" + NL + "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.util.HashMap;" + NL + "import java.util.Map;" + NL + "" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "Package;" + NL + "import ";
  protected final String TEXT_5 = ".*;" + NL + "" + NL + "" + NL + "/**" + NL + " * Deploy tool Edit Part provider for ";
  protected final String TEXT_6 = " domain." + NL + " * " + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = "EditPartProvider extends AbstractEditPartProvider {" + NL + "" + NL + "\t/** list of supported shape editparts. */" + NL + "\tprivate Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();" + NL + "\t{";
  protected final String TEXT_8 = NL + "\t\tnodeMap.put(";
  protected final String TEXT_9 = "Package.eINSTANCE.get";
  protected final String TEXT_10 = "Unit(), ";
  protected final String TEXT_11 = "UnitEditPart.class);";
  protected final String TEXT_12 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Gets a Node's editpart class." + NL + "\t */" + NL + "\t@Override" + NL + "\tprotected Class<?> getNodeEditPartClass(View view) {" + NL + "\t\tClass<?> clazz = null;" + NL + "\t\tEClass eClass = getReferencedElementEClass(view);" + NL + "\t\tif (eClass != null) {" + NL + "\t\t\tclazz = ((Class<?>) nodeMap.get(eClass));" + NL + "\t\t}" + NL + "" + NL + "\t\treturn clazz;" + NL + "\t}" + NL + "}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String editPartProviderPackage=(String)args.get(2); 
     String unitEditPartPackage=(String)args.get(3); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(editPartProviderPackage);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(unitEditPartPackage);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_7);
     for (int i=4; i<args.size(); ++i) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(args.get(i));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(args.get(i));
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
