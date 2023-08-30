 package bitedu.bipa.forestTalk.model.comment;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentVo {
	
	private int cSeq;
	private int bSeq;
	private int uSeq;
	private String cContents;
	private Date cdt;

}
