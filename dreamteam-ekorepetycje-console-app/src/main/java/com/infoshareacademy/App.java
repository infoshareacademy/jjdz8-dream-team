package com.infoshareacademy;

import com.infoshareacademy.menu.MainMenu;
import com.infoshareacademy.menu.MenuService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MainMenu.showMenu();
        MenuService.uploadCorrectUserInput();
    }
}
