package nz.co.zufang.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Lillian on 2/25/2016.
 */
@Entity
@Table(name = "TBL_USER")
public class User {
    @Id
    @Column(name = "UID", unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String uid;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DT")
    private Date createdDt;
    @Column(name = "REGISTER_IP")
    private String registerIp;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGIN_TIME")
    private Date lastLoginTime;
    @Column(name = "LAST_LOGIN_IP")
    private String lastLoginIp;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SEND_MAIL_TIME")
    private Date sendMailTime;
    @Column(name = "IM_ACCOUNT")
    private String imAccount;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "MAP_POINT")
    private String mapPoint;
    @Column(name = "MONEY")
    private Double money;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_POST_TIME")
    private Date lastPostTime;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "AUTHORITIES")
    private String authorities;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LASTPASSWORDRESET")
    private Date lastPasswordReset;

    public User() {
    }

    public User(UserCreate userReg) {
        this.username = userReg.getUsername();
        this.password = userReg.getPassword();
        this.email = userReg.getEmail();
        this.createdDt = new Date();
    }


    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getSendMailTime() {
        return sendMailTime;
    }

    public void setSendMailTime(Date sendMailTime) {
        this.sendMailTime = sendMailTime;
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

    public String getMapPoint() {
        return mapPoint;
    }

    public void setMapPoint(String mapPoint) {
        this.mapPoint = mapPoint;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getLastPostTime() {
        return lastPostTime;
    }

    public void setLastPostTime(Date lastPostTime) {
        this.lastPostTime = lastPostTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Date getLastPasswordReset() {
		return lastPasswordReset;
	}

	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}
	

}
