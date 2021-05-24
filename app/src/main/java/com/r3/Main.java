package com.r3;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;

public class Main {



    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String args[]) {
        load();
        StudentDAO studentDAO = new StudentDAO();
        TeamDAO teamDAO = new TeamDAO();
        CourseDAO courseDAO = new CourseDAO();
        RequestDAO requestDAO = new RequestDAO();
        AccountDAO accountDAO = new AccountDAO();
        EvaluationDAO evaluate = new EvaluationDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our app");
        System.out.println("In order to continue, you need to login or sign up... \n");
        boolean totalexit = false;
        while (!totalexit) {
            System.out.println("Press 0 to exit the app");
            System.out.println("Press 1 to login");
            System.out.println("Press 2 to sign up");

            String decision = scanner.nextLine();
            int success = 1;
            boolean humungus = false;

            switch (decision) {
                case "0":
                    System.exit(0);

                case "1":
                    System.out.println("Enter your AM");
                    String AM = scanner.nextLine();
                    System.out.println("Enter your password");
                    String password = scanner.nextLine();
                    switch (studentDAO.login(AM, password)) {
                        case "0":
                            break;
                        case "1":
                            while(!humungus) {
                                System.out.println("Press 1 to alter your profile data");
                                System.out.println("Press 2 to create a team");
                                System.out.println("Press 3 to join an existing team");
                                System.out.println("Press 4 to evaluate a team member");
                                System.out.println("Press 5 to see your messages (Only for Team-Founders)");
                                System.out.println("Press 6 to logout");

                                String decision2 = scanner.nextLine();
                                switch (decision2) {

                                    case "1":
                                        boolean changes = false;
                                        while (!changes) {
                                            studentDAO.editAccount(AM);
                                            System.out.println("Do you want to change something else?");
                                            System.out.println("Press 0 to head to the previous menu");
                                            System.out.println("Press 1 to change more");
                                            String further = scanner.nextLine();
                                            if (further.equals("0")) {
                                                changes = true;
                                                break;
                                            } else if (further.equals("1")) {
                                                System.out.println("Ok :)");
                                            } else {
                                                System.out.println("Wrong input, you are being transferred to the previous menu");
                                            }
                                        }
                                        break;

                                    case "2":
                                        studentDAO.createTeam();
                                        break;

                                    case "3":
                                        boolean bored = false;
                                        while (!bored) {
                                            System.out.println("For which course do you want to see the existing teams? ");
                                            System.out.println("Here are all the courses on this semester...");
                                            ArrayList<String> temp_courses = new ArrayList<>();
                                            for (int i = 0; i < courseDAO.courses.size(); i++) {
                                                System.out.println(courseDAO.getHashMapKey(courseDAO.courses).get(i));
                                                temp_courses.add(courseDAO.getHashMapKey(courseDAO.courses).get(i));
                                            }
                                            String thecourse = scanner.nextLine();
                                            if (temp_courses.contains(thecourse)) {
                                                boolean already = false;
                                                if(teamDAO.teams.get(thecourse)!=null) {
                                                    ArrayList<Integer> temp2 = teamDAO.getHashMapKey(teamDAO.teams.get(thecourse));
                                                    for (int j = 0; j < temp2.size(); j++) {
                                                        for (int h = 0; h < teamDAO.teams.get(thecourse).get(temp2.get(j)).size(); h++) {
                                                            if (teamDAO.teams.get(thecourse).get(temp2.get(j)).get(h).getAM().equals(AM)) {
                                                                already = true;
                                                            }
                                                        }
                                                    }
                                                }
                                                if(!already) {
                                                    studentDAO.viewTeams(thecourse);
                                                    //System.out.println("If you want to learn more about a team, please enter the team's ID");
                                                    System.out.println("If you want to go back press 0");
                                                    String input = scanner.nextLine();
                                                    boolean full = false;
                                                    int correct = 0;
                                                    int limit = courseDAO.courses.get(thecourse);
                                                    if (input.equals("0")) {
                                                        break;
                                                    } else if (!input.matches("^[0-9][0-9][0-9][0-9]$")) {
                                                        System.out.println("Invalid input");
                                                        break;
                                                    } else {
                                                        ArrayList<Integer> temp = teamDAO.getHashMapKey(teamDAO.teams.get(thecourse));//ola ta teams toy Tech
                                                        for (int i = 0; i < temp.size(); i++) {
                                                            if (Integer.parseInt(input) == temp.get(i)) {
                                                                if (teamDAO.teams.get(thecourse).get(Integer.parseInt(input)).size() < limit) {
                                                                    for (int j = 0; j < teamDAO.teams.get(thecourse).get(Integer.parseInt(input)).size(); j++) {
                                                                        System.out.println(teamDAO.teams.get(thecourse).get(Integer.parseInt(input)).get(j).getName());
                                                                        System.out.println(teamDAO.teams.get(thecourse).get(Integer.parseInt(input)).get(j).getSurname());
                                                                        if (teamDAO.teams.get(thecourse).get(Integer.parseInt(input)).get(j).getSkills() != null) {
                                                                            System.out.println(teamDAO.teams.get(thecourse).get(Integer.parseInt(input)).get(j).getSkills());
                                                                        }
                                                                    }

                                                                } else {
                                                                    full = true;
                                                                    System.out.println("The team you entered is full.");
                                                                }
                                                                correct++;
                                                            }
                                                        }
                                                    }
                                                    if (correct == 0) {
                                                        System.out.println("The team you enter does not exist");
                                                    } else {
                                                        if (!full) {
                                                            System.out.println("Do you want to send a join request to this team? \n");
                                                            System.out.println("If not, press 0 to go back");
                                                            System.out.println("If yes, press 1 \n");
                                                            String onemore = scanner.nextLine();
                                                            if (onemore.equals("0")) {
                                                                bored = true;
                                                                break;
                                                            } else if (onemore.equals("1")) {
                                                                if (!teamDAO.teams.get(thecourse).get(Integer.parseInt(input)).contains(accountDAO.accounts.get(AM))) {
                                                                    System.out.println("Do you want to send a message to the team? \n");
                                                                    System.out.println("If not, press 0");
                                                                    System.out.println("If yes, press 1 \n");
                                                                    String reply = scanner.nextLine();
                                                                    if (reply.equals("0")) {
                                                                        studentDAO.joinRequest(AM, "", Integer.parseInt(input), thecourse);
                                                                        System.out.println("Request successfully sent! Remember to keep an eye on your inbox :)");
                                                                        break;

                                                                    } else if (reply.equals("1")) {
                                                                        System.out.println("Type your message. When you are finished press 'ENTER'.");
                                                                        String message = scanner.nextLine();
                                                                        studentDAO.joinRequest(AM, message, Integer.parseInt(input), thecourse);
                                                                        System.out.println("Request successfully sent! Remember to keep an eye on your inbox :)");

                                                                        break;
                                                                    } else {
                                                                        System.out.println("Invalid input, we are transferring you to the previous menu");
                                                                        break;
                                                                    }
                                                                } else {
                                                                    System.out.println("You are already a member of this team...");
                                                                    break;
                                                                }


                                                            } else {
                                                                bored = true;
                                                                System.out.println("Invalid input, we are transferring you to the previous menu");
                                                                break;
                                                            }
                                                        } else {
                                                            System.out.println("Do you want to see another team? \n");
                                                            System.out.println("If not, press 0 to go back ");
                                                            System.out.println("If yes, press 1 \n");
                                                            String twomore = scanner.nextLine();
                                                            if (twomore.equals("0")) {
                                                                bored = true;
                                                                break;
                                                            } else if (twomore.equals("1")) {
                                                                System.out.println("Okay :)");
                                                            } else {
                                                                bored = true;
                                                                System.out.println("Invalid input, we are transferring you to the previous menu");
                                                                break;
                                                            }
                                                        }
                                                    }

                                                }else{
                                                    System.out.println("You already have a team in this course");
                                                }
                                            }else{
                                                System.out.println("Wrong input, you are being transferred to the previous menu");
                                                break;
                                            }
                                        }


                                        break;
                                    case "4":
                                        studentDAO.completeEvaluation(AM);
                                        break;

                                    case "5":
                                        if(teamDAO.team_founders.containsKey(AM)) {
                                            int temp = teamDAO.team_founders.get(AM);
                                            if(teamDAO.inbox.size()!=0){
                                                if (teamDAO.inbox.get(temp).size()!=0) {
                                                    ArrayList<String> gathered = new ArrayList<>();
                                                    for(int k = 0; k< teamDAO.inbox.get(temp).size(); k++) {
                                                        gathered.add(requestDAO.getHashMapKey(teamDAO.inbox.get(temp)).get(k));
                                                    }
                                                    for(int h=0;h<gathered.size();h++) {
                                                        if(gathered.get(h)!=null) {
                                                            System.out.println("You have a join request from " + teamDAO.inbox.get(temp).get(gathered.get(h)).getAM() + "!");
                                                            if (!teamDAO.inbox.get(temp).get(gathered.get(h)).getMessage().equals("")) {
                                                                System.out.println(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM() + " has left you a message: " + teamDAO.inbox.get(temp).get(gathered.get(h)).getMessage() + "\n");
                                                                System.out.println("Press 0 to decline");
                                                                System.out.println("Press 1 to see " + teamDAO.inbox.get(temp).get(gathered.get(h)).getAM() + "'s info");
                                                                System.out.println("Press 2 to go back without answering");
                                                                String begin = scanner.nextLine();
                                                                if (begin.equals("0")) {
                                                                    studentDAO.message_to_student.put(temp, "Your request has been declined by the team " + temp);
                                                                    studentDAO.personal_inbox.put(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getAM(), studentDAO.message_to_student);
                                                                    teamDAO.inbox.remove(temp);//-----------------------------------------------------------------------------------------------------------------
                                                                    teamDAO.sender.remove(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM());
                                                                    break;
                                                                } else if (begin.equals("1")) {
                                                                    System.out.println("Student details:");
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getAM());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getName());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getSurname());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getEmail());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getSkills());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getTimeline());

                                                                    System.out.println("Press 0 to decline " + teamDAO.inbox.get(temp).get(gathered.get(h)).getAM() + "'s request.");
                                                                    System.out.println("Press 1 to accept " + teamDAO.inbox.get(temp).get(gathered.get(h)).getAM() + "'s request.");
                                                                    System.out.println("Press 2 to go back without answering.");
                                                                    String etymhgoria = scanner.nextLine();
                                                                    if (etymhgoria.equals("0")) {
                                                                        studentDAO.message_to_student.put(temp, "Your request has been declined by the team " + temp);
                                                                        studentDAO.personal_inbox.put(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getAM(), studentDAO.message_to_student);
                                                                        teamDAO.inbox.remove(temp);//-----------------------------------------------------------------------------------------------------------------
                                                                        break;
                                                                    } else if (etymhgoria.equals("1")) {
                                                                        ArrayList<StudentDAO> newteam = new ArrayList<>();
                                                                        for (int i = 0; i < teamDAO.assembled.get(temp).size(); i++) {
                                                                            newteam.add(teamDAO.assembled.get(temp).get(i));
                                                                        }
                                                                        newteam.add(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()));
                                                                        teamDAO.assembled.replace(temp, newteam);
                                                                        teamDAO.teams.put(teamDAO.inbox.get(temp).get(gathered.get(h)).getTheCourse(), teamDAO.assembled);

                                                                        studentDAO.message_to_student.put(temp, "You have been accepted by the team " + temp);

                                                                        studentDAO.personal_inbox.put(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getAM(), studentDAO.message_to_student);
                                                                        teamDAO.sender.remove(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM());
                                                                        teamDAO.inbox.remove(temp);//----------------------------------------------------------------------------------------------------------------------------
                                                                        System.out.println("The student has been added to your team successfully!");
                                                                        break;


                                                                    } else if (etymhgoria.equals("2")) {
                                                                        break;
                                                                    } else {
                                                                        System.out.println("Wrong input, you are being transferred to the previous menu");
                                                                    }
                                                                } else if (begin.equals("2")) {
                                                                    break;
                                                                }
                                                            } else {
                                                                System.out.println(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM() + " did not leave you any messages. \n");
                                                                System.out.println("Press 0 to decline");
                                                                System.out.println("Press 1 to see " + teamDAO.inbox.get(temp).get(gathered.get(h)).getAM() + "'s info");
                                                                System.out.println("Press 2 to go back without answering");
                                                                String begin = scanner.nextLine();
                                                                if (begin.equals("0")) {
                                                                    studentDAO.message_to_student.put(temp, "Your request has been declined by the team " + temp);
                                                                    studentDAO.personal_inbox.put(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getAM(), studentDAO.message_to_student);
                                                                    teamDAO.sender.remove(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM());
                                                                    teamDAO.inbox.remove(temp);//-----------------------------------------------------------------------------------------------------------------
                                                                    break;

                                                                } else if (begin.equals("1")) {
                                                                    System.out.println("Student details:");
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getAM());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getName());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getSurname());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getEmail());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getSkills());
                                                                    System.out.println(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getTimeline());
                                                                    if (evaluate.evaluations.size() != 0) {
                                                                        System.out.println("Average Evaluation Score " + evaluate.evaluations.get(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getAM()) + " \n");
                                                                    }

                                                                    System.out.println("Press 0 to decline " + teamDAO.inbox.get(temp).get(gathered.get(h)).getAM() + "'s request.");
                                                                    System.out.println("Press 1 to accept " + teamDAO.inbox.get(temp).get(gathered.get(h)).getAM() + "'s request.");
                                                                    System.out.println("Press 2 to go back without answering.");
                                                                    String etymhgoria = scanner.nextLine();
                                                                    if (etymhgoria.equals("0")) {
                                                                        studentDAO.message_to_student.put(temp, "Your request has been declined by the team " + temp);
                                                                        studentDAO.personal_inbox.put(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getAM(), studentDAO.message_to_student);
                                                                        teamDAO.sender.remove(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM());
                                                                        teamDAO.inbox.remove(temp);//-----------------------------------------------------------------------------------------------------------------
                                                                        break;
                                                                    } else if (etymhgoria.equals("1")) {
                                                                        ArrayList<StudentDAO> newteam = new ArrayList<>();
                                                                        for (int i = 0; i < teamDAO.assembled.get(temp).size(); i++) {
                                                                            newteam.add(teamDAO.assembled.get(temp).get(i));
                                                                        }
                                                                        newteam.add(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()));
                                                                        teamDAO.assembled.replace(temp, newteam);
                                                                        teamDAO.teams.put(teamDAO.inbox.get(temp).get(gathered.get(h)).getTheCourse(), teamDAO.assembled);

                                                                        studentDAO.message_to_student.put(temp, "You have been accepted by the team " + temp);

                                                                        studentDAO.personal_inbox.put(accountDAO.accounts.get(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM()).getAM(), studentDAO.message_to_student);
                                                                        teamDAO.sender.remove(teamDAO.inbox.get(temp).get(gathered.get(h)).getAM());
                                                                        teamDAO.inbox.remove(temp);//----------------------------------------------------------------------------------------------------------------------------
                                                                        System.out.println("The student has been added to your team successfully!");
                                                                        break;
                                                                    } else if (etymhgoria.equals("2")) {
                                                                        break;
                                                                    } else {
                                                                        System.out.println("Wrong input, you are being transferred to the previous menu");
                                                                    }
                                                                }
                                                            }

                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.println("You have no new messages.");
                                            }

                                        }else{
                                            System.out.println("Sorry, you are not a founder of any team.");
                                            break;
                                        }
                                        break;

                                    case "6":
                                        humungus = true;
                                        break;

                                    default:
                                        System.out.println("ERROR: Invalid Selection");
                                }
                            }

                            break;
                        default:
                            System.out.println("ERROR: Invalid Selection");

                    }
                    break;
                case "2":
                    studentDAO.createAccount();
                    break;

                default:
                    System.out.println("ERROR: Invalid Selection");

            }
            System.out.println("Do you have further actions?");
            System.out.println("If yes press 1");
            System.out.println("If no press 0");
            String finalanswer = scanner.nextLine();
            if(finalanswer.equals("1")){
                System.out.println("Okay :)");
            }else if(finalanswer.equals("0")){
                totalexit = true;
            }else{
                System.out.println("Wrong input");
                break;
            }
        }
    }
    public static void load(){
        AccountDAO accountDAO = new AccountDAO();
        HashMap<String, ArrayList<String>> days = new HashMap<>();
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> mondayhours = new ArrayList<>();
        ArrayList<String> tuesdayhours = new ArrayList<>();
        ArrayList<String> wednesdayhours = new ArrayList<>();
        ArrayList<String> thursdayhours = new ArrayList<>();
        ArrayList<String> fridayhours = new ArrayList<>();
        ArrayList<String> saturdayhours = new ArrayList<>();
        ArrayList<String> sundayhours = new ArrayList<>();

        skills.add("watchF1");
        skills.add("suckateverything");
        skills.add("fml");

        mondayhours.add("5:00");
        tuesdayhours.add("6:00");
        wednesdayhours.add("7:00");
        thursdayhours.add("8:00");
        fridayhours.add("9:00");
        saturdayhours.add("10:00");
        sundayhours.add("11:00");

        days.put("Monday", mondayhours);
        days.put("Tuesday", tuesdayhours);
        days.put("Wednesday", wednesdayhours);
        days.put("Thursday", thursdayhours);
        days.put("Friday", fridayhours);
        days.put("Saturday", saturdayhours);

        days.put("Sunday", sundayhours);

        //Student st1 = new Student("Platonas", "Karageorgis", "p3180068", "karageorgisplatonas@gmail.com", "platonaras", skills, days);
        //Student st2 = new Student("Denis", "Diamantis", "p3152363", "denisdiam@hotmail.com","denisaras",skills,days);
        //Student st3 = new Student("Kleiw", "Patatsh", "p3180266", "nikolpatatsi@gmail.com", "klei-w", skills, days);

        AccountDAO acc = new AccountDAO("Platonas", "Karageorgis", "p3180068", "karageorgisplatonas@gmail.com", "platonaras", skills, days);
        AccountDAO acc2 = new AccountDAO("Denis", "Diamantis", "p3152363", "denisdiam@hotmail.com","denisaras",skills,days);
        AccountDAO acc3 = new AccountDAO("Kleiw", "Patatsh", "p3180266", "nikolpatatsi@gmail.com", "klei-w", skills, days);

        CourseDAO katanemhmena = new CourseDAO("Katanemhmena",4);
        CourseDAO tech_log = new CourseDAO("Tech",3);
        CourseDAO databases = new CourseDAO("Databases",2);
        ArrayList<StudentDAO> members = new ArrayList<>();
        members.add(accountDAO.accounts.get("p3180068"));
        members.add(accountDAO.accounts.get("p3152363"));
        members.add(accountDAO.accounts.get("p3180266"));
        TeamDAO teamDAO1 = new TeamDAO("Tech",1112,members,"p3180068", "No requirements only party");
    }


}

