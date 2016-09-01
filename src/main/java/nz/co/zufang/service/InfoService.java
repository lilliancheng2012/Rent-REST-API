package nz.co.zufang.service;

import java.util.List;

import nz.co.zufang.controller.InfoCreateRequest;
import nz.co.zufang.controller.InfoUpdateRequest;
import nz.co.zufang.model.Info;

public interface InfoService {
	
	Boolean createInfo(InfoCreateRequest infoCreateRequest);
	
	Boolean deleteInfo(String id);
	
	Boolean updateInfo(InfoUpdateRequest infoUpdateRequest);
	
	Info getInfoById(String id);	
	
	List<Info> getAllInfo();
	
	List<Info> getInfo(Info info, int pageNumber);
	
	Info findInfoByPhone(String phone);
	
}
