package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;

public class StackHelper {

	/**
	 * Map from drawer/stack name to corresponding palette stack entry, or null for directly under
	 * Local Additions
	 */
	private final HashMap<String, DynamicPaletteEntry> stackMap;

	private final LinkedList<String> idsInUse;

	/**
	 * 
	 */
	public StackHelper() {
		stackMap = new HashMap<String, DynamicPaletteEntry>();
		idsInUse = new LinkedList<String>();

		DynamicPaletteEntry adpe[] = getDynamicStackEntries();
		for (int i = 0; i < adpe.length; i++) {
			idsInUse.add(adpe[i].getId());
		}
	}

	/**
	 * @return palette entries known to Resource Type Service
	 */
	public DynamicPaletteEntry[] getDynamicStackEntries() {
		return ExtensionsCore.createResourceTypeService().getDynamicStackEntries();
	}

	/**
	 * @return validator with rules for new palette entry names
	 */
	public IInputValidator getPaletteStackNameValidator() {
		return new IInputValidator() {

			public String isValid(String newText) {
				String proposedName = getDrawerStackNameStackLabel(newText);
				String proposedId = makeIdFromStackName(newText);
				if (stackMap.containsKey(proposedName) || duplicateStackId(proposedId)) {
					return Messages.BankUnitAction_Duplicate_Stack_Nam_;
				}

				if (proposedId == null || newText.length() == 0) {
					return Messages.BankUnitAction_Unsupported_characte_;
				}

				return null;
			}
		};
	}

	private boolean duplicateStackId(String proposedId) {
		return idsInUse.contains(proposedId);
	}

	public static String getDrawerStackNameStackLabel(String stackLabel) {
		String drawer = Messages.DeployCoreEditor_Local_Extension_;
		String name = NLS.bind(Messages.BankUnitAction_0_1__2, drawer, stackLabel);
		return name;
	}

	public static String makeIdFromStackName(String newText) {
		// TODO Move this method to ResourceTypeService; it knows better what characters are legal.
		// For example, are spaces legal?  I don't know....

		// We could be clever here, and handle forbidden characters by mapping to non-forbidden ones
		// in a reversible way, but instead we just ban anything that isn't already a valid palette ID
		if (newText.indexOf('/') >= 0) {
			return null;
		}

		return newText;
	}

	public String getDrawerStackNameFromPaletteEntry(DynamicPaletteEntry stackPaletteEntry) {
		String drawer = Messages.DeployCoreEditor_Local_Extension_;
		String name = drawer;
		if (stackPaletteEntry == null) {
			name = Messages.DeployCoreEditor_Local_Extension_;
		} else {
			name = StackHelper.getDrawerStackNameStackLabel(stackPaletteEntry.getLabel());
		}

		stackMap.put(name, stackPaletteEntry);
		return name;
	}

	public DynamicPaletteEntry getDrawerPaletteEntryFromName(String name) {
		return stackMap.get(name);
	}

}
