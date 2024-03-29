package minh.lehong.auticonnect.controller;


import minh.lehong.auticonnect.facade.UserFacade;
import minh.lehong.auticonnect.payload.request.user.UserLoginRequest;
import minh.lehong.auticonnect.payload.request.user.UserRegisterRequest;
import minh.lehong.auticonnect.payload.response.ResponseData;
import minh.lehong.auticonnect.payload.response.UserResponse;
import minh.lehong.auticonnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody final UserLoginRequest request) {
        ResponseData<UserResponse> responseData = userFacade.login(request);
        return new ResponseEntity<>(responseData, Objects.nonNull(responseData) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody final UserRegisterRequest request) {
        ResponseData<UserResponse> responseData = userFacade.register(request);
        return new ResponseEntity<>(responseData, Objects.nonNull(responseData) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
