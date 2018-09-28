package com.ibm.ccl.soa.deploy.index.internal.emf.index.xml.providers;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.xml.sax.SAXException;

import com.ibm.xtools.emf.index.internal.l10n.IndexMessages;
import com.ibm.xtools.emf.index.internal.plugin.IndexPlugin;
import com.ibm.xtools.emf.index.internal.plugin.IndexStatusCodes;
import com.ibm.xtools.emf.index.provider.AbortParsingException;
import com.ibm.xtools.emf.index.provider.AbstractIndexProvider;
import com.ibm.xtools.emf.index.provider.EObjectEntry;
import com.ibm.xtools.emf.index.provider.IIndexConfigurationManager;
import com.ibm.xtools.emf.index.provider.IIndexWriter;
import com.ibm.xtools.emf.index.provider.ResourceEntry;
import com.ibm.xtools.emf.index.search.IndexContext;
import com.ibm.xtools.emf.index.search.IndexException;

public class XMLIndexProvider extends AbstractIndexProvider {

	private static final Map<URI, List<Throwable>> cachedExceptions = new HashMap<URI, List<Throwable>>();

	/**
	 * Constructor
	 */
	public XMLIndexProvider() {
		super();
	}

	/**
	 * Updates the specified <code>EObjectEntry</code> object with attribute information from the
	 * specified EObject for the specified attribute feature
	 * 
	 * @param resource
	 *           the resource associated with the eObject
	 * @param eObject
	 *           the eObject whose attribute information is updated in the entry
	 * @param eAttribute
	 *           the eAttribute
	 * @param eObjectEntry
	 *           the corresponding eObject entry that will be added to the index store
	 * @param imports
	 *           a set to capture the imported resources
	 */
	protected void indexObjectAttributeData(Resource resource, EObject eObject,
			EAttribute eAttribute, EObjectEntry eObjectEntry, Set imports) {
		// check if the attribute is a feature map
		if (FeatureMapUtil.isFeatureMap(eAttribute) && !eAttribute.isTransient()) {
			List values = (List) eObject.eGet(eAttribute, false);
			if (values != null && !values.isEmpty()) {
				Iterator entries = values.iterator();
				while (entries.hasNext()) {
					FeatureMap.Entry entry = (FeatureMap.Entry) entries.next();
					EStructuralFeature entryFeature = entry.getEStructuralFeature();
					if (!(entryFeature instanceof EReference)) {
						continue;
					}

					EReference reference = (EReference) entryFeature;

					// index the reference data
					indexObjectReferenceData(resource, eObject, reference, eObjectEntry, imports);
				}
			}
		}

		// check if attribute is indexed
		if (!IIndexConfigurationManager.INSTANCE.isFeatureIndexed(eAttribute)) {
			return;
		}

		// create the field for the attribute
		Object value = null;
		if (eAttribute.getUpperBound() == ETypedElement.UNSPECIFIED_MULTIPLICITY
				|| FeatureMapUtil.isFeatureMap(eAttribute) || eAttribute.isMany()) {

			ArrayList stringValues = new ArrayList();
			List values;
			Object o = eObject.eGet(eAttribute, false);
			if (!(o instanceof List)) {
				values = Collections.singletonList(o);
			} else {
				values = (List) o;
			}

			for (Iterator j = values.iterator(); j.hasNext();) {
				Object next = j.next();
				if (next != null) {
					String stringValue = EcoreUtil.convertToString(eAttribute.getEAttributeType(), next);
					if (stringValue != null) {
						stringValues.add(stringValue);
					}
				}
			}
		} else {
			Object attributeValue = eObject.eGet(eAttribute, false);
			if (attributeValue != null) {
				String stringValue = EcoreUtil.convertToString(eAttribute.getEAttributeType(),
						attributeValue);
				if (stringValue != null) {
					value = stringValue;
				}
			}
		}

		// add the attribute field
		if (value != null) {
			eObjectEntry.addEAttributeValue(eAttribute, value);
		}
	}

