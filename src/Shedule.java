import java.util.*;

public class Shedule  {
    Set<Seance> seances = new TreeSet<>();


    public void  addSeance(){
        Seance seance = GetWhatYouNeed.getSeance();
        if (seance.startTime.compareTo(Cinema.open)==0 & seance.startTime.compareTo(Cinema.close)==1)
        {seances.add(seance);}
        else System.out.println("The seance can`t start before the cinema opens or the last seance must start before the cinema closes. Sorry, chose another time ");
    }



    public void  removeSeance(){
        Seance seance = GetWhatYouNeed.getSeance();
        if (seances.contains(seance)){
            seances.remove(seance);
            System.out.println("Seance has just successfully  deleted");
        }
        else System.out.println("Can`t find this seance. Sorry");

    }


}
