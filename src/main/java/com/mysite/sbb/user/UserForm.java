package com.mysite.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    @Size(min = 3,max = 25)
    @NotEmpty(message = "이름은 필수 입니다.")
    private String name;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인는 필수 입니다.")
    private String password2;

    @NotEmpty(message = "이메일은 필수 입니다.")
    @Email
    private String email;
}