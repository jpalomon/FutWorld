package es.urjc.code.dad;

import java.io.File;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FutWorldController {
	
	//Inyectamos los repositorios.
	@Autowired
	private TorneoRepository torneoRepository;	
	@Autowired
	private EquipoRepository equipoRepository;	
	@Autowired
	private JugadorRepository jugadorRepository;	
	@Autowired
	private ManagerRepository managerRepository;	
	@Autowired
	private PalmaresRepository palmaresRepository;
	
	//User y Password Compartidas HttpSession
	String userCompartida;
	String passwordCompartida;
	
	@PostConstruct 
	//Indicamos los torneos, equipos y jugadores añadidos por defecto al ejecutarse el programa.
	public void predeterminado(){
		//Generamos los siguientes Torneos, Equipos, Jugadores y Mánagers únicamente la primera vez que se 
		//ejecuta la app. Las demás veces, como ya están cargado los datos (persistencia), los comentamos.
		
//		//Creamos los Torneos.
//		Torneo laLiga = new Torneo("La Liga",20);
//		Torneo premierLeague = new Torneo("Premier League",20);
//		Torneo serieA = new Torneo("Serie A",20);
//		Torneo bundesliga = new Torneo("Bundesliga",20);
//		Torneo ligueOne = new Torneo("Ligue 1",20);
//		Torneo ligaNos = new Torneo("Liga NOS",20);
//		
//		torneoRepository.save(laLiga);
//		torneoRepository.save(premierLeague);
//		torneoRepository.save(serieA);
//		torneoRepository.save(bundesliga);
//		torneoRepository.save(ligueOne);
//		torneoRepository.save(ligaNos);
//		
//		//Creamos los Equipos de la Liga Española.
//		Equipo realMadrid = new Equipo("Real Madrid","La Liga","España",32);
//		Equipo barcelona = new Equipo("Barcelona","La Liga","España",24);
//		Equipo atleticoMadrid = new Equipo("Atletico de Madrid","La Liga","España",10);
//		Equipo sevilla = new Equipo("Sevilla","La Liga","España",1);
//		Equipo villarreal = new Equipo("Villarreal","La Liga","España",0);
//		Equipo leganes = new Equipo("Leganes","La Liga","España",0);
//		
//		realMadrid.setTorneo(laLiga);
//		barcelona.setTorneo(laLiga);
//		atleticoMadrid.setTorneo(laLiga);
//		sevilla.setTorneo(laLiga);
//		villarreal.setTorneo(laLiga);
//		leganes.setTorneo(laLiga);
//		
//		equipoRepository.save(realMadrid);
//		equipoRepository.save(barcelona);
//		equipoRepository.save(atleticoMadrid);
//		equipoRepository.save(sevilla);
//		equipoRepository.save(villarreal);
//		equipoRepository.save(leganes);
//		
//		//Creamos los Equipos de la Premier League.
//		Equipo chelsea = new Equipo("Chelsea","Premier League","Inglaterra",4);
//		Equipo arsenal = new Equipo("Arsenal","Premier League","Inglaterra",3);
//		Equipo liverpool = new Equipo("Liverpool","Premier League","Inglaterra",0);
//		Equipo manchesterUnited = new Equipo("Manchester United","Premier League","Inglaterra",13);
//		Equipo manchesterCity = new Equipo("Manchester City","Premier League","Inglaterra",2);
//		Equipo tottenham = new Equipo("Tottenham","Premier League","Inglaterra",0);
//		
//		chelsea.setTorneo(premierLeague);
//		arsenal.setTorneo(premierLeague);
//		liverpool.setTorneo(premierLeague);
//		manchesterUnited.setTorneo(premierLeague);
//		manchesterCity.setTorneo(premierLeague);
//		tottenham.setTorneo(premierLeague);
//		
//		equipoRepository.save(chelsea);
//		equipoRepository.save(arsenal);
//		equipoRepository.save(liverpool);
//		equipoRepository.save(manchesterUnited);
//		equipoRepository.save(manchesterCity);
//		equipoRepository.save(tottenham);
//		
//		//Creamos los Equipos de la Serie A.
//		Equipo juventus = new Equipo("Juventus","Serie A","Italia",32);
//		Equipo milan = new Equipo("Milan","Serie A","Italia",18);
//		Equipo interMilan = new Equipo("Inter de Milan","Serie A","Italia",18);
//		Equipo roma = new Equipo("Roma","Serie A","Italia",3);
//		Equipo napoles = new Equipo("Napoles","Serie A","Italia",2);
//		
//		juventus.setTorneo(serieA);
//		milan.setTorneo(serieA);
//		interMilan.setTorneo(serieA);
//		roma.setTorneo(serieA);
//		napoles.setTorneo(serieA);
//		
//		equipoRepository.save(juventus);
//		equipoRepository.save(milan);
//		equipoRepository.save(interMilan);
//		equipoRepository.save(roma);
//		equipoRepository.save(napoles);
//		
//		//Creamos los Equipos de la Bundesliga.
//		Equipo bayernMunich = new Equipo("Bayern Munich","Bundesliga","Alemania",25);
//		Equipo borussiaDormund = new Equipo("Borussia Dormund","Bundesliga","Alemania",5);
//		Equipo bayerLeverkusen = new Equipo("Bayer Leverkusen","Bundesliga","Alemania",0);
//		Equipo shalke = new Equipo("Shalke 04","Bundesliga","Alemania",0);
//		
//		bayernMunich.setTorneo(bundesliga);
//		borussiaDormund.setTorneo(bundesliga);
//		bayerLeverkusen.setTorneo(bundesliga);
//		shalke.setTorneo(bundesliga);
//		
//		equipoRepository.save(bayernMunich);
//		equipoRepository.save(borussiaDormund);
//		equipoRepository.save(bayerLeverkusen);
//		equipoRepository.save(shalke);
//		
//		//Creamos los Equipos de la Ligue 1.
//		Equipo psg = new Equipo("PSG","Ligue 1","Francia",6);
//		Equipo monaco = new Equipo("Monaco","Ligue 1","Francia",7);
//		Equipo olympiqueLyon = new Equipo("Olympique de Lyon","Ligue 1","Francia",7);
//		Equipo olympiqueMarsella = new Equipo("Olympique de Marsella","Ligue 1","Francia",9);
//		
//		psg.setTorneo(ligueOne);
//		monaco.setTorneo(ligueOne);
//		olympiqueLyon.setTorneo(ligueOne);
//		olympiqueMarsella.setTorneo(ligueOne);
//		
//		equipoRepository.save(psg);
//		equipoRepository.save(monaco);
//		equipoRepository.save(olympiqueLyon);
//		equipoRepository.save(olympiqueMarsella);
//		
//		//Creamos los Equipos de la Liga NOS.
//		Equipo oporto = new Equipo("Oporto","Liga NOS","Portugal",27);
//		Equipo benfica = new Equipo("Benfica","Liga NOS","Portugal",35);
//		Equipo sportingLisboa = new Equipo("Sporting de Lisboa","Liga NOS","Portugal",18);
//		Equipo sportingBraga = new Equipo("Sporting de Braga","Liga NOS","Portugal",0);
//		
//		oporto.setTorneo(ligaNos);
//		benfica.setTorneo(ligaNos);
//		sportingLisboa.setTorneo(ligaNos);
//		sportingBraga.setTorneo(ligaNos);
//		
//		equipoRepository.save(oporto);
//		equipoRepository.save(benfica);
//		equipoRepository.save(sportingLisboa);
//		equipoRepository.save(sportingBraga);
//		
//		//Creamos los jugadores del Real Madrid.
//		Jugador keylorNavas = new Jugador("Keylor Navas","Real Madrid","Portero",30,"Costa Rica",20000000);
//		Jugador sergioRamos = new Jugador("Sergio Ramos","Real Madrid","Defensa",30,"España",40000000);
//		Jugador lukaModric = new Jugador("Luka Modric","Real Madrid","Mediocentro",31,"Croacia",45000000);
//		Jugador cristianoRonaldo = new Jugador("Cristiano Ronaldo","Real Madrid","Delantero",32,"Portugal",100000000);
//		
//		keylorNavas.setEquipo(realMadrid);
//		sergioRamos.setEquipo(realMadrid);
//		lukaModric.setEquipo(realMadrid);
//		cristianoRonaldo.setEquipo(realMadrid);
//		
//		jugadorRepository.save(keylorNavas);
//		jugadorRepository.save(sergioRamos);
//		jugadorRepository.save(lukaModric);
//		jugadorRepository.save(cristianoRonaldo);
//		
//		//Creamos los jugadores del Barcelona.
//		Jugador terStegen = new Jugador("Ter Stegen","Barcelona","Portero",24,"Alemania",22000000);
//		Jugador gerardPique = new Jugador("Gerard Pique","Barcelona","Defensa",30,"España",40000000);
//		Jugador andresIniesta = new Jugador("Andres Iniesta","Barcelona","Mediocentro",32,"España",30000000);
//		Jugador lionelMessi = new Jugador("Lionel Messi","Barcelona","Delantero",29,"Argentina",120000000);
//		
//		terStegen.setEquipo(barcelona);
//		gerardPique.setEquipo(barcelona);
//		andresIniesta.setEquipo(barcelona);
//		lionelMessi.setEquipo(barcelona);
//		
//		jugadorRepository.save(terStegen);
//		jugadorRepository.save(gerardPique);
//		jugadorRepository.save(andresIniesta);
//		jugadorRepository.save(lionelMessi);
//		
//		//Creamos los jugadores del Atletico de Madrid.
//		Jugador janOblak = new Jugador("Jan Oblak","Atletico de Madrid","Portero",24,"Eslovenia",35000000);
//		Jugador diegoGodin = new Jugador("Diego Godin","Atletico de Madrid","Defensa",30,"Uruguay",40000000);
//		Jugador koke = new Jugador("Koke","Atletico de Madrid","Mediocentro",25,"España",55000000);
//		Jugador antoineGriezmann = new Jugador("Antoine Griezmann","Atletico de Madrid","Delantero",25,"Francia",80000000);
//		
//		janOblak.setEquipo(atleticoMadrid);
//		diegoGodin.setEquipo(atleticoMadrid);
//		koke.setEquipo(atleticoMadrid);
//		antoineGriezmann.setEquipo(atleticoMadrid);
//		
//		jugadorRepository.save(janOblak);
//		jugadorRepository.save(diegoGodin);
//		jugadorRepository.save(koke);
//		jugadorRepository.save(antoineGriezmann);		
//		
//		//Creamos los jugadores del Sevilla.
//		Jugador sergioRico = new Jugador("Sergio Rico","Sevilla","Portero",23,"Eslovenia",20000000);
//		Jugador adilRami = new Jugador("Adil Rami","Sevilla","Defensa",31,"Francia",7000000);
//		Jugador vicenteIborra = new Jugador("Vicente Iborra","Sevilla","Mediocentro",29,"España",9000000);
//		Jugador vitolo = new Jugador("Vitolo","Sevilla","Delantero",27,"España",20000000);
//		
//		sergioRico.setEquipo(sevilla);
//		adilRami.setEquipo(sevilla);
//		vicenteIborra.setEquipo(sevilla);
//		vitolo.setEquipo(sevilla);
//		
//		jugadorRepository.save(sergioRico);
//		jugadorRepository.save(adilRami);
//		jugadorRepository.save(vicenteIborra);
//		jugadorRepository.save(vitolo);		
//		
//		//Creamos los jugadores del Villarreal.
//		Jugador sergioAsenjo = new Jugador("Sergio Asenjo","Villarreal","Portero",27,"España",7500000);
//		Jugador mateoMusacchio = new Jugador("Mateo Musacchio","Villarreal","Defensa",26,"Argentina",15000000);
//		Jugador brunoSoriano = new Jugador("Bruno Soriano","Villarreal","Mediocentro",32,"España",8000000);
//		Jugador robertoSoldado = new Jugador("Roberto Soldado","Villarreal","Delantero",31,"España",14000000);
//		
//		sergioAsenjo.setEquipo(villarreal);
//		mateoMusacchio.setEquipo(villarreal);
//		brunoSoriano.setEquipo(villarreal);
//		robertoSoldado.setEquipo(villarreal);
//		
//		jugadorRepository.save(sergioAsenjo);
//		jugadorRepository.save(mateoMusacchio);
//		jugadorRepository.save(brunoSoriano);
//		jugadorRepository.save(robertoSoldado);	
//		
//		//Creamos los jugadores del Leganés.
//		Jugador iagoHerrerin = new Jugador("Iago Herrerín","Leganes","Portero",29,"España",2500000);
//		Jugador martinMantovani = new Jugador("Martin Mantovani","Leganes","Defensa",32,"Argentina",800000);
//		Jugador gabrielPires = new Jugador("Gabriel Pires","Leganes","Mediocentro",23,"España",2500000);
//		Jugador albertoBueno = new Jugador("Alberto Bueno","Leganes","Delantero",28,"España",3000000);
//		
//		iagoHerrerin.setEquipo(leganes);
//		martinMantovani.setEquipo(leganes);
//		gabrielPires.setEquipo(leganes);
//		albertoBueno.setEquipo(leganes);
//		
//		jugadorRepository.save(iagoHerrerin);
//		jugadorRepository.save(martinMantovani);
//		jugadorRepository.save(gabrielPires);
//		jugadorRepository.save(albertoBueno);
//		
//		//Creamos los jugadores del Chelsea.
//		Jugador thibautCourtois = new Jugador("Thibaut Courtois","Chelsea","Portero",24,"Belgica",35000000);
//		Jugador davidLuiz = new Jugador("David Luiz","Chelsea","Defensa",29,"Brasil",30000000);
//		Jugador cescFabregas = new Jugador("Cesc Fabregas","Chelsea","Mediocentro",29,"España",45000000);
//		Jugador diegoCosta = new Jugador("Diego Costa","Chelsea","Delantero",28,"España",45000000);
//		
//		thibautCourtois.setEquipo(chelsea);
//		davidLuiz.setEquipo(chelsea);
//		cescFabregas.setEquipo(chelsea);
//		diegoCosta.setEquipo(chelsea);
//		
//		jugadorRepository.save(thibautCourtois);
//		jugadorRepository.save(davidLuiz);
//		jugadorRepository.save(cescFabregas);
//		jugadorRepository.save(diegoCosta);		
//		
//		//Creamos los jugadores del Arsenal.
//		Jugador petrCech = new Jugador("Petr Cech","Arsenal","Portero",34,"Republica Checa",12000000);
//		Jugador kieranGibbs = new Jugador("Kieran Gibbs","Arsenal","Defensa",27,"Inglaterra",13000000);
//		Jugador aaronRamsey = new Jugador("Aaron Ramsey","Arsenal","Mediocentro",26,"Gales",35000000);
//		Jugador olivierGiroud = new Jugador("Olivier Giroud","Arsenal","Delantero",30,"Francia",25000000);
//		
//		petrCech.setEquipo(arsenal);
//		kieranGibbs.setEquipo(arsenal);
//		aaronRamsey.setEquipo(arsenal);
//		olivierGiroud.setEquipo(arsenal);
//		
//		jugadorRepository.save(petrCech);
//		jugadorRepository.save(kieranGibbs);
//		jugadorRepository.save(aaronRamsey);
//		jugadorRepository.save(olivierGiroud);	
//		
//		//Creamos los jugadores del Liverpool.
//		Jugador simonMignolet = new Jugador("Simon Mignolet","Liverpool","Portero",28,"Belgica",12000000);
//		Jugador joelMatip = new Jugador("Joel Matip","Liverpool","Defensa",25,"Alemania",18000000);
//		Jugador philippeCoutinho = new Jugador("Philippe Coutinho","Liverpool","Mediocentro",24,"Brasil",35000000);
//		Jugador danielSturridge = new Jugador("Daniel Sturridge","Liverpool","Delantero",27,"Inglaterra",25000000);
//		
//		simonMignolet.setEquipo(liverpool);
//		joelMatip.setEquipo(liverpool);
//		philippeCoutinho.setEquipo(liverpool);
//		danielSturridge.setEquipo(liverpool);
//		
//		jugadorRepository.save(simonMignolet);
//		jugadorRepository.save(joelMatip);
//		jugadorRepository.save(philippeCoutinho);
//		jugadorRepository.save(danielSturridge);		
//		
//		//Creamos los jugadores del Manchester United.
//		Jugador davidDeGea = new Jugador("David De Gea","Manchester United","Portero",26,"España",40000000);
//		Jugador ericBailly = new Jugador("Eric Bailly","Manchester United","Defensa",22,"Costa de Marfil",25000000);
//		Jugador paulPogba = new Jugador("Paul Pogba","Manchester United","Mediocentro",23,"Francia",80000000);
//		Jugador zlatanIbrahimovic = new Jugador("Zlatan Ibrahimovic","Manchester United","Delantero",35,"Suecia",12000000);
//		
//		davidDeGea.setEquipo(manchesterUnited);
//		ericBailly.setEquipo(manchesterUnited);
//		paulPogba.setEquipo(manchesterUnited);
//		zlatanIbrahimovic.setEquipo(manchesterUnited);
//		
//		jugadorRepository.save(davidDeGea);
//		jugadorRepository.save(ericBailly);
//		jugadorRepository.save(paulPogba);
//		jugadorRepository.save(zlatanIbrahimovic);		
//		
//		//Creamos los jugadores del Manchester City.
//		Jugador claudioBravo = new Jugador("Claudio Bravo","Manchester City","Portero",33,"Chile",15000000);
//		Jugador johnStones = new Jugador("John Stones","Manchester City","Defensa",22,"Inglaterra",35000000);
//		Jugador yayaToure = new Jugador("Yaya Toure","Manchester City","Mediocentro",33,"Costa de Marfil",12000000);
//		Jugador sergioAguero = new Jugador("Sergio Aguero","Manchester City","Delantero",28,"Argentina",60000000);
//		
//		claudioBravo.setEquipo(manchesterCity);
//		johnStones.setEquipo(manchesterCity);
//		yayaToure.setEquipo(manchesterCity);
//		sergioAguero.setEquipo(manchesterCity);
//		
//		jugadorRepository.save(claudioBravo);
//		jugadorRepository.save(johnStones);
//		jugadorRepository.save(yayaToure);
//		jugadorRepository.save(sergioAguero);		
//		
//		//Creamos los jugadores del Tottenham.
//		Jugador hugoLloris = new Jugador("Hugo Lloris","Tottenham","Portero",30,"Francia",24000000);
//		Jugador tobyAlderweireld = new Jugador("Toby Alderweireld","Tottenham","Defensa",27,"Belgica",27000000);
//		Jugador ericDier = new Jugador("Eric Dier","Tottenham","Mediocentro",23,"Inglaterra",18000000);
//		Jugador harryKane = new Jugador("Harry Kane","Tottenham","Delantero",23,"Inglaterra",40000000);
//		
//		hugoLloris.setEquipo(tottenham);
//		tobyAlderweireld.setEquipo(tottenham);
//		ericDier.setEquipo(tottenham);
//		harryKane.setEquipo(tottenham);
//		
//		jugadorRepository.save(hugoLloris);
//		jugadorRepository.save(tobyAlderweireld);
//		jugadorRepository.save(ericDier);
//		jugadorRepository.save(harryKane);
//		
//		//Creamos los jugadores del Juventus.
//		Jugador gianluigiBuffon = new Jugador("Gianluigi Buffon","Juventus","Portero",39,"Italia",2000000);
//		Jugador leonardoBonucci = new Jugador("Leonardo Bonucci","Juventus","Defensa",29,"Italia",40000000);
//		Jugador tomasRincon = new Jugador("Tomas Rincon","Juventus","Mediocentro",29,"Venezuela",9000000);
//		Jugador gonzaloHiguain = new Jugador("Gonzalo Higuain","Juventus","Delantero",29,"Argentina",75000000);
//		
//		gianluigiBuffon.setEquipo(juventus);
//		leonardoBonucci.setEquipo(juventus);
//		tomasRincon.setEquipo(juventus);
//		gonzaloHiguain.setEquipo(juventus);
//		
//		jugadorRepository.save(gianluigiBuffon);
//		jugadorRepository.save(leonardoBonucci);
//		jugadorRepository.save(tomasRincon);
//		jugadorRepository.save(gonzaloHiguain);		
//		
//		//Creamos los jugadores del Milán.
//		Jugador gianluigiDonnarumma = new Jugador("Gianluigi Donnarumma","Milan","Portero",17,"Italia",20000000);
//		Jugador alessioRomagnoli = new Jugador("Alessio Romagnoli","Milan","Defensa",22,"Italia",25000000);
//		Jugador giacomoBonaventura = new Jugador("Giacomo Bonaventura","Milan","Mediocentro",27,"Italia",24000000);
//		Jugador carlosBacca = new Jugador("Carlos Bacca","Milan","Delantero",30,"Venezuela",23000000);
//		
//		gianluigiDonnarumma.setEquipo(milan);
//		alessioRomagnoli.setEquipo(milan);
//		giacomoBonaventura.setEquipo(milan);
//		carlosBacca.setEquipo(milan);
//		
//		jugadorRepository.save(gianluigiDonnarumma);
//		jugadorRepository.save(alessioRomagnoli);
//		jugadorRepository.save(giacomoBonaventura);
//		jugadorRepository.save(carlosBacca);	
//		
//		//Creamos los jugadores del Inter de Milán.
//		Jugador samirHandanovic = new Jugador("Samir Handanovic","Inter de Milan","Portero",32,"Eslovenia",12500000);
//		Jugador jeisonMurillo = new Jugador("Jeison Murillo","Inter de Milan","Defensa",24,"Venezuela",14000000);
//		Jugador marceloBrozovic = new Jugador("Marcelo Brozovic","Inter de Milan","Mediocentro",24,"Croacia",22000000);
//		Jugador mauroIcardi = new Jugador("Mauro Icardi","Inter de Milan","Delantero",23,"Argentina",45000000);
//		
//		samirHandanovic.setEquipo(interMilan);
//		jeisonMurillo.setEquipo(interMilan);
//		marceloBrozovic.setEquipo(interMilan);
//		mauroIcardi.setEquipo(interMilan);
//		
//		jugadorRepository.save(samirHandanovic);
//		jugadorRepository.save(jeisonMurillo);
//		jugadorRepository.save(marceloBrozovic);
//		jugadorRepository.save(mauroIcardi);		
//		
//		//Creamos los jugadores del Roma.
//		Jugador wojciechSzczesny = new Jugador("Wojciech Szczesny","Roma","Portero",26,"Polonia",14000000);
//		Jugador konstantinosManolas = new Jugador("Konstantinos Manolas","Roma","Defensa",25,"Grecia",28000000);
//		Jugador radjaNainggolan = new Jugador("Radja Nainggolan","Roma","Mediocentro",28,"Belgica",35000000);
//		Jugador edinDzeko = new Jugador("Edin Dzeko","Roma","Delantero",30,"Bosnia",15000000);
//		
//		wojciechSzczesny.setEquipo(roma);
//		konstantinosManolas.setEquipo(roma);
//		radjaNainggolan.setEquipo(roma);
//		edinDzeko.setEquipo(roma);
//		
//		jugadorRepository.save(wojciechSzczesny);
//		jugadorRepository.save(konstantinosManolas);
//		jugadorRepository.save(radjaNainggolan);
//		jugadorRepository.save(edinDzeko);		
//		
//		//Creamos los jugadores del Nápoles.
//		Jugador pepeReina = new Jugador("Pepe Reina","Napoles","Portero",34,"España",3000000);
//		Jugador kalidouKoulibaly = new Jugador("Kalidou Koulibaly","Napoles","Defensa",25,"Francia",30000000);
//		Jugador marekHamsik = new Jugador("Marek Hamsik","Napoles","Mediocentro",29,"Eslovaquia",40000000);
//		Jugador arkadiuszMilik = new Jugador("Arkadiusz Milik","Napoles","Delantero",22,"Polonia",20000000);
//		
//		pepeReina.setEquipo(napoles);
//		kalidouKoulibaly.setEquipo(napoles);
//		marekHamsik.setEquipo(napoles);
//		arkadiuszMilik.setEquipo(napoles);
//		
//		jugadorRepository.save(pepeReina);
//		jugadorRepository.save(kalidouKoulibaly);
//		jugadorRepository.save(marekHamsik);
//		jugadorRepository.save(arkadiuszMilik);
//		
//		//Creamos los jugadores del Bayern Munich.
//		Jugador manuelNeuer = new Jugador("Manuel Neuer","Bayern Munich","Portero",30,"Alemania",45000000);
//		Jugador philippLahm = new Jugador("Philipp Lahm","Bayern Munich","Defensa",33,"Alemania",11000000);
//		Jugador arturoVidal = new Jugador("Arturo Vidal","Bayern Munich","Mediocentro",29,"Chile",37000000);
//		Jugador robertLewandowski = new Jugador("Robert Lewandowski","Bayern Munich","Delantero",28,"Polonia",80000000);
//		
//		manuelNeuer.setEquipo(bayernMunich);
//		philippLahm.setEquipo(bayernMunich);
//		arturoVidal.setEquipo(bayernMunich);
//		robertLewandowski.setEquipo(bayernMunich);
//		
//		jugadorRepository.save(manuelNeuer);
//		jugadorRepository.save(philippLahm);
//		jugadorRepository.save(arturoVidal);
//		jugadorRepository.save(robertLewandowski);		
//		
//		//Creamos los jugadores del Borussia Dormund.
//		Jugador romanBurki = new Jugador("Roman Burki","Borussia Dormund","Portero",26,"Suiza",7500000);
//		Jugador sokratis = new Jugador("Sokratis","Borussia Dormund","Defensa",28,"Grecia",28000000);
//		Jugador julianWeigl = new Jugador("Julian Weigl","Borussia Dormund","Mediocentro",21,"Alemania",23000000);
//		Jugador aubameyang = new Jugador("Aubameyang","Borussia Dormund","Delantero",27,"Gabón",65000000);
//		
//		romanBurki.setEquipo(borussiaDormund);
//		sokratis.setEquipo(borussiaDormund);
//		julianWeigl.setEquipo(borussiaDormund);
//		aubameyang.setEquipo(borussiaDormund);
//		
//		jugadorRepository.save(romanBurki);
//		jugadorRepository.save(sokratis);
//		jugadorRepository.save(julianWeigl);
//		jugadorRepository.save(aubameyang);		
//		
//		//Creamos los jugadores del Bayer Leverkusen.
//		Jugador berndLeno = new Jugador("Bernd Leno","Bayer Leverkusen","Portero",24,"Alemania",16000000);
//		Jugador jonathanTah = new Jugador("Jonathan Tah","Bayer Leverkusen","Defensa",20,"Alemania",22000000);
//		Jugador larsBender = new Jugador("Lars Bender","Bayer Leverkusen","Mediocentro",27,"Alemania",15000000);
//		Jugador chicharito = new Jugador("Chicharito","Bayer Leverkusen","Delantero",29,"Mexico",22000000);
//		
//		berndLeno.setEquipo(bayerLeverkusen);
//		jonathanTah.setEquipo(bayerLeverkusen);
//		larsBender.setEquipo(bayerLeverkusen);
//		chicharito.setEquipo(bayerLeverkusen);
//		
//		jugadorRepository.save(berndLeno);
//		jugadorRepository.save(jonathanTah);
//		jugadorRepository.save(larsBender);
//		jugadorRepository.save(chicharito);
//		
//		//Creamos los jugadores del Shalke 04.
//		Jugador ralfFahrmann = new Jugador("Ralf Fahrmann","Shalke 04","Portero",28,"Alemania",9000000);
//		Jugador benediktHowedes = new Jugador("Benedikt Howedes","Shalke 04","Defensa",28,"Alemania",18000000);
//		Jugador leonGoretzka = new Jugador("Leon Goretzka","Shalke 04","Mediocentro",22,"Alemania",18000000);
//		Jugador breelEmbolo = new Jugador("Breel Embolo","Shalke 04","Delantero",19,"Suiza",20000000);
//		
//		ralfFahrmann.setEquipo(shalke);
//		benediktHowedes.setEquipo(shalke);
//		leonGoretzka.setEquipo(shalke);
//		breelEmbolo.setEquipo(shalke);
//		
//		jugadorRepository.save(ralfFahrmann);
//		jugadorRepository.save(benediktHowedes);
//		jugadorRepository.save(leonGoretzka);
//		jugadorRepository.save(breelEmbolo);
//		
//		//Creamos los jugadores del PSG.
//		Jugador kevinTrapp = new Jugador("Kevin Trapp","PSG","Portero",26,"Alemania",10000000);
//		Jugador marquinhos = new Jugador("Marquinhos","PSG","Defensa",22,"Portugal",32000000);
//		Jugador marcoVeratti = new Jugador("Marco Veratti","PSG","Mediocentro",24,"Italia",40000000);
//		Jugador edisonCavani = new Jugador("Edison Cavani","PSG","Delantero",29,"Uruguay",45000000);
//		
//		kevinTrapp.setEquipo(psg);
//		marquinhos.setEquipo(psg);
//		marcoVeratti.setEquipo(psg);
//		edisonCavani.setEquipo(psg);
//		
//		jugadorRepository.save(kevinTrapp);
//		jugadorRepository.save(marquinhos);
//		jugadorRepository.save(marcoVeratti);
//		jugadorRepository.save(edisonCavani);		
//		
//		//Creamos los jugadores del Mónaco.
//		Jugador danijelSubasic = new Jugador("Danijel Subasic","Monaco","Portero",32,"Croacia",5000000);
//		Jugador kamilGlik = new Jugador("Kamil Glik","Monaco","Defensa",29,"Polonia",15000000);
//		Jugador fabinho = new Jugador("Fabinho","Monaco","Mediocentro",23,"Brasil",20000000);
//		Jugador falcao = new Jugador("Falcao","Monaco","Delantero",31,"Colombia",15000000);
//		
//		danijelSubasic.setEquipo(monaco);
//		kamilGlik.setEquipo(monaco);
//		fabinho.setEquipo(monaco);
//		falcao.setEquipo(monaco);
//		
//		jugadorRepository.save(danijelSubasic);
//		jugadorRepository.save(kamilGlik);
//		jugadorRepository.save(fabinho);
//		jugadorRepository.save(falcao);		
//		
//		//Creamos los jugadores del Olympique de Lyon.
//		Jugador anthonyLopes = new Jugador("Anthony Lopes","Olymmpique de Lyon","Portero",26,"Portugal",14000000);
//		Jugador emanuelMammana = new Jugador("Emanuel Mammana","Olymmpique de Lyon","Defensa",21,"Argentina",6000000);
//		Jugador corentinTolisso = new Jugador("Corentin Tolisso","Olymmpique de Lyon","Mediocentro",22,"Francia",18000000);
//		Jugador alexandreLacazette = new Jugador("Alexandre Lacazette","Olymmpique de Lyon","Delantero",25,"Francia",40000000);
//		
//		anthonyLopes.setEquipo(olympiqueLyon);
//		emanuelMammana.setEquipo(olympiqueLyon);
//		corentinTolisso.setEquipo(olympiqueLyon);
//		alexandreLacazette.setEquipo(olympiqueLyon);
//		
//		jugadorRepository.save(anthonyLopes);
//		jugadorRepository.save(emanuelMammana);
//		jugadorRepository.save(corentinTolisso);
//		jugadorRepository.save(alexandreLacazette);	
//		
//		//Creamos los jugadores del Olympique de Marsella.
//		Jugador yohannPele = new Jugador("Yohann Pele","Olymmpique de Marsella","Portero",34,"Francia",500000);
//		Jugador karimRekik = new Jugador("Karim Rekik","Olymmpique de Lyon","Defensa",22,"Holanda",3000000);
//		Jugador morganSanson = new Jugador("Morgan Sanson","Olymmpique de Lyon","Mediocentro",22,"Francia",10000000);
//		Jugador bafetimbiGomis = new Jugador("Bafetimbi Gomis","Olymmpique de Lyon","Delantero",31,"Francia",7000000);
//		
//		yohannPele.setEquipo(olympiqueMarsella);
//		karimRekik.setEquipo(olympiqueMarsella);
//		morganSanson.setEquipo(olympiqueMarsella);
//		bafetimbiGomis.setEquipo(olympiqueMarsella);
//		
//		jugadorRepository.save(yohannPele);
//		jugadorRepository.save(karimRekik);
//		jugadorRepository.save(morganSanson);
//		jugadorRepository.save(bafetimbiGomis);
//		
//		//Creamos los jugadores del Oporto.
//		Jugador ikerCasillas = new Jugador("Iker Casillas","Oporto","Portero",35,"España",3000000);
//		Jugador ivanMarcano = new Jugador("Ivan Marcano","Oporto","Defensa",29,"España",6000000);
//		Jugador hectorHerrera = new Jugador("Hector Herrera","Oporto","Mediocentro",26,"Mexico",16000000);
//		Jugador andreSilva = new Jugador("Andre Silva","Oporto","Delantero",21,"Portugal",10000000);
//		
//		ikerCasillas.setEquipo(oporto);
//		ivanMarcano.setEquipo(oporto);
//		hectorHerrera.setEquipo(oporto);
//		andreSilva.setEquipo(oporto);
//		
//		jugadorRepository.save(ikerCasillas);
//		jugadorRepository.save(ivanMarcano);
//		jugadorRepository.save(hectorHerrera);
//		jugadorRepository.save(andreSilva);		
//		
//		//Creamos los jugadores del Benfica.
//		Jugador ederson = new Jugador("Ederson","Benfica","Portero",23,"Brasil",7000000);
//		Jugador victorLindelof = new Jugador("Victor Lindelof","Benfica","Defensa",22,"Suecia",12000000);
//		Jugador pizzi = new Jugador("Pizzi","Benfica","Mediocentro",27,"Portugal",13000000);
//		Jugador raulJimenez = new Jugador("Raul Jimenez","Benfica","Delantero",25,"Mexico",11000000);
//		
//		ederson.setEquipo(benfica);
//		victorLindelof.setEquipo(benfica);
//		pizzi.setEquipo(benfica);
//		raulJimenez.setEquipo(benfica);
//		
//		jugadorRepository.save(ederson);
//		jugadorRepository.save(victorLindelof);
//		jugadorRepository.save(pizzi);
//		jugadorRepository.save(raulJimenez);	
//		
//		//Creamos los jugadores del Sporting de Lisboa.
//		Jugador ruiPatricio = new Jugador("Rui Patricio","Sporting de Lisboa","Portero",28,"Portugal",16000000);
//		Jugador rubenSemedo = new Jugador("Ruben Semedo","Sporting de Lisboa","Defensa",22,"Portugal",7000000);
//		Jugador williamCarvalho = new Jugador("William Carvalho","Sporting de Lisboa","Mediocentro",24,"Portugal",30000000);
//		Jugador banDost = new Jugador("Ban Dost","Sporting de Lisboa","Delantero",27,"Holanda",27000000);
//		
//		ruiPatricio.setEquipo(sportingLisboa);
//		rubenSemedo.setEquipo(sportingLisboa);
//		williamCarvalho.setEquipo(sportingLisboa);
//		banDost.setEquipo(sportingLisboa);
//		
//		jugadorRepository.save(ruiPatricio);
//		jugadorRepository.save(rubenSemedo);
//		jugadorRepository.save(williamCarvalho);
//		jugadorRepository.save(banDost);		
//		
//		//Creamos los jugadores del Sporting de Braga.
//		Jugador marafona = new Jugador("Marafona","Sporting de Braga","Portero",29,"Portugal",2000000);
//		Jugador emilianoVelazquez = new Jugador("Emiliano Velazquez","Sporting de Braga","Defensa",22,"Uruguay",1500000);
//		Jugador nikolaVukcevic = new Jugador("Nikola Vukcevic","Sporting de Braga","Mediocentro",25,"Albania",3000000);
//		Jugador ahmedHassan = new Jugador("Ahmed Hassan","Sporting de Braga","Delantero",23,"Egipto",4500000);
//		
//		marafona.setEquipo(sportingBraga);
//		emilianoVelazquez.setEquipo(sportingBraga);
//		nikolaVukcevic.setEquipo(sportingBraga);
//		ahmedHassan.setEquipo(sportingBraga);
//		
//		jugadorRepository.save(marafona);
//		jugadorRepository.save(emilianoVelazquez);
//		jugadorRepository.save(nikolaVukcevic);
//		jugadorRepository.save(ahmedHassan);
//		
//		//Creamos los managers de los equipos.
//		Manager zinedineZidane = new Manager("Zinedine Zidane","Real Madrid","ZineZid","remadr","ROLE_USER");
//		zinedineZidane.setEquipo(realMadrid);
//		managerRepository.save(zinedineZidane);
//		
//		Manager luisEnrique = new Manager("Luis Enrique","Barcelona","LuEnr","fcbarc","ROLE_USER");
//		luisEnrique.setEquipo(barcelona);
//		managerRepository.save(luisEnrique);
//		
//		Manager diegoSimeone = new Manager("Diego Simeone","Atletico de Madrid","DieSim","atmad","ROLE_USER");
//		diegoSimeone.setEquipo(atleticoMadrid);
//		managerRepository.save(diegoSimeone);
//		
//		Manager jorgeSampaoli = new Manager("Jorge Sampaoli","Sevilla","JorSamp","sevfc","ROLE_USER");
//		jorgeSampaoli.setEquipo(sevilla);
//		managerRepository.save(jorgeSampaoli);
//		
//		Manager franEscriba = new Manager("Fran Escriba","Villarreal","FrEscr","villafc","ROLE_USER");
//		franEscriba.setEquipo(villarreal);
//		managerRepository.save(franEscriba);
//		
//		Manager asierGaritano = new Manager("Asier Garitano","Leganes","AsGari","cdleg","ROLE_USER");
//		asierGaritano.setEquipo(leganes);
//		managerRepository.save(asierGaritano);
//		
//		Manager antonioConte = new Manager("Antonio Conte","Chelsea","AntCon","chel","ROLE_USER");
//		antonioConte.setEquipo(chelsea);
//		managerRepository.save(antonioConte);		
//
//		Manager arseneWenger = new Manager("Arsene Wenger","Arsenal","ArWeng","arsn","ROLE_USER");
//		arseneWenger.setEquipo(arsenal);
//		managerRepository.save(arseneWenger);
//		
//		Manager jurgenKlopp = new Manager("Jurgen Klopp","Liverpool","JuKlo","livfc","ROLE_USER");
//		jurgenKlopp.setEquipo(liverpool);
//		managerRepository.save(jurgenKlopp);
//		
//		Manager joseMourinho = new Manager("Jose Mourinho","Manchester United","JoMou","manu","ROLE_USER");
//		joseMourinho.setEquipo(manchesterUnited);
//		managerRepository.save(joseMourinho);
//
//		Manager pepGuardiola = new Manager("Pep Guardiola","Manchester City","PeGuar","manc","ROLE_USER");
//		pepGuardiola.setEquipo(manchesterCity);
//		managerRepository.save(pepGuardiola);
//		
//		Manager mauricioPochettino = new Manager("Mauricio Pochettino","Tottenham","MauPoch","totten","ROLE_USER");
//		mauricioPochettino.setEquipo(tottenham);
//		managerRepository.save(mauricioPochettino);
//		
//		Manager massimilianoAllegri = new Manager("Massimiliano Allegri","Juventus","MasAlle","juvfc","ROLE_USER");
//		massimilianoAllegri.setEquipo(juventus);
//		managerRepository.save(massimilianoAllegri);		
//		
//		Manager vicenzoMontella = new Manager("Vicenzo Montella","Milan","VicMon","acmil","ROLE_USER");
//		vicenzoMontella.setEquipo(milan);
//		managerRepository.save(vicenzoMontella);
//		
//		Manager stefanoPioli = new Manager("Stefano Pioli","Inter de Milan","StePio","intmil","ROLE_USER");
//		stefanoPioli.setEquipo(interMilan);
//		managerRepository.save(stefanoPioli);
//		
//		Manager lucianoSpalletti = new Manager("Luciano Spalletti","Roma","LucSpa","asrom","ROLE_USER");
//		lucianoSpalletti.setEquipo(roma);
//		managerRepository.save(lucianoSpalletti);
//		
//		Manager maurizioSarri = new Manager("Maurizio Sarri","Napoles","MauSar","sscnap","ROLE_USER");
//		maurizioSarri.setEquipo(napoles);
//		managerRepository.save(maurizioSarri);
//		
//		Manager carloAncelotti = new Manager("Carlo Ancelotti","Bayern Munich","CarAnc","fcbaym","ROLE_USER");
//		carloAncelotti.setEquipo(bayernMunich);
//		managerRepository.save(carloAncelotti);
//		
//		Manager thomasTuchel = new Manager("Thomas Tuchel","Borussia Dormund","TomTuc","bordor","ROLE_USER");
//		thomasTuchel.setEquipo(borussiaDormund);
//		managerRepository.save(thomasTuchel);
//		
//		Manager rogerSchmidt = new Manager("Roger Schmidt","Bayer Leverkusen","RogSch","baylev","ROLE_USER");
//		rogerSchmidt.setEquipo(bayerLeverkusen);
//		managerRepository.save(rogerSchmidt);
//		
//		Manager markusWeinzierl = new Manager("Markus Weinzierl","Shalke 04","MarWein","fcshal","ROLE_USER");
//		markusWeinzierl.setEquipo(shalke);
//		managerRepository.save(markusWeinzierl);
//		
//		Manager unaiEmery = new Manager("Unai Emery","PSG","UnEme","fcpsg","ROLE_USER");
//		unaiEmery.setEquipo(psg);
//		managerRepository.save(unaiEmery);
//		
//		Manager leonardoJardim = new Manager("Leonardo Jardim","Monaco","LeoJar","asmon","ROLE_USER");
//		leonardoJardim.setEquipo(monaco);
//		managerRepository.save(leonardoJardim);
//		
//		Manager brunoGenesio = new Manager("Bruno Genesio","Olympique de Lyon","BruGen","olylyo","ROLE_USER");
//		brunoGenesio.setEquipo(olympiqueLyon);
//		managerRepository.save(brunoGenesio);
//		
//		Manager rudiGarcia = new Manager("Rudi Garcia","Olympique de Marsella","RudGar","olymar","ROLE_USER");
//		rudiGarcia.setEquipo(olympiqueMarsella);
//		managerRepository.save(rudiGarcia);
//		
//		Manager nunoEspiritoSanto = new Manager("Nuno Espirito Santo","Oporto","NunEspS","fcopo","ROLE_USER");
//		nunoEspiritoSanto.setEquipo(oporto);
//		managerRepository.save(nunoEspiritoSanto);
//		
//		Manager ruiVitoria = new Manager("Rui Vitoria","Benfica","RuVit","slbenf","ROLE_USER");
//		ruiVitoria.setEquipo(benfica);
//		managerRepository.save(ruiVitoria);
//		
//		Manager jorgeJesus = new Manager("Jorge Jesus","Sporting Lisboa","JorJes","splisb","ROLE_USER");
//		jorgeJesus.setEquipo(sportingLisboa);
//		managerRepository.save(jorgeJesus);
//		
//		Manager jorgeSimao = new Manager("Jorge Simao","Sporting Braga","JorSim","scbra","ROLE_USER");
//		jorgeSimao.setEquipo(sportingBraga);
//		managerRepository.save(jorgeSimao);	
	}
	
	//Indicamos la página principal de nuestra aplicación Web (FutWorld).
	@RequestMapping("/")
	public String principal (){
		return "index";
	}
	
	//Parte pública de nuestra aplicación Web donde se van a realizar las consultas.
	@RequestMapping("/realizarconsultas")
	public String realizarConsultas (){
		return "realizarconsultas";
	}
	
	//Parte privada de nuestra aplicación Web donde el usuario podrá loguearse y registrarse.
	@RequestMapping("/areaprivada")
	public String areaPrivada (){
		return "areaprivada";
	}
	
	//Acceso a formulario de registro.
	@RequestMapping("/registrousuario")
	public String registroUsuario (){
		return "registrousuario";
	}
	
	//Login Manager.
	@PostMapping("/login")
	public String loginManager(Model model, @RequestParam String user, @RequestParam String password, HttpSession sesion, HttpServletRequest request){
		//Comprobamos si existe o no un Manager registrado con ese "user" y "password".
		Manager manager = managerRepository.findByUserAndPassword(user,password);	
		
		//Si existe devuelve la información.		
		if (manager!=null){	
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String usuario = authentication.getName();
			sesion = request.getSession();
			sesion.setAttribute("user", usuario);
			model.addAttribute("userCompartida", userCompartida);	
			return "areagestionmanager";
		}else{
			//Si no existe notifica el error al usuario.
			return "areaprivada";
		}
	}
	
	//Área de gestión del mánager donde podra gestionar su equipo y consultar su información.
	@RequestMapping("/areagestionmanager")
	public String areaGestionManager (Model model, HttpSession sesion,HttpServletRequest request){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		sesion = request.getSession();
		sesion.setAttribute("user", user);
		model.addAttribute("userCompartida", userCompartida);
		
		return "areagestionmanager";
	}
	
	//Buscar Jugador.
	@GetMapping("/consultarjugador/nombreJugador")
	public String verJugador(Model model, @RequestParam String nombreJugador){
		
		//Comprobamos si existe o no un Jugador registrado con ese "nombreJugador".
		Jugador jugador = jugadorRepository.findByNombreJugador(nombreJugador);

		//Si existe, mostramos la información.
		if (jugador!=null){	
			
			model.addAttribute("jugador", jugador);
			
			return "consultajugador";
		}else{
			//Si no existe notifica el error al usuario.
			return "errorjugadornoexiste";
		}		
	}
	
	//Buscar Plantilla Equipo.
	@GetMapping("/consultarequipo/nombreEquipo")
	public String verEquipo (Model model, @RequestParam String nombreEquipo){
		
		//Comprobamos si existe o no un Equipo registrado con ese "nombreEquipo".
		Equipo existe = equipoRepository.findByNombreEquipo(nombreEquipo);		

		//Si existe, mostramos la información.
		if (existe!=null){
			List<Jugador> jugador = jugadorRepository.findDistinctJugadoresByEquipoJugadorOrderByValorMercadoDesc(nombreEquipo);
			
			model.addAttribute("jugador", jugador);		
			
			return "consultaequipo";
		}else{
			//Si no existe notifica el error al usuario.
			return "errorequiponoexiste";
		}			
	}
	
	//Buscar Edad Jugadores.
	@GetMapping("/consultaredadjugadores/edad")
	public String verEdadJugadores (Model model, @RequestParam int edad){
		
		//Comprobamos si existe o no un Jugador registrado con ese "edad".
		List<Jugador> existe = jugadorRepository.findByEdad(edad);

		//Si existe, mostramos la información.
		if (existe.isEmpty()){		
			
			return "errornoexistejugadoredad";
		}else{
			//Si no existe notifica el error al usuario.
			List<Jugador> jugador = jugadorRepository.findDistinctJugadoresByEdadOrderByValorMercadoDesc(edad);
			
			model.addAttribute("jugador", jugador);		
			
			return "consultaedadjugadores";
		}		
	}	

	//Buscar Nacionalidad Jugadores.
	@GetMapping("/consultarpaisjugadores/nacionalidadJugador")
	public String verNacionalidadJugadores (Model model, @RequestParam String nacionalidadJugador){
		
		//Comprobamos si existe o no un Jugador registrado con ese "nacionalidad".
		List<Jugador> existe = jugadorRepository.findByNacionalidadJugador(nacionalidadJugador);

		//Si existe, mostramos la información.
		if (existe.isEmpty()){	
			
			return "errornoexistejugadornacionalidad";
		}else{
			//Si no existe notifica el error al usuario.
			List<Jugador> jugador = jugadorRepository.findDistinctJugadoresByNacionalidadJugadorOrderByValorMercadoDesc(nacionalidadJugador);
			
			model.addAttribute("jugador", jugador);		
			
			return "consultanacionalidadjugadores";
		}	
	}
	
	//Palmarés.
	@GetMapping("/consultarpalmares/nombreLiga")
	public String verPalmares (Model model, @RequestParam String nombreLiga){
		
		//Comprobamos si existe o no un Jugador registrado con ese "nacionalidad".
		Torneo existe = torneoRepository.findByNombreLiga(nombreLiga);

		//Si existe, mostramos la información.
		if (existe!=null){
			List<Equipo> equipo = equipoRepository.findDistinctEquiposByLigaOrderByNumTorneoGanadosDesc(nombreLiga);
			
			model.addAttribute("equipo", equipo);		
			
			return "consultapalmares";
		}else{
			//Si no existe notifica el error al usuario.
			return "errortorneonoexiste";
		}	
	}	
	
	//Buscar Torneo.
	@GetMapping("/consultartorneo/nombreLiga")
	public String verTorneo (Model model, @RequestParam String nombreLiga){
		
		//Comprobamos si existe o no un Jugador registrado con ese "nacionalidad".
		Torneo existe = torneoRepository.findByNombreLiga(nombreLiga);

		//Si existe, mostramos la información.
		if (existe!=null){
			List<Equipo> equipo = equipoRepository.findDistinctEquiposByLigaOrderByNombreEquipoAsc(nombreLiga);
			
			model.addAttribute("equipo", equipo);		
			
			return "consultatorneo";
		}else{
			//Si no existe notifica el error al usuario.
			return "errortorneonoexiste";
		}	
	}
	
	//Registrar Mánager.
	@PostMapping("/manager/nuevo")
	public String registroManager (@RequestParam String nombreManager, @RequestParam String equipoManager, @RequestParam String user, @RequestParam String password){
		//Comprobamos si existe o no un Manager registrado prevamente con ese "user" y "password".
		Manager existe = managerRepository.findByUserAndPassword(user,password);
		
		//Si no existe lo crea (registra).
		if (existe==null){
			String rol = "ROLE_USER";
			Manager manager = new Manager(nombreManager,equipoManager,user,password,rol);
			managerRepository.save(manager);
			return "managerregistrado";
		}else{
			//Si existe notifica el error al usuario y no lo registra.
			return "errorregistro";
		}
	}

	//Información Manager.
	@GetMapping("/informacionmanager/user/password")
	public String verManager(Model model, HttpSession sesion,HttpServletRequest request){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		sesion = request.getSession();
		sesion.setAttribute("user", user);
		model.addAttribute("userCompartida", userCompartida);
		
		//Cargamos los datos de la sesión del mánager.
//		String user = (String) sesion.getAttribute("user");
//		String password = (String) sesion.getAttribute("password");

//		model.addAttribute("user", user);
//		model.addAttribute("password", user);
//		
//		model.addAttribute("userCompartida", userCompartida);
//		model.addAttribute("passwordCompartida", passwordCompartida);
//		
		Manager manager = managerRepository.findByUser(user);
			
		model.addAttribute("manager", manager);
			
		return "consultardatosmanager";
	}
	
	//Inscribir Equipo.
	@GetMapping("/registrarequipo/user/password")
	public String registrarEquipoManager(Model model, HttpSession sesion, HttpServletRequest request){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		sesion = request.getSession();
		sesion.setAttribute("user", user);
		model.addAttribute("userCompartida", userCompartida);
		
		//Cargamos los datos de la sesión del Mánager.
//		String user = (String) sesion.getAttribute("user");
//		String password = (String) sesion.getAttribute("password");
//
//		model.addAttribute("user", user);
//		model.addAttribute("password", user);
//		
//		model.addAttribute("userCompartida", userCompartida);
//		model.addAttribute("passwordCompartida", passwordCompartida);
		
		Manager manager = managerRepository.findByUser(user);
			
		model.addAttribute("manager", manager);
			
		return "registrarequipo";
	}
	
	//Registrar Equipo.
	@PostMapping("/equipo/nuevo")
	public String registroEquipo (@RequestParam String nombreEquipo, @RequestParam String liga, @RequestParam String nacionalidadEquipo, @RequestParam int numTorneoGanados, HttpSession sesion){

		//Comprobamos si existe o no un Equipo registrado con ese "nombreEquipo".
		Equipo existe = equipoRepository.findByNombreEquipo(nombreEquipo);		

		//Si no existe, continuamos con el registro del equipo.
		if (existe==null){
			Equipo equipo = new Equipo(nombreEquipo,liga,nacionalidadEquipo,numTorneoGanados);
			equipoRepository.save(equipo);
			
			File dirEquipo = null;
			try{
			dirEquipo = new File("fichas/"+nombreEquipo);
			if (!dirEquipo.exists()) {
				dirEquipo.mkdir();
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				
			}
			
			return "equiporegistrado";
		}else{
			//Si existe notifica el error al usuario y no lo registra.
			return "errorregistroequipo";
		}
	}
	
	//Inscribir Jugador.
	@GetMapping("/registrarjugador/user/password")
	public String registrarJugadorManager(Model model,HttpServletRequest request  ,HttpSession sesion){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		sesion = request.getSession();
		sesion.setAttribute("user", user);
		model.addAttribute("userCompartida", userCompartida);
		
		//Cargamos los datos de la sesión del Mánager.
//		String user = (String) sesion.getAttribute("user");
//		String password = (String) sesion.getAttribute("password");
//
//		model.addAttribute("user", user);
//		model.addAttribute("password", user);
//		
//		model.addAttribute("userCompartida", userCompartida);
//		model.addAttribute("passwordCompartida", passwordCompartida);
		
		Manager manager = managerRepository.findByUser(user);
			
		model.addAttribute("manager", manager);
			
		return "registrarjugador";
	}
	
	//Registrar Jugador.
	@PostMapping("/jugador/nuevo")
	public String registroJugador (@RequestParam String nombreJugador, @RequestParam String equipoJugador, @RequestParam String posicion, @RequestParam int edad, @RequestParam String nacionalidadJugador, @RequestParam int valorMercado, HttpSession sesion){
		
		//Comprobamos si existe o no un Jugador registrado con ese "nombreJugador".
		Jugador existe = jugadorRepository.findByNombreJugador(nombreJugador);

		//Si no existe, continuamos con el registro del equipo.
		if (existe==null){
			Jugador jugador = new Jugador (nombreJugador,equipoJugador,posicion,edad,nacionalidadJugador,valorMercado);
			jugadorRepository.save(jugador);
			
			ClienteSocket socket = new ClienteSocket();
			socket.enviarInfoJugador(nombreJugador,equipoJugador,posicion,edad,nacionalidadJugador,valorMercado);
			socket.recibirInfoJugador(nombreJugador,equipoJugador);
			
			return "jugadorregistrado";
		}else{
			//Si existe notifica el error al usuario y no lo registra.
			return "errorregistrojugador";
		}
	}	
}
