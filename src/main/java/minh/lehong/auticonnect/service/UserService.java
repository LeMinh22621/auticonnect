package minh.lehong.auticonnect.service;

import minh.lehong.auticonnect.payload.request.user.UserLoginRequest;
import minh.lehong.auticonnect.payload.request.user.UserRegisterRequest;
import minh.lehong.auticonnect.payload.response.UserResponse;

public interface UserService {
    UserResponse login(UserLoginRequest request);

    UserResponse register(UserRegisterRequest request);
}
