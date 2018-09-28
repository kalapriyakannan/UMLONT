/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.publisher;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;

public class PublishFamilyMember extends Job implements IJobChangeListener {

	private String lastName;
	private String firstName;
	private int familyPriority = 100;
	private Job job = null;
	private boolean hasJob = false;
	private List children = new ArrayList();

	public PublishFamilyMember(String firstName, String lastName) {
		super(firstName + " " + lastName); //$NON-NLS-1$
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public PublishFamilyMember(Job job, String firstName, String lastName) {
		super(firstName + " " + lastName); //$NON-NLS-1$
		this.job = job;
		this.hasJob = true;
		this.lastName = lastName;
		this.firstName = firstName;
		setupJobListener();
	}

	private void setupJobListener() {
		job.addJobChangeListener(this);

	}

	protected IStatus run(IProgressMonitor monitor) {
		System.out.println(firstName);
		return Status.OK_STATUS;
	}

	public void setJob(Job job) {
		hasJob = true;
		this.job = job;
	}

	public boolean belongsTo(Object family) {
		return lastName.equals(family);

	}

	public int getFamilyPriority() {
		return familyPriority;
	}

	public void setFamilyPriority(int familyPriority) {
		this.familyPriority = familyPriority;
	}

	public Job getJob() {
		return job;
	}

	public boolean containsJob() {
		return hasJob;
	}

	public void addChildren(List childList) {
		children.addAll(childList);
	}

	public void addChild(Object child) {
		children.add(child);
	}

	public boolean hasChildren() {
		return children.size() != 0;
	}

	public List getChildren() {
		return children;
	}

	public void aboutToRun(IJobChangeEvent event) {

	}

	public void awake(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	public void done(IJobChangeEvent event) {
		event.getJob().removeJobChangeListener(this);
		schedule();
	}

	public void running(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	public void scheduled(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	public void sleeping(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
