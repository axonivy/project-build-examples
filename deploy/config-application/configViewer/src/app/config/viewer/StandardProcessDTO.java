package app.config.viewer;

import ch.ivyteam.ivy.application.IProcessModel;

public class StandardProcessDTO {
	private String name;
	private String desc;
	
	public StandardProcessDTO(IProcessModel pm)
	{
		name = pm.getName();
		desc = pm.getDescription();
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
	
}
