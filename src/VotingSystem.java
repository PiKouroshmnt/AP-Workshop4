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

    public void printResults(int index) {
        votingList.get(index).printResult();
    }

    public void printVoters(int index) {
        votingList.get(index).printVoters();
    }

    public void printVoting(int index) {
        Voting voting = votingList.get(index);
        ArrayList<String> choices = voting.getChoices();
        Iterator<String> it = choices.iterator();
        System.out.println("Question: " + voting.getQuestion() + "\n");
        for(int i = 0;it.hasNext();i++){
            System.out.println(i+1 + ". " + it.next());
        }
    }

    public void vote(int index, Person voter, ArrayList<String> voterChoices) {
        votingList.get(index).vote(voter,voterChoices);
    }

    public void vote(int index, Person person) {
        votingList.get(index).vote(person);
    }
}
