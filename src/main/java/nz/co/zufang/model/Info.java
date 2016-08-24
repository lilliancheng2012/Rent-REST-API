package nz.co.zufang.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mark on 2/25/2016.
 */
@Entity
@Table(name = "TBL_INFO")
public class Info{
    @Id
    @Column(name = "ID", unique = true)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "THUMB")
    private String thumb;
    @Column(name = "KEYWORDS")
    private String keywords;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "LINKMAN")
    private String linkMan;
    @Column(name = "FEE")
    private Double fee;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "QQ")
    private String qq;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "MAP_POINT")
    private String mapPoint;
    @Column(name = "POST_AREA")
    private String postArea;
    @Column(name = "POST_DATE")
    private Date postDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "IP")
    private String ip;
    @Column(name = "CLICK")
    private int click;
    @Column(name = "IS_PRO")
    private boolean isPro;
    @Column(name = "IS_TOP")
    private boolean isTop;
    @Column(name = "TOP_TYPE")
    private String topType;
    @Column(name = "IS_CHECK")
    private boolean isCheck;

    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "DISTRICT")
    private String district;
    
    @Column(name = "SUBURB")
    private String suburb;
    
    @Column(name = "DURATION")
    private String duration;
    
    @Column(name = "MINPRICE")
    private String minprice;
    
    @Column(name = "MAXPRICE")
    private String maxprice;
    
    @Column(name = "PRICE")
    private double price;
    
    @Column(name = "TYPE")
    private String type;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
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

    public String getPostArea() {
        return postArea;
    }

    public void setPostArea(String postArea) {
        this.postArea = postArea;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public boolean isPro() {
        return isPro;
    }

    public void setPro(boolean pro) {
        isPro = pro;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public String getTopType() {
        return topType;
    }

    public void setTopType(String topType) {
        this.topType = topType;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMinprice() {
		return minprice;
	}

	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}

	public String getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(String maxprice) {
		this.maxprice = maxprice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    
    
}