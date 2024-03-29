package minh.lehong.auticonnect.converter.impl;

import minh.lehong.auticonnect.converter.UserConverter;
import minh.lehong.auticonnect.dto.UserDto;
import minh.lehong.auticonnect.entity.UserEntity;
import minh.lehong.auticonnect.payload.request.user.UserRegisterRequest;
import minh.lehong.auticonnect.payload.response.UserResponse;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserDto convertEntityToDto(UserEntity source) {
        UserDto target = null;
        if (Objects.nonNull(source)) {
            target = new UserDto();
            target.setAge(source.getAge());
            target.setId(source.getUserId());
            target.setUsername(source.getUsername());
            target.setFirstName(source.getFirstName());
            target.setLastName(source.getLastName());
        }
        return target;
    }

    @Override
    public UserResponse convertDtoToResponse(UserDto source, UserResponse target) {
        if (Objects.nonNull(source)) {
            if (Objects.isNull(target)) {
                target = new UserResponse();
            }
            target.setAge(source.getAge());
            target.setId(source.getId());
            target.setUsername(source.getUsername());
            target.setFirstName(source.getFirstName());
            target.setLastName(source.getLastName());
        }
        return target;
    }

    @Override
    public UserDto convertRequestToDto(UserRegisterRequest source, UserDto target) {
        if (Objects.nonNull(source)) {
            if (Objects.isNull(target)) {
                target = new UserDto();
            }
            target.setPassword(source.getPassword());
            target.setAge(source.getAge());
            target.setUsername(source.getUsername());
            target.setFirstName(source.getFirstName());
            target.setLastName(source.getLastName());
        }
        return target;
    }

    @Override
    public UserEntity convertDtoToEntity(UserDto source, UserEntity target) {
        if (Objects.nonNull(source)) {
            if (Objects.isNull(target)) {
                target = new UserEntity();
            }
            target.setPassword(source.getPassword());
            target.setAge(source.getAge());
            target.setUsername(source.getUsername());
            target.setFirstName(source.getFirstName());
            target.setLastName(source.getLastName());
        }
        return target;
    }
}
