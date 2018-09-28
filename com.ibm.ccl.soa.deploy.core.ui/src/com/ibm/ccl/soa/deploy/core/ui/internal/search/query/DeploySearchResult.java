package com.ibm.ccl.soa.deploy.core.ui.internal.search.query;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;

import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.DeploySearchEvent.DeploySearchEventType;

public class DeploySearchResult implements ISearchResult {

	// list of matches
	private final Collection<Match> elements = new ArrayList<Match>(2);

	// list of new additions to the matches that need to be notified to the
	// search listeners..
	private final Collection<Match> newAdditions = new ArrayList<Match>(2);

	// list of matches
	private final Collection<Match> oldelements = new ArrayList<Match>(2);

	// search listeners
	private final ListenerList searchResultsListeners = new ListenerList();

	// a query object
	private ISearchQuery query = null;

	// constant for notification of new additions
	private static int NEW_ADDITIONS_NOTIFICATION_THRESHOLD = 5000;

	/**
	 * A constructor - create a new search result for the given search query object
	 * 
	 * @param query
	 */
	public DeploySearchResult(ISearchQuery query) {
		super();
		this.query = query;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#addListener(org.eclipse.search.ui.ISearchResultListener)
	 */
	public void addListener(ISearchResultListener l) {
		searchResultsListeners.add(l);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#removeListener(org.eclipse.search.ui.ISearchResultListener)
	 */
	public void removeListener(ISearchResultListener l) {
		searchResultsListeners.remove(l);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#getLabel()
	 */
	public String getLabel() {
		return new String();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#getTooltip()
	 */
	public String getTooltip() {
		return new String();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#getImageDescriptor()
	 */
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#getQuery()
	 */
	public ISearchQuery getQuery() {
		return query;
	}

	/**
	 * @return Returns the elements.
	 */
	public Collection<Match> getElements() {
		return elements;
	}

	/**
	 * Remove element from the search results set (due to model closing event for instance)
	 * 
	 * @param element
	 */
	public void removeMatch(Match match) {
		elements.remove(match);

		// just in case the notification has not been fired we want to update
		// the new additions list as well
		newAdditions.remove(match);

		ArrayList<Match> list = new ArrayList<Match>(2);
		list.add(match);
		fireSearchResultEvent(DeploySearchEvent.REMOVED, list);
	}

	/**
	 * Add element to the search results set
	 * 
	 * @param element
	 */
	public void addMatch(Match match) {
		elements.add(match);
		newAdditions.add(match);

		// The optimization is needed here so that events are not fired
		// for every addition of match. Instead the events are fired after
		// NEW_ADDITIONS_NOTIFICATION_THRESHOLD addtions so that
		// the search results view is updated frequently and the number of read
		// transactions
		// opoened through async runnables is minimal.
		if (newAdditions.size() > NEW_ADDITIONS_NOTIFICATION_THRESHOLD) {

			fireSearchResultEvent(DeploySearchEvent.ADDED, newAdditions);

			// clear once the events are fired
			newAdditions.clear();
		}
	}

	/**
	 * @param element
	 * @return
	 */
	public boolean containsMatch(Match match) {
		return elements.contains(match);
	}

	/**
	 * clear search results
	 */
	public void clear() {

		oldelements.clear();
		oldelements.addAll(elements);
		elements.clear();
		newAdditions.clear();
	}

	/**
	 * Notifies the search results that population of the results is complete
	 */
	public void complete() {
		// if the events were not fired for searches that had less
		// than NEW_ADDITIONS_NOTIFICATION_THRESHOLD matches then events
		// are fired at completion
		if (!newAdditions.isEmpty()) {

			fireSearchResultEvent(DeploySearchEvent.ADDED, newAdditions);

			// clear once the events are fired
			newAdditions.clear();
		}

		if (!oldelements.isEmpty()) {
			fireSearchResultEvent(DeploySearchEvent.REMOVED_ALL, oldelements);
		}
	}

	/**
	 * @param eventType
	 */
	private void fireSearchResultEvent(DeploySearchEventType eventType, Collection<Match> matches) {
		DeploySearchEvent event = new DeploySearchEvent(this, eventType);
		event.setMatches(matches);

		for (int i = 0; i < searchResultsListeners.getListeners().length; i++) {
			ISearchResultListener listener = (ISearchResultListener) searchResultsListeners
					.getListeners()[i];
			listener.searchResultChanged(event);
		}
	}

}
