package com.european.ed.util;

public class ActionResult {
    private boolean success;
    private String description;
    private int errorCode;

    public ActionResult(boolean success, String description, int errorCode) {
        this.success = success;
        this.description = description;
        this.errorCode = errorCode;
    }
    

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ActionResult{" + "success=" + success + ", description=" + description + ", errorCode=" + errorCode + '}';
    }
    
    
}
