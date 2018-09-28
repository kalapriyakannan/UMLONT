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

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.validator.resolution.Messages;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;

/**
 * Displays two side-by-side {@link TopTreeComposite}s. The left side represents conceptual
 * {@link Unit}s in a topology, the right represents concrete Units.
 * 
 * @since 7.0
 * @see MultiRealizationPopupDialog
 */
public class TwoStacksComposite extends Composite implements RealizationMapperView {

	/**
	 * If <code>true</code> this UI displays configuration units.
	 */
	private final boolean allowConfigUnits = RealizationAssistantResolutionGenerator.allowConfigUnits;

	private List<Unit> sources;

	private final Label labelConceptual;
	private final Label labelTarget;
	private final TopTreeComposite topConceptual;
	private final TopTreeComposite topTarget;
//	private final Label labelInfoConceptual;

	private final RealizationMapHelper mapUtil;
	private ISelectionChangedListener selChangedListener;
	private final Button fuzzy;
	private final Button filterConcrete;
	private final Button filterUnrealConcept;

	/**
	 * @param parent
	 * @param rmu
	 */
	public TwoStacksComposite(Composite parent, RealizationMapHelper rmu) {
		super(parent, SWT.NULL);
		mapUtil = rmu;

		GridLayout gl = new GridLayout(2, true);
		gl.marginHeight = 0;
		gl.verticalSpacing = 0;
		setLayout(gl);
//		setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));

		labelConceptual = new Label(this, SWT.NULL);
		labelConceptual.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		labelConceptual.setText(Messages.TwoStacksComposite_Conceptual_Unit_);

		labelTarget = new Label(this, SWT.NULL);
		labelTarget.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		labelTarget.setText(Messages.TwoStacksComposite_Target_);

		topConceptual = new TopTreeComposite(this);
		GridData gdTable = new GridData(SWT.FILL, SWT.FILL, true, true);
		gdTable.heightHint = 200;
		topConceptual.setLayoutData(gdTable);
		topConceptual.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Unit newSource = topConceptual.getSelection();
				Unit oldSource = mapUtil.setSource(newSource);
				if (oldSource != newSource) {
					refreshTargets();
				}
			}
		});

		topTarget = new TopTreeComposite(this);
		GridData gdTarget = new GridData(SWT.FILL, SWT.FILL, true, true);
		gdTarget.heightHint = 200;
		topTarget.setLayoutData(gdTarget);
		topTarget.setEnablementFunction(new TopTreeComposite.EnablementFunction() {

			@Override
			public boolean isEnabled(Object obj) {
				return mapUtil.getValidTargets().contains(obj);
			}
		});

		topTarget.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Unit newTarget = topTarget.getSelection();
				Unit oldTarget = mapUtil.setTarget(newTarget);
				if (oldTarget != newTarget) {
					enableDisableControls();
				}
			}
		});

