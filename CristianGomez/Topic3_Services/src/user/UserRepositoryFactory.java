package user;

/**
 * A factory to get the right User Repository implementation.
 */
public class UserRepositoryFactory {

    private UserRepositoryFactory() {
    };

    /**
     * Get a local User Repository implementation.
     * @return A UserRespositoryImp instance 
     */
    public static IUserRepositoryService getLocalUserRespository() {
        return new UserRepositoryProxy(new UserRepository());
    }
    
    /**
     * Get a web service client for the User Repository implementation.
     * @return A UserRespositoryWebServiceClient instance 
     */ 
    public static IUserRepositoryService getUserRepositoryWebService() {
        return new UserRepositoryProxy(new UserRespositoryWebServiceClient());
    }

}
