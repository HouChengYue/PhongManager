package edu.feicui.app.phone.entity;

import java.io.File;

/**
 * 文件信息类
 * Created by Administrator on 2016/7/7.
 */
public class FileInfo {
    private File file;
    private boolean isSelect;
    //图标图像文件名称
    private String iconName;
    //文件分类
    private String fileType;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public FileInfo(File file, String iconName, String fileType){
        super();
        this.file=file;
        this.iconName=iconName;
        this.fileType=fileType;
        isSelect=false;
    }
}
