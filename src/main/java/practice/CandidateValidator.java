package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate>{
    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraine(candidate);
    }

    private boolean periodInUkraine(Candidate candidate) {
        int years;
        String[] split = candidate.getPeriodsInUkr().split("-");
        years = Integer.parseInt(split[1]) - Integer.parseInt(split[0]);
        return years >= 10;
    }
}
