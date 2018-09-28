package templateclasses;

import java.util.*;

public class UnitFigureTemplate
{
  protected static String nl;
  public static synchronized UnitFigureTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UnitFigureTemplate result = new UnitFigureTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved." + NL + " *  " + NL + " * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + " * Schedule Contract with IBM Corp." + NL + " * " + NL + " * Contributors: IBM Corporation - initial API and implementation" + NL + " *******************************************************************************/" + NL + "" + NL + "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.draw2d.Graphics;" + NL + "" + NL + "import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;" + NL + "" + NL + "/**" + NL + " * This Figure represents a Rounded Rectangle Figure" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = "UnitFigure extends DeployCoreFigure {" + NL + "" + NL + "\t/**" + NL + "\t * Constructor for LtmNodeFigure." + NL + "\t */" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_4 = "UnitFigure() {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Draw the state object." + NL + "\t * " + NL + "\t * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)" + NL + "\t */" + NL + "\t@Override" + NL + "\tprotected void paintFigure(Graphics g) {" + NL + "\t\tpaintDeployApplication(g);" + NL + "\t}" + NL + "}";

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
    return stringBuffer.toString();
  }
}
