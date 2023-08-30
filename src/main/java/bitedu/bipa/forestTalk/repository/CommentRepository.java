package bitedu.bipa.forestTalk.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.forestTalk.model.board.BoardVo;
import bitedu.bipa.forestTalk.model.comment.CommentVo;

@Repository
public class CommentRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	/*
	 0816 장은주 
	 댓글 조회
	 .. 0819 김선규 댓글 조회 수정
	 */
	public List<CommentVo> selectCmt(int bSeq){
		List<CommentVo> list = null;
				
		list = sqlSession.selectList("comment.selectCmt", bSeq);
		
		System.out.println(list.get(0));
		
		if(list.isEmpty()) {
			System.out.println("1231324");
			System.out.println("(Repo Comment)Success! bSeq : " + list.get(0).getCContents());
			
		}else {
			System.out.println("(Repo Comment)not return!!");
		}
		
		return list;
	}
	
	
	public int registComment(CommentVo cv){
		int flag = 0;
				
		flag = sqlSession.insert("comment.insertCmt", cv);
		
		
		return flag;
	}
	
}
