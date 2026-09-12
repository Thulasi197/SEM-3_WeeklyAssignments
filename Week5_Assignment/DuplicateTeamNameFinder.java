public class DuplicateTeamNameFinder {

    static String findDuplicateTeam(String[] teams) {
        for (int i = 0; i < teams.length; i++)
            for (int j = i + 1; j < teams.length; j++)
                if (teams[i].equals(teams[j]))
                    return "Duplicate Found: " + teams[i];

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] teams = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teams));
    }
}