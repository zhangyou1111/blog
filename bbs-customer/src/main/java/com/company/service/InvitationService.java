package com.company.service;

import java.util.List;

import com.company.pojo.Invitation;
import com.company.util.Show;

public interface InvitationService {
	public List<Invitation> find();
	public boolean add(Invitation invitation);
	/* public int delete(Invitation invitation); */
	public boolean update(Invitation invitation);
	public boolean delete1(int[] ids);
	public Invitation findById(int id);
	public List<Invitation> findPageList(Integer IndexFrom,Integer pageNum);
	public int findcount();
	public Show findShow(Integer page,Integer pageNum);

}
