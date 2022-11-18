create table abonnes(
    abonneID number GENERATED ALWAYS AS IDENTITY,
    nom varchar(50),
    prenom varchar(50),
    email varchar(50),
    adresse varchar(50),
    telephone varchar(10),
    restrictions varchar(500),
    solde number(10),
    mdpHash number(10),
    constraint abonnes_C1 primary key (abonneID)
);

create table films(
    nomFilm varchar(100),
    categories varchar(500),
    realisateur varchar(50),
    synopsis varchar(2000),
    acteurs varchar(500),
    constraint films_C1 primary key (nomFilm)
);

create table supports(
    supportID number GENERATED ALWAYS AS IDENTITY,
    nomFilm varchar(100),
    typeSup varchar(10),
    constraint supports_C1 primary key (supportID),
    constraint supports_C2 foreign key (nomFilm) references films (nomFilm)
);

create table locations(
    supportID number(10),
    dateDebut TIMESTAMP,
    dateFin TIMESTAMP,
    abonneID number(10),
    etat varchar(20),
    constraint locations_C1 primary key (supportID, dateDebut),
    constraint locations_C3 foreign key (supportID) references supports (supportID),
    constraint locations_C4 foreign key (abonneID) references abonnes (abonneID)
);

create table demandesAjouts(
    abonneID number(10),
    nomFilm varchar(100),
    constraint demandesAjouts_C1 primary key (abonneID, nomFilm),
    constraint demandesAjouts_C3 foreign key (abonneID) references abonnes (abonneID),
    constraint demandesAjouts_C4 foreign key (nomFilm) references films (nomFilm)
)

