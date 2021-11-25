import biuoop.DrawSurface;
/**
 * the Animation interface.
 * @author Omer Abargel, id-207041005.
 */
interface Animation {
    /**
     * in charge of running all the game logic in one frame.
     * @param d a draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * in charge of stopping the running.
     * @return true- to stop running or false- to continue.
     */
    boolean shouldStop();
}