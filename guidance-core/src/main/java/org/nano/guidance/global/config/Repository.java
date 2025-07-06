package org.nano.guidance.global.config;

import javax.persistence.Entity;
import java.util.UUID;

public interface Repository {
    void write(Entity entity);
    org.nano.guidance.global.config.Entity read(UUID uuid);
}
