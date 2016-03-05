/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.couchcontroller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 *
 * @author ziron_000
 */
public class Actions {
    
    private String url;
    private String username;
    private String pass;
    private String db;
    
    public Actions(String url, String username, String pass, String db) {
        this.url = url;
        this.username = username;
        this.pass = pass;
        this.db = db;
    }
    private HttpURLConnection connection(String action, String method) throws Exception {
       return new Connection(url+"/"+db+"/"+action, username, pass).connect(method);
    }
    
    public void truncateDb() {
        
    }
    
    public void getView(String view) throws Exception {
        HttpURLConnection con = connection(view,"GET");
        
        con.setDoOutput(true);
        System.out.println(con.getResponseCode());
        System.out.println(con.getResponseMessage());
        
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        //System.out.println(response.toString());
        System.out.println("finished");
    }
}
