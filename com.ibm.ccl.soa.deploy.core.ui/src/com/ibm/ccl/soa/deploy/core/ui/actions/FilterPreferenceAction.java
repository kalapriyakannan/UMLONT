/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * The Diagram Prefs Actions
 * 
 * @author jswanke
 */
public class FilterPreferenceAction extends DiagramAction implements IPropertyChangeListener {

	private final String _preference;
	private final boolean _isSelectedOnly;
	private static final Map<String, String> PREFMAP = new HashMap<String, String>();
	static {
		PREFMAP.put(IDeployPreferences.DEPLOY_FILTER_SECONDARY_DUP_LINKS, "DupLinks");//$NON-NLS-1$
		PREFMAP.put(IDeployPreferences.DEPLOY_FILTER_DUP_VIEW_INDICATORS, "DupCounters");//$NON-NLS-1$
		PREFMAP.put(IDeployPreferences.DEPLOY_FILTER_ATTRIBUTES, "Attributes");//$NON-NLS-1$
		PREFMAP.put(IDeployPreferences.DEPLOY_FILTER_NUBS, "Nubs");//$NON-NLS-1$
		PREFMAP.put(IDeployPreferences.DEPLOY_FILTER_CONTRACTS, "Contracts"); //$NON-NLS-1$
		PREFMAP.put(IDeployPreferences.DEPLOY_FILTER_TYPE_NAMES, "TypeNames");//$NON-NLS-1$
		PREFMAP.put(IDeployPreferences.DEPLOY_HIDE_ERROR_MARKERS, "Errors"); //$NON-NLS-1$
		PREFMAP.put(IDeployPreferences.DEPLOY_HIDE_WARNING_MARKERS, "Warnings");//$NON-NLS-1$
		PREFMAP.put(IDeployPreferences.DEPLOY_HIDE_INFO_MARKERS, "Info");//$NON-NLS-1$
	}
	private static final List<String> ALLLIST = new ArrayList<String>();
	static {
		ALLLIST.add("Nubs"); //$NON-NLS-1$
		ALLLIST.add("Contracts");//$NON-NLS-1$
		ALLLIST.add("TypeNames");//$NON-NLS-1$
		ALLLIST.add("Attributes");//$NON-NLS-1$
	}

	static final private int UNKNOWN = 0;
	static final private int CHECKED = 1;
	static final private int UNCHECKED = 2;

	/**
	 * @param workbenchPage
	 */
	protected FilterPreferenceAction(IWorkbenchPage workbenchPage, String preference,
			boolean isSelectedOnly) {
		super(workbenchPage);
		_preference = preference;
		_isSelectedOnly = isSelectedOnly;
		setChecked(isChecked());
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	@Override
	public boolean isChecked() {
		// first we try the current selection
		if (_isSelectedOnly) {
			List<GraphicalEditPart> selected = getFilteredSelectedObjects();
			if (selected.size() > 0) {
				View view = selected.get(0).getNotationView();
				DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
						.getDeployStyle());
				if (style != null) {
					if (getId().equals(DeployActionIds.ACTION_ALL_DETAIL_STATUSES)) {
						int lastMode = -1;
						for (String pref : ALLLIST) {
							int checkMode = getCheckMode(style, pref);
							if (lastMode == -1) {
								lastMode = checkMode;
							} else if (checkMode != lastMode) {
								lastMode = -1;
								break;
							}
						}
						return lastMode == CHECKED;
					} else {
						int checkMode = getCheckMode(style, PREFMAP.get(_preference));
						if (checkMode != UNKNOWN) {
							return checkMode == CHECKED;
						}
					}
				}
			}
		}

		// then we try the diagram
		DiagramEditPart dep = getDiagramEditPart();
		if (dep != null) {
			Diagram diagram = dep.getDiagramView();
			DeployStyle style = (DeployStyle) diagram.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null) {
				int checkMode = getCheckMode(style, PREFMAP.get(_preference));
				if (checkMode != UNKNOWN) {
					return checkMode == CHECKED;
				}
			}
		}

