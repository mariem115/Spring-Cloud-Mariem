package com.mariem.voyage.service;

import com.mariem.voyage.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(url = "http://localhost:8082", value = "USER")
@FeignClient(name = "USER")
public interface APIClient {

    @GetMapping("api/users/{email}")
    UserDto getUserByEmail(@PathVariable("email") String email);
}
