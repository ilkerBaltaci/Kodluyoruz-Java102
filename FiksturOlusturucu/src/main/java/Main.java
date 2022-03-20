import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        FixtureCreator fixtureCreator = new FixtureCreator();

        fixtureCreator.addTeam("Galatasaray");
        fixtureCreator.addTeam("Fenerbahçe");
        fixtureCreator.addTeam("Beşiktaş");
        fixtureCreator.addTeam("Tranbzonspor");
        fixtureCreator.addTeam("Bursaspor");

        fixtureCreator.showFixture();
    }
}
