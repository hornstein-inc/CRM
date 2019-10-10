package commonAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;

import hello.Test;
import modals.AccessToken;

public class FetchAccess {

	
	
	public static AccessToken getToken(String code) throws MalformedURLException {
		
		AccessToken obj= null;
		
		String client_Id = "fe1xi3mppo2ecie1rg4v02peiz2ig7";
		String client_Secret = "tpigsj842mlt0qk3mh80mfnsz2uty0";
		String grant_type = "authorization_code";
		String redirect_uri="http://localhost:8080/greeting";
		
		// initializing token string
		String token = code;

		// getToken body data
		

		// initializing URL end point
		URL getTokenURLobject = new URL("https://id.twitch.tv/oauth2/token?client_id="+client_Id+"&client_secret="+client_Secret+"&code="+code+"&grant_type="+grant_type+"&redirect_uri="+redirect_uri);
		
		//System.out.println("URL "+getTokenURLobject);
		// initializing and building request method and headers.
		HttpURLConnection getTokenRequest = null;
		try {
			getTokenRequest = (HttpURLConnection) getTokenURLobject.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getTokenRequest.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getTokenRequest.setRequestProperty("Authorization", token);
		getTokenRequest.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
		
		
		getTokenRequest.setDoOutput(true);

		// Sending the request.
		OutputStream getTokenOutputStream = null;
		try {
			getTokenOutputStream = getTokenRequest.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			getTokenOutputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getTokenOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// fetching response code.
		int getTokenResponseCode = 0;
		try {
			getTokenResponseCode = getTokenRequest.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("/getAccessToken Response Code :  " + getTokenResponseCode  );
		try {
			System.out.println("/getAccessToken Response Message : " + getTokenRequest.getResponseMessage() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if response code is 200, continue.
		if (getTokenResponseCode == 200) { // success
			// Writing response data
			BufferedReader getTokenBufferReader = null;
			try {
				getTokenBufferReader = new BufferedReader(new InputStreamReader(getTokenRequest.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String getTokenInputLine;
			StringBuffer getTokenResponse = new StringBuffer();
			try {
				while ((getTokenInputLine = getTokenBufferReader.readLine()) != null) {
					getTokenResponse.append(getTokenInputLine);

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				getTokenBufferReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// inserting response body to string (token)
			token = getTokenResponse.toString();

			Gson gson = new Gson();
			obj = gson.fromJson(token, AccessToken.class);  
			
			// printing the fetched token.
			System.out.println("JSON: " + token + "\n");
			

		}
		return obj;

	}
	
	
	
}
