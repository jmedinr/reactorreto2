package co.com.sofkau.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "players")
public class Players {
    @Id
    private String id;

    private String name;
    private Integer age;
    private String icon;
    private String national;
    private Integer winners;
    private Integer games;
    private String club;

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
