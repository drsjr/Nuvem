package tour.donnees.nuvem.resource.input;

import tour.donnees.nuvem.entity.Account;

public class AccountInput {
	
	private Long    idAccount;
	private String  login;
	//private String  password;
	private String  email;
	private Boolean status;
	//private Person  person;
	
	public AccountInput(Account account) {
		this.idAccount 	= account.getIdAccount();
		this.login 		= account.getLogin();
		this.email 		= account.getEmail();
		this.status 	= account.getStatus();
		
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
