package com.paulwithers.demoForgotPassword;

import org.openntf.domino.Session;
import org.openntf.domino.utils.Factory;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public static Session getUserSession(lotus.domino.Session sess) {
		Session retVal_ = null;
		try {
			retVal_ = Factory.fromLotus(sess, Session.SCHEMA, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal_;
	}

}
