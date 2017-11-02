package org.total.spring.http;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.total.spring.entity.enums.HttpMethod;
import org.total.spring.verifier.IgnoreCertificatesTrustManager;
import org.total.spring.verifier.SSLVerifier;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by pavlo.fandych on 3/18/2015.
 */

@Component("httpExecutor")
public final class HttpExecutor {

    private static final Logger LOGGER = Logger.getLogger(HttpExecutor.class);

    static {
        final TrustManager[] trustAllCerts = new TrustManager[] { new IgnoreCertificatesTrustManager() };
        try {
            final SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        final HostnameVerifier hv = (String urlHostName, SSLSession session) -> {
            LOGGER.warn("Warning: URL Host: ".concat(urlHostName).concat(" vs. ").concat(String.valueOf(session.getPeerHost())));
            return true;
        };
        try {
            SSLVerifier.trustAllHttpsCertificates();
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

    private HttpExecutor() {
    }

    public static String executePost(final String targetURL, final String urlParameter,
            final Map<String, String> headerParameters) throws IOException {
        final URL url = new URL(targetURL);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.POST.name());
        for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        connection.setDoOutput(true);
        final DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(urlParameter);
        wr.flush();
        wr.close();

        connection.connect();

        InputStream instream = null;
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            if (connection.getResponseCode() != 200) {
                instream = connection.getErrorStream();
            } else {
                instream = connection.getInputStream();
            }
            final BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            return stringBuilder.toString();
        } finally {
            if (instream != null) {
                instream.close();
            }
            connection.disconnect();
        }
    }

    public static String executeGet(final String targetURL, final Map<String, String> headerParameters, final String urlParameter)
            throws IOException {
        final StringBuilder goalUrl = new StringBuilder(targetURL);

        if (urlParameter != null && !urlParameter.isEmpty()) {
            goalUrl.append(urlParameter);
        }

        final URL url = new URL(goalUrl.toString());
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.GET.name());

        for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        connection.setAllowUserInteraction(true);
        connection.connect();

        InputStream instream = null;
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            if (connection.getResponseCode() != 200) {
                instream = connection.getErrorStream();
            } else {
                instream = connection.getInputStream();
            }

            final BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            return stringBuilder.toString();
        } finally {
            if (instream != null) {
                instream.close();
            }
            connection.disconnect();
        }
    }

    public static String executeDelete(final String targetURL, final Map<String, String> headerParameters,
            final String urlParameter) throws IOException {
        final StringBuilder goalUrl = new StringBuilder(targetURL);

        if (urlParameter != null && !urlParameter.isEmpty()) {
            goalUrl.append(urlParameter);
        }

        final URL url = new URL(goalUrl.toString());
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.DELETE.name());

        for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        connection.setAllowUserInteraction(true);
        connection.connect();

        InputStream instream = null;
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            if (connection.getResponseCode() != 200) {
                instream = connection.getErrorStream();
            } else {
                instream = connection.getInputStream();
            }

            final BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            return stringBuilder.toString();
        } finally {

            if (instream != null) {
                instream.close();
            }
            connection.disconnect();
        }
    }

    public static String executePut(final String targetURL, final Map<String, String> headerParameters, final String urlParameter)
            throws IOException {
        final URL url = new URL(targetURL);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.PUT.name());
        for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        connection.setDoOutput(true);
        final DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(urlParameter);
        wr.flush();
        wr.close();

        connection.connect();

        InputStream instream = null;
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            if (connection.getResponseCode() != 200) {
                instream = connection.getErrorStream();
            } else {
                instream = connection.getInputStream();
            }
            final BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            return stringBuilder.toString();
        } finally {
            if (instream != null) {
                instream.close();
            }
            connection.disconnect();
        }
    }
}