package com.ibm.ccl.soa.deploy.index.internal.emf.index.xml.providers;

import org.eclipse.core.runtime.content.IContentType;

import com.ibm.xtools.emf.index.provider.AbstractIndexProviderFactory;
import com.ibm.xtools.emf.index.provider.IIndexProvider;

public class XMLIndexProviderFactory extends AbstractIndexProviderFactory {

	/**
	 * Constructor
	 */
	public XMLIndexProviderFactory() {
		super();
	}

	/*
	 * @see com.ibm.xtools.emf.index.configuration.IIndexProviderFactory#createIndexProvider(org.eclipse.core.runtime.content.IContentType)
	 */
	public IIndexProvider createIndexProvider(IContentType contentType) {
		return new XMLIndexProvider();
	}
}
