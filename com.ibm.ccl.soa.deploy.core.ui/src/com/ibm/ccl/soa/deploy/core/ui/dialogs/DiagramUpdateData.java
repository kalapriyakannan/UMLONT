/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * @since 7.0
 * 
 */
public class DiagramUpdateData {
	private String _name;
	private String _type;
	private final int _change;
	private boolean _isUnit = false;
	private final View _view;

	/**
	 * a view was created
	 */
	static final public int CREATED = 0;
	/**
	 * a view was created
	 */
	static final public int DELETED = 1;
	/**
	 * a view is unreferenced
	 */
	static final public int UNREFED = 2;
	/**
	 * a view is unreferenced
	 */
	static final public int REREFED = 3;
	/**
	 * a view is uncontained
	 */
	static final public int UNCONTAINED = 4;

	/**
	 * @param dmo
	 * @param view
	 * @param parentDmo
	 * @param name
	 * @param type
	 * @param isUnit
	 * @param change
	 */
	public DiagramUpdateData(EObject dmo, View view, EObject parentDmo, String name, String type,
			boolean isUnit, int change) {
		_change = change;
		_view = view;

		if (dmo == null) {
			_type = type;
			_name = name;
			_isUnit = isUnit;
		} else {
			if (dmo instanceof HostingLink) {
				HostingLink link = (HostingLink) dmo;
				_name = NLS.bind(Messages.HostingLinkType, DeployModelObjectUtil.getTitle(link
						.getTarget()), DeployModelObjectUtil.getTitle(link.getSource()));
			} else if (dmo instanceof RealizationLink) {
				RealizationLink link = (RealizationLink) dmo;
				_name = NLS.bind(Messages.RealizationLinkType, DeployModelObjectUtil.getTitle(link
						.getTarget()), DeployModelObjectUtil.getTitle(link.getSource()));
			} else if (dmo instanceof DependencyLink) {
				DependencyLink link = (DependencyLink) dmo;
				DeployModelObject srcDmo = link.getSource();
				DeployModelObject tgtDmo = link.getTarget();
				_name = NLS.bind(Messages.DependencyLinkType, new Object[] {
						srcDmo == null ? null : DeployModelObjectUtil.getTitle(srcDmo.getParent()),
						DeployModelObjectUtil.getTitle(srcDmo),
						tgtDmo == null ? null : DeployModelObjectUtil.getTitle(tgtDmo.getParent()),
						DeployModelObjectUtil.getTitle(tgtDmo) });
			} else if (dmo instanceof DeployModelObject) {
				_name = getQualifiedName(_view, false);
			}
			_type = Messages.DiagramRefreshDialog_Unknown_Objec_;
			_isUnit = dmo instanceof Unit;

			if (dmo instanceof Unit) {
				_type = Messages.DeployDeleteAction_Uni_;
			} else if (dmo instanceof HostingLink) {
				_type = Messages.HOSTINGLINK_CATEGORY;
			} else if (dmo instanceof ConstraintLink) {
				_type = Messages.CONSTRAINTLINK_CATEGORY;
			} else if (dmo instanceof MemberLink) {
				_type = Messages.MEMBERSHIP_CATEGORY;
			} else if (dmo instanceof DependencyLink) {
				_type = Messages.DEPENDENCYLINK_CATEGORY;
			} else if (dmo instanceof RealizationLink) {
				_type = Messages.REALIZATIONLINK_CATEGORY;
			}
		}
		if (view != null) {
			DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null && style.getProxyHashCode() != 0
					|| view.getElement() instanceof DeployModelObject
					&& PropertyUtils.isProxy((DeployModelObject) view.getElement())) {
				_type = NLS.bind(Messages.DiagramUpdateData_Imported_0_, _type);
			}
		}
	}

	public String getName() {
		return _name;
	}

	public String getType() {
		return _type;
	}

	public int getChange() {
		return _change;
	}

	public boolean isUnit() {
		return _isUnit;
	}

	public View getView() {
		return _view;
	}

	/**
	 * @param view
	 * @param isFrom
	 * @return qualified unit name
	 */
	public static String getQualifiedName(View view, boolean isFrom) {
		String name = Messages.ImportTopologyCompartmentCanonicalEditPolicy_unknow_;
		EObject eo = view.eContainer();
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null && eo != null) {
			String parentName = "";//$NON-NLS-1$
			if (eo instanceof Diagram) {
				parentName = Messages.DeployDeleteAction_Diagra_;
			} else if (eo != null && eo.eContainer() instanceof View) {
				View containerView = (View) eo.eContainer();
				DeployStyle pstyle = (DeployStyle) containerView
						.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
				if (pstyle != null && pstyle.getElementName() != null
						&& pstyle.getElementName().length() > 0) {
					parentName = NLS.bind(Messages.CreateDependencyLinkDialog_6,
							pstyle.getElementName(), pstyle.getElementCategory());
				} else if (containerView.getElement() instanceof DeployModelObject) {
					parentName = PropertyUtils
							.getDmoName((DeployModelObject) containerView.getElement());
				} else {
					parentName = Messages.ImportTopologyCompartmentCanonicalEditPolicy_unknow_;
				}
			} else {
				parentName = Messages.ImportTopologyCompartmentCanonicalEditPolicy_unknow_;
			}
			if (isFrom) {
				name = NLS.bind(Messages.DeployCanonicalEditPolicy_0_1_from_2_, new Object[] {
						style.getElementName(), style.getElementCategory(), parentName });
			} else {
				name = NLS.bind(Messages.DeployCanonicalEditPolicy_0_1_in_2_, new Object[] {
						style.getElementName(), style.getElementCategory(), parentName });
			}
		}
		return name;
	}
}
