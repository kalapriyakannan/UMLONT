/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.type;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeFactory;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;

import com.ibm.ccl.soa.deploy.core.ui.util.IUnitElementType;

public class UnitTypeFactory extends AbstractElementTypeFactory {
	/**
	 * The hinted type kind. This string is specified in the XML 'kind' attribute of any element type
	 * that is a hinted type.
	 */
	public static final String HINTED_TYPE_KIND = "com.ibm.ccl.soa.deploy.core.ui.util.IUnitElementType"; //$NON-NLS-1$

	/**
	 * The templateURI hint parameter name. This is used for specialized element types.
	 */
	private static final String URI_HINT_PARAM_NAME = "templateURI"; //$NON-NLS-1$

	/**
	 * The semantic hint parameter name.
	 */
	private static final String SEMANTIC_HINT_PARAM_NAME = "semanticHint"; //$NON-NLS-1$

	/**
	 * The hinted specialization type class.
	 */
	public static final class HintedSpecializationType extends SpecializationType implements
			IUnitElementType {

		/**
		 * The templateURI hint.
		 */
		private final String templateURI;

		/**
		 * The templateURI hint.
		 */
		private String templateVURI;

		/**
		 * The semantic hint.
		 */
		private final String semanticHint;

		/**
		 * Constructs a new hinted type.
		 * 
		 * @param descriptor
		 *           the specialization type descriptor
		 * @param semanticHint
		 *           the semantic hint
		 */
		public HintedSpecializationType(ISpecializationTypeDescriptor descriptor, String templateURI,
				String semanticHint) {
			super(descriptor);
			this.templateURI = templateURI;
			this.semanticHint = semanticHint;

		}

		public HintedSpecializationType(ISpecializationTypeDescriptor descriptor, String templateURI,
				String semanticHint, String aTemplateVuri) {
			super(descriptor);
			this.semanticHint = semanticHint;
			this.templateURI = templateURI;
			templateVURI = aTemplateVuri;

		}

		/**
		 * Gets the semantic hint.
		 */
		public String getTemplateURI() {
			return templateURI;
		}

		/**
		 * Gets the semantic hint.
		 */
		public String getSemanticHint() {
			return semanticHint;
		}

		public String getTemplateVURI() {
			return templateVURI;
		}
	}

	/**
	 * The hinted metamodel type class.
	 */
	public static final class HintedMetamodelType extends MetamodelType implements IUnitElementType {

		/**
		 * The semantic hint.
		 */
		private final String semanticHint;

		/**
		 * Constructs a new hinted type.
		 * 
		 * @param descriptor
		 *           the specialization type descriptor
		 * @param semanticHint
		 *           the semantic hint
		 */
		public HintedMetamodelType(IMetamodelTypeDescriptor descriptor, String semanticHint) {

			super(descriptor);
			this.semanticHint = semanticHint;
		}

		/**
		 * Gets the semantic hint.
		 */
		public String getTemplateURI() {
			return null;
		}

		/**
		 * Gets the semantic hint.
		 */
		public String getSemanticHint() {
			return semanticHint;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeFactory#createSpecializationType(org.eclipse.gmf.runtime.emf.type.core.internal.impl.SpecializationTypeDescriptor)
	 */
	public ISpecializationType createSpecializationType(ISpecializationTypeDescriptor descriptor) {

		String templateURI = descriptor.getParamValue(URI_HINT_PARAM_NAME);

		String semanticHint = descriptor.getParamValue(SEMANTIC_HINT_PARAM_NAME);

		return new HintedSpecializationType(descriptor, templateURI, semanticHint);
	}

	public IMetamodelType createMetamodelType(IMetamodelTypeDescriptor descriptor) {

		String semanticHint = descriptor.getParamValue(SEMANTIC_HINT_PARAM_NAME);

		return new HintedMetamodelType(descriptor, semanticHint);
	}
}
