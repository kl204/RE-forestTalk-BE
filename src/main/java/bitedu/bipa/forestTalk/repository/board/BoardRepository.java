package bitedu.bipa.forestTalk.repository.board;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.forestTalk.model.board.BoardVo;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	/*
	 0815 김선규 회원게시판 리스트 조회 테스트 중 
	 */
	public List<BoardVo> selectAllBoard(){
		List<BoardVo> list = null;
		
		list = sqlSession.selectList("board.getBoardList");
		
		return list;
	}
	
	/*
	 0816 김선규 회원게시판 리스트 상세 조회 테스트 중 
	 */	
	public BoardVo selectDetailBoard(int bSeq){
		BoardVo boardVo = null;
		
		boardVo = sqlSession.selectOne("board.selectDetailBoard", bSeq );
		
		return boardVo;
	}
	
	
	/*
	 0816 김선규 회원게시판 게시물 등록 테스트 중 
	 */	
	public int registBoard(BoardVo bv){
		int flag = 0;
		
		flag = sqlSession.insert("board.registBoard", bv );
		
		return flag;
	}
	
	/*
	 0816 김선규 회원게시판 조회수 테스트 중 
	 */	
	public int updateView(int bSeq){
		int flag = 0;
		
		flag = sqlSession.update("board.updateView", bSeq );
		
		return flag;
	}
	
	/*
	 0816 김선규 회원게시판 리스트 상세 조회 테스트 중 
	 */	
	public List<BoardVo> searchByText(String text){
		List<BoardVo> list = null;
		
		list = sqlSession.selectList("board.searchByText", text);
		
		System.out.println(list);
		
		
		return list;
	}
	
	
	/*
	 0816 김선규 회원게시판 게시물 삭제 테스트 중 
	 */	
	public int deleteBoard(int bSeq){
		int flag = 0;
		
		flag = sqlSession.delete("board.deleteBoard", bSeq );
		
		return flag;
	}
	
	/*
	 0816 김선규 회원게시판 게시물 삭제 테스트 중 
	 */	
	public int likeBoard(int bSeq){
		int flag = 0;
		
		flag = sqlSession.update("board.likeBoard", bSeq );
		
		return flag;
	}
	
	
	/*
	 0816 박은빈 자료게시판 조회 테스트 중 
	 */
	public List<BoardVo> selectFileBoard(){
		List<BoardVo> list = null;
		
		list = sqlSession.selectList("board.getFileBoardList");
		
		return list;
	}

}
