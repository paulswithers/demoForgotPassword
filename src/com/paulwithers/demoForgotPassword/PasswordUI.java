package com.paulwithers.demoForgotPassword;

import lotus.domino.NotesThread;

import org.openntf.domino.Session;
import org.openntf.domino.utils.Factory;
import org.openntf.domino.utils.Factory.SessionType;

import com.ibm.domino.osgi.core.context.ContextInfo;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class PasswordUI extends UI {
	private static final long serialVersionUID = 1L;

	public PasswordUI() {

	}

	public PasswordUI(Component content) {
		super(content);
	}

	@Override
	protected void init(VaadinRequest request) {
		HorizontalLayout layout = new HorizontalLayout();
		setContent(layout);
		layout.setSizeFull();

		Label label = new Label();
		label.setValue("<h1>Please enter your username and new password</h1>");
		label.setContentMode(ContentMode.HTML);
		layout.addComponent(label);
		layout.setComponentAlignment(label, Alignment.TOP_CENTER);

		try {
			Factory.initThread(Factory.STRICT_THREAD_CONFIG);
			NotesThread.sinitThread();
			Session mySess = Utils.getUserSession(ContextInfo.getUserSession());
			Label label2 = new Label();
			label2.setValue(mySess.getEffectiveUserName());
			layout.addComponent(label2);
			layout.setComponentAlignment(label2, Alignment.TOP_LEFT);
			Label label3 = new Label();
			label3.setValue(Factory.getSession(SessionType.NATIVE).getEffectiveUserName());
			layout.addComponent(label3);
			layout.setComponentAlignment(label3, Alignment.TOP_LEFT);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			NotesThread.stermThread();
			Factory.termThread();
		}
	}

}
