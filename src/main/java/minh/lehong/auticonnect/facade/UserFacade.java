package minh.lehong.auticonnect.facade;

import minh.lehong.auticonnect.payload.request.user.UserLoginRequest;
import minh.lehong.auticonnect.payload.request.user.UserRegisterRequest;
import minh.lehong.auticonnect.payload.response.ResponseData;
import minh.lehong.auticonnect.payload.response.UserResponse;

public interface UserFacade {
    ResponseData<UserResponse> login(UserLoginRequest request);

    ResponseData<UserResponse> register(UserRegisterRequest request);
}
