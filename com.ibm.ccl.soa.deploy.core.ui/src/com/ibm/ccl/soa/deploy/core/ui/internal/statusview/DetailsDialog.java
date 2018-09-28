/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */

public class DetailsDialog extends TrayDialog {
	private IStatusField[] extendFields;
	private Text[] extendTextArray;
	private StatusNode node;
	private SashForm sashForm;
	private Label severityImageLabel;
	private Label severityLabel;
	private Text msgText;
	private Text traceText;

	protected DetailsDialog(Shell shell, StatusNode node, IStatusField[] extendFields) {
		super(shell);
		this.extendFields = extendFields;
		this.node = node;
		setShellStyle(getShellStyle() | SWT.RESIZE);
		extendTextArray = new Text[extendFields.length];

	}

	private String getTrace() throws NotSupportedTargetException {
		Throwable exe;

		exe = FieldException.INSTANCE.getObject(node);
		if (exe == null)
			return Messages.NULL_MESSAGE;
		StringWriter swriter = new StringWriter();
		PrintWriter writer = new PrintWriter(swriter);
		exe.printStackTrace(writer);
		return swriter.toString();

	}

	private void setContent() {

		try {
			severityImageLabel.setImage(FieldSeverity.INSTANCE.getImage(node));
			//severityImageLabel.setText(FieldSeverity.INSTANCE.getValue(node));
			severityLabel.setText(FieldSeverity.INSTANCE.getValue(node));
			msgText.setText(FieldMessage.INSTANCE.getValue(node));
			traceText.setText(getTrace());
			for (int i = 0; i < extendFields.length; i++) {
				extendTextArray[i].setText(extendFields[i].getValue(node));
			}
		} catch (NotSupportedTargetException e) {

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gd);

		createNormalSection(container);
		sashForm = createSashForm(container);
		createExtendSection(sashForm);
		setContent();
		return container;

	}

	private SashForm createSashForm(Composite parent) {
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		GridLayout layout = new GridLayout();
		layout.marginHeight = layout.marginWidth = 0;
		sashForm.setLayout(layout);
		sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
		return sashForm;
	}

	protected void createNormalSection(Composite parent) {
		Composite textContainer = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginHeight = layout.marginWidth = 0;
		textContainer.setLayout(layout);
		textContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createSeveritySection(textContainer);
		createDescriptionSection(textContainer);
		createTraceSection(textContainer);
	}

	protected void createTraceSection(Composite parent) {
		traceText = createTextSection(parent, "Exception stack trace", 100); //$NON-NLS-1$

	}

	protected void createDescriptionSection(Composite parent) {
		msgText = createTextSection(parent, "Description", 80); //$NON-NLS-1$

	}

	protected void createSeveritySection(Composite parent) {
		Composite textContainer = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.marginHeight = layout.marginWidth = 0;
		textContainer.setLayout(layout);
		textContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Label label = new Label(textContainer, SWT.NONE);
		label.setText(Messages.Status_Severity);
		severityImageLabel = new Label(textContainer, SWT.NULL);
		//severityImageLabel.setText()
		severityLabel = new Label(textContainer, SWT.NULL);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		severityLabel.setLayoutData(gd);
	}

	protected void createExtendSection(Composite parent) {
		for (int i = 0; i < extendFields.length; i++) {
			extendTextArray[i] = createTextSection(parent, extendFields[i].getColumnHeaderText(), 60);
		}
	}

	protected Text createTextSection(Composite parent, String textLabel, int height) {
		Text text;
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 3;
		container.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = height;
		container.setLayoutData(gd);

		Label label = new Label(container, SWT.NULL);
		label.setText(textLabel);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		label.setLayoutData(gd);

		text = new Text(container, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		gd = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL);
		gd.grabExcessHorizontalSpace = true;
		text.setLayoutData(gd);
		text.setEditable(false);
		return text;
	}

}
