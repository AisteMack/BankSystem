/*
Lenteliø sukûrimas banko duombazei
Aistë Mackevièiûtë
Informatika IIIk.
*/

CREATE TABLE aima3213.Zmogus
(
	AK CHAR(11) NOT NULL PRIMARY KEY,
	Vardas VARCHAR(32) NOT NULL,
	Pavarde VARCHAR(32) NOT NULL,
	TelNumeris CHAR(12) NOT NULL,
	ElPastas VARCHAR(32),
	CONSTRAINT checkMail CHECK (ElPastas ~* '^[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$')
);


CREATE TABLE aima3213.Bankas(
	Nr SERIAL NOT NULL PRIMARY KEY,
	Pavadinimas CHAR(20) NOT NULL CONSTRAINT RaktasPavadinimo UNIQUE,
	Adresas CHAR(30) NOT NULL
);

CREATE TABLE aima3213.PrisijungimoDuomenys
(
	Nr SERIAL NOT NULL PRIMARY KEY,
	Slaptazodis VARCHAR(32) NOT NULL,
	PrisijungimoVardas VARCHAR(16) NOT NULL CONSTRAINT RaktasVardo UNIQUE,
	Zmogus CHAR(11) NOT NULL,
	Bankas Integer NOT NULL,
	FOREIGN KEY(Zmogus) REFERENCES aima3213.Zmogus ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(Bankas) REFERENCES aima3213.Bankas ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE aima3213.Saskaita
(
	Nr CHAR(20) NOT NULL PRIMARY KEY,
	Tipas CHAR(10) NOT NULL DEFAULT 'DEBETINE',
	Bankas Integer NOT NULL,
	Savininkas CHAR(11) NOT NULL,
	PiniguLikutis DECIMAL(31, 3) NOT NULL CHECK (PiniguLikutis >= 0),
	Kreditas DECIMAL(31, 3) CHECK (Kreditas >= 0) DEFAULT 0,
	CONSTRAINT SasTipai CHECK(Tipas IN ('Debetine', 'Kreditine', 'Taupomoji')),
	--CONSTRAINT SasNeKreditine CHECK(Tipas IN ('Debetine', 'Taupomoli') OR Kreditas = NULL),
	FOREIGN KEY(Bankas) REFERENCES aima3213.Bankas ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY(Savininkas) REFERENCES aima3213.Zmogus ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE aima3213.Transakcija
(
	Nr SERIAL NOT NULL PRIMARY KEY,
	Suma DECIMAL(31, 3) NOT NULL CHECK (Suma > 0),
	GavejoSasNr CHAR(20),
	SiuntejoSasNr CHAR(20),
	FOREIGN KEY(GavejoSasNr) REFERENCES aima3213.Saskaita ON DELETE SET NULL ON UPDATE CASCADE,
	FOREIGN KEY(SiuntejoSasNr) REFERENCES aima3213.Saskaita ON DELETE SET NULL ON UPDATE CASCADE
);
