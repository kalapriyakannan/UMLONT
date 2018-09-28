/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Static deployment NLS utilities.
 * 
 * @see NLS
 */
public final class DeployNLS {

	private DeployNLS() {
		// prevent instantiation
	}

	// This is bad, but as this class is currently designed, it looks like the only option
	private static ComposedAdapterFactory.Descriptor.Registry registry = EMFEditPlugin
			.getComposedAdapterFactoryDescriptorRegistry();

	/**
	 * Returns the name of the structural feature for user display.
	 * 
	 * @param attribute
	 *           a deploy model object type attribute.
	 * @return the name of the attribute.
	 * @deprecated use {@link #getName(DeployModelObject, EStructuralFeature)}
	 */
	public static String getName(EStructuralFeature attribute) {
		// Rather than using EMF.Edit to look up the provider through a plug-in,
		// attempt to calculate the provider using Java reflection
		if (attribute instanceof ExtendedAttribute) {
			return getName((ExtendedAttribute) attribute);
		}

		EClass ecl = attribute.getEContainingClass();
		if (ecl != null) {
			IItemPropertySource iips = getItemPropertySource(ecl);

			if (iips != null) {
				// Although we need an Object to get a usable IItemPropertySource, because
				// we only want the display name it's safe to ask for a descriptor for null!!!
				Object obj = null;
				ItemPropertyDescriptor ipd = getDescriptor(iips, attribute, obj);

				if (ipd != null) {
					return ipd.getDisplayName(obj);
				}
			}
		}
		// If we couldn't get a source, just use internal ENamedElement name
		return attribute.getName();
	}

	/**
	 * Returns the name of the extended attribute for user display.
	 * 
	 * @param attribute
	 *           a deploy model object extended attribute.
	 * @return the name of the attribute.
	 */
	public static String getName(ExtendedAttribute attribute) {
		if (attribute == null) {
			return null;
		}
		DeployModelObject object = attribute.getContainer();
		if (object == null || attribute.getName() == null) {
			return attribute.getName();
		}
		AttributeMetaData m = object.getAttributeMetaData(attribute.getName());
		if (m != null && m.getLabel() != null) {
			return m.getLabel();
		}
		return attribute.getName();
	}

	/**
	 * Returns the name of the attribute for user display.
	 * 
	 * @param dmo
	 *           An instance of the class the attribute applies to
	 * @param attribute
	 * @return a display name for the attribute (from EMF.Edit)
	 * @deprecated use {@link #getName(EStructuralFeature, Object)}
	 */
	public static String getName(DeployModelObject dmo, EStructuralFeature attribute) {
		if (attribute instanceof ExtendedAttribute) {
			return getName((ExtendedAttribute) attribute);
		}

		IItemPropertySource iips = getItemPropertySource(dmo);

		if (iips != null) {
			// Although we need an Object to get a usable IItemPropertySource, because
			// we only want the display name it's safe to ask for a descriptor for null!!!
			Object obj = null;
			ItemPropertyDescriptor ipd = getDescriptor(iips, attribute, obj);

			if (ipd != null) {
				return ipd.getDisplayName(obj);
			}
		}

		// If we couldn't get a source, just use internal ENamedElement name
		return attribute.getName();
	}

	/**
	 * Returns the name for the enumeration value.
	 * 
	 * @param e
	 *           an enumeration value.
	 * @return the name of the enumeration value.
	 */
	public static String getName(Enumerator e) {
		return e.getLiteral();
	}

	/**
	 * @param ecl
	 * @return item property source or <code>null</code>
	 * @deprecated Use EMF.Edit version, rather than Java reflection version, because EMF.Edit
	 *             version is customizable via plugin.xml
	 */
	private static IItemPropertySource getItemPropertySource(EClass ecl) {
		String javaPackageName = calculateJavaPackageName(ecl.getEPackage());
		// Assume item provider was generated with the default name and package
		String javaItemProviderName = javaPackageName + ".provider." + ecl.getName() + "ItemProvider"; //$NON-NLS-1$ //$NON-NLS-2$

		Class clz;
		try {
			clz = Class.forName(javaItemProviderName);
		} catch (ClassNotFoundException cnfe) {
			return null;
		}

		Object obj;
		try {
			// Assume item provider has default constructor taking AdapterFactory as param
			Constructor ctor = clz.getConstructor(new Class[] { AdapterFactory.class });
			obj = ctor.newInstance(new Object[] { new ComposedAdapterFactory() });
		} catch (Exception e) {
			return null;
		}

		if (obj instanceof IItemPropertySource) {
			return (IItemPropertySource) obj;
		}

		return null;
	}

