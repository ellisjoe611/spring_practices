package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.hellospring.vo.UserVO;

// RequestMapping
// Class + Method

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = { "/join", "/j" }, method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVo) {
		System.out.println(userVo);
		
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam("n") String name) {
		System.out.println(name + " : ");
		return "UserController:update";
	}

	// defalut 값 지정하기
	// required는 기본적으로 true로 지정됨
	@ResponseBody
	@RequestMapping(value = "/update2", method = RequestMethod.POST)
	public String update2(@RequestParam(value = "n", required = true, defaultValue = "") String name,
			@RequestParam(value = "a", required = true, defaultValue = "0") int age) {
		// "n"이 없는 경우 400 에러가 발생

		System.out.println(name + " : " + age);
		return "UserController:update2";
	}

}
