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
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;

public class PublishFamilyManager {

	class Mutex implements ISchedulingRule {
		public boolean isConflicting(ISchedulingRule rule) {
			return rule == this;
		}

		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}
	}

	private Mutex mutex = new Mutex();

	private List listeners = new ArrayList();

	private static PublishFamilyManager instance = new PublishFamilyManager();

	private List familyMembers = new ArrayList();
	private boolean user = true;

	public void addMember(PublishFamilyMember member) {
		familyMembers.add(member);
	}

	public IStatus scheduleFamily(String familyName, boolean sort) {
		if (sort) {
			sortMembers();
		}
		return schedule();
	}

	private IStatus schedule() {
		for (Iterator iterator = familyMembers.iterator(); iterator.hasNext();) {
			PublishFamilyMember member = (PublishFamilyMember) iterator.next();
			Job executeJob = (Job) member;
			if (member.containsJob()) {
				executeJob = member.getJob();
			}
			executeJob.setRule(mutex);
			executeJob.schedule();
		}
		// need to collect status;
		return Status.OK_STATUS;

	}

	private void sortMembers() {
		Collections.sort(familyMembers, new Comparator() {
			public int compare(Object arg0, Object arg1) {
				PublishFamilyMember m1 = (PublishFamilyMember) arg0;
				PublishFamilyMember m2 = (PublishFamilyMember) arg1;
				if (m1.getFamilyPriority() >= m2.getFamilyPriority()) {
					return 1;
				}
				return 0;
			}

		});

	}

	public static PublishFamilyManager instance() {
		return instance;
	}

	public void setUser(boolean user) {
		this.user = user;
	}

	public void reset() {
		familyMembers.clear();
	}

	public List getFamilyMembers(boolean sort) {
		if (sort)
			sortMembers();
		return familyMembers;
	}

	public void addListener(IListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);

		}
	}

	public void removeListener(IListener listener) {
		if (listeners.contains(listener))
			listeners.remove(listener);
	}

	public void notifyListeners() {

		for (Iterator iterator = listeners.iterator(); iterator.hasNext();) {
			IListener listener = (IListener) iterator.next();
			listener.handle();

		}
	}

	public Mutex getMutex() {
		return mutex;
	}

}
