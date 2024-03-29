package minh.lehong.auticonnect.converter;

import minh.lehong.auticonnect.dto.UserDto;
import minh.lehong.auticonnect.entity.UserEntity;
import minh.lehong.auticonnect.payload.request.user.UserRegisterRequest;
import minh.lehong.auticonnect.payload.response.UserResponse;

public interface UserConverter {
    UserDto convertEntityToDto(UserEntity entity);

    UserResponse convertDtoToResponse(UserDto dto, UserResponse userResponse);

    UserDto convertRequestToDto(UserRegisterRequest request, UserDto userDto);

    UserEntity convertDtoToEntity(UserDto userDto, UserEntity userEntity);
}
