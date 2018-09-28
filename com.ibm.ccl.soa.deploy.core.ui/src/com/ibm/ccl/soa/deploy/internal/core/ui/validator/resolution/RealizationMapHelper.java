/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.ui.validator.resolution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.AutoRealizationBookKeeping;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.AutoRealizationControl;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternCacheService;

/**
 * The interactive mapping rules, independent from UI
 * 
 * @since 7.0
 */
public class RealizationMapHelper {

	private final List<RealizationMapperView> views = new LinkedList<RealizationMapperView>();
	private final Topology top;

	private Set<Unit> validTargets;
	private List<Unit> zeroTargetConceptuals;
	private Collection<RealizationLink> proposed;
	private Collection<Map<Unit, Unit>> possibilities;
	private final List<RealizationLink> mappings;
//	private Set<Unit> realizableConceptuals;
	private Set<Unit> realizationSources;
	private Unit currentSourceSelection;
	private Unit currentTargetSelection;
	private final Runner runnableRunner;
	private RealizationPatternCacheService rpcs;
	private final IObjectFilter<Unit> targetFilt;

	private final AutoRealizationControl arc;
	private final AutoRealizationBookKeeping arbk;
	private boolean fuzzy;
	private Unit sourceForProposal;
	private Unit targetForProposal;

	/**
	 * @param topology
	 * @param runner
	 *           wrap a Java Runnable so that long-running processes can signal UI, for example busy
	 *           cursor
	 * @param targetFilter
	 *           method to identify if a target is acceptable to the UI
	 */
	public RealizationMapHelper(Topology topology, Runner runner, IObjectFilter<Unit> targetFilter) {
//		interactiveMapper = mapper;
		runnableRunner = runner;
		top = topology;
		targetFilt = targetFilter;

		arc = new AutoRealizationControl();
		arc.setFindAllSolutions(true);
		arbk = new AutoRealizationBookKeeping();

		mappings = new LinkedList<RealizationLink>();
//		explicitlyAdded = new HashSet<DeployModelObject>();
		validTargets = new HashSet<Unit>();
//		stack = new Stack<List<RealizationLink>>();

		internalSetFuzzy(false);
	}

	// Fill targetConceptual with all units that can be a target of the selected conceptual
	private Set<Unit> calculateUniqueTargets() {

		Set<Unit> uniqueTargets = new HashSet<Unit>();

		if (currentSourceSelection != null) {
			for (Map<Unit, Unit> mapping : getPossibleMappings()) {
				Unit target = mapping.get(currentSourceSelection);
				if (target != null) {
					// Although the mapping might propose a conceptual target I only want concrete ones
					if (targetFilt.accept(target)) {
						uniqueTargets.add(target);
					}
				}
			}
		}

		return uniqueTargets;
	}

	@SuppressWarnings("unchecked")
	protected int unmappedCount() {
		int count = 0;
		for (Iterator<Unit> it = top.findAllPublicUnits(); it.hasNext();) {
			Unit u = it.next();
			if (unrealized(u)) {
				count++;
			}
		}
		return count;
	}

	protected boolean canMapSelectedConceptual() {
//		Unit source = interactiveMapper.getSelectedConceptual();
//		Unit target = interactiveMapper.getSelectedTarget();

		boolean canMap;
		if (currentSourceSelection != null && currentTargetSelection != null) {
			canMap = true;
			newProposed(currentSourceSelection, currentTargetSelection);
		} else {
			canMap = false;
			newProposed(null, null);
		}

		return canMap;
	}

	private Collection<Map<Unit, Unit>> getPossibleMappings() {
		if (possibilities == null) {
			possibilities = calculatePossibleMappings();
		}

		return possibilities;
	}

