/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.UnitFilter.UnitFilterAction;
import com.ibm.ccl.soa.deploy.core.UnitFilter.UnitFilterTemplate;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.impl.SoftwareComponentImpl;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.NewInterfaceDialog;
import com.ibm.ccl.soa.deploy.core.ui.composites.NewServiceDialog;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ArrangeSnappedViewsCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.NubEditPopUpCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.type.UnitTypeFactory.HintedSpecializationType;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.properties.TransactionCommandWrapper2;
import com.ibm.ccl.soa.deploy.core.ui.properties.TransactionCommandWrapper4;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeploySemanticType;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.LayoutUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionUIUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.internal.core.extension.DomainManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeUIBindingDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitFilterDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

/**
 * A caching and composite service for the {@link UnitFilter}s. Given a Unit, this service will
 * combine the results from the UnitFilters returned by {@link UnitLifeCycleManager} as appropriate
 * to that Unit, caching the results if possible.
 * 
 * <p>
 * This service also includes methods to cache the icons offered by UnitFilter choices.
 * 
 * @since 1.0
 * 
 * @see UnitFilter
 * @see UnitLifeCycleManager
 */
public class DeployableUnitElementUIService {

	//	private Map<String, List<IElementType>> unitToAllowableHostingElementMap;
	//	private Map<String, List<IElementType>> unitToAllowableMemberElementMap;
	//	private Map<String, List<IElementType>> unitToAllowableNubElementMap;

	// Cache the UnitFilter results on a per-Unit basis (not per Unit.getSpecializedTypeId()),
	// as we did in M5.  TODO Change the Javadoc for that method in Unit to reflect that
	// this is no longer needed.
	private Map<Unit, List<Object>> unitToAllowableHostingElementMap;
	private Map<Unit, List<Object>> unitToAllowableMemberElementMap;
	private Map<Unit, List<Object>> unitToAllowableNubElementMap;

	private static final Map<String, Image> iconCache = new HashMap<String, Image>();

	private static final DeployableUnitElementUIService INSTANCE = new DeployableUnitElementUIService();

	/**
	 * @return The singleton instance of the UnitElementUIService.
	 */
	public static DeployableUnitElementUIService getInstance() {
		return INSTANCE;
	}

	private DeployableUnitElementUIService() {
		loadFromResourceTypeService();
	}

	/**
	 * Return an array of IUnitElementTypes that can be hosted on the input unit specified unit
	 * 
	 * @param sourceUnit
	 *           the unit to be used as the source unit
	 * @return an array of IUnitElementTypes that can be hosted
	 */
	public List getAllowableHostingUnitElements(Unit sourceUnit) {
		if (sourceUnit == null) {
			return Collections.emptyList();
		}
		String specializedTypeId = sourceUnit.getSpecializedTypeId();
		//		List<IElementType> resultList = getUnitToAllowableHostingElementMap().get(specializedTypeId);
		List<Object> resultList = getUnitToAllowableHostingElementMap().get(specializedTypeId);
		if (resultList != null) {
			return resultList;
		}

		//		resultList = new ArrayList<IElementType>();
		resultList = new ArrayList<Object>();
		boolean isVolatile = false;

		UnitFilterDescriptor[] enabledFilters = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitFiltersByInputOnly(sourceUnit);
		for (int i = 0; enabledFilters != null && i < enabledFilters.length; i++) {
			UnitFilter filter = enabledFilters[i].createUnitFilter();
			List<?> unitElementIDs = filter.getAllowableHostingUnitTypes(sourceUnit);
			//			List unitElementIDs = filter.getAllowableConfigurationUnitTypes(sourceUnit);
			if (unitElementIDs != null) {
				for (Iterator<?> it = unitElementIDs.iterator(); it.hasNext();) {
					//			for (int j = 0; unitElementIDs != null && j < unitElementIDs.size(); j++) {
					//				String unitElementID = (String) unitElementIDs.get(j);
					//				IElementType elemType = ElementTypeRegistry.getInstance().getType(unitElementID);
					Object elemType = convert(it.next());
					if (elemType != null) {
						resultList.add(elemType);
					}
				}
			}

			isVolatile |= filter.isVolatile();
		}

		// cache for next time
		if (!isVolatile) {
			getUnitToAllowableHostingElementMap().put(sourceUnit, resultList);
		}

		return resultList;
	}

