package hview;

/**
 * Created on 09.05.2017 by Kamil Samul for usage in Hangman.
 */
public class ViewGenerator {
    private HView view = null;

    public ViewGenerator(){

    }

    public HView getView(String viewType){
        try {
            return (HView) Class.forName("hview." + viewType).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
