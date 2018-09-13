package app.config.viewer;

import java.util.Locale;

import ch.ivyteam.ivy.application.IApplication;

public class EmailSettingsDTO {
	private boolean disabled;
	private String dailyTask;
	private boolean onNewTasks;
	private Locale lang;
	
	public EmailSettingsDTO(IApplication app)
	{
		disabled = app.getDefaultEMailNotifcationSettings().isNotificationDisabled();
		dailyTask = app.getDefaultEMailNotifcationSettings().getSendDailyTaskSummary().toString();
		onNewTasks = app.getDefaultEMailNotifcationSettings().isSendOnNewWorkTasks();
		lang = app.getDefaultEMailLanguage();
	}

	public boolean isDisabled() {
		return disabled;
	}

	public String getDailyTask() {
		return dailyTask;
	}

	public boolean isOnNewTasks() {
		return onNewTasks;
	}

	public Locale getLang() {
		return lang;
	}
	
	
}