	/**
	 * Returns an EObjectEntry object with the specified eObject's attribute and reference
	 * information.
	 * 
	 * @param resource
	 *           the resource associated with the eObject
	 * @param eObject
	 *           the eObject whose attribute and reference information is updated in the entry
	 * @param imports
	 *           a set to capture the imported resources
	 * @param monitor
	 *           the progress monitor or <code>null</code>
	 * 
	 * @return the created eObject entry
	 */
	protected EObjectEntry indexObjectLevelContents(Resource resource, EObject eObject, Set imports,
			IProgressMonitor monitor) {
		// get the container
		URI containerURI = eObject.eContainer() != null ? IndexContext.normalize(EcoreUtil
				.getURI(eObject.eContainer()), resource.getResourceSet()) : null;

		// create the object
		EObjectEntry eObjectEntry = new EObjectEntry(getContext(), containerURI, eObject.eClass());

		// set the eObject uri
		eObjectEntry.setEObjectURI(EcoreUtil.getURI(eObject));

		if (monitor != null && monitor.isCanceled()) {
			return null;
		}

		// Index reference data
		List references = eObject.eClass().getEAllReferences();
		for (Iterator i = references.iterator(); i.hasNext();) {
			EReference reference = (EReference) i.next();
			if (!reference.isChangeable()) {
				continue;
			}
			if (reference.isDerived()) {
				continue;
			}
			if (!eObject.eIsSet(reference)) {
				continue;
			}
			if (reference.isContainer()) {
				continue;
			}

			indexObjectReferenceData(resource, eObject, reference, eObjectEntry, imports);

			if (monitor != null && monitor.isCanceled()) {
				return null;
			}
		}

		// Index attribute data
		List attributes = eObject.eClass().getEAllAttributes();
		for (Iterator i = attributes.iterator(); i.hasNext();) {
			EAttribute attribute = (EAttribute) i.next();

			indexObjectAttributeData(resource, eObject, attribute, eObjectEntry, imports);

			if (monitor != null && monitor.isCanceled()) {
				return null;
			}
		}

		return eObjectEntry;
	}

	/**
	 * Updates the specified <code>EObjectEntry</code> object with reference information from the
	 * specified EObject for the specified reference feature
	 * 
	 * @param resource
	 *           the resource associated with the eObject
	 * @param eObject
	 *           the eObject whose reference information is updated in the entry
	 * @param reference
	 *           the EReference
	 * @param eObjectEntry
	 *           the corresponding eObject entry that will be added to the index store
	 * @param imports
	 *           a set to capture the imported resources
	 */
	protected void indexObjectReferenceData(Resource resource, EObject eObject,
			EReference reference, EObjectEntry eObjectEntry, Set imports) {

		boolean isManyReference = reference.getUpperBound() == ETypedElement.UNSPECIFIED_MULTIPLICITY
				|| FeatureMapUtil.isFeatureMap(reference) || reference.isMany();

		// handle many and containment
		if (isManyReference && reference.isContainment()) {
			Object o = eObject.eGet(reference);
			List objects;

			if (!(o instanceof List)) {
				objects = Collections.singletonList(o);
			} else {
				objects = (List) o;
			}

			for (Iterator j = objects.iterator(); j.hasNext();) {
				EObject contained = (EObject) j.next();
				if (contained != null) {
					eObjectEntry.addEReferenceValue(reference, IndexContext.normalize(EcoreUtil
							.getURI(contained), resource.getResourceSet()));
				}
			}
		}

		// handle many and non-containment
		if (isManyReference && !reference.isContainment()) {
			Object o = eObject.eGet(reference, false);
			List objects;

			if (!(o instanceof List)) {
				objects = Collections.singletonList(o);
			} else {
				objects = (List) o;
			}

			for (Iterator j = ((InternalEList) objects).basicIterator(); j.hasNext();) {
				EObject referenced = (EObject) j.next();
				if (referenced != null) {
					URI uri = IndexContext.normalize(EcoreUtil.getURI(referenced), resource
							.getResourceSet());

					/* Add to the cross ref list */
					if (!uri.trimFragment().equals(resource.getURI())) {
						imports.add(uri.trimFragment());
					}

					eObjectEntry.addEReferenceValue(reference, uri);
				}
			}
		}

		// handle single and containment
		if (!isManyReference && reference.isContainment()) {
			EObject contained = (EObject) eObject.eGet(reference);
			if (contained != null) {
				eObjectEntry.addEReferenceValue(reference, IndexContext.normalize(EcoreUtil
						.getURI(contained), resource.getResourceSet()));
			}
		}

		// handle single and non-containment
		if (!isManyReference && !reference.isContainment()) {
			EObject referenced = (EObject) eObject.eGet(reference, false);
			if (referenced != null) {
				URI uri = IndexContext.normalize(EcoreUtil.getURI(referenced), resource
						.getResourceSet());

				/* Add to the cross ref list */
				if (!uri.trimFragment().equals(resource.getURI())) {
					imports.add(uri.trimFragment());
				}

				eObjectEntry.addEReferenceValue(reference, uri);
			}
		}
	}

