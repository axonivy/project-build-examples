package app.config.viewer;

import ch.ivyteam.ivy.application.restricted.IGlobalVariable;

public class GlobalVariableDTO {
	private String name;
	private String description;
	private String value;
	
	public GlobalVariableDTO(IGlobalVariable var) {
		name = var.getName();
		description = var.getDescription();
		value = var.getValue();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getValue() {
		return value;
	}
	
	
}

