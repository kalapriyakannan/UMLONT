package templateclasses;

import java.util.*;

public class DomainMatcherTemplate
{
  protected static String nl;
  public static synchronized DomainMatcherTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    DomainMatcherTemplate result = new DomainMatcherTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved." + NL + " *  " + NL + " * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP" + NL + " * Schedule Contract with IBM Corp." + NL + " * " + NL + " * Contributors: IBM Corporation - initial API and implementation" + NL + " *******************************************************************************/" + NL + "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;" + NL + "import com.ibm.ccl.soa.deploy.core.validator.matcher.DefaultLinkMatcherFactory;" + NL + "import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;" + NL + "import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;" + NL + "" + NL + "/**" + NL + " * Domain specific matcher for the ";
  protected final String TEXT_3 = " package." + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = "DomainMatcher extends CoreDomainMatcher {" + NL + "" + NL + "\t/**" + NL + "\t * Constructor" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "DomainMatcher() {" + NL + "\t\tsuper(new DefaultLinkMatcherFactory() {" + NL + "\t\t\tpublic LinkMatcher getLinkMatcher(LinkType linkType) {" + NL + "\t\t\t\tLinkMatcher matcher = super.getLinkMatcher(linkType);" + NL + "\t\t\t\t// make any domain specific modifications to matcher here" + NL + "\t\t\t\treturn matcher;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String ucModelPackagePrefix=(String)args.get(1); 
     String domainMatcherPackage=(String)args.get(2); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(domainMatcherPackage);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
