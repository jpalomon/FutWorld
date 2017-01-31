# **FUTWORLD**

Football Database

## Nombre de la Aplicación Web: FUTWORLD.

## Descripción Temática de la Web:

La aplicación web, consiste en una base de datos donde se pueden hacer diferentes consultas de fútbol. A su vez, se puede inscribir nuevos equipos y jugadores en una determinada liga, si eres el mánager de un équipo. Para ello, hemos dividido la aplicación web en dos partes diferenciadas:

* Parte Pública: únicamente se pueden realizar consultas a la base de datos. Para realizar dichas consultas, se pueden filtrar los resultados por:

	+ Nombre del Jugador: se mostrarán las características de un único jugador.
	+ Equipo: se mostrará toda la plantilla de jugadores pertenecientes a ese equipo.
	+ Edad: se mostrarán los jugadores con esa edad dentro de un mismo equipo, en una determinada liga o en general.
	+ Nacionalidad: se mostrarán los jugadores con esa nacionalidad dentro de un mismo equipo, en una determinada liga o en general.
	+ Valor de Mercado: se mostrarán los jugadores que tengan ese valor de mercado dentro de un mismo equipo, en una determinada liga o en general.
	+ Liga: se mostrarán los equipos participantes en una determinada liga.
	+ Palmarés: se mostrará el ranking de campeones de una liga en los últimos años.


* Parte Privada: cada usuario podrá inscribir y administrar a un sólo equipo, gestionando su plantilla y jugadores. Cuando se inscriba un jugador, se deberá indicar su nombre, equipo, edad, nacionalidad y valor de mercado. Importante: un usuario no puede gestionar un equipo que no es el suyo por lo que, para evitar que esto ocurra, se gestionará dicha funcionalidad mediante un usuario y contraseña para cada usuario. Añadimos un servicio de uso exclusivamente interno, el cual permite al manager subir imagenes de los jugadores de su plantilla al editarlos.

* Parte Privada: cada usuario (mánager) puede inscribir y administrar a un sólo equipo, gestionando su plantilla y jugadores. Primeramente, debe indicar en que liga va a participar su equipo y, posteriormente, ha de inscibir a los jugadores pertenecientes a su plantilla. Cuando se inscribe a un jugador, se debe indicar su nombre, equipo, edad, nacionalidad y valor de mercado. Importante: un usuario no puede gestionar un equipo que no es el suyo, por lo que, para evitar que esto ocurra, se gestiona dicha funcionalidad mediante un nombre de usuario y contraseña para cada mánager de equipo. Añadimos un servicio de uso exclusivamente interno, el cual permite al manager subir imagenes de los jugadores de su plantilla al editarlos.


## Entidades Principales:

1. Jugador: características de un jugador (nombre, equipo al que pertenece, edad, nacionalidad y valor de mercado).
2. Equipo: nombre de un equipo y plantilla de la que dispone para disputar el Torneo.
3. Mánager: director de un equipo, el cual es el encargado de inscribir a su equipo en una determinada liga y de gestionar su plantilla.
4. Torneo: campeonato de liga en el cúal se van a inscribir un máximo de 20 equipos por liga.
5. Palmarés: ranking de campeones del torneo en los últimos años.

## Integrantes del Proyecto:

1. Jorge Palomo Neila. Correo: j.palomon@alumnos.urjc.es
2. Francisco Miján Sánchez. Correo: f.mijans@alumnos.urjc.es
