package Modelo;

import Modelo.Estadio;
import Modelo.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-19T08:43:19")
@StaticMetamodel(Jogo.class)
public class Jogo_ { 

    public static volatile SingularAttribute<Jogo, String> placar;
    public static volatile SingularAttribute<Jogo, Estadio> idEstadio;
    public static volatile SingularAttribute<Jogo, Integer> idJogo;
    public static volatile SingularAttribute<Jogo, Date> dataJogo;
    public static volatile SingularAttribute<Jogo, Time> idTime1;
    public static volatile SingularAttribute<Jogo, Time> idTime2;

}