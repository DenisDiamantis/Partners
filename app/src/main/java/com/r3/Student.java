package com.r3;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Student {

    private String name = null;
    private String surname = null;
    private String AM = null;
    private String email = null;
    private ArrayList<String> skills = null;
    private HashMap<String, ArrayList<String>> timeline = null;
    private String password = null;
    Account account = new Account();
    Team team = new Team();
    Course course = new Course();
    Evaluation evaluate = new Evaluation();
    boolean login = false;
    static HashMap<String, HashMap<Integer,String>> personal_inbox = new HashMap<>();
    static HashMap<Integer,String> message_to_student = new HashMap<>();
    static HashMap<String, Integer> counter = new HashMap<>();
    static HashMap<String, Integer> total_additions = new HashMap<>();

    public Student(String name, String surname, String AM, String email, String password, ArrayList<String> skills, HashMap<String, ArrayList<String>> timeline) {
        /*this.name = name;
        this.surname=surname;
        this.AM = AM;
        this.email = email;
        this.password = password;
        this.skills = skills;
        this.timeline= timeline;*/

        setName(name);
        setSurname(surname);
        setAM(AM);
        setEmail(email);
        setPassword(password);
        setSkills(skills);
        setTimeline(timeline);
        this.skills = skills;
        this.timeline = timeline;
    }
    public Student(){

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setAM(String AM) {
        this.AM = AM;
    }

    public String getAM() {
        return AM;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setTimeline(HashMap<String, ArrayList<String>> timeline) {
        this.timeline = timeline;
    }

    public HashMap<String, ArrayList<String>> getTimeline() {
        return timeline;
    }

    public void createAccount() {
        ArrayList<String> allAM = new ArrayList<>();
        allAM.addAll(account.getHashMapKeyStudent(account.accounts));

        HashMap<String, ArrayList<String>> days = new HashMap<>();
        ArrayList myskills = new ArrayList<>();
        ArrayList<String> mondayhours = new ArrayList<>();
        ArrayList<String> tuesdayhours = new ArrayList<>();
        ArrayList<String> wednesdayhours = new ArrayList<>();
        ArrayList<String> thursdayhours = new ArrayList<>();
        ArrayList<String> fridayhours = new ArrayList<>();
        ArrayList<String> saturdayhours = new ArrayList<>();
        ArrayList<String> sundayhours = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean corname = false;
        while(!corname) {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            if (name != null) {
                corname=true;
                setName(name);
            }else{
                System.out.println("Name can not be null");
            }
        }
        //------------------------------------------------------------------------------------------------------------------------------
        boolean corsurname = false;
        while(!corsurname) {
            System.out.println("Enter your surname: ");
            String surname = scanner.nextLine();
            if(surname!=null){
                corsurname=true;
                setSurname(surname);
            }else{
                System.out.println("Surname can not be null");
            }

        }
        //------------------------------------------------------------------------------------------------------------------------------
        boolean correct = false;
        while (!correct) {
            int invalid = 0;
            System.out.println("Enter your AM: ");
            String AM = scanner.nextLine();

            if (AM == null) {
                System.out.println("Wrong input");
                invalid++;
            }
            String temp[] = AM.split("");
            if(temp.length!=8){
                System.out.println("Illegal form of ID");
                invalid++;
            }
            if (invalid==0 && !temp[0].matches("^[a-zA-Z]*$")) {
                System.out.println("Illegal form of ID");
                invalid++;
            }
            if (invalid == 0) {
                for (int i = 1; i < temp.length; i++) {
                    if (!temp[i].matches("^[0-9]")) {
                        System.out.println("Illegal form of ID");
                        invalid++;
                    }
                    if (invalid != 0)
                        break;
                }
            }
            if (invalid == 0 && account!=null && account.accounts!=null) {
                for (int k = 0; k < account.accounts.size(); k++) {
                    if (AM.equals(account.accounts.get(allAM.get(k)).getAM())) {
                        System.out.println("The AM you entered is already being used");
                        invalid++;
                    }
                    if (invalid != 0)
                        break;
                }
            }
            if (invalid == 0) {
                this.AM=AM;
                correct = true;
            }
        }
        setAM(AM);
        //------------------------------------------------------------------------------------------------------------------------------
        boolean coremail = false;
        while(!coremail){
            int local = 0;
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if (!email.matches(regex)) {
                System.out.println("Illegal form of email");
                local++;
            }
            if(account!= null && account.accounts!=null) {
                for (int i = 0; i < account.accounts.size(); i++) {
                    if (email.equals(account.accounts.get(allAM.get(i)).getEmail())) {
                        System.out.println("The email you entered is already being used");
                        local++;
                    }
                }
            }
            if(local==0){
                this.email=email;
                coremail=true;
            }
        }
        setEmail(email);
        //------------------------------------------------------------------------------------------------------------------------------
        boolean pas = false;
        String password1 = "";// temp
        boolean pas2 = false;
        while(!pas2) {
            while (!pas) {
                int local = 0;
                System.out.println("Enter your password: ");
                password1 = scanner.nextLine();
                boolean limit = false;
                String temp[] = password1.split("");
                if (temp.length < 6 || temp.length > 15) {
                    System.out.println("The password must be between 6-15 characters and must include at least 1 number");
                    local++;
                }
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].matches("^[0-9]")) {
                        limit = true;
                    }
                }
                if (!limit) {
                    System.out.println("The password must be between 6-15 characters and must include at least 1 number");
                    local++;
                }
                if (local == 0) {
                    pas = true;
                }
            }
            System.out.println("Enter your password again: ");
            String password2 = scanner.nextLine();
            String equals;
            if (password1.equals(password2)) {
                equals = "0";
            } else {
                equals = "1";
            }
            switch (equals) {
                case "0":
                    this.password = password1;
                    setPassword(password);
                    pas2 = true;
                    break;
                case "1":
                    System.out.println("Passwords do not match");
                    System.out.println("If you want to retry press 0");
                    System.out.println("If you want to change the initial password you typed press 1");
                    String amazing = scanner.nextLine();
                    if(amazing.equals("0")){
                        break;
                    }else if(amazing.equals("1")){
                        pas=false;
                        break;
                    }else {
                        System.out.println("Wrong input, start the password process again");
                        pas = false;
                        break;
                    }
                default:
                    System.out.println("ERROR: Invalid Selection");
            }
        }

        System.out.println("Congratulations, your account was successfully created! ");
        System.out.println("Do you want to add some additional information to your account? ");
        System.out.println("Press 0 if you want to skip this part");
        System.out.println("Press 1 if you want to continue");
        String additional = scanner.nextLine();
        switch(additional){
            case "0":
                break;

            case "1":
                System.out.println("To begin with, do you want to add a skill or add an available hour...");
                boolean adding = false;
                while(!adding) {
                    System.out.println("Press 0 for a skill");
                    System.out.println("Press 1 for an hour");
                    System.out.println("Press 2 if you changed your mind");
                    String toadd = scanner.nextLine();
                    switch (toadd) {
                        case "0":
                            boolean stop = false;
                            while (!stop) {
                                System.out.println("Add a skill to your list");
                                String skill = scanner.nextLine();
                                if (skill != null) {
                                    myskills.add(skill);
                                    System.out.println("Do you want to add another? ");
                                    System.out.println("Press 0 for one more");
                                    System.out.println("Press 1 to go to the previous menu");
                                    String more = scanner.nextLine();
                                    if (more.equals("1")) {
                                        stop = true;
                                    } else if (more.equals("0")) {
                                        System.out.println("Ok :)");
                                    } else {
                                        System.out.println("Wrong input");
                                        break;
                                    }
                                }
                            }
                            setSkills(myskills);
                            System.out.println("Skill list updated successfully");
                            break;

                        case "1":
                            boolean stop2 = false;
                            while (!stop2) {
                                System.out.println("In what day is the available hour you want to add? ");
                                System.out.println("Please enter EXACTLY one of the options below:");
                                System.out.println("Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday");

                                String day = scanner.nextLine();

                                switch (day) {
                                    case "Monday":
                                        boolean stop3 = false;
                                        while (!stop3) {
                                            System.out.println("Add the available hour");
                                            System.out.println("Please enter the hour in EXACTLY this format: $$:$$");
                                            String hour = scanner.nextLine();
                                            String regex = "([01]?[0-9]|2[0-3]):[0][0]";
                                            if (!hour.matches(regex)) {
                                                System.out.println("Wrong input");
                                                break;
                                            } else {
                                                if(!mondayhours.contains(hour)) {
                                                    mondayhours.add(hour);
                                                    days.put("Monday", mondayhours);
                                                    System.out.println("Press 0 to add one more hour on Monday");
                                                    System.out.println("Press 1 to go to the previous menu");
                                                    String onemore = scanner.nextLine();
                                                    if (onemore.equals("0")) {
                                                        System.out.println("Okay :)");
                                                    } else if (onemore.equals("1")) {
                                                        stop3 = true;
                                                    } else {
                                                        System.out.println("Wrong input");
                                                        break;
                                                    }
                                                }else{
                                                    System.out.println("We didn't add anything you already had that hour on the list");
                                                    System.out.println("You are being transfered to the previous menu");
                                                    break;
                                                }
                                            }
                                        }
                                        System.out.println("Monday's available hours updated successfully");
                                        break;

                                    case "Tuesday":
                                        boolean stop4 = false;
                                        while (!stop4) {
                                            System.out.println("Add the available hour");
                                            System.out.println("Please enter the hour in EXACTLY this format: ($)$:00");
                                            String hour = scanner.nextLine();
                                            String regex = "([01]?[0-9]|2[0-3]):[0][0]";
                                            if (!hour.matches(regex)) {
                                                System.out.println("Wrong input");
                                                break;
                                            } else {
                                                tuesdayhours.add(hour);
                                                days.put("Tuesday", tuesdayhours);
                                                System.out.println("Press 0 to add one more hour on Tuesday");
                                                System.out.println("Press 1 to go to the previous menu");
                                                String onemore = scanner.nextLine();
                                                if (onemore.equals("0")) {
                                                    System.out.println("Okay :)");
                                                } else if (onemore.equals("1")) {
                                                    stop4 = true;
                                                } else {
                                                    System.out.println("Wrong input");
                                                    break;
                                                }
                                            }
                                        }
                                        System.out.println("Tuesday's available hours updated successfully");
                                        break;

                                    case "Wednesday":
                                        boolean stop5 = false;
                                        while (!stop5) {
                                            System.out.println("Add the available hour");
                                            System.out.println("Please enter the hour in EXACTLY this format: $$:$$");
                                            String hour = scanner.nextLine();
                                            String regex = "([01]?[0-9]|2[0-3]):[0][0]";
                                            if (!hour.matches(regex)) {
                                                System.out.println("Wrong input");
                                                break;
                                            } else {
                                                wednesdayhours.add(hour);
                                                days.put("Wednesday", wednesdayhours);
                                                System.out.println("Press 0 to add one more hour on Wednesday");
                                                System.out.println("Press 1 to go to the previous menu");
                                                String onemore = scanner.nextLine();
                                                if (onemore.equals("0")) {
                                                    System.out.println("Okay :)");
                                                } else if (onemore.equals("1")) {
                                                    stop5 = true;
                                                } else {
                                                    System.out.println("Wrong input");
                                                    break;
                                                }
                                            }
                                        }
                                        System.out.println("Wednesday's available hours updated successfully");
                                        break;

                                    case "Thursday":
                                        boolean stop6 = false;
                                        while (!stop6) {
                                            System.out.println("Add the available hour");
                                            System.out.println("Please enter the hour in EXACTLY this format: $$:$$");
                                            String hour = scanner.nextLine();
                                            String regex = "([01]?[0-9]|2[0-3]):[0][0]";
                                            if (!hour.matches(regex)) {
                                                System.out.println("Wrong input");
                                                break;
                                            } else {
                                                thursdayhours.add(hour);
                                                days.put("Thursday", thursdayhours);
                                                System.out.println("Press 0 to add one more hour on Thursday");
                                                System.out.println("Press 1 to go to the previous menu");
                                                String onemore = scanner.nextLine();
                                                if (onemore.equals("0")) {
                                                    System.out.println("Okay :)");
                                                } else if (onemore.equals("1")) {
                                                    stop6 = true;
                                                } else {
                                                    System.out.println("Wrong input");
                                                    break;
                                                }
                                            }
                                        }
                                        System.out.println("Thursday's available hours updated successfully");
                                        break;

                                    case "Friday":
                                        boolean stop7 = false;
                                        while (!stop7) {
                                            System.out.println("Add the available hour");
                                            System.out.println("Please enter the hour in EXACTLY this format: $$:$$");
                                            String hour = scanner.nextLine();
                                            String regex = "([01]?[0-9]|2[0-3]):[0][0]";
                                            if (!hour.matches(regex)) {
                                                System.out.println("Wrong input");
                                                break;
                                            } else {
                                                fridayhours.add(hour);
                                                days.put("Friday", fridayhours);
                                                System.out.println("Press 0 to add one more hour on Friday");
                                                System.out.println("Press 1 to go to the previous menu");
                                                String onemore = scanner.nextLine();
                                                if (onemore.equals("0")) {
                                                    System.out.println("Okay :)");
                                                } else if (onemore.equals("1")) {
                                                    stop7 = true;
                                                } else {
                                                    System.out.println("Wrong input");
                                                    break;
                                                }
                                            }
                                        }
                                        System.out.println("Friday's available hours updated successfully");
                                        break;

                                    case "Saturday":
                                        boolean stop8 = false;
                                        while (!stop8) {
                                            System.out.println("Add the available hour");
                                            System.out.println("Please enter the hour in EXACTLY this format: $$:$$");
                                            String hour = scanner.nextLine();
                                            String regex = "([01]?[0-9]|2[0-3]):[0][0]";
                                            if (!hour.matches(regex)) {
                                                System.out.println("Wrong input");
                                                break;
                                            } else {
                                                saturdayhours.add(hour);
                                                days.put("Saturday", saturdayhours);
                                                System.out.println("Press 0 to add one more hour on Saturday");
                                                System.out.println("Press 1 to go to the previous menu");
                                                String onemore = scanner.nextLine();
                                                if (onemore.equals("0")) {
                                                    System.out.println("Okay :)");
                                                } else if (onemore.equals("1")) {
                                                    stop8 = true;
                                                } else {
                                                    System.out.println("Wrong input");
                                                    break;
                                                }
                                            }
                                        }
                                        System.out.println("Saturday's available hours updated successfully");
                                        break;

                                    case "Sunday":
                                        boolean stop9 = false;
                                        while (!stop9) {
                                            System.out.println("Add the available hour");
                                            System.out.println("Please enter the hour in EXACTLY this format: $$:$$");
                                            String hour = scanner.nextLine();
                                            String regex = "([01]?[0-9]|2[0-3]):[0][0]";
                                            if (!hour.matches(regex)) {
                                                System.out.println("Wrong input");
                                                break;
                                            } else {
                                                sundayhours.add(hour);
                                                days.put("Sunday", sundayhours);
                                                System.out.println("Press 0 to add one more hour on Sunday");
                                                System.out.println("Press 1 to go to the previous menu");
                                                String onemore = scanner.nextLine();
                                                if (onemore.equals("0")) {
                                                    System.out.println("Okay :)");
                                                } else if (onemore.equals("1")) {
                                                    stop9 = true;
                                                } else {
                                                    System.out.println("Wrong input");
                                                    break;
                                                }
                                            }
                                        }
                                        System.out.println("Sunday's available hours updated successfully");
                                        break;

                                    default:
                                        System.out.println("ERROR: Invalid Selection");
                                }
                                System.out.println("Do you want to add an hour to a different day?");
                                System.out.println("Press 0 for yes");
                                System.out.println("Press 1 to go to the previous menu");
                                String moredays = scanner.nextLine();
                                if (moredays.equals("0")) {
                                    System.out.println("Okay :)");
                                } else if (moredays.equals("1")) {
                                    stop2 = true;
                                } else {
                                    System.out.println("Wrong input");
                                    break;
                                }

                            }
                            setTimeline(days);
                            System.out.println("Timeline updated successfully");
                            break;

                        case "2":
                            break;

                        default:
                            System.out.println("ERROR: Invalid Selection");
                    }
                    System.out.println("Do you want to keep embellishing your account? ");
                    System.out.println("Press 0 if not");
                    System.out.println("Press 1 if yes");
                    String embellish = scanner.nextLine();
                    if (embellish.equals("0")) {
                        adding = true;
                        break;
                    } else if(embellish.equals("1")){
                        System.out.println("Ok :)");
                    }else{
                        adding = true;
                        System.out.println("Wrong input, heading to the previous menu");
                        break;
                    }
                }
                break;
            default:
                System.out.println("ERROR: Invalid Selection");
        }

        allAM.add(getAM());
        Account acc = new Account(getName(), getSurname(), getAM(), getEmail(), getPassword(), getSkills(), getTimeline());
    }


    public String login(String AM, String password) {
        Scanner scanner = new Scanner(System.in);
        //setAM(AM);
        //setPassword(password);
        if (account != null && account.accounts != null) {
            for (int i = 0; i < account.accounts.size(); i++) {
                if (account.accounts.containsKey(AM)) {
                    for(int j=0;j<account.accounts.size();j++) {

                    }
                    if (password.equals(account.accounts.get(AM).getPassword())) {
                        System.out.println("You have logged in successfully");
                        setAM(AM);
                        return "1";
                    } else {
                        System.out.println("Invalid password");
                        return "0";
                    }

                }
            }
            System.out.println("The AM you entered does not exist on our dataset");
            return "0";
        } else {
            System.out.println("The credentials you entered do not match any of our accounts");
            return "0";
        }
    }

    public void logout() {

    }



    public void editAccount(String AM) {
        System.out.println("Please choose an action: ");
        System.out.println("Press 1 to change your name");
        System.out.println("Press 2 to change your surname");
        System.out.println("Press 3 to change your password");
        System.out.println("Press 4 to alter your skills");
        System.out.println("Press 5 to alter your timeline");
        System.out.println("Press 6 to go to the previous menu");

        setAM(AM);
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        switch (action) {
            case "1":
                System.out.println("Please enter your new name");
                String newname = scanner.nextLine();
                if (newname != null) {
                    setName(newname);
                    Student temp = account.accounts.get(AM);
                    account.accounts.remove(AM);
                    Account updated = new Account(getName(),temp.getSurname(),temp.getAM(),temp.getEmail(),temp.getPassword(),temp.getSkills(),temp.getTimeline());
                    System.out.println("Name updated");
                } else {
                    System.out.println("Name can not be null");
                }
                break;

            case "2":
                System.out.println("Please enter your new surname");
                String newsurname = scanner.nextLine();
                if (newsurname != null) {
                    setSurname(newsurname);
                    Student temp = account.accounts.get(AM);
                    account.accounts.remove(AM);
                    Account updated = new Account(temp.getName(),getSurname(),temp.getAM(),temp.getEmail(),temp.getPassword(),temp.getSkills(),temp.getTimeline());

                    System.out.println("Surname updated");
                } else {
                    System.out.println("Surname can not be null");
                }
                break;

            case "3":
                System.out.println("Please enter your old password");
                String oldpas = scanner.nextLine();
                if (oldpas.equals(account.accounts.get(AM).getPassword())) {
                    boolean pas = false;
                    String newpas = "";
                    boolean pas2 = false;
                    while(!pas2) {
                        while (!pas) {
                            int local = 0;
                            System.out.println("Please enter your new password");
                            newpas = scanner.nextLine();
                            boolean limit = false;
                            String temp[] = newpas.split("");
                            if (temp.length < 6 || temp.length > 15) {
                                System.out.println("The password must be between 6-15 characters and must include at least 1 number");
                                local++;
                            }
                            for (int i = 0; i < temp.length; i++) {
                                if (temp[i].matches("^[0-9]")) {
                                    limit = true;
                                }
                            }
                            if (!limit) {
                                System.out.println("The password must be between 6-15 characters and must include at least 1 number");
                                local++;
                            }
                            if (local == 0) {
                                pas = true;
                            }
                        }
                        System.out.println("Please enter your new password again");
                        String newpas2 = scanner.nextLine();
                        String equals;
                        if (newpas.equals(newpas2)) {
                            equals = "0";
                        } else {
                            equals = "1";
                        }
                        switch (equals) {
                            case "0":
                                this.password = newpas;
                                setPassword(password);
                                pas2 = true;
                                break;
                            case "1":
                                System.out.println("Passwords do not match");
                                System.out.println("If you want to retry press 0");
                                System.out.println("If you want to change the initial password you typed press 1");
                                String amazing = scanner.nextLine();
                                if(amazing.equals("0")){
                                    break;
                                }else if(amazing.equals("1")){
                                    pas=false;
                                    break;
                                }else {
                                    System.out.println("Wrong input, start the password process again");
                                    pas = false;
                                    break;
                                }
                            default:
                                System.out.println("ERROR: Invalid Selection");
                        }
                    }
                    setPassword(newpas);
                    Student temp = account.accounts.get(AM);
                    account.accounts.remove(AM);
                    Account updated = new Account(temp.getName(),temp.getSurname(),temp.getAM(),temp.getEmail(),getPassword(),temp.getSkills(),temp.getTimeline());

                    System.out.println("Password updated");
                } else {
                    System.out.println("The password you entered is not valid");
                }
                break;

            case "4":
                System.out.println("If you want to remove a skill please press 'R'");
                System.out.println("If you want to add a skill please press 'A'");
                System.out.println("If you want to go back to the previous menu press 'B'");
                String decision = scanner.nextLine();
                switch(decision) {
                    case "R":
                        System.out.println("These are the skills you have listed");
                        for(int i = 0; i<account.skillsmap.size();i++) {
                            System.out.println(account.skillsmap.get(AM));
                        }
                        System.out.println("Please type exactly the skill you want to remove. ");
                        String removal = scanner.nextLine();
                        int sem = 0;
                        for (int i = 0; i < account.skillsmap.get(AM).size(); i++) {
                            if (removal.equals(account.skillsmap.get(AM).get(i))) {
                                account.skillsmap.remove(i);
                                System.out.println("Skill removed");
                                sem = 1;
                                break;
                            }
                        }
                        if (sem == 0) {
                            System.out.println("The skilled you entered is not on your skill list");
                        }
                        break;
                    case "A":
                        System.out.println("Please type the skill you want to add");
                        String addition = scanner.nextLine();
                        if (addition != null) {
                            account.skillsmap.get(AM).add(addition);
                            System.out.println("Skill added successfully");
                        } else {
                            System.out.println("Skill can not be null");
                        }
                        break;
                    case "B":
                        break;
                    default:
                        System.out.println("ERROR: Invalid Selection");
                }
                break;

            case "5":
                System.out.println("If you want to remove an available hour press 'R'");
                System.out.println("If you want to add an available hour press 'A'");
                System.out.println("If you want to go back to the previous menu press 'B'");
                String choice = scanner.nextLine();

                boolean changing = false;
                switch (choice) {
                    case "R":
                        System.out.println("Here is your timeline so far: ");
                        System.out.println(account.timelinemap.get(AM));
                        System.out.println("Please type the day");
                        System.out.println("Type for example : Monday");
                        String day = scanner.nextLine();
                        System.out.println("Please add the hour on the format ($)$:00");
                        String hour = scanner.nextLine();
                        if ((day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday") || day.equals("Saturday") || day.equals("Sunday"))) {
                            String regex = "([01]?[0-9]|2[0-3]):[0][0]";
                            if (!hour.matches(regex)) {
                                System.out.println("Wrong input");
                                break;
                            }
                            int sem = 0;
                            for (int i = 0; i < account.timelinemap.get(getAM()).get(day).size(); i++) {
                                if (hour.equals(account.timelinemap.get(getAM()).get(day).get(i))) {
                                    account.timelinemap.get(getAM()).get(day).remove(i);
                                    System.out.println("Hour removed");
                                    sem = 1;
                                }
                            }
                            if (sem == 0) {
                                System.out.println("The hour you entered was not on the listed hours");
                            }
                        }else{
                            System.out.println("Wrong input");
                        }
                        break;

                    case "A":
                        System.out.println("Please type the day and the hour you want to add");
                        System.out.println("Please type the day");
                        String theday = scanner.nextLine();
                        System.out.println("Please add the hour");
                        String thehour = scanner.nextLine();

                        if ((theday.equals("Monday") || theday.equals("Tuesday") || theday.equals("Wednesday") || theday.equals("Thursday") || theday.equals("Friday") || theday.equals("Saturday") || theday.equals("Sunday")) && thehour != null) {
                            if(!account.timelinemap.get(getAM()).get(theday).contains(thehour)) {
                                account.timelinemap.get(getAM()).get(theday).add(thehour);
                                System.out.println("Available hour added successfully");
                            }else if(account.timelinemap.get(getAM()).get(theday).contains(thehour)){
                                System.out.println("The hour you added exists already on "+ theday);
                            }

                        } else {
                            System.out.println("Wrong input");
                        }
                        break;

                    case "B":
                        break;

                    default:
                        System.out.println("ERROR: Invalid Selection");
                        break;
                }


            case "6":
                break;

            default:
                System.out.println("ERROR: Invalid Selection");

        }
    }
    public void createTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Great, let's help you do that :)");
        System.out.println("For which course do you want to create a team ?");
        ArrayList<String> temp_courses = new ArrayList<>();
        for(int i=0;i<course.courses.size();i++) {
            if(course!= null && course.courses!=null) {
                temp_courses.add(course.getHashMapKey(course.courses).get(i));
                System.out.println(course.getHashMapKey(course.courses).get(i));
            }
        }
        String thecourse = scanner.nextLine();// the course name
        if(temp_courses.contains(thecourse)) {
            int min = 1111;
            int max = 9999;
            int id = (int) Math.floor(Math.random() * (max - min + 1) + min);// the id
            String founder = getAM();// the founder
            int team_size = course.courses.get(thecourse);
            final ArrayList<Student> members = new ArrayList<>(team_size);
            members.add(account.accounts.get(AM));
            String requirements = null;
            System.out.println("Your team was successfully created! ");
            System.out.println("Do you want the team to have any specific requirements? ");
            System.out.println("If not press 0");
            System.out.println("If yes press 1");
            String req = scanner.nextLine();
            if (req.equals("1")) {
                System.out.println("Please type a text with your requirements. When you are finished press 'Enter'. ");
                requirements = scanner.nextLine();
                Team the_team = new Team(thecourse, id, members, founder, requirements);
            } else {
                requirements = "No requirements";
                Team the_team = new Team(thecourse, id, members, founder, requirements);
            }
        }else{
            System.out.println("Wrong input, you are being transferred to the previous menu");
        }
    }

    public void joinRequest(String AM, String message, int id,String course) {
        Request request = new Request(AM,message,id,course);
        team.sender.put(AM,request);
        team.inbox.put(id,team.sender);
        //System.out.println(team.inbox.get(id).get(AM).getAM());
        //System.out.println(team.inbox.get(id).get(AM).getMessage());
        //System.out.println(team.inbox.get(id).get(AM).getID());
    }

    public void viewTeams(String thecourse) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The team limit for this course is "+ course.courses.get(thecourse));
        if(team.teams.get(thecourse)!=null) {
            for (int j = 0; j < team.teams.get(thecourse).size(); j++) {
                if (team != null && team.teams != null) {
                    System.out.println(j + 1 + ". Team " + team.getHashMapKey(team.teams.get(thecourse)).get(j) + ": ");
                    for (int l = 0; l < team.teams.get(thecourse).get(team.getHashMapKey(team.teams.get(thecourse)).get(j)).size(); l++) {
                        System.out.println(team.teams.get(thecourse).get(team.getHashMapKey(team.teams.get(thecourse)).get(j)).get(l).getAM());
                    }
                }
                System.out.println("Teams's requirements: " + team.the_requirements.get(team.getHashMapKey(team.teams.get(thecourse)).get(j)) + "\n");

            }
            System.out.println("If you want to learn more about a team, please enter the team's ID");
        }else{
            System.out.println("There are no teams in this course yet.");
        }



    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void completeEvaluation(String AM) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the course that you and the person you are evaluating are taking.");
        System.out.println("Here are all the courses on this semester...");
        ArrayList<String> temp_courses = new ArrayList<>();
        for (int i = 0; i < course.courses.size(); i++) {
            System.out.println(course.getHashMapKey(course.courses).get(i));
            temp_courses.add(course.getHashMapKey(course.courses).get(i));
        }
        ArrayList<Integer> temp_id = new ArrayList<>();
        for (int i = 0; i < team.assembled.size(); i++) {
            temp_id.add(team.getHashMapKey(team.assembled).get(i));
        }
        String thecourse = scanner.nextLine();
        if (!temp_courses.contains(thecourse)) {
            System.out.println("Invalid input");
        } else {
            System.out.println("Now please enter your team's ID");
            String theid = scanner.nextLine();
            if (!theid.matches("[0-9][0-9][0-9][0-9]") || !temp_id.contains(Integer.parseInt(theid))) {
                System.out.println("The team you entered does not exist");
            } else {
                System.out.println("Finally, enter the student's AM");
                String AM_2 = scanner.nextLine();
                if (!team.assembled.get(Integer.parseInt(theid)).contains(account.accounts.get(AM_2))) {
                    System.out.println("The student you entered is not listed on this team");
                } else {
                    int teammates = 0;
                    //System.out.println(team.teams.get(thecourse).get(theid));
                    for (int i = 0; i < team.teams.get(thecourse).get(Integer.parseInt(theid)).size(); i++) {
                        if (team.teams.get(thecourse).get(Integer.parseInt(theid)).get(i).getAM().equals(AM)) {
                            teammates++;
                            for (int j = 0; j < team.teams.get(thecourse).get(Integer.parseInt(theid)).size(); j++) {
                                if (team.teams.get(thecourse).get(Integer.parseInt(theid)).get(j).getAM().equals(AM_2)) {
                                    teammates++;
                                }
                            }
                        }
                    }
                    if (teammates == 2) {
                        if(evaluate.eval_done.size()==0 || evaluate.eval_done.get(AM)==null || !evaluate.eval_done.get(AM).get(AM_2)) {
                            System.out.println("You have been approved to evaluate " + AM_2);
                            System.out.println("Now please enter your evaluation from scale 1-5, WITHOUT decimal numbers");
                            int evaluation = scanner.nextInt();
                            String str_evaluation = String.valueOf(evaluation);
                            if (evaluation < 1 || evaluation > 5) {
                                System.out.println("Please read the instructions carefully.");
                            } else if (!str_evaluation.matches("[0-9]")) {
                                System.out.println("Not a number");
                            } else {
                                int temp = 0;
                                int temp2 = 0;
                                if (counter.size() != 0) {
                                    temp = counter.get(AM_2);
                                    counter.replace(AM_2, temp, temp++);
                                } else {
                                    temp = 1;
                                    counter.put(AM_2, temp);
                                }
                                if (total_additions.size() != 0) {
                                    temp2 = total_additions.get(AM_2);
                                    total_additions.replace(AM_2, temp2, temp2 + evaluation);
                                } else {
                                    temp2 = evaluation;
                                    total_additions.put(AM_2, temp2);
                                }
                                if (evaluate.evaluations.size() != 0) {
                                    double temp3 = evaluate.evaluations.get(AM_2);
                                    double newevaluation = (((double) temp2 + (double) evaluation) / (double) temp);
                                    evaluate.evaluations.replace(AM_2, temp3, newevaluation);
                                } else {
                                    double newevaluation = evaluation;
                                    evaluate.evaluations.put(AM_2, newevaluation);
                                }
                                Evaluation total_evaluation = new Evaluation(AM,AM_2);
                                //System.out.println(evaluations.get(AM_2).toString());
                                System.out.println("Evaluation complete!");

                            }
                        }else{
                            System.out.println("You already have evaluated this student.");
                        }
                    } else {
                        System.out.println("You are not authorised to evaluate this student.");
                    }
                }
            }
        }
    }
}