package in.ashokit.service;

import java.util.List;

import in.ashokit.bindings.App;

public interface ArSevice {

     public String createApplication(App app);
	
	 public List<App> fetchApps(Integer userId);

}
