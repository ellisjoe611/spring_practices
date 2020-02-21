package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVO;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository repository;

	@RequestMapping(value = { "" })
	public String index(Model model) {
		List<GuestbookVO> list = repository.findall();
		model.addAttribute("list", list);

		return "index";
	}

	// guestbook 추가
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String add(GuestbookVO vo) {
		if(isNotNull(vo) == false) {
			return "redirect:/";
		}
		repository.insert(vo);
		return "redirect:/";
	}

	// delete form 연결
	@RequestMapping(value = { "/delete/{no}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, Model model) {
		if (no == null || isLong(no) == false) {
			return "redirect:/";
		}

		GuestbookVO vo = new GuestbookVO();
		vo.setNo(no);
		if (repository.exists(vo) == false) {
			return "redirect:/";
		}

		model.addAttribute("no", no);
		return "deleteform";
	}

	// 삭제하기
	@RequestMapping(value = { "/delete" }, method = RequestMethod.POST)
	public String delete(GuestbookVO vo, Model model) {
		if(repository.delete(vo) == false) {
			return "redirect:/delete/" + vo.getNo();
		}else {
			return "redirect:/";
		}
	}

	protected boolean isLong(Long input) {
		try {
			Long.parseLong(String.valueOf(input));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	protected boolean isNotNull(GuestbookVO vo) {
		if(vo == null) {
			return false;
		}
		if(vo.getName() == null || "".equals(vo.getName())) {
			return false;
		}
		if(vo.getPw() == null || "".equals(vo.getPw())) {
			return false;
		}
		if(vo.getContents() == null || "".equals(vo.getContents())) {
			return false;
		}
		
		return true;
	}
}
