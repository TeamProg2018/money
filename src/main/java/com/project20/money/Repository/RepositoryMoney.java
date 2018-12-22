package com.project20.money.Repository;

import com.project20.money.Entity.EntityMoney;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryMoney extends JpaRepository<EntityMoney,Long> {
}
