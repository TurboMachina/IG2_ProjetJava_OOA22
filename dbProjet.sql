CREATE TABLE IF NOT EXISTS Clients
	( idClient INT PRIMARY KEY AUTO_INCREMENT
	, nom VARCHAR(255) NOT NULL
	, prenom VARCHAR(255) NOT NULL
	, numTel VARCHAR(255) NOT NULL
	, email VARCHAR(255) NOT NULL
	)ENGINE = InnoDB;
	
CREATE TABLE IF NOT EXISTS Marque
	( libelle VARCHAR(255) PRIMARY KEY
	)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Magasin
	( idMagasin INT PRIMARY KEY AUTO_INCREMENT
	, adresse VARCHAR(255) NOT NULL
	, libelle VARCHAR(255) NOT NULL
	)ENGINE = InnoDB;
	
CREATE TABLE IF NOT EXISTS Modele
	( idModele INT PRIMARY KEY AUTO_INCREMENT
	, libelle VARCHAR(255) NOT NULL
	, cylindree INT NOT NULL
	, cylindre INT NOT NULL
	, transmission VARCHAR(255) NOT NULL
	, vitesses INT NOT NULL CHECK (vitesses > 1)
	, poidAVide INT NOT NULL
	, carburant VARCHAR(255) NOT NULL
	, consoMixte DOUBLE NOT NULL
	, consoUrbain DOUBLE NOT NULL
	, consoExtraUrbain DOUBLE NOT NULL
	, nbPortes INT NOT NULL CHECK (nbPortes > 1)
	, App_libelle VARCHAR(255) NOT NULL
	 
	, CONSTRAINT mod_carbu_chk CHECK (carburant IN ('essence','diesel','lpg','hybride','electrique'))
	, CONSTRAINT mod_transmi_chk CHECK (transmission IN ('automatique','manuelle'))
	, CONSTRAINT mod_mar_fk FOREIGN KEY (App_libelle) REFERENCES Marque(libelle)
	)ENGINE = InnoDB;
    
CREATE TABLE IF NOT EXISTS Commercial
	( matricule INT PRIMARY KEY AUTO_INCREMENT
	, nom VARCHAR(255) NOT NULL
	, prenom VARCHAR(255) NOT NULL
	, numTel VARCHAR(255) NOT NULL
	, email VARCHAR(255) NOT NULL
	, idMagasin INT NOT NULL
	
	, CONSTRAINT com_m_fk FOREIGN KEY (idMagasin) REFERENCES Magasin(idMagasin)
	)ENGINE = InnoDB;
	
CREATE TABLE IF NOT EXISTS FicheVehicule
	( numChassis VARCHAR(14) PRIMARY KEY
	, dateMiseCircu DATE NOT NULL
	, idModele INT NOT NULL
	
	, CONSTRAINT fv_mod_fk FOREIGN KEY (idModele) REFERENCES Modele(idModele)
	)ENGINE = InnoDB;

    
CREATE TABLE IF NOT EXISTS Transactions
	( idTransaction INT PRIMARY KEY AUTO_INCREMENT 
	, kilometrage INT NOT NULL
	, couleur VARCHAR(255) NOT NULL
	, prixAchat DOUBLE NOT NULL CHECK(prixAchat > 0)
	, prixDepart DOUBLE NOT NULL CHECK(prixDepart > 0)
	, prixMin DOUBLE NULL CHECK(prixMin > 0)
	, nbProprios INT NULL CHECK (nbProprios > -1)
	, description VARCHAR(255) NULL
	, dateArrivee DATE NOT NULL
	, dureeGarantie INT NOT NULL CHECK (dureeGarantie > -1)
	, estTVARecup BOOLEAN NOT NULL
	, prixVente DOUBLE NOT NULL CHECK(prixVente > 0)
	, dateVente DATE NOT NULL
	, etat VARCHAR(255) NOT NULL
	, matricule INT NOT NULL
	, numChassis VARCHAR(14) NOT NULL
	, idClient INT NOT NULL
	
	, CONSTRAINT trans_com_fk FOREIGN KEY (matricule) REFERENCES Commercial(matricule)
	, CONSTRAINT trans_fv_fk FOREIGN KEY (numChassis) REFERENCES FicheVehicule(numChassis)
	, CONSTRAINT trans_c_fk FOREIGN KEY (idClient) REFERENCES  Clients(idClient)
	, CONSTRAINT trans_etat_chk CHECK (etat IN ('vendue', 'attente'))
	)ENGINE = InnoDB;
	
/*Marque*/
	
INSERT INTO Marque (libelle)
	VALUES ('audi');
INSERT INTO Marque (libelle)
	VALUES ('bmw');
INSERT INTO Marque (libelle)
	VALUES ('honda');
INSERT INTO Marque (libelle)
	VALUES ('tesla');
INSERT INTO Marque (libelle)
	VALUES ('ford');

/*Modele*/

/*Audi*/
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('a3', 1996, 4, 'manuelle', 8, 1320, 'essence', 7.3, 8.8, 5.8, 5, 'audi');
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('q5', 1856, 4, 'automatique', 7, 1458, 'diesel', 7.2, 8.7, 5.7, 5, 'audi');
/*BMW*/
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('serie1', 2006, 4, 'manuelle', 5, 1265, 'lpg', 7.3, 8.8, 5.8, 5, 'bmw');
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('m5', 1589, 4, 'automatique', 6, 1156, 'hybride', 7.3, 8.8, 5.8, 5, 'bmw');
/*Honda*/
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('civic', 1325, 4, 'manuelle', 8, 1065, 'essence', 7.3, 8.8, 5.8, 5, 'honda');
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('hrv',1896, 4, 'automatique', 6, 1485, 'lpg', 7.3, 8.8, 5.8, 5, 'honda');
/*Tesla*/
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('models', 2125, 4, 'manuelle', 7, 1236, 'electrique', 7.3, 8.8, 5.8, 5, 'tesla');
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('model3', 1685, 4, 'automatique', 8, 1896, 'electrique', 7.3, 8.8, 5.8, 5, 'tesla');
/*Ford*/
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('mustang', 1735, 4, 'manuelle', 4, 1630, 'diesel', 7.3, 8.8, 5.8, 5, 'ford');
INSERT INTO Modele (libelle, cylindree, cylindre, transmission, vitesses, poidAVide, carburant, consoMixte, consoUrbain, consoExtraUrbain, nbPortes, App_libelle)
	VALUES ('focus', 1465, 4, 'automatique', 8, 1058, 'hybride', 7.3, 8.8, 5.8, 5, 'ford');

