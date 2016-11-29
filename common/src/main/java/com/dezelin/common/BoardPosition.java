package com.dezelin.common;

/**
 * Created by dezelin on 28.11.16..
 */

public interface BoardPosition {
    public void put(Chessman chessman);
    public Chessman remove(Chessman.File file, Chessman.Rank rank);
    public Chessman get(Chessman.File file, Chessman.Rank rank);
}
