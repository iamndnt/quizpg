package com.myapp.quizphatgiao;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CenterProcessQuestion {

    private static final String TOKEN = "~";
    private static CenterProcessQuestion center;

    static ArrayList<Question> setupQuestion(Context context) {
        ArrayList listQuestion = new ArrayList();
        ArrayList<String> Sans = GetAns(context);
        ArrayList<String> Squestion = GetQuestion(context);
        ArrayList<String> Squestion2 = combine(Squestion,Sans);
        for(int i=0;i<Squestion2.size();i++) {
            listQuestion.add(initializeQuestion(Squestion2.get(i)));
        }
        return listQuestion;
    }

    private static Question initializeQuestion(String str) {
        Question ques = new Question();
        String[] arr = str.split("~");
        ques.question = arr[0];
        ques.option1 = arr[1];
        ques.option2 = arr[2];
        ques.option3 = arr[3];
        ques.option4 = arr[4];
        ques.ans = arr[5];
        return ques;
    }

    private static ArrayList<String> combine(ArrayList<String> squestion, ArrayList<String> sans) {
        ArrayList<String> ques = new ArrayList<>();
        for(int i=0;i<squestion.size();i++) {
            ques.add(squestion.get(i) + sans.get(i));
        }
        return ques;
    }

    private static ArrayList<String> GetQuestion(Context context) {
        AssetManager am = context.getAssets();
        InputStream input;
        try {
            String[] files = am.list("");
            for (String file : files) {
                if (file.equals("ques")) {
                    input = am.open(file);
                    String[] textline = read_text(input);
                    ArrayList<String> question = CheckQues(textline);
                    return question;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<String> CheckQues(String[] textline) {
        String question = "";
        ArrayList<String> m = new ArrayList<String>();
        for(int i=0;i<textline.length ; i++){
            int last = textline[i].length() -1 ;

            if(textline[i].equals("")||textline[i].equals("end")){
                //  question = question;//  + ans.get(i);
                m.add(question);
                question = "";
            }
            else if(textline[i].charAt(last) == '?'|| textline[i].charAt(last) == '.'){
                question = question + textline[i] + TOKEN;
            }else{
            }
        }
        return m;
    }

    private static ArrayList<String> GetAns(Context context) {
        AssetManager am = context.getAssets();
        InputStream input;
        try {
            String[] files = am.list("");
            for (String file : files) {
                if (file.equals("answer")) {
                    input = am.open(file);
                    String[] textline = read_text(input);
                    ArrayList<String> ans = CheckAns(textline);
                    return ans;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<String> CheckAns(String[] textline) {
        ArrayList<String> m = new ArrayList<String>();
        for(int i=0;i<textline.length ; i++){
            m.add(textline[i]);
        }
        return m;
    }

    private static String[] read_text(InputStream input) throws IOException{
        int size = input.available();
        byte[] buffer = new byte[size];
        input.read(buffer);
        input.close();
        String text = new String(buffer);
        return text.split("\\r?\\n");
    }
}
