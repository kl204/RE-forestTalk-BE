package bitedu.bipa.forestTalk.service.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.forestTalk.model.board.BoardVo;
import bitedu.bipa.forestTalk.repository.board.BoardRepository;
import bitedu.bipa.forestTalk.repository.board.FileBoardRepository;

@Service
public class FileBoardService {
	
	@Autowired
	private FileBoardRepository fileBoardRepository;
	
	/*
	 0816 박은빈 자료게시판 조회 
	 */
	public List<BoardVo> findFileBoard(){
		ArrayList<BoardVo> list = null;
		
		list = (ArrayList<BoardVo>)fileBoardRepository.selectFileBoard();
		
		return list;
	}

	public BoardVo findFileBoardOne(int seq){
		BoardVo board = null;
		
		board = (BoardVo)fileBoardRepository.selectFileBoardOne(seq);
		
		return board;
	}

	/*
	 0817 박은빈 자료게시판 글 작성 
	 */
	public boolean registFileBoard(BoardVo board){
		
		boolean flag = fileBoardRepository.insertFileBoard(board);
		
		return flag;
	}
	

	/*
	 0818 박은빈 자료게시판 게시물 삭제 
	 */
	public boolean deleteFileBoard(int bSeq){
		boolean flag = false;
		
		flag = fileBoardRepository.deleteFileBoard(bSeq);
		
		return flag;
	}
	
	/*
	 0818 박은빈 게시물 좋아요 
	 */
	public boolean likeBoard(int bSeq){
		boolean flag = false;
		
		flag = fileBoardRepository.likeBoard(bSeq);
		
		return flag;
	}

	/*
	 0818 박은빈 게시물 조회수
	 */
	
	public boolean updateView(int bSeq){
		boolean flag = false;
		
		flag = fileBoardRepository.updateView(bSeq);
		
		return flag;
	}
	

	/*
	 0818 박은빈 게시물 검색
	 */
	public List<BoardVo> searchByText(String Text){
		List<BoardVo> boardVo = null;
				
		boardVo = fileBoardRepository.searchByText(Text);
		
		return boardVo;
	}
}
