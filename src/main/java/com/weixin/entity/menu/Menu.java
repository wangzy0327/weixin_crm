package com.weixin.entity.menu;

import java.util.Arrays;

/**
 * 类名: Menu </br>
 * 包名： com.weixin.entity.menu
 * 描述: 整个菜单对象的封装 </br>
 * 发布版本：V1.0  </br>
 */
public class Menu {
    private Button[] button;

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "button=" + Arrays.toString(button) +
                '}';
    }
}
