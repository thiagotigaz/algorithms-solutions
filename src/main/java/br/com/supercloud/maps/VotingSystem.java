package br.com.supercloud.maps;

import java.util.*;
import java.util.stream.Collectors;

public class VotingSystem {

    static class Ballot {
        List<String> candidates;
        Integer votes;

        public Ballot(List<String> candidates, Integer votes) {
            this.candidates = candidates;
            this.votes = votes;
        }
    }

    static class Candidate {
        String name;
        Integer firstChoiceVotes = 0;
        final List<Ballot> firstChoiceBallots = new LinkedList<>();
        final List<Ballot> ballots = new LinkedList<>();

        public Candidate(String name) {
            this.name = name;
        }
    }

    final List<Ballot> ballots;
    final TreeSet<Candidate> candidates = new TreeSet<>((o1, o2) -> {
        if (o1.firstChoiceVotes.equals(o2.firstChoiceVotes)) {
            return o1.name.compareTo(o2.name);
        }
        return o1.firstChoiceVotes > o2.firstChoiceVotes ? 1 : -1;
    });
    final Map<String, Candidate> candidatesMap = new HashMap<>();

    Integer totalVotes = 0;
    boolean ballotsProcessed;
    Candidate popularWinner;
    Candidate rankerWinner;

    public VotingSystem(Map<List<String>, Integer> ballots) {
        this.ballots = ballots.entrySet().stream()
                .map(e -> new Ballot(new LinkedList<>(e.getKey()), e.getValue()))
                .collect(Collectors.toList());
    }

    private void processBallots() {
        for (Ballot b : ballots) {
            totalVotes += b.votes;
            for (int i = 0; i < b.candidates.size(); i++) {
                String candidateName = b.candidates.get(i);
                Candidate candidate = getOrCreateCandidate(candidateName);
                if (i == 0) {
                    candidate.firstChoiceVotes += b.votes;
                    candidate.firstChoiceBallots.add(b);
                } else {
                    candidate.ballots.add(b);
                }
            }
        }
        candidates.addAll(candidatesMap.values());
        popularWinner = candidates.last();

        if (popularWinner.firstChoiceVotes > totalVotes / 2) {
            rankerWinner = popularWinner;
        } else {
            while (rankerWinner == null && candidates.size() > 1) {
                Candidate leastVoted = candidates.first();
                candidates.remove(leastVoted);
                candidatesMap.remove(leastVoted.name);
                System.out.println("Removing the least voted " + leastVoted.name + " with " + leastVoted.firstChoiceVotes + " out of " + totalVotes);
                for (Ballot b : leastVoted.firstChoiceBallots) {
                    b.candidates.remove(0);
                    String firstChoiceName = b.candidates.get(0);
                    Candidate firstChoiceCandidate = candidatesMap.get(firstChoiceName);
                    firstChoiceCandidate.firstChoiceVotes += b.votes;
                    firstChoiceCandidate.firstChoiceBallots.add(b);
                    if (b.candidates.contains(firstChoiceName)) {
                        firstChoiceCandidate.ballots.remove(b);
                    }
                    candidates.remove(firstChoiceCandidate);
                    candidates.add(firstChoiceCandidate);
                }
                for (Ballot b : leastVoted.ballots) {
                    b.candidates.remove(leastVoted.name);
                }
                if (candidates.last().firstChoiceVotes > totalVotes / 2) {
                    break;
                }
            }
            rankerWinner = candidates.last();
        }
        ballotsProcessed = true;
    }

    private Candidate getOrCreateCandidate(String candidateName) {
        if (candidatesMap.containsKey(candidateName)) {
            return candidatesMap.get(candidateName);
        } else {
            Candidate candidate = new Candidate(candidateName);
            candidatesMap.put(candidateName, candidate);
            return candidate;
        }
    }

    public Candidate getPopularWinner() {
        if (!ballotsProcessed) {
            processBallots();
        }
        System.out.println("The popular winner is " + popularWinner.name + " with " + popularWinner.firstChoiceVotes + " out of " + totalVotes);
        return popularWinner;
    }

    public Candidate getRankedWinner() {
        if (!ballotsProcessed) {
            processBallots();
        }
        System.out.println("The rankerWinner is " + rankerWinner.name + " with " + rankerWinner.firstChoiceVotes + " out of " + totalVotes);
        return rankerWinner;
    }

    public static void main(String[] args) {
        Map<List<String>, Integer> ballots = new HashMap<List<String>, Integer>() {{
            put(Arrays.asList("A", "B", "C"), 4);
            put(Arrays.asList("B", "C", "A"), 3);
            put(Arrays.asList("C", "B", "A"), 2);
            put(Arrays.asList("C", "A", "B"), 3);
        }};

        VotingSystem votingSystem = new VotingSystem(ballots);
        System.out.println(votingSystem.getPopularWinner().name);
        System.out.println(votingSystem.getRankedWinner().name);
        System.out.println(votingSystem.getPopularWinner().name);
    }
}
