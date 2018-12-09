package com.succApplication.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ModeSettings {
    @Id
    public String id;
    public String mode;
    public ObjectId template;

    public ModeSettings(String mode, ObjectId template) {
        this.mode = mode;
        this.template = template;
    }
}
