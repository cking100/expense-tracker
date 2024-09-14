package com.chirag.finance_manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chirag.finance_manage.model.User;

public interface UserRepository  extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
