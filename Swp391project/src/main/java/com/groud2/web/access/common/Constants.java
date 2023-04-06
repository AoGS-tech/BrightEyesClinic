/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.access.common;

/**
 *
 * @author anhha
 */
public class Constants {

    public static String GOOGLE_CLIENT_ID = "440656250085-3d24uvmbsdou0vkjg15q14q8l3qdbfao.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "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";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8909/mavenproject1/loginwithgoogle";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
    ////Login with facebook
    public static String FACEBOOK_APP_ID = "1139592463416490";
    public static String FACEBOOK_APP_SECRET = "a84904acb8a7aa65164ac585854c9db5";
    public static String FACEBOOK_REDIRECT_URL = "http://localhost:8909/mavenproject1/loginwithfacebook";
    public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";

}
