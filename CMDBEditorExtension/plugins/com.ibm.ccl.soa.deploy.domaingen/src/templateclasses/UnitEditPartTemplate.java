package templateclasses;

import java.util.*;

public class UnitEditPartTemplate
{
  protected static String nl;
  public static synchronized UnitEditPartTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UnitEditPartTemplate result = new UnitEditPartTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/***************************************************************************************************" + NL + " * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights" + NL + " * reserved." + NL + " * " + NL + " * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + " * Schedule Contract with IBM Corp." + NL + " * " + NL + " * Contributors: IBM Corporation - initial API and implementation" + NL + " **************************************************************************************************/" + NL + "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.draw2d.DelegatingLayout;" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL;
  protected final String TEXT_3 = NL + "import ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = "UnitEditPart;";
  protected final String TEXT_6 = NL + "import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitEditPart;";
  protected final String TEXT_7 = NL + "import ";
  protected final String TEXT_8 = ".ui.figures.";
  protected final String TEXT_9 = "FigureFactory;" + NL + "" + NL + "/**" + NL + " * Holds a logical node, which is a container capable of holding deployable units." + NL + " */" + NL + "public class ";
  protected final String TEXT_10 = "UnitEditPart extends ";
  protected final String TEXT_11 = "UnitEditPart {" + NL + "\t/**" + NL + "\t * @param view" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_12 = "UnitEditPart(View view) {" + NL + "\t\tsuper(view);" + NL + "\t\t// determine figure category description" + NL + "\t\t// TODO replace with translatable string" + NL + "\t\tsetCategory(\"";
  protected final String TEXT_13 = "\"); //$NON-NLS-1$ " + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tprotected NodeFigure createMainFigure() {" + NL + "\t\tNodeFigure f = ";
  protected final String TEXT_14 = "FigureFactory.createNew";
  protected final String TEXT_15 = "UnitFigure();" + NL + "\t\tf.setLayoutManager(new DelegatingLayout());" + NL + "\t\treturn f;" + NL + "\t}" + NL + "}";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String unitEditPartPackage=(String)args.get(2); 
     String classNamePrefix=(String)args.get(3); 
     String superClassNamePrefix=(String)args.get(4); 
     String superClassPackage=(String)args.get(5); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(unitEditPartPackage);
    stringBuffer.append(TEXT_2);
     if (superClassNamePrefix.length() > 0) { 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(superClassPackage);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(superClassNamePrefix);
    stringBuffer.append(TEXT_5);
     } else { 
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelPackage);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ucModelPackagePrefix);
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
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
