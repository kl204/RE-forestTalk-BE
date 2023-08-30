package bitedu.bipa.forestTalk.service.login;

import bitedu.bipa.forestTalk.model.user.SignupVO;
import bitedu.bipa.forestTalk.model.user.UserVO;
import bitedu.bipa.forestTalk.repository.user.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingupService {

    @Autowired
    private SignupRepository signupRepository;
        /*
	 0817 박중영
	 회원가입 기능
	 */

    public boolean signup(UserVO signupForm) {
        return signupRepository.insertUser(signupForm);
    }
    public boolean checkid(String id) {
        return signupRepository.checkid(id);
    }

}
