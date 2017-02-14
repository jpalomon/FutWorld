package es.urjc.code.dad;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FutWorldController {
	
	@Autowired
	private TorneoRepository torneoRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	private List<Torneo> torneos = new ArrayList<>();
	private List<Equipo> equiposEspaña = new ArrayList<>();
	private List<Equipo> equiposInglaterra = new ArrayList<>();
	private List<Equipo> equiposItalia = new ArrayList<>();
	private List<Equipo> equiposAlemania = new ArrayList<>();
	private List<Equipo> equiposFrancia = new ArrayList<>();
	private List<Equipo> equiposPortugal = new ArrayList<>();
	
	@PostConstruct
	public void inicio(){
		Torneo ligaEspañola = new Torneo("Liga Española",equiposEspaña);
		Torneo premierLeague = new Torneo("Premier League",equiposInglaterra);
		Torneo serieA = new Torneo("Serie A",equiposItalia);
		Torneo bundesliga = new Torneo("Bundesliga",equiposAlemania);
		Torneo ligueOne = new Torneo("Ligue 1",equiposFrancia);
		Torneo ligaPortuguesa = new Torneo("Liga Portuguesa",equiposPortugal);
		
		torneoRepository.save(ligaEspañola);
		torneoRepository.save(premierLeague);
		torneoRepository.save(serieA);
		torneoRepository.save(bundesliga);
		torneoRepository.save(ligueOne);
		torneoRepository.save(ligaPortuguesa);
		
		Equipo realMadrid = ;
		Equipo barcelona = 
		Equipo atleticoMadrid =;
		Equipo sevilla =;
		Equipo villarreal =;
		Equipo athleticBilbao =;
		Equipo leganes =;
	}
	
	@RequestMapping("/")
	public String principal (){
		return "index";
	}
}
