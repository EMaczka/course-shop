package pl.courseshop.infrastructure.exceptions;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String resource, String id) {
        super(String.format("Resource: %s wasn't found with id: %s", resource, id));
    }
}
