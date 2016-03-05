/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.couchcontroller;

/**
 *
 * @author ziron_000
 */
public class CouchController {
    private String url;
    private String username;
    private String pass;
    private String db;
    public CouchController(String url, String db) {
        this(url, null, null, db);
    }
    
    public CouchController(String url, String username, String pass, String db) {
        this.url = url;
        this.username = username;
        this.pass = pass;
        this.db = db;
    }
    
    public Actions actions() {
        return new Actions(this.getUrl(), this.getUsername(), this.getPass(), this.getDb());
    }
    
    public String getUrl() {
        return url;
    }
    public String getUsername(){
        return username;
    }
    public String getPass() {
        return pass;
    }
    public String getDb() {
        return db;
    }
    
    public void insert() {
        System.out.println("insert");
    }
    
    public void getView(String view) throws Exception {
        actions().getView(view);
    }
}
