package nz.co.zufang.model;

/**
 * Created by Lillian on 12/03/16.
 */
public class BasicUserReg {
	
    private String email;
    private String username;
    private String password;
    private String imAccount;
    private String phone;
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
	public String getImAccount() {
        return imAccount;
    }

    public void setImAccount(String imAccount) {
        this.imAccount = imAccount;
    }
	public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
