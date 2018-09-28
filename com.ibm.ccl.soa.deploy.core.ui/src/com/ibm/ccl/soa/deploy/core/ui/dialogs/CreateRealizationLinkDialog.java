package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ZoomUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;

/**
 * @since 7.0
 * 
 */
public class CreateRealizationLinkDialog extends SelectChangeQuickDialog<LinkDescriptor> {

	protected static String[] tableColumnProperties = { Messages.TARGET_LABEL };
	protected static int[] tableColumnWidths = { 300 };

	final private EditPartViewer _viewer;
	final private Unit _srcUnit;

	static private class RealizationLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof LinkDescriptor) {
				LinkDescriptor item = (LinkDescriptor) element;
				switch (columnIndex)
				{
				case 0: {
					Unit unit = item.getTargetUnit();
					String title = unit.getCaptionProvider().title(unit);
					if (title == null) {
						return Messages.UNKNOWN_LABEL;
					}
					return title;
				}
				}
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
	 * @param viewer
	 * @param openLocation
	 *           The location of the top left corner of the quick dialog when it opens.
	 * @param srcUnit
	 * @param descriptorList
	 *           All links within all selected ConsolidationLinkEditParts
	 */
	public CreateRealizationLinkDialog(Shell parent, EditPartViewer viewer, Point openLocation,
			Unit srcUnit, List<LinkDescriptor> descriptorList) {
		super(parent, openLocation, descriptorList,
				Messages.CreateRealizationLinkDialog_Select_Realization_Lin_,
				new CreateRealizationLinkDialog.RealizationLabelProvider(), tableColumnProperties,
				tableColumnWidths);
		_viewer = viewer;
		_srcUnit = srcUnit;
	}

	@Override
	protected int getOpenStrategyType() {
		return CustomizedOpenStrategy.DOUBLE_CLICK;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(250, 150);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_SEL_REALIZATION_LINK_DIALOG);
		return super.createDialogArea(parent);
	}

	@Override
	protected void handleSelect(SelectionEvent e) {
		super.handleSelect(e);
		if (e.getSource() instanceof Table) {
			_viewer.deselectAll();
			Table table = (Table) e.getSource();
			TableItem[] selections = table.getSelection();
			for (int i = 0; i < selections.length; i++) {
				TableItem item = selections[i];
				if (item.getData() instanceof LinkDescriptor) {
					LinkDescriptor descriptor = (LinkDescriptor) item.getData();
					Unit tgtUnit = descriptor.getTargetUnit();
					List<DeployShapeNodeEditPart> epList = GMFUtils.getOrCreateEditPartsFor(_viewer,
							tgtUnit);
					if (epList.size() > 0) {
						DeployShapeNodeEditPart ep = epList.get(0);
						for (DeployShapeNodeEditPart epx : epList) {
							if (!GMFUtils.isImportTopology(epx)) {
								ep = epx;
								break;
							}
						}
						ZoomUtils.expose(ep);
						if (e.item == item) {
							_viewer.reveal(ep);
						}
						_viewer.appendSelection(ep);
					}
				}
			}
		}
	}
}
