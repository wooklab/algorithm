package com.wooklab.algorithm.codingtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// unsolved..
public class KBSolution4 {

    public static void main(String[] args) {
        KBSolution4 m = new KBSolution4();

        String[] result = m.solution(new String[]{"/",
                                                  "/hello",
                                                  "/hello/tmp",
                                                  "/root",
                                                  "/root/abcd",
                                                  "/root/abcd/etc",
                                                  "/root/abcd/hello"},
                                     new String[]{
                                         "mkdir /root/tmp",
                                         "cp /hello /root/tmp",
                                         "rm /hello"
                                     });
    }
    /*
"/",
"/root",
"/root/abcd",
"/root/abcd/etc",
"/root/abcd/hello",
"/root/tmp",
"/root/tmp/hello",
"/root/tmp/hello/tmp"
     */

    private String[] solution(String[] directory, String[] command) {
        Directory dir = new Directory(directory[0]);
        for (int i = 1; i < directory.length; i++) {
            Queue<String> q = new LinkedList<>();
            q.addAll(Arrays.asList(directory[i].substring(1).split("/")));
            dir.addDir(q);
        }
        System.out.println(dir);
        return new String[0];
    }

    static class Directory {

        private String folder;
        private Map<String, Directory> child;

        public Directory(String folder) {
            this.folder = folder;
            this.child = new TreeMap<>();
        }

        public void addDir(Queue<String> q) {
            if (q.isEmpty()) {
                return;
            }
            String currentChildFolder = q.poll();
            child.put(currentChildFolder, child.getOrDefault(currentChildFolder, new Directory(currentChildFolder)));
            Directory childDir = child.get(currentChildFolder);
            childDir.addDir(q);
        }

        public String getFolder() {
            return folder;
        }

        public Map<String, Directory> getChild() {
            return child;
        }

        public String display() {
            String dirPath = folder;
            for (Directory d : child.values()) {
                d.display();
            }
            return dirPath;
        }

        @Override
        public String toString() {
            return "Directory{" +
                "folder='" + folder + '\'' +
                ", child=" + child +
                '}';
        }
    }
}
