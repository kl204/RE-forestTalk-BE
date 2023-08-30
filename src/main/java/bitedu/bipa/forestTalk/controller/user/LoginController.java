package bitedu.bipa.forestTalk.controller.user;


import bitedu.bipa.forestTalk.model.ApiResult;
import bitedu.bipa.forestTalk.model.user.LoginVO;
import bitedu.bipa.forestTalk.service.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
	로그인 컨트롤러
	박중영*/
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ApiResult login(@RequestBody LoginVO loginForm) {
        ApiResult result = new ApiResult();
        // 로그인 폼 데이터 처리
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        // 로그인 결과 반환
        if (loginService.login(username, password)) {
            result.setResultMsg("certified");
            return result;
        } else {
            result.setResultMsg("non-certified");
            return result;
        }
    }
}