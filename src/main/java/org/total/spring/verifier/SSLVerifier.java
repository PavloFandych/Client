package org.total.spring.verifier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.IOException;
import java.security.cert.Certificate;

/**
 * @author Pavlo.Fandych
 */

public final class SSLVerifier {

    private static final Log log = LogFactory.getLog(SSLVerifier.class);

    public static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new IgnoreCertificatesTrustManager();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    public static void print_https_cert(HttpsURLConnection con) {
        if (con != null) {
            try {
                log.debug("Response Code : " + con.getResponseCode());
                log.debug("Cipher Suite : " + con.getCipherSuite());
                log.debug("\n");
                Certificate[] certs = con.getServerCertificates();
                for (Certificate cert : certs) {
                    log.debug("Cert Type : " + cert.getType());
                    log.debug("Cert Hash Code : " + cert.hashCode());
                    log.debug("Cert Public Key Algorithm : " + cert.getPublicKey().getAlgorithm());
                    log.debug("Cert Public Key Format : " + cert.getPublicKey().getFormat());
                    log.debug("\n");
                }
            } catch (SSLPeerUnverifiedException e) {
                log.error(e, e);
            } catch (IOException e) {
                log.error(e, e);
            }
        }
    }
}