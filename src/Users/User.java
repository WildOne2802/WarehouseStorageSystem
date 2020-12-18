package Users;

import Components.JobType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class User {
    private final int userID;
    private String name;
    private JobType jobType;
    private String authorizationToken;
    static int nextID = 0;

    User(String name) {
        this.name = name;
        userID = nextID++;
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

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", jobType=" + jobType +
                '}';
    }
}
