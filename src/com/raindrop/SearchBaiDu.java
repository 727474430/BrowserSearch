package com.raindrop;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

import javax.swing.*;

/**
 * @name: com.raindrop.SearchBaiDu.java
 * @description: BaiDu search
 * @author: Raindrop
 * @create Time: 2018/5/16 20:47
 */
public class SearchBaiDu extends AnAction {

    /**
     * Default Prefix
     */
    private static final String BAIDU_SEARCH_PREFIX = "https://www.baidu.com/s?wd=";

    public SearchBaiDu() {
        // Load icon
        super(null, null, new ImageIcon(SearchBaiDu.class.getClassLoader().getResource("icon/baidu.png")));
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        // get editor
        final Editor editor = e.getData(PlatformDataKeys.EDITOR);
        // get select model
        SelectionModel selectionModel = editor.getSelectionModel();
        // get user selected text
        String text = selectionModel.getSelectedText();
        if (text != null && text.trim() != "") {
            // Open the browser
            BrowserUtil.browse(BAIDU_SEARCH_PREFIX + text);
        } else {
            BrowserUtil.browse(BAIDU_SEARCH_PREFIX);
        }
    }

}
