package minh.lehong.auticonnect.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("user")
@Setter
@Getter
public class UserEntity {
    @Id
    private Long userId;

    @Field("username")
    private String username;

    @Field("password")
    private String password;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("age")
    private Integer age;
}
