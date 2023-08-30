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
import bitedu.bipa.forestTalk.model.comment.CommentVo;
import bitedu.bipa.forestTalk.service.CommentService;
import bitedu.bipa.forestTalk.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/commentBoard")
@Slf4j
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	/*
	 0819 김선규 회원게시판 댓글 테스트 중 
	 */
//	@RequestMapping(value ="/userBoard", method=RequestMethod.GET)
	@GetMapping("selectBoardComment")
	public ApiResult selectBoardComment(@RequestParam int bSeq) {
		
		ApiResult list = new ApiResult();
		
		log.debug("selectBoardComment : " + bSeq);		
		
		list.setData(commentService.selectCmt(bSeq));	
		
		return list;
	}
	
	@PostMapping("registComment")
	public ApiResult registComment(@RequestBody CommentVo cv) {
		
		ApiResult list = new ApiResult();		
		
		int flag = 0;
		
		//bv 확인
		log.debug("(UserBoardController) bv 확인 : " + cv.getCContents());	
		
		flag = commentService.registComment(cv);
		
		if(flag!= 0) {
			log.debug("댓글 업데이트 완료!");
		}else {
			log.debug("댓글 업데이트 실패!");
			list.setResult("Failed");
		}
		
		return list;
	}
	
	
//	@GetMapping("updateView")
//	public ApiResult updateView(@RequestParam int bSeq) {
//		
//		ApiResult list = new ApiResult();
//		int flag = 0;
//		
//		log.debug("updateView : " + bSeq);		
//		
//		flag = commentService.updateView(bSeq);
//		
//		
//		return list;
//	}
//	
//	@GetMapping("deleteBoard")
//	public ApiResult deleteBoard(@RequestParam int bSeq) {
//		
//		ApiResult list = new ApiResult();
//		int flag = 0;
//		
//		log.debug("deleteBoard : " + bSeq);		
//		
//		flag = commentService.deleteBoard(bSeq);
//		
//		
//		return list;
//	}
//	
//	
//	@GetMapping("likeBoard")
//	public ApiResult likeBoard(@RequestParam int bSeq) {
//		
//		ApiResult list = new ApiResult();
//		int flag = 0;
//		
//		log.debug("likeBoard : " + bSeq);		
//		
//		flag = commentService.likeBoard(bSeq);
//		
//		log.debug("flag : "+flag);
//		
//		
//		return list;
//	}
	
}
