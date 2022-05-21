create table administrateur(
    id_administrateur integer not null auto_increment primary key,
    login varchar(20),
    mot_de_passe varchar(30)
)engine=innodb;

create table chauffeur(
   id_chauffeur integer not null auto_increment primary key,
   nom_chauffeur varchar(30),
   email varchar(40),
   mot_de_passe varchar(20)
)engine=innodb;
insert into chauffeur values(0,'Koto','jrmanouhoseah@gmail.com','koto');

create table marque(
    id_marque integer not null auto_increment primary key,
    nom_marque varchar(20)
)engine=innodb;
insert into marque values(0,'BMW'),(0,'Mercedes');

create table type_vehicule(
    id_type_vehicule integer not null auto_increment primary key,
    nom_type_vehicule varchar(20)
)engine=innodb;
insert into type_vehicule values(0,'SUV'),(0,'Camion');

create table vehicule(
    id_vehicule integer not null auto_increment primary key,
    numero varchar(20),
    marque integer,
    foreign key(marque) references marque(id_marque),
    modele  varchar(20),
    type_vehicule integer,
    foreign key(type_vehicule) references type_vehicule(id__type_vehicule),
    kilometrage integer
)engine=innodb; 

create table trajet(
    id_trajet integer not null auto_increment primary key,
    chauffeur integer,
    foreign key(chauffeur) references chauffeur(id_chauffeur),
    vehicule integer,
    foreign key(vehicule) references voiture(id_vehicule),
    motif varchar(100),
    quantite integer,
    date_depart date,
    heure_depart time,
    lieu_depart varchar(40),
    kilometrage_depart integer,
    date_arrivee date,
    heure_arrivee time,
    lieu_arrivee varchar(40),
    kilometrage_arrivee integer
)engine=innodb;

alter table trajet add foreign key(vehicule) references vehicule(id_vehicule);
alter table trajet add foreign key(chauffeur) references chauffeur(id_chauffeur);

create table type_echeance(
    id_type_echeance integer not null auto_increment primary key,
    nom_echeance varchar(30),
    duree_echeance integer
)engine=innodb;
insert into type_echeance values(0,'Assurance',30),(0,'Visite Technique',10);

create table echeance (
    id_echeance integer not null auto_increment primary key,
    vehicule integer ,
    foreign key(vehicule) references vehicule(id_vehicule),
    type_echeance integer,
    foreign key(type_echeance) references type_echeance(id_type_echeance),
    date_renouvellement date
) engine=innodb;


 ---------------------------------------liste des voitures avec restes jours echeances

create view viewGarage as (
 select v.numero,v.modele, v.marque,v.type_vehicule,v.id_vehicule ,
 t.nom_echeance,t.duree_echeance,
 e.date_renouvellement,adddate(e.date_renouvellement,t.duree_echeance) as date_echeance,
   datediff(adddate(e.date_renouvellement,t.duree_echeance),curdate()) as jour_restant
  from echeance e join type_echeance t
 on e.type_echeance=t.id_type_echeance 
 join vehicule v on v.id_vehicule=e.vehicule);

 create view garage as (
     select viewGarage.*, tv.nom_type_vehicule
 ,m.nom_marque,m.image from viewGarage join
 marque m on viewGarage.marque=m.id_marque join 
 type_vehicule tv on viewGarage.type_vehicule=tv.id_type_vehicule
 );

--create view voitureNonEcheance as (select * from garage where  jour_restant>0);

select * from trajet where now()  between  '2022-05-19 09:00:00'  and  '2022-05-19 10:00:00' ;

----select concat(date_depart,' ',heure_depart) as ddt from trajet;

create view voitureDispo as(
select  concat(trajet.date_depart,' ',trajet.heure_depart)as timee , garage.*  from trajet join garage on trajet.vehicule=garage.id_vehicule
where now() not between concat(date_depart,' ',heure_depart) and  concat(date_arrivee,' ',heure_arrivee));


select trajet.*,garage.jour_restant from trajet join garage on trajet.vehicule=garage.id_vehicule
where now() between concat(date_depart,' ',heure_depart) and  concat(date_arrivee,' ',heure_arrivee);
 
select * from trajet 
where now() not between concat(date_depart,' ',heure_depart) and  concat(date_arrivee,' ',heure_arrivee);

 ------------------------------------------------------

 create table type_maintenance(
     id_type_maintenance integer not null auto_increment primary key,
     nom_type_maintenance varchar(30),
     valable integer
 )engine=innodb;
 insert into type_maintenance values(0,'Vidange',5000),(0,'Pneu',2000);

 create table maintenance(
     id_maintenance integer not null auto_increment primary key,
     type_maintenance integer,
     foreign key(type_maintenance) references type_maintenance(id_type_maintenance),
     vehicule integer,
     foreign key(vehicule) references vehicule(id_vehicule)
 )engine=innodb;

 ------------------------------------------------------
create view viewMaintenance as(
 select tm.nom_type_maintenance,tm.valable,
  t.vehicule, 
  t.kilometrage_arrivee-t.kilometrage_depart as distance_parcourue, valable-(t.kilometrage_arrivee-t.kilometrage_depart) as reste
  from maintenance main join type_maintenance tm on main.type_maintenance=tm.id_type_maintenance 
  join trajet t on t.vehicule=main.vehicule
 ) ;

create view viewVehicule as (
    select vehicule.*, marque.nom_marque,marque.image,type_vehicule.nom_type_vehicule
from vehicule join marque on vehicule.marque=marque.id_marque join type_vehicule on type_vehicule.id_type_vehicule=vehicule.type_vehicule
);
 
create view MaintenanceTrajet as(
 select   
  v.numero,v.modele,v.nom_marque ,v.image,v.nom_type_vehicule, sum(distance_parcourue) as distance_parcourue,
   valable-sum(distance_parcourue) as reste from viewMaintenance join viewvehicule v on viewMaintenance.vehicule=v.id_vehicule
   
    )  ; 

---------------------------------------------------------voiture dispo


create view getIdLastTrajet as(
SELECT max(id_trajet) as id FROM trajet group by vehicule);

create view getLastTrajet as(
    select trajet.*  from trajet join getIdLastTrajet on getIdLastTrajet.id=trajet.id_trajet
);

create view trajetGarage as( 
select gl.vehicule,gl.chauffeur,gl.date_depart,gl.heure_depart,gl.date_arrivee,gl.heure_arrivee,
g.jour_restant from getLastTrajet gl join garage g on gl.vehicule=g.id_vehicule);

 create view voitureDispo as (select  trajetGarage.*,viewvehicule.modele,viewvehicule.nom_marque  from trajetGarage join viewvehicule
 on trajetGarage.vehicule=viewvehicule.id_vehicule
where now() not between concat(date_depart,' ',heure_depart) and  concat(date_arrivee,' ',heure_arrivee));
