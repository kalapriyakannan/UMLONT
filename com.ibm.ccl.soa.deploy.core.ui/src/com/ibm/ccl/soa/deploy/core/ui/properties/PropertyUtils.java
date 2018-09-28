/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionUtils;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.operation.DeleteModelObjectOperation;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.FindUnitDialog;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployCoreCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.ErrorMarkerFigureFactory;
import com.ibm.ccl.soa.deploy.core.ui.internal.SoaDeployUiUtil;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CollapseCommand;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.DeployEMFLabelProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.IRequirementExpressionInterpreter;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployOperation;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus;

/**
 * Static util methods for properties
 */
public class PropertyUtils {

	/**
	 * Name for an unknown/missing etype
	 */
	public static final String NO_ETYPE = Messages.PropertyUtils_none_;

	private static final List<ConnectionNodeEditPart> NO_EDIT_PARTS = Collections.emptyList();

	private static ILabelProvider labelProvider;

	private static Map<String, EClass> capTypes;
	private static Map<String, EClass> instCapTypes;
	private static Map<String, EClass> unitTypes;
	private static List<Capability> registeredBankedCapabilities;
	private static Image icon_optional;

	private static Image icon_prohibited;

	private static ViewerComparator viewerComparator;

	/**
	 * @param cap
	 * @return display name for a Capability
	 */
	public static String getName(Capability cap) {
		if (cap != null) {
			return cap.getCaptionProvider().title(cap);
		}

		return getName2(cap /* , Messages.PROVIDES_LABEL */);
	}

	/**
	 * @param link
	 * @return display name for a UnitLink
	 */
	public static String getName(UnitLink link) {
		return getName2(link);
	}

	/**
	 * @param link
	 * @return display name for a RealizationLink
	 */
	public static String getName(RealizationLink link) {
		return getName2(link);
	}

	/**
	 * @param link
	 * @return display name for a DependencyLink
	 */
	public static String getName(DependencyLink link) {
		return getName2(link);
	}

	/**
	 * @param artifact
	 * @return display name for an Artifact
	 */
	public static String getName(Artifact artifact) {
		return getName2(artifact);
	}

	/**
	 * @param link
	 * @return display name for a LogicalLink
	 */
	public static String getName(ConstraintLink link) {
		return getName2(link);
	}

	/**
	 * @param req
	 * @return display name for a Requirement
	 */
	public static String getName(Requirement req) {
		if (req != null && req.getDisplayName() == null) {
			// Don't use the default getName(), which will call this requirement 'anonymous'
			return calculateDisplayName(req);
		}

		return getName2(req /* , Messages.CONSUMES_LABEL */);
	}

	/**
	 * @param re
	 * @return displayable name for the expression
	 */
	public static String getName(RequirementExpression re) {
		if (re != null && re.getDisplayName() == null) {
			// Don't use the default getName(), which will call this requirement 'anonymous'
			return calculateDisplayName(re);
		}

		return getName2(re /* , Messages.PropertyUtils_RequirementExpressio_ */);
	}

	/**
	 * @param unit
	 * @return display name for a Unit
	 */
	public static String getName(Unit unit) {
		if (unit != null) {
			return unit.getCaptionProvider().titleWithContext(unit);
		}

		return getName2(unit);
	}

	/**
	 * @param top
	 * @return display name for a Topology
	 */
	public static String getName(Topology top) {
		return getName2(top);
		//		return getName2(unit /*, Messages.PropertyUtils_Uni_*/);
	}

	/**
	 * @param imp
	 * @return display name for an Import
	 */
	public static String getName(Import imp) {
		return getName2(imp);
	}

	/**
	 * @param dmo
	 * @return display name for DMO
	 */
	public static String getDmoName(DeployModelObject dmo) {
		return getName2(dmo);
	}

	/**
	 * @param dmo
	 * @return a Unit to use for a dmo (usually the one that contains it), or <code>null</code>
	 */
	public static Unit getUnitForDmo(DeployModelObject dmo) {
		while (dmo != null && !(dmo instanceof Unit)) {
			dmo = dmo.getParent();
		}

		return (Unit) dmo;
	}

	protected static String getName2(DeployModelObject dmo /* , String def */) {
		if (dmo == null) {
			return Messages.PropertyUtils_null_;
		}

		if (dmo instanceof Capability) {
			Capability cap = (Capability) dmo;
			return cap.getCaptionProvider().title(cap);
		} else if (dmo instanceof Unit) {
			Unit unit = (Unit) dmo;
			return unit.getCaptionProvider().title(unit);
		}

		if (dmo.getDisplayName() != null && dmo.getDisplayName().length() > 0) {
			return dmo.getDisplayName();
		}

		//		if (dmo.getName() != null && dmo.getName().length() > 0) {
		//			return NLS.bind(Messages.PropertyUtils_anonymous_0_1_, new Object[] { def, dmo.getName() });
		//		}
		//		
		//		return NLS.bind(Messages.PropertyUtils_anonymous_0_, def);

		// Re bug 9631, Narinder demands the internal anchor name be used if
		// an internal error created a DMO with no external name.

		// Re bug https://cs.opensource.ibm.com/bugzilla/show_bug.cgi?id=11561 can't
		// handle unanchored capability
		if (dmo.getName() == null) {
			return com.ibm.ccl.soa.deploy.core.ui.properties.Messages.PropertyUtils_no_ID_;
		}

		return dmo.getName();
	}

	/**
	 * delegate allowing each Interpreter its own calculation logic
	 * 
	 * @param re
	 * @return human-readable representation of 're'
	 */
	private static String calculateDisplayName(RequirementExpression re) {
		IRequirementExpressionInterpreter interp = com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil
				.getInterpreter(re);
		return interp.computeTitle(re);
	}

	//	private static String stringValue(String s) {
	//		if (s == null) {
	//			return ""; //$NON-NLS-1$
	//		}
	//		
	//		return s;
	//	}

	private static String calculateDisplayName(Requirement req) {
		if (req.getExpressions().size() == 0) {
			if (req.getDmoEType() != null) {
				return req.getDmoEType().getName();
			}

			// No REs *and* no etype -- promiscuous requirement
			return "*"; //$NON-NLS-1$
		}

		StringBuffer sb = new StringBuffer();
		for (Iterator it = req.getExpressions().iterator(); it.hasNext();) {
			RequirementExpression re = (RequirementExpression) it.next();
			sb.append(getName(re));

			if (it.hasNext()) {
				sb.append(" && "); //$NON-NLS-1$
			}
		}

		return sb.toString();
	}

	/**
	 * @return a label provider for DMOs.
	 */
	public static synchronized ILabelProvider getSoaLabelProvider() {
		if (labelProvider == null) {
			labelProvider = createLabelProvider();
		}

		return labelProvider;
	}

