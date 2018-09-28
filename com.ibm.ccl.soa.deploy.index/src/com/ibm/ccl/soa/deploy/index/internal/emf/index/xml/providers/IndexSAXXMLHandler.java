package com.ibm.ccl.soa.deploy.index.internal.emf.index.xml.providers;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.FeatureNotFoundException;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.xtools.emf.collections.HashedCollectionFactory;
import com.ibm.xtools.emf.index.internal.plugin.IndexDebugOptions;
import com.ibm.xtools.emf.index.internal.plugin.IndexPlugin;
import com.ibm.xtools.emf.index.internal.util.IIndexConstants;
import com.ibm.xtools.emf.index.provider.AbstractIndexProvider;
import com.ibm.xtools.emf.index.provider.EObjectEntry;
import com.ibm.xtools.emf.index.provider.IIndexConfigurationManager;
import com.ibm.xtools.emf.index.provider.IIndexProvider;
import com.ibm.xtools.emf.index.provider.IIndexWriter;
import com.ibm.xtools.emf.index.provider.ResourceEntry;
import com.ibm.xtools.emf.index.search.IndexContext;
import com.ibm.xtools.emf.index.search.IndexException;

public class IndexSAXXMLHandler extends SAXXMLHandler {

	/**
	 * This class is cache for mapping the feature to its xml name
	 */
	protected static class EClassFeatureNamePair {

		public EClass eClass;

		public String featureName;

		public String namespaceURI;

		public boolean isElement;

		public boolean equals(Object that) {
			EClassFeatureNamePair typedThat = (EClassFeatureNamePair) that;
			return typedThat.eClass == eClass
					&& typedThat.isElement == isElement
					&& typedThat.featureName.equals(featureName)
					&& (typedThat.namespaceURI != null ? typedThat.namespaceURI.equals(namespaceURI)
							: namespaceURI == null);
		}

		public int hashCode() {
			return eClass.hashCode() ^ featureName.hashCode()
					^ (namespaceURI == null ? 0 : namespaceURI.hashCode()) + (isElement ? 0 : 1);
		}
	}

	/**
	 * A stack implementation for the light weight eObject entries
	 */
	protected static class MyEObjectEntryStack extends MyStack {

		private static final long serialVersionUID = -7961596050372859067L;

		protected EObjectEntry[] eObjectData;

		public MyEObjectEntryStack() {
			// do nothing
		}

		protected final Object[] newData(int capacity) {
			return eObjectData = new EObjectEntry[capacity];
		}

		public final EObjectEntry peekEObjectEntry() {
			return size == 0 ? null : eObjectData[size - 1];
		}

		public final EObjectEntry peekEObjectEntryAt(int atIndex) {
			return size == 0 || size < atIndex ? null : eObjectData[atIndex];
		}

		public final void push(EObjectEntry o) {
			grow(size + 1);
			eObjectData[size++] = o;
		}

		public final EObjectEntry popEObjectEntry() {
			return size == 0 ? null : eObjectData[--size];
		}
	}

	protected Map eClassFeatureNamePairToEStructuralFeatureMap = null;

	protected EClassFeatureNamePair eClassFeatureNamePair = new EClassFeatureNamePair();

	/**
	 * Attribute for the resource entry
	 */
	protected ResourceEntry resourceEntry = null;

	/**
	 * Attribute for the list of EObject entries
	 */
	protected IProgressMonitor monitor = null;

	/**
	 * Attribute for the eObject entries
	 */
	protected MyEObjectEntryStack objects = new MyEObjectEntryStack();

	/**
	 * Attribute for the representing the cross resource object
	 */
	protected static final String CROSS_RES_OBJECT_TYPE = "cross-res-object"; //$NON-NLS-1$

	protected static final String NAME = "name"; //$NON-NLS-1$

	protected static final String HREF_PATH_SEPERATOR = "/"; //$NON-NLS-1$

	private final boolean isTraceEnabled = IndexPlugin.Tracing
			.shouldTrace(IndexDebugOptions.INDEX_XMI_HANDLER);

	/**
	 * Attribute for the current index context
	 */
	protected IndexContext context = null;

	/**
	 * Attribute for the index writer
	 */
	protected IIndexWriter indexWriter = null;

