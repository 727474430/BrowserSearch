package com.raindrop.action;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.util.text.StringUtil;
import com.raindrop.enums.BrowserEngineType;
import com.raindrop.util.IconLoadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @name: com.raindrop.action.SearchBaiDu.java
 * @description: BaiDu search action
 * @author: Raindrop
 * @create Time: 2018/5/16 20:47
 */
public class SearchBaiDu extends AnAction {

    private static final Logger logger = LoggerFactory.getLogger(SearchBaiDu.class);

    public SearchBaiDu() {
        super(null, null, IconLoadUtil.loadByPath("icon/baidu.png"));
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        // get editor
        final Editor editor = e.getData(PlatformDataKeys.EDITOR);
        // get select model
        SelectionModel selectionModel = editor.getSelectionModel();
        // get user selected text
        String text = selectionModel.getSelectedText();
        if (!StringUtil.isEmpty(text)) {
            try {
                text = URLEncoder.encode(text, "utf-8");
            } catch (UnsupportedEncodingException ex) {
                logger.error("BaiDu search url encode error: {}", ex.getMessage());
            }
            logger.info("BaiDu search text : {}", text);
            BrowserUtil.browse(BrowserEngineType.BAIDU_ENGINE.getEnginePath() + text);
        }
    }

}
