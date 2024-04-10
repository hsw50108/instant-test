package com.example.instanttest.api.user.response;

import com.example.instanttest.domain.enums.CarType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserUpdateResponse {

    private final String nickname;
    private final String password;
    private final CarType carType;

    @Builder
    public UserUpdateResponse(String nickname, String password, CarType carType) {
        this.nickname = nickname;
        this.password = password;
        this.carType = carType;
    }
}
