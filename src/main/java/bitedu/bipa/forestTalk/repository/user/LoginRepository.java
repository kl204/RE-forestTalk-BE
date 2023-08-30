package bitedu.bipa.forestTalk.repository.user;

import bitedu.bipa.forestTalk.model.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class LoginRepository {
            /*
	 0817 박중영
	 로그인 기능
	 */

    @Autowired
    private SqlSession sqlSession;

    public UserVO selectUser(String username) {
        UserVO user = null;
        log.debug("username : {}", username);
    	user = sqlSession.selectOne("user.idPassCheck", username);
        log.debug("user : {}", user);
    	return user;
    }
}
