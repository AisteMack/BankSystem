/*
Trigerių sukūrimas banko duombazei
Aistė Mackevičiūtė
Informatika IIIk.
*/
	
--Patikrina ar pakankamas pinigų likutis sąskaitoje
CREATE FUNCTION aima3213.arUztenkaPinigu() RETURNS "trigger" AS $$
DECLARE likutis DECIMAL(31, 3);
    BEGIN

        SELECT A.pinigulikutis+A.kreditas INTO likutis FROM aima3213.saskaita as A, aima3213.transakcija
              WHERE A.nr = NEW.siuntejosasnr;

        
        IF NEW.siuntejosasnr IS NOT NULL AND NEW.gavejosasnr IS NOT NULL AND likutis < NEW.suma
            THEN RAISE EXCEPTION 'Nepakankamas likutis pinigu saskaitoje!';
        END IF;
        RETURN NEW;
    END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER piniguLikutis
    BEFORE INSERT OR UPDATE ON aima3213.transakcija
    FOR EACH ROW EXECUTE PROCEDURE aima3213.arUztenkaPinigu();
	
	
--Patikrina ar nekeičiamas sąskaitos nr		
CREATE FUNCTION aima3213.kaKeiciam() RETURNS "trigger" AS $$
    BEGIN

        if(SELECT count(*) FROM aima3213.saskaita as A WHERE NEW.nr = A.nr) = 0 

            THEN RAISE EXCEPTION 'Saskaitos numerio negalima keisti!';
        END IF;
        RETURN NEW;
    END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER sasNrKeitimas
    BEFORE UPDATE ON aima3213.saskaita
    FOR EACH ROW EXECUTE PROCEDURE aima3213.kaKeiciam();	

--Patikrina ar bankas turi klientą prieš kūriant jam saskaitą
CREATE FUNCTION aima3213.arYraKlientas() RETURNS "trigger" AS $$

    BEGIN

        IF (SELECT count(A.nr) FROM aima3213.prisijungimoDuomenys as A
              WHERE A.zmogus = NEW.savininkas AND A.bankas = NEW.bankas) = 0

            THEN RAISE EXCEPTION 'Sis zmogus nera banko klientas';
        END IF;
        RETURN NEW;
    END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER KlientoPaieska
    BEFORE INSERT OR UPDATE ON aima3213.saskaita
    FOR EACH ROW EXECUTE PROCEDURE aima3213.arYraKlientas();	

--Prieš naikinant žmogų patikrina ar jis turi sąskaitų
CREATE FUNCTION aima3213.arYraSaskaita() RETURNS "trigger" AS $$

    BEGIN

        IF (SELECT count(A.nr) FROM aima3213.saskaita as A
              WHERE A.savininkas = OLD.ak) > 0

            THEN RAISE EXCEPTION 'Sis zmogus turi saskaitu banke';
        END IF;
        RETURN OLD;
    END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER KlientoSaskaita
    BEFORE DELETE ON aima3213.zmogus
    FOR EACH ROW EXECUTE PROCEDURE aima3213.arYraSaskaita();

--Patikrina ar prisijungimo duomenys yra naudojami    
CREATE FUNCTION aima3213.arNaudojami() RETURNS "trigger" AS $$

    BEGIN

        IF (SELECT count(A.nr) FROM aima3213.saskaita as A
              WHERE A.savininkas = OLD.zmogus) > 0

            THEN RAISE EXCEPTION 'Prisijungimo duomenys yra naudojami! Ju pasalinti negalima';
        END IF;
        RETURN OLD;
    END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER ZmogausDuomenys
    BEFORE DELETE ON aima3213.prisijungimoDuomenys
    FOR EACH ROW EXECUTE PROCEDURE aima3213.arNaudojami();    		
	
	
	
	