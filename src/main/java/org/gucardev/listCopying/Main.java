package org.gucardev.listCopying;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.SerializationUtils;

public class Main {

  public static void main(String[] args) {

    List<User> users = new ArrayList<>();

    users.add(new User(1L, "grkn"));
    users.add(new User(2L, "ali"));
    users.add(new User(3L, "metin"));

    // List<User> usersDeepCopy1 =  new ArrayList<>(users);
    List<User> usersDeepCopy1 =
        users.stream().map(SerializationUtils::clone).collect(Collectors.toList());

    User temp = usersDeepCopy1.get(0);
    usersDeepCopy1.set(0, usersDeepCopy1.get(2));
    usersDeepCopy1.set(2, temp);

    // List<User> usersDeepCopy2 = new ArrayList<>(users);
    List<User> usersDeepCopy2 =
        users.stream().map(SerializationUtils::clone).collect(Collectors.toList());
    User temp2 = usersDeepCopy2.get(1);
    usersDeepCopy2.set(1, usersDeepCopy2.get(0));
    usersDeepCopy2.set(0, temp2);

    System.out.println(Arrays.toString(users.toArray()));
    System.out.println(Arrays.toString(usersDeepCopy1.toArray()));
    System.out.println(Arrays.toString(usersDeepCopy2.toArray()));
  }
}
