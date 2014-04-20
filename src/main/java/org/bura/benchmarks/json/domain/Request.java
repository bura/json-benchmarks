package org.bura.benchmarks.json.domain;

import java.util.Map;

/**
 * The request data.
 * 
 * @author Andrey Bloschetsov
 */
public class Request {

    private String method;
    private String host;
    private String path;
    private Map<String, String> params;
    private Map<String, String> headers;

    public Request() {
    }

    public Request(String method, String host, String path, Map<String, String> params, Map<String, String> headers) {
        this.method = method;
        this.host = host;
        this.path = path;
        this.params = params;
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

}
