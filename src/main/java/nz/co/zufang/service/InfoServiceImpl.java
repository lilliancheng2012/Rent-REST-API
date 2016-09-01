package nz.co.zufang.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import nz.co.zufang.controller.InfoCreateRequest;
import nz.co.zufang.controller.InfoUpdateRequest;
import nz.co.zufang.model.Info;
import nz.co.zufang.repository.InfoRepository;
import nz.co.zufang.spec.InfoSpec;

@Service
public class InfoServiceImpl implements InfoService{
	
	private static final int PAGE_SIZE = 5;
	
	@Autowired
	InfoRepository infoRepository;

	@Override
	public Info getInfoById(String id) {
		return infoRepository.findOne(id);
	}

	
	@Override
	public Boolean createInfo(InfoCreateRequest infoCreateRequest) {
		Info info = new Info();
		info.setTitle(infoCreateRequest.getTitle());
		info.setKeywords(infoCreateRequest.getKeywords());
		info.setDescription(infoCreateRequest.getDescription());
		info.setLinkMan(infoCreateRequest.getLinkMan());
		info.setFee(infoCreateRequest.getFee());
		info.setEmail(infoCreateRequest.getEmail());
		info.setQq(infoCreateRequest.getQq());
		info.setPhone(infoCreateRequest.getPhone());
		info.setAddress(infoCreateRequest.getAddress());	
		info.setMapPoint(infoCreateRequest.getMapPoint());
		info.setPostArea(infoCreateRequest.getPostArea());
	    info.setPostDate(new Date());
	    info.setEndDate(new Date());
		info = infoRepository.save(info);
		if(info.getId()!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean updateInfo(InfoUpdateRequest infoUpdateRequest) {
		Info info = infoRepository.findOne(infoUpdateRequest.getId());
//		Info info = new Info();
		info.setTitle(infoUpdateRequest.getTitle());
		info.setKeywords(infoUpdateRequest.getKeywords());
		info.setDescription(infoUpdateRequest.getDescription());
		info.setLinkMan(infoUpdateRequest.getLinkMan());
		info.setFee(infoUpdateRequest.getFee());
		info.setEmail(infoUpdateRequest.getEmail());
		info.setQq(infoUpdateRequest.getQq());
		info.setPhone(infoUpdateRequest.getPhone());
		info.setAddress(infoUpdateRequest.getAddress());
		info.setMapPoint(infoUpdateRequest.getMapPoint());
		info.setPostArea(infoUpdateRequest.getPostArea());
		info.setPostDate(new Date());
		info.setEndDate(new Date());
		infoRepository.save(info);
		return true;
	}
	
	@Override
	public Boolean deleteInfo(String id) {
		infoRepository.delete(id);
		return true;
	}
	
	@Override
	public List<Info> getAllInfo() {
		return (List<Info>) infoRepository.findAll();
	}
	
	@Override
	public List<Info> getInfo(Info info, int pageNumber) {
		InfoSpec infoSpec = new InfoSpec(info);
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "postDate");
		List<Info> infos = infoRepository.findAll(infoSpec,request).getContent();
		return infos;
	}
	
	@Override
	public Info findInfoByPhone(String phone){
		Info info = infoRepository.findInfoByPhone(phone);
		return info;
	}
}
