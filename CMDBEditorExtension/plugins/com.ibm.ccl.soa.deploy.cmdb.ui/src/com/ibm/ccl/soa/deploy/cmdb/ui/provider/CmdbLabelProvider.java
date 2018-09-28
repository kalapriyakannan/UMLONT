package com.ibm.ccl.soa.deploy.cmdb.ui.provider;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.ModelObject;
import com.collation.platform.model.topology.app.db.db2.Db2Database;
import com.collation.platform.model.topology.app.db.db2.Db2Instance;
import com.collation.platform.model.topology.app.db.db2.Db2System;
import com.collation.platform.model.topology.app.j2ee.websphere.WebSphereCell;
import com.collation.platform.model.topology.app.j2ee.websphere.WebSphereCluster;
import com.collation.platform.model.topology.app.j2ee.websphere.WebSphereJDBCDataSource;
import com.collation.platform.model.topology.app.j2ee.websphere.WebSphereJDBCProvider;
import com.collation.platform.model.topology.app.j2ee.websphere.WebSphereNode;
import com.collation.platform.model.topology.app.j2ee.websphere.WebSphereServer;
import com.collation.platform.model.topology.sys.ComputerSystem;
import com.collation.platform.model.topology.sys.OperatingSystem;
import com.collation.platform.model.topology.sys.aix.Aix;
import com.collation.platform.model.topology.sys.linux.Linux;
import com.collation.platform.model.topology.sys.unix.Unix;
import com.collation.platform.model.topology.sys.windows.WindowsOperatingSystem;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbQueryService;
import com.ibm.ccl.soa.deploy.cmdb.model2model.CmdbToTdmConversionUtils;
import com.ibm.ccl.soa.deploy.cmdb.provider.CmdbModelObjectNode;
import com.ibm.ccl.soa.deploy.cmdb.provider.ICmdbNode;
import com.ibm.ccl.soa.deploy.cmdb.provider.object.IModelObjectProvider;
import com.ibm.ccl.soa.deploy.cmdb.provider.object.ModelObjectProviderService;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Used for type-specific treeview labels and icons
 * 
 * TODO automated approach to making this consistent with UnitProvider.
 * 
 * @author barnold
 *
 */
public class CmdbLabelProvider extends LabelProvider implements ILabelProvider {

	private static final Image cmdbImg = createImage("icons/navigator/cmdb_16.gif"); //$NON-NLS-1$a
	
	private static final Image cmdbImgDisconnected = createImage("icons/navigator/cmdb_disconnected_16.gif"); //$NON-NLS-1$a

	private static final Image serverImg = createImage("icons/navigator/genericsvr_dgm_16.gif"); //$NON-NLS-1$

	private static final Image powerServerImg = createImage("icons/navigator/power_server_16.gif"); //$NON-NLS-1$

	private static final Image x86ServerImg = createImage("icons/navigator/x86_server_16.gif"); //$NON-NLS-1$

	private static final Image osImg = createImage("icons/navigator/os_16.gif"); //$NON-NLS-1$

	private static final Image aixOsImg = createImage("icons/navigator/aix_os_16_pal.gif"); //$NON-NLS-1$

	private static final Image redHatServerOsImg = createImage("icons/navigator/red_hat_server_pal16.gif"); //$NON-NLS-1$

	private static final Image suseLinuxServerOsImg = createImage("icons/navigator/suse_linux_server_pal16.gif"); //$NON-NLS-1$	

	private static final Image win2000OsImg = createImage("icons/navigator/win_2000_16.gif"); //$NON-NLS-1$	

	private static final Image winXPOsImg = createImage("icons/navigator/win_xp_16.gif"); //$NON-NLS-1$	

	private static final Image winServer2003Img = createImage("icons/navigator/winsvr03_dgm.gif"); //$NON-NLS-1$

	private static final Image db2SystemImg = createImage("icons/navigator/db2system_pal16.gif"); //$NON-NLS-1$a

	private static final Image db2InstanceImg = createImage("icons/navigator/db2instance_pal16.gif"); //$NON-NLS-1$a

