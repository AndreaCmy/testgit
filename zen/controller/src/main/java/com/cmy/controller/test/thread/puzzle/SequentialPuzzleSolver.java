package com.cmy.controller.test.thread.puzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mengyingc on 2017/4/14.
 */
public class SequentialPuzzleSolver<P,M> {
    private final Puzzle<P,M> pmPuzzle;
    private final Set<P> seen = new HashSet<>();

    public SequentialPuzzleSolver(Puzzle<P,M> puzzle){
        this.pmPuzzle = puzzle;
    }

    public List<M> solve(){
        P pos = pmPuzzle.initialPosition();
        return search(new Node<P,M>(pos, null, null));
    }

    private List<M> search(Node<P, M> pmNode) {
        if(!seen.contains(pmNode.pos)){
            seen.add(pmNode.pos);
            if(pmPuzzle.isGoal(pmNode.pos){
                return pmNode.asMoveList();
            }
            for(M move:pmPuzzle.legalMoves(pmNode.pos)){
                P pos = pmPuzzle.move(pmNode.pos, move);
                Node<P,M> child = new Node<P, M>(pos, move, pmNode);
                List<M> result = search(child);
                if(result != null){
                    return  result;
                }
            }
        }
        return null;
    }
}