	/**
	 * Returns a ResourceEntry object that contains resource level information for the specified
	 * resource URI.
	 * 
	 * @param resourceSet
	 *           the resource set
	 * @param resourceURI
	 *           the resource uri
	 * @param imports
	 *           the collection of uris that the specfied resource imports
	 * @return the resource entry object
	 */
	protected ResourceEntry indexResourceLevelContents(ResourceSet resourceSet, URI resourceURI,
			Set imports) {
		// create a resource entry
		ResourceEntry entry = new ResourceEntry(getContext(), IndexContext.normalize(resourceURI,
				resourceSet));

		// handle the imports
		Iterator iter = imports.iterator();
		while (iter.hasNext()) {
			entry.addImport((URI) iter.next());
		}

		return entry;
	}

	/*
	 * @see com.ibm.xtools.emf.index.provider.AbstractIndexProvider#createIndexEntriesByParsing(org.eclipse.emf.ecore.resource.ResourceSet,
	 *      org.eclipse.emf.common.util.URI, com.ibm.xtools.emf.index.provider.IIndexWriter,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void createIndexEntriesByParsing(ResourceSet resourceSet, URI resourceURI,
			IIndexWriter indexWriter, IProgressMonitor monitor) throws IndexException {
		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		if (true == false) {
			throw new AbortParsingException();
		}

		try {
			// create the resource handle
			Resource resource = null;
			Resource.Factory resourceFactory = resourceSet.getResourceFactoryRegistry().getFactory(
					resourceURI);
			if (resourceFactory != null) {
				// dont add the resource to the contents of the resource set
				resource = resourceFactory.createResource(resourceURI);
			}

			// verify the resource is an xml resource
			if (!(resource instanceof XMLResource)) {
				MessageFormat format = new MessageFormat(IndexMessages.indexProvider_invalidResource);
				String msg = format.format(new String[] { resourceURI.toString() });

				throw new IndexException(new Status(IStatus.ERROR, IndexPlugin.getPlugin().getBundle()
						.getSymbolicName(), IndexStatusCodes.PARSER_FAILED, msg, null));
			}

			if (monitor != null && monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			// create the xmi handler
			IndexSAXXMLHandler handler = createIndexSAXXMLHandler((XMLResource) resource, resourceSet,
					indexWriter, monitor);

			// verify the handle is valid
			if (handler == null) {
				MessageFormat format = new MessageFormat(IndexMessages.indexProvider_failedToParse);
				String msg = format.format(new String[] { resourceURI.toString() });

				throw new IndexException(new Status(IStatus.ERROR, IndexPlugin.getPlugin().getBundle()
						.getSymbolicName(), IndexStatusCodes.PARSER_FAILED, msg, null));
			}

			if (monitor != null && monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			// create the parser and get the index entries
			InputStream inputStream = null;
			try {
				// create a sax parser factory
				SAXParserFactory parserFactory = SAXParserFactory.newInstance();

				// get the input stream
				inputStream = resourceSet.getURIConverter().createInputStream(resourceURI);

				// create the sax parser
				SAXParser parser = parserFactory.newSAXParser();

				// parse the resource
				parser.parse(inputStream, handler);

				// reset the handler and clean up
				handler.reset();
			} catch (IOException e) {
				MessageFormat format = new MessageFormat(IndexMessages.indexProvider_failedToParse);
				String msg = format.format(new String[] { resourceURI.toString() });

				throw new IndexException(new Status(IStatus.ERROR, IndexPlugin.getPlugin().getBundle()
						.getSymbolicName(), IndexStatusCodes.PARSER_FAILED, msg, e));
			} catch (ParserConfigurationException e) {
				MessageFormat format = new MessageFormat(IndexMessages.indexProvider_failedToParse);
				String msg = format.format(new String[] { resourceURI.toString() });

				throw new IndexException(new Status(IStatus.ERROR, IndexPlugin.getPlugin().getBundle()
						.getSymbolicName(), IndexStatusCodes.PARSER_FAILED, msg, e));
			} catch (SAXException e) {
				// check if the exception embedded exception
				if (e.getException() != null && e.getException() instanceof AbortParsingException) {
					throw (AbortParsingException) e.getException();
				}

				MessageFormat format = new MessageFormat(IndexMessages.indexProvider_failedToParse);
				String msg = format.format(new String[] { resourceURI.toString() });

				throw new IndexException(new Status(IStatus.ERROR, IndexPlugin.getPlugin().getBundle()
						.getSymbolicName(), IndexStatusCodes.PARSER_FAILED, msg, e));
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						// ignore
					}
				}
			}
		} catch (Throwable ex) {
			List<Throwable> exceptions = cachedExceptions.get(resourceURI);
			if (null != exceptions && !exceptions.isEmpty()) {
				if (!exceptions.contains(ex)) {
					exceptions.add(ex);
					throw new IndexException(new Status(IStatus.ERROR, IndexPlugin.getPlugin()
							.getBundle().getSymbolicName(), IndexStatusCodes.PARSER_FAILED, ex
							.getMessage(), ex));
				}
			}
		}
	}

	/*
	 * @see com.ibm.xtools.emf.index.provider.AbstractIndexProvider#createIndexEntriesByLoading(org.eclipse.emf.ecore.resource.ResourceSet,
	 *      org.eclipse.emf.common.util.URI, com.ibm.xtools.emf.index.provider.IIndexWriter,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void createIndexEntriesByLoading(ResourceSet resourceSet, URI resourceURI,
			IIndexWriter indexWriter, IProgressMonitor monitor) throws IndexException {
		/* Create a resource and load the resource */
		Resource resource = resourceSet.getResource(resourceURI, true);

