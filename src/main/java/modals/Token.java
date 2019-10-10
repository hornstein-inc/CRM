package modals;

public class Token {

	private Boolean vaild;
	private Authorization authorization;
	private String userName;
	private String userId;
	private String clientId;
	private Integer expiresIn;
	public Boolean getVaild() {
		return vaild;
	}
	public void setVaild(Boolean vaild) {
		this.vaild = vaild;
	}
	public Authorization getAuthorization() {
		return authorization;
	}
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Integer getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
	@Override
	public String toString() {
		return "Token [vaild=" + vaild + ", authorization=" + authorization + ", userName=" + userName + ", userId="
				+ userId + ", clientId=" + clientId + ", expiresIn=" + expiresIn + "]";
	}
	
	
	
	
	
}
