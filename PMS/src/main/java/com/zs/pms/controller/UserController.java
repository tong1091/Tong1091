package com.zs.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@Controller
public class UserController {

	@Autowired
	private UserService us;

	@RequestMapping("/user/list.do")
	public String queryUser(QueryUser qu, ModelMap model, String page) {

		if (page == "" || page == null) {
			page = "1";
		}
		List<TUser> users = us.queryByPage(qu, Integer.parseInt(page));
		int pageCount = us.getPageCount(qu);
		model.addAttribute("users", users);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", page);
		model.addAttribute("query", qu);
		return "user/list";

	}

}
