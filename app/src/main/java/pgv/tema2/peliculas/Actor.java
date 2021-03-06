package pgv.tema2.peliculas;

public class Actor {
    private int id;
    private String name;
    private String character;
    private String profile_path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public Actor(int id, String name, String character, String profile_path) {
        this.id = id;
        this.name = name;
        this.character = character;
        this.profile_path = profile_path;
    }
}
