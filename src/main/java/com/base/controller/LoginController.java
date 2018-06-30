package com.base.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.base.common.util.FileReaderUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	
//	public void login(String userName,String pwd,String code){
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(String userId,String password){
		ModelAndView mv = new ModelAndView("index");
		Map<Object, Object> result = FileReaderUtil.readProperties("");
		
		for(Object key: result.keySet()){
			if(key.equals(userId) && result.get(key).equals(password)){
				return mv;
			}
		}
//		mv.setViewName("forward:/login.html");
		mv.setViewName("redirect:/login.html");
		mv.addObject("message", "用户名或密码错误");
		return mv;
	}
	
	
}
