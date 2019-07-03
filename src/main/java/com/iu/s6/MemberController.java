package com.iu.s6;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.member.MemberService;
import com.iu.member.MemberVO;

@Controller
@RequestMapping(value = "/member/")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "memberLogout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void setWrite() throws Exception{}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView setWrite(MemberVO memberVO, MultipartFile multipartFile, HttpSession session) throws Exception{
		int result = memberService.setWrite(memberVO, multipartFile, session);
		String message = "Join Fail";
		if(result > 0) {
			message = "Join Success";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/messageMove");
		mv.addObject("message", message);
		mv.addObject("path", "../");
		
		return mv;
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public void getSelect() throws Exception{}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView getSelect(MemberVO memberVO, HttpSession session, Model model) throws Exception{
		HashMap<String, Object> map = memberService.getSelect(memberVO, session);
		memberVO = (MemberVO)map.get("memberVO");
		String message = "Login Fail";
		if(memberVO != null) {
			session.setAttribute("member", map.get("memberVO"));
			session.setAttribute("memberfile", map.get("memberfileVO"));
			message = "Login Success";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/messageMove");
		mv.addObject("message", message);
		mv.addObject("path", "../");
		
		return mv;
	}
	
	@RequestMapping(value = "memberPage")
	public void memberPage(HttpSession session) throws Exception{}
}