	@SuppressWarnings("unchecked")
	private Collection<Map<Unit, Unit>> calculatePossibleMappings() {

		Collection<Map<Unit, Unit>> retVal = new HashSet<Map<Unit, Unit>>();

		DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
		for (Iterator<Unit> it = top.findAllPublicUnits(); it.hasNext();) {
			Unit unit = it.next();
			if (unrealized(unit)) {
//				System.out
//						.println("@@@ Calculating mappings for unrealized " + unit.getCaptionProvider().title(unit)); //$NON-NLS-1$
				// Checking if we've already mapped 'unit' as part of another connected
				// set won't buy much because this method is just reading from a cache anyway.
				List<Map<Unit, Unit>> choices = rpcs.realizationMapsConnectedSet(unit, unit
						.getEditTopology(), dvs, null);

//				System.out.println("@@@ Found " + choices.size() + " choices"); //$NON-NLS-1$ //$NON-NLS-2$ 
//				for (Map<Unit, Unit> choice : choices) {
//					dumpMap(choice);
//				}

				retVal.addAll(choices);
			}
		}

		// At this point retVal might be empty because we've already done the realizations
		// that caused us to be a resolution

		return retVal;
	}

//	private void dumpMap(Map<Unit, Unit> map) {
//		System.out.println("MAP"); //$NON-NLS-1$
//		for (Map.Entry<Unit, Unit> me : map.entrySet()) {
//			System.out.print(me.getKey().getCaptionProvider().title(me.getKey()));
//			System.out.print(" --> "); //$NON-NLS-1$
//			System.out.println(me.getValue().getCaptionProvider().title(me.getValue()));
//		}
//
//		System.out.println();
//	}

	private boolean unrealized(Unit unit) {
		return unit.isConceptual() && TopologyUtil.getImmediateRealizationLinksOut(unit).size() == 0;
	}

	private void newProposed(Unit source, Unit target) {
		// the same as last time, because 
		// Don't recalculate identical proposals
		if (source == sourceForProposal && target == targetForProposal) {
			return;
		}

		sourceForProposal = source;
		targetForProposal = target;
		Map<Unit, Unit> implied = calculateRelatedRealizations(source, target);

		if (proposed != null) {
//			System.out.println("@@@ removing from mappings"); //$NON-NLS-1$
			mappings.removeAll(proposed);
		}

		proposed = new LinkedList<RealizationLink>();

		// Make a link, ***but don't actually link source and target***
		if (source != null && target != null) {
			proposed.add(createLink(source, target));
			for (Map.Entry<Unit, Unit> me : implied.entrySet()) {
				proposed.add(createLink(me.getKey(), me.getValue()));
			}

//			System.out.println("@@@ proposing " + proposed); //$NON-NLS-1$
			mappings.addAll(proposed);
		}

		for (RealizationMapperView interactiveMapper : views) {
			interactiveMapper.refreshRealizationLinks();
		}
	}

	private RealizationLink createLink(Unit source, Unit target) {
		RealizationLink rlproposed = CoreFactory.eINSTANCE.createRealizationLink();
		rlproposed.setSource(source);
		rlproposed.setTarget(target);
		return rlproposed;
	}

	/**
	 * @return Map of all single-target realizations after realizing <code>source</code> to
	 *         <code>target</code>
	 */
	private Map<Unit, Unit> calculateRelatedRealizations(Unit source, Unit target) {
		// Calculate mappings that occur in EVERY possible mapping that includes (source->target).
		List<Map<Unit, Unit>> mapsIncludingSrcAndTarget = new LinkedList<Map<Unit, Unit>>();

		for (Map<Unit, Unit> mapping : getPossibleMappings()) {
			if (mapping.get(source) == target) {
				mapsIncludingSrcAndTarget.add(mapping);
			}
		}

		Map<Unit, Unit> retVal = new HashMap<Unit, Unit>();

		if (mapsIncludingSrcAndTarget.size() > 0) {
			// Check for mappings in every Map by finding those entries in the first map
			// that are also in every other map.
			Map<Unit, Unit> first = mapsIncludingSrcAndTarget.remove(0);
			for (Map.Entry<Unit, Unit> me : first.entrySet()) {
				if (me.getKey() != source) { // don't consider the realization to be related to itself
					if (inEveryMap(me.getKey(), me.getValue(), mapsIncludingSrcAndTarget)) {
						retVal.put(me.getKey(), me.getValue());
					}
				}
			}
		}

//		System.out.println("@@@ found " + retVal.entrySet().size() + " related realizations"); //$NON-NLS-1$//$NON-NLS-2$

		return retVal;
	}

