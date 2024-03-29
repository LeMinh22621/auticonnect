package minh.lehong.auticonnect.facade.impl;

import minh.lehong.auticonnect.facade.UserFacade;
import minh.lehong.auticonnect.payload.request.user.UserLoginRequest;
import minh.lehong.auticonnect.payload.request.user.UserRegisterRequest;
import minh.lehong.auticonnect.payload.response.ResponseData;
import minh.lehong.auticonnect.payload.response.UserResponse;
import minh.lehong.auticonnect.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserService userService;

    @Override
    public ResponseData<UserResponse> login(final UserLoginRequest request) {
        UserResponse userResponse = userService.login(request);
        ResponseData responseData = ResponseData.builder()
                .data(null)
                .message("wrong username, password!")
                .status(HttpStatus.BAD_REQUEST)
                .build();
        if (Objects.nonNull(userResponse)) {
            responseData = ResponseData.builder()
                    .data(userResponse)
                    .message("login success!")
                    .status(HttpStatus.OK)
                    .build();
        }
        return responseData;
    }

    @Override
    public ResponseData<UserResponse> register(final UserRegisterRequest request) {
        UserResponse userResponse = userService.register(request);
        ResponseData responseData = ResponseData.builder()
                .data(null)
                .message("register failed!")
                .status(HttpStatus.BAD_REQUEST)
                .build();
        if (Objects.nonNull(userResponse)) {
            responseData = ResponseData.builder()
                    .data(userResponse)
                    .message("register success!")
                    .status(HttpStatus.OK)
                    .build();
        }
        return responseData;
    }
}
