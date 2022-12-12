create or replace trigger MaxTroisFilms
before insert on Locations
for each row
declare
    nbLocationsEnCours number(10) := 0;
begin
    select count(locationID) into nbLocationsEnCours
    from locations
    where abonneID = :NEW.abonneID and etat = 'enCours'
    group by abonneID;

    if nbLocationsEnCours > 2 then 
        raise_application_error(-20001, 'Un abonné ne peut pas louer plus de trois films à la fois');
    end if;
Exception
    when NO_DATA_FOUND then NULL;
end;
/
create or replace trigger LouerSansQuinzeEuros
before insert on Locations
for each row
declare
    soldeClient number(10);
begin
    select solde into soldeClient
    from abonnes
    where abonneID = :NEW.abonneID;

    if soldeClient < 15 then
        raise_application_error(-20002, 'Un abonné ne peut pas louer de film si son solde est inférieur à 15€');
    end if;
Exception
    when NO_DATA_FOUND then NULL;
end;
/
create or replace trigger MaxCentBluRaysAL2000
before insert on supports
for each row
declare
    nbBluRays number(10);
begin
    select count(supportID) into nbBluRays
    from supports
    where typeSup = 'BluRay';

    if nbBluRays = 100 then
        raise_application_error(-20002, 'AL2000 ne peut pas contenir plus de 100 Blu-Rays');
    end if;
Exception
    when NO_DATA_FOUND then NULL;
end;