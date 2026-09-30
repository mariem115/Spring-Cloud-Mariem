package com.mariem.user.service;

import com.mariem.user.dto.UserDto;

public interface UserService {

    UserDto getUserByEmail(String email);
}
