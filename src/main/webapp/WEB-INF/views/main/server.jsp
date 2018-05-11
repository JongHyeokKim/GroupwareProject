<%@ page  contentType = "text/event-stream;charset=utf-8" %>
<%--==============================================================
 * 메시지 서버 페이지
 * @author 이준수
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *     수정일              수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    이준수                     최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
retry:800
data:${sessionScope.newMsgPush}
data:${sessionScope.noneReadMsg}


