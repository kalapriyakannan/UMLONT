/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.pattern.IUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.DomainDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.DomainManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.SkeletonDomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployTransactionReporter;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidationContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidatorJob;
import com.ibm.ccl.soa.deploy.internal.core.validator.IDeployTransactionReporter;
import com.ibm.ccl.soa.deploy.internal.core.validator.InternalDomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.RegisteredConstraintLinkValidator;
import com.ibm.ccl.soa.deploy.internal.core.validator.StatefulDeployValidationContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;

/**
 * Capability access point for SOA deploy topology validation extensions.
 * <p>
 * Provides a registry for obtaining DomainValidator extensions, and convenience methods for
 * invoking validation on all validators.
 * 
 * @see DeployValidatorJob
 */
public class DeployValidatorService implements IDomainValidatorService {

	/**
	 * The key used for the default validator service.
	 * 
	 * @see #getDefaultValidatorService()
	 */
	public static final String DEFAULT_SERVICE_ID = DeployValidatorService.class.getName();

	/** constant depth value to indicate matcher should search to deepest level */
//	public static final int MATCHER_DEPTH_ALL = -1;
	public static final int MATCHER_DEPTH_ALL = Integer.MAX_VALUE;

	/** constant depth value to indicate matcher should not search beyond the specified target */
	public static final int MATCHER_DEPTH_NONE = 0;

	public static final int MATCHER_STOP_RECURSION = -1;

	/** An immutable singleton list containing the skeleton domain matcher. */
	protected final List<IDomainValidator> SKELETON_DOMAIN_VALIDATOR_LIST = Collections
			.singletonList((IDomainValidator) SkeletonDomainValidator.INSTANCE);

	/** An immutable singleton list containing the skeleton domain matcher. */
	protected final List<DomainMatcher> SKELETON_DOMAIN_MATCHER_LIST = Collections
			.singletonList(SkeletonDomainValidator.INSTANCE.getDomainMatcher());

	/** Static map of validator service IDs to weak references to the service. */
	private static Map<Object, WeakReference<DeployValidatorService>> keyServiceCache;

	/** Caches a map between a namespace and the list of its validators. */
	protected final Map<String, List<IDomainValidator>> namespaceValidatorsCache = new HashMap<String, List<IDomainValidator>>();

	/** Caches a map between a namespace and the list of its matchers. */
	protected final Map<String, List<DomainMatcher>> namespaceMatchersCache = new HashMap<String, List<DomainMatcher>>();

	/**
	 * Set<String> of domains IDs whose validator has been disabled.
	 * 
	 * @see IDomainValidator#getDomainID()
	 */
	protected Set<String> disabledDomainIdSet = null;

	/**
	 * Construct a domain validator service which delegates validation to the domain validator
	 * extension points.
	 */

	public DeployValidatorService() {
	}

	/**
	 * Returns the default instance of the deploy validator service.
	 * <p>
	 * The default service is cached using the{@link #DEFAULT_SERVICE_ID} key.
	 * 
	 * @return the default validator service.
	 */
	public static synchronized DeployValidatorService getDefaultValidatorService() {
		DeployValidatorService service = getValidatorService(DEFAULT_SERVICE_ID);
		if (service == null) {
			service = getOrCreateValidatorService(DEFAULT_SERVICE_ID);
			cacheValidatorService(DEFAULT_SERVICE_ID, service);
		}
		return service;
	}

	/**
	 * Returns the validator service associated with the key.
	 * <p>
	 * The result may be null if the key was never associated with a service or the service has been
	 * garbage collected
	 * 
	 * @param key
	 *           any object with a well defined {@link Object#hashCode()} method (e.g. String).
	 * @return the cached {@link DeployValidatorService} instance (may be null);
	 */
	public static synchronized DeployValidatorService getValidatorService(Object key) {
		DeployValidatorService service = null;
		if (keyServiceCache != null) {
			WeakReference<DeployValidatorService> ref = keyServiceCache.get(key);
			if (ref != null) {
				service = ref.get();
			}
		}
		return service;
	}