	// RECURSIVE
	private Object convert(Object obj) {
		if (obj instanceof String) {
			String unitElementID = (String) obj;
			// TODO Use ResourceTypeService instead
			if (ElementTypeRegistry.getInstance().getType(unitElementID) == null) {
				DeployCoreUIPlugin.log(IStatus.WARNING, 0,
						"Element ID not known to ElementTypeRegistry : " + unitElementID, null); //$NON-NLS-1$
			}
			return ElementTypeRegistry.getInstance().getType(unitElementID);
		} else if (obj instanceof Collection) {
			Collection<?> collection = (Collection<?>) obj;
			List<Object> resultList = new ArrayList<Object>();
			for (Iterator<?> iterator = collection.iterator(); iterator.hasNext();) {
				Object o = iterator.next();
				Object o2 = convert(o);
				if (o2 != null) {
					resultList.add(o2);
				}
			}
			return resultList;
		} else if (obj instanceof UnitFilterAction) {
			return obj;
		} else if (obj instanceof UnitFilterTemplate) {
			return obj;
		}

		DeployCoreUIPlugin.log(IStatus.WARNING, 0, "Unknown UnitFilter tool type " + obj, null); //$NON-NLS-1$

		return null;
	}

	/**
	 * Return an array of IUnitElementTypes that can be hosted on the input unit specified unit
	 * 
	 * @param sourceUnit
	 *           the unit to be used as the source unit
	 * @return an array of IUnitElementTypes that can be hosted
	 */
	public List getAllowableMemberUnitElements(Unit sourceUnit) {
		if (sourceUnit == null) {
			return Collections.EMPTY_LIST;
		}

		//		String specializedTypeId = sourceUnit.getSpecializedTypeId();
		List<Object> resultList = getUnitToAllowableMemberElementMap().get(sourceUnit);
		if (resultList == null) {
			resultList = new ArrayList<Object>();
			boolean isVolatile = false;
			UnitFilterDescriptor[] enabledFilters = UnitLifeCycleManager.getInstance()
					.findEnabledTopologyUnitFiltersByInputOnly(sourceUnit);
			for (int i = 0; enabledFilters != null && i < enabledFilters.length; i++) {
				UnitFilter filter = enabledFilters[i].createUnitFilter();
				List<?> unitElementIDs = filter.getAllowableMemberUnitTypes(sourceUnit);
				if (unitElementIDs != null) {
					for (Iterator<?> it = unitElementIDs.iterator(); it.hasNext();) {
						//					String unitElementID = (String) unitElementIDs.get(j);
						//					IUnitElementType elemType = (IUnitElementType) ElementTypeRegistry.getInstance()
						//							.getType(unitElementID);
						Object elemType = convert(it.next());
						if (elemType != null) {
							resultList.add(elemType);
						}
					}
				}

				isVolatile |= filter.isVolatile();
			}

			// cache for next time
			if (!isVolatile) {
				getUnitToAllowableMemberElementMap().put(sourceUnit, resultList);
			}
		}

		return Collections.unmodifiableList(resultList);
	}

	/**
	 * Return an array of IUnitElementTypes that can be nub elements on the input unit
	 * 
	 * @param sourceUnit
	 *           the unit to be used as the source unit
	 * @return an array of IUnitElementTypes that can be hosted
	 */
	public List getAllowableNubUnitElements(Unit sourceUnit) {
		if (sourceUnit == null) {
			return Collections.EMPTY_LIST;
		}
		String specializedTypeId = sourceUnit.getSpecializedTypeId();
		List<Object> resultList = getUnitToAllowableNubElementMap().get(specializedTypeId);
		if (resultList != null) {
			return resultList;
		}

		resultList = new ArrayList<Object>();
		boolean isVolatile = false;
		UnitFilterDescriptor[] enabledFilters = UnitLifeCycleManager.getInstance()
				.findEnabledTopologyUnitFiltersByInputOnly(sourceUnit);
		for (int i = 0; enabledFilters != null && i < enabledFilters.length; i++) {
			UnitFilter filter = enabledFilters[i].createUnitFilter();
			List<?> unitElementIDs = filter.getAllowableNubDmoTypes(sourceUnit);
			if (unitElementIDs != null) {
				for (Iterator<?> it = unitElementIDs.iterator(); it.hasNext();) {
					//					String unitElementID = (String) unitElementIDs.get(j);
					//					IUnitElementType elemType = (IUnitElementType) ElementTypeRegistry.getInstance()
					//							.getType(unitElementID);
					Object elemType = convert(it.next());
					if (elemType != null) {
						resultList.add(elemType);
					}
				}

			}

			isVolatile |= filter.isVolatile();
		}
		// always add reference to components
		if (sourceUnit instanceof SoftwareComponentImpl) {
			resultList.add(DeploySemanticType.getComponentReferenceElementType());
		}

		// cache for next time
		if (!isVolatile) {
			getUnitToAllowableNubElementMap().put(sourceUnit, resultList);
		}

		return resultList;
	}