	private static ILabelProvider createLabelProvider() {
		return new DeployEMFLabelProvider();
//		return new PropUtilLabelProvider();
	}

//	private static class PropUtilLabelProvider extends LabelProvider implements IBaseLabelProvider {
//		private static AdapterFactoryLabelProvider iconProvider;
//
//		public Image getImage(Object element) {
//			Image retVal = null;
//
//			if (element instanceof DeployModelObject) {
//				DeployModelObject dmo = (DeployModelObject) element;
//				retVal = PropertyUtils.getStatusTableImage(dmo.getStatus());
//			}
//
//			// TODO In the future, perhaps we can extend this to other types and get icons
//			// for other modeled classes?
//			if (retVal == null && element instanceof Capability) {
//				retVal = getAdapterImageProvider().getImage(element);
//			}
//
//			return retVal;
//		}
//
//		public String getText(Object element) {
//			if (element instanceof Unit) {
//				Unit unit = (Unit) element;
//				return getName(unit);
//			} else if (element instanceof Capability) {
//				return getName((Capability) element);
//			} else if (element instanceof Interface) {
//				Interface interfaze = (Interface) element;
//				AbstractInterfaceHandler handler = DeployCoreUIPlugin.getDefault()
//						.getInterfaceHandlerService().findInterfaceHandlerForInterface(interfaze);
//				String iname = DeployNLS.bind(Messages.NubEditDialog_Interface_0_, handler
//						.getInterfacePropertyLabel(interfaze));
//				return iname;
//			} else if (element instanceof Constraint) {
//				Constraint constraint = (Constraint) element;
//				return ConstraintService.INSTANCE.title(constraint);
//			} else if (element instanceof ShortConstraintDescriptor) {
//				ShortConstraintDescriptor descr = (ShortConstraintDescriptor) element;
//				return descr.getTitle();
//			} else if (element instanceof Artifact) {
//				Artifact artifact = (Artifact) element;
//				return getName(artifact);
//			} else if (element instanceof UnsetInterface) {
//				return com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPropertiesLabelProvider_Set_Interface_;
//			}
//
//			return element == null ? "" : element.toString();//$NON-NLS-1$
//		}
//
//		private ILabelProvider getAdapterImageProvider() {
//			if (iconProvider == null) {
////				iconProvider = new AdapterFactoryLabelProvider(new DynamicAdapterFactory(null));
//				iconProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(EMFEditPlugin
//						.getComposedAdapterFactoryDescriptorRegistry()));
//			}
//
//			return iconProvider;
//		}
//
//	}

	/**
	 * @param unit
	 * @param context
	 *           if unit is imported the context is the topology doing the import
	 * @return all Units one degree away from this Unit
	 */
	public static List<DeployLink> getLinksFromAndTo(Unit unit, Topology context) {
		List<DeployLink> retVal = getLinksFrom(unit);

		// Now, check for links TO this Unit
		//		Topology top = unit.getTopology();
		Topology top = unit.getEditTopology();

		if (top != null) {
			retVal.addAll(getLinksTo(unit, top));

			//		System.out.println("Topology " + top.getDisplayName() + " has " + top.getImports().size() + " imports");  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
			for (Iterator<Topology> it = getImportedTopologies(top).iterator(); it.hasNext();) {
				Topology topImport = it.next();
				retVal.addAll(getLinksTo(unit, topImport));
			}
		}

		return retVal;
	}

	private static Collection<Topology> getImportedTopologies(Topology top) {
		// @@@ TODO Bug doesn't consider recursive imports
		List<Topology> retVal = new LinkedList<Topology>();
		for (Iterator it = top.getImports().iterator(); it.hasNext();) {
			Import imp = (Import) it.next();
			List<Unit> units = imp.getInstanceConfiguration().getPublicUnits();
			if (units.size() > 0) {
				Unit unitImported = units.get(0);
				Topology topImported = unitImported.getTopology();
				if (!retVal.contains(topImported)) {
					retVal.add(topImported);
				}
			}
		}

		return retVal;
	}

	/**
	 * @param unit
	 * @param top
	 * @return Collection of DeployLink
	 */
	private static Collection<DeployLink> getLinksTo(Unit unit, Topology top) {
		List<DeployLink> retVal = new LinkedList<DeployLink>();
		// TODO Uncomment
		//		retVal.add(ValidatorUtils.getImmediateHostingLink(unit, false));
		//		retVal.addAll(ValidatorUtils.getImmediateGroupLinks(unit));
		//		for (Iterator it = unit.getRequirements().iterator(); it.hasNext(); ) {
		//			Requirement req = (Requirement) it.next();
		//			retVal.addAll(ValidatorUtils.getImmediateDependencyLinks(req));
		//		}
		//		retVal.add(ValidatorUtils.getImmediateRealizationLink());
		// TODO Comment
		if (top != null) {
			for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
				Unit u = (Unit) it.next();
				if (u != unit) {
					List<DeployLink> uLinks = getLinksFrom(u);
					for (Iterator<DeployLink> it2 = uLinks.iterator(); it2.hasNext();) {
						DeployModelObject dmo = it2.next();
						if (dmo instanceof DependencyLink) {
							DependencyLink dlink = (DependencyLink) dmo;
							if (dlink.getTarget() != null && dlink.getTarget().getParent() == unit) {
								retVal.add(dlink);
							}
						} else if (dmo instanceof UnitLink) {
							UnitLink hlink = (UnitLink) dmo;
							if (hlink.getTarget() == unit) {
								retVal.add(hlink);
							}
						} else if (dmo instanceof ConstraintLink) {
							ConstraintLink llink = (ConstraintLink) dmo;
							if (llink.getTarget() == unit) {
								retVal.add(llink);
							} else if (llink.getTarget() instanceof Capability) {
								Capability cap = (Capability) llink.getTarget();
								if (cap.getParent() == unit) {
									retVal.add(llink);
								}
							}
						}
					}
				}
			}

			for (Iterator it = top.getRealizationLinks().iterator(); it.hasNext();) {
				RealizationLink rlink = (RealizationLink) it.next();
				if (/* dlink.getSource() == unit || */rlink.getTarget() == unit) {
					retVal.add(rlink);
				}
			}

			//		for (Iterator it = top.getDependencyLinks().iterator(); it.hasNext(); ) {
			//			DependencyLink dlink = (DependencyLink) it.next();
			//			if (unit.getCapabilities().contains(dlink.getTarget())) {
			//				retVal.add(dlink);
			//			}
			//		}

		} // endif top!=null

