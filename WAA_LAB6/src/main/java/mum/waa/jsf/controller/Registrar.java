package mum.waa.jsf.controller;

import java.util.ArrayList;
import java.util.List;

public class Registrar {

   private static List<UserBean> registeredUsers = new ArrayList<UserBean>();
   static {
      registeredUsers.add(new UserBean("Hiro", "secret"));
   }

   public static void register(String name, String password) {
      registeredUsers.add(new UserBean(name, password));
   }

   public static boolean isRegistered(String name, String password) {
      for (UserBean user : registeredUsers) {
         if (user.getName().equals(name) && user.getPassword().equals(password))
            return true;
      }
      return false;
   }
}
