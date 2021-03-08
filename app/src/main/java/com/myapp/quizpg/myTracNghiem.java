package com.myapp.quizpg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class myTracNghiem extends HinhHoc{

    //private static Question currentQues;
    myRect[] rect = new myRect[5];
    Question myQues;
    private GameEngine ge;
    private Question currentQues;

    myTracNghiem(myRect[] tn, GameEngine ge){
        rect[0]=tn[0];

        rect[1]=tn[1];
        rect[2]=tn[2];
        rect[3]=tn[3];
        rect[4]=tn[4];

        this.ge = ge;

    }

    public void drawTracNghiem(Canvas canvas, Paint paint) {
        setQuesText(ge.currentQuestion);
        for(int i=0;i<this.rect.length;i++){
            /* draw background bitmap */
            if(this.rect[i].getBGBitmap() != null){
                canvas.drawBitmap(this.rect[i].Rectbitmap,null,this.rect[i].rect,null);
            }else{
                paint.setColor(this.rect[i].getColorRect());
                canvas.drawRect(this.rect[i].rect, paint);
            }

            /* draw text bitmap */
            if(this.rect[i].getWriteText() != null ) {
                paint.setColor(this.rect[i].getColorTextRect());
                paint.setTextSize(this.rect[i].getTextSize());
                int len_x = (int) paint.measureText(this.rect[i].text);
                Rect bounds = new Rect();
                paint.getTextBounds(this.rect[i].text, 0, this.rect[i].text.length(), bounds);
                int len_y = bounds.height();
                int x = setPosX(this.rect[i].rect.left, this.rect[i].rect.width(), len_x);
                int y = setPosY(this.rect[i].rect.top, this.rect[i].rect.height(), len_y);
                canvas.drawText(this.rect[i].text, x, y, paint);
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



    private void setQuesText(Question question){
        rect[0].setText(question.question);
        rect[1].setText(question.option1);
        rect[2].setText(question.option2);
        rect[3].setText(question.option3);
        rect[4].setText(question.option4);
    }



    public Question getQuestion() {
        return currentQues;
    }
}
