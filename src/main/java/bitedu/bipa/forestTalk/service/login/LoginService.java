package bitedu.bipa.forestTalk.service.login;

import bitedu.bipa.forestTalk.model.user.UserVO;
import bitedu.bipa.forestTalk.repository.user.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;
    /*
	 0817 박중영
	 로그인 기능
	 */
    public boolean login(String username, String password) {
        boolean flag = false;
        UserVO user = loginRepository.selectUser(username);
        if (user != null) {
            if (user.getUpw().equals(password)) {
                flag = true;
            }
        }
        return flag;
    }
}