	/**
	 * Constructor
	 * 
	 * @param xmiResource
	 *           the resource
	 * @param resourceSet
	 *           the resource set
	 * @param monitor
	 *           the progress monitor
	 */
	public IndexSAXXMLHandler(IndexContext context, XMLResource xmlResource,
			ResourceSet resourceSet, IIndexWriter indexWriter, IProgressMonitor monitor) {
		super(xmlResource, new XMLHelperImpl(xmlResource), resourceSet.getLoadOptions());

		// set the package registry
		this.resourceSet = resourceSet;
		packageRegistry = resourceSet.getPackageRegistry();

		// set the monitor
		this.monitor = monitor;

		// set the context
		this.context = context;

		// set the index writer
		this.indexWriter = indexWriter;

		// set the resource entry
		resourceEntry = new ResourceEntry(this.context, resourceURI);

		// set the extended metadata
		extendedMetaData = resourceSet == null ? ExtendedMetaData.INSTANCE
				: new BasicExtendedMetaData(resourceSet.getPackageRegistry());
		helper.setExtendedMetaData(extendedMetaData);
		helper.setXMLMap(new XMLMapImpl());
		eClassFeatureNamePairToEStructuralFeatureMap = (Map) resourceSet.getLoadOptions().get(
				XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP);
		if (eClassFeatureNamePairToEStructuralFeatureMap == null) {
			eClassFeatureNamePairToEStructuralFeatureMap = HashedCollectionFactory
					.createMap(IIndexConstants.INITIAL_CAPACITY);
		}
	}

	@Override
	public void endDocument() {
		// add the resource entry
		try {
			indexWriter.addIndexEntryToIndex(resourceEntry, monitor);
		} catch (IndexException e) {
			// do nothing
		}

		helper.recordPrefixToURIMapping();
		helper.popContext();
	}

	@Override
	public void endElement(String uri, String localName, String name) {
		elements.pop();

		Object type = types.pop();
		if (type == OBJECT_TYPE) {
			EObjectEntry popEntry = objects.popEObjectEntry();

			// add to the index
			try {
				indexWriter.addIndexEntryToIndex(popEntry, monitor);
			} catch (Exception e) {
				// do nothing;
			}
		} else if (type instanceof EAttribute && isTextFeatureValue(type)) {
			// get the peek object
			EObjectEntry peekObject = objects.peekEObjectEntry();

			// set the value
			if (text != null && text.length() > 0) {
				setEAttributeValue(peekObject, (EAttribute) type, text.toString());
			}

			text = null;
		}

		helper.popContext();

		if (isTraceEnabled) {
			IndexPlugin.Tracing.trace("Ending element " + name); //$NON-NLS-1$
		}

		// check the progress monitor
		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}

	@Override
	protected void createTopObject(String prefix, String name) {
		// process schema locations
		handleTopLocations(prefix, name);

		// get the package
		String uri = helper.getURI(prefix);
		EPackage ePackage = getPackageForURI(uri);
		if (ePackage == null) {
			return;
		}
		// get the type
		EStructuralFeature eFeature = extendedMetaData.getElement(uri, name);
		if (eFeature != null) {

			EClassifier eClassifier = eFeature.getEType();
			if (eClassifier instanceof EClass) {

				// create the object with null container
				URI containerURI = IndexContext.normalize(resourceURI, resourceSet);
				EObjectEntry entry = new EObjectEntry(context, containerURI, (EClass) eClassifier);

				// handle attributes for the object
				if (attribs != null && !isNull()) {
					for (int i = 0, size = attribs.getLength(); i < size; ++i) {
						String qName = attribs.getQName(i);
						if (qName.equals(NAME)) {
							// set the object uri
							entry.setEObjectURI(constructURI(attribs.getValue(i)));
						}
						if (qName.equals(hrefAttribute)
								&& (!recordUnknownFeature || types.peek() != UNKNOWN_FEATURE_TYPE)) {
							// get the peek object
							EObjectEntry peekObject = objects.peekEObjectEntry();

							// get the reference feature
							EStructuralFeature feature = getFeature(peekObject.getEClass(), prefix, name,
									true);
							if (feature instanceof EReference) {
								setEReferenceValueFromHREF(peekObject, (EReference) feature, attribs
										.getValue(i));
							}
						} else if (!qName.startsWith(XMLResource.XML_NS) && !notFeatures.contains(qName)) {
							setAttribValue(entry, qName, attribs.getValue(i));
						}
					}
				}

				if (isTraceEnabled) {
					IndexPlugin.Tracing.trace("Entry uri:" + entry.getEObjectURI().toString()); //$NON-NLS-1$
				}

				objects.push(entry);
				types.push(OBJECT_TYPE);
			}
		}
	}

