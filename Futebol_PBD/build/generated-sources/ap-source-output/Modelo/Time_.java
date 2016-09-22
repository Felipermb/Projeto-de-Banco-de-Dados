package Modelo;

import Modelo.Estadio;
import Modelo.Jogador;
import Modelo.Jogo;
import Modelo.Pais;
import Modelo.Tecnico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-19T08:43:19")
@StaticMetamodel(Time.class)
public class Time_ { 

    public static volatile SingularAttribute<Time, String> sigla;
    public static volatile CollectionAttribute<Time, Jogo> jogoCollection;
    public static volatile SingularAttribute<Time, Pais> idPais;
    public static volatile SingularAttribute<Time, Estadio> idEstadio;
    public static volatile SingularAttribute<Time, String> nome;
    public static volatile CollectionAttribute<Time, Tecnico> tecnicoCollection;
    public static volatile CollectionAttribute<Time, Jogo> jogoCollection1;
    public static volatile CollectionAttribute<Time, Jogador> jogadorCollection;
    public static volatile SingularAttribute<Time, Integer> idTime;

}