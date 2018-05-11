package com.groupware.login.common;

import com.groupware.dto.MemberVO;

public interface RegistrationNotifier {
	public void sendMail(Receiver receiver,String tempPwd);
}
