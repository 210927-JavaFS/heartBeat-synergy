package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.HBTopGenre;
import com.revature.models.HBUserAccount;

public interface HBTopGenreDAO extends JpaRepository<HBTopGenre, Integer>{
	
	List<HBTopGenre> findByUser(HBUserAccount user);
	
	void deleteByUser(HBUserAccount user);

}
