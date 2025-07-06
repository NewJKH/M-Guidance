package org.nano.guidance.domain.player.repository;

import org.nano.guidance.domain.player.entity.UserGuidance;
import org.nano.guidance.global.config.JpaExecutor;
import org.nano.guidance.global.config.Repository;

import javax.persistence.Entity;
import java.util.UUID;

public class UserRepository implements Repository {
    @Override
    public void write(Entity entity) {
        JpaExecutor.execute(em -> em.persist(entity));
    }

    @Override
    public org.nano.guidance.global.config.Entity read(UUID uuid) {
        return JpaExecutor.query(em -> em.find(UserGuidance.class, uuid));
    }
}
