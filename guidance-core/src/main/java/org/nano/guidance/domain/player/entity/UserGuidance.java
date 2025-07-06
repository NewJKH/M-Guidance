package org.nano.guidance.domain.player.entity;

import org.nano.guidance.global.config.Entity;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Table(name = "user")
public class UserGuidance implements Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "uuid")
    private final UUID uuid;

    @Column(name = "stats")
    private final Map<Integer, Boolean> checkMap;

    public UserGuidance(UUID uuid, Map<Integer, Boolean> checkMap) {
        this.uuid = uuid;
        this.checkMap = checkMap;
    }

    public long getId() {
        return id;
    }

    public Map<Integer, Boolean> getCheckMap() {
        return checkMap;
    }
    public boolean hasClear(int index){
        return checkMap.getOrDefault(index, false);
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }
}
