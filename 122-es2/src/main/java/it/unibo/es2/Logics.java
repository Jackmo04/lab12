package it.unibo.es2;

public interface Logics {

    /**
     * Returns the new value that should be displayed om the specified button
     * @param position the position of the pressed button
     * @return the new value the button should bisplay
     */
    String hit(Pair<Integer, Integer> position);

    /**
     * Checks wether the app should quit
     * @return true if is to quit
     */
    boolean toQuit();
}
