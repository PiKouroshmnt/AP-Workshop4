import java.util.*;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem() {
        votingList = new ArrayList<>();
    }

    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {
        Voting temp = new Voting(type,question,isAnonymous);
        Iterator<String> it = choices.iterator();
        while(it.hasNext()) {
            temp.createChoice(it.next());
        }
        votingList.add(temp);
    }

    public Voting getVoting(int index) {
        return votingList.get(index);
    }

    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotingSystem that = (VotingSystem) o;
        return Objects.equals(votingList, that.votingList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votingList);
    }
}
