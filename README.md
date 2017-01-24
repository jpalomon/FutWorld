# **FUTWORLD**

Football Database

## Nombre de la Aplicación Web: FUTWORLD.

## Descripción Temática de la Web:

La aplicación web consiste, en una base de datos donde se pueden hacer diferentes consultas de fútbol y, a su vez, se puede inscribir nuevos equipos y jugadores si eres el mánager de un équipo. Para ello, hemos dividido la aplicación web en dos partes diferenciadas:

* Parte Pública: únicamente se podrán realizar consultas a la base de datos. Para realizar dichas consultas, podremos filtrar los resultados por:

	+ Nombre del Jugador: se mostrarán las características de un único jugador.
	+ Equipo: se mostrarán todos los jugadores pertenecientes a ese equipo.
	+ Edad: se mostrarán los jugadores con esa edad dentro de un mismo equipo o en general.
	+ Nacionalidad: se mostrarán los jugadores con esa nacionalidad dentro de un mismo equipo o en general.
	+ Valor de Mercado: se mostrarán los jugadores que tengan ese valor de mercado dentro de un mismo equipo o en general.

* Parte Privada: cada usuario podrá inscribir y administrar a un sólo equipo, gestionando su plantilla y jugadores. Cuando se inscriba un jugador, se deberá indicar su nombre, equipo, edad, nacionalidad y valor de mercado. Importante: un usuario no puede gestionar un equipo que no es el suyo por lo que, para evitar que esto ocurra, se gestionará dicha funcionalidad mediante un usuario y contraseña para cada usuario. Añadimos un servicio de uso exclusivamente interno, el cual permite al manager subir imagenes de los jugadores de su plantilla al editarlos.

## Entidades Principales:

1. Jugador: nombre del futbolista.
2. Equipo: nombre de un equipo.
3. Nacionalidad: país de nacimiento de un jugador.
4. Edad: años de un futbolista.
5. Valor de Mercado: precio de un futbolista.
