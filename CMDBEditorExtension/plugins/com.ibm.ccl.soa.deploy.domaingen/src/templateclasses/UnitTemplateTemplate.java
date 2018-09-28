package templateclasses;

import java.util.*;

public class UnitTemplateTemplate
{
  protected static String nl;
  public static synchronized UnitTemplateTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UnitTemplateTemplate result = new UnitTemplateTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + NL + "<core:topology xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + NL + "xmlns:core=\"http://www.ibm.com/ccl/soa/deploy/core/1.0.0/\" " + NL + "xmlns:";
  protected final String TEXT_2 = "=\"";
  protected final String TEXT_3 = "\"" + NL + "name=\"";
  protected final String TEXT_4 = " Template\">" + NL + "  <";
  protected final String TEXT_5 = ":unit.";
  protected final String TEXT_6 = "Unit name=\"";
  protected final String TEXT_7 = "\" configurationUnit=\"false\" conceptual=\"true\">" + NL + "    <";
  protected final String TEXT_8 = ":capability.";
  protected final String TEXT_9 = " name=\"";
  protected final String TEXT_10 = "\" linkType=\"any\"/>" + NL + "    <core:requirement name=\"optionalHostingReq\" dmoType=\"core:Capability\" linkType=\"hosting\" use=\"optional\"/>  " + NL + "  </";
  protected final String TEXT_11 = ":unit.";
  protected final String TEXT_12 = "Unit>" + NL + "</core:topology>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String modelPackage=(String)args.get(0); 
     String uri=(String)args.get(1); 
     String capClassName=(String)args.get(2); 
     String lcCapClassName=(String)args.get(3); 
     String lcModelPackagePrefix=(String)args.get(4); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(capClassName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(lcCapClassName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(capClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(lcCapClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(capClassName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(lcCapClassName);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