	/**
	 * Return the cached {@link DeployValidatorService} based on the key or creates a new service.
	 * <p>
	 * Note the newly created service will NOT be cached. You should invoke
	 * {@link #cacheValidatorService(Object, DeployValidatorService)}.
	 * 
	 * @param key
	 *           the key used to lookup an existing service (may be null).
	 * @return an existing or newly created {@link DeployValidatorService} (never null).
	 */
	public static synchronized DeployValidatorService getOrCreateValidatorService(Object key) {
		DeployValidatorService service = getValidatorService(key);
		return service == null ? new DeployValidatorService() : service;
	}

	/**
	 * This is a way for clients to cache their {@link DeployValidatorService} for others to reuse.
	 * <p>
	 * It is up to the client to define the key and publicize it for its clients.
	 * <p>
	 * The passed service will be cached as a {@link WeakReference}.
	 * 
	 * @param key
	 *           any non-null object with a well defined {@link Object#hashCode()} method (e.g.
	 *           String).
	 * @param service
	 *           An instance of {@link DeployValidatorService}.
	 * 
	 * @see #getValidatorService(Object)
	 * @see #removeCachedValidatorService(Object)
	 */
	public static void cacheValidatorService(Object key, DeployValidatorService service) {
		if (key == null) {
			throw new IllegalArgumentException("null key argument"); //$NON-NLS-1$
		}
		if (keyServiceCache == null) {
			keyServiceCache = Collections
					.synchronizedMap(new HashMap<Object, WeakReference<DeployValidatorService>>());
		}
		keyServiceCache.put(key, new WeakReference<DeployValidatorService>(service));
	}

	/**
	 * Used to removed a cached {@link DeployValidatorService} instance.
	 * 
	 * @param key
	 *           any object with a well defined {@link Object#hashCode()} method (e.g. String).
	 * 
	 * @see #cacheValidatorService(Object, DeployValidatorService)
	 */
	public static void removeCachedValidatorService(Object key) {
		if (keyServiceCache != null) {
			keyServiceCache.remove(key);
		}
	}

	/**
	 * Check if the validator declared for a domain is enabled.
	 * <p>
	 * Disabled domain validators are not invoked by
	 * {@link #validate(IDeployValidationContext, IDeployReporter)}.
	 * 
	 * @param domainID
	 *           a domain extension point ID
	 * @return true if validation for the domain is enabled, false otherwise.
	 * 
	 * @see IDomainValidator#getDomainID()
	 */
	public boolean isDomainValidatorEnabled(String domainID) {
		if (domainID == null) {
			return true;
		}
		if (disabledDomainIdSet == null) {
			return true;
		}
		return !disabledDomainIdSet.contains(domainID);
	}

	/**
	 * Enables or disables the validator of a domain.
	 * 
	 * @param domainID
	 *           the ID of the domain extension.
	 * @param enabled
	 *           true to enable the validator of the domain, false otherwise.
	 */
	public void setDomainValidatorEnabled(String domainID, boolean enabled) {
		if (domainID == null) {
			return;
		}
		if (enabled) {
			if (disabledDomainIdSet != null) {
				disabledDomainIdSet.remove(domainID);
			}
		} else {
			if (disabledDomainIdSet == null) {
				disabledDomainIdSet = new HashSet<String>();
			}
			disabledDomainIdSet.add(domainID);
		}
	}

	/**
	 * Returns the {@link IUnitValidator} associated with the unit type.
	 * <p>
	 * Queries all domain validators of type {@link UnitDomainValidator}.
	 * 
	 * @param type
	 *           a subtype of {@link Unit}.
	 * @return an unmodifiable list of unit validators (never null).
	 */
	public List<IUnitValidator> getUnitValidators(EClass type) {
		// TODO cache result
		if (type == null) {
			return Collections.emptyList();
		}
		List<IDomainValidator> domainValidators = getDomainValidators(type.getEPackage().getNsURI());
		if (domainValidators.size() == 0) {
			return Collections.emptyList();
		}
		List<IUnitValidator> resultList = new ArrayList<IUnitValidator>();
		for (IDomainValidator domainValidator : domainValidators) {
			if (!(domainValidator instanceof UnitDomainValidator)) {
				continue;
			}
			UnitDomainValidator validator = (UnitDomainValidator) domainValidator;
			for (Iterator<IUnitValidator> iter = validator.getValidators(type); iter.hasNext();) {
				IUnitValidator unitValidator = iter.next();
				if (unitValidator != null) {
					resultList.add(unitValidator);
				}
			}
		}
		return Collections.unmodifiableList(resultList);
	}

