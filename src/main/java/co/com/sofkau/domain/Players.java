package co.com.sofkau.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Jugadores")
public class Players {
    private final String name;
    private final Integer age;
    private final String icon;
    private final String national;
    private final Integer winners;
    private final Integer games;
    private final String club;
    @Id
    private String id;

    public Players(String name, Integer age, String icon, String national, Integer winners, Integer games, String club) {
        this.name = name;
        this.age = age;
        this.icon = icon;
        this.national = national;
        this.winners = winners;
        this.games = games;
        this.club = club;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getIcon() {
        return icon;
    }

    public String getNational() {
        return national;
    }

    public Integer getWinners() {
        return winners;
    }

    public Integer getGames() {
        return games;
    }

    public String getClub() {
        return club;
    }

    @Override
    public String toString() {
        return "Players{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", icon='" + icon + '\'' +
                ", national='" + national + '\'' +
                ", winners=" + winners +
                ", games=" + games +
                ", club='" + club + '\'' +
                '}';
    }
}
