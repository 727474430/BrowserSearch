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
 * @name: com.raindrop.SearchDuckduckgo.java
 * @description: Duckduckgo搜索Action
 * @author: Wang Liang
 * @create Time: 2018/5/16 20:47
 * @copyright:
 */
public class SearchDuckduckgo extends AnAction {

	/** Default Prefix */
	public static final String DUCK_SEARCH_PREFIX = "https://duckduckgo.com/?q=";
	/** Default Suffix */
	public static final String DEFAULT_SUFFIX = "";

	public SearchDuckduckgo() {
		super(null, null, new ImageIcon(SearchDuckduckgo.class.getClassLoader().getResource("icon/duckduckgo.png")));
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
			BrowserUtil.browse(DUCK_SEARCH_PREFIX + text);
		} else {
			BrowserUtil.browse(DUCK_SEARCH_PREFIX + DEFAULT_SUFFIX);
		}
	}

}
