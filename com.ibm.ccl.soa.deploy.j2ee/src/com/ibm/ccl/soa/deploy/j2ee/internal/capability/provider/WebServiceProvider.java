/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.http.HTTPAddress;
import javax.wsdl.extensions.soap.SOAPAddress;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jst.j2ee.webapplication.WebApp;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.ws.internal.wsfinder.WebServiceFinder;
import org.eclipse.wst.ws.internal.wsrt.WebServiceInfo;
import org.xml.sax.InputSource;

import com.ibm.ccl.soa.deploy.core.AbstractEMFOperationChange;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployPlugin;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.WSDLInterface;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.WebService;
import com.ibm.ccl.soa.deploy.j2ee.internal.Messages;
import com.ibm.ccl.soa.deploy.j2ee.provider.J2eeEditPlugin;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class WebServiceProvider extends CapabilityProvider {

	public Object[] resolveCapabilities(Object anObject) {

		// TODO Decide on another way to get a monitor; may not be in UI
		IProgressMonitor monitor = new NullProgressMonitor();
		if (anObject instanceof WebApp) {
			WebApp webApp = (WebApp) anObject;
			IFile webFile = WorkbenchResourceHelper.getFile(webApp);
			if (webFile != null) {
				IProject webProject = webFile.getProject();

				List foundWebServices = new ArrayList();
				//TODO Should we use the WorkspaceWSDLLocator instead?
				Iterator webServices = WebServiceFinder.instance().getWebServices(
						new IProject[] { webProject }, monitor);
				while (webServices.hasNext()) {
					WebServiceInfo wsInfo = (WebServiceInfo) webServices.next();
					String wsdlURL = wsInfo.getWsdlURL();
					if (wsdlURL != null) {
						IPath wsdlURLPath = new Path(wsdlURL);
						if (wsdlURLPath.getDevice() != null
								&& wsdlURLPath.getDevice().startsWith("platform:")) { //$NON-NLS-1$
							Definition wsdlDef = null;
							try {
								wsdlDef = parseWSDL(wsdlURL);
							} catch (WSDLException e) {
								J2EEDeployPlugin.logError(0,
										"Failed parsing WSDL file when deriving services: " + wsdlURL, e); //$NON-NLS-1$
							}
							if (wsdlDef != null) {
								Map services = wsdlDef.getServices();
								if (!services.isEmpty()) {
//									String documentUri = computeDocumentUri(wsdlURLPath);
									for (Iterator it = services.values().iterator(); it.hasNext();) {
										Service service = (Service) it.next();
										createWebServices(service, wsdlURL, foundWebServices);
									}
								}
							}
						}
					}
				}
				return foundWebServices.toArray(new Capability[foundWebServices.size()]);
			}
		}
		return NO_CAPS;
	}

	private void createWebServices(Service service, String wsdlDocumentUri, Collection webServices) {

		Map ports = service.getPorts();
		if (!ports.isEmpty()) {
			for (Iterator it = ports.values().iterator(); it.hasNext();) {
				Port port = (Port) it.next();
				webServices.add(createWebService(port, wsdlDocumentUri));
			}
		}

	}

	private WebService createWebService(Port port, String wsdlDocumentUri) {
		WebService ws = J2eeFactory.eINSTANCE.createWebService();
		ws.setName(port.getName());
		ws.setDisplayName(port.getName());

		// Should we make the default version configurable?
		ws.setVersion("1.0.0"); //$NON-NLS-1$

		//Set the endpoint based on the bindings.
		Binding binding = port.getBinding();
		if (binding != null) {
			List extElements = port.getExtensibilityElements();
			for (int i = 0; i < extElements.size(); i++) {
				ExtensibilityElement element = (ExtensibilityElement) extElements.get(i);
				if ("address".equals(element.getElementType().getLocalPart())) { //$NON-NLS-1$
					//HTTPAddress and SOAPAddress supported
					if (element instanceof SOAPAddress) {
						ws.setEndpoint(((SOAPAddress) element).getLocationURI());
						ws.setProtocol("soap/http"); //$NON-NLS-1$
					} else if (element instanceof HTTPAddress) {
						ws.setEndpoint(((HTTPAddress) element).getLocationURI());
						ws.setProtocol("http"); //$NON-NLS-1$
					}
				}
			}
			//Set the interface based on the port type.
			PortType type = binding.getPortType();
			if (type != null) {
				//Set the interface
				WSDLInterface wsdlInterface = J2eeFactory.eINSTANCE.createWSDLInterface();
				wsdlInterface.setTypeUri(wsdlDocumentUri + '#' + type.getQName().getLocalPart());
				ws.setInterface(wsdlInterface);
			}
		}
		return ws;
	}

	private boolean exists(Port port, List webServices) {

		// TODO Better error checking/user feedback.
		if (port.getName() == null) {
			return true; // don't try to import ports with null names
		}

		for (Iterator iterator = webServices.iterator(); iterator.hasNext();) {
			Capability capability = (Capability) iterator.next();
			if (capability instanceof WebService) {
				WebService webService = (WebService) capability;

				if (port.getName().equals(webService.getName())) {
					String endpoint = null;
					Binding binding = port.getBinding();
					if (binding != null) {
						List extElements = port.getExtensibilityElements();
						for (int i = 0; i < extElements.size(); i++) {
							ExtensibilityElement element = (ExtensibilityElement) extElements.get(i);
							if ("address".equals(element.getElementType().getLocalPart())) { //$NON-NLS-1$
								//HTTPAddress and SOAPAddress supported
								if (element instanceof SOAPAddress) {
									endpoint = ((SOAPAddress) element).getLocationURI();
								} else if (element instanceof HTTPAddress) {
									endpoint = ((HTTPAddress) element).getLocationURI();
								}
							}
							if (endpoint != null && endpoint.equals(webService.getEndpoint())) {
								return true;
							}
						}
					}
				}

			}
		}
		return false;
	}

	private Definition parseWSDL(String platformURL) throws WSDLException {
		WSDLFactory factory = WSDLFactory.newInstance();
		WSDLReader reader = factory.newWSDLReader();
		try {
			URL url = new URL(platformURL);
			InputSource input = new InputSource(url.openStream());
			return reader.readWSDL(null, input);
		} catch (MalformedURLException e) {
			J2EEDeployPlugin.logError(0, "Failed parsing WSDL file: " + platformURL, e); //$NON-NLS-1$
		} catch (IOException e) {

		}
		return null;
	}

	public Object[] resolveRequirements(Object anObject) {
		return NO_REQS;
	}

	@Override
	public boolean canReflect() {
		return true;
	}

	@Override
	public Change[] createReflectionChange(Unit unit, IProgressMonitor monitor) {

		List<Change> changes = new ArrayList<Change>();
		monitor.beginTask(NLS.bind(Messages.WebServiceProvider_Creating_reflection_changes_for_0_,
				unit.getName()), 10);
		try {
			if (unit instanceof WebModule) {

				IProject project = J2eeEditPlugin.findProject(unit);

				monitor.subTask(Messages.WebServiceProvider_Searching_workspace_);
				// TODO Should we use the WorkspaceWSDLLocator instead?
				Iterator webServicesIter = WebServiceFinder.instance().getWebServices(
						new IProject[] { project }, subprogress(monitor, 5));

				IProgressMonitor webServiceIterationProgress = subprogress(monitor, 5);
				webServiceIterationProgress.beginTask(Messages.WebServiceProvider_Processing_results_,
						IProgressMonitor.UNKNOWN);
				while (webServicesIter.hasNext()) {

					WebServiceInfo wsInfo = (WebServiceInfo) webServicesIter.next();
					String wsdlURL = wsInfo.getWsdlURL();
					webServiceIterationProgress.subTask(wsdlURL);

					if (wsdlURL != null) {
						IPath wsdlURLPath = new Path(wsdlURL);
						if (wsdlURLPath.getDevice() != null
								&& wsdlURLPath.getDevice().startsWith("platform:")) { //$NON-NLS-1$
							Definition wsdlDef = null;
							try {
								monitor.subTask(Messages.WebServiceProvider_Parsing_WSDL_contents_);
								wsdlDef = parseWSDL(wsdlURL);
								monitor.worked(3);
							} catch (WSDLException e) {
								J2EEDeployPlugin.logError(0,
										"Failed parsing WSDL file when deriving services: " + wsdlURL, e); //$NON-NLS-1$
							}
							if (wsdlDef != null) {
								Map services = wsdlDef.getServices();
								if (!services.isEmpty()) {
//									String documentUri = computeDocumentUri(wsdlURLPath);
									for (Iterator servicesIter = services.values().iterator(); servicesIter
											.hasNext();) {
										Service service = (Service) servicesIter.next();
										Map ports = service.getPorts();
										if (!ports.isEmpty()) {
											for (Iterator portsIter = ports.values().iterator(); portsIter
													.hasNext();) {
												Port port = (Port) portsIter.next();
												if (!exists(port, unit.getCapabilities())) {
													changes.add(new CreateWebServiceModelChange(unit, project,
															port, wsdlURL));
												}
											}
										}

									}
								}
							}
						}
					}
					webServiceIterationProgress.worked(1);
				}
				if (changes.size() > 0) {
					return changes.toArray(new Change[changes.size()]);
				}
				return NO_CHANGES;
			}
		} finally {
			monitor.done();
		}
		return NO_CHANGES;
	}

	public abstract class WebServiceModelChange extends Change {

		private final Unit unit;
		private final IProject project;

		public WebServiceModelChange(Unit unit, IProject project) {
			this.unit = unit;
			this.project = project;
		}

		public Object getModifiedElement() {
			return unit;
		}

		public void initializeValidationData(IProgressMonitor pm) {

		}

		public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
				OperationCanceledException {
			return RefactoringStatus.create(Status.OK_STATUS);
		}

		protected Unit getUnit() {
			return unit;
		}

		protected IProject getProject() {
			return project;
		}
	}

	public class CreateWebServiceModelChange extends WebServiceModelChange {

		private final Port port;
		private final String wsdlURL;

		public CreateWebServiceModelChange(Unit unit, IProject project, Port port, String wsdlURL) {
			super(unit, project);
			this.port = port;
			this.wsdlURL = wsdlURL;
		}

		@Override
		public String getName() {
			String label = null;
			Binding binding = port.getBinding();
			if (binding != null) {
				List extElements = port.getExtensibilityElements();
				for (int i = 0; i < extElements.size() && label == null; i++) {
					ExtensibilityElement element = (ExtensibilityElement) extElements.get(i);
					if ("address".equals(element.getElementType().getLocalPart())) { //$NON-NLS-1$
						//HTTPAddress and SOAPAddress supported
						if (element instanceof SOAPAddress) {
							label = ((SOAPAddress) element).getLocationURI();
						} else if (element instanceof HTTPAddress) {
							label = ((HTTPAddress) element).getLocationURI();
						}
					}
				}
			}
			if (label == null) {
				label = port.getName();
			}

			return NLS.bind(Messages.WebServiceProvider_Create_Web_Service_model_elements_f_, label);
		}

		@Override
		public Change perform(IProgressMonitor pm) throws CoreException {

			AbstractEMFOperation op = new AbstractEMFOperation(TransactionUtil
					.getEditingDomain(getUnit()), getName()) {

				@Override
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					monitor.beginTask(NLS.bind(Messages.WebServiceProvider_Creating_0_, port.getName()),
							2);
					WebService service = createWebService(port, wsdlURL);
					monitor.worked(1);
					getUnit().getCapabilities().add(service);
					monitor.worked(1);
					monitor.done();

					return Status.OK_STATUS;
				}

			};

			return new AbstractEMFOperationChange(getName(), getModifiedElement(), op, false)
					.perform(pm);

		}

	}

	public IProgressMonitor subprogress(IProgressMonitor monitor, int ticks) {
		return new SubProgressMonitor(monitor, ticks,
				SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
	}

}
