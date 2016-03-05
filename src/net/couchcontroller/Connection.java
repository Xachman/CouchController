/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.couchcontroller;

import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author ziron_000
 */
public class Connection {
    private String url;
    private String username;
    private String pass;
    public Connection(String url) {
        this(url, null, null);
    }
    
    public Connection(String url, String username, String pass) {
        this.url = url;
        this.username = username;
        this.pass = pass;
    }
    
    public HttpURLConnection connect(String method) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        authenticate(con);
        return con;
    }
    
    private void authenticate(HttpURLConnection con) {
        if(username != null && pass != null) {
            //con.setRequestProperty("User-Agent", USER_AGENT);
            String basicAuth = "Basic " + new String(new Base64().encode(new String(username+":"+pass).getBytes()));
            con.setRequestProperty("Authorization", basicAuth); 
        }
    }
}
