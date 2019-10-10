package modals;

public class AccessToken {

	 String access_token;
	 String expires_in;
	 String refresh_token;
	 String scope[];
	 String token_type;
	 
	public String[] getScope() {
		return scope;
	}
	public void setScope(String[] scope) {
		this.scope = scope;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ","+"\n"
				+ " expires_in=" + expires_in + "," +"\n"
						+ " refresh_token="+ refresh_token + "," +"\n"
								+ " scope=" + scope + "," +"\n"
										+ " token_type=" + token_type + "]" +"\n";
	}
	
	
	
}
