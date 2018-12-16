package com.succApplication.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "modeSettings")
public class ModeSettings {
    @Id
    public String id;
    public String mode;        //косяк !   в данном случае поля должны быть private final !!!
    public ObjectId contextId;

    public ModeSettings(String mode, ObjectId contextId) {
        this.mode = mode;
        this.contextId = contextId;
    }
}