	//	private Map<String, List<IElementType>> getUnitToAllowableHostingElementMap() {
	private Map<Unit, List<Object>> getUnitToAllowableHostingElementMap() {
		if (unitToAllowableHostingElementMap == null) {
			//			unitToAllowableHostingElementMap = new HashMap<String, List<IElementType>>();
			unitToAllowableHostingElementMap = new HashMap<Unit, List<Object>>();
		}
		return unitToAllowableHostingElementMap;
	}

	private Map<Unit, List<Object>> getUnitToAllowableMemberElementMap() {
		if (unitToAllowableMemberElementMap == null) {
			unitToAllowableMemberElementMap = new HashMap<Unit, List<Object>>();
		}
		return unitToAllowableMemberElementMap;
	}

	private Map<Unit, List<Object>> getUnitToAllowableNubElementMap() {
		if (unitToAllowableNubElementMap == null) {
			unitToAllowableNubElementMap = new HashMap<Unit, List<Object>>();
		}
		return unitToAllowableNubElementMap;
	}

	//TODO fix access issues
	private void loadFromResourceTypeService() {
		// As resource types into the ElementTypeRegistry
		// M5, this is required for seamless us of Unit Filter framework
		ResourceTypeUIBindingDescriptor[] descs = DomainManager.getInstance()
				.getAllResourceTypeUIBindings();
		if (descs != null) {
			for (int i = 0; i < descs.length; i++) {
				ResourceTypeUIBindingDescriptor paletteDesc = descs[i];
				String rtId = paletteDesc.getResourceTypeId();
				IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
				ResourceTypeDescriptor rtDesc = rts.getResourceTypeDescriptor(rtId);
				if (rtDesc == null) {
					//Log error and continue.
					DeployCoreUIPlugin
							.logError(
									0,
									"ResourceTypeUIBinding refers to a resourceType that does not exist: " + rtId, null); //$NON-NLS-1$
					continue;
				}
				EClass eclass = null;
				if (rtDesc.getTemplateUri() != null) {
					eclass = CorePackage.eINSTANCE.getUnit();
				} else {
					eclass = rtDesc.getEclass();
				}

				if (eclass != null) {
					MetamodelType ietMM = new MetamodelType(rtId, paletteDesc.getSmallIconURL(),
							"resourceType", eclass, null); //$NON-NLS-1$
					ISpecializationTypeDescriptor istDescr = new ResourceElementDescriptor(ietMM,
							paletteDesc);
					HintedSpecializationType iet = new HintedSpecializationType(istDescr, rtDesc
							.getTemplateUri(), null);
					ElementTypeRegistry.getInstance().register(iet);
				}
			}
		}
	}

	/**
	 * Handles icon caching for UnitFilter.
	 * 
	 * @param imagePath
	 * @return an Image loaded from the path
	 */
	public Image getImage(String imagePath) {
		Image retVal = iconCache.get(imagePath);
		if (retVal == null) {
			ImageDescriptor id = getIconDescriptor(imagePath);
			retVal = id.createImage();
			iconCache.put(imagePath, retVal);
		}

		return retVal;
	}

