package bitedu.bipa.forestTalk.repository.user;

import bitedu.bipa.forestTalk.model.user.SignupVO;
import bitedu.bipa.forestTalk.model.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class SignupRepository {
            /*
	 0817 박중영
	 회원가입 기능
	 */

    @Autowired
    private SqlSession sqlSession;

    public boolean insertUser(UserVO userinfo) {
        boolean result = false;
        int count = sqlSession.insert("user.insertUserInfo", userinfo);
        if (count == 1) {
            result = true;
        }
        return result;
    }
    public boolean checkid(String id) {
        boolean result = false;
        int count = sqlSession.selectOne("user.duplicateIdChk", id);
        log.debug(String.valueOf(count));
        if (count == 1) {
            result = true;
        }
        return result;
    }
}
