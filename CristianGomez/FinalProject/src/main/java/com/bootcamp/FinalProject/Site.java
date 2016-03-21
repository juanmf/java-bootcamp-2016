package com.bootcamp.FinalProject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bootcamp.FinalProject.entity.User;

/**
 * Class that keeps in memory the list of logged in users.
 * 
 * @author Cadrian
 *
 */

@Component
public class Site {

    private static List<User> loggedUsers;
   

    /**
     * inicializacion de statics, thread safe.
     */
    static {
        loggedUsers =  Collections.synchronizedList(new LinkedList<User>());
    }

    private Site(){}

    
    public static List<User> getLoggedUsers() {
        return loggedUsers;
    }
    }
