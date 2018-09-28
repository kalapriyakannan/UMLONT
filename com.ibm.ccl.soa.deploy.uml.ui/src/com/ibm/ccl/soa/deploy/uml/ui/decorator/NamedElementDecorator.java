package com.ibm.ccl.soa.deploy.uml.ui.decorator;

import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.emf.core.internal.util.MSLConstants;
import org.eclipse.gmf.runtime.emf.core.internal.util.ShortcutUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.INavigatorContentService;
import org.eclipse.ui.navigator.NavigatorContentServiceFactory;
import org.eclipse.uml2.uml.Element;

import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match;
import com.ibm.ccl.soa.deploy.uml.ui.Activator;
import com.ibm.ccl.soa.deploy.uml.ui.internal.search.handlers.AbstractUMLReferencesHandler;
import com.ibm.xtools.uml.msl.internal.util.UML2Constants;
import com.ibm.xtools.uml.navigator.ModelElementDescriptor;
import com.ibm.xtools.uml.navigator.ModelServerElement;
import com.ibm.xtools.uml.navigator.ProxyModelingElement;
import com.ibm.xtools.uml.type.UMLElementTypes;

public class NamedElementDecorator implements ILabelDecorator {

	private final INavigatorContentService service;
	private final ILabelProvider delegateLabelProvider;
	private final ListenerList listeners;

	@SuppressWarnings( { "restriction" })
	public NamedElementDecorator() {
		service = NavigatorContentServiceFactory.INSTANCE
				.createContentService("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
		delegateLabelProvider = service.createCommonLabelProvider();
//		delegateLabelProvider = new AdapterFactoryLabelProvider(new DynamicAdapterFactory(
//				"org.eclipse.ui.navigator.ProjectExplorer")); //$NON-NLS-1$
		listeners = new ListenerList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ILabelDecorator#decorateImage(org.eclipse.swt.graphics.Image,
	 *      java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public Image decorateImage(Image image, Object element) {

		if (element instanceof Match) {

			Match match = (Match) element;
			URI uri = match.getReferencing();

			try {

				if (isUmlFileType(uri)) {

					EObject eObject = match.getReferencerEObject(false, true, false);
					if (NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {
						View view = (View) eObject;
						if (view.eIsProxy()) {
							return delegateLabelProvider.getImage(new ProxyModelingElement(
									new ModelElementDescriptor(view.getElement())));
						}
						return delegateLabelProvider.getImage(new ModelServerElement(
								new ModelElementDescriptor(view.getElement())));
					}
					return delegateLabelProvider.getImage(new ModelServerElement(
							new ModelElementDescriptor(eObject)));
				}

			} catch (CoreException ex) {
				Activator.logError(0, ex.getMessage(), ex);
				return null;
			}

		}

		return image;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ILabelDecorator#decorateText(java.lang.String,
	 *      java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public String decorateText(String text, Object element) {

		if (element instanceof Match) {

			Match match = (Match) element;
			URI uri = match.getReferencing();

			try {

				if (isUmlFileType(uri)) {

					EObject eObject = match.getReferencerEObject(false, true, false);
//					if (NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {
//						View view = (View) eObject;
//						if (view.eIsProxy()) {
//							return delegateLabelProvider.getText(new ProxyModelingElement(
//									new ModelElementDescriptor(view.getElement())));
//						}
//						return delegateLabelProvider.getText(new ModelServerElement(
//								new ModelElementDescriptor(view.getElement())));
//					}
					return getFullyQualifiedName(eObject);
//					return delegateLabelProvider.getText(new ModelServerElement(
//							new ModelElementDescriptor(eObject)));
				}

			} catch (CoreException ex) {
				Activator.logError(0, ex.getMessage(), ex);
				return null;
			}

		}

		return text;
	}

	private boolean isUmlFileType(URI uri) {
		return AbstractUMLReferencesHandler.UML_MODEL_CONTENT_TYPE.isAssociatedWith(uri
				.trimFragment().lastSegment())
				|| AbstractUMLReferencesHandler.UML_MODEL_FRAGMENT_CONTENT_TYPE.isAssociatedWith(uri
						.trimFragment().lastSegment())
				|| AbstractUMLReferencesHandler.UML_PROFILE_CONTENT_TYPE.isAssociatedWith(uri
						.trimFragment().lastSegment());
	}

	public static String getFullyQualifiedName(EObject eObject) {
		if (eObject.eIsProxy()) {
			return null;
		}

		if (ShortcutUtil.isShortcut(eObject)) {
			return formatString(UMLElementTypes.SHORTCUT.getDisplayName(), EObjectUtil.getQName(
					eObject, true));
		}

		// check if it a fragment
		if (eObject instanceof EAnnotation
				&& UML2Constants.FRAGMENTS_ANNOTATION.equals(((EAnnotation) eObject).getSource())) {
			return formatString("Fragment", EObjectUtil.getQName(eObject, true)); //$NON-NLS-1$
		}

		if (eObject instanceof Element) {
			return formatString(EObjectUtil.getName(eObject.eClass()), EObjectUtil.getQName(eObject,
					true));
		}

		if (eObject instanceof View) {
			View view = (View) eObject;

			Diagram diagram = view.getDiagram();
			if (diagram == null) {
				return null;
			}
			String pathString = EObjectUtil.getQName(diagram, true);
			String name = view.getElement() != null ? EObjectUtil.getName(view.getElement()) : view
					.getType();

			if (StringStatics.BLANK.equals(name) && view.getElement() != null) {
				name = EObjectUtil.getName(view.getElement().eClass());
			}

			if (!name.equals(StringStatics.BLANK)) {
				name = MSLConstants.QUALIFIED_NAME_SEPARATOR + name;
			}
			return pathString + name;

		}

		return null;
	}

	/*
	 * Return formatted string
	 */
	public static String formatString(String one, String two) {
		if (StringStatics.BLANK.equals(one)) {
			return two;
		}

		return MessageFormat.format("<{0}> {1}", new Object[] { one, two }); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		if (null != delegateLabelProvider) {
			try {
				delegateLabelProvider.dispose();
			} catch (Exception ex) {
				Activator.logError(0, ex.getMessage(), ex);
			}
		}

		if (null != service) {
			try {
				service.dispose();
			} catch (Exception ex) {
				Activator.logError(0, ex.getMessage(), ex);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
	 *      java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

}
