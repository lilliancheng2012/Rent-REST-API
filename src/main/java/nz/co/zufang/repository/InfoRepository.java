package nz.co.zufang.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import nz.co.zufang.model.Info;

@Repository
public interface InfoRepository extends JpaRepository<Info, String>,JpaSpecificationExecutor<Info> {
	
	List<Info> findByTitleNotNull(String title, Pageable pageable);
}
