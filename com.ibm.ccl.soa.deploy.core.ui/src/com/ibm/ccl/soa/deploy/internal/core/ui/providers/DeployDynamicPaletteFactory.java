/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.ui.providers;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.ui.actions.BankUnitAction;
import com.ibm.ccl.soa.deploy.core.ui.internal.type.UnitTypeFactory.HintedSpecializationType;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployCorePaletteFactory;
import com.ibm.ccl.soa.deploy.core.ui.tools.DeployShapeCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeUIBindingDescriptor;

/**
 * A palette factory for dynamic palette additions.
 * 
 * @see DeployCorePaletteFactory for non-dynamic additions
 * @see BankUnitAction
 */
public class DeployDynamicPaletteFactory implements PaletteFactory {

	static Map<String, List<Unit>> _toolidToRootUnitsMap = new HashMap<String, List<Unit>>();

	public Tool createTool(String toolId) {
		//		System.out.println(toolId);

		//		Unit unit = ResourceTypeService.INSTANCE.createFromTemplate(toolId);

		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		String uri = rts.getTemplateURI(toolId);
		String uriV = rts.getTemplateVURI(toolId);
		boolean isDynamic = rts.isDynamicPaletteEntry(toolId);

		//		System.out.println(unit);
		// Manufacture an IElementType from uri
		IElementType ietMM = new MetamodelType(toolId, null, "dummy", //$NON-NLS-1$
				CorePackage.eINSTANCE.getUnit(), null);
		ISpecializationTypeDescriptor istDescr = new DeployDynamicSpecializationTypeDescriptor(ietMM,
				toolId);
		HintedSpecializationType iet = new HintedSpecializationType(istDescr, uri, null, uriV);
		return new DeployShapeCreationTool(iet, getRootObjects(toolId, isDynamic));
	}

	/**
	 * @param toolId
	 * @param isDynamic
	 * @return does this toolId create multiple root objects?
	 */
	static public List<Unit> getRootObjects(String toolId, boolean isDynamic) {
		// cache results to avoid creating template each time
		if (_toolidToRootUnitsMap.containsKey(toolId)) {
			return _toolidToRootUnitsMap.get(toolId);
		}
		// Create the unit (just to check if its a group or not)
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		String templateURIString = rts.getTemplateURI(toolId);
		List<Unit> rootElements = GMFUtils.getRootElements(templateURIString, isDynamic);
		if (!isDynamic) {
			_toolidToRootUnitsMap.put(toolId, rootElements);
		}
		return rootElements;
	}

	public Object getTemplate(String templateId) {
		System.out.println(templateId); // TODO Remove
		return null;
	}

	/**
	 * create a specialization type
	 * 
	 * @param toolId
	 * @return HintedSpecializationType
	 */
	static public HintedSpecializationType createSpecializationType(String toolId) {
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		//String uri = rts.getTemplateURI(toolId);
		ResourceTypeDescriptor descriptor = rts.getResourceTypeDescriptor(toolId);
		String uri = descriptor.getTemplateUri();
		String uriV = descriptor.getTemplateVUri();
		IElementType ietMM = new MetamodelType(toolId, null, "dummy", //$NON-NLS-1$
				CorePackage.eINSTANCE.getUnit(), null);
		ISpecializationTypeDescriptor istDescr = new DeployDynamicSpecializationTypeDescriptor(ietMM,
				toolId);
		return new HintedSpecializationType(istDescr, uri, null, uriV);
	}

	//	private static class DeployDynamicCreationTool extends ShapeCreationTool {
	//		
	//		private Unit unit;
	//
	//		protected DeployDynamicCreationTool(Unit unit) {
	//			this.unit = unit;
	//		}
	//
	////		protected Request createTargetRequest() {
	////			return CreateViewRequestFactory.getCreateShapeRequest(getElementType(),
	////				getPreferencesHint());
	////		}
	//
	//	}

	private static class DeployDynamicSpecializationTypeDescriptor implements
			ISpecializationTypeDescriptor {

		private final IElementType mtype;
		private final String id;
		private final ResourceTypeUIBindingDescriptor desc;

		protected DeployDynamicSpecializationTypeDescriptor(IElementType mtype, String id) {
			this.mtype = mtype;
			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			desc = rts.getResourceTypeUIBindingDescriptor(id);
			this.id = id;
		}

		public IContainerDescriptor getContainerDescriptor() {
			return null;
		}

		public IEditHelperAdvice getEditHelperAdvice() {
			return null;
		}

		public IElementMatcher getMatcher() {
			return null;
		}

		public IElementType[] getSpecializedTypes() {
			return new IElementType[] { mtype };
		}

		public URL getIconURL() {
			//TODO get real Icon URL from resource type service here
			if (desc != null) {
				return desc.getSmallIconURL();
			}
			return null;
		}

		public String getId() {
			return id;
		}

		public String getKindName() {
			return "tool"; //$NON-NLS-1$
		}

		public String getName() {
			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			return rts.getResourceTypeName(id);
		}

		public String getParamValue(String paramName) {
			return null;
		}

	} // end class DeployDynamicSpecializationTypeDescriptor
} // end class DeployDynamicPaletteFactory
