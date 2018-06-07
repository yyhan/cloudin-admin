package com.cloudin.admin.web.controller;

import com.cloudin.admin.entity.Administrator;
import com.cloudin.admin.service.AdministratorService;
import com.cloudin.commons.langs.entity.BaseResult;
import com.cloudin.commons.langs.support.datatables.DTRequest;
import com.cloudin.commons.langs.support.datatables.DTResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 小天
 * @version 1.0.0, 2018/6/6 0006 15:17
 */
@Controller
public class AdministratorController {
	
	@Resource
	private AdministratorService administratorService;
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/add.htm")
	public BaseResult add(Administrator administrator) {
		return administratorService.add(administrator);
	}
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/update.htm")
	public BaseResult update(Administrator administrator) {
		return administratorService.update(administrator);
	}
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/delete.htm")
	public BaseResult delete(Integer administratorId) {
		return administratorService.delete(administratorId);
	}
	
	@RequestMapping("/administrator/list.htm")
	public String listWithPage() {
		return "/administrator/list";
	}
	
	@ResponseBody
	@RequestMapping("/ajax/administrator/list.htm")
	public DTResponse<Administrator> listWithPage(DTRequest request) {
		return administratorService.listWithPage(request);
	}
}
