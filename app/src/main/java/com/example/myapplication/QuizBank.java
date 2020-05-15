package com.example.myapplication;

public class QuizBank {
    private String textQuestions [] = {
            "Medan Merupakan Ibukota dari Provinsi ?",
            "Pulau paling luas di Indonesia adalah ",
            "Suku paling banyak di Indonesia adalah ",
            "Candi Borobudur terletak di Provinsi ?",
            "Lagu Ampar Ampar Pisang berasal dari ?"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"Kalimantan Timur", "Sulawesi Selatan", "Sumatera Utara", "Sumatera Selatan"},
            {"Pulau Papua", "Pulau Kalimantan", "Pulau Sumatera", "Pulai Sulawesi"},
            {"Suku Batak", "Suku Jawa", "Suku Melayu", "Suku Bugis"},
            {"DKI Jakarta", "DI Yogyakarta", "Jawa Barat", "Jawa Tengah"},
            {"Kalimantan Selatan", "Sulawesi Selatan", "Sumatera Selatan", "Jawa Timur"}
    };

    private String mCorrectAnswers[] = {"Sumatera Utara", "Pulau Papua", "Suku Jawa", "Jawa Tengah", "Kalimantan Selatan"};

    public int getLength(){
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
