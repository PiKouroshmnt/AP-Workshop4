import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        //creating each voting's choices...
        ArrayList<String> choicesForFirstVoting = new ArrayList<>();
        choicesForFirstVoting.add("first option.");
        choicesForFirstVoting.add("second option?");
        choicesForFirstVoting.add("third option!!");
        ArrayList<String> choicesForSecondVoting = new ArrayList<>();
        choicesForSecondVoting.add("YES");
        choicesForSecondVoting.add("NO");
        ArrayList<String> choicesForThirdVoting = new ArrayList<>();
        choicesForThirdVoting.add("0%-25%");
        choicesForThirdVoting.add("26%-50%");
        choicesForThirdVoting.add("51%-75%");
        choicesForThirdVoting.add("76%-100%");

        //create votings in our votingSystem object
        votingSystem.createVoting("test question??",false,1,choicesForFirstVoting);
        votingSystem.createVoting("Do you like programming?",false,0,choicesForSecondVoting);
        votingSystem.createVoting("how much has AP class been useful to you?",false,0,choicesForThirdVoting);

        //create different persons to participate in our votes
        Person ali = new Person("Ali","Smith");
        Person james = new Person("James","McGill");
        Person hosein = new Person("Hosein","NimaPoor");
        Person martin = new Person("Martin" , "Odegaard");
        Person diana = new Person("Diana" , "BurnWood");

        //vote using our Person objects...
        ArrayList<String> martinAnsweringFirstQuestion = new ArrayList<>();
        martinAnsweringFirstQuestion.add("first option.");
        martinAnsweringFirstQuestion.add("third option!!");
        ArrayList<String> dianaAnsweringFirstQuestion = new ArrayList<>();
        dianaAnsweringFirstQuestion.add("second option?");
        dianaAnsweringFirstQuestion.add("third option!!");
        ArrayList<String> aliAnsweringSecondQuestion = new ArrayList<>();
        aliAnsweringSecondQuestion.add("YES");
        ArrayList<String> jamesAnsweringSecondQuestion = new ArrayList<>();
        jamesAnsweringSecondQuestion.add("NO");
        ArrayList<String> martinAnsweringSecondQuestion = new ArrayList<>();
        martinAnsweringSecondQuestion.add("YES");
        ArrayList<String> aliAnsweringThirdQuestion = new ArrayList<>();
        aliAnsweringThirdQuestion.add("51%-75%");
        ArrayList<String> hoseinAnsweringThirdQuestion = new ArrayList<>();
        hoseinAnsweringThirdQuestion.add("76%-100%");

        //adding the votes to our votingSystem object...
        votingSystem.vote(0,martin,martinAnsweringFirstQuestion);
        votingSystem.vote(0,diana,dianaAnsweringFirstQuestion);
        votingSystem.vote(1,ali,aliAnsweringSecondQuestion);
        votingSystem.vote(1,james,jamesAnsweringSecondQuestion);
        votingSystem.vote(1,martin,martinAnsweringSecondQuestion);
        votingSystem.vote(2,ali,aliAnsweringThirdQuestion);
        votingSystem.vote(2,hosein,hoseinAnsweringThirdQuestion);

        //printing results...
        for (int i = 0; i < votingSystem.getVotingList().size(); i++) {
            System.out.println("---------------------\n");
            votingSystem.printVoting(i);
            System.out.println("\nVoters:------------\n");
            votingSystem.printVoters(i);
            System.out.println("\nResults:-----------\n");
            votingSystem.printResults(i);
            System.out.println();
        }
    }
}