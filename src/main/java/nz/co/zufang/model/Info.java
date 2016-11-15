package nz.co.zufang.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Lillian on 2/25/2016.
 */
@Entity
@Table(name = "TBL_INFO")
public class Info{
    @Id
    @Column(name = "ID", unique = true)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    public String id;
    @Column(name = "TITLE")
    public String title;
    @Column(name = "CONTENT")
    public String content;
    @Column(name = "THUMB")
    public String thumb;
    @Column(name = "KEYWORDS")
    public String keywords;
    @Column(name = "DESCRIPTION")
    public String description;
    @Column(name = "LINKMAN")
    public String linkMan;
    @Column(name = "FEE")
    public Double fee;
    @Column(name = "EMAIL")
    public String email;
    @Column(name = "QQ")
    public String qq;
    @Column(name = "PHONE")
    public String phone;
    @Column(name = "ADDRESS")
    public String address;
    @Column(name = "MAP_POINT")
    public String mapPoint;
    @Column(name = "POST_AREA")
    public String postArea;
    @Column(name = "POST_DATE")
    public Date postDate;
    @Column(name = "END_DATE")
    public Date endDate;
    @Column(name = "IP")
    private String ip;
    @Column(name = "CLICK")
    public int click;
    @Column(name = "IS_PRO")
    public boolean isPro;
    @Column(name = "IS_TOP")
    public boolean isTop;
    @Column(name = "TOP_TYPE")
    public String topType;
    @Column(name = "IS_CHECK")
    public boolean isCheck;

    
    @Column(name = "CITY")
    public String city;
    
    @Column(name = "DISTRICT")
    public String district;
    
    @Column(name = "SUBURB")
    public String suburb;
    
    @Column(name = "DURATION")
    public String duration;
    
    @Column(name = "MINPRICE")
    public String minprice;
    
    @Column(name = "MAXPRICE")
    public String maxprice;
    
    @Column(name = "PRICE")
    public double price;
    
    @Column(name = "TYPE")
    public String type;

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
