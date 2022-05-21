package tech.service;

import org.springframework.beans.factory.annotation.Autowired; 
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import  tech.model.Administrateur;
import tech.repo.AdministrateurRepo; 

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AdministrateurService {
	@Autowired
    private AdministrateurRepo adminRepo  ;
    
    //instancer superRepo de atao ao amboniny le autowired(tsy mila constructeur ana repo)
     
    public Administrateur loginSuper(Administrateur admin)
    {
        Optional<Administrateur> opt= adminRepo.findLogin(admin.getLogin(),admin.getMot_de_passe());
        if(opt.isPresent()){
            return opt.get();
        } 
        return null;
    }
    
    
   /* public void sendMail(JavaMailSender emailSender)
    { 
    	SimpleMailMessage message=new SimpleMailMessage();
    	message.setFrom("no-reply@produiLaitier.mg");
    	message.setTo("jrmanouhoseah@gmail.com");
    	message.setSubject("Simple message");
    	message.setText("Test");
    	emailSender.send(message);
    }*/
    



}
