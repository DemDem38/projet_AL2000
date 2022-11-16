create table abonnes(
    abonneID number AUTO_INCREMENT,
    nom varchar(50),
    prenom varchar(50),
    email varchar(50),
    adresse varchar(50),
    telephone varchar(10),
    restrictions varchar(500),
    solde number,
    mdpHash number,
    constraint abonnes_C1 primary key (abonneID)
);

create table films(
    nomFilm varchar(100),
    categories varchar(500),
    realisateur varchar(50),
    synopsis varchar(1000),
    acteurs varchar(500),
    constraint films_C1 primary key (nom)
);

create table supports(
    supportID number AUTO_INCREMENT,
    nomFilm varchar(100),
    typeSup varchar(10),
    constraint supports_C1 primary key (supportID),
    constraint supports_C2 foreign key (nomFilm) references films(nom)
);

create table locations(
    supportID number,
    dateDebut TIMESTAMP,
    dateFin TIMESTAMP,
    abonneID number,
    etat varchar(20),
    constraint locations_C1 primary key (supportID),
    constraint locations_C2 primary key (dateDebut),
    constraint locations_C3 foreign key (supportID) references supports(supportID),
    constraint locations_C4 foreign key (abonneID) references abonnes(abonneID)
);

create table demandesAjouts(
    abonneID number,
    nomFilm varchar(100),
    constraint demandesAjouts_C1 primary key (abonneID),
    constraint demandesAjouts_C2 primary key (nomFilm),
    constraint demandesAjouts_C3 foreign key (abonneID) references abonnes(abonneID),
    constraint demandesAjouts_C4 foreign key (nomFilm) references films(nomFilm)

);

