package com.daquv.Controller;



import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.daquv.Service.IndexService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/api/v1/askavatar")
public class IdexController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IndexService indexService;
	
	@RequestMapping("")
	public String index(HttpServletRequest request,
									   HttpServletResponse response,
									   Model model,
									   @RequestParam HashMap param,
									   HttpSession session) throws Exception
	{
		if (request.getServerName().toLowerCase().indexOf("dev") ==-1)
		{
			return "home/home_0002_01_view";
		}
		else if(request.getServerName().toLowerCase().indexOf("dev") == -1)
		{
			
			String userAgent = request.getHeader("User-Agent").toLowerCase();
			if(userAgent.indexOf("android") > -1 || userAgent.indexOf("iphone") > -1 || userAgent.indexOf("ipad") > -1 || request.getServerName().toLowerCase().indexOf("m.askavatar") > -1 || request.getServerName().toLowerCase().indexOf("www.askavatar") > -1){
				return "redirect:https://m.askavatar.ai/home_0002_01.act";
			}
			else
			{
				return "home/home_0002_01_view";
			}
		}
		else if(request.getRemoteAddr().indexOf("10.254.24") == -1)
		{
			// 다큐브 여의도 본사 IP 허용
			if(request.getRemoteAddr().indexOf("121.131.131") == -1)
			{
				return "home/home_0002_01_view";
			}
		}
		return "home/home_0002_01_view";
	}
	
	@RequestMapping(value="/test")
	public @ResponseBody String test2()
	{
		String aa = indexService.getTest();
		return "home";
	}
}
