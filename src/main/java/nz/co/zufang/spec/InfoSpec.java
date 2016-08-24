package nz.co.zufang.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import nz.co.zufang.model.Info;

public class InfoSpec implements Specification<Info> {

	private final Info info;

	public InfoSpec(Info info) {
		this.info = info;
	}

	@Override
	public Predicate toPredicate(Root<Info> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<>();
		if (StringUtils.isNotBlank(info.getCity())) {
			predicates.add(cb.like(cb.lower(root.get("city")), info.getCity().toLowerCase() + "%"));
		}
		if (StringUtils.isNotBlank(info.getDistrict())) {
			predicates.add(cb.like(cb.lower(root.get("district")), info.getDistrict().toLowerCase() + "%"));
		}
		if (StringUtils.isNotBlank(info.getSuburb())) {
			predicates.add(cb.like(cb.lower(root.get("suburb")), info.getSuburb().toLowerCase() + "%"));
		}
		if (StringUtils.isNotBlank(info.getDuration())) {
			predicates.add(cb.like(cb.lower(root.get("duration")), info.getDuration().toLowerCase() + "%"));
		}
		if (StringUtils.isNotBlank(info.getMinprice())) {
			predicates.add(cb.like(cb.lower(root.get("minprice")), info.getMinprice().toLowerCase() + "%"));
		}
		if (StringUtils.isNotBlank(info.getMaxprice())) {
			predicates.add(cb.like(cb.lower(root.get("maxprice")), info.getMinprice().toLowerCase() + "%"));
		}
		if (StringUtils.isNotBlank(info.getType())) {
			predicates.add(cb.like(cb.lower(root.get("type")), info.getType().toLowerCase() + "%"));
		}
		return cb.and(predicates.toArray(new Predicate[0]));
	}
}
