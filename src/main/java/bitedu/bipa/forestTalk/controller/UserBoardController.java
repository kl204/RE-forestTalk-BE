	package bitedu.bipa.forestTalk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import bitedu.bipa.forestTalk.model.ApiResult;
import bitedu.bipa.forestTalk.model.board.BoardVo;
import bitedu.bipa.forestTalk.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/userBoard")
@Slf4j
public class UserBoardController {
	
	@Autowired
	private BoardService boardService;
	
	/*
	 0815 김선규 회원게시판 리스트 조회 테스트 중 
	 */
//	@RequestMapping(value ="/userBoard", method=RequestMethod.GET)
	@GetMapping("selectAllBoard")
	public ApiResult selectAllBoard() {
		
		ApiResult list = new ApiResult();
		
		List<BoardVo> boardList = new ArrayList<>();
		
		
		boardList = boardService.selectAllBoard();
		
		log.debug("=============== selectAllBoard {}", boardList.get(0).getCdt());	
		
		list.setData(boardList);
		
		
		return list;
	}
	
	@PostMapping("registBoard")
	public ApiResult registBoard(@RequestBody BoardVo bv) {
		
		ApiResult list = new ApiResult();		
		
		int flag = 0;
		
		//bv에는 작성자 이름과 제목, 내용밖에 없다. 유저 유형과 sys_code는 로그인 파트에서 담당해야할듯. 
		//default로 u_seq=1 로 하드코딩
		int uSeq = 1;
		
		bv.setUSeq(uSeq);
		
		//bv 확인
		log.debug("(UserBoardController) bv 확인 : " + bv.getBContents());	
		
		flag = boardService.registBoard(bv);
		
		if(flag!= 0) {
			log.debug("게시물 업데이트 완료!");
		}else {
			log.debug("게시물 업데이트 실패!");
			list.setResult("Failed");
		}
		
		return list;
	}

	
	@GetMapping("selectDetailBoard")
	public ApiResult selectDetailBoard(@RequestParam int bSeq) {
		
		ApiResult list = new ApiResult();
		BoardVo boardVo = new BoardVo();
		
		log.debug("detailBoard : " + bSeq);		
		
		boardVo = boardService.selectDetailBoard(bSeq);
	
		
		list.setVoData(boardVo);
		
		
		return list;
	}
	
	
	@GetMapping("updateView")
	public ApiResult updateView(@RequestParam int bSeq) {
		
		ApiResult list = new ApiResult();
		int flag = 0;
		
		log.debug("updateView : " + bSeq);		
		
		flag = boardService.updateView(bSeq);
		
		
		return list;
	}

	
	@GetMapping("searchByText")
	public ApiResult searchByText(@RequestParam String Text) {
		
		ApiResult list = new ApiResult();
		
		log.debug("searchByText : " + Text);		
		
		list.setData(boardService.searchByText(Text));
				
		return list;
	}
	
	
	@GetMapping("deleteBoard")
	public ApiResult deleteBoard(@RequestParam int bSeq) {
		
		ApiResult list = new ApiResult();
		int flag = 0;
		
		log.debug("deleteBoard : " + bSeq);		
		
		flag = boardService.deleteBoard(bSeq);
		
		
		return list;
	}
	
	
	@GetMapping("likeBoard")
	public ApiResult likeBoard(@RequestParam int bSeq) {
		
		ApiResult list = new ApiResult();
		int flag = 0;
		
		log.debug("likeBoard : " + bSeq);		
		
		flag = boardService.likeBoard(bSeq);
		
		log.debug("flag : "+flag);
		
		
		return list;
	}
	
}
