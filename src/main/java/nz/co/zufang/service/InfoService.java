package nz.co.zufang.service;

import java.util.List;

import nz.co.zufang.controller.InfoCreateRequest;
import nz.co.zufang.controller.InfoUpdateRequest;
import nz.co.zufang.model.Info;

public interface InfoService {
	
	public Info createInfo(InfoCreateRequest infoCreateRequest);
	
	public Boolean deleteInfo(String id);
	
	public Boolean updateInfo(InfoUpdateRequest infoUpdateRequest);
	
	Info getInfoById(String id);	
	
	List<Info> getAllInfo();
	
	List<Info> getInfo(Info info, int pageNumber);
	
	Info findInfoByPhone(String phone);
	//GenericResponse
}