		return retVal;
	}

	/**
	 * Get links from 'unit'. (Does not include realization links.)
	 * 
	 * @param unit
	 * @return List of {@link DeployLink}
	 */
	private static List<DeployLink> getLinksFrom(Unit unit) {
		List<DeployLink> retVal = new LinkedList<DeployLink>();

		Topology top = unit.getEditTopology();
		if (top != null) {
			for (Iterator it = top.getRealizationLinks().iterator(); it.hasNext();) {
				RealizationLink rlink = (RealizationLink) it.next();
				if (rlink.getSource() == unit) {
					retVal.add(rlink);
				}
			}

			for (Iterator it = top.getDependencyLinks().iterator(); it.hasNext();) {
				DependencyLink dlink = (DependencyLink) it.next();
				if (dlink.getSource().getParent() == unit) {
					retVal.add(dlink);
				}
			}
		}

		retVal.addAll(unit.getUnitLinks());
		retVal.addAll(unit.getConstraintLinks());

		for (Iterator it = unit.getRequirements().iterator(); it.hasNext();) {
			Requirement req = (Requirement) it.next();
			if (req.getLink() != null) {
				// This link might be a duplicate.  req.getLink() could be a regular link,
				// or a proxy to an intra-import link, or a proxy to an inter-import link.
				// We've already looked at the inter-import links.
				if (!retVal.contains(req.getLink())) {
					retVal.add(req.getLink());
				}
			}
		}

		return retVal;
	}

	/**
	 * @param path
	 * @return Image from *.core.ui
	 */
	public static Image createImage(String path) {
		try {
			return createImageDescriptor(path).createImage();
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * @param path
	 * @return ImageDescriptor from *.core.ui plug-in
	 */
	public static ImageDescriptor createImageDescriptor(String path) {
		return DeployCoreUIPlugin.getImageDescriptor(path);
	}

	/**
	 * Get the EditPart for dmo; if dmo has multiple EditParts return the one <i>after</i>
	 * 'oldEditPart'
	 * 
	 * @param dmo
	 * @param provider
	 * 
	 * @return the next EditPart that corresponds to 'dmo'
	 */
	private static EditPart getEditPart(DeployModelObject dmo, EditPartViewer viewer,
			EditPart oldEditPart) {
		// If nothing is selected, use the other algorithm
		if (oldEditPart == null) {
			return getEditPart(dmo, viewer);
		}

		//		if (provider instanceof EditPartViewer) {
		//			EditPartViewer viewer = (EditPartViewer) provider;
		EditPart epRoot = viewer.getRootEditPart();

		List allEditPartsForDmo = GMFUtils.getEditPartsFor(epRoot, dmo);
		int index = allEditPartsForDmo.indexOf(oldEditPart);
		if (index + 1 < allEditPartsForDmo.size()) {
			return (EditPart) allEditPartsForDmo.get(index + 1);
		}

		return (EditPart) allEditPartsForDmo.get(0);
		//		}

		//		return null;
	}

	/**
	 * Look up the semantic object's EditPart using the selection provider
	 * 
	 * @param dmo
	 * @param provider
	 * @return the EditPart that corresponds to 'dmo'
	 */
	private static EditPart getEditPart(DeployModelObject dmo, EditPartViewer viewer) {
		//		if (provider instanceof EditPartViewer) {
		//			EditPartViewer viewer = (EditPartViewer) provider;
		for (Iterator it = viewer.getRootEditPart().getChildren().iterator(); it.hasNext();) {
			EditPart dep = (EditPart) it.next();
			if (dep instanceof GraphicalEditPart) {
				GraphicalEditPart gep = (GraphicalEditPart) dep;
				EditPart retVal = gep.findEditPart(gep, dmo);
				if (retVal != null) {
					return retVal;
				}
			}
		}
		//		}

		return null;
	}

	/**
	 * @param epDmo
	 * @return 'epDmo' (for historical reasons)
	 */
	public static EditPart makeVisible(EditPart epDmo) {
		if (epDmo == null) {
			return null;
		}

		EditPart ep = epDmo;
		CompositeCommand cc = new CompositeCommand(""); //$NON-NLS-1$
		while (ep.getParent() != null) {
			ep = ep.getParent();
			if (ep instanceof DeployListCompartmentEditPart
					|| ep instanceof DeployCoreCompartmentEditPart) {
				cc.compose(createShapeUncollapseCommand((IGraphicalEditPart) ep));
			}
		}
		// don't execute on stack-- reveal may have been called by an unrelated command
		if (cc.size() > 0) {
			try {
				cc.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
			}
		}

		return epDmo;
	}

	private static CollapseCommand createShapeUncollapseCommand(IGraphicalEditPart ep) {
		TransactionalEditingDomain domain = ep.getEditingDomain();
		CollapseCommand collapse = new CollapseCommand(domain, ep, false);
		return collapse;
	}

	/**
	 * Reveal on diagram; if Unit has mulitple {@link EditPart}s reveal the next one after the
	 * currently selected one.
	 * 
	 * @param unit
	 * @param part
	 */
	public static void revealNext(Unit unit, IWorkbenchPart part) {
		if (part != null && part.getSite().getSelectionProvider() instanceof EditPartViewer) {
			EditPartViewer epv = (EditPartViewer) part.getSite().getSelectionProvider();
			EditPart oldEditPart = getSelectedEditPartIfFor(unit, part);
			EditPart ep = getEditPart(unit, epv, oldEditPart);
			revealEditPart(ep, part);
		}
	}

	/**
	 * Return the currently selected EditPart, iff it represents 'unit'. We do this do that we can
	 * make the dialog behave like find/next if the unit being selected is already selected
	 * 
	 * @param unit
	 * @return an EditPart representing 'unit', or null
	 */
	private static EditPart getSelectedEditPartIfFor(Unit unit, IWorkbenchPart part) {
		ISelection sel = part.getSite().getSelectionProvider().getSelection();
		if (sel instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) sel;
			if (ss.getFirstElement() instanceof EditPart) {
				EditPart ep = (EditPart) ss.getFirstElement();
				if (ep.getModel() instanceof Node) {
					Node node = (Node) ep.getModel();
					if (node.getElement() == unit) {
						return ep;
					}
				}
			}
		}

		return null;
	}

	//	public static void reveal(Unit unit, IWorkbenchPart part, EditPart oldEditPart) {
	//		EditPart ep = getEditPart(unit, part.getSite().getSelectionProvider(), oldEditPart);
	//		revealEditPart(ep, part);
	//	}

	/**
	 * Reveal on the active diagram.
	 * 
	 * @param dmo
	 *           A {@link DeployModelObject} that you want revealed in the diagram.
	 */
	public static void reveal(DeployModelObject dmo) {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			IWorkbenchPage page = window.getActivePage();
			if (page != null) {
				//				reveal(dmo, page.getActivePart());
				reveal(dmo, ResourceUtils.getActiveDeployEditDomain());
			}
		}
	}

	/**
	 * Reveal on the diagram
	 * 
	 * @param dmo
	 *           A {@link DeployModelObject} that you want revealed in the diagram.
	 * @param part
	 *           The {@link IWorkbenchPart} that has the diagram.
	 */
	public static void reveal(DeployModelObject dmo, IWorkbenchPart part) {
		if (part != null && part.getSite() != null
				&& part.getSite().getSelectionProvider() instanceof EditPartViewer) {
			EditPartViewer epv = (EditPartViewer) part.getSite().getSelectionProvider();
			EditPart ep = getEditPart(dmo, epv);
			revealEditPart(ep, part);
		}
	}

	/**
	 * Select and reveal the EditPart, and set the focus to the part. (Setting the focus is
	 * important, because without it the property page won't show the new selection.)
	 * 
	 * @param ep
	 * @param part
	 */
	public static void revealEditPart(EditPart ep, IWorkbenchPart part) {
		// There is no longer any need to call makeVisible(), because it
		// visibility is now handled by {@link DeployGraphicalViewer#reveal(EditPart)}.
//		ep = makeVisible(ep);

		if (ep != null) {

			StructuredSelection selectionOpposite = new StructuredSelection(ep);
			part.getSite().getSelectionProvider().setSelection(selectionOpposite);
			//			System.out.println(selProv);

			// If the master is a GEF viewer, make the selection visible if scrolled away.
			if (part.getSite().getSelectionProvider() instanceof GraphicalViewer) {
				GraphicalViewer sgv = (GraphicalViewer) part.getSite().getSelectionProvider();
				sgv.reveal(ep);
			}

			part.setFocus();
		}
	}

	/**
	 * @param ec
	 * @param valForNone
	 *           return value if ec isn't an OK etype
	 * @return The EClass as a displayable name
	 */
	public static String getDisplayEType(EClass ec, String valForNone) {
		if (ec != null) {
			//			return ec.getName();
			EPackage ep = ec.getEPackage();
			String displayName = ep.getName() + '.' + ec.getName();
			return displayName;
		}

		// No REs *and* no etype -- promiscuous requirement
		//		return "*"; //$NON-NLS-1$
		return valForNone;
	}

	/**
	 * @param req
	 * @return <code>true</code> if the requirement is met (equiv to linked)
	 */
	public static boolean isMet(Requirement req) {
		if (req.getLinkType() == RequirementLinkTypes.ANY_LITERAL && req.getLink() != null) {
			return true;
		}

		if (req.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL) {
			return req.getLink() != null;
		}

		// Fallthrough for HOSTING_LITERAL and unlinked ANY_LITERAL
		if (req.getParent() == null || !(req.getParent() instanceof Unit)) {
			return false;
		}

		Unit unit = (Unit) req.getParent();
		if (unit.getTopology() == null) {
			return false;
		}

		Unit hoster = ValidatorUtils.getImmediateHost(unit);
		return hoster != null;
	}

	/**
	 * @return a Map of String to EClass for the capability ETypes displays
	 */
	public static synchronized Collection<String> getCapTypeNames() {
		return getCapTypes().keySet();
	}

	/**
	 * @return a Map of String to EClass for the capability ETypes displays
	 */
	public static synchronized Collection<String> getInstantiatableCapTypeNames() {
		return getInstantiatableCapTypes().keySet();
	}

	/**
	 * @param ecName
	 * @return Given a string returned from {@link #getCapTypeNames()} or {@link #getUnitTypeNames()}
	 *         get an EClass
	 */
	public static EClass getETypeFromName(String ecName) {
		Object ecCap = getCapTypes().get(ecName);
		if (ecCap != null) {
			return (EClass) ecCap;
		}

		return getUnitTypes().get(ecName);
	}

	/**
	 * @param ecName
	 * @return Given a string returned from getCapTypeNames(), get an instance Capability
	 */
	public static Capability createCapability(String ecName) {
		EClass ec = getETypeFromName(ecName);
		if (ec == null) {
			// This would happen, for example, if ecName was {@link PropertyUtils#NO_ETYPE}
			return null;
		}
		EPackage pack = (EPackage) ec.eContainer();
		EFactory factory = pack.getEFactoryInstance();
		Capability cap = (Capability) factory.create(ec);
		//6536: Adding a capability is not setting the link type
		cap.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
		return cap;
	}

	/**
	 * @return a Map of String to EClass for the capability ETypes displays
	 */
	private static synchronized Map<String, EClass> getCapTypes() {
		if (capTypes == null) {
			capTypes = createCapTypes(true);
		}

		return capTypes;
	}

	/**
	 * @return a Map of String to EClass for the instantiatable capability ETypes displays
	 */
	private static synchronized Map<String, EClass> getInstantiatableCapTypes() {
		if (instCapTypes == null) {
			instCapTypes = createCapTypes(false);
		}

		return instCapTypes;
	}

	private static Map<String, EClass> createCapTypes(boolean useabstracts) {
		Map<String, EClass> retVal = createCoreCapTypes();

		List<String> namespaces = ExtensionUtils.getSoaDeployDomainNamespaces();
		for (Iterator<String> it = namespaces.iterator(); it.hasNext();) {
			String ns = it.next();
			List<EClass> capETypes = getCapsForNamespace(ns, useabstracts);
			for (Iterator<EClass> it2 = capETypes.iterator(); it2.hasNext();) {
				EClass ec = it2.next();
				//				retVal.put(ec.getName(), ec);
				//				EPackage ep = ec.getEPackage();
				//				String displayName = ep.getName() + '.' + ec.getName();
				String displayName = getDisplayEType(ec, "*"); //$NON-NLS-1$
				retVal.put(displayName, ec);
			}
		}

		retVal.put(NO_ETYPE, null);

		return retVal;
	}

	private static Map<String, EClass> createCoreCapTypes() {
		Map<String, EClass> retVal = new TreeMap<String, EClass>();

		EClass ecTarget = CorePackage.eINSTANCE.getCapability();
		String displayName = getDisplayEType(ecTarget, "*"); //$NON-NLS-1$
		retVal.put(displayName, ecTarget);

		for (Iterator<EClassifier> it = CorePackage.eINSTANCE.getEClassifiers().iterator(); it
				.hasNext();) {
			Object eclazz = it.next();
			if (eclazz instanceof EClass) {
				EClass ec = (EClass) eclazz;
				if (ec.getEAllSuperTypes().contains(ecTarget)) {
					displayName = getDisplayEType(ec, "*"); //$NON-NLS-1$
					retVal.put(displayName, ec);
				}
			}
		}

		return retVal;
	}

	/**
	 * Given a namespace known to EPackage.Registry; get all Capability EClasses in the package for
	 * that namespace
	 */
	private static List<EClass> getCapsForNamespace(String ns, boolean includeAbstracts) {
		EClass ecTarget = CorePackage.eINSTANCE.getCapability();
		return getSubtypesForNamespace(ns, ecTarget, includeAbstracts);
	}

	/**
	 * Given a namespace known to EPackage.Registry; get all Capability EClasses in the package for
	 * that namespace
	 */
	private static List<EClass> getSubtypesForNamespace(String ns, EClass ecTarget,
			boolean includeAbstracts) {
		List<EClass> retVal = new LinkedList<EClass>();

		try {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(ns);
			if (ePackage == null) {
				// Some namespaces, like com.ibm.ccl.soa.deploy.tests.domain1 in the deploy.tests plugin,
				// don't have an associated EPackage.  Thus, no capabilities.
				return Collections.emptyList();
			}

			for (Iterator<EClassifier> it = ePackage.getEClassifiers().iterator(); it.hasNext();) {
				Object eclazz = it.next();
				if (eclazz instanceof EClass) {
					EClass ec = (EClass) eclazz;
					//				System.out.println("Found classifier " + ec.getName() + " in " + ns);  //$NON-NLS-1$//$NON-NLS-2$
					if (ec.getEAllSuperTypes().contains(ecTarget)) {
						if (includeAbstracts || !ec.isAbstract()) {
							retVal.add(ec);
						}
					}
				}
			}
		} catch (Exception ex) {
			// If an error happened ignore the package, even capabilities identified before the error.
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
			return Collections.emptyList();
		}

		return retVal;
	}

	/**
	 * @return 16x16 icon that can be used to indicate something is optional
	 */
	public static Image getOptionalIcon() {
		if (icon_optional == null) {
			icon_optional = createImage("icons/reltypes/optional.gif"); //$NON-NLS-1$
		}

		return icon_optional;
	}

	/**
	 * @return 16x16 'no smoking' icon that can be used to indicate something is prohibited
	 */
	public static Image getProhibitedIcon() {
		if (icon_prohibited == null) {
			icon_prohibited = createImage("icons/reltypes/prohibited.gif"); //$NON-NLS-1$
		}

		return icon_prohibited;
	}

	/**
	 * Given a Unit, get its {@link Requirement}s but merge all hosting requirements into a single
	 * item.
	 * 
	 * @param u
	 * @return list of requirements and maybe a single CollectiveHostingRequirement.
	 */
	public static List<Object> getRequirementsFlatteningHosting(Unit u) {
		List<Object> retVal = new LinkedList<Object>();
		List<Requirement> hostingReqs = new LinkedList<Requirement>();
		for (Iterator it = u.getRequirements().iterator(); it.hasNext();) {
			Requirement req = (Requirement) it.next();
			if (req.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL) {
				hostingReqs.add(req);
			} else {
				retVal.add(req);
			}

		}

		if (hostingReqs.size() > 0) {
			retVal.add(new CollectiveHostingRequirement(u, hostingReqs));
		}

		return retVal;
	}

	/**
	 * For the GUI, an object that represents all the hosting requirements on a Unit.
	 * 
	 * @author Ed Snible
	 */
	public final static class CollectiveHostingRequirement {

		private static Image HOSTING;
		private static Image LINKED_HOSTING;

		private final List<Requirement> hostingReqs;
		private final Unit unit;

		/**
		 * @param unit
		 * @param hostingReqs
		 */
		public CollectiveHostingRequirement(Unit unit, List<Requirement> hostingReqs) {
			this.unit = unit;
			this.hostingReqs = hostingReqs;
		}

		/**
		 * @return array of hosting Requirements
		 */
		public Object[] getChildren() {
			return hostingReqs.toArray();
		}

		/**
		 * @return name of linked unit, or "" if none
		 */
		public String getLinkText() {
			// Units not in topologies cannot be linked to
			if (unit.getTopology() == null) {
				return ""; //$NON-NLS-1$
			}

			Unit hoster = ValidatorUtils.getImmediateHost(unit);
			if (hoster == null) {
				return ""; //$NON-NLS-1$
			}

			return PropertyUtils.getName(hoster);
		}

		/**
		 * @return icon for tree
		 */
		public Image getColumnImage() {
			if (HOSTING == null) {
				//				HOSTING = PropertyUtils.createImage("icons/svctypes/hosting_requirement.gif");  //$NON-NLS-1$;
				//				LINKED_HOSTING = PropertyUtils.createImage("icons/svctypes/linked_hosting_requirement.gif");  //$NON-NLS-1$;
				HOSTING = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_HOSTING);
				LINKED_HOSTING = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_LINKED_HOSTING);
			}

			// Is there a Unit error?
			if (!unit.getStatus().isOK()) {
				// Is it a hosting error?
				for (Iterator it = new StatusIterator(unit.getStatus()); it.hasNext();) {
					Object obj = it.next();
					if (obj instanceof DeployAttributeStatus) {
						DeployAttributeStatus das = (DeployAttributeStatus) obj;
						if (das.getProblemType().equals(ICoreProblemType.UNIT_NOT_HOSTED)) {
							// Yes, hosting error
							//							return ErrorMarkerFigureFactory.getFigureImageNoQuickfix(das);
							//							return DeployCoreImages.IMAGE_ERROR_TBL;
							return PropertyUtils.getStatusTableImage(das);
						}
					}
				}
			}

			return isLinked() ? LINKED_HOSTING : HOSTING;
		}

		/**
		 * @return <code>true</code> if this CHR is on a unit with a hosting link
		 */
		public boolean isLinked() {
			return unit.getTopology() != null && ValidatorUtils.getImmediateHost(unit) != null;
		}

		/**
		 * @return the Unit associated with this CHR
		 */
		public Unit getUnit() {
			return unit;
		}

		/**
		 * @return a message if the unit isn't hosted, or null if there is no hosting error
		 */
		public String getHostingStatusTooltip() {
			// Is there a Unit error?
			if (!unit.getStatus().isOK()) {
				// Is it a hosting error?
				for (Iterator it = new StatusIterator(unit.getStatus()); it.hasNext();) {
					Object obj = it.next();
					if (obj instanceof DeployAttributeStatus) {
						DeployAttributeStatus das = (DeployAttributeStatus) obj;
						if (das.getProblemType().equals(ICoreProblemType.UNIT_NOT_HOSTED)) {
							// Yes, hosting error
							return SoaDeployUiUtil.getStatusMessage(das);
						}
					}
				}
			}

			return null;
		}

	}

	/**
	 * Get the Unit corresponding to the other end of this requirement (which may be hosting req).
	 * 
	 * It would be better to get the Capability rather than the Unit, but this requires help on
	 * matching; as a hosting link doesn't make it clear which capability it most-tightly binds to.)
	 * 
	 * @param req
	 * @return related Unit or <code>null</code>
	 */
	public static Unit getOppositeUnit(Requirement req) {
		if (req.getLink() != null) {
			Capability oppositeCap = req.getLink().getTarget();

			// link is empty/broken, don't traverse
			if (oppositeCap == null) {
				return null;
			}

			if (!(oppositeCap.getParent() instanceof Unit)) {
				return null;
			}
			return (Unit) oppositeCap.getParent();
		}

		// Dependeny links have no opposite, even if Unit is hosted
		if (req.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL) {
			return null;
		}

		Unit unit = (Unit) req.getParent();
		Unit hoster = ValidatorUtils.getImmediateHost(unit);
		return hoster;
	}

	/**
	 * @param chr
	 * @return Unit that hosts the Unit that owns/implies the CollectiveHostingRequirement.
	 */
	public static Unit getOppositeUnit(CollectiveHostingRequirement chr) {
		Unit hoster = ValidatorUtils.getImmediateHost(chr.getUnit());
		return hoster;
	}

	/**
	 * @return a Map of String to EClass for unit ETypes displays
	 */
	public static synchronized Collection<String> getUnitTypeNames() {
		return getUnitTypes().keySet();
	}

	/**
	 * @return a Map of String to EClass for the capability ETypes displays
	 */
	private static synchronized Map<String, EClass> getUnitTypes() {
		if (unitTypes == null) {
			unitTypes = createUnitTypes();
		}

		return unitTypes;
	}

	private static Map<String, EClass> createUnitTypes() {
		Map<String, EClass> retVal = createCoreUnitTypes();

		List<String> namespaces = ExtensionUtils.getSoaDeployDomainNamespaces();
		for (Iterator<String> it = namespaces.iterator(); it.hasNext();) {
			String ns = it.next();
			List<EClass> capETypes = getUnitsForNamespace(ns, false);
			for (Iterator<EClass> it2 = capETypes.iterator(); it2.hasNext();) {
				EClass ec = it2.next();
				String displayName = getDisplayEType(ec, "*"); //$NON-NLS-1$
				retVal.put(displayName, ec);
			}
		}

		return retVal;
	}

	private static Map<String, EClass> createCoreUnitTypes() {
		Map<String, EClass> retVal = new TreeMap<String, EClass>();

		EClass ecTarget = CorePackage.eINSTANCE.getUnit();
		String displayName = getDisplayEType(ecTarget, "*"); //$NON-NLS-1$
		retVal.put(displayName, ecTarget);

		for (Iterator<EClassifier> it = CorePackage.eINSTANCE.getEClassifiers().iterator(); it
				.hasNext();) {
			Object eclazz = it.next();
			if (eclazz instanceof EClass) {
				EClass ec = (EClass) eclazz;
				if (ec.getEAllSuperTypes().contains(ecTarget)) {
					displayName = getDisplayEType(ec, "*"); //$NON-NLS-1$
					retVal.put(displayName, ec);
				}
			}
		}

		return retVal;
	}

	/**
	 * Given a namespace known to EPackage.Registry; get all Capability EClasses in the package for
	 * that namespace
	 */
	private static List<EClass> getUnitsForNamespace(String ns, boolean includeAbstracts) {
		EClass ecTarget = CorePackage.eINSTANCE.getUnit();
		return getSubtypesForNamespace(ns, ecTarget, includeAbstracts);
	}

	/**
	 * @param ecName
	 *           name of a Unit
	 * @return an instanceof the Unit
	 */
	public static Unit createUnit(String ecName) {
		EClass ec = getUnitTypes().get(ecName);
		EPackage pack = (EPackage) ec.eContainer();
		EFactory factory = pack.getEFactoryInstance();
		Unit unit = (Unit) factory.create(ec);
		return unit;
	}

	/**
	 * @param u
	 * @return a name guarenteed not to collide with other children of this Unit
	 */
	public static String generateUniqueRequirementName(Unit u) {
		return UnitUtil.generateUniqueName(u, "r"); //$NON-NLS-1$
	}

	/**
	 * @param u
	 * @return a name guarenteed not to collide with other children of this Unit
	 */
	public static String generateUniqueArtifactName(Unit u) {
		return UnitUtil.generateUniqueName(u, "artifact"); //$NON-NLS-1$
	}

	/**
	 * @param cap
	 * @param name
	 * @return <code>true</code> if the Capability has the attribute, delta the additions and
	 *         subtractions for the batch operation to follow
	 */
	public static boolean hasAttribute(DeployModelObject cap, String name,
			List<ExtendedAttribute> additions, List<ExtendedAttribute> subtractions) {
		// Check schema
		for (Iterator<EAttribute> it = cap.eClass().getEAllAttributes().iterator(); it.hasNext();) {
			EStructuralFeature esf = it.next();
			if (esf.getName().equals(name)) {
				return true;
			}
		}

		//		// Check extended attributes
		//		if (cap.getExtendedAttribute(name) != null) {
		//			return true;
		//		}

		ExtendedAttribute match = cap.getExtendedAttribute(name);
		if (match != null && subtractions != null && !subtractions.contains(match)) {
			return true;
		}

		if (additions != null) {
			for (ExtendedAttribute ea : additions) {
				if (ea.getName().equals(name)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * @param dmo
	 * @return mutability for <code>dmo</code>, which may involve rules beyond dmo's attribute
	 * @deprecated use DeployModelObjectUtil.isMutable()
	 */
	public static boolean isMutable(DeployModelObject dmo) {
		return DeployModelObjectUtil.isMutable(dmo);
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if the dmo is 'editable', which means mutable AND configurable
	 */
	public static boolean isEditable(DeployModelObject dmo) {
		// 'nothingness' is not editable
		if (dmo == null) {
			return false;
		}

		if (!dmo.isPublicEditable()) {
			return false;
		}

		// Removed, we support editing attributes of public-editable Capabilities etc
		//		if (isProxy(dmo)) {
		//			if (!isConfigurableUnderContract(dmo)) {
		//				return false;
		//			}
		//			return false;
		//		}

		return DeployModelObjectUtil.isMutable(dmo);
	}

	/**
	 * @param dmo
	 * @param esf
	 * @return <code>true</code> if the esf is 'editable', which means mutable AND configurable
	 */
	public static boolean isEditable(DeployModelObject dmo, EStructuralFeature esf) {
		if (!dmo.isPublicEditable(esf.getName())) {
			return false;
		}

//		// We don't yet support overriding FileArtifact.FileURIs, etc.
//		if (isProxy(dmo) && esf.isMany()) {
//			return false;
//		}

		// Removed, we support editing attributes of public-editable Capabilities etc
		//		if (isProxy(dmo)) {
		//			if (!isConfigurableUnderContract(dmo, esf)) {
		//				return false;
		//			}
		//			return false;
		//		}

		if (esf instanceof EAttribute) {
			return DeployModelObjectUtil.isMutable(dmo, (EAttribute) esf);
		}

		// TODO need an ESF isMutable utility
		return DeployModelObjectUtil.isMutable(dmo);
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if <code>dmo</code> is not part of the edit topology
	 */
	public static boolean isProxy(DeployModelObject dmo) {
		if (dmo == null) {
			return false;
		}

		return dmo.getTopology() != dmo.getEditTopology();
	}

	/**
	 * @param ep
	 * @return the GMF EditDomain for an EditPart (or <code>null</code> for inactive parts)
	 */
	public static EditDomain getEditDomain(EditPart ep) {
		return ep.isActive() ? ep.getViewer().getEditDomain() : null;
	}

	/**
	 * Find the {@link Unit}s appropriate to display in a UI list for this Topology. Includes
	 * {@link Import}ed Units.
	 * 
	 * @param top
	 * @return List&lt;{@link Unit}&gt;
	 */
	public static List<Unit> getUnitsInTopologyForSemantic(Topology top) {
		String decoratorSemanticId = top.getDecoratorSemantic();

		List<Unit> retVal = new LinkedList<Unit>();
		for (Iterator it = top.findAllPublicUnits(); it.hasNext();) {
			Unit unit = (Unit) it.next();

			IDecoratorSemanticService dsService = ExtensionsCore.createDecoratorSemanticService();
			if (dsService.isDmoMemberOf(decoratorSemanticId, unit)) {
				retVal.add(unit);
			}
		}

		return retVal;
	}

	/**
	 * Returns an Image, suitable for use in tables, representing the Status.
	 * 
	 * @param status
	 * @return an Image
	 */
	public static Image getStatusTableImage(IStatus status) {
		if (status == null || status.getSeverity() == IStatus.OK) {
			return null;
		}

		boolean hasResolution = ErrorMarkerFigureFactory.hasResolution(status);
		if (status.getSeverity() == IStatus.ERROR) {
			return hasResolution ? DeployCoreImages.IMAGE_ERROR_TBL_QUICKFIX
					: DeployCoreImages.IMAGE_ERROR_TBL;
		} else if (status.getSeverity() == IStatus.WARNING) {
			return hasResolution ? DeployCoreImages.IMAGE_WARNING_TBL_QUICKFIX
					: DeployCoreImages.IMAGE_WARNING_TBL;
		} else if (status.getSeverity() == IStatus.INFO) {
			return DeployCoreImages.IMAGE_INFO_TBL;
		}

		// Unknown severity
		return null;
	}

	/**
	 * Get a name, suitable for displaying in the UI, representing the type
	 * 
	 * @param dmo
	 * @return internationalized String
	 */
	public static String getTypeName(DeployModelObject dmo) {
		if (dmo == null) {
			return ""; //$NON-NLS-1$
		}

		// TODO Internationalize
		return dmo.eClass().getName();
	}

	/**
	 * Can dmo be removed?
	 * 
	 * @param dmo
	 * @return <code>true</code> if dmo's parent is mutable
	 * 
	 * @see {@link DeployModelObjectUtil#isMutable(DeployModelObject)}
	 * 
	 * TODO Promote this method to DeployModelObjectUtil
	 */
	public static boolean canRemove(DeployModelObject dmo) {
		if (isProxy(dmo)) {
			return false;
		}

		if (dmo.eContainer() instanceof DeployModelObject) {
			return DeployModelObjectUtil.isMutable(dmo.getParent());
		}

		// No parent, or non-DMO parent
		return false;
	}

	/**
	 * @param dmo
	 * @param domain
	 * @return an ESF command that can remove dmo from it's parent
	 */
	public static Command getRemoveCommand(DeployModelObject dmo, EditingDomain domain) {
		Command retVal = null;

		EObject container = dmo.eContainer();
		//		System.out.println(container);
		EStructuralFeature esf = dmo.eContainingFeature();
		//		System.out.println(esf);

		// Hackery.  EMF thinks 'xyzGroup' is the containing feature but to
		// delete it needs 'xyz'....
		if (esf == CorePackage.eINSTANCE.getUnit_UnitLinksGroup()) {
			esf = CorePackage.eINSTANCE.getUnit_UnitLinks();
		} else if (esf == CorePackage.eINSTANCE.getTopology_UnitLinksGroup()) {
			esf = CorePackage.eINSTANCE.getTopology_UnitLinks();
		} else if (esf == CorePackage.eINSTANCE.getInstantiation_ConfiguredRequirementsGroup()) {
			esf = CorePackage.eINSTANCE.getInstantiation_ConfiguredRequirements();
		}

		if (esf.isMany()) {
			retVal = new RemoveCommand(domain, container, esf, dmo);
		} else {
			retVal = new SetCommand(domain, container, esf, null);
		} // endif isMany

		//		if (!retVal.canExecute()) {
		//			System.out.print("Can't execute command, attribute is "); //$NON-NLS-1$
		//			System.out.println(esf);
		//		}

		return retVal;
	}

	/**
	 * Execute a command using the given object to determine the proper undo context.
	 * 
	 * @param dmo
	 *           The model object to use to determine the {@link IUndoContext}
	 * @param command
	 *           The command to execute as an undoable operation.
	 */
	public static void executeWithUndo(EObject dmo, final ICommand command) {
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					command.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		};
		executeWithUndo(dmo, command.getLabel(), runnable);
	}

	/**
	 * Execute a command using the given object to determine the proper undo context.
	 * 
	 * @param dmo
	 *           The model object to use to determine the {@link IUndoContext}
	 * @param command
	 *           The command to execute as an undoable operation.
	 */
	public static void executeWithUndo(EObject dmo, org.eclipse.gef.commands.Command command) {
		TransactionCommandWrapper2 txcmd = TransactionCommandWrapper2.create(dmo, command, false);
		LightweightOperationFactory.execute(dmo, txcmd);
	}

	/**
	 * Execute a command using the given object to determine the proper undo context.
	 * 
	 * @param dmo
	 *           The model object to use to determine the {@link IUndoContext}
	 * @param command
	 *           The command to execute as an undoable operation.
	 */
	public static void executeWithUndo(EObject dmo, AbstractCommand command) {
		TransactionCommandWrapper2 txcmd = TransactionCommandWrapper2.create(dmo, command, false);
		LightweightOperationFactory.execute(dmo, txcmd);
	}

	/**
	 * Execute a command using the given object to determine the proper undo context.
	 * 
	 * @param dmo
	 *           The model object to use to determine the {@link IUndoContext}
	 * @param command
	 *           The command to execute as an undoable operation.
	 */
	public static void executeWithUndo(EObject dmo,
			org.eclipse.gmf.runtime.common.core.command.AbstractCommand command) {
		TransactionCommandWrapper2 txcmd = TransactionCommandWrapper2.create(dmo, command);
		LightweightOperationFactory.execute(dmo, txcmd);
	}

	/**
	 * Execute a command using the given object to determine the proper undo context.
	 * 
	 * @param dmo
	 *           The model object to use to determine the {@link IUndoContext}
	 * @param command
	 *           The command to execute as an undoable operation.
	 */
	public static void executeWithUndo(EObject dmo, AbstractTransactionalCommand command) {
		LightweightOperationFactory.execute(dmo, command);
	}

	/**
	 * Execute a command using the given object to determine the proper undo context.
	 * 
	 * @param dmo
	 *           The model object to use to determine the {@link IUndoContext}
	 * @param label
	 *           The externalized, user-readable label to announce in the UI
	 * @param runnable
	 *           The command to execute as an undoable operation.
	 */
	public static void executeWithUndo(EObject dmo, String label, Runnable runnable) {
		TransactionCommandWrapper2 txcmd = TransactionCommandWrapper2.create(dmo, label, runnable,
				false);
		LightweightOperationFactory.execute(dmo, txcmd);
	}

	/**
	 * Execute a command using the given object to determine the proper undo context.
	 * 
	 * @param dmo
	 *           The model object to use to determine the {@link IUndoContext}
	 * @param command
	 *           The command to execute as an undoable operation.
	 * @return The status returned from the command to indicate success or failure.
	 */
	public static IStatus executeWithUndo(EObject dmo, DeployOperation command) {
		TransactionCommandWrapper2 txcmd = TransactionCommandWrapper2.create(dmo, command
				.getDisplayName(), command, true);
		return LightweightOperationFactory.execute(dmo, txcmd);
	}

	/**
	 * Get a UI dialog for selecting a {@link Unit} from a Topology
	 * 
	 * @param parent
	 * @param top
	 * @param title
	 * @return an ElementListSelectionDialog whose results are {@link Unit}s
	 */
	public static ElementListSelectionDialog createUnitSelectionDialog(Shell parent, Topology top,
			String title) {
		FindUnitDialog fud = new FindUnitDialog(parent, title);
		fud.setElements(PropertyUtils.getUnitsInTopologyForSemantic(top).toArray());
		return fud;
	}

	/**
	 * Get a list of the capabilities that the user has added to the palette for re-use. The
	 * registered capabilities are cached by invocation of this API.
	 * 
	 * @return capabilities
	 */
	public static List<Capability> getBankedCapabilities() {
		List<Capability> retVal = new LinkedList<Capability>();
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		retVal.addAll(getRegisteredBankedCapabilities(rts));
		retVal.addAll(getDynamicBankedCapabilities(rts));
		return retVal;
	}

	private static List<Capability> getRegisteredBankedCapabilities(IResourceTypeService rts) {
		if (registeredBankedCapabilities == null) {
			registeredBankedCapabilities = getBankedCapabilities(rts, rts
					.getRegisteredPaletteEntries());
		}
		return registeredBankedCapabilities;
	}

	private static List<Capability> getDynamicBankedCapabilities(IResourceTypeService rts) {
		//this list can change with addition or removal of palette entries
		//need to listen to the event to cache this
		return getBankedCapabilities(rts, rts.getDynamicPaletteEntries());
	}

	private static List<Capability> getBankedCapabilities(IResourceTypeService rts,
			DynamicPaletteEntry[] ape) {
		List<Capability> retVal = new LinkedList<Capability>();
		for (int i = 0; i < ape.length; i++) {
			String id = ape[i].getId();
			//			String uri = ResourceTypeService.INSTANCE.getTemplateURI(id);
			try {
				// Safeguard against non-unit templates (such as Import)
				DeployModelObject dmo = rts.createFromTemplate(id);
				if (dmo instanceof Unit) {
					Unit model = (Unit) dmo;
					for (Iterator it = model.getCapabilities().iterator(); it.hasNext();) {
						Capability cap = (Capability) it.next();
						String newName = DeployNLS.bind(Messages.PropertyUtils_FROM, new Object[] {
								cap.getCaptionProvider().title(cap), ape[i].getLabel() });

						// Process stereotypes for display name
						if (cap.getStereotypes().size() > 0) {
							String stereotypeString = null;
							Iterator itSt = cap.getStereotypes().iterator();
							while (itSt.hasNext()) {
								Stereotype st = (Stereotype) itSt.next();
								if (stereotypeString == null) {
									stereotypeString = st.getKeyword();
								} else {
									stereotypeString += "," + st.getKeyword(); //$NON-NLS-1$
								}
							}
							newName = "<<" + stereotypeString + ">> " + newName; //$NON-NLS-1$//$NON-NLS-2$
						}

						cap.setDisplayName(newName);
					}

					retVal.addAll(model.getCapabilities());
				}
			} catch (Exception ex) {
				// TODO Log
				ex.printStackTrace();
			}
		}

		return retVal;
	}

	/**
	 * Delete a list of requirements. This method will automatically detect the associated link to be
	 * removed. This will not remove hosting links.
	 * 
	 * @param requirementsToDelete
	 *           {@link List} of {@link Requirement}s to be deleted.
	 * @param context
	 *           The {@link DeployModelObject} to be used to define the context of what is to be
	 *           deleted.
	 * @param operationMessage
	 *           A {@link String} message to present to the user with the underlying operation. This
	 *           message should be translated since it will be shown in the Undo/Redo menus.
	 */
	public static void deleteRequirements(List<Requirement> requirementsToDelete,
			DeployModelObject context, String operationMessage) {
		if (requirementsToDelete != null && !requirementsToDelete.isEmpty()) {

			IUndoableOperation op = DeleteModelObjectOperation.createDeleteModelObjectOperation(
					requirementsToDelete, operationMessage);
			if (op != null) {
				CompositeCommand compositeOp = null;
				DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
				for (int i = 0; i < requirementsToDelete.size(); i++) {
					//Delete links
					Requirement req = requirementsToDelete.get(i);
					DeployLink link = req.getLink();
					if (link != null) {
						// get all links associated with this link dmo
						List<ConnectionNodeEditPart> linkEPs = editor != null ? GMFUtils
								.getLinkEditPartsFor(editor.getDiagramGraphicalViewer(), link)
								: NO_EDIT_PARTS;
						if (linkEPs.size() > 0) {
							if (compositeOp == null) {
								compositeOp = new CompositeCommand(op.getLabel());
								compositeOp.compose(op);
							}
							// only need to create command for first link ep-- command deletes the rest
							//GroupRequest delReq = new GroupRequest(RequestConstants.REQ_DELETE);
							// link deletes always delete the model
							Request delReq = new EditCommandRequestWrapper(new DestroyElementRequest(
									editor.getEditingDomain(), false));
							org.eclipse.gef.commands.Command delCmd = ((EditPart) linkEPs.get(0))
									.getCommand(delReq);
							compositeOp.compose(new CommandProxy(delCmd));
						}

					}
				}
				if (compositeOp != null) {
					op = compositeOp;
				}
				try {
					LightweightOperationFactory.execute(context, op);
				} catch (Exception e) {
					DeployCoreUIPlugin.logError(0, "Failed to delete objects.", e); //$NON-NLS-1$
				}
			}
		}
	}

	/**
	 * Simple method to delete any {@link DeployModelObject} from its container. This will only
	 * remove the passed DMO from its parent and nothing more.
	 * 
	 * @param dmos
	 *           A {@link List} of {@link EObject}s to be deleted.
	 * @param context
	 *           The {@link DeployModelObject} to be used to define the context of what is to be
	 *           deleted.
	 * @param operationMessage
	 *           A {@link String} message to present to the user with the underlying operation. This
	 *           message should be translated since it will be shown in the Undo/Redo menus.
	 */
	public static void deleteFromModel(final List<? extends EObject> dmos,
			DeployModelObject context, String operationMessage) {
		if (dmos != null && !dmos.isEmpty()) {
			try {

				IUndoableOperation op = DeleteModelObjectOperation.createDeleteModelObjectOperation(
						dmos, operationMessage);
				if (op != null) {
					LightweightOperationFactory.execute(context, op);
				}
			} catch (Exception e) {
				DeployCoreUIPlugin.logError(0, "Failed to delete objects.", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Creates a ViewerComparator, suitable for attaching to
	 * {@link TreeViewer#setComparator(ViewerComparator)}, that sorts by {@link Unit#title()},
	 * {@link Capability#title()}, and {@link DeployModelObject#getDisplayName()}.
	 * 
	 * @return comparator
	 */
	public synchronized static ViewerComparator getDisplayNameComparator() {
		if (viewerComparator == null) {
			viewerComparator = createDisplayNameComparator();
		}

		return viewerComparator;
	}

	private static ViewerComparator createDisplayNameComparator() {
		return new ViewerComparator() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				return getDisplayTitle(e1).compareTo(getDisplayTitle(e2));
			}

			private String getDisplayTitle(Object obj) {
				if (obj instanceof Unit) {
					return ((Unit) obj).getCaptionProvider().title((Unit) obj);
				} else if (obj instanceof Capability) {
					String capTitle = ((Capability) obj).getCaptionProvider().title((Capability) obj);
					return capTitle == null ? "" : capTitle; //$NON-NLS-1$
				} else if (obj instanceof DeployModelObject) {
					return ((DeployModelObject) obj).getDisplayName();
				} else {
					return obj.toString();
				}
			}
		};
	}

	/**
	 * Get the EMF.Edit ItemPropertySource for the {@link EObject}.
	 * 
	 * @param dmo
	 * 
	 * @return an EMF.Edit descriptor with useful stuff like translated display name and description
	 */
	public static IItemPropertySource getPropertySource(EObject dmo) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(dmo);
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			AdapterFactoryEditingDomain afed = (AdapterFactoryEditingDomain) editingDomain;
			IItemPropertySource ips = (IItemPropertySource) afed.getAdapterFactory().adapt(dmo,
					IItemPropertySource.class);
			return ips;
		}

		return null;
	}

	/**
	 * @param ips
	 * @param dmo
	 * @param esf
	 * @return descriptor for esf on dmo
	 */
	public static ItemPropertyDescriptor getItemPropertyDescriptor(IItemPropertySource ips,
			EObject dmo, EStructuralFeature esf) {
		if (ips != null) {
			List<IItemPropertyDescriptor> descriptors = ips.getPropertyDescriptors(dmo);
			for (Iterator<IItemPropertyDescriptor> it = descriptors.iterator(); it.hasNext();) {
				ItemPropertyDescriptor ipd = (ItemPropertyDescriptor) it.next();
				Object feature = ipd.getFeature(dmo);
				if (feature == esf) {
					return ipd;
				}
			}
		}

		return null;
	}

	/**
	 * delete a link and it's edges --if there are no edges, the link is hidden so need to run
	 * canonical refresh
	 * 
	 * @param link
	 */
	public static void deleteLinkElementAndView(DeployLink link) {
		deleteLinkElementsAndViews(Collections.singletonList(link), null);
	}

	/**
	 * delete a link and it's edges --if there are no edges, the link is hidden so need to run
	 * canonical refresh
	 * 
	 * @param links
	 *           The links to be deleted.
	 * @param operationMessage
	 *           The message for the operation.
	 */
	public static void deleteLinkElementsAndViews(List<? extends DeployLink> links,
			String operationMessage) {

		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		// create a chained command that will delete the link and all of its views
		CompoundCommand deleteCC = new CompoundCommand(
				operationMessage == null ? DiagramUIMessages.DeleteCommand_Label : operationMessage);
		for (Iterator<? extends DeployLink> it = links.iterator(); it.hasNext();) {
			DeployLink link = it.next();
			// get all links associated with this link dmo
			List<ConnectionNodeEditPart> linkEPs = editor != null ? GMFUtils.getLinkEditPartsFor(
					editor.getDiagramGraphicalViewer(), link) : NO_EDIT_PARTS;
			if (linkEPs.size() > 0) {
				// only need to create command for first link ep-- command deletes the rest
				//GroupRequest delReq = new GroupRequest(RequestConstants.REQ_DELETE);
				// link deletes always delete the model
				Request delReq = new EditCommandRequestWrapper(new DestroyElementRequest(editor
						.getEditingDomain(), false));
				org.eclipse.gef.commands.Command delCmd = ((EditPart) linkEPs.get(0))
						.getCommand(delReq);
				deleteCC.add(delCmd);
			} else {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(link);
				Command c = PropertyUtils.getRemoveCommand(link, domain);

				TransactionCommandWrapper2 mtcw;
				// if deleting a hosting link to a config unit, repatriate the config unit to the diagram
				if (link instanceof HostingLink
						&& ((HostingLink) link).getHosted().isConfigurationUnit()) {
					List<DeployModelObject> list = new ArrayList<DeployModelObject>();
					list.add(((HostingLink) link).getHosted());
					mtcw = new TransactionCommandWrapper2(link, c, list);
				} else {
					mtcw = new TransactionCommandWrapper2(link, c, true);
				}
				deleteCC.add(new ICommandProxy(mtcw));
			}
		}

		executeWithUndo(links.get(0), deleteCC);
	}

} // end class PropertyUtils
