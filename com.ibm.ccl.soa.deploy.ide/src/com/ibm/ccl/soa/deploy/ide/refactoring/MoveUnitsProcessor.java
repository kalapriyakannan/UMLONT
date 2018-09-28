package com.ibm.ccl.soa.deploy.ide.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.MoveArguments;
import org.eclipse.ltk.core.refactoring.participants.MoveProcessor;
import org.eclipse.ltk.core.refactoring.participants.ParticipantManager;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateTopologyDataModelOperation;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.IMoveUnitsModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.ChangeAdapter;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.RefactoringUtils;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CoreCompositeChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateImportChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeleteViewChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveLinkChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveUnitChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateContractVisibilityChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange;
import com.ibm.ccl.soa.deploy.index.search.Query;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class MoveUnitsProcessor extends MoveProcessor {

	public static final String IDENTIFIER = "com.ibm.ccl.soa.deploy.ide.refactoring.moveUnitsProcessor"; //$NON-NLS-1$

	private MoveUnitsRefactoringDescriptor descriptor = null;

	public MoveUnitsProcessor(Collection<Unit> unitsToBeMoved) {
		descriptor = MoveUnitsRefactoringDescriptor.createModel();
		Unit[] units = unitsToBeMoved.toArray(new Unit[unitsToBeMoved.size()]);
		descriptor.setUnits(units);
	}

	public MoveUnitsProcessor(MoveUnitsRefactoringDescriptor model) {
		descriptor = model;
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor monitor,
			CheckConditionsContext context) throws CoreException, OperationCanceledException {
		monitor.beginTask(Messages.MoveUnitsProcessor_Checking_final_conditions_for_move_, 1);
		try {

			RefactoringStatus status = RefactoringStatus.create(descriptor.validateUnits());
			status.merge(RefactoringStatus.create(descriptor.validateTopologyCreationDataModel()));
			status.merge(RefactoringStatus.create(descriptor.validateExistingTopologyFile()));

			if (status.isOK()) {
				List<IEditorPart> sourceEditors = RefactoringUtils.findDirtyEditors(descriptor
						.getSourceTopologyFile());
				for (Iterator<IEditorPart> iter = sourceEditors.iterator(); iter.hasNext();) {
					status.addEntry(new RefactoringStatusEntry(RefactoringStatus.ERROR, NLS.bind(
							Messages.RenameNamespaceProcessor_The_editor_0_contains_unsaved_, iter.next()
									.getTitle())));
				}

				List<IEditorPart> destinationEditors = RefactoringUtils.findDirtyEditors(descriptor
						.getDestinationTopologyFile());
				for (Iterator<IEditorPart> iter = destinationEditors.iterator(); iter.hasNext();) {
					status.addEntry(new RefactoringStatusEntry(RefactoringStatus.ERROR, NLS.bind(
							Messages.RenameNamespaceProcessor_The_editor_0_contains_unsaved_, iter.next()
									.getTitle())));
				}
			}

			return status;
		} finally {
			monitor.done();
		}
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		monitor.beginTask(Messages.MoveUnitsProcessor_Checking_initial_conditions_for_mov_, 1);
		try {

			RefactoringStatus status = RefactoringStatus.create(descriptor.validateUnits());
			status.merge(RefactoringStatus.create(descriptor.validatePreserveLinks()));

			return status;
		} finally {
			monitor.done();
		}
	}

	private void fluffDescriptor() {
		descriptor.setProject(descriptor.getSourceTopologyFile().getProject().getName());
		descriptor.setDescription("Move unit" //$NON-NLS-1$
				+ (descriptor.getUnits().length > 1 ? "s" : new String()) + " to " //$NON-NLS-1$ //$NON-NLS-2$
				+ descriptor.getDestinationTopologyFile().getName() + "."); //$NON-NLS-1$
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < descriptor.getUnits().length; i++) {
			if (i > 0) {
				buf.append(", "); //$NON-NLS-1$
			}
			buf.append(descriptor.getUnits()[i].getName());
		}
		descriptor.setComment("Move units " + buf.toString() + " to " //$NON-NLS-1$ //$NON-NLS-2$
				+ descriptor.getDestinationTopologyFile().getName());
		descriptor.setFlags(RefactoringDescriptor.STRUCTURAL_CHANGE
				| RefactoringDescriptor.MULTI_CHANGE | RefactoringDescriptor.BREAKING_CHANGE);
	}

	@Override
	public Change createChange(IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		monitor.beginTask("", 1); //$NON-NLS-1$

		fluffDescriptor();

		CoreCompositeChange changes = new CoreCompositeChange(
				Messages.MoveUnitsProcessor_Move_Units_Refactoring_Change_);
		changes.setRefactoringDescriptor(descriptor);
		changes.generateUniqueNames(descriptor.getDestinationTopology(), descriptor.getUnits());

		try {

			Topology source = descriptor.getSourceTopology();
			Topology destination = descriptor.getDestinationTopology();
			IFile destinationFile = descriptor.getDestinationTopologyFile();
			boolean destinationIsPublicEditable = false;

			// create new topology model and default diagram if needed
			if (null == destination) {
				CreateTopologyDataModelOperation op = (CreateTopologyDataModelOperation) descriptor
						.getTopologyCreationDataModel().createConfiguredOperation();
				IPath newTopologyPath = destinationFile.getFullPath();
				IPath newDiagramPath = newTopologyPath.removeFileExtension().addFileExtension(
						IConstants.TOPOLOGYV_EXTENSION);
				op.setLabel(NLS.bind(Messages.MoveUnitsProcessor_create_new_topology_model_0_,
						newTopologyPath.lastSegment()));

				ChangeAdapter createTopologyChange = new ChangeAdapter(op, new Object[] { descriptor
						.getTopologyCreationDataModel().getTopologyFile() },
						ChangeAdapter.Operation.EXECUTE);
				changes.add(createTopologyChange);

				CreateDiagramChange createDiagram = CreateDiagramChange.createModel();
				createDiagram.setModel(newTopologyPath);
				createDiagram.setDiagram(newDiagramPath);
				changes.add(createDiagram);
				destinationIsPublicEditable = descriptor.getTopologyCreationDataModel()
						.getContractType().equals("Make All Units Public-Editable By Default"); //$NON-NLS-1$
			} else {
				destinationIsPublicEditable = destination.getConfigurationContract().getDefaultPolicy()
						.getValue() == Visibility.PUBLIC_EDITABLE_LITERAL.getValue();
			}

			List<DeployLink> affectedLinks = new ArrayList<DeployLink>();
			// iterate over all the links that are contained in the source topology
			for (Iterator<DeployLink> iter = source.findAllDeployLinks(); iter.hasNext();) {
				DeployLink link = iter.next();
				boolean affected = createRequiredChanges(changes, link);
				if (affected && !affectedLinks.contains(link)) {
					affectedLinks.add(link);
				}
			}

			// find topologies that import the source topology and who contain links that
			// point to one of the units to be moved; 
			for (int i = 0; i < descriptor.getUnits().length; i++) {

				Unit unit = descriptor.getUnits()[i];
				Collection<URI> results = findDeployLinksBySourceOrTarget(unit, monitor);
				for (Iterator<URI> iter = results.iterator(); iter.hasNext();) {
					URI uri = iter.next();
					Topology topology = descriptor.getTopology(WorkbenchResourceHelper
							.getPlatformFile(uri));
					DeployModelObject dmo = topology.resolve(uri.fragment());
					createRequiredChanges(changes, (DeployLink) dmo);
				}

			}

			// create move unit changes for each unit to be moved
			for (int i = 0; i < descriptor.getUnits().length; i++) {
				Unit unit = descriptor.getUnits()[i];
				URI sourceUri = unit.eResource().getURI().appendFragment(
						unit.eResource().getURIFragment(unit));
				URI targetUri = URI.createPlatformResourceURI(destinationFile.getFullPath().toString())
						.appendFragment(IConstants.PATH_SEPARATOR + changes.getUniqueName(unit));

				CompositeChange unitChanges = new CompositeChange(NLS.bind(
						Messages.MoveUnitsProcessor_unit_0_, unit.getFullPath()));

				MoveUnitChange moveUnit = MoveUnitChange.createModel();
				moveUnit.setSource(sourceUri);
				moveUnit.setDestination(targetUri);

				unitChanges.add(moveUnit);

				if (!destinationIsPublicEditable) {
					UpdateContractVisibilityChange visibility = UpdateContractVisibilityChange
							.createModel();
					visibility.setDmo(moveUnit.getDestination());
					visibility.setContractFlag(UpdateContractVisibilityChange.PUBLIC_EDITABLE_FLAG);
					unitChanges.add(visibility);
				}

				changes.add(unitChanges);

				// create delete view changes
				Collection<URI> views = Query.findReferencingDiagramViews(unit, null, true, false,
						true, false, monitor);
				for (Iterator<URI> iter = views.iterator(); iter.hasNext();) {
					URI uri = iter.next();

					CompositeChange viewChanges = new CompositeChange(NLS.bind(
							Messages.MoveUnitsProcessor_view_0_, uri.fragment()));

					DeleteViewChange deleteView = DeleteViewChange.createModel();
					deleteView.setView(uri);

					viewChanges.add(deleteView);

					changes.add(viewChanges);
				}
			}

			for (Iterator<DeployLink> iter = affectedLinks.iterator(); iter.hasNext();) {

				LinkDescriptor ld = new LinkDescriptor(iter.next());
				boolean sourceWillBeMoved = willBeMoved(ld.getSourceUnit());
				boolean targetWillBeMoved = willBeMoved(ld.getTargetUnit());

				if (!sourceWillBeMoved) {
					ConfigurationContract contract = ld.getSourceUnit().getEditTopology()
							.getConfigurationContract();
					if (!contract.isPublicEditable(ld.getSourceUnit())) {
						CompositeChange unitChanges = new CompositeChange(NLS.bind(
								Messages.MoveUnitsProcessor_unit_0_, ld.getSourceUnit().getFullPath()));
						UpdateContractVisibilityChange visibility = UpdateContractVisibilityChange
								.createModel();
						visibility.setDmo(EcoreUtil.getURI(ld.getSourceUnit()));
						visibility.setContractFlag(UpdateContractVisibilityChange.PUBLIC_EDITABLE_FLAG);
						unitChanges.add(visibility);
						changes.add(unitChanges);
					}
				}

				if (!targetWillBeMoved) {
					ConfigurationContract contract = ld.getTargetUnit().getEditTopology()
							.getConfigurationContract();
					if (!contract.isPublicEditable(ld.getTargetUnit())) {
						CompositeChange unitChanges = new CompositeChange(NLS.bind(
								Messages.MoveUnitsProcessor_unit_0_, ld.getTargetUnit().getFullPath()));
						UpdateContractVisibilityChange visibility = UpdateContractVisibilityChange
								.createModel();
						visibility.setDmo(EcoreUtil.getURI(ld.getTargetUnit()));
						visibility.setContractFlag(UpdateContractVisibilityChange.PUBLIC_EDITABLE_FLAG);
						unitChanges.add(visibility);
						changes.add(unitChanges);
					}
				}
			}

		} finally {
			monitor.done();
		}

		return changes;
	}

	/**
	 * <p>
	 * This method determines what, if any, changes will be made to the passed in link in order to
	 * preserve the link post the move units refactoring. There are several parameters that play a
	 * part in the decision of how to preserve the link, but the possible end results are very
	 * finite. This methods makes the following assumptions:
	 * <ul>
	 * <li>A link between two units in different topologies is allowed as long as one topology
	 * imports the other and the unit that the link points to from the imported topology has a
	 * contract of public-editable.</li>
	 * <li>All of the moved units must exist in the same topology ( the source topology ).</li>
	 * <li>The destination of the move refactoring can only be a single topology ( the destination
	 * topology ).</li>
	 * <li>An imported unit in a topology can never be moved, it can however be moved when it's
	 * topology is the same as the source topology of the move refactoring.</li>
	 * <li>The DeployLink is not null. ( will handle in safe manner if it is)</li>
	 * <li>The CoreCompositeChange is not null. ( will throw NullPointerException if null )</li>
	 * <li>The link's topology is may not be the same as the source topology.</li>
	 * <li>The link.getTopology() == link.getEditTopology() ( the link is not a proxy object )</li>
	 * </ul>
	 * With those assumptions in mind, the following are the criteria used to determine the optimal
	 * placement and configuration of a link that will be effected by the move units refactoring.
	 * </p>
	 * 
	 * <li>Neither side of the link will be moved:
	 * <ol>
	 * Do nothing.
	 * </ol>
	 * <li>Both sides of the link will be moved:
	 * <ol>
	 * Move the link to the destination topology.
	 * </ol>
	 * <li>One side of the link will be moved but not the other side:
	 * <ol>
	 * <li>If neither side of the link is imported prior to the move and neither the source or
	 * destination topology imports each other:
	 * <ul>
	 * <li>The link will be moved to either the destination or the source topology depending on the
	 * setting in the MoveUnitsRefactoringDescriptor.PreserveLinks property.</li>
	 * <li>An import of the other topology will be created in the topology where the link will be
	 * moved to.</li>
	 * </ul>
	 * <li>If neither side of the link is imported prior to the move and either the source or the
	 * destination topology already imports the other:
	 * <ul>
	 * <li>The link will be created in the topology that already imports the other.</li>
	 * <li>The side of the link that refers to the imported unit will need to be updated to use an
	 * import formated uri '%qualified.topology.name%:%/full/path/of/endpoint%'</li>
	 * <li>An update to the imported unit's contract may be necessary if it is not already set to
	 * 'public-editable'.</li>
	 * </ul>
	 * <li>If the side of the link that is not being moved is an import already and the destination
	 * topology of the move is the same as the imported unit's topology:
	 * <ul>
	 * <li>The link will be moved to the destination topology.</li>
	 * <li>The previously imported side of the link will be updated to be a local format
	 * '%/full/path/of/endpoint%'.</li>
	 * </ul>
	 * <li>If the side of the link that is not being moved is an import already and the destination
	 * topology of the move is not the same as the imported unit's topology and the link's topology
	 * is not the same as the source topology of the move:
	 * <ul>
	 * <li>The link will remain in it's topology.</li>
	 * <li>An import will be created in the link's topology for the destination topology.</li>
	 * <li>The side of the link that refers to the moved unit will need to be updated to use an
	 * import formated uri '%qualified.topology.name%:%/full/path/of/endpoint%'.</li>
	 * <li>An update to the imported unit's contract may be necessary if it is not already set to
	 * 'public-editable'.</li>
	 * </ul>
	 * <li>If either side of the link is imported and the destination topology is not the same as
	 * either of the imported topologies:
	 * <ul>
	 * <li>The link will remain in the source topology.</li>
	 * <li>The link will be updated so that the side pointing to the moved unit will use an import
	 * formated uri '%qualified.topology.name%:/full/path/of/endpoint%'.</li>
	 * <li>An import will be created in the source topology for the destination topology.</li>
	 * <li>An update to the moved unit's contract may be necessary if it is not already set to
	 * 'public-editable'.</li>
	 * </ul>
	 * </li>
	 * 
	 * @param changes
	 *           an instance of {@link CoreCompositeChange} that is used to collect all of the
	 *           {@link Change} objects that the refactoring will need to perform.
	 * @param link
	 *           an instance of {@link DeployLink} that might be affected by the move units
	 *           refactoring.
	 * @return boolean indicates if changes were necessary for the given DeployLink
	 */
	private boolean createRequiredChanges(CoreCompositeChange changes, DeployLink link) {

		if (null == link || !link.getEditTopology().equals(link.getTopology())) {
			return false;
		}

		LinkDescriptor ld = new LinkDescriptor(link);

		IPath source = ld.getSourceFile().getFullPath();
		IPath target = ld.getTargetFile().getFullPath();
		IPath destination = descriptor.getDestinationTopologyFile().getFullPath();

		boolean sourceWillBeMoved = willBeMoved(ld.getSourceUnit());
		boolean targetWillBeMoved = willBeMoved(ld.getTargetUnit());

		if (!sourceWillBeMoved && !targetWillBeMoved) {
			// no point in continuing
			return false;
		}

		boolean sourceImportsDestination = changes.getImportTracker().hasImport(source, destination);
		boolean targetImportsDestination = changes.getImportTracker().hasImport(target, destination);
		boolean destinationImportsSource = changes.getImportTracker().hasImport(destination, source);
		boolean destinationImportsTarget = changes.getImportTracker().hasImport(destination, target);
		boolean sourceImportsTarget = changes.getImportTracker().hasImport(source, target);
		boolean targetImportsSource = changes.getImportTracker().hasImport(target, source);
		boolean sourceIsImported = link.getSourceURI().startsWith(
				new String() + IConstants.PATH_SEPARATOR) ? false : true;
		boolean targetIsImported = link.getTargetURI().startsWith(
				new String() + IConstants.PATH_SEPARATOR) ? false : true;
		boolean linkTopologyImportsOrigin = changes.getImportTracker().hasImport(link.getTopology(),
				descriptor.getSourceTopology());
		boolean linkTopologyImportsDestination = changes.getImportTracker().hasImport(
				link.getTopology(), descriptor.getDestinationTopology());

		boolean createImportsInSource = descriptor.getPreserveLinks().equals(
				IMoveUnitsModelProperties.PRESERVE_LINKS_IN_SOURCE);

		if (sourceWillBeMoved && targetWillBeMoved || sourceWillBeMoved
				&& ld.getTargetTopology().equals(descriptor.getQualifiedDestinationName())
				|| targetWillBeMoved
				&& ld.getSourceTopology().equals(descriptor.getQualifiedDestinationName())) {
			// simplest case, both endpoints are moving to destination

			// move link to destination file
			ld.setLinkFile(descriptor.getDestinationTopologyFile());

			// generate a unique name for the link
			ld.setLinkUriFragment(changes.generateUniqueName(descriptor.getDestinationTopology(), ld
					.getOriginalLink()));

			// set the imported flag for the source endpoint of the ld to false
			ld.setSourceImported(false);

			if (sourceWillBeMoved) {
				// set sourceUri of ld to use new unique name for unit in destination
				ld.setSourceUri(IConstants.PATH_SEPARATOR + changes.getUniqueName(ld.getSourceUnit())
						+ ld.getSourceUri().substring(ld.getSourceUnit().getName().length() + 1));
			}

			// set the imported flag for the target endpoint of the ld to false
			ld.setTargetImported(false);

			if (targetWillBeMoved) {
				// set targetUri of ld to use new unique name for unit in destination
				ld.setTargetUri(IConstants.PATH_SEPARATOR + changes.getUniqueName(ld.getTargetUnit())
						+ ld.getTargetUri().substring(ld.getTargetUnit().getName().length() + 1));
			}

			// compute changes and add them to our changes object
			applyLinkChanges(ld, changes);

			return true;
		}

		if (sourceWillBeMoved || targetWillBeMoved) {
			// at this point we know that either the source or the target will end up in the
			// destination topology but not both, that case was handled above

			if (sourceWillBeMoved && targetImportsDestination || sourceWillBeMoved
					&& targetImportsSource && !destinationImportsTarget) {
				// link will go into target and source will be an import

				// move link to target file
				ld.setLinkFile(ld.getTargetFile());

				// generate a unique name for the link
				ld.setLinkUriFragment(changes.generateUniqueName(descriptor.getTopology(ld
						.getTargetFile()), ld.getOriginalLink()));

				// set flag to indicate that source should be imported
				ld.setSourceImported(true);

				// set the qualified name for the source endpoint of the ld
				ld.setSourceTopology(descriptor.getQualifiedDestinationName());

				// set the source file for the ld
				ld.setSourceFile(descriptor.getDestinationTopologyFile());

				// set sourceUri of ld to use new unique name for unit in destination
				ld.setSourceUri(IConstants.PATH_SEPARATOR + changes.getUniqueName(ld.getSourceUnit())
						+ ld.getSourceUri().substring(ld.getSourceUnit().getName().length() + 1));

				// set flag to indicate if target should be imported or not
				ld.setTargetImported(!ld.getTargetUnit().getTopology().getQualifiedName().equals(
						descriptor.getTopology(ld.getTargetFile()).getQualifiedName()));

				applyLinkChanges(ld, changes);

				return true;
			}

			if (targetWillBeMoved && sourceImportsDestination || targetWillBeMoved
					&& sourceImportsTarget && !destinationImportsSource || targetWillBeMoved
					&& !sourceImportsTarget && !destinationImportsSource && !targetImportsSource
					&& createImportsInSource && !linkTopologyImportsOrigin
					&& !linkTopologyImportsDestination) {
				// link will go into source and target will be an import

				// move link to source file
				ld.setLinkFile(ld.getSourceFile());

				// generate a unique name for the link
				ld.setLinkUriFragment(changes.generateUniqueName(descriptor.getTopology(ld
						.getSourceFile()), ld.getOriginalLink()));

				// set the qualified name for the target endpoint of the ld
				ld.setTargetTopology(descriptor.getQualifiedDestinationName());

				// set flag to indicate that target should be imported
				ld.setTargetImported(true);

				// set the target file for the ld
				ld.setTargetFile(descriptor.getDestinationTopologyFile());

				// set targetUri of ld to use new unique name for unit in destination
				ld.setTargetUri(IConstants.PATH_SEPARATOR + changes.getUniqueName(ld.getTargetUnit())
						+ ld.getTargetUri().substring(ld.getTargetUnit().getName().length() + 1));

				// set flag to indicate if source should be imported or not
				ld.setSourceImported(!ld.getSourceUnit().getTopology().getQualifiedName().equals(
						descriptor.getTopology(ld.getSourceFile()).getQualifiedName()));

				applyLinkChanges(ld, changes);

				return true;
			}

			if (sourceWillBeMoved && targetImportsSource && destinationImportsTarget
					|| sourceWillBeMoved && sourceImportsTarget && destinationImportsTarget
					|| sourceWillBeMoved && !sourceImportsTarget && destinationImportsTarget
					|| sourceWillBeMoved && !sourceImportsTarget && !destinationImportsTarget
					&& !createImportsInSource && !linkTopologyImportsOrigin
					&& !linkTopologyImportsDestination) {
				// link will go into destination and target will be an import

				// move link to destination file
				ld.setLinkFile(descriptor.getDestinationTopologyFile());

				// generate a unique name for the link
				ld.setLinkUriFragment(changes.generateUniqueName(descriptor.getTopology(descriptor
						.getDestinationTopologyFile()), ld.getOriginalLink()));

				// set flag to indicate that target should be imported
				ld.setTargetImported(true);

				if (!ld.getTargetUnit().getTopology().equals(ld.getTargetUnit().getEditTopology())) {
					// this is a proxied dmo ( imported ), we need to find the dmo's actual topology file
					ld.setTargetFile(ResourcesPlugin.getWorkspace().getRoot().getFile(
							new Path(ld.getTargetUnit().getTopology().eResource().getURI()
									.toPlatformString(true))));
				}

				// set flag to indicate if source should be imported or not
				ld.setSourceImported(false);

				// set sourceUri of ld to use new unique name for unit in destination
				ld.setSourceUri(IConstants.PATH_SEPARATOR + changes.getUniqueName(ld.getSourceUnit())
						+ ld.getSourceUri().substring(ld.getSourceUnit().getName().length() + 1));

				applyLinkChanges(ld, changes);

				return true;
			}

			if (targetWillBeMoved && sourceImportsTarget && destinationImportsSource
					|| targetWillBeMoved && targetImportsSource && destinationImportsSource
					|| targetWillBeMoved && !targetImportsSource && destinationImportsSource
					|| targetWillBeMoved && !createImportsInSource && !linkTopologyImportsOrigin
					&& !linkTopologyImportsDestination) {
				// link will go into destination and source will be an import

				// move link to destination file
				ld.setLinkFile(descriptor.getDestinationTopologyFile());

				// generate a unique name for the link
				ld.setLinkUriFragment(changes.generateUniqueName(descriptor.getTopology(descriptor
						.getDestinationTopologyFile()), ld.getOriginalLink()));

				// set flag to indicate that source should be imported
				ld.setSourceImported(true);

				// set flag to indicate that target should not be imported
				ld.setTargetImported(false);

				// set the targetFile on the ld
				ld.setTargetFile(descriptor.getDestinationTopologyFile());

				// set targetUri of ld to use new unique name for unit in destination
				ld.setTargetUri(IConstants.PATH_SEPARATOR + changes.getUniqueName(ld.getTargetUnit())
						+ ld.getTargetUri().substring(ld.getTargetUnit().getName().length() + 1));

				applyLinkChanges(ld, changes);

				return true;
			}

			if (sourceWillBeMoved && targetIsImported && linkTopologyImportsOrigin
					|| sourceWillBeMoved && targetIsImported && linkTopologyImportsDestination
					|| sourceWillBeMoved && sourceIsImported && linkTopologyImportsOrigin) {
				// link will remain in it's topology and source will be an import

				// move link to top-level of it's topology
				ld.setLinkFile(ld.getLinkFile());

				// generate a unique name for the link
				ld.setLinkUriFragment(changes.generateUniqueName(link.getTopology(), link));

				// set flag to indicate that source should be imported
				ld.setSourceImported(true);

				// set the sourceFile on the ld
				ld.setSourceFile(descriptor.getDestinationTopologyFile());

				// set sourceUri of ld to use new unique name for unit in destination
				ld.setSourceUri(IConstants.PATH_SEPARATOR + changes.getUniqueName(ld.getSourceUnit())
						+ ld.getSourceUri().substring(ld.getSourceUnit().getName().length() + 1));

				applyLinkChanges(ld, changes);

				return true;
			}

			if (targetWillBeMoved && sourceIsImported && linkTopologyImportsOrigin
					|| targetWillBeMoved && sourceIsImported && linkTopologyImportsDestination
					|| targetWillBeMoved && targetIsImported && linkTopologyImportsOrigin) {
				// link will remain in it's topology and target will be an import

				// move link to top-level of it's topology
				ld.setLinkFile(ld.getLinkFile());

				// generate a unique name for the link
				ld.setLinkUriFragment(changes.generateUniqueName(link.getTopology(), link));

				// set flag to indicate that target should be imported
				ld.setTargetImported(true);

				// set the targetFile on the ld
				ld.setTargetFile(descriptor.getDestinationTopologyFile());

				// set targetUri of ld to use new unique name for unit in destination
				ld.setTargetUri(IConstants.PATH_SEPARATOR + changes.getUniqueName(ld.getTargetUnit())
						+ ld.getTargetUri().substring(ld.getTargetUnit().getName().length() + 1));

				applyLinkChanges(ld, changes);

				return true;
			}

			if (sourceWillBeMoved && createImportsInSource) {
				// link will go into source and source will be an import

				// move link to source file
				ld.setLinkFile(ld.getSourceFile());

				// generate a unique name for the link
				ld.setLinkUriFragment(changes.generateUniqueName(descriptor.getTopology(ld
						.getSourceFile()), ld.getOriginalLink()));

				// set the qualified name for the source endpoint of the ld
				ld.setSourceTopology(descriptor.getQualifiedDestinationName());

				// set flag to indicate that source should be imported
				ld.setSourceImported(true);

				// set the sourceFile on the ld
				ld.setSourceFile(descriptor.getDestinationTopologyFile());

				// set sourceUri of ld to use new unique name for unit in destination
				ld.setSourceUri(IConstants.PATH_SEPARATOR + changes.getUniqueName(ld.getSourceUnit())
						+ ld.getSourceUri().substring(ld.getSourceUnit().getName().length() + 1));

				// set flag to indicate if target is imported
				ld.setTargetImported(!ld.getTargetUnit().getTopology().getQualifiedName().equals(
						descriptor.getTopology(ld.getTargetFile()).getQualifiedName()));

				applyLinkChanges(ld, changes);

				return true;
			}
		}

		return false;

	}

	@Override
	public Object[] getElements() {
		return descriptor.getUnits();
	}

	@Override
	public String getIdentifier() {
		return IDENTIFIER;
	}

	@Override
	public String getProcessorName() {
		return Messages.MoveUnitsProcessor_Move_Unit_;
	}

	@Override
	public boolean isApplicable() throws CoreException {

		if (descriptor.validateUnits().isOK()) {
			return true;
		}

		return false;
	}

	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
			SharableParticipants sharedParticipants) throws CoreException {

		IFile aTopologyFile = descriptor.getUseExistingTopology() ? (IFile) ResourcesPlugin
				.getWorkspace().getRoot().findMember(new Path(descriptor.getExistingTopologyFile()))
				: descriptor.getTopologyCreationDataModel().getTopologyFile();
		return ParticipantManager.loadMoveParticipants(status, this, descriptor.getUnits(),
				new MoveArguments(aTopologyFile, true), WorkbenchResourceHelper.getFile(
						descriptor.getUnits()[0].eResource()).getProject().getDescription()
						.getNatureIds(), sharedParticipants);
	}

	public MoveUnitsRefactoringDescriptor getDataModel() {
		return descriptor;
	}

	private Collection<URI> findDeployLinksBySourceOrTarget(Unit unit, IProgressMonitor monitor)
			throws CoreException {
		Collection<URI> results = new ArrayList<URI>();

		results.addAll(Query.findDeployLinksByImportedTarget(unit, null, true, false, true, false,
				monitor));
		results.addAll(Query.findDeployLinksByImportedSource(unit, null, true, false, true, false,
				monitor));
		return results;
	}

	/**
	 * Given a Unit this methods tests to see if it is one of the units that will be moving during
	 * this move refactoring processess.
	 * 
	 * @param unit
	 * @return
	 */
	public boolean willBeMoved(Unit unit) {
		for (Iterator<Unit> iter = Arrays.asList(descriptor.getUnits()).iterator(); iter.hasNext();) {
			Unit toBeMoved = iter.next();
			if (toBeMoved.getTopology().getQualifiedName().equals(
					unit.getTopology().getQualifiedName())
					&& toBeMoved.getName().equals(unit.getName())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Given the information supplied via the set methods in this class, this method will build a
	 * CompositeChange for the passed in link. The changes are automatically added to the
	 * CoreCompositeChange object passed at the IPath that corresponds to the IFile of the resource
	 * that contains the original link dmo.
	 * 
	 * @param changes
	 * @return
	 */
	public void applyLinkChanges(LinkDescriptor link, CoreCompositeChange changes) {

		if (link.isSourceImported()
				&& !changes.getImportTracker().hasImport(link.getLinkFile().getFullPath(),
						link.getSourceFile().getFullPath())) {
			// this means that we need to create an import of the source file in the link file
			CreateImportChange createImport = CreateImportChange.createModel();
			createImport.setImported(link.getSourceFile().getFullPath());
			createImport.setImports(link.getLinkFile().getFullPath());
//			CreateImportChange change = new CreateImportChange(link.getLinkFile().getFullPath(), link
//					.getSourceFile().getFullPath());

			changes.add(createImport);
//			changes.add(change);
		}

		if (link.isTargetImported()
				&& !changes.getImportTracker().hasImport(link.getLinkFile().getFullPath(),
						link.getTargetFile().getFullPath())) {
			// this means that we need to create an import of the target file in the link file
			CreateImportChange createImport = CreateImportChange.createModel();
			createImport.setImported(link.getTargetFile().getFullPath());
			createImport.setImports(link.getLinkFile().getFullPath());
//			CreateImportChange change = new CreateImportChange(link.getLinkFile().getFullPath(), link
//					.getTargetFile().getFullPath());

			changes.add(createImport);
//			changes.add(change);
		}

		CompositeChange linkChanges = new CompositeChange(NLS.bind(Messages.LinkDescriptor_link_0_,
				link.getOriginalLink().getFullPath()));

		if (!link.getLinkUri().equals(link.getUri(link.getOriginalLink()))) {
			// this means were moving this link
			MoveLinkChange moveLink = MoveLinkChange.createModel();
			moveLink.setSource(link.getUri(link.getOriginalLink()));
			moveLink.setDestination(link.getLinkUri());
//			MoveLinkChange move = new MoveLinkChange(link.getUri(link.getOriginalLink()), link
//					.getLinkUri());

			linkChanges.add(moveLink);
//			linkChanges.add(move);
		}

		if (!link.getOriginalLink().getSourceURI().equals(link.getQualifiedSourceUri())) {
			// this means that were updating the sourceUri of the link
			UpdateLinkChange updateLink = UpdateLinkChange.createModel();
			updateLink.setLink(link.getLinkUri());
			updateLink.setSource(link.getOriginalLink().getSourceURI());
			updateLink.setDestination(link.getQualifiedSourceUri());
			updateLink.setEndpoint(UpdateLinkChange.SOURCE);
//			UpdateLinkChange update = new UpdateLinkChange(link.getLinkUri(), link.getOriginalLink()
//					.getSourceURI(), link.getQualifiedSourceUri(), UpdateLinkChange.EndPoint.SOURCE);

			linkChanges.add(updateLink);
//			linkChanges.add(update);
		}

		if (!link.getOriginalLink().getTargetURI().equals(link.getQualifiedTargetUri())) {
			// this means that were updating the targetUri of the link
			UpdateLinkChange updateLink = UpdateLinkChange.createModel();
			updateLink.setLink(link.getLinkUri());
			updateLink.setSource(link.getOriginalLink().getTargetURI());
			updateLink.setDestination(link.getQualifiedTargetUri());
			updateLink.setEndpoint(UpdateLinkChange.TARGET);
//			UpdateLinkChange update = new UpdateLinkChange(link.getLinkUri(), link.getOriginalLink()
//					.getTargetURI(), link.getQualifiedTargetUri(), UpdateLinkChange.EndPoint.TARGET);

			linkChanges.add(updateLink);
//			linkChanges.add(update);
		}

		changes.add(linkChanges);
	}

	private IFile getFile(DeployModelObject obj) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(obj.getEditTopology().eResource().getURI().toPlatformString(true)));
	}

	/**
	 * Simple state machine to manage the many variables that come into play when deciding on where a
	 * link should be moved and which endpoints need to be updated.
	 * 
	 * @since 7.0
	 * 
	 */
	private class LinkDescriptor {

		private DeployLink link;
		private DeployModelObject source = null;
		private DeployModelObject target = null;
		private IFile sourceFile = null;
		private IFile targetFile = null;
		private IFile linkFile = null;
		private String sourceUri = null;
		private String targetUri = null;
		private String linkUriFragment = null;
		private boolean sourceImported = false;
		private boolean targetImported = false;
		private String sourceTopology = null;
		private String targetTopology = null;

		/**
		 * Populates this class with 'default' values based on the values found in the DeployLink. Any
		 * calls to set* methods in this class will not change the DeployLink that was passed in with
		 * the constructor. The original link can be retrieved by calling getOriginalLink().
		 * 
		 * 
		 * @param link
		 */
		public LinkDescriptor(DeployLink link) {
			this.setLink(link);
		}

		/**
		 * Return the parent child name path from the root of the topology for the specific
		 * DeployModelObject that is it's target. If the sourceURI of the link points to an imported
		 * DMO this method will still only return the path portion. If you need the entire path
		 * including the fully qualified topology name + path then call getQualifiedSourceUri().
		 * 
		 * @return
		 */
		public String getSourceUri() {
			return sourceUri;
		}

		/**
		 * Returns the fully qualified path for the sourceUri of this link. If the source is set to
		 * not be imported then this moethod will return the same value as getSourceUri.
		 * 
		 * @return
		 */
		public String getQualifiedSourceUri() {
			String uri = sourceUri;
			if (sourceImported) {
				uri = getSourceTopology() + IConstants.TOPOLOGY_SEPARATOR + uri;
			}
			return uri;
		}

		/**
		 * Sets the source of this link and populates the overriding values over the DeployLink that
		 * was used when the class was constructed.
		 * 
		 * @param obj
		 */
		public void setSource(DeployModelObject obj) {
			source = obj;
			sourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(obj.getEditTopology().eResource().getURI().toPlatformString(true)));
			sourceTopology = obj.getTopology().getQualifiedName();
			sourceImported = !obj.getTopology().equals(obj.getEditTopology());
			if (sourceImported) {
				sourceUri = source.getFullPath().substring(sourceTopology.length() + 1);
			} else {
				sourceUri = source.getFullPath();
			}
		}

		/**
		 * Set's the value of the soureURI of this link.
		 * 
		 * @param sourceUri
		 */
		public void setSourceUri(String sourceUri) {
			this.sourceUri = sourceUri;
		}

		/**
		 * Returns the IFile that represents the resource where the DeployModelObject resides. Note
		 * that this is not necessarily the source dmo's topology. The source dmo of this link could
		 * possibly be a proxy b/c it represents an imported dmo in another topology.
		 * 
		 * @return
		 */
		public IFile getSourceFile() {
			return sourceFile;
		}

		/**
		 * Sets the value of the IFile to which the dmo for the sourcURI can be resolved using the
		 * getQualifiedSourceUri().
		 * 
		 * @param sourceFile
		 */
		public void setSourceFile(IFile sourceFile) {
			this.sourceFile = sourceFile;
			Topology topology = descriptor.getTopology(sourceFile);
			if (topology != null) {
				setSourceTopology(topology.getQualifiedName());
			} else {
				setSourceTopology(descriptor.getQualifiedDestinationName());
			}
		}

		/**
		 * Determines if the dmo at the sourceURI endpoint of this link is actually an import from
		 * some other topology.
		 * 
		 * @return
		 */
		public boolean isSourceImported() {
			return sourceImported;
		}

		/**
		 * Sets the sourceURI's import flag. If set to true then calls to getQualifiedSourceUri() will
		 * produce a fully qualified import path to the sourceUri's dmo.
		 * 
		 * @param imported
		 */
		public void setSourceImported(boolean imported) {
			sourceImported = imported;
		}

		/**
		 * Returns the fully-qualified name of the sourceUri's topology.
		 * 
		 * @return
		 */
		public String getSourceTopology() {
			return sourceTopology;
		}

		/**
		 * Sets the fully-qualified name of the sourceUri dmo's topology.
		 * 
		 * @param topology
		 */
		public void setSourceTopology(String topology) {
			sourceTopology = topology;
		}

		/**
		 * Attempts to locate the first parent of the DeployModelObject at the sourceUri path, or the
		 * DMO itself, who is an instance of Unit.
		 * 
		 * @return
		 */
		public Unit getSourceUnit() {
			DeployModelObject dmo = source;
			while (dmo != null
					&& !CorePackage.eINSTANCE.getUnit().isSuperTypeOf(dmo.getEObject().eClass())) {
				dmo = dmo.getParent();
			}

			return (Unit) dmo;
		}

		public String getTargetUri() {
			return targetUri;
		}

		public String getQualifiedTargetUri() {
			String uri = targetUri;
			if (targetImported) {
				uri = getTargetTopology() + IConstants.TOPOLOGY_SEPARATOR + uri;
			}
			return uri;
		}

		public void setTarget(DeployModelObject obj) {
			target = obj;
			targetFile = getFile(obj);
			targetTopology = obj.getTopology().getQualifiedName();
			targetImported = !obj.getTopology().equals(obj.getEditTopology());
			if (targetImported) {
				targetUri = target.getFullPath().substring(targetTopology.length() + 1);
			} else {
				targetUri = target.getFullPath();
			}
		}

		public void setTargetUri(String targetUri) {
			this.targetUri = targetUri;
		}

		public IFile getTargetFile() {
			return targetFile;
		}

		public void setTargetFile(IFile targetFile) {
			this.targetFile = targetFile;
			Topology topology = descriptor.getTopology(targetFile);
			if (topology != null) {
				setTargetTopology(topology.getQualifiedName());
			} else {
				setTargetTopology(descriptor.getQualifiedDestinationName());
			}
		}

		public boolean isTargetImported() {
			return targetImported;
		}

		public void setTargetImported(boolean imported) {
			targetImported = imported;
		}

		public String getTargetTopology() {
			return targetTopology;
		}

		public void setTargetTopology(String topology) {
			targetTopology = topology;
		}

		public Unit getTargetUnit() {
			DeployModelObject dmo = target;
			while (dmo != null
					&& !CorePackage.eINSTANCE.getUnit().isSuperTypeOf(dmo.getEObject().eClass())) {
				dmo = dmo.getParent();
			}

			return (Unit) dmo;
		}

		public DeployLink getOriginalLink() {
			return link;
		}

		private void setLink(DeployLink link) {
			this.link = link;
			linkUriFragment = link.getFullPath();
			linkFile = getFile(link);
			setSource(link.getEditTopology().resolve(link.getSourceURI()));
			setTarget(link.getEditTopology().resolve(link.getTargetURI()));
		}

		public String getLinkUriFragment() {
			return linkUriFragment;
		}

		public void setLinkUriFragment(String linkUriFragment) {
			this.linkUriFragment = linkUriFragment;
		}

		public IFile getLinkFile() {
			return linkFile;
		}

		public void setLinkFile(IFile linkFile) {
			this.linkFile = linkFile;
		}

		public URI getLinkUri() {
			return URI.createPlatformResourceURI(getLinkFile().getFullPath().toString())
					.appendFragment(getLinkUriFragment());
		}

		private IFile getFile(DeployModelObject obj) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(obj.getEditTopology().eResource().getURI().toPlatformString(true)));
		}

		private URI getUri(DeployModelObject dmo) {
			return dmo.eResource().getURI().appendFragment(dmo.eResource().getURIFragment(dmo));
		}
	}
}
