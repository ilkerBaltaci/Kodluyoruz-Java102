import java.util.*;
import java.util.stream.Stream;

public class FixtureCreator {
    private List<String> teams;
    private List<MFixture> fixtureList;
    private List<HashMap<String, String>> allFixture;

    public FixtureCreator() {
        this.fixtureList = new ArrayList<MFixture>();
        this.teams = new ArrayList<String>();
        //Bu liste tüm haftalık müsabakaları liste olarak tutuyor.
        this.allFixture = new ArrayList<HashMap<String, String>>();
    }

    public void showFixture()
    {
        adjustAllFixture();
        int week = 1;

    }

    private void adjustAllFixture()
    {
        fillFixtureList();

        int matchNumberWeekly = teams.size() / 2;
        int lengthOfFixtureWeek = fixtureList.size() / matchNumberWeekly;
        List<String> weeklyAddedTeams = new ArrayList<>();
        HashMap<String, String> matchesPerWeek = new HashMap<>();
        List<MFixture> tempFixtureList = fixtureList;
        int matchNumber = fixtureList.size();

        int week = 0;
        int temp2 = 0;

        while(week < lengthOfFixtureWeek) {
            while(temp2 <= matchNumberWeekly){
                Stream<MFixture> filteredData = tempFixtureList.stream().filter(mFixture -> !weeklyAddedTeams.contains(mFixture.away) && !weeklyAddedTeams.contains(mFixture.homeOwner));
                Random rand = new Random();
                filteredData.findAny();
                MFixture match = tempFixtureList.get(rand.nextInt((int) filteredData.count()));
                if(weeklyAddedTeams.contains(match.homeOwner) ||
                        weeklyAddedTeams.contains(match.away)){
                    continue;
                }
                weeklyAddedTeams.add(match.homeOwner);
                weeklyAddedTeams.add(match.away);
                tempFixtureList.remove(match);
                matchesPerWeek.put(match.homeOwner, match.away);
                matchNumber--;
                temp2++;
            }
            allFixture.add(matchesPerWeek);
            week++;
        }




    }

    public String addTeam(String team)
    {
        teams.add(team);
        return team;
    }

    private void fillFixtureList()
    {
        if(teams.size() % 2 == 1){
            teams.add("Bay");
        }
        for(String owner : teams){
            for(String away : teams){
                if(owner.equals(away)){
                    continue;
                }
                fixtureList.add(new MFixture(owner, away));
            }
        }
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }
}
