package org.ck.codeeval.hard.everythingornothing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 216,
    name = "Everything or nothing",
    description = "Check if a code is correct.",
    url = "https://www.codeeval.com/open_challenges/216/",
    category = "Hard challenges")
public class Main {
  private static Map<String, Map<String, Permission>> permissions;

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        initPermissions();

        line = line.trim();
        String[] commands = line.split(" ");

        boolean isCorrect = true;

        for (String command : commands) {
          String[] arguments = command.trim().split("=>");

          String user = arguments[0];
          String fileName = arguments[1];
          String action = arguments[2];

          if (!permissions.get(user).get(fileName).isAllowed(action)) {
            isCorrect = false;
            break;
          }

          if ("grant".equals(action)) {
            String right = arguments[3];
            String userToBeGranted = arguments[4];

            Permission oldPermission = permissions.get(userToBeGranted).get(fileName);
            permissions.get(userToBeGranted).put(fileName, oldPermission.grant(right));
          }
        }

        System.out.println(isCorrect ? "True" : "False");
      }
    }
  }

  private static void initPermissions() {
    Map<String, Permission> user1Permissions = new HashMap<>();
    user1Permissions.put("file_1", Permission.FULL); /* 7 - full access (read, write, grant); */
    user1Permissions.put("file_2", Permission.WRITE_GRANT); /* 3 - write, grant; */
    user1Permissions.put("file_3", Permission.BAN); /* 0 - total ban; */

    Map<String, Permission> user2Permissions = new HashMap<>();
    user2Permissions.put("file_1", Permission.READ_WRITE); /* 6 - read, write; */
    user2Permissions.put("file_2", Permission.WRITE); /* 2 - write; */
    user2Permissions.put("file_3", Permission.READ); /* 4 - read; */

    Map<String, Permission> user3Permissions = new HashMap<>();
    user3Permissions.put("file_1", Permission.READ_GRANT); /* 5 - read, grant; */
    user3Permissions.put("file_2", Permission.GRANT); /* 1 - grant; */
    user3Permissions.put("file_3", Permission.READ_GRANT); /* 5 - read, grant; */

    Map<String, Permission> user4Permissions = new HashMap<>();
    user4Permissions.put("file_1", Permission.WRITE_GRANT); /* 3 - write, grant; */
    user4Permissions.put("file_2", Permission.FULL); /* 7 - full access (read, write, grant); */
    user4Permissions.put("file_3", Permission.GRANT); /* 1 - grant; */

    Map<String, Permission> user5Permissions = new HashMap<>();
    user5Permissions.put("file_1", Permission.READ_WRITE); /* 6 - read, write; */
    user5Permissions.put("file_2", Permission.BAN); /* 0 - total ban; */
    user5Permissions.put("file_3", Permission.WRITE); /* 2 - write; */

    Map<String, Permission> user6Permissions = new HashMap<>();
    user6Permissions.put("file_1", Permission.READ); /* 4 - read; */
    user6Permissions.put("file_2", Permission.WRITE); /* 2 - write; */
    user6Permissions.put("file_3", Permission.READ_WRITE); /* 6 - read, write; */

    permissions = new HashMap<>();
    permissions.put("user_1", user1Permissions);
    permissions.put("user_2", user2Permissions);
    permissions.put("user_3", user3Permissions);
    permissions.put("user_4", user4Permissions);
    permissions.put("user_5", user5Permissions);
    permissions.put("user_6", user6Permissions);
  }

  private enum Permission {
    BAN {
      @Override
      public Permission grant(String permission) {
        switch (permission) {
          case "grant":
            return GRANT;
          case "read":
            return READ;
          case "write":
            return WRITE;
        }

        return BAN;
      }

      @Override
      public boolean isAllowed(String action) {
        return false;
      }
    },
    GRANT {
      @Override
      public Permission grant(String permission) {
        switch (permission) {
          case "read":
            return READ_GRANT;
          case "write":
            return WRITE_GRANT;
        }

        return GRANT;
      }

      @Override
      public boolean isAllowed(String action) {
        if (action.equals("grant")) {
          return true;
        }

        return false;
      }
    },
    WRITE {
      @Override
      public Permission grant(String permission) {
        switch (permission) {
          case "grant":
            return WRITE_GRANT;
          case "read":
            return READ_WRITE;
        }

        return WRITE;
      }

      @Override
      public boolean isAllowed(String action) {
        if (action.equals("write")) {
          return true;
        }

        return false;
      }
    },
    WRITE_GRANT {
      @Override
      public Permission grant(String permission) {
        switch (permission) {
          case "read":
            return FULL;
        }

        return WRITE_GRANT;
      }

      @Override
      public boolean isAllowed(String action) {
        if (action.equals("read")) {
          return false;
        }

        return true;
      }
    },
    READ {
      @Override
      public Permission grant(String permission) {
        switch (permission) {
          case "grant":
            return READ_GRANT;
          case "write":
            return READ_WRITE;
        }

        return READ;
      }

      @Override
      public boolean isAllowed(String action) {
        if (action.equals("read")) {
          return true;
        }

        return false;
      }
    },
    READ_GRANT {
      @Override
      public Permission grant(String permission) {
        switch (permission) {
          case "write":
            return FULL;
        }

        return READ_GRANT;
      }

      @Override
      public boolean isAllowed(String action) {
        if (action.equals("write")) {
          return false;
        }

        return true;
      }
    },
    READ_WRITE {
      @Override
      public Permission grant(String permission) {
        switch (permission) {
          case "grant":
            return FULL;
        }

        return READ_WRITE;
      }

      @Override
      public boolean isAllowed(String action) {
        if (action.equals("grant")) {
          return false;
        }

        return true;
      }
    },
    FULL {
      @Override
      public Permission grant(String permission) {
        return FULL;
      }

      @Override
      public boolean isAllowed(String action) {
        return true;
      }
    };

    public abstract Permission grant(String permission);

    public abstract boolean isAllowed(String action);
  }
}
