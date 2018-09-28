/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.composites;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnsetInterface;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

public class InterfaceComposite extends DmoComposite {
	private static String JAVA_INTERFACE = "Java Interface"; //$NON-NLS-1$

	private Hyperlink interfaceLink;
	private Text interfaceText;
	private Button editButton;
	private Interface interfaceObj;
	private boolean isUnset = false;
	private EClass serviceType;

	public InterfaceComposite(Composite parent, int style, FormToolkit formToolkit) {
		super(parent, style, formToolkit);
		setLayout(getGridLayout());
		setLayoutData(new GridData(GridData.FILL_BOTH));

	}

	private Layout getGridLayout() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		return gridLayout;
	}

	@Override
	protected void initializeContents(DmoSyncHelper synchHelper) {
		FormToolkit formToolkit = getWidgetFactory();
		interfaceLink = formToolkit.createHyperlink(this, "", SWT.NONE); //$NON-NLS-1$
		interfaceText = formToolkit.createText(this, "");//$NON-NLS-1$
		interfaceText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		interfaceText.setEnabled(false);
		editButton = formToolkit.createButton(this, "...", SWT.None); //$NON-NLS-1$
		addEditButtonSelectionListener();
		addHyperLinkListener();
		formToolkit.adapt(this);
		formToolkit.paintBordersFor(this);
	}

	private void addHyperLinkListener() {

		interfaceLink.addHyperlinkListener(new IHyperlinkListener() {

			public void linkActivated(HyperlinkEvent e) {
				try {
					getUIInterfaceHandler().open(interfaceObj);
				} catch (SAFException e1) {
					DeployCoreUIPlugin.logError(0, e1.getMessage(), e1);
				} catch (InvalidOperationException e2) {
					DeployCoreUIPlugin.logError(0, e2.getMessage(), e2);
				}
			}

			public void linkEntered(HyperlinkEvent e) {

			}

			public void linkExited(HyperlinkEvent e) {

			}
		});

	}

	@Override
	public void setInput(Object object) {
		if (object instanceof Interface) {
			interfaceObj = (Interface) object;
			String defaultText = getInterfaceHandler().getInterfacePropertyLabel(interfaceObj);
			interfaceLink.setText(getInterfaceHandler().getName() + ':');
			if (defaultText != null) {
				interfaceText.setText(defaultText);
			}
			interfaceLink.setUnderlined(getUIInterfaceHandler().canOpen(interfaceObj));
			interfaceLink.setEnabled(getUIInterfaceHandler().canOpen(interfaceObj));
		} else if (object instanceof UnsetInterface) {
			findInterface(object);
			isUnset = true;
			if (getInterfaceHandler() == null || getInterfaceHandler().getName() == null) {
				interfaceLink.setText(Messages.InterfaceComposite_Unknown_Interfac_);
				return;
			}
			interfaceLink.setText(getInterfaceHandler().getName() + ':');
			interfaceText.setText(""); //$NON-NLS-1$
			interfaceLink.setUnderlined(false);
		}
		layout();
	}

	private void findInterface(Object object) {
		serviceType = null;
		UnsetInterface element = (UnsetInterface) object;
		dmo = element.getParent();
		if (element instanceof Reference) {
			serviceType = ((Reference) element.getParent()).getDmoEType();
		} else if (element instanceof Service) {
			serviceType = ((Service) element.getParent()).eClass();
		}

		if (serviceType != null) {
			IInterfaceHandlerService handlerService = DeployCoreUIPlugin.getDefault()
					.getInterfaceHandlerService();

			AbstractInterfaceHandler[] handlers = handlerService
					.findInterfaceHandlersForService(serviceType.eClass());

			if (handlers.length == 1) {
				try {
					interfaceObj = handlers[0].createInterfaceFor(serviceType);
				} catch (Exception e) {
					DeployCoreUIPlugin.logError(0, NLS.bind(
							Messages.InterfaceComposite_Failed_to_create_interface_for_serv_, serviceType
									.getName()), e);
				}
			} else {
				// create interface selection dialog
			}
		}
	}

	private AbstractInterfaceHandler getInterfaceHandler() {
		IInterfaceHandlerService handlerService = DeployCoreUIPlugin.getDefault()
				.getInterfaceHandlerService();
		if (interfaceObj != null) {
			return handlerService.findInterfaceHandlerForInterface(interfaceObj);
		} else {
			return null; //handlerService.findInterfaceHandlersForService();
		}

	}

	private AbstractUIHandler getUIInterfaceHandler() {
		return DeployCoreUIPlugin.getDefault().getInterfaceUIHandlerService()
				.findUIHandlerForSubstitutable(interfaceObj);
	}

	private DeployModelObject getDMO() {
		EObject object = interfaceObj.eContainer();
		if (object instanceof DeployModelObject) {
			dmo = (DeployModelObject) object;
		}
		return dmo;
	}

	private void setInterfaceObjectOnReference(final Reference aReference,
			final Interface interfaceToEdit) {
		AbstractTransactionalCommand editCmd = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(aReference),
				com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsListComposite2_Set_interface_,
				null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				aReference.setInterface(interfaceToEdit);
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			editCmd.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	private void setInterfaceObjectOnService(final Service service, final Interface interfaceToEdit) {
		AbstractTransactionalCommand editCmd = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(service),
				com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsListComposite2_Set_interface_,
				null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				service.setInterface(interfaceToEdit);
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			editCmd.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	private void addEditButtonSelectionListener() {
		editButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				try {
					boolean successful = false;
					if (getInterfaceHandler() == null) {
						return;
					}
					successful = getUIInterfaceHandler().editSubstitutable(getShell(), getDMO(),
							interfaceObj, false);
					if (dmo instanceof Reference) {
						setInterfaceObjectOnReference((Reference) dmo, interfaceObj);
					} else if (dmo instanceof Service) {
						setInterfaceObjectOnService((Service) dmo, interfaceObj);
					}
					if (successful) {
						setInput(interfaceObj);
					}
				} catch (SAFException e1) {
					DeployCoreUIPlugin.logError(0, e1.getMessage(), e1);
				}

			}

		});

	}
}