	private static String calculateJavaPackageName(EPackage ep) {
		String packageClassName = ep.getClass().getName();
		int posDot = packageClassName.lastIndexOf(".impl."); //$NON-NLS-1$
		return packageClassName.substring(0, posDot);
	}

	/**
	 * @param attribute
	 * @param object
	 *           any object whose class has 'attribute'
	 * @return display name for 'attribute'
	 */
	public static String getName(EStructuralFeature attribute, Object object) {
		if (attribute instanceof ExtendedAttribute) {
			return getName((ExtendedAttribute) attribute);
		}
		// Get the item provider for the class
		IItemPropertySource iips = getItemPropertySource(object);

		if (iips != null) {
			// Although we need an Object to get a usable IItemPropertySource, because
			// we only want the display name it's safe to ask for a descriptor for null!!!
			Object obj = null;
			ItemPropertyDescriptor ipd = getDescriptor(iips, attribute, obj);

			if (ipd != null) {
				return ipd.getDisplayName(obj);
			}
		}

		// If we couldn't get a source, just use internal ENamedElement name
		return attribute.getName();
	}

	private static ItemPropertyDescriptor getDescriptor(IItemPropertySource iips,
			EStructuralFeature esf, Object object) {
		List l = iips.getPropertyDescriptors(object);
		for (Iterator it = l.iterator(); it.hasNext();) {
			ItemPropertyDescriptor ipd = (ItemPropertyDescriptor) it.next();
			if (ipd.getFeature(object) == esf) {
				//				System.out.println(ipd.getDisplayName(object));
				return ipd;
			}
		}

		return null;
	}

	private static IItemPropertySource getItemPropertySource(/* EClass ecl, */Object object) {
		// Although GMF-based apps can use PropertiesServiceAdapterFactory, this
		// plug-in doesn't pre-req GMF, so use the EMF.Edit registry instead.

		try {
			ComposedAdapterFactory af = new ComposedAdapterFactory(registry);
			IItemPropertySource ips = (IItemPropertySource) af
					.adapt(object, IItemPropertySource.class);
			return ips;
		} catch (RuntimeException e) {
			DeployCorePlugin.log(IStatus.WARNING, 0, e.getMessage(), e);
			return null;
		}

		// This code ended up with the same 'need an object' limitation

		//		EClass ecl = attribute.getEContainingClass();
		//		System.out.println(ecl.getEPackage().getNsURI());
		//		System.out.println(IItemPropertySource.class.getName());
		//		
		//		Collection arg0 = Arrays.asList(
		//				new Object[] { ecl.getEPackage().getNsURI(), 
		//						IItemPropertySource.class.getName() } );
		//		Descriptor descr = reg.getDescriptor(arg0);
		//		if (descr != null) {
		//			AdapterFactory af1 = descr.createAdapterFactory();
		//			System.out.println(af1);
		//			
		//			if (af1 != null) {
		//				System.out.println("worked?"); //$NON-NLS-1$
		//				Object object = CoreFactory.eINSTANCE.createUnit();
		//				IItemPropertySource iips = (IItemPropertySource) af1.adapt(object, IItemPropertySource.class);
		//				System.out.println("iips="+iips); //$NON-NLS-1$
	}

	/**
	 * Returns the name of the deploy type for user display.
	 * 
	 * @param eClass
	 *           the deploy type.
	 * @return the name of the type.
	 */
	public static String getName(EClass eClass) {
		return eClass.getName();
	}

