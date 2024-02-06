package com.quillquest.model.Response;

public class DeleteUserResponse {

    private boolean sucess;

    private String message;

    public DeleteUserResponse() {
    }

    public DeleteUserResponse(boolean sucess, String message) {
        this.sucess = sucess;
        this.message = message;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
