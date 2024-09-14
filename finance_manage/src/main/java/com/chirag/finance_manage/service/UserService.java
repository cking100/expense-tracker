package com.chirag.finance_manage.service;
import com.chirag.finance_manage.model.User;
import java.util.Optional;
public interface UserService {
    User register(User user);
    Optional<User> getUserById(Long id);
    User update(Long id, User user);

}
