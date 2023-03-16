import java.util.*;

public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters;
    private HashMap<String , HashSet<Vote>> choices;
    private boolean isAnonymous;
    public Voting(int type, String question, boolean isAnonymous){
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        choices = new HashMap<>();
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
    public ArrayList<String> getChoices(){
        ArrayList<String> choicesArrayList = new ArrayList<>();
        for (String choiceInChoicesList : choices.keySet()) {
            choicesArrayList.add(choiceInChoicesList);
        }
        return choicesArrayList;
    }
    public void createChoice(String choice){
        //create an empty Hashset for this new choice`s value. (Choice is key and the empty HashSet is value)
        HashSet<Vote> voters = new HashSet<>();
        choices.put(choice, voters);
    }
    public void vote (Person voter, ArrayList<String> voterChoices) {
        //Check for anonymous Voting
        if (!isAnonymous) {
            //creat a Hashset and add voter`s vote to this set to avoid duplicate choices.
            HashSet<String> voterVotes = new HashSet<>();
            for (String vote : voterChoices) {
                voterVotes.add(vote);
            }
            //create votes from elements in voterVotes HashSet
            for (String vote : voterVotes) {
                //check if choice exist in choices
                if (choices.containsKey(vote)) {
                    Vote voterVote = new Vote(voter, new Date().toString());
                    choices.get(vote).add(voterVote);
                } else {
//                 this commented code can be used when that voting could accept any choices, even that choice doesn`t exist in choices
//                 Vote voterVote = new Vote(voter, new Date().toString());
//                 HashSet<Vote> votes = new HashSet<>();
//                 votes.add(voterVote);
//                 choices.put(vote ,votes);
                    System.out.println("Choice not exist");
                }
            }
        }
    }
    public void vote (Person person){
        if(isAnonymous){
            int randomNumber;
            randomNumber = new Random().nextInt(choices.size());
            int counter = 0;
            for (String choice : choices.keySet()){
                if(randomNumber == counter){
                    Vote vote = new Vote(person, new Date().toString());
                    choices.get(choice).add(vote);
                    break;
                }
                else
                    counter++;
            }
        }

    }
    public void printResult(){
        for(String choiceInChoicesMap : choices.keySet()){
            System.out.println("Choice: " + choiceInChoicesMap + " has: " + choices.get(choiceInChoicesMap).size() + " Votes");
        }
    }

    public void printVoters(){
        if(!isAnonymous){
            for(String choiceInChoicesMap : choices.keySet()){
                System.out.println("Choice: " + choiceInChoicesMap + " :\n");
                for(Vote vote : choices.get(choiceInChoicesMap)){
                    System.out.println(vote.getVoter().toString());
                }
                System.out.println();
            }
        }
    }



}