	/**
	 * @deprecated We need an SOA-wide utility for this, not some private class!
	 */
	private static ImageDescriptor getIconDescriptor(String iconpath) {
		if (iconpath == null) {
			return null;
		}

		URL url;
		try {
			url = new URL(iconpath);
			url = FileLocator.resolve(url);
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		return ImageDescriptor.createFromURL(url);
	}

	/**
	 * @param host
	 * @param obj
	 *           a typeid String, a UnitFilter.UnitFilterTemplate, or a UnitFilter.UnitFilterAction
	 * @param type
	 *           {@link UnitFilter#HOSTEE}, {@link UnitFilter#MEMBER}, or {@link UnitFilter#NUB};
	 *           only used if 'obj' is a <code>UnitFilterAction</code>
	 * @param originatingEditPart
	 * @return an icon representing the creation that may happen
	 */
	public static Command getGefCommandForSelection(Unit host, Object obj, int type,
			IGraphicalEditPart originatingEditPart) {
		Shell shell = originatingEditPart.getViewer().getControl().getShell();
		if (obj instanceof IElementType) {
			IElementType eleType = (IElementType) obj;
			if (type == UnitFilter.NUB) {
				return createNubCommand(host, eleType, shell, originatingEditPart);
			} else {
				//				return getCommand(host, eleType);
				return getCommand(host, eleType, type, originatingEditPart);
			}
		} else if (obj instanceof UnitFilterAction) {
			UnitFilterAction ufa = (UnitFilterAction) obj;
			return getCommandForAction(host, ufa, originatingEditPart);
		} else if (obj instanceof UnitFilterTemplate) {
			UnitFilterTemplate uft = (UnitFilterTemplate) obj;
			return getCommand(host, uft, type, originatingEditPart);
		}

		throw new IllegalArgumentException();
	}

	/**
	 * @param unit
	 * @param uft
	 * @param type
	 *           {@link UnitFilter#HOSTEE} or {@link UnitFilter#MEMBER}
	 * @return Command
	 */
	private static Command getCommand(final Unit unit, Object unitCreator, int type,
			IGraphicalEditPart originatingEditPart) {
		if (type == UnitFilter.HOSTEE) {
			return createHosteeCommand(unit, unitCreator, originatingEditPart);
		} else if (type == UnitFilter.MEMBER) {
			return createMemberCommand(unit, unitCreator, originatingEditPart);
		}

		throw new IllegalArgumentException();
	}

	// See CreateNubCommand for another way to do this
	private static Command createNubCommand(final Unit unit, final IElementType type,
			final Shell shell, IGraphicalEditPart originatingEditPart) {

		// Don't let user create a nub if it would be illegal through the property page 
		if (!PropertyUtils.isEditable(unit)) {
			return null;
		}

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(unit);

		CompositeTransactionalCommand createCmd = new CompositeTransactionalCommand(domain,
				Messages.DeployableUnitElementUIService_Add_capabilit_);

		final DeployModelObject[] created = new DeployModelObject[1];

		AbstractTransactionalCommand atc = new AbstractTransactionalCommand(domain,
				Messages.DeployableUnitElementUIService_Add_capabilit_, null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EClass eclass = type.getEClass();
				Object objNub = eclass.getEPackage().getEFactoryInstance().create(eclass);

				created[0] = (DeployModelObject) objNub;

				if (objNub instanceof Capability) {
					Capability cap = (Capability) objNub;
					cap.setName(UnitUtil.generateUniqueName(unit, "cap")); //$NON-NLS-1$

					// NOTE: We add the capability here, even though the user may cancel later!!!
					// This is a work-around for bugs in the UI handlers; they don't work *except*
					// in a transaction!
					unit.getCapabilities().add(cap);

					// Does this kind of nub contain SOA Deploy Interfaces?
					if (cap instanceof Service) {
						Service service = (Service) cap;
						service.setDisplayName(NLS.bind(Messages.DeployableUnitElementUIService_New_0_,
								eclass.getName()));

						Interface interfaze = createAndAddAppropriateInterface(shell, service);
						if (interfaze != null) {
							AbstractUIHandler uihandler = DeployCoreUIPlugin.getDefault()
									.getInterfaceUIHandlerService().findUIHandlerForSubstitutable(interfaze);
							if (uihandler != null) {

								// now allow user to stuff values into new interface 
								try {
									if (!uihandler.editSubstitutable(shell, service, service.getInterface(),
											true)) {
										//											throw new ExecutionException("User cancelled create"); //$NON-NLS-1$
										// If user quits out of customization dialog, don't add Service to Unit.
										// UNFORTUNATELY, we had to add the Service already, so that the UI handler
										// would be able to create a transaction!!!  So we throw an exception, counting
										// on rollback to undo the 'getUnit().getCapabilities().add(cap)'... 
									}
								} catch (SAFException e) {
									DeployCoreUIPlugin.logError(0, e.getMessage(), e);
								}
							} // endif interfaze != null
						}
					}
				} else if (objNub instanceof Reference) {
					Reference ref = (Reference) objNub;

					ref.setName(UnitUtil.generateUniqueName(unit, "r")); //$NON-NLS-1$

					NewServiceDialog selection = new NewServiceDialog(shell, DeployCoreUIPlugin
							.getDefault().getInterfaceHandlerService());

					if (selection.open() == Window.OK) {
						EClass serviceType = selection.resolveSelectedServiceType();
						ref.setDmoEType(serviceType);
						ref.setDisplayName(NLS.bind(Messages.DeployableUnitElementUIService_New_0_,
								serviceType.getName()));

						unit.getRequirements().add(ref);
					} else {
						throw new ExecutionException(
								Messages.CreateNubCommand_The_creation_was_cancelled_at_the_r_);
					}
				}

				return CommandResult.newOKCommandResult();
			}
		};

		boolean isCapability = CorePackage.Literals.CAPABILITY.isSuperTypeOf(type.getEClass());

		NubEditPopUpCommand popUpCommand = new NubEditPopUpCommand(shell, unit, isCapability,
				originatingEditPart);

		popUpCommand.setInitialSelectionProvider(new ISelectionProvider() {

			public void addSelectionChangedListener(ISelectionChangedListener listener) {

			}

			public ISelection getSelection() {
				if (created[0] != null) {
					return new StructuredSelection(created[0]);
				}
				return StructuredSelection.EMPTY;
			}

			public void removeSelectionChangedListener(ISelectionChangedListener listener) {

			}

			public void setSelection(ISelection selection) {

			}
		});

		createCmd.add(atc);
		createCmd.add(popUpCommand);
		ICommandProxy command = new ICommandProxy(createCmd);
		return command;
	}

