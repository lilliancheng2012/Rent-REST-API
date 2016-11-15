package nz.co.zufang.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import nz.co.zufang.Bootstrap;
import nz.co.zufang.controller.InfoCreateRequest;
import nz.co.zufang.controller.InfoUpdateRequest;
import nz.co.zufang.model.Info;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
@WebAppConfiguration

public class InfoServiceTest {
	@Autowired
	InfoService infoService;
	
	@Before
    public void testCreateInfo() {
		//To test create new info success with valid inputs
		InfoCreateRequest infoCreateRequest= new InfoCreateRequest();
		infoCreateRequest.setTitle("House rent");
		infoCreateRequest.setKeywords("Penrose");
		infoCreateRequest.setDescription("good house in Penrose");
		infoCreateRequest.setLinkMan("Mr. a");
		infoCreateRequest.setFee(120.00);
		infoCreateRequest.setEmail("linlin.cheng2012@gmail.com");
		infoCreateRequest.setQq("123");
	    infoCreateRequest.setPhone("0222762000");
	    infoCreateRequest.setAddress("242 Penrose Rd");
	    infoCreateRequest.setMapPoint("Auckland");
	    infoCreateRequest.setPostArea("1060");
	    
	    Info info = infoService.createInfo(infoCreateRequest);
	    assertEquals("linlin.cheng2012@gmail.com",info.getEmail());
    }
	
	@Test
    public void testGetInfoById() {
		//To test find the info by it's id
		String phone = "0222762000";
        Info info = infoService.findInfoByPhone(phone);
		Info info1 = infoService.getInfoById(info.getId());
		assertEquals("242 Penrose Rd",info1.getAddress());
    }
	
	@Ignore
	@Test
    public void testGetInfo() {
		Info info = new Info();
		info.setCity("ACK");
		info.setDistrict("central district");
		info.setSuburb("Weymouth");
		info.setDuration("3 month");
		/*info.setMinprice("600.00");
		info.setMaxprice("650.00");*/
		info.setType("single rent");
		List<Info> aa = infoService.getInfo(info, 1);
		assertEquals(1,aa.size());
	}
	
	@Test
    public void testUpdateInfo() {
		//To test update the info's details after find it by phone number
		String phone = "0222762000";
        Info info = infoService.findInfoByPhone(phone);
		InfoUpdateRequest infoUpdateRequest = new InfoUpdateRequest();
		infoUpdateRequest.setId(info.getId());
		infoUpdateRequest.setTitle("rent house");
		infoUpdateRequest.setKeywords("Penrose");
		infoUpdateRequest.setDescription("rent home in penrose");
		infoUpdateRequest.setLinkMan("Mr.b");
		infoUpdateRequest.setFee(200.00);
		infoUpdateRequest.setEmail("bbb@qq.com");
		infoUpdateRequest.setQq("111");
		infoUpdateRequest.setPhone(info.getPhone());
		infoUpdateRequest.setAddress("242 Penrose Rd MT Wellington.");
		infoUpdateRequest.setMapPoint("Wellington in Auckland");
		infoUpdateRequest.setPostArea("1061");
		Boolean isUpdated = infoService.updateInfo(infoUpdateRequest);
		assertTrue(isUpdated);
    }
	
	@Test
    public void testGetAllInfo() {
		//To test get the list for all info
		List<Info> all = infoService.getAllInfo();
		assertFalse(all.isEmpty());
	}
	
	@After
    public void testDeleteInfo() {
		//To test delete the info success after find it by phone number
		String phone = "0222762000";
        Info info = infoService.findInfoByPhone(phone);
		Boolean isDeleted = infoService.deleteInfo(info.getId());
		assertTrue(isDeleted);
	}
}
