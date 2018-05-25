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
 * @name: com.raindrop.SearchStackOverflow.java
 * @description: StackOverflow搜索Action
 * @author: Wang Liang
 * @create Time: 2018/5/16 20:47
 * @copyright:
 */
public class SearchStackOverflow extends AnAction {

	/** Default Prefix */
	public static final String SO_SEARCH_PREFIX = "https://stackoverflow.com/search?q=";
	/** Default Suffix */
	public static final String DEFAULT_SUFFIX = "";

	public SearchStackOverflow() {
		super(null, null, new ImageIcon(SearchStackOverflow.class.getClassLoader().getResource("icon/stackoverflow.png")));
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
			BrowserUtil.browse(SO_SEARCH_PREFIX + text);
		} else {
			BrowserUtil.browse(SO_SEARCH_PREFIX + DEFAULT_SUFFIX);
		}
	}

}
