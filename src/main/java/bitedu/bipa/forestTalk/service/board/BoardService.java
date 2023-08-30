package bitedu.bipa.forestTalk.service.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.forestTalk.model.board.BoardVo;
import bitedu.bipa.forestTalk.repository.board.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	/*
	 0815 김선규 회원게시판 리스트 조회 테스트 중 
	 */
	public List<BoardVo> selectAllBoard(){
		ArrayList<BoardVo> list = null;
		
		list = (ArrayList<BoardVo>)boardRepository.selectAllBoard();
		
		return list;
	}

	/*
	 0816 김선규 회원게시판 리스트 상세 조회 테스트 중 
	 */
	public BoardVo selectDetailBoard(int bSeq){
		BoardVo boardVo = null;
		
		boardVo = boardRepository.selectDetailBoard(bSeq);
		
		return boardVo;
	}
	
	
	/*
	 0816 김선규 회원게시판 게시물 등록 중 
	 */
	public int registBoard(BoardVo bv){
		int flag = 0;
		
		flag = boardRepository.registBoard(bv);
		
		return flag;
	}
	
	/*
	 0817 김선규 회원게시판 조회수 테스트 중 
	 */
	public int updateView(int bSeq){
		int flag = 0;
		
		flag = boardRepository.updateView(bSeq);
		
		return flag;
	}
	
	/*
	 0816 김선규 회원게시판 리스트 검색 조회 테스트 중 
	 */
	public List<BoardVo> searchByText(String Text){
		List<BoardVo> boardVo = null;
				
		boardVo = boardRepository.searchByText(Text);
		
		return boardVo;
	}
	
	
	/*
	 0817 김선규 회원게시판 게시물 삭제 테스트 중 
	 */
	public int deleteBoard(int bSeq){
		int flag = 0;
		
		flag = boardRepository.deleteBoard(bSeq);
		
		return flag;
	}
	
	/*
	 0817 김선규 회원게시판 게시물 삭제 테스트 중 
	 */
	public int likeBoard(int bSeq){
		int flag = 0;
		
		flag = boardRepository.likeBoard(bSeq);
		
		return flag;
	}
	
	
	
	
	
	/*
	 0816 박은빈 자료게시판 조회 테스트 중 
	 */
	public List<BoardVo> selectFileBoard(){
		ArrayList<BoardVo> list = null;
		
		list = (ArrayList<BoardVo>)boardRepository.selectFileBoard();
		
		return list;
	}


}
