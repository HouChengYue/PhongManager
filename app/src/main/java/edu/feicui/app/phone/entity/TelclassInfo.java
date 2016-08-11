package edu.feicui.app.phone.entity;

/**
 * Created by houch on 2016/6/13.
 */
public class TelclassInfo {
    public String name;
    // 唯一 ID
    public int idx;
    // 重写构造方法
    public TelclassInfo(String name, int idx) {
        super();
        this.name = name;
        this.idx = idx;
    }
    // 系统默认构造方法
    public TelclassInfo() {
        super();
    }
}
