package ua.training.vitascherry.model.entity;

import static ua.training.vitascherry.controller.util.Message.ENTITY_NOT_CREATED;

public class EntityCreateException extends Exception {
    public EntityCreateException(Object entity) {
        super(entity + ENTITY_NOT_CREATED);
    }
}
