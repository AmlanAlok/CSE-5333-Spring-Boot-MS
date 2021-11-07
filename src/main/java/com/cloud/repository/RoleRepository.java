package com.cloud.repository;

import com.cloud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {

    @Query("SELECT r from Role r WHERE NOT r.name = 'Admin'")
    List<Role> getRoleDropdown();
}
