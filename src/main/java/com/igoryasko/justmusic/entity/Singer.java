package com.igoryasko.justmusic.entity;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Singer extends Entity{

    private static final long serialVersionUID = -87758406741621694L;

    private long singerId;
    private String name;

    public Singer(String name) {
        this.name = name;
    }

}