	private static Interface createAndAddAppropriateInterface(Shell shell, Service service) {
		Interface interfaze = null;
		final NewInterfaceDialog selection = new NewInterfaceDialog(shell, DeployCoreUIPlugin
				.getDefault().getInterfaceHandlerService(), service.eClass());
		if (selection.open() == Window.OK) {
			interfaze = selection.createSelectedInterface();
			if (interfaze != null) {
				service.setInterface(interfaze);
			}
		}
		return interfaze;
	}

	// See DeployCreateElementAndViewCommand for another way to do this
	private static Command createMemberCommand(final Unit unit, final Object unitCreator,
			final IGraphicalEditPart originatingEditPart) {
		ICommand ic = new TransactionCommandWrapper4(unit,
				Messages.DeployableUnitElementUIService_Create_Membe_, new Runnable() {

					public void run() {
						BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {

							public void run() {
								//						Collection<?> newUnits = insertNewUnits();
								//						Collection<?> newUnits = ResolutionUtils.doRealElementCreation(
								//								uft.getTemplateURI(), unit.getTopology());
								Collection<?> newUnits = createUnits(unitCreator, unit.getTopology());

								// we only create member links to the root units
								Collection<Unit> rootUnits = GMFUtils.getRootElements(newUnits);
								for (Iterator<Unit> it = rootUnits.iterator(); it.hasNext();) {
									Unit member = it.next();
									createMemberLink(unit, member);
								}
								showCreatedUnits(newUnits, originatingEditPart, false);
							}

						});
					} // end run()
				});

