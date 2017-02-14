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
	
	@Autowired
	private JugadorResository jugadorRepository;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	private List<Equipo> equipos = new ArrayList<>();
	private List<Jugador> jugadores = new ArrayList<>();
	
	@PostConstruct 
	//Indicamos los torneos, equipos y jugadores añadidos por defecto al ejecutarse el programa.
	public void predeterminado(){
		//Creamos los Torneos.
		Torneo ligaEspañola = new Torneo("Liga Española",20);
		Torneo premierLeague = new Torneo("Premier League",20);
		Torneo serieA = new Torneo("Serie A",20);
		Torneo bundesliga = new Torneo("Bundesliga",20);
		Torneo ligueOne = new Torneo("Ligue 1",20);
		Torneo ligaNos = new Torneo("Liga NOS",20);
		
		torneoRepository.save(ligaEspañola);
		torneoRepository.save(premierLeague);
		torneoRepository.save(serieA);
		torneoRepository.save(bundesliga);
		torneoRepository.save(ligueOne);
		torneoRepository.save(ligaNos);
		
		//Creamos los Equipos de la Liga Española.
		Equipo realMadrid = new Equipo("Real Madrid","España",32);
		Equipo barcelona = new Equipo("Barcelona","España",24);
		Equipo atleticoMadrid = new Equipo("Atletico de Madrid","España",10);
		Equipo sevilla = new Equipo("Sevilla","España",1);
		Equipo villarreal = new Equipo("Villarreal","España",0);
		Equipo leganes = new Equipo("Leganes","España",0);
		
		realMadrid.setTorneo(ligaEspañola);
		barcelona.setTorneo(ligaEspañola);
		atleticoMadrid.setTorneo(ligaEspañola);
		sevilla.setTorneo(ligaEspañola);
		villarreal.setTorneo(ligaEspañola);
		leganes.setTorneo(ligaEspañola);
		
		equipoRepository.save(realMadrid);
		equipoRepository.save(barcelona);
		equipoRepository.save(atleticoMadrid);
		equipoRepository.save(sevilla);
		equipoRepository.save(villarreal);
		equipoRepository.save(leganes);
		
		//Creamos los Equipos de la Premier League.
		Equipo chelsea = new Equipo("Chelsea","Inglaterra",4);
		Equipo arsenal = new Equipo("Arsenal","Inglaterra",3);
		Equipo liverpool = new Equipo("Liverpool","Inglaterra",0);
		Equipo manchesterUnited = new Equipo("Manchester United","Inglaterra",13);
		Equipo manchesterCity = new Equipo("Manchester City","Inglaterra",2);
		Equipo tottenham = new Equipo("Tottenham","Inglaterra",0);
		
		chelsea.setTorneo(premierLeague);
		arsenal.setTorneo(premierLeague);
		liverpool.setTorneo(premierLeague);
		manchesterUnited.setTorneo(premierLeague);
		manchesterCity.setTorneo(premierLeague);
		tottenham.setTorneo(premierLeague);
		
		equipoRepository.save(chelsea);
		equipoRepository.save(arsenal);
		equipoRepository.save(liverpool);
		equipoRepository.save(manchesterUnited);
		equipoRepository.save(manchesterCity);
		equipoRepository.save(tottenham);
		
		//Creamos los Equipos de la Serie A.
		Equipo juventus = new Equipo("Juventus","Italia",32);
		Equipo milan = new Equipo("Milan","Italia",18);
		Equipo interMilan = new Equipo("Inter de Milan","Italia",18);
		Equipo roma = new Equipo("Roma","Italia",3);
		Equipo napoles = new Equipo("Napoles","Italia",2);
		
		juventus.setTorneo(serieA);
		milan.setTorneo(serieA);
		interMilan.setTorneo(serieA);
		roma.setTorneo(serieA);
		napoles.setTorneo(serieA);
		
		equipoRepository.save(juventus);
		equipoRepository.save(milan);
		equipoRepository.save(interMilan);
		equipoRepository.save(roma);
		equipoRepository.save(napoles);
		
		//Creamos los Equipos de la Bundesliga.
		Equipo bayernMunich = new Equipo("Bayern Munich","Alemania",25);
		Equipo borussiaDormund = new Equipo("Borussia Dormund","Alemania",5);
		Equipo bayerLeverkusen = new Equipo("Bayer Leverkusen","Alemania",0);
		Equipo shalke = new Equipo("Shalke 04","Alemania",0);
		
		bayernMunich.setTorneo(bundesliga);
		borussiaDormund.setTorneo(bundesliga);
		bayerLeverkusen.setTorneo(bundesliga);
		shalke.setTorneo(bundesliga);
		
		equipoRepository.save(bayernMunich);
		equipoRepository.save(borussiaDormund);
		equipoRepository.save(bayerLeverkusen);
		equipoRepository.save(shalke);
		
		//Creamos los Equipos de la Ligue 1.
		Equipo psg = new Equipo("PSG","Francia",6);
		Equipo monaco = new Equipo("Monaco","Francia",7);
		Equipo olympiqueLyon = new Equipo("Olympique de Lyon","Francia",7);
		Equipo olympiqueMarsella = new Equipo("Olympique de Marsella","Francia",9);
		
		psg.setTorneo(ligueOne);
		monaco.setTorneo(ligueOne);
		olympiqueLyon.setTorneo(ligueOne);
		olympiqueMarsella.setTorneo(ligueOne);
		
		equipoRepository.save(psg);
		equipoRepository.save(monaco);
		equipoRepository.save(olympiqueLyon);
		equipoRepository.save(olympiqueMarsella);
		
		//Creamos los Equipos de la Liga NOS.
		Equipo oporto = new Equipo("Oporto","Portugal",27);
		Equipo benfica = new Equipo("Benfica","Portugal",35);
		Equipo sportingLisboa = new Equipo("Sporting de Lisboa","Portugal",18);
		Equipo sportingBraga = new Equipo("Sporting de Braga","Portugal",0);
		
		oporto.setTorneo(ligaNos);
		benfica.setTorneo(ligaNos);
		sportingLisboa.setTorneo(ligaNos);
		sportingBraga.setTorneo(ligaNos);
		
		equipoRepository.save(oporto);
		equipoRepository.save(benfica);
		equipoRepository.save(sportingLisboa);
		equipoRepository.save(sportingBraga);
		
		//Creamos los jugadores del Real Madrid.
		Jugador keylorNavas = new Jugador("Keylor Navas","Portero",30,"Costa Rica",20000000);
		Jugador sergioRamos = new Jugador("Serio Ramos","Defensa",30,"España",40000000);
		Jugador lukaModric = new Jugador("Luka Modric","Mediocentro",31,"Croacia",45000000);
		Jugador cristianoRonaldo = new Jugador("Cristiano Ronaldo","Delantero",32,"Portugal",100000000);
		
		keylorNavas.setEquipo(realMadrid);
		sergioRamos.setEquipo(realMadrid);
		lukaModric.setEquipo(realMadrid);
		cristianoRonaldo.setEquipo(realMadrid);
		
		jugadorRepository.save(keylorNavas);
		jugadorRepository.save(sergioRamos);
		jugadorRepository.save(lukaModric);
		jugadorRepository.save(cristianoRonaldo);
		
		//Creamos los jugadores del Barcelona.
		Jugador terStegen = new Jugador("Ter Stegen","Portero",24,"Alemania",22000000);
		Jugador gerardPique = new Jugador("Gerard Pique","Defensa",30,"España",40000000);
		Jugador andresIniesta = new Jugador("Andres Iniesta","Mediocentro",32,"España",30000000);
		Jugador lionelMessi = new Jugador("Lionel Messi","Delantero",29,"Argentina",120000000);
		
		terStegen.setEquipo(barcelona);
		gerardPique.setEquipo(barcelona);
		andresIniesta.setEquipo(barcelona);
		lionelMessi.setEquipo(barcelona);
		
		jugadorRepository.save(terStegen);
		jugadorRepository.save(gerardPique);
		jugadorRepository.save(andresIniesta);
		jugadorRepository.save(lionelMessi);
		
		//Creamos los jugadores del Atletico de Madrid.
		Jugador janOblak = new Jugador("Jan Oblak","Portero",24,"Eslovenia",35000000);
		Jugador diegoGodin = new Jugador("Diego Godin","Defensa",30,"Uruguay",40000000);
		Jugador koke = new Jugador("Koke","Mediocentro",25,"España",55000000);
		Jugador antoineGriezmann = new Jugador("Antoine Griezmann","Delantero",25,"Francia",80000000);
		
		janOblak.setEquipo(atleticoMadrid);
		diegoGodin.setEquipo(atleticoMadrid);
		koke.setEquipo(atleticoMadrid);
		antoineGriezmann.setEquipo(atleticoMadrid);
		
		jugadorRepository.save(janOblak);
		jugadorRepository.save(diegoGodin);
		jugadorRepository.save(koke);
		jugadorRepository.save(antoineGriezmann);		
		
		//Creamos los jugadores del Sevilla.
		Jugador sergioRico = new Jugador("Sergio Rico","Portero",23,"Eslovenia",20000000);
		Jugador adilRami = new Jugador("Adil Rami","Defensa",31,"Francia",7000000);
		Jugador vicenteIborra = new Jugador("Vicente Iborra","Mediocentro",29,"España",9000000);
		Jugador vitolo = new Jugador("Vitolo","Delantero",27,"España",20000000);
		
		sergioRico.setEquipo(sevilla);
		adilRami.setEquipo(sevilla);
		vicenteIborra.setEquipo(sevilla);
		vitolo.setEquipo(sevilla);
		
		jugadorRepository.save(sergioRico);
		jugadorRepository.save(adilRami);
		jugadorRepository.save(vicenteIborra);
		jugadorRepository.save(vitolo);		
		
		//Creamos los jugadores del Villarreal.
		Jugador sergioAsenjo = new Jugador("Sergio Asenjo","Portero",27,"España",7500000);
		Jugador mateoMusacchio = new Jugador("Mateo Musacchio","Defensa",26,"Argentina",15000000);
		Jugador brunoSoriano = new Jugador("Bruno Soriano","Mediocentro",32,"España",8000000);
		Jugador robertoSoldado = new Jugador("Roberto Soldado","Delantero",31,"España",14000000);
		
		sergioAsenjo.setEquipo(villarreal);
		mateoMusacchio.setEquipo(villarreal);
		brunoSoriano.setEquipo(villarreal);
		robertoSoldado.setEquipo(villarreal);
		
		jugadorRepository.save(sergioAsenjo);
		jugadorRepository.save(mateoMusacchio);
		jugadorRepository.save(brunoSoriano);
		jugadorRepository.save(robertoSoldado);	
		
		//Creamos los jugadores del Leganés.
		Jugador iagoHerrerin = new Jugador("Iago Herrerín","Portero",29,"España",2500000);
		Jugador martinMantovani = new Jugador("Martin Mantovani","Defensa",32,"Argentina",800000);
		Jugador gabrielPires = new Jugador("Gabriel Pires","Mediocentro",23,"España",2500000);
		Jugador albertoBueno = new Jugador("Alberto Bueno","Delantero",28,"España",3000000);
		
		iagoHerrerin.setEquipo(leganes);
		martinMantovani.setEquipo(leganes);
		gabrielPires.setEquipo(leganes);
		albertoBueno.setEquipo(leganes);
		
		jugadorRepository.save(iagoHerrerin);
		jugadorRepository.save(martinMantovani);
		jugadorRepository.save(gabrielPires);
		jugadorRepository.save(albertoBueno);
		
		//Creamos los jugadores del Chelsea.
		Jugador thibautCourtois = new Jugador("Thibaut Courtois","Portero",24,"Belgica",35000000);
		Jugador davidLuiz = new Jugador("David Luiz","Defensa",29,"Brasil",30000000);
		Jugador cescFabregas = new Jugador("Cesc Fabregas","Mediocentro",29,"España",45000000);
		Jugador diegoCosta = new Jugador("Diego Costa","Delantero",28,"España",45000000);
		
		thibautCourtois.setEquipo(chelsea);
		davidLuiz.setEquipo(chelsea);
		cescFabregas.setEquipo(chelsea);
		diegoCosta.setEquipo(chelsea);
		
		jugadorRepository.save(thibautCourtois);
		jugadorRepository.save(davidLuiz);
		jugadorRepository.save(cescFabregas);
		jugadorRepository.save(diegoCosta);		
		
		//Creamos los jugadores del Arsenal.
		Jugador petrCech = new Jugador("Petr Cech","Portero",34,"Republica Checa",12000000);
		Jugador kieranGibbs = new Jugador("Kieran Gibbs","Defensa",27,"Inglaterra",13000000);
		Jugador aaronRamsey = new Jugador("Aaron Ramsey","Mediocentro",26,"Gales",35000000);
		Jugador olivierGiroud = new Jugador("Olivier Giroud","Delantero",30,"Francia",25000000);
		
		petrCech.setEquipo(arsenal);
		kieranGibbs.setEquipo(arsenal);
		aaronRamsey.setEquipo(arsenal);
		olivierGiroud.setEquipo(arsenal);
		
		jugadorRepository.save(petrCech);
		jugadorRepository.save(kieranGibbs);
		jugadorRepository.save(aaronRamsey);
		jugadorRepository.save(olivierGiroud);	
		
		//Creamos los jugadores del Liverpool.
		Jugador simonMignolet = new Jugador("Simon Mignolet","Portero",28,"Belgica",12000000);
		Jugador joelMatip = new Jugador("Joel Matip","Defensa",25,"Alemania",18000000);
		Jugador philippeCoutinho = new Jugador("Philippe Coutinho","Mediocentro",24,"Brasil",35000000);
		Jugador danielSturridge = new Jugador("Daniel Sturridge","Delantero",27,"Inglaterra",25000000);
		
		simonMignolet.setEquipo(liverpool);
		joelMatip.setEquipo(liverpool);
		philippeCoutinho.setEquipo(liverpool);
		danielSturridge.setEquipo(liverpool);
		
		jugadorRepository.save(simonMignolet);
		jugadorRepository.save(joelMatip);
		jugadorRepository.save(philippeCoutinho);
		jugadorRepository.save(danielSturridge);		
		
		//Creamos los jugadores del Manchester United.
		Jugador davidDeGea = new Jugador("David De Gea","Portero",26,"España",40000000);
		Jugador ericBailly = new Jugador("Eric Bailly","Defensa",22,"Costa de Marfil",25000000);
		Jugador paulPogba = new Jugador("Paul Pogba","Mediocentro",23,"Francia",80000000);
		Jugador zlatanIbrahimovic = new Jugador("Zlatan Ibrahimovic","Delantero",35,"Suecia",12000000);
		
		davidDeGea.setEquipo(manchesterUnited);
		ericBailly.setEquipo(manchesterUnited);
		paulPogba.setEquipo(manchesterUnited);
		zlatanIbrahimovic.setEquipo(manchesterUnited);
		
		jugadorRepository.save(davidDeGea);
		jugadorRepository.save(ericBailly);
		jugadorRepository.save(paulPogba);
		jugadorRepository.save(zlatanIbrahimovic);		
		
		//Creamos los jugadores del Manchester City.
		Jugador claudioBravo = new Jugador("Claudio Bravo","Portero",33,"Chile",15000000);
		Jugador johnStones = new Jugador("John Stones","Defensa",22,"Inglaterra",35000000);
		Jugador yayaToure = new Jugador("Yaya Toure","Mediocentro",33,"Costa de Marfil",12000000);
		Jugador sergioAguero = new Jugador("Sergio Aguero","Delantero",28,"Argentina",60000000);
		
		claudioBravo.setEquipo(manchesterCity);
		johnStones.setEquipo(manchesterCity);
		yayaToure.setEquipo(manchesterCity);
		sergioAguero.setEquipo(manchesterCity);
		
		jugadorRepository.save(claudioBravo);
		jugadorRepository.save(johnStones);
		jugadorRepository.save(yayaToure);
		jugadorRepository.save(sergioAguero);		
		
		//Creamos los jugadores del Tottenham.
		Jugador hugoLloris = new Jugador("Hugo Lloris","Portero",30,"Francia",24000000);
		Jugador tobyAlderweireld = new Jugador("Toby Alderweireld","Defensa",27,"Belgica",27000000);
		Jugador ericDier = new Jugador("Eric Dier","Mediocentro",23,"Inglaterra",18000000);
		Jugador harryKane = new Jugador("Harry Kane","Delantero",23,"Inglaterra",40000000);
		
		hugoLloris.setEquipo(tottenham);
		tobyAlderweireld.setEquipo(tottenham);
		ericDier.setEquipo(tottenham);
		harryKane.setEquipo(tottenham);
		
		jugadorRepository.save(hugoLloris);
		jugadorRepository.save(tobyAlderweireld);
		jugadorRepository.save(ericDier);
		jugadorRepository.save(harryKane);
		
		//Creamos los jugadores del Juventus.
		Jugador gianluigiBuffon = new Jugador("Gianluigi Buffon","Portero",39,"Italia",2000000);
		Jugador leonardoBonucci = new Jugador("Leonardo Bonucci","Defensa",29,"Italia",40000000);
		Jugador tomasRincon = new Jugador("Tomas Rincon","Mediocentro",29,"Venezuela",9000000);
		Jugador gonzaloHiguain = new Jugador("Gonzalo Higuain","Delantero",29,"Argentina",75000000);
		
		gianluigiBuffon.setEquipo(juventus);
		leonardoBonucci.setEquipo(juventus);
		tomasRincon.setEquipo(juventus);
		gonzaloHiguain.setEquipo(juventus);
		
		jugadorRepository.save(gianluigiBuffon);
		jugadorRepository.save(leonardoBonucci);
		jugadorRepository.save(tomasRincon);
		jugadorRepository.save(gonzaloHiguain);		
		
		//Creamos los jugadores del Milán.
		Jugador gianluigiDonnarumma = new Jugador("Gianluigi Donnarumma","Portero",17,"Italia",20000000);
		Jugador alessioRomagnoli = new Jugador("Alessio Romagnoli","Defensa",22,"Italia",25000000);
		Jugador giacomoBonaventura = new Jugador("Giacomo Bonaventura","Mediocentro",27,"Italia",24000000);
		Jugador carlosBacca = new Jugador("Carlos Bacca","Delantero",30,"Venezuela",23000000);
		
		gianluigiDonnarumma.setEquipo(milan);
		alessioRomagnoli.setEquipo(milan);
		giacomoBonaventura.setEquipo(milan);
		carlosBacca.setEquipo(milan);
		
		jugadorRepository.save(gianluigiDonnarumma);
		jugadorRepository.save(alessioRomagnoli);
		jugadorRepository.save(giacomoBonaventura);
		jugadorRepository.save(carlosBacca);	
		
		//Creamos los jugadores del Inter de Milán.
		Jugador samirHandanovic = new Jugador("Samir Handanovic","Portero",32,"Eslovenia",12500000);
		Jugador jeisonMurillo = new Jugador("Jeison Murillo","Defensa",24,"Venezuela",14000000);
		Jugador marceloBrozovic = new Jugador("Marcelo Brozovic","Mediocentro",24,"Croacia",22000000);
		Jugador mauroIcardi = new Jugador("Mauro Icardi","Delantero",23,"Argentina",45000000);
		
		samirHandanovic.setEquipo(interMilan);
		jeisonMurillo.setEquipo(interMilan);
		marceloBrozovic.setEquipo(interMilan);
		mauroIcardi.setEquipo(interMilan);
		
		jugadorRepository.save(samirHandanovic);
		jugadorRepository.save(jeisonMurillo);
		jugadorRepository.save(marceloBrozovic);
		jugadorRepository.save(mauroIcardi);		
		
		//Creamos los jugadores del Roma.
		Jugador wojciechSzczesny = new Jugador("Wojciech Szczesny","Portero",26,"Polonia",14000000);
		Jugador konstantinosManolas = new Jugador("Konstantinos Manolas","Defensa",25,"Grecia",28000000);
		Jugador radjaNainggolan = new Jugador("Radja Nainggolan","Mediocentro",28,"Belgica",35000000);
		Jugador edinDzeko = new Jugador("Edin Dzeko","Delantero",30,"Bosnia",15000000);
		
		wojciechSzczesny.setEquipo(roma);
		konstantinosManolas.setEquipo(roma);
		radjaNainggolan.setEquipo(roma);
		edinDzeko.setEquipo(roma);
		
		jugadorRepository.save(wojciechSzczesny);
		jugadorRepository.save(konstantinosManolas);
		jugadorRepository.save(radjaNainggolan);
		jugadorRepository.save(edinDzeko);		
		
		//Creamos los jugadores del Nápoles.
		Jugador pepeReina = new Jugador("Pepe Reina","Portero",34,"España",3000000);
		Jugador kalidouKoulibaly = new Jugador("Kalidou Koulibaly","Defensa",25,"Francia",30000000);
		Jugador marekHamsik = new Jugador("Marek Hamsik","Mediocentro",29,"Eslovaquia",40000000);
		Jugador arkadiuszMilik = new Jugador("Arkadiusz Milik","Delantero",22,"Polonia",20000000);
		
		pepeReina.setEquipo(napoles);
		kalidouKoulibaly.setEquipo(napoles);
		marekHamsik.setEquipo(napoles);
		arkadiuszMilik.setEquipo(napoles);
		
		jugadorRepository.save(pepeReina);
		jugadorRepository.save(kalidouKoulibaly);
		jugadorRepository.save(marekHamsik);
		jugadorRepository.save(arkadiuszMilik);
		
		//Creamos los jugadores del Bayern Munich.
		Jugador manuelNeuer = new Jugador("Manuel Neuer","Portero",30,"Alemania",45000000);
		Jugador philippLahm = new Jugador("Philipp Lahm","Defensa",33,"Alemania",11000000);
		Jugador arturoVidal = new Jugador("Arturo Vidal","Mediocentro",29,"Chile",37000000);
		Jugador robertLewandowski = new Jugador("Robert Lewandowski","Delantero",28,"Polonia",80000000);
		
		manuelNeuer.setEquipo(bayernMunich);
		philippLahm.setEquipo(bayernMunich);
		arturoVidal.setEquipo(bayernMunich);
		robertLewandowski.setEquipo(bayernMunich);
		
		jugadorRepository.save(manuelNeuer);
		jugadorRepository.save(philippLahm);
		jugadorRepository.save(arturoVidal);
		jugadorRepository.save(robertLewandowski);		
		
		//Creamos los jugadores del Borussia Dormund.
		Jugador romanBurki = new Jugador("Roman Burki","Portero",26,"Suiza",7500000);
		Jugador sokratis = new Jugador("Sokratis","Defensa",28,"Grecia",28000000);
		Jugador julianWeigl = new Jugador("Julian Weigl","Mediocentro",21,"Alemania",23000000);
		Jugador aubameyang = new Jugador("Aubameyang","Delantero",27,"Gabón",65000000);
		
		romanBurki.setEquipo(borussiaDormund);
		sokratis.setEquipo(borussiaDormund);
		julianWeigl.setEquipo(borussiaDormund);
		aubameyang.setEquipo(borussiaDormund);
		
		jugadorRepository.save(romanBurki);
		jugadorRepository.save(sokratis);
		jugadorRepository.save(julianWeigl);
		jugadorRepository.save(aubameyang);		
		
		//Creamos los jugadores del Bayer Leverkusen.
		Jugador berndLeno = new Jugador("Bernd Leno","Portero",24,"Alemania",16000000);
		Jugador jonathanTah = new Jugador("Jonathan Tah","Defensa",20,"Alemania",22000000);
		Jugador larsBender = new Jugador("Lars Bender","Mediocentro",27,"Alemania",15000000);
		Jugador chicharito = new Jugador("Chicharito","Delantero",29,"Mexico",22000000);
		
		berndLeno.setEquipo(bayerLeverkusen);
		jonathanTah.setEquipo(bayerLeverkusen);
		larsBender.setEquipo(bayerLeverkusen);
		chicharito.setEquipo(bayerLeverkusen);
		
		jugadorRepository.save(berndLeno);
		jugadorRepository.save(jonathanTah);
		jugadorRepository.save(larsBender);
		jugadorRepository.save(chicharito);
		
		//Creamos los jugadores del Shalke 04.
		Jugador ralfFahrmann = new Jugador("Ralf Fahrmann","Portero",28,"Alemania",9000000);
		Jugador benediktHowedes = new Jugador("Benedikt Howedes","Defensa",28,"Alemania",18000000);
		Jugador leonGoretzka = new Jugador("Leon Goretzka","Mediocentro",22,"Alemania",18000000);
		Jugador breelEmbolo = new Jugador("Breel Embolo","Delantero",19,"Suiza",20000000);
		
		ralfFahrmann.setEquipo(shalke);
		benediktHowedes.setEquipo(shalke);
		leonGoretzka.setEquipo(shalke);
		breelEmbolo.setEquipo(shalke);
		
		jugadorRepository.save(ralfFahrmann);
		jugadorRepository.save(benediktHowedes);
		jugadorRepository.save(leonGoretzka);
		jugadorRepository.save(breelEmbolo);
		
		//Creamos los jugadores del PSG.
		Jugador kevinTrapp = new Jugador("Kevin Trapp","Portero",26,"Alemania",10000000);
		Jugador marquinhos = new Jugador("Marquinhos","Defensa",22,"Portugal",32000000);
		Jugador marcoVeratti = new Jugador("Marco Verotti","Mediocentro",24,"Italia",40000000);
		Jugador edisonCavani = new Jugador("Edison Cavani","Delantero",29,"Uruguay",45000000);
		
		kevinTrapp.setEquipo(psg);
		marquinhos.setEquipo(psg);
		marcoVeratti.setEquipo(psg);
		edisonCavani.setEquipo(psg);
		
		jugadorRepository.save(kevinTrapp);
		jugadorRepository.save(marquinhos);
		jugadorRepository.save(marcoVeratti);
		jugadorRepository.save(edisonCavani);		
		
		//Creamos los jugadores del Mónaco.
		Jugador danijelSubasic = new Jugador("Danijel Subasic","Portero",32,"Croacia",5000000);
		Jugador kamilGlik = new Jugador("Kamil Glik","Defensa",29,"Polonia",15000000);
		Jugador fabinho = new Jugador("Fabinho","Mediocentro",23,"Brasil",20000000);
		Jugador falcao = new Jugador("Falcao","Delantero",31,"Colombia",15000000);
		
		danijelSubasic.setEquipo(monaco);
		kamilGlik.setEquipo(monaco);
		fabinho.setEquipo(monaco);
		falcao.setEquipo(monaco);
		
		jugadorRepository.save(danijelSubasic);
		jugadorRepository.save(kamilGlik);
		jugadorRepository.save(fabinho);
		jugadorRepository.save(falcao);		
		
		//Creamos los jugadores del Olympique de Lyon.
		Jugador anthonyLopes = new Jugador("Anthony Lopes","Portero",26,"Portugal",14000000);
		Jugador emanuelMammana = new Jugador("Emanuel Mammana","Defensa",21,"Argentina",6000000);
		Jugador corentinTolisso = new Jugador("Corentin Tolisso","Mediocentro",22,"Francia",18000000);
		Jugador alexandreLacazette = new Jugador("Alexandre Lacazette","Delantero",25,"Francia",40000000);
		
		anthonyLopes.setEquipo(olympiqueLyon);
		emanuelMammana.setEquipo(olympiqueLyon);
		corentinTolisso.setEquipo(olympiqueLyon);
		alexandreLacazette.setEquipo(olympiqueLyon);
		
		jugadorRepository.save(anthonyLopes);
		jugadorRepository.save(emanuelMammana);
		jugadorRepository.save(corentinTolisso);
		jugadorRepository.save(alexandreLacazette);	
		
		//Creamos los jugadores del Olympique de Marsella.
		Jugador yohannPele = new Jugador("Yohann Pele","Portero",34,"Francia",500000);
		Jugador karimRekik = new Jugador("Karim Rekik","Defensa",22,"Holanda",3000000);
		Jugador morganSanson = new Jugador("Morgan Sanson","Mediocentro",22,"Francia",10000000);
		Jugador bafetimbiGomis = new Jugador("Bafetimbi Gomis","Delantero",31,"Francia",7000000);
		
		yohannPele.setEquipo(olympiqueMarsella);
		karimRekik.setEquipo(olympiqueMarsella);
		morganSanson.setEquipo(olympiqueMarsella);
		bafetimbiGomis.setEquipo(olympiqueMarsella);
		
		jugadorRepository.save(yohannPele);
		jugadorRepository.save(karimRekik);
		jugadorRepository.save(morganSanson);
		jugadorRepository.save(bafetimbiGomis);
		
		//Creamos los jugadores del Oporto.
		Jugador ikerCasillas = new Jugador("Iker Casillas","Portero",35,"España",3000000);
		Jugador ivanMarcano = new Jugador("Ivan Marcano","Defensa",29,"España",6000000);
		Jugador hectorHerrera = new Jugador("Hector Herrera","Mediocentro",26,"Mexico",16000000);
		Jugador andreSilva = new Jugador("Andre Silva","Delantero",21,"Portugal",10000000);
		
		ikerCasillas.setEquipo(oporto);
		ivanMarcano.setEquipo(oporto);
		hectorHerrera.setEquipo(oporto);
		andreSilva.setEquipo(oporto);
		
		jugadorRepository.save(ikerCasillas);
		jugadorRepository.save(ivanMarcano);
		jugadorRepository.save(hectorHerrera);
		jugadorRepository.save(andreSilva);		
		
		//Creamos los jugadores del Benfica.
		Jugador ederson = new Jugador("Ederson","Portero",23,"Brasil",7000000);
		Jugador victorLindelof = new Jugador("Victor Lindelof","Defensa",22,"Suecia",12000000);
		Jugador pizzi = new Jugador("Pizzi","Mediocentro",27,"Portugal",13000000);
		Jugador raulJimenez = new Jugador("Raul Jimenez","Delantero",25,"Mexico",11000000);
		
		ederson.setEquipo(benfica);
		victorLindelof.setEquipo(benfica);
		pizzi.setEquipo(benfica);
		raulJimenez.setEquipo(benfica);
		
		jugadorRepository.save(ederson);
		jugadorRepository.save(victorLindelof);
		jugadorRepository.save(pizzi);
		jugadorRepository.save(raulJimenez);	
		
		//Creamos los jugadores del Sporting de Lisboa.
		Jugador ruiPatricio = new Jugador("Rui Patricio","Portero",28,"Portugal",16000000);
		Jugador rubenSemedo = new Jugador("Ruben Semedo","Defensa",22,"Portugal",7000000);
		Jugador williamCarvalho = new Jugador("William Carvalho","Mediocentro",24,"Portugal",30000000);
		Jugador banDost = new Jugador("Ban Dost","Delantero",27,"Holanda",27000000);
		
		ruiPatricio.setEquipo(sportingLisboa);
		rubenSemedo.setEquipo(sportingLisboa);
		williamCarvalho.setEquipo(sportingLisboa);
		banDost.setEquipo(sportingLisboa);
		
		jugadorRepository.save(ruiPatricio);
		jugadorRepository.save(rubenSemedo);
		jugadorRepository.save(williamCarvalho);
		jugadorRepository.save(banDost);		
		
		//Creamos los jugadores del Sporting de Braga.
		Jugador marafona = new Jugador("Marafona","Portero",29,"Portugal",2000000);
		Jugador emilianoVelazquez = new Jugador("Emiliano Velazquez","Defensa",22,"Uruguay",1500000);
		Jugador nikolaVukcevic = new Jugador("Nikola Vukcevic","Mediocentro",25,"Albania",3000000);
		Jugador ahmedHassan = new Jugador("Ahmed Hassan","Delantero",23,"Egipto",4500000);
		
		marafona.setEquipo(sportingBraga);
		emilianoVelazquez.setEquipo(sportingBraga);
		nikolaVukcevic.setEquipo(sportingBraga);
		ahmedHassan.setEquipo(sportingBraga);
		
		jugadorRepository.save(marafona);
		jugadorRepository.save(emilianoVelazquez);
		jugadorRepository.save(nikolaVukcevic);
		jugadorRepository.save(ahmedHassan);
		
		//Creamos los managers de los equipos.
		Manager zinedineZidane = new Manager("Zinedine Zidane","ZineZid","remadr");
		zinedineZidane.setEquipo(realMadrid);
		managerRepository.save(zinedineZidane);
		
		Manager luisEnrique = new Manager("Luis Enrique","LuEnr","fcbarc");
		luisEnrique.setEquipo(barcelona);
		managerRepository.save(luisEnrique);
		
		Manager diegoSimeone = new Manager("Diego Simeone","DieSim","atmad");
		diegoSimeone.setEquipo(atleticoMadrid);
		managerRepository.save(diegoSimeone);
		
		Manager jorgeSampaoli = new Manager("Jorge Sampaoli","JorSamp","sevfc");
		jorgeSampaoli.setEquipo(sevilla);
		managerRepository.save(jorgeSampaoli);
		
		Manager franEscriba = new Manager("Fran Escriba","FrEscr","villafc");
		franEscriba.setEquipo(villarreal);
		managerRepository.save(franEscriba);
		
		Manager asierGaritano = new Manager("Asier Garitano","AsGari","cdleg");
		asierGaritano.setEquipo(leganes);
		managerRepository.save(asierGaritano);
		
		Manager antonioConte = new Manager("Antonio Conte","AntCon","chel");
		antonioConte.setEquipo(chelsea);
		managerRepository.save(antonioConte);		

		Manager arseneWenger = new Manager("Arsene Wenger","ArWeng","arsn");
		arseneWenger.setEquipo(arsenal);
		managerRepository.save(arseneWenger);
		
		Manager jurgenKlopp = new Manager("Jurgen Klopp","JuKlo","livfc");
		jurgenKlopp.setEquipo(liverpool);
		managerRepository.save(jurgenKlopp);
		
		Manager joseMourinho = new Manager("Jose Mourinho","JoMou","manu");
		joseMourinho.setEquipo(manchesterUnited);
		managerRepository.save(joseMourinho);

		Manager pepGuardiola = new Manager("Pep Guardiola","PeGuar","manc");
		pepGuardiola.setEquipo(manchesterCity);
		managerRepository.save(pepGuardiola);
		
		Manager mauricioPochettino = new Manager("Mauricio Pochettino","MauPoch","totten");
		mauricioPochettino.setEquipo(tottenham);
		managerRepository.save(mauricioPochettino);
		
		Manager massimilianoAllegri = new Manager("Massimiliano Allegri","MasAlle","juvfc");
		massimilianoAllegri.setEquipo(juventus);
		managerRepository.save(massimilianoAllegri);		
		
		Manager vicenzoMontella = new Manager("Vicenzo Montella","VicMon","acmil");
		vicenzoMontella.setEquipo(milan);
		managerRepository.save(vicenzoMontella);
		
		Manager stefanoPioli = new Manager("Stefano Pioli","StePio","intmil");
		stefanoPioli.setEquipo(interMilan);
		managerRepository.save(stefanoPioli);
		
		Manager lucianoSpalletti = new Manager("Luciano Spalletti","LucSpa","asrom");
		lucianoSpalletti.setEquipo(roma);
		managerRepository.save(lucianoSpalletti);
		
		Manager maurizioSarri = new Manager("Maurizio Sarri","MauSar","sscnap");
		maurizioSarri.setEquipo(napoles);
		managerRepository.save(maurizioSarri);
		
		Manager carloAncelotti = new Manager("Carlo Ancelotti","CarAnc","fcbaym");
		carloAncelotti.setEquipo(bayernMunich);
		managerRepository.save(carloAncelotti);
		
		Manager thomasTuchel = new Manager("Thomas Tuchel","TomTuc","bordor");
		thomasTuchel.setEquipo(borussiaDormund);
		managerRepository.save(thomasTuchel);
		
		Manager rogerSchmidt = new Manager("Roger Schmidt","RogSch","baylev");
		rogerSchmidt.setEquipo(bayerLeverkusen);
		managerRepository.save(rogerSchmidt);
		
		Manager markusWeinzierl = new Manager("Markus Weinzierl","MarWein","fcshal");
		markusWeinzierl.setEquipo(shalke);
		managerRepository.save(markusWeinzierl);
		
		Manager unaiEmery = new Manager("Unai Emery","UnEme","fcpsg");
		unaiEmery.setEquipo(psg);
		managerRepository.save(unaiEmery);
		
		Manager leonardoJardim = new Manager("Leonardo Jardim","LeoJar","asmon");
		leonardoJardim.setEquipo(monaco);
		managerRepository.save(leonardoJardim);
		
		Manager brunoGenesio = new Manager("Bruno Genesio","BruGen","olylyo");
		brunoGenesio.setEquipo(olympiqueLyon);
		managerRepository.save(brunoGenesio);
		
		Manager rudiGarcia = new Manager("Rudi Garcia","RudGar","olymar");
		rudiGarcia.setEquipo(olympiqueMarsella);
		managerRepository.save(rudiGarcia);
		
		Manager nunoEspiritoSanto = new Manager("Nuno Espirito Santo","NunEspS","fcopo");
		nunoEspiritoSanto.setEquipo(oporto);
		managerRepository.save(nunoEspiritoSanto);
		
		Manager ruiVitoria = new Manager("Rui Vitoria","RuVit","slbenf");
		ruiVitoria.setEquipo(benfica);
		managerRepository.save(ruiVitoria);
		
		Manager jorgeJesus = new Manager("Jorge Jesus","JorJes","splisb");
		jorgeJesus.setEquipo(sportingLisboa);
		managerRepository.save(jorgeJesus);
		
		Manager jorgeSimao = new Manager("Jorge Simao","JorSim","scbra");
		jorgeSimao.setEquipo(sportingBraga);
		managerRepository.save(jorgeSimao);		
	}
	
	//Indicamos la página principal de nuestra aplicación Web (FutWorld).
	@RequestMapping("/")
	public String principal (){
		return "index";
	}
}
