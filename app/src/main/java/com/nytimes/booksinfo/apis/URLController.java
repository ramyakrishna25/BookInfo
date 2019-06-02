package com.cloudpeppers.user.apis;

public class URLController {

    //public static String BASE_URL = "http://35.165.108.250:8080/CloudPeppers-V2/";
    //public static String BASE_URL = "http://35.165.108.250:8080/chompapi/";
    //public static String BASE_URL = "http://35.165.108.250:8080/CloudPeppers-V2/";    //Production URL
    //  public static String BASE_URL = "http://35.165.108.250:8080/CloudPeppers-V2_QA/";   //QA URL
// public static String BASE_URL = "http://35.165.108.250:8080/CloudPeppers-V2_dev/";   //QA URL
    // public static String BASE_URL = "http://172.26.9.64:8080/";
//    public static String BASE_URL = "http://172.26.9.64:8080/";
//    public static String BASE_URL = "http://172.26.9.61:8080/";
    // public static String SERVER_IP = "http://35.165.108.250:8080/";   //QA URL
    //  public static String AWS_SERVER_IP = "http://34.213.234.171:8080/";   //QA URL
    //public static String BASE_URL = SERVER_IP +"CloudPeppers-V2_QA/";   //QA URL
    public static String SERVER_IP = "http://34.213.234.171:8080/";
    //public static String BASE_URL = SERVER_IP +"CloudPeppers-V2_dev/";   //dev URL
    public static String BASE_URL = "https://api.nytimes.com/svc/books/v3/lists/";   //dev URL
   // public static String BASE_URL = SERVER_IP +"CloudPeppers-V2_new_qa/";   //dev URL
    public static String AWS_BASE_URL = SERVER_IP +"CloudPeppers_common/api/common/";   //aws URL

    public static String HELP = SERVER_IP +"cpadminportal/faq.html";   //aws URL

    ;

//    http://34.213.234.171:8080/CloudPeppers_common/api/common


    //public static String BASE_URL = "http://172.26.9.64:8080/";   //QA URL
    //public static String BASE_URL = "http://172.26.9.64/"; //Ganesh Vanam Local Server
    public static String REGISTRATION_URL = BASE_URL + "saveParent";
    public static String LOGIN_URL = BASE_URL + "loginParent";
    public static String SPLASH_DETAILS = BASE_URL + "loginParent";

    //http://35.165.108.250:8080/CloudPeppers-V2/getOrganizationInfo


}
