package bitedu.bipa.forestTalk.model.user;

import bitedu.bipa.forestTalk.model.ComonVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignupVO extends ComonVo {
    /*
	 박중영 회원가입 VO 추가
	 */
    private int useq;
    private String uname;
    private String uemail;
    private String uid;
    private String upw;
    private String unick;
    private String ubirth;
}
