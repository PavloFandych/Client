package org.total.spring.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component("passwordManager")
public final class PasswordManagerImpl implements PasswordManager {

    @Override
    public synchronized String encodeMD5(final String password) {
        return DigestUtils.md5Hex(password);
    }

    @Override
    public synchronized String encodeBase64(final String input) {
        return "Basic ".concat(new String(Base64.encodeBase64(input.getBytes())));
    }

    @Override
    public synchronized String decodeBase64(final String input) {
        return new String(Base64.decodeBase64(input
                .substring(input.indexOf(" ") + 1).getBytes()));
    }
}