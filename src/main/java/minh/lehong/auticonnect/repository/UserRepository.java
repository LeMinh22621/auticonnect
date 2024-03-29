package minh.lehong.auticonnect.repository;

import minh.lehong.auticonnect.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {

    @Query(value = "{username:'?0', password: '?1'}")
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
    @Query(value = "{username:'?0'}")
    Optional<UserEntity> findByUsername(String username);
}
