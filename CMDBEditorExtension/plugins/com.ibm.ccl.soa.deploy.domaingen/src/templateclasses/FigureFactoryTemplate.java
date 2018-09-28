package templateclasses;

import java.util.*;

public class FigureFactoryTemplate
{
  protected static String nl;
  public static synchronized FigureFactoryTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    FigureFactoryTemplate result = new FigureFactoryTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved." + NL + " *  " + NL + " * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + " * Schedule Contract with IBM Corp." + NL + " * " + NL + " * Contributors: IBM Corporation - initial API and implementation" + NL + " *******************************************************************************/" + NL + "" + NL + "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;" + NL + "" + NL + "/**" + NL + " * This class is used to create figures" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = "FigureFactory {" + NL + "\t/**" + NL + "\t * " + NL + "\t * @return NodeFigure" + NL + "\t */" + NL + "\tpublic static NodeFigure createNew";
  protected final String TEXT_4 = "UnitFigure() {" + NL + "\t\treturn new ";
  protected final String TEXT_5 = "UnitFigure();" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String figuresPackage=(String)args.get(2); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(figuresPackage);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
