package bitedu.bipa.forestTalk.repository.board;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.forestTalk.model.board.BoardVo;

@Repository
public class FileBoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	/*
	 0816 박은빈 자료게시판 조회 테스트 중 
	 */
	public List<BoardVo> selectFileBoard(){
		List<BoardVo> list = null;
		
		list = sqlSession.selectList("board.selectFileBoardList");
		
		return list;
	}
	
	public BoardVo selectFileBoardOne(int seq) {
		BoardVo board = null;
		
		board = sqlSession.selectOne("board.selectFileBoardListOne", seq);
		
		return board;
	}

	/*
	 0816 박은빈 자료게시판 작성
	 */
	public boolean insertFileBoard(BoardVo board) {
		boolean flag = false;
		
		if(sqlSession.insert("board.insertFileBoard", board) > 0) {
			flag = true;
		}
		
		return flag;
	}
	

	/*
	 0818 박은빈 자료게시판 삭제 
	 */	
	public boolean deleteFileBoard(int bSeq){
		boolean flag = false;
		
		if(sqlSession.delete("board.deleteBoard", bSeq) > 0) {
			flag = true;
		}
		
		return flag;
	}
	

	/*
	 0818 박은빈 자료게시판 좋아요 
	 */	
	public boolean likeBoard(int bSeq){
		boolean flag = false;
		
		if(sqlSession.update("board.likeBoard", bSeq ) > 0) {
			flag = true;
		}
		
		return flag;
	}

	/*
	 0818 박은빈 자료게시판 조회수 
	 */
	public boolean updateView(int bSeq){
		boolean flag = false;
		
		if(sqlSession.update("board.updateView", bSeq ) > 0) {
			flag = true;
		}
		
		return flag;
	}
	

	/*
	 0818 박은빈 자료게시판 검색
	 */	
	public List<BoardVo> searchByText(String text){
		List<BoardVo> list = null;
		
		list = sqlSession.selectList("board.searchByText", text);
		
//		System.out.println(list);
		
		
		return list;
	}
}
