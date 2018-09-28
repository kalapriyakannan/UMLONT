package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;

/**
 * @since 7.0
 * 
 */
public class DeleteConsolidatedLinkDialog extends
		SelectChangeQuickDialog<DeployConnectionNodeEditPart> {

	protected static String[] tableColumnProperties = { Messages.DeleteConsolidatedLinkDialog_0 };
	protected static int[] tableColumnWidths = { 100 };

	static protected class ConsolidationLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				String type = ISharedImages.IMG_DEPENDENCY_LINK_TYPE;
				if (element instanceof DeployConnectionNodeEditPart) {
					EObject eo = ((DeployConnectionNodeEditPart) element).resolveSemanticElement();
					if (eo instanceof HostingLink) {
						type = ISharedImages.IMG_HOSTING_LINK_TYPE;
					} else if (eo instanceof ConstraintLink) {
						type = ISharedImages.IMG_CONSTRAINT_LINK_TYPE;
					} else if (eo instanceof RealizationLink) {
						type = ISharedImages.IMG_REALIZATION_LINK_TYPE;
					}
				}
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(type);
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof DeployConnectionNodeEditPart) {
				return DeployLinkConnection.getToolTip((DeployConnectionNodeEditPart) element);
			}
			return null;
		}
	}

	/**
	 * Create a quick dialog that is modal, but easy to dismiss, in order to present the user with
	 * the given list of options. The labelProvider will be used to provide the user with a
	 * translated message for each option in the list.
	 * 
	 * @param parent
	 *           The parent shell to open in front of.
	 * @param openLocation
	 *           The location of the top left corner of the quick dialog when it opens.
	 * @param unpackedEPList
	 *           All links within all selected ConsolidationLinkEditParts
	 */
	public DeleteConsolidatedLinkDialog(Shell parent, Point openLocation,
			List<DeployConnectionNodeEditPart> unpackedEPList) {
		super(parent, openLocation, unpackedEPList, Messages.DeleteConsolidatedLinkDialog_1,
				new DeleteConsolidatedLinkDialog.ConsolidationLabelProvider(), tableColumnProperties,
				tableColumnWidths);
	}

	@Override
	protected int getOpenStrategyType() {
		return CustomizedOpenStrategy.DOUBLE_CLICK;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(400, 300);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_DELETE_CONSOLIDATED_LINK_DIALOG);
		return super.createDialogArea(parent);
	}

	@Override
	protected String getApplyControlText() {
		return Messages.DeleteConsolidatedLinkDialog_2;
	}

	/**
	 * @return An int for the table style.
	 */
	protected int getTableStyleBits() {
		return SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI;
	}
}
