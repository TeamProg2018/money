package com.project20.money.Repository;

import com.project20.money.Entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<EntityUser,Long>
{
}