	private static final Image db2DatabaseImg = createImage("icons/navigator/db2database_pal16.gif"); //$NON-NLS-1$a

	private static final Image wasServerImg = createImage("icons/navigator/was_server_16.gif"); //$NON-NLS-1$a	

	private static final Image wasNodeImg = createImage("icons/navigator/node_pal.gif"); //$NON-NLS-1$a	

	private static final Image wasStandaloneCellImg = createImage("icons/navigator/snglcll_pal.gif"); //$NON-NLS-1$a	

	private static final Image wasDistCellImg = createImage("icons/navigator/dstrbutdcell_pal.gif"); //$NON-NLS-1$a	

	private static final Image wasJdbcProviderImg = createImage("icons/navigator/jdbcprovider_pal.gif"); //$NON-NLS-1$a	

	private static final Image wasDatasourceImg = createImage("icons/navigator/data_source_16.gif"); //$NON-NLS-1$a	
	
	private static final Image wasClusterImg = createImage("icons/navigator/cluster_pal.gif"); //$NON-NLS-1$a	

	private static final Image placeholderImg = createImage("icons/navigator/GenericUnit_16.gif"); //$NON-NLS-1$

	/**
	 * Returns an image associated with the unit's type.
	 * 
	 * @param unitType
	 *            a subtype of {@link Unit}.
	 * @return the image (may be null)
	 */
	public static Image getUnitTypeImage(EClass unitType) {
		if ((unitType == null)
				|| (!CorePackage.eINSTANCE.getUnit().isSuperTypeOf(unitType))) {
			return null;
		}
		EObject obj = unitType.getEPackage().getEFactoryInstance().create(
				unitType);
		if (obj instanceof Unit) {
			return getUnitImage((Unit) obj);
		}
		return null;
	}

