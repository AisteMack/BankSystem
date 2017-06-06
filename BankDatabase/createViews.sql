/*
Virtualiø lenteliø sukûrimas banko duombazei
Aistë Mackevièiûtë
Informatika IIk.
*/

CREATE VIEW aima3213.BankoSaskaitos AS
	SELECT pavadinimas, COUNT(*) FROM aima3213.bankas AS A, aima3213.saskaita AS B
	WHERE A.nr = B.bankas
	GROUP BY pavadinimas;
		
CREATE VIEW aima3213.ZmogausPavedimai AS
	SELECT vardas, pavarde, siuntejosasnr, COUNT(*) AS "Pavedimu skaicius", SUM(suma) as "Pervesta pinigu"
	FROM aima3213.zmogus AS A, aima3213.saskaita AS B, aima3213.transakcija AS C
	WHERE A.ak = B.savininkas AND B.nr = C.siuntejosasnr
	GROUP BY vardas, pavarde, siuntejosasnr;
	
CREATE VIEW aima3213.ZmogausSaskaitos AS
	SELECT vardas, pavarde, nr AS "Saskaitos numeris" 
	FROM aima3213.saskaita AS A, aima3213.zmogus AS B
	WHERE A.savininkas = B.ak;
