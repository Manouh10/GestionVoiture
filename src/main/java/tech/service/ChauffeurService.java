package tech.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import tech.model.Chauffeur; 
import tech.repo.ChauffeurRepo; 
import java.util.List;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ChauffeurService {
	@Autowired
	private ChauffeurRepo chauffeurRepo;

	// instancer superRepo de atao ao amboniny le autowired(tsy mila constructeur
	// ana repo)

	public Chauffeur loginChauffeur(Chauffeur chauffeur)
    {
        Optional<Chauffeur> opt= chauffeurRepo.findLogin(chauffeur.getEmail(), chauffeur.getMot_de_passe());
         
        if(opt.isPresent()){
            return opt.get();
        } 
        return null;
    }
	public List<Chauffeur> getAllChauffeur()
	{
		return chauffeurRepo.findAll();
	}

	/*
	 * public void sendMail(JavaMailSender emailSender) { SimpleMailMessage
	 * message=new SimpleMailMessage();
	 * message.setFrom("no-reply@produiLaitier.mg");
	 * message.setTo("jrmanouhoseah@gmail.com");
	 * message.setSubject("Simple message"); message.setText("Test");
	 * emailSender.send(message); }
	 */

}
