package com.raindrop;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

import javax.swing.*;

/**
 * @name: com.raindrop.SearchGoogle.java
 * @description: Google search
 * @author: Raindrop
 * @create Time: 2018/5/16 20:47
 */
public class SearchGoogle extends AnAction {

    /**
     * Default Prefix
     */
    public static final String GOOGLE_SEARCH_PREFIX = "https://www.google.com/search?q=";

    public SearchGoogle() {
        // Load icon
        super(null, null, new ImageIcon(SearchGoogle.class.getClassLoader().getResource("icon/chrome.png")));
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
            BrowserUtil.browse(GOOGLE_SEARCH_PREFIX + text);
        } else {
            BrowserUtil.browse(GOOGLE_SEARCH_PREFIX);
        }
    }

}
