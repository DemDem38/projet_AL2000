create table abonnes(
    abonneID number GENERATED ALWAYS AS IDENTITY,
    nom varchar(50),
    prenom varchar(50),
    email varchar(50),
    adresse varchar(50),
    telephone varchar(10),
    restrictions varchar(500),
    solde number(10),
    mdpHash number(38),
    constraint abonnes_C1 primary key (abonneID)
);

create table films(
    filmID number GENERATED ALWAYS AS IDENTITY,
    nomFilm varchar(100),
    categories varchar(500),
    realisateur varchar(50),
    synopsis varchar(2000),
    acteurs varchar(500),
    constraint films_C1 primary key (filmID)
);

create table supports(
    supportID number GENERATED ALWAYS AS IDENTITY,
    filmID number(10),
    typeSup varchar(10),
    dateExpiration varchar(100),
    constraint supports_C1 primary key (supportID),
    constraint supports_C2 foreign key (filmID) references films (filmID)
);

create table locations(
    locationID number GENERATED ALWAYS AS IDENTITY,
    supportID number(10),
    dateDebut varchar(100),
    dateFin varchar(100),
    abonneID number(10),
    etat varchar(20),
    constraint locations_C1 primary key (locationID),
    constraint locations_C3 foreign key (supportID) references supports (supportID)
);

create table demandesAjouts(
    demandeAjoutID number GENERATED ALWAYS AS IDENTITY,
    abonneID number(10),
    filmID number(10),
    constraint demandesAjouts_C1 primary key (demandeAjoutID),
    constraint demandesAjouts_C3 foreign key (abonneID) references abonnes (abonneID),
    constraint demandesAjouts_C4 foreign key (filmID) references films (filmID)
)

