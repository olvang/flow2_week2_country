package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeCountry {

    private static FacadeCountry instance;
    
    //Private Constructor to ensure Singleton
    private FacadeCountry() {}
    
    
    /**
     *
     * @return an instance of this facade class.
     */
    public static FacadeCountry getFacadeCountry() {
        if (instance == null) {
            instance = new FacadeCountry();
        }
        return instance;
    }

}
