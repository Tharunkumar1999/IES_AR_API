package in.ashokit.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.bindings.App;
import in.ashokit.constants.AppConstants;
import in.ashokit.entities.AppEntity;
import in.ashokit.exceptions.SsaWebException;
import in.ashokit.repositories.AppRepo;

@Service
public class ArServiceImpl implements ArSevice{

    @Autowired
    private AppRepo appRepo;

    private static final String SSA_WEB_API_URL = "https://ssa.web.app/{ssn}";

    @Override
    public String createApplication(App app) {
       
        try{
            WebClient webClient = WebClient.create(); //create a web client

           String stateName = webClient.get()
                            .uri(SSA_WEB_API_URL, app.getSsn())
                            .retrieve()
                            .bodyToMono(String.class)
                            .block();

            if(AppConstants.RI.equals(stateName)){
                AppEntity entity = new AppEntity();
                BeanUtils.copyProperties(app, entity);
                entity = appRepo.save(entity);

                return "App created with case Num : " + entity.getCaseNum();
            }

        }catch (Exception e){
            throw new SsaWebException(e.getMessage());
        }

        return AppConstants.INVALID_SSN;

    }

    @Override
    public List<App> fetchApps(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchApps'");
    }

}
