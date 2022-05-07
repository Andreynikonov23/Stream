package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File path = new File("C://Users/xxxkeep/IdeaProjects/human/src/main/resources/file.txt");
        ArrayList<Human> humans = new ArrayList<>();
        Scanner scanner = new Scanner(path);
        while (scanner.hasNextLine()){
            Human human = new Human();
            human.load(scanner);
            humans.add(human);
        }
        Human newHuman = new Human("Роман");
        humans.add(newHuman);
        FileWriter writer = new FileWriter(path);
        for (int i = 0; i < humans.size(); i++) {
            humans.get(i).save(writer);
        }
        writer.close();
    }
}