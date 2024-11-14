package ek.app.social.repository;

import ek.app.social.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
        Role findByRoleName(String roleName);
}