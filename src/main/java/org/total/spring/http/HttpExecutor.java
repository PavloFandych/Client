package org.total.spring.http;

import org.apache.log4j.Logger;
import org.total.spring.entity.enums.HttpMethod;
import org.total.spring.verifier.IgnoreCertificatesTrustManager;
import org.total.spring.verifier.SSLVerifier;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pavlo.fandych on 3/18/2015.
 */

public class HttpExecutor {
    private static final Logger LOGGER = Logger.getLogger(HttpExecutor.class);
    private static final Lock SINGLETON_LOCK = new ReentrantLock();
    private static volatile HttpExecutor singletonRef;

    public static HttpExecutor getInstance() {
        if (HttpExecutor.singletonRef == null) {
            try {
                HttpExecutor.SINGLETON_LOCK.lock();
                HttpExecutor.singletonRef = new HttpExecutor();
            } finally {
                HttpExecutor.SINGLETON_LOCK.unlock();
            }
        }
        return HttpExecutor.singletonRef;
    }

    static {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new IgnoreCertificatesTrustManager()
        };
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {

        }
        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String urlHostName, SSLSession session) {
                LOGGER.warn("Warning: URL Host: " + urlHostName + " vs. "
                        + session.getPeerHost());
                return true;
            }
        };
        try {
            SSLVerifier.trustAllHttpsCertificates();
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

    public static String executePost(String targetURL,
                                     String urlParameter,
                                     Map<String, String> headerParameters) throws IOException {

        URL url = new URL(targetURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.POST.name());
        for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(urlParameter);
        wr.flush();
        wr.close();

        connection.connect();

        InputStream instream = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (connection.getResponseCode() != 200) {
                instream = connection.getErrorStream();
            } else {
                instream = connection.getInputStream();
            }
            BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append('\n');
            }
            return stringBuffer.toString();
        } finally {
            if (instream != null) {
                instream.close();
            }
            connection.disconnect();
        }
    }

    public static String executeGet(String targetURL,
                                    Map<String, String> headerParameters,
                                    String urlParameter) throws IOException {

        StringBuilder goalUrl = new StringBuilder(targetURL);

        if (urlParameter != null && !urlParameter.isEmpty()) {
            goalUrl.append(urlParameter);
        }

        URL url = new URL(goalUrl.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.GET.name());

        for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        connection.setAllowUserInteraction(true);
        connection.connect();

        InputStream instream = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (connection.getResponseCode() != 200) {
                instream = connection.getErrorStream();
            } else {
                instream = connection.getInputStream();
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append('\n');
            }
            return stringBuffer.toString();
        } finally {
            if (instream != null) {
                instream.close();
            }
            connection.disconnect();
        }
    }

    public static String executeDelete(String targetURL,
                                       Map<String, String> headerParameters,
                                       String urlParameter) throws IOException {

        StringBuilder goalUrl = new StringBuilder(targetURL);

        if (urlParameter != null && !urlParameter.isEmpty()) {
            goalUrl.append(urlParameter);
        }

        URL url = new URL(goalUrl.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.DELETE.name());

        for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        connection.setAllowUserInteraction(true);
        connection.connect();

        InputStream instream = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (connection.getResponseCode() != 200) {
                instream = connection.getErrorStream();
            } else {
                instream = connection.getInputStream();
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append('\n');
            }
            return stringBuffer.toString();
        } finally {

            if (instream != null) {
                instream.close();
            }
            connection.disconnect();
        }
    }

    public static String executePut(String targetURL,
                                    Map<String, String> headerParameters,
                                    String urlParameter) throws IOException {

        URL url = new URL(targetURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.PUT.name());
        for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }

        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(urlParameter);
        wr.flush();
        wr.close();

        connection.connect();

        InputStream instream = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (connection.getResponseCode() != 200) {
                instream = connection.getErrorStream();
            } else {
                instream = connection.getInputStream();
            }
            BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append('\n');
            }
            return stringBuffer.toString();
        } finally {
            if (instream != null) {
                instream.close();
            }
            connection.disconnect();
        }
    }
}