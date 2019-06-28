package com.iu.s6;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeService;
import com.iu.util.PageMaker;

@Controller
@RequestMapping("/notice/")
public class NoticeController {

	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String setWrite(Model model) throws Exception {
		model.addAttribute("board", "notice");
		
		return "board/boardWirte";
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String setWrite(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setWrite(boardDTO);
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String setUpdate(Model model, int num) throws Exception{
		BoardDTO boardDTO = noticeService.getSelect(num);
		model.addAttribute("boardDTO", boardDTO);
		model.addAttribute("board", "notice");
		
		return "board/boardUpdate";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:./noticeSelect";
	}

	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public String getList(Model model, PageMaker pageMaker) throws Exception {
		List<BoardDTO> ar = noticeService.getList(pageMaker);
		model.addAttribute("list", ar);
		model.addAttribute("board", "notice");
		
		return "board/boardList";
	}

	@RequestMapping("noticeSelect")///////////////////////////////////////////////////////////////////////////////////////////////
	public ModelAndView getSelect(@RequestParam(defaultValue = "0", required = false) int num, ModelAndView mv) throws Exception {
		BoardDTO boardDTO = noticeService.getSelect(num);
		mv.addObject("boardDTO", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@RequestMapping("noticeDelete")
	public String setDelete(@RequestParam(defaultValue = "0", required = false) int num) throws Exception{
		int result = noticeService.setDelete(num);
		
		return "redirect:./noticeList";
	}
}