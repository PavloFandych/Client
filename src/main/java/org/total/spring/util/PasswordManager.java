package org.total.spring.util;

/**
 * @author Pavlo.Fandych
 */

public interface PasswordManager {

    String encodeMD5(final String password);

    String encodeBase64(final String input);

    String decodeBase64(final String input);
}
