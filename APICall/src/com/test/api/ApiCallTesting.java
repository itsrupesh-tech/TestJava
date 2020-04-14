package com.test.api;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;






public class ApiCallTesting {

	public static void main(String[] args)  throws Exception{
		String token = getToken();
		String secretKey = "secret";
		
		getSecretValue(token,secretKey);
	}

	
    private static String getToken() throws IOException {
    	String endpoint = "https://login.microsoftonline.com/8a87a890-1cbc-40d6-8c0f-d5088cf14969/oauth2/v2.0/token";
    	String postbody = "client_id=f9b7f395-ff2e-4a6a-bddb-dc0323505c74&client_secret=736dee95-56eb-45ce-af63-65ac0130b3ee&grant_type=client_credentials&scope=https://vault.azure.net/.default";
    	HttpURLConnection conn= null;
    	String token = null;
    	try{
    		URL url  = new URL( endpoint );
    		conn= (HttpURLConnection) url.openConnection();
    		conn.setReadTimeout(10000);
    		conn.setConnectTimeout(15000);
    		conn.setRequestMethod( "POST" );
    		conn.addRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
    		conn.setDoOutput( true );
    		conn.getOutputStream().write(postbody.getBytes());
    		conn.connect();
    		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		StringBuilder builder = new StringBuilder();
    		String line =null;
    		while((line=br.readLine())!=null) {
    			builder.append(line);
    		}
    		JSONObject jsonObject = new JSONObject(builder.toString());
            token = (String) jsonObject.get(Constant.ACCESS_TOKEN);
    		System.out.println("TOKEN::::"+token);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    		conn.disconnect();
    	}finally {
            if (conn != null) {
            	conn.disconnect();
            }
        }
    	System.out.println("TOKEN:::::::"+token);
    	return token; 
    }
    
	
	private static String getSecretValue(String token,String secretKey) throws IOException {
        String urlString = "https://myvaultrkj.vault.azure.net/secrets/"+secretKey+"?api-version=2016-10-01";
        URL url = new URL(urlString);
        HttpURLConnection connection = null;
        String secretValue = null;

        try {
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(Constant.GET);
            connection.setRequestProperty(Constant.METADATA,Constant.TRUE);
            connection.setRequestProperty (Constant.AUTHORIZATION, Constant.BEARER+  token);


            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, Constant.UTF_8), 100);
            String result = reader.readLine();
            JSONObject jsonObject = new JSONObject(result);
            secretValue = (String) jsonObject.get(Constant.VALUE);
			
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("SecretValue:::::::"+secretValue);
        return secretValue;
    }

}
