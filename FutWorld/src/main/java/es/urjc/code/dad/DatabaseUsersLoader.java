package es.urjc.code.dad;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@PostConstruct
	private void initDataBase(){
//		Manager jorgePalomo = new Manager("Jorge Palomo","Alcorcon","JorPal","adalc","ROLE_USER");
//		managerRepository.save(jorgePalomo);
//		
//		Manager franciscoMijan = new Manager("Francisco Mijan","Getafe","FranMij","gtffc","ROLE_USER");
//		managerRepository.save(franciscoMijan);
	}
}
