package bitedu.bipa.forestTalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.forestTalk.model.comment.CommentVo;
import bitedu.bipa.forestTalk.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	/*
	 0816 장은주 
	 댓글 조회
	 */
	public List<CommentVo> selectCmt(int bSeq){
		List<CommentVo> list = null;
		
		list = commentRepository.selectCmt(bSeq);
		
		return list;
	}
	
	
	public int registComment(CommentVo cv){
		int flag = 0;
		
		flag = commentRepository.registComment(cv);
		
		return flag;
	}
}