		/* Create the object level index contents */
		Set imports = new HashSet();
		for (Iterator i = resource.getContents().iterator(); i.hasNext();) {
			EObject root = (EObject) i.next();
			if (root != null) {
				if (monitor != null && monitor.isCanceled()) {
					throw new OperationCanceledException();
				}

				// index object level contents
				EObjectEntry entry = indexObjectLevelContents(resource, root, imports, monitor);
				if (entry != null) {
					indexWriter.addIndexEntryToIndex(entry, monitor);
				}

				// iterate over the contents
				TreeIterator iterator = EcoreUtil.getAllProperContents(root, false);
				if (iterator != null) {
					while (iterator.hasNext()) {
						EObject next = (EObject) iterator.next();
						if (monitor != null && monitor.isCanceled()) {
							throw new OperationCanceledException();
						}

						entry = indexObjectLevelContents(resource, next, imports, monitor);
						if (entry != null) {
							indexWriter.addIndexEntryToIndex(entry, monitor);
						}
					}
				}
			}
		}

		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		/* Create the resource level index contents */
		ResourceEntry entry = indexResourceLevelContents(resourceSet, resourceURI, imports);
		if (entry != null) {
			indexWriter.addIndexEntryToIndex(entry, monitor);
		}
	}

	/**
	 * Returns a new instance of <code>IndexSAXXMIHandler</code>. The instance is initialized with
	 * the specified arguments.
	 * 
	 * @param resource
	 *           the resource handle
	 * @param resourceSet
	 *           the resource set used to parse the resource contents
	 * @param indexWriter
	 *           the handle to the index store object for adding the index entries
	 * @param monitor
	 *           the progress monitor or <code>null</code>
	 * @return the new instance of <code>IndexSAXXMIHandler</code>
	 */
	protected IndexSAXXMLHandler createIndexSAXXMLHandler(XMLResource resource,
			ResourceSet resourceSet, IIndexWriter indexWriter, IProgressMonitor monitor) {
		return new IndexSAXXMLHandler(getContext(), resource, resourceSet, indexWriter, monitor);
	}
}
