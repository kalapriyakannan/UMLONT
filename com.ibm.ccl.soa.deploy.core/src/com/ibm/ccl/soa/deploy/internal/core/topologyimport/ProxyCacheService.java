package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.change.FeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * 
 * Creates and caches proxy objects representing Units in imported Topologies.
 * 
 * <p>
 * A ProxyCacheService should be instantiated when a Topology Imports other Topologies, and should
 * be disposed when the resource that contains the referenc<b>ing</b> is unloaded.
 * </p>
 * 
 * @since 1.0
 * 
 */
public class ProxyCacheService implements IProxyCacheService {

	/**
	 * Create an instance of the cache service. To be called only by the Scope Service.
	 * 
	 * @param scopeService
	 * 
	 * @return An instance of the cache service.
	 */
	public final static IProxyCacheService create(InternalScopeService scopeService) {
		return new ProxyCacheService(scopeService);
	}

	/**
	 * Create an instance of the cache service. To be called only by the Scope Service.
	 * 
	 * @param scopeService
	 * 
	 * @return An instance of the cache service.
	 */
	public final static IProxyCacheService create() {
		return new ProxyCacheService(null);
	}

	private final Object lock = new Object();
	private boolean stale;

	private final static DelegateSwitch delegateSwitch = new DelegateSwitch();

	private final Map<Import, Map<DeployModelObject, DeployModelObject>> caches = new HashMap<Import, Map<DeployModelObject, DeployModelObject>>();

	private final Map<DeployModelObject, MethodResults> results = new WeakHashMap<DeployModelObject, MethodResults>();