	/**
	 * Returns the domain validators that are applicable to the types contained in the topology.
	 * 
	 * @param topology
	 *           an SOA topology containing units, services and links from different domains.
	 * @return an unmodifiable list of validators applicable to the topology (never null).
	 */
	public Collection<IDomainValidator> getDomainValidators(Topology topology) {
		Set<String> namespaces = new LinkedHashSet<String>();

		// Make sure that the core and topology namespaces are always included.
		namespaces.add(topology.eClass().getEPackage().getNsURI());
		namespaces.add(CorePackage.eINSTANCE.getNsURI());

		for (Iterator<DeployModelObject> iter = topology.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject object = iter.next();
			namespaces.add(object.eClass().getEPackage().getNsURI());
		}
		Set<IDomainValidator> validatorSet = new LinkedHashSet<IDomainValidator>();
		for (Iterator<String> it = namespaces.iterator(); it.hasNext();) {
			String namespace = it.next();
			List<IDomainValidator> domainValidators = getDomainValidators(namespace);
			if (domainValidators != null) {
				for (IDomainValidator validator : domainValidators) {
					validatorSet.add(validator);
				}
			}
		}
		return Collections.unmodifiableSet(validatorSet);
	}

	/**
	 * Returns the validator for the domain of the object.
	 * 
	 * @param namespace
	 *           A namespace URI that is used to describe a domain.
	 * @return an unmodifiable list of domain validators (never null).
	 */
	public List<IDomainValidator> getDomainValidators(String namespace) {
		if (namespace == null) {
			return SKELETON_DOMAIN_VALIDATOR_LIST;
		}

		synchronized (namespaceValidatorsCache) {
			List<IDomainValidator> validators = namespaceValidatorsCache.get(namespace);
			if (validators == null) {
				DomainDescriptor[] descriptors = DomainManager.INSTANCE
						.findDomainDescriptorsByTargetNamespace(namespace, null);
				if (descriptors == null) {
					// TODO replace with {@link #SKELETON_DOMAIN_VALIDATOR_LIST}
					validators = Collections
							.singletonList((IDomainValidator) RegisteredConstraintLinkValidator.INSTANCE);
				} else {
					validators = new ArrayList<IDomainValidator>(descriptors.length + 1);
					for (int i = 0; i < descriptors.length; i++) {
						try {
							IDomainValidator validator = descriptors[i].createDomainValidator();
							if (validator == null) {
								validator = SkeletonDomainValidator.INSTANCE;
							}
							validators.add(validator);
						} catch (RuntimeException e) {
							DeployCorePlugin.logError(0, "" + e.getMessage(), e);//$NON-NLS-1$
							validators.add(SkeletonDomainValidator.INSTANCE);
						}
					}
					validators.add(RegisteredConstraintLinkValidator.INSTANCE);
				}
				validators = Collections.unmodifiableList(validators);
				namespaceValidatorsCache.put(namespace, validators);
			}
			return validators;
		}
	}

	/**
	 * Returns the validator for the domain of the object.
	 * 
	 * @param deployModelObject
	 *           the deploy model object whose domain validator is needed.
	 * @return an unmodifiable list of domain validators (never null).
	 */
	public List<IDomainValidator> getDomainValidators(DeployModelObject deployModelObject) {
		String targetNamespace = deployModelObject.eClass().getEPackage().getNsURI();
		return getDomainValidators(targetNamespace);
	}

