package commonAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import modals.AccessToken;
import modals.Token;
import modals.TokenStatus;
import modals.TopGames;
import modals.User;

public class FetchData {

public static TopGames getTopGames(String code) throws MalformedURLException {
		
		TopGames obj= null;
		
		String client_Id = "fe1xi3mppo2ecie1rg4v02peiz2ig7";
		
		
		// initializing token string
		String token = code;

		// getToken body data
		

		// initializing URL end point
		String getTopGamesURL ="https://api.twitch.tv/helix/games/top";
		
		
		
		
		//getTokenRequest.setRequestProperty("Authorization", token);
			
		System.out.println();
		
		 StringBuilder result = new StringBuilder();
	      URL url = new URL(getTopGamesURL);
	      
	     
	      HttpURLConnection conn = null;
	     
	      
		
	      try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      conn.setRequestProperty("Client-ID", client_Id);
	      BufferedReader rd = null;
		try {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      String line;
	      try {
			while ((line = rd.readLine()) != null) {
			     result.append(line);
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			rd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      Gson gson = new Gson();
	      obj = gson.fromJson(result.toString(), TopGames.class);  
	      
	      System.out.println(obj.toString());
	      return obj ;
	   }
			
public static String getTokenDetails(String token) {
	
	
	
	

	// getToken body data
	

	// initializing URL end point
	String getUserURL ="https://api.twitch.tv/kraken/";
	
	
	
	
	
		
	System.out.println();
	
	 StringBuilder result = new StringBuilder();
      URL url = null;
	try {
		url = new URL(getUserURL);
	} catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      HttpURLConnection conn = null;
	try {
		conn = (HttpURLConnection) url.openConnection();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      try {
		conn.setRequestMethod("GET");
	} catch (ProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      //conn.setRequestProperty("Client-ID", client_Id);
      
      String oauth= "OAuth "+token;
      
      conn.setRequestProperty("Authorization", oauth);
      conn.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
      
      BufferedReader rd = null;
	try {
		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      String line;
      try {
		while ((line = rd.readLine()) != null) {
		     result.append(line);
		     
		  }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      try {
		rd.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      try {
    	  System.out.println(conn.getResponseCode());
		System.out.println(conn.getResponseMessage());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      JSONObject obj = new JSONObject(result.toString());

      String user_id = obj.getJSONObject("token").getString("user_id");

      System.out.println(user_id);
      
      return user_id ;
}

public static User getUserInfo(String id) {
	
		String client_Id = "fe1xi3mppo2ecie1rg4v02peiz2ig7";

		// initializing URL end point
		String getUserURL ="https://api.twitch.tv/kraken/users/"+id;
		
		User obj= null;
		
		
		
			
		System.out.println(getUserURL);
		
		 StringBuilder result = new StringBuilder();
	      URL url = null;
		try {
			url = new URL(getUserURL);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			conn.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      //conn.setRequestProperty("Client-ID", client_Id);
	      
	      
	      
	      conn.setRequestProperty("Client-ID", client_Id);
	      conn.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
	      
	      BufferedReader rd = null;
		try {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      String line;
	      try {
			while ((line = rd.readLine()) != null) {
			     result.append(line);
			     
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			rd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      try {
	    	  System.out.println(conn.getResponseCode());
			System.out.println(conn.getResponseMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      Gson gson = new Gson();
	      obj = gson.fromJson(result.toString(), User.class);  
	      
	    
	      
	      return obj ;
	
}
	
	
}
