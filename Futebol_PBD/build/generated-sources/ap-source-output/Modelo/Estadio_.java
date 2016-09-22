package Modelo;

import Modelo.Jogo;
import Modelo.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-19T08:43:19")
@StaticMetamodel(Estadio.class)
public class Estadio_ { 

    public static volatile CollectionAttribute<Estadio, Jogo> jogoCollection;
    public static volatile SingularAttribute<Estadio, Integer> idEstadio;
    public static volatile CollectionAttribute<Estadio, Time> timeCollection;
    public static volatile SingularAttribute<Estadio, String> nome;
    public static volatile SingularAttribute<Estadio, Double> publico;

}