	protected EStructuralFeature getFeature(EClass eClass, String prefix, String name,
			boolean isElement) {
		String uri = helper.getURI(prefix);

		// need to be able to optimize but the overrides are not visible
		// for eClassFeatureNamePair. Get the feature
		eClassFeatureNamePair.eClass = eClass;
		eClassFeatureNamePair.featureName = name;
		eClassFeatureNamePair.namespaceURI = uri;
		eClassFeatureNamePair.isElement = isElement;
		EStructuralFeature result = (EStructuralFeature) eClassFeatureNamePairToEStructuralFeatureMap
				.get(eClassFeatureNamePair);
		if (result == null) {
			result = helper.getFeature(eClass, uri, name, isElement);
			if (result == null && extendedMetaData != null) {
				EStructuralFeature wildcardFeature = isElement ? extendedMetaData
						.getElementWildcardAffiliation(eClass, uri, name) : extendedMetaData
						.getAttributeWildcardAffiliation(eClass, uri, name);
				if (wildcardFeature != null) {
					switch (extendedMetaData.getProcessingKind(wildcardFeature))
					{
					case ExtendedMetaData.LAX_PROCESSING:
					case ExtendedMetaData.SKIP_PROCESSING: {
						// EATM Demand create metadata.
						result = extendedMetaData.demandFeature(uri, name, isElement);
						break;
					}
					}
				}
			}

			EClassFeatureNamePair entry = new EClassFeatureNamePair();
			entry.eClass = eClass;
			entry.featureName = name;
			entry.namespaceURI = uri;
			entry.isElement = isElement;
			eClassFeatureNamePairToEStructuralFeatureMap.put(entry, result);
		}

		return result;
	}

	@Override
	protected void handleFeature(String prefix, String name) {
		// get the peek object
		EObjectEntry peekObject = objects.peekEObjectEntry();
		if (peekObject == null) {
			types.push(ERROR_TYPE);
			error(new FeatureNotFoundException(name, null, getLocation(), getLineNumber(),
					getColumnNumber()));
			return;
		}

		// get the feature
		EStructuralFeature feature = getFeature(peekObject.getEClass(), prefix, name, true);
		if (feature instanceof EReference) {
			// get the EClass
			EClassifier eClassifier = null;
			String typeName = null;
			String xsiType = getXSIType();

			// get from type info if available
			if (xsiType != null) {
				String nprefix = null;
				int index = xsiType.indexOf(":"); //$NON-NLS-1$
				if (index > 0) {
					nprefix = xsiType.substring(0, index);
					typeName = xsiType.substring(index + 1);
				} else {
					typeName = xsiType;
				}

				String uri = helper.getURI(nprefix != null ? nprefix : prefix);
				EPackage ePackage = getPackageForURI(uri);
				if (ePackage != null) {
					eClassifier = helper.getType(ePackage.getEFactoryInstance(), typeName);
				}
			} else {
				// get the type from the feature
				eClassifier = feature.getEType();
			}

			if (eClassifier instanceof EClass) {
				// create the object
				EObjectEntry entry = new EObjectEntry(context, peekObject.getEObjectURI(),
						(EClass) eClassifier);

				// handle attributes for the object
				if (attribs != null && !isNull()) {
					for (int i = 0, size = attribs.getLength(); i < size; ++i) {
						String qName = attribs.getQName(i);
						if (qName.equals(hrefAttribute)
								&& (!recordUnknownFeature || types.peek() != UNKNOWN_FEATURE_TYPE)) {
							setEReferenceValueFromHREF(peekObject, (EReference) feature, attribs
									.getValue(i));
						} else if (!qName.startsWith(XMLResource.XML_NS) && !notFeatures.contains(qName)) {
							setAttribValue(entry, qName, attribs.getValue(i));
						}
					}
				}

				// push the object in the stack
				if (entry.getEObjectURI() != null) {
					if (isTraceEnabled) {
						IndexPlugin.Tracing.trace("Entry uri:" + entry.getEObjectURI().toString()); //$NON-NLS-1$
					}

					objects.push(entry);
					types.push(OBJECT_TYPE);

					// set the ref value
					peekObject.addEReferenceValue((EReference) feature, entry.getEObjectURI());
				} else {
					// clear the entry. it is only a cross model reference
					entry = null;
					types.push(CROSS_RES_OBJECT_TYPE);
				}
			}
		} else if (feature instanceof EAttribute) {
			types.push(feature);
			if (!isNull()) {
				text = new StringBuffer();
			}
		}
	}

