package templateclasses;

import java.util.*;

public class UIPluginPropertiesTemplate
{
  protected static String nl;
  public static synchronized UIPluginPropertiesTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UIPluginPropertiesTemplate result = new UIPluginPropertiesTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "###############################################################################" + NL + "# Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved." + NL + "#  " + NL + "# US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + "# Schedule Contract with IBM Corp." + NL + "# " + NL + "# Contributors: IBM Corporation - initial API and implementation" + NL + "###############################################################################" + NL + "# <copyright>" + NL + "# </copyright>" + NL + "#" + NL + "# ====================================================================" + NL + "# To code developer:" + NL + "#   Do NOT change the properties between this line and the" + NL + "#   \"%%% END OF TRANSLATED PROPERTIES %%%\" line." + NL + "#   Make a new property name, append to the end of the file and change" + NL + "#   the code to use the new property." + NL + "# ====================================================================" + NL + "" + NL + "# ====================================================================" + NL + "# %%% END OF TRANSLATED PROPERTIES %%%" + NL + "# ====================================================================" + NL + "" + NL + "pluginName=";
  protected final String TEXT_2 = " Component for Zephyr" + NL + "providerName=IBM Corporation" + NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = "Stack.Label=";
  protected final String TEXT_5 = " Stack";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "Stack.Description=";
  protected final String TEXT_8 = " Stack";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String ucModelPackagePrefix=(String)args.get(0); 
     String lcModelPackagePrefix=(String)args.get(1); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
