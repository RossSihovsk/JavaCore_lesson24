import java.util.*;

public class Cinema {

    TreeMap<Days, Shedule> schedules = new TreeMap<>();


    static Time open;
    static Time close;


    Cinema() {
        Arrays.stream(Days.values()).forEach(d->schedules.put(d,new Shedule()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Open time ");
        open = GetWhatYouNeed.getTime();
        System.out.println("Ending time: ");
        close = GetWhatYouNeed.getTime();
    }

    void getAllMovies(){
        //Movie library is  formed on the basis of all films which has benn going during the week
        HashSet<String> movieLibrary = new HashSet<>();
        Arrays.stream(Days.values()).forEach(day->{
            Shedule schedule = schedules.get(day);
            schedule.seances.forEach(seance->{
                movieLibrary.add(seance.movie.getTitle());
            });
        });
        movieLibrary.forEach(System.out::println);
    }

    void getScheduleForDay(){
        try{
        String day = GetWhatYouNeed.getDay();
        Shedule schedule = schedules.get(Days.valueOf(day.toUpperCase()));
        schedule.seances.forEach(System.out::println);}
        catch (IllegalArgumentException exception){
            System.out.println("You entered the day wrong. Try again please");
        }
    }

    void addSeance ( ) {
        String day = GetWhatYouNeed.getDay();
        try {
            Shedule schedule = schedules.get(Days.valueOf(day.toUpperCase()));
            schedule.addSeance();
        }
        catch (IllegalArgumentException exception){
            System.out.println("You entered the day wrong. Try again please");
        }

    }


    void removeMovie() {
        System.out.println("You are going to delete all seances with some movie.\nYou also " +
                "will delete this film from library");
        Movie movie = GetWhatYouNeed.getMovie();
        schedules.values().forEach((schedule) ->
                schedule.seances.removeIf(seance -> seance.movie.getTitle().equalsIgnoreCase(movie.getTitle())));
    }


    void removeSeance ( String day) {
        try {
        schedules.get(Days.valueOf(day.toUpperCase())).removeSeance();
        }
        catch (IllegalArgumentException exception){
            System.out.println("You entered the day wrong. Try again please");
        }
    }

}