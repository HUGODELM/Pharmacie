/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huggy
 */
public abstract class Subject {

    protected List<Observer> myObservers = new ArrayList();

    public void AddObserver(Observer o) {
        myObservers.add(o);
    }
    public void RemoveObserver(Observer o) {
        myObservers.remove(o);
    }
    public void NotifyObserver(){
        String message=getNotification();
        for(Observer o :myObservers){
            o.update(message);
        }
    }
    public abstract String getNotification();
}
