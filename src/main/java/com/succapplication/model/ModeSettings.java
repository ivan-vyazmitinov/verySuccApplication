package com.succapplication.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "modeSettings")
public class ModeSettings {
    @Id
    private String id;
    private final String mode;
    private final ObjectId contextId;

    public ModeSettings(String mode, ObjectId contextId) {
        this.mode = mode;
        this.contextId = contextId;
    }
}
