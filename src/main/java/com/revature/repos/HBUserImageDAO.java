package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.HBUserAccount;
import com.revature.models.HBUserImage;

@Repository
public interface HBUserImageDAO extends JpaRepository<HBUserImage, Integer>
{
	List<HBUserImage> findByUser(HBUserAccount user);
	
	List<HBUserImage> deleteByUser(HBUserAccount user);
}
