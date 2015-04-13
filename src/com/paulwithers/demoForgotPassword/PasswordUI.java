package com.paulwithers.demoForgotPassword;

import lotus.domino.NotesThread;

import org.openntf.domino.utils.Factory;
import org.openntf.domino.utils.Factory.SessionType;

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

		Factory.initThread(Factory.STRICT_THREAD_CONFIG);
		NotesThread.sinitThread();
		Label label2 = new Label();
		System.out.println("Getting username");
		label2.setValue(Factory.getSession(SessionType.CURRENT).getEffectiveUserName());
		layout.addComponent(label2);
		layout.setComponentAlignment(label2, Alignment.TOP_LEFT);

		NotesThread.stermThread();
		Factory.termThread();
	}

}
