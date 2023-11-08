package com.project.pragmatic.user.dto;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userid;
    private String userpw;

    private String name;
    private String nickname;
    private String email;
}
