/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.crypto.CipherOutputStream;

import org.eclipse.emf.ecore.resource.impl.CryptoCipherImpl;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @since 3.2
 * 
 * Should this implement a public interface, or not?
 */
public class EncService {
	/** singleton instance of this service */
	public static final EncService INSTANCE = new EncService();

	// 8 byte static key. 
	private static final String staticKey = "O$e>u[O1"; //$NON-NLS-1$

	/**
	 * @param bytes
	 *           byte array to encode
	 * @return base64 encoding of buffer with appended check byte
	 */
	private String encode(byte bytes[]) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(appendCheckCode(bytes));
	}

	/**
	 * @param encodedBytes
	 *           string of base64 encoded bytes
	 * @return base64 decoding of string, stripped of appended check byte.
	 * @throws IllegalArgumentException
	 */
	private byte[] decode(String encodedBytes) throws IllegalArgumentException {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] decoded = decoder.decodeBuffer(encodedBytes);
			if (hasValidCheckCode(decoded)) {
				return stripCheckCode(decoded);
			}
			// TODO throw specific crypto exception				
			throw new IllegalArgumentException();
		} catch (IOException e) {
			// TODO throw specific crypto exception
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @param plaintext
	 *           plaintext string to encrypt
	 * @return encrypted (base64 encoding of plaintext with appended check byte)
	 * @throws IllegalArgumentException
	 */
	public String encrypt(String plaintext) throws IllegalArgumentException {
		return encrypt(plaintext, staticKey);
	}

	/**
	 * @param ciphertext
	 *           base64 encoded ciphertext to decrypt
	 * @return String representing decrypted base64 encoded ciphertext
	 * @throws IllegalArgumentException
	 */
	public String decrypt(String ciphertext) throws IllegalArgumentException {
		return decrypt(ciphertext, staticKey);
	}

	/**
	 * Encrypt using parameter key
	 * 
	 * @param plaintext
	 *           plaintext string to encrypt *
	 * @param key
	 *           key string. Must be 8+ bytes
	 * @return String representing encrypted (base64 encoding of plaintext with appended check byte)
	 * @throws IllegalArgumentException
	 */
	public String encrypt(String plaintext, String key) throws IllegalArgumentException {
		if (plaintext == null)
			return null;
		try {
			CryptoCipherImpl cci = new CryptoCipherImpl(key);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			CipherOutputStream eos = (CipherOutputStream) cci.encrypt(baos);
			eos.write(plaintext.getBytes());
			eos.close();
			byte[] bytes = baos.toByteArray();
			return encode(bytes);
		} catch (IOException e) {
			// TODO throw specific crypto exception						
			throw new IllegalArgumentException();
		} catch (Exception e) {
			// TODO throw specific crypto exception									
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Decrypt using parameter key
	 * 
	 * @param base64CipherText
	 *           base64 encoded ciphertext to decrypt
	 * @param key
	 *           key to decrypt with.
	 * @return String representing decrypted base64 encoded ciphertext
	 * @throws IllegalArgumentException
	 */
	public String decrypt(String base64CipherText, String key) throws IllegalArgumentException {
		if (base64CipherText == null)
			return null;
		CryptoCipherImpl cci = new CryptoCipherImpl(key);
		try {
			byte decodedCipherText[] = decode(base64CipherText);
			ByteArrayInputStream bais = new ByteArrayInputStream(decodedCipherText);
			InputStream dis = cci.decrypt(bais);
//			String plaintext = new String();
			StringBuffer plaintext = new StringBuffer();
			int c = dis.read();
			while (c != -1) {
//				plaintext += (char)c;
				plaintext.append((char) c);
				c = dis.read();
			}
			return plaintext.toString();
		} catch (IOException e) {
			// TODO throw specific crypto exception
			throw new IllegalArgumentException();
		} catch (Exception e) {
			// TODO throw specific crypto exception			
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @param bytes
	 *           byte array to append a check code to
	 * @return copy of original byte array with an appended check code
	 */
	private byte[] appendCheckCode(byte[] bytes) {
		byte retArray[] = new byte[bytes.length + 1];
		for (int i = 0; i < bytes.length; ++i) {
			retArray[i] = bytes[i];
		}
//		retArray[bytes.length] = (byte) Arrays.hashCode(bytes);
		retArray[bytes.length] = hashByteArray(bytes);
		return retArray;
	}

	/*
	 * Same algorithm as Java 1.5 Arrays.hashCode(bytes);
	 */
	private byte hashByteArray(byte ba[]) {
		if (ba == null)
			return 0;

		int result = 1;
		for (int i = 0; i < ba.length; ++i) {
			result = 31 * result + ba[i];
		}

		return (byte) result;
	}

	/**
	 * @param bytes
	 *           byte array to remove a check code from
	 * @return bytes with appended check code removed
	 */
	private byte[] stripCheckCode(byte[] bytes) {
		byte retArray[] = new byte[bytes.length - 1];
		for (int i = 0; i < bytes.length - 1; ++i) {
			retArray[i] = bytes[i];
		}
		return retArray;
	}

	/**
	 * @param bytes
	 *           byte array to check the check code of
	 * @return true if appended check code is valid, false otherwise
	 */
	private boolean hasValidCheckCode(byte[] bytes) {
		byte tstArray[] = new byte[bytes.length - 1];
		for (int i = 0; i < bytes.length - 1; ++i) {
			tstArray[i] = bytes[i];
		}
		return (bytes[bytes.length - 1] == hashByteArray(tstArray));
	}
}
