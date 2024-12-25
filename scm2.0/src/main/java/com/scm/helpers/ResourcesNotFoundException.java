package com.scm.helpers;

public class ResourcesNotFoundException extends RuntimeException{
    public ResourcesNotFoundException(String message){
        super(message);
    }

    public ResourcesNotFoundException(){
        super("Resources not found");
    }
}