		ICommandProxy command = new ICommandProxy(ic);
		return command;
	}

	// See DeployCreateElementAndViewCommand for another way to do this
	private static Command createHosteeCommand(final Unit unit, final Object unitCreator,
			final IGraphicalEditPart originatingEditPart) {
		String msg = Messages.DeployableUnitElementUIService_Create_hosted_uni_;
		ICommand ic = TransactionCommandWrapper2.create(unit, msg, new Runnable() {

			public void run() {
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {

					public void run() {

						//						Collection<?> newUnits = insertNewUnits();
						//						Collection<?> newUnits = ResolutionUtils.doRealElementCreation(
						//								uft.getTemplateURI(), unit.getTopology());
						Collection<?> newUnits = createUnits(unitCreator, unit.getTopology());

						// we only create hosting links to the root units
						Collection<Unit> rootUnits = GMFUtils.getRootElements(newUnits);
						for (Iterator<Unit> it = rootUnits.iterator(); it.hasNext();) {
							Unit hostee = it.next();
							if (!alreadyHosted(hostee)) {
								createHostingLink(unit, hostee);
							}
						}

						// is this item an external host (if so we arrange it outside of the server)
						boolean isExternalHosted = false;
						if (rootUnits.size() == 1) {
							Object o = rootUnits.iterator().next();
							if (o instanceof Unit) {
								isExternalHosted = !((Unit) o).isConfigurationUnit();
							}
						}
						showCreatedUnits(newUnits, originatingEditPart, isExternalHosted);
					}

				});
			} // end run()
		});

		ICommandProxy command = new ICommandProxy(ic);
		return command;
	}

	protected static Collection<?> createUnits(Object unitCreator, Topology top) {
		top = top.getEditTopology();
		if (unitCreator instanceof UnitFilterTemplate) {
			UnitFilterTemplate uft = (UnitFilterTemplate) unitCreator;
			//TODO need to determine if the template is dynamic or not.
			return ResolutionUtils.doRealElementCreation(uft.getTemplateURI(), top, false);
		} else if (unitCreator instanceof IElementType) {
			IElementType eleType = (IElementType) unitCreator;
			return ResolutionUIUtils.doRealElementCreation(eleType, top);
		}

		throw new IllegalArgumentException();
	}

	private static void createHostingLink(Unit hoster, Unit hostee) {
		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
		hl.setSource(hoster);
		hl.setTarget(hostee);
		hl.setName(UnitUtil.generateUniqueName(hoster, "hl")); //$NON-NLS-1$
		hoster.getHostingLinks().add(hl);
	}

	private static void createMemberLink(Unit container, Unit member) {
		MemberLink ml = CoreFactory.eINSTANCE.createMemberLink();
		ml.setSource(container);
		ml.setTarget(member);
		ml.setName(UnitUtil.generateUniqueName(container, "ml")); //$NON-NLS-1$
		container.getMemberLinks().add(ml);
	}

	private static boolean alreadyHosted(Unit unit) {
		return ValidatorUtils.getHost(unit) != null;
	}

	/**
	 * @param unit
	 * @param ufa
	 * @return Command
	 */
	public static Command getCommandForAction(final Unit unit, final UnitFilterAction ufa,
			final IGraphicalEditPart originatingEditPart) {
		ICommand ic = new TransactionCommandWrapper4(unit, ufa.getText(), new Runnable() {

			public void run() {
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {

					public void run() {
						List<DeployModelObject> outDmosToReveal = new LinkedList<DeployModelObject>();
						ufa.run(unit, outDmosToReveal);

						showCreatedUnits(outDmosToReveal, originatingEditPart, false);
					}
				});
			} // end run()
		});

		// GEF tools must return GEF commands; ICommandProxy wraps a GMF ICommand in a GEF Command
		ICommandProxy command = new ICommandProxy(ic);
		return command;
	}

	private static void showCreatedUnits(Collection<?> newUnits,
			IGraphicalEditPart originatingEditPart, boolean isExternalHosted) {
		// At this point, the links have been created but there are no EditParts.
		// do edit policies to add views for new units
		if (originatingEditPart instanceof DeployShapeNodeEditPart) {
			DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
			DeployDiagramEditPart diagramEP = (DeployDiagramEditPart) editor.getDiagramEditPart();
			diagramEP.getViewer().getControl().setRedraw(false);
			List<DeployModelObject> unitList = new ArrayList<DeployModelObject>();
			for (Iterator it = newUnits.iterator(); it.hasNext();) {
				Object o = it.next();
				if (o instanceof Unit) {
					unitList.add((Unit) o);
				}
			}
			CanonicalUtils.refreshViews(unitList, true);

			// if this is hosted
			if (isExternalHosted) {
				Point pt = ((GraphicalEditPart) GEFUtils.getTopEditPart(originatingEditPart))
						.getFigure().getBounds().getTopLeft();
				pt.y -= DeployCoreConstants.SERVER_UNIT_HEIGHT * 2;
				LayoutUtils.layoutNewShapes(diagramEP, newUnits, pt);
			} else {
				LayoutUtils.layoutNewTreeItem(originatingEditPart, newUnits);
			}

			// make sure attached views are aligned
			if (((DeployShapeNodeEditPart) originatingEditPart).isInSnapGroup()) {
				ArrangeSnappedViewsCommand.arrangeSnappedViewsDelayed(originatingEditPart
						.getEditingDomain(), originatingEditPart.getNotationView(), null, 0,
						originatingEditPart.getViewer());
			}

			diagramEP.getViewer().getControl().setRedraw(true);
		}

		// Although the EditParts are now created, the user might not be able to
		// see them, because their were created inside collapsed containers.  So
		// show them.
		for (Iterator<?> it = newUnits.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj instanceof Unit) {
				Unit hostee = (Unit) obj;
				PropertyUtils.reveal(hostee);
			}
		}
	}

	//	private static Command getCommand(IGraphicalEditPart host, IElementType eleType) {
	//		CreateViewAndElementRequest createReq = (CreateViewAndElementRequest) CreateViewRequestFactory
	//				.getCreateShapeRequest(eleType, host.getDiagramPreferencesHint());
	//		Command cmd = host.getCommand(createReq);
	//		return cmd;
	//	}

	/**
	 * @param obj
	 *           a typeid String, a UnitFilter.UnitFilterTemplate, or a UnitFilter.UnitFilterAction
	 * @return an icon representing the creation that may happen
	 */
	public static Image getIconForSelection(Object obj) {
		if (obj instanceof IElementType) {
			return getIconForSelection((IElementType) obj);
		} else if (obj instanceof UnitFilterAction) {
			UnitFilterAction ufa = (UnitFilterAction) obj;
			return getInstance().getImage(ufa.getImagePath());
		} else if (obj instanceof UnitFilterTemplate) {
			UnitFilterTemplate uft = (UnitFilterTemplate) obj;
			return getInstance().getImage(uft.getImagePath());
		}

		return DeployCoreImages.IMAGE_ERROR_TBL;
	}

	/**
	 * @param obj
	 *           a typeid String, a UnitFilter.UnitFilterTemplate, or a UnitFilter.UnitFilterAction
	 * @return image descriptor representing the creation that may happen
	 */
	public static ImageDescriptor getIconDescriptorForSelection(Object obj) {
		// Should we cache these, the way we cache the images themselves?
		if (obj instanceof IElementType) {
			IElementType elementType = (IElementType) obj;
			return ImageDescriptor.createFromURL(elementType.getIconURL()); // get icon
		} else if (obj instanceof UnitFilterAction) {
			UnitFilterAction ufa = (UnitFilterAction) obj;
			return getIconDescriptor(ufa.getImagePath());
		} else if (obj instanceof UnitFilterTemplate) {
			UnitFilterTemplate uft = (UnitFilterTemplate) obj;
			return getIconDescriptor(uft.getImagePath());
		}

		return null;
	}

	/**
	 * @param obj
	 *           a typeid String, a UnitFilter.UnitFilterTemplate, or a UnitFilter.UnitFilterAction
	 * @return an human-readable internationalized message representing the creation
	 */
	public static String getNameForSelection(Object obj) {
		if (obj instanceof IElementType) {
			return getNameForSelection((IElementType) obj);
		} else if (obj instanceof UnitFilterAction) {
			return ((UnitFilterAction) obj).getText();
		} else if (obj instanceof UnitFilterTemplate) {
			return ((UnitFilterTemplate) obj).getText();
		}

		return obj.toString();
	}

	private static Image getIconForSelection(IElementType eleType) {
		return IconService.getInstance().getIcon(eleType);
	}

	private static String getNameForSelection(IElementType eleType) {
		return eleType.getDisplayName();
	}

} // end class DeployableUnitElementUIService
