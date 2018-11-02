package com.phoneticalphabet.bean;

import java.io.Serializable;

public class VoiceBean implements Serializable {

    private String name;

    private String voicePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }
}
