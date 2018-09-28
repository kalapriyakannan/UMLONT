package templateclasses;

import java.util.*;

public class NonUIPluginPropertiesAdditionsTemplate
{
  protected static String nl;
  public static synchronized NonUIPluginPropertiesAdditionsTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    NonUIPluginPropertiesAdditionsTemplate result = new NonUIPluginPropertiesAdditionsTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "extension.";
  protected final String TEXT_2 = "Domain=";
  protected final String TEXT_3 = " domain" + NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "Tool.Label=";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "Tool.Description=";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List args=(List) argument; 
     String ucModelPackagePrefix=(String)args.get(0); 
     String lcModelPackagePrefix=(String)args.get(1); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ucModelPackagePrefix);
    stringBuffer.append(TEXT_3);
     for (int i=2; i<args.size(); ++i) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(args.get(i));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(args.get(i));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(lcModelPackagePrefix);
    stringBuffer.append(args.get(i));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(args.get(i));
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
