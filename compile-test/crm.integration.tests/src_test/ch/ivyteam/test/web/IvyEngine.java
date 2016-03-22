package ch.ivyteam.test.web;

public class IvyEngine {
	
	public static String getBaseUrl() 
	{
		String vmArgUrl = System.getProperty("engineUrl");
		if (vmArgUrl != null) {
			return vmArgUrl;
		}
		// assume designer/inMemory
		return "http://localhost:8081/ivy";
	}

}
