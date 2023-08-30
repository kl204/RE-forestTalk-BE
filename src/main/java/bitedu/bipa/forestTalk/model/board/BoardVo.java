package bitedu.bipa.forestTalk.model.board;


import bitedu.bipa.forestTalk.model.ComonVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVo extends ComonVo{

	/*
	 0817 김선규 board 테이블 getter setter 어노테이션 제거/ extends 상속 제거
	 g/setter 제거 		-> g/setter 어노테이션 작동 제대로 못해서 RequestBody null 반환
	 extends 상속 제거 	-> RequestBody 파싱 시 상위 클래스인 CommonVo에 파싱하여 반환
	 */
	private int bSeq;
	private int uSeq;
	private String bTitle;
	private String bContents;
	private String bFileOriginNm;
	private String bFileModiNm;
	private int bCount;
	private int liked;
	private String sysCode;

	
	
}
