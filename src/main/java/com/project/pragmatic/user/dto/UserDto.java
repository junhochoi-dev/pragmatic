package com.project.pragmatic.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class UserDto {
    private String userid;
    private String userpw;

    private String name;
    private String nickname;
    private String email;
    public UserDto(String userid, String userpw){
        this.userid = userid;
        this.userpw = userpw;
    }
}
