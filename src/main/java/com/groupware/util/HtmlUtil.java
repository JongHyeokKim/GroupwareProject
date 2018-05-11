package com.groupware.util;

import org.htmlcleaner.HtmlCleaner;

/**
 * @Class Name : HtmlUtil.java
 * @Description : HTML태그 제거를 위한 Util 클래스
 * @Modification Information
 * @author 김태균
 * @since  2016.09.28.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일      		 수정자          		수정내용
 *    -------      -------     -------------------
 *    2016.09.28.  	김태균        			최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public class HtmlUtil {
	/**
	 * HTML 태그 제거용 메서드
	 * 
	 * @param none
	 * @return String
	 * @throws none
	 */
	public static String HtmlCleaner(String inputText) {
		String plainText = new HtmlCleaner().clean(inputText).getText().toString();
		return plainText;
	}
	
}
