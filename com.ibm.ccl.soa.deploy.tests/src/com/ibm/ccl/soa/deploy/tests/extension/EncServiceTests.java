/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.internal.core.extension.EncService;

/**
 * JUnit test case for password encryption/decryption
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class EncServiceTests extends TopologyTestCase {

	/** Test case ctor */
	public EncServiceTests() {
		super("EncServiceTests"); //$NON-NLS-1$
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * Test encyption/decryption of passwords
	 * 
	 * @throws Exception
	 */
	public void testPasswordEncryptionDecryptionCryptoCipherImpl()
			throws Exception {
		// -----------------------
		// Basic tests
// System.out.println("Test testPasswordEncryptionDecryptionCryptoCipherImpl");
		String password = "password";
		String es = EncService.INSTANCE.encrypt(password);
// System.out.println("encrypted password = " + es);
// System.out.println("decrypted password = " +
// EncService.INSTANCE.decrypt(es));
		assert (es.length() != password.length());
		assert password.equals(EncService.INSTANCE.decrypt(EncService.INSTANCE
				.encrypt(password)));

		// -----------------------
		// Illegal argument handling
		String tmp;
		tmp = EncService.INSTANCE.encrypt("");
		tmp = EncService.INSTANCE.encrypt(null);
		assert (tmp == null);

		boolean eae = false;
		try {
			tmp = EncService.INSTANCE.decrypt("");
		} catch (IllegalArgumentException iae) {
			eae = true;
		}
		assert (eae);

		tmp = EncService.INSTANCE.decrypt(null);
		assert (tmp == null);

		// short key test (encryption only)
		boolean cryptoExceptionOccurred = false;
		try {
			EncService.INSTANCE.encrypt("password", "0123456");
		} catch (IllegalArgumentException e) {
// System.out.println("Expected IllegalArgumentException occurred when trying to
// use short key");
			cryptoExceptionOccurred = true;
		}
		assert (cryptoExceptionOccurred == true);

		// Not decodable test
		byte notDecodableBytes[] = { 0x41, 0x60, 0x79 };
		String notDecodable = new String(notDecodableBytes);
		eae = false;
		try {
			tmp = EncService.INSTANCE.decrypt(notDecodable);
		} catch (IllegalArgumentException iae) {
			eae = true;
		}
		assert (eae);

		// Decrypt with wrong key
		String ep1 = EncService.INSTANCE.encrypt("password", "01234567");
		try {
			String dp1 = EncService.INSTANCE.decrypt(ep1, "0123456X");
		} catch (IllegalArgumentException e) {
// System.out.println("Expected IllegalArgumentException occurred on attempted
// decrypt with wrong key");
			cryptoExceptionOccurred = true;
		}
		assert (cryptoExceptionOccurred == true);

		// -----------------------
		// Varying length plaintexts, 0-9 bytes
		int testStringCnt = 11;
		String p[] = new String[testStringCnt];
		p[0] = "0";
		p[1] = "01";
		p[2] = "012";
		p[3] = "0123";
		p[4] = "01234";
		p[5] = "012345";
		p[6] = "0123456";
		p[7] = "01234567";
		// 9 characters
		p[8] = "012345678";
		// repeat of p[5]
		p[9] = "012345";
		p[10] = "";

		String ep[] = new String[testStringCnt];
		for (int i = 0; i < testStringCnt; ++i) {
			ep[i] = EncService.INSTANCE.encrypt(p[i]);
		}

		String dp[] = new String[testStringCnt];
		for (int i = 0; i < testStringCnt; ++i) {
			dp[i] = EncService.INSTANCE.decrypt(ep[i]);
		}

		for (int i = 0; i < testStringCnt; ++i) {
// System.out.println("p=["+p[i]+"] ep=["+ep[i]+"] dp=["+dp[i]+"]");
			assert (p[i].equals(dp[i]));
			assert (!(p[i].equals(ep[i])));
		}

		assert (p[9].equals(p[5]));
		assert (ep[9].equals(ep[5]));
		assert (ep[9].equals(ep[5]));
		assert (dp[9].equals(dp[5]));

		// -----------------------
		// test with passed-in key
		String sample_configuration_key = "a82r/qJt";
		String enc_password = EncService.INSTANCE.encrypt("password",
				sample_configuration_key);
		String dec_password = EncService.INSTANCE.decrypt(enc_password,
				sample_configuration_key);
		String reenc_password = EncService.INSTANCE.encrypt(dec_password,
				sample_configuration_key);
// System.out.println("enc_password=["+enc_password+
// "] dec_password=["+dec_password+
// "] reenc_password=["+reenc_password+"]");
		assert (enc_password.equals(reenc_password));

		// -----------------------
		// Test decrypt of modified ciphertext
		String modified_enc_password = enc_password;
		modified_enc_password = modified_enc_password.replaceFirst(
				modified_enc_password.substring(0, 1), "p4");
		assert (!modified_enc_password.equals(enc_password));
		cryptoExceptionOccurred = false;
		String dec_modified_password = null;
		try {
			dec_modified_password = EncService.INSTANCE.decrypt(
					modified_enc_password, sample_configuration_key);
		} catch (IllegalArgumentException e) {
// System.out.println("Expected IllegalArgumentException occurred on attempted
// decrypt of modified ciphertext");
			cryptoExceptionOccurred = true;
		}
		assert (cryptoExceptionOccurred == true);
// System.out.println("modified_enc_password=["+modified_enc_password+
// "] dec_modified_dcm_password=["+dec_modified_password+"]");

		// -----------------------
		// Timing tests. (About 1ms or less per encrypt/decrypt of 8 byte
		// password)
		long prevTime = System.currentTimeMillis();
		String encPassword = null;
		for (int i = 0; i < 100; ++i) {
			encPassword = EncService.INSTANCE.encrypt("mypasswd");
		}
		long time = System.currentTimeMillis();
// System.out.println(this.getName() + " : Elapsed milliseconds for encryption
// of 100 passwords = " + (time-prevTime)); //$NON-NLS-1$

		prevTime = System.currentTimeMillis();
		String decPassword = null;
		for (int i = 0; i < 100; ++i) {
			decPassword = EncService.INSTANCE.decrypt(encPassword);
		}
		time = System.currentTimeMillis();
// System.out.println(this.getName() + " : Elapsed milliseconds for encryption
// of 100 passwords = " + (time-prevTime)); //$NON-NLS-1$

	}
}