	/*
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLHandler#reset()
	 */
	public void reset() {
		super.reset();

		// clean up everything
		if (eClassFeatureNamePairToEStructuralFeatureMap != null) {
			eClassFeatureNamePairToEStructuralFeatureMap.clear();
			eClassFeatureNamePairToEStructuralFeatureMap = null;
		}

		if (eClassFeatureNamePair != null) {
			eClassFeatureNamePair = null;
		}

		resourceEntry = null;

		monitor = null;
		context = null;
		indexWriter = null;
	}

	/**
	 * Create a feature with the given name for the given object with the given values.
	 */
	protected void setAttribValue(EObjectEntry object, String name, String value) {
		int index = name.indexOf(":"); //$NON-NLS-1$

		// We use null here instead of "" because an attribute without a prefix
		// is considered to have the null target namespace...
		String prefix = null;
		String localName = name;
		if (index != -1) {
			prefix = name.substring(0, index);
			localName = name.substring(index + 1);
		}
		EStructuralFeature feature = getFeature(object.getEClass(), prefix, localName, false);
		if (feature == null) {
			error(new FeatureNotFoundException(name, null, getLocation(), getLineNumber(),
					getColumnNumber()));
		} else {
			int kind = helper.getFeatureKind(feature);

			if (kind == XMLHelper.DATATYPE_SINGLE || kind == XMLHelper.DATATYPE_IS_MANY) {
				setEAttributeValue(object, (EAttribute) feature, value);
			} else {
				setEReferenceValueFromId(object, (EReference) feature, value);
			}
		}
	}

	/**
	 * Set the attribute feature for the specified object to the given value.
	 */
	protected void setEAttributeValue(EObjectEntry object, EAttribute attribute, Object value) {
		// check if attribute is indexed
		if (!IIndexConfigurationManager.INSTANCE.isFeatureIndexed(attribute)) {
			return;
		}

		if (attribute.getUpperBound() == ETypedElement.UNSPECIFIED_MULTIPLICITY
				|| FeatureMapUtil.isFeatureMap(attribute) || attribute.isMany()) {
			ArrayList list = new ArrayList();
			for (StringTokenizer stringTokenizer = new StringTokenizer((String) value, " "); stringTokenizer.hasMoreTokens();) { //$NON-NLS-1$
				list.add(stringTokenizer.nextToken());
			}

			object.addEAttributeValue(attribute, list);
		} else {
			object.addEAttributeValue(attribute, value);
		}
	}

	/**
	 * Set the given reference feature value for the given object to the given uri value.
	 */
	protected void setEReferenceValueFromURI(EObjectEntry object, EReference reference, URI uri) {
		// set the reference value
		object.addEReferenceValue(reference, uri);
	}

	/**
	 * Set the given reference feature value for the given object to the given id value.
	 */
	protected void setEReferenceValueFromId(EObjectEntry object, EReference reference, String idValue) {
		// set the ref uri
		object.addEReferenceValue(reference, resourceURI.appendFragment(idValue));
	}

	/**
	 * Set the given reference feature value on the specified peek object
	 */
	protected void setEReferenceValueFromHREF(EObjectEntry peekObject, EReference reference,
			String uriLiteral) {
		URI uri = URI.createURI(uriLiteral);
		if (resolve
				&& uri.isRelative()
				&& uri.hasRelativePath()
				&& (extendedMetaData == null ? !packageRegistry.containsKey(uri.trimFragment()
						.toString()) : extendedMetaData.getPackage(uri.trimFragment().toString()) == null)) {
			uri = helper.resolve(uri, resourceURI);
		}

		// normalize the uri
		uri = IndexContext.normalize(uri, resourceSet);

		// add to the imports of the resource
		if (!uri.trimFragment().equals(resourceURI)) {
			resourceEntry.addImport(uri.trimFragment());
		}

		// set the reference value
		setEReferenceValueFromURI(peekObject, reference, uri);
	}

	protected URI constructURI(String name) {
		String path = new String();
		String attField = AbstractIndexProvider.getField(CorePackage.eINSTANCE
				.getDeployModelObject_Name(), IIndexProvider.ATT_PREFIX);
		for (int i = 1; i < objects.size(); i++) {
			String objName = (String) objects.peekEObjectEntryAt(i).getValue(attField);
			path += HREF_PATH_SEPERATOR + objName;
		}

		path += HREF_PATH_SEPERATOR + name;
		return resourceURI.appendFragment(path);
	}
}