//		// spacer
//		labelInfoConceptual = new Label(this, SWT.NULL);
//		GridData gdInfoConceptual = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		labelInfoConceptual.setLayoutData(gdInfoConceptual);

		fuzzy = new Button(this, SWT.CHECK);
		fuzzy.setText(Messages.TwoStacksComposite_Include_invalid_realization_);
		GridData gdInfoConceptual = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		fuzzy.setLayoutData(gdInfoConceptual);
		fuzzy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				changeFuzzy();
			}
		});

		Composite filterControlsComposite = new Composite(this, SWT.NULL);
		filterControlsComposite.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, true));
		filterControlsComposite.setLayout(new GridLayout(2, false));

		filterConcrete = new Button(filterControlsComposite, SWT.RADIO);
		filterConcrete.setText("Concrete"); //$NON-NLS-1$
		filterConcrete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showConcreteOnly();
			}
		});

		filterUnrealConcept = new Button(filterControlsComposite, SWT.RADIO);
		filterUnrealConcept.setText("Concrete or unrealized"); //$NON-NLS-1$
		filterUnrealConcept.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showConcreteOrUnrealized();
			}
		});

		initControls();
	}

	private void changeFuzzy() {
		mapUtil.setFuzzy(fuzzy.getSelection());

		refreshTargets();
//		enableDisableControls();
	}

	private void initControls() {
		List<Unit> allTargets = mapUtil.getUnits();
		filterConcrete.setSelection(true);
		topConceptual.setFilter(new DefaultFilter());
		topTarget.setFilter(new ConcreteFilter());
		topTarget.setInput(allTargets);

		refreshUnrealCount();
		refreshSourceUnits();

		refreshTargets();

		fuzzy.setSelection(mapUtil.isFuzzy());

		enableDisableControls();
	}

	private void refreshTargets() {
//		mapUtil.recalculateUniqueTargets();

		if (mapUtil.getValidTargets().size() == 0) {
			topTarget.clearSelection();
		} else {
			topTarget.setSelection(mapUtil.getValidTargets().iterator().next());
		}

		topTarget.refresh();
		enableDisableControls();
	}

	private void enableDisableControls() {
//		int count = mapUtil.unmappedCount();
//		boolean finished = count == 0;
//		if (finished) {
//			labelInfoConceptual.setText(Messages.TwoStacksComposite_All_mappings_have_been_performe_);
//		} else {
//			if (mapUtil.getZeroTargetConceptuals().size() > 0) {
//				labelInfoConceptual.setText(DeployNLS.bind(
//						Messages.TwoStacksComposite_No_solutions_0_unmappable_Unit_s_, mapUtil
//								.getZeroTargetConceptuals().size()));
////				conceptuals.addAll(zeroTargetConceptuals);
//			} else if (mapUtil.getValidTargets().size() > 0) {
//				labelInfoConceptual.setText(DeployNLS.bind(
//						Messages.TwoStacksComposite_0_suitable_infrastructure_Unit_s_, mapUtil
//								.getValidTargets().size()));
//			} else {
//				labelInfoConceptual.setText(""); //$NON-NLS-1$
//			}
//		}

//		canMapCurrentSelection(mapUtil.unmappedCount() == 0 || mapUtil.canMapSelectedConceptual());
		if (selChangedListener != null) {
			selChangedListener.selectionChanged(null);
		}
	}

	/**
	 * Rank units by how interesting they are when doing mapping. OSes and Servers with hosting or
	 * dependencies come first, then non-configs, then configs, finally units with neither hosting
	 * nor dependency.
	 */
	private List<Unit> rankedUnits(List<Unit> units) {
		Unit[] au = units.toArray(new Unit[0]);
		Arrays.sort(au, new Comparator<Unit>() {

			public int compare(Unit u1, Unit u2) {
				return rank(u1) - rank(u2);
			}

//			public int compare(Object o1, Object o2) {
//				Unit u1 = (Unit) o1;
//				Unit u2 = (Unit) o2;
//				return rank(u1) - rank(u2);
//			}

			private int rank(Unit u) {
//				System.out.println(u);

				if (u.isConfigurationUnit()) {
					return 3;
				}

				int nlinks = links(u);
				// An improvement is to prioritizing OS and Server...  We are in
				// core so can't use domain types, consider measuring hosting tree as an alternate?
//				if ((u instanceof OperatingSystemUnit || u instanceof ServerUnit) && nlinks > 0) {
//					return 1;
//				} else 
				if (nlinks > 0) {
					return 2;
				}

				return 4;
			}

			private int links(Unit u) {
				return TopologyUtil.getImmediateHostingLinksIn(u).size()
						+ TopologyUtil.getImmediateHostingLinksOut(u).size()
						+ TopologyUtil.getImmediateMemberLinksIn(u).size()
						+ TopologyUtil.getImmediateMemberLinksOut(u).size() + deplinks(u);
			}

			@SuppressWarnings("unchecked")
			private int deplinks(Unit u) {
				int count = 0;
				for (Capability cap : (List<Capability>) u.getCapabilities()) {
					count += TopologyUtil.getImmediateDependencyLinksIn(cap).size();
				}
				for (Requirement req : (List<Requirement>) u.getRequirements()) {
					count += TopologyUtil.getImmediateDependencyLinksOut(req, true).size();
				}

				return count;

			}

		});

		return Arrays.asList(au);
	}

	/**
	 * Called to cause the UI to select the current proposal
	 * 
	 * @return true if the currently displayed choice was successfully made
	 */
	public boolean confirmCurrentChoice() {
		// If user clicks 'Next' while there are unmapped items, don't progress
		if (mapUtil.unmappedCount() != 0) {
			if (mapUtil.mapCurrentChoice()) {

				// If there are any more possibilities, set them up.
				if (mapUtil.getRealizationSources().size() > 0) {
					topConceptual.setSelection(mapUtil.getRealizationSources().iterator().next());
				}

				// Mapping succeeded
				return true;
			}
		}

		return false;
	}

	/**
	 * @param selectionChangedListener
	 */
	public void setSelectionChangeListener(ISelectionChangedListener selectionChangedListener) {
		selChangedListener = selectionChangedListener;
	}

	/**
	 * @return <code>true</code> if the currently displayed choice can probably be made without
	 *         error
	 */
	public boolean canConfirmCurrentChoice() {
		return /* mapUtil.unmappedCount() == 0 || */mapUtil.canMapSelectedConceptual();
	}

	public void refreshRealizationLinks() {
		// Does nothing; RealizationsCreatedComposite will handle
	}

	public void selectRealizationLink(RealizationLink realizationLink) {
		// Does nothing; RealizationsCreatedComposite will handle
	}

	public void refreshSourceUnits() {
		List<Unit> conceptuals = new LinkedList<Unit>(mapUtil.getRealizationSources());

		sources = rankedUnits(conceptuals);

		topConceptual.setInput(sources);

		// This lets the user know there is nothing to do.  Perhaps we should indicate
		// this some other way?
//		boolean finished = (conceptuals.size() == 0 && zeroTargetConceptuals.size() == 0);
		boolean finished = sources.size() == 0 && mapUtil.noMoreChoices();
		topTarget.setVisible(!finished);
		labelTarget.setVisible(!finished);
		labelConceptual.setVisible(!finished);
		topConceptual.setVisible(!finished);

//		if (conceptuals.size() > 0) {
//			if (conceptuals.contains(defaultConceptual)) {
//				topConceptual.setSelection(defaultConceptual);
//			} else {
//				topConceptual.setSelection(conceptuals.get(0));
//			}
//		}
	}

	/**
	 * @param src
	 */
	public void setSourceSelection(Unit src) {
		if (sources.size() > 0) {
			if (sources.contains(src)) {
				topConceptual.setSelection(src);
			} else {
				topConceptual.setSelection(sources.get(0));
			}
		}
	}

	public void refreshUnrealCount() {
		// do nothing
	}

	/**
	 * @return controls that shouldn't be colored according to their container
	 */
	public Collection<Control> getBackgroundColorExclusions() {
		List<Control> retVal = new LinkedList<Control>();
		retVal.addAll(topConceptual.getBackgroundColorExclusions());
		retVal.addAll(topTarget.getBackgroundColorExclusions());
		return retVal;
	}

	private void showConcreteOrUnrealized() {
		setFilter(new ConcreteOrUnrealizedFilter());
	}

	private void showConcreteOnly() {
		setFilter(new ConcreteFilter());
	}

	private void setFilter(IObjectFilter<Unit> filt) {
		topTarget.setFilter(filt);
		mapUtil.recalculateUniqueTargets();
		enableDisableControls();
		refreshTargets();
	}

	/**
	 * @param unit
	 * @return <code>true</code> if <code>unit</code> appears in the current targets UI
	 */
	public boolean acceptAsTarget(Unit unit) {
		return topTarget.getFilter().accept(unit);
	}

	private class DefaultFilter implements IObjectFilter<Unit> {
		public boolean accept(Unit u) {
			// If we are showing 'Configuration' Units then we accept everything
			if (allowConfigUnits) {
				return true;
			}

			// We always show non-config units
			if (!u.isConfigurationUnit()) {
				return true;
			}

			// We *could* show some config units and not others.  But which ones?
			// It would be nice to show only those configs the user has to deal with to
			// get a valid topology.  Determining which is difficult.
			return false;
		}
	}

	private class ConcreteOrUnrealizedFilter extends DefaultFilter {

		private boolean unrealized(Unit u) {
			Topology top = u.getEditTopology();
			return top == null || top.getRelationships().getRealizedBy(u).size() == 0;
		}

		public boolean accept(Unit u) {
			return super.accept(u) && (!u.isConceptual() || unrealized(u));
		}

	}

	private class ConcreteFilter extends DefaultFilter {

		public boolean accept(Unit u) {
			return !u.isConceptual() && super.accept(u);
		}

	}

}
