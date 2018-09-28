package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.TopologyNodeColorDecorator;

/**
 * @since 7.0
 * 
 */
public class HighlightUnusedNodesAction extends Action {

	private final IWorkbenchPage wbPage;
	private final IWorkbenchWindow window = null;
	private static boolean enabled = false;

	/**
	 * @param wbPage
	 */
	public HighlightUnusedNodesAction(IWorkbenchPage wbPage) {
		setId(HighlightUnusedNodesAction.class.getName());
		setText(Messages.HighlightUnusedNodesAction_Highlight_unvisualized_Topology_ele_);
		setToolTipText(Messages.HighlightUnusedNodesAction_Highlight_Topology_elements_in_the_);
		this.wbPage = wbPage;
	}

	public void run() {
		enabled = !enabled;
		setChecked(enabled);
		TopologyNodeColorDecorator.setEnabled(enabled);

	}

	public ImageDescriptor getImageDescriptor() {
		return DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
				ISharedImages.IMG_TOPOLOGY_DIAGRAM_NODE);
	}

	@Override
	public int getStyle() {
		return IAction.AS_CHECK_BOX;
	}
}
