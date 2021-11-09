package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.HBTopArtist;
import com.revature.models.HBTopGenre;
import com.revature.models.HBUserAccount;
import com.revature.repos.HBTopArtistDAO;
import com.revature.repos.HBTopGenreDAO;
import com.revature.repos.HBUserDAO;

@Service
public class HBUserService 
{
	@Autowired
	private HBUserDAO userDAO;
	
	@Autowired
	private HBTopArtistDAO artistDAO;
	
	@Autowired
	private HBTopGenreDAO genreDAO;
	
	public HBUserService(HBUserDAO userDAO, HBTopArtistDAO artistDAO, HBTopGenreDAO genreDAO)
	{
		this.userDAO = userDAO;
		this.artistDAO = artistDAO;
		this.genreDAO = genreDAO;
	}
	
	public void addGenre(HBTopGenre g){
		genreDAO.save(g);
	}
	
	public List<HBUserAccount> findAllUserAccounts()
	{
		return userDAO.findAll();
	}
	
	public HBUserAccount findAccountById(int id)
	{
		return userDAO.findById(id).get();
	}
	
	public boolean addOrUpdateHBUserAccount(HBUserAccount account)
	{
		try {
			userDAO.save(account);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}

	}
	
	public boolean addOrUpdateHBUserTopArtist(HBTopArtist artist)
	{
		try
		{
			artistDAO.save(artist);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	
	public List<HBTopArtist> findTopArtistsByUserID(int id)
	{
		HBUserAccount account = findAccountById(id);
		return artistDAO.findByUser(account);
	}
	
	public boolean deleteHBUserAccount(int id)
	{
		try {
			HBUserAccount account = findAccountById(id);
			userDAO.delete(account);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	
}
