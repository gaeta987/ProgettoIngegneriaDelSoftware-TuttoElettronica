DROP database IF EXISTS tuttoElettronica;
CREATE database tuttoElettronica;
USE tuttoElettronica;

DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (	
  username varchar(30),
  indirizzo varchar(100),
  cf char(16) primary key,
  nome varchar(20) not null,
  cognome varchar(20) not null,
  ruolo varchar(50) not null,
  password varchar(30)not null,
  email varchar(50) not null
);

DROP TABLE IF EXISTS clienteRegistrato;

CREATE TABLE clienteRegistrato (	
  cfClienteRegistrato varchar(16) primary key,
  foreign key (cfClienteRegistrato) references cliente(cf)
);

DROP TABLE IF EXISTS amministratoreGenerale;

CREATE TABLE amministratoreGenerale (	
  cfAmm varchar(16) primary key,
  foreign key (cfAmm) references cliente(cf)
);

DROP TABLE IF EXISTS gestore;

CREATE TABLE gestore (	
  cfGestore varchar(16) primary key,
  ruolo varchar(50),
  foreign key (cfGestore) references cliente(cf)
);

DROP TABLE IF EXISTS gestoreProdotti;

CREATE TABLE gestoreProdotti (	
  cfGestoreP varchar(16) primary key,
  foreign key (cfGestoreP) references gestore(cfGestore)
);

DROP TABLE IF EXISTS gestoreRiparazioni;

CREATE TABLE gestoreRiparazioni (	
  cfGestoreR varchar(16) primary key,
  data1 date,
  data2 date,
  data3 date,
  foreign key (cfGestoreR) references gestore(cfGestore)
);


DROP TABLE IF EXISTS prodotto;

CREATE TABLE prodotto (	
  codice int primary key AUTO_INCREMENT,
  nome varchar(150) not null,
  categoria varchar(20) not null,
  prezzo double not null,
  marca varchar(29),
  descrizione varchar(500),
  immagine varchar(300)
)AUTO_INCREMENT=0;

DROP TABLE IF EXISTS prodottoInMagazzino;
CREATE TABLE prodottoInMagazzino(
 idPM int primary key,
 promo boolean,
 quantitaInMagazzino int,
 quantitaNelCarrello int,
 foreign key (idPM) REFERENCES prodotto(codice)
);

DROP TABLE IF EXISTS prodottoInRiparazione;
CREATE TABLE prodottoInRiparazione(
 idPR int not null,
 idPrenotazioneRiparazione int primary key AUTO_INCREMENT,
 dataIncontro date,
 cfCliente varchar(16),
 statoRiparazione varchar(255),
 descrizioneProblema varchar(255),
 foreign key (idPR) REFERENCES prodotto(codice),
 foreign key (cfCliente) REFERENCES cliente(cf)
)AUTO_INCREMENT=0;

DROP TABLE IF EXISTS prodottoPrenotato;
CREATE TABLE prodottoPrenotato(
 idPrenotazioneProdotto int primary key AUTO_INCREMENT,
 idP int not null,
 cfCliente varchar(16),
 dataPrenotazione date,
 quantitaPrenotata int,
 foreign key (idP) REFERENCES prodotto(codice),
 foreign key (cfCliente) REFERENCES cliente(cf)
)AUTO_INCREMENT=0;


DROP TABLE IF EXISTS recensioni;

CREATE TABLE recensioni (	
	id int not null AUTO_INCREMENT,
	cf_cliente varchar(16),
    cod_merce int,
    testo varchar(500),
    voto int,
    primary key(id),
    foreign key (cod_merce) REFERENCES prodotto(codice),
    foreign key (cf_cliente) REFERENCES cliente(cf)
)AUTO_INCREMENT=0;

DROP TABLE IF EXISTS carrello;

CREATE TABLE carrello (	
	idCarrello int not null AUTO_INCREMENT,
	cf_cliente varchar(16),
    listaProdotti varchar(255),
    primary key(idCarrello)
)AUTO_INCREMENT=0;

INSERT INTO PRODOTTO (nome,categoria,prezzo,marca,descrizione,immagine) VALUES ("arduino UNO", "arduino", "10", "arduino", "ciao sono arduino", "arduino.jpg");
INSERT INTO PRODOTTOINMAGAZZINO (idPM, promo, quantitainmagazzino, quantitanelcarrello) VALUES (1,false, 10, 0);
INSERT INTO PRODOTTO (nome,categoria,prezzo,marca,descrizione,immagine) VALUES ("arduino UNO", "arduino", "10", "arduino", "ciao sono arduino", "arduino.jpg");
INSERT INTO PRODOTTOINMAGAZZINO (idPM, promo, quantitainmagazzino, quantitanelcarrello) VALUES (2, TRUE, 10, 0);
INSERT INTO PRODOTTO (nome,categoria,prezzo,marca,descrizione,immagine) VALUES ("arduino UNO", "arduino", "10", "arduino", "ciao sono arduino", "arduino.jpg");
INSERT INTO PRODOTTOINMAGAZZINO (idPM, promo, quantitainmagazzino, quantitanelcarrello) VALUES (3, TRUE, 10, 0);

INSERT INTO CLIENTE (username, indirizzo, cf, nome, cognome, ruolo, password, email) VALUES ("ggg", "via roma", "CMMGTN80A01C361Z", "Gaetano", "Cimmino", "cliente", "ggg123", "gaetano@gmail.com");

INSERT INTO CLIENTE (username, indirizzo, cf, nome, cognome, ruolo, password, email) VALUES ("bbb", "via roma", "CMNGTN80A01C361Z", "Gaetano", "Cimino", "gestoreRiparazioni", "ggg123", "gaetano@gmail.com");
INSERT INTO gestore(cfGestore, ruolo) VALUES ("CMNGTN80A01C361Z", "gestoreRiparazioni");
INSERT INTO gestoreRiparazioni(cfGestoreR, data1, data2, data3) VALUES ("CMNGTN80A01C361Z", "2019/01/30", "2019/02/5", "2019/02/25");