	/**
	 * Returns an image associated with the unit's type.
	 * 
	 * @param unit
	 *            a deploy unit.
	 * @return the image (may be null)
	 */
	public static Image getUnitImage(Unit unit) {
		if (unit == null) {
			return null;
		}
		Image image = IconService.getInstance().getIcon(
				new EObjectAdapter(unit),
				IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
		return image;
	}
	
	@Override
	public String getText(Object element) {
		if (element instanceof ICmdbNode) {
			return ((ICmdbNode) element).toString();
		}
		return CmdbToTdmConversionUtils.classDisplayName(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof CmdbCategory) {
			// BEGIN: AVK model object pattern link
			CmdbCategory cElement = (CmdbCategory) element;
			IModelObjectProvider provider = ModelObjectProviderService
					.getDefault().getProvider(cElement.getCategoryClassName());
			if (provider != null) {
				List<EClass> tdmTypes = provider.getProvidedTdmTypes();
				if (!tdmTypes.isEmpty()) {
					Image image = getUnitTypeImage(tdmTypes.get(0));
					if (image != null) {
						// TODO cache
						return image;
					}
				}
			}
			// END: AVK model object pattern link
			// TODO FIXME look up ModelObject type/instance and get the right
			// icon!
			return serverImg;
		} else if (element instanceof CmdbModelObjectNode) {
			CmdbModelObjectNode nElement = (CmdbModelObjectNode) element;
			ModelObject mo = (nElement).getModelObject();
			Image image = getModelObjectImage(mo);
			if (image != null) {
				return image;
			}
		} else if (element instanceof CmdbRoot) {
			if (CmdbQueryService.INSTANCE.isAPIHealthy()) {
				return cmdbImg;
			} else {
				return cmdbImgDisconnected;
			}
		}
		return super.getImage(element);
	}
	
	/**
	 * Returns an image for the model object.
	 * 
	 * @param mo a model object.
	 * @return the image or null if not found.
	 */
	protected Image getModelObjectImage(ModelObject mo) {
		if (mo == null) {
			return null;
		}
		// BEGIN: AVK model object pattern link
		IModelObjectProvider provider = ModelObjectProviderService.getDefault()
				.getProvider(mo);
		if (provider != null) {
			List<EClass> tdmTypes = provider.getProvidedTdmTypes();
			if (!tdmTypes.isEmpty()) {
				Image image = getUnitTypeImage(tdmTypes.get(0));
				if (image != null) {
					// TODO cache
					return image;
				}
			}
		}
		// END: AVK model object pattern link
			
		/** Legacy images to be migrated to {@link ModelObjectProvider} */
		if (mo instanceof ComputerSystem) {
			return getServerImage((ComputerSystem) mo);
		} else if (mo instanceof Db2System) {
			return db2SystemImg;
		} else if (mo instanceof Db2Instance) {
			return db2InstanceImg;
		} else if (mo instanceof Db2Database) {
			return db2DatabaseImg;
		} else if (mo instanceof WebSphereServer) {
			return wasServerImg;
		} else if (mo instanceof WebSphereNode) {
			return wasNodeImg;
		} else if (mo instanceof WebSphereCell) {
			return getWasCellImage((WebSphereCell) mo);
		} else if (mo instanceof WebSphereJDBCDataSource) {
			return wasDatasourceImg;
		} else if (mo instanceof WebSphereJDBCProvider) {
			return wasJdbcProviderImg;
		} else if (mo instanceof WebSphereCluster) {
			return wasClusterImg;
		} else if (mo instanceof OperatingSystem) {
			return getOperatingSystemImg((OperatingSystem) mo);
		}
		return placeholderImg;
	}

	private Image getServerImage(ComputerSystem mo) {
		if (mo.hasArchitecture()) {
			try {
				String arch = mo.getArchitecture();
				if (arch.equalsIgnoreCase("Power")) { //$NON-NLS-1$
					return powerServerImg;
				} else if (arch.equalsIgnoreCase("Intel")) { //$NON-NLS-1$
					return x86ServerImg;
				}
			} catch (AttributeNotSetException e) {
				// Should not be possible
				e.printStackTrace();
			}
		}
		return serverImg;
	}

	private Image getWasCellImage(WebSphereCell wsc) {
		try {
			if (wsc.hasType()) {
				if (wsc.getType().equals("STANDALONE")) { //$NON-NLS-1$
					return wasStandaloneCellImg;
				} else if (wsc.getType().equals("DISTRIBUTED")) { //$NON-NLS-1$
					return wasDistCellImg;
				}
			}
		} catch (AttributeNotSetException e) {
			// Should not be possible
			e.printStackTrace();
		}
		return wasDistCellImg;

	}

	private Image getOperatingSystemImg(OperatingSystem os) {
		try {
			if (os instanceof Unix) {
				if (os instanceof Aix) {
					return aixOsImg;
				} else if (os instanceof Linux) {
					Linux linuxOs = (Linux) os;
					if (linuxOs.hasOSDistribution()) {
						String dist = linuxOs.getOSDistribution();
						dist = dist.toLowerCase();
						if (dist.indexOf("redhat") >= 0) { //$NON-NLS-1$
							return redHatServerOsImg;
						} else if (dist.indexOf("suse") >= 0) { //$NON-NLS-1$
							return suseLinuxServerOsImg;
						}
					}
				}
			} else if (os instanceof WindowsOperatingSystem) {
				WindowsOperatingSystem winOs = (WindowsOperatingSystem) os;
				if (winOs.hasOSVersion()) {
					String osVersion = winOs.getOSVersion();
					osVersion = osVersion.toLowerCase();
					if (osVersion.indexOf("windows xp") >= 0) { //$NON-NLS-1$
						return winXPOsImg;
					} else if (osVersion.indexOf("windows 2000") >= 0) { //$NON-NLS-1$
						return win2000OsImg;
					} else if (osVersion.indexOf("windows server 2003") >= 0) { //$NON-NLS-1$
						return winServer2003Img;
					}
				}
			}
		} catch (AttributeNotSetException e) {
			// Should not be possible
			e.printStackTrace();
		}
		// Generic OS icon
		return osImg;
	}

	private static Image createImage(String path) {
		ImageDescriptor imgDesc = AbstractUIPlugin.imageDescriptorFromPlugin("com.ibm.ccl.soa.deploy.cmdb.ui", path); //$NON-NLS-1$
//		System.out.println("image path=" + path); //$NON-NLS-1$
		return imgDesc.createImage();
	}
}
