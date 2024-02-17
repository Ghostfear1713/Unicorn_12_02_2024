package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Unicorn unicorn1 = new Unicorn("Farid", 39, 66);
        //Unicorn unicorn2 = new Unicorn("Gaggy", 23, 55);
        //Unicorn unicorn3 = new Unicorn("Phuuby", 19, 23);

        UnicornDAO unicornDAO = new UnicornDAO();

        //PERSISTING A UNICORN
        //____________________
        /*unicornDAO.save(unicorn1);
        unicornDAO.save(unicorn2);
        unicornDAO.save(unicorn3);*/

        //USING UPDATE (MERGE) METHOD TO CHANGE THE AGE OF A UNICORN BY
        //A GIVEN ID WITH THE FIND UNICORN BY ID METHOD
        //_____________________________________________________
        /*Unicorn unicorn1 = unicornDAO.findUnicornById(1);
        unicorn1.setAge(10);
        unicornDAO.update(unicorn1);*/

        //DELETE METHOD
        //_____________
        //unicornDAO.deleteUnicorn(4);

        //READ METHOD - GETS ALL UNICORNS FROM DB
        //_______________________________________
        //unicornDAO.getAllUnicorns();


    }
}