package com.array;

import java.util.*;

class Unbox {
    public static class Image {
        private String filename;
        private int width;
        private int height;
        public Image(String filename, int width, int height) {
            this.filename = filename;
            this.width = width;
            this.height = height;
        }
        public boolean equals(Object other) {
            Image o = (Image)other;
            if (filename == null || o.filename == null)
                return false;
            String[] components = filename.split("\\.");
            String[] ocomponents = o.filename.split("\\.");
            return components[0].equals(ocomponents[0]) && 
                width * height == o.width * o.height;
        }
        public String toString() {
            return "Image: filename=" + filename + " Size=" + width*height;
        }
    }

    public static void printImages(Set<Image> images) {
        for(Image image: images) {
            System.out.println(image);
        }
    }

    public static void main(String[] args) {
        Image[] images = {new Image("flag.jpg", 40, 60),
                          new Image("flag.gif", 30, 50),
                          new Image("smile.gif", 100, 200),
                          new Image("smile.gif", 50, 400),
                          new Image("other.jpg", 20, 60),
                          new Image("lenna.jpg", 542, 512),
                          new Image("Lenna.jpg", 512, 512)};
        Set<Image> set = new HashSet<Image>(Arrays.asList(images));
        Unbox.printImages(set);
    }
}