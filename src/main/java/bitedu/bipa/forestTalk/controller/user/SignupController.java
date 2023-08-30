package bitedu.bipa.forestTalk.controller.user;

import bitedu.bipa.forestTalk.model.ApiResult;
import bitedu.bipa.forestTalk.model.user.UserVO;
import bitedu.bipa.forestTalk.service.login.SingupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/*
	회원가입 컨트롤러
	박중영*/
@RestController
@Slf4j
public class SignupController {

    @Autowired
    private SingupService singupService;
    @PostMapping("/user/signup")
    public ApiResult Signup(@RequestBody UserVO SignupForm) {
    	ApiResult result = new ApiResult();
        result.setResultMsg("non-certified");
        log.debug(String.valueOf(SignupForm));
        if (singupService.signup(SignupForm)) {
            result.setResultMsg("certified");
            return result;
        } else {
            return result;
        }
    }
    @GetMapping("/user/checkid")
    public ApiResult checkId(@RequestParam String uid) {
        ApiResult result = new ApiResult();
        // 로그인 폼 데이터 처리
        log.debug(uid);
        if (singupService.checkid(uid)) {
            result.setResultMsg("certified");
            return result;
        } else {
            result.setResultMsg("non-certified");
            return result;
        }
    }

}
