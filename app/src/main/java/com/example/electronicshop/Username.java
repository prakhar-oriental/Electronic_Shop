package com.example.electronicshop;

import com.google.firebase.auth.FirebaseUser;

public class Username {
    String Username;
    String currentUserId;

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }





    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
