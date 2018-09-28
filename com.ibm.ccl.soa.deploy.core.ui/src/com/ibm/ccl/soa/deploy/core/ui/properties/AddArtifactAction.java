package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.core.resources.IContainer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.ui.extension.IUIHandlerService;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

/**
 * An action to create an artifact.
 * 
 */
public class AddArtifactAction extends Action implements IAction {

	/**
	 * The default actionId for adding an artifact
	 */
	public static final String ACTION_ID = DeployCoreUIPlugin.PLUGIN_ID + IConstants.DOT_SEPARATOR
			+ "addArtifact"; //$NON-NLS-1$
	/**
	 * The default image path for an artifact.
	 */
	public static final String IMAGE_PATH = "icons/elcl16/add_atfct.gif"; //$NON-NLS-1$

	private final String kind;
	private final IContainer location;
	private final ISelectionProvider provider;
	private Artifact newArtifact;
	private final IShellProvider sheller;

	/**
	 * Create an AddArtifactAction for the specific type of artifact with the proper settings.
	 * 
	 * @param artifactName
	 *           The user-displayable name of the artifact kind
	 * @param artifactKind
	 *           The XML substitution name of the artifact model element
	 * @param activeShell
	 *           The active shell of the workbench window to use to see any dialogs that need to be
	 *           opened
	 * @param defaultLocation
	 *           A suggested default container for the new resources, perhaps the same container as
	 *           the Topology.
	 */
	public AddArtifactAction(String artifactName, String artifactKind, IShellProvider shellProvider,
			IContainer defaultLocation, ISelectionProvider selectionProvider) {
//		setId(ACTION_ID);
//		setActionDefinitionId(ACTION_ID);
		setText(NLS.bind(Messages.AddArtifactAction_Add_0_, artifactName));
		setToolTipText(NLS.bind(Messages.AddArtifactAction_Add_an_artifact_of_the_specific_sub_,
				artifactName));
		setImageDescriptor(DeployCoreUIPlugin.getImageDescriptor(IMAGE_PATH));

		kind = artifactKind;
		sheller = shellProvider;
		location = defaultLocation;
		provider = selectionProvider;

	}

	@Override
	public void runWithEvent(Event event) {
		run();
	}

	@Override
	public void run() {

		Shell shell = sheller.getShell();
		newArtifact = null;

		final Unit container = getUnit();

		if (container != null) {
			IUIHandlerService handlerService = DeployCoreUIPlugin.getDefault()
					.getArtifactUIHandlerService();

			AbstractUIHandler handler = handlerService.findSubstitutableUIHandlerForKind(kind);
			try {
				Object obj = handler.createNewSubstitutableObject(location, shell);
				if (obj instanceof Artifact) {
					newArtifact = (Artifact) obj;
				}

				if (newArtifact != null) {

					newArtifact.setName(PropertyUtils.generateUniqueArtifactName(container));

					String msg = Messages.ModulePropertySection_Add_Artifac_;
					PropertyUtils.executeWithUndo(container, msg, new Runnable() {

						public void run() {
							container.getArtifacts().add(newArtifact);
						}
					});
				}
			} catch (SAFException e) {
				DeployCoreUIPlugin.logError(0, e.getMessage(), e);
			} catch (InvalidOperationException e) {
				DeployCoreUIPlugin.logError(0, e.getMessage(), e);
			}
		}
		if (container == null) {
			DeployCoreUIPlugin.logError(0,
					Messages.AddArtifactAction_No_Unit_is_available_to_accept_new_, null);
			MessageDialog.openWarning(shell, Messages.AddArtifactAction_Problem_Creating_Artifac_,
					Messages.AddArtifactAction_No_Unit_is_available_to_accept_new_);
		}
	}

	public Artifact getNewArtifact() {
		return newArtifact;
	}

	private Unit getUnit() {
		if (provider != null) {
			ISelection selection = provider.getSelection();
			if (selection instanceof IStructuredSelection) {
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				if (obj instanceof Unit) {
					return (Unit) obj;
				}
			}
		}
		return null;

	}
}
