package com.ibm.ccl.soa.deploy.core.ui.internal.search.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.util.EnumeratedType;
import org.eclipse.search.ui.SearchResultEvent;

/**
 * An event object which is being propagated every time a new match is found by the
 * <code>DeploySearchQuery</code>
 */
public class DeploySearchEvent extends SearchResultEvent {

	private static final long serialVersionUID = 7056481352510245799L;

	static class DeploySearchEventType extends EnumeratedType {

		private static final long serialVersionUID = 6733815559099326372L;

		private static DeploySearchEventType[] types;

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ibm.xtools.common.core.util.EnumeratedType#getValues()
		 */
		protected List<DeploySearchEventType> getValues() {
			return Arrays.asList(types);
		}

		protected DeploySearchEventType(String name, int ordinal) {
			super(name, ordinal);
		}

	}

	/**
	 * Constant for a matches being added.
	 * 
	 * @see DeploySearchEvent#getKind()
	 */
	public static final DeploySearchEventType ADDED = new DeploySearchEventType("added", 1); //$NON-NLS-1$

	/**
	 * Constant for a matches being removed.
	 * 
	 * @see DeploySearchEvent#getKind()
	 */
	public static final DeploySearchEventType REMOVED = new DeploySearchEventType("removed", 2); //$NON-NLS-1$

	/**
	 * Constant for all matches being removed.
	 * 
	 * @see DeploySearchEvent#getKind()
	 */
	public static final DeploySearchEventType REMOVED_ALL = new DeploySearchEventType(
			"removed_all", 3); //$NON-NLS-1$

	static {
		DeploySearchEventType.types = new DeploySearchEventType[] { ADDED, REMOVED, REMOVED_ALL };
	}

	private final DeploySearchEventType fKind;

	// an object that was added or removed from the search results
	private final Collection<Match> matches = new ArrayList<Match>(2);

	/**
	 * Constructs a new <code>MatchEvent</code>.
	 * 
	 * @param searchResult
	 *           the search result concerned
	 */
	public DeploySearchEvent(DeploySearchResult searchResult, DeploySearchEventType kind) {
		super(searchResult);
		fKind = kind;
	}

	/**
	 * Tells whether this is a remove or an add.
	 * 
	 * @return one of <code>ADDED</code> or <code>REMOVED</code>
	 */
	public DeploySearchEventType getKind() {
		return fKind;
	}

	/**
	 * Return the matches
	 * 
	 * @return the collection matches
	 */
	public Collection<Match> getMatches() {
		return matches;
	}

	/**
	 * Set matches that were added/removed from the search result
	 * 
	 * @param matches
	 *           the collection of matches
	 */
	public void setMatches(Collection<Match> matches) {
		if (matches != null && !matches.isEmpty()) {
			this.matches.addAll(matches);
		}
	}
}