	/**
	 * Returns the name of the deploy model object for user display.
	 * <p>
	 * In order of priority: (1) {@link DeployModelObject#getDisplayName()} (2)
	 * {@link DeployModelObject#getName()} (3) {@link DeployModelObject#getFullPath()}.
	 * 
	 * @param object
	 *           the object whose name will be returned (may be null).
	 * @return return the name of the object or an empty string if a name cannot be determined (never
	 *         null).
	 */
	public static String getName(DeployModelObject object) {
		if (object == null) {
			return ""; //$NON-NLS-1$
		}
		String title = null;
		if (object instanceof Unit) {
			title = ((Unit) object).getCaptionProvider().title((Unit) object);
		} else if (object instanceof Capability) {
			title = ((Capability) object).getCaptionProvider().title((Capability) object);
		}
		if (title != null) {
			return title;
		}
		if (object.getDisplayName() != null) {
			return object.getDisplayName();
		}
		if (object.getName() != null) {
			return object.getName();
		}
		return object.getFullPath().toString();
	}

	/**
	 * Resolves a binding by looking up its display name.
	 * <p>
	 * The resolution method creates a display name for instances of the following types:
	 * <ul>
	 * <li> {@link DeployModelObject} using {@link #getName(DeployModelObject)}
	 * <li> {@link EClass} using {@link #getName(EClass)}
	 * <li> {@link EAttribute} using {@link #getName(EAttribute)}
	 * </ul>
	 * 
	 * @param object
	 *           the object to be resolved.
	 * @return the resolved binding, or the same object.
	 */
	public static Object resolveBinding(Object object) {
		if (object == null) {
			return DeployCoreMessages.null_value;
		}
		if (object instanceof DeployModelObject) {
			return getName((DeployModelObject) object);
		}
		if (object instanceof Enumerator) {
			return getName((Enumerator) object);
		}
		if (object instanceof EClass) {
			return getName(((EClass) object));
		}
		if (object instanceof EAttribute) {
			return getName((EAttribute) object);
		}
		if (object instanceof IDeployResolution) {
			IDeployResolution res = (IDeployResolution) object;
			if (res.getDescription() != null) {
				return res.getDescription();
			}
			return res.getClass().getSimpleName();
		}
		if (object instanceof Throwable) {
			Throwable e = (Throwable) object;
			String message = e.getLocalizedMessage();
			if (message == null || message.trim().length() == 0) {
				message = e.getMessage();
				if (message == null || message.trim().length() == 0) {
					return e.getClass().getSimpleName();
				}
			}
			return message;
		}
		return object;
	}

	/**
	 * Bind the given message's substitution locations with the given string value.
	 * <p>
	 * Prior to substitution, the binding is resolved using {@link #resolveBinding(Object)}.
	 * 
	 * @param message
	 *           the message to be manipulated
	 * @param binding
	 *           the object to be inserted into the message
	 * @return the manipulated String
	 * 
	 * @see NLS#bind(String, Object)
	 * 
	 */
	public static String bind(String message, Object binding) {
		return NLS.bind(message, resolveBinding(binding));
	}

	/**
	 * Bind the given message's substitution locations with the given string value.
	 * <p>
	 * Prior to substitution, the binding is resolved using {@link #resolveBinding(Object)}.
	 * 
	 * @param message
	 *           the message to be manipulated
	 * @param binding1
	 *           the first object to be inserted into the message
	 * @param binding2
	 *           the second object to be inserted into the message
	 * @return the manipulated String
	 * 
	 * @see NLS#bind(String, Object, Object)
	 * 
	 */
	public static String bind(String message, Object binding1, Object binding2) {
		return NLS.bind(message, resolveBinding(binding1), resolveBinding(binding2));
	}

	/**
	 * Bind the given message's substitution locations with the given string values.
	 * <p>
	 * Prior to substitution, the bindings are resolved using {@link #resolveBinding(Object)}.
	 * 
	 * @param message
	 *           the message to be manipulated
	 * @param bindings
	 *           An array of objects to be inserted into the message
	 * @return the manipulated String
	 * 
	 * @see NLS#bind(String, Object[])
	 */
	public static String bind(String message, Object[] bindings) {
		if (bindings == null || bindings.length == 0) {
			return message;
		}
		Object[] bindings2 = new Object[bindings.length];
		for (int i = 0; i < bindings.length; i++) {
			bindings2[i] = resolveBinding(bindings[i]);
		}
		return NLS.bind(message, bindings2);
	}
}