/*Magasin*/

INSERT INTO Magasin (adresse, libelle)
	VALUES ('rue de bruxelles/65/5000/namur','forshen');

INSERT INTO Magasin (adresse, libelle)
	VALUES('rue du tilleul/125/1030/schaerbeek','karkace');
	
INSERT INTO Magasin (adresse, libelle)
	VALUES('rue de fourquepire/10/7890/ath','lepave');
	
/*Commercial*/

/*Lepave*/
INSERT INTO Commercial (nom, prenom, numTel, email, idMagasin)
	VALUES ('pool','christopher','0498562384','moot@forshen.com',1);
	
INSERT INTO Commercial (nom, prenom, numTel, email, idMagasin)
	VALUES ('reynolds','toby','0495632458','eggman@forshen.com',1);
	
INSERT INTO Commercial (nom, prenom, numTel, email, idMagasin)
	VALUES ('hyde','sam','0465987423','hyde@forshen.com',1);
/*Karkace*/
INSERT INTO Commercial (nom, prenom, numTel, email, idMagasin)
	VALUES ('denino','paul','0495682145','iceposeidon@karkace.be',2);
	
INSERT INTO Commercial (nom, prenom, numTel, email, idMagasin)
	VALUES ('dang','xavier','0498756982','mistermv@karkace.be',2);
	
INSERT INTO Commercial (nom, prenom, numTel, email, idMagasin)
	VALUES ('blevins','tyler','0495685450','ninja@karkace.be',2);
/*Dumortier*/
INSERT INTO Commercial (nom, prenom, numTel, email, idMagasin)
	VALUES ('pointud','nans','0498568213','boblennon@lepave.be',3);
	
INSERT INTO Commercial (nom, prenom, numTel, email, idMagasin)
	VALUES ('kjellberg','felix','0495681354','pewdiepie@lepave.be',3);

INSERT INTO Commercial (nom, prenom, numTel, email, idMagasin)
	VALUES ('hauchard','lucas','0495682156','squeezie@lepave.be',3);
	
/*Clients*/
INSERT INTO Clients (nom,prenom,numTel,email)
	VALUES ('milos','ricardo','0498568598','ricardo@client.be');
INSERT INTO Clients (nom,prenom,numTel,email)
	VALUES ('miller','george','0498568512','joji@client.be');
INSERT INTO Clients (nom,prenom,numTel,email)
	VALUES ('stanley','max','0498563215','maxmoefoe@client.be');
INSERT INTO Clients (nom,prenom,numTel,email)
	VALUES ('carter','ian','0496312589','idubbz@client.be');
	
/*FicheVehicule*/
INSERT INTO FicheVehicule (numChassis, dateMiseCircu, idModele)
	VALUES ('1235698789652', '2019-01-20',3);
INSERT INTO FicheVehicule (numChassis, dateMiseCircu, idModele)
	VALUES ('2569874569852', '2017-05-19',1);
INSERT INTO FicheVehicule (numChassis, dateMiseCircu, idModele)
	VALUES ('8954123654789', '2015-12-05',8);
INSERT INTO FicheVehicule (numChassis, dateMiseCircu, idModele)
	VALUES ('2365418954685', '2015-01-26',10);
	
/*Transaction*/
INSERT INTO Transactions (kilometrage,couleur,prixAchat,prixDepart,prixMin,nbProprios,description,dateArrivee,dureeGarantie,estTVARecup,prixVente,dateVente,etat, matricule, numChassis, idClient)
	VALUES(256800,'bleue',12568.23,18965.75,null,3,null,'2019-02-17',24,0,18965.75,'2019-03-23','vendue',1,'1235698789652',1);
INSERT INTO Transactions (kilometrage,couleur,prixAchat,prixDepart,prixMin,nbProprios,description,dateArrivee,dureeGarantie,estTVARecup,prixVente,dateVente,etat, matricule, numChassis, idClient)
	VALUES(156920,'rouge',15879.32,20568.89,18795.65,1,'belle voiture','2018-05-20',6,0,20568.89,'2018-05-21','vendue',4,'2569874569852',2);
INSERT INTO Transactions (kilometrage,couleur,prixAchat,prixDepart,prixMin,nbProprios,description,dateArrivee,dureeGarantie,estTVARecup,prixVente,dateVente,etat, matricule, numChassis, idClient)
	VALUES(140630,'noire',9856.15,13851.25,12589.63,null,null,'2019-03-26',12,1,13851.25,'2019-03-28','vendue',6,'8954123654789',3);
INSERT INTO Transactions (kilometrage,couleur,prixAchat,prixDepart,prixMin,nbProprios,description,dateArrivee,dureeGarantie,estTVARecup,prixVente,dateVente,etat, matricule, numChassis, idClient)
	VALUES(25000,'grise',35689.45,40896.57,null,2,null,'2018-07-25',18,1,40896.57,'2018-09-15','attente',2,'2365418954685',4);