	/**
	 * Returns the resolutions that can be applied to the specified status.
	 * <p>
	 * The resolutions are sorted in reverse priority order (higher to lower).
	 * 
	 * @param status
	 *           a status that may contain {@link IDeployStatus}.
	 * @return an unmodifiable list of bound deploy resolutions (never null).
	 */
	public List<IDeployResolution> getResolutions(IStatus status) {
		List<IDeployResolution> resolutionList = new ArrayList<IDeployResolution>();
		for (Iterator<IDeployStatus> iter = new DeployStatusIterator(status); iter.hasNext();) {
			IDeployStatus deployStatus = iter.next();
			IDeployResolutionContext context = new DeployResolutionContext(deployStatus, this, null);
			ResolutionGeneratorDescriptor[] descriptors = ResolutionGeneratorManager.getInstance()
					.getResolutionGeneratorDescriptors(deployStatus);
			for (int i = 0; i < descriptors.length; i++) {
				IDeployResolutionGenerator generator = descriptors[i].getResolutionGenerator();
				if (generator != null) {
					try {
						if (generator.hasResolutions(context)) {
							IDeployResolution[] resolutions = generator.getResolutions(context);
							for (int r = 0; resolutions != null && r < resolutions.length; r++) {
								if (!resolutionList.contains(resolutions[r])) {
									resolutionList.add(resolutions[r]);
								}
							}
						}
					} catch (ConcurrentModificationException e) {
						// Don't log errors caused by a concurrent model change
					} catch (RuntimeException e) {
						DeployCorePlugin.logError(0, DeployCoreMessages.Resolution_generator_failure, e);
					}
				}
			}

		}
		if (resolutionList.size() > 1) {
			Collections.sort(resolutionList);
			Collections.reverse(resolutionList);
		}
		return Collections.unmodifiableList(resolutionList);
	}

	/**
	 * Checks if the status has deploy resolutions associated with it.
	 * 
	 * @param status
	 *           a status that may contain or be a deploy status.
	 * @return true if the status contains deploy status, and there are resolutions for that status.
	 */
	public boolean hasResolutions(IStatus status) {
		for (Iterator<IDeployStatus> iter = new DeployStatusIterator(status); iter.hasNext();) {
			IDeployStatus deployStatus = iter.next();
			IDeployResolutionContext context = new DeployResolutionContext(deployStatus, this, null);
			ResolutionGeneratorDescriptor[] descriptors = ResolutionGeneratorManager.getInstance()
					.getResolutionGeneratorDescriptors(deployStatus);
			for (int i = 0; i < descriptors.length; i++) {
				IDeployResolutionGenerator generator = descriptors[i].getResolutionGenerator();
				if (generator != null) {
					try {
						if (generator.hasResolutions(context)) {
							return true;
						}
					} catch (Throwable e) {
						DeployCorePlugin.logError(0, DeployCoreMessages.Resolution_generator_failure, e);
					}
				}
			}
		}
		return false;
	}

