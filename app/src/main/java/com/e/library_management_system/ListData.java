package com.e.library_management_system;

public class ListData {
    private String content;
    private int flag;
    public static final int SEND = 1;
    public static final int ReCEIVE = 2;

    public ListData(String content, int flag) {
        setContent(content);
        setFlag(flag);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
