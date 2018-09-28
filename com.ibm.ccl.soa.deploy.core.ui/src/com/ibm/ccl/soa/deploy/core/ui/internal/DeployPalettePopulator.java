/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.IActivity;
import org.eclipse.ui.activities.IActivityManager;
import org.eclipse.ui.activities.IActivityPatternBinding;
import org.eclipse.ui.activities.IActivityRequirementBinding;
import org.eclipse.ui.activities.IWorkbenchActivitySupport;

import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.internal.core.extension.PaletteExtensionListener;
import com.ibm.ccl.soa.deploy.internal.core.ui.providers.DeployDynamicPaletteFactory;
import com.ibm.xtools.common.ui.reduction.viewpoints.IViewpointManager;
import com.ibm.xtools.common.ui.reduction.viewpoints.Viewpoint;

/**
 * This class is used to populate the palette for the {@link DeployCoreEditor}. It is responsible
 * for ensuring that the proper filtering is applied based on the active Viewpoint and to add
 * dynamic templates that are defined within the workspace.
 * 
 */
public class DeployPalettePopulator implements PaletteExtensionListener {

	//Viewpoint IDs
	private static final String PHYSICAL_VIEWPOINT_ID = "com.ibm.ccl.soa.deploy.core.ui.viewpoint.physical"; //$NON-NLS-1$

	//Activity IDs
	private static final String CORE_ACTIVITY_ID = "com.ibm.ccl.soa.deploy.core.ui.activity.core"; //$NON-NLS-1$
	private static final String GENERIC_ACTIVITY_ID = "com.ibm.ccl.soa.deploy.core.ui.activity.generic"; //$NON-NLS-1$	

	//Palette Drawer IDs
	final static String GEODRAWER = "geoshapeDrawer"; //$NON-NLS-1$
	final static String STANDARD_GROUP = "standardGroup"; //$NON-NLS-1$
	final static String COMMON_TOOLS_DRAWER = "commontoolDrawer";//$NON-NLS-1$
	private static final String EXTENSION_DRAWER_ID = "extensionDrawer"; //$NON-NLS-1$

	private final DefaultEditDomain editDomain;
	private String decoratorSemantic;
	private final IViewpointManager viewpointManager;

	private PaletteFactory paletteFactory;

	private IActivity coreActivity;
	private IActivity genericActivity;

	/**
	 * 
	 * @param anEditDomain
	 * @param aViewpointMgr
	 */
	public DeployPalettePopulator(DefaultEditDomain anEditDomain, IViewpointManager aViewpointMgr) {
		editDomain = anEditDomain;
		viewpointManager = aViewpointMgr;
		ExtensionsCore.createResourceTypeService().addPaletteChangeListener(this);
	}

	/**
	 * Dispose all resources when no longer needed.
	 */
	public void dispose() {
		ExtensionsCore.createResourceTypeService().removePaletteChangeListener(this);
		coreActivity = null;
		genericActivity = null;
	}

	/**
	 * Set the value of the decorator semantic based on the current topology.
	 * 
	 * @param aDecoratorSemantic
	 */
	public void setDecoratorSemantic(String aDecoratorSemantic) {
		decoratorSemantic = aDecoratorSemantic;
	}

	/**
	 * This method should be called by clients to populate palette entries using the
	 * {@link IResourceTypeService}.
	 * 
	 * @param root
	 */
	public void populatePalette(PaletteRoot root) {
		extendPaletteUsingResourceTypeService(root);
		// Filter out content based on decorator semantic and viewpoints.
		filterPaletteEntries(root, decoratorSemantic, true);
	}