	/**
	 * Checks if the status has deploy resolution generators associated with it.
	 * 
	 * @param status
	 *           a status that may contain or be a deploy status.
	 * @return true if the status contains deploy status, and there are resolution generators for
	 *         that status.
	 */
	public boolean hasResolutionGenerators(IStatus status) {
		for (Iterator<IDeployStatus> iter = new DeployStatusIterator(status); iter.hasNext();) {
			IDeployStatus deployStatus = iter.next();
			if (ResolutionGeneratorManager.getInstance().hasResolutionGeneratorDescriptors(
					deployStatus)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidatorService#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public IStatus validate(IDeployValidationContext context, IDeployReporter reporter) {
		final Topology topology = context.getTopology();

		// Collect the applicable domain validators.
		Collection<IDomainValidator> validators = getDomainValidators(topology);
		String validationTaskName = NLS.bind(DeployCoreMessages.Deploy_topology_0_validation_job,
				new String[] { DeployNLS.getName(topology) });
		context.getProgressMonitor().beginTask(validationTaskName, validators.size());
		return validate(context, reporter, validators);
	}

	/**
	 * Validate the context topology using the specified list of domain validators.
	 * 
	 * @param context
	 *           the validation context identifying the topology.
	 * @param reporter
	 *           the mechanism for reporting validation issues.
	 * @param validators
	 *           the collection of validators to be used.
	 * @return the status of the validation process itself, not related to the status of the topology
	 *         itself.
	 */
	public IStatus validate(final IDeployValidationContext context, final IDeployReporter reporter,
			Collection<IDomainValidator> validators) {
		assert context != null;
		assert reporter != null;

		final Topology topology = context.getTopology();
		assert topology != null;
		final IProgressMonitor monitor = context.getProgressMonitor();

		// Begin transaction
		if (reporter instanceof IDeployTransactionReporter) {
			((IDeployTransactionReporter) reporter).beginTransaction(topology);
		}

		//
		// Validate using each applicable domain validator.
		//
		try {
			TopologyDiscovererService.INSTANCE.enterDefaultDiscoveryCache();
			for (Iterator<IDomainValidator> iter = validators.iterator(); iter.hasNext()
					&& !monitor.isCanceled();) {
				final IDomainValidator validator = iter.next();
				if (!isDomainValidatorEnabled(validator.getDomainID())) {
					continue;
				}

				final Throwable[] errorRef = new Throwable[1];
				SafeRunner.run(new ISafeRunnable() {
					public void run() throws Exception {
						try {
							validator.validate(context, reporter);
						} catch (AssertionError e) {
							handleException(e);
						}
					}

					public void handleException(Throwable exception) {
						errorRef[0] = exception;
					}
				});
				monitor.worked(1);

				Throwable error = errorRef[0];
				// Unwrap the root cause of the exception (if applicable)
				if (error instanceof UndeclaredThrowableException) {
					error = ((UndeclaredThrowableException) error).getCause();
				}
				if (error instanceof InvocationTargetException) {
					error = ((InvocationTargetException) error).getCause();
				}
				if (monitor.isCanceled() || topology.eIsProxy()
						|| error instanceof ConcurrentModificationException) {
					// Model changed while we were validating (OK because another
					// validation will be scheduled).
					monitor.setCanceled(true);
				} else if (error != null) {
					// Log the error
					String topologyName = topology.getNamespace() != null ? topology.getNamespace()
							+ IConstants.DOT_SEPARATOR + topology.getName() : topology.getName();
					String message = NLS.bind(
							DeployCoreMessages.Domain_validator_0_execution_error_1_over_topology_2,
							new String[] { validator.getDomainID(), error.getMessage(), topologyName });
					DeployCorePlugin.logError(0, message, error);
				}
			}
		} finally {
			TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
		}

		if (monitor.isCanceled()) {
			// Abort the transaction
			if (reporter instanceof IDeployTransactionReporter) {
				((IDeployTransactionReporter) reporter).abortTransaction();
			}
			return Status.CANCEL_STATUS;
		}

		//
		// TODO: generalize concept of status filter in M6
		//
		if (reporter instanceof IDeployTransactionReporter) {
			IDeployTransactionReporter txnReporter = (IDeployTransactionReporter) reporter;
			List<IDeployStatus> statusList = txnReporter.getTransactionContents();
			for (IDomainValidator validator : validators) {
				try {
					if (validator instanceof InternalDomainValidator) {
						((InternalDomainValidator) validator).filterStatusList(context, statusList);
					}
				} catch (Throwable e) {
					DeployCorePlugin.logError(0, e.getMessage() != null ? e.getMessage() : e.toString(),
							e);
				}
			}

			try {
				txnReporter.commitTransaction();
			} catch (Throwable e) {
				DeployCorePlugin.logError(0, e.getMessage() != null ? e.getMessage() : e.toString(), e);
			}
		}

		monitor.done();
		return Status.OK_STATUS;
	}

	/**
	 * Validates an in-memory topology in <em>the invoking thread</em>.
	 * <p>
	 * To perform asynchronous validation as a Job invoke {@link #scheduleValidation(Topology)}
	 * 
	 * @param topology
	 *           the topology to be validated.
	 */
	public void validate(Topology topology) {
		DeployTransactionReporter reporter = new DeployTransactionReporter();
		DeployValidationContext context = new StatefulDeployValidationContext(topology, this,
				new NullProgressMonitor());

		validate(context, reporter);
	}

	// //////////////////////////////////////////////////////////////////////////////////////
	//
	// Matcher code
	//
	// //////////////////////////////////////////////////////////////////////////////////////

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidatorService#getDomainMatchers(java.lang.String)
	 */
	public List<DomainMatcher> getDomainMatchers(String namespace) {
		if (namespace == null) {
			return SKELETON_DOMAIN_MATCHER_LIST;
		}

		synchronized (namespaceMatchersCache) {
			List<DomainMatcher> matchers = namespaceMatchersCache.get(namespace);
			if (matchers == null) {
				List<IDomainValidator> validators = getDomainValidators(namespace);
				matchers = new ArrayList<DomainMatcher>(validators.size());
				for (IDomainValidator validator : validators) {
					if (validator instanceof DomainValidator) {
						DomainMatcher matcher = ((DomainValidator) validator).getDomainMatcher();
						if (matcher != null) {
							matchers.add(matcher);
						}
					}
				}
				if (matchers.size() == 0) {
					matchers = SKELETON_DOMAIN_MATCHER_LIST;
				} else {
					matchers = Collections.unmodifiableList(matchers);
				}
				namespaceMatchersCache.put(namespace, matchers);
			}

			return matchers;
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidatorService#getDomainMatchers(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public List<DomainMatcher> getDomainMatchers(Unit unit) {
		if (unit == null) {
			return SKELETON_DOMAIN_MATCHER_LIST;
		}
		String namespace = unit.eClass().getEPackage().getNsURI();

		return getDomainMatchers(namespace);
	}

	public IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes) {
		return canBeLinkSource(unit, linkTypes, MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkSource(Unit unit, Requirement requirement, LinkType[] linkTypes) {
		return canBeLinkSource(unit, requirement, linkTypes, MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkSource(Unit unit, LinkType[] linkTypes, int depth) {
		return canBeLinkSource(unit, null, linkTypes, depth);
	}

	public IStatus canBeLinkSource(Unit unit, Requirement requirement, LinkType[] linkTypes,
			int depth) {
		List<DomainMatcher> matchers = getDomainMatchers(unit);
		IStatus lastStatus = null;
		for (DomainMatcher matcher : matchers) {
			if (null == matcher) {
				continue;
			}
			lastStatus = matcher.canBeLinkSource(unit, requirement,
			// MK 10/5/2005 this is wrong; should use list of linktypes passed
					// in
					// new LinkType[] { LinkType.DEPENDENCY });
					linkTypes, depth);
			if (lastStatus.isOK()) {
				return lastStatus;
			}
		}
		return lastStatus;
	}

	public IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes) {
		return canBeLinkTarget(unit, null, linkTypes, MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes) {
		return canBeLinkTarget(unit, capability, linkTypes, MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkTarget(Unit unit, LinkType[] linkTypes, int depth) {
		return canBeLinkTarget(unit, null, linkTypes, depth);
	}

	public IStatus canBeLinkTarget(Unit unit, Capability capability, LinkType[] linkTypes, int depth) {
		List<DomainMatcher> matchers = getDomainMatchers(unit);
		IStatus lastStatus = null;
		for (DomainMatcher matcher : matchers) {
			if (null == matcher) {
				continue;
			}
			lastStatus = matcher.canBeLinkTarget(unit, capability, linkTypes, depth);
			if (lastStatus.isOK()) {
				return lastStatus;
			}
		}
		return lastStatus;
	}

	public IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes) {
		return canBeLinkEndpoint(unit, null, linkTypes, MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, LinkType[] linkTypes) {
		return canBeLinkEndpoint(unit, reqCap, linkTypes, MATCHER_DEPTH_NONE);
	}

	public IStatus canBeLinkEndpoint(Unit unit, LinkType[] linkTypes, int depth) {
		return canBeLinkEndpoint(unit, null, linkTypes, depth);
	}

	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap, LinkType[] linkTypes,
			int depth) {
		List<DomainMatcher> matchers = getDomainMatchers(unit);
		IStatus lastStatus = null;
		for (DomainMatcher matcher : matchers) {
			if (null == matcher) {
				continue;
			}
			lastStatus = matcher.canBeLinkEndpoint(unit, reqCap, linkTypes, depth);
			if (lastStatus.isOK()) {
				return lastStatus;
			}
		}
		return lastStatus;
	}

	public IStatus canCreateLink(Unit source, Unit target, LinkType[] linkTypes) {
		return canCreateLink(source, null, target, null, linkTypes, MATCHER_DEPTH_NONE);
	}

	public IStatus canCreateLink(Unit source, Unit target, LinkType[] linkTypes, int depth) {
		return canCreateLink(source, null, target, null, linkTypes, depth);
	}

	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, LinkType[] linkTypes) {
		IStatus status = canCreateLink(source, source, sourceRequirement, target, targetCapability,
				linkTypes, MATCHER_DEPTH_NONE);
		return status;
	}

	/*
	 * No longer called locallay private IStatus canCreateLink(Unit unitToCheckForMatchers, Unit
	 * source, Requirement sourceRequirement, Unit target, Capability targetCapability, LinkType[]
	 * linkTypes) { return canCreateLink (unitToCheckForMatchers, source, sourceRequirement, target,
	 * targetCapability, linkTypes, LinkMatcherStrategy.NONE); }
	 */

	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, LinkType[] linkTypes, int depth) {
		IStatus status = canCreateLink(source, source, sourceRequirement, target, targetCapability,
				linkTypes, depth);
		return status;
	}

	private IStatus canCreateLink(Unit unitToCheckForMatchers, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability,
			LinkType[] linkTypes, int depth) {
//		System.out.println ("DVS.canCreateLink called for " + source.getName() + " -> " + target.getName()); //$NON-NLS-1$ //$NON-NLS-2$
		List<DomainMatcher> matchers = getDomainMatchers(unitToCheckForMatchers);
		IStatus retValStatus = DeployMatcherStatus.MATCH_NOT_FOUND;
		IStatus currStatus = null;
		for (DomainMatcher matcher : matchers) {
			if (null == matcher) {
				continue;
			}
			currStatus = matcher.canCreateLink(source, sourceRequirement, target, targetCapability,
					linkTypes, depth);
//			System.out.println ("   Status for matcher: " + currStatus + "  (" + matchers[i] + ")");  //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
			if (currStatus.isOK()) {
				return currStatus;
			}

			// If non-MATCH_NOT_FOUND failure status has not already been saved, 
			// save current status if it is not a MATCH_NOT_FOUND status
			if (!currStatus.equals(DeployMatcherStatus.MATCH_NOT_FOUND)
					&& retValStatus.equals(DeployMatcherStatus.MATCH_NOT_FOUND)) {
//				System.out.println ("   Setting retValStatus to: " + currStatus);  //$NON-NLS-1$
				retValStatus = currStatus;
			}
		}
		return retValStatus;
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Unit target, LinkType[] linkTypes) {
		return getPossibleLinks(source, null, target, null, linkTypes, MATCHER_DEPTH_NONE);
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, LinkType[] linkTypes) {
		return getPossibleLinks(source, sourceRequirement, target, targetCapability, linkTypes,
				MATCHER_DEPTH_NONE);
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Unit target, LinkType[] linkTypes,
			int depth) {
		return getPossibleLinks(source, null, target, null, linkTypes, depth);
	}

	public LinkDescriptor[] getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, LinkType[] linkTypes, int depth) {
		Set links1 = getPossibleLinks(source, new DomainMatcher[0], source, sourceRequirement,
				target, targetCapability, linkTypes, depth);

		Set allLinks = new HashSet();
		for (Iterator it = links1.iterator(); it.hasNext();) {
			LinkDescriptor l = (LinkDescriptor) it.next();
			if (!allLinks.contains(l)) {
				allLinks.add(l);
			}
		}

		// copy to array
		LinkDescriptor[] links = new LinkDescriptor[allLinks.size()];
		int i = 0;
		for (Iterator lIt = allLinks.iterator(); lIt.hasNext();) {
			links[i++] = (LinkDescriptor) lIt.next();
		}
		return links;
	}

	private Set getPossibleLinks(Unit unitToCheckForMatchers, DomainMatcher[] testedMatchers,
			Unit source, Requirement sourceRequirement, Unit target, Capability targetCapability,
			LinkType[] linkTypes, int depth) {
		List<DomainMatcher> matchers = getDomainMatchers(unitToCheckForMatchers);
		HashSet arrayList = new HashSet();
		for (DomainMatcher matcher : matchers) {
			boolean skip = false;
			if (null == matcher) {
				continue;
			}
			for (int j = 0; j < testedMatchers.length; j++) {
				if (testedMatchers[j].getClass().equals(matcher.getClass())) {
					skip = true;
					break;
				}
			}
			if (skip) {
				break;
			}
			LinkDescriptor[] links = matcher.getPossibleLinks(source, sourceRequirement, target,
					targetCapability, linkTypes, depth);
			for (int j = 0; j < links.length; j++) {
				arrayList.add(links[j]);
			}
		}
		return arrayList;
	}
}
