package hview;

import java.lang.reflect.InvocationTargetException;

/**
 * Created on 09.05.2017 by Kamil Samul for usage in Hangman.
 */
public class ViewGenerator {

    public ViewGenerator(){

    }

    public HView getView(String viewType, float h, float w){
        try {
            return (HView) Class.forName("hview." + viewType).getConstructor(float.class, float.class).newInstance(h, w);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
