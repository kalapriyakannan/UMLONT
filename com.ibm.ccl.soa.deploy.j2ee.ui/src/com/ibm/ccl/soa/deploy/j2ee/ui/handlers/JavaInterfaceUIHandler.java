/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.ui.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jdt.ui.actions.OpenNewInterfaceWizardAction;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.util.Assert;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.wst.common.core.search.scope.ProjectSearchScope;
import org.eclipse.wst.common.core.search.scope.SearchScope;
import org.eclipse.wst.common.core.search.scope.SelectionSearchScope;
import org.eclipse.wst.common.core.search.scope.WorkspaceSearchScope;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Substitutable;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.j2ee.JavaInterface;
import com.ibm.ccl.soa.deploy.j2ee.internal.handlers.util.TypeInfo;
import com.ibm.ccl.soa.deploy.j2ee.internal.handlers.util.TypeInfoFactory;
import com.ibm.ccl.soa.deploy.j2ee.ui.J2EEUIDeployPlugin;
import com.ibm.ccl.soa.deploy.j2ee.ui.Messages;
import com.ibm.ccl.soa.deploy.j2ee.ui.handlers.util.TypeFilter;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class JavaInterfaceUIHandler extends AbstractUIHandler {

	private class TypeInfoRequestor extends TypeNameRequestor {
		private final Collection fTypesFound;
		private final TypeInfoFactory fFactory;

		/**
		 * Constructs the TypeRefRequestor
		 * 
		 * @param typesFound
		 *           Will collect all TypeRef's found
		 */
		public TypeInfoRequestor(Collection typesFound) {
			Assert.isNotNull(typesFound);
			fTypesFound = typesFound;
			fFactory = new TypeInfoFactory();
		}

		protected boolean inScope(char[] packageName, char[] typeName) {
			return !TypeFilter.isFiltered(packageName, typeName);
		}

		public void acceptType(int modifiers, char[] packageName, char[] typeName,
				char[][] enclosingTypeNames, String path) {
			if (inScope(packageName, typeName)) {
				fTypesFound.add(fFactory.create(packageName, typeName, enclosingTypeNames, modifiers,
						path));
			}
		}
	}

	public AbstractDescriptionProvider getDescriptionProvider() {
		return new AbstractDescriptionProvider() {
			public String getName(Object interfaceObject) {
				return ((TypeInfo) interfaceObject).getTypeName();
			}

			/*
			 * This will return fully qualifed name of the type selected.
			 * 
			 * @see
			 * com.ibm.ccl.soa.core.saf.handler.IInterfaceHandler.IInterfaceLabelProvider#getQualifier
			 * (java.lang.Object)
			 */
			public String getQualifier(Object interfaceObject) {
				return ((TypeInfo) interfaceObject).getFullyQualifiedName();
			}

			public Image getObjectImage(Object interfaceObject) {
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_INTERFACE);
			}

			public IFile getFile(Object interfaceObject) {
				TypeInfo typeInfo = (TypeInfo) interfaceObject;
				if (typeInfo.getElementType() == TypeInfo.IFILE_TYPE_INFO) {
					return ResourcesPlugin.getWorkspace().getRoot()
							.getFile(new Path(typeInfo.getPath()));
				} else if (typeInfo.getElementType() == TypeInfo.JAR_FILE_ENTRY_TYPE_INFO) {
					return ResourcesPlugin.getWorkspace().getRoot().getFile(
							typeInfo.getPackageFragmentRootPath());
				}

				return null;
			}

			public Image getContainerImage(Object interfaceObject) {
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_PACKAGE);
			}
		};
	}

	public Object[] getInterfaceObjects(char[] searchChars) {
		ArrayList typeInfos = new ArrayList();
		TypeInfoRequestor requestor = new TypeInfoRequestor(typeInfos);

		IJavaSearchScope scope = getJavaSearchScope(null);

		try {
			new SearchEngine().searchAllTypeNames(null, searchChars, SearchPattern.R_PATTERN_MATCH,
					IJavaSearchConstants.INTERFACE, scope, requestor,
					IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());

		} catch (JavaModelException e) {
			J2EEUIDeployPlugin.logError(0, e.getMessage(), e);
		}

		return typeInfos.toArray();
	}

	private IJavaSearchScope getJavaSearchScope(SearchScope searchScope) {
		if (searchScope instanceof WorkspaceSearchScope) {
			return SearchEngine.createWorkspaceScope();
		} else if (searchScope instanceof SelectionSearchScope) {
			IFile[] resources = searchScope.enclosingFiles();

			List javaElements = new ArrayList();
			for (int i = 0; i < resources.length; i++) {
				IJavaElement element = JavaCore.create(resources[i]);
				if (element != null) {
					javaElements.add(element);
				}
			}

			IJavaElement[] elements = (IJavaElement[]) javaElements
					.toArray(new IJavaElement[javaElements.size()]);
			return SearchEngine.createJavaSearchScope(elements, true);
		} else if (searchScope instanceof ProjectSearchScope) {
			IFile[] resources = searchScope.enclosingFiles();

			List javaElements = new ArrayList();
			for (int i = 0; i < resources.length; i++) {
				IJavaElement element = JavaCore.create(resources[i]);
				if (element != null) {
					javaElements.add(element.getJavaProject());
					break;
				}
			}

			IJavaElement[] elements = (IJavaElement[]) javaElements
					.toArray(new IJavaElement[javaElements.size()]);
			return SearchEngine.createJavaSearchScope(elements, true);
		}

		return SearchEngine.createWorkspaceScope();
	}

	private TypeInfo getTypeInfo(String fullyQualitfyName) {
		String typeName = getTypeName(fullyQualitfyName);
		Object[] objects = getInterfaceObjects(typeName.toCharArray());
		for (int i = 0; i < objects.length; i++) {
			Object object = objects[i];
			if (object instanceof TypeInfo) {
				TypeInfo typeInfo = (TypeInfo) object;
				if (typeInfo.getFullyQualifiedName().equals(fullyQualitfyName)) {
					return typeInfo;
				}
			}

		}

		return null;
	}

	private String getTypeName(String fullyQualitfyName) {
		if (fullyQualitfyName != null) {
			int lastInt = fullyQualitfyName.lastIndexOf('.');
			int stringSize = fullyQualitfyName.length();
			return fullyQualitfyName.substring(lastInt + 1, stringSize);
		}
		return IConstants.EMPTY_STRING;

	}

	public void open(Substitutable interfaze) throws SAFException {
		if (interfaze instanceof JavaInterface) {
			String fullyQualifiedName = ((JavaInterface) interfaze).getInterface();
			AbstractDescriptionProvider provider = getDescriptionProvider();
			TypeInfo info = getTypeInfo(fullyQualifiedName);
			IFile file = provider.getFile(info);
			IJavaElement element = JavaCore.create(file);
			if (element == null || !element.exists()) {
				return;
			}
			if (fullyQualifiedName != null && fullyQualifiedName.length() > 0) {
				try {
					JavaUI.openInEditor(element);
				} catch (PartInitException e) {
					throw new SAFException(e);
				} catch (JavaModelException e) {
					throw new SAFException(e);
				}
			} else {
				MessageBox msgBox = new MessageBox(new Shell(), SWT.ICON_ERROR);
				msgBox.setMessage(Messages.INTERFACE_NOT_SET);
				msgBox.open();

			}
		}
	}

	public IType getIType(String fullyQualifiedName, EObject context) {
		if (context != null) {
			IProject project = ProjectUtilities.getProject(context);
			if (project == null) {
				//Try getting the project from the URI
				Resource resource = context.eResource();
				if (resource != null) {
					IFile file = WorkbenchResourceHelper.getPlatformFile(resource.getURI());
					if (file != null) {
						project = file.getProject();
					}
				}
			}
			if (project != null) {
				return getIType(fullyQualifiedName, project);
			}
		}
		return null;
	}

	public IType getIType(String fullyQualifiedName, IProject project) {
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject != null) {
			try {
				return javaProject.findType(fullyQualifiedName);
			} catch (JavaModelException jme) {
				J2EEUIDeployPlugin.logError(0, jme.getMessage(), jme);
			}
		}
		return null;
	}

	public IType getIType(IFile file) {
		IJavaElement javaElement = JavaCore.create(file);

		if (javaElement instanceof ICompilationUnit) {
			return ((ICompilationUnit) javaElement).findPrimaryType();
		}

		return null;
	}

	public Object createNewSubstitutableObject(IContainer defaultLocation, Shell shell)
			throws SAFException, InvalidOperationException {
		OpenNewInterfaceWizardAction action = new OpenNewInterfaceWizardAction();
		if (defaultLocation != null) {
			action.setSelection(new StructuredSelection(defaultLocation));
		}

		action.run();

		IJavaElement createdElement = action.getCreatedElement();

		return createdElement;
	}

	public boolean isUIHandlerForObject(Substitutable interfaze) {
		return interfaze instanceof JavaInterface;
	}

	public boolean editSubstitutable(Shell shell, final DeployModelObject nubDmo,
			Substitutable substitutable, boolean isEditNubDmo) throws SAFException {
		if (substitutable instanceof JavaInterface) {
			final JavaInterface javaInterface = (JavaInterface) substitutable;
			SelectionStatusDialog dialog;
			try {
				dialog = (SelectionStatusDialog) JavaUI.createTypeDialog(shell, null, SearchEngine
						.createWorkspaceScope(), IJavaSearchConstants.INTERFACE, false);
			} catch (JavaModelException e1) {
				J2EEUIDeployPlugin.logError(0, "Failed to open java interface search dialog.", e1); //$NON-NLS-1$
				return false;
			}

			dialog.setTitle(javaInterface.getInterface());
			dialog.setMessage(Messages.JavaInterfaceUIHandler_Select_a_new_interface_);
			if (dialog instanceof FilteredItemsSelectionDialog) {
				((FilteredItemsSelectionDialog) dialog).setInitialPattern(javaInterface
						.getDisplayString() != null ? javaInterface.getDisplayString() : "*"); //$NON-NLS-1$
			}
			dialog.setInitialSelections(new Object[] { javaInterface });
			if (dialog.open() == Window.OK) {
				Object interfaceOBJ = dialog.getFirstResult();
				String interfaceName = null;
				if (interfaceOBJ != null && interfaceOBJ instanceof IType) {
					IType type = (IType) interfaceOBJ;
					interfaceName = type.getFullyQualifiedName();

				} else {
					return false;
				}
				final String finalName = interfaceName;
				final AbstractTransactionalCommand editCmd = new AbstractTransactionalCommand(
						TransactionUtil.getEditingDomain(nubDmo), Messages.Edit_Java_interface, null) {
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
						monitor.beginTask(Messages.JavaInterfaceUIHandler_Configuring_model_element_, 4);
						try {
							javaInterface.setInterface(finalName);
							monitor.worked(2);
						} finally {
							monitor.done();
						}
						return CommandResult.newOKCommandResult();
					}
				};

				DeployCoreUIPlugin.runWithProgress(new IRunnableWithProgress() {
					public void run(IProgressMonitor monitor) throws InvocationTargetException,
							InterruptedException {
						try {
							editCmd.execute(monitor, null);
						} catch (ExecutionException e) {
							J2EEUIDeployPlugin.logError(0, e.getMessage(), e);
						}
					}
				}, false);

				// open interface in editor if user asked
				/*
				 * if (dialog.isOpenInterface()) { open(javaInterface); }
				 */
				return true;
			}
		}
		return false;
	}

}
