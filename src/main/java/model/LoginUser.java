package model;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class LoginUser {
    private String username;
    private String password;

}
