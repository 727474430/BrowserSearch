package com.raindrop;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;

/**
 * @name: com.raindrop.SearchBaidu.java
 * @description: 百度搜索Action
 * @author: Wang Liang
 * @create Time: 2018/5/16 20:47
 * @copyright:
 */
public class SearchBaidu extends AnAction {

	/** Default Prefix */
	public static final String BAIDU_SEARCH_PREFIX = "https://www.baidu.com/s?wd=";
	/** Default Suffix */
	public static final String DEFAULT_SUFFIX = "";

	public SearchBaidu() {
		super(null, null, new ImageIcon(SearchBaidu.class.getClassLoader().getResource("icon/baidu.png")));
	}

	@Override
	public void actionPerformed(AnActionEvent e) {
		// get editor
		final Editor editor = e.getData(PlatformDataKeys.EDITOR);
		// get select model
		SelectionModel selectionModel = editor.getSelectionModel();
		// get user selected text
		String text = selectionModel.getSelectedText();
		if (StringUtils.isNotBlank(text)) {
			// Open the browser
			BrowserUtil.browse(BAIDU_SEARCH_PREFIX + text);
		} else {
			BrowserUtil.browse(BAIDU_SEARCH_PREFIX + DEFAULT_SUFFIX);
		}
	}

}
