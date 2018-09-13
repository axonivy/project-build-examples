package app.config.viewer;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.application.IProcessModel;
import ch.ivyteam.ivy.application.restricted.IGlobalVariable;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.security.exec.Sudo;
import ch.ivyteam.ivy.system.IProperty;

@ManagedBean
@RequestScoped
public class Bean {
	private String actualEnv;
	private List<GlobalVariableDTO> variables = new ArrayList<>();
	private EmailSettingsDTO email;
	private List<PropertyDTO> properties = new ArrayList<>();
	private List<StandardProcessDTO> processes = new ArrayList<>();

	public Bean() {
		Sudo.exec(() -> {
			IApplication app = Ivy.getInstance().request.getApplication();
			actualEnv = app.getActiveEnvironment();
			for (IGlobalVariable var : app.getDefaultGlobalVariables()) {
				variables.add(new GlobalVariableDTO(var));
			}
			email = new EmailSettingsDTO(app);
			for (IProperty prop : app.getConfigurationProperties()) {
				properties.add(new PropertyDTO(prop));
			}
			for (IProcessModel pm : app.getProcessModels()) {
				processes.add(new StandardProcessDTO(pm));
			}
		});
	}

	public String getActualEnvironment() {
		return actualEnv;
	}

	public List<GlobalVariableDTO> getGlobalVariables() {
		return variables;
	}

	public EmailSettingsDTO getEmailSettings() {
		return email;
	}

	public List<PropertyDTO> getProperties() {
		return properties;
	}

	public List<StandardProcessDTO> getStandardProcess() {
		return processes;
	}

}
