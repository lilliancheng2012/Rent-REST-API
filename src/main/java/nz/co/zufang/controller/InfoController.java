package nz.co.zufang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nz.co.zufang.model.Info;
import nz.co.zufang.service.InfoService;

/**
 * Created by Lillian on 2/25/2016.
 */
@RestController
public class InfoController {
	
	@Autowired
	InfoService infoService;

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public Info getInfo(@PathVariable String id){
    	Info info = infoService.getInfoById(id);
    	return info;
    }
    
    
    @RequestMapping(value = "/createInfo/", method = RequestMethod.POST)
    public ResponseEntity<Info> createInfo(@RequestBody InfoCreateRequest infoCreateRequest){
    	Info info = infoService.createInfo(infoCreateRequest);
    	return new ResponseEntity<Info>(info, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/updateInfo/", method = RequestMethod.POST)
    public ResponseEntity<Boolean> updateInfo(@RequestBody InfoUpdateRequest infoUpdateRequest){
    	Boolean isUpdated = infoService.updateInfo(infoUpdateRequest);
    	return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/deleteInfo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteInfo(@PathVariable String id){
    	Boolean isDeleted = infoService.deleteInfo(id);
    	return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Info> listInfo(){
    	return infoService.getAllInfo();
    }
    
    @RequestMapping(value = "/page/{city}/{district}/{suburb}/{duration}/{minprice}/{maxprice}/{type}/{pid}",method = RequestMethod.GET)
    public List<Info> getInfo(@PathVariable String city,
    		@PathVariable String district,
    		@PathVariable String suburb,
    		@PathVariable String duration,
    		@PathVariable String minprice,
    		@PathVariable String maxprice,
    		@PathVariable String type,
    		@PathVariable int pid){
    	Info info = new Info();
//    	info.setCity("*".equals(city)?null:city);
//    	info.setDistrict("*".equals(district)?null:district);
//    	info.setSuburb("*".equals(suburb)?null:suburb);
//    	info.setDuration("*".equals(duration)?null:duration);
//    	info.setMinprice("*".equals(minprice)?null:minprice);
//    	info.setMaxprice("*".equals(maxprice)?null:maxprice);
//    	info.setType("*".equals(type)?null:type);
    	return infoService.getInfo(info,pid);
    }
    
}