		// then we try preferences
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		return store != null && store.getBoolean(_preference);
	}

	private int getCheckMode(DeployStyle style, String string) {
		if (style.getFilteredDecorations().contains(string + "f")) { //$NON-NLS-1$
			return CHECKED;
		}
		if (style.getFilteredDecorations().contains(string + "u")) { //$NON-NLS-1$
			return UNCHECKED;
		}
		return UNKNOWN;
	}

	@Override
	public void dispose() {
		super.dispose();
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(_preference)) {
			setChecked(isChecked());
		}
	}

	protected boolean calculateEnabled() {
		return !_isSelectedOnly || getFilteredSelectedObjects().size() > 0;
	}

	protected boolean isSelectionListener() {
		return false;
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	protected void doRun(IProgressMonitor progressMonitor) {

		// first we try the current selection
		boolean isHide = !isChecked();
		if (_isSelectedOnly) {
			List<GraphicalEditPart> partList = getFilteredSelectedObjects();
			if (partList.size() > 0) {
				if (getId().equals(DeployActionIds.ACTION_ALL_DETAIL_STATUSES)) {
					if (changeStyle(ALLLIST, partList, isHide, progressMonitor)) {
						refreshDecorations(partList);
						return;
					}
				} else {
					List<String> prefList = new ArrayList<String>();
					prefList.add(PREFMAP.get(_preference));
					if (changeStyle(prefList, partList, isHide, progressMonitor)) {
						refreshDecorations(partList);
						return;
					}
				}
			}
		}

		// then we try the diagram
		Diagram diagram = getDiagramEditPart().getDiagramView();
		DeployStyle style = (DeployStyle) diagram.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null) {
			List<GraphicalEditPart> partList = new ArrayList<GraphicalEditPart>();
			partList.add(getDiagramEditPart());
			List<String> prefList = new ArrayList<String>();
			prefList.add(PREFMAP.get(_preference));
			changeStyle(prefList, partList, isHide, progressMonitor);
			refreshDecorations(getDiagramEditPart().getChildren());
			return;
		}

		// then we try preferences-- should never get here unless older diagram w/o a DeployStyle)
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		if (store != null) {
			store.setValue(_preference, isHide);
		}
	}

	private boolean changeStyle(final List<String> prefList, final List<GraphicalEditPart> partList,
			final boolean isHide, IProgressMonitor monitor) {
		final boolean[] bRet = new boolean[] { false };
		execute(new ICommandProxy(new AbstractTransactionalCommand(
				partList.get(0).getEditingDomain(), getCommandLabel(), null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
					IAdaptable info) {

				for (String pref : prefList) {
					boolean isDiagramHide = false;
					if (_isSelectedOnly) {
						// then try diagram
						DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(partList.get(0));
						DeployStyle style = (DeployStyle) ddep.getDiagramView().getStyle(
								DeployNotationPackage.eINSTANCE.getDeployStyle());
						if (style.getFilteredDecorations().contains(pref + 'f')) {
							isDiagramHide = true;
						}
					}

					for (GraphicalEditPart part : partList) {
						View view = part.getNotationView();
						DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
								.getDeployStyle());
						if (style != null) {
							bRet[0] = true;
							// if changes to individual views, we always add something to string array to override the diagram's setting
							// add "u" for unfiltered and "f" for filtered
							if (_isSelectedOnly) {
								style.getFilteredDecorations().remove(pref + (isHide ? 'u' : 'f'));
								// if this view's state will be the same as the diagram, no need to save anything
								if (isHide != isDiagramHide) {
									style.getFilteredDecorations().add(pref + (isHide ? 'f' : 'u'));
								}
							} else {
								style.getFilteredDecorations().remove(pref + (isHide ? 'u' : 'f'));
								style.getFilteredDecorations().add(pref + (isHide ? 'f' : 'u'));
							}
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		}), monitor);
		return bRet[0];
	}

	private void refreshDecorations(List<?> list) {
		for (Iterator<?> it = list.iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) o;
				ep.refresh();
				DecorationEditPolicy policy = (DecorationEditPolicy) ep
						.getEditPolicy(EditPolicyRoles.DECORATION_ROLE);
				if (policy != null) {
					policy.refresh();
				}
				for (Iterator<?> it2 = ep.getSourceConnections().iterator(); it2.hasNext();) {
					ConnectionEditPart cep = (ConnectionEditPart) it2.next();
					if (cep instanceof DeployConnectionNodeEditPart) {
						DeployConnectionNodeEditPart dcep = (DeployConnectionNodeEditPart) cep;
						policy = (DecorationEditPolicy) dcep
								.getEditPolicy(EditPolicyRoles.DECORATION_ROLE);
						if (policy != null) {
							policy.refresh();
						}
					}
				}
			}
			if (o instanceof EditPart) {
				refreshDecorations(((EditPart) o).getChildren());
			}
		}
	}

	private List<GraphicalEditPart> getFilteredSelectedObjects() {
		List<?> rawList = getSelectedObjects();
		List<GraphicalEditPart> filteredList = new ArrayList<GraphicalEditPart>();
		for (Iterator<?> it = rawList.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj instanceof DeployShapeNodeEditPart) {
				filteredList.add((DeployShapeNodeEditPart) obj);
			}
		}
		return filteredList;
	}

	/**
	 * toggle duplicate links
	 * 
	 * @param workbenchPage
	 * @return DiagramPreferenceAction
	 */
	public static FilterPreferenceAction createDuplicateLinksAction(IWorkbenchPage workbenchPage) {
		return createAction(workbenchPage, IDeployPreferences.DEPLOY_FILTER_SECONDARY_DUP_LINKS,
				DeployActionIds.ACTION_DUPLICATE_LINKS,
				Messages.DiagramPreferenceAction_Duplicate_Link_, false);
	}

	/**
	 * toggle duplicate counters
	 * 
	 * @param workbenchPage
	 * @return DiagramPreferenceAction
	 */
	public static FilterPreferenceAction createDuplicateCounterAction(IWorkbenchPage workbenchPage) {
		return createAction(workbenchPage, IDeployPreferences.DEPLOY_FILTER_DUP_VIEW_INDICATORS,
				DeployActionIds.ACTION_DUPLICATE_COUNTERS,
				Messages.DiagramPreferenceAction_Duplicate_Counter, false);
	}

	/**
	 * toggle error statuses
	 * 
	 * @param workbenchPage
	 * @param isSelectedOnly
	 * @return DiagramPreferenceAction
	 */
	public static FilterPreferenceAction createContractAction(IWorkbenchPage workbenchPage,
			boolean isSelectedOnly) {
		return createAction(workbenchPage, IDeployPreferences.DEPLOY_FILTER_CONTRACTS,
				DeployActionIds.ACTION_CONTRACTS, Messages.DeployCoreMainPreferencePage_0,
				isSelectedOnly);
	}

	/**
	 * toggle error statuses
	 * 
	 * @param workbenchPage
	 * @param isSelectedOnly
	 * @return DiagramPreferenceAction
	 */
	public static FilterPreferenceAction createNubsAction(IWorkbenchPage workbenchPage,
			boolean isSelectedOnly) {
		return createAction(workbenchPage, IDeployPreferences.DEPLOY_FILTER_NUBS,
				DeployActionIds.ACTION_NUBS, Messages.DeployCoreMainPreferencePage_3, isSelectedOnly);
	}

	/**
	 * toggle error statuses
	 * 
	 * @param workbenchPage
	 * @param isSelectedOnly
	 * @return DiagramPreferenceAction
	 */
	public static FilterPreferenceAction createAttributesAction(IWorkbenchPage workbenchPage,
			boolean isSelectedOnly) {
		return createAction(workbenchPage, IDeployPreferences.DEPLOY_FILTER_ATTRIBUTES,
				DeployActionIds.ACTION_ATTRIBUTES, Messages.DeployCoreMainPreferencePage_2,
				isSelectedOnly);
	}

	/**
	 * toggle error statuses
	 * 
	 * @param workbenchPage
	 * @param isSelectedOnly
	 * @return DiagramPreferenceAction
	 */
	public static FilterPreferenceAction createTypeNamesAction(IWorkbenchPage workbenchPage,
			boolean isSelectedOnly) {
		return createAction(workbenchPage, IDeployPreferences.DEPLOY_FILTER_TYPE_NAMES,
				DeployActionIds.ACTION_TYPE_NAMES, Messages.DeployCoreMainPreferencePage_1,
				isSelectedOnly);
	}

	/**
	 * toggle error statuses
	 * 
	 * @param workbenchPage
	 * @param isSelectedOnly
	 * @return DiagramPreferenceAction
	 */
	public static FilterPreferenceAction createErrorStatusesAction(IWorkbenchPage workbenchPage) {
		return createAction(workbenchPage, IDeployPreferences.DEPLOY_HIDE_ERROR_MARKERS,
				DeployActionIds.ACTION_ERROR_STATUSES, Messages.FilterPreferenceAction_Error_Statuse_,
				false);
	}

	/**
	 * toggle warning statuses
	 * 
	 * @param workbenchPage
	 * @param isSelectedOnly
	 * @return DiagramPreferenceAction
	 */
	public static FilterPreferenceAction createWarningStatusesAction(IWorkbenchPage workbenchPage) {
		return createAction(workbenchPage, IDeployPreferences.DEPLOY_HIDE_WARNING_MARKERS,
				DeployActionIds.ACTION_WARNING_STATUSES,
				Messages.FilterPreferenceAction_Warning_Statuse_, false);
	}

	/**
	 * toggle info statuses
	 * 
	 * @param workbenchPage
	 * @param isSelectedOnly
	 * @return DiagramPreferenceAction
	 */
	public static FilterPreferenceAction createInfoStatusesAction(IWorkbenchPage workbenchPage) {
		return createAction(workbenchPage, IDeployPreferences.DEPLOY_HIDE_INFO_MARKERS,
				DeployActionIds.ACTION_INFO_STATUSES,
				Messages.FilterPreferenceAction_Informational_Statuse_, false);
	}

	/**
	 * @param workbenchPage
	 * @return
	 */
	public static IAction createAllDetailsAction(IWorkbenchPage workbenchPage) {
		return createAction(workbenchPage, "", DeployActionIds.ACTION_ALL_DETAIL_STATUSES, //$NON-NLS-1$
				Messages.FilterPreferenceAction_1, true);
	}

	private static FilterPreferenceAction createAction(IWorkbenchPage workbenchPage, String pref,
			String actionID, String message, boolean isSelectedOnly) {
		FilterPreferenceAction action = new FilterPreferenceAction(workbenchPage, pref,
				isSelectedOnly);
		action.setId(actionID);
		action.setText(message);
		action.setToolTipText(message);
		ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
		action.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DIAGRAM_PREFERENCES));
		action.setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DIAGRAM_PREFERENCES));
		action.setHoverImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DIAGRAM_PREFERENCES));
		action.init();
		return action;
	}

	/**
	 * @param prefID
	 * @param ep
	 * @return is this preference filtered from this figure
	 */
	static public boolean isFiltered(String prefID, IGraphicalEditPart ep) {
		// first try style on this editpart
		DeployStyle style = (DeployStyle) ep.getNotationView().getStyle(
				DeployNotationPackage.eINSTANCE.getDeployStyle());
		if (style != null) {
			if (style.getFilteredDecorations().contains(PREFMAP.get(prefID) + 'f')) {
				return true;
			}
			if (style.getFilteredDecorations().contains(PREFMAP.get(prefID) + 'u')) {
				return false;
			}
		}

		// then try diagram
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(ep);
		if (ddep != null) {
			style = (DeployStyle) ddep.getDiagramView().getStyle(
					DeployNotationPackage.eINSTANCE.getDeployStyle());
			if (style != null) {
				if (style.getFilteredDecorations().contains(PREFMAP.get(prefID) + 'f')) {
					return true;
				}
				if (style.getFilteredDecorations().contains(PREFMAP.get(prefID) + 'u')) {
					return false;
				}
			}
		}

		// then try preferences
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		return store != null && store.getBoolean(prefID);
	}

}
