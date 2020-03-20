package com.raindrop.util;

import javax.swing.*;
import java.util.Objects;

/**
 * @name: com.raindrop.util.IconLoadUtil.java
 * @description: ImageIcon load util
 * @author: Wang Liang
 * @create Time: 2020/3/20 12:45
 */
public class IconLoadUtil {

    /**
     * Load icon by path
     *
     * @param iconPath
     * @return
     */
    public static ImageIcon loadByPath(String iconPath) {
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(IconLoadUtil.class.getClassLoader().getResource(iconPath)));
        return imageIcon;
    }

}