	public void paletteRegistryChanged() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				PaletteRoot root = editDomain.getPaletteViewer().getPaletteRoot();
				extendPaletteUsingResourceTypeService(root);
				// Filter out content based on decorator semantic and viewpoints.
				//This path is called when dynamicTypes are changed.
				filterPaletteEntries(root, decoratorSemantic, true);
			}
		});
	}

	private void createExtensionStack(PaletteRoot root, DynamicPaletteEntry entry) {
		PaletteContainer parent = lookup(root, entry.getPath());
		if (parent != null) {
			if (!paletteEntryExists(parent, entry.getId())) {
				ImageDescriptor idSmall = getIconDescriptor(entry.getSmallIcon());
				PaletteStack ps = new PaletteStack(entry.getLabel(), entry.getDescription(), idSmall);
				ps.setId(entry.getId());
				parent.add(ps);
			}
		} else {
			if (Platform.inDebugMode()) {
				DeployCoreUIPlugin.log(IStatus.WARNING, 0, "Could not find palette path " //$NON-NLS-1$
						+ entry.getPath(), null);
			}
		}
	}

	private void removeDynamicPaletteExtensions(PaletteRoot root) {
		PaletteContainer pcExtensions = lookup(root, EXTENSION_DRAWER_ID);

		if (pcExtensions != null) {
			pcExtensions.setChildren(new ArrayList<Object>());
		}
	}

	@SuppressWarnings("restriction")
	private boolean paletteEntryExists(PaletteContainer parent, String entry) {
		List<?> childrenList = parent.getChildren();
		for (int i = 0; i < childrenList.size(); i++) {
			Object child = childrenList.get(i);
			if (child instanceof PaletteToolEntry) {
				if (((PaletteToolEntry) child).getId().equals(entry)) {
					return true;
				}
			} else if (child instanceof PaletteContainer) {
				//TODO: CMH - Change this to the correct API when resource type service implements stacks
				if (((PaletteContainer) child).getId().equals(entry)) {
					return true;
				}
			}

		}
		return false;
	}

	private PaletteFactory getPaletteFactory() {
		if (paletteFactory == null) {
			paletteFactory = new DeployDynamicPaletteFactory();
		}

		return paletteFactory;
	}

	@SuppressWarnings("restriction")
	private void extendPalette(PaletteRoot root, DynamicPaletteEntry entry,
			Viewpoint physicalViewpoint) {
		//		System.out.println("Adding " + entry + " to palette"); //$NON-NLS-1$ //$NON-NLS-2$

		ImageDescriptor idSmall = getIconDescriptor(entry.getSmallIcon());
		ImageDescriptor idLarge = getIconDescriptor(entry.getLargeIcon());
		// new PaletteEntry(entry.getLabel(), entry.getDescription(), idSmall, idLarge, entry.getId());
		if (root == null || entry == null || entry.getPath() == null) {
			return;
		}
		PaletteContainer parent = lookup(root, entry.getPath());

		if (parent != null) {
			PaletteToolEntry gef = new PaletteToolEntry(entry.getId(), computePaletteLabel(entry,
					physicalViewpoint), getPaletteFactory());

			gef.setSmallIcon(idSmall);
			gef.setLargeIcon(idLarge);

			gef.setDescription(entry.getDescription());

			try {
				//parent.setVisible(true);
				if (!paletteEntryExists(parent, entry.getId())) {
					parent.add(gef);
				} /*
					 * else { PaletteContainer child = findChildContainer(parent, entry.getId()); if
					 * (child != null) { child.setVisible(true); } }
					 */
			} catch (IllegalArgumentException iae) {
				DeployCoreUIPlugin.logError(0, iae.getMessage(), iae);
			}
		} else {
			if (Platform.inDebugMode()) {
				DeployCoreUIPlugin.log(IStatus.WARNING, 0,
						"Could not find palette path " + entry.getPath(), null); //$NON-NLS-1$
			}
		}
	}

	@SuppressWarnings("unchecked")
	private String computePaletteLabel(DynamicPaletteEntry entry, Viewpoint physicalViewpoint) {
		String baseLabel = entry.getLabel();
		String entryId = entry.getId();
		if (physicalViewpoint != null && !isCommonTool(entryId)) {
			if (isPatternBound(entryId, physicalViewpoint)) {
				//It is conceptual so add a conceptual label.
				return baseLabel + " (P)"; //$NON-NLS-1$
			}
		}
		return baseLabel;
	}

	/*
	 * Return true if the entryId belonds to the core or generic activity.
	 */
	private boolean isCommonTool(String entryId) {
		return isPatternBound(entryId, getCoreActivity())
				|| isPatternBound(entryId, getGenericActivity());
	}

	private void extendPaletteUsingResourceTypeService(PaletteRoot root) {
		removeDynamicPaletteExtensions(root);

		// GMF might have gotten rid of the drawer when it noticed it had no children.
		// Recreate it.
		PaletteContainer pcExtensions = lookup(root, EXTENSION_DRAWER_ID);
		if (pcExtensions == null) {
			// TODO rather than building localized one here, read from extension point?
			PaletteDrawer pd = new PaletteDrawer(Messages.DeployCoreEditor_Local_Extension_);
			pd.setId(EXTENSION_DRAWER_ID);
			root.add(pd);
		}

		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();

		DynamicPaletteEntry[] stacks = rts.getDynamicStackEntries();
		for (int i = 0; i < stacks.length; i++) {
			createExtensionStack(root, stacks[i]);
		}

		DynamicPaletteEntry[] entries = rts.getAllPaletteEntries();
		Viewpoint physicalViewpoint = getPhysicalViewpoint();
		for (int i = 0; i < entries.length; i++) {
			extendPalette(root, entries[i], physicalViewpoint);
		}

		//Move to the bottom.
		moveDrawer(root, GEODRAWER, -1, false);
		//Move to just under the common tools drawer
		moveDrawer(root, EXTENSION_DRAWER_ID, 2, true);
	}

	private void moveDrawer(PaletteRoot root, String drawerId, int index, boolean doExpand) {
		PaletteContainer drawer = lookup(root, drawerId);
		if (drawer != null) {
			root.remove(drawer);
			if (doExpand) {
				((PaletteDrawer) drawer).setInitialState(PaletteDrawer.INITIAL_STATE_OPEN);
			}
			root.add(index, drawer);
		}
	}

	private Viewpoint getPhysicalViewpoint() {
		return IViewpointManager.INSTANCE.getViewpoint(PHYSICAL_VIEWPOINT_ID);
	}

	private ImageDescriptor getIconDescriptor(String iconpath) {
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

	private boolean isPatternBound(String id, Set<String> activityIDs,
			IActivityManager activityManager, boolean testRequired) {
		for (Iterator<String> iterator = activityIDs.iterator(); iterator.hasNext();) {
			IActivity activity = activityManager.getActivity(iterator.next());
			if (isPatternBound(id, activity, activityManager, testRequired)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private boolean isPatternBound(String id, IActivity activity) {
		IWorkbenchActivitySupport activitySupport = PlatformUI.getWorkbench().getActivitySupport();
		IActivityManager activityManager = activitySupport.getActivityManager();
		return isPatternBound(id, activity, activityManager, true);
	}

	@SuppressWarnings("unchecked")
	private boolean isPatternBound(String id, IActivity activity, IActivityManager activityManager,
			boolean testRequired) {
		Set<IActivityPatternBinding> bindingSet = activity.getActivityPatternBindings();
		for (Iterator<IActivityPatternBinding> it = bindingSet.iterator(); it.hasNext();) {
			IActivityPatternBinding patternBinding = it.next();
			Matcher matcher = patternBinding.getPattern().matcher(id);
			if (matcher.find()) {
				return true;
			}
		}
		if (testRequired) {
			Set<IActivityRequirementBinding> requiredBindings = activity
					.getActivityRequirementBindings();
			Set<String> requiredActivityIds = new HashSet<String>(requiredBindings.size());
			if (requiredBindings != null && !requiredBindings.isEmpty()) {
				for (IActivityRequirementBinding activityRequirementBinding : requiredBindings) {
					requiredActivityIds.add(activityRequirementBinding.getRequiredActivityId());
				}
			}
			return isPatternBound(id, requiredActivityIds, activityManager, true);
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private boolean isPatternBound(String id, Viewpoint viewpoint) {
		Set<String> activityIDs = viewpoint.getEnabledActivityIds();
		IWorkbenchActivitySupport activitySupport = PlatformUI.getWorkbench().getActivitySupport();
		IActivityManager activityMgr = activitySupport.getActivityManager();
		for (Iterator<String> it = activityIDs.iterator(); it.hasNext();) {
			IActivity activity = activityMgr.getActivity(it.next());
			if (activity != null && isPatternBound(id, activity)) {
				return true;
			}
		}
		return false;
	}

	private void filterPaletteEntries(PaletteContainer paletteContainer, String semantic,
			Boolean filterViewpoint) {
		Viewpoint viewpoint = viewpointManager.getEnabledViewpoint();

		IWorkbenchActivitySupport activitySupport = PlatformUI.getWorkbench().getActivitySupport();
		IActivityManager activityManager = activitySupport.getActivityManager();
		try {
			Iterator<?> iter = paletteContainer.getChildren().iterator();
			List<PaletteEntry> toRemove = new ArrayList<PaletteEntry>();
			while (iter.hasNext()) {
				PaletteEntry entry = (PaletteEntry) iter.next();
				Object type = entry.getType();
				String entryId = entry.getId();
				if (entry instanceof PaletteContainer) {
					// Do not remove the standard group or geoshapeDrawer
					if (!entryId.equals(STANDARD_GROUP) && !entryId.equals(GEODRAWER)) {
						PaletteContainer container = (PaletteContainer) entry;
						filterPaletteEntries(container, semantic, filterViewpoint);
						if (container.getChildren().size() == 0) {
							toRemove.add(container);
						}
					}
				} else if (type.equals(ToolEntry.PALETTE_TYPE_TOOL)) {
					IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
					if (!rts.isDynamicPaletteEntry(entry.getId())) {
						if (!entryId.equals(GEODRAWER)) {
							if (!getDsService().isPaletteEntryMemberOf(semantic, entryId)) {
								toRemove.add(entry);
							} else {
								if (!shouldFilter(viewpoint)) {
									return;
								}
								if (filterViewpoint) {
									filterPaletteEntriesByViewPoint(viewpoint, activityManager, toRemove,
											entry);
								}
							}
						}
					}
				}
			}
			Iterator<PaletteEntry> remove = toRemove.iterator();
			while (remove.hasNext()) {
				PaletteEntry removeEntry = remove.next();
				paletteContainer.remove(removeEntry);
			}
		} catch (RuntimeException e) {
			String msg = e.getMessage() != null ? e.getMessage() : e.toString();
			DeployCoreUIPlugin.logError(0, msg, e);
		}

	}

	private void filterPaletteEntriesByViewPoint(Viewpoint viewpoint,
			IActivityManager activityManager, List<PaletteEntry> toRemove, PaletteEntry entry) {
		if (!isPatternBound(entry.getId(), viewpoint.getEnabledActivityIds(), activityManager, true)) {
			toRemove.add(entry);
		}
	}

	private boolean shouldFilter(Viewpoint viewpoint) {
		return viewpoint != Viewpoint.MODEL;

	}

	protected IDecoratorSemanticService getDsService() {
		//A singleton.
		return ExtensionsCore.createDecoratorSemanticService();
	}

	/** Given a PaletteContainer, return the Container represented by 'path' */
	private PaletteContainer lookup(PaletteContainer entry, String path) {
		if (path == null) {
			//Invalid state.
			return null;
		}
		for (StringTokenizer tokens = new StringTokenizer(path, "/"); tokens.hasMoreTokens() && entry != null;) { //$NON-NLS-1$
			String token = tokens.nextToken();
			PaletteContainer child = findChildContainer(entry, token);
			entry = child;
		}
		return entry;
	}

	/** Given a PaletteContainer, return the direct child named 'token' */
	private PaletteContainer findChildContainer(PaletteContainer entry, String token) {
		for (Iterator<?> it = entry.getChildren().iterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj instanceof PaletteContainer) {
				PaletteContainer pc = (PaletteContainer) obj;
				if (pc.getId().equals(token)) {
					return pc;
				}
			}
		}

		return null;
	}

	private IActivity getCoreActivity() {
		if (coreActivity == null) {
			coreActivity = getActivity(CORE_ACTIVITY_ID);
		}
		return coreActivity;
	}

	private IActivity getGenericActivity() {
		if (genericActivity == null) {
			genericActivity = getActivity(GENERIC_ACTIVITY_ID);
		}
		return genericActivity;
	}

	private IActivity getActivity(String id) {
		IWorkbenchActivitySupport activitySupport = PlatformUI.getWorkbench().getActivitySupport();
		return activitySupport.getActivityManager().getActivity(id);
	}

}
