package bitedu.bipa.forestTalk.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitedu.bipa.forestTalk.model.ApiResult;
import bitedu.bipa.forestTalk.model.board.BoardVo;
import bitedu.bipa.forestTalk.service.board.FileBoardService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("board")
@Slf4j
public class FileBoardController {

	@Autowired
	private FileBoardService fileBoardService;

	/*
	 * 0816 박은빈 자료게시판 조회
	 */
	@GetMapping("fileBoard")
	public ApiResult findFileBoard() {
		ApiResult result = new ApiResult();

		List<BoardVo> fileList = new ArrayList<>();

		fileList = fileBoardService.findFileBoard();

		result.setData(fileList);

		return result;
	}

	@GetMapping("fileBoardDetail")
	public ApiResult findFileBoardOne(@RequestParam int bSeq) {
		ApiResult result = new ApiResult();
		log.debug("bseq" + bSeq);

		BoardVo board = new BoardVo();

		board = fileBoardService.findFileBoardOne(bSeq);

		result.setVoData(board);

		return result;
	}

	/*
	 * 0817 박은빈 자료게시판 글 작성
	 * 0818 파일 업로드
	 */

	@PostMapping("registFileBoard")
	public ApiResult writeFileBoard(@RequestParam("bTitle") String bTitle, @RequestParam("bContents") String bContents,
			@RequestParam("bFile") MultipartFile bFile) {
		ApiResult result = new ApiResult();

		BoardVo board = new BoardVo();
		board.setUSeq(1);
		board.setBTitle(bTitle);
		board.setBContents(bContents);

		if (!bFile.isEmpty()) {
			String fileName = bFile.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String filePath = "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\file" + uuid + fileName;
			board.setBFileOriginNm(fileName);
			board.setBFileModiNm(uuid + fileName);
			try {
				bFile.transferTo(new File(filePath));
				// 저장 성공 처리
			} catch (IOException e) {
				e.printStackTrace();
				// 파일 저장 중 에러 처리
			}
		}

		boolean flag = fileBoardService.registFileBoard(board);

		if (flag) {
			return result;
		} else {
			result.setStrData("실패");
			return result;
		}
	}
	
	/*
	 * 0818 박은빈 자료게시판 파일 다운로드
	 */
	@GetMapping("downloadFile")
	public ResponseEntity<InputStreamResource> downloadFile(@RequestParam int bSeq) throws FileNotFoundException {
	    BoardVo board = fileBoardService.findFileBoardOne(bSeq);
	    
	    File file = new File("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\file" + board.getBFileModiNm());
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + board.getBFileOriginNm());

	    return ResponseEntity.ok()
	        .headers(headers)
	        .contentLength(file.length())
	        .contentType(MediaType.APPLICATION_OCTET_STREAM)
	        .body(resource);
	}
	
	/*
	 * 0818 박은빈 자료게시판 삭제
	 */
	
	@GetMapping("deleteFileBoard")
	public ApiResult deleteBoard(@RequestParam int bSeq) {
		
		ApiResult result = new ApiResult();
		boolean flag = false;
		
		log.debug("deleteBoard : " + bSeq);		
		
		flag = fileBoardService.deleteFileBoard(bSeq);
		
		
		return result;
	}
	
	/*
	 * 0818 박은빈 자료게시판 좋아요
	 */
	@GetMapping("likeBoard")
	public ApiResult likeBoard(@RequestParam int bSeq) {
//		BoardVo b = new BoardVo();
		ApiResult result = new ApiResult();
		boolean flag = false;	
		
		flag = fileBoardService.likeBoard(bSeq);		
//		log.debug("좋아요" + b.getLiked());
		
		return result;
	}

	/*
	 * 0818 박은빈 자료게시판 조회수
	 */
	@GetMapping("updateView")
	public ApiResult updateView(@RequestParam int bSeq) {
		
		ApiResult result = new ApiResult();
		boolean flag = false;		
		
		flag = fileBoardService.updateView(bSeq);
		
		
		return result;
	}

	/*
	 * 0818 박은빈 자료게시판 검색
	 */
	@GetMapping("searchByText")
	public ApiResult searchByText(@RequestParam String Text) {
		
		ApiResult result = new ApiResult();
		
//		log.debug("searchByText : " + Text);		
		
		result.setData(fileBoardService.searchByText(Text));
				
		return result;
	}
}