	private final Adapter cacheListener = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			synchronized (lock) {
				stale = true;
			}
		}
	};

	private final InternalScopeService scopeService;

	private ProxyCacheService(InternalScopeService service) {
		scopeService = service;
		setTopology(scopeService.getManagingTopology());
	}

	public void setTopology(Topology topology) {
		synchronized (lock) {
			stale = true;
		}
		if (topology != null) {
			if (cacheListener.getTarget() != null) {
				cacheListener.getTarget().eAdapters().remove(cacheListener);
			}
			configureCacheListener(topology);
		}
	}

	private void configureCacheListener(Topology source) {
		source.addTopologyListener(cacheListener,
				CorePackage.Literals.DEPLOY_CORE_ROOT__INSTANTIATION);
		source.addTopologyListener(cacheListener,
				CorePackage.Literals.INSTANCE_CONFIGURATION__INSTANTIATIONS);
		source.addTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_PROPERTIES);
		source.addTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITIES);
		source.addTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS);
		source.addTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP);
		source.addTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP);
		source.addTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__AUGMENTATION_GROUP);
		source.addTopologyListener(cacheListener, CorePackage.Literals.INSTANTIATION__AUGMENTATIONS);
		source.addTopologyListener(cacheListener, CorePackage.Literals.AUGMENTATION__ADDITIONS);
	}

	private void deconfigureCacheListener(Topology source) {
		source.removeTopologyListener(cacheListener,
				CorePackage.Literals.DEPLOY_CORE_ROOT__INSTANTIATION);
		source.removeTopologyListener(cacheListener,
				CorePackage.Literals.INSTANCE_CONFIGURATION__INSTANTIATIONS);
		source.removeTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_PROPERTIES);
		source.removeTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITIES);
		source.removeTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS);
		source.removeTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP);
		source.removeTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP);
		source.removeTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__AUGMENTATION_GROUP);
		source.removeTopologyListener(cacheListener,
				CorePackage.Literals.INSTANTIATION__AUGMENTATIONS);
		source.removeTopologyListener(cacheListener, CorePackage.Literals.AUGMENTATION__ADDITIONS);
	}

	/**
	 * Locate the proxy for the given object if already created; otherwise generate the Proxy and
	 * return it.
	 * 
	 * @param dmo
	 *           An object contained in another Topology.
	 * 
	 * @return The proxy for the given dmo object populated
	 */
	public DeployModelObject findProxy(DeployModelObject dmo, Import imported) {
		if (dmo != null && imported != null && dmo.getTopology() == imported.getTopology()) {
			return dmo;
		}

		if (dmo.eIsProxy()) {
			dmo = (DeployModelObject) scopeService.resolve(dmo.getEObject());
			if (dmo == null || dmo.eContainer() == null) {
				return null;
			}
		}

		Map cache = getCache(imported);

		DeployModelObject source = dmo;
		Object proxyKey = null;
		if (Proxy.isProxyClass(dmo.getClass())) {
			InvocationHandler handler = Proxy.getInvocationHandler(dmo);
			assert handler instanceof IProxyConfiguration;
			IProxyConfiguration config = (IProxyConfiguration) handler;
			if (this == config.getService()) {
				return dmo;
			}
			source = config.getSource();
			proxyKey = dmo.getFullPath();
		} else if (dmo.getTopology() != null) {
			proxyKey = dmo.getTopology().getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR
					+ dmo.getFullPath();
		} else {
			proxyKey = imported.getQualifiedImport() + IConstants.TOPOLOGY_SEPARATOR
					+ dmo.getFullPath();
		}

		if (source instanceof Topology) {
			proxyKey = ((Topology) source).getQualifiedName();
		}

		DeployModelObject proxy = null;
		synchronized (cache) {

			proxy = (DeployModelObject) cache.get(proxyKey);

			if (proxy == null) {

				proxy = createProxy(imported, source);
				cache.put(proxyKey, proxy);

			} else {
				if (ProxyConfiguration.getSource(proxy) != source) {
//				Exception ex = new IllegalStateException(
//						"Found unmatched Proxy: " + source + " does not match returned proxy: " + proxy); //$NON-NLS-1$//$NON-NLS-2$
//				DeployCorePlugin.log(IStatus.WARNING, 0, ex.getMessage(), ex);

					proxy = createProxy(imported, source);
					cache.put(proxyKey, proxy);
				}
			}

		}

		return proxy;
	}

	private DeployModelObject createProxy(Import imported, DeployModelObject source) {
		DeployModelObject proxy;
		ProxyConfiguration handler = new ProxyConfiguration(this, source, imported);

		Collection interfaces = new LinkedHashSet();
		collectInterfaces(source.getClass(), interfaces);

		proxy = (DeployModelObject) Proxy.newProxyInstance(source.getClass().getClassLoader(),
				(Class[]) interfaces.toArray(new Class[0]), handler);
		return proxy;
	}

	/**
	 * Locate the proxy for the given object if already created; otherwise generate the Proxy and
	 * return it.
	 * 
	 * @param dmo
	 *           An object contained in another Topology.
	 * 
	 * @return The proxy for the given dmo object populated
	 */
	public synchronized ExtendedAttribute findProxy(ExtendedAttribute attr, Import imported) {
		if (attr != null && attr.getContainer() != null) {
			DeployModelObject container = attr.getContainer();
			DeployModelObject containerProxy = findProxy(container, imported);

			if (imported != null && container.getTopology() == imported.getTopology()) {
				return attr;
			}

			if (attr.eIsProxy()) {
				attr = (ExtendedAttribute) scopeService.resolve(attr);
				if (attr == null || attr.eContainer() == null) {
					return null;
				}
			}

			Map cache = getCache(imported);

			Object proxyKey = container.getFullPath() + IConstants.ATTRIBUTE_SEPARATOR
					+ attr.getName();

			ExtendedAttribute proxy = (ExtendedAttribute) cache.get(proxyKey);

			// getInterfaces() may need to be correct to aggregate all interfaces
			if (proxy == null) {

				IProxyConfiguration parentHandler = (IProxyConfiguration) Proxy
						.getInvocationHandler(containerProxy);

				IProxyConfiguration handler = new ExtendedAttributeConfiguration(parentHandler, attr);

				Collection interfaces = new LinkedHashSet();
				collectInterfaces(attr.getClass(), interfaces);

				proxy = (ExtendedAttribute) Proxy.newProxyInstance(attr.getClass().getClassLoader(),
						(Class[]) interfaces.toArray(new Class[0]), handler);

				cache.put(proxyKey, proxy);

			}
			return proxy;
		}
		return attr;

	}

	/**
	 * Retrieve the result for the feature if already stored; otherwise return ;
	 * 
	 * @param dmo
	 *           An object contained in another Topology.
	 * @param feature
	 *           The feature of the dmo being queried for cached results.
	 * 
	 * @return The proxy for the given dmo object populated
	 */
	public Object retrieveResult(DeployModelObject dmo, String feature) {
		synchronized (lock) {
			if (stale) {
				results.clear();
				stale = false;
			}
			Object retrieved = null;
			MethodResults cached = results.get(dmo);
			if (cached != null) {
				retrieved = cached.retrieve(feature);
			}
			return retrieved != null ? retrieved : NO_RESULT;
		}
	}

	/**
	 * Clear the result for the feature if already stored
	 * 
	 * @param dmo
	 *           An object contained in another Topology.
	 * @param feature
	 *           The feature of the dmo being cleared from the cached results.
	 * 
	 */
	public void clearResult(DeployModelObject dmo, String feature) {
		synchronized (lock) {
			if (stale) {
				results.clear();
				stale = false;
			} else {
				MethodResults cached = results.get(dmo);
				if (cached != null) {
					cached.clear(feature);
				}
			}
		}
	}

	/**
	 * Retrieve the result for the feature if already stored; otherwise return ;
	 * 
	 * @param dmo
	 *           An object contained in another Topology.
	 * @param feature
	 *           The feature of the dmo being queried for cached results.
	 * @param result
	 *           The result of the method invocation.
	 * 
	 */
	public void storeResult(DeployModelObject dmo, String feature, Object result) {
		synchronized (lock) {
			MethodResults cached = results.get(dmo);
			if (cached == null) {
				cached = new MethodResults(dmo);
			}
			cached.store(feature, result);
			results.put(dmo, cached);
		}
	}

	/**
	 * Remove stored method results, if any.
	 * 
	 * @param dmo
	 *           An object contained in another Topology.
	 * 
	 */
	public void clearResults(DeployModelObject dmo) {
		synchronized (lock) {
			results.remove(dmo);
		}
	}

	private Map<DeployModelObject, DeployModelObject> getCache(Import imported) {
		Map<DeployModelObject, DeployModelObject> cache = caches.get(imported);
		if (cache == null) {
			caches.put(imported, cache = new HashMap<DeployModelObject, DeployModelObject>());
		}
		return cache;
	}

	private void collectInterfaces(Class clazz, Collection interfaces) {

		if (clazz.getSuperclass() != null) {
			collectInterfaces(clazz.getSuperclass(), interfaces);
		}
		interfaces.addAll(Arrays.asList(clazz.getInterfaces()));

	}

	public void dispose() {
		caches.clear();
		results.clear();

	}

	/**
	 * Turn the result of a method call into a proxy or list of proxies.
	 * <p>
	 * Uses generic knowledge of containers to proxy their values. In particular, supports:
	 * <ul>
	 * <li>{@link DeployModelObject}
	 * <li>{@link List}
	 * <li>{@link EList}
	 * <ul>
	 * </ul>
	 * <li>{@link Object}[]
	 * <li>{@link Iterator}
	 * <ul>
	 * <li>{@link ListIterator}
	 * <li>{@link TreeIterator}
	 * </ul>
	 * </ul>
	 * 
	 * @param result
	 *           the result of a method operation.
	 * @param imported
	 *           the topology import context.
	 * @return the proxified result (if applicable).
	 * 
	 * @see #findProxy(DeployModelObject, Import)
	 */
	public Object proxify(Object result, Import imported) {
		if (result == null) {
			return null;
		}

		if (result instanceof DeployModelObject) {
			return findProxy((DeployModelObject) result, imported);
		}

		if (result instanceof ExtendedAttribute) {
			return findProxy((ExtendedAttribute) result, imported);
		}

		if (result instanceof TreeIterator) {
			return new ProxyTreeIterator(this, imported, (TreeIterator) result);
		}

		if (result instanceof ListIterator) {
			ListIterator iter = (ListIterator) result;
			if (!iter.hasNext()) {
				return ProxyListIterator.EMPTY_LIST_ITERATOR;
			}
			return new ProxyListIterator(this, imported, iter);
		}

		if (result instanceof Iterator) {
			Iterator iter = (Iterator) result;
			if (!iter.hasNext()) {
				return ProxyIterator.EMPTY_ITERATOR;
			}
			return new ProxyIterator(this, imported, iter);
		}

		if (result instanceof FeatureMap) {
			FeatureMap map = (FeatureMap) result;
			return new ProxyFeatureMap(this, imported, map);
		}

		if (result instanceof FeatureMapEntry) {
			FeatureMapEntry map = (FeatureMapEntry) result;
			return new ProxyFeatureMapEntry(this, imported, map);
		}

		if (result instanceof EList) {
			EList list = (EList) result;
			return new ProxyEList(this, imported, list);
		}

		if (result instanceof List) {
			List list = (List) result;
			if (list.size() == 0) {
				return ProxyList.EMPTY_LIST;
			}
			return new ProxyList(this, imported, list);
		}

		if (result.getClass().isArray()) {
			Object[] array = (Object[]) result;
			boolean hasDMO = false;
			for (int i = 0; i < array.length; i++) {
				if (array[i] instanceof DeployModelObject) {
					hasDMO = true;
					break;
				}
			}
			if (!hasDMO) {
				return array;
			}
			Object[] copy = (Object[]) Array.newInstance(array.getClass().getComponentType(),
					array.length);
			for (int i = 0; i < array.length; i++) {
				if (array[i] instanceof DeployModelObject) {
					copy[i] = findProxy((DeployModelObject) array[i], imported);
				} else {
					copy[i] = array[i];
				}
			}
			return copy;
		}

		// No proxy transformation available, return as is and hope for the best
		return result;
	}

	public DelegateSwitch getDelegateSwitch() {
		return delegateSwitch;
	}

	protected InternalScopeService getScopeService() {
		return scopeService;
	}

}
