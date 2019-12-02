package com.company.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.company.pojo.Invitation;
import com.company.service.InvitationService;
import com.company.util.Show;
@Controller
public class InvitationController {
	@Reference
	InvitationService invitationService;
	@RequestMapping("/find")
	public String find() {
		return "findpage";
	}
	@RequestMapping("/")
	public String index() {
		return "forward:/index.jsp";
	}
	@RequestMapping("/list")
	public String find(Model model) {
		List<Invitation> list =invitationService.find();
		System.out.println(list.size());
		model.addAttribute("list", list);
		return "list";
	}
	@RequestMapping("/findById")
	public String findById(int id, Model model) {
		Invitation invitation=invitationService.findById(id);
		model.addAttribute("invitation", invitation);
		return "info";
	}
	@RequestMapping("/add")
	public String add() {
		return "add";
	}
	@RequestMapping("/addSave")
	public String addSave(Invitation invitation) {
		invitation.setCreatedate(new Date(System.currentTimeMillis()));
		boolean flag=invitationService.add(invitation);
		System.out.println(flag);
		return "redirect:list";
	}
	@RequestMapping("/update")
	public String update(int id,Model model) {
		Invitation  invitation=invitationService.findById(id);
		model.addAttribute("invitation",invitation);
		return "update";
	}
	@RequestMapping("/update1")
	public String update1(Invitation invitation) {
		boolean flag=invitationService.update(invitation);
		System.out.println(flag);
		return "redirect:list";
		
	}@RequestMapping("/delete")
	public String delete(int[] ids) {
		System.out.println(ids.length);
		boolean flag=invitationService.delete1(ids);
		return "redirect:list";
	}
	@RequestMapping("/tofindPageList")
	public String tofindPageList() {
		return "findpage";
	}
	@RequestMapping("/fingPageList")
	public @ResponseBody Show findPageList(Integer page,Integer pageNum) {
		pageNum=5;
		System.out.println(" >>>>>>>>>>>>>");
		System.out.println(page);
		Show show=invitationService.findShow(page, pageNum);
		System.out.println(show);
		return show;
	}

}
