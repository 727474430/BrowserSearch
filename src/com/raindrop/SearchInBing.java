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
 * @name: com.raindrop.GotoBing.java
 * @description: 必应搜索插件
 * @author: Wang Liang
 * @create Time: 2018/5/16 20:47
 * @copyright: 深圳拖保软件有限公司
 */
public class SearchInBing extends AnAction {

	/** Default Prefix */
	public static final String BING_SEARCH_PREFIX = "https://cn.bing.com/search?q=";
	/** Default Suffix */
	public static final String DEFAULT_SUFFIX = "";

	public SearchInBing() {
		super(null, null, new ImageIcon(SearchInBing.class.getClassLoader().getResource("icon/bing.png")));
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
			BrowserUtil.browse(BING_SEARCH_PREFIX + text);
		} else {
			BrowserUtil.browse(BING_SEARCH_PREFIX + DEFAULT_SUFFIX);
		}
	}
}