	private <K, V> boolean inEveryMap(K key, V value, List<Map<K, V>> maps) {
		for (Map<?, ?> map : maps) {
			if (map.get(key) != value) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @return <code>true</code> on success
	 */
	protected boolean mapCurrentChoice() {
		if (proposed.size() == 0) {
			return false;
		}

		// At this point, 'proposed' contains the units the user wants to map
		// Recreate them using the LinkFactory so they become part of the topology
		List<RealizationLink> newLinks = new LinkedList<RealizationLink>();
		for (RealizationLink rl : proposed) {
			RealizationLink truerl = LinkFactory.createRealizationLink(rl.getSource(), rl.getTarget());
			newLinks.add(truerl);
			mappings.add(truerl);
//			realizableConceptuals.remove(rl.getSource());
			realizationSources.remove(rl.getSource());
		}
		CanonicalUtils.refreshLinks();

		// Dump the old proposed, as we have recreated them
		if (proposed != null) {
//			System.out.println("@@@ removing from mappings/2"); //$NON-NLS-1$
			mappings.removeAll(proposed);
			proposed = null;
		}

		// Refresh the source tree.
		recalculate();

		for (RealizationMapperView interactiveMapper : views) {
			interactiveMapper.refreshRealizationLinks();
			interactiveMapper.refreshUnrealCount();
			interactiveMapper.selectRealizationLink(newLinks.get(0));
			interactiveMapper.refreshSourceUnits();
		}

		return true;
	}

	protected synchronized void recalculate() {

//		System.out.println("Recalculating..."); //$NON-NLS-1$

		// Build the internal data structures used by getResolutions()
		possibilities = null;

//		// Conceptuals that can be realized on something
//		realizableConceptuals = new HashSet<Unit>();

		// Units that have no possibilities
		List<Unit> unmappedConceptuals = allUnmappedConceptuals(top);
		zeroTargetConceptuals = unmappedConceptuals;

		realizationSources = new HashSet<Unit>(unmappedConceptuals);

		runnableRunner.run(new Runnable() {

			public void run() {

//				System.out.println("About to zap cache"); //$NON-NLS-1$
				rpcs = RealizationPatternCacheService.INSTANCE.create(arc, arbk);
				// Enable caching
				rpcs.enterRealizationNavigationCache();
				rpcs.enterRealizationPatternCache();
//				System.out.println("Completed cache zap"); //$NON-NLS-1$

				for (Map<Unit, Unit> mapping : getPossibleMappings()) {
//					System.out
//							.println(NLS.bind("Mapping with {0} entrie(s)", mapping.entrySet().size())); //$NON-NLS-1$
//					dumpUnitUnitMap(mapping);

//					// For the purpose of this wizard, a Unit that is already realized isn't considered realizable.
//					// (The technical definition of realizability now allows a Unit to be multiply-realized, but
//					// we don't want the popup offering that.)
//					realizableConceptuals.addAll(filterOutRealizedUnits(mapping.keySet()));
					zeroTargetConceptuals.removeAll(mapping.keySet());
				}

			}
		});

	}

//	private Collection<Unit> filterOutRealizedUnits(Set<Unit> candidates) {
//		List<Unit> retVal = new LinkedList<Unit>();
//
//		for (Unit candidate : candidates) {
//			if (TopologyUtil.getImmediateRealizationLinksOut(candidate).size() == 0) {
//				retVal.add(candidate);
//			}
//		}
//
//		return retVal;
//	}

	@SuppressWarnings("unchecked")
	private List<Unit> allUnmappedConceptuals(Topology top2) {
		List<Unit> retVal = new LinkedList<Unit>();
		for (Iterator<Unit> it = top.findAllPublicUnits(); it.hasNext();) {
			Unit u = it.next();
			if (unrealized(u)) {
				retVal.add(u);
			}
		}
		return retVal;
	}

	protected List<Unit> getZeroTargetConceptuals() {
		return Collections.unmodifiableList(zeroTargetConceptuals);
	}

	protected Set<Unit> getValidTargets() {
		return Collections.unmodifiableSet(validTargets);
	}

	protected void recalculateUniqueTargets() {
		validTargets = calculateUniqueTargets();
	}

//	protected Set<Unit> getRealizableConceptuals() {
//	return realizableConceptuals;
//}

	protected Set<Unit> getRealizationSources() {
		return realizationSources;
	}

	protected boolean noMoreChoices() {
		return zeroTargetConceptuals.size() == 0;
	}

	@SuppressWarnings("unchecked")
	protected int unmappedConfigUnitCount() {
		int count = 0;
		for (Iterator<Unit> it = top.findAllPublicUnits(); it.hasNext();) {
			Unit u = it.next();
			if (unrealized(u) && u.isConfigurationUnit()) {
				count++;
			}
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	protected List<Unit> getNonConceptuals() {
		List<Unit> retVal = new LinkedList<Unit>();
		for (Iterator<Unit> it = top.findAllPublicUnits(); it.hasNext();) {
			Unit u = it.next();
			if (!u.isConceptual()) {
				retVal.add(u);
			}
		}

		return Collections.unmodifiableList(retVal);
	}

	protected List<RealizationLink> getMappings() {
		return Collections.unmodifiableList(mappings);
	}

	protected Collection<RealizationLink> getProposed() {
		return proposed;
	}

//	protected boolean manuallyAdded(DeployModelObject dmo) {
//		return explicitlyAdded.contains(dmo);
//	}

	protected Unit setSource(Unit selection) {
		Unit oldSource = currentSourceSelection;
		if (currentSourceSelection != selection) {
			currentSourceSelection = selection;
			recalculateUniqueTargets();
		}
		return oldSource;
	}

	protected Unit setTarget(Unit selection) {
		Unit oldTarget = currentTargetSelection;
		currentTargetSelection = selection;
		return oldTarget;
	}

	protected void addView(RealizationMapperView rmv) {
		views.add(rmv);
	}

	/**
	 * @return all Units
	 */
	@SuppressWarnings("unchecked")
	public List<Unit> getUnits() {
		List<Unit> retVal = new LinkedList<Unit>();
		for (Iterator<Unit> it = top.findAllPublicUnits(); it.hasNext();) {
			retVal.add(it.next());
		}

		return Collections.unmodifiableList(retVal);
	}

	/**
	 * Runs a Java runnable.
	 * 
	 * This seems really useful, consider promoting to core.
	 */
	public static interface Runner {

		/**
		 * @param runnable
		 */
		void run(Runnable runnable);
	}

	/**
	 * @return <code>true</code> if configured to ignore constraints and attributes
	 * @see AutoRealizationControl#setFollowStructuralConstraintLinks(boolean)
	 * @see AutoRealizationControl#setStrictAttributeValueMatchMode(boolean)
	 */
	public boolean isFuzzy() {
		return fuzzy;
	}

	/**
	 * @param newFuzzy
	 * @see #isFuzzy()
	 */
	public void setFuzzy(boolean newFuzzy) {
		if (fuzzy == newFuzzy) {
			return;
		}

		internalSetFuzzy(newFuzzy);
	}

	private void internalSetFuzzy(boolean newFuzzy) {
		fuzzy = newFuzzy;
		arc.setStrictAttributeValueMatchMode(!fuzzy);
		arc.setFullyValidateConstraintsInMatchMode(!fuzzy);

		// Forget the units we built the proposal from, the old proposal isn't valid
		sourceForProposal = null;
		targetForProposal = null;

		recalculate();
		recalculateUniqueTargets();
	}

}
