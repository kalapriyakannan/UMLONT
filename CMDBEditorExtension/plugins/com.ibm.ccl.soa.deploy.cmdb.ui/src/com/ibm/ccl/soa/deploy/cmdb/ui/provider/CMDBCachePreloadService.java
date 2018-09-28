package com.ibm.ccl.soa.deploy.cmdb.ui.provider;

import java.lang.Thread.State;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.cmdb.provider.CmdbModelObjectNode;
import com.ibm.ccl.soa.deploy.cmdb.provider.ICmdbNode;

/**
 * @author barnold
 *
 */
public class CMDBCachePreloadService {

	/** singleton instance of this service */
	public static final CMDBCachePreloadService INSTANCE = new CMDBCachePreloadService();

	private final PreloadRunnable preloadRunnable;

	private Thread cachePreloadThread;
	
	private boolean verbose = false;

	/**
	 * Private constructor
	 */
	private CMDBCachePreloadService() {
		preloadRunnable = new PreloadRunnable();
		cachePreloadThread = initThread();
	}

	private Thread initThread() {
		Thread cachePreloadThread = new Thread(preloadRunnable);
		cachePreloadThread.setName("CCMDB cache preload"); //$NON-NLS-1$
		cachePreloadThread.setPriority(Thread.MIN_PRIORITY);
		return cachePreloadThread;
	}

	/**
	 * @param oArray
	 */
	public void preLoadCMDBCache(final Object oArray[]) {
		try {
			if (oArray == null) {
				return;
			}

			preloadRunnable.addWorkToBeginning(oArray);

			State state = cachePreloadThread.getState();

			// If new thread, just start it
			if (state.equals(State.NEW)) {
				cachePreloadThread.start();
				return;
			}
			// If thread is terminated, make a new one
			if (state.equals(State.TERMINATED)) {
				cachePreloadThread = initThread();
				cachePreloadThread.start();
				return;
			}
			// Otherwise current thread will pick up the work
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class PreloadRunnable implements Runnable {
		private List<Object> oList = Collections.synchronizedList(new LinkedList<Object>());

		public PreloadRunnable(Object oArray[]) {
			synchronized (oList) {
				oList.addAll(Arrays.asList(oArray));
			}
		}

		public PreloadRunnable() {

		}

		public void addWorkToBeginning(Object oArray[]) {
			synchronized (oList) {
				oList.addAll(0, Arrays.asList((oArray)));
			}
		}

		public void addWorkToEnd(Object oArray[]) {
			synchronized (oList) {
				oList.addAll(Arrays.asList((oArray)));
			}
		}

		public void run() {
				while (true) {
					Object o = null;
					int listSize = 0; 
					synchronized (oList) {
						listSize = oList.size();
						if (oList.size() == 0) {
							break;
						}
						o = oList.get(0);
						oList.remove(0);
					}
					if (o == null) {
						break;
					}
					if (o instanceof ICmdbNode) {
						if (o instanceof CmdbModelObjectNode) {
							if (!CmdbQueryService.INSTANCE.isAPIHealthy())  {
								// terminate thread if API is broken
								break;
							}
							if (((CmdbModelObjectNode) o).getModelObject() == null) {
								// handle bad child - guid exists (e.g. target of relationship) but no model object
								continue;
							}
							if (verbose) {
								System.out.println("Getting children for " + //$NON-NLS-1$
										((CmdbModelObjectNode) o).getModelObject().getClass().getSimpleName() + ", list size=" + listSize); //$NON-NLS-1$
							}
						}
						List<ICmdbNode> children = ((ICmdbNode) o).getChildren();
						/* Thread.sleep(1); */
					}
				}
		}
	};
}
