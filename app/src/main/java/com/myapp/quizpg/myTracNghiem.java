package com.myapp.quizpg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class myTracNghiem extends HinhHoc{

    myRect[] rect = new myRect[5];
    Question myQues = new Question();
    private GameEngine ge;

    myTracNghiem(myRect[] tn, Question question, GameEngine ge){
        rect[0]=tn[0];
        rect[1]=tn[1];
        rect[2]=tn[2];
        rect[3]=tn[3];
        rect[4]=tn[4];
        myQues = question;
        this.ge = ge;

    }

    public static void drawTracNghiem(Canvas canvas, myTracNghiem tracNghiem, Paint paint) {
        for(int i=0;i<tracNghiem.rect.length;i++){
            /* draw background bitmap */
            if(tracNghiem.rect[i].getBGBitmap() != null){
                canvas.drawBitmap(tracNghiem.rect[i].Rectbitmap,null,tracNghiem.rect[i].rect,null);
            }else{
                paint.setColor(tracNghiem.rect[i].getColorRect());
                canvas.drawRect(tracNghiem.rect[i].rect, paint);
            }

            /* draw text bitmap */
            if(tracNghiem.rect[i].getWriteText() != null ) {
                paint.setColor(tracNghiem.rect[i].getColorTextRect());
                paint.setTextSize(tracNghiem.rect[i].getTextSize());
                int len_x = (int) paint.measureText(tracNghiem.rect[i].text);
                Rect bounds = new Rect();
                paint.getTextBounds(tracNghiem.rect[i].text, 0, tracNghiem.rect[i].text.length(), bounds);
                int len_y = bounds.height();
                int x = setPosX(tracNghiem.rect[i].rect.left, tracNghiem.rect[i].rect.width(), len_x);
                int y = setPosY(tracNghiem.rect[i].rect.top, tracNghiem.rect[i].rect.height(), len_y);
                canvas.drawText(tracNghiem.rect[i].text, x, y, paint);
            }
        }
    }

    private static int setPosY(int top, int h, int len) {
        int t = h - len;
        return top + (t/2)+len;
    }

    private static int setPosX(int left, int w,int len) {
        int t = w - len;
        return left+(t/2);
    }

    public void checkQues(int index) {
        if(ge.questions.get(index) != null){

            rect[0].setText(ge.questions.get(index).question);
            rect[1].setText(ge.questions.get(index).option1);
            rect[2].setText(ge.questions.get(index).option2);
            rect[3].setText(ge.questions.get(index).option3);
            rect[4].setText(ge.questions.get(index).option4);

           // setQues();

        }
    }

    private void setQues() {
        rect[0].setText(myQues.question);
        rect[1].setText(myQues.option1);
        rect[2].setText(myQues.option2);
        rect[3].setText(myQues.option3);
        rect[4].setText(myQues.option4);
    }
}
