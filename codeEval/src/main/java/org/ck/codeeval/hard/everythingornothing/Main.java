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
  private static final String GRANT = "grant";
  private static final String FILE_1 = "file_1";
  private static final String FILE_2 = "file_2";
  private static final String FILE_3 = "file_3";
  private static final String WRITE = "write";
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

          if (GRANT.equals(action)) {
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
    user1Permissions.put(FILE_1, Permission.FULL);
    user1Permissions.put(FILE_2, Permission.WRITE_GRANT);
    user1Permissions.put(FILE_3, Permission.BAN);

    Map<String, Permission> user2Permissions = new HashMap<>();
    user2Permissions.put(FILE_1, Permission.READ_WRITE);
    user2Permissions.put(FILE_2, Permission.WRITE);
    user2Permissions.put(FILE_3, Permission.READ);

    Map<String, Permission> user3Permissions = new HashMap<>();
    user3Permissions.put(FILE_1, Permission.READ_GRANT);
    user3Permissions.put(FILE_2, Permission.GRANT);
    user3Permissions.put(FILE_3, Permission.READ_GRANT);

    Map<String, Permission> user4Permissions = new HashMap<>();
    user4Permissions.put(FILE_1, Permission.WRITE_GRANT);
    user4Permissions.put(FILE_2, Permission.FULL);
    user4Permissions.put(FILE_3, Permission.GRANT);

    Map<String, Permission> user5Permissions = new HashMap<>();
    user5Permissions.put(FILE_1, Permission.READ_WRITE);
    user5Permissions.put(FILE_2, Permission.BAN);
    user5Permissions.put(FILE_3, Permission.WRITE);

    Map<String, Permission> user6Permissions = new HashMap<>();
    user6Permissions.put(FILE_1, Permission.READ);
    user6Permissions.put(FILE_2, Permission.WRITE);
    user6Permissions.put(FILE_3, Permission.READ_WRITE);

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
        return switch (permission) {
          case Main.GRANT -> GRANT;
          case "read" -> READ;
          case Main.WRITE -> WRITE;
          default -> BAN;
        };
      }

      @Override
      public boolean isAllowed(String action) {
        return false;
      }
    },
    GRANT {
      @Override
      public Permission grant(String permission) {
        return switch (permission) {
          case "read" -> READ_GRANT;
          case Main.WRITE -> WRITE_GRANT;
          default -> GRANT;
        };
      }

      @Override
      public boolean isAllowed(String action) {
        return action.equals(Main.GRANT);
      }
    },
    WRITE {
      @Override
      public Permission grant(String permission) {
        return switch (permission) {
          case Main.GRANT -> WRITE_GRANT;
          case "read" -> READ_WRITE;
          default -> WRITE;
        };
      }

      @Override
      public boolean isAllowed(String action) {
        return action.equals(Main.WRITE);
      }
    },
    WRITE_GRANT {
      @Override
      public Permission grant(String permission) {
        if ("read".equals(permission)) {
          return FULL;
        }

        return WRITE_GRANT;
      }

      @Override
      public boolean isAllowed(String action) {
        return !action.equals("read");
      }
    },
    READ {
      @Override
      public Permission grant(String permission) {
        return switch (permission) {
          case Main.GRANT -> READ_GRANT;
          case Main.WRITE -> READ_WRITE;
          default -> READ;
        };
      }

      @Override
      public boolean isAllowed(String action) {
        return action.equals("read");
      }
    },
    READ_GRANT {
      @Override
      public Permission grant(String permission) {
        if (Main.WRITE.equals(permission)) {
          return FULL;
        }

        return READ_GRANT;
      }

      @Override
      public boolean isAllowed(String action) {
        return !action.equals(Main.WRITE);
      }
    },
    READ_WRITE {
      @Override
      public Permission grant(String permission) {
        if (Main.GRANT.equals(permission)) {
          return FULL;
        }

        return READ_WRITE;
      }

      @Override
      public boolean isAllowed(String action) {
        return !action.equals(Main.GRANT);
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
