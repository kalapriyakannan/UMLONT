package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

/**
 * @since 7.0
 * 
 */
public class DeployObjectTransfer extends ByteArrayTransfer {
	protected static final String TYPE_NAME = "deploy-transfer-format"; //$NON-NLS-1$
	protected static final int TYPE_ID = registerType(TYPE_NAME);
	protected static DeployObjectTransfer instance;
	protected long _startTime;
	protected Object _object;

	protected DeployObjectTransfer() {
	}

	public static DeployObjectTransfer getInstance() {
		if (instance == null) {
			instance = new DeployObjectTransfer();
		}

		return instance;
	}

	protected int[] getTypeIds() {
		return new int[] { TYPE_ID };
	}

	public String[] getTypeNames() {
		return new String[] { TYPE_NAME };
	}

	public void javaToNative(Object object, TransferData transferData) {
		_startTime = System.currentTimeMillis();
		_object = object;
		if (transferData != null) {
			super.javaToNative(String.valueOf(_startTime).getBytes(), transferData);
		}
	}

	public Object nativeToJava(TransferData transferData) {
		long startTime = Long.valueOf(new String((byte[]) super.nativeToJava(transferData)))
				.longValue();
		return _startTime == startTime ? _object : null;
	}
}
