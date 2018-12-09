package com.succApplication.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "modeSettings")
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
