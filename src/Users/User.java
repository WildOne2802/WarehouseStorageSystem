package Users;

import Components.JobType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class User {
    private int userID;
    private String name;
    private JobType jobType;
    private String authorizationToken;
    static int nextID = 0;

    User() {
        userID = nextID++;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void logIn() throws IOException {
        System.out.println("Enter login");
        String login = reader.readLine();
        System.out.println("Enter password");
        String password = reader.readLine();


    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void menu() {
    }
}
