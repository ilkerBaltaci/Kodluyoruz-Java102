import java.util.*;
import java.util.stream.Collectors;

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
        for(HashMap<String, String> matchesWeekly : allFixture){
            System.out.println("Week-" + week);
            for(String homeOwner : matchesWeekly.keySet()){
                System.out.println(homeOwner + " vs " + matchesWeekly.get(homeOwner));
            }
            System.out.println();
            week++;
        }

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
            while(temp2 < matchNumberWeekly){
                List<MFixture> filteredData = tempFixtureList.stream().filter(mFixture -> (!weeklyAddedTeams.contains(mFixture.away)) && (!weeklyAddedTeams.contains(mFixture.homeOwner))).collect(Collectors.toList());
                Random rand = new Random();
                int index = 0;
                if(filteredData.size() > 1)
                {
                    index = rand.nextInt(filteredData.size());
                }

                MFixture OneMatch = filteredData.stream().skip(index).findFirst().get();
                weeklyAddedTeams.add(OneMatch.homeOwner);
                weeklyAddedTeams.add(OneMatch.away);
                matchesPerWeek.put(OneMatch.homeOwner, OneMatch.away);
                tempFixtureList.remove(OneMatch);

                temp2++;
            }
            HashMap<String, String> tempHashMap = new HashMap<>();
            tempHashMap.putAll(matchesPerWeek);
            allFixture.add(tempHashMap);
            matchesPerWeek.clear();
            weeklyAddedTeams.clear();
            week++;
            temp2=0;
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
