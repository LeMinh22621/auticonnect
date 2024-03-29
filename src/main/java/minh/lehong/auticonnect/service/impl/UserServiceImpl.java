package minh.lehong.auticonnect.service.impl;

import minh.lehong.auticonnect.converter.UserConverter;
import minh.lehong.auticonnect.dto.UserDto;
import minh.lehong.auticonnect.entity.UserEntity;
import minh.lehong.auticonnect.payload.request.user.UserLoginRequest;
import minh.lehong.auticonnect.payload.request.user.UserRegisterRequest;
import minh.lehong.auticonnect.payload.response.UserResponse;
import minh.lehong.auticonnect.repository.UserRepository;
import minh.lehong.auticonnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserResponse login(final UserLoginRequest request) {
        final String username = request.getUsername();
        final String password = request.getPassword();
        final Optional<UserEntity> userEntityOptional = userRepository.findByUsernameAndPassword(username, password);
        final UserDto userDto = userEntityOptional.map(entity -> userConverter.convertEntityToDto(entity)).orElse(null);
        return Optional.ofNullable(userDto).map(dto -> userConverter.convertDtoToResponse(dto, null)).orElse(null);
    }

    @Override
    public UserResponse register(final UserRegisterRequest request) {
        final UserDto userDto = userConverter.convertRequestToDto(request, new UserDto());
        final UserEntity userEntity = Optional.ofNullable(userDto)
                .filter(dto -> userRepository.findByUsername(dto.getUsername()).map(entity -> Boolean.FALSE).orElse(Boolean.TRUE))
                .map(dto -> userConverter.convertDtoToEntity(userDto, new UserEntity()))
                .orElse(null);
        if (Objects.nonNull(userEntity)) {
            userRepository.insert(userEntity);
        }
        final UserDto dto = userConverter.convertEntityToDto(userEntity);
        return userConverter.convertDtoToResponse(dto, null);
    }
}
