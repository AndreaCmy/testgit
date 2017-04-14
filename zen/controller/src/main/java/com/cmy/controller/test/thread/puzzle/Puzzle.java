package com.cmy.controller.test.thread.puzzle;

import java.util.Set;

/**
 * Created by mengyingc on 2017/4/14.
 */
public interface Puzzle<P,M> {
    P initialPosition();
    boolean isGoal(P position);
    Set<M> legalMoves(P position);
    P move(P position, M move);
}
