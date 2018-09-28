package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DomainPackager;
import com.ibm.ccl.soa.deploy.core.extension.IDomainPackagerDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a wrapper around <b>&lt;domains /&gt;</b> configuration elements parsed from the
 * <b>com.ibm.ccl.soa.deploy.core.domains/packager</b> extension point.
 * 
 * @see ICommonDeployExtensionConstants#TAG_PACKAGER
 */
public class DomainPackagerDescriptor extends CommonDescriptor implements IDomainPackagerDescriptor {
	/**
	 * The constructor for the domain packager descriptor
	 * 
	 * @param anElement
	 */
	public DomainPackagerDescriptor(IConfigurationElement anElement) {
		super(anElement);
		Assert.isTrue(TAG_PACKAGER.equals(anElement.getName()));
	}

	/**
	 * Create an instance of the domain packager for this descriptor
	 * 
	 * @return an instance of the domain packager
	 */
	public DomainPackager createDomainPackager() {
		try {
			Object instance = getElement().createExecutableExtension(ATT_CLASS);
			if (instance instanceof DomainPackager) {
				return (DomainPackager) instance;
			}

			String errMsg = NLS
					.bind(
							DeployCoreMessages.UnitProviderDescriptor_An_instance_of_TopologyUnitProvider_is_required,
							new Object[] { DomainPackager.class.getName(), ATT_CLASS,
									getElement().getDeclaringExtension().getExtensionPointUniqueIdentifier() });
			DeployCorePlugin.logError(0, errMsg, null);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} catch (RuntimeException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		return SkeletonDomainPackager.INSTANCE;
	}
}
