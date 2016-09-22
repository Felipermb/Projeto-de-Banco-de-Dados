package Modelo;

import Modelo.Jogador;
import Modelo.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-19T08:43:19")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> sigla;
    public static volatile SingularAttribute<Pais, Integer> idPais;
    public static volatile CollectionAttribute<Pais, Time> timeCollection;
    public static volatile SingularAttribute<Pais, String> nome;
    public static volatile CollectionAttribute<Pais, Jogador> jogadorCollection;

}