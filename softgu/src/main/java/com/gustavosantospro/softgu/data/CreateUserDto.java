package com.gustavosantospro.softgu.data;

import com.gustavosantospro.softgu.model.user.Role;

public record CreateUserDto(String login, String password, Role role) {
}
