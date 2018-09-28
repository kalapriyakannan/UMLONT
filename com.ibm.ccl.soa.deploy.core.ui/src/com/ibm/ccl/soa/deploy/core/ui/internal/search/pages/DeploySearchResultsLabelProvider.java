package com.ibm.ccl.soa.deploy.core.ui.internal.search.pages;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.ui.services.util.CommonLabelProvider;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match.EObjectLookupCallback;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class DeploySearchResultsLabelProvider extends CommonLabelProvider implements
		ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {

		Match match = (Match) element;

		try {

			switch (columnIndex)
			{

			case DeploySearchResultsPage.MATCH_TYPE:
				return null;

			case DeploySearchResultsPage.FOUND:
				return getImage(match.getReferencedEObject(false, false, false), match
						.getReferencedCallback());

			case DeploySearchResultsPage.REFERENCER_URI:
				return getImage(match.getReferencerEObject(false, false, false), match
						.getReferencerCallback());

			default:
				return null;
			}
		} catch (CoreException ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
			return null;
		}
	}

	public String getColumnText(Object element, int columnIndex) {

		Match match = (Match) element;

		try {

			EObject eObject = columnIndex == DeploySearchResultsPage.FOUND ? match
					.getReferencedEObject(false, false, false) : match.getReferencerEObject(false,
					false, false);

			switch (columnIndex)
			{

			case DeploySearchResultsPage.MATCH_TYPE:
				if (NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {
					return Messages.DeploySearchResultsPage_View_o_;
				}

				return Messages.DeploySearchResultsPage_Reference_t_;

			case DeploySearchResultsPage.FOUND:
				return getText(eObject, match.getReferencedCallback());

			case DeploySearchResultsPage.REFERENCER_URI:
				return " ( " + getText(eObject, match.getReferencerCallback()) + " ) " //$NON-NLS-1$ //$NON-NLS-2$;
						+ EcoreUtil.getURI(eObject);

			default:
				return new String();

			}
		} catch (CoreException ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
			return null;
		}
	}

	public String getText(EObject eObject, EObjectLookupCallback callback) throws CoreException {

		String text = null;

		// if eObject is an instance of a view we need to get the label from the view's
		// element reference not the view object itself
		if (NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {
			text = getViewText((View) eObject, callback);
		}

		if (isEmpty(text)) {
			text = getText(eObject);
		}

		return text;
	}

	public String getViewText(View view, EObjectLookupCallback callback) throws CoreException {
		String text = null;
		if (view.eIsProxy()) {
			URI ref = (URI) callback.getIndexContext().getProxyData().getValue(EcoreUtil.getURI(view),
					NotationPackage.Literals.VIEW__ELEMENT);
			if (null != ref) {

				if (ref.scheme().startsWith("mmi")) { //$NON-NLS-1$
					URI uri = EcoreUtil.getURI(view);
					Resource resource = loadResource(uri);
					if (null != resource) {
						View resolvedView = (View) resource.getEObject(uri.fragment());
						if (null != resolvedView) {
							EObject element = resolvedView.getElement();
							if (null != element) {
								text = getText(element);
							}
						}
					}
				}

				Object element = callback.getEObject(ref, false, false, false);

				if (null != element) {
					text = getText(element);
				}
			}
		} else {
			EObject element = view.getElement();
			text = getText(element, callback);
		}

		if (isEmpty(text)) {
			text = getText(view);
		}

		return text;
	}

	public String getText(Object object) {
		String text = null;
		if (object instanceof EObject) {
			text = super.getText(new EObjectAdapter((EObject) object));
		}

		if (isEmpty(text)) {
			text = super.getText(object);
		}

		if (isEmpty(text) && object instanceof EObject) {
			EObject eObject = (EObject) object;
			if (CorePackage.Literals.DEPLOY_MODEL_OBJECT.isSuperTypeOf(eObject.eClass())) {
				DeployModelObject dmo = (DeployModelObject) eObject;
				if (dmo.eIsProxy()) {
					URI uri = EcoreUtil.getURI(dmo);
					Resource resource = loadResource(uri);
					if (null != resource) {
						dmo = (DeployModelObject) resource.getEObject(uri.fragment());
						text = DeployModelObjectUtil.getTitle(dmo);
					}
				} else {
					text = DeployModelObjectUtil.getTitle(dmo);
				}
			}
		}

		return text;
	}

	private Image getImage(EObject eObject, EObjectLookupCallback callback) throws CoreException {

		Image image = null;

		// if eObject is an instance of a view we need to get the image from the view's
		// element reference not the view object itself
		if (NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {
			image = getViewImage((View) eObject, callback);
		}

		if (null == image) {
			image = getImage(eObject);
		}

		return image;
	}

	private Image getViewImage(View view, EObjectLookupCallback callback) throws CoreException {
		Image image = null;
		if (view.eIsProxy()) {
			URI ref = (URI) callback.getIndexContext().getProxyData().getValue(EcoreUtil.getURI(view),
					NotationPackage.Literals.VIEW__ELEMENT);
			if (null != ref) {

				if (ref.scheme().startsWith("mmi")) { //$NON-NLS-1$
					URI uri = EcoreUtil.getURI(view);
					Resource resource = loadResource(uri);
					if (null != resource) {
						View resolvedView = (View) resource.getEObject(uri.fragment());
						if (null != resolvedView) {
							EObject element = resolvedView.getElement();
							if (null != element) {
								image = getImage(element);
							}
						}
					}
				}

				Object element = callback.getEObject(ref, false, false, false);

				if (null != element) {
					image = getImage(element);
				}
			}
		} else {
			EObject element = view.getElement();
			image = getImage(element);
		}

		if (null == image) {
			image = getImage(view);
		}

		return image;
	}

	public Image getImage(Object object) {
		Image image = null;
		if (object instanceof EObject) {
			image = super.getImage(new EObjectAdapter((EObject) object));
		}

		if (null == image) {
			image = super.getImage(object);
		}

		return image;
	}

	private boolean isEmpty(String string) {
		if (null == string) {
			return true;
		}

		if (string.trim().length() == 0) {
			return true;
		}

		return false;
	}

	public static Resource loadResource(URI resourceUri) {

		IFile file = WorkbenchResourceHelper.getPlatformFile(resourceUri);
		if (file == null) {
			return null;
		}
		if (file.isAccessible()) {
			ResourceSet set = ResourceUtil.getResourceSet();
			if (set == null) {
				return null;
			}
			Resource resource = set.getResource(resourceUri, true);
			return resource;
		} else {
			return null;
		}
	}
}
