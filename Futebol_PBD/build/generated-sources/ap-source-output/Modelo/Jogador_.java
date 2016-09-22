package Modelo;

import Modelo.Pais;
import Modelo.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-19T08:43:19")
@StaticMetamodel(Jogador.class)
public class Jogador_ { 

    public static volatile SingularAttribute<Jogador, Pais> idPais;
    public static volatile SingularAttribute<Jogador, String> cpf;
    public static volatile SingularAttribute<Jogador, Integer> idJogador;
    public static volatile SingularAttribute<Jogador, String> nome;
    public static volatile SingularAttribute<Jogador, Time> idTime;

}