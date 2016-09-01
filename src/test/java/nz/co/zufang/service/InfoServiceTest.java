package nz.co.zufang.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
	
	@Test
    public void testGetInfoById() {
		String id = "4028d08155ee51000155ee5211380003";
		Info info = infoService.getInfoById(id);
		assertEquals("string",info.getAddress());
    }
	
	@Test
    public void testCreateInfo() {
		InfoCreateRequest infoCreateRequest= new InfoCreateRequest();
		infoCreateRequest.setTitle("House rent in Penrose");
		infoCreateRequest.setKeywords("house in Penrose");
		infoCreateRequest.setDescription("good house in Penrose");
		infoCreateRequest.setLinkMan("Mr. aa");
		infoCreateRequest.setFee(120.00);
		infoCreateRequest.setEmail("aaa@qq.com");
		infoCreateRequest.setQq("aaa");
	    infoCreateRequest.setPhone("12345");
	    infoCreateRequest.setAddress("242 Penrose");
	    infoCreateRequest.setMapPoint("Auckland");
	    infoCreateRequest.setPostArea("1060");
	    Boolean isCreated = infoService.createInfo(infoCreateRequest);
		assertTrue(isCreated);
    }
	
	@Test
    public void testUpdateInfo() {
		Info info = infoService.getInfoById("4028d08155ee51000155ee5210220002");
		InfoUpdateRequest infoUpdateRequest = new InfoUpdateRequest();
		infoUpdateRequest.setId(info.getId());
		infoUpdateRequest.getKeywords();
		infoUpdateRequest.getDescription();
		infoUpdateRequest.getLinkMan();
		infoUpdateRequest.getFee();
		infoUpdateRequest.getEmail();
		infoUpdateRequest.getQq();
		infoUpdateRequest.getPhone();
		infoUpdateRequest.getAddress();
		infoUpdateRequest.getMapPoint();
		infoUpdateRequest.getPostArea();
		infoUpdateRequest.setTitle("rent house");
		infoUpdateRequest.setKeywords("penrose");
		infoUpdateRequest.setDescription("rent home in penrose");
		infoUpdateRequest.setLinkMan("bb");
		infoUpdateRequest.setFee(200.00);
		infoUpdateRequest.setEmail("bbb@qq.com");
		infoUpdateRequest.setQq("bbb");
		infoUpdateRequest.setPhone("111");
		infoUpdateRequest.setAddress("242 Penrose rd mt wellington.");
		infoUpdateRequest.setMapPoint("Wellington in auckland");
		infoUpdateRequest.setPostArea("1061");
		Boolean isUpdated = infoService.updateInfo(infoUpdateRequest);
		assertTrue(isUpdated);
    }
	
	@Test
    public void testDeleteInfo() {
		String phone = "12345";
        Info info = infoService.findInfoByPhone(phone);
		Boolean isDeleted = infoService.deleteInfo(info.getId());
		assertTrue(isDeleted);
	}
	
	@Test
    public void testGetAllInfo() {
		List<Info> all = infoService.getAllInfo();
		assertEquals(31,all.size());
	}
	
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
}
