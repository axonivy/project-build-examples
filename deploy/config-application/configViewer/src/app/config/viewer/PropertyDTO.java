package app.config.viewer;

import ch.ivyteam.ivy.system.IProperty;

public class PropertyDTO {
	private String name;
	private String value;
	
	public PropertyDTO(IProperty property)
	{
		name = property.getName();
		value = property.getValue();
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
	
}
