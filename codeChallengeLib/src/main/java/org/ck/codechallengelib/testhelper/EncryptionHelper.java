package org.ck.codechallengelib.testhelper;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionHelper {
  private EncryptionHelper() {}

  public static String encrypt(final String plainText, final String key) {
    final SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
    final byte[] initializationVector = getInitializationVector();

    try {
      final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(128, initializationVector));

      final byte[] encryptedData = cipher.doFinal(plainText.getBytes());

      final Base64.Encoder encoder = Base64.getEncoder();
      final byte[] baseData = encoder.encode(encryptedData);
      final byte[] baseInitializationVector = encoder.encode(initializationVector);

      return "%s@%s".formatted(new String(baseInitializationVector), new String(baseData));
    } catch (GeneralSecurityException e) {
      throw new IllegalStateException(e);
    }
  }

  private static byte[] getInitializationVector() {
    final byte[] initializationVector = new byte[16];

    new SecureRandom().nextBytes(initializationVector);

    return initializationVector;
  }

  public static String decrypt(final String cypherText, final String key) {
    final SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
    final String[] split = cypherText.split("@");

    final Base64.Decoder decoder = Base64.getDecoder();
    final byte[] initializationVectorBytes = decoder.decode(split[0]);
    final byte[] cypherBytes = decoder.decode(split[1]);

    try {
      final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(
          Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(128, initializationVectorBytes));

      byte[] decryptedData = cipher.doFinal(cypherBytes);

      return new String(decryptedData);
    } catch (GeneralSecurityException e) {
      throw new IllegalStateException(e);
    }
  }